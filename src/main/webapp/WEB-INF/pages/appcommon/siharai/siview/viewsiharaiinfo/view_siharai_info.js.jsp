<%--
    view_siharai_info.js.jsp - 支払情報 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParam" %>
<%@page import="yuyu.def.classification.C_SUketoriHouhouKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsiharaiinfo/view_siharai_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSiharaiInfoUiBeanParam viewSiharaiInfoUiBean = (ViewSiharaiInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

 <%
  if (!viewSiharaiInfoUiBean.isViewSiharaiInfoYenknsnKijyunYmdFlg()) { %>
    $(<%=SHRKWSRATEKJNYMD_VIEWSIHARAIINFO%>).parent().parent().visible(false);
  <% } %>

 <%
  if (!viewSiharaiInfoUiBean.isViewSiharaiInfoGaikaknsnKijyunYmdFlg()) { %>
    $(<%=GAIKAKNSNKWSRATEKJYMD_VIEWSIHARAIINFO%>).parent().parent().visible(false);
  <% } %>

  <%
  if (viewSiharaiInfoUiBean.isViewSiharaiInfoDispHantei()) { %>
    showGroup(<%=VIEWSIHARAIINFO1%>);
  <% } %>

  var viewSiharaiInfoDispKbn = 0;
  <%
  if (viewSiharaiInfoUiBean.isViewSiharaiInfoSeigyo()) { %>
      $(<%=VIEWSIHARAIINFO + LABEL%>).addClass('toggletitle');

      <%
      if (viewSiharaiInfoUiBean.isViewSiharaiInfoDispFlg()) { %>
          $(<%= VIEWSIHARAIINFO%>).show();
          <%
            if (viewSiharaiInfoUiBean.isViewSiharaiInfoDispHantei()) { %>
            $(<%= VIEWSIHARAIINFO1%>).show();
          <% } %>
      <%
      } else { %>
          $(<%= VIEWSIHARAIINFO%>).hide();
          <%
            if (viewSiharaiInfoUiBean.isViewSiharaiInfoDispHantei()) { %>
            $(<%= VIEWSIHARAIINFO1%>).hide();
          <% } %>
          viewSiharaiInfoDispKbn = 1;
      <% } %>

      $(<%= VIEWSIHARAIINFO + LABEL%>).click(function(){
          if (viewSiharaiInfoDispKbn == 0) {
              $(<%= VIEWSIHARAIINFO%>).hide();
              <%
                if (viewSiharaiInfoUiBean.isViewSiharaiInfoDispHantei()) { %>
                $(<%= VIEWSIHARAIINFO1%>).hide();
              <% } %>
              viewSiharaiInfoDispKbn = 1;
            } else {
              $(<%= VIEWSIHARAIINFO%>).show();
              <%
                if (viewSiharaiInfoUiBean.isViewSiharaiInfoDispHantei()) { %>
                $(<%= VIEWSIHARAIINFO1%>).show();
              <% } %>
              viewSiharaiInfoDispKbn = 0;
          }
      });
  <% } %>

});

</script>
