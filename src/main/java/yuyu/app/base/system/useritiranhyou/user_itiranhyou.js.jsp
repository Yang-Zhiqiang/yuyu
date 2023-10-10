<%--
    user_itiranhyou.js.jsp - ユーザー一覧表 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.useritiranhyou.UserItiranhyouConstants.*"%>
<%@page
	import="static yuyu.app.base.system.useritiranhyou.UserItiranhyouSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.system.useritiranhyou.UserItiranhyouUiBean"%>
<%@page
	import="yuyu.app.base.system.useritiranhyou.GenUserItiranhyouConstants"%>
<% UserItiranhyouUiBean uiBean = SWAKInjector.getInstance(UserItiranhyouUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

    <% if (uiBean.getPageNo() == GenUserItiranhyouConstants.PAGENO_RESULT) { %>
        openReport("print", "_blank");
    <%
    }
    %>
});
//-->
</script>
