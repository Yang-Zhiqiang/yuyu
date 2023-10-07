<%--
    si_sibou_kari_uketuke_teisei.js.jsp - 死亡仮受付訂正 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.simouside.sisiboukariuketuketeisei.SiSibouKariUketukeTeiseiConstants.*" %>
<%@page import="static yuyu.app.siharai.simouside.sisiboukariuketuketeisei.SiSibouKariUketukeTeiseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.simouside.sisiboukariuketuketeisei.SiSibouKariUketukeTeiseiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<% SiSibouKariUketukeTeiseiUiBean uiBean = SWAKInjector.getInstance(SiSibouKariUketukeTeiseiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>
<% commonViewInBean.setCommonViewUiBeanParam(uiBean); %>
<%
 if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
     || uiBean.getPageNo() == PAGENO_CONFIRM
     || uiBean.getPageNo() == PAGENO_RESULT) {%>
     <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewuketorininsb/view_uketorinin_sb.js.jsp"/>
     <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewbetukyk/view_betukyk.js.jsp"/>

<%}%>
<script type="text/javascript"><!--
$(function(){
});
//-->
</script>
