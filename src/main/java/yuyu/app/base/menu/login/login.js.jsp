<%--
    login.js.jsp - ログイン JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page import="static yuyu.app.base.menu.login.LoginConstants.*"%>
<%@page import="static yuyu.app.base.menu.login.LoginSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.base.menu.login.LoginUiBean"%>
<% LoginUiBean uiBean = SWAKInjector.getInstance(LoginUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  $(<%=REQUIREDMARK%>).visible(false);

  $(<%=SOSIKICD + LABEL%>).removeClass('label required');

  $(<%=SOSIKICD + LABEL%>).attr('style','float:right;');

  $(<%=TANMATUSETTISOSIKICD_LOGININPUT + LABEL%>)[0].innerText = $(<%=TANMATUSETTISOSIKICD_LOGININPUT + LABEL%>)[0].innerText + " :";
});
//-->
</script>
