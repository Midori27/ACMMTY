<%-- 
    Document   : actualizaNoticia.jsp
    Created on : Apr 17, 2013, 11:54:32 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia noticia = (Noticia) request.getAttribute("noticia");
    if(noticia==null) response.sendRedirect("/AdminNoticias");
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
        <%@include file="/WEB-INF/Includes/errores.jsp"%>
        <!-- forma actualizar noticia -->
	<div class="row">
		<div class="large-8 large-centered columns">
			<form action="ActualizaNoticia" method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>Actualiza Noticia</legend>
                                        <div class="row">
                                            <div class="large-12 columns">
                                                <label>Titulo</label>
                                                <input type="text" name="titulo" placeholder="Titulo de la noticia" value="<%=noticia.getTitulo()%>">
                                                <label>Descripcion</label>
                                                <textarea style="height:300px;" name="descripcion" placeholder="El desarrollo de la noticia" rows="50"><%=noticia.getDescripcion()%></textarea>
                                                <label>Imagen</label>
                                                <input type="file" name="imagen">
                                                <img src="ImagenServidor/<%=noticia.getImagen()%>" height="150" width="150">
                                                <input type="hidden" name="imagenSubida" value="<%=noticia.getImagen()%>">
                                                <input type="hidden" name="id" value="<%=noticia.getId()%>">
                                                
                                            </div>
                                        </div>
                                        <div class="row">
                                             <div class="large-offset-9 columns">
                                                 <input type="submit" class="small button" value="Actualiza noticia">
                                            </div>
                                        </div>
                                </fieldset>
                        </form>
                </div>
        </div>
        <div class="row">
            <div class="large-8 large-centered columns text-center">
                <a class="small button secondary" href="AdminNoticias">Regresa a administrar noticias</a>
            </div>
        </div>
<%@include file="/WEB-INF/Includes/footer.jsp" %>
