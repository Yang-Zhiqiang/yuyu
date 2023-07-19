<%--
    view_kokuhan_check.js.jsp - 告反チェック JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewkokuhancheck.ViewKokuhanCheckSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewkokuhancheck.ViewKokuhanCheckUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewkokuhancheck/view_kokuhan_check.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKokuhanCheckUiBeanParam viewKokuhanCheckUiBean = (ViewKokuhanCheckUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewKokuhanCheckUiBean.isViewKokuhanCheckFlg()) { %>
    showGroup(<%=VIEWKOKUHANCHECKINFO%>);
    viewKokuhanCheck();

    <%
       if (!viewKokuhanCheckUiBean.isViewKokuhanCheckInputDispFlg()) { %>
          $(<%=KOKUHANCHECOMMENT1_VIEWKOKUHANCHECKINFO%>).parent().addClass('dispviewfirstCell');
          $(<%=KOKUHANCHECOMMENT2_VIEWKOKUHANCHECKINFO%>).parent().addClass('dispviewfirstCell');
          $(<%=KOKUHANCHECOMMENT3_VIEWKOKUHANCHECKINFO%>).parent().addClass('dispviewfirstCell');
          $(<%=KOKUHANCHECOMMENT4_VIEWKOKUHANCHECKINFO%>).parent().addClass('dispviewfirstCell');
          $(<%=KOKUHANCHECOMMENT5_VIEWKOKUHANCHECKINFO%>).parent().addClass('dispviewfirstCell');
          $(<%=KOKUHANCHECOMMENT6_VIEWKOKUHANCHECKINFO%>).parent().addClass('dispviewfirstCell');
          $(<%=KOKUHANCHECOMMENT7_VIEWKOKUHANCHECKINFO%>).parent().addClass('dispviewfirstCell');
          $(<%=KOKUHANCHECOMMENT8_VIEWKOKUHANCHECKINFO%>).parent().addClass('dispviewfirstCell');
    <% } %>
  <% } %>

function viewKokuhanCheck() {
   var viewKokuhanCheckDispKbn = 0;
   <%
   if (viewKokuhanCheckUiBean.isViewKokuhanCheckSeigyo()) { %>
       $(<%=VIEWKOKUHANCHECKINFO + LABEL%>).addClass('toggletitle');

       <%
       if (viewKokuhanCheckUiBean.isViewKokuhanCheckDispFlg()) { %>
           $(<%= VIEWKOKUHANCHECKINFO%>).show();
       <%
       } else { %>
           $(<%= VIEWKOKUHANCHECKINFO%>).hide();
           viewKokuhanCheckDispKbn = 1;
       <% } %>

       $(<%= VIEWKOKUHANCHECKINFO + LABEL%>).click(function(){
           if (viewKokuhanCheckDispKbn == 0) {
               $(<%= VIEWKOKUHANCHECKINFO%>).hide();
               viewKokuhanCheckDispKbn = 1;
           } else {
               $(<%= VIEWKOKUHANCHECKINFO%>).show();
               viewKokuhanCheckDispKbn = 0;
           }
       });
   <% } %>
}

});

</script>
