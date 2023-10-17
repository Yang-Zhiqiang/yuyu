<%--
    kh_nyuukin_torikesi.js.jsp - 入金取消 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khnyuukintorikesi.KhNyuukinTorikesiConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khnyuukintorikesi.KhNyuukinTorikesiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khansyuu.khnyuukintorikesi.KhNyuukinTorikesiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<% KhNyuukinTorikesiUiBean uiBean = SWAKInjector.getInstance(KhNyuukinTorikesiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);%>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtokusin/view_tokusin.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp"/>
<% } %>
<script type="text/javascript">
$(function(){
<%
  if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
    $(<%= NYUUKINTORIKESISYORIINFO + DIV%>).css("margin-top","-1px");
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    $(<%= JYUTOUKAISUUY_NYUUKINJISSEKIINFO_UNIT%>).addClass("rightMargin");

    <%
    if (uiBean.getJyutoukaisuuy() != null && uiBean.getJyutoukaisuuy() != 0) { %>
        $(<%= JYUTOUKAISUUY_NYUUKINJISSEKIINFO%>).parent().visible(true);
        $(<%= JYUTOUKAISUUY_NYUUKINJISSEKIINFO_UNIT%>).parent().visible(true);
        $(<%= JYUTOUKAISUUM_NYUUKINJISSEKIINFO%>).visible(false);
        $(<%= JYUTOUKAISUUM_NYUUKINJISSEKIINFO_UNIT%>).visible(false);
    <% }
    else { %>
        $(<%= JYUTOUKAISUUY_NYUUKINJISSEKIINFO%>).visible(false);
        $(<%= JYUTOUKAISUUY_NYUUKINJISSEKIINFO_UNIT%>).visible(false);
        $(<%= JYUTOUKAISUUM_NYUUKINJISSEKIINFO%>).parent().visible(true);
        $(<%= JYUTOUKAISUUM_NYUUKINJISSEKIINFO_UNIT%>).parent().visible(true);
    <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    openReport('print', '_blank');
<% } %>
});
</script>
