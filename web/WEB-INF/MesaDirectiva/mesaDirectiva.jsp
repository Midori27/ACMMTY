<%-- 
    Document   : mesaDirectiva
    Created on : May 3, 2013, 4:54:55 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.MiembroMesa"%>
<%  
    MiembroMesa[] miembros = (MiembroMesa[]) request.getAttribute("miembrosMesa");
    if(miembros==null)miembros = new MiembroMesa[0];
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MesaDirectiva</h1>
        <%
            for(int i=0;i<miembros.length;i++){
                out.println("<h2>"+miembros[i].getNombre()+"</h2>");
            }
        %>
    </body>
</html>
