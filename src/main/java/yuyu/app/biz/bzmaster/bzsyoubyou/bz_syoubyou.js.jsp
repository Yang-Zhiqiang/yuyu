<%--
    bz_syoubyou.js.jsp - 傷病登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzmaster.bzsyoubyou.BzSyoubyouConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzmaster.bzsyoubyou.BzSyoubyouSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.biz.bzmaster.bzsyoubyou.BzSyoubyouUiBean"%>
<% BzSyoubyouUiBean uiBean = SWAKInjector.getInstance(BzSyoubyouUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    var pankuzuText = '';

    <% if (uiBean.getGmsyorikbn() ==E_SyoriKbn.NEW) { %>
        pankuzuText = '<%=PANKUZU_NEW%>';
    <% } else if (uiBean.getGmsyorikbn() == E_SyoriKbn.UPD) { %>
        pankuzuText = '<%=PANKUZU_UPD%>';
    <% } else if (uiBean.getGmsyorikbn() == E_SyoriKbn.DEL) { %>
        pankuzuText = '<%=PANKUZU_DEL%>';
    <% } %>
    $(<%= IBA0001 %>).text(pankuzuText);

  <% } %>

});
//-->
</script>
