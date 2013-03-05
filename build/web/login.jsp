<%-- 
    Document   : login
    Created on : Mar 3, 2013, 9:05:11 PM
    Author     : juanjo
--%>

<%@page import="Controlador.ServletLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = (String) request.getAttribute(ServletLogin.ATRIBUTO_ERR);
    if (mensaje == null){
        mensaje = "";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4><%=mensaje%></h4>
        <form action="login" method="POST">
            <input type="text" name="uname">
            <input type="password" name="pass">
            <input type="submit">
        </form>
    </body>
</html>
