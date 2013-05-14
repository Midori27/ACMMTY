<%-- 
    Document   : eventos
    Created on : May 3, 2013, 1:31:15 AM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Evento"%>
<%
    Evento[] eventos = (Evento[]) request.getAttribute("eventos");
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
    <!-- Eventos -->
    <div class="row">
            <div class="large-10 large-centered columns">
                    <h2>Eventos</h2>
            </div>
    </div>
    <div class="row">
                    <div class="large-10 large-centered columns panel">
                            <ul class="large-block-grid-3">
                                    <%  for(int i=0;i<eventos.length;i++){ %>
                                    <li>	
                                            <h3 class="subheader text-center"><%=eventos[i].getNombre()%></h3>
                                            <a class="th radius" href="VerEvento?id=<%=eventos[i].getId()%>">
                                                    <img style="height:200px;width:250px;"src="ImagenServidor/<%=eventos[i].getImagen()%>" />
                                            </a>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum.</p>
                                            <center><a class="button" href="VerEvento?id=<%=eventos[i].getId()%>">Ver</a></center>
                                    </li>
                                    <%  }  %>
                            </ul>
                    </div>
    </div>
<%@include file="/WEB-INF/Includes/footer.jsp" %>
