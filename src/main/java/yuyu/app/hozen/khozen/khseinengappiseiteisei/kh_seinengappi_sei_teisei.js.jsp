<%--
    kh_seinengappi_sei_teisei.js.jsp - 被保険者生年月日・性訂正 JavaScript(JSP)
--%>
<%@page import="jp.co.slcs.swak.number.BizCurrency"%>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn"%>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn"%>
<%@page import="yuyu.def.classification.C_KouzasyuruiKbn"%>
<%@page import="yuyu.def.classification.C_Tdk"%>
<%@page import="yuyu.def.classification.C_Tuukasyu"%>
<%@page import="yuyu.def.classification.C_Hrkkeiro"%>
<%@page import="yuyu.def.classification.C_NrhnkKbn"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="yuyu.def.classification.C_KihonssyuruiKbn"%>
<%@page import="yuyu.def.MessageId"%>
<%@page import="yuyu.infr.kinoumode.KinouMode"%>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khseinengappiseiteisei.KhSeinengappiSeiTeiseiConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khseinengappiseiteisei.KhSeinengappiSeiTeiseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khseinengappiseiteisei.KhSeinengappiSeiTeiseiUiBean" %>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil" %>
<% KhSeinengappiSeiTeiseiUiBean uiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class); %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
   <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
          <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
   <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_REFERENCE ||
       uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT ||
       uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
   <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
          <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
          <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
   <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_REFERENCE ||
       uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT ||
       uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtokusin/view_tokusin.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
   <%
      if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
          !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) { %>
          <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
   <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
   <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){

<% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
  $(<%= SYORIKBNINFO + DIV%>).css("margin-top", "-1px");
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
        showGroup(<%=HHKNTEISEIINFO%>);
    <% } %>

    <%
    if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
       <%
       if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) { %>
          showGroup(<%=HHKNTEISEIINFO%>);
          inputToOutput("#newhhknseiymdSpan > *");
          inputToOutput(<%=NEWHHKNSEI_HHKNTEISEIINFO%>);
       <% } %>
    <% } %>

   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=KOUTEIINFO %>);
   <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
  <%
  if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
      C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

      <% if (!C_NrhnkKbn.HNKNONE.eq(uiBean.getNrhnkKbn()) ||
          C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) { %>

        $(<%=SKSSAKUSEIBTN_FOOTERBUTTONS%>).visible(true);
      <% } %>
  <% } %>

  <%
  if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
      C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
      C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
    showGroup(<%=HONNINKAKUNININFO%>);

      <% if (!C_NrhnkKbn.HNKNONE.eq(uiBean.getNrhnkKbn()) ||
          C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) { %>

        showGroup(<%=HASSOUKBNINFO%>);
      <% } %>

    <%
    if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) { %>
      showGroup(<%=SIHARAIHOUHOU%>);
      showGroup(<%=KOUZAINFO%>);
      showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
      showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);

      <%
      if (!C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) { %>
        showGroup(<%=YENSHRTKNYUURYOKU%>);
        changeYenshrtkumu();
      <% } %>

      <%
      if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro())) { %>
        showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
      <% } %>
    <% } %>
  <% } %>

  <%
  if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
      !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) { %>

      showGroup(<%=HONNINKAKUNININFO%>);
      inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNINKAKUNININFO%>);

      <% if (!C_NrhnkKbn.HNKNONE.eq(uiBean.getNrhnkKbn()) ||
          C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) { %>

        showGroup(<%=HASSOUKBNINFO%>);
        inputToOutput(<%=HASSOUKBN_HASSOUKBNINFO%>);
      <% } %>

      <%
      if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) { %>
        showGroup(<%=SIHARAIHOUHOU%>);
        inputToOutput(<%=INPUTSHRHOUSITEIKBN_SIHARAIHOUHOU%>);
        showGroup(<%=KOUZAINFO%>);
        showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);
        inputToOutput(<%=BANKCD_KOUZAINFO%>);
        inputToOutput(<%=SITENCD_KOUZAINFO%>);
        inputToOutput(<%=YOKINKBN_KOUZAINFO%>);
        inputToOutput(<%=KOUZANO_KOUZAINFO%>);
        inputToOutput(<%=KZDOUKBN_KOUZAINFO%>);
        inputToOutput(<%=KZMEIGINMKN_KOUZAINFO%>);

        $(<%=IIC0012 %>).visible(false);
        $(<%=IIC0013 %>).visible(false);
        $(<%=IBC1003 %>).visible(false);
        $(<%=IIC0014 %>).visible(false);
        $(<%=IIC1003 %>).visible(false);

        <%
        if (!C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) { %>
          showGroup(<%=YENSHRTKNYUURYOKU%>);
          inputToOutput("#yenshrtkumuSpan > *");
        <% } %>

        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro())) { %>
          showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
          inputToOutput(<%=SOUKINSAKIKBN_KOUZAINFO%>);
        <% } %>

        <%
        if (!C_KouzasyuruiKbn.GAIKAKOUZA.eq(uiBean.getKzsyuruikbn())) { %>
          showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
          showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
        <% } %>
      <% } %>
  <% } %>

  <%
  if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
    $(<%=KAKUNINBTN_FOOTERBUTTONS3 %>).visible(false);
  <%
  } else { %>
    $(<%=KAKUNINBTN_FOOTERBUTTONS3 %>).visible(true);
  <% } %>

  $("input[name='ui:000yenshrtkumu']").on('click', function(){
      changeYenshrtkumu();
  });
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
  uiBean.getPageNo() == PAGENO_RESULT) { %>

  <%
  if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
      !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) { %>
      showGroup(<%=HHKNTEISEIINFO%>);
      showGroup(<%=KYKHENKOUNAIYOUINFO%>);
      <%
      if (C_KihonssyuruiKbn.KIJYUNKIN.eq(uiBean.getKihonsSyuruiKbn())) { %>
          $(<%=NEWSYUKIHONS_KYKHENKOUNAIYOUINFO + LABEL%>).text('<%=KIJYUNKINGK%>');
      <% } %>
      <%
      if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == uiBean.getSyohinHanteiKbn()) { %>
          showKoumoku(<%=NEWSYUKJNKNGK_KYKHENKOUNAIYOUINFO%>);
      <% } %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm1())) { %>
          showGroup(<%=TOKUYAKUINFO1%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm2())) { %>
          showGroup(<%=TOKUYAKUINFO2%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm3())) { %>
          showGroup(<%=TOKUYAKUINFO3%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm4())) { %>
          showGroup(<%=TOKUYAKUINFO4%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm5())) { %>
          showGroup(<%=TOKUYAKUINFO5%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm6())) { %>
          showGroup(<%=TOKUYAKUINFO6%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm7())) { %>
          showGroup(<%=TOKUYAKUINFO7%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm8())) { %>
          showGroup(<%=TOKUYAKUINFO8%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm9())) { %>
          showGroup(<%=TOKUYAKUINFO9%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm10())) { %>
          showGroup(<%=TOKUYAKUINFO10%>);
      <%} %>

      <%
      if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) { %>
        <%
        if (uiBean.getTuikahrkkinInfoDispPattern() == 1) { %>
          showGroup(<%=TUIKAHRKKININFO%>);
        <%
        } else if (uiBean.getTuikahrkkinInfoDispPattern() == 2) { %>
          showGroup(<%=TUIKAHRKKININFO2%>);
        <%
        } else if (uiBean.getTuikahrkkinInfoDispPattern() == 3) { %>
          showGroup(<%=TUIKAHRKKININFO3%>);
          showGroup(<%=NYKNJIKWSRATEINFO%>);
        <%} %>
      <%} %>

      <%
      if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) { %>
        <%
        if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
          showGroup(<%=SIHARAINAIYOUINFO%>);

          <%
            if ((!C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu()) && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()))
                || C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) { %>
              showGroup(<%=SHRGKKEIINFO%>);
            <%} %>
        <%
        } else { %>
          showGroup(<%=SHRGKKEIINFO%>);
        <%} %>

        <%
        if (!C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) { %>
          <%
          if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
            showGroup(<%=HENKANKINFO%>);
            showGroup(<%=SHRKWSRATEINFO%>);
          <%
          } else { %>
            <%
            if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) { %>
              showGroup(<%=HENKANKINFO%>);
              showGroup(<%=SHRKWSRATEINFO%>);
            <%} %>
          <%} %>
        <%} %>
      <%} %>
  <% } %>

  <%
  if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
      C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
      C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

        showGroup(<%=KEKKAINPUTINFO %>);
  <%
  } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

        showGroup(<%=KEKKAINPUTINFO %>);
        showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTINFO %>);
  <% } %>

  <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
     || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
     || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

     showGroup(<%=KOUTEIINFO %>);
  <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
  uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

  <%
  if (C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) { %>

      $(<%=HHKNTEISEIINFO + LABEL%>).text("●被保険者（契約者）訂正入力");
  <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE ||
  uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
  if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
      !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) { %>
    <%
    if (C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) { %>
      $(<%=HHKNTEISEIINFO + LABEL%>).text("●被保険者（契約者）訂正入力");
    <% } %>
  <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

  <%
  if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
      !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) { %>
      showGroup(<%=HONNINKAKUNININFO%>);

      <% if (!C_NrhnkKbn.HNKNONE.eq(uiBean.getNrhnkKbn()) ||
          C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) { %>

        showGroup(<%=HASSOUKBNINFO%>);
      <% } %>

      <%
      if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) { %>
        <%
        if (!C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) { %>
          showGroup(<%=YENSHRTKNYUURYOKU%>);
        <% } %>

        showGroup(<%=SIHARAIHOUHOU%>);
        inputToOutput(<%=INPUTSHRHOUSITEIKBN_SIHARAIHOUHOU%>);

        showGroup(<%=KOUZAINFO%>);
        showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);
        inputToOutput(<%=BANKCD_KOUZAINFO%>);
        inputToOutput(<%=SITENCD_KOUZAINFO%>);
        inputToOutput(<%=YOKINKBN_KOUZAINFO%>);
        inputToOutput(<%=KOUZANO_KOUZAINFO%>);
        inputToOutput(<%=KZDOUKBN_KOUZAINFO%>);
        inputToOutput(<%=KZMEIGINMKN_KOUZAINFO%>);

        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro())) { %>
          showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
          inputToOutput(<%=SOUKINSAKIKBN_KOUZAINFO%>);
        <% } %>

        <%
        if (!C_KouzasyuruiKbn.GAIKAKOUZA.eq(uiBean.getKzsyuruikbn())) { %>
          showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
          showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
        <% } %>
      <% } %>
  <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

  showGroup(<%=HHKNTEISEIINFO%>);

      showGroup(<%=KYKHENKOUNAIYOUINFO%>);
      <%
      if (C_KihonssyuruiKbn.KIJYUNKIN.eq(uiBean.getKihonsSyuruiKbn())) { %>
          $(<%=NEWSYUKIHONS_KYKHENKOUNAIYOUINFO + LABEL%>).text('<%=KIJYUNKINGK%>');
      <% } %>
      <%
      if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == uiBean.getSyohinHanteiKbn()) { %>
          showKoumoku(<%=NEWSYUKJNKNGK_KYKHENKOUNAIYOUINFO%>);
      <% } %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm1())) { %>
          showGroup(<%=TOKUYAKUINFO1%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm2())) { %>
          showGroup(<%=TOKUYAKUINFO2%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm3())) { %>
          showGroup(<%=TOKUYAKUINFO3%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm4())) { %>
          showGroup(<%=TOKUYAKUINFO4%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm5())) { %>
          showGroup(<%=TOKUYAKUINFO5%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm6())) { %>
          showGroup(<%=TOKUYAKUINFO6%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm7())) { %>
          showGroup(<%=TOKUYAKUINFO7%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm8())) { %>
          showGroup(<%=TOKUYAKUINFO8%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm9())) { %>
          showGroup(<%=TOKUYAKUINFO9%>);
      <%} %>
      <%
      if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhnnm10())) { %>
          showGroup(<%=TOKUYAKUINFO10%>);
      <%} %>
      <%
      if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) { %>
          showGroup(<%=TUIKAHRKKININFO%>);
      <% } %>
      <%
      if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) { %>
          showGroup(<%=SHRGKKEIINFO%>);

          <%
          if (!C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) { %>
              showGroup(<%=HENKANKINFO%>);
              showGroup(<%=SHRKWSRATEINFO%>);
          <%} %>
      <%} %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_SKSRESULT || uiBean.getPageNo() == PAGENO_RESULT) { %>
      <%
      if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
            openReport("print", "_blank");
      <% } %>

<% } %>

function changeYenshrtkumu(){

  var value = $("input[name='ui:000yenshrtkumu']:checked").val();

  if (value == "0") {

      $(<%=YOKINKBN_KOUZAINFO%>).val("0");
      $(<%=YOKINKBN_KOUZAINFO%>).find("option").each(function(){
        if ($(this).val() != 0) {
           $(this).attr("disabled", "true");
         }
      });
      $(<%=YOKINKBN_KOUZAINFO%>).addClass("backgroundReadOnlyGray");

      $(<%=KZDOUKBN_KOUZAINFO%>).val("0");
      $(<%=KZDOUKBN_KOUZAINFO%>).find("option").each(function(){
         if ($(this).val() != 0) {
            $(this).attr("disabled", "true");
          }
       });
       $(<%=KZDOUKBN_KOUZAINFO%>).addClass("backgroundReadOnlyGray");
  } else {

      $(<%=YOKINKBN_KOUZAINFO%>).find("option").each(function(){
          $(this).removeAttr("disabled");
      });
      $(<%=YOKINKBN_KOUZAINFO%>).removeClass("backgroundReadOnlyGray");

      $(<%=KZDOUKBN_KOUZAINFO%>).find("option").each(function(){
          $(this).removeAttr("disabled");
       });
      $(<%=KZDOUKBN_KOUZAINFO%>).removeClass("backgroundReadOnlyGray");
  }
}

});
//-->
</script>
