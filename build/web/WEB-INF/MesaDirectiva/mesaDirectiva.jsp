<%-- 
    Document   : mesaDirectiva
    Created on : May 3, 2013, 4:54:55 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.MiembroMesa, Helper.ParPeriodoMiembros"%>
<%
    ParPeriodoMiembros[] pm = (ParPeriodoMiembros[]) request.getAttribute("paresPeriodoMiembros");
    if(pm==null) pm = new ParPeriodoMiembros[0];
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
<div class="row panel">
    <h3>Nuestra misión:</h3>
    <div class="large-10 large-centered columns">
        <img src="img/icpc.jpg" />
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?</p>
    </div>
</div>
            <div class="row">
		<div class="large-10 large-centered columns">
                    <% if(pm.length>0) out.println("<h3>El equipo:</h3>");%>
			<div class="section-container vertical-tabs" data-section="vertical-tabs">
                            <% for(int i=0; i<pm.length;i++){ %>
                                <section>
					<p class="title" data-section-title><a href="#"><%=pm[i].getP().toString()%></a></p>
					<div class="content" data-section-content>
						<ul class="large-block-grid-3">
                                                    <% for(int j=0;j<pm[i].getMiembros().length;j++){ %>
                                                            <li class="text-center">
                                                                    <h6><%=pm[i].getMiembros()[j].getPosicion()%></h6>
                                                                    <img style="width:250px;height:200px;" src="ImagenServidor/<%=pm[i].getMiembros()[j].getFoto()%>" />
                                                                    <h6 class="subheader"><%=pm[i].getMiembros()[j].getNombre()%></h6>
                                                            </li>
                                                    <% } %>
						</ul>
					</div>
				</section>
                            <% } %> 
			</div>
		</div>
            </div>
<%@include file="/WEB-INF/Includes/footer.jsp" %>