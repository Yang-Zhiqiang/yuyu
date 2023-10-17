<%--
    sk_toujitu_nyuukin_torikesi.js.jsp - 当日入金取消 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi.SkToujituNyuukinTorikesiConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi.SkToujituNyuukinTorikesiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi.SkToujituNyuukinTorikesiUiBean" %>
<% SkToujituNyuukinTorikesiUiBean uiBean = SWAKInjector.getInstance(SkToujituNyuukinTorikesiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
      <%
        String[] hubiMsgs = uiBean.getHubiMsgDatas();
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
