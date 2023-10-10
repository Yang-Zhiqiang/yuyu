<%--
    kh_nyuukin_syoukai.js.jsp - 入金照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khnyuukinsyoukai.KhNyuukinSyoukaiConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khnyuukinsyoukai.KhNyuukinSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khansyuu.khnyuukinsyoukai.KhNyuukinSyoukaiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_NyksyoukaiKbn" %>
<% KhNyuukinSyoukaiUiBean uiBean = SWAKInjector.getInstance(KhNyuukinSyoukaiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<% if (uiBean.getPageNo() != PAGENO_INPUTKEY) { %>
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

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ) { %>
     showGroup(<%=NYUUKINSYOUKAIINFO%>);
     showKoumoku(<%=JYUTOUKAISUUY_NYUUKINSYOUKAIINFO%>);
     $(<%=RSYYMD_NYUUKINSYOUKAIINFO + SPAN%>).parent().removeClass('c').addClass('c1').attr("colSpan","3");
<% } %>
<%
   if (uiBean.getPageNo() == PAGENO_RESULT) { %>
     showGroup(<%=NYUUKINSYOUKAIINFO%>);
     showKoumoku(<%=JYUTOUKAISUUY_NYUUKINSYOUKAIINFO%>);
     showKoumoku(<%=HRKKIGENYMD_NYUUKINSYOUKAIINFO%>);

     showGroup(<%=RESULTINFO%>);

     <%
        if (C_NyksyoukaiKbn.ZENNOUNYUUKINNSISAN.eq(uiBean.getNyksyoukaikbn())) { %>
          showKoumoku(<%=ANNAISAIKAIYM_RESULTINFO%>);
     <% } %>

     <%
        if (C_UmuKbn.ARI.eq(uiBean.getKeisanprstuukaknsnumn())) { %>
          showGroup(<%=RESULTINFONORYOSYUJIKWSRATE%>);
     <% } %>
<% } %>
});
//-->
</script>
