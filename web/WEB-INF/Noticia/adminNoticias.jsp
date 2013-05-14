<%-- 
    Document   : adminNoticias
    Created on : Apr 17, 2013, 11:55:08 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia noticias[] = (Noticia[]) request.getAttribute("noticias");
    if (noticias==null)noticias = new Noticia[0];
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
        <!-- titulo de la seccion -->
        <div class="row">
            <div class="large-8 large-centered columns">
                <h3>Administrar noticias</h3>
            </div>
        </div>
        <!-- boton para crear una nueva noticia -->
        <div class="row">
            <div class="large-8 large-centered columns text-center">
                <a href="CreaNoticia" style="width:100%;margin-bottom: 0;" class="small button success">Crea una nueva noticia</a>
            </div>
        </div>
        <% for(int i=0; i<noticias.length;i++){%>
            <!-- empieza admin noticia -->
            <div class="row">
                    <div class="large-8 large-centered columns">
                            <div class="row panel">
                                    <div class="large-4 columns">
                                            <img src="ImagenServidor/<%=noticias[i].getImagen()%>" />
                                    </div>
                                    <div class="large-8 columns" >
                                            <div class="row">
                                                    <div class="large-12 columns text-center">
                                                            <h4 class="subheader"><%=noticias[i].getTitulo()%></h4>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="large-12 columns text-center">
                                                            <div class="row">
                                                                    <div class="large-6 columns">
                                                                            <a href="ActualizaNoticia?id=<%=noticias[i].getId()%>" class="small button">Actualiza</a>
                                                                    </div>
                                                                    <div class="large-6 columns">
                                                                            <a href="BorraNoticia?id=<%=noticias[i].getId()%>" class="small alert button">Borra</a>
                                                                    </div>
                                                            </div>
                                                    </div>
                                            </div>
                                    </div>
                            </div>
                    </div>
            </div>
        <%}%>
<%@include file="/WEB-INF/Includes/footer.jsp" %>