<%--
    ds_mail_sousin_rireki_syoukai.js.jsp - ＤＳメール送信履歴照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.DsMailSousinRirekiSyoukaiConstants.*"%>
<%@page
	import="static yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.DsMailSousinRirekiSyoukaiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.DsMailSousinRirekiSyoukaiUiBean"%>
<% DsMailSousinRirekiSyoukaiUiBean uiBean = SWAKInjector.getInstance(DsMailSousinRirekiSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  if ($(<%=SEARCHRESULTINFO%>)[0].rows.length > 2) {
      showList(<%=SEARCHRESULTINFO%>);
  }
  $(<%= ROWSPAN_CLASS_2%>).attr("rowspan", "2");
  $(<%= COLSPAN_CLASS_1%>).attr("colspan","1");

});
//-->
</script>
