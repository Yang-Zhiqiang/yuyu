<%--
    kh_gengaku.js.jsp - 減額 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khgengaku.KhGengakuConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khgengaku.KhGengakuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.app.hozen.khozen.khgengaku.KhGengakuUiBean" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn"%>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn"%>
<%@page import="yuyu.def.classification.C_Sdpd"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="yuyu.def.classification.C_KykhnkKbn"%>
<%@page import="yuyu.def.classification.C_GengkhouKbn"%>
<%@page import="yuyu.def.classification.C_KhnkyhkgbairituKbn"%>
<%@page import="yuyu.def.classification.C_InputShrhousiteiKbn"%>
<%@page import="yuyu.def.classification.C_KahiKbn"%>
<%@page import="yuyu.def.classification.C_Tuukasyu"%>
<%@page import="yuyu.def.classification.C_ShrhousiteiKbn"%>
<%@page import="yuyu.def.classification.C_TkiktbrisyuruiKbn"%>
<%@page import="yuyu.def.classification.C_Hrkkeiro"%>
<%@page import="jp.co.slcs.swak.number.BizCurrency"%>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil"%>
<% KhGengakuUiBean uiBean = SWAKInjector.getInstance(KhGengakuUiBean.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

    <jsp:include
    page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp" />
    <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
    || uiBean.getPageNo() == PAGENO_REFERENCE
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

  <jsp:include
    page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp" />
  <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
    || uiBean.getPageNo() == PAGENO_REFERENCE
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT
    || uiBean.getPageNo() == PAGENO_SKSCONFIRM
    || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp" />

  <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewtokusin/view_tokusin.js.jsp" />

  <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp" />

  <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp" />

  <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewhaitoukin/view_haitoukin.js.jsp" />

  <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp" />

  <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp" />

  <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewkhtkshrsiharaikouza/view_kh_tkshr_siharai_kouza.js.jsp" />
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT
    || uiBean.getPageNo() == PAGENO_SKSCONFIRM
    || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

    <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

      <jsp:include
        page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp" />
    <% } %>
<% } %>

<script type="text/javascript"><!--
$(function(){

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
   <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

      showGroup(<%=GENGAKUNYUURYOKUINFO %>);

      showGroup(<%=GENGAKUNYUURYOKUSYUINFO %>);

      <% uiBean.setDispsyusyouhnnm(uiBean.getVhsyusyusyouhnnm()); %>

      <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU) || C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>

         showKoumoku(<%=SYUHNKKBN_GENGAKUNYUURYOKUSYUINFO%>);
      <% } %>

      <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU)
          && C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>

         showKoumoku(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO%>);

         showKoumoku(<%=SYUP_GENGAKUNYUURYOKUSYUINFO%>);

         showKoumoku(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>);

         onloadGengkhoukbn(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO%>);

      <% } else {%>
        <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU)
            && C_KahiKbn.HUKA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>
             $(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
             showKoumoku(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>);
             $(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
        <% } %>
        <% if (!uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU)
            && C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>
             $(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
             $(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
             showKoumoku(<%=SYUP_GENGAKUNYUURYOKUSYUINFO%>);
        <% } %>
      <% } %>

      <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU)) { %>
        <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyusyutsnshrgndhjumu())) { %>

           $(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
           $(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
           $(<%=SYUTSNSHRGNDGK_GENGAKUNYUURYOKUSYUINFO %>).parent().find("span").eq(4).visible(true);
           $(<%=SYUTSNSHRGNDGK_GENGAKUNYUURYOKUSYUINFO %>).visible(true);
        <% } %>
      <% } else {%>
         inputToOutput(<%= SYUKIHONS_GENGAKUNYUURYOKUSYUINFO %>);
       <% } %>

      <% uiBean.setSyukihonssyuruikbn(uiBean.getVhsyusyukihonssyuruikbn()); %>

      $(<%= GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO %>).on('change', function(){
          changeGengkhoukbn(<%= GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO%>);
      });

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO1%>);

         <% uiBean.setTokuyakusyouhnnm1(uiBean.getVhsyudisptksyouhnnm1()); %>

         <% if (uiBean.getTkGengakukahikbn1().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn1(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn1(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN1_GENGAKUNYUURYOKUTKINFO1%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu1())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN1_GENGAKUNYUURYOKUTKINFO1 %>).visible(false);
            $(<%=NEWTKKIHONS1_GENGAKUNYUURYOKUTKINFO1 %>).visible(false);
            $(<%=TKTSNSHRGNDGK1_GENGAKUNYUURYOKUTKINFO1 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK1_GENGAKUNYUURYOKUTKINFO1 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn1().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS1_GENGAKUNYUURYOKUTKINFO1 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn1(uiBean.getVhsyudisptkkihsyuruikbn1()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO2%>);

         <% uiBean.setTokuyakusyouhnnm2(uiBean.getVhsyudisptksyouhnnm2()); %>

         <% if (uiBean.getTkGengakukahikbn2().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn2(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn2(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN2_GENGAKUNYUURYOKUTKINFO2%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu2())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN2_GENGAKUNYUURYOKUTKINFO2 %>).visible(false);
            $(<%=NEWTKKIHONS2_GENGAKUNYUURYOKUTKINFO2 %>).visible(false);
            $(<%=TKTSNSHRGNDGK2_GENGAKUNYUURYOKUTKINFO2 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK2_GENGAKUNYUURYOKUTKINFO2 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn2().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS2_GENGAKUNYUURYOKUTKINFO2 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn2(uiBean.getVhsyudisptkkihsyuruikbn2()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO3%>);

         <% uiBean.setTokuyakusyouhnnm3(uiBean.getVhsyudisptksyouhnnm3()); %>

         <% if (uiBean.getTkGengakukahikbn3().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn3(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn3(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN3_GENGAKUNYUURYOKUTKINFO3%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu3())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN3_GENGAKUNYUURYOKUTKINFO3 %>).visible(false);
            $(<%=NEWTKKIHONS3_GENGAKUNYUURYOKUTKINFO3 %>).visible(false);
            $(<%=TKTSNSHRGNDGK3_GENGAKUNYUURYOKUTKINFO3 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK3_GENGAKUNYUURYOKUTKINFO3 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn3().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS3_GENGAKUNYUURYOKUTKINFO3 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn3(uiBean.getVhsyudisptkkihsyuruikbn3()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO4%>);

         <% uiBean.setTokuyakusyouhnnm4(uiBean.getVhsyudisptksyouhnnm4()); %>

         <% if (uiBean.getTkGengakukahikbn4().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn4(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn4(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN4_GENGAKUNYUURYOKUTKINFO4%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu4())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN4_GENGAKUNYUURYOKUTKINFO4 %>).visible(false);
            $(<%=NEWTKKIHONS4_GENGAKUNYUURYOKUTKINFO4 %>).visible(false);
            $(<%=TKTSNSHRGNDGK4_GENGAKUNYUURYOKUTKINFO4 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK4_GENGAKUNYUURYOKUTKINFO4 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn4().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS4_GENGAKUNYUURYOKUTKINFO4 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn4(uiBean.getVhsyudisptkkihsyuruikbn4()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO5%>);

         <% uiBean.setTokuyakusyouhnnm5(uiBean.getVhsyudisptksyouhnnm5()); %>

         <% if (uiBean.getTkGengakukahikbn5().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn5(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn5(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN5_GENGAKUNYUURYOKUTKINFO5%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu5())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN5_GENGAKUNYUURYOKUTKINFO5 %>).visible(false);
            $(<%=NEWTKKIHONS5_GENGAKUNYUURYOKUTKINFO5 %>).visible(false);
            $(<%=TKTSNSHRGNDGK5_GENGAKUNYUURYOKUTKINFO5 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK5_GENGAKUNYUURYOKUTKINFO5 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn5().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS5_GENGAKUNYUURYOKUTKINFO5 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn5(uiBean.getVhsyudisptkkihsyuruikbn5()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO6%>);

         <% uiBean.setTokuyakusyouhnnm6(uiBean.getVhsyudisptksyouhnnm6()); %>

         <% if (uiBean.getTkGengakukahikbn6().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn6(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn6(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN6_GENGAKUNYUURYOKUTKINFO6%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu6())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN6_GENGAKUNYUURYOKUTKINFO6 %>).visible(false);
            $(<%=NEWTKKIHONS6_GENGAKUNYUURYOKUTKINFO6 %>).visible(false);
            $(<%=TKTSNSHRGNDGK6_GENGAKUNYUURYOKUTKINFO6 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK6_GENGAKUNYUURYOKUTKINFO6 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn6().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS6_GENGAKUNYUURYOKUTKINFO6 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn6(uiBean.getVhsyudisptkkihsyuruikbn6()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO7%>);

         <% uiBean.setTokuyakusyouhnnm7(uiBean.getVhsyudisptksyouhnnm7()); %>

         <% if (uiBean.getTkGengakukahikbn7().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn7(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn7(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN7_GENGAKUNYUURYOKUTKINFO7%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu7())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN7_GENGAKUNYUURYOKUTKINFO7 %>).visible(false);
            $(<%=NEWTKKIHONS7_GENGAKUNYUURYOKUTKINFO7 %>).visible(false);
            $(<%=TKTSNSHRGNDGK7_GENGAKUNYUURYOKUTKINFO7 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK7_GENGAKUNYUURYOKUTKINFO7 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn7().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS7_GENGAKUNYUURYOKUTKINFO7 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn7(uiBean.getVhsyudisptkkihsyuruikbn7()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO8%>);

         <% uiBean.setTokuyakusyouhnnm8(uiBean.getVhsyudisptksyouhnnm8()); %>

         <% if (uiBean.getTkGengakukahikbn8().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn8(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn8(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN8_GENGAKUNYUURYOKUTKINFO8%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu8())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN8_GENGAKUNYUURYOKUTKINFO8 %>).visible(false);
            $(<%=NEWTKKIHONS8_GENGAKUNYUURYOKUTKINFO8 %>).visible(false);
            $(<%=TKTSNSHRGNDGK8_GENGAKUNYUURYOKUTKINFO8 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK8_GENGAKUNYUURYOKUTKINFO8 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn8().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS8_GENGAKUNYUURYOKUTKINFO8 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn8(uiBean.getVhsyudisptkkihsyuruikbn8()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO9%>);

         <% uiBean.setTokuyakusyouhnnm9(uiBean.getVhsyudisptksyouhnnm9()); %>

         <% if (uiBean.getTkGengakukahikbn9().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn9(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn9(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN9_GENGAKUNYUURYOKUTKINFO9%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu9())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN9_GENGAKUNYUURYOKUTKINFO9 %>).visible(false);
            $(<%=NEWTKKIHONS9_GENGAKUNYUURYOKUTKINFO9 %>).visible(false);
            $(<%=TKTSNSHRGNDGK9_GENGAKUNYUURYOKUTKINFO9 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK9_GENGAKUNYUURYOKUTKINFO9 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn9().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS9_GENGAKUNYUURYOKUTKINFO9 %>);
            <% } %>
          <% } %>

          <% uiBean.setTokuyakukihonssyuruikbn9(uiBean.getVhsyudisptkkihsyuruikbn9()); %>
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO10%>);

         <% uiBean.setTokuyakusyouhnnm10(uiBean.getVhsyudisptksyouhnnm10()); %>

         <% if (uiBean.getTkGengakukahikbn10().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

            <% uiBean.setPatternTkhnkkbn10(C_KykhnkKbn.PATTERN_DEFAULT); %>
         <% } else {%>

            <% uiBean.setPatternTkhnkkbn10(C_KykhnkKbn.PATTERN_NOGEN); %>
         <% } %>

         showKoumoku(<%=TKHNKKBN10_GENGAKUNYUURYOKUTKINFO10%>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu10())) {%>

            $(<%=TOKUYAKUKIHONSSYURUIKBN10_GENGAKUNYUURYOKUTKINFO10 %>).visible(false);
            $(<%=NEWTKKIHONS10_GENGAKUNYUURYOKUTKINFO10 %>).visible(false);
            $(<%=TKTSNSHRGNDGK10_GENGAKUNYUURYOKUTKINFO10 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK10_GENGAKUNYUURYOKUTKINFO10 %>).visible(true);

          <% } else {%>

            <% if (!uiBean.getTkGengakukahikbn10().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

               inputToOutput(<%= NEWTKKIHONS10_GENGAKUNYUURYOKUTKINFO10 %>);
            <% } %>
          <% } %>

      <% } %>
   <%
    } else { %>
       <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

          showGroup(<%=GENGAKUNYUURYOKUINFO %>);

          inputToOutput("#syoruiukeymdSpan > *");

          showGroup(<%=GENGAKUNYUURYOKUSYUINFO %>);

          <% uiBean.setDispsyusyouhnnm(uiBean.getVhsyusyusyouhnnm()); %>

          <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU) || C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>

             showKoumoku(<%=SYUHNKKBN_GENGAKUNYUURYOKUSYUINFO%>);

             inputToOutput(<%=SYUHNKKBN_GENGAKUNYUURYOKUSYUINFO %>);
          <% } %>

          <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU)
              && C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>

             showKoumoku(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO%>);

             inputToOutput(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO %>);

             showKoumoku(<%=SYUP_GENGAKUNYUURYOKUSYUINFO%>);

             inputToOutput(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>);
          <% } else { %>
            <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU)
                && C_KahiKbn.HUKA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>
                 $(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
                 showKoumoku(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO%>);
                 inputToOutput(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO %>);
                 $(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
            <% } %>
            <% if (!uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU)
                && C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>
                 $(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
                 $(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
                 showKoumoku(<%=SYUP_GENGAKUNYUURYOKUSYUINFO%>);
                 inputToOutput(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>);
            <% } %>
          <% } %>

          <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyusyutsnshrgndhjumu())) {%>

             $(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
             $(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
             $(<%=SYUTSNSHRGNDGK_GENGAKUNYUURYOKUSYUINFO %>).parent().find("span").eq(4).visible(true);
             $(<%=SYUTSNSHRGNDGK_GENGAKUNYUURYOKUSYUINFO %>).visible(true);
          <% } else { %>

             inputToOutput(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO %>);

          <% } %>

          <% uiBean.setSyukihonssyuruikbn(uiBean.getVhsyusyukihonssyuruikbn()); %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO1%>);

             <% uiBean.setTokuyakusyouhnnm1(uiBean.getVhsyudisptksyouhnnm1()); %>

             <% if (uiBean.getTkGengakukahikbn1().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn1(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn1(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN1_GENGAKUNYUURYOKUTKINFO1%>);

             inputToOutput(<%=TKHNKKBN1_GENGAKUNYUURYOKUTKINFO1 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu1())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN1_GENGAKUNYUURYOKUTKINFO1 %>).visible(false);
                $(<%=NEWTKKIHONS1_GENGAKUNYUURYOKUTKINFO1 %>).visible(false);
                $(<%=TKTSNSHRGNDGK1_GENGAKUNYUURYOKUTKINFO1 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK1_GENGAKUNYUURYOKUTKINFO1 %>).visible(true);

              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS1_GENGAKUNYUURYOKUTKINFO1 %>);

                <% uiBean.setTokuyakukihonssyuruikbn1(uiBean.getVhsyudisptkkihsyuruikbn1()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO2%>);

             <% uiBean.setTokuyakusyouhnnm2(uiBean.getVhsyudisptksyouhnnm2()); %>

             <% if (uiBean.getTkGengakukahikbn2().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn2(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn2(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN2_GENGAKUNYUURYOKUTKINFO2%>);

             inputToOutput(<%=TKHNKKBN2_GENGAKUNYUURYOKUTKINFO2 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu2())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN2_GENGAKUNYUURYOKUTKINFO2 %>).visible(false);
                $(<%=NEWTKKIHONS2_GENGAKUNYUURYOKUTKINFO2 %>).visible(false);
                $(<%=TKTSNSHRGNDGK2_GENGAKUNYUURYOKUTKINFO2 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK2_GENGAKUNYUURYOKUTKINFO2 %>).visible(true);
              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS2_GENGAKUNYUURYOKUTKINFO2 %>);

                <% uiBean.setTokuyakukihonssyuruikbn2(uiBean.getVhsyudisptkkihsyuruikbn2()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO3%>);

             <% uiBean.setTokuyakusyouhnnm3(uiBean.getVhsyudisptksyouhnnm3()); %>

             <% if (uiBean.getTkGengakukahikbn3().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn3(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn3(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN3_GENGAKUNYUURYOKUTKINFO3%>);

             inputToOutput(<%=TKHNKKBN3_GENGAKUNYUURYOKUTKINFO3 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu3())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN3_GENGAKUNYUURYOKUTKINFO3 %>).visible(false);
                $(<%=NEWTKKIHONS3_GENGAKUNYUURYOKUTKINFO3 %>).visible(false);
                $(<%=TKTSNSHRGNDGK3_GENGAKUNYUURYOKUTKINFO3 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK3_GENGAKUNYUURYOKUTKINFO3 %>).visible(true);
              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS3_GENGAKUNYUURYOKUTKINFO3 %>);

                <% uiBean.setTokuyakukihonssyuruikbn3(uiBean.getVhsyudisptkkihsyuruikbn3()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO4%>);

             <% uiBean.setTokuyakusyouhnnm4(uiBean.getVhsyudisptksyouhnnm4()); %>

             <% if (uiBean.getTkGengakukahikbn4().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn4(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn4(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN4_GENGAKUNYUURYOKUTKINFO4%>);

             inputToOutput(<%=TKHNKKBN4_GENGAKUNYUURYOKUTKINFO4 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu4())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN4_GENGAKUNYUURYOKUTKINFO4 %>).visible(false);
                $(<%=NEWTKKIHONS4_GENGAKUNYUURYOKUTKINFO4 %>).visible(false);
                $(<%=TKTSNSHRGNDGK4_GENGAKUNYUURYOKUTKINFO4 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK4_GENGAKUNYUURYOKUTKINFO4 %>).visible(true);
              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS4_GENGAKUNYUURYOKUTKINFO4 %>);

                <% uiBean.setTokuyakukihonssyuruikbn4(uiBean.getVhsyudisptkkihsyuruikbn4()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO5%>);

             <% uiBean.setTokuyakusyouhnnm5(uiBean.getVhsyudisptksyouhnnm5()); %>

             <% if (uiBean.getTkGengakukahikbn5().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn5(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn5(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN5_GENGAKUNYUURYOKUTKINFO5%>);

             inputToOutput(<%=TKHNKKBN5_GENGAKUNYUURYOKUTKINFO5 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu5())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN5_GENGAKUNYUURYOKUTKINFO5 %>).visible(false);
                $(<%=NEWTKKIHONS5_GENGAKUNYUURYOKUTKINFO5 %>).visible(false);
                $(<%=TKTSNSHRGNDGK5_GENGAKUNYUURYOKUTKINFO5 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK5_GENGAKUNYUURYOKUTKINFO5 %>).visible(true);

              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS5_GENGAKUNYUURYOKUTKINFO5 %>);

                <% uiBean.setTokuyakukihonssyuruikbn5(uiBean.getVhsyudisptkkihsyuruikbn5()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO6%>);

             <% uiBean.setTokuyakusyouhnnm6(uiBean.getVhsyudisptksyouhnnm6()); %>

             <% if (uiBean.getTkGengakukahikbn6().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn6(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn6(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN6_GENGAKUNYUURYOKUTKINFO6%>);

             inputToOutput(<%=TKHNKKBN6_GENGAKUNYUURYOKUTKINFO6 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu6())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN6_GENGAKUNYUURYOKUTKINFO6 %>).visible(false);
                $(<%=NEWTKKIHONS6_GENGAKUNYUURYOKUTKINFO6 %>).visible(false);
                $(<%=TKTSNSHRGNDGK6_GENGAKUNYUURYOKUTKINFO6 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK6_GENGAKUNYUURYOKUTKINFO6 %>).visible(true);
              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS6_GENGAKUNYUURYOKUTKINFO6 %>);

                <% uiBean.setTokuyakukihonssyuruikbn6(uiBean.getVhsyudisptkkihsyuruikbn6()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO7%>);

             <% uiBean.setTokuyakusyouhnnm7(uiBean.getVhsyudisptksyouhnnm7()); %>

             <% if (uiBean.getTkGengakukahikbn7().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn7(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn7(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN7_GENGAKUNYUURYOKUTKINFO7%>);

             inputToOutput(<%=TKHNKKBN7_GENGAKUNYUURYOKUTKINFO7 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu7())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN7_GENGAKUNYUURYOKUTKINFO7 %>).visible(false);
                $(<%=NEWTKKIHONS7_GENGAKUNYUURYOKUTKINFO7 %>).visible(false);
                $(<%=TKTSNSHRGNDGK7_GENGAKUNYUURYOKUTKINFO7 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK7_GENGAKUNYUURYOKUTKINFO7 %>).visible(true);
              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS7_GENGAKUNYUURYOKUTKINFO7 %>);

                <% uiBean.setTokuyakukihonssyuruikbn7(uiBean.getVhsyudisptkkihsyuruikbn7()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO8%>);

             <% uiBean.setTokuyakusyouhnnm8(uiBean.getVhsyudisptksyouhnnm8()); %>

             <% if (uiBean.getTkGengakukahikbn8().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn8(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn8(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN8_GENGAKUNYUURYOKUTKINFO8%>);

             inputToOutput(<%=TKHNKKBN8_GENGAKUNYUURYOKUTKINFO8 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu8())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN8_GENGAKUNYUURYOKUTKINFO8 %>).visible(false);
                $(<%=NEWTKKIHONS8_GENGAKUNYUURYOKUTKINFO8 %>).visible(false);
                $(<%=TKTSNSHRGNDGK8_GENGAKUNYUURYOKUTKINFO8 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK8_GENGAKUNYUURYOKUTKINFO8 %>).visible(true);
              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS8_GENGAKUNYUURYOKUTKINFO8 %>);

                <% uiBean.setTokuyakukihonssyuruikbn8(uiBean.getVhsyudisptkkihsyuruikbn8()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO9%>);

             <% uiBean.setTokuyakusyouhnnm9(uiBean.getVhsyudisptksyouhnnm9()); %>

             <% if (uiBean.getTkGengakukahikbn9().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn9(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn9(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN9_GENGAKUNYUURYOKUTKINFO9%>);

             inputToOutput(<%=TKHNKKBN9_GENGAKUNYUURYOKUTKINFO9 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu9())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN9_GENGAKUNYUURYOKUTKINFO9 %>).visible(false);
                $(<%=NEWTKKIHONS9_GENGAKUNYUURYOKUTKINFO9 %>).visible(false);
                $(<%=TKTSNSHRGNDGK9_GENGAKUNYUURYOKUTKINFO9 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK9_GENGAKUNYUURYOKUTKINFO9 %>).visible(true);

              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS9_GENGAKUNYUURYOKUTKINFO9 %>);

                <% uiBean.setTokuyakukihonssyuruikbn9(uiBean.getVhsyudisptkkihsyuruikbn9()); %>
              <% } %>
          <% } %>

          <% if(!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())) {%>

             showGroup(<%=GENGAKUNYUURYOKUTKINFO10%>);

             <% uiBean.setTokuyakusyouhnnm10(uiBean.getVhsyudisptksyouhnnm10()); %>

             <% if (uiBean.getTkGengakukahikbn10().equals(GENGAKUKAHIKBN_SYORIKANOU)) {%>

                <% uiBean.setPatternTkhnkkbn10(C_KykhnkKbn.PATTERN_DEFAULT); %>
             <% } else {%>

                <% uiBean.setPatternTkhnkkbn10(C_KykhnkKbn.PATTERN_NOGEN); %>
             <% } %>

             showKoumoku(<%=TKHNKKBN10_GENGAKUNYUURYOKUTKINFO10%>);

             inputToOutput(<%=TKHNKKBN10_GENGAKUNYUURYOKUTKINFO10 %>);

             <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu10())) {%>

                $(<%=TOKUYAKUKIHONSSYURUIKBN10_GENGAKUNYUURYOKUTKINFO10 %>).visible(false);
                $(<%=NEWTKKIHONS10_GENGAKUNYUURYOKUTKINFO10 %>).visible(false);
                $(<%=TKTSNSHRGNDGK10_GENGAKUNYUURYOKUTKINFO10 %>).parent().find("span").eq(4).visible(true);
                $(<%=TKTSNSHRGNDGK10_GENGAKUNYUURYOKUTKINFO10 %>).visible(true);
              <% } else {%>

                inputToOutput(<%= NEWTKKIHONS10_GENGAKUNYUURYOKUTKINFO10 %>);

                <% uiBean.setTokuyakukihonssyuruikbn10(uiBean.getVhsyudisptkkihsyuruikbn10()); %>
              <% } %>
          <% } %>
       <% } %>
   <% } %>

   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
      || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

      showGroup(<%=KOUTEIINFO %>);

   <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT
    || uiBean.getPageNo() == PAGENO_SKSCONFIRM
    || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

   <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
      || !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

      showGroup(<%=GENGAKUNYUURYOKUINFO %>);

      showGroup(<%=GENGAKUNYUURYOKUSYUINFO %>);

      <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU) ||
          C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>

         showKoumoku(<%=SYUHNKKBN_GENGAKUNYUURYOKUSYUINFO%>);
      <% } %>

      <% if (uiBean.getSyuGengakuKahiKbn().equals(GENGAKUKAHIKBN_SYORIKANOU)
          && C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {%>

         showKoumoku(<%=GENGKHOUKBN_GENGAKUNYUURYOKUSYUINFO%>);
      <% } %>

      <% if (C_GengkhouKbn.SD.eq(uiBean.getGengkhoukbn())) {%>

          showKoumoku(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>);

          <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyusyutsnshrgndhjumu())) {%>

             $(<%=SYUTSNSHRGNDGK_GENGAKUNYUURYOKUSYUINFO %>).parent().find("span").eq(4).visible(true);
             $(<%=SYUTSNSHRGNDGK_GENGAKUNYUURYOKUSYUINFO %>).visible(true);
             $(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
             $(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO %>).visible(false);

          <% } %>
      <% } else {%>

         $(<%=SYUKIHONSSYURUIKBN_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
         $(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO %>).visible(false);
         $(<%=SYUTSNSHRGNDGK_GENGAKUNYUURYOKUSYUINFO %>).parent().find("span").eq(4).visible(false);
         $(<%=SYUTSNSHRGNDGK_GENGAKUNYUURYOKUSYUINFO %>).visible(false);

      <% } %>

      <% if (!C_KhnkyhkgbairituKbn.BLNK.eq(uiBean.getVhsyusyukhnkyhkgbairitukbn())) {%>

         showKoumoku(<%=SYUKIHONKYHGK_GENGAKUNYUURYOKUSYUINFO%>);

      <% } %>

      <% if (C_GengkhouKbn.PD.eq(uiBean.getGengkhoukbn())) {%>

         showKoumoku(<%=SYUP_GENGAKUNYUURYOKUSYUINFO%>);

          <% if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk()) ||
                 C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getVhrkitikiktbrijk())) { %>
                 showKoumoku(<%=HENSYUIKTHRIP_GENGAKUNYUURYOKUSYUINFO%>);
          <% } %>
      <% } %>

      <% if (C_UmuKbn.ARI.eq(uiBean.getNewSyunextkosUmu())) {%>

         showKoumoku(<%=NEWSYUNEXTKOSGOP_GENGAKUNYUURYOKUSYUINFO%>);

      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn1())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO1%>);

         showKoumoku(<%=TKHNKKBN1_GENGAKUNYUURYOKUTKINFO1 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyusyutsnshrgndhjumu())) {%>

            $(<%=TKTSNSHRGNDGK1_GENGAKUNYUURYOKUTKINFO1 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK1_GENGAKUNYUURYOKUTKINFO1 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN1_GENGAKUNYUURYOKUTKINFO1 %>).visible(false);
            $(<%=NEWTKKIHONS1_GENGAKUNYUURYOKUTKINFO1 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP1_GENGAKUNYUURYOKUTKINFO1 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu1())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP1_GENGAKUNYUURYOKUTKINFO1%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn2())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO2%>);

         showKoumoku(<%=TKHNKKBN2_GENGAKUNYUURYOKUTKINFO2 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu2())) {%>

            $(<%=TKTSNSHRGNDGK2_GENGAKUNYUURYOKUTKINFO2 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK2_GENGAKUNYUURYOKUTKINFO2 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN2_GENGAKUNYUURYOKUTKINFO2 %>).visible(false);
            $(<%=NEWTKKIHONS2_GENGAKUNYUURYOKUTKINFO2 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP2_GENGAKUNYUURYOKUTKINFO2 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu2())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP2_GENGAKUNYUURYOKUTKINFO2%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn3())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO3%>);

         showKoumoku(<%=TKHNKKBN3_GENGAKUNYUURYOKUTKINFO3 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu3())) {%>

            $(<%=TKTSNSHRGNDGK3_GENGAKUNYUURYOKUTKINFO3 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK3_GENGAKUNYUURYOKUTKINFO3 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN3_GENGAKUNYUURYOKUTKINFO3 %>).visible(false);
            $(<%=NEWTKKIHONS3_GENGAKUNYUURYOKUTKINFO3 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP3_GENGAKUNYUURYOKUTKINFO3 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu3())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP3_GENGAKUNYUURYOKUTKINFO3%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn4())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO4%>);

         showKoumoku(<%=TKHNKKBN4_GENGAKUNYUURYOKUTKINFO4 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu4())) {%>

            $(<%=TKTSNSHRGNDGK4_GENGAKUNYUURYOKUTKINFO4 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK4_GENGAKUNYUURYOKUTKINFO4 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN4_GENGAKUNYUURYOKUTKINFO4 %>).visible(false);
            $(<%=NEWTKKIHONS4_GENGAKUNYUURYOKUTKINFO4 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP4_GENGAKUNYUURYOKUTKINFO4 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu4())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP4_GENGAKUNYUURYOKUTKINFO4%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn5())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO5%>);

         showKoumoku(<%=TKHNKKBN5_GENGAKUNYUURYOKUTKINFO5 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu5())) {%>

            $(<%=TKTSNSHRGNDGK5_GENGAKUNYUURYOKUTKINFO5 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK5_GENGAKUNYUURYOKUTKINFO5 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN5_GENGAKUNYUURYOKUTKINFO5 %>).visible(false);
            $(<%=NEWTKKIHONS5_GENGAKUNYUURYOKUTKINFO5 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP5_GENGAKUNYUURYOKUTKINFO5 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu5())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP5_GENGAKUNYUURYOKUTKINFO5%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn6())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO6%>);

         showKoumoku(<%=TKHNKKBN6_GENGAKUNYUURYOKUTKINFO6 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu6())) {%>

            $(<%=TKTSNSHRGNDGK6_GENGAKUNYUURYOKUTKINFO6 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK6_GENGAKUNYUURYOKUTKINFO6 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN6_GENGAKUNYUURYOKUTKINFO6 %>).visible(false);
            $(<%=NEWTKKIHONS6_GENGAKUNYUURYOKUTKINFO6 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP6_GENGAKUNYUURYOKUTKINFO6 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu6())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP6_GENGAKUNYUURYOKUTKINFO6%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn7())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO7%>);

         showKoumoku(<%=TKHNKKBN7_GENGAKUNYUURYOKUTKINFO7 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu7())) {%>

            $(<%=TKTSNSHRGNDGK7_GENGAKUNYUURYOKUTKINFO7 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK7_GENGAKUNYUURYOKUTKINFO7 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN7_GENGAKUNYUURYOKUTKINFO7 %>).visible(false);
            $(<%=NEWTKKIHONS7_GENGAKUNYUURYOKUTKINFO7 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP7_GENGAKUNYUURYOKUTKINFO7 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu7())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP7_GENGAKUNYUURYOKUTKINFO7%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn8())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO8%>);

         showKoumoku(<%=TKHNKKBN8_GENGAKUNYUURYOKUTKINFO8 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu8())) {%>

            $(<%=TKTSNSHRGNDGK8_GENGAKUNYUURYOKUTKINFO8 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK8_GENGAKUNYUURYOKUTKINFO8 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN8_GENGAKUNYUURYOKUTKINFO8 %>).visible(false);
            $(<%=NEWTKKIHONS8_GENGAKUNYUURYOKUTKINFO8 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP8_GENGAKUNYUURYOKUTKINFO8 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu8())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP8_GENGAKUNYUURYOKUTKINFO8%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn9())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO9%>);

         showKoumoku(<%=TKHNKKBN9_GENGAKUNYUURYOKUTKINFO9 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu9())) {%>

            $(<%=TKTSNSHRGNDGK9_GENGAKUNYUURYOKUTKINFO9 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK9_GENGAKUNYUURYOKUTKINFO9 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN9_GENGAKUNYUURYOKUTKINFO9 %>).visible(false);
            $(<%=NEWTKKIHONS9_GENGAKUNYUURYOKUTKINFO9 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP9_GENGAKUNYUURYOKUTKINFO9 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu9())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP9_GENGAKUNYUURYOKUTKINFO9%>);
         <% } %>
      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())
          && !C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn10())) {%>

         showGroup(<%=GENGAKUNYUURYOKUTKINFO10%>);

         showKoumoku(<%=TKHNKKBN10_GENGAKUNYUURYOKUTKINFO10 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getVhsyudisptktsnshrgndhjumu10())) {%>

            $(<%=TKTSNSHRGNDGK10_GENGAKUNYUURYOKUTKINFO10 %>).parent().find("span").eq(4).visible(true);
            $(<%=TKTSNSHRGNDGK10_GENGAKUNYUURYOKUTKINFO10 %>).visible(true);
            $(<%=TOKUYAKUKIHONSSYURUIKBN10_GENGAKUNYUURYOKUTKINFO10 %>).visible(false);
            $(<%=NEWTKKIHONS10_GENGAKUNYUURYOKUTKINFO10 %>).visible(false);
         <% } %>

         showKoumoku(<%=NEWDISPTKP10_GENGAKUNYUURYOKUTKINFO10 %>);

         <% if (C_UmuKbn.ARI.eq(uiBean.getDispnewtknextkosumu10())) {%>

            showKoumoku(<%=DISPNEWTKNEXTKOSGOP10_GENGAKUNYUURYOKUTKINFO10%>);
         <% } %>
      <% } %>

   <% if (C_GengkhouKbn.SD.eq(uiBean.getGengkhoukbn())) {%>

      showGroup(<%=SINSIHARAIKOMIHOKENRYOU%>);

      <% if (C_UmuKbn.ARI.eq(uiBean.getNewNextkosUmu())) {%>

         showKoumoku(<%=NEWNEXTKOSGOHRKP_SINSIHARAIKOMIHOKENRYOU%>);
      <% } %>
   <% } %>

   <% if (C_GengkhouKbn.PD.eq(uiBean.getGengkhoukbn())) { %>
       <% if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) { %>
          showGroup(<%=SINKJNKNGKINFO%>);
       <%
       } else { %>
          showGroup(<%=SINKIHONSINFO%>);
       <% } %>
   <% } %>
   $(<%= ROWSPAN4_CLASS %>).attr("rowspan","7");
   $(<%= ROWSPAN6_CLASS %>).attr("rowspan","7");
   $(<%= COLSPAN1_CLASS %>).attr("colspan","1");
   $(<%= ROWSPAN3_CLASS %>).attr("rowspan","3");
   <% if (uiBean.getPageNo() == PAGENO_REFERENCE
       || uiBean.getPageNo() == PAGENO_SKSCONFIRM
       || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

       <% if(!uiBean.getShrgkgoukeisyoukai().isOptional() && uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) { %>
           <% if(!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) { %>
               showGroup(<%=SIHARAINAIYOUINFOGK%>);

               <% if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                   showKoumoku(<%= GAIKAMIKEIKAP_SIHARAINAIYOUINFOGK %>);
                   showKoumoku(<%= GAIKAZENNOUSEISANKGK_SIHARAINAIYOUINFOGK %>);
               <% } %>

               <% if(C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyou())) {%>
                   showKoumoku(<%= DISPGSTSZEIGK_SIHARAINAIYOUINFOGK %>);
               <% } %>

               showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);

               showGroup(<%=SNTSHRGKSSSIHARAIWASERATE%>);

               showGroup(<%=SNTSHRGKSSYENSONOTASHRGKINFO%>);

               <% if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                   showKoumoku(<%= SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO %>);
                   showKoumoku(<%= SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO %>);
               <% } %>

               showGroup(<%=SIHARAINAIYOUINFOYEN%>);

               <% if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                   showKoumoku(<%= YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN %>);
                   showKoumoku(<%= YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN %>);
               <% } %>

               <% if(C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyou())) {%>
                   showKoumoku(<%= DISPYENGSTSZEIGK_SIHARAINAIYOUINFOYEN %>);
               <% } %>
               <% if(C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                   showGroup(<%=SIHARAISYOUSAIINFO%>);

                   showGroup(<%=SIHARAIWASERATE%>);
               <%
               } else { %>
                   showGroup(<%=YENKIYKHRSSYENINFO%>);
                   showGroup(<%=YENKIYKHRSSWASERATE%>);
                   showGroup(<%=YENKIYKHRSSGKINFO%>);
               <% } %>
               $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK %>).visible(false);
               $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).visible(false);
               $(<%=DISPJPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOYEN %>).visible(false);
               $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).visible(false);
               $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).parent().find("span").eq(4).visible(true);
               $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).parent().find("span").eq(5).visible(false);
               $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).parent().find("span").eq(4).visible(true);
               $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).parent().find("span").eq(5).visible(false);

           <% } else { %>
               showGroup(<%= SIHARAINAIYOUINFO %>);

               <% if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                   showKoumoku(<%= YENDTHNKMIKEIKAP_SIHARAINAIYOUINFO %>);
                   showKoumoku(<%= YENDTHNKZENNOUSEISANKIN_SIHARAINAIYOUINFO %>);
               <% } %>

               <% if (C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyou())) {%>
                   showKoumoku(<%= DISPYENDTHNKGSTSZEIGK_SIHARAINAIYOUINFO %>);
               <% } %>

               $(<%=YENDTHNKSHRTIENRSK_SIHARAINAIYOUINFO %>).parent().find("span").eq(3).visible(true);
               $(<%=YENDTHNKSHRTIENRSK_SIHARAINAIYOUINFO %>).parent().find("span").eq(4).visible(false);

           <% } %>
       <% } %>
       <% if(C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())) {%>
          showGroup(<%=AZUKARIKININFO%>);
          showGroup(<%=AZUKARIKINYENINFO%>);
       <% } %>
    <% } else { %>
       <% if(!uiBean.getShrgkgoukeisyoukai().isOptional() && uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) { %>
           <% if(!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) { %>
               <% if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) { %>

                   showGroup(<%=SIHARAINAIYOUINFOYMD%>);

                   showGroup(<%=SIHARAINAIYOUINFOGK%>);

                   showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);

                   showGroup(<%=SNTSHRGKSSSIHARAIWASERATE%>);

                   showGroup(<%=SNTSHRGKSSYENSONOTASHRGKINFO%>);

                   <% if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                       showKoumoku(<%= GAIKAMIKEIKAP_SIHARAINAIYOUINFOGK %>);
                       showKoumoku(<%= GAIKAZENNOUSEISANKGK_SIHARAINAIYOUINFOGK %>);
                       showKoumoku(<%= SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO %>);
                       showKoumoku(<%= SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO %>);
                   <% } %>

                   <% if(C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyou())) {%>
                       showKoumoku(<%= DISPGSTSZEIGK_SIHARAINAIYOUINFOGK %>);
                   <% } %>

                   $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK %>).visible(true);
                   $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).visible(true);
                   $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).parent().find("span").eq(4).visible(false);
                   $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).parent().find("span").eq(5).visible(false);

                   <% if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {%>

                       $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK %>).visible(false);
                       $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).visible(false);
                       $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).parent().find("span").eq(4).visible(false);
                       $(<%=SHRTIENRSK_SIHARAINAIYOUINFOGK %>).parent().find("span").eq(5).visible(true);

                   <% } %>
               <% } else { %>

                   showGroup(<%=SIHARAINAIYOUINFOYMD%>);

                   showGroup(<%=SIHARAINAIYOUINFOYEN%>);

                   <% if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                       showKoumoku(<%= YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN %>);
                       showKoumoku(<%= YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN %>);
                   <% } %>

                   <% if(C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyou())) {%>
                       showKoumoku(<%= DISPYENGSTSZEIGK_SIHARAINAIYOUINFOYEN %>);
                   <% } %>

                   <% if(C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                       showGroup(<%=SIHARAISYOUSAIINFO%>);

                       showGroup(<%=SIHARAIWASERATE%>);
                   <%
                   } else { %>
                       showGroup(<%=YENKIYKHRSSYENINFO%>);
                       showGroup(<%=YENKIYKHRSSWASERATE%>);
                       showGroup(<%=YENKIYKHRSSGKINFO%>);
                   <% } %>

                   $(<%=DISPJPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOYEN %>).visible(true);
                   $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).visible(true);
                   $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).parent().find("span").eq(4).visible(false);
                   $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).parent().find("span").eq(5).visible(false);

                   <% if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {%>

                       $(<%=DISPJPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOYEN %>).visible(false);
                       $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).visible(false);
                       $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).parent().find("span").eq(4).visible(false);
                       $(<%=JPYSHRTIENRSK_SIHARAINAIYOUINFOYEN %>).parent().find("span").eq(5).visible(true);

                   <% } %>
               <% } %>
           <% } else { %>

              showGroup(<%=SIHARAINAIYOUINFOYMD%>);

               showGroup(<%= SIHARAINAIYOUINFO %>);

               <% if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                   showKoumoku(<%= YENDTHNKMIKEIKAP_SIHARAINAIYOUINFO %>);
                   showKoumoku(<%= YENDTHNKZENNOUSEISANKIN_SIHARAINAIYOUINFO %>);
               <% } %>

                <% if(C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyou())) {%>
                      showKoumoku(<%= DISPYENDTHNKGSTSZEIGK_SIHARAINAIYOUINFO %>);
                <% } %>

               <% if(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhouSiteiKbn())) { %>
                   $(<%=DISPYENDTTIENRSKKSNBINISSUU_SIHARAINAIYOUINFO %>).visible(false);
                   $(<%=YENDTHNKSHRTIENRSK_SIHARAINAIYOUINFO %>).visible(false);
                   $(<%=YENDTHNKSHRTIENRSK_SIHARAINAIYOUINFO %>).parent().find("span").eq(3).visible(false);
                   $(<%=YENDTHNKSHRTIENRSK_SIHARAINAIYOUINFO %>).parent().find("span").eq(4).visible(true);
               <% } else { %>
                   $(<%=DISPYENDTTIENRSKKSNBINISSUU_SIHARAINAIYOUINFO %>).visible(true);
                   $(<%=YENDTHNKSHRTIENRSK_SIHARAINAIYOUINFO %>).visible(true);
                   $(<%=YENDTHNKSHRTIENRSK_SIHARAINAIYOUINFO %>).parent().find("span").eq(3).visible(false);
                   $(<%=YENDTHNKSHRTIENRSK_SIHARAINAIYOUINFO %>).parent().find("span").eq(4).visible(false);
               <% } %>
           <% } %>

          showGroup(<%=ZEIMUINFO%>);

          <% if (C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyouFlag())) { %>

              showKoumoku(<%= GSTSTAISYOUSAEKI_ZEIMUINFO %>);

              showKoumoku(<%= ZEIMUGSTSZEIGK_ZEIMUINFO %>);
          <% } %>

          <% if (uiBean.getKykHnkKaisuu() > 0) {%>

             showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
          <% } %>

          <% if(!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) { %>
             <% if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {%>

                 showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
             <% } else { %>

                 $(<%= SYNYKNGK_ZEIMUINFO %>).parents('td').removeClass('c2').addClass('c1').attr('colspan', '3');

                 $(<%=SYNYKNGK_ZEIMUINFO%>).css("margin-right", "58.5%");
              <% } %>
          <% } else { %>
              $(<%= SYNYKNGK_ZEIMUINFO %>).parents('td').removeClass('c2').addClass('c1').attr('colspan', '3');

              $(<%=SYNYKNGK_ZEIMUINFO%>).css("margin-right", "58.5%");
          <% } %>
       <% } %>
       <% if(C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())) {%>
          showGroup(<%=AZUKARIKININFO%>);
          showGroup(<%=AZUKARIKINYENINFO%>);
       <% } %>
    <% } %>
   <% } %>
   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
      || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

      showGroup(<%=KOUTEIINFO %>);

   <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>

   <% if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

      $(<%=SKSSAKUSEIBTN_REFERENCEBUTTONS %>).visible(true);
   <% } %>

   <% if (uiBean.getKawaseRateMinasiKbn() == KAWASERATEMINASIKBN_SEIJYOURATE
       && uiBean.getUnitGkminasiKbn() == UNITGKMINASIKBN_TOUJITUKAKAKU) { %>

   <% if (!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

      showGroup(<%=FOOTERBUTTONS3%>);
   <% } %>

   <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

   <% if (!uiBean.getShrgkgoukeisyoukai().isOptional() && uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) { %>

      <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
          || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
          || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

         <% if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) { %>

            showGroup(<%=YENSHRTKNYUURYOKU%>);

            changeYenshrtkumu();
         <% } %>

         showGroup(<%=SHRHOUINFO%>);

         showGroup(<%=KOUZAINFO%>);

         showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
         showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);

         <% if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro()) ||
             C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
           showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
         <% } %>

         showGroup(<%=MNMEIGINOINFO%>);

      <% } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
            && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

         <% if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) { %>

            showGroup(<%=YENSHRTKNYUURYOKU%>);

            inputToOutput("#yenshrtkumuSpan > *");
         <% } %>

         showGroup(<%=SHRHOUINFO%>);

         inputToOutput(<%=INPUTSHRHOUSITEIKBN_SHRHOUINFO%>);

         showGroup(<%=KOUZAINFO%>);

          <%if (C_UmuKbn.ARI.equals(uiBean.getYenshrtkumu())) { %>
             showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
             showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
             <% if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro()) ||
                 C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
               showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
               inputToOutput(<%=SOUKINSAKIKBN_KOUZAINFO%>);
            <% } %>
          <% } %>

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

         showGroup(<%=MNMEIGINOINFO%>);

         inputToOutput(<%=KYKMNMEIGIBANGOU_MNMEIGINOINFO%>);

      <% } %>

      $("input[name='ui:000yenshrtkumu']").on('click', function(){
          changeYenshrtkumu();
      });
   <% } %>
   <% } %>

   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

      showGroup(<%=HONNININFO%>);

      showGroup(<%=HASSOUKBNGROUP%>);

      showGroup(<%=KEKKAINPUTGROUP%>);

   <% } else { %>
      <%if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
         && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

         showGroup(<%=HONNININFO%>);

         inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNININFO%>);

         showGroup(<%=HASSOUKBNGROUP%>);

         inputToOutput(<%=HASSOUKBN_HASSOUKBNGROUP%>);
      <% } %>

      <%if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

         showGroup(<%=KEKKAINPUTGROUP%>);

         showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
      <% } %>
   <% } %>
   <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT) { %>

    <%if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

       <% if (!uiBean.getShrgkgoukeisyoukai().isOptional() && uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) { %>

          <% if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) { %>

             showGroup(<%=YENSHRTKNYUURYOKU%>);
          <% } %>

          showGroup(<%=SHRHOUINFO%>);

          showGroup(<%=KOUZAINFO%>);

          <%if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu()) ||
              C_UmuKbn.ARI.equals(uiBean.getYenshrtkumu())) { %>

             showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
             showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
             <% if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro()) ||
                 C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
               showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
             <% } %>
          <% } %>

          showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);

          showGroup(<%=MNMEIGINOINFO%>);
       <% } %>

       showGroup(<%=HONNININFO%>);

       showGroup(<%=HASSOUKBNGROUP%>);
    <% } %>

    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

        showGroup(<%=KEKKAINPUTGROUP%>);

    <% } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>

         showGroup(<%=KEKKAINPUTGROUP%>);

         showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);

     <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    openReport("print", "_blank");
<% } %>

function changeGengkhoukbn(gengkhoukbn){

  var value = $(gengkhoukbn).val();

  if (value == "<%=C_GengkhouKbn.PD.getValue()%>") {

      $(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO%>).val("");
      setReadOnlyGray(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO%>);

      removeReadOnlyGray(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>);

  } else if (value == "<%=C_GengkhouKbn.SD.getValue()%>") {

      removeReadOnlyGray(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO%>);

      $(<%=SYUP_GENGAKUNYUURYOKUSYUINFO%>).val("");
      setReadOnlyGray(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>);
  } else {

      $(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO%>).val("");
      setReadOnlyGray(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO%>);

      $(<%=SYUP_GENGAKUNYUURYOKUSYUINFO%>).val("");
      setReadOnlyGray(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>);
  }
}

function onloadGengkhoukbn(gengkhoukbn){

  var value = $(gengkhoukbn).val();

  if (value == "<%=C_GengkhouKbn.PD.getValue()%>") {

      $(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO%>).val("");
      setReadOnlyGray(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO%>);

      removeReadOnlyGray(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>);

  } else if (value == "<%=C_GengkhouKbn.SD.getValue()%>") {

      removeReadOnlyGray(<%=SYUKIHONS_GENGAKUNYUURYOKUSYUINFO%>);

      $(<%=SYUP_GENGAKUNYUURYOKUSYUINFO%>).val("");
      setReadOnlyGray(<%=SYUP_GENGAKUNYUURYOKUSYUINFO %>);
  }
}

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
