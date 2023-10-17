<%--
    tantousyabetu_syori_task_syoukai.js.jsp - 担当者別処理タスク照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai.TantousyabetuSyoriTaskSyoukaiConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai.TantousyabetuSyoriTaskSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai.TantousyabetuSyoriTaskSyoukaiUiBean" %>
<% TantousyabetuSyoriTaskSyoukaiUiBean uiBean = SWAKInjector.getInstance(TantousyabetuSyoriTaskSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

if ($(<%= TASKSERINFO %>)[0].rows.length <= 1) {
    $(<%= TASKSERINFO + DIV %>).visible(false);
    $(<%= USERNM_SEARCHKEYINPUT        %>).val("");
}
$(".messagesItem").each(
  function(){
    $(<%= TASKSERINFO + DIV %>).visible(false);
    $(<%= USERNM_SEARCHKEYINPUT %>).hide();
    $(".recordCountDiv").visible(false);
    $(".pagerDiv").visible(false);
    }
);

$(<%= DISPGYOUMUKEY + LABEL %>).text('<%= uiBean.getGyoumukeylbl() %>');

});
//-->
</script>
