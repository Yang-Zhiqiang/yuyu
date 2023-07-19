<%--
    view_betukyk.js.jsp - 別契約情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewbetukyk.ViewBetukykSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewbetukyk/view_betukyk.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewBetukykUiBeanParam viewBetukykUiBean = (ViewBetukykUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

    showList(<%=KIKEIYAKUINFO%>);

    showList(<%=NENKINSIHARAIINFO%>);

    showList(<%=PALKIKEIYAKUINFO%>);

    showList(<%=PALNENKINSIHARAIINFO%>);

    showList(<%=PALSUEOKIINFO%>);
    <%
    if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {
  %>
    varElmAddTopBottomLink([<%= KIKEIYAKUINFO %>,
                            <%= NENKINSIHARAIINFO %>,
                            <%= PALKIKEIYAKUINFO %>,
                            <%= PALNENKINSIHARAIINFO %>,
                            <%= PALSUEOKIINFO %>]);

  <%}%>
  function varElmAddTopBottomLink(idSelecterList){
      var groupSelecter = idSelecterList.join(',');
      var targetId = $(groupSelecter).filter(':visible').last().attr('id');
      addBottomLink('#' + targetId);
  }
});

</script>