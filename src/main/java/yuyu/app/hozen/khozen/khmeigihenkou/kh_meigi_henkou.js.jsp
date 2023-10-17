<%--
    kh_meigi_henkou.js.jsp - 名義変更／契約者等生年月日訂正 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khmeigihenkou.KhMeigiHenkouConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khmeigihenkou.KhMeigiHenkouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khmeigihenkou.KhMeigiHenkouUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.def.classification.C_KidougmKbn" %>
<%@page import="yuyu.def.classification.C_Meigihnkjiyuu" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_SyorikahiKbn"%>
<%@page import="yuyu.def.classification.C_HjndaiykKbn" %>
<%@page import="yuyu.def.classification.C_Kyksei" %>
<%@page import="yuyu.def.classification.C_Tdk" %>
<%@page import="yuyu.def.classification.C_HjndaiykKbn" %>
<%@page import="yuyu.def.classification.C_UktsiteiKbn" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="jp.co.slcs.swak.number.BizNumber" %>
<%@page import="yuyu.def.classification.C_UktkaijyoKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.def.classification.C_UktKbn" %>
<%@page import="yuyu.def.classification.C_AeoiKekkaKbn" %>

<% KhMeigiHenkouUiBean uiBean = SWAKInjector.getInstance(KhMeigiHenkouUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE ) { %>
   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
       || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
     <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
   <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT    || uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
       uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp" />
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp" />
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp" />
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp" />
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp" />
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp" />
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp" />

      <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
          || !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
            <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp" />
      <% } %>

 <% } %>

<% if ((uiBean.getPageNo() == PAGENO_REFERENCE  || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) &&
        (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
            || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode()))) { %>
     <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp" />
     <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp" />
<% } %>
<script type="text/javascript"><!--
$(function(){

  <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
     || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
     || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

     showGroup(<%=KOUTEIINFO%>);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
    $(<%= HENKOUJIYUUINFO + DIV%>).css("margin-top", "-1px");
  <% }%>

  <% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT    || uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
       uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

      <% if(!C_AeoiKekkaKbn.BLNK.eq(uiBean.getDispaeoikekkakbn1())) { %>
          showGroup(<%= AEOITAISYOUSYAINFO1 %>);
          <% if(!C_AeoiKekkaKbn.BLNK.eq(uiBean.getDispaeoikekkakbn2())) { %>
              showGroup(<%= AEOITAISYOUSYAINFO2 %>);
          <% } %>
          <% if(!C_AeoiKekkaKbn.BLNK.eq(uiBean.getDispaeoikekkakbn3())) { %>
              showGroup(<%= AEOITAISYOUSYAINFO3 %>);
          <% } %>
          <% if(!C_AeoiKekkaKbn.BLNK.eq(uiBean.getDispaeoikekkakbn4())) { %>
              showGroup(<%= AEOITAISYOUSYAINFO4 %>);
          <% } %>
          <% if(!C_AeoiKekkaKbn.BLNK.eq(uiBean.getDispaeoikekkakbn5())) { %>
              showGroup(<%= AEOITAISYOUSYAINFO5 %>);
          <% } %>
      <% } %>

      <% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
            $(<%=DUMMYKMK1_HENKOUJIYUUINFO2 + LABEL%>).parent().attr("rowspan","2");
            $(<%=DUMMYKMK2_HENKOUJIYUUINFO2%>).parent().parent().append(
                '<td class="c1_mh"><span>漢字欄最後に<font color=\"#FF0000\">※</font>ありは、漢字化不可</span></td>');
            $(<%=DUMMYKMK2_HENKOUJIYUUINFO2%>).parent().parent().append(
                '<td class="c1_mh"><span>漢字化不可の場合は漢字欄後ろに<input type=\"checkbox\" checked> を入力する</span></td>');
      <% } else if (uiBean.getPageNo() == PAGENO_CONFIRM
                    || uiBean.getPageNo() == PAGENO_RESULT
                    || uiBean.getPageNo() == PAGENO_SKSCONFIRM
                    || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
            $(<%=DUMMYKMK1_HENKOUJIYUUINFO2 + LABEL%>).parent().attr("rowspan","2");
            $(<%=DUMMYKMK2_HENKOUJIYUUINFO2%>).parent().parent().append(
                '<td class="c1_mh"><span>漢字欄最後に<font color=\"#FF0000\">※</font>ありは、漢字化不可</span></td>');
            $(<%=DUMMYKMK2_HENKOUJIYUUINFO2%>).parent().parent().append(
                '<td class="c1_mh"><span>漢字欄最後に<font color=\"#FF0000\">※</font>ありは、漢字化不可</span></td>');

      <% } %>

  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>

    <% if (C_UmuKbn.ARI.equals(uiBean.getVshktsbhkuktumu())
        || C_UmuKbn.ARI.equals(uiBean.getVshktsbkyuuhukinuktumu())) { %>

      showGroup(<%= SBHKKUKTTYOUINFO1 %>);
      showGroup(<%= SBHKKUKTTYOUINFO2 %>);
      showGroup(<%= SBHKKUKTTYOUINFO3 %>);
      showGroup(<%= SBHKKUKTTYOUINFO4 %>);
      showGroup(<%= SBHKKUKTTYOUINFO5 %>);

      <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

        <% if(C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1())) { %>
            showGroup(<%= SBHKUKTINFO11 %>);
        <% } %>

        <% if(C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2())) { %>
            showGroup(<%= SBHKUKTINFO21 %>);
        <% } %>

        <% if(C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3())) { %>
            showGroup(<%= SBHKUKTINFO31 %>);
        <% } %>

        <% if(C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4())) { %>
            showGroup(<%= SBHKUKTINFO41 %>);
        <% } %>
      <% } else { %>

        <% if (!C_UktKbn.BLNK.eq(uiBean.getVshktdispsbuktkbn1())) { %>
            showGroup(<%= SBHKUKTINFO11 %>);
        <% } %>

        <% if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn2())) { %>
            showGroup(<%= SBHKUKTINFO21 %>);
        <% } %>

        <% if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn3())) { %>
            showGroup(<%= SBHKUKTINFO31 %>);
        <% } %>

        <% if(!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn4())){ %>
            showGroup(<%= SBHKUKTINFO41 %>);
        <% } %>
      <% } %>
      <% if (C_UmuKbn.ARI.equals(uiBean.getVshktsbkyuuhukinuktumu())) { %>

         $(<%=SBHKKUKTTYOUINFO1 + LABEL %>).text('●死亡給付金受取人');
      <% } %>

      <% if(!BizUtil.isBlank(uiBean.getSbhenkanuktnmkn())){ %>
          showGroup(<%= SBHENKANUKTINFO %>);
      <% } %>
    <% } %>
    <% if (!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(uiBean.getKinouMode().getKinouMode())
        && !C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
        $(<%=SKSSAKUSEIBTN_REFERENCEBUTTONS%>).visible(false);
    <% } %>

    <% if ((C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) &&
        C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())){ %>
         showGroup(<%= SHSNMINFO %>);
         showGroup(<%= SHSKADRINFO %>);
    <% } %>

    <% if(C_UmuKbn.ARI.eq(uiBean.getHjnkykumukbn())){ %>
        showGroup(<%= HOUJINDAIHYOUSYAINFO %>);

        $(<%=NEWHJNDAIYKNM_HOUJINDAIHYOUSYAINFO %>).addClass('hojnText');

        <% if (C_HjndaiykKbn.SONOTA.eq(uiBean.getVkykshjndaiykkbn()) && !BizUtil.isBlank(uiBean.getVkykshjndaiyknm())) { %>

            $(<%=VKYKSHJNDAIYKKBN_HOUJINDAIHYOUSYAINFO %>)
            .text($(<%=VKYKSHJNDAIYKKBN_HOUJINDAIHYOUSYAINFO %>).text()
            + '<%=MessageUtil.getMessage(MessageId.IAW0004) %>'
            + $(<%=VKYKSHJNDAIYKNM_HOUJINDAIHYOUSYAINFO %>).text()
             + '<%=MessageUtil.getMessage(MessageId.IAW0005) %>');
       <% } %>
    <% } %>
    <% if(C_UmuKbn.ARI.eq(uiBean.getNkhknumu())){ %>
       showGroup(<%= NKUKTINFO %>);
    <% } %>

    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

       <% if (!BizUtil.isBlank(uiBean.getKeizknkuktnmkn())) { %>
           showGroup(<%= KZUKTKAIJYOINFO1 %>);
           showGroup(<%= KZUKTKAIJYOINFO2 %>);
           showKoumoku(<%= KZUKTKAIJYOKBN_KZUKTKAIJYOINFO1 %>);
       <% } %>
    <% } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
        <% if (!BizUtil.isBlank(uiBean.getKeizknkuktnmkn())) { %>
            showGroup(<%= KZUKTKAIJYOINFO1 %>);
            showGroup(<%= KZUKTKAIJYOINFO2 %>);

            <% if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getKzuktkaijyokbn())) { %>
                showKoumoku(<%= KZUKTKAIJYOKBN_KZUKTKAIJYOINFO1 %>);
            <% } else { %>
                $(<%= KZUKTKAIJYOINFO2 + DIV %>).css("margin-top", "0px");
            <% } %>
        <% } %>
    <% } %>

    <% if(C_UmuKbn.ARI.eq(uiBean.getStdrsktkyhkumu())) { %>
      showGroup(<%= STDRSKKAIJYOINFO1 %>);
      showGroup(<%= STDRSKKAIJYOINFO2 %>);

      <% if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
          || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
          || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode()))
          && C_UktKbn.NASI.eq(uiBean.getVstsksiteidruktkbn())) { %>

         $(<%= STDRSKKAIJYOINFO2 + DIV %>).css("margin-top", "0px");
      <% } else if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
          && !C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) { %>

         $(<%= STDRSKKAIJYOINFO2 + DIV %>).css("margin-top", "0px");
      <% } else { %>
         showKoumoku(<%= STDRSKKAIJYOKBN_STDRSKKAIJYOINFO1 %>);
      <% } %>
    <% } %>
    <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
       inputToOutput(<%= NEWKYKNMKN_KEIYAKUSYAINFO %>);
       inputToOutput(<%= NEWKYKNMKJ_KEIYAKUSYAINFO %>);
       $(<%= NEWKYKNMKJKHUKA_KEIYAKUSYAINFO %>).visible(false);
       $(<%= NEWKYKNMKJKHUKA_KEIYAKUSYAINFO %>).disable(true);
       $(<%= NEWKYKNMKJKHUKAKBN_KEIYAKUSYAINFO %>).visible(true);

       inputToOutput('#newkykseiymdSpan > *');
       inputToOutput(<%= NEWKYKSEI_KEIYAKUSYAINFO %>);
       inputToOutput(<%= NEWKKKYKTDK_KEIYAKUSYAINFO %>);

       inputToOutput(<%= NEWHJNDAIYKKBN_HOUJINDAIHYOUSYAINFO %>);
       inputToOutput(<%= NEWHJNDAIYKNM_HOUJINDAIHYOUSYAINFO %>);
       inputToOutput(<%= NEWHJNDAINMKN_HOUJINDAIHYOUSYAINFO %>);
       inputToOutput(<%= NEWHJNDAINMKJ_HOUJINDAIHYOUSYAINFO %>);

       inputToOutput(<%= NEWHHKNNMKN_HHKNINFO1 %>);
       inputToOutput(<%= NEWHHKNNMKJ_HHKNINFO1 %>);
       $(<%= NEWHHKNNMKJKHUKA_HHKNINFO1 %>).visible(false);
       $(<%= NEWHHKNNMKJKHUKA_HHKNINFO1 %>).disable(true);
       $(<%= NEWHHKNNMKJKHUKAKBN_HHKNINFO1 %>).visible(true);

       inputToOutput(<%= NEWNENKINUKTKBN_NKUKTINFO %>);

       inputToOutput(<%= KZUKTKAIJYOKBN_KZUKTKAIJYOINFO1 %>);
       inputToOutput(<%= NEWKZUKTNMKN_KZUKTKAIJYOINFO2 %>);
       inputToOutput(<%= NEWKZUKTNMKJ_KZUKTKAIJYOINFO2 %>);
       inputToOutput('#newkzuktseiymdSpan > *');
       inputToOutput(<%= NEWKZUKTTDK_KZUKTKAIJYOINFO2 %>);

       inputToOutput(<%= NEWSBHENKANUKTNMKN_SBHENKANUKTINFO %>);
       inputToOutput(<%= NEWSBHENKANUKTNMKJ_SBHENKANUKTINFO %>);
       inputToOutput('#newsbhenkanuktseiymdSpan > *');
       inputToOutput(<%= NEWSBHENKANUKTTDK_SBHENKANUKTINFO %>);

       inputToOutput(<%= SBUKTNIN_SBHKKUKTTYOUINFO1 %>);
       <% if (null == uiBean.getSbuktnin()) { %>
         $(<%=SBUKTNIN_SBHKKUKTTYOUINFO1 + " + 'Unit'"%>).text('');
       <% } %>
       inputToOutput(<%= SBUKTKAIJYOKBN1_SBHKUKTINFO11 %>);
       inputToOutput(<%= SBUKTKBN1_SBHKKUKTTYOUINFO2 %>);
       inputToOutput(<%= SBUKTNMKN1_SBHKKUKTTYOUINFO2 %>);
       inputToOutput(<%= SBUKTNMKJ1_SBHKKUKTTYOUINFO2 %>);
       $(<%= SBUKTNMKJKHUKA1_SBHKKUKTTYOUINFO2 %>).visible(false);
       $(<%= SBUKTNMKJKHUKA1_SBHKKUKTTYOUINFO2 %>).disable(true);
       $(<%= SBUKTNMKJHUKAKBN1_SBHKKUKTTYOUINFO2 %>).visible(true);
       inputToOutput('#sbuktseiymd1Span > *');
       inputToOutput(<%= NEWSBUKTBNWARI1_SBHKKUKTTYOUINFO2 %>);
       <% if (uiBean.getNewsbuktbnwari1().isOptional()) { %>
         $(<%=NEWSBUKTBNWARI1_SBHKKUKTTYOUINFO2 + " + 'Unit'"%>).text('');
       <% } %>


       inputToOutput(<%= SBUKTKAIJYOKBN2_SBHKUKTINFO21 %>);
       inputToOutput(<%= SBUKTNMKN2_SBHKKUKTTYOUINFO3 %>);
       inputToOutput(<%= SBUKTNMKJ2_SBHKKUKTTYOUINFO3 %>);
       $(<%= SBUKTNMKJKHUKA2_SBHKKUKTTYOUINFO3 %>).visible(false);
       $(<%= SBUKTNMKJKHUKA2_SBHKKUKTTYOUINFO3 %>).disable(true);
       $(<%= SBUKTNMKJHUKAKBN2_SBHKKUKTTYOUINFO3 %>).visible(true);
       inputToOutput('#sbuktseiymd2Span > *');
       inputToOutput(<%= NEWSBUKTBNWARI2_SBHKKUKTTYOUINFO3 %>);
       <% if (uiBean.getNewsbuktbnwari2().isOptional()) { %>
         $(<%=NEWSBUKTBNWARI2_SBHKKUKTTYOUINFO3 + " + 'Unit'"%>).text('');
       <% } %>

       inputToOutput(<%= SBUKTKAIJYOKBN3_SBHKUKTINFO31 %>);
       inputToOutput(<%= SBUKTNMKN3_SBHKKUKTTYOUINFO4 %>);
       inputToOutput(<%= SBUKTNMKJ3_SBHKKUKTTYOUINFO4 %>);
       $(<%= SBUKTNMKJKHUKA3_SBHKKUKTTYOUINFO4 %>).visible(false);
       $(<%= SBUKTNMKJKHUKA3_SBHKKUKTTYOUINFO4 %>).disable(true);
       $(<%= SBUKTNMKJHUKAKBN3_SBHKKUKTTYOUINFO4 %>).visible(true);
       inputToOutput('#sbuktseiymd3Span > *');
       inputToOutput(<%= NEWSBUKTBNWARI3_SBHKKUKTTYOUINFO4 %>);
       <% if (uiBean.getNewsbuktbnwari3().isOptional()) { %>
         $(<%=NEWSBUKTBNWARI3_SBHKKUKTTYOUINFO4 + " + 'Unit'"%>).text('');
       <% } %>


       inputToOutput(<%= SBUKTKAIJYOKBN4_SBHKUKTINFO41 %>);
       inputToOutput(<%= SBUKTNMKN4_SBHKKUKTTYOUINFO5 %>);
       inputToOutput(<%= SBUKTNMKJ4_SBHKKUKTTYOUINFO5 %>);
       $(<%= SBUKTNMKJKHUKA4_SBHKKUKTTYOUINFO5 %>).visible(false);
       $(<%= SBUKTNMKJKHUKA4_SBHKKUKTTYOUINFO5 %>).disable(true);
       $(<%= SBUKTNMKJHUKAKBN4_SBHKKUKTTYOUINFO5 %>).visible(true);
       inputToOutput('#sbuktseiymd4Span > *');
       inputToOutput(<%= NEWSBUKTBNWARI4_SBHKKUKTTYOUINFO5 %>);
       <% if (uiBean.getNewsbuktbnwari4().isOptional()) { %>
         $(<%=NEWSBUKTBNWARI4_SBHKKUKTTYOUINFO5 + " + 'Unit'"%>).text('');
       <% } %>

       inputToOutput(<%= STDRSKKAIJYOKBN_STDRSKKAIJYOINFO1 %>);
       inputToOutput(<%= NEWSTDRUKTKBN_STDRSKKAIJYOINFO2 %>);
       inputToOutput(<%= NEWSTDRSKNMKN_STDRSKKAIJYOINFO2 %>);
       inputToOutput(<%= NEWSTDRSKNMKJ_STDRSKKAIJYOINFO2 %>);
       $(<%= NEWSTDRSKNMKJHUKA_STDRSKKAIJYOINFO2 %>).visible(false);
       $(<%= NEWSTDRSKNMKJHUKA_STDRSKKAIJYOINFO2 %>).disable(true);
       $(<%= NEWSTDRSKNMKJHUKAKBN_STDRSKKAIJYOINFO2 %>).visible(true);
       inputToOutput('#newstdrskseiymdSpan > *');

       showKoumoku(<%= SASIMODOSISAKIKBN_KEKKAINPUTGROUP %>);

       $('#IIC0006').css("margin", "0px");
       $('#IIC1004').css("margin", "0px");
       $("span[name='IIC0015']").css("margin", "0px");
    <% } else { %>
      $(<%=SBUKTKAIJYOKBN1_SBHKUKTINFO11%>).parent().addClass('floatKaijyo');
      $(<%=SBUKTKAIJYOKBN2_SBHKUKTINFO21%>).parent().addClass('floatKaijyo');
      $(<%=SBUKTKAIJYOKBN3_SBHKUKTINFO31%>).parent().addClass('floatKaijyo');
      $(<%=SBUKTKAIJYOKBN4_SBHKUKTINFO41%>).parent().addClass('floatKaijyo');
      $(<%=KZUKTKAIJYOKBN_KZUKTKAIJYOINFO1%>).parent().addClass('floatKaijyo');
      $(<%=STDRSKKAIJYOKBN_STDRSKKAIJYOINFO1%>).parent().addClass('floatKaijyo');
      $(<%= NEWKYKNMKJKHUKAKBN_KEIYAKUSYAINFO %>).visible(false);
      $(<%= NEWHHKNNMKJKHUKAKBN_HHKNINFO1 %>).visible(false);
      $(<%= SBUKTNMKJHUKAKBN1_SBHKKUKTTYOUINFO2 %>).visible(false);
      $(<%= SBUKTNMKJHUKAKBN2_SBHKKUKTTYOUINFO3 %>).visible(false);
      $(<%= SBUKTNMKJHUKAKBN3_SBHKKUKTTYOUINFO4 %>).visible(false);
      $(<%= SBUKTNMKJHUKAKBN4_SBHKKUKTTYOUINFO5 %>).visible(false);
      $(<%= NEWSTDRSKNMKJHUKAKBN_STDRSKKAIJYOINFO2 %>).visible(false);
    <% } %>
  <% } else { %>
    $('#IIC0006').css("margin", "0px");
    $('#IIC1004').css("margin", "0px");
    $("span[name='IIC0015']").css("margin", "0px");
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM
      || uiBean.getPageNo() == PAGENO_RESULT
      || uiBean.getPageNo() == PAGENO_SKSCONFIRM
      || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

      <% if (BizUtil.isBlank(uiBean.getNewkyknmkn())) { %>
           $(<%= NEWKYKNMKN_KEIYAKUSYAINFO %>).text('<%= ASTERISK %>');
      <% } %>

      <% if (BizUtil.isBlank(uiBean.getNewkyknmkj())) { %>
           $(<%= NEWKYKNMKJ_KEIYAKUSYAINFO %>).text('<%= ASTERISK %>');
      <% } %>

      <% if (uiBean.getNewkykseiymd() == null) { %>
           $(<%= NEWKYKSEIYMD_KEIYAKUSYAINFO %>).text('<%= ASTERISK %>');
      <% } %>

      <% if (C_Kyksei.BLNK.eq(uiBean.getNewkyksei())) { %>
           $(<%= NEWKYKSEI_KEIYAKUSYAINFO %>).text('<%= ASTERISK %>');
      <% } %>

      <% if (C_Tdk.BLNK.eq(uiBean.getNewkkkyktdk())) { %>
           $(<%= NEWKKKYKTDK_KEIYAKUSYAINFO %>).text('<%= ASTERISK %>');
      <% } %>

      <% if(C_UmuKbn.ARI.eq(uiBean.getHjnkykumukbn())) { %>
          showGroup(<%= HOUJINDAIHYOUSYAINFO %>);
          <% if (C_HjndaiykKbn.SONOTA.eq(uiBean.getVkykshjndaiykkbn()) && !BizUtil.isBlank(uiBean.getVkykshjndaiyknm())) { %>
              $(<%=VKYKSHJNDAIYKKBN_HOUJINDAIHYOUSYAINFO %>).text($(<%=VKYKSHJNDAIYKKBN_HOUJINDAIHYOUSYAINFO %>).text() + '<%=MessageUtil.getMessage(MessageId.IAW0004) %>' + $(<%=VKYKSHJNDAIYKNM_HOUJINDAIHYOUSYAINFO %>).text() + '<%=MessageUtil.getMessage(MessageId.IAW0005) %>');
         <%} %>

         <% if (C_HjndaiykKbn.SONOTA.eq(uiBean.getNewhjndaiykkbn()) && !BizUtil.isBlank(uiBean.getNewhjndaiyknm())) { %>
             $(<%=NEWHJNDAIYKNM_HOUJINDAIHYOUSYAINFO %>).prev().visible(true);
             $(<%=NEWHJNDAIYKNM_HOUJINDAIHYOUSYAINFO %>).next().visible(true);
         <%}%>

         <% if (C_HjndaiykKbn.BLNK.eq(uiBean.getNewhjndaiykkbn()) && BizUtil.isBlank(uiBean.getNewhjndaiyknm())) { %>
              $(<%= NEWHJNDAIYKKBN_HOUJINDAIHYOUSYAINFO %>).text('<%= ASTERISK %>');
         <% } %>

         <% if (BizUtil.isBlank(uiBean.getNewhjndainmkn())) { %>
              $(<%= NEWHJNDAINMKN_HOUJINDAIHYOUSYAINFO %>).text('<%= ASTERISK %>');
         <% } %>

         <% if (BizUtil.isBlank(uiBean.getNewhjndainmkj())) { %>
              $(<%= NEWHJNDAINMKJ_HOUJINDAIHYOUSYAINFO %>).text('<%= ASTERISK %>');
         <% } %>

      <% } %>

      <% if (BizUtil.isBlank(uiBean.getNewhhknnmkn())) { %>
           $(<%= NEWHHKNNMKN_HHKNINFO1 %>).text('<%= ASTERISK %>');
      <% } %>

      <% if (BizUtil.isBlank(uiBean.getNewhhknnmkj())) { %>
           $(<%= NEWHHKNNMKJ_HHKNINFO1 %>).text('<%= ASTERISK %>');
      <% } %>

      <% if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) { %>
          showGroup(<%= NKUKTINFO %>);

          <% if (C_UktKbn.BLNK.eq(uiBean.getNewnenkinuktkbn())) { %>
              $(<%= NEWNENKINUKTKBN_NKUKTINFO %>).text('<%= ASTERISK %>');
          <% } %>

      <% } %>

      <% if (!BizUtil.isBlank(uiBean.getKeizknkuktnmkn())) { %>

        showGroup(<%= KZUKTKAIJYOINFO1 %>);
        showGroup(<%= KZUKTKAIJYOINFO2 %>);

        <% if(C_UktkaijyoKbn.KAIJYO.eq(uiBean.getKzuktkaijyokbn())){ %>
            showKoumoku(<%= KZUKTKAIJYOKBN_KZUKTKAIJYOINFO1 %>);
            $(<%= NEWKZUKTNMKN_KZUKTKAIJYOINFO2 %>).text('');
            $(<%= NEWKZUKTNMKJ_KZUKTKAIJYOINFO2 %>).text('');
            $(<%= NEWKZUKTSEIYMD_KZUKTKAIJYOINFO2 %>).text('');
            $(<%= NEWKZUKTTDK_KZUKTKAIJYOINFO2 %>).text('');
        <% }
       else {%>
          $(<%= KZUKTKAIJYOINFO2 + DIV %>).css('margin-top', '0');

          <% if (BizUtil.isBlank(uiBean.getNewkzuktnmkn())) { %>
               $(<%= NEWKZUKTNMKN_KZUKTKAIJYOINFO2 %>).text('<%= ASTERISK %>');
          <% } %>

          <% if (BizUtil.isBlank(uiBean.getNewkzuktnmkj())) { %>
               $(<%= NEWKZUKTNMKJ_KZUKTKAIJYOINFO2 %>).text('<%= ASTERISK %>');
          <% } %>

          <% if (uiBean.getNewkzuktseiymd() == null) { %>
               $(<%= NEWKZUKTSEIYMD_KZUKTKAIJYOINFO2 %>).text('<%= ASTERISK %>');
          <% } %>

          <% if (C_Tdk.BLNK.eq(uiBean.getNewkzukttdk())) { %>
               $(<%= NEWKZUKTTDK_KZUKTKAIJYOINFO2 %>).text('<%= ASTERISK %>');
          <% } %>
       <% } %>
     <% } %>

     <% if(!BizUtil.isBlank(uiBean.getSbhenkanuktnmkn())){ %>
         showGroup(<%= SBHENKANUKTINFO %>);

        <% if (BizUtil.isBlank(uiBean.getNewsbhenkanuktnmkn())) { %>
             $(<%= NEWSBHENKANUKTNMKN_SBHENKANUKTINFO %>).text('<%= ASTERISK %>');
        <% } %>

        <% if (BizUtil.isBlank(uiBean.getNewsbhenkanuktnmkj())) { %>
             $(<%= NEWSBHENKANUKTNMKJ_SBHENKANUKTINFO %>).text('<%= ASTERISK %>');
        <% } %>

        <% if (uiBean.getNewsbhenkanuktseiymd() == null) { %>
             $(<%= NEWSBHENKANUKTSEIYMD_SBHENKANUKTINFO %>).text('<%= ASTERISK %>');
        <% } %>

        <% if (C_Tdk.BLNK.eq(uiBean.getNewsbhenkanukttdk())) { %>
             $(<%= NEWSBHENKANUKTTDK_SBHENKANUKTINFO %>).text('<%= ASTERISK %>');
        <% } %>

     <% } %>

     <% if (C_UmuKbn.ARI.eq(uiBean.getVshktsbhkuktumu())
         || C_UmuKbn.ARI.eq(uiBean.getVshktsbkyuuhukinuktumu())) { %>

       showGroup(<%= SBHKKUKTTYOUINFO1 %>);

       <% if (C_UmuKbn.ARI.eq(uiBean.getVshktsbkyuuhukinuktumu())) { %>

          $(<%=SBHKKUKTTYOUINFO1 + LABEL %>).text('●死亡給付金受取人');
       <% } %>


       <% if(!C_UktKbn.BLNK.eq(uiBean.getSbuktkbn1()) || !C_UktKbn.BLNK.eq(uiBean.getVshktdispsbuktkbn1())) { %>
          showGroup(<%= SBHKKUKTTYOUINFO2 %>);
          <% if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1())) { %>
            showGroup(<%= SBHKUKTINFO11 %>);
            $(<%=SBUKTKBN1_SBHKKUKTTYOUINFO2%>).text('');
            $(<%=SBUKTNMKN1_SBHKKUKTTYOUINFO2%>).text('');
            $(<%=SBUKTNMKJ1_SBHKKUKTTYOUINFO2%>).text('');
            $(<%=SBUKTNMKJHUKAKBN1_SBHKKUKTTYOUINFO2%>).text('');
            $(<%=SBUKTSEIYMD1_SBHKKUKTTYOUINFO2%>).text('');
            $(<%=NEWSBUKTBNWARI1_SBHKKUKTTYOUINFO2%>).text('');
            $(<%=NEWSBUKTBNWARI1_SBHKKUKTTYOUINFO2 + " + 'Unit'"%>).text('');

          <% } else {%>
            <% if (C_UktKbn.BLNK.eq(uiBean.getSbuktkbn1())) { %>
                 $(<%= SBUKTKBN1_SBHKKUKTTYOUINFO2 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (BizUtil.isBlank(uiBean.getSbuktnmkn1())) { %>
                 $(<%= SBUKTNMKN1_SBHKKUKTTYOUINFO2 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (BizUtil.isBlank(uiBean.getSbuktnmkj1())) { %>
                 $(<%= SBUKTNMKJ1_SBHKKUKTTYOUINFO2 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (uiBean.getSbuktseiymd1() == null) { %>
                 $(<%= SBUKTSEIYMD1_SBHKKUKTTYOUINFO2 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (uiBean.getNewsbuktbnwari1() == null || uiBean.getNewsbuktbnwari1().isOptional()) { %>
                 $(<%= NEWSBUKTBNWARI1_SBHKKUKTTYOUINFO2 %>).text('<%= ASTERISK %>');
            <% } %>
          <% } %>
       <% } %>

       <% if(!BizUtil.isBlank(uiBean.getSbuktnmkn2()) || !BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn2())) { %>
          showGroup(<%= SBHKKUKTTYOUINFO3 %>);
          <% if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2())) { %>
            showGroup(<%= SBHKUKTINFO21 %>);
            $(<%=SBUKTNMKN2_SBHKKUKTTYOUINFO3%>).text('');
            $(<%=SBUKTNMKJ2_SBHKKUKTTYOUINFO3%>).text('');
            $(<%=SBUKTNMKJHUKAKBN2_SBHKKUKTTYOUINFO3%>).text('');
            $(<%=SBUKTSEIYMD2_SBHKKUKTTYOUINFO3%>).text('');
            $(<%=NEWSBUKTBNWARI2_SBHKKUKTTYOUINFO3%>).text('');
            $(<%=NEWSBUKTBNWARI2_SBHKKUKTTYOUINFO3 + " + 'Unit'"%>).text('');
          <% } else {%>
            <% if (BizUtil.isBlank(uiBean.getSbuktnmkn2())) { %>
                 $(<%= SBUKTNMKN2_SBHKKUKTTYOUINFO3 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (BizUtil.isBlank(uiBean.getSbuktnmkj2())) { %>
                 $(<%= SBUKTNMKJ2_SBHKKUKTTYOUINFO3 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (uiBean.getSbuktseiymd2() == null) { %>
                 $(<%= SBUKTSEIYMD2_SBHKKUKTTYOUINFO3 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (uiBean.getNewsbuktbnwari2() == null || uiBean.getNewsbuktbnwari2().isOptional()) { %>
                 $(<%= NEWSBUKTBNWARI2_SBHKKUKTTYOUINFO3 %>).text('<%= ASTERISK %>');
            <% } %>
          <% } %>
       <% } %>

       <% if(!BizUtil.isBlank(uiBean.getSbuktnmkn3()) || !BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn3())) { %>
          showGroup(<%= SBHKKUKTTYOUINFO4  %>);
          <% if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3())) { %>
            showGroup(<%= SBHKUKTINFO31 %>);
            $(<%=SBUKTNMKN3_SBHKKUKTTYOUINFO4%>).text('');
            $(<%=SBUKTNMKJ3_SBHKKUKTTYOUINFO4%>).text('');
            $(<%=SBUKTNMKJHUKAKBN3_SBHKKUKTTYOUINFO4%>).text('');
            $(<%=SBUKTSEIYMD3_SBHKKUKTTYOUINFO4%>).text('');
            $(<%=NEWSBUKTBNWARI3_SBHKKUKTTYOUINFO4%>).text('');
            $(<%=NEWSBUKTBNWARI3_SBHKKUKTTYOUINFO4 + " + 'Unit'"%>).text('');
          <% } else {%>
            <% if (BizUtil.isBlank(uiBean.getSbuktnmkn3())) { %>
                 $(<%= SBUKTNMKN3_SBHKKUKTTYOUINFO4 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (BizUtil.isBlank(uiBean.getSbuktnmkj3())) { %>
                 $(<%= SBUKTNMKJ3_SBHKKUKTTYOUINFO4 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (uiBean.getSbuktseiymd3() == null) { %>
                 $(<%= SBUKTSEIYMD3_SBHKKUKTTYOUINFO4 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (uiBean.getNewsbuktbnwari3() == null || uiBean.getNewsbuktbnwari3().isOptional()) { %>
                 $(<%= NEWSBUKTBNWARI3_SBHKKUKTTYOUINFO4 %>).text('<%= ASTERISK %>');
            <% } %>
          <% } %>
       <% } %>

       <% if(!BizUtil.isBlank(uiBean.getSbuktnmkn4()) || !BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn4())) { %>
          showGroup(<%= SBHKKUKTTYOUINFO5 %>);
          <% if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4())) { %>
            showGroup(<%= SBHKUKTINFO41 %>);
            $(<%=SBUKTNMKN4_SBHKKUKTTYOUINFO5%>).text('');
            $(<%=SBUKTNMKJ4_SBHKKUKTTYOUINFO5%>).text('');
            $(<%=SBUKTNMKJHUKAKBN4_SBHKKUKTTYOUINFO5%>).text('');
            $(<%=SBUKTSEIYMD4_SBHKKUKTTYOUINFO5%>).text('');
            $(<%=NEWSBUKTBNWARI4_SBHKKUKTTYOUINFO5%>).text('');
            $(<%=NEWSBUKTBNWARI4_SBHKKUKTTYOUINFO5 + " + 'Unit'"%>).text('');
          <% } else {%>
            <% if (BizUtil.isBlank(uiBean.getSbuktnmkn4())) { %>
                 $(<%= SBUKTNMKN4_SBHKKUKTTYOUINFO5 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (BizUtil.isBlank(uiBean.getSbuktnmkj4())) { %>
                 $(<%= SBUKTNMKJ4_SBHKKUKTTYOUINFO5 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (uiBean.getSbuktseiymd4() == null) { %>
                 $(<%= SBUKTSEIYMD4_SBHKKUKTTYOUINFO5 %>).text('<%= ASTERISK %>');
            <% } %>

            <% if (uiBean.getNewsbuktbnwari4() == null || uiBean.getNewsbuktbnwari4().isOptional()) { %>
                 $(<%= NEWSBUKTBNWARI4_SBHKKUKTTYOUINFO5 %>).text('<%= ASTERISK %>');
            <% } %>
          <% } %>
       <% } %>
    <% } %>

       <% if(C_UmuKbn.ARI.eq(uiBean.getStdrsktkyhkumu())) { %>
         showGroup(<%= STDRSKKAIJYOINFO1 %>);
         showGroup(<%= STDRSKKAIJYOINFO2 %>);

         <% if(C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) { %>
            showKoumoku(<%= STDRSKKAIJYOKBN_STDRSKKAIJYOINFO1 %>);

            $(<%= NEWSTDRSKNMKN_STDRSKKAIJYOINFO2 %>).text('');
            $(<%= NEWSTDRSKNMKJ_STDRSKKAIJYOINFO2 %>).text('');
            $(<%= NEWSTDRSKNMKJHUKAKBN_STDRSKKAIJYOINFO2 %>).text('');
            $(<%= NEWSTDRSKSEIYMD_STDRSKKAIJYOINFO2 %>).text('');

         <% } else { %>

           $(<%= STDRSKKAIJYOINFO2 + DIV %>).css("margin-top", "0px");
           <% if (C_UktKbn.BLNK.eq(uiBean.getNewstdruktkbn())) { %>
                $(<%= NEWSTDRUKTKBN_STDRSKKAIJYOINFO2 %>).text('<%= ASTERISK %>');
           <% } %>

           <% if (BizUtil.isBlank(uiBean.getNewstdrsknmkn())) { %>
                $(<%= NEWSTDRSKNMKN_STDRSKKAIJYOINFO2 %>).text('<%= ASTERISK %>');
           <% } %>

           <% if (BizUtil.isBlank(uiBean.getNewstdrsknmkj())) { %>
                $(<%= NEWSTDRSKNMKJ_STDRSKKAIJYOINFO2 %>).text('<%= ASTERISK %>');
           <% } %>

           <% if (uiBean.getNewstdrskseiymd() == null) { %>
                $(<%= NEWSTDRSKSEIYMD_STDRSKKAIJYOINFO2 %>).text('<%= ASTERISK %>');
           <% } %>
         <% } %>
       <% } %>

    <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
      showKoumoku(<%= SASIMODOSISAKIKBN_KEKKAINPUTGROUP %>);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
        showGroup(<%=TYHYSAKUSEIYHKBNINFO%>);
        showGroup(<%=HONNINKAKUNININFO%>);
        showGroup(<%=HASSOUKBNGROUP%>);
        showGroup(<%= FOOTERBUTTONS2 %>);
        showGroup(<%= KEKKAINPUTGROUP %>);
    <% } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
        showGroup(<%=KEKKAINPUTGROUP%>);

        <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>

            showGroup(<%=TYHYSAKUSEIYHKBNINFO%>);
            showGroup(<%=HONNINKAKUNININFO%>);
            showGroup(<%=HASSOUKBNGROUP%>);
            inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNINKAKUNININFO%>);
            inputToOutput(<%=TYHYSAKUSEIYHKBN_TYHYSAKUSEIYHKBNINFO%>);
            inputToOutput(<%=HASSOUKBN_HASSOUKBNGROUP%>);
            $('#IIC0017').visible(false);
        <% } %>

        showGroup(<%= FOOTERBUTTONS2 %>);
    <% } %>
    <% if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) || C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) { %>
        <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
            || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

           showGroup(<%= SINKEIYAKUTUUSINSAKIINFO %>);
           <% if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) { %>
              showGroup(<%= IDOUTYOUSYOYUUKOUMOKU %>);

           <% } %>
        <% } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
           <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
              <% if(C_UmuKbn.NONE.eq(uiBean.getAdrhenkouumu())) { %>
                 $(<%=TSINADR1KJ_SINKEIYAKUTUUSINSAKIINFO%>).removeClass('returnBlock');
                 $(<%=TSINADR2KJ_SINKEIYAKUTUUSINSAKIINFO%>).removeClass('returnBlock');
                 $(<%=TSINADR3KJ_SINKEIYAKUTUUSINSAKIINFO%>).removeClass('returnBlock');

              <% }%>

              showGroup(<%= SINKEIYAKUTUUSINSAKIINFO %>);
              inputToOutput(<%= ADRHENKOUUMU_SINKEIYAKUTUUSINSAKIINFO %>);
              inputToOutput(<%= TSINYNO_SINKEIYAKUTUUSINSAKIINFO %>);
              inputToOutput(<%= TSINADR1KJ_SINKEIYAKUTUUSINSAKIINFO %>);
              inputToOutput(<%= TSINADR2KJ_SINKEIYAKUTUUSINSAKIINFO %>);
              inputToOutput(<%= TSINADR3KJ_SINKEIYAKUTUUSINSAKIINFO %>);
              inputToOutput(<%= TSINTELNO_SINKEIYAKUTUUSINSAKIINFO %>);
              inputToOutput(<%= DAI2TSINTELNO_SINKEIYAKUTUUSINSAKIINFO %>);

              <% if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) { %>
                 showGroup(<%= IDOUTYOUSYOYUUKOUMOKU %>);
                 inputToOutput("#oldkyksibouymdSpan > *");
                 inputToOutput("#syoruiukeymdSpan > *");
              <% } %>
           <% } %>
        <% } %>
    <% } %>
  <% }
  else if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
        || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

        showGroup(<%=KEKKAINPUTGROUP%>);

        showGroup(<%=TYHYSAKUSEIYHKBNINFO%>);
        showGroup(<%=HONNINKAKUNININFO%>);
        showGroup(<%=HASSOUKBNGROUP%>);
    <% } %>
    <% if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

        showGroup(<%=KEKKAINPUTGROUP%>);

        showGroup(<%=TYHYSAKUSEIYHKBNINFO%>);
        showGroup(<%=HONNINKAKUNININFO%>);
        showGroup(<%=HASSOUKBNGROUP%>);
    <% } %>
    <% if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

        showGroup(<%=KEKKAINPUTGROUP%>);
        <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>

            showGroup(<%=TYHYSAKUSEIYHKBNINFO%>);
            showGroup(<%=HONNINKAKUNININFO%>);
            showGroup(<%=HASSOUKBNGROUP%>);
        <% } %>
    <% } %>
    <% if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) || C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) { %>
        <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(uiBean.getKinouMode().getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(uiBean.getKinouMode().getKinouMode())
            || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

           showGroup(<%= SINKEIYAKUTUUSINSAKIINFO %>);
           <% if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) { %>
              showGroup(<%= IDOUTYOUSYOYUUKOUMOKU %>);

           <% } %>
        <% } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
           <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
              showGroup(<%= SINKEIYAKUTUUSINSAKIINFO %>);
              <% if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) { %>
                 showGroup(<%= IDOUTYOUSYOYUUKOUMOKU %>);
              <% } %>
           <% } %>
        <% } %>
    <% } %>
  <% } %>

   <% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
        uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
        <% if( C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())){ %>
             showGroup(<%= SHSNMINFO %>);
             showGroup(<%= SHSKADRINFO %>);
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
