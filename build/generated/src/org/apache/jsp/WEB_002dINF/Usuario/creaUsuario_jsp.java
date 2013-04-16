package org.apache.jsp.WEB_002dINF.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class creaUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"CreaUsuario\" method=\"post\">\n");
      out.write("            <label>Nombre</label><input class=\"textbox\" type=\"text\" name=\"nombre\"  id=\"nombre\"/><br />\n");
      out.write("            <label>Apellido Paterno</label><input class=\"textbox\" type=\"text\" name=\"apellidoP\"  id=\"apellidoP\"/><br />\n");
      out.write("            <label>Apellido Materno</label><input class=\"textbox\" type=\"text\" name=\"apellidoM\"  id=\"apellidoM\"/><br />\n");
      out.write("            <label>Fecha de Nacimiento</label>\n");
      out.write("            <input type=\"date\" class=\"textbox\" name=\"fechaNacimiento\" id=\"fechaNacimiento\" value=\"mm-dd-aaaa\"><br /><br />\n");
      out.write("            <label>Telefono</label><input class=\"textbox\" type=\"text\" name=\"telefono\"  id=\"telefono\"/><br />\n");
      out.write("            <label>Ciudad</label><select class=\"textbox\" type=\"text\" name=\"ciudad\"  id=\"ciudad\"/>\n");
      out.write("              <option value=\"nada\">Selecciona</option>\n");
      out.write("              <option value=\"Monterrey\">Monterrey</option>\n");
      out.write("              <option value=\"Monclova\">Monclova</option>\n");
      out.write("            </select><br /><br />\n");
      out.write("            <label>Estado</label><select class=\"textbox\" type=\"text\" name=\"estado\"  id=\"estado\"/>\n");
      out.write("              <option value=\"nada\">Selecciona</option>\n");
      out.write("              <option value=\"Monterrey\">Nuevo Léon</option>\n");
      out.write("              <option value=\"Monclova\">Coahuila</option>\n");
      out.write("            </select><br /><br />\n");
      out.write("            <label>Universidad</label><select class=\"textbox\" type=\"text\" name=\"universidad\"  id=\"universidad\"/>\n");
      out.write("              <option value=\"nada\">Selecciona</option>\n");
      out.write("              <option value=\"ITESM\">ITESM</option>\n");
      out.write("              <option value=\"UDEM\">UDEM</option>\n");
      out.write("            </select><br /><br />\n");
      out.write("            <label>Campus</label><select class=\"textbox\" type=\"text\" name=\"campus\"  id=\"campus\"/>\n");
      out.write("              <option value=\"nada\">Selecciona</option>\n");
      out.write("              <option value=\"Monterrey\">MTY</option>\n");
      out.write("              <option value=\"Coahuila\">COAH</option>\n");
      out.write("            </select><br /><br />\n");
      out.write("            <label>Carrera</label><select class=\"textbox\" type=\"text\" name=\"carrera\"  id=\"carrera\"/>\n");
      out.write("              <option value=\"nada\">Selecciona</option>\n");
      out.write("              <option value=\"ITC\">ITC</option>\n");
      out.write("              <option value=\"ITE\">ITE</option>\n");
      out.write("            </select><br /><br />\n");
      out.write("            <label>Mátricula</label><input class=\"textbox\" type=\"text\" name=\"matricula\"  id=\"matricula\"/><br />\n");
      out.write("            <label>Nombre de Usuario</label>\n");
      out.write("            <input class=\"textbox\" type=\"text\" name=\"nombreUsuario\"  id=\"nombreUsuario\"/><br /><br />\n");
      out.write("            <label>Email</label><input class=\"textbox\" type=\"text\" name=\"email\"  id=\"email\"/><br />\n");
      out.write("            <label>password</label><input class=\"textbox\" type=\"password\" name=\"password\"  id=\"password\"/><br />\t\t\n");
      out.write("            <label>&nbsp;</label><input class=\"button\" type=\"image\" src=\"images/send.png\" id=\"submit\" value=\"Send Message\" />\t\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
