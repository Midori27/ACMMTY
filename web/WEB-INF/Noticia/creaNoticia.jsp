<%-- 
    Document   : creaNoticia.jsp
    Created on : Apr 17, 2013, 11:53:56 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia, net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList"%>
<%
    Noticia noticia = (Noticia) request.getAttribute("noticia");
    if(noticia==null) noticia=new Noticia();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crea Noticia</h1>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <form action="CreaNoticia" method="post" enctype="multipart/form-data">
            <label for="titulo">Titulo</label><input type="text" name="titulo" value="<%=noticia.getTitulo()%>"><br />
            <label for="descripcion">Descripcion</label><textarea name="descripcion"><%=noticia.getDescripcion()%></textarea><br />
            <label for="imagen">Imagen</label><input type="file" name="imagen"><br />
            <img src="ImagenServidor/<%=noticia.getImagen()%>" height="150" width="150">
            <input type="hidden" name="imagenSubida" value="<%=noticia.getImagen()%>">
            <input type="submit" value="Crea noticia">
        </form>
    </body>
</html>
