<%--
    kh_yendt_hnk_hr_shr.js.jsp - 円建変更時返戻金支払 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khyendthnkhrshr.KhYendtHnkHrShrConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khyendthnkhrshr.KhYendtHnkHrShrSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khyendthnkhrshr.KhYendtHnkHrShrUiBean" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.def.classification.C_Khhrshrjiyuu" %>
<%@page import="jp.co.slcs.swak.number.BizCurrency" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_InputShrhousiteiKbn" %>
<% KhYendtHnkHrShrUiBean uiBean = SWAKInjector.getInstance(KhYendtHnkHrShrUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);%>

<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
       uiBean.getPageNo() == PAGENO_REFERENCE ||
       uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT ||
       uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
       uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
       uiBean.getPageNo() == PAGENO_REFERENCE ||
       uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
    if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
      <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
  <% } %>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  <%
    if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
      <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
  <% } %>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE ||
       uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
  <% } %>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
       uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
<% }%>

<script type="text/javascript"><!--
$(function(){

<%
  if (uiBean.getPageNo() != PAGENO_INPUTKEY) { %>
      <%
      if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
        $(<%= KOUTEIINFO + DIV%>).visible(false);
    <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
  $(<%= KHHRSHRJIYUUINFO + DIV%>).css("margin-top", "-1px");
<% }%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>
        showGroup(<%=SHIHARAISYORINYUURYOKUINFO%>);
      <%
        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {%>
          inputToOutput("#syoruiukeymdSpan > *");
      <% } %>
  <% } %>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
  <%
    if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
      <%
        if (C_Khhrshrjiyuu.KYKSB.equals(uiBean.getKhhrshrjiyuu())) { %>
          showGroup(<%=SHSNMINFO%>);
          showGroup(<%=SHSKADRINFO%>);
      <% } %>
      <%
        if (C_Khhrshrjiyuu.TUUJYOU.equals(uiBean.getKhhrshrjiyuu())) { %>
          showGroup(<%=KHSKSSAKUSEIJIYUUINFO%>);
      <% } %>
  <% } %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
      showGroup(<%=SHIHARAISYORINYUURYOKUINFO%>);
      showGroup(<%=SIHARAINAIYOUINFOGK%>);
      $(<%= ROWSPAN2 %>).attr('rowspan', '2');
      $(<%= COLSPAN1 %>).attr('colspan', '1');
      $(".disptienrskkisanymdnissuu_data").removeClass("alignRight");
  <% } %>
  <%
    if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
      $(<%=SKSSAKUSEIBTN_REFERENCEBUTTONS%>).visible(true);
  <% } %>

  <%
    if ((!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
         !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) &&
         !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>

      <%
        if (C_Khhrshrjiyuu.KYKSB.equals(uiBean.getKhhrshrjiyuu())) { %>
          showGroup(<%=KYKSYASZKINFO%>);
          showGroup(<%=KYKSYASZKINFO2%>);

          <%
            if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
              inputToOutput(<%=KYKSYASZKNMKN_KYKSYASZKINFO%>);
              inputToOutput(<%=KYKSYASZKNMKJ_KYKSYASZKINFO%>);
              inputToOutput(<%=KYKSYASZKYNO_KYKSYASZKINFO2%>);
              inputToOutput(<%=KYKSYASZKADR1KJ_KYKSYASZKINFO2%>);
              inputToOutput(<%=KYKSYASZKADR2KJ_KYKSYASZKINFO2%>);
              inputToOutput(<%=KYKSYASZKADR3KJ_KYKSYASZKINFO2%>);
          <% } %>
      <% } %>

      <%
        if (uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) { %>
          showGroup(<%=SIHARAIHOUHOU%>);
          showGroup(<%=KOUZAINFO%>);

          <%
            if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
                showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);

                inputToOutput(<%=INPUTSHRHOUSITEIKBN_SIHARAIHOUHOU%>);
                inputToOutput(<%=BANKCD_KOUZAINFO%>);
                inputToOutput(<%=SITENCD_KOUZAINFO%>);
                inputToOutput(<%=YOKINKBN_KOUZAINFO%>);
                inputToOutput(<%=KOUZANO_KOUZAINFO%>);
                inputToOutput(<%=KZDOUKBN_KOUZAINFO%>);
                inputToOutput(<%=KZMEIGINMKN_KOUZAINFO%>);

                 $(<%= IBC1001 %>).text("");
                 $(<%= IBC1002 %>).text("");
                 $(<%= IBC1003 %>).text("");
                 $(<%= IBC1004 %>).text("");
                 $(<%= IIC1003 %>).text("");
          <% } %>
      <% } %>

      showGroup(<%=HONNININFO%>);
      showGroup(<%=HASSOUKBNINFO%>);

      <%
        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
          inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNININFO%>);
          inputToOutput(<%=HASSOUKBN_HASSOUKBNINFO%>);
      <% } %>
  <% } %>

  <%
    if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
      showGroup(<%=KEKKAINPUTGROUP%>);
  <%
    } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
      showGroup(<%=KEKKAINPUTGROUP%>);
      showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
  <% } %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
      showGroup(<%=FOOTERBUTTONS3%>);
  <% } %>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
      showGroup(<%=SHIHARAISYORINYUURYOKUINFO%>);
      showGroup(<%=SIHARAINAIYOUINFO%>);
      showGroup(<%=SIHARAINAIYOUINFOGK%>);
      $(<%= ROWSPAN2 %>).attr('rowspan', '2');
      $(<%= COLSPAN1 %>).attr('colspan', '1');

      <%
         if (C_Khhrshrjiyuu.KYKSB.equals(uiBean.getKhhrshrjiyuu())) { %>
           showGroup(<%=KYKSYASZKINFO%>);
           showGroup(<%=KYKSYASZKINFO2%>);
      <% } %>

      <%
         if (uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) { %>
           showGroup(<%=SIHARAIHOUHOU%>);
           showGroup(<%=KOUZAINFO%>);
           showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);
      <% }%>
      showGroup(<%=HONNININFO%>);
      showGroup(<%=HASSOUKBNINFO%>);
  <% } %>
  <%
    if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {%>
    $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK%>).css("padding-right", "110px");
  <%
  } else { %>
  <%
     if (!C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) && !C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) { %>
      $(".disptienrskkisanymdnissuu_data").removeClass("alignRight");
    <% } %>
  <% } %>
  showGroup(<%=KEKKAINPUTGROUP%>);

  <%
   if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
      showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
  <% } %>
 <% }%>

<% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
       uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
      showGroup(<%=SHIHARAISYORINYUURYOKUINFO%>);
      showGroup(<%=SIHARAINAIYOUINFOGK%>);
      $(<%= ROWSPAN2 %>).attr('rowspan', '2');
      $(<%= COLSPAN1 %>).attr('colspan', '1');
      $(".disptienrskkisanymdnissuu_data").removeClass("alignRight");
  <% } %>

  <%
    if (C_Khhrshrjiyuu.KYKSB.equals(uiBean.getKhhrshrjiyuu())) { %>
      showGroup(<%=SHSNMINFO%>);
      showGroup(<%=SHSKADRINFO%>);
  <%
    } else if (C_Khhrshrjiyuu.TUUJYOU.equals(uiBean.getKhhrshrjiyuu())) { %>
      showGroup(<%=KHSKSSAKUSEIJIYUUINFO%>);
  <% } %>
<% }%>

 <% if (uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <% if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
        openReport("print", "_blank");
    <% } %>
 <% } %>
});
//-->
</script>
