--
-- Base de datos: `PortalACM`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la base de datos `PortalACM`
--
-- --------------------------------------------------------



-- --------------------------------------------------------
-- Creacion de la tabla Usuario
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
  id int(11) NOT NULL AUTO_INCREMENT,
  nombreUsuario varchar(35) NOT NULL,
  password varchar(20) NOT NULL,
  nombre varchar(35) NOT NULL,
  apellidoP varchar(35) NOT NULL,
  apellidoM varchar(35),
  email varchar(255) NOT NULL,
  tipo int(1) NOT NULL,
  PRIMARY KEY (id)
) ;

-- --------------------------------------------------------
-- Creacion de la tabla Evento
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Evento (
  id int(11) NOT NULL AUTO_INCREMENT,
  imagen varchar(90) NOT NULL,
  nombre varchar(30) NOT NULL,
  fecha DATE NOT NULL,
  lugar varchar(50) NOT NULL,
  descripcion varchar(150) NOT NULL,
  integrantesPorEquipo int(2) NOT NULL,
  PRIMARY KEY (id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Equipo
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Equipo (
  id int(11) NOT NULL AUTO_INCREMENT,
  idEvento int(11) NOT NULL,
  idUsuario int(11) NOT NULL,
  nombre varchar(35) NOT NULL,
  estado varchar(35) NULL,
  puntaje int (9) NULL,
  clave varchar(35) NOT NULL,
  maxIntegrantes int (2) NOT NULL,
  PRIMARY KEY (id, idEvento, idUsuario),
  FOREIGN KEY (idEvento) REFERENCES Evento(id),
  FOREIGN KEY (idUsuario) REFERENCES Usuario(id)
) ;

-- --------------------------------------------------------
-- Creacion de la tabla Noticia
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Noticia (
  id int(11) NOT NULL AUTO_INCREMENT,
  imagen varchar(90) NOT NULL,
  fecha DATE,
  titulo varchar(30) NOT NULL,
  descripcion varchar(200) NOT NULL, 
  PRIMARY KEY (id)
) ;

-- --------------------------------------------------------
-- Creacion de la tabla ComentarioNoticia
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ComentarioNoticia (
  id int(11) NOT NULL AUTO_INCREMENT,
  descripcion varchar(1000) NOT NULL,
  fecha DATE NOT NULL, 
  idNoticia int(11) NOT NULL,
  idUsuario int(11) NOT NULL,
  nombreUsuario varchar(35) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idNoticia) REFERENCES Noticia(id) ON DELETE CASCADE,
  FOREIGN KEY (idUsuario) REFERENCES Usuario(id)
) ;

-- --------------------------------------------------------
-- Creacion de la tabla ComentarioEvento
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ComentarioEvento (
  id int(11) NOT NULL AUTO_INCREMENT,
  descripcion varchar(1000) NOT NULL,
  fecha DATE NOT NULL, 
  idEvento int(11) NOT NULL,
  idUsuario int(11) NOT NULL,
  nombreUsuario varchar(35) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idEvento) REFERENCES Evento(id) ON DELETE CASCADE,
  FOREIGN KEY (idUsuario) REFERENCES Usuario(id)
) ;

-- --------------------------------------------------------
-- Creacion de la tabla RecuperacionCuenta
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS RecuperacionCuenta(
  id int(11) NOT NULL AUTO_INCREMENT,
  idUsuario int(11) NOT NULL,
  fechaExpedicion TIMESTAMP NOT NULL,
  fechaExpiracion TIMESTAMP NOT NULL,
  uuid varchar(36) NOT NULL,
  reclamo boolean NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idUsuario) REFERENCES Usuario(id)
) ;
-- --------------------------------------------------------
-- Creacion de la tabla Periodo
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Periodo(
  id int(11) NOT NULL AUTO_INCREMENT,
  mInicio varchar(10) NOT NULL,
  aInicio int(11) NOT NULL,
  mFin varchar(10) NOT NULL,
  aFin int(11) NOT NULL,
  PRIMARY KEY (id)
) ;
-- --------------------------------------------------------
-- Creacion de la tabla MesaDirectiva
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS MesaDirectiva(
  id int(11) NOT NULL AUTO_INCREMENT,
  idPeriodo int(11) NOT NULL,
  foto varchar(60) NOT NULL,
  nombre varchar(60) NOT NULL,
  posicion varchar(60) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idPeriodo) REFERENCES Periodo(id) ON DELETE CASCADE
) ;
