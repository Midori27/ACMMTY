<%-- 
    Document   : index
    Created on : May 14, 2013, 1:47:45 AM
    Author     : juanjo
--%>

<%@page import="Modelo.Noticia"%>
<%@page import="Modelo.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Noticia[] noticias = (Noticia[]) request.getAttribute(Noticia.NOMBRE_TABLA);
    if(noticias==null) noticias = new Noticia[0];
%>
<%@include file="/WEB-INF/Includes/header.jsp"%>
    <!-- slider -->
    <div class="row">
            <div class="large-12 columns">
                    <ul  data-orbit data-options="timer-speed:1000; bullets:false;">
                            <% for(int i=0; i<noticias.length && i<4;i++){ %>
                            <li>
                                    <img style="width:970px;height:600px;" src="ImagenServidor/<%=noticias[i].getImagen()%>" />
                                    <div class="orbit-caption"><%=noticias[i].getTitulo()%> <a class="tiny button" href="VerNoticia?id=<%=noticias[i].getId()%>">Ver</a></div>
                            </li>
                            <% } %>
                    </ul>
            </div>
    </div>
    <!-- termina slider -->
    <div class="row">
        <div class="large-12 columns text-center">
            <img style="width:25%;" src="img/acm.png" />
        </div>
    </div>
    
<%@include file="/WEB-INF/Includes/footer.jsp"%>
