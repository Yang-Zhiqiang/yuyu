<%--
    view_kyksyadairi.js.jsp - 契約者代理人情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewkyksyadairi.ViewKyksyadairiSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewkyksyadairi.ViewKyksyadairiUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UktKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKyksyadairiUiBeanParam viewKyksyadairiUiBeanParam = (ViewKyksyadairiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){


  <%
    if (!C_UktKbn.BLNK.eq(viewKyksyadairiUiBeanParam.getVkykdrkykdrkbn())) { %>
     showGroup(<%=KYKSYADAIRINININFO%>);
     <%
       if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) { %>
         addTopBottomLink(<%=KYKSYADAIRINININFO%>);
     <%}%>
  <% } %>
});

</script>
