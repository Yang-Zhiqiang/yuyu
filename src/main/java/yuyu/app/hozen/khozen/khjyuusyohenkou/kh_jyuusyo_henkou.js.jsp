<%--
    kh_jyuusyo_henkou.js.jsp - 住所変更 JavaScript(JSP)
--%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khjyuusyohenkou.KhJyuusyoHenkouConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khjyuusyohenkou.KhJyuusyoHenkouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khjyuusyohenkou.KhJyuusyoHenkouUiBean" %>
<%@page import="yuyu.def.classification.C_Syorikngn" %>
<%@page import="yuyu.def.classification.C_SyorikahiKbn" %>
<%@page import="yuyu.def.classification.C_KidougmKbn" %>
<%@page import="yuyu.def.classification.C_Tdk" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<% KhJyuusyoHenkouUiBean uiBean = SWAKInjector.getInstance(KhJyuusyoHenkouUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);%>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<% if (uiBean.getPageNo() == PAGENO_REFERENCE1 ||uiBean.getPageNo() == PAGENO_REFERENCE2 ||
    uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT ||
    uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE1 ||uiBean.getPageNo() == PAGENO_REFERENCE2 ||
    uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
        <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
        <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
    <% } %>

    <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
           !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>
        <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
    <% } %>

<% } %>

<% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE1 ||uiBean.getPageNo() == PAGENO_REFERENCE2) { %>
    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
        <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
    <% } %>
<% } %>

<script type="text/javascript">

$(function(){

  <%
  if (uiBean.getPageNo() == PAGENO_REFERENCE1 ||uiBean.getPageNo() == PAGENO_REFERENCE2 ) { %>
    <%
    if (C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
        $(<%=SKSSAKUSEIBTN_BUTTONSYOUKAI%>).visible(true);
    <% } %>
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_REFERENCE1 ||uiBean.getPageNo() == PAGENO_REFERENCE2 ) { %>
    <%
    if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) { %>
        $(<%=KAKUNINBTN_FOOTERBUTTONS%>).visible(true);
    <% } %>
  <% } %>

 <% if (uiBean.getPageNo() == PAGENO_RESULT || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <% if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
        openReport("print", "_blank");
    <% } %>
 <% } %>

 <% if (uiBean.getPageNo() == PAGENO_REFERENCE1 || uiBean.getPageNo() == PAGENO_REFERENCE2) { %>

     <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
             !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()))) { %>

         showGroup(<%=HENKOUTUUSINSAKIINFO%>);
         showGroup(<%=HONNINKAKUNIN%>);
         showGroup(<%=TYHYSAKUSEIY%>);

         <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {%>

               inputToOutput(<%=TSINYNO_HENKOUTUUSINSAKIINFO %>);
               inputToOutput(<%=TSINADR1KJ_HENKOUTUUSINSAKIINFO %>);
               inputToOutput(<%=TSINADR2KJ_HENKOUTUUSINSAKIINFO %>);
               inputToOutput(<%=TSINADR3KJ_HENKOUTUUSINSAKIINFO %>);
               inputToOutput(<%=TSINTELNO_HENKOUTUUSINSAKIINFO %>);
               inputToOutput(<%=DAI2TSINTELNO_HENKOUTUUSINSAKIINFO %>);
               inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNINKAKUNIN %>);
               inputToOutput(<%=TYHYSAKUSEIYHKBN_TYHYSAKUSEIY %>);

               $(<%= IIC0001 %>).text("");

         <% } %>
     <% } %>
 <% } %>
 <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

     <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>

         showGroup(<%=HENKOUTUUSINSAKIINFO%>);
         showGroup(<%=HONNINKAKUNIN%>);
         showGroup(<%=TYHYSAKUSEIY%>);

     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_REFERENCE1 ||uiBean.getPageNo() == PAGENO_REFERENCE2 ) { %>
      <%
        if (C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {%>
          showGroup(<%=SKSOUHUSAKIINFO1%>);
          showGroup(<%=SKSOUHUSAKI2%>);
      <% } %>
  <% } %>
  <% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||uiBean.getPageNo() == PAGENO_SKSRESULT ) { %>
        showGroup(<%=SKSOUHUSAKIINFO1%>);
        showGroup(<%=SKSOUHUSAKI2%>);
  <% } %>

 <% if (uiBean.getPageNo() == PAGENO_REFERENCE1 || uiBean.getPageNo() == PAGENO_REFERENCE2 ||
    uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

     <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
         showGroup(<%=KOUTEIINFO%>);
     <% } %>

     <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

         showGroup(<%=KEKKAINPUTGROUP%>);

         <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {%>
              showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
         <% } %>

     <% } %>

 <% } %>

});
</script>
