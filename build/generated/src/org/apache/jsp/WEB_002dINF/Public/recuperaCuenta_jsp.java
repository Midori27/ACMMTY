package org.apache.jsp.WEB_002dINF.Public;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Servlet.Login;
import Controlador.Query;
import Modelo.Usuario;

public final class recuperaCuenta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/Includes/navegacion.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    String mensaje = (String) request.getAttribute("mensaje");
    if(mensaje==null){
        mensaje="";
    }
    
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("\t<!-- Fonts de google -->\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Numans' rel='stylesheet' type='text/css'/>\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>\n");
      out.write("\t\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("\t<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("\t<title>ACM MTY</title>\n");
      out.write("\t<meta name=\"Description\" content=\"ACMMTY\"\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/scrollto.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/scrollto.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/contact_form.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<!-- Barra fija -->\n");
      out.write("\t<div id=\"topbar\">\n");
      out.write("\t\t<!-- Logo ACM -->\n");
      out.write("\t\t<img src=\"images/logo.png\" class=\"logo\" alt=\"ACM MTY\" />\n");
      out.write("\t\t\n");
      out.write("\t\t");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"navigation\">\n");
      out.write("\t\t  <ul>\n");
      out.write("\t\t\t<li><a href=\"index.jsp\" >Inicio</a></li>\n");
      out.write("\t\t\t<li><a href=\"eventos.jsp\" title=\"Eventos\">Eventos</a></li>\n");
      out.write("\t\t\t<li><a href=\"contact.jsp\" title=\"Contacto\">Contacto</a></li>\n");
      out.write("\t\t\t<li><a href=\"nosotros.jsp\" title=\"Acerca\">Acerca de Nosotros</a></li>\n");
      out.write("                        ");
 
                            HttpSession se = request.getSession();
                            Usuario u = (Usuario) se.getAttribute(Usuario.NOMBRE_TABLA);
                            if(u == null){
                         
      out.write("\n");
      out.write("                        <li><a href=\"login.jsp\" title=\"Ingresa\">Login</a></li>\n");
      out.write("                        <li><a href=\"registro.jsp\" title=\"Registro\">Registrate</a></li>\n");
      out.write("                        ");
 }else {
                             if(u.getTipo()==0){
                            
      out.write("\n");
      out.write("                        <li><a href=\"cuenta.jsp\" title=\"Cuenta\">");
      out.print(u.getNombreUsuario());
      out.write("</a></li>\n");
      out.write("                        <li><form id=\"form\" action=\"logout\" method=\"post\" style=\"display:inline;\"><input type=\"submit\" value=\"Logout\" style=\"display:inline;\"></form></li>\n");
      out.write("                        <li><a href=\"listaEventos.jsp\" title=\"listaEventos\">Listado eventos</a></li>\n");
      out.write("                        <li><a href=\"nuevoEvento.jsp\" title=\"nuevoEvento\">Nuevo evento</a></li>\n");
      out.write("                        ");
}else{
      out.write("\n");
      out.write("                        <li><a href=\"cuenta.jsp\" title=\"Cuenta\">");
      out.print(u.getNombreUsuario());
      out.write("</a></li>\n");
      out.write("                        <li><form id=\"form\" action=\"logout\" method=\"post\" style=\"display:inline;\"><input type=\"submit\" value=\"Logout\" style=\"display:inline;\"></form></li>\n");
      out.write("                        ");
}}
      out.write("\n");
      out.write("                  </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<!--Contenido -->\n");
      out.write("\t\t<div id=\"contentInside\">\t\n");
      out.write("                    <h3>Recuperaci&oacute;n de cuenta.</h3>\n");
      out.write("                    <form action=\"RecuperacionCuenta\" method=\"post\">\n");
      out.write("                        <h4>¿Qu&eacute; olvidaste?</h4>\n");
      out.write("                        <input id=\"campoPassword\" type=\"radio\" name=\"campo\" value=\"password\" checked=\"checked\" />\n");
      out.write("                        <label for=\"campoPassword\">Contrase&ntilde;a</label><br></br>\n");
      out.write("                        <input id=\"campoUsuario\"type=\"radio\" name=\"campo\" value=\"usuario\" />\n");
      out.write("                        <label for=\"campoUsuario\">Usuario</label><br></br>\n");
      out.write("                        <h4>Introduce tu e-mail</h4>\n");
      out.write("                        <input id=\"email\" type=\"text\" placeholder=\"Tu E-Mail\" name=\"email\"></input>\n");
      out.write("                        <label for=\"email\">E-Mail</label><br></br>\n");
      out.write("                        <h3 style=\"color:red;\">");
      out.print(mensaje);
      out.write("</h3>\n");
      out.write("                        <input type=\"submit\" value=\"Continuar\"></input>\n");
      out.write("                    </form>\n");
      out.write("\t\t\t\t<div id=\"footer\">\n");
      out.write("\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\tACM MTY 2013\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- END CONTENT -->\n");
      out.write("\t\t<div id=\"clearer\"></div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<!-- END CONTAINER -->\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
