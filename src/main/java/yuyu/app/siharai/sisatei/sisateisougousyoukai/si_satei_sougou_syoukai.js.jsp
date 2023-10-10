<%--
    si_satei_sougou_syoukai.js.jsp - 査定総合照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisateisougousyoukai.SiSateiSougouSyoukaiConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisateisougousyoukai.SiSateiSougouSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sisatei.sisateisougousyoukai.SiSateiSougouSyoukaiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.def.classification.C_TokkoudosghtnpKbn"%>
<%@page import="yuyu.def.classification.C_YuukousyoumetuKbn"%>
<%@page import="yuyu.def.classification.C_YokinKbn"%>

<% SiSateiSougouSyoukaiUiBean uiBean = SWAKInjector.getInstance(SiSateiSougouSyoukaiUiBean.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>

  <%
     if (uiBean.getPageNo() == PAGENO_SKINFO1) { %>
       <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
  <% }%>

  <%
     if (uiBean.getPageNo() == PAGENO_SKINFO2) { %>
       <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
  <% }%>


<script type="text/javascript"><!--
$(function(){

  $(<%= FUNCTIONNAMELINK %>).attr('disabled', 'true');
  $(<%= FUNCTIONNAMELINK %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');

  $(<%= SKINFO1BTNBYSK1_HEADERBUTTONS3 %>).disable(true);

  $(<%= SKINFO2BTNBYSK2_HEADERBUTTONS4 %>).disable(true);

  $(<%= KYKINFOBTNBYKYK_HEADERBUTTONS5 %>).disable(true);

  $(<%= NAYOSEINFOBTNBYNAYOSE_HEADERBUTTONS6 %>).disable(true);

  $(<%= TTDKTYUUIINFOBTNBYTTDK_HEADERBUTTONS7 %>).disable(true);

  <%
     if (uiBean.getPageNo() == PAGENO_SKINFO1) {

       if (uiBean.getSkKihonKanriInfoDataSource().size() > 0) { %>
         showList(<%= SKKIHONKANRIINFO %>);
       <% }

       if (uiBean.isSeikyuuJyouhouFlag()) { %>
         showGroup(<%= SKJYOUHOU %>);
         showGroup(<%= SOUHUSAKIINFO %>);
         showGroup(<%= SOUKINSAKI %>);
       <% }

       if (uiBean.isSaikensyaJyouhouFlag()) { %>
         showGroup(<%= VIEWSAIKENINFO %>);
         showGroup(<%= VIEWSAIKENINFO1 %>);
       <% }

       if (uiBean.getYokinkbn() !=null && !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn())) { %>
         showKoumoku(<%= YOKINKBN_SOUKINSAKI %>);
       <% } %>

  <% }
       else if (uiBean.getPageNo() == PAGENO_SKINFO2) { %>

         <%
         if (uiBean.isHubiitiranFlag()) { %>
           showList(<%= HUBILIST %>);
         <% } %>

         $(<%= HUBILIST_TRKYMD_LABEL %>).attr("rowspan","2");
         $(<%= HUBILIST_GENPONHNKYKUMU_LABEL %>).attr("rowspan","2");
         $(<%= HUBILIST_HASINYMD_LABEL %>).attr("rowspan","2");
         $(<%= HUBILIST_HASSINSAKIKBN_LABEL %>).attr("rowspan","2");
         $(<%= HUBILIST_KAISYOUMD_LABEL %>).attr("rowspan","2");
         $(<%= HUBILIST_HUBISYORUIMSG_LABEL %>).attr("colspan","1");
         $(<%= HUBILIST_HUBISYOUNINKTNTNM_LABEL %>).attr("colspan","1");

         $(<%= HUBILIST_TRKYMD_DATA %>).attr("rowspan","2");
         $(<%= HUBILIST_GENPONHNKYKUMU_DATA %>).attr("rowspan","2");
         $(<%= HUBILIST_HASINYMD_DATA %>).attr("rowspan","2");
         $(<%= HUBILIST_HASSINSAKIKBN_DATA %>).attr("rowspan","2");
         $(<%= HUBILIST_KAISYOUMD_DATA %>).attr("rowspan","2");
         $(<%= HUBILIST_HUBISYORUIMSG_DATA %>).attr("colspan","1");
         $(<%= HUBILIST_HUBISYOUNINKTNTNM_DATA %>).attr("colspan","1");


         <%
         if (uiBean.isMousidejinJyouhouFlag()) { %>
           showGroup(<%= MOUSIDENININFO %>);
           showGroup(<%= MOUSIDENININFO2 %>);
           showGroup(<%= MOUSIDENAIYOU %>);
         <% } %>

  <% }
       else if (uiBean.getPageNo() == PAGENO_KEIYAKUINFO) {

         if (uiBean.isKeiyakuJyouhouFlag()) { %>
           showGroup(<%= KIHONINFO %>);
           showGroup(<%= KEIYAKUSYAINFO %>);
           showGroup(<%= HIHOKENSYAINFO %>);
           showGroup(<%= HOSYOUINFO %>);
           showGroup(<%= SONOTATKINFO %>);
           showGroup(<%= DAIRITENINFO1 %>);
           showGroup(<%= DAIRITENINFO3 %>);
           showGroup(<%= DAIRITENINFO4 %>);

         $(<%= MOSUKEYMD_KIHONINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");
         $(<%= KKTYMD_KIHONINFO %>).parent().attr("rowspan","2");
         $(<%= KKTYMD_KIHONINFO + LABEL %>).parent().attr("rowspan","2");


         <%
         if (uiBean.getVhsyusyuhrkkkn() !=null && uiBean.getVhsyusyuhrkkkn() == 0) { %>
           $(<%=VHSYUSYUHRKKKN_HOSYOUINFO%>).text("");
           $(<%=VHSYUSYUHRKKKNSMNKBN_HOSYOUINFO%>).text("");
         <% }else { %>
           $(<%=VHSYUSYUHRKKKN_HOSYOUINFO %>).parent().find("span").eq(2).text("");
         <% }

         if ((null != uiBean.getVhsyudai1hknkkn()) && (uiBean.getVhsyudai1hknkkn() != 0)) {  %>
           showKoumoku(<%= VHSYUDAI1HKNKKN_HOSYOUINFO %>);
         <% }

         if (uiBean.getVhsyusyufktsknnkaisiymd() != null) { %>

           showKoumoku(<%= VHSYUSYUFKTSKNNKAISIYMD_HOSYOUINFO %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyusyuhtnpbuicd1())) { %>
           showKoumoku(<%= VHSYUSYUHTNPBUICD1_HOSYOUINFO %>);
           showKoumoku(<%= VHSYUSYUHTNPKKN1_HOSYOUINFO %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyusyuhtnpbuicd2())) { %>
           showKoumoku(<%= VHSYUSYUHTNPBUICD2_HOSYOUINFO %>);
           showKoumoku(<%= VHSYUSYUHTNPKKN2_HOSYOUINFO %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyusyuhtnpbuicd3())) { %>
           showKoumoku(<%= VHSYUSYUHTNPBUICD3_HOSYOUINFO %>);
           showKoumoku(<%= VHSYUSYUHTNPKKN3_HOSYOUINFO %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyusyuhtnpbuicd4())) { %>
           showKoumoku(<%= VHSYUSYUHTNPBUICD4_HOSYOUINFO %>);
           showKoumoku(<%= VHSYUSYUHTNPKKN4_HOSYOUINFO %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyusyutokkdsghtnpkbn())) { %>
           showKoumoku( <%= VHSYUSYUTOKKDSGHTNPKBN_HOSYOUINFO %>);
         <% } %>

        <%
         if (uiBean.isTokuyaku1Flag()) {%>
             showGroup(<%= TKINFO1 %>);
         <% }

         if (uiBean.isTokuyaku2Flag()) {%>
             showGroup(<%= TKINFO2 %>);
         <% }

         if (uiBean.isTokuyaku3Flag()) {%>
             showGroup(<%= TKINFO3 %>);
         <% }

         if (uiBean.isTokuyaku4Flag()) {%>
             showGroup(<%= TKINFO4 %>);
         <% }

         if (uiBean.isTokuyaku5Flag()) {%>
             showGroup(<%= TKINFO5 %>);
         <% }

         if (uiBean.isTokuyaku6Flag()) {%>
             showGroup(<%= TKINFO6 %>);
         <% }

         if (uiBean.isTokuyaku7Flag()) {%>
             showGroup(<%= TKINFO7 %>);
         <% }

         if (uiBean.isTokuyaku8Flag()) {%>
             showGroup(<%= TKINFO8 %>);
         <% }

         if (uiBean.isTokuyaku9Flag()) {%>
             showGroup(<%= TKINFO9 %>);
         <% }

         if (uiBean.isTokuyaku10Flag()) {%>
             showGroup(<%= TKINFO10 %>);
         <% } %>

         <%
         if (uiBean.getVhsyudisptkhrkkkn1() !=null && uiBean.getVhsyudisptkhrkkkn1() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN1_TKINFO1%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN1_TKINFO1%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN1_TKINFO1 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn2() !=null && uiBean.getVhsyudisptkhrkkkn2() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN2_TKINFO2%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN2_TKINFO2%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN2_TKINFO2 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn3() !=null && uiBean.getVhsyudisptkhrkkkn3() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN3_TKINFO3%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN3_TKINFO3%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN3_TKINFO3 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn4() !=null && uiBean.getVhsyudisptkhrkkkn4() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN4_TKINFO4%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN4_TKINFO4%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN4_TKINFO4 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn5() !=null && uiBean.getVhsyudisptkhrkkkn5() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN5_TKINFO5%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN5_TKINFO5%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN5_TKINFO5 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn6() !=null && uiBean.getVhsyudisptkhrkkkn6() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN6_TKINFO6%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN6_TKINFO6%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN6_TKINFO6 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn7() !=null && uiBean.getVhsyudisptkhrkkkn7() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN7_TKINFO7%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN7_TKINFO7%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN7_TKINFO7 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn8() !=null && uiBean.getVhsyudisptkhrkkkn8() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN8_TKINFO8%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN8_TKINFO8%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN8_TKINFO8 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn9() !=null && uiBean.getVhsyudisptkhrkkkn9() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN9_TKINFO9%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN9_TKINFO9%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN9_TKINFO9 %>).parent().find("span").eq(2).text("");
         <% }

         if (uiBean.getVhsyudisptkhrkkkn10() !=null && uiBean.getVhsyudisptkhrkkkn10() == 0) { %>
           $(<%=VHSYUDISPTKHRKKKN10_TKINFO10%>).text("");
           $(<%=VHSYUDISPTKHRKKKNSMNKBN10_TKINFO10%>).text("");
         <% }else { %>
           $(<%=VHSYUDISPTKHRKKKN10_TKINFO10 %>).parent().find("span").eq(2).text("");
         <% } %>

         <%
         if (uiBean.getVhsyudisptkhkskkaisiymd1() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD1_TKINFO1 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd2() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD2_TKINFO2 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd3() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD3_TKINFO3 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd4() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD4_TKINFO4 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd5() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD5_TKINFO5 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd6() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD6_TKINFO6 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd7() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD7_TKINFO7 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd8() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD8_TKINFO8 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd9() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD9_TKINFO9 %>);
         <% }

         if (uiBean.getVhsyudisptkhkskkaisiymd1() != null) { %>
           showKoumoku( <%= VHSYUDISPTKHKSKKAISIYMD10_TKINFO10 %>);
         <% } %>

         <%
         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd11())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD11_TKINFO1 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN11_TKINFO1 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd21())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD21_TKINFO1 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN21_TKINFO1 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd31())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD31_TKINFO1 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN31_TKINFO1 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd41())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD41_TKINFO1 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN41_TKINFO1 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd12())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD12_TKINFO2 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN12_TKINFO2 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd22())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD22_TKINFO2 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN22_TKINFO2 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd32())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD32_TKINFO2 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN32_TKINFO2 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd42())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD42_TKINFO2 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN42_TKINFO2 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd13())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD13_TKINFO3 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN13_TKINFO3 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd23())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD23_TKINFO3 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN23_TKINFO3 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd33())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD33_TKINFO3 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN33_TKINFO3 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd43())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD43_TKINFO3 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN43_TKINFO3 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd14())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD14_TKINFO4 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN14_TKINFO4 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd24())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD24_TKINFO4 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN24_TKINFO4 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd34())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD34_TKINFO4 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN34_TKINFO4 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd44())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD44_TKINFO4 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN44_TKINFO4 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd15())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD15_TKINFO5 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN15_TKINFO5 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd25())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD25_TKINFO5 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN25_TKINFO5 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd35())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD35_TKINFO5 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN35_TKINFO5 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd45())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD45_TKINFO5 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN45_TKINFO5 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd16())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD16_TKINFO6 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN16_TKINFO6 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd26())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD26_TKINFO6 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN26_TKINFO6 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd36())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD36_TKINFO6 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN36_TKINFO6 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd46())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD46_TKINFO6 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN46_TKINFO6 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd17())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD17_TKINFO7 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN17_TKINFO7 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd27())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD27_TKINFO7 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN27_TKINFO7 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd37())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD37_TKINFO7 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN37_TKINFO7 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd47())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD47_TKINFO7 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN47_TKINFO7 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd18())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD18_TKINFO8 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN18_TKINFO8 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd28())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD28_TKINFO8 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN28_TKINFO8 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd38())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD38_TKINFO8 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN38_TKINFO8 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd48())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD48_TKINFO8 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN48_TKINFO8 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd19())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD19_TKINFO9 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN19_TKINFO9 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd29())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD29_TKINFO9 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN29_TKINFO9 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd39())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD39_TKINFO9 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN39_TKINFO9 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd49())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD49_TKINFO9 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN49_TKINFO9 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd110())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD110_TKINFO10 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN110_TKINFO10 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd210())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD210_TKINFO10 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN210_TKINFO10 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd310())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD310_TKINFO10 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN310_TKINFO10 %>);
         <% }

         if (!BizUtil.isBlank(uiBean.getVhsyudisptkhtnpbuicd410())) { %>
           showKoumoku( <%= VHSYUDISPTKHTNPBUICD410_TKINFO10 %>);
           showKoumoku( <%= VHSYUDISPTKHTNPKKN410_TKINFO10 %>);
         <% } %>

         <%
         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn1())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN1_TKINFO1 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn2())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN2_TKINFO2 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn3())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN3_TKINFO3 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn4())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN4_TKINFO4 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn5())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN5_TKINFO5 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn6())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN6_TKINFO6 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn7())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN7_TKINFO7 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn8())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN8_TKINFO8 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn9())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN9_TKINFO9 %>);
         <% }

         if (!C_TokkoudosghtnpKbn.BLNK.eq(uiBean.getVhsyudisptktkkdsghtpkbn10())) { %>
           showKoumoku( <%= VHSYUDISPTKTKKDSGHTPKBN10_TKINFO10 %>);
         <% } %>


         <%
         if (uiBean.isSibouketoriNinzuFlag()) { %>
           showGroup(<%= SBHKUKTINFO %>);
         <% }

         if (uiBean.isUketoriJyouhou1Flag()) { %>
           showGroup(<%= SBHKUKTINFO1 %>);

           <%
             if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn1())) { %>
             showKoumoku( <%= VSHKTDISPSBUKTNMKN1_SBHKUKTINFO1 %>);
           <% }

           if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkj1())) { %>
             showKoumoku( <%= VSHKTDISPSBUKTNMKJ1_SBHKUKTINFO1 %>);
           <% }

           if (uiBean.getVshktdispsbuktseiymd1() != null) { %>
             showKoumoku( <%= VSHKTDISPSBUKTSEIYMD1_SBHKUKTINFO1 %>);
           <% }

           if ((uiBean.getVshktdispsbuktbnwari1() != null) &&
               (!uiBean.getVshktdispsbuktbnwari1().isZeroOrOptional()) ) { %>
             showKoumoku( <%= VSHKTDISPSBUKTBNWARI1_SBHKUKTINFO1 %>);
           <% }
         }

         if (uiBean.isUketoriJyouhou2Flag()) { %>
           showGroup(<%= SBHKUKTINFO2 %>);

           <%
             if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn2())) { %>
             showKoumoku( <%= VSHKTDISPSBUKTNMKN2_SBHKUKTINFO2 %>);
           <% }

           if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkj2())) { %>
             showKoumoku( <%= VSHKTDISPSBUKTNMKJ2_SBHKUKTINFO2 %>);
           <% }

           if (uiBean.getVshktdispsbuktseiymd2() != null) { %>
             showKoumoku( <%= VSHKTDISPSBUKTSEIYMD2_SBHKUKTINFO2 %>);
           <% }

           if ((uiBean.getVshktdispsbuktbnwari2() != null) &&
               (!uiBean.getVshktdispsbuktbnwari2().isZeroOrOptional()) ) { %>
             showKoumoku( <%= VSHKTDISPSBUKTBNWARI2_SBHKUKTINFO2 %>);
           <% }
         }

         if (uiBean.isUketoriJyouhou3Flag()) { %>
           showGroup(<%= SBHKUKTINFO3 %>);

           <%
             if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn3())) { %>
             showKoumoku( <%= VSHKTDISPSBUKTNMKN3_SBHKUKTINFO3 %>);
           <% }

           if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkj3())) { %>
             showKoumoku( <%= VSHKTDISPSBUKTNMKJ3_SBHKUKTINFO3 %>);
           <% }

           if (uiBean.getVshktdispsbuktseiymd3() != null) { %>
             showKoumoku( <%= VSHKTDISPSBUKTSEIYMD3_SBHKUKTINFO3 %>);
           <% }

           if ((uiBean.getVshktdispsbuktbnwari3() != null) &&
               (!uiBean.getVshktdispsbuktbnwari3().isZeroOrOptional()) ) { %>
             showKoumoku( <%= VSHKTDISPSBUKTBNWARI3_SBHKUKTINFO3 %>);
           <% }
         }

         if (uiBean.isUketoriJyouhou4Flag()) { %>
           showGroup(<%= SBHKUKTINFO4 %>);

           <%
             if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn4())) { %>
             showKoumoku( <%= VSHKTDISPSBUKTNMKN4_SBHKUKTINFO4 %>);
           <% }

           if (!BizUtil.isBlank(uiBean.getVshktdispsbuktnmkj4())) { %>
             showKoumoku( <%= VSHKTDISPSBUKTNMKJ4_SBHKUKTINFO4 %>);
           <% }

           if (uiBean.getVshktdispsbuktseiymd4() != null) { %>
             showKoumoku( <%= VSHKTDISPSBUKTSEIYMD4_SBHKUKTINFO4 %>);
           <% }

           if ((uiBean.getVshktdispsbuktbnwari4() != null) &&
               (!uiBean.getVshktdispsbuktbnwari4().isZeroOrOptional()) ) { %>
             showKoumoku( <%= VSHKTDISPSBUKTBNWARI4_SBHKUKTINFO4 %>);
           <% }
         } %>

         <%
         if (uiBean.isSiteiDairiSeikyuFlag()) { %>
           showGroup(<%= SITEISEIKYUUINFO %>);
         <% } %>

         <%
         if(uiBean.isJuuDairiFlag()) { %>
           showGroup(<%=DAIRITENINFO2%>);
         <% }

         if (uiBean.isUketsukeKanriIdFlag()) { %>
           showKoumoku( <%= SMBCKANRIID_DAIRITENINFO4 %>);
         <% } %>
      <% } %>
  <% }
       else if (uiBean.getPageNo() == PAGENO_NAYOSEINFO) {
         if (uiBean.isBetsuKeiyakuJyouhouFlag()) { %>
           showList(<%= BETUKYKINFO %>);
         <% } %>

  <% }
       else if (uiBean.getPageNo() == PAGENO_TTDKTYUUIINFO) { %>

         <%
         if (uiBean.isTtdktyuuikbnInfoFlag()) { %>
           showList(<%= TTDKTYUUIKBNINFO %>);
         <% } %>

         <%
         if (uiBean.isSikenSetFlag()) { %>
           showGroup( <%= STKNSETINFO %>);
         <% } %>

         <%
         if (uiBean.isSinsaTyuiFlag()) { %>
           showGroup(<%= SINSATYUUIINFO %>);
         <% } %>

         <%
         if (uiBean.isFatcaTaisyouFlag()) { %>
           showGroup(<%= DISPFATCAINFO1 %>);
         <% }

         if (uiBean.isFatcaTaisyou1Flag()) { %>
           showGroup(<%= DISPFATCAINFO1 %>);
         <% }

         if (uiBean.isFatcaTaisyou2Flag()) { %>
           showGroup(<%= DISPFATCAINFO2 %>);
         <% }

         if (uiBean.isFatcaTaisyou3Flag()) { %>
           showGroup(<%= DISPFATCAINFO3 %>);
         <% }

         if (uiBean.isFatcaTaisyou4Flag()) { %>
           showGroup(<%= DISPFATCAINFO4 %>);
         <% }

         if (uiBean.isFatcaTaisyou5Flag()) { %>
           showGroup(<%= DISPFATCAINFO5 %>);
         <% } %>

  <% }  %>

  <%
     if (uiBean.isAllPrintFlg()) { %>
         if ($(<%=ALLHYOUJIBTN_BUTTONALLHYOUJI%>).is(':disabled') === false) {
             $(<%=ALLHYOUJIBTN_BUTTONALLHYOUJI%>).trigger("click");
         }
  <% } %>

});
//-->
</script>
