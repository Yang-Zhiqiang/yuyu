<%--
    bz_srch_syokugyou.js.jsp - 職業検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchsyokugyou.BzSrchSyokugyouConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchsyokugyou.BzSrchSyokugyouSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzkensaku.bzsrchsyokugyou.BzSrchSyokugyouUiBean"%>
<% BzSrchSyokugyouUiBean uiBean = SWAKInjector.getInstance(BzSrchSyokugyouUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  showList(<%=SEARCHRESULTS%>);
});
//-->
</script>
