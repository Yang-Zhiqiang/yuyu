<%--
    user_group_kensaku.js.jsp - ユーザーグループ検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.usergroupkensaku.UserGroupKensakuConstants.*"%>
<%@page
	import="static yuyu.app.base.system.usergroupkensaku.UserGroupKensakuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.system.usergroupkensaku.UserGroupKensakuUiBean"%>
<% UserGroupKensakuUiBean uiBean = SWAKInjector.getInstance(UserGroupKensakuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  if ($(<%= USERGROUPINFO %>)[0].rows.length <= 1) {
    $(<%= USERGROUPINFO + DIV %>).visible(false);
  }
});
//-->
</script>
