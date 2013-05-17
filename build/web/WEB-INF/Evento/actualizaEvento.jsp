<%-- 
    Document   : actualizaEvento
    Created on : Apr 16, 2013, 5:35:29 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento, Servlet.Evento.AdminEventos, net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList" %>
<%
    Evento evento = (Evento) request.getAttribute("evento");
    if(evento==null) response.sendRedirect("/AdminEventos");
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
        <%@include file="/WEB-INF/Includes/errores.jsp"%>
        <div class="row">
            <div class="large-8 large-centered columns">
                <form action="ActualizaEvento" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Actualizar Evento</legend>
                        <div class="row">
                            <div class="large-12 columns">
                                <div class="row">
                                    <div class="large-6 columns">
                                        <input type="hidden" name="id" value="<%=evento.getId()%>"
                                        <label>Nombre</label>
                                        <input type="text" name="nombre" placeholder="Nombre del evento" value="<%=evento.getNombre()%>">
                                    </div>
                                    <div class="large-6 columns">
                                        <label>Fecha</label>
                                        <input type="text" name="fecha" placeholder="aaaa-mm-dd" value="<%=evento.getFechaString()%>"> 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12 columns">
                                <div class="row">
                                    <div class="large-6 columns">
                                        <label>Lugar</label>
                                        <input type="text" name="lugar" placeholder="Lugar del evento" value="<%=evento.getLugar()%>">
                                    </div>
                                    <div class="large-6 columns">
                                        <label>Integrantes por equipo</label>
                                        <input type="text" name="integrantesPorEquipo" placeholder="# maximo de integrantes por equipo" value="<%=evento.getMaxIntegrantesEquipo()%>"> 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12 columns">
                                <label>Descripcion</label>
                                <textarea style="height:300px;" rows="50" name="descripcion" placeholder="La descripcion del evento"><%=evento.getDescripcion()%></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-12 columns">
                                <div class="row">
                                    <div class="large-6 columns">
                                        <label>Imagen</label>
                                        <input type="file" name="imagen">
                                    </div>
                                    <div class="large-6 columns">
                                        <img src="ImagenServidor/<%=evento.getImagen()%>" height="150" width="150">
                                        <input type="hidden" name="imagenSubida" value="<%=evento.getImagen()%>">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-offset-9 columns">
                                <input type="submit" class="small button" value="Actualiza evento">
                           </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="large-8 large-centered columns text-center">
                <a class="small button secondary" href="AdminEventos">Regresa a administrar eventos</a>
            </div>
        </div>
<%@include file="/WEB-INF/Includes/footer.jsp" %>
