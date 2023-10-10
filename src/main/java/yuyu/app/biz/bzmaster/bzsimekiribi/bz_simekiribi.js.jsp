<%--
    bz_simekiribi.js.jsp - 締切日登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzmaster.bzsimekiribi.BzSimekiribiConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzmaster.bzsimekiribi.BzSimekiribiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.app.biz.bzmaster.bzsimekiribi.BzSimekiribiUiBean"%>
<% BzSimekiribiUiBean uiBean = SWAKInjector.getInstance(BzSimekiribiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    var pankuzuText = '';
    <% if (uiBean.getGmsyorikbn() == E_SyoriKbn.ADD) { %>
        pankuzuText = '<%=PANKUZU_ADD%>';
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