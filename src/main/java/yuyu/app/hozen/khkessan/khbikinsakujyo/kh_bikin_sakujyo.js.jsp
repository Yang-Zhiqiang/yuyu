<%--
    kh_bikin_sakujyo.js.jsp - 契約保全備金削除 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khkessan.khbikinsakujyo.KhBikinSakujyoConstants.*" %>
<%@page import="static yuyu.app.hozen.khkessan.khbikinsakujyo.KhBikinSakujyoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khkessan.khbikinsakujyo.KhBikinSakujyoUiBean" %>
<%@page import="yuyu.def.classification.C_BknsyoriKbn"%>
<% KhBikinSakujyoUiBean uiBean = SWAKInjector.getInstance(KhBikinSakujyoUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

    <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
        || uiBean.getPageNo() == PAGENO_CONFIRM
        || uiBean.getPageNo() == PAGENO_RESULT) { %>
        <%
        if (C_BknsyoriKbn.TORIKESI.eq(uiBean.getBknsyorikbn())) { %>

            showKoumoku(<%= BKNRIGIKBN_BIKININFO%>);
        <% } %>
    <% } %>
});
//-->
</script>
