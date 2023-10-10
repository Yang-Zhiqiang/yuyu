<%--
    sk_hubi_msg.js.jsp - 不備メッセージ JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgUiBean" %>
<% SkHubiMsgUiBean uiBean = SWAKInjector.getInstance(SkHubiMsgUiBean.class); %>
<script type="text/javascript"><!--

  function dispMessageIcon(msgId, target) {
      if($(msgId).text().substring(0, 1) == "I") {
        $(target).parent().addClass("infIcon");

      } else if($(msgId).text().substring(0, 1) == "W") {
        $(target).parent().addClass("warIcon");

      } else if($(msgId).text().substring(0, 1) == "E") {
        if($(msgId).text().substring(2, 3) == "V") {
            $(target).parent().addClass("valIcon");

        } else {
            $(target).parent().addClass("errIcon");
        }

      } else if($(msgId).text().substring(0, 1) == "T") {
        $(target).parent().addClass("tokuninIcon");

      } else if($(msgId).text().substring(0, 1) == "K") {
        $(target).parent().addClass("tokuninkanouIcon");

      } else if($(msgId).text().substring(0, 1) == "Q") {
        $(target).parent().addClass("inqIcon");
      }
  }

$(function(){

  showList(<%= KETTEIHORYUUHUBI %>);
  showList(<%= SEIRITUHORYUUHUBI %>);
  showList(<%= WARNING %>);
  showList(<%= KIHONHUBI %>);

  <% if(uiBean.getKetteiHoryuuHubiDataSource() != null){ %>
    <% for(int i = 0; i < uiBean.getKetteiHoryuuHubiDataSource().getAllData().size(); i++ ){ %>
      dispMessageIcon(<%= DISPHUBIMSGID_KETTEIHORYUUHUBI(i) %>, <%= MSGSYUBETU_KETTEIHORYUUHUBI(i) %>);
    <% } %>
  <% } %>
  <% if(uiBean.getSeirituHoryuuHubiDataSource() != null){ %>
    <% for(int i = 0; i < uiBean.getSeirituHoryuuHubiDataSource().getAllData().size(); i++ ){ %>
      dispMessageIcon(<%= DISPHUBIMSGID_SEIRITUHORYUUHUBI(i) %>, <%= MSGSYUBETU_SEIRITUHORYUUHUBI(i) %>);
    <% } %>
  <% } %>
  <% if(uiBean.getWarningDataSource() != null){ %>
    <% for(int i = 0; i < uiBean.getWarningDataSource().getAllData().size(); i++ ){ %>
      dispMessageIcon(<%= DISPHUBIMSGID_WARNING(i) %>, <%= MSGSYUBETU_WARNING(i) %>);
    <% } %>
  <% } %>
  <% if(uiBean.getKihonHubiDataSource() != null){ %>
    <% for(int i = 0; i < uiBean.getKihonHubiDataSource().getAllData().size(); i++ ){ %>
      dispMessageIcon(<%= DISPHUBIMSGID_KIHONHUBI(i) %>, <%= MSGSYUBETU_KIHONHUBI(i) %>);
    <% } %>
  <% } %>
});
//-->
</script>
