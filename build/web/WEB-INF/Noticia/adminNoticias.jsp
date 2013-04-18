<%-- 
    Document   : adminNoticias
    Created on : Apr 17, 2013, 11:55:08 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia noticias[] = (Noticia[]) request.getAttribute("noticias");
    if (noticias==null)noticias = new Noticia[0];
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje==null)mensaje="";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>adminNoticias</h1>
        <% for(int i=0; i<noticias.length;i++){%>
        <%=noticias[i].getTitulo()%>
        <a href="ActualizaNoticia?id=<%=noticias[i].getId()%>">Modifica</a>
        <a href="BorraNoticia?id=<%=noticias[i].getId()%>">Elimina</a>
        <br />
        <%}%>
        <h3><%=mensaje%></h3>
    </body>
</html>
