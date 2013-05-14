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
    Evento[] eventos = (Evento[]) request.getAttribute(Evento.NOMBRE_TABLA);
%>
<%@include file="/WEB-INF/Includes/header.jsp"%>
    <!-- slider -->
    <div class="row">
            <div class="large-12 columns">
                    <ul  data-orbit data-options="timer-speed:1000; bullets:false;">
                            <% for(int i=0; i<noticias.length && i<4;i++){ %>
                            <li>
                                    <img style="width:960px;height:400px;" src="ImagenServidor/<%=noticias[i].getImagen()%>" />
                                    <div class="orbit-caption"><%=noticias[i].getTitulo()%></div>
                            </li>
                            <% } %>
                    </ul>
            </div>
    </div>
    <!-- termina slider -->
    
    <!-- Eventos -->
    <div class="row">
            <div class="large-12 columns">
                    <h2>Eventos</h2>
            </div>
    </div>
    <div class="row">
        <div class="large-12 columns">
            <ul class="large-block-grid-3 panel">
                <% for(int i=0; i<eventos.length && i<9;i++){ %>
                <li>
                    <h3 class="subheader"><%=eventos[i].getNombre()%></h3>
                    <img style="height:200px;width:250px;" src="ImagenServidor/<%=eventos[i].getImagen()%>"></img>
                    <p><%=eventos[i].getDescripcion()%></p>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
    <!-- termina eventos -->
<%@include file="/WEB-INF/Includes/footer.jsp"%>
