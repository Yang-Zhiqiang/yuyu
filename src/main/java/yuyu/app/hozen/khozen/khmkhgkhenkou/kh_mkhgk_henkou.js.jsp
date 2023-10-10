<%--
    kh_mkhgk_henkou.js.jsp - 目標額変更 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khmkhgkhenkou.KhMkhgkHenkouConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khmkhgkhenkou.KhMkhgkHenkouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khmkhgkhenkou.KhMkhgkHenkouUiBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<% KhMkhgkHenkouUiBean uiBean = SWAKInjector.getInstance(KhMkhgkHenkouUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);%>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||uiBean.getPageNo() == PAGENO_REFERENCE ||
    uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT ||
    uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>
<% } %>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||uiBean.getPageNo() == PAGENO_REFERENCE ||
    uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
<% } %>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } else { %>
      <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
             !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
            <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
      <% } %>
<% } %>

<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||  uiBean.getPageNo() == PAGENO_REFERENCE ||
         uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

      <% if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
             $(<%= KOUTEIINFO + DIV%>).visible(false);
      <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
       <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
           showGroup(<%= MKHGKHENKOUINFO%>);
           showGroup(<%= MKHGKINFO%>);
       <% } else { %>
          <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
               showGroup(<%= MKHGKHENKOUINFO%>);
               showGroup(<%= MKHGKINFO%>);
               inputToOutput(<%= SYORUIUKEYMD_SPAN%>);
               inputToOutput(<%= TARGETTKMKHTKBN_MKHGKINFO%>);
          <% }
          }
       } %>

  <% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
          uiBean.getPageNo() == PAGENO_RESULT) { %>
       <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
            <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
               showGroup(<%= MKHGKHENKOUINFO%>);
               showGroup(<%= MKHGKINFO%>);
            <% } %>
       <% } else { %>
            showGroup(<%= MKHGKHENKOUINFO%>);
            showGroup(<%= MKHGKINFO%>);
       <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
            showGroup(<%= MKHGKHENKOUINFO%>);
            showGroup(<%= MKHGKINFO%>);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
      <% if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
           $(<%=SKSSAKUSEIBTN_BUTTONSYOUKAI%>).visible(true);
      <% } %>

      <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
           showGroup(<%=HONNINKAKUNIN%>);
           showGroup(<%=HASSOUKUBUN%>);
      <% } %>

      <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
             !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
           showGroup(<%=HONNINKAKUNIN%>);
           showGroup(<%=HASSOUKUBUN%>);
           inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNINKAKUNIN%>);
           inputToOutput(<%=HASSOUKBN_HASSOUKUBUN%>);
      <% } %>

      <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
           showGroup(<%=KEKKAINPUTGROUP%>);
      <% } else if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
           showGroup(<%=KEKKAINPUTGROUP%>);
           showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
      <% } %>

      <% if(!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
           $(<%=KAKUNINBTN_FOOTERBUTTONS%>).visible(true);
      <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>

      <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
           if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
           showGroup(<%=HONNINKAKUNIN%>);
           showGroup(<%=HASSOUKUBUN%>);
           <% } %>
      <% } else { %>
           showGroup(<%=HONNINKAKUNIN%>);
           showGroup(<%=HASSOUKUBUN%>);
      <% } %>

      <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
           showGroup(<%=KEKKAINPUTGROUP%>);
      <% } else if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
           showGroup(<%=KEKKAINPUTGROUP%>);
           showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
      <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
        openReport("print", "_blank");
  <% } %>

});
//-->
</script>
