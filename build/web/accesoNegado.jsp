<%-- 
    Document   : accesoNegado
    Created on : May 17, 2013, 8:16:43 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
<%
    Usuario u = (Usuario) request.getSession().getAttribute(Usuario.NOMBRE_TABLA);
%>

    <div class="row">
        <div class="large-10 large-centered columns">
            <div class="row">
                <div class="large-4 columns">
                    <img src="img/stop.jpg" />
                </div>
                <div class="large-8 columns">
                    <% if(u==null){ %>
                    <p>El contenido que trataste de accesar solo lo pueden acceder usuarios registrados, porfavor inicia sesión.</p>
                    <a class="small button" href="Login">Iniciar sesion</a>
                    <% } else { %>
                    <p>El contenido que trataste de accesar es sólo para administradores.</p>
                    <a class="small button" href="Indice">Regresar a inicio</a>
                    <% } %>
                    
                </div>
            </div>
        </div>
    </div>
<%@include file="/WEB-INF/Includes/footer.jsp" %>
