<%--
    view_sonota_check_sibou.js.jsp - その他チェック項目（死亡） JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsonotachecksibou.ViewSonotaCheckSibouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsonotachecksibou.ViewSonotaCheckSibouUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsonotachecksibou/view_sonota_check_sibou.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSonotaCheckSibouUiBeanParam viewSonotaCheckSibouUiBean = (ViewSonotaCheckSibouUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewSonotaCheckSibouUiBean.isViewSonotaCheckSibouFlg()) { %>
    showGroup(<%=VIEWSONOTACHECKSIBOU%>);
    viewSonotaCheckSibou();
  <% } %>

function viewSonotaCheckSibou() {
   var viewSonotaCheckSibouDispKbn = 0;
   <%
   if (viewSonotaCheckSibouUiBean.isViewSonotaCheckSibouSeigyo()) { %>
       $(<%=VIEWSONOTACHECKSIBOU + LABEL%>).addClass('toggletitle');

       <%
       if (viewSonotaCheckSibouUiBean.isViewSonotaCheckSibouDispFlg()) { %>
           $(<%= VIEWSONOTACHECKSIBOU%>).show();
       <%
       } else { %>
           $(<%= VIEWSONOTACHECKSIBOU%>).hide();
           viewSonotaCheckSibouDispKbn = 1;
       <% } %>

       $(<%= VIEWSONOTACHECKSIBOU + LABEL%>).click(function(){
           if (viewSonotaCheckSibouDispKbn == 0) {
               $(<%= VIEWSONOTACHECKSIBOU%>).hide();
               viewSonotaCheckSibouDispKbn = 1;
           } else {
               $(<%= VIEWSONOTACHECKSIBOU%>).show();
               viewSonotaCheckSibouDispKbn = 0;
           }
       });
   <% } %>
}

});

</script>
