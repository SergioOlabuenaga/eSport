-- Estructura de tabla para la tabla Login

DROP TABLE Login CASCADE CONSTRAINTS;

CREATE TABLE Login (
  ID_Login NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  Usuario VARCHAR2(8) NOT NULL,
  pass VARCHAR2(8) NOT NULL,
  tipo CHAR NOT NULL,
  CONSTRAINT log_id_pk PRIMARY KEY(id_Login),
  CONSTRAINT log_tip_ck CHECK (tipo IN('A','a','U','u')));

-- Estructura de tabla para la tabla Administrador

DROP TABLE Administrador CASCADE CONSTRAINTS;

CREATE TABLE Administrador (
  ID_Admin NUMBER(3),
  nombre VARCHAR2(20) NOT NULL,
  apellido VARCHAR2(20) NOT NULL,
  pass NUMBER(4) NOT NULL,
  CONSTRAINT ADM_ID_PK PRIMARY KEY(ID_Admin),
  CONSTRAINT ADM_ID_FK FOREIGN KEY(ID_Admin) REFERENCES Login (ID_Login));

-- Estructura de tabla para la tabla Usuario

DROP TABLE Usuario CASCADE CONSTRAINTS;

CREATE TABLE Usuario (
  ID_Usuario NUMBER(3),
  nombre VARCHAR2(20) NOT NULL,
  apellido VARCHAR2(20) NOT NULL,
  CONSTRAINT USU_ID_PK PRIMARY KEY (ID_Usuario)
  CONSTRAINT USU_ID_FK FOREIGN KEY (ID_Usuario) REFERENCES Login (ID_Login));

-- Estructura de tabla para la tabla Jugador

DROP TABLE Jugador CASCADE CONSTRAINTS;

CREATE TABLE Jugador (
  ID_Jugador NUMBER(3),
  nombre VARCHAR2(20) NOT NULL,
  nickname VARCHAR2(20) NOT NULL,
  sueldo double(6,2) NOT NULL,
  telefono VARCHAR2(9) NOT NULL,
  rol VARCHAR2(20) NOT NULL,
  CONSTRAINT lug_id_pk PRIMARY KEY(id_persona));

-- Estructura de tabla para la tabla Equipo

DROP TABLE Equipo CASCADE CONSTRAINTS;

CREATE TABLE Equipo (
  ID_Equipo NUMBER(2) NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  nombre VARCHAR2(20) NOT NULL,
  nacionalidad VARCHAR2(20) NOT NULL,
  anio_creacion NUMBER(4) NOT NULL,
  CONSTRAINT equ_id_pk PRIMARY KEY(ID_Equipo));

-- Estructura de tabla para la tabla Partido

DROP TABLE Partido CASCADE CONSTRAINTS;

CREATE TABLE Partido (
  ID_Partido NUMBER(2) NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  hora time NOT NULL,
  puntosLocal NUMBER(3) NOT NULL,
  puntosVisitante NUMBER(3) NOT NULL,
  ID_Equipo_local NUMBER(4) NOT NULL,
  ID_Equipo_visitante NUMBER(4) NOT NULL,
  ID_Jornada NUMBER(4) NOT NULL,
  CONSTRAINT PAR_ID_PK PRIMARY KEY (ID_Partido),
  CONSTRAINT PAR_JOR_FK FOREIGN KEY (ID_Jornada) REFERENCES Jornada (ID_Jornada) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT PAR_LOC_FK FOREIGN KEY (ID_Local) REFERENCES Equipo (ID_Equipo) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT PAR_VIS_FK FOREIGN KEY (ID_Visitante) REFERENCES Equipo (ID_Equipo) ON DELETE CASCADE ON UPDATE CASCADE;)

-- Estructura de tabla para la tabla Jornada

DROP TABLE Jornada CASCADE CONSTRAINTS;

CREATE TABLE Jornada (
  ID_Jornada NUMBER(2) NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  fechaInicio date NOT NULL,
  fechaFin date NOT NULL,
  numeroJornada NUMBER(3) NOT NULL,
  numeroTemporada NUMBER(3) NOT NULL);

-- --------------------------------------------------------

--
-- Indices de la tabla Administrador
--

ALTER TABLE Administrador
  ADD PRIMARY KEY AD_CDAD_PK (codAdministrador),
  ADD KEY AD_ADCL_FK (codLogin);

-- --------------------------------------------------------

--
-- Indices de la tabla Usuario
--

ALTER TABLE Usuario
  ADD PRIMARY KEY US_CDUS_PK (codUsuario),
  ADD KEY US_USCL_FK (codLogin);

-- --------------------------------------------------------

--
-- Indices de la tabla duenio
--

ALTER TABLE duenio
  ADD PRIMARY KEY DU_CDDU_PK (codDuenio),
  ADD KEY DU_DUCL_FK (codLogin);
  
-- --------------------------------------------------------
  
--
-- Indices de la tabla Jugador
--

ALTER TABLE Jugador
  ADD PRIMARY KEY JU_CDJU_PK (codJugador),
  ADD KEY JU_JUEQ_FK (codEquipo);

-- --------------------------------------------------------  
  
--
-- Indices de la tabla Equipo
--
ALTER TABLE Equipo
  ADD PRIMARY KEY EQ_CDEQ_PK (codEquipo),
  ADD KEY EQ_EQDU_FK (codDuenio);

-- --------------------------------------------------------

--
-- Indices de la tabla Partido
--

ALTER TABLE Partido
  ADD PRIMARY KEY PA_CDPA_PK (codPartido),
  ADD KEY PA_PEQL_FK (codLocal),
  ADD KEY PA_PEQV_FK (codVisitante),
  ADD KEY PA_PAJO_FK (codJornada);

-- --------------------------------------------------------

--
-- Indices de la tabla Jornada
--

ALTER TABLE Jornada
  ADD PRIMARY KEY JO_CDJO_PK (codJornada);

-- --------------------------------------------------------

--
-- GENERANDO AUTO_INCREMENT DE LAS TABLAS VOLCADAS
--

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla Login
--

ALTER TABLE Login
  MODIFY codLogin NUMBER(4) NOT NULL AUTO_INCREMENT;

-- -------------------------------------------------------- 

--
-- AUTO_INCREMENT de la tabla Administrador
--

ALTER TABLE Administrador
  MODIFY codAdministrador NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------
  
--
-- AUTO_INCREMENT de la tabla Usuario
--

ALTER TABLE Usuario
  MODIFY codUsuario NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla duenio
--

ALTER TABLE duenio
  MODIFY codDuenio NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla Jugador
--

ALTER TABLE Jugador
  MODIFY codJugador NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla Equipo
--

ALTER TABLE Equipo
  MODIFY codEquipo NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla Partido
--

ALTER TABLE Partido
  MODIFY codPartido NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla Jornada
--

ALTER TABLE Jornada
  MODIFY codJornada NUMBER(11) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- RESTRICCIONES PARA LAS TABLAS VOLCADAS
--

-- --------------------------------------------------------

ALTER TABLE Login 
  ADD CONSTRAINT LO_LOTI_CK CHECK (tipo IN('A','a','U','u','D','d'));

-- --------------------------------------------------------

--
-- Filtros para la tabla Administrador
--

ALTER TABLE Administrador
  ADD CONSTRAINT AD_ADCL_FK FOREIGN KEY (codLogin) REFERENCES Login (codLogin) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla Usuario
--

ALTER TABLE Usuario
  ADD CONSTRAINT US_USCL_FK FOREIGN KEY (codLogin) REFERENCES Login (codLogin) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------
  
--
-- Filtros para la tabla duenio
--

ALTER TABLE duenio
  ADD CONSTRAINT DU_DUCL_FK FOREIGN KEY (codLogin) REFERENCES Login (codLogin) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla Jugador
--

ALTER TABLE Jugador ADD (
  CONSTRAINT JU_JUEQ_FK FOREIGN KEY (codEquipo) REFERENCES Equipo (codEquipo) ON DELETE CASCADE ON UPDATE CASCADE
  CONSTRAINT JU_SUMN_CK CHECK (salario >= 735,90));
  

-- --------------------------------------------------------

--
-- Filtros para la tabla Equipo
--

ALTER TABLE Equipo
  ADD CONSTRAINT EQ_EQDU_FK FOREIGN KEY (codDuenio) REFERENCES duenio (codDuenio) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla Partido
--

ALTER TABLE Partido
  ADD CONSTRAINT PA_PAJO_FK FOREIGN KEY (codJornada) REFERENCES Jornada (codJornada) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT PA_PEQL_FK FOREIGN KEY (codLocal) REFERENCES Equipo (codEquipo) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT PA_PEQV_FK FOREIGN KEY (codVisitante) REFERENCES Equipo (codEquipo) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- INSERCCION PREVIA DE DATOS PARA LAS TABLAS ANTERIORMENTE VOLCADAS - ESTOS DATOS SON OBLIGATORIOS
-- POR LO TANTO SON DATOS DE CARACTER PREESTABLECIDO PARA EL FUNCIONAMIENTO INICIAL DEL PROGRAMA
--

-- --------------------------------------------------------

--
-- Datos para la tabla 'Login' y 'administracion' -  Creacion del Usuario SUPERAMINISTRADOR
--

INSERT INTO Login (codLogin, Usuario, passwd, tipo) VALUES (1, 'root','root','A');

INSERT INTO Administrador VALUES (1, '00000000A', 'Miguel', 'Olmo', 1);

-- --------------------------------------------------------

--
-- Datos para la tabla 'Login' y 'duenio' -  Creacion de un duenio SUPERDUENIO
--

INSERT INTO Login (codLogin, Usuario, passwd, tipo) VALUES (2, 'super','duenio','D');

INSERT INTO duenio VALUES (1, '11111111A', 'Super', 'Duenio', 2);

-- --------------------------------------------------------

--
-- Datos para la tabla 'Login' y 'Usuario' -  Creacion de un Usuario SUPERUsuario
--

INSERT INTO Login (codLogin, Usuario, passwd, tipo) VALUES (3, 'super','Usuario','U');

INSERT INTO Usuario VALUES (1, '22222222A', 'Super', 'Usuario', 3);
