<%--
    bz_srch_dairiten.js.jsp - 代理店検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchdairiten.BzSrchDairitenConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchdairiten.BzSrchDairitenSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzkensaku.bzsrchdairiten.BzSrchDairitenUiBean"%>
<% BzSrchDairitenUiBean uiBean = SWAKInjector.getInstance(BzSrchDairitenUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  showList(<%=SEARCHRESULTS%>);

});
//-->
</script>
