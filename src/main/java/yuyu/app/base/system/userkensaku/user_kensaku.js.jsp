<%--
    user_kensaku.js.jsp - ユーザー検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static yuyu.app.base.system.userkensaku.UserKensakuSelector.*"%>
<%@page
	import="static yuyu.app.base.system.userkensaku.UserKensakuConstants.*"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.userkensaku.UserKensakuConstants.*"%>
<%@page
	import="static yuyu.app.base.system.userkensaku.UserKensakuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.base.system.userkensaku.UserKensakuUiBean"%>
<% UserKensakuUiBean uiBean = SWAKInjector.getInstance(UserKensakuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  $(".closeButton").click(
    function() {
      parent.$(<%= DIALOG %>).dialog("close");
    }
  );

  if ($(<%= USERINFO %>)[0].rows.length <= 1) {
    $(<%= USERINFO + DIV %>).visible(false);
  }
});
//-->
</script>