<%--
    sk_hubi_kaisyou.js.jsp - 新契約不備解消 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.SkHubiKaisyouConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.SkHubiKaisyouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.SkHubiKaisyouUiBean" %>
<%@page import="yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.HubiListDataSourceBean" %>
<%@page import="java.util.List" %>
<%@page import="yuyu.def.classification.C_KaisyoutaisyouKbn" %>
<%@page import="yuyu.def.classification.C_KidougmKbn" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<% SkHubiKaisyouUiBean uiBean = SWAKInjector.getInstance(SkHubiKaisyouUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>
<% commonViewInBean.setCommonViewUiBeanParam(uiBean); %>
<%
if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
<% } %>
<%
if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM ||
      uiBean.getPageNo() == PAGENO_RESULT) { %>

      $(<%= CLASS_COLSPAN_1 %>).attr('colspan', '1');
      $(<%= CLASS_COLSPAN_5 %>).attr('colspan', '5');
      $(<%= CLASS_ROWSPAN_3 %>).attr('rowspan', '3');
      $(<%= CLASS_ROWSPAN_4 %>).attr('rowspan', '4');

   <% } %>

    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM
        || uiBean.getPageNo() == PAGENO_RESULT) { %>

        showList(<%= TORIATUKAITYUUIINFO %>);

      <% } %>

    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
        <% List<HubiListDataSourceBean> hubiListDataSourceBeanLst = uiBean.getHubiListDataSource().getAllData();

           for (int iCnt = 0; iCnt < hubiListDataSourceBeanLst.size(); iCnt++ ) { %>
             <% HubiListDataSourceBean hubiListDataSourceBean = hubiListDataSourceBeanLst.get(iCnt);
               if (!((hubiListDataSourceBean.getDisphassinymd() != null) && (hubiListDataSourceBean.getDispkaisyouymd() == null))) {%>
                $(<%= DISPKAISYOUTAISYOU_HUBILIST(iCnt) %>).visible(false);
            <%}%>
        <%}%>
        <% if (IMUSATEIIRAIHYJCTRLFLG_HYOUJI.equals(uiBean.getImusateiiraihyjctrlflg())) { %>
           $(<%= IMUSATEISATEIKEKKA_IMUSATEITENSOU %>).visible(true);
           $(<%= IMUTNSKETSYACD_IMUSATEITENSOU %>).visible(true);
           $(<%= IMUSATEICOMMENTGAMEN_IMUSATEITENSOU %>).visible(true);
        <% } %>
    <% } %>

    <% if ((uiBean.getPageNo() == PAGENO_CONFIRM) ||  (uiBean.getPageNo() == PAGENO_RESULT)) { %>
        <% List<HubiListDataSourceBean> hubiListDataSourceBeanLst = uiBean.getHubiListDataSource().getAllData();

           for (int iCnt = 0; iCnt < hubiListDataSourceBeanLst.size(); iCnt++ ) { %>
             <% HubiListDataSourceBean hubiListDataSourceBean = hubiListDataSourceBeanLst.get(iCnt);
               if (C_KaisyoutaisyouKbn.TAISYOU.eq(hubiListDataSourceBean.getDispkaisyoutaisyoukbn())) {%>
                $(<%= DISPKAISYOUYMD_HUBILIST(iCnt) %>).css({color:"red"});
            <%}%>
        <%}%>
        <% if (IMUSATEIIRAIHYJCTRLFLG_HYOUJI.equals(uiBean.getImusateiiraihyjctrlflg())) { %>
           $(<%= IMUSATEISATEIKEKKA_IMUSATEITENSOU %>).visible(true);
           $(<%= IMUTNSKETSYACD_IMUSATEITENSOU %>).visible(true);
           $(<%= IMUSATEICOMMENTGAMEN_IMUSATEITENSOU %>).visible(true);
        <% } %>
    <% } %>

     <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
        <% if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) { %>

           $(<%= SYOKIGAMENHEBTN_FOOTERBUTTONS %>).visible(true);
           $(<%= SYOKIGAMENHEBTNBYWORKFLOW_FOOTERBUTTONS %>).visible(false);

        <% } else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {%>

           $(<%= SYOKIGAMENHEBTN_FOOTERBUTTONS %>).visible(false);
           $(<%= SYOKIGAMENHEBTNBYWORKFLOW_FOOTERBUTTONS %>).visible(true);

        <% } %>
     <% } %>

      <% if (uiBean.getPageNo() == PAGENO_SELECTDATA) { %>
          $(<%= MOSNO_BASEINFO %>).parent().removeClass('c1').addClass('c2');
          $(<%= NYUURYOKULINK_LABEL %>).visible(false);
      <% } %>
});
//-->
</script>
