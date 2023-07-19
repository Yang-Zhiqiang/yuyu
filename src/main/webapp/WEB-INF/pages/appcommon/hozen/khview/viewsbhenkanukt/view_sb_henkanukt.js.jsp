<%--
    view_sb_henkanukt.js.jsp - 死亡返還金受取人情報表示 JavaScript(JSP)
--%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewsbhenkanukt.ViewSbHenkanuktSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewsbhenkanukt.ViewSbHenkanuktUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewsbhenkanukt/view_sb_henkanukt.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSbHenkanuktUiBeanParam viewSbHenkanuktUiBean = (ViewSbHenkanuktUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

 <%
 if (!BizUtil.isBlank(viewSbHenkanuktUiBean.getSbhenkanuktnmkn())) {%>
   showGroup(<%=SBHENKANUKTINFO%>);
    <%
      if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {%>
      addTopBottomLink(<%=SBHENKANUKTINFO%>);
   <%}%>
 <%}%>


});

</script>
