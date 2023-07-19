<%--
    view_keiyakusya.js.jsp - 契約者情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_Kyksei" %>
<%@page import="yuyu.def.classification.C_HjndaiykKbn" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKeiyakusyaUiBeanParam viewKeiyakusyaUiBean = (ViewKeiyakusyaUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

function varElmAddTopBottomLink(idSelecterList){
    var groupSelecter = idSelecterList.join(',');
    var targetId = $(groupSelecter).filter(':visible').last().attr('id');
    addTopBottomLink('#' + targetId);
}

$(function(){

  <%
    if (C_Kyksei.HJNKYK.eq(viewKeiyakusyaUiBean.getVkykskyksei())) {
  %>
    showGroup(<%=HJNDAIYINFO%>);
  <%}%>


  <%
    if (C_HjndaiykKbn.SONOTA.eq(viewKeiyakusyaUiBean.getVkykshjndaiykkbn()) && !BizUtil.isBlank(viewKeiyakusyaUiBean.getVkykshjndaiyknm())) {
  %>
    $(<%=IAW0004_HJNDAIYINFO %>).visible(true);
    $(<%=VKYKSHJNDAIYKNM_HJNDAIYINFO%>).visible(true);
    $(<%=IAW0005_HJNDAIYINFO %>).visible(true);
  <%}%>

  <%
    if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {
  %>
    varElmAddTopBottomLink([
        <%= KEIYAKUSYAINFO %>,
        <%= HJNDAIYINFO %>
    ]);
  <%}%>

});

</script>
