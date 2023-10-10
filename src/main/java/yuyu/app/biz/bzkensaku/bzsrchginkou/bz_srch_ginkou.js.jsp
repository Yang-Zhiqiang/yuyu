<%--
    bz_srch_ginkou.js.jsp - 銀行検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchginkou.BzSrchGinkouConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchginkou.BzSrchGinkouSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.biz.bzkensaku.bzsrchginkou.BzSrchGinkouUiBean"%>
<% BzSrchGinkouUiBean uiBean = SWAKInjector.getInstance(BzSrchGinkouUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  showList(<%=SEARCHRESULTS%>);
});
//-->
</script>
