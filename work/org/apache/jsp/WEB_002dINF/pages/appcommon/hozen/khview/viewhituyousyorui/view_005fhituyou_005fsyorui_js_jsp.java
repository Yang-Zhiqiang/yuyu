package org.apache.jsp.WEB_002dINF.pages.appcommon.hozen.khview.viewhituyousyorui;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*;
import static yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiSelector.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzview.CommonViewInBean;
import yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiUiBeanParam;
import yuyu.common.biz.bzcommon.BizUtil;

public final class view_005fhituyou_005fsyorui_js_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/javascript; charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); 
      out.write("\r\n");
      out.write("\r\n");

   ViewHituyouSyoruiUiBeanParam viewHituyouSyoruiUiBean = (ViewHituyouSyoruiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\r\n");
      out.write("  ");

    if (!BizUtil.isBlank(viewHituyouSyoruiUiBean.getVhtysdisphtysyorui())) {
  
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    showGroup(");
      out.print(HITUYOUSYORUIINFO);
      out.write(");\r\n");
      out.write("\r\n");
      out.write("    $(");
      out.print(VHTYSDISPHTYSYORUI_HITUYOUSYORUIINFO);
      out.write(").html('");
      out.print(viewHituyouSyoruiUiBean.getVhtysdisphtysyorui());
      out.write("');\r\n");
      out.write("\r\n");
      out.write("  ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
