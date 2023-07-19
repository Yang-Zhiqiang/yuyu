<%--
    view_betukuti_check_sibou.js.jsp - 別口チェック項目（死亡） JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewbetukutichecksibou.ViewBetukutiCheckSibouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewbetukutichecksibou.ViewBetukutiCheckSibouUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewbetukutichecksibou/view_betukuti_check_sibou.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewBetukutiCheckSibouUiBeanParam viewBetukutiCheckSibouUiBean = (ViewBetukutiCheckSibouUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewBetukutiCheckSibouUiBean.isViewBetukutiCheckSibouInputDispFlg()) { %>

   $(<%=BETUSIBOUCOMMENT_VIEWBETUKUTICHECKSIBOUINFO%>).addClass("betusiboucomment_text12");

   $(<%=BETUSOUKICOMMENT_VIEWBETUKUTICHECKSIBOUINFO%>).addClass("betusoukicomment_text12");

   viewBetukutiCheckSibou();
  <%
  } else { %>
    <%
    if (viewBetukutiCheckSibouUiBean.isViewBetukutiCheckSibouFlg()) { %>
      $(<%=BETUSIBOUUMUKBN_VIEWBETUKUTICHECKSIBOUINFO%>).addClass('betusibouumukbnFirstCell');
      $(<%=BETUSOUKIUMUKBN_VIEWBETUKUTICHECKSIBOUINFO%>).addClass('betusoukiumukbnFirstCell');
      viewBetukutiCheckSibou();
    <%
    } else { %>
       $(<%=VIEWBETUKUTICHECKSIBOUINFO + DIV%>).visible(false);
    <% } %>
  <% } %>

function viewBetukutiCheckSibou () {
  var viewBetukutiCheckSibouDispKbn = 0;
  <%
  if (viewBetukutiCheckSibouUiBean.isViewBetukutiCheckSibouSeigyo()) { %>
      $(<%=VIEWBETUKUTICHECKSIBOUINFO + LABEL%>).addClass('toggletitle');

      <%
      if (viewBetukutiCheckSibouUiBean.isViewBetukutiCheckSibouDispFlg()) { %>
          $(<%= VIEWBETUKUTICHECKSIBOUINFO%>).show();
      <%
      } else { %>
          $(<%= VIEWBETUKUTICHECKSIBOUINFO%>).hide();
          viewBetukutiCheckSibouDispKbn = 1;
      <% } %>

      $(<%= VIEWBETUKUTICHECKSIBOUINFO + LABEL%>).click(function(){
          if (viewBetukutiCheckSibouDispKbn == 0) {
              $(<%= VIEWBETUKUTICHECKSIBOUINFO%>).hide();
              viewBetukutiCheckSibouDispKbn = 1;
          } else {
              $(<%= VIEWBETUKUTICHECKSIBOUINFO%>).show();
              viewBetukutiCheckSibouDispKbn = 0;
          }
      });
  <% } %>
}

});

</script>
