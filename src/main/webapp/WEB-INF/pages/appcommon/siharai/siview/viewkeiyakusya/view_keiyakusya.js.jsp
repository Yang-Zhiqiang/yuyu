<%--
    view_keiyakusya.js.jsp - 契約者情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page import="static yuyu.common.siharai.siview.viewkeiyakusya.ViewKeiyakusyaSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.common.siharai.siview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam"%>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags"%>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewkeiyakusya/view_keiyakusya.css" />
<%
    CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
%>

<%
    ViewKeiyakusyaUiBeanParam viewhihokensyaUiBean = (ViewKeiyakusyaUiBeanParam) commonViewInBean.getCommonViewUiBeanParam();
%>

<script type="text/javascript">
$(function(){
});
</script>
