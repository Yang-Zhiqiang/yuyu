<%--
    view_nkukt.js.jsp - 年金受取人情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewnkukt.ViewNkuktSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewnkukt.ViewNkuktUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UktKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewNkuktUiBeanParam viewNkuktUiBean = (ViewNkuktUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

 <%
 if (!C_UktKbn.BLNK.eq(viewNkuktUiBean.getVnkuknenkinuktkbn())) {%>
   showGroup(<%=NKUKTINFO%>);
   <%
     if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {%>
      addTopBottomLink(<%=NKUKTINFO%>);
    <%}%>
 <%}%>


});

</script>
