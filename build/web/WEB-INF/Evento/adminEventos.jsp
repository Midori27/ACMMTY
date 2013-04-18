<%-- 
    Document   : adminEventos
    Created on : Apr 16, 2013, 6:05:13 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento"%>
<%
    Evento eventos[] = (Evento[]) request.getAttribute("eventos");
    if (eventos==null) eventos = new Evento[0];
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje==null) mensaje = "";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Administrar Eventos</h1>
        <h3><%=mensaje%></h3>
        <%  for(int i=0; i<eventos.length;i++){%>
            <%=eventos[i].getNombre()%> 
            <a href="ActualizaEvento?id=<%=eventos[i].getId()%>">Modifica</a>
            <a href="BorraEvento?id=<%=eventos[i].getId()%>">Elimina</a>
            <br />
            <%}%>    
    </body>
</html>
