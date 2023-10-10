<%--
    kh_online_nyuukin.js.jsp - オンライン入金処理 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khonlinenyuukin.KhOnlineNyuukinConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khonlinenyuukin.GenKhOnlineNyuukinConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khonlinenyuukin.KhOnlineNyuukinSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn" %>
<%@page import="yuyu.app.hozen.khansyuu.khonlinenyuukin.KhOnlineNyuukinUiBean" %>
<%@page import="yuyu.app.hozen.khansyuu.khonlinenyuukin.KhOnlineNyuukinBizLogic" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_NykhouhouKbn" %>
<%@page import="yuyu.def.classification.C_TkiktbrisyuruiKbn" %>
<%@page import="yuyu.def.classification.C_Hrkkaisuu" %>
<% KhOnlineNyuukinUiBean uiBean = SWAKInjector.getInstance(KhOnlineNyuukinUiBean.class); %>
<% KhOnlineNyuukinBizLogic khOnlineNyuukinBizLogic = SWAKInjector.getInstance(KhOnlineNyuukinBizLogic.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
  commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtokusin/view_tokusin.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp"/>
<% } %>

<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getPageNo() == PAGENO_INPUTKEY ) { %>
    showGroup(<%=KARIUKEKININFO%>);

    $(<%=KIHONINFO%>).css("margin-top", "-1px");

    $(<%=NYKHOUHOUINFO%>).css("margin-top", "-21px");

    $(<%=KARIUKEKININFO%>).css("margin-top", "-21px");
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    $(<%=RSGAKU_NYUUKINSYORIINFO%>).addClass("lertKrkgk");
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM ||
    uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou())) { %>
      if ($(<%= HRKEIRAIINFO%>)[0].rows.length > 2) {
         $(<%= HRKEIRAIINFO%> + "Div").visible(true);
      }

      $(<%= ROWSPAN2_HRKEIRAIINFO %>).attr("rowspan", "2");
      $(<%= COLSPAN1_HRKEIRAIINFO %>).attr("colspan", "1");
    <% } %>

    <% if (C_NykhouhouKbn.HURIKAE.eq(uiBean.getNykhouhou())) { %>
      showGroup(<%= NYUUKINSYORIINFO%>);

      showKoumoku(<%=TYAKKINYMD_NYUUKINSYORIINFO%>);

    <% } %>

    <% if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) { %>
      showGroup(<%= NYUUKINSYORIINFO%>);
      showKoumoku(<%= HRKKAISUU_NYUUKINSYORIINFO%>);

      showKoumoku(<%= TIKIKTBRISYURUIKBN_NYUUKINSYORIINFO%>);

      showKoumoku(<%= NYKNAIYOUKBN_NYUUKINSYORIINFO%>);
      $(<%= NYKNAIYOUKBN_LABEL %>).visible(true);

      showKoumoku(<%= JYUUTOUYM_NYUUKINSYORIINFO%>);
      $(<%= JYUUTOUYM_LABEL %>).visible(true);

      showKoumoku(<%= JYUTOUKAISUUY_NYUUKINSYORIINFO%>);
      $(<%= JYUTOUKAISUUY_LABEL %>).visible(true);

      showKoumoku(<%= NYKINPUTDENYMD_NYUUKINSYORIINFO%>);

    <% } %>

    <% if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) { %>
      showGroup(<%=KARIUKEKININFO%>);

      $(<%= DUMMYKMK1_LABEL %>).css("width", "14%");
      $(<%= DUMMYKMK1_DATA %>).css("width", "36%");
      $(<%= DUMMYKMK2_DATA %>).css("width", "50%");

      <% if (uiBean.getDispjyutoukaisuuy() != null && uiBean.getDispjyutoukaisuuy() != 0) { %>
        $(<%=DISPJYUTOUKAISUUY_KARIUKEKININFO%>).parent().find("span").eq(3).remove();
        $(<%=DISPJYUTOUKAISUUY_KARIUKEKININFO%>).parent().find("span").eq(2).remove();
      <% } else { %>
        <% if (uiBean.getDispjyutoukaisuuy() == 0) { %>
          $(<%=DISPJYUTOUKAISUUY_KARIUKEKININFO%>).parent().find("span").eq(1).remove();
          $(<%=DISPJYUTOUKAISUUY_KARIUKEKININFO%>).parent().find("span").eq(0).remove();
        <% } %>
        $(<%=DISPJYUTOUKAISUUM_KARIUKEKININFO%>).removeClass("leftMargin");
      <% } %>

    <% } %>

  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ) { %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(HRKKAISUU, uiBean.getNykhouhou())) { %>
      $(<%= HRKKAISUU_NYUUKINSYORIINFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(NYKNAIYOUKBN, uiBean.getNykhouhou())) { %>
      $('td' + <%= NYKNAIYOUKBN_LABEL%>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(RYOSYUYMD, uiBean.getNykhouhou())) { %>
      $(<%= RYOSYUYMD_NYUUKINSYORIINFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(TYAKKINYMD, uiBean.getNykhouhou())) { %>
      $(<%= TYAKKINYMD_NYUUKINSYORIINFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(RSGAKU, uiBean.getNykhouhou())) { %>
      $(<%= RSGAKU_NYUUKINSYORIINFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(NYKINPUTDENYMD, uiBean.getNykhouhou())) { %>
      $(<%= NYKINPUTDENYMD_NYUUKINSYORIINFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(SUITOSOSHIKICD, uiBean.getNykhouhou())) { %>
      $(<%= SUITOSOSHIKICD_NYUUKINSYORIINFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(TABAKARIKANJYONO, uiBean.getNykhouhou())) { %>
      $(<%= TABAKARIKANJYONO_NYUUKINSYORIINFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(NYKINPUTHRKKAISUU, uiBean.getNykhouhou())) { %>
      $(<%= DISPHRKKAISUU_KARIUKEKININFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(NYKINPUTNYKKEIRO, uiBean.getNykhouhou())) { %>
      $(<%= DISPNYKKEIRO_KARIUKEKININFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(NYKINPUTNYKNAIYOUKBN, uiBean.getNykhouhou())) { %>
      $(<%= DISPNYKNAIYOUKBN_KARIUKEKININFO + LABEL %>).required(true);
    <% } %>

    <% if (khOnlineNyuukinBizLogic.checkJyoukentukiHissu(NYKINPUTRYOSYUYMD, uiBean.getNykhouhou())) { %>
      $(<%= DISPRYOSYUYMD_KARIUKEKININFO + LABEL %>).required(true);
    <% } %>

    <% if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) { %>
      <% if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getTikiktbrisyuruikbn()) ||
          C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getTikiktbrisyuruikbn())) { %>
          setJyutoukaisuuyAndJyutoukaisuum();
      <% } %>

      $(<%=TIKIKTBRISYURUIKBN_NYUUKINSYORIINFO%>).change( function() {
        var value = $(<%=TIKIKTBRISYURUIKBN_NYUUKINSYORIINFO%>).val();
        if (value == "<%=C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.getValue()%>" ||
            value == "<%=C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.getValue()%>") {
            setJyutoukaisuuyAndJyutoukaisuum();
        }
        else {
           removeReadOnlyGray(<%=JYUTOUKAISUUY_NYUUKINSYORIINFO%>);
           removeReadOnlyGray(<%=JYUTOUKAISUUM_NYUUKINSYORIINFO%>);
        }
      });

      <% if (C_Hrkkaisuu.HALFY.eq(uiBean.getHrkkaisuu()) || C_Hrkkaisuu.NEN.eq(uiBean.getHrkkaisuu())) { %>
          setTikiktbrisyuruikbn();
      <% } %>

      $(<%=HRKKAISUU_NYUUKINSYORIINFO%>).change( function() {
        var value = $(<%=HRKKAISUU_NYUUKINSYORIINFO%>).val();
        if (value == "<%=C_Hrkkaisuu.HALFY.getValue()%>" || value == "<%=C_Hrkkaisuu.NEN.getValue()%>") {
           setTikiktbrisyuruikbn();
        }
        else {
          $(<%=TIKIKTBRISYURUIKBN_NYUUKINSYORIINFO%>).find("option").each(function(){
            $(this).removeAttr("disabled");
          });
          $(<%=TIKIKTBRISYURUIKBN_NYUUKINSYORIINFO%>).removeClass("backgroundReadOnlyGray");
        }
      });

    <% } %>
    <% if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) { %>
      <% if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getNykinputtikiktbrisyuruikbn()) ||
          C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getNykinputtikiktbrisyuruikbn())) { %>
          setNykinputJyutoukaisuuyAndJyutoukaisuum();
      <% } %>

      $(<%=NYKINPUTTIKIKTBRISYURUIKBN_KARIUKEKININFO%>).change( function() {
        var value = $(<%=NYKINPUTTIKIKTBRISYURUIKBN_KARIUKEKININFO%>).val();
        if (value == "<%=C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.getValue()%>" ||
            value == "<%=C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.getValue()%>") {
            setNykinputJyutoukaisuuyAndJyutoukaisuum();
        }
        else {
           removeReadOnlyGray(<%=NYKINPUTJYUTOUKAISUUY_KARIUKEKININFO%>);
           removeReadOnlyGray(<%=NYKINPUTJYUTOUKAISUUM_KARIUKEKININFO%>);
        }
      });

      <% if (C_Hrkkaisuu.HALFY.eq(uiBean.getNykinputhrkkaisuu()) || C_Hrkkaisuu.NEN.eq(uiBean.getNykinputhrkkaisuu())) { %>
          setNykinputtikiktbrisyuruikbn();
      <% } %>

      $(<%=NYKINPUTHRKKAISUU_KARIUKEKININFO%>).change( function() {
        var value = $(<%=NYKINPUTHRKKAISUU_KARIUKEKININFO%>).val();
        if (value == "<%=C_Hrkkaisuu.HALFY.getValue()%>" || value == "<%=C_Hrkkaisuu.NEN.getValue()%>") {
           setNykinputtikiktbrisyuruikbn();
        }
        else {
          $(<%=NYKINPUTTIKIKTBRISYURUIKBN_KARIUKEKININFO%>).find("option").each(function(){
            $(this).removeAttr("disabled");
          });
          $(<%=NYKINPUTTIKIKTBRISYURUIKBN_KARIUKEKININFO%>).removeClass("backgroundReadOnlyGray");
        }
      });

    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (C_NykhouhouKbn.KARIUKEKEIJYOU.eq(uiBean.getNykhouhou())) { %>
      <% if (uiBean.getJyutoukaisuuy() != null && uiBean.getJyutoukaisuuy() != 0) { %>
         $(<%=JYUTOUKAISUUY_NYUUKINSYORIINFO%>).parent().find("span").eq(3).remove();
         $(<%=JYUTOUKAISUUY_NYUUKINSYORIINFO%>).parent().find("span").eq(2).remove();
      <% } else { %>
         $(<%=JYUTOUKAISUUM_NYUUKINSYORIINFO%>).removeClass("leftMargin")
      <% } %>
    <% } %>
    <% if (C_NykhouhouKbn.KARIUKE.eq(uiBean.getNykhouhou())) { %>
      <% if (uiBean.getNykinputjyutoukaisuuy() != null && uiBean.getNykinputjyutoukaisuuy() != 0) { %>
         $(<%=NYKINPUTJYUTOUKAISUUY_KARIUKEKININFO%>).parent().find("span").eq(3).remove();
         $(<%=NYKINPUTJYUTOUKAISUUY_KARIUKEKININFO%>).parent().find("span").eq(2).remove();
      <% } else { %>
         $(<%=NYKINPUTJYUTOUKAISUUM_KARIUKEKININFO%>).removeClass("leftMargin")
      <% } %>
    <% } %>
  <% } %>
  <% if (uiBean.getPageNo() == PAGENO_RESULT ) { %>
    <% if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
        openReport("print", "_blank");
    <% } %>
  <% } %>

function setJyutoukaisuuyAndJyutoukaisuum () {
  setReadOnlyGray(<%=JYUTOUKAISUUY_NYUUKINSYORIINFO%>);
  setReadOnlyGray(<%=JYUTOUKAISUUM_NYUUKINSYORIINFO%>);
}

function setNykinputJyutoukaisuuyAndJyutoukaisuum () {
  setReadOnlyGray(<%=NYKINPUTJYUTOUKAISUUY_KARIUKEKININFO%>);
  setReadOnlyGray(<%=NYKINPUTJYUTOUKAISUUM_KARIUKEKININFO%>);
}

function setTikiktbrisyuruikbn() {
  $(<%=TIKIKTBRISYURUIKBN_NYUUKINSYORIINFO%>).val('<%=C_TkiktbrisyuruiKbn.BLNK.getValue()%>');
  $(<%=TIKIKTBRISYURUIKBN_NYUUKINSYORIINFO%>).find("option").each(function(){
    if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
  });
  $(<%=TIKIKTBRISYURUIKBN_NYUUKINSYORIINFO%>).addClass("backgroundReadOnlyGray");
  removeReadOnlyGray(<%=JYUTOUKAISUUY_NYUUKINSYORIINFO%>);
  removeReadOnlyGray(<%=JYUTOUKAISUUM_NYUUKINSYORIINFO%>);
}

function setNykinputtikiktbrisyuruikbn() {
  $(<%=NYKINPUTTIKIKTBRISYURUIKBN_KARIUKEKININFO%>).val('<%=C_TkiktbrisyuruiKbn.BLNK.getValue()%>');
  $(<%=NYKINPUTTIKIKTBRISYURUIKBN_KARIUKEKININFO%>).find("option").each(function(){
    if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
  });
  $(<%=NYKINPUTTIKIKTBRISYURUIKBN_KARIUKEKININFO%>).addClass("backgroundReadOnlyGray");
  removeReadOnlyGray(<%=NYKINPUTJYUTOUKAISUUY_KARIUKEKININFO%>);
  removeReadOnlyGray(<%=NYKINPUTJYUTOUKAISUUM_KARIUKEKININFO%>);
}

});
//-->
</script>
