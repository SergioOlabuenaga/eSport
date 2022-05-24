-- Trigger para controlar que en un equipo no haya más de 6 jugadores

CREATE OR REPLACE PACKAGE Maximo_Jugadores_cache
IS
    equipo_id equipo.ID_Equipo%type;
end Maximo_Jugadores_cache;

CREATE OR REPLACE TRIGGER Maximo_Jugadores
BEFORE INSERT OR UPDATE ON JUGADOR FOR EACH ROW
BEGIN
    Maximo_Jugadores_cache.equipo_id := :new.ID_EQUIPO;
END;

CREATE OR REPLACE TRIGGER Maximo_Jugadores_statement
BEFORE INSERT OR UPDATE ON JUGADOR
DECLARE
    V_COUNT NUMBER(1);
BEGIN
    SELECT COUNT(*) INTO V_COUNT FROM JUGADOR
    WHERE ID_EQUIPO = Maximo_Jugadores_cache.equipo_id;
    IF (V_COUNT > 5) THEN
        RAISE_APPLICATION_ERROR (-20001, 'Error: Este equipo ya tiene 6
            jugadores');
    END IF;
END;


-- Trigger para controlar que no se generen las jornadas

CREATE OR REPLACE TRIGGER Minimo_Jugadores
    BEFORE INSERT ON Jornada FOR EACH ROW
DECLARE
    CURSOR CUR_EQUIPO IS
    SELECT ID_EQUIPO
    FROM EQUIPO;
    ID_COMPARADO EQUIPO.ID_EQUIPO%TYPE;
    COUNT_JUGADORES NUMBER(1);
BEGIN
    OPEN CUR_EQUIPO;
    LOOP
        FETCH CUR_EQUIPO INTO ID_COMPARADO;
        SELECT COUNT(*) INTO COUNT_JUGADORES FROM JUGADOR 
        WHERE ID_EQUIPO = ID_COMPARADO;
        
        IF (COUNT_JUGADORES < 2) THEN
            RAISE_APPLICATION_ERROR (-20002, 'Error: Un equipo (ID: ' || 
            ID_COMPARADO ||') no tiene los jugadores mínimos');
        END IF;
        EXIT WHEN CUR_EQUIPO%NOTFOUND;
    END LOOP;
    CLOSE CUR_EQUIPO;
END;

-- Trigger para controlar que no se editen los equipos cuando las jornadas están generadas

CREATE OR REPLACE TRIGGER Calendario_Completo_Equipo
BEFORE INSERT OR UPDATE OR DELETE ON EQUIPO
DECLARE
    CalenCount number;
BEGIN
    SELECT COUNT(*) INTO CalenCount
    FROM JORNADA;
    
    IF (CalenCount > 0) then
        RAISE_APPLICATION_ERROR (-20003, 'Error: El calendario está completo' || 
        ' y no se pueden editar los equipos');
    END IF;
END;


-- Trigger para controlar que no se editen los jugadores cuando las jornadas están generadas

CREATE OR REPLACE TRIGGER Calendario_Completo_Jugador
BEFORE INSERT OR UPDATE OR DELETE ON JUGADOR
DECLARE
    CalenCount number;
BEGIN
    SELECT COUNT(*) INTO CalenCount
    FROM JORNADA;
    
    IF (CalenCount > 0) then
        RAISE_APPLICATION_ERROR (-20004, 'Error: El calendario está completo' || 
        ' y no se pueden editar los jugadores');
    END IF;
END;

-- Trigger para añadir a un equipo a la tabla Clasificacion, con 0 puntos y en la última temporada

CREATE OR REPLACE PACKAGE Clasificar_Equipo_Cache
IS
    ID_equipo equipo.ID_Equipo%type;
    Temporada Clasificacion.Temporada%type;
end Clasificar_Equipo_Cache;

CREATE OR REPLACE TRIGGER Clasificar_Equipo
AFTER INSERT ON EQUIPO FOR EACH ROW
BEGIN
    Clasificar_Equipo_Cache.ID_Equipo := :new.ID_EQUIPO;    
    SELECT MAX(TEMPORADA) INTO Clasificar_Equipo_Cache.Temporada
    FROM CLASIFICACION;
END;

CREATE OR REPLACE TRIGGER Clasificar_Equipo_Statement
AFTER INSERT ON EQUIPO
BEGIN
    INSERT INTO CLASIFICACION (ID_EQUIPO, PUNTOS, TEMPORADA) VALUES 
    (Clasificar_Equipo_Cache.ID_Equipo, 0, Clasificar_Equipo_Cache.Temporada);
END;

-- Trigger para controlar que el salario no sea inferior al salario mínimo.

CREATE OR REPLACE TRIGGER Salario_Equipo
FOR UPDATE OR INSERT ON JUGADOR COMPOUND TRIGGER

v_ID NUMBER;
v_SALARIO NUMBER;
v_TOTAL NUMBER(10);

AFTER EACH ROW IS
BEGIN
    v_ID := :new.ID_Equipo;
    v_SALARIO := :new.Sueldo;
END AFTER EACH ROW;

AFTER STATEMENT IS
BEGIN
    SELECT SUM(SUELDO) INTO v_TOTAL FROM JUGADOR
    WHERE ID_EQUIPO = v_ID;
    v_TOTAL := v_TOTAL + v_SALARIO;
    IF (v_TOTAL + v_SALARIO > '200000') THEN
        RAISE_APPLICATION_ERROR (-20005, 'Error: No puede haber un sueldo
            total de más de 200.000 euros por equipo');
    END IF;
END AFTER STATEMENT;
END Salario_Equipo;

COMMIT;

-- Trigger para sumar los puntos a la clasificación después de actualizar cada partido

CREATE OR REPLACE PACKAGE Sumar_Puntos_Cache
IS
    ID_Local Partido.ID_Local%type;
    ID_Visitante Partido.ID_Visitante%type;
    Puntos_Local Clasificacion.Puntos%type;
    Puntos_Visitante Clasificacion.Puntos%type;
end Sumar_Puntos_Cache;

CREATE OR REPLACE TRIGGER Sumar_Puntos
AFTER UPDATE ON PARTIDO FOR EACH ROW
BEGIN
    Sumar_Puntos_Cache.ID_Local := :new.ID_Local;
    Sumar_Puntos_Cache.ID_Visitante := :new.ID_Visitante;
    Sumar_Puntos_Cache.Puntos_Local := :new.Puntos_Local;
    Sumar_Puntos_Cache.Puntos_Visitante := :new.Puntos_Visitante;
END;

CREATE OR REPLACE TRIGGER Sumar_Puntos_Statement
AFTER UPDATE ON PARTIDO
BEGIN
    UPDATE CLASIFICACION
    SET PUNTOS = PUNTOS + Sumar_Puntos_Cache.Puntos_Local
    WHERE ID_EQUIPO = Sumar_Puntos_Cache.ID_Local;
    
    UPDATE CLASIFICACION
    SET PUNTOS = PUNTOS + Sumar_Puntos_Cache.Puntos_Visitante
    WHERE ID_EQUIPO = Sumar_Puntos_Cache.ID_Visitante;
    
    COMMIT;
END;