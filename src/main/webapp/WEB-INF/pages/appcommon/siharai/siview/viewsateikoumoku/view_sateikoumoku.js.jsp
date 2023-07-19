<%--
    view_sateikoumoku.js.jsp - 査定項目 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsateikoumoku.ViewSateikoumokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsateikoumoku.ViewSateikoumokuUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsateikoumoku/view_sateikoumoku.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSateikoumokuUiBeanParam viewSateikoumokuUiBean = (ViewSateikoumokuUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

   var viewSateikoumokuDispKbn = 0;
   <%
   if (viewSateikoumokuUiBean.isViewSateikoumokuSeigyo()) { %>
       $(<%=VIEWSATEIKOUMOKUINFO + LABEL%>).addClass('toggletitle');

       <%
       if (viewSateikoumokuUiBean.isViewSateikoumokuDispFlg()) { %>
           $(<%= VIEWSATEIKOUMOKUINFO%>).show();
       <%
       } else { %>
           $(<%= VIEWSATEIKOUMOKUINFO%>).hide();
           viewSateikoumokuDispKbn = 1;
       <% } %>

       $(<%= VIEWSATEIKOUMOKUINFO + LABEL%>).click(function(){
           if (viewSateikoumokuDispKbn == 0) {
               $(<%= VIEWSATEIKOUMOKUINFO%>).hide();
               viewSateikoumokuDispKbn = 1;
             } else {
               $(<%= VIEWSATEIKOUMOKUINFO%>).show();
               viewSateikoumokuDispKbn = 0;
           }
       });

   <% } %>

});

</script>
