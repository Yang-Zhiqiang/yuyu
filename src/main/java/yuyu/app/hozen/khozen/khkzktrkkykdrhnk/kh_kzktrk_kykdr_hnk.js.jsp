<%--
    kh_kzktrk_kykdr_hnk.js.jsp - 家族登録／契約者代理特約変更 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkzktrkkykdrhnk.KhKzktrkKykdrHnkConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkzktrkkykdrhnk.KhKzktrkKykdrHnkSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khkzktrkkykdrhnk.KhKzktrkKykdrHnkUiBean" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.def.classification.C_MousideninKbn" %>
<%@page import="yuyu.def.classification.C_TeiseiKbn" %>
<%@page import="yuyu.def.classification.C_TrkkzkttdkKbn" %>
<%@page import="yuyu.def.classification.C_Seibetu" %>
<%@page import="yuyu.def.classification.C_Tdk" %>
<%@page import="yuyu.def.classification.C_KykdrtkykttdkKbn" %>
<%@page import="yuyu.def.classification.C_UktKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_TsindousiteiKbn" %>
<% KhKzktrkKykdrHnkUiBean uiBean = SWAKInjector.getInstance(KhKzktrkKykdrHnkUiBean.class);
   KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
   CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
   commonViewInBean.setCommonViewUiBeanParam(uiBean);
   commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<%
  if (uiBean.getPageNo() != PAGENO_INPUTKEY) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp" />
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp" />
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsiteiseikyuu/view_siteiseikyuu.js.jsp" />
   <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
           <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
           <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
   <% } %>

   <%
    if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {%>
       <%
          if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
              !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>
               <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
       <% } %>
   <% } %>
<% } %>
<%
  if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
    <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
        <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
    <% } %>
<% }%>
<script type="text/javascript"><!--
$(function(){
<%
   if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
    $(<%= MOUSIDENININFO + DIV%>).css("margin-top", "-1px");
    $(<%= TEISEIKBNINFO + DIV%>).css("margin-top", "-1px");
<% }%>

<%
  if (uiBean.getPageNo() != PAGENO_INPUTKEY) { %>
      <%
      if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) { %>
        $(<%= KOUTEIINFO + DIV%>).visible(false);
    <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
   <%
      if (!C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) &&
          !C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) &&
          !C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
          !(C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode()) &&
            C_TeiseiKbn.TEISEI.eq(uiBean.getTeiseikbn()))) { %>
          inputToOutput(<%=TRKKZKTTDKKBN1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKNMKN1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKNMKJ1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKNMKJKHUKA1_TRKKZKINFO1%>);
          $(<%= NEWTRKKZKNMKJKHUKAKBN1_TRKKZKINFO1 %>).visible(true);
          inputToOutput("#newtrkkzkseiymd1Span > *");
          inputToOutput(<%=NEWTRKKZKSEI1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKYNO1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKADR1KJ1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKADR2KJ1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKADR3KJ1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKTELNO1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKTDK1_TRKKZKINFO1%>);
          inputToOutput(<%=NEWTRKKZKTSINDOUSITEIKBN1_TRKKZKINFO1%>);

          inputToOutput(<%=TRKKZKTTDKKBN2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKNMKN2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKNMKJ2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKNMKJKHUKA2_TRKKZKINFO2%>);
          $(<%= NEWTRKKZKNMKJKHUKAKBN2_TRKKZKINFO2 %>).visible(true);
          inputToOutput("#newtrkkzkseiymd2Span > *");
          inputToOutput(<%=NEWTRKKZKSEI2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKYNO2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKADR1KJ2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKADR2KJ2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKADR3KJ2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKTELNO2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKTDK2_TRKKZKINFO2%>);
          inputToOutput(<%=NEWTRKKZKTSINDOUSITEIKBN2_TRKKZKINFO2%>);

          inputToOutput(<%=KYKDRTKYKTTDKKBN_KYKSYADAIRITKINFO%>);
          inputToOutput(<%=NEWKYKDRKBN_KYKSYADAIRITKINFO%>);
          inputToOutput(<%=NEWKYKDRNMKN_KYKSYADAIRITKINFO%>);
          inputToOutput(<%=NEWKYKDRNMKJ_KYKSYADAIRITKINFO%>);
          inputToOutput(<%=NEWKYKDRNMKJKHUKA_KYKSYADAIRITKINFO%>);
          $(<%= NEWKYKDRNMKJKHUKAKBN_KYKSYADAIRITKINFO %>).visible(true);
          inputToOutput("#newkykdrseiymdSpan > *");
          inputToOutput(<%=NEWKYKDRYNO_KYKSYADAIRITKINFO%>);
          inputToOutput(<%=NEWKYKDRADR1KJ_KYKSYADAIRITKINFO%>);
          inputToOutput(<%=NEWKYKDRADR2KJ_KYKSYADAIRITKINFO%>);
          inputToOutput(<%=NEWKYKDRADR3KJ_KYKSYADAIRITKINFO%>);
          $(<%= NEWTRKKZKTDK1_TRKKZKINFO1_OUTPUTSPAN %>).removeClass('trkkzktdkFirstCell');
          $(<%= NEWTRKKZKTDK2_TRKKZKINFO2_OUTPUTSPAN %>).removeClass('trkkzktdkFirstCell');
   <%
   } else { %>
     $(<%= NEWTRKKZKNMKJKHUKAKBN1_TRKKZKINFO1 %>).visible(false);
     $(<%= NEWTRKKZKNMKJKHUKAKBN2_TRKKZKINFO2 %>).visible(false);
     $(<%= NEWKYKDRNMKJKHUKAKBN_KYKSYADAIRITKINFO %>).visible(false);
     $(<%=NEWTRKKZKTDK1_TRKKZKINFO1%>).removeClass('trkkzktdkFirstCell');
     $(<%=NEWTRKKZKTDK2_TRKKZKINFO2%>).removeClass('trkkzktdkFirstCell');

     $(<%=NEWTRKKZKADR1KJ1_TRKKZKINFO1%>).removeClass('text11').addClass('newText11');
     $(<%=NEWTRKKZKADR2KJ1_TRKKZKINFO1%>).removeClass('text11').addClass('newText11');
     $(<%=NEWTRKKZKADR3KJ1_TRKKZKINFO1%>).removeClass('text11').addClass('newText11');

     $(<%=NEWTRKKZKADR1KJ2_TRKKZKINFO2%>).removeClass('text11').addClass('newText11');
     $(<%=NEWTRKKZKADR2KJ2_TRKKZKINFO2%>).removeClass('text11').addClass('newText11');
     $(<%=NEWTRKKZKADR3KJ2_TRKKZKINFO2%>).removeClass('text11').addClass('newText11');

     $(<%=NEWKYKDRADR1KJ_KYKSYADAIRITKINFO%>).removeClass('text11').addClass('newText11');
     $(<%=NEWKYKDRADR2KJ_KYKSYADAIRITKINFO%>).removeClass('text11').addClass('newText11');
     $(<%=NEWKYKDRADR3KJ_KYKSYADAIRITKINFO%>).removeClass('text11').addClass('newText11');

   <% } %>

   <%
      if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) { %>
          <%
            if (C_MousideninKbn.HHKNHONNIN.eq(uiBean.getMousideninkbn())
                || C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn())
                || C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {%>
              showGroup(<%=SHSNMINFO %>);
              showGroup(<%=SHSKADRINFO %>);
          <% } %>
          <%
            if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {%>
                $(<%=SKSSAKUSEIBTN_REFERENCEBUTTONS%>).visible(true);
          <%
          } else { %>
                $(<%=SKSSAKUSEIBTN_REFERENCEBUTTONS%>).visible(false);
          <% } %>
   <%
   } else { %>
      $(<%=SKSSAKUSEIBTN_REFERENCEBUTTONS%>).visible(false);
   <% } %>

   <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
           C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn()))) { %>
           showGroup(<%=HONNINKAKUNININFO %>);
           showGroup(<%=TYHYSAKUSEIYHKBNINFO %>);
           showGroup(<%=HASSOUKBNGROUP %>);
    <%
    } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
      <%
      if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) && C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) { %>
           showGroup(<%=HONNINKAKUNININFO %>);
           inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNINKAKUNININFO%>);
           showGroup(<%=TYHYSAKUSEIYHKBNINFO %>);
           inputToOutput(<%=TYHYSAKUSEIYHKBN_TYHYSAKUSEIYHKBNINFO%>);
           showGroup(<%=HASSOUKBNGROUP %>);
           inputToOutput(<%=HASSOUKBN_HASSOUKBNGROUP%>);
           $('#IIC0017').visible(false);
      <% } %>
   <% } %>

   <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
           && C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
           showGroup(<%=KEKKAINPUTGROUP %>);
           <%
              if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {%>
              showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
           <% } %>
   <% } %>

   <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
          (C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())
              && C_TeiseiKbn.TEISEI.eq(uiBean.getTeiseikbn()))) { %>
        showGroup(<%=FOOTERBUTTONS2%>);
   <% } %>

     $(<%=DUMMYKMK1_DUMMYINFO + LABEL%>).parent().attr("rowspan","2");
     $(<%=DUMMYKMK2_DUMMYINFO%>).parent().parent().append(
       '<td class="c1_KzktrkKykDrHnk"><span>漢字欄最後に<font color=\"#FF0000\">※</font>ありは、漢字化不可</span></td>');
      $(<%=DUMMYKMK2_DUMMYINFO%>).parent().parent().append(
                '<td class="c1_KzktrkKykDrHnk"><span>漢字化不可の場合は漢字欄後ろに<input type=\"checkbox\" checked> を入力する</span></td>');
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT ||
      uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
      $(<%=DUMMYKMK1_DUMMYINFO + LABEL%>).parent().attr("rowspan","2");
      $(<%=DUMMYKMK2_DUMMYINFO%>).parent().parent().append(
       '<td class="c1_KzktrkKykDrHnk"><span>漢字欄最後に<font color=\"#FF0000\">※</font>ありは、漢字化不可</span></td>');
      $(<%=DUMMYKMK2_DUMMYINFO%>).parent().parent().append(
        '<td class="c1_KzktrkKykDrHnk"><span>漢字欄最後に<font color=\"#FF0000\">※</font>ありは、漢字化不可</span></td>');
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
       <%
          if (C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn1())) { %>
            $(<%= TRKKZKTTDKKBN1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzknmkn1())) { %>
            $(<%= NEWTRKKZKNMKN1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzknmkj1())) { %>
            $(<%= NEWTRKKZKNMKJ1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (uiBean.getNewtrkkzkseiymd1() == null) { %>
            $(<%= NEWTRKKZKSEIYMD1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (C_Seibetu.BLNK.eq(uiBean.getNewtrkkzksei1())) { %>
            $(<%= NEWTRKKZKSEI1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzkyno1())) { %>
            $(<%= NEWTRKKZKYNO1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj1()) &&
              BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj1()) &&
              BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj1())) { %>
            $(<%= NEWTRKKZKADR1KJ1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzktelno1())) { %>
            $(<%= NEWTRKKZKTELNO1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (C_Tdk.BLNK.eq(uiBean.getNewtrkkzktdk1())) { %>
            $(<%= NEWTRKKZKTDK1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) { %>
            $(<%= NEWTRKKZKTSINDOUSITEIKBN1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
       <% } %>

       <%
          if (C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn2())) { %>
            $(<%= TRKKZKTTDKKBN2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzknmkn2())) { %>
            $(<%= NEWTRKKZKNMKN2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzknmkj2())) { %>
            $(<%= NEWTRKKZKNMKJ2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (uiBean.getNewtrkkzkseiymd2() == null) { %>
            $(<%= NEWTRKKZKSEIYMD2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (C_Seibetu.BLNK.eq(uiBean.getNewtrkkzksei2())) { %>
            $(<%= NEWTRKKZKSEI2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzkyno2())) { %>
            $(<%= NEWTRKKZKYNO2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj2()) &&
              BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj2()) &&
              BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj2())) { %>
            $(<%= NEWTRKKZKADR1KJ2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewtrkkzktelno2())) { %>
            $(<%= NEWTRKKZKTELNO2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (C_Tdk.BLNK.eq(uiBean.getNewtrkkzktdk2())) { %>
            $(<%= NEWTRKKZKTDK2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) { %>
            $(<%= NEWTRKKZKTSINDOUSITEIKBN2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
       <% } %>

       <%
          if (C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn())) { %>
            $(<%= KYKDRTKYKTTDKKBN_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (C_UktKbn.BLNK.eq(uiBean.getNewkykdrkbn())) { %>
            $(<%= NEWKYKDRKBN_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewkykdrnmkn())) { %>
            $(<%= NEWKYKDRNMKN_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewkykdrnmkj())) { %>
            $(<%= NEWKYKDRNMKJ_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (uiBean.getNewkykdrseiymd() == null) { %>
            $(<%= NEWKYKDRSEIYMD_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewkykdryno())) { %>
            $(<%= NEWKYKDRYNO_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
       <% } %>
       <%
          if (BizUtil.isBlank(uiBean.getNewkykdradr1kj()) &&
              BizUtil.isBlank(uiBean.getNewkykdradr2kj()) &&
              BizUtil.isBlank(uiBean.getNewkykdradr3kj())) { %>
            $(<%= NEWKYKDRADR1KJ_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
       <% } %>

       <%
          if (!C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) { %>
            <%
             if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) { %>
                <%
                 if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
                     !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                     showGroup(<%=HONNINKAKUNININFO %>);
                     showGroup(<%=TYHYSAKUSEIYHKBNINFO %>);
                     showGroup(<%=HASSOUKBNGROUP %>);
                <% } %>
            <% } %>
       <% } %>

       <%
          if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
              C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
              (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
              C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) ||
              C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
                 showGroup(<%=KEKKAINPUTGROUP %>);
                 <%
                 if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
                     showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
                 <% } %>
          <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
      $(<%= TRKKZKTTDKKBN1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKNMKN1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKNMKJ1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKSEIYMD1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKSEI1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKYNO1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKADR1KJ1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKTELNO1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKTDK1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKTSINDOUSITEIKBN1_TRKKZKINFO1 %>).text('<%= ASTERISK %>');

      $(<%= TRKKZKTTDKKBN2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKNMKN2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKNMKJ2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKSEIYMD2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKSEI2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKYNO2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKADR1KJ2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKTELNO2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKTDK2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');
      $(<%= NEWTRKKZKTSINDOUSITEIKBN2_TRKKZKINFO2 %>).text('<%= ASTERISK %>');

      $(<%= KYKDRTKYKTTDKKBN_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
      $(<%= NEWKYKDRKBN_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
      $(<%= NEWKYKDRNMKN_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
      $(<%= NEWKYKDRNMKJ_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
      $(<%= NEWKYKDRSEIYMD_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
      $(<%= NEWKYKDRYNO_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');
      $(<%= NEWKYKDRADR1KJ_KYKSYADAIRITKINFO %>).text('<%= ASTERISK %>');

     <%
       if (C_MousideninKbn.HHKNHONNIN.eq(uiBean.getMousideninkbn()) ||
           C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn()) ||
           C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) { %>
         showGroup(<%=SHSNMINFO %>);
         showGroup(<%=SHSKADRINFO %>);
     <% } %>
<% }%>

<%
  if (uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    <%
    if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
        openReport("print", "_blank");
    <% } %>
  <% } %>

});
//-->
</script>
