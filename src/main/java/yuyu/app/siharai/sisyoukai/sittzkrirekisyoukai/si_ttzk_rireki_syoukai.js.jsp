<%--
    si_ttzk_rireki_syoukai.js.jsp - 手続履歴照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiConstants.*" %>
<%@page import="static yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.def.classification.C_SeikyuuSyubetu" %>
<%@page import="yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiUiBean" %>
<% SiTtzkRirekiSyoukaiUiBean uiBean = SWAKInjector.getInstance(SiTtzkRirekiSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <%
     if (uiBean.getPageNo() == PAGENO_SELECTTTZKRRK) { %>
       <%
         if (!C_SeikyuuSyubetu.SB.equals( uiBean.getSeikyuusyubetu())) { %>
           $(<%=SYOUKAIBTN_HEADERBUTTONS2 %>).visible(false);
       <% } %>
  <% } %>

});
//-->
</script>
