package org.apache.jsp.WEB_002dINF.pages.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.google.common.base.Strings;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import java.text.SimpleDateFormat;
import java.util.Date;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.web.struts.Constants;
import jp.co.slcs.swak.web.struts.configuration.SWAKStrutsConfig;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.infr.auth.LoginUser;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.common.base.BaseUserInfo;

public final class contents_002dheader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fswak_005fmessages_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fswak_005fmessages_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fswak_005fmessages_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

  SWAKStrutsConfig conf        = SWAKInjector.getInstance(SWAKStrutsConfig.class);
  YuyuBaseConfig   baseConf    = SWAKInjector.getInstance(YuyuBaseConfig.class);
  AS_Kinou         kinou       = SWAKInjector.getInstance(AS_Kinou        .class);
  LoginUser        loginUser   = SWAKInjector.getInstance(LoginUser       .class);
  BizDate          now         = BizDate.getSysDate();
  SeirekiWarekiKbn swKbn       = BizDateConfig.getInstance().getSeirekiWarekiKbn();
  String           format;
  String           dateTimeNotShowSubSystemGroup = baseConf.getDateTimeNotShowSubSystemGroup();

  if      (swKbn.equals(SeirekiWarekiKbn.WAREKI_INPUT) ||
           swKbn.equals(SeirekiWarekiKbn.WAREKI_SYMBOL)) { format = "G yy/MM/dd";  }
  else if (swKbn.equals(SeirekiWarekiKbn.WAREKI_KANJI))  { format = "GG yy/MM/dd"; }
  else                                                   { format = "yyyy/MM/dd";  }
  
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

  boolean isNormalMode = true;
  if (kinou.getSubSystemId().equals("consumer") || kinou.getSubSystemId().equals("directhanbai"))
  {
      isNormalMode = false;
  }


      out.write("\r\n");
      out.write("<div class=\"contentsHeader\">\r\n");
      out.write("  <div class=\"contentsHeaderLeft\"><a class=\"functionName\" id=\"functionName\">");
      out.print( kinou.getKinouNm() );
      out.write("</a></div>\r\n");


  boolean isShowLoginDateTime = true;
  if(dateTimeNotShowSubSystemGroup !=null && dateTimeNotShowSubSystemGroup.length()>0){
      if(dateTimeNotShowSubSystemGroup.indexOf(kinou.getSubSystemId()) != -1){
          isShowLoginDateTime = false;
      }
  }


  if (isShowLoginDateTime) {

      BaseUserInfo userInfo = SWAKInjector.getInstance(BaseUserInfo.class);

      String zenkaiLoginTime = userInfo.getZenkaiLoginTime();

      String operaterMsg = MessageUtil.getMessage(MessageId.IAW0007);

      String datetimeMsg = "";

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d H:mm");

      if("menu".equals(kinou.getCategoryId()))
          if(zenkaiLoginTime == null || zenkaiLoginTime.equals("")){
              zenkaiLoginTime = "";
          }else{
              Date loginDateTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(zenkaiLoginTime);
              zenkaiLoginTime = sdf.format(loginDateTime);
          }
          datetimeMsg = MessageUtil.getMessage(MessageId.IAW0008);
      }else{
          zenkaiLoginTime = BizDate.getSysDateTimeMilli();
          Date loginDateTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(zenkaiLoginTime);
          zenkaiLoginTime = sdf.format(loginDateTime);

          datetimeMsg = MessageUtil.getMessage(MessageId.IAW0009);
      }


      out.write("\r\n");
      out.write("  <div class=\"contentsHeaderRight\">\r\n");
      out.write("    <table>\r\n");
      out.write("      <!-- 操作者 -->\r\n");
      out.write("      <tr><td class=\"alignRight contentsHeaderRightLabel\">");
      out.print( operaterMsg );
      out.write("</td><td>");
      out.print( loginUser.getUserNm() );
      out.write("</td></tr>\r\n");
      out.write("      <!-- 時刻 -->\r\n");
      out.write("      <tr><td class=\"alignRight contentsHeaderRightLabel\">");
      out.print( datetimeMsg );
      out.write("</td><td>");
      out.print( zenkaiLoginTime );
      out.write("</td></tr>\r\n");
      out.write("    </table>\r\n");
      out.write("  </div>\r\n");

  }

      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<hr class=\"contentsHeader\" />\r\n");

  if (isNormalMode) {

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_swak_005fmessages_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

}

      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_swak_005fmessages_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    jp.co.slcs.swak.web.taglib.MessagesTag _jspx_th_swak_005fmessages_005f0 = (jp.co.slcs.swak.web.taglib.MessagesTag) _005fjspx_005ftagPool_005fswak_005fmessages_005fnobody.get(jp.co.slcs.swak.web.taglib.MessagesTag.class);
    _jspx_th_swak_005fmessages_005f0.setPageContext(_jspx_page_context);
    _jspx_th_swak_005fmessages_005f0.setParent(null);
    int _jspx_eval_swak_005fmessages_005f0 = _jspx_th_swak_005fmessages_005f0.doStartTag();
    if (_jspx_th_swak_005fmessages_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fswak_005fmessages_005fnobody.reuse(_jspx_th_swak_005fmessages_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fswak_005fmessages_005fnobody.reuse(_jspx_th_swak_005fmessages_005f0);
    return false;
  }
}
