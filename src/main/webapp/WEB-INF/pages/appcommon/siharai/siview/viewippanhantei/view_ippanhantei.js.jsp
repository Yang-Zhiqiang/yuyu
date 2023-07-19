<%--
    view_ippanhantei.js.jsp - 一般判定 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewippanhantei.ViewIppanhanteiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewippanhantei.ViewIppanhanteiUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewippanhantei/view_ippanhantei.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewIppanhanteiUiBeanParam viewIppanhanteiUiBean = (ViewIppanhanteiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewIppanhanteiUiBean.isViewIppanhanteiFlg()) { %>
    showGroup(<%=VIEWIPPANHANTEIINFO%>);
    viewIppanhantei();
  <%
  if (!viewIppanhanteiUiBean.isViewIppanhanteiInputDispFlg()) { %>
      $(<%=IPPANHANTEICOMMENT1_VIEWIPPANHANTEIINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=IPPANHANTEICOMMENT2_VIEWIPPANHANTEIINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=IPPANHANTEICOMMENT3_VIEWIPPANHANTEIINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=IPPANHANTEICOMMENT4_VIEWIPPANHANTEIINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=IPPANHANTEICOMMENT5_VIEWIPPANHANTEIINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=IPPANHANTEICOMMENT6_VIEWIPPANHANTEIINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=IPPANHANTEIGOUKEICOMMENT_VIEWIPPANHANTEIINFO%>).parent().addClass('dispviewfirstCell');
   <% } %>
  <% } %>

function viewIppanhantei() {
  var viewIppanhanteiDispKbn = 0;
  <%
    if (viewIppanhanteiUiBean.isViewIppanhanteiSeigyo()) { %>
      $(<%=VIEWIPPANHANTEIINFO + LABEL%>).addClass('toggletitle');

     <%
       if (viewIppanhanteiUiBean.isViewIppanhanteiDispFlg()) { %>
         $(<%= VIEWIPPANHANTEIINFO%>).show();
     <%
       } else { %>
         $(<%= VIEWIPPANHANTEIINFO%>).hide();
         viewIppanhanteiDispKbn = 1;
  <% } %>

  $(<%= VIEWIPPANHANTEIINFO + LABEL%>).click(function(){
    if (viewIppanhanteiDispKbn == 0) {
      $(<%= VIEWIPPANHANTEIINFO%>).hide();
      viewIppanhanteiDispKbn = 1;
     } else {
      $(<%= VIEWIPPANHANTEIINFO%>).show();
      viewIppanhanteiDispKbn = 0;
      }
  });
 <% } %>
}


});

</script>
