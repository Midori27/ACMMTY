<%-- 
    Document   : verNoticia
    Created on : May 1, 2013, 11:42:41 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento, Modelo.Comentario" %>
<%
    Evento evento = (Evento) request.getAttribute(Evento.NOMBRE_TABLA);
   
 %>
 <%@include file="/WEB-INF/Includes/header.jsp" %>   
    <!-- Evento -->
	<div class="row">
		<div class="large-10 large-centered columns">
			<div class="row">
				<div class="large-12 columns">
					<h2><%=evento.getNombre()%></h2>
				</div>
			</div>
			<div class="row">
				<div class="large-12 columns panel text-center">
					<img src="ImagenServidor/<%=evento.getImagen()%>" />
				</div>
			</div>
			<div class="row">
				<div class="large-12 columns">
					<ul class="large-block-grid-3 text-center">
                                            <li class="panel"><i class="icon-calendar icon-large"></i> <%=evento.getFechaString()%></li>
						<li class="panel"><i class="icon-map-marker icon-large"></i> <%=evento.getLugar()%></li>
						<li class="panel"><i class="icon-group icon-large"></i>Equipos de <%=evento.getMaxIntegrantesEquipo()%> max</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="large-12 columns panel">
					<p><%=evento.getDescripcion()%></p>
				</div>
			</div>
		</div>
	</div>
        <%@include file="/WEB-INF/Includes/comentariosEvento.jsp"%>
        <div class="row">
            <div class="large-10 large-centered columns">
                <form action="CreaComentarioEvento" method="post">
                    <fieldset>
                        <legend>Deja tu comentario:</legend>
                        <div class="row">
                            <div class="large-12 columns">
                                <label>Comentario</label>
                                <textarea style="height:20px;" name="descripcion" placeholder="Tu comentario" rows="5"></textarea>
                                <input type="hidden" name="id" value="<%=evento.getId()%>">
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-offset-9 columns">
                                <input type="submit" class="small button" value="Comentar">
                           </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
               
<%@include file="/WEB-INF/Includes/footer.jsp" %>