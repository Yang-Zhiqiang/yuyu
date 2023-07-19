<%--
    view_hituyou_syorui.js.jsp - 必要書類情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiUiBeanParam" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewHituyouSyoruiUiBeanParam viewHituyouSyoruiUiBean = (ViewHituyouSyoruiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
    if (!BizUtil.isBlank(viewHituyouSyoruiUiBean.getVhtysdisphtysyorui())) {
  %>
    showGroup(<%=HITUYOUSYORUIINFO%>);

    $(<%=VHTYSDISPHTYSYORUI_HITUYOUSYORUIINFO%>).html('<%=viewHituyouSyoruiUiBean.getVhtysdisphtysyorui()%>');

  <%}%>


});

</script>
