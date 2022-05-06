-- Insertamos dueños
INSERT INTO dueno (nombre, telefono, nombre_empresa)
VALUES ('TheGrefg',784512457,'Heretics');

INSERT INTO dueno (nombre, telefono, nombre_empresa)
VALUES ('Willyrex',895641245,'Golden');

INSERT INTO dueno (nombre, telefono, nombre_empresa)
VALUES ('Amador',632547895,'LQSA');

INSERT INTO dueno (nombre, telefono, nombre_empresa)
VALUES ('Ibai',652134578,'KOI');


-- Insertamos entrenadores
INSERT INTO entrenador (nombre,telefono,anos_exp)
VALUES ('Koeman',578445123, 3);

INSERT INTO entrenador (nombre,telefono,anos_exp)
VALUES ('Pep Guardiola',985631457, 6);

INSERT INTO entrenador (nombre,telefono,anos_exp)
VALUES ('Luis Enrique',316425794, 5);

INSERT INTO entrenador (nombre,telefono,anos_exp)
VALUES ('Xavi',745812457, 1);

-- Insertamos asistentes
INSERT INTO asistente (nombre, telefono, descripcion_funcion)
VALUES ('Tito', 878457845,'Psicologo de equipo');

INSERT INTO asistente (nombre, telefono, descripcion_funcion)
VALUES ('Juan', 745845123,'Masajista');

INSERT INTO asistente (nombre, telefono, descripcion_funcion)
VALUES ('Beñat', 985632147,'Oculista');

INSERT INTO asistente (nombre, telefono, descripcion_funcion)
VALUES ('Eneko', 451233549,'Analista');

-- Insertamos equipos
INSERT INTO EQUIPO (Nombre, Ano_creacion, Nacionalidad, id_dueno, id_entrenador, id_asistente) 
VALUES ('Equipo1',2003,'Argentina',1,2,3);

INSERT INTO EQUIPO (Nombre, Ano_creacion, Nacionalidad, id_dueno, id_entrenador, id_asistente) 
VALUES ('Equipo2',2004,'Inglaterra',2,3,1);

INSERT INTO EQUIPO (Nombre, Ano_creacion, Nacionalidad, id_dueno, id_entrenador, id_asistente) 
VALUES ('Equipo3',2005,'Armenia',3,1,2);

INSERT INTO EQUIPO (Nombre, Ano_creacion, Nacionalidad, id_dueno, id_entrenador, id_asistente) 
VALUES ('Equipo4',2006,'Chile',4,4,4);

-- Insertamos jugadores
INSERT INTO jugador (id_equipo, nombre, nickname, sueldo, telefono, rol)
VALUES (1,'Pedro','Pedrito69',1200,625220893,'POR');

INSERT INTO jugador (id_equipo, nombre, nickname, sueldo, telefono, rol)
VALUES (1,'Andres','Andresito69',1500,625584215,'LTI');

INSERT INTO jugador (id_equipo, nombre, nickname, sueldo, telefono, rol)
VALUES (2,'Damian','Damiansito69',2300,625578594,'DEF');

INSERT INTO jugador (id_equipo, nombre, nickname, sueldo, telefono, rol)
VALUES (2,'Paco','Paquito69',1300,669800594,'LTD');

INSERT INTO jugador (id_equipo, nombre, nickname, sueldo, telefono, rol)
VALUES (3,'Juan','Juanito69',1600,624517968,'SDI');

INSERT INTO jugador (id_equipo, nombre, nickname, sueldo, telefono, rol)
VALUES (3,'Ander','Andersito69',1700,625200321,'MCD');

INSERT INTO jugador (id_equipo, nombre, nickname, sueldo, telefono, rol)
VALUES (4,'Oier','Oiersito69',1900,625200594,'DC');

INSERT INTO jugador (id_equipo, nombre, nickname, sueldo, telefono, rol)
VALUES (4,'Yeray','Yeraysito69',2500,625200594,'MCO');