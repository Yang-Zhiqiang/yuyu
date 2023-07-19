<%--
    view_kakuninkoumoku.js.jsp - 確認項目 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewkakuninkoumoku.ViewKakuninkoumokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewkakuninkoumoku.ViewKakuninkoumokuUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewkakuninkoumoku/view_kakuninkoumoku.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKakuninkoumokuUiBeanParam viewKakuninkoumokuUiBean = (ViewKakuninkoumokuUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  showList(<%=VIEWKAKUNINKOUMOKUINFO%>);
  <%
  if (viewKakuninkoumokuUiBean.getViewKakuninkoumokuInfoDataSource().getAllData().size() > 0) { %>
      var viewKakuninkoumokuDispKbn = 0;
      <%
      if (viewKakuninkoumokuUiBean.isViewKakuninkoumokuSeigyo()) { %>
        $(<%=VIEWKAKUNINKOUMOKUINFO + LABEL%>).addClass('toggletitle');

        <%
        if (viewKakuninkoumokuUiBean.isViewKakuninkoumokuDispFlg()) { %>
            $(<%= VIEWKAKUNINKOUMOKUINFO%>).show();
        <%
        } else { %>
            $(<%= VIEWKAKUNINKOUMOKUINFO%>).hide();
            viewKakuninkoumokuDispKbn = 1;
        <% } %>

        $(<%= VIEWKAKUNINKOUMOKUINFO + LABEL%>).click(function(){
          if (viewKakuninkoumokuDispKbn == 0) {
              $(<%= VIEWKAKUNINKOUMOKUINFO%>).hide();
              viewKakuninkoumokuDispKbn = 1;
          } else {
              $(<%= VIEWKAKUNINKOUMOKUINFO%>).show();
              viewKakuninkoumokuDispKbn = 0;
          }
        });
      <% } %>
  <% } %>


});

</script>
