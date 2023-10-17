<%--
    sk_nyuukin.js.jsp - 入金入力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.sknyuukin.SkNyuukinConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.sknyuukin.SkNyuukinSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sknyuukin.sknyuukin.SkNyuukinUiBean" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<% SkNyuukinUiBean uiBean = SWAKInjector.getInstance(SkNyuukinUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
        $(<%= RSGAKU_KIHONINFO %>).parent().addClass("alignRight");
  <% } %>

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

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
     <% if (!BizUtil.isBlank(uiBean.getWarnmessage())) { %>
         var index = 0
          $('#messages tr').each(function(){
          var message = $(this).children('td').text();
             if (message == '<%= uiBean.getWarnmessage()%>') {
               index = index + 1;
             }
        });
         if (index == 0) {
           $('#messages').append('<tr><td class="messagesIcon"><img src="'+ '<%= request.getContextPath() %>/img/message/Message_Warning.png" /></td><td class="messagesItem"><span class="error_message">' +
           '<%= uiBean.getWarnmessage()%>' + '</span></td></tr>');
         }
     <% } %>
     <% if (!BizUtil.isBlank(uiBean.getKakuninmessage())) { %>
         var index = 0
          $('#messages tr').each(function(){
          var message = $(this).children('td').text();
             if (message == '<%= uiBean.getKakuninmessage()%>') {
               index = index + 1;
             }
        });
         if (index == 0) {
           $('#messages').append('<tr><td class="messagesIcon"><img src="'+ '<%= request.getContextPath() %>/img/message/Message_Inquiry.png" /></td><td class="messagesItem"><span class="error_message">' +
           '<%= uiBean.getKakuninmessage()%>' + '</span></td></tr>');
         }
     <% } %>
  <% } %>
});
//-->
</script>
