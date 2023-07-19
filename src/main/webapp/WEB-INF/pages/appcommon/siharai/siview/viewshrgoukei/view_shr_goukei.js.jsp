<%--
    view_shr_goukei.js.jsp - 支払合計表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewshrgoukei.ViewShrGoukeiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewshrgoukei.ViewShrGoukeiUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewshrgoukei/view_shr_goukei.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewShrGoukeiUiBeanParam viewShrGoukeiUiBean = (ViewShrGoukeiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewShrGoukeiUiBean.isViewShrGoukeiInfoUmuSeigyo()) { %>
    showGroup(<%=HKTSHRGOUKEIINFO%>);

    <%
    if (viewShrGoukeiUiBean.isShrGoukeiHaitoukinDispFlg()) { %>
        showKoumoku(<%=HAITOUKIN_HKTSHRGOUKEIINFO%>);
    <% } %>

    <%
    if (viewShrGoukeiUiBean.isShrGoukeiSonotahaitoukinDispFlg()) { %>
        showKoumoku(<%=SONOTAHAITOUKIN_HKTSHRGOUKEIINFO%>);
    <% } %>

    <%
    if (viewShrGoukeiUiBean.isShrGoukeiMikeikapDispFlg()) { %>
        showKoumoku(<%=MIKEIKAPGAITOUKKN_HKTSHRGOUKEIINFO%>);
    <% } %>

    <%
    if (viewShrGoukeiUiBean.isShrGoukeiMisyuupDispFlg()) { %>
        showKoumoku(<%=MISYUUPGAITOUKKN_HKTSHRGOUKEIINFO%>);
    <% } %>

    <%
    if (viewShrGoukeiUiBean.isShrGoukeiZennouseisankgkDispFlg()) { %>
        showKoumoku(<%=ZENNOUSEISANKGK_HKTSHRGOUKEIINFO%>);
    <% } %>

    <%
    if (viewShrGoukeiUiBean.isShrGoukeiAzukarikingkDispFlg()) { %>
        showKoumoku(<%=AZUKARIKINGK_HKTSHRGOUKEIINFO%>);
    <% } %>

    <%
    if (viewShrGoukeiUiBean.isShrGoukeiKrkgkDispFlg()) { %>
        showKoumoku(<%=KRKGK_HKTSHRGOUKEIINFO%>);
    <% } %>

    $(<%=SHRGK_HKTSHRGOUKEIINFO + LABEL%>).parent().attr("rowspan","11");
    $(<%=SHRGK_HKTSHRGOUKEIINFO%>).parent().attr("rowspan","11");
    $(<%=TIENRISOKUKISANYMD_HKTSHRGOUKEIINFO + PREFIX%>).addClass('viewFirstCell');
    $(<%=TIENRSKNISSUU_HKTSHRGOUKEIINFO + SUFFIX%>).addClass('viewFirstCell');
    var viewShrGoukeiDispKbn = 0;
    <%
    if (viewShrGoukeiUiBean.isViewShrGoukeiSeigyo()) { %>
        $(<%=HKTSHRGOUKEIINFO + LABEL%>).addClass('toggletitle');

        <%
        if (viewShrGoukeiUiBean.isViewShrGoukeiDispFlg()) { %>
            $(<%= HKTSHRGOUKEIINFO%>).show();
        <%
        } else { %>
            $(<%= HKTSHRGOUKEIINFO%>).hide();
            viewShrGoukeiDispKbn = 1;
        <% } %>

        $(<%= HKTSHRGOUKEIINFO + LABEL%>).click(function(){
            if (viewShrGoukeiDispKbn == 0) {
                $(<%= HKTSHRGOUKEIINFO%>).hide();
                viewShrGoukeiDispKbn = 1;
            } else {
                $(<%= HKTSHRGOUKEIINFO%>).show();
                viewShrGoukeiDispKbn = 0;
            }
        });
    <% } %>

    <%
    if (viewShrGoukeiUiBean.isYenGoukeiInfoUmuSeigyo()) { %>
      showGroup(<%=YENGOUKEIINFO%>);

      <%
      if (viewShrGoukeiUiBean.isShrGoukeiHaitoukinDispFlg()) { %>
          showKoumoku(<%=YENKAHAITOUKIN_YENGOUKEIINFO%>);
      <% } %>

      <%
      if (viewShrGoukeiUiBean.isShrGoukeiSonotahaitoukinDispFlg()) { %>
          showKoumoku(<%=YENKASONOTAHAITOUKIN_YENGOUKEIINFO%>);
      <% } %>

      <%
      if (viewShrGoukeiUiBean.isShrGoukeiMikeikapDispFlg()) { %>
          showKoumoku(<%=YENKAMIKEIKAPGAITOUKKN_YENGOUKEIINFO%>);
      <% } %>

      <%
      if (viewShrGoukeiUiBean.isShrGoukeiMisyuupDispFlg()) { %>
          showKoumoku(<%=YENKAMISYUUPGAITOUKKN_YENGOUKEIINFO%>);
      <% } %>

      <%
      if (viewShrGoukeiUiBean.isShrGoukeiZennouseisankgkDispFlg()) { %>
          showKoumoku(<%=YENKAZENNOUSEISANKGK_YENGOUKEIINFO%>);
      <% } %>

      <%
      if (viewShrGoukeiUiBean.isShrGoukeiAzukarikingkDispFlg()) { %>
          showKoumoku(<%=YENKAAZUKARIKINGK_YENGOUKEIINFO%>);
      <% } %>

      <%
      if (viewShrGoukeiUiBean.isShrGoukeiKrkgkDispFlg()) { %>
          showKoumoku(<%=YENKAKRKGK_YENGOUKEIINFO%>);
      <% } %>

      $(<%=YENSHRGK_YENGOUKEIINFO + LABEL%>).parent().attr("rowspan","11");
      $(<%=YENSHRGK_YENGOUKEIINFO%>).parent().attr("rowspan","11");
      $(<%=YENTIENRISOKUKISANYMD_YENGOUKEIINFO + PREFIX%>).addClass('viewFirstCell');
      $(<%=YENTIENRSKNISSUU_YENGOUKEIINFO + SUFFIX%>).addClass('viewFirstCell');
      var yenShrGoukeiDispKbn = 0;
      <%
      if (viewShrGoukeiUiBean.isYenGoukeiSeigyo()) { %>
          $(<%=YENGOUKEIINFO + LABEL%>).addClass('toggletitle');

          <%
          if (viewShrGoukeiUiBean.isYenShrGoukeiDispFlg()) { %>
              $(<%= YENGOUKEIINFO%>).show();
          <%
          } else { %>
              $(<%= YENGOUKEIINFO%>).hide();
              yenShrGoukeiDispKbn = 1;
          <% } %>

          $(<%= YENGOUKEIINFO + LABEL%>).click(function(){
              if (yenShrGoukeiDispKbn == 0) {
                  $(<%= YENGOUKEIINFO%>).hide();
                  yenShrGoukeiDispKbn = 1;
              } else {
                  $(<%= YENGOUKEIINFO%>).show();
                  yenShrGoukeiDispKbn = 0;
              }
          });
      <% } %>
    <% } %>

  <% } %>

});

</script>
