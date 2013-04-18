<%-- 
    Document   : actualizaUsuario
    Created on : Apr 16, 2013, 4:24:55 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Usuario,Controlador.Query"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if(usuario==null){
        Integer id = Integer.parseInt((String)request.getSession().getAttribute("id"));
        Query q = new Query();
        usuario = q.getUsuarioBD(id);
    }
    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null)mensaje = "";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3><%=mensaje%></h3>
        <form action="ActualizaUsuario" method="post">
            <label>Nombre</label><input class="textbox" type="text" name="nombre"  id="nombre" value="<%=usuario.getNombre()%>"/><br />
            <label>Apellido Paterno</label><input class="textbox" type="text" name="apellidoP"  id="apellidoP" value="<%=usuario.getApellidoP()%>"/><br />
            <label>Apellido Materno</label><input class="textbox" type="text" name="apellidoM"  id="apellidoM" value="<%=usuario.getApellidoM()%>"/><br />
            <label>Fecha de Nacimiento</label>
            <input type="date" class="textbox" name="fechaNacimiento" id="fechaNacimiento" value="mm-dd-aaaa"><br /><br />
            <label>Telefono</label><input class="textbox" type="text" name="telefono"  id="telefono" value="<%=usuario.getTelefono()%>"/><br />
            <label>Ciudad</label><select class="textbox" type="text" name="ciudad"  id="ciudad" />
              <option value="nada">Selecciona</option>
              <option value="Monterrey">Monterrey</option>
              <option value="Monclova">Monclova</option>
            </select><br /><br />
            <label>Estado</label><select class="textbox" type="text" name="estado"  id="estado"/>
              <option value="nada">Selecciona</option>
              <option value="Monterrey">Nuevo Léon</option>
              <option value="Monclova">Coahuila</option>
            </select><br /><br />
            <label>Universidad</label><select class="textbox" type="text" name="universidad"  id="universidad"/>
              <option value="nada">Selecciona</option>
              <option value="ITESM">ITESM</option>
              <option value="UDEM">UDEM</option>
            </select><br /><br />
            <label>Campus</label><select class="textbox" type="text" name="campus"  id="campus"/>
              <option value="nada">Selecciona</option>
              <option value="Monterrey">MTY</option>
              <option value="Coahuila">COAH</option>
            </select><br /><br />
            <label>Carrera</label><select class="textbox" type="text" name="carrera"  id="carrera"/>
              <option value="nada">Selecciona</option>
              <option value="ITC">ITC</option>
              <option value="ITE">ITE</option>
            </select><br /><br />
            <label>Mátricula</label><input class="textbox" type="text" name="matricula"  id="matricula" value="<%=usuario.getMatricula()%>"/><br />
            <label>Nombre de Usuario</label>
            <input class="textbox" type="text" name="nombreUsuario"  id="nombreUsuario" value="<%=usuario.getNombreUsuario()%>"/><br /><br />
            <label>Email</label><input class="textbox" type="text" name="email"  id="email" value="<%=usuario.getEmail()%>"/><br />
            <label>password</label><input class="textbox" type="password" name="password"  id="password" value="<%=usuario.getPassword()%>"/><br />		
            <input type="submit" value="Actualizar usuario">	
        </form>
    </body>
</html>
