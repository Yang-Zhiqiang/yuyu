<%--
    view_siteiseikyuu.js.jsp - 被保険者代理人情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewsiteiseikyuu.ViewSiteiseikyuuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewsiteiseikyuu.ViewSiteiseikyuuUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UktKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewsiteiseikyuu/view_siteiseikyuu.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSiteiseikyuuUiBeanParam viewSiteiseikyuuUiBean = (ViewSiteiseikyuuUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
    if (!C_UktKbn.BLNK.eq(viewSiteiseikyuuUiBean.getVstsksiteidruktkbn())) {%>
        showGroup(<%=SITEISEIKYUUINFO%>);

    <%
      if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {%>
          addTopBottomLink(<%=SITEISEIKYUUINFO%>);
    <%}%>
  <%}%>


});

</script>
