<%--
    view_dattai.js.jsp - 脱退情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewdattai.ViewDattaiSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewdattai.ViewDattaiUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewdattai/view_dattai.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewDattaiUiBeanParam viewDattaiUiBeanParam = (ViewDattaiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
  <%
    if (C_UmuKbn.ARI.eq(viewDattaiUiBeanParam.getVdtumukbn())) { %>
     showGroup(<%=DATTAIINFO%>);
     <%
       if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) { %>
         addTopBottomLink(<%=DATTAIINFO%>);
     <%}%>
  <% } %>
});

</script>
