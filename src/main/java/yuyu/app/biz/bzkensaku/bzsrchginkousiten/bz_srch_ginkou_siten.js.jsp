<%--
    bz_srch_ginkou_siten.js.jsp - 銀行支店検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchginkousiten.BzSrchGinkouSitenConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchginkousiten.BzSrchGinkouSitenSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzkensaku.bzsrchginkousiten.BzSrchGinkouSitenUiBean"%>
<% BzSrchGinkouSitenUiBean uiBean = SWAKInjector.getInstance(BzSrchGinkouSitenUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  showList(<%=SEARCHRESULTS%>);

});
//-->
</script>
