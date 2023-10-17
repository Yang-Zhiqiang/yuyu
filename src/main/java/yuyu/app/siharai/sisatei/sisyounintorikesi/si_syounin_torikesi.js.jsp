<%--
    si_syounin_torikesi.js.jsp - 承認取消 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisyounintorikesi.SiSyouninTorikesiConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisyounintorikesi.SiSyouninTorikesiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sisatei.sisyounintorikesi.SiSyouninTorikesiUiBean" %>
<%@page import="yuyu.app.siharai.sisatei.sisyounintorikesi.SiSyouninTorikesiConstants" %>
<% SiSyouninTorikesiUiBean uiBean = SWAKInjector.getInstance(SiSyouninTorikesiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <%
  if(SiSyouninTorikesiConstants.PAGENO_CONFIRM == uiBean.getPageNo()) {%>
    <%
    if(uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) {%>
        $(<%=TSKNM_SATEIINFO%>).parent().parent().visible(false);
        $(<%=SASIMODOSITSKNM_SATEIINFO%>).parent().parent().visible(false);
        $(<%=HHKNINFO  + DIV %>).visible(false);
        $(<%=MODORUBTNBYCONFIRM_FOOTERBUTTONS3 %>).visible(false);
        $(<%=KAKUTEIBTN_FOOTERBUTTONS3%>).visible(false);
        $(<%=FUNCTION_NAME%>).text('<%= uiBean.getKinouNm() %>');
        $(<%= FUNCTION_NAME %>).attr("disabled", "true");
        $(<%= FUNCTION_NAME %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');
        $(<%=TOJIRUBTN_HEADERBUTTONS%>).visible(false);
    <%}
    else {%>
    $(<%=TOJIRUBTNBYPOPUP_HEADERBUTTONS%>).visible(false);
    <%}
    }%>
  <% %>
});
//-->
</script>
