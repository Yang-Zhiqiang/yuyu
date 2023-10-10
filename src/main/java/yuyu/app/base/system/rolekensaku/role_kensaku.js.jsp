<%--
    role_kensaku.js.jsp - ロール検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.rolekensaku.RoleKensakuConstants.*"%>
<%@page
	import="static yuyu.app.base.system.rolekensaku.RoleKensakuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.base.system.rolekensaku.RoleKensakuUiBean"%>
<% RoleKensakuUiBean uiBean = SWAKInjector.getInstance(RoleKensakuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  if ($(<%= ROLEINFO %>)[0].rows.length <= 1) {
    $(<%= ROLEINFO + DIV %>).visible(false);
  }
});

//-->
</script>