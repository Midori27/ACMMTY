--
-- Base de datos: `RegistroACM`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la base de datos `RegistroACM`
--
-- --------------------------------------------------------



-- --------------------------------------------------------
-- Creacion de la tabla Persona
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Persona (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  nombre varchar(20) NOT NULL,
  apellidoP varchar(20) NOT NULL,
  apellidoM varchar(20),
  fechaNacimiento Date NOT NULL,
  telefono int (15) ,
  direccion varchar(50) NOT NULL,
  email varchar(30) NOT NULL,
  tipo int(1) NOT NULL,
  PRIMARY KEY (id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Administrador
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Administrador (
  id int(11) NOT NULL,
  nivel int(1) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES Persona(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Usuario
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
  id int(11) NOT NULL ,
  tipo int(1) NOT NULL,
  carrera varchar(5) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES Persona(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Interno
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Interno (
  id int(11) NOT NULL ,
  matricula varchar(10) NOT NULL,
  campus varchar(15) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES Usuario(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Externo
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Externo (
  id int(11) NOT NULL ,
  universidad varchar(30) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES Usuario(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Evento
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Evento (
  id int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(30) NOT NULL,
  fecha date NOT NULL,
  lugar varchar(50) NOT NULL,
  descripcion varchar(150) NOT NULL,
  tipo int(1) NOT NULL,
  PRIMARY KEY (id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla EventoIndividual
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS EventoIndividual (
  id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES Evento(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla EventoEquipo
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS EventoEquipo (
  id int(11) NOT NULL ,
  NoPersonaXEquipo int(2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES Evento(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Equipo
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Equipo (
  id int(11) NOT NULL AUTO_INCREMENT,
  eventoID int(11) NOT NULL,
  nombre varchar(30) NOT NULL,
  puntaje int (8) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (eventoID) REFERENCES EventoEquipo(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla UsuarioEventoIn
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS UsuarioEventoIn (
  usuarioID int(11) NOT NULL ,
  eventoID int(11) NOT NULL,
  estado varchar(30) ,
  puntaje int (8) NOT NULL,
  PRIMARY KEY (usuarioID,eventoID),
  FOREIGN KEY (eventoID) REFERENCES EventoIndividual(id),
  FOREIGN KEY (usuarioID) REFERENCES Usuario(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla UsuarioEventoEq
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS UsuarioEventoEq (
  usuarioID int(11) NOT NULL ,
  equipoID int(11) NOT NULL,
  PRIMARY KEY (usuarioID,equipoID),
  FOREIGN KEY (equipoID) REFERENCES Equipo(id),
  FOREIGN KEY (usuarioID) REFERENCES Usuario(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Comentario
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Comentario (
  id int(11) NOT NULL AUTO_INCREMENT,
  descripcion varchar(150) NOT NULL,
  fecha date NOT NULL, 
  eventoID int(11) NOT NULL,
  personaID int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (eventoID) REFERENCES Evento(id),
  FOREIGN KEY (personaID) REFERENCES Persona(id)
) ;


-- --------------------------------------------------------
-- Creacion de la tabla Noticia
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Noticia (
  id int(11) NOT NULL AUTO_INCREMENT,
  fecha date,
  titulo varchar(30) NOT NULL,
  descripcion varchar(200) NOT NULL, 
  PRIMARY KEY (id)
) ;

