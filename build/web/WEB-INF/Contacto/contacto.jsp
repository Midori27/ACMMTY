<%-- 
    Document   : contacto
    Created on : May 3, 2013, 5:17:28 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nombre = (String) request.getAttribute("nombre");
    if(nombre==null) nombre="";
    String email = (String) request.getAttribute("email");
    if(email==null) email="";
    %>
<%@include file="/WEB-INF/Includes/header.jsp" %>
<%@include file="/WEB-INF/Includes/alerta.jsp"%>
        <div class="row">
            <div class="large-8 large-centered columns">
                <form action="Contacto" method="post">
                    <fieldset>
                        <legend>Contacto</legend>
                        <div class="row">
                            <div class="large-6 columns">
                                <label>Nombre</label>
                                <input type="text" name="name" placeholder="Tu nombre" value="<%=nombre%>">
                            </div>
                            <div class="large-6 columns">
                                <label>Email</label>
                                <input type="text" name="email" placeholder="Tu email" value="<%=email%>">
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12 columns">
                                <label>Asunto</label>
                                <input type="text" name="subject" placeholder="Cual es tu asunto" value="">
                                <label>Mensaje</label>
                                <textarea style="height:300px;" rows="50" name="message" placeholder="Tu mensaje"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-offset-9 columns">
                                <input type="submit" class="small button" value="Contactanos">
                           </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
<%@include file="/WEB-INF/Includes/footer.jsp" %>
