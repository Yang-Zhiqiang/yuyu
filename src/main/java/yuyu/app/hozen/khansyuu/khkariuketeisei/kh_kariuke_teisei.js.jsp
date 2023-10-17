<%--
    kh_kariuke_teisei.js.jsp - 仮受訂正 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khkariuketeisei.KhKariukeTeiseiConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khkariuketeisei.KhKariukeTeiseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khansyuu.khkariuketeisei.KhKariukeTeiseiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_KrkteiseiKbn" %>
<% KhKariukeTeiseiUiBean uiBean = SWAKInjector.getInstance(KhKariukeTeiseiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtokusin/view_tokusin.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>
<% } %>

<script type="text/javascript">
$(function(){
<%
  if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
    $(<%= KARIUKEKININFO + DIV%>).css("margin-top","-1px");
    $(<%= KRKTEISEIINPUTINFO + DIV%>).css("margin-top","-1px");
    $(<%= KRKNO_KARIUKEKININFO + SPAN%>).parent().removeClass("c2").addClass("c1");
<% } %>
<%-- <%
 if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <%
      if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>--%>
 <%--        openReport('print', '_blank');
    <% } %>
<% } %>  --%>
<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <%
      if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())) { %>
      showGroup(<%= SOUKINSAKIINFO%>);
      showGroup(<%= KOUZAINFO%>);
      showGroup(<%= HASSOUKBNINFO%>);
      showGroup(<%= HNKNRIYUUKBNINFO%>);
    <%
    } else if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) { %>
      showGroup(<%= HASSOUKBNINFO%>);
      showGroup(<%= HNKNRIYUUKBNINFO%>);
    <% } %>

    <%
      if (uiBean.getJyutoukaisuuy() != null && uiBean.getJyutoukaisuuy() != 0) { %>

        $(<%= JYUTOUKAISUUY_KARIUKEKININFO%>).parent().visible(true);
        $(<%= JYUTOUKAISUUY_NYUUKINJISSEKIINFO_UNIT%>).parent().visible(true);
        $(<%= JYUTOUKAISUUM_KARIUKEKININFO%>).visible(false);
        $(<%= JYUTOUKAISUUM_NYUUKINJISSEKIINFO_UNIT%>).visible(false);
    <% }
    else { %>
        $(<%= JYUTOUKAISUUY_KARIUKEKININFO%>).visible(false);
        $(<%= JYUTOUKAISUUY_NYUUKINJISSEKIINFO_UNIT%>).visible(false);
        $(<%= JYUTOUKAISUUM_KARIUKEKININFO%>).parent().visible(true);
        $(<%= JYUTOUKAISUUM_NYUUKINJISSEKIINFO_UNIT%>).parent().visible(true);
    <% } %>
    <%
      if (C_KrkteiseiKbn.HANDKRK.eq(uiBean.getKrkteiseikbn())) { %>

        showKoumoku(<%=DENKARIKANJYONO_KRKTEISEIINPUTINFO%>);
    <% } %>
    $(<%= JYUTOUKAISUUY_NYUUKINJISSEKIINFO_UNIT%>).addClass("rightMargin");

<% } %>
<%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <%
      if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())) { %>
        $(<%=BANKCD_KOUZAINFO%>).addClass("bfrFirstCell");
        $(<%=SITENCD_KOUZAINFO%>).addClass("bfrFirstCell");
    <%
    } else if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) { %>
       showGroup(<%= HNKNSAKICREDITINFO%>);
    <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <%
      if (uiBean.getDenkarikanjyonoFlg()) { %>
      $(<%= DENKARIKANJYONO_KRKTEISEIINPUTINFO + LABEL %>).required(true);
    <% } %>
    <%
      if (uiBean.getHnknriyuukbnFlg()) { %>
      $(<%= SHRRIYUUKBN_HNKNRIYUUKBNINFO + LABEL %>).required(true);
    <% } %>
<% } %>

});
</script>
