<%--
    view_sinkensya.js.jsp - 親権者後見人情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsinkensya.ViewSinkensyaSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsinkensya.ViewSinkensyaUiBeanParam" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.def.classification.C_SkskknsyubetuKbn"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsinkensya/view_sinkensya.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSinkensyaUiBeanParam viewSinkensyaUiBean = (ViewSinkensyaUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

<%
 if (viewSinkensyaUiBean.isViewSinkensyaHyouji()) { %>
   var viewSinkensya = 0;
   <%
    if (viewSinkensyaUiBean.isViewSinkensyaSeigyo()) { %>
      $(<%=VIEWSINKENSYAINFO + LABEL%>).addClass('toggletitle');

     <%
      if (viewSinkensyaUiBean.isViewSinkensyaDispFlg()) {%>
         $(<%= VIEWSINKENSYAINFO%>).show();
         viewSinkensya = 0;
     <%
     } else {  %>
        $(<%= VIEWSINKENSYAINFO%>).hide();
        viewSinkensya = 1;
     <% } %>

   $(<%= VIEWSINKENSYAINFO + LABEL%>).click(function(){
      if (viewSinkensya == 0) {
        $(<%= VIEWSINKENSYAINFO%>).hide();
        viewSinkensya = 1;
      } else {
         $(<%= VIEWSINKENSYAINFO%>).show();
         viewSinkensya = 0;
      }
   });
  <% } %>
<%
 } else { %>
  $(<%=VIEWSINKENSYAINFO + DIV%>).visible(false);
<% } %>


});

</script>
