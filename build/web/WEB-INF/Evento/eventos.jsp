<%-- 
    Document   : eventos
    Created on : May 3, 2013, 1:31:15 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento"%>
<%
    Evento[] eventos = (Evento[]) request.getAttribute("eventos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Eventos</h1>
        <%
            for(int i=0;i<eventos.length;i++){
                out.println("<h2><a href=\"VerEvento?id="+eventos[i].getId()+"\">"+eventos[i].getNombre()+"</a></h2>");
            }
        %>
    </body>
</html>
