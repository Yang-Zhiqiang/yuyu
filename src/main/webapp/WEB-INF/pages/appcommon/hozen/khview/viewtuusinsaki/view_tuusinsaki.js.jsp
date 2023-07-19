<%--
    view_tuusinsaki.js.jsp - 通信先情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewTuusinsakiUiBeanParam viewTuusinsakiUiBean = (ViewTuusinsakiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
    if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {
  %>
    addTopBottomLink(<%=TUUSINSAKIINFO%>);
  <%}%>

});

</script>
