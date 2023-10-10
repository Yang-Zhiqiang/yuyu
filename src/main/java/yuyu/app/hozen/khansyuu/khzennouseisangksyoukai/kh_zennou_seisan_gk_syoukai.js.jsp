<%--
    kh_zennou_seisan_gk_syoukai.js.jsp - 前納精算額照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khzennouseisangksyoukai.KhZennouSeisanGkSyoukaiConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khzennouseisangksyoukai.KhZennouSeisanGkSyoukaiSelector.*"  %>
<%@page import="yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoSelector"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<%@page import="yuyu.app.hozen.khansyuu.khzennouseisangksyoukai.KhZennouSeisanGkSyoukaiUiBean" %>
<% KhZennouSeisanGkSyoukaiUiBean uiBean = SWAKInjector.getInstance(KhZennouSeisanGkSyoukaiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<%
  if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){

<%
if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
  <% if (!uiBean.getHaraimanflag()) { %>
    $(<%= IIA3002Prefix_ZENNOUINFO2 %>).visible(false);
    $(<%= IIA3002_ZENNOUINFO2 %>).visible(false);
    $(<%= IIA3002Suffix_ZENNOUINFO2 %>).visible(false);
  <% } %>
  $(<%=ViewHaraikomiInfoSelector.ZENNOUINFO%> + "Div").visible(false);

  <%
  if (uiBean.getRstuukasyu() != null && !uiBean.getCalcTuukasyu().eq(uiBean.getRstuukasyu())) { %>
    showKoumoku(<%=ZENNOUNYUUKINKGKRSTK_ZENNOUINFO2%>);
    showKoumoku(<%=RYOSYUKWSRATEKJYMD_ZENNOUINFO2%>);
  <% } %>

  <%
  if (!C_Tuukasyu.JPY.eq(uiBean.getCalcTuukasyu())) { %>
    showKoumoku(<%=YENKAZENNOUSEISANKGK_SEISANGKINFO%>);
    showKoumoku(<%=YENKANSANTKYKWSRATEYMD_SEISANGKINFO%>);
  <% } %>
<% } %>
});
//-->
</script>
