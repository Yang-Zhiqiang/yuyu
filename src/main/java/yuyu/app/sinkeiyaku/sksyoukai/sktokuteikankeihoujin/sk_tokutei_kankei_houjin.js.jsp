<%--
    sk_tokutei_kankei_houjin.js.jsp - 特定関係法人照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin.SkTokuteiKankeiHoujinConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin.SkTokuteiKankeiHoujinSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin.SkTokuteiKankeiHoujinUiBean" %>
<% SkTokuteiKankeiHoujinUiBean uiBean = SWAKInjector.getInstance(SkTokuteiKankeiHoujinUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getKensakuKekkaHyoujiKbn() == KENSAKUKEKKAHYOUJIKBN_HYOUJI) { %>
    showGroup(<%=SEARCHCONDITIONS2%>);
    showList(<%=SEARCHRESULTS%>);
  <% } %>
});
//-->
</script>
