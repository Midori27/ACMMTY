<%-- 
    Document   : verNoticia
    Created on : May 1, 2013, 11:42:41 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia, Modelo.Comentario" %>
<%
    Noticia noticia = (Noticia) request.getAttribute(Noticia.NOMBRE_TABLA);
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>   
        <!-- Noticia -->
	<div class="row">
		<div class="large-10 large-centered columns">
			<div class="row">
				<div class="large-12 columns">
					<h2><%=noticia.getTitulo()%></h2>
				</div>
			</div>
			<div class="row">
				<div class="large-12 columns panel text-center">
					<img src="ImagenServidor/<%=noticia.getImagen()%>" />
				</div>
			</div>
			<div class="row">
				<div class="large-12 columns panel">
					<p><%=noticia.getDescripcion()%></p>
				</div>
			</div>
		</div>
	</div>
        <%@include file="/WEB-INF/Includes/comentariosNoticia.jsp"%>
        <div class="row">
            <div class="large-10 large-centered columns">
                <form action="CreaComentarioNoticia" method="post">
                    <fieldset>
                        <legend>Deja tu comentario:</legend>
                        <div class="row">
                            <div class="large-12 columns">
                                <label>Comentario</label>
                                <textarea style="height:20px;" name="descripcion" placeholder="Tu comentario" rows="5"></textarea>
                                <input type="hidden" name="id" value="<%=noticia.getId()%>">
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
        