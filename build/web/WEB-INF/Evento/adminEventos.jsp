<%-- 
    Document   : adminEventos
    Created on : Apr 16, 2013, 6:05:13 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento"%>
<%
    Evento eventos[] = (Evento[]) request.getAttribute("eventos");
    if (eventos==null) eventos = new Evento[0];
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje==null) mensaje = "";
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
        <!-- titulo de la seccion -->
        <div class="row">
            <div class="large-8 large-centered columns">
                <h3>Administrar eventos</h3>
            </div>
        </div>
        <!-- boton para crear un nuevo evento -->
        <div class="row">
            <div class="large-8 large-centered columns text-center">
                <a href="CreaEvento" style="width:100%;margin-bottom: 0;" class="small button success">Crea un nuevo evento</a>
            </div>
        </div>
        <% for(int i=0; i<eventos.length;i++){%>
            <!-- empieza admin evento -->
            <div class="row">
                    <div class="large-8 large-centered columns">
                            <div class="row panel">
                                    <div class="large-4 columns">
                                            <img src="ImagenServidor/<%=eventos[i].getImagen()%>" />
                                    </div>
                                    <div class="large-8 columns" >
                                            <div class="row">
                                                    <div class="large-12 columns text-center">
                                                            <h4 class="subheader"><%=eventos[i].getNombre()%></h4>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="large-12 columns text-center">
                                                            <div class="row">
                                                                    <div class="large-6 columns">
                                                                            <a href="ActualizaEvento?id=<%=eventos[i].getId()%>" class="small button">Actualiza</a>
                                                                    </div>
                                                                    <div class="large-6 columns">
                                                                            <a href="BorraEvento?id=<%=eventos[i].getId()%>" class="small alert button">Borra</a>
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