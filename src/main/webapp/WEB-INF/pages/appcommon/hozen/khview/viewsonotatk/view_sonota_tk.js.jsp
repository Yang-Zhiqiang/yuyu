<%--
    view_sonota_tk.js.jsp - その他特約付加情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewsonotatk.ViewSonotaTkSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewsonotatk.ViewSonotaTkUiBeanParam" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSonotaTkUiBeanParam viewSonotaTkUiBean = (ViewSonotaTkUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
    if (!BizUtil.isBlank(viewSonotaTkUiBean.getVsntkdisptkhukainfo())) {
  %>
    showGroup(<%=SONOTATKINFO%>);

    $(<%=VSNTKDISPTKHUKAINFO_SONOTATKINFO%>).html('<%=viewSonotaTkUiBean.getVsntkdisptkhukainfo()%>');

   <%
      if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {
    %>
      addTopBottomLink(<%=SONOTATKINFO%>);

    <%}%>
  <%}%>


});

</script>
