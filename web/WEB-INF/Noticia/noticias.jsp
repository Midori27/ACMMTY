<%-- 
    Document   : noticia
    Created on : May 2, 2013, 1:15:59 PM
    Author     : juanjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Modelo.Noticia"%>
<%
    Noticia[] noticias = (Noticia[]) request.getAttribute("noticias");
    if(noticias==null) noticias = new Noticia[0];
%>
<%@include file="/WEB-INF/Includes/header.jsp" %>
    <!-- Noticias -->
    <div class="row">
            <div class="large-10 large-centered columns">
                    <h2>Noticias</h2>
            </div>
    </div>
    <% if(noticias.length==0){ %>
    <div class="row panel">
        <div class="large-10 large-centered columns">
            <p>Actualmente no hay contenido en esta sección.</p>
        </div>
    </div>
    <% }else{ %>
    <div class="row">
                    <div class="large-10 large-centered columns panel">
                            <ul class="large-block-grid-3">
                                    <%  for(int i=0;i<noticias.length;i++){ %>
                                    <li>	
                                            <h3 class="subheader text-center"><%=noticias[i].getTitulo()%></h3>
                                            <a class="th radius" href="VerNoticia?id=<%=noticias[i].getId()%>">
                                                    <img style="height:200px;width:250px;"src="ImagenServidor/<%=noticias[i].getImagen()%>" />
                                            </a>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum.</p>
                                            <center><a class="button" href="VerNoticia?id=<%=noticias[i].getId()%>">Ver</a></center>
                                    </li>
                                    <%  }  %>
                            </ul>
                    </div>
    </div>
    <% } %>
<%@include file="/WEB-INF/Includes/footer.jsp" %>
