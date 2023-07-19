<%--
    view_satei_kekka.js.jsp - 査定結果 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsateikekka.ViewSateiKekkaSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.common.siharai.siview.viewsateikekka.ViewSateiKekkaUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsateikekka/view_satei_kekka.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSateiKekkaUiBeanParam ViewSateiKekkaUiBean = (ViewSateiKekkaUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

 <%
   if (ViewSateiKekkaUiBean.isSyouninInputHanteiFlg()) { %>
     $(<%= VIEWSATEIKEKKAINFO + LABEL%>).text('<%= MessageUtil.getMessage(MessageId.IJW1067) %>');
 <%
 } else { %>
   <%
     if (ViewSateiKekkaUiBean.isSessyouInputHanteiFlg()) { %>
       $(<%= VIEWSATEIKEKKAINFO + LABEL%>).text('<%= MessageUtil.getMessage(MessageId.IJW1068) %>');
   <%
     } else { %>
       <%
         if (ViewSateiKekkaUiBean.isKaiketuInputHanteiFlg()) { %>
           $(<%= VIEWSATEIKEKKAINFO + LABEL%>).text('<%= MessageUtil.getMessage(MessageId.IJW1069) %>');
     <% } %>
   <% } %>
 <% } %>

 var viewSateiKekka = 0;
 <%
 if (ViewSateiKekkaUiBean.isViewSateiKekkaSeigyo()) { %>
     $(<%=VIEWSATEIKEKKAINFO + LABEL%>).addClass('toggletitle');

     <%
     if (ViewSateiKekkaUiBean.isViewSateiKekkaDispFlg()) { %>
         $(<%= VIEWSATEIKEKKAINFO%>).show();
     <%
     } else { %>
         $(<%= VIEWSATEIKEKKAINFO%>).hide();
         viewSateiKekka = 1;
     <% } %>

     $(<%= VIEWSATEIKEKKAINFO + LABEL%>).click(function(){
         if (viewSateiKekka == 0) {
             $(<%= VIEWSATEIKEKKAINFO%>).hide();
             viewSateiKekka = 1;
         } else {
             $(<%= VIEWSATEIKEKKAINFO%>).show();
             viewSateiKekka = 0;
         }
     });
 <% } %>

});

</script>
