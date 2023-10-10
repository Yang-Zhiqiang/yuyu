<%--
    bz_srch_syoubyou.js.jsp - 傷病検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchsyoubyou.BzSrchSyoubyouConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchsyoubyou.BzSrchSyoubyouSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzkensaku.bzsrchsyoubyou.BzSrchSyoubyouUiBean"%>
<% BzSrchSyoubyouUiBean uiBean = SWAKInjector.getInstance(BzSrchSyoubyouUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

    showList(<%=SEARCHRESULTS%>);
});
//-->
</script>
