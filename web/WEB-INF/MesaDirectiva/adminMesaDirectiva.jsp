<%-- 
    Document   : adminMesaDirectiva
    Created on : Apr 15, 2013, 11:35:04 PM
    Author     : juanjo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Helper.ParPeriodoMiembros"%>
<%
    ParPeriodoMiembros[] pm = (ParPeriodoMiembros[]) request.getAttribute("paresPeriodoMiembros");
    if(pm==null) pm = new ParPeriodoMiembros[0];
%>
<%@include file="/WEB-INF/Includes/header.jsp"%>
<!-- titulo de la seccion -->
	<div class="row">
		<div class="large-8 large-centered columns">
		    <h3>Administrar Mesa Directiva</h3>
		</div>
	</div>
	<!-- boton para crear un nuevo periodo -->
	<div class="row">
	    	<div class="large-8 large-centered columns text-center">
		    <a href="CreaPeriodo" style="width:100%;margin-bottom: 0;" class="small button success">Crea un nuevo periodo.</a>
		</div>
	</div>
	<!-- empiezan periodos -->
        <% for(int i=0;i<pm.length;i++){%>
            <div class="row panel">
		<div class="large-10 large-centered columns">
			<div class="row">
				<div class="large-4 columns">
					<h3><%=pm[i].getP().toString()%></h3>
				</div>
				<div class="large-8 columns">
					<a href="CreaMiembroMesa?idPeriodo=<%=pm[i].getP().getId()%>" class="small button success">Nuevo miembro</a>
					<a href="BorraPeriodo?id=<%=pm[i].getP().getId()%>" class="small button alert">Borra periodo</a>
				</div>
			</div>
                        <% for(int j=0; j<pm[i].getMiembros().length;j++){ %>
                            <div class="row">
                                    <div class="large-12 columns">
                                            <hr />
                                            <div class="row">
                                                    <div class="large-4 columns">
                                                            <h6><%=pm[i].getMiembros()[j].getNombre()%></h6>
                                                    </div>
                                                    <div class="large-8 columns">
                                                            <div class="row">
                                                                    <div class="large-6 columns">
                                                                            <a href="ActualizaMiembroMesa?id=<%=pm[i].getMiembros()[j].getId()%>" class="button small">Actualiza</a>
                                                                    </div>
                                                                    <div class="large-6 columns">
                                                                            <a href="BorraMiembroMesa?id=<%=pm[i].getMiembros()[j].getId()%>" class="button small alert">Borra</a>
                                                                    </div>
                                                            </div>
                                                    </div>
                                            </div>
                                    </div>
                            </div>
                        <% } %> 
		</div>
	</div>
        <% } %> 
<%@include file="/WEB-INF/Includes/footer.jsp"%>
