<%--
    kh_haraikata_henkou.js.jsp - 払方変更 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.hozen.khansyuu.khharaikatahenkou.KhHaraikataHenkouConstants.*"%>
<%@page
	import="static yuyu.app.hozen.khansyuu.khharaikatahenkou.KhHaraikataHenkouSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.hozen.khansyuu.khharaikatahenkou.KhHaraikataHenkouUiBean"%>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<%@page import="yuyu.infr.kinoumode.KinouMode"%>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn"%>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn"%>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn"%>
<%@page import="yuyu.def.classification.C_Hrkkeiro"%>
<%@page import="yuyu.def.classification.C_SyorikahiKbn"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="jp.co.slcs.swak.number.BizCurrency"%>
<%@page import="yuyu.def.classification.C_TkiktbrisyuruiKbn"%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<% KhHaraikataHenkouUiBean uiBean = SWAKInjector.getInstance(KhHaraikataHenkouUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);%>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<% if (uiBean.getPageNo() != PAGENO_INPUTKEY) { %>
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
	page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp" />
<jsp:include
	page="/WEB-INF/pages/appcommon/hozen/khview/viewtokusin/view_tokusin.js.jsp" />
<jsp:include
	page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp" />
<jsp:include
	page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp" />
<jsp:include
	page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp" />
<jsp:include
	page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp" />
<jsp:include
	page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp" />

<%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
<jsp:include
	page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp" />
<jsp:include
	page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp" />
<% } %>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
<%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
<jsp:include
	page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp" />
<% } %>
<% }%>

<%
  if (uiBean.getPageNo() == PAGENO_REFERENCE ||
      uiBean.getPageNo() == PAGENO_CONFIRM ||
      uiBean.getPageNo() == PAGENO_RESULT) { %>
<%
    if (!(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
        C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()))) {%>
<jsp:include
	page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp" />
<% } %>
<% }%>

<%
  if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
      uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
<jsp:include
	page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp" />
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

<%
     if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS){ %>
        <%
        if(C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
           showGroup(<%=HRKHOUHOUHENKOUINFO1%>);

           <%
           if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) { %>
             showKoumoku(<%=NEWHRKKAISUU_HRKHOUHOUHENKOUINFO1%>);
           <%
           } else { %>
             showKoumoku(<%=NEWTIKIKTBRISYURUIKBN_HRKHOUHOUHENKOUINFO1%>);
           <% } %>

            <%
           if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
               C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) { %>

               inputToOutput(<%=NEWHRKKEIRO_HRKHOUHOUHENKOUINFO1%>);
           <%
           }  %>
       <% } %>

        <%
        if(C_KhkinouModeIdKbn.KYUUKZANNAIMATI.getValue().equals(kinouMode.getKinouMode()) ||
           C_KhkinouModeIdKbn.CARDTOUROKUMATI.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
          !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()))) { %>
           showGroup(<%=HRKHOUHOUHENKOUINFO1%>);
           inputToOutput(<%=NEWHRKKEIRO_HRKHOUHOUHENKOUINFO1%>);
           inputToOutput(<%=NEWHRKKAISUU_HRKHOUHOUHENKOUINFO1%>);
           inputToOutput(<%=HENKOUYOTEIYM_SPAN%>);

           <%
           if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) { %>
             showKoumoku(<%=NEWHRKKAISUU_HRKHOUHOUHENKOUINFO1%>);
             inputToOutput(<%=NEWHRKKAISUU_HRKHOUHOUHENKOUINFO1%>);
           <%
           } else { %>
             showKoumoku(<%=NEWTIKIKTBRISYURUIKBN_HRKHOUHOUHENKOUINFO1%>);
             inputToOutput(<%=NEWTIKIKTBRISYURUIKBN_HRKHOUHOUHENKOUINFO1%>);
           <% } %>
        <% } %>
  <% } %>

  <%
     if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>

       <%
        if(!(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()))) { %>

            showGroup(<%=HRKHOUHOUHENKOUINFO1%>);

            <%
               if(uiBean.getHrhnkyoup().compareTo(BizCurrency.valueOf(0, uiBean.getHrhnkyoup().getType())) > 0) { %>
                showKoumoku(<%=HRHNKYOUPZYTYM_HRKHOUHOUHENKOUINFO1%>);
                showKoumoku(<%=HRHNKYOUPZYTM_HRKHOUHOUHENKOUINFO1%>);

                <%
                   if(C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) { %>
                   showKoumoku(<%=YENKAHRHNKYOUP_HRKHOUHOUHENKOUINFO1%>);
                   showKoumoku(<%=HRHNKYOUPKWSRATEKJYMD_HRKHOUHOUHENKOUINFO1%>);
                <% } %>
            <% } %>

            <%
               if (!HRHNKYOUP_HUKARIYUU_NONE.equals(uiBean.getHrhnkyoupHukaRiyuu())) { %>
                 $(<%= IIA3005%>).visible(true);
             <% } %>

           <%
           if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) { %>
             showKoumoku(<%=NEWHRKKAISUU_HRKHOUHOUHENKOUINFO1%>);
             showKoumoku(<%=NEWHRKP_HRKHOUHOUHENKOUINFO1%>);
           <%
           } else { %>
             showKoumoku(<%=NEWTIKIKTBRISYURUIKBN_HRKHOUHOUHENKOUINFO1%>);
             showKoumoku(<%=NEWTIKIKTBRIHRKP_HRKHOUHOUHENKOUINFO1%>);
           <% } %>

            <%
               if(uiBean.getNewnextkosumu().eq(C_UmuKbn.ARI)) { %>
               showGroup(<%=HRKHOUHOUHENKOUINFO2%>);
            <% } %>

           <%
              if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro()) &&
              !BizUtil.isBlank(uiBean.getSaibanCreditKessaiyouNo())) {%>
                 showGroup(<%=CREDITCARDINFO%>);
           <% } %>

        <% } %>

        <%
           if(C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
              C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
              C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
              if(C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) { %>
               showGroup(<%=KOUZAINFO%>);
               <%
               if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro())) { %>
                showGroup(<%=KYUUKOUZAANNAIINFO%>);
               <% } %>
              <% } %>
              <%
              if(C_UmuKbn.ARI.eq(uiBean.getYykidouuktkdispumu())) { %>
              showGroup(<%=YYKIDOUUKTKINFO%>);
              <% } %>

              showGroup(<%=KANRYOTUUTIOUTINFO%>);

        <% } %>

        <%
           if(C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
              C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
              C_KhkinouModeIdKbn.KYUUKZANNAIMATI.getValue().equals(kinouMode.getKinouMode()) ||
              C_KhkinouModeIdKbn.CARDTOUROKUMATI.getValue().equals(kinouMode.getKinouMode()) ||
              C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {%>
              showGroup(<%=KEKKAINPUTGROUP%>);
        <% } %>

        <%
            if(C_KhkinouModeIdKbn.KYUUKZANNAIMATI.getValue().equals(kinouMode.getKinouMode()) ||
               C_KhkinouModeIdKbn.CARDTOUROKUMATI.getValue().equals(kinouMode.getKinouMode()) ||
               C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
               !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) {
                 if(C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) { %>
                 showGroup(<%=KOUZAINFO%>);
                 $(<%= IBC1001%>).visible(false);
                 $(<%= IBC1002%>).visible(false);
                 $(<%= IBC1003%>).visible(false); <%-- TODO --%>
                 $(<%= IBC1004%>).visible(false);
                 $(<%= IIC1003%>).visible(false);
                 inputToOutput(<%=BANKCD_KOUZAINFO%>);
                 inputToOutput(<%=SITENCD_KOUZAINFO%>);
                 inputToOutput(<%=YOKINKBN_KOUZAINFO%>);
                 inputToOutput(<%=KOUZANO_KOUZAINFO%>);
                 inputToOutput(<%=KZKYKDOUKBN_KOUZAINFO%>);
                 inputToOutput(<%=KZMEIGINMKN_KOUZAINFO%>);
                 <%
                 if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro())) { %>
                  showGroup(<%=KYUUKOUZAANNAIINFO%>);
                  inputToOutput(<%=KYUUKOUZAANNAIKBN_KYUUKOUZAANNAIINFO%>);
                 <% } %>
                 <% } %>

                 <%
                 if(C_UmuKbn.ARI.eq(uiBean.getYykidouuktkdispumu())) { %>
                 showGroup(<%=YYKIDOUUKTKINFO%>);
                 inputToOutput(<%=YYKIDOUUKTKKBN_YYKIDOUUKTKINFO%>);
                 <% } %>

                 showGroup(<%=KANRYOTUUTIOUTINFO%>);
                 inputToOutput(<%=KANRYOTUUTIOUTKBN_KANRYOTUUTIOUTINFO%>);
                 $(<%= IIC0001%>).visible(false);
        <% } %>

        <%
            if(C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
               C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
             $(<%=SKSSAKUSEIBTN_FOOTERBUTTONS%>).visible(true);
        <% } %>

        <%
            if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
              showGroup(<%=KEKKAINPUTGROUP%>);
              showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
        <% } %>

        <%
            if (!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
            showGroup(<%=FOOTERBUTTONS3%>);
        <% } %>
  <% } %>

  <%
     if (uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>

      <%
        if(!(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()))) { %>

            showGroup(<%=HRKHOUHOUHENKOUINFO1%>);

            <%
               if(uiBean.getHrhnkyoup().compareTo(BizCurrency.valueOf(0, uiBean.getHrhnkyoup().getType())) > 0) { %>
                showKoumoku(<%=HRHNKYOUPZYTYM_HRKHOUHOUHENKOUINFO1%>);
                showKoumoku(<%=HRHNKYOUPZYTM_HRKHOUHOUHENKOUINFO1%>);

                <%
                   if(C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) { %>
                   showKoumoku(<%=YENKAHRHNKYOUP_HRKHOUHOUHENKOUINFO1%>);
                   showKoumoku(<%=HRHNKYOUPKWSRATEKJYMD_HRKHOUHOUHENKOUINFO1%>);
                <% } %>
            <%  } %>

            <%
                if (!HRHNKYOUP_HUKARIYUU_NONE.equals(uiBean.getHrhnkyoupHukaRiyuu())) { %>
                 $(<%= IIA3005%>).visible(true);
              <% } %>

            <%
             if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) { %>
               showKoumoku(<%=NEWHRKKAISUU_HRKHOUHOUHENKOUINFO1%>);
               showKoumoku(<%=NEWHRKP_HRKHOUHOUHENKOUINFO1%>);
            <%
             } else { %>
               showKoumoku(<%=NEWTIKIKTBRISYURUIKBN_HRKHOUHOUHENKOUINFO1%>);
               showKoumoku(<%=NEWTIKIKTBRIHRKP_HRKHOUHOUHENKOUINFO1%>);
            <% } %>

            <%
               if(uiBean.getNewnextkosumu().eq(C_UmuKbn.ARI)) { %>
               showGroup(<%=HRKHOUHOUHENKOUINFO2%>);
            <% } %>

            <%
              if(C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) { %>
              showGroup(<%=KOUZAINFO%>);
              <%
               if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro())) { %>
                showGroup(<%=KYUUKOUZAANNAIINFO%>);
               <% } %>
              <%
              } else if(C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) { %>
               <%
               if (!BizUtil.isBlank(uiBean.getSaibanCreditKessaiyouNo())) {%>
                 showGroup(<%=CREDITCARDINFO%>);
               <% } %>
            <% } %>

            <%
            if(C_UmuKbn.ARI.eq(uiBean.getYykidouuktkdispumu())) { %>
            showGroup(<%=YYKIDOUUKTKINFO%>);
            <% } %>

            showGroup(<%=KANRYOTUUTIOUTINFO%>);
      <% } %>

      <%
         if(C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.KYUUKZANNAIMATI.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.CARDTOUROKUMATI.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {%>
            showGroup(<%=KEKKAINPUTGROUP%>);
      <% } %>

      <%
          if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {%>
          showGroup(<%=KEKKAINPUTGROUP%>);
          showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
      <% } %>
  <% } %>

    <%
       if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
           uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

            showGroup(<%=HRKHOUHOUHENKOUINFO1%>);

            <%
               if(uiBean.getHrhnkyoup().compareTo(BizCurrency.valueOf(0, uiBean.getHrhnkyoup().getType())) > 0) { %>
                showKoumoku(<%=HRHNKYOUPZYTYM_HRKHOUHOUHENKOUINFO1%>);
                showKoumoku(<%=HRHNKYOUPZYTM_HRKHOUHOUHENKOUINFO1%>);

                <%
                   if(C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) { %>
                   showKoumoku(<%=YENKAHRHNKYOUP_HRKHOUHOUHENKOUINFO1%>);
                   showKoumoku(<%=HRHNKYOUPKWSRATEKJYMD_HRKHOUHOUHENKOUINFO1%>);
                <% } %>
            <%  } %>
            <%
                if (!HRHNKYOUP_HUKARIYUU_NONE.equals(uiBean.getHrhnkyoupHukaRiyuu())) { %>
                 $(<%= IIA3005%>).visible(true);
              <% } %>

            <%
             if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) { %>
               showKoumoku(<%=NEWHRKKAISUU_HRKHOUHOUHENKOUINFO1%>);
               showKoumoku(<%=NEWHRKP_HRKHOUHOUHENKOUINFO1%>);
            <%
             } else { %>
               showKoumoku(<%=NEWTIKIKTBRISYURUIKBN_HRKHOUHOUHENKOUINFO1%>);
               showKoumoku(<%=NEWTIKIKTBRIHRKP_HRKHOUHOUHENKOUINFO1%>);
            <% } %>

            <%
               if(uiBean.getNewnextkosumu().eq(C_UmuKbn.ARI)) { %>
               showGroup(<%=HRKHOUHOUHENKOUINFO2%>);
            <% } %>
    <% } %>

    <%
       if (uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
       <%
          if(C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) { %>
             showGroup(<%=CREDITCARDINFO%>);
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
