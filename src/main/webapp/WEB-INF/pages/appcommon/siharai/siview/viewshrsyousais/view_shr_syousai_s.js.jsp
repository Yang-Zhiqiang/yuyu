<%--
    view_shr_syousai_s.js.jsp - 支払詳細表示（保険金） JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewshrsyousais.ViewShrSyousaiSSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewshrsyousais.ViewShrSyousaiSUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewshrsyousais/view_shr_syousai_s.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewShrSyousaiSUiBeanParam viewshrsyousaisUiBean = (ViewShrSyousaiSUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  showList(<%=HKTSHRMEISAISINFO%>);
  <%
  if (viewshrsyousaisUiBean.getHktshrMeisaisInfoDataSource().getAllData().size() > 0) { %>
      $(<%=HKTSHRMEISAISINFO%>).find(<%=SHR_SYOUSAI_S_LIST_CELL %>).each(function(){
        $(this).find("span").eq(1).before('<br/>');
        $(this).find("span").eq(2).before('<br/>');
        $(this).find("span").eq(3).before('<br/>');
      });

      var viewShrSyousaiSDisp = 0;
      <%
      if (viewshrsyousaisUiBean.isViewShrSyousaiSSeigyo()) { %>
        $(<%=HKTSHRMEISAISINFO + LABEL%>).addClass('toggletitle');

        <%
        if (viewshrsyousaisUiBean.isViewShrSyousaiSDispFlg()) { %>
            $(<%= HKTSHRMEISAISINFO%>).show();
        <%
        } else { %>
            $(<%= HKTSHRMEISAISINFO%>).hide();
            viewShrSyousaiSDisp = 1;
        <% } %>

        $(<%= HKTSHRMEISAISINFO + LABEL%>).click(function(){
          if (viewShrSyousaiSDisp == 0) {
              $(<%= HKTSHRMEISAISINFO%>).hide();
              viewShrSyousaiSDisp = 1;
          } else {
              $(<%= HKTSHRMEISAISINFO%>).show();
              viewShrSyousaiSDisp = 0;
          }
        });
      <% } %>
  <% } %>


});

</script>
