<%--
    si_sibou_kari_uketuke.js.jsp - 死亡仮受付 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.simouside.sisiboukariuketuke.SiSibouKariUketukeConstants.*" %>
<%@page import="static yuyu.app.siharai.simouside.sisiboukariuketuke.SiSibouKariUketukeSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.simouside.sisiboukariuketuke.SiSibouKariUketukeUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_SibouKariUketukeSyoriKbn" %>
<% SiSibouKariUketukeUiBean uiBean = SWAKInjector.getInstance(SiSibouKariUketukeUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>
<% commonViewInBean.setCommonViewUiBeanParam(uiBean); %>

<%
 if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM
       || uiBean.getPageNo() == PAGENO_RESULT) {%>
   <%
      if (!uiBean.isSiTtzkRirekiSyoukaiHyoujiFlg()) { %>
       <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewuketorininsb/view_uketorinin_sb.js.jsp"/>
       <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewbetukyk/view_betukyk.js.jsp"/>
 <% } %>
<%}%>
<script type="text/javascript">
$(function(){

<%
   if (uiBean.getPageNo() == PAGENO_INPUTKEY) {%>
     $(<%= MOUSIDEINFO + DIV %>).css("margin-top", "-1px");
 <% }%>

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
   <%
      if (C_SibouKariUketukeSyoriKbn.TORIKESI.eq(uiBean.getSiboukariuketukesyorikbn())) { %>
          $(<%= SIBOUYMD_MOUSIDEINFO %>).disable(true);
          $(<%= GENINKBN_MOUSIDEINFO %>).disable(true);
   <% } %>
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM) {%>
   <%
     if (uiBean.isSiTtzkRirekiSyoukaiHyoujiFlg()) { %>
     $(<%= KEIYAKUSYAINFO + DIV %>).visible(false);
     $(<%= HIHOKENSYAINFO + DIV %>).visible(false);
  <% } %>
<% } %>


<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
   <%
     if (uiBean.isSiTtzkRirekiSyoukaiHyoujiFlg()) { %>
      $(<%= FOOTERBUTTONS3 + DIV %>).visible(false);
      $(<%= FUNCTIONNAMELINK %>).text('<%= uiBean.getKinouNm() %>');
      $(<%= FUNCTIONNAMELINK %>).attr("disabled", "true");
      $(<%= FUNCTIONNAMELINK %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');
      $(<%= TOJIRUBTN_HEADERBUTTONS %>).visible(false);
    <%
       } else  { %>
        $(<%= TOJIRUBTNBYPOPUP_HEADERBUTTONS %>).visible(false);
    <%}%>
<%}%>

});
</script>
