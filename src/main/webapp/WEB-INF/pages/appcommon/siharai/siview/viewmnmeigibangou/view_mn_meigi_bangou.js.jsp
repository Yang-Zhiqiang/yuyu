<%--
    view_mn_meigi_bangou.js.jsp - ＭＮ名義番号表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewmnmeigibangou.ViewMnMeigiBangouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewmnmeigibangou.ViewMnMeigiBangouUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewmnmeigibangou/view_mn_meigi_bangou.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewMnMeigiBangouUiBeanParam viewMnMeigiBangouUiBean = (ViewMnMeigiBangouUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

 var viewMnMeigiBangouDispKbn = 0;
 <%
    if (viewMnMeigiBangouUiBean.isViewMnMeigiBangouSeigyo()) { %>
       $(<%=VIEWMNMEIGIBANGOU + LABEL%>).addClass('toggletitle');

       <%
          if (viewMnMeigiBangouUiBean.isViewMnMeigiBangouDispFlg()) { %>
             $(<%= VIEWMNMEIGIBANGOU%>).show();
       <%
          } else { %>
             $(<%= VIEWMNMEIGIBANGOU%>).hide();
             viewMnMeigiBangouDispKbn = 1;
       <% } %>

       $(<%= VIEWMNMEIGIBANGOU + LABEL%>).click(function(){
         if (viewMnMeigiBangouDispKbn == 0) {
             $(<%= VIEWMNMEIGIBANGOU%>).hide();
             viewMnMeigiBangouDispKbn = 1;
         } else {
             $(<%= VIEWMNMEIGIBANGOU%>).show();
             viewMnMeigiBangouDispKbn = 0;
         }
     });
 <% } %>

});

</script>
