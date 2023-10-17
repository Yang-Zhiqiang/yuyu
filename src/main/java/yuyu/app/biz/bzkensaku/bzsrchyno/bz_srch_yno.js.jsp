<%--
    bz_srch_yno.js.jsp - 郵便番号検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchyno.BzSrchYnoConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkensaku.bzsrchyno.BzSrchYnoSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.biz.bzkensaku.bzsrchyno.BzSrchYnoUiBean"%>
<% BzSrchYnoUiBean uiBean = SWAKInjector.getInstance(BzSrchYnoUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  showList(<%=SEARCHRESULT%>);
});
//-->
</script>
