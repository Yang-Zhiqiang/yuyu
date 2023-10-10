<%--
    kh_syouken_saihakkou.js.jsp - 証券再発行 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khsyoukensaihakkou.KhSyoukenSaihakkouConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khsyoukensaihakkou.KhSyoukenSaihakkouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khsyoukensaihakkou.KhSyoukenSaihakkouUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_KidougmKbn" %>
<%@page import="yuyu.def.classification.C_KaiyksyorikahiKbn" %>
<%@page import="yuyu.def.classification.C_Syorikngn" %>
<%@page import="yuyu.def.classification.C_SyorikahiKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<% KhSyoukenSaihakkouUiBean uiBean = SWAKInjector.getInstance(KhSyoukenSaihakkouUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);%>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE ||
       uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT ||
       uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
       uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
      <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
         || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
         || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
         <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
     <% } %>

   <% } %>

    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>

    <% if (uiBean.getPageNo() == PAGENO_REFERENCE ||
           uiBean.getPageNo() == PAGENO_CONFIRM ||
           uiBean.getPageNo() == PAGENO_RESULT) { %>
        <% if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
            && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()))
            || !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
            <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
        <% } %>
    <% } %>

    <% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
           uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
        <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
    <% } %>

  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp" />
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp"/>

      <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
         || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
         || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

         <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
         <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
      <% } %>
<% } %>

<script type="text/javascript">
$(function(){

  <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
     || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
     || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

     showGroup(<%=KOUTEIINFO%>);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

      $(<%= KAKUNINBTN_FOOTERBUTTONS2 %>).visible(true);
    <% } %>

    <% if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

      $(<%= SKSSAKUSEIBTN_BUTTONSYOUKAI %>).visible(true);
    <% } %>

    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%= SYOSAIHKIINFO %>);

      showGroup(<%= INSIZEISHRINFO %>);

      showGroup(<%= HONNINKAKNIINFO %>);

      showGroup(<%= HASSOUKBNIINFO %>);

    <% } %>

    <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
      && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>

      showGroup(<%= SYOSAIHKIINFO %>);

      showGroup(<%= INSIZEISHRINFO %>);

      showGroup(<%= HONNINKAKNIINFO %>);

      showGroup(<%= HASSOUKBNIINFO %>);

       inputToOutput(<%= SYOUKENSAIHKKBN_SYOSAIHKIINFO %>);

       inputToOutput(<%= INSIZEISHRYOUHIKBN_INSIZEISHRINFO %>);

       inputToOutput(<%= HONNINKAKNINKEKKAKBN_HONNINKAKNIINFO %>);

       inputToOutput(<%= HASSOUKBN_HASSOUKBNIINFO %>);

     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_REFERENCE
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT) { %>

      <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
        || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
        || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
        || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

        showGroup(<%= KEKKAINFO %>);

        <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

          showKoumoku(<%= SASIMODOSISAKIKBN_KEKKAINFO %>);
      <% } %>
    <% } %>
  <% } %>



  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
      && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()))
      || !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%= SYOSAIHKIINFO %>);

      showGroup(<%= INSIZEISHRINFO %>);

      showGroup(<%= HONNINKAKNIINFO %>);

      showGroup(<%= HASSOUKBNIINFO %>);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_RESULT || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <% if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
        openReport("print", "_blank");
    <% } %>
  <% } %>

});
//-->
</script>
