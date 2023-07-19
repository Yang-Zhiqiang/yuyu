<%--
    view_tokusin.js.jsp - 特伸情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewtokusin.ViewTokusinSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewtokusin.ViewTokusinUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewtokusin/view_tokusin.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewTokusinUiBeanParam viewTokusinUiBeanParam = (ViewTokusinUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
  <%
    if (C_UmuKbn.ARI.eq(viewTokusinUiBeanParam.getVtsumukbn())) { %>
     showGroup(<%=TOKUSININFO%>);
     <%
       if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) { %>
         addTopBottomLink(<%=TOKUSININFO%>);
     <%}%>
  <% } %>
});

</script>
