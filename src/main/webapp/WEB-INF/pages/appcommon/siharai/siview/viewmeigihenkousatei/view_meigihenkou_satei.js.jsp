<%--
    view_meigihenkou_satei.js.jsp - 名義変更査定 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewmeigihenkousatei.ViewMeigihenkouSateiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewmeigihenkousatei.ViewMeigihenkouSateiUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewmeigihenkousatei/view_meigihenkou_satei.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewMeigihenkouSateiUiBeanParam viewMeigihenkouSateiUiBean = (ViewMeigihenkouSateiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

   <%
   if (viewMeigihenkouSateiUiBean.isViewMeigihenkouSateiFlg()) { %>
     showGroup(<%=VIEWMEIGIHENKOUSATEIINFO%>);
     $(<%=MEIHENUKTKBN_VIEWMEIGIHENKOUSATEIINFO%>).addClass('meihenuktnmFirstCell');
     viewMeigihenkouSatei();
   <% } %>

function viewMeigihenkouSatei() {
  var viewMeigihenkouSateiDispKbn = 0;
  <%
  if (viewMeigihenkouSateiUiBean.isViewMeigihenkouSateiSeigyo()) { %>
      $(<%=VIEWMEIGIHENKOUSATEIINFO + LABEL%>).addClass('toggletitle');

      <%
      if (viewMeigihenkouSateiUiBean.isViewMeigihenkouSateiDispFlg()) { %>
          $(<%= VIEWMEIGIHENKOUSATEIINFO%>).show();
      <%
      } else { %>
          $(<%= VIEWMEIGIHENKOUSATEIINFO%>).hide();
          viewMeigihenkouSateiDispKbn = 1;
      <% } %>

      $(<%= VIEWMEIGIHENKOUSATEIINFO + LABEL%>).click(function(){
          if (viewMeigihenkouSateiDispKbn == 0) {
              $(<%= VIEWMEIGIHENKOUSATEIINFO%>).hide();
              viewMeigihenkouSateiDispKbn = 1;
          } else {
              $(<%= VIEWMEIGIHENKOUSATEIINFO%>).show();
              viewMeigihenkouSateiDispKbn = 0;
          }
      });
  <% } %>
}

});

</script>
