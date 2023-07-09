package org.apache.jsp.WEB_002dINF.classes.yuyu.app.hozen.khozen.khmkhgkhenkou;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*;
import static yuyu.app.hozen.khozen.khmkhgkhenkou.KhMkhgkHenkouConstants.*;
import static yuyu.app.hozen.khozen.khmkhgkhenkou.KhMkhgkHenkouSelector.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.hozen.khozen.khmkhgkhenkou.KhMkhgkHenkouUiBean;
import yuyu.def.classification.C_HyoujiptnKbn;
import yuyu.common.biz.bzview.CommonViewInBean;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;

public final class kh_005fmkhgk_005fhenkou_js_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 KhMkhgkHenkouUiBean uiBean = SWAKInjector.getInstance(KhMkhgkHenkouUiBean.class); 
      out.write('\r');
      out.write('\n');
 KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
      out.write('\r');
      out.write('\n');
 CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);

      out.write("\r\n");
      out.write("\r\n");
 if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||uiBean.getPageNo() == PAGENO_REFERENCE ||
    uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT ||
    uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { 
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp", out, false);
      out.write('\r');
      out.write('\n');
 } 
      out.write('\r');
      out.write('\n');
 if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||uiBean.getPageNo() == PAGENO_REFERENCE ||
    uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { 
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp", out, false);
      out.write('\r');
      out.write('\n');
 } 
      out.write('\r');
      out.write('\n');
 if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { 
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp", out, false);
      out.write('\r');
      out.write('\n');
 } else { 
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
             !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { 
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp", out, false);
      out.write("\r\n");
      out.write("      ");
 } 
      out.write('\r');
      out.write('\n');
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("$(function(){\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
 if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||  uiBean.getPageNo() == PAGENO_REFERENCE ||
         uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("             ");
      out.write("\r\n");
      out.write("             $(");
      out.print( KOUTEIINFO + DIV);
      out.write(").visible(false);\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
 if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { 
      out.write("\r\n");
      out.write("       ");
      out.write("\r\n");
      out.write("       ");
 if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print( MKHGKHENKOUINFO);
      out.write(");\r\n");
      out.write("           showGroup(");
      out.print( MKHGKINFO);
      out.write(");\r\n");
      out.write("       ");
      out.write("\r\n");
      out.write("       ");
 } else { 
      out.write("\r\n");
      out.write("          ");
      out.write("\r\n");
      out.write("          ");
 if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { 
      out.write("\r\n");
      out.write("               showGroup(");
      out.print( MKHGKHENKOUINFO);
      out.write(");\r\n");
      out.write("               showGroup(");
      out.print( MKHGKINFO);
      out.write(");\r\n");
      out.write("               inputToOutput(");
      out.print( SYORUIUKEYMD_SPAN);
      out.write(");\r\n");
      out.write("               inputToOutput(");
      out.print( TARGETTKMKHTKBN_MKHGKINFO);
      out.write(");\r\n");
      out.write("          ");
 }
          }
       } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
 if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
          uiBean.getPageNo() == PAGENO_RESULT) { 
      out.write("\r\n");
      out.write("       ");
      out.write("\r\n");
      out.write("       ");
 if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
 if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { 
      out.write("\r\n");
      out.write("               showGroup(");
      out.print( MKHGKHENKOUINFO);
      out.write(");\r\n");
      out.write("               showGroup(");
      out.print( MKHGKINFO);
      out.write(");\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("       ");
      out.write("\r\n");
      out.write("       ");
 } else { 
      out.write("\r\n");
      out.write("            showGroup(");
      out.print( MKHGKHENKOUINFO);
      out.write(");\r\n");
      out.write("            showGroup(");
      out.print( MKHGKINFO);
      out.write(");\r\n");
      out.write("       ");
 } 
      out.write("\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
 if (uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { 
      out.write("\r\n");
      out.write("            showGroup(");
      out.print( MKHGKHENKOUINFO);
      out.write(");\r\n");
      out.write("            showGroup(");
      out.print( MKHGKINFO);
      out.write(");\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
 if (uiBean.getPageNo() == PAGENO_REFERENCE) { 
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("           $(");
      out.print(SKSSAKUSEIBTN_BUTTONSYOUKAI);
      out.write(").visible(true);\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print(HONNINKAKUNIN);
      out.write(");\r\n");
      out.write("           showGroup(");
      out.print(HASSOUKUBUN);
      out.write(");\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
             !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print(HONNINKAKUNIN);
      out.write(");\r\n");
      out.write("           showGroup(");
      out.print(HASSOUKUBUN);
      out.write(");\r\n");
      out.write("           inputToOutput(");
      out.print(HONNINKAKNINKEKKAKBN_HONNINKAKUNIN);
      out.write(");\r\n");
      out.write("           inputToOutput(");
      out.print(HASSOUKBN_HASSOUKUBUN);
      out.write(");\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print(KEKKAINPUTGROUP);
      out.write(");\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 } else if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print(KEKKAINPUTGROUP);
      out.write(");\r\n");
      out.write("           showKoumoku(");
      out.print(SASIMODOSISAKIKBN_KEKKAINPUTGROUP);
      out.write(");\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if(!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("           $(");
      out.print(KAKUNINBTN_FOOTERBUTTONS);
      out.write(").visible(true);\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
 if (uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
           if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print(HONNINKAKUNIN);
      out.write(");\r\n");
      out.write("           showGroup(");
      out.print(HASSOUKUBUN);
      out.write(");\r\n");
      out.write("           ");
 } 
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 } else { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print(HONNINKAKUNIN);
      out.write(");\r\n");
      out.write("           showGroup(");
      out.print(HASSOUKUBUN);
      out.write(");\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print(KEKKAINPUTGROUP);
      out.write(");\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
 } else if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { 
      out.write("\r\n");
      out.write("           showGroup(");
      out.print(KEKKAINPUTGROUP);
      out.write(");\r\n");
      out.write("           showKoumoku(");
      out.print(SASIMODOSISAKIKBN_KEKKAINPUTGROUP);
      out.write(");\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  ");
 if (uiBean.getPageNo() == PAGENO_SKSRESULT) { 
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        openReport(\"print\", \"_blank\");\r\n");
      out.write("  ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("//-->\r\n");
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
