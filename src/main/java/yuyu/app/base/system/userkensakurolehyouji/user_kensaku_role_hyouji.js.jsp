<%--
    user_kensaku_role_hyouji.js.jsp - ユーザー検索（ロール表示用） JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static yuyu.app.base.system.userkensakurolehyouji.UserKensakuRoleHyoujiSelector.*"%>
<%@page
	import="static yuyu.app.base.system.userkensakurolehyouji.UserKensakuRoleHyoujiConstants.*"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.userkensakurolehyouji.UserKensakuRoleHyoujiConstants.*"%>
<%@page
	import="static yuyu.app.base.system.userkensakurolehyouji.UserKensakuRoleHyoujiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.system.userkensakurolehyouji.UserKensakuRoleHyoujiUiBean"%>
<% UserKensakuRoleHyoujiUiBean uiBean = SWAKInjector.getInstance(UserKensakuRoleHyoujiUiBean.class); %>
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

  if ($(<%= USERANDUSERROLEINFO %>)[0].rows.length <= 1) {
    $(<%= USERANDUSERROLEINFO + DIV %>).visible(false);
  }
});
//-->
</script>
