<%-- 
    Document   : muestraErrores
    Created on : Apr 22, 2013, 12:32:00 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList"%>
<%
    List<ConstraintViolation> errores = (List<ConstraintViolation>) request.getAttribute("errores");
    if(errores==null) errores = new ArrayList<ConstraintViolation>();
        if(!errores.isEmpty()){
    %>
    <!-- muestra errores -->
    <div class="row">
            <div class="large-centered large-8 columns alert-box alert" style="background-color:pink;color:black;">
                <% for(int i=0; i<errores.size();i++){
                    out.println("<p>"+errores.get(i).getMessage()+"<//p>");
                   } %>
            </div>  
    </div>  
    <!-- termina muestra errores -->

            
        
     <% } %>
