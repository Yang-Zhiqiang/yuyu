<%--
    sk_seikyuusyo_sakusei.js.jsp - 新契約請求書作成 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei.SkSeikyuusyoSakuseiConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei.SkSeikyuusyoSakuseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei.SkSeikyuusyoSakuseiUiBean" %>
<% SkSeikyuusyoSakuseiUiBean uiBean = SWAKInjector.getInstance(SkSeikyuusyoSakuseiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    openReport("print", "_blank");
    <% } %>
});
//-->
</script>
