<%-- 
    Document   : comentariosNoticia
    Created on : May 3, 2013, 5:38:13 PM
    Author     : juanjo
--%>

<%@page import="Modelo.Comentario"%>
<%
    Comentario[] comentarios = (Comentario[]) request.getAttribute(Comentario.NOMBRE_TABLA_NOTICIA);
    if(comentarios != null){
            for(int i =0; i<comentarios.length;i++){ %>
            <div class="row">
                <div class="large-10 large-centered columns">
                    <div class="row panel">
                        <div class="large-12 columns">
                            <p>
                                <i class="icon-user icon-2x"></i><strong><%=" "+comentarios[i].getNombreUsuario()+":"%></strong>
                                <%=comentarios[i].getDescripcion()%>
                            </p>
                            <h6 class="subheader right"><%=comentarios[i].getFecha().toString()%></h6>
                        </div>
                    </div>
                </div>
            </div>
               <% 
            }
     }
    
    %>
