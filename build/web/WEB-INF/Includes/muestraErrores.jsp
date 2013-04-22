<%-- 
    Document   : muestraErrores
    Created on : Apr 22, 2013, 12:32:00 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList"%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null)mensaje="";
    List<ConstraintViolation> errores = (List<ConstraintViolation>) request.getAttribute("errores");
    if(errores==null) errores = new ArrayList<ConstraintViolation>();
    %>
<h3><%=mensaje%></h3>
<div style="background-color: red">
    <%
        if(!errores.isEmpty()){
            out.println("<ul>");
            for(int i=0; i<errores.size();i++){
                out.println("<li>"+errores.get(i).getMessage()+"<//li>");
            }
            out.println("<//ul>");
        }
    %>
</div>
