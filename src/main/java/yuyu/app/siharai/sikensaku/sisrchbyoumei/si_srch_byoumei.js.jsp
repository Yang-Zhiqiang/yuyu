<%--
    si_srch_byoumei.js.jsp - 病名検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sikensaku.sisrchbyoumei.SiSrchByoumeiConstants.*" %>
<%@page import="static yuyu.app.siharai.sikensaku.sisrchbyoumei.SiSrchByoumeiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sikensaku.sisrchbyoumei.SiSrchByoumeiUiBean" %>
<% SiSrchByoumeiUiBean uiBean = SWAKInjector.getInstance(SiSrchByoumeiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  showList(<%=SEARCHRESULTS%>);

});
//-->
</script>
