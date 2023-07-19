<%--
    view_keizoku_nkukt.js.jsp - 継続年金受取人情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewkeizokunkukt.ViewKeizokuNkuktSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewkeizokunkukt.ViewKeizokuNkuktUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewkeizokunkukt/view_keizoku_nkukt.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKeizokuNkuktUiBeanParam viewKeizokuNkuktUiBean = (ViewKeizokuNkuktUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

 <%
 if (!BizUtil.isBlank(viewKeizokuNkuktUiBean.getKeizknkuktnmkn())) {%>
   showGroup(<%=KEIZOKUNKUKTINFO%>);
   <%
     if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {%>
       addTopBottomLink(<%=KEIZOKUNKUKTINFO%>);
   <%}%>
 <%}%>

});

</script>
