<%--
    bz_srch_simekiribi.js.jsp - 締切日検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchsimekiribi.BzSrchSimekiribiConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchsimekiribi.BzSrchSimekiribiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzkensaku.bzsrchsimekiribi.BzSrchSimekiribiUiBean"%>
<% BzSrchSimekiribiUiBean uiBean = SWAKInjector.getInstance(BzSrchSimekiribiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  showList(<%=SEARCHRESULTS%>);

  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });
});
//-->
</script>
