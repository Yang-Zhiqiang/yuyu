<%--
    kh_souhuannai_sakusei.js.jsp - 送付案内作成 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khsouhuannaisakusei.KhSouhuannaiSakuseiConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khsouhuannaisakusei.KhSouhuannaiSakuseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khsouhuannaisakusei.KhSouhuannaiSakuseiUiBean" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<% KhSouhuannaiSakuseiUiBean uiBean = SWAKInjector.getInstance(KhSouhuannaiSakuseiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
     $(<%=SHSKYN_OPOPUP_BUTTON%>).popupResponse(function(data){
        if (data.length != 0)  {
         $(<%=SHSKYNO_SOUHUSAKIJYUUSYOINFO %>).val(substrVal(data[1]));
         $(<%=SHSADR1KJ_SOUHUSAKIJYUUSYOINFO %>).val(substrVal(data[2]) + substrVal(data[3]));
         $(<%=SHSADR2KJ_SOUHUSAKIJYUUSYOINFO %>).val(substrVal(data[4]));
         $(<%=SHSADR3KJ_SOUHUSAKIJYUUSYOINFO %>).val('');
        }
     });
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
       <% if (uiBean.getTyhykbn().eq(C_UmuKbn.ARI)){ %>
            openReport("print", "_blank");
       <% } %>
  <% } %>
});
//-->
</script>
