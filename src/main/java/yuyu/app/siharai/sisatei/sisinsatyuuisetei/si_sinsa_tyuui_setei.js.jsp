<%--
    si_sinsa_tyuui_setei.js.jsp - 審査注意設定 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisinsatyuuisetei.SiSinsaTyuuiSeteiConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisinsatyuuisetei.SiSinsaTyuuiSeteiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.def.classification.C_SetteiKbn" %>
<%@page import="yuyu.app.siharai.sisatei.sisinsatyuuisetei.SiSinsaTyuuiSeteiUiBean" %>
<% SiSinsaTyuuiSeteiUiBean uiBean = SWAKInjector.getInstance(SiSinsaTyuuiSeteiUiBean.class); %>
<script type="text/javascript">
$(function(){

  <%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      <%
      if (uiBean.isSiSinsaTyuuiSetKbnFlg()) { %>
          $(<%=SINSATYUUI_SINSATYUUIINFO%>).removeAttr("disabled");
      <% } else { %>
          $(<%=SINSATYUUI_SINSATYUUIINFO%>).attr("disabled", "true");
      <% } %>
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
      <%
      if (!uiBean.isSiSinsaTyuuiSetKbnFlg()) { %>
          $(<%=SINSATYUUISETNM_SINSATYUUIINFO%>).parent().parent().visible(false);
          $(<%=SOSIKINM_SINSATYUUIINFO%>).parent().parent().visible(false);
          $(<%=SINSATYUUI_SINSATYUUIINFO%>).parent().parent().visible(false);
      <% } %>
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      $("input[id^='sinsatyuuisetkbn']").change(function() {
         var value = $("input[id^='sinsatyuuisetkbn']:checked").val();
         if ( value == "<%=C_SetteiKbn.SETTEI.getValue()%>" ) {
              $(<%=SINSATYUUI_SINSATYUUIINFO%>).removeAttr("disabled");
         } else {
              $(<%=SINSATYUUI_SINSATYUUIINFO%>).attr("disabled", "true");
         }
      });
  <% } %>

});
</script>
