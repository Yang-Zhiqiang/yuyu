<%--
    view_sknaiyou.js.jsp - 請求内容表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsknaiyou.ViewSknaiyouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsknaiyou.ViewSknaiyouUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsknaiyou/view_sknaiyou.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSknaiyouUiBeanParam viewSknaiyouUiBean = (ViewSknaiyouUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
 <%
   if (viewSknaiyouUiBean.isViewSknaiyouSeigyo()) { %>
     $(<%=VIEWSKNAIYOUINFO + LABEL%>).addClass('toggletitle');

     var viewSknaiyou = 0;
     <%
       if (viewSknaiyouUiBean.isViewSknaiyouDispFlg()) { %>
          $(<%= VIEWSKNAIYOUINFO%>).show();
          viewSknaiyou = 0;
     <%
       } else { %>
          $(<%= VIEWSKNAIYOUINFO%>).hide();
          viewSknaiyou = 1;
    <% } %>
     $(<%= VIEWSKNAIYOUINFO + LABEL%>).click(function(){
       if (viewSknaiyou == 0) {
          $(<%= VIEWSKNAIYOUINFO%>).hide();
          viewSknaiyou = 1;
        } else {
          $(<%= VIEWSKNAIYOUINFO%>).show();
          viewSknaiyou = 0;
       }
     });
<% } %>
});

</script>
