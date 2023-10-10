<%--
    kh_dairiten_info_syuusei.js.jsp - 代理店情報修正 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khdairiteninfosyuusei.KhDairitenInfoSyuuseiConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khdairiteninfosyuusei.KhDairitenInfoSyuuseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khdairiteninfosyuusei.KhDairitenInfoSyuuseiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="jp.co.slcs.swak.number.BizNumber"%>
<% KhDairitenInfoSyuuseiUiBean uiBean = SWAKInjector.getInstance(KhDairitenInfoSyuuseiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
 <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <% if (BizNumber.ZERO.equals(uiBean.getBunwari1())) { %>
      $(<%=BUNWARI1_ADAIRIINFO%>).visible(false);
      $(<%=BUNWARI1_ADAIRIINFO_UNIT%>).visible(false);
    <% } %>

    <% if (BizNumber.ZERO.equals(uiBean.getBunwari2())) { %>
      $(<%=BUNWARI2_BDAIRIINFO%>).visible(false);
      $(<%=BUNWARI2_BDAIRIINFO_UNIT%>).visible(false);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (BizNumber.ZERO.equals(uiBean.getBunwari1())) { %>
      $(<%=BUNWARI1_ADAIRIINFO%>).visible(false);
      $(<%=BUNWARI1_ADAIRIINFO_UNIT%>).visible(false);
    <% } %>

    <% if (BizNumber.ZERO.equals(uiBean.getBunwari2())) { %>
      $(<%=BUNWARI2_BDAIRIINFO%>).visible(false);
      $(<%=BUNWARI2_BDAIRIINFO_UNIT%>).visible(false);
    <% } %>

    <% if (BizNumber.ZERO.equals(uiBean.getBunwari3())) { %>
      $(<%=BUNWARI3_ADAIRIINFO2%>).visible(false);
      $(<%=BUNWARI3_ADAIRIINFO2_UNIT%>).visible(false);
    <% } %>

    <% if (BizNumber.ZERO.equals(uiBean.getBunwari4())) { %>
      $(<%=BUNWARI4_BDAIRIINFO2%>).visible(false);
      $(<%=BUNWARI4_BDAIRIINFO2_UNIT%>).visible(false);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CIFCDINPUTCONTENTS || uiBean.getPageNo() == PAGENO_CIFCDCONFIRM ||
      uiBean.getPageNo() == PAGENO_CIFCDRESULT) { %>
    $(<%=HEKOUMAEDAIRITENINFO + LABEL%>).text("●変更前ＣＩＦコード");
    $(<%=HEKOUGODAIRITENINFO + LABEL%>).text("●変更後ＣＩＦコード");
    $(<%=CIFCD1_HEKOUMAEDAIRITENINFO + LABEL%>).parent().parent().append("<td></td>");
    $(<%=CIFCD2_HEKOUGODAIRITENINFO + LABEL%>).parent().parent().append("<td></td>");
  <% } %>
});
//-->
</script>
