<%--
    view_kihon.js.jsp - 基本情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewkihon.ViewKihonSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_YuukousyoumetuKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewkihon/view_kihon.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKihonUiBeanParam viewKihonUiBean = (ViewKihonUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
    if (C_YuukousyoumetuKbn.SYOUMETU.eq(viewKihonUiBean.getVkihnyuukousyoumetukbn())) {
  %>
    showKoumoku(<%=VKIHNSYOUMETUJIYUU_KIHONINFO%>);
    showKoumoku(<%=VKIHNSYOUMETUYMD_KIHONINFO%>);
  <%}%>

  <%
    if (viewKihonUiBean.getVkihnlastsyosaihkymd() != null) {
  %>
    showKoumoku(<%=VKIHNLASTSYOSAIHKYMD_KIHONINFO%>);

  <%}%>

});

</script>
