<%--
    ds_sousa_rireki_syoukai.js.jsp - 操作履歴照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.direct.dssyoukai.dssousarirekisyoukai.DsSousaRirekiSyoukaiConstants.*"%>
<%@page
	import="static yuyu.app.direct.dssyoukai.dssousarirekisyoukai.DsSousaRirekiSyoukaiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.direct.dssyoukai.dssousarirekisyoukai.DsSousaRirekiSyoukaiUiBean"%>
<% DsSousaRirekiSyoukaiUiBean uiBean = SWAKInjector.getInstance(DsSousaRirekiSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
        <% if (uiBean.getKensakukekkaDataSource().getAllData().size() > 0) {%>
            showList(<%=KENSAKUKEKKA%>);
        <% }%>

        <% if (uiBean.getSousaRirekiSyousaiInfoHyoujiFlg() == true) {%>
            showList(<%=SOUSARIREKISYOUSAIINFO%>);
        <% }%>

});
//-->
</script>
