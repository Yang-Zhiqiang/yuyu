<%--
    kh_online_dattai.js.jsp - オンライン脱退処理 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khonlinedattai.KhOnlineDattaiConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khonlinedattai.KhOnlineDattaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khansyuu.khonlinedattai.KhOnlineDattaiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<% KhOnlineDattaiUiBean uiBean = SWAKInjector.getInstance(KhOnlineDattaiUiBean.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
  commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtokusin/view_tokusin.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    var pankuzuText = '';
    <% if (uiBean.getSyorikbn() == E_SyoriKbn.SETTEI) { %>
        pankuzuText = '<%=PANKUZU_SETTEI%>';
    <% } else if (uiBean.getSyorikbn() == E_SyoriKbn.TORIKESI) { %>
        pankuzuText = '<%=PANKUZU_TORIKESI%>';
    <% } %>

    $(<%= IBA0001 %>).text(pankuzuText);

  <% } %>
});
//-->
</script>
