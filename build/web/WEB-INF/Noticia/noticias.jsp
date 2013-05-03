<%-- 
    Document   : noticia
    Created on : May 2, 2013, 1:15:59 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia[] noticias = (Noticia[]) request.getAttribute("noticias");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Noticias</h1>
        <%
            for(int i=0;i<noticias.length;i++){
                out.println("<h2><a href=\"VerNoticia?id="+noticias[i].getId()+"\">"+noticias[i].getTitulo()+"</a></h2>");
            }
        %>
    </body>
</html>
