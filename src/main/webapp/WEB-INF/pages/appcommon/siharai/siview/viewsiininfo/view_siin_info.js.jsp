<%--
    view_siin_info.js.jsp - 死因情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsiininfo.ViewSiinInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsiininfo.ViewSiinInfoUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsiininfo/view_siin_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSiinInfoUiBeanParam viewSiinInfoUiBean = (ViewSiinInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

 <%
    if (viewSiinInfoUiBean.isViewSiinInfoFlg()) { %>
       showGroup(<%=VIEWSIININFO%>);

       <%
          if (viewSiinInfoUiBean.isViewSiinInfoSeigyo()) { %>

             $(<%=VIEWSIININFO + LABEL%>).addClass('toggletitle');
             var viewSiinInfo = 0;

             <%
                if (viewSiinInfoUiBean.isViewSiinInfoDispFlg()) { %>
                   $(<%= VIEWSIININFO%>).show();
             <%
                } else { %>
                   $(<%= VIEWSIININFO%>).hide();
                   viewSiinInfo = 1;
            <% } %>

            $(<%= VIEWSIININFO + LABEL%>).click(function(){
              if (viewSiinInfo == 0) {
                  $(<%= VIEWSIININFO%>).hide();
                  viewSiinInfo = 1;
              } else {
                  $(<%= VIEWSIININFO%>).show();
                  viewSiinInfo = 0;
              }
           });
       <% } %>
  <% } %>

});

</script>
