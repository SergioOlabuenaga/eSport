drop table login CASCADE CONSTRAINTS;
drop table administrador CASCADE CONSTRAINTS;
drop table usuario CASCADE CONSTRAINTS;
drop table jugador CASCADE CONSTRAINTS;
drop table equipo CASCADE CONSTRAINTS;
drop table partido CASCADE CONSTRAINTS;
drop table jornada CASCADE CONSTRAINTS;
-- Estructura de tabla para la tabla login
--

CREATE TABLE login (
  id_login NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  usuario VARCHAR2(8) NOT NULL,
  pass VARCHAR2(8) NOT NULL,
  tipo CHAR NOT NULL,
  CONSTRAINT log_id_pk PRIMARY KEY(id_login),
  CONSTRAINT log_tip_ck CHECK (tipo IN('A','a','U','u'))
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla administrador
--

CREATE TABLE administrador (
  id_admin NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  nombre VARCHAR2(20) NOT NULL,
  apellido VARCHAR2(20) NOT NULL,
  pass NUMBER(4) NOT NULL,
  CONSTRAINT adm_id_pk PRIMARY KEY(id_admin)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla usuario
--

CREATE TABLE usuario (
  id_usuario NUMBER(3) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  nombre VARCHAR2(20) NOT NULL,
  apellido VARCHAR2(20) NOT NULL,
  CONSTRAINT usr_id_pk PRIMARY KEY(id_usuario)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla jugador
--

CREATE TABLE jugador (
  id_persona NUMBER(4) NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  nombre VARCHAR2(20) NOT NULL,
  nickname VARCHAR2(20) NOT NULL,
  sueldo double(6,2) NOT NULL,
  telefono VARCHAR2(9) NOT NULL,
  rol VARCHAR2(20) NOT NULL,
  CONSTRAINT lug_id_pk PRIMARY KEY(id_persona)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla equipo
--

CREATE TABLE equipo (
  id_equipo NUMBER(4) NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  nombre VARCHAR2(20) NOT NULL,
  nacionalidad VARCHAR2(20) NOT NULL,
  anio_creacion NUMBER(4) NOT NULL,
  CONSTRAINT equ_id_pk PRIMARY KEY(id_equipo)
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla partido
--

CREATE TABLE partido (
  id_partido NUMBER(4) NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  hora time NOT NULL,
  puntosLocal NUMBER(3) NOT NULL,
  puntosVisitante NUMBER(3) NOT NULL,
  id_equipo_local NUMBER(4) NOT NULL,
  id_equipo_visitante NUMBER(4) NOT NULL,
  id_jornada NUMBER(4) NOT NULL,
  CONSTRAINT par_id_pk PRIMARY KEY(id_partido)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla jornada
--

CREATE TABLE jornada (
  id_jornada NUMBER(2) NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1 MAXVALUE 999),
  fechaInicio date NOT NULL,
  fechaFin date NOT NULL,
  numeroJornada NUMBER(3) NOT NULL,
  numeroTemporada NUMBER(3) NOT NULL
);

-- --------------------------------------------------------

--
-- GENERANDO INDICES PK Y FK PARA LAS TABLAS VOLCADAS
--

-- --------------------------------------------------------

--
-- Indices de la tabla login
--

ALTER TABLE login
  ADD PRIMARY KEY LO_CDLO_PK (codLogin);

-- --------------------------------------------------------

--
-- Indices de la tabla administrador
--

ALTER TABLE administrador
  ADD PRIMARY KEY AD_CDAD_PK (codAdministrador),
  ADD KEY AD_ADCL_FK (codLogin);

-- --------------------------------------------------------

--
-- Indices de la tabla usuario
--

ALTER TABLE usuario
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
-- Indices de la tabla jugador
--

ALTER TABLE jugador
  ADD PRIMARY KEY JU_CDJU_PK (codJugador),
  ADD KEY JU_JUEQ_FK (codEquipo);

-- --------------------------------------------------------  
  
--
-- Indices de la tabla equipo
--
ALTER TABLE equipo
  ADD PRIMARY KEY EQ_CDEQ_PK (codEquipo),
  ADD KEY EQ_EQDU_FK (codDuenio);

-- --------------------------------------------------------

--
-- Indices de la tabla partido
--

ALTER TABLE partido
  ADD PRIMARY KEY PA_CDPA_PK (codPartido),
  ADD KEY PA_PEQL_FK (codLocal),
  ADD KEY PA_PEQV_FK (codVisitante),
  ADD KEY PA_PAJO_FK (codJornada);

-- --------------------------------------------------------

--
-- Indices de la tabla jornada
--

ALTER TABLE jornada
  ADD PRIMARY KEY JO_CDJO_PK (codJornada);

-- --------------------------------------------------------

--
-- GENERANDO AUTO_INCREMENT DE LAS TABLAS VOLCADAS
--

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla login
--

ALTER TABLE login
  MODIFY codLogin NUMBER(4) NOT NULL AUTO_INCREMENT;

-- -------------------------------------------------------- 

--
-- AUTO_INCREMENT de la tabla administrador
--

ALTER TABLE administrador
  MODIFY codAdministrador NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------
  
--
-- AUTO_INCREMENT de la tabla usuario
--

ALTER TABLE usuario
  MODIFY codUsuario NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla duenio
--

ALTER TABLE duenio
  MODIFY codDuenio NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla jugador
--

ALTER TABLE jugador
  MODIFY codJugador NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla equipo
--

ALTER TABLE equipo
  MODIFY codEquipo NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla partido
--

ALTER TABLE partido
  MODIFY codPartido NUMBER(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla jornada
--

ALTER TABLE jornada
  MODIFY codJornada NUMBER(11) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- RESTRICCIONES PARA LAS TABLAS VOLCADAS
--

-- --------------------------------------------------------

ALTER TABLE login 
  ADD CONSTRAINT LO_LOTI_CK CHECK (tipo IN('A','a','U','u','D','d'));

-- --------------------------------------------------------

--
-- Filtros para la tabla administrador
--

ALTER TABLE administrador
  ADD CONSTRAINT AD_ADCL_FK FOREIGN KEY (codLogin) REFERENCES login (codLogin) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla usuario
--

ALTER TABLE usuario
  ADD CONSTRAINT US_USCL_FK FOREIGN KEY (codLogin) REFERENCES login (codLogin) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------
  
--
-- Filtros para la tabla duenio
--

ALTER TABLE duenio
  ADD CONSTRAINT DU_DUCL_FK FOREIGN KEY (codLogin) REFERENCES login (codLogin) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla jugador
--

ALTER TABLE jugador ADD (
  CONSTRAINT JU_JUEQ_FK FOREIGN KEY (codEquipo) REFERENCES equipo (codEquipo) ON DELETE CASCADE ON UPDATE CASCADE
  CONSTRAINT JU_SUMN_CK CHECK (salario >= 735,90));
  

-- --------------------------------------------------------

--
-- Filtros para la tabla equipo
--

ALTER TABLE equipo
  ADD CONSTRAINT EQ_EQDU_FK FOREIGN KEY (codDuenio) REFERENCES duenio (codDuenio) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla partido
--

ALTER TABLE partido
  ADD CONSTRAINT PA_PAJO_FK FOREIGN KEY (codJornada) REFERENCES jornada (codJornada) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT PA_PEQL_FK FOREIGN KEY (codLocal) REFERENCES equipo (codEquipo) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT PA_PEQV_FK FOREIGN KEY (codVisitante) REFERENCES equipo (codEquipo) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- INSERCCION PREVIA DE DATOS PARA LAS TABLAS ANTERIORMENTE VOLCADAS - ESTOS DATOS SON OBLIGATORIOS
-- POR LO TANTO SON DATOS DE CARACTER PREESTABLECIDO PARA EL FUNCIONAMIENTO INICIAL DEL PROGRAMA
--

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'administracion' -  Creacion del usuario SUPERAMINISTRADOR
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (1, 'root','root','A');

INSERT INTO administrador VALUES (1, '00000000A', 'Miguel', 'Olmo', 1);

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'duenio' -  Creacion de un duenio SUPERDUENIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (2, 'super','duenio','D');

INSERT INTO duenio VALUES (1, '11111111A', 'Super', 'Duenio', 2);

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'usuario' -  Creacion de un usuario SUPERUSUARIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (3, 'super','usuario','U');

INSERT INTO usuario VALUES (1, '22222222A', 'Super', 'Usuario', 3);
