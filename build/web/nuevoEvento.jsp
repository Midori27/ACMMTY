<%-- 
    Document   : nuevoEvento
    Created on : Mar 5, 2013, 5:43:42 PM
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
        <h1>Hello World!</h1>
        <form action="evento" method="POST">
            <input type="text" name="nombreE">
            <input type="date" name="fechaE">
            <input type="text" name="lugarE">
            <input type="text" name="descripcionE">
            <input type="number" name="integrantesPorEquipo">
            <input type="submit">
        </form>
    </body>
</html>
