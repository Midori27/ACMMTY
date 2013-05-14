<%-- 
    Document   : recuperaCuenta
    Created on : May 3, 2013, 5:31:38 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
<%@include file="/WEB-INF/Includes/alerta.jsp" %>
    <div class="row">
           <div class="large-8 large-centered columns">
               <form action="RecuperaCuenta" method="post">
                   <fieldset>
                       <legend>Recuperacion de cuenta</legend>
                       <div class="row">
                           <div class="large-12 columns">
                               <label>Email</label>
                               <input type="text" name="email" placeholder="El email con el que te registraste">
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