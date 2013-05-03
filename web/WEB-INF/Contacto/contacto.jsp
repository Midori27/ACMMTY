<%-- 
    Document   : contacto
    Created on : May 3, 2013, 5:17:28 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nombre = (String) request.getAttribute("nombre");
    if(nombre==null) nombre="";
    String email = (String) request.getAttribute("email");
    if(email==null) email="";
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Contacto</h1>
            <form action="Contacto" method="post">
                <label for="name">Nombre</label><input type="text" name="name" value="<%=nombre%>" /><br />
		<label for="email">Correo</label><input type="text" name="email" value="<%=email%>" /><br />
		<label for="subject">Asunto</label><input type="text" name="subject" value="" /><br />
                <label for="message">Mensaje</label><textarea name="message" rows="5" cols="25"></textarea><br />
                <input type="submit" value="Contactanos" />	
            </form>
    </body>
</html>
