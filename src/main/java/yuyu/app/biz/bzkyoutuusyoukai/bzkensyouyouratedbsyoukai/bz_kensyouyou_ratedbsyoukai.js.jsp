<%--
    bz_kensyouyou_ratedbsyoukai.js.jsp - 検証用レートＤＢ照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai.BzKensyouyouRatedbsyoukaiConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai.BzKensyouyouRatedbsyoukaiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai.BzKensyouyouRatedbsyoukaiUiBean"%>
<% BzKensyouyouRatedbsyoukaiUiBean uiBean = SWAKInjector.getInstance(BzKensyouyouRatedbsyoukaiUiBean.class); %>
<script type="text/javascript">
$(function(){

  <%
    if (uiBean.getPageNo() == PAGENO_RESULT) { %>
      openReport('print', '_blank');
  <%} %>

  <%
    if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
      $(<%= DISPPALHOKENSYURUIKIGOU_RATEKEYNYUURYOKUGROUP %>).removeClass("imemode-off");
      $(<%= DISPPALHOKENSYURUIKIGOU_RATEKEYNYUURYOKUGROUP %>).addClass("imemode-on");
  <%} %>

});
</script>
