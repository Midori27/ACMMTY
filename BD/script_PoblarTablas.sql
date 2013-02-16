--
-- Base de datos: `RegistroACM`
--


-- --------------------------------------------------------
-- Insertar datos en la tabla `Persona`
-- --------------------------------------------------------
insert into Persona (username,password,nombre,apellidoP,apellidoM,fechaNacimiento,telefono,direccion,email,tipo)values ('JuanJo','1234','Juan','Lenero','Lozano','1992-05-28',88888888,'Miguel Angel 123 Colonia Contry La Silla','juan@gmail.com',0), ('LuisH','hola','Luis','Gonzalez','Guerra','1978-04-05',83335932,'Pinos 3333 Colonia Beto','lhgonzalez@itesm.mx',0), ('MariaMa','mr38','Maria','Martinez','','1996-12-18',12345678,'Mizar 456 Colonia Contry','maria@hotmail.com',1), ('Pedro184','purpura','Pedro','Alvarez','Castro','1994-02-25',45678901,'Hamsburgo 567 Colonia Alta Vista','pedro94@hotmail.com',1),
 ('Angel','an123','Angel','Zepeda','Rosalez','1990-05-10', 12986735,'Revolucion 1865 Colonia Playa','angle123@gmail.com',1), ('MarthaGN','magica','Martha','Gimenez','Navarro','1992-07-13', 869553597,'Rio Naza 568 Colonia La Presa','marthag@gmail.com',1), ('Pa99LAM','secreto','Pablo','Perez','Parra','1989-11-20', 12579563,'Benitez 175 Colonia Rio','pablopp@hotmail.com',1), ('AleT','kosa12','Alejandra','Torres','Castillo','1991-10-30', 675359012,'Costa Azul 2208 Colonia Laguna','alextc@gmail.com',1);



-- --------------------------------------------------------
-- Insersion de datos en la tabla `Administrador`
-- --------------------------------------------------------
insert into Administrador values (1,1);
insert into Administrador values (2,0);


-- --------------------------------------------------------
-- Insersion de datos en la tabla `Usuario`
-- --------------------------------------------------------
insert into Usuario values (3,0,'ITC');
insert into Usuario values (4,1,'ITIC');
insert into Usuario values (5,0,'INT');
insert into Usuario values (6,0,'IMA');
insert into Usuario values (7,1,'LATI');
insert into Usuario values (8,1,'ITC');


-- --------------------------------------------------------
-- Insersion de datos en la tabla `Interno`
-- --------------------------------------------------------
insert into Interno values (3,'A01074693','Monterrey');
insert into Interno values (5,'A00864537','Saltillo');
insert into Interno values (6,'A00949370','Monterrey');


-- --------------------------------------------------------
-- Insersion de datos en la tabla `Externo`
-- --------------------------------------------------------
insert into Externo values (4,'UANL');
insert into Externo values (7,'UNAM');
insert into Externo values (8,'UDG');


-- --------------------------------------------------------
-- Insersion de datos en la tabla `Evento`
-- --------------------------------------------------------
insert into Evento (nombre,fecha,lugar,descripcion,tipo)values ('Hackathon','2012-10-08',' biblioteca del Campus Monterrey','maraton hacking de 24 horas',1),
('Top Tec Programmer','2013-01-28','virtual','competencia individual de programacion',0),
('ICPC','2012-04-23','Centro Estudiantil','Competencia de programacion',1);


-- --------------------------------------------------------
-- Insersion de datos en la tabla `EventoIndividual`
-- --------------------------------------------------------
insert into EventoIndividual values (2);


-- --------------------------------------------------------
-- Insersion de datos en la tabla `EventoEquipo`
-- --------------------------------------------------------
insert into EventoEquipo values (1,4);
insert into EventoEquipo values (3,5);


-- --------------------------------------------------------
-- Insersion de datos en la tabla `Equipo`
-- --------------------------------------------------------
insert into Equipo(eventoID,nombre,puntaje) values (1,'The Algo Geeks',350),
(1,'The Best Team',200),
(1,'Byte',250),
(3,'ANY Dream', 150),
(3,'LOL', 380);


-- --------------------------------------------------------
-- Insersion de datos en la tabla `UsuarioEventoIn`
-- --------------------------------------------------------
insert into UsuarioEventoIn values (3,2,'activo',185);
insert into UsuarioEventoIn values (6,2,'',50);
insert into UsuarioEventoIn values (7,2,'activo',245);


-- --------------------------------------------------------
-- Insersion de datos en la tabla `UsuarioEventoEq`
-- --------------------------------------------------------
insert into UsuarioEventoEq values (3,1);
insert into UsuarioEventoEq values (4,2);
insert into UsuarioEventoEq values (6,3);
insert into UsuarioEventoEq values (7,3);
insert into UsuarioEventoEq values (5,2);
insert into UsuarioEventoEq values (8,1);
insert into UsuarioEventoEq values (8,4);
insert into UsuarioEventoEq values (5,5);
insert into UsuarioEventoEq values (3,4);
insert into UsuarioEventoEq values (6,4);


-- --------------------------------------------------------
-- Insersion de datos en la tabla `Comentario`
-- --------------------------------------------------------
insert into Comentario (descripcion,fecha,eventoID,personaID)values 
('Es imposible resolver el problema 5','2012-11-25',1,3),
('Donde esta publicada la solucion?','2012-10-30',2,4),
('Quien ya tiene la solucion?','2013-01-18',2,8),
('Animo','2012-12-05',3,3),
('Mi codigo no funciona','2012-09-05',1,5),
('El juez en linea no acepta mi solucion','2012-08-17',1,6);


-- --------------------------------------------------------
-- Insersion de datos en la tabla `Noticia`
-- --------------------------------------------------------
insert into Noticia(fecha,titulo,descripcion) values 
('2012-08-30','Top Tec Programmer 2012','El 1ro de Septiembre iniciara la inscripcion del concurso de Top Tec Programmer, para mayor informacion consultar a la pagina del ACM'),
('2012-09-19','Junta Top Tec Programmer','El dia 20 de Septiembre habra junta para todo los concursantes en aulas 3-101, esperamos su asistencia.'),
('2012-12-05','Cierre del Top Tec Programmer','La ceremonia del cierre del concurso se queda para el dia 10 de Diciembre en Auditorio Luis Elizondo a las 12:00pm, donde se entregara diplomas y premios a los programadores destacados'),
('2013-01-20','Junta para el evento de Hackathon','Quieres conocer las tecnicas de hacking, participas en el evento de Hackathon.');


