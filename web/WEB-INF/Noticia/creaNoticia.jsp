<%-- 
    Document   : creaNoticia.jsp
    Created on : Apr 17, 2013, 11:53:56 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia, net.sf.oval.ConstraintViolation, java.util.List, java.util.ArrayList"%>
<%
    Noticia noticia = (Noticia) request.getAttribute("noticia");
    if(noticia==null) noticia=new Noticia();
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
        <%@include file="/WEB-INF/Includes/muestraErrores.jsp"%>
        <!-- forma crear noticia -->
	<div class="row">
		<div class="large-8 large-centered columns">
			<form action="CreaNoticia" method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>Crear Noticia</legend>
                                        <div class="row">
                                            <div class="large-12 columns">
                                                <label>Titulo</label>
                                                <input type="text" name="titulo" placeholder="Titulo de la noticia" value="<%=noticia.getTitulo()%>">
                                                <label>Descripcion</label>
                                                <textarea style="height:300px;" rows="50" name="descripcion" placeholder="El desarrollo de la noticia"><%=noticia.getDescripcion()%></textarea>
                                                <label>Imagen</label>
                                                <input type="file" name="imagen">
                                                <img src="ImagenServidor/<%=noticia.getImagen()%>" height="150" width="150">
                                                <input type="hidden" name="imagenSubida" value="<%=noticia.getImagen()%>">
                                                
                                            </div>
                                        </div>
                                        <div class="row">
                                             <div class="large-offset-9 columns">
                                                 <input type="submit" class="small button" value="Crea noticia">
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