/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-08-09 00:43:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/Menu.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/Menu.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.10.1.min.js\"></script>\r\n");
      out.write("<title>メニュー</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"menuload()\">\r\n");
      out.write("<form action=\"MenuController\" method=\"post\" id=\"menu\" name=\"menu\">\r\n");
      out.write("\t\t\t<abbr title=\"ログアウト\"> <a id=\"modoru\" href=\"Login.jsp\"><img\r\n");
      out.write("\t\t\t\t\tid=\"modoru\" src=\"css/picture/tan.png\"\r\n");
      out.write("\t\t\t\t\tonmouseover=\"src ='css/picture/tan2.png'\"\r\n");
      out.write("\t\t\t\t\tonmouseout=\"src ='css/picture/tan.png'\"></a>\r\n");
      out.write("\t\t\t</abbr>\r\n");
      out.write("<div id=\"screen\">\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td id=\"kotobabtn\"><a href=\"Vocabulary.jsp\" id=\"kotoba\">言葉</a></td>\r\n");
      out.write("<td rowspan=\"4\" id=\"info\">\r\n");
      out.write("<p id=\"title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("<p>\r\n");
      out.write("<p id=\"news\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${news}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("<p id=\"honyakupan\" style=\"display: none;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${honyakupan}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("<a href=\"#\" id=\"honyaku\" onclick=\"honyaku()\">翻訳...</a><br>\r\n");
      out.write("\r\n");
      out.write("<a href=\"#\" id=\"honnpan\" onclick=\"honpan()\" style=\"display: none;\">本版...</a>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td id=\"kanjibtn\"><a href=\"Kanji.jsp\" id=\"kanji\">漢字</a></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td id=\"bunpobtn\"><a href=\"Grammar.jsp\" id=\"bunpo\">文法</a></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td id=\"choukaibtn\"><a href=\"TestTraining.jsp\" id=\"choukai\">試験訓練</a></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<input type=\"hidden\" id=\"actionVal\" name=\"actionVal\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${actionVal}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
