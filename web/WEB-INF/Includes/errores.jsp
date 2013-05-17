<%-- 
    Document   : errores
    Created on : May 17, 2013, 6:52:08 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%
    ArrayList<String> errores = (ArrayList<String>) request.getAttribute("errores");
    if(errores==null) errores = new ArrayList<String>();
    String noError = (String) request.getAttribute("noError");
    
    for(int i=0;i<errores.size();i++){
%>
        <div class="row">
            <div class="large-8 large-centered columns">
                <div data-alert class="alert-box alert">
                    <%=errores.get(i)%>
                    <a href="#" class="close">&times;</a>
                </div>
            </div>    
        </div>
                    
 <% } 
    if(noError!= null){
 %>
    <div class="row">
            <div class="large-8 large-centered columns">
                <div data-alert class="alert-box success">
                    <%=noError%>
                    <a href="#" class="close">&times;</a>
                </div>
            </div>    
        </div>
<% } %>