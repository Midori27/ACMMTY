<%-- 
    Document   : creaNoticia.jsp
    Created on : Apr 17, 2013, 11:53:56 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia noticia = (Noticia) request.getAttribute("noticia");
    if(noticia==null) noticia=new Noticia();
    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null)mensaje="";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>creaNoticia</h1>
        <form action="CreaNoticia" method="post">
            <label for="titulo">Titulo</label><input type="text" name="titulo" value="<%=noticia.getTitulo()%>"><br />
            <label for="descripcion">Descripcion</label><textarea name="descripcion"><%=noticia.getDescripcion()%></textarea><br />
            <label for="imagen">Imagen</label><input type="text" name="imagen" value="<%=noticia.getImagen()%>"><br />
            <input type="submit" value="Crea noticia">
        </form>
        <h3><%=mensaje%></h3>
    </body>
</html>
