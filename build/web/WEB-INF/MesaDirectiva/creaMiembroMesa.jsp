<%-- 
    Document   : pruebaMesaDirectiva
    Created on : Apr 15, 2013, 1:41:49 PM
    Author     : juanjo
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" import="Modelo.MiembroMesa" %>

<%
    MiembroMesa miembro = (MiembroMesa) request.getAttribute("miembro");
    if(miembro==null) miembro = new MiembroMesa();
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
        <h1>Hello World!</h1>
        <form action="CreaMiembroMesa" method="POST">
            <input type="hidden" name="id" value="<%=miembro.getId()%>">
            <label for="periodo">Periodo</label>
            <input type="text" name="periodo" value="<%=miembro.getPeriodo()%>"><br />
             <label for="foto">Foto</label>
            <input type="text" name="foto" value="<%=miembro.getFoto()%>"><br />
             <label for="nombre">Nombre</label>
            <input type="text" name="nombre" value="<%=miembro.getNombre()%>"><br />
             <label for="posicion">Posicion</label>
            <input type="text" name="posicion" value="<%=miembro.getPosicion()%>"><br />
            <input type="submit" value="Crea miembro">
        </form>
            <h3><%=mensaje%></h3>
    </body>
</html>
