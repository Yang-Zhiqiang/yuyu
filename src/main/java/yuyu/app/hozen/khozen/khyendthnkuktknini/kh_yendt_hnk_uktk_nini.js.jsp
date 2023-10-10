<%--
    kh_yendt_hnk_uktk_nini.js.jsp - 円建変更受付（任意請求） JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khyendthnkuktknini.KhYendtHnkUktkNiniConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khyendthnkuktknini.KhYendtHnkUktkNiniSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khyendthnkuktknini.KhYendtHnkUktkNiniUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil" %>

<% KhYendtHnkUktkNiniUiBean uiBean = SWAKInjector.getInstance(KhYendtHnkUktkNiniUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);%>

<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
   commonViewInBean.setCommonViewUiBeanParam(uiBean);
   commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<%  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
        uiBean.getPageNo() == PAGENO_REFERENCE ||
        uiBean.getPageNo() == PAGENO_CONFIRM ||
        uiBean.getPageNo() == PAGENO_RESULT ||
        uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
        uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>
<% }%>


  <%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

      <%if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

           <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>

    <% } %>
<% } %>


  <%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
        uiBean.getPageNo() == PAGENO_REFERENCE ||
        uiBean.getPageNo() == PAGENO_CONFIRM ||
        uiBean.getPageNo() == PAGENO_RESULT) { %>

      <%if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

           <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
           <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>

    <% } %>
<% } %>


  <%if (uiBean.getPageNo() == PAGENO_REFERENCE ||
        uiBean.getPageNo() == PAGENO_CONFIRM ||
        uiBean.getPageNo() == PAGENO_RESULT ||
        uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
        uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

    <%if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
          !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>

        <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>

    <% } %>
<% } %>


<script type="text/javascript"><!--
$(function(){


<%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
      uiBean.getPageNo() == PAGENO_REFERENCE ||
      uiBean.getPageNo() == PAGENO_CONFIRM ||
      uiBean.getPageNo() == PAGENO_RESULT) { %>

      <%if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

            showGroup(<%=KOUTEIINFO%>);

    <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

      <%if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

            showGroup(<%= YENDTHNKINFO %>);

            $(<%= YENDTHNKINFO_LABEL %>).html("●円建変更受付（任意請求）入力");

       <% } else { %>

          <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>

            showGroup(<%= YENDTHNKINFO %>);

            $(<%= YENDTHNKINFO_LABEL %>).html("●円建変更受付（任意請求）入力");

            inputToOutput(<%= SYORUIUKEYMD_YENDTHNKINFO%>);

          <% } %>

        <% } %>
    <% } %>


<%  if (uiBean.getPageNo() == PAGENO_REFERENCE) {  %>

    <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
           !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>

            showGroup(<%= NEWSONOTATKINFO %>);
            <% if (uiBean.getYendthnktkhukainfo() != null) {%>
                   $(<%=YENDTHNKTKHUKAINFO_NEWSONOTATKINFO%>).html('<%=uiBean.getYendthnktkhukainfo()%>');
            <% } %>

            showGroup(<%= YENDTHNKINFO %>);
            showGroup(<%= YENDTHNKINFO2 %>);

            <% if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) { %>
                showGroup(<%= NENKINKAISIJITENNKGNS %>);

            <% } else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyouhinHanteiKbn()) { %>
                showGroup(<%= YENDTHNKJITENHOSYOUINFO %>);
            <% } %>

    <% } %>

    <% if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

         $(<%= SKSSAKUSEIBTN_BUTTONSYOUKAI %>).visible(true);

    <%  } %>

    <%if (uiBean.getKawaseRateMinasiKbn() == KAWASERATEMINASIKBN_SEIJYOURATE) { %>

        <%  if (!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {%>

             $(<%= KAKUNINBTN_FOOTERBUTTONS %>).visible(true);

        <%  } %>


        <%  if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

                showGroup(<%= HONNINKAKUNIN %>);

                showGroup(<%= HASSOUKUBUN %>);

                showGroup(<%= KEKKAINPUTGROUP %>);

        <% } else { %>

                <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                       !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>

                       showGroup(<%= HONNINKAKUNIN %>);

                       inputToOutput(<%= HONNINKAKNINKEKKAKBN_HONNINKAKUNIN %>);

                       showGroup(<%= HASSOUKUBUN %>);

                       inputToOutput(<%= HASSOUKBN_HASSOUKUBUN %>);

                <% } %>

                <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {%>

                       showGroup(<%=KEKKAINPUTGROUP%>);

                       showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);

                <% } %>

        <%  } %>

    <%  } %>

<%  } %>


<%  if (uiBean.getPageNo() == PAGENO_CONFIRM ||
        uiBean.getPageNo() == PAGENO_RESULT) {  %>

    <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
           !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>

            showGroup(<%= NEWSONOTATKINFO %>);
            <% if (uiBean.getYendthnktkhukainfo() != null) {%>
                   $(<%=YENDTHNKTKHUKAINFO_NEWSONOTATKINFO%>).html('<%=uiBean.getYendthnktkhukainfo()%>');
            <% } %>

            showGroup(<%= YENDTHNKINFO %>);
            showGroup(<%= YENDTHNKINFO2 %>);

            <% if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) { %>
                showGroup(<%= NENKINKAISIJITENNKGNS %>);

            <% } else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyouhinHanteiKbn()) { %>
                showGroup(<%= YENDTHNKJITENHOSYOUINFO %>);
            <% } %>

            showGroup(<%= HONNINKAKUNIN %>);

            showGroup(<%= HASSOUKUBUN %>);

    <% } %>


    showGroup(<%= KEKKAINPUTGROUP %>);

    <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {%>

            showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);

    <% } %>

<%  } %>


<%  if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
        uiBean.getPageNo() == PAGENO_SKSRESULT) {  %>

    <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
           !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>

            showGroup(<%= NEWSONOTATKINFO %>);
            <% if (uiBean.getYendthnktkhukainfo() != null) {%>
                   $(<%=YENDTHNKTKHUKAINFO_NEWSONOTATKINFO%>).html('<%=uiBean.getYendthnktkhukainfo()%>');
            <% } %>

            showGroup(<%= YENDTHNKINFO %>);
            showGroup(<%= YENDTHNKINFO2 %>);

            <% if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) { %>
                showGroup(<%= NENKINKAISIJITENNKGNS %>);

            <% } else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyouhinHanteiKbn()) { %>
                showGroup(<%= YENDTHNKJITENHOSYOUINFO %>);
            <% } %>

    <% } %>
<%  } %>


<%  if (uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

     <% if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
            openReport("print", "_blank");
     <% } %>

 <% } %>


});
//-->
</script>
