<%-- 
    Document   : comentariosEvento
    Created on : May 3, 2013, 5:38:23 PM
    Author     : juanjo
--%>

<%@page import="Modelo.Comentario"%>
<%
    Comentario[] comentarios = (Comentario[]) request.getAttribute(Comentario.NOMBRE_TABLA_EVENTO);
    if(comentarios != null){
            for(int i =0; i<comentarios.length;i++){
               out.println("<div>"+comentarios[i].getFecha().toString()+" | "+comentarios[i].getNombreUsuario()+": "+comentarios[i].getDescripcion()+"</div>");
            }
     }
    
    %>
 