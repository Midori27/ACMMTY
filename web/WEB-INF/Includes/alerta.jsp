<%-- 
    Document   : alerta
    Created on : May 14, 2013, 9:38:43 AM
    Author     : juanjo
--%>

<%
    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null){
        mensaje="";
    }

%>
  <% if(!mensaje.isEmpty()){%>
    <div class="row">
        <div class="large-8 large-centered columns">
            <div data-alert class="alert-box alert">
                <%=mensaje%>
                <a href="#" class="close">&times;</a>
            </div>
        </div>    
    </div>
    <% } %>