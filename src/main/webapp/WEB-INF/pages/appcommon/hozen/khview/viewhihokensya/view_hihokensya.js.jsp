<%--
    view_hihokensya.js.jsp - 被保険者情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewhihokensya/view_hihokensya.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewHihokensyaUiBeanParam viewHihokensyaUiBean = (ViewHihokensyaUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
    if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {
  %>
    addTopBottomLink(<%=HIHOKENSYAINFO%>);
  <%}%>

});

</script>
