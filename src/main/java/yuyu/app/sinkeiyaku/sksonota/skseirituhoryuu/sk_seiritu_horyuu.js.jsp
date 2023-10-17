<%--
    sk_seiritu_horyuu.js.jsp - 成立保留処理 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksonota.skseirituhoryuu.SkSeirituHoryuuConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksonota.skseirituhoryuu.SkSeirituHoryuuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sksonota.skseirituhoryuu.SkSeirituHoryuuUiBean" %>
<% SkSeirituHoryuuUiBean uiBean = SWAKInjector.getInstance(SkSeirituHoryuuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
 <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
   String[] hubiMsgs = uiBean.getHubimsgData();
   String msgId = "";
   if (hubiMsgs != null && hubiMsgs.length != 0 && hubiMsgs[0].length() != 0) {
     String[] hubiMsg = hubiMsgs[0].split(" ");
     msgId = hubiMsg[1];
   }
  %>
  changeErrMsg('<%= msgId %>');
 <% } %>

});
//-->
</script>
