<%--
    sk_nyuuryoku_sai_syoukai.js.jsp - 入力差異照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai.SkNyuuryokuSaiSyoukaiConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai.SkNyuuryokuSaiSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai.SkNyuuryokuSaiSyoukaiUiBean" %>
<% SkNyuuryokuSaiSyoukaiUiBean uiBean = SWAKInjector.getInstance(SkNyuuryokuSaiSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  showList(<%= NYUURYOKUSOUILIST %>);
});
//-->
</script>
