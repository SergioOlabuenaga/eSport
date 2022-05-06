-- Procedimiento anonimo Partidos_Ganados
set serveroutput on;
DECLARE
ganados NUMBER(3) := 0;
BEGIN
Partidos_Ganados('Equipo1', ganados);
dbms_output.put_line('Partidos ganados: ' || ganados);
END;


-- Procedimiento anonimo Info_Jugador
set serveroutput on;
DECLARE
rol VARCHAR(20);
nickname VARCHAR(20);
equipo VARCHAR(20);
BEGIN
Info_Jugador('Damian', rol, nickname, equipo);
dbms_output.put_line('Información del jugador: ' || CHR(13) || 'Nickname: ' || 
nickname || CHR(13) || 'Rol: ' || rol || CHR(13) || 'Equipo: ' || equipo);
END;
