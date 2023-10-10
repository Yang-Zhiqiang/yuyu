<%--
    kh_koujyosyoumei_saihakkou.js.jsp - 控除証明書再発行 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou.KhKoujyosyoumeiSaihakkouConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou.KhKoujyosyoumeiSaihakkouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou.KhKoujyosyoumeiSaihakkouUiBean" %>
<%@page import="yuyu.def.classification.C_Hrkkaisuu" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_KoujyosyoumeimsgKbn" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<% KhKoujyosyoumeiSaihakkouUiBean uiBean = SWAKInjector.getInstance(KhKoujyosyoumeiSaihakkouUiBean.class); %>

<%
   CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
   commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<% if (
    uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM ||
    uiBean.getPageNo() == PAGENO_RESULT ) { %>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp" />
<% } %>

<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT ) { %>
    $(<%=KOUJYOSYOUMEISYOOUTKBN_TYHYOUTKBNINFO%>).addClass("alignMessageCell");

    <% if (C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK.eq(uiBean.getKoujyosyoumeimsgKbn())) { %>
          $(<%=DISPNEWIPPANNENKANP_NENKANINFO%>).text('<%= ASTERISK %>');
          $(<%=DISPNEWIPPANNENKANHTKIN_NENKANINFO%>).text('<%= ASTERISK %>');
          $(<%=DISPNEWIPPANNENKANSYMGK_NENKANINFO%>).text('<%= ASTERISK %>');
          $(<%=DISPNEWIRYOUNENKANP_NENKANINFO%>).text('<%= ASTERISK %>');
          $(<%=DISPNEWIRYOUNENKANHTKIN_NENKANINFO%>).text('<%= ASTERISK %>');
          $(<%=DISPNEWIRYOUNENKANSYMGK_NENKANINFO%>).text('<%= ASTERISK %>');
          $(<%=DISPNEWNKNENKANP_NENKANINFO%>).text('<%= ASTERISK %>');
          $(<%=DISPNEWNKNENKANHTKIN_NENKANINFO%>).text('<%= ASTERISK %>');
          $(<%=DISPNEWNKNENKANSYMGK_NENKANINFO%>).text('<%= ASTERISK %>');
    <% } %>
  <% } %>
  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>

     <% if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
          openReport("print", "_blank");
     <% } %>
  <% } %>
});
//-->
</script>
