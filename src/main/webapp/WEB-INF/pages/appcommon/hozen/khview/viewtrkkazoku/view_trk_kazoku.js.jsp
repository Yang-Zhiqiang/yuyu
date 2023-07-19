<%--
    view_trk_kazoku.js.jsp - 登録家族情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewTrkKazokuUiBeanParam viewTrkKazokuUiBeanParam = (ViewTrkKazokuUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
    if (C_UmuKbn.ARI.eq(viewTrkKazokuUiBeanParam.getVtrkkzktrkkzkumukbn1())) { %>
     showGroup(<%=TRKKZKINFO1%>);
  <% } %>

  <%
    if (C_UmuKbn.ARI.eq(viewTrkKazokuUiBeanParam.getVtrkkzktrkkzkumukbn2())) { %>
     showGroup(<%=TRKKZKINFO2%>);
  <% } %>

  <%
    if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) { %>
      varElmAddTopBottomLink([<%= TRKKZKINFO1 %>, <%= TRKKZKINFO2 %>]);
  <%}%>

  function varElmAddTopBottomLink(idSelecterList){
      var groupSelecter = idSelecterList.join(',');
      var targetId = $(groupSelecter).filter(':visible').last().attr('id');
      addTopBottomLink('#' + targetId);
  }

});
</script>
