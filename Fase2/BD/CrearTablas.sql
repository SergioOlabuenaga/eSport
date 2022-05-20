-- Creación de tabla Login

DROP TABLE LOGIN CASCADE CONSTRAINTS;

CREATE TABLE LOGIN (
  ID_LOGIN NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  USUARIO VARCHAR2(30) UNIQUE NOT NULL,
  PASS VARCHAR2(16) UNIQUE NOT NULL,
  TIPO CHAR NOT NULL,
  CONSTRAINT LOG_ID_PK PRIMARY KEY(ID_LOGIN),
  CONSTRAINT LOG_TIPO_CK CHECK (UPPER(TIPO) IN('A','U')));

-- Creación de la tabla Dueño

DROP TABLE DUENO CASCADE CONSTRAINTS;

CREATE TABLE DUENO (
  ID_DUENO NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 100),
  NOMBRE VARCHAR2(20) NOT NULL,
  TELEFONO VARCHAR2(9) UNIQUE NOT NULL,
  NOMBRE_EMPRESA VARCHAR2(50) NOT NULL,
  CONSTRAINT DUE_ID_PK PRIMARY KEY (ID_DUENO));

-- Creación de la tabla Asistente

DROP TABLE ASISTENTE CASCADE CONSTRAINTS;

CREATE TABLE ASISTENTE (
  ID_ASISTENTE NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 100),
  NOMBRE VARCHAR2(20) NOT NULL,
  TELEFONO VARCHAR2(9) UNIQUE NOT NULL,
  DESCRIPCION_FUNCION VARCHAR2(500) NOT NULL,
  CONSTRAINT ASI_ID_PK PRIMARY KEY (ID_ASISTENTE));

-- Creación de la tabla Entrenador

DROP TABLE ENTRENADOR CASCADE CONSTRAINTS;

CREATE TABLE ENTRENADOR (
  ID_ENTRENADOR NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 100),
  NOMBRE VARCHAR2(20) NOT NULL,
  TELEFONO VARCHAR2(9) UNIQUE NOT NULL,
  ANOS_EXP NUMBER(2) DEFAULT '0',
  CONSTRAINT ENT_ID_PK PRIMARY KEY (ID_ENTRENADOR));

-- Creación de la tabla Equipo

DROP TABLE EQUIPO CASCADE CONSTRAINTS;

CREATE TABLE EQUIPO (
  ID_EQUIPO NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  NOMBRE VARCHAR2(20) UNIQUE NOT NULL,
  ANO_CREACION NUMBER(4) NOT NULL,
  NACIONALIDAD VARCHAR2(20) NOT NULL,
  ID_DUENO NUMBER(3) NOT NULL,
  ID_ENTRENADOR NUMBER(3) NOT NULL,
  ID_ASISTENTE NUMBER(3),
  CONSTRAINT EQU_ID_PK PRIMARY KEY(ID_EQUIPO),
  CONSTRAINT EQU_DUE_FK FOREIGN KEY (ID_DUENO) REFERENCES DUENO (ID_DUENO) ON DELETE CASCADE,
  CONSTRAINT EQU_ENT_FK FOREIGN KEY (ID_ENTRENADOR) REFERENCES ENTRENADOR (ID_ENTRENADOR) ON DELETE CASCADE,
  CONSTRAINT EQU_ASI_FK FOREIGN KEY (ID_ASISTENTE) REFERENCES ASISTENTE (ID_ASISTENTE) ON DELETE SET NULL);

-- Creación de la tabla Jugador

DROP TABLE JUGADOR CASCADE CONSTRAINTS;

CREATE TABLE JUGADOR (
  ID_JUGADOR NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  ID_EQUIPO NUMBER(3),
  NOMBRE VARCHAR2(20) NOT NULL,
  NICKNAME VARCHAR2(20) UNIQUE NOT NULL,
  SUELDO NUMBER(7) NOT NULL,
  TELEFONO VARCHAR2(9) NOT NULL,
  ROL VARCHAR2(20) NOT NULL,
  CONSTRAINT JUG_ID_PK PRIMARY KEY (ID_JUGADOR),
  CONSTRAINT JUG_EQU_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO (ID_EQUIPO) ON DELETE CASCADE,
  CONSTRAINT JUG_SUE_CK CHECK (SUELDO > 1166.7));

-- Creación de la tabla Clasificación

DROP TABLE CLASIFICACION CASCADE CONSTRAINTS;

CREATE TABLE CLASIFICACION (
  ID_CLASIFICACION NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  ID_EQUIPO NUMBER(3),
  PUNTOS NUMBER(3) DEFAULT '0',
  TEMPORADA NUMBER(2),
  CONSTRAINT CLA_ID_PK PRIMARY KEY (ID_CLASIFICACION),
  CONSTRAINT CLA_EQU_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPO (ID_EQUIPO) ON DELETE CASCADE);

-- Creación de la tabla Jornada

DROP TABLE JORNADA CASCADE CONSTRAINTS;

CREATE TABLE JORNADA (
  ID_JORNADA NUMBER(2) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  FECHA DATE NOT NULL,
  CONSTRAINT JOR_ID_PK PRIMARY KEY (ID_JORNADA));

-- Creación de la tabla Partido

DROP TABLE PARTIDO CASCADE CONSTRAINTS;

CREATE TABLE PARTIDO (
  ID_PARTIDO NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  HORA DATE NOT NULL,
  ID_LOCAL NUMBER(4) NOT NULL,
  ID_VISITANTE NUMBER(4) NOT NULL,
  PUNTOS_LOCAL NUMBER(1) DEFAULT '0',
  PUNTOS_VISITANTE NUMBER(1) DEFAULT '0',
  ID_JORNADA NUMBER(4) NOT NULL,
  CONSTRAINT PAR_ID_PK PRIMARY KEY (ID_PARTIDO, ID_LOCAL, ID_VISITANTE),
  CONSTRAINT PAR_JOR_FK FOREIGN KEY (ID_JORNADA) REFERENCES JORNADA (ID_JORNADA) ON DELETE CASCADE,
  CONSTRAINT PAR_LOC_FK FOREIGN KEY (ID_LOCAL) REFERENCES EQUIPO (ID_EQUIPO) ON DELETE CASCADE,
  CONSTRAINT PAR_VIS_FK FOREIGN KEY (ID_VISITANTE) REFERENCES EQUIPO (ID_EQUIPO) ON DELETE CASCADE);

-- Creación de la tabla XMLS

DROP TABLE XMLS CASCADE CONSTRAINTS;

CREATE TABLE XMLS (
  ID_XMLS NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  Resultado_XML CLOB);

COMMIT;