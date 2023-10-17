<%--
    syori_kensuu_syoukai.js.jsp - 処理件数照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.syorikensuusyoukai.SyoriKensuuSyoukaiConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.syorikensuusyoukai.SyoriKensuuSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.processkanri.syorikensuusyoukai.SyoriKensuuSyoukaiUiBean" %>
<% SyoriKensuuSyoukaiUiBean uiBean = SWAKInjector.getInstance(SyoriKensuuSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

$(<%= SYOUSAILINK + LABEL  %>).text("<%= BLANK %>");

$(<%= SYOUSAILINKTASK + LABEL  %>).text("<%= BLANK %>");

<% if (uiBean.getPageNo() == PAGENO_INIT) { %>
if ($(<%= TASKUSERINFO %>)[0].rows.length <= 1) {
    $(<%= TASKUSERINFO + DIV %>).visible(false);
}
<% } %>


<% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
    $("a").filter(function (index) { return $(this).html() == ""; }).parent().html("<%= SYOUSAI_LINK %>");
<% } %>


<% if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
    $("a").filter(function (index) { return $(this).html() == "<%= BLANK %>"; }).parent().html("<%= SYOUSAI_LINK %>");

    if ($(<%= TASKUSERINFO2 %>)[0].rows.length <= 1) {
         $(<%= TASKUSERINFO2 + DIV %>).visible(false);
    }
<% } %>

<% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (uiBean.getUserId().equals("")) { %>
      <% if (uiBean.getTaskuserInfo3DataSource().getAllData().get(0).getDisptantounm().equals("共用")) { %>
           $(<%= KANRYOKENSUU_TASKUSERINFO3(0) %>).html("<%= BLANK %>");
           $(<%= KANRYOKENSUU_TASKUSERINFO3_UNIT(0) %>).html("<%= BLANK %>");
      <% } %>
    <% } %>
    if ($(<%= TASKUSERINFO3 %>)[0].rows.length <= 1) {
         $(<%= TASKUSERINFO3 + DIV %>).visible(false);
    }
<% } %>


});
//-->
</script>
