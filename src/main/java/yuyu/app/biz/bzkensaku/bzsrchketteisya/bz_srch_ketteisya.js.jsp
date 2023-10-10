<%--
    bz_srch_ketteisya.js.jsp - 決定者検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchketteisya.BzSrchKetteisyaConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchketteisya.BzSrchKetteisyaSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzkensaku.bzsrchketteisya.BzSrchKetteisyaUiBean"%>
<% BzSrchKetteisyaUiBean uiBean = SWAKInjector.getInstance(BzSrchKetteisyaUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

    showList(<%=SEARCHRESULTS%>);
});
//-->
</script>
