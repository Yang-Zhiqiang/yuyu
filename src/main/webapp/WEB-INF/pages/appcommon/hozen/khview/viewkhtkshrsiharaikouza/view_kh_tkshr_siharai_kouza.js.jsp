<%--
    view_kh_tkshr_siharai_kouza.js.jsp - 定期支払金支払先口座情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewkhtkshrsiharaikouza.ViewKhTkshrSiharaiKouzaSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewkhtkshrsiharaikouza.ViewKhTkshrSiharaiKouzaUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_KouzasyuruiKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewkhtkshrsiharaikouza/view_kh_tkshr_siharai_kouza.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKhTkshrSiharaiKouzaUiBeanParam viewKhTkshrSiharaiKouzaUiBeanParam = (ViewKhTkshrSiharaiKouzaUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

<%
  if (C_UmuKbn.ARI.eq(viewKhTkshrSiharaiKouzaUiBeanParam.getTeikishrtkykhukaumu())) { %>
    showGroup(<%=VIEWKHTKSHRSIHARAIKOUZAINFO%>);
    <%
    if (C_KouzasyuruiKbn.YENKOUZA.eq(viewKhTkshrSiharaiKouzaUiBeanParam.getVktikskzkzsyuruikbn())) { %>
      showKoumoku(<%=VKTIKSKZYOKINKBN_VIEWKHTKSHRSIHARAIKOUZAINFO%>);
    <% } %>
    <%
    if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) { %>
      addTopBottomLink(<%=VIEWKHTKSHRSIHARAIKOUZAINFO%>);
    <% } %>
<% } %>


});

</script>
