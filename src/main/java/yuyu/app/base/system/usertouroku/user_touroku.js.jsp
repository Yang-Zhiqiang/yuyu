<%--
    user_touroku.js.jsp - ユーザー登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.usertouroku.UserTourokuConstants.*"%>
<%@page
	import="static yuyu.app.base.system.usertouroku.UserTourokuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.base.system.usertouroku.UserTourokuUiBean"%>
<% UserTourokuUiBean uiBean = SWAKInjector.getInstance(UserTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
    $(<%= ALLCHECKBTN_CHECKBUTTONS %>).click(function () {
     $("input[class='check']").each(function(){
       this.checked = true;
      });
    });

    $(<%= ALLUNCHECKBTN_CHECKBUTTONS %>).click(function () {
      $("input[class='check']").each(function(){
       this.checked = false;
      });
    });
});
//-->
</script>
