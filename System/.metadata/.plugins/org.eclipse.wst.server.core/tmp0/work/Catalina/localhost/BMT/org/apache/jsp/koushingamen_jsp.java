/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-05-13 09:24:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class koushingamen_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/koushingamen.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.10.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" language=\"JavaScript\" src=\"js/bookmaster.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"addload()\">\r\n");
      out.write("\t<form action=\"Koushingamen\" method=\"post\" id=\"addupdate\" name=\"addupdate\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<b id=\"title\">本マスタ更新</b><input type=\"button\" value=\"戻る\" id=\"return\" name=\"return\"  onclick=\"gobackpage()\"><br> <br> \r\n");
      out.write("\t\t\t<b>本ID：</b><br>\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"text_input_id\" disabled=\"disabled\" readonly=\"readonly\" value=\"");
      out.print((request.getAttribute("bookid")));
      out.write("\" /><br>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" id=\"id\" value=\"");
      out.print((request.getAttribute("bookid")));
      out.write("\" /> \r\n");
      out.write("\t\t\t<b>本タイトル：</b><br>\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"text_input_title\" name=\"title\" value=\"");
      out.print((request.getAttribute("booktitle")));
      out.write("\" maxlength=\"40\" /><br> \r\n");
      out.write("\t\t\t<b>著者名：</b><br>\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"text_input_author\" name=\"author\" value=\"");
      out.print((request.getAttribute("authorname")));
      out.write("\" maxlength=\"40\"/><br> \r\n");
      out.write("\t\t\t<b>出版社：</b><br>\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"text_input_publisher\" name=\"publisher\" value=\"");
      out.print((request.getAttribute("publisher")));
      out.write("\" maxlength=\"40\"/><br> \r\n");
      out.write("\t\t\t<b>出版年月日:</b><br>\r\n");
      out.write("\t\t\t<select id=\"year_input\" name=\"year\">\r\n");
      out.write("\t\t\t\t<option></option>\r\n");
      out.write("\t\t\t</select>年 \r\n");
      out.write("\t\t\t<select id=\"month_input\" name=\"month\">\r\n");
      out.write("\t\t\t\t<option></option>\r\n");
      out.write("\t\t\t</select>月\r\n");
      out.write("\t\t\t <select id=\"date_input\" name=\"day\">\r\n");
      out.write("\t\t\t\t<option></option>\r\n");
      out.write("\t\t\t</select>日<br>\r\n");
      out.write("\t\t\t <input type=\"hidden\" id=\"day_id\" value=\"");
      out.print(request.getAttribute("day"));
      out.write("\"></input> \r\n");
      out.write("\t\t\t <input type=\"hidden\" id=\"year_id\" value=\"");
      out.print(request.getAttribute("year"));
      out.write("\"></input>\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"month_id\" value=\"");
      out.print(request.getAttribute("month"));
      out.write("\"></input> \r\n");
      out.write("\t\t\t<b>在庫数:</b><br>\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"text_input_zaiko\" name=\"zaiko\" value=\"");
      out.print((request.getAttribute("stock")));
      out.write("\" /><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"追加\"  id=\"add\" onclick=\"addvalue()\"> \r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"更新\"  id=\"update\" onclick=\"updatevalue()\" /> \r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"削除\"  id=\"delete\" onclick=\"deletevalue()\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"action\" name=\"action\" value=\"");
      out.print(request.getAttribute("action"));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"searchid\" name=\"searchid\" value=\"");
      out.print((request.getAttribute("searchid")));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"searchtitle\" name=\"searchtitle\" value=\"");
      out.print((request.getAttribute("searchtitle")));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"searchauthor\" name=\"searchauthor\" value=\"");
      out.print((request.getAttribute("searchauthor")));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"searchpulisher\" name=\"searchpulisher\" value=\"");
      out.print((request.getAttribute("searchpulisher")));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"searchpulication_dayin\" name=\"searchpulication_dayin\" value=\"");
      out.print((request.getAttribute("searchpulication_dayin")));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"searchpulication_dayout\" name=\"searchpulication_dayout\" value=\"");
      out.print((request.getAttribute("searchpulication_dayout")));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"searchcheckbox\" name=\"searchcheckbox\" value=\"");
      out.print((request.getAttribute("searchcheckbox")));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"completemessage\" name=\"completemessage\" value=\"");
      out.print(request.getAttribute("completemessage") );
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"bookupdatecount\" name=\"bookupdatecount\" value=\"");
      out.print(request.getAttribute("bookupdatecount"));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"stockupdatecount\" name=\"stockupdatecount\" value=\"");
      out.print(request.getAttribute("stockupdatecount"));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"existvalue\" name=\"existvalue\" value=\"");
      out.print(request.getAttribute("existvalue"));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"servererrormessage\" name=\"servererrormessage\" value=\"");
      out.print(request.getAttribute("servererrormessage"));
      out.write("\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</form>\r\n");
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
