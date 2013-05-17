<%-- 
    Document   : creaPeriodo
    Created on : May 17, 2013, 2:54:36 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
        <%@include file="/WEB-INF/Includes/alerta.jsp"%>
        <!-- forma crear Periodo -->
	<div class="row">
		<div class="large-8 large-centered columns">
			<form action="CreaPeriodo" method="post">
				<fieldset>
					<legend>Nuevo Periodo</legend>
                                        <div class="row">
                                            <div class="large-12 columns">
                                                <label>Mes de inicio</label>
                                                    <select name="mInicio">
                                                          <option selected="selected" value="Ene">Enero</option>
                                                          <option value="Ago">Agosto</option>
                                                    </select>
                                                <label>Año inicio</label>
                                                <input type="number" name="aInicio" min="2000" max="2100">
                                                <label>Mes final</label>
                                                    <select name="mFin">
                                                          <option selected="selected" value="May">Mayo</option>
                                                          <option value="Dic">Diciembre</option>
                                                    </select>
                                                <label>Año final</label>
                                                <input type="number" name="aFin" min="2000" max="2100">
                                            </div>
                                        </div>
                                        <div class="row">
                                             <div class="large-offset-9 columns">
                                                 <input type="submit" class="small button" value="Crea periodo">
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
