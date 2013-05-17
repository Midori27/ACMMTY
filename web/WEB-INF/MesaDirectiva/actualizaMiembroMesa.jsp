<%-- 
    Document   : actualizaMiembroMesa
    Created on : Apr 15, 2013, 11:58:11 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.MiembroMesa" %>
<%
    MiembroMesa miembro = (MiembroMesa) request.getAttribute("miembro");
    if(miembro==null) response.sendRedirect("AdminMesaDirectiva");
    Integer idPeriodo = miembro.getIdPeriodo();
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
<%@include file="/WEB-INF/Includes/errores.jsp"%>
        <!-- forma actualizar miembro mesa -->
	<div class="row">
		<div class="large-8 large-centered columns">
			<form action="ActualizaMiembroMesa" method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>Actualizar Miembro Mesa</legend>
                                        <div class="row">
                                            <div class="large-12 columns">
                                                <input type="hidden" name="id" value="<%=miembro.getId()%>">
                                                <label>Nombre</label>
                                                <input type="text" name="nombre" placeholder="El nombre completo" value="<%=miembro.getNombre()%>">
                                                <label>Posicion</label>
                                                <input type="text" name="posicion" placeholder="El puesto que ocupa" value="<%=miembro.getPosicion()%>">
                                                <label>Foto</label>
                                                <input type="file" name="foto">
                                                <img src="ImagenServidor/<%=miembro.getFoto()%>" height="150" width="150">
                                                <input type="hidden" name="fotoSubida" value="<%=miembro.getFoto()%>">
                                                <input type="hidden" name="idPeriodo" value="<%=idPeriodo%>">
                                            </div>
                                        </div>
                                        <div class="row">
                                             <div class="large-offset-9 columns">
                                                 <input type="submit" class="small button" value="Actualiza miembro">
                                            </div>
                                        </div>
                                </fieldset>
                        </form>
                </div>
        </div>
        <div class="row">
            <div class="large-8 large-centered columns text-center">
                <a class="small button secondary" href="AdminMesaDirectiva">Regresa a administrar mesa directiva</a>
            </div>
        </div>
<%@include file="/WEB-INF/Includes/footer.jsp" %>