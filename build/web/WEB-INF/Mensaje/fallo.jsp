<%-- 
    Document   : fallo
    Created on : May 14, 2013, 9:35:38 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null){
        mensaje="";
    }

%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
    <!-- mensaje de fallo -->
    <div class="row">
        <div class="large-centered large-8 columns">
            <div data-alert class="alert-box alert text-center">
                <h3 style="color:white;"><%=mensaje%></h3>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="large-4 large-centered columns text-center">
            <a href="Indice" class="small radius button">Regresar al inicio</a>
        </div>
                    
<%@include file="/WEB-INF/Includes/footer.jsp" %>
