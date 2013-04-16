<%-- 
    Document   : adminMesaDirectiva
    Created on : Apr 15, 2013, 11:35:04 PM
    Author     : juanjo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.MiembroMesa"%>
<%
    MiembroMesa miembros[] = (MiembroMesa[]) request.getAttribute("miembros");
    if (miembros==null) miembros = new MiembroMesa[0];
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
        <h1>Administrar Mesa Directiva</h1>
        <h3><%=mensaje%></h3>
        <%  for(int i=0; i<miembros.length;i++){%>
            <%=miembros[i].getNombre()%> 
            <a href="ActualizaMiembroMesa?id=<%=miembros[i].getId()%>">Modifica</a>
            <a href="BorraMiembroMesa?id=<%=miembros[i].getId()%>">Elimina</a>
            <br />
            <%}%>    
    </body>
</html>
