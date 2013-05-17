<%-- 
    Document   : comentariosEvento
    Created on : May 3, 2013, 5:38:23 PM
    Author     : juanjo
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Comentario"%>
<%
    Usuario user = (Usuario) request.getSession().getAttribute(Usuario.NOMBRE_TABLA);
    Integer idComentador = (user!=null) ? user.getId() : -1;
    Integer tipoU = (user!=null) ? user.getTipo() : -1;
    Comentario[] comentarios = (Comentario[]) request.getAttribute(Comentario.NOMBRE_TABLA_EVENTO);
    if(comentarios != null){
            for(int i =0; i<comentarios.length;i++){ %>
            <div class="row">
                <div class="large-10 large-centered columns">
                    <div class="row panel">
                        <div class="large-12 columns">
                            <% if(idComentador == comentarios[i].getIdUsuario() || tipoU == 0){ %>
                                <a class="tiny button alert right" href="BorraComentarioEvento?idComentario=<%=comentarios[i].getId()%>&idPadre=<%=comentarios[i].getIdPadre()%>">X</a>
                            <% } %>
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
 