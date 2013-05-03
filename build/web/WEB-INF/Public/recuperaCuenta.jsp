<%-- 
    Document   : recuperaCuenta
    Created on : May 3, 2013, 5:31:38 PM
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
        <h1>Recuperaci&oacute;n de cuenta.</h1>
         <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="RecuperaCuenta" method="post" enctype="multipart/form-data">
            <h4>¿Qu&eacute; olvidaste?</h4>
            <input id="campoPassword" type="radio" name="campo" value="password" checked="checked" />
            <label for="campoPassword">Contrase&ntilde;a</label><br></br>
            <input id="campoUsuario"type="radio" name="campo" value="usuario" />
            <label for="campoUsuario">Usuario</label><br></br>
            <h4>Introduce tu e-mail</h4>
            <input id="email" type="text" placeholder="Tu E-Mail" name="email"></input>
            <label for="email">E-Mail</label><br></br>
            <input type="submit" value="Continuar"></input>
        </form>
    </body>
</html>
