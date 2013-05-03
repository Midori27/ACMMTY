<%-- 
    Document   : reestableceContrasena
    Created on : May 3, 2013, 5:31:53 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reestablece contrasena</h1>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="ReestableceContrasena" method="post">
            <input id="campoPassword" type="password" name="password" />
            <label for="campoPassword">Contrase&ntilde;a</label><br></br>
            <input id="confirmaPassword" type="password" name="confirmaPassword" />
            <label for="confirmaPassword">Confirma contrase&ntilde;a</label><br></br>
            <h3 style="color:red;"><%=mensaje%></h3>
            <input type="hidden" value="<%=uuid%>" name="uuid" />
            <input type="submit" value="Aceptar"></input>
        </form>
    </body>
</html>
