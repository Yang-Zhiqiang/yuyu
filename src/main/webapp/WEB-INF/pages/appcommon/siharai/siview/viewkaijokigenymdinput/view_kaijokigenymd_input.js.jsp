<%--
    view_kaijokigenymd_input.js.jsp - 解除期限日入力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewkaijokigenymdinput.ViewKaijokigenymdInputSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewkaijokigenymdinput.ViewKaijokigenymdInputUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewkaijokigenymdinput/view_kaijokigenymd_input.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKaijokigenymdInputUiBeanParam viewKaijokigenymdInputUiBean = (ViewKaijokigenymdInputUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewKaijokigenymdInputUiBean.isViewKaijokigenymdInputFlg()) { %>
    showGroup(<%=VIEWKAIJOKIGENYMDINPUTINFO%>);
    viewKaijokigenymdInput();
  <% } %>

function viewKaijokigenymdInput() {
  var viewKaijokigenymdDispKbn = 0;
  <%
  if (viewKaijokigenymdInputUiBean.isViewKaijokigenymdSeigyo()) { %>
      $(<%=VIEWKAIJOKIGENYMDINPUTINFO + LABEL%>).addClass('toggletitle');

      <%
      if (viewKaijokigenymdInputUiBean.isViewKaijokigenymdDispFlg()) { %>
          $(<%= VIEWKAIJOKIGENYMDINPUTINFO%>).show();
      <%
      } else { %>
          $(<%= VIEWKAIJOKIGENYMDINPUTINFO%>).hide();
          viewKaijokigenymdDispKbn = 1;
      <% } %>

      $(<%= VIEWKAIJOKIGENYMDINPUTINFO + LABEL%>).click(function(){
          if (viewKaijokigenymdDispKbn == 0) {
              $(<%= VIEWKAIJOKIGENYMDINPUTINFO%>).hide();
              viewKaijokigenymdDispKbn = 1;
          } else {
              $(<%= VIEWKAIJOKIGENYMDINPUTINFO%>).show();
              viewKaijokigenymdDispKbn = 0;
          }
      });
  <% } %>
}

});

</script>
