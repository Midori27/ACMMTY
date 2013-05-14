<%-- 
    Document   : reestableceContrasena
    Created on : May 3, 2013, 5:31:53 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String uuid = (String) request.getAttribute("uuid");
    
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
<%@include file="/WEB-INF/Includes/alerta.jsp" %>
    <div class="row">
           <div class="large-8 large-centered columns">
               <form action="ReestableceContrasena" method="post">
                   <fieldset>
                       <legend>Reestablecer password</legend>
                       <div class="row">
                           <div class="large-12 columns">
                               <label>Nuevo password</label>
                               <input type="password" name="password">
                               <label>Confirma tu nuevo password</label>
                               <input type="password" name="confirmaPassword">
                               <input type="hidden" value="<%=uuid%>" name="uuid" />
                           </div>
                       </div>
                       <div class="row">
                            <div class="large-offset-9 columns">
                                <input type="submit" class="small button" value="Continuar">
                           </div>
                       </div>
                   </fieldset>
               </form>
           </div>
    </div>
<%@include file="/WEB-INF/Includes/footer.jsp" %>