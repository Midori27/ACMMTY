--
-- Base de datos: `PortalACM`
--


-- --------------------------------------------------------
-- Insertar datos en la tabla `Usuario`
-- --------------------------------------------------------
insert into Usuario (username,password,nombre,apellidoP,apellidoM,fechaNacimiento,telefono,ciudad,estado,email,tipo,carrera,matricula,campus,universidad)values ('JuanJo','1234','Juan','Lenero','Lozano','1992-05-28','88884324','Monterrey','Nuevo Leon','juan@gmail.com',0,'ITC','A01034171','Monterrey','ITESM'), ('LuisH','hola','Luis','Gonzalez','Guerra','1978-04-05','88886534','Monterrey','Nuevo Leon','lhgonzalez@itesm.mx',1,'ITC','A01031234','Monterrey','ITESM'), ('MariaMa','mr38','Maria','Martinez','Tijerina','1996-12-18','83482345','Monterrey','Nuevo Leon','maria@hotmail.com',1,'ITIC','A010342341','Monterrey','ITESM'), ('Pedro184','purpura','Pedro','Alvarez','Castro','1994-02-25','82345323','Monterrey','Nuevo Leon','pedro94@hotmail.com',1,'ITE','A01023454','Monterrey','ITESM'),('Angel','an123','Angel','Zepeda','Rosalez','1990-05-10','81345674','Monterrey','Nuevo Leon','angle123@gmail.com',1,'LAD','A01045432','Monterrey','ITESM'), ('MarthaGN','magica','Martha','Gimenez','Navarro','1992-07-13', '88346578','Monterrey','Nuevo Leon','marthag@gmail.com',1,'ITC','A01035567','Monterrey','ITESM'), ('Pa99LAM','secreto','Pablo','Perez','Parra','1989-11-20','88984367','Monterrey','Nuevo Leon','pablopp@hotmail.com',2,'ITC',null,'Monterrey','UDEM'), ('AleT','kosa12','Alejandra','Torres','Castillo','1991-10-30','88749382','Monterrey','Nuevo Leon','alextc@gmail.com',2,'ITC',null,'Monterrey','UDEM');

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
insert into Equipo(idEvento,nombre,puntaje) values (1,'The Algo Geeks',350),
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
insert into Comentario (descripcion,fecha,idEvento,idUsuario)values 
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


