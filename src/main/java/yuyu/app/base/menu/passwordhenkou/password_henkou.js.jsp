<%--
    password_henkou.js.jsp - パスワード変更 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.menu.passwordhenkou.PasswordHenkouConstants.*"%>
<%@page
	import="static yuyu.app.base.menu.passwordhenkou.PasswordHenkouSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.base.menu.passwordhenkou.PasswordHenkouUiBean"%>
<% PasswordHenkouUiBean uiBean = SWAKInjector.getInstance(PasswordHenkouUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

    <% if (uiBean.getPageNo() == PAGENO_INIT) {%>
    <%     if (!uiBean.getPasswordHenkouKyokaFlg()) {%>
               $(<%= PASSWORDINPUT %>).visible(false);
               $(<%= BUTTONINPUTCONTENTS %>).visible(false);
        <%
        }
        %>
    <%
    }
    %>

});
//-->
</script>
