<%--
    kh_kaiyaku.js.jsp - 解約 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkaiyaku.KhKaiyakuConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkaiyaku.KhKaiyakuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khkaiyaku.KhKaiyakuUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_Kaiyakujiyuu" %>
<%@page import="yuyu.def.classification.C_KaiyksyorikahiKbn" %>
<%@page import="yuyu.def.classification.C_InputShrhousiteiKbn" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="jp.co.slcs.swak.number.BizCurrency" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil" %>
<%@page import="yuyu.def.classification.C_Hrkkeiro" %>
<%@page import="yuyu.def.classification.C_Kykjyoutai" %>
<% KhKaiyakuUiBean uiBean = SWAKInjector.getInstance(KhKaiyakuUiBean.class); %>
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
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtokusin/view_tokusin.js.jsp" />
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp" />
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp" />
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhaitoukin/view_haitoukin.js.jsp" />
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkhtkshrsiharaikouza/view_kh_tkshr_siharai_kouza.js.jsp" />
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

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
       uiBean.getPageNo() == PAGENO_REFERENCE ||
       uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
    if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
      showGroup(<%=KOUTEIINFO%>);
  <% } %>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
  $(<%= KAIYAKUJIYUUINFO + DIV%>).css("margin-top", "-1px");
<% }%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>
      showGroup(<%=KAIYAKUSYORINYUURYOKUINFO%>);
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
      $(<%=SKSSAKUSEIBTN_REFERENCEBUTTONS%>).visible(true);
  <% } %>

  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
      showGroup(<%=KAIYAKUSYORINYUURYOKUINFO%>);
  <% } %>

  <%
    if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
      <%
        if (C_Kaiyakujiyuu.KYKSB.equals(uiBean.getKaiyakujiyuu())||
            C_Kaiyakujiyuu.SKS.equals(uiBean.getKaiyakujiyuu())) { %>
          showGroup(<%=SHSNMINFO%>);
          showGroup(<%=SHSKADRINFO%>);
      <% } %>
  <% } %>

  <%
    if (C_KaiyksyorikahiKbn.KA.equals(uiBean.getKaiyksyorikahikbn())) { %>
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
        if ((!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
             !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) &&
             !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
          showGroup(<%=HONNININFO%>);
          showGroup(<%=KANRYOUINFO%>);

          <%
            if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
              inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNININFO%>);
              inputToOutput(<%=KANRYOTUUTIOUTKBN_KANRYOUINFO%>);
              $(<%= IIC0001 %>).text("");
          <% } %>

          <%
            if (C_Kaiyakujiyuu.KYKSB.equals(uiBean.getKaiyakujiyuu())) { %>
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
          <%
            } else if (C_Kaiyakujiyuu.SKS.equals(uiBean.getKaiyakujiyuu())) { %>
              showGroup(<%=SAIKENINFO%>);
              showGroup(<%=SAIKENINFO2%>);

              <%
                if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
                  inputToOutput(<%=SAIKENNMKJ_SAIKENINFO%>);
                  inputToOutput(<%=SAIKENNYNO_SAIKENINFO2%>);
                  inputToOutput(<%=SAIKENADR1KJ_SAIKENINFO2%>);
                  inputToOutput(<%=SAIKENADR2KJ_SAIKENINFO2%>);
                  inputToOutput(<%=SAIKENADR3KJ_SAIKENINFO2%>);
              <% } %>
          <% } %>

          <%
            if (uiBean.getShrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0 ||
                uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
                    BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0) { %>
              showGroup(<%=SIHARAIHOUHOU%>);
              showGroup(<%=KOUZAINFO%>);
              showGroup(<%=MNMEIGINOINFO%>);

              <%
              if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {%>
                  showKoumoku(<%=UKTMNMEIGIBANGOU_MNMEIGINOINFO%>);
              <%} %>

              <%
              if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

                  if (C_UmuKbn.ARI.equals(uiBean.getYenshrtkumu()) || C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                    showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
                    showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
                <%}
                } else {%>
                    showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
                    showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
              <%}%>
              changeYenshrtkumu();
              $("input[name='ui:0G0yenshrtkumu']").on('click', function(){
                changeYenshrtkumu();
              });

              <%
                if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
                  showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);
                  inputToOutput(<%=KZSYURUIKBN_KOUZAINFO%>);

                  inputToOutput(<%=INPUTSHRHOUSITEIKBN_SIHARAIHOUHOU%>);
                  inputToOutput(<%=BANKCD_KOUZAINFO%>);
                  inputToOutput(<%=SITENCD_KOUZAINFO%>);
                  inputToOutput(<%=KOUZANO_KOUZAINFO%>);
                  inputToOutput(<%=KZMEIGINMKN_KOUZAINFO%>);
                  inputToOutput(<%=KYKMNMEIGIBANGOU_MNMEIGINOINFO%>);

                  <%
                  if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {%>
                      inputToOutput(<%=UKTMNMEIGIBANGOU_MNMEIGINOINFO%>);
                  <%} %>

                  <%
                  if (C_UmuKbn.ARI.equals(uiBean.getYenshrtkumu()) || C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                       inputToOutput(<%=YOKINKBN_KOUZAINFO%>);
                       inputToOutput(<%=KZDOUKBN_KOUZAINFO%>);
                  <% }%>

                  $(<%= IBC1001 %>).text("");
                  $(<%= IBC1002 %>).text("");
                  $(<%= IBC1003 %>).text("");
                  $(<%= IBC1004 %>).text("");
                  $(<%= IIC1003 %>).text("");
              <% } %>

              <%
                if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
                  <%
                  if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro()) || C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
                      showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                      inputToOutput(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                  <% }%>
              <%
              } else { %>
                  <%
                  if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro()) || C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
                      showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                  <% }%>
              <% } %>

              <%
                if (C_UmuKbn.ARI.equals(uiBean.getYenshrtktekiumu())) { %>
                  showGroup(<%=YENSHRTKUMUINFO%>);

                  <%
                    if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
                      inputToOutput("#yenshrtkumuSpan > *");
                  <% } %>
              <% } %>
          <% } %>
      <% } %>

    <%
      if (!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
        showGroup(<%=FOOTERBUTTONS3%>);
    <% } %>

  <% } %>

  $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK%>).css("padding-right", "295px");
  $(<%=DISPJPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOYEN%>).css("padding-right", "295px");
  $(<%=DISPYENDTTIENRSKKSNBINISSUU_SIHARAINAIYOUINFOYENDTHNK%>).css("padding-right", "295px");
<% }%>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
      showGroup(<%=KAIYAKUSYORINYUURYOKUINFO%>);
      showGroup(<%=SIHARAINAIYOUINFO%>);
      showKoumoku(<%=SHRYMD_SIHARAINAIYOUINFO%>);
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
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
      showGroup(<%=HONNININFO%>);
      showGroup(<%=KANRYOUINFO%>);

      <%
        if (C_Kaiyakujiyuu.KYKSB.equals(uiBean.getKaiyakujiyuu())) { %>
          showGroup(<%=KYKSYASZKINFO%>);
          showGroup(<%=KYKSYASZKINFO2%>);
      <%
        } else if (C_Kaiyakujiyuu.SKS.equals(uiBean.getKaiyakujiyuu())) { %>
          showGroup(<%=SAIKENINFO%>);
          showGroup(<%=SAIKENINFO2%>);
      <% } %>

      <%
        if (uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0 ||
            uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0) { %>
          showGroup(<%=SIHARAIHOUHOU%>);
          showGroup(<%=KOUZAINFO%>);
          showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);
          showGroup(<%=MNMEIGINOINFO%>);

          <%
            if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {%>
               showKoumoku(<%=UKTMNMEIGIBANGOU_MNMEIGINOINFO%>);
          <% } %>

          <%
            if (C_UmuKbn.ARI.equals(uiBean.getYenshrtktekiumu())) { %>
              showGroup(<%=YENSHRTKUMUINFO%>);
          <% } %>

          <%
            if (C_UmuKbn.ARI.equals(uiBean.getYenshrtkumu()) || C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
              showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
              showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
          <% } %>

          <%
          if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro()) || C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
             showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
         <% }%>
      <% } %>
  <% } %>

  <%
    if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {%>
    $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK%>).css("padding-right", "110px");
    $(<%=DISPJPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOYEN%>).css("padding-right", "110px");
    $(<%=DISPYENDTTIENRSKKSNBINISSUU_SIHARAINAIYOUINFOYENDTHNK%>).css("padding-right", "110px");
  <%

  } else { %>
     <%
       if (!C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) && !C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) { %>
        $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK%>).css("padding-right", "295px");
        $(<%=DISPJPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOYEN%>).css("padding-right", "295px");
        $(<%=DISPYENDTTIENRSKKSNBINISSUU_SIHARAINAIYOUINFOYENDTHNK%>).css("padding-right", "295px");
    <% } %>
  <% } %>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
       uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
      showGroup(<%=KAIYAKUSYORINYUURYOKUINFO%>);
  <% } %>

  <%
    if (C_Kaiyakujiyuu.KYKSB.equals(uiBean.getKaiyakujiyuu())||
        C_Kaiyakujiyuu.SKS.equals(uiBean.getKaiyakujiyuu())) { %>
      showGroup(<%=SHSNMINFO%>);
      showGroup(<%=SHSKADRINFO%>);
  <% } %>

  $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK%>).css("padding-right", "295px");
  $(<%=DISPJPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOYEN%>).css("padding-right", "295px");
  $(<%=DISPYENDTTIENRSKKSNBINISSUU_SIHARAINAIYOUINFOYENDTHNK%>).css("padding-right", "295px");

<% }%>

 <% if (uiBean.getPageNo() == PAGENO_RESULT || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <% if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
        openReport("print", "_blank");
    <% } %>
 <% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT || uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
       uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
  <%
     if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
         !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
       $(<%= ROWSPAN2 %>).attr('rowspan', '2');
       $(<%= COLSPAN1 %>).attr('colspan', '1');
       $(<%= ROWSPAN4 %>).attr('rowspan', '4');
       $(<%= ROWSPAN5 %>).attr('rowspan', '5');
       $(<%= ROWSPAN6 %>).attr('rowspan', '6');
       $(<%= ROWSPAN7 %>).attr('rowspan', '7');
       $(<%= ROWSPAN9 %>).attr('rowspan', '9');

       <% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
           uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

            <%
            if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                <%
                   if (C_UmuKbn.NONE.eq(uiBean.getYuuyokkntyoukaumu())) { %>
                       showGroup(<%=SIHARAINAIYOUINFOGK%>);
                       <%
                          if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                              showKoumoku(<%=DISPGSTSZEIGK_SIHARAINAIYOUINFOGK%>);
                       <% } %>
                       <%
                          if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                              showKoumoku(<%=MIKEIKAP_SIHARAINAIYOUINFOGK%>);
                              showKoumoku(<%=ZENNOUSEISANKIN_SIHARAINAIYOUINFOGK%>);
                       <% } %>
                       showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);
                       showGroup(<%=SNTSHRGKSSSIHARAIKAWASERATE%>);
                       showGroup(<%=SNTSHRGKSSGOUKEIINFO%>);
                       <%
                          if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                              showKoumoku(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSGOUKEIINFO%>);
                              showKoumoku(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSGOUKEIINFO%>);
                       <% } %>
               <% } %>

               showGroup(<%=SIHARAINAIYOUINFOYEN%>);
                <%
                   if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                     showKoumoku(<%=DISPYENGSTSZEIGK_SIHARAINAIYOUINFOYEN%>);
               <% } %>
               <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                      showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                      showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
               <% } %>
               <%
                  if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                  showGroup(<%=SIHARAISYOUSAIINFO%>);
                  showGroup(<%=SHRKWSRATEINFO%>);

                  showGroup(<%=KIYKHRSYOUSAIINFO%>);

                  showKoumoku(<%=KIYKHRSYOUSAIKIYKHRTOGOUKEI_KIYKHRSYOUSAIINFO%>);

                  <%
                   if (C_UmuKbn.ARI.eq(uiBean.getMvatekiumu())) { %>
                      showKoumoku(<%=KIYKHRSYOUSAISJKKKTYOUSEIRT_KIYKHRSYOUSAIINFO%>);
                  <% } %>

                  <%
                   if (C_UmuKbn.ARI.eq(uiBean.getKaiyakukoujyoritutekiumu())) { %>
                      showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJGK_KIYKHRSYOUSAIINFO%>);
                      showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJRITU_KIYKHRSYOUSAIINFO%>);
                  <% } %>
               <%
               } else { %>
                  showGroup(<%=KIYKHRSTOUSGOUKEIINFOYEN%>);
                  showGroup(<%=KIYKHRSTOUSKAWASERATE%>);
                  showGroup(<%=KIYKHRSTOUSGOUKEIINFO%>);
               <% } %>

              <%
                 if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
                     SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) &&
                     !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                   showGroup(<%=PTUMITATEKININFO%>);
              <% } %>
           <%
             } else { %>
                showGroup(<%=SIHARAINAIYOUINFOYENDTHNK%>);

                <%
                   if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                       showKoumoku(<%=DISPYENDTHNKGSTSZEIGK_SIHARAINAIYOUINFOYENDTHNK%>);
                <% } %>
                <%
                   if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                       showKoumoku(<%=YENDTHNKMIKEIKAP_SIHARAINAIYOUINFOYENDTHNK%>);
                       showKoumoku(<%=YENDTHNKZENNOUSEISANKIN_SIHARAINAIYOUINFOYENDTHNK%>);
                       showKoumoku(<%=YENDTHNKKRKGK_SIHARAINAIYOUINFOYENDTHNK%>);
                <%
                } else { %>
                       showKoumoku(<%=SONOTASEISAN_SIHARAINAIYOUINFOYENDTHNK%>);
                <% } %>
                <%
                  if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                     showGroup(<%=KIYKHRSYOUSAIINFO%>);
                     showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUHR_KIYKHRSYOUSAIINFO%>);
               <% } %>
            <% } %>
       <% } %>
       <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
         <%
            if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
             <%
                if (C_UmuKbn.NONE.equals(uiBean.getYenshrtkumu())) { %>
                  showGroup(<%=SIHARAINAIYOUINFOGK%>);
                  <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                      showKoumoku(<%=MIKEIKAP_SIHARAINAIYOUINFOGK%>);
                      showKoumoku(<%=ZENNOUSEISANKIN_SIHARAINAIYOUINFOGK%>);
                  <% } %>
                  <%
                   if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                     showKoumoku(<%=DISPGSTSZEIGK_SIHARAINAIYOUINFOGK%>);
                  <% } %>

                   showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);
                   showGroup(<%=SNTSHRGKSSSIHARAIKAWASERATE%>);
                   showGroup(<%=SNTSHRGKSSGOUKEIINFO%>);
                  <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                      showKoumoku(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSGOUKEIINFO%>);
                      showKoumoku(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSGOUKEIINFO%>);
                  <% } %>
             <%
                } else { %>
                  showGroup(<%=SIHARAINAIYOUINFOYEN%>);
                  <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                      showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                      showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                  <% } %>
                  <%
                   if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                     showKoumoku(<%=DISPYENGSTSZEIGK_SIHARAINAIYOUINFOYEN%>);
                  <% } %>
                  <%
                    if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                        showGroup(<%=SIHARAISYOUSAIINFO%>);
                        showGroup(<%=SHRKWSRATEINFO%>);
                  <% } %>
             <% } %>

             <%
                if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                    showGroup(<%=KIYKHRSYOUSAIINFO%>);
                    showKoumoku(<%=KIYKHRSYOUSAIKIYKHRTOGOUKEI_KIYKHRSYOUSAIINFO%>);

                    <%
                       if (C_UmuKbn.ARI.eq(uiBean.getMvatekiumu())) { %>
                          showKoumoku(<%=KIYKHRSYOUSAISJKKKTYOUSEIRT_KIYKHRSYOUSAIINFO%>);
                    <% } %>
                    <%
                       if (C_UmuKbn.ARI.eq(uiBean.getKaiyakukoujyoritutekiumu())) { %>
                          showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJGK_KIYKHRSYOUSAIINFO%>);
                          showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJRITU_KIYKHRSYOUSAIINFO%>);
                     <% } %>
             <% } %>

             <%
             if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
               <%
                  if (C_UmuKbn.ARI.equals(uiBean.getYenshrtkumu())) { %>
                   showGroup(<%=KIYKHRSTOUSGOUKEIINFOYEN%>);
                   showGroup(<%=KIYKHRSTOUSKAWASERATE%>);
                   showGroup(<%=KIYKHRSTOUSGOUKEIINFO%>);
                 <% } %>
             <% } %>

              <%
                 if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
                     SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) &&
                     !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                   showGroup(<%=PTUMITATEKININFO%>);
              <% } %>
         <%
            } else { %>
             showGroup(<%=SIHARAINAIYOUINFOYENDTHNK%>);
             <%
                if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=YENDTHNKMIKEIKAP_SIHARAINAIYOUINFOYENDTHNK%>);
                    showKoumoku(<%=YENDTHNKZENNOUSEISANKIN_SIHARAINAIYOUINFOYENDTHNK%>);
                    showKoumoku(<%=YENDTHNKKRKGK_SIHARAINAIYOUINFOYENDTHNK%>);
             <%
             } else { %>
                    showKoumoku(<%=SONOTASEISAN_SIHARAINAIYOUINFOYENDTHNK%>);
             <% } %>
             <%
                if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                    showKoumoku(<%=DISPYENDTHNKGSTSZEIGK_SIHARAINAIYOUINFOYENDTHNK%>);
             <% } %>
             <%
                if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                   showGroup(<%=KIYKHRSYOUSAIINFO%>);
                   showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUHR_KIYKHRSYOUSAIINFO%>);
             <% } %>
         <% } %>
         showGroup(<%=SIHARAINAIYOUINFO%>);

         showGroup(<%=ZEIMUINFO%>);
         <%
            if (!C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) { %>
                showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
         <%
         } else { %>
             $(<%=SYNYKNGK_ZEIMUINFO%>).css("margin-right", "58.5%");
             $(<%=SYNYKNGK_ZEIMUINFO%>).parent().removeClass("c").addClass("c1").attr("colSpan","3");
         <% } %>
         <%
            if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyouFlg())) { %>
               showKoumoku(<%=GSTSTAISYOUSAEKI_ZEIMUINFO%>);
               showKoumoku(<%=YENGSTSZEIGK_ZEIMUINFO%>);
         <% } %>
         <%
            if (uiBean.getKykhnkkaisuu() > 0) {%>
               showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
          <% } %>
       <% } %>
  <% } %>
<% } %>

function changeYenshrtkumu(){

  var value = $("input[name='ui:0G0yenshrtkumu']:checked").val();
  var kyktuukasyu = '<%=uiBean.getKyktuukasyu() %>';

  if (value == "0" && kyktuukasyu != "JPY") {


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
