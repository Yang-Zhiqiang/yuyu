<%--
    kh_sakuinnmno_syuusei.js.jsp - 契約保全索引名番号修正 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khnayose.khsakuinnmnosyuusei.KhSakuinnmnoSyuuseiConstants.*" %>
<%@page import="static yuyu.app.hozen.khnayose.khsakuinnmnosyuusei.KhSakuinnmnoSyuuseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khnayose.khsakuinnmnosyuusei.KhSakuinnmnoSyuuseiUiBean" %>
<%@page import="yuyu.def.classification.C_Tdk"%>
<% KhSakuinnmnoSyuuseiUiBean uiBean = SWAKInjector.getInstance(KhSakuinnmnoSyuuseiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

    <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
        || uiBean.getPageNo() == PAGENO_CONFIRM
        || uiBean.getPageNo() == PAGENO_RESULT) { %>
        <%
        if (C_Tdk.HONNIN.eq(uiBean.getItKykKihon().getKykSya().getKkkyktdk())) { %>

            $(<%= TAISYOUDOUITUHYOUJI_INPUTGROUP%>).visible(true);
        <% } %>
    <% } %>
});
//-->
</script>
