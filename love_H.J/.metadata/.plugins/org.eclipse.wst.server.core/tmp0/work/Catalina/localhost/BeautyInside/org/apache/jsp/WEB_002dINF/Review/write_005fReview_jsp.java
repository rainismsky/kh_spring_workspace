/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.31
 * Generated at: 2018-10-24 11:25:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.Review;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class write_005fReview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/love_H.J/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BeautyInside/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1540178618364L));
    _jspx_dependants.put("jar:file:/D:/love_H.J/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BeautyInside/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Beauty Inside</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.1.0.min.js\"></script> <!-- 좌측 코드는 자바 스크립트를 쓰기 위해 꼭 필요한 명령 선언 -->\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function (){\r\n");
      out.write("\t$(\"#R_Save\").click(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//var title=document.form.title.value; ==> name속성으로 처리할 경우\r\n");
      out.write("\t\t//var content=document.form.content.value;\r\n");
      out.write("\t\t//var writer=document.form.writer.value;\r\n");
      out.write("\t\t//var rno=$(\"#title\").val();\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar rno=$(\"#rno\").val();\r\n");
      out.write("\t\tvar rcontents=$(\"#rcontents\").val();\r\n");
      out.write("\t\tvar mid=$(\"#mid\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t/* 변수 var a와 var $a의 차이점.\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t ex)var a; : 자바 스크립트 변수. 스트립트만 사용 가능함.\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t ex) var a 는 a.css('backgroundcolor', 'blue') 라는 메소드가 안 먹음.\r\n");
      out.write("        .css 메소드는 jQeury에서만 사용하는 것이므로.\r\n");
      out.write("        var $a 는 jQuery 변수이므로 모든 스크립트 사용이 가능함.\r\n");
      out.write("        .css(), .hide(), .show() 등등\r\n");
      out.write("\t\t \r\n");
      out.write("        *JavaScript\r\n");
      out.write("        var idx = 10;\r\n");
      out.write("        alert(idx);\r\n");
      out.write("        \r\n");
      out.write("        *Jquery\r\n");
      out.write("        var $idx = 20;\r\n");
      out.write("        alert($idx);\r\n");
      out.write("        \r\n");
      out.write("        */\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t/*console.log(\"title --> \"+title);\r\n");
      out.write("\t\tconsole.log(\"rcontent --> \"+rcontent);\r\n");
      out.write("\t\tconsole.log(\"mid --> \"+mid); */\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t if(rno == \"\"){\r\n");
      out.write("\t\t\talert(\"글 번호를 입력 하세요\");\r\n");
      out.write("\t\t\tdocument.form.rno.focus();\r\n");
      out.write("\t\t\treturn false; \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}else if(rcontents == \"\"){\r\n");
      out.write("\t\t\talert(\"내용을 입력 하세요\");\r\n");
      out.write("\t\t\tdocument.form.rcontents.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}else if(mid == \"\"){\r\n");
      out.write("\t\t\talert(\"이름을 입력하세요\");\r\n");
      out.write("\t\t\tdocument.form.mid.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("//폼에 입력한 데이터 서버로 전송!\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write(" <!-- <= 로고를 눌러 메인화면으로 보낼때 쓰면 유용할것 같다 -->\r\n");
      out.write("\r\n");
      out.write("<h1>후기 작성</h1>\r\n");
      out.write("\r\n");
      out.write("<form name=\"form\" method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Review/insert\">\r\n");
      out.write("\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t제목 \r\n");
      out.write("\t\t<input name=\"title\" id=\"title\" size=\"80\" placeholder=\"제목을 입력하세요\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t내용\r\n");
      out.write("\t\t<textarea name=\"content\" id=\"content\" rows=\"4\" cols=\"80\"\r\n");
      out.write("\t\t\tplaceholder=\"내용을 입력 하세요\"></textarea>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t이름 \r\n");
      out.write("\t\t<input name=\"writer\" id=\"writer\" placeholder=\"이름을 입력하세요\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<div style=\"width:800px; text-align:center;\">\r\n");
      out.write("\t\t<button type=\"submit\" id=\"R_Save\">등록</button>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<button type=\"reset\">재 작성</button>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input type=\"button\" value=\"글 목록\"\r\n");
      out.write("       onclick=\"document.location.href='list_Review'\"> <!-- onclick페이지 넘길때 쓴다 -->\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
