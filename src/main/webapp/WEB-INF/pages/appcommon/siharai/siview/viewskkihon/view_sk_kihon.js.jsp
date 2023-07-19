<%--
    view_sk_kihon.js.jsp - 請求基本情報 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewskkihon.ViewSkKihonSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewskkihon/view_sk_kihon.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSkKihonUiBeanParam viewSkKihonUiBean = (ViewSkKihonUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  var viewSkKihonDispKbn = 0;
  <%
  if (viewSkKihonUiBean.isViewSkKihonSeigyo()) { %>
      $(<%=HKTSKKIHONINFO + LABEL%>).addClass('toggletitle');

      <%
      if (viewSkKihonUiBean.isViewSkKihonDispFlg()) { %>
          $(<%= HKTSKKIHONINFO%>).show();
      <%
      } else { %>
          $(<%= HKTSKKIHONINFO%>).hide();
          viewSkKihonDispKbn = 1;
      <% } %>

    $(<%= HKTSKKIHONINFO + LABEL%>).click(function(){
        if (viewSkKihonDispKbn == 0) {
            $(<%= HKTSKKIHONINFO%>).hide();
            viewSkKihonDispKbn = 1;
        } else {
            $(<%= HKTSKKIHONINFO%>).show();
            viewSkKihonDispKbn = 0;
        }
    });

  <% } %>


});

</script>
