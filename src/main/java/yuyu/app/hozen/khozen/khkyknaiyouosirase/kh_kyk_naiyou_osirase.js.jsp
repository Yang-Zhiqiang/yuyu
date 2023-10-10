<%--
    kh_kyk_naiyou_osirase.js.jsp - ご契約内容のお知らせ JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkyknaiyouosirase.KhKykNaiyouOsiraseConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkyknaiyouosirase.KhKykNaiyouOsiraseSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khkyknaiyouosirase.KhKykNaiyouOsiraseUiBean" %>
<% KhKykNaiyouOsiraseUiBean uiBean = SWAKInjector.getInstance(KhKykNaiyouOsiraseUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
        openReport('print', '_blank');
  <% } %>
});
//-->
</script>
