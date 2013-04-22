<%-- 
    Document   : actualizaNoticia.jsp
    Created on : Apr 17, 2013, 11:54:32 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia noticia = (Noticia) request.getAttribute("noticia");
    if(noticia==null) response.sendRedirect("/AdminNoticias");
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
        <h1>actualizaNoticia</h1>
        <form action="ActualizaNoticia" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%=noticia.getId()%>">
            <label for="titulo">Titulo</label><input type="text" name="titulo" value="<%=noticia.getTitulo()%>"><br />
            <label for="descripcion">Descripcion</label><textarea name="descripcion"><%=noticia.getDescripcion()%></textarea><br />
            <label for="imagen">Imagen</label><input type="file" name="imagen"><br />
            <img src="<%="ImagenServidor/"+noticia.getImagen()%>" height="100" width="100">
            <input type="hidden" name="imagenSubida" value="<%=noticia.getImagen()%>">
            <input type="submit" value="Actualiza noticia">
        </form>
        <h3><%=mensaje%></h3>
    </body>
</html>
