<%--
    sk_mos_syoukai.js.jsp - 申込状況照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.SkMosSyoukaiConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.SkMosSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.SkMosSyoukaiUiBean" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="yuyu.def.classification.C_PWaribikiKbn"%>
<%@page import="yuyu.def.classification.C_Nstkumu"%>
<%@page import="yuyu.def.classification.C_MosKbn"%>
<%@page import="yuyu.def.classification.C_KokusekiKbn"%>
<%@page import="yuyu.def.classification.C_SknnkaisikitkhukaKbn"%>
<%@page import="yuyu.def.classification.C_YouhiKbn"%>
<%@page import="yuyu.def.classification.C_ImusateirankKbn"%>
<%@page import="yuyu.def.classification.C_KetrankKbn"%>
<%@page import="yuyu.def.classification.C_SeirituKbn"%>
<%@page import="yuyu.def.classification.C_Tkhukaumu"%>
<%@page import="yuyu.def.classification.C_KykKbn"%>
<%@page import="yuyu.def.classification.C_TargetTkHukaKanouKbn"%>
<%@page import="jp.co.slcs.swak.number.BizCurrency"%>
<%@page import="jp.co.slcs.swak.number.BizNumber"%>
<%@page import="jp.co.slcs.swak.date.BizDate"%>
<%@page import="yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig" %>
<%@page import="yuyu.common.biz.bzcommon.BizDateUtil" %>
<%@page import="yuyu.def.classification.C_HknsyuruiNo"%>
<%@page import="yuyu.def.classification.C_Tuukasyu"%>
<%@page import="yuyu.def.classification.C_Hrkkaisuu"%>
<%@page import="yuyu.def.classification.C_PtratkituukasiteiKbn"%>
<%@page import="yuyu.def.classification.C_BlnktkumuKbn"%>
<% SkMosSyoukaiUiBean uiBean = SWAKInjector.getInstance(SkMosSyoukaiUiBean.class); %>
<% if (uiBean.getPageNo() == PAGENO_SYORUITOUTYAKUJK) { %>
<jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){

 <% if (uiBean.getPageNo() == PAGENO_HUBITRKINFO) { %>
     $(<%= DISPTRKYMD_LABEL%>).attr("rowspan",'5');
     $(<%= DISPSKHUBINAIYOU_LABEL%>).attr("colspan","1");
     $(<%= DISPSKSEIBISIJINAIYOU_LABEL %>).attr("colspan","1");
     $(<%= TYOUBUNDISPRENRAKUJIKOU_LABEL %>).attr("colspan","6");
     $(<%= DISPRENRAKUJIKOU_LABEL %>).attr("colspan","6");
     $(<%= DISPHASSINYMD_LABEL %>).attr("rowspan","3");
     $(<%= DISPKAISYOUYMD_LABEL %>).attr("rowspan","3");
     $(<%= DISPHASINKYOKAKBN_LABEL %>).attr("rowspan","3");
     $(<%= DISPHASSINSAKIKBN_LABEL %>).attr("rowspan","3");
     $(<%= DISPNYURYOKUTANTOUNM_LABEL %>).attr("rowspan","3");

     $(<%= DISPTRKYMD_DATA%>).attr("rowspan",'5');
     $(<%= DISPSKHUBINAIYOU_DATA%>).attr("colspan","1");
     $(<%= DISPSKSEIBISIJINAIYOU_DATA %>).attr("colspan","1");
     $(<%= TYOUBUNDISPRENRAKUJIKOU_DATA %>).attr("colspan","6");
     $(<%= DISPRENRAKUJIKOU_DATA %>).attr("colspan","6");
     $(<%= DISPHASSINYMD_DATA %>).attr("rowspan","3");
     $(<%= DISPKAISYOUYMD_DATA %>).attr("rowspan","3");
     $(<%= DISPHASINKYOKAKBN_DATA %>).attr("rowspan","3");
     $(<%= DISPHASSINSAKIKBN_DATA %>).attr("rowspan","3");
     $(<%= DISPNYURYOKUTANTOUNM_DATA %>).attr("rowspan","3");

    <% } %>
  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU ||
         uiBean.getPageNo() == PAGENO_HUBIJK ||
         uiBean.getPageNo() == PAGENO_HUBITRKINFO ||
         uiBean.getPageNo() == PAGENO_KETTEIJK ||
         uiBean.getPageNo() == PAGENO_NYUUKINJK ||
         uiBean.getPageNo() == PAGENO_SYORUITOUTYAKUJK ||
         uiBean.getPageNo() == PAGENO_TEISEIRRKLIST ||
         uiBean.getPageNo() == PAGENO_SAKUININFO ||
         uiBean.getPageNo() == PAGENO_KOUTEIJK) { %>

         <% if (C_UmuKbn.ARI.eq(uiBean.getKyksyoukaiKngnUmu())) { %>
         showGroup(<%=BUTTONKYKNAIYOUSYOUKAI%>);
         <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
   $(<%=KYKNAIYOUBTNBYKEIYAKUNAIYOU_PAGEBUTTONS1%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_HUBIJK) { %>
   $(<%=HUBIJYOUKYOUBTNBYHUBIJK_PAGEBUTTONS2%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_HUBITRKINFO) { %>
   $(<%=HBTRJHBTNBYHUBITRKINFO_PAGEBUTTONS3%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KETTEIJK) { %>
   $(<%=KETTEIJYOUKYOUBTNBYKETTEIJK_PAGEBUTTONS4%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_NYUUKINJK) { %>
   $(<%=NKJKBTNBYNYUUKINJK_PAGEBUTTONS5%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_SYORUITOUTYAKUJK) { %>
   $(<%=SRTTJKBTNBYSYORUITOUTYAKUJK_PAGEBUTTONS6%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_TEISEIRRKLIST) { %>
   $(<%=TSRRKBTNBYTEISEIRRKLIST_PAGEBUTTONS7%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_SAKUININFO) { %>
   $(<%=SKININFOBTNBYSKININFO_PAGEBUTTONS18%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KOUTEIJK) { %>
   $(<%=KOUTEIJKBTNBYKOUTEIJK_PAGEBUTTONS9%>).disable(true);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
   $(<%=BASEINFO_LABEL%>).text('<%= KEYSITEI %>');
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getSyokugyoukktumu())) { %>
       showKoumoku(<%=KKTYMD_HIHOKENSYAINFO%>);
      <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>

     <% if (uiBean.getSyudai1hknkkn() != null && uiBean.getSyudai1hknkkn() != 0) { %>
       showKoumoku(<%=SYUDAI1HKNKKN_SYUHOSYOUINFO%>);
     <% } %>

     <% if (C_UmuKbn.ARI.eq(uiBean.getGaikatatkiumu())) { %>
        showKoumoku(<%=KYKTUUKASYU_SYUHOSYOUINFO%>);
        showKoumoku(<%=HRKTUUKASYU_SYUHOSYOUINFO%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getTmttknhaibunwarisiteiumu())) { %>
        showKoumoku(<%=SISUUHAIBUNWARIKBN_SYUHOSYOUINFO%>);
        showKoumoku(<%=SISUUNM_SYUHOSYOUINFO%>);
        showKoumoku(<%=TEIRITUHAIBUNWARIKBN_SYUHOSYOUINFO%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) { %>
        showKoumoku(<%=SKNENKINSYU_SYUHOSYOUINFO%>);
        showKoumoku(<%=NKSHRSTARTNEN_SYUHOSYOUINFO%>);
        showKoumoku(<%=SUEOKIKKN_SYUHOSYOUINFO%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getZennouumu())) { %>
        showKoumoku(<%=ZENKIZENNOUUMU_SYUHOSYOUINFO%>);
        showKoumoku(<%=ZNNKAI_SYUHOSYOUINFO%>);
        showKoumoku(<%=ZENNOUP_SYUHOSYOUINFO2%>);
        showKoumoku(<%=MOSZENNOUPSYOKAIARI_SYUHOSYOUINFO2%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getHengakuumu())) { %>
        showKoumoku(<%=NKGNSHOSYOURITUKBN_SYUHOSYOUINFO%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getSyksbyensitihsyutktekiumu())) { %>
        showKoumoku(<%=SYKSBYENSITIHSYUTKHKKBN_SONOTATOKUYAKUINFO4%>)
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getJyudkaigomehrtktekiumu())) { %>
        showKoumoku(<%=JYUDKAIGOMEHRTKHKKBN_SONOTATOKUYAKUINFO4%>)
     <% } %>

     <% if (C_Nstkumu.ST_ARI.eq(uiBean.getNstkumu())) { %>
        showKoumoku(<%=NSTKHKKBN_SONOTATOKUYAKUINFO4%>);
        showKoumoku(<%=NSTKSBNKKN_SONOTATOKUYAKUINFO4%>);
     <% } %>

     <% if (!C_TargetTkHukaKanouKbn.NONE.eq(uiBean.getTargettkhukakanoukbn())) { %>
        showKoumoku(<%=TARGETTKMKHTKBN_SONOTATOKUYAKUINFO4%>);
        showKoumoku(<%=MKHYOUYENSYSNIKOUGK_SONOTATOKUYAKUINFO4%>);
        showKoumoku(<%=TARGETTKYKKIJYUNGK_SONOTATOKUYAKUINFO4%>);
        showKoumoku(<%=TARGETTKHKKBN_SONOTATOKUYAKUINFO4%>);
         $(<%=TARGETTKHKKBN_SONOTATOKUYAKUINFO4 + LABEL %>).html('<%= uiBean.getTargettkhukakanoukbn().getContent(C_TargetTkHukaKanouKbn.PATTERN_SKMOSSYOUKAI)%>');
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getGaikatatkiumu()) &&
         !uiBean.getKyktuukasyu().eq(uiBean.getHrktuukasyu())) { %>
         showKoumoku(<%=NYKNKWSRATEKIJYUNYMD_SYUHOSYOUINFO%>);
         showKoumoku(<%=NYKNKWSRATE_SYUHOSYOUINFO%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getSyksbyensitihsyutktekiumu()) ||
         C_UmuKbn.ARI.eq(uiBean.getJyudkaigomehrtktekiumu()) ||
         C_UmuKbn.ARI.eq(uiBean.getGaikatatkiumu()) ||
         C_Nstkumu.ST_ARI.eq(uiBean.getNstkumu()) ||
         !C_TargetTkHukaKanouKbn.NONE.eq(uiBean.getTargettkhukakanoukbn()) ||
         C_UmuKbn.ARI.eq(uiBean.getZeiseitekikakuumu()) ||
         (C_UmuKbn.ARI.eq(uiBean.getPyennykntktekiumu()) && !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()))||
         C_UmuKbn.ARI.eq(uiBean.getGaikanyuukintktekiumu()) ||
         C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getSeigyoHknsyuruino())) { %>
     showGroup(<%=SONOTATOKUYAKUINFO%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getZeiseitekikakuumu())) { %>
         showKoumoku(<%=KJNNKPZEITEKITKHUKAKBN_SONOTATOKUYAKUINFO4%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getPyennykntktekiumu()) && !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
         showKoumoku(<%=YENNYKNTKHKKBN_SONOTATOKUYAKUINFO2%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getGaikanyuukintktekiumu())) { %>
         showKoumoku(<%=GAIKANYKNTKHKKBN_SONOTATOKUYAKUINFO2%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
         showKoumoku(<%=PHARAIKOMISOUGAKU_SYUHOSYOUINFO2%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getTeikiikkatubaraiumu())) { %>
         showKoumoku(<%=IKKATUBARAIKAISUU_SYUHOSYOUINFO%>);
         showKoumoku(<%=IKKATUP_SYUHOSYOUINFO2%>);
         showKoumoku(<%=MOSIKKATUP_SYUHOSYOUINFO2%>);
     <% } %>
     <% if (!C_PWaribikiKbn.NONE.eq(uiBean.getPwaribikikbn())) { %>
         showKoumoku(<%=PWARIBIKITEKIYOUKBN_SYUHOSYOUINFO%>);
     <% } %>
     <% if (!BizUtil.isBlank(uiBean.getAitemosno())) { %>
         showKoumoku(<%=AITEMOSNO_BASEINFO%>);
     <% } %>

     // TODO 現状、未使用。 ガウディ（定期支払プラン）販売時に再度使用。
     <%--
     if (C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getSeigyoHknsyuruino())) { %>
        showGroup(<%=SONOTATOKUYAKUINFO3%>);
        $(<%=SONOTATOKUYAKUINFO4 + DIV%>).removeClass("nonMargin");
     <% } %> --%>

     <%
     if (C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(uiBean.getSeigyoHknsyuruino()) ||
         C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getSeigyoHknsyuruino()) ||
         C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(uiBean.getSeigyoHknsyuruino())) { %>
           showGroup(<%= KOUREISYAINFO %>);
           addTopBottomLink(<%= KOUREISYAINFO %>);
     <% } %>

     <%
     if (!C_Hrkkaisuu.ITIJI.eq(uiBean.getHrkkaisuu()) && !C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) { %>
         showKoumoku(<%=HHKNNENSYUUKBN_HIHOKENSYAINFO%>);
     <% } %>

     <%
     if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn()) &&
         !uiBean.getKyktuukasyu().eq(uiBean.getHrktuukasyu()) &&
         C_BlnktkumuKbn.NONE.eq(uiBean.getZenkizennouumu())) { %>
         showGroup(<%= PTUUTIINFO %>);
         addTopBottomLink(<%= PTUUTIINFO %>);
     <% } %>

     <%
       if (!uiBean.getSyup().isOptional() && !uiBean.getMossyup().isOptional()) { %>
          $(<%=SYUP_DATA%>).find("span").eq(3).before('<br/>');
     <%
       } else { %>
          <%
            if (!uiBean.getSyup().isOptional()) { %>
               $(<%=SYUP_DATA%>).find("span").eq(3).before('<br/>').before('<br/>');
            <%
            } else if (!uiBean.getMossyup().isOptional()) { %>
               $(<%=SYUP_DATA%>).find("span").eq(2).before('<br/>');
            <%
            } else { %>
               $(<%=SYUP_DATA%>).find("span").eq(2).before('<br/>').before('<br/>');
          <% } %>
     <% } %>

     <%
       if (!uiBean.getSyukihons().isOptional() && !uiBean.getSyumoskihons().isOptional()) { %>
          $(<%=SYUKIHONS_DATA%>).find("span").eq(3).before('<br/>');
     <%
       } else { %>
          <%
            if (!uiBean.getSyukihons().isOptional()) { %>
               $(<%=SYUKIHONS_DATA%>).find("span").eq(3).before('<br/>').before('<br/>');
            <%
            } else if (!uiBean.getSyumoskihons().isOptional()) { %>
                 $(<%=SYUKIHONS_DATA%>).find("span").eq(2).before('<br/>');
            <%
            } else { %>
                $(<%=SYUKIHONS_DATA%>).find("span").eq(2).before('<br/>').before('<br/>');
          <% } %>
     <% } %>

     <%
       if (!uiBean.getZennoup().isOptional() && !uiBean.getZennouphrkgk().isOptional()) { %>
          $(<%=ZENNOUP_DATA%>).find("span").eq(3).before('<br/>');
     <%
       } else { %>
          <%
            if (!uiBean.getZennoup().isOptional()) { %>
               $(<%=ZENNOUP_DATA%>).find("span").eq(3).before('<br/>').before('<br/>');
            <%
            } else if (!uiBean.getZennouphrkgk().isOptional()) { %>
                $(<%=ZENNOUP_DATA%>).find("span").eq(2).before('<br/>');
            <%
            } else { %>
                $(<%=ZENNOUP_DATA%>).find("span").eq(2).before('<br/>').before('<br/>');
          <% } %>
     <% } %>

    <%
     if (!C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn())) { %>
        $(<%=SYUP_SYUHOSYOUINFO + PREFIX%>).visible(false);
     <% } %>

     <%
      if (!C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(uiBean.getSeigyoHknsyuruino()) &&
          !C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(uiBean.getSeigyoHknsyuruino()) ) { %>
          $(<%=HRKTUUKASYUKYKP_SYUHOSYOUINFO + PREFIX%>).visible(false);
     <% } %>

  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
     <%
     if (C_UmuKbn.ARI.eq(uiBean.getCreditcardhrtekiumu())) { %>
        $(<%= CREDITBTN_LINKBUTTONS2%>).visible(true);
        showGroup(<%=CREDITCARDINFO%>);
        addTopBottomLink(<%= CREDITCARDINFO %>);
     <%
     } else { %>
        $(<%= CREDITBTN_LINKBUTTONS2%>).visible(false);
     <% } %>
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
     <% if (!BizUtil.isBlank(uiBean.getTrkkzknmkn2())) { %>
       showGroup(<%=KZKTOUROKUSERVICEINFO2%>);
       addTopBottomLink(<%= KZKTOUROKUSERVICEINFO2 %>);
     <%
     } else { %>
       addTopBottomLink(<%= KZKTOUROKUSERVICEINFO1 %>);
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getNkuktumu())) { %>
      showGroup(<%=NKHOKENKINUKETORINININFO%>);
      addTopBottomLink(<%= NKHOKENKINUKETORINININFO %>);
      <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>

     <% if (C_UmuKbn.ARI.eq(uiBean.getSbuktumu())) { %>
     showGroup(<%=SBHOKENKINUKETORINININFO%>);
     showGroup(<%=SBHOKENKINUKETORINININFO1%>);
         <% if (uiBean.getSbuUktSyurenNo2() != null) { %>
         showGroup(<%=SBHOKENKINUKETORINININFO2%>);
         <% } %>
         <% if (uiBean.getSbuUktSyurenNo3() != null) { %>
         showGroup(<%=SBHOKENKINUKETORINININFO3%>);
         <% } %>
         <% if (uiBean.getSbuUktSyurenNo4() != null) { %>
         showGroup(<%=SBHOKENKINUKETORINININFO4%>);
         <% } %>
         varElmAddTopBottomLink([
             <%= SBHOKENKINUKETORINININFO %>,
             <%= SBHOKENKINUKETORINININFO1 %>,
             <%= SBHOKENKINUKETORINININFO2 %>,
             <%= SBHOKENKINUKETORINININFO3 %>,
             <%= SBHOKENKINUKETORINININFO4 %>
         ]);
     <% } %>

  <% } %>

  <% if (C_UmuKbn.ARI.eq(uiBean.getKouzahurikaebaraitekiumu())) { %>
          showGroup(<%=KOUFURIKOUZAINFO%>);

          <%
          if (BizDateUtil.compareYmd(BizDate.getSysDate(),
              YuyuSinkeiyakuConfig.getInstance().getNetkouhuriServiceKaisiYmd()) == BizDateUtil.COMPARE_GREATER ||
              BizDateUtil.compareYmd(BizDate.getSysDate(),
                  YuyuSinkeiyakuConfig.getInstance().getNetkouhuriServiceKaisiYmd()) == BizDateUtil.COMPARE_EQUAL) {%>
                  showKoumoku(<%=KZHURITOUROKUHOUKBN_KOUFURIKOUZAINFO%>);
            <% } %>

          $(<%= KZJOUHOUBTN_LINKBUTTONS2%>).visible(true);
          addTopBottomLink(<%= KOUFURIKOUZAINFO %>);
  <% } else { %>
          $(<%= KZJOUHOUBTN_LINKBUTTONS2%>).visible(false);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
     showGroup(<%=DAIRITENINFOA%>);

     <% if (uiBean.getMosDairitenRenno2() != null) { %>
     showGroup(<%=DAIRITENINFOB%>);
        <% if (uiBean.getDispbunwari1().compareTo(BizNumber.valueOf(0)) == 0 &&
            uiBean.getDispbunwari2().compareTo(BizNumber.valueOf(0)) == 0)  { %>
            $(<%=DISPBUNWARI1_DAIRITENINFOA%>).text("");
            $(<%=DISPBUNWARI2_DAIRITENINFOB%>).text("");
            $(<%=DISPBUNWARI1_UNIT%>).text("");
            $(<%=DISPBUNWARI2_UNIT%>).text("");
        <% } %>
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_HUBIJK) { %>
     <% if (uiBean.getSkToriatukaiTyuuiInfoDataSource().getAllData().size() != 0) { %>
     showGroup(<%=SKTORIATUKAITYUUIINFO%>);
     <% } %>
     <% if (uiBean.getSonotaTyuuiInfoDataSource().getAllData().size() != 0) { %>
     showGroup(<%=SONOTATYUUIINFO%>);
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_HUBIJK) { %>
     <% if (uiBean.getKetteiHoryuuHubiDataSource().getAllData().size() != 0) { %>
       showGroup(<%=KETTEIHORYUUHUBI%>);
       <% for(int i = 0; i < uiBean.getKetteiHoryuuHubiDataSource().getAllData().size(); i++ ){ %>
       dispMessageIcon(<%= DISPHUBIMSGID_KETTEIHORYUUHUBI(i) %>, <%= MSGSYUBETU_KETTEIHORYUUHUBI(i) %>);
       <% } %>
     <% } %>

     <% if (uiBean.getSeirituHoryuuHubiDataSource().getAllData().size() != 0) { %>
       showGroup(<%=SEIRITUHORYUUHUBI%>);
       <% for(int i = 0; i < uiBean.getSeirituHoryuuHubiDataSource().getAllData().size(); i++ ){ %>
       dispMessageIcon(<%= DISPHUBIMSGID_SEIRITUHORYUUHUBI(i) %>, <%= MSGSYUBETU_SEIRITUHORYUUHUBI(i) %>);
       <% } %>
     <% } %>

     <% if (uiBean.getWarningDataSource().getAllData().size() != 0) { %>
       showGroup(<%=WARNING%>);
       <% for(int i = 0; i < uiBean.getWarningDataSource().getAllData().size(); i++ ){ %>
       dispMessageIcon(<%= DISPHUBIMSGID_WARNING(i) %>, <%= MSGSYUBETU_WARNING(i) %>);
       <% } %>
     <% } %>

     <% if (uiBean.getKihonHubiDataSource().getAllData().size() != 0) { %>
       showGroup(<%=KIHONHUBI%>);
       <% for(int i = 0; i < uiBean.getKihonHubiDataSource().getAllData().size(); i++ ){ %>
       dispMessageIcon(<%= DISPHUBIMSGID_KIHONHUBI(i) %>, <%= MSGSYUBETU_KIHONHUBI(i) %>);
       <% } %>
     <% } %>

     $(".msgsyubetu_data").text("");
  <% } %>

      <% if (uiBean.getPageNo() == PAGENO_HUBITRKINFO) { %>
         <% if (!BizUtil.isBlank(uiBean.getCommentareagamen())) { %>
         showGroup(<%=COMMENT%>);
         <% } %>
      <% } %>

  <% if(uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU){ %>
      var linkList = {
          <%= STYJKBTN_LINKBUTTONS1 %>         : <%= SINTYOKUJOUKYOU + LABEL %>,
          <%= KIHONJOUHOUBTN_LINKBUTTONS1 %>   : <%= BASEINFO + LABEL %>,
          <%= KEIYAKUSYAJOUHOUBTN_LINKBUTTONS1 %>   : <%= KEIYAKUSYAINFO + LABEL %>,
          <%= TUSINSAKIJOUHOUBTN_LINKBUTTONS1 %>    : <%= TUUSINSAKIINFO + LABEL %>,
          <%= HIHOKENSYAJOUHOUBTN_LINKBUTTONS1 %>   : <%= HIHOKENSYAINFO + LABEL %>,
          <%= KZKTOUROKUBTN_LINKBUTTONS2 %>   : <%= KZKTOUROKUSERVICEINFO + LABEL %>,
          <%= HOSYOUINFOBTN_LINKBUTTONS1 %>   : <%= SYUHOSYOUINFO + LABEL %>,
          <% if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) { %>
              <%= UKETORININBTN_LINKBUTTONS1 %>      : <%= NKHOKENKINUKETORINININFO + LABEL %>,
          <% } else if (C_UmuKbn.ARI.eq(uiBean.getSbuktumu())) { %>
              <%= UKETORININBTN_LINKBUTTONS1 %>      : <%= SBHOKENKINUKETORINININFO + LABEL %>,
          <% } %>
          <%= KZJOUHOUBTN_LINKBUTTONS2 %>   : <%= KOUFURIKOUZAINFO + LABEL %>,
          <%= KYKDAIRININBTN_LINKBUTTONS2 %>   : <%= KYKDRTKYKINFO + LABEL %>,
          <%= SITEIDAIRININBTN_LINKBUTTONS2 %>   : <%= STDRSKTKUINFO + LABEL %>,
          <%
             if (C_UmuKbn.ARI.eq(uiBean.getCreditcardhrtekiumu())) { %>
              <%= CREDITBTN_LINKBUTTONS2 %>   : <%= CREDITCARDINFO + LABEL %>,
          <% } %>
          <%= DAIRITENJOUHOUBTN_LINKBUTTONS2 %>   : <%= DAIRITENINFO + LABEL %>,
      };

      for(btnId in linkList){
          $(document).on('click', btnId, function(){
              var thisId = $(this).attr('id');
              gotoTarget(linkList['#' + thisId]);
          });
      }
  <% } %>

  <% if(uiBean.getPageNo() == PAGENO_KOUTEIJK){ %>
        showList(<%=KOUTEIJYOUKYOUBASEINFO%>);

  <% } %>


  addBottomLink(<%= LINKBUTTONS2 %>);

  addTopBottomLink(<%= BASEINFO1 %>);

  addTopBottomLink(<%= KEIYAKUSYAINFO %>);

  addTopBottomLink(<%= TUUSINSAKIINFO %>);

  addTopBottomLink(<%= HIHOKENSYAINFO %>);

  addTopBottomLink(<%= SYUHOSYOUINFO2 %>);

  <% if (C_UmuKbn.ARI.eq(uiBean.getSyksbyensitihsyutktekiumu()) ||
         C_UmuKbn.ARI.eq(uiBean.getJyudkaigomehrtktekiumu()) ||
         C_UmuKbn.ARI.eq(uiBean.getGaikatatkiumu()) ||
         C_Nstkumu.ST_ARI.eq(uiBean.getNstkumu()) ||
         !C_TargetTkHukaKanouKbn.NONE.eq(uiBean.getTargettkhukakanoukbn()) ||
         C_UmuKbn.ARI.eq(uiBean.getZeiseitekikakuumu()) ||
         (C_UmuKbn.ARI.eq(uiBean.getPyennykntktekiumu()) && !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) ||
         C_UmuKbn.ARI.eq(uiBean.getGaikanyuukintktekiumu()) ||
         C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getSeigyoHknsyuruino())) { %>
     addTopBottomLink(<%= SONOTATOKUYAKUINFO2 %>);
  <% } %>

  addTopBottomLink(<%= KYKDRTKYKINFO %>);

  addTopBottomLink(<%= STDRSKTKUINFO %>);

  addTopBottomLink(<%= HONNINKAKUNININFO %>);

  varElmAddTopBottomLink([
      <%= DAIRITENINFO %>,
      <%= DAIRITENINFOA %>,
      <%= DAIRITENINFOB %>
  ]);

  addTopBottomLink(<%=KOUSEIINKYKINFO%>);

  addTopBottomLink(<%=KOUKANKYKINFO%>);

  addTopBottomLink(<%= TOKUBETUKOUMOKUCD %>);

  addTopBottomLink(<%= DSKAIYAKUSOUKINYOUKOUZA %>);

  addTopBottomLink(<%= SONOTAINFO %>);

  <% if (uiBean.getPageNo() == PAGENO_HUBIJK) { %>
     <% if (C_YouhiKbn.YOU.eq(uiBean.getSkeittdkkinkyuyouhikbn())) { %>
        $('.skeittdkkinkyuyouhikbn_data').children("#IHF0053").visible(true);
     <% } %>
     <% if (C_YouhiKbn.YOU.eq(uiBean.getSkeittdktyuuiyouhikbn())) { %>
        $('.skeittdktyuuiyouhikbn_data').children("#IHF0053").visible(true);
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KETTEIJK) { %>

     showGroup(<%=MOUSHIKOMITENKENRIREKI1%>);

     <% if (uiBean.getMostenkenRirekiNo2() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI2%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo3() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI3%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo4() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI4%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo5() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI5%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo6() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI6%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo7() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI7%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo8() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI8%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo9() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI9%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo10() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI10%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo11() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI11%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo12() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI12%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo13() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI13%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo14() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI14%>);
     <% } %>
     <% if (uiBean.getMostenkenRirekiNo15() != null) { %>
        showGroup(<%=MOUSHIKOMITENKENRIREKI15%>);
     <% } %>

     varElmAddTopBottomLink([
          <%= MOUSHIKOMITENKENRIREKI1 %>,
          <%= MOUSHIKOMITENKENRIREKI2 %>,
          <%= MOUSHIKOMITENKENRIREKI3 %>,
          <%= MOUSHIKOMITENKENRIREKI4 %>,
          <%= MOUSHIKOMITENKENRIREKI5 %>,
          <%= MOUSHIKOMITENKENRIREKI6 %>,
          <%= MOUSHIKOMITENKENRIREKI7 %>,
          <%= MOUSHIKOMITENKENRIREKI8 %>,
          <%= MOUSHIKOMITENKENRIREKI9 %>,
          <%= MOUSHIKOMITENKENRIREKI10 %>,
          <%= MOUSHIKOMITENKENRIREKI11 %>,
          <%= MOUSHIKOMITENKENRIREKI12 %>,
          <%= MOUSHIKOMITENKENRIREKI13 %>,
          <%= MOUSHIKOMITENKENRIREKI14 %>,
          <%= MOUSHIKOMITENKENRIREKI15 %>
      ]);

     showGroup(<%=KANKYOUSATEIRIREKI1%>);

     <% if (uiBean.getKankyouSateiRirekiNo2() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI2%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo3() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI3%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo4() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI4%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo5() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI5%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo6() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI6%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo7() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI7%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo8() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI8%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo9() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI9%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo10() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI10%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo11() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI11%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo12() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI12%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo13() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI13%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo14() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI14%>);
     <% } %>
     <% if (uiBean.getKankyouSateiRirekiNo15() != null) { %>
        showGroup(<%=KANKYOUSATEIRIREKI15%>);
     <% } %>

     varElmAddTopBottomLink([
          <%= KANKYOUSATEIRIREKI1 %>,
          <%= KANKYOUSATEIRIREKI2 %>,
          <%= KANKYOUSATEIRIREKI3 %>,
          <%= KANKYOUSATEIRIREKI4 %>,
          <%= KANKYOUSATEIRIREKI5 %>,
          <%= KANKYOUSATEIRIREKI6 %>,
          <%= KANKYOUSATEIRIREKI7 %>,
          <%= KANKYOUSATEIRIREKI8 %>,
          <%= KANKYOUSATEIRIREKI9 %>,
          <%= KANKYOUSATEIRIREKI10 %>,
          <%= KANKYOUSATEIRIREKI11 %>,
          <%= KANKYOUSATEIRIREKI12 %>,
          <%= KANKYOUSATEIRIREKI13 %>,
          <%= KANKYOUSATEIRIREKI14 %>,
          <%= KANKYOUSATEIRIREKI15 %>
      ]);

     showGroup(<%=IMUSATEIRIREKI1%>);

     <% if (uiBean.getImuSateiRenban2() != null) { %>
        showGroup(<%=IMUSATEIRIREKI2%>);
     <% } %>
     <% if (uiBean.getImuSateiRenban3() != null) { %>
        showGroup(<%=IMUSATEIRIREKI3%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban4() != null) { %>
        showGroup(<%=IMUSATEIRIREKI4%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban5() != null) { %>
        showGroup(<%=IMUSATEIRIREKI5%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban6() != null) { %>
        showGroup(<%=IMUSATEIRIREKI6%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban7() != null) { %>
        showGroup(<%=IMUSATEIRIREKI7%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban8() != null) { %>
        showGroup(<%=IMUSATEIRIREKI8%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban9() != null) { %>
        showGroup(<%=IMUSATEIRIREKI9%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban10() != null) { %>
        showGroup(<%=IMUSATEIRIREKI10%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban11() != null) { %>
        showGroup(<%=IMUSATEIRIREKI11%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban12() != null) { %>
        showGroup(<%=IMUSATEIRIREKI12%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban13() != null) { %>
        showGroup(<%=IMUSATEIRIREKI13%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban14() != null) { %>
        showGroup(<%=IMUSATEIRIREKI14%>);
     <% } %>

     <% if (uiBean.getImuSateiRenban15() != null) { %>
        showGroup(<%=IMUSATEIRIREKI15%>);
     <% } %>

      varElmAddTopBottomLinkForImusateiAndDakuhi([
          <%= IMUSATEIRIREKI1 %>,
          <%= IMUSATEIRIREKI2 %>,
          <%= IMUSATEIRIREKI3 %>,
          <%= IMUSATEIRIREKI4 %>,
          <%= IMUSATEIRIREKI5 %>,
          <%= IMUSATEIRIREKI6 %>,
          <%= IMUSATEIRIREKI7 %>,
          <%= IMUSATEIRIREKI8 %>,
          <%= IMUSATEIRIREKI9 %>,
          <%= IMUSATEIRIREKI10 %>,
          <%= IMUSATEIRIREKI11 %>,
          <%= IMUSATEIRIREKI12 %>,
          <%= IMUSATEIRIREKI13 %>,
          <%= IMUSATEIRIREKI14 %>,
          <%= IMUSATEIRIREKI15 %>
      ]);

      showGroup(<%=DAKUHIKETTEIRIREKI1%>);

     <% if (uiBean.getDisprenno2() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI2%>);
     <% } %>

     <% if (uiBean.getDisprenno3() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI3%>);
     <% } %>

     <% if (uiBean.getDisprenno4() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI4%>);
     <% } %>

     <% if (uiBean.getDisprenno5() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI5%>);
     <% } %>

     <% if (uiBean.getDisprenno6() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI6%>);
     <% } %>

     <% if (uiBean.getDisprenno7() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI7%>);
     <% } %>

     <% if (uiBean.getDisprenno8() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI8%>);
     <% } %>

     <% if (uiBean.getDisprenno9() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI9%>);
     <% } %>

     <% if (uiBean.getDisprenno10() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI10%>);
     <% } %>

     <% if (uiBean.getDisprenno11() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI11%>);
     <% } %>

     <% if (uiBean.getDisprenno12() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI12%>);
     <% } %>

     <% if (uiBean.getDisprenno13() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI13%>);
     <% } %>

     <% if (uiBean.getDisprenno14() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI14%>);
     <% } %>

     <% if (uiBean.getDisprenno15() != null) { %>
        showGroup(<%=DAKUHIKETTEIRIREKI15%>);
     <% } %>

      varElmAddTopBottomLinkForImusateiAndDakuhi([
          <%= DAKUHIKETTEIRIREKI1 %>,
          <%= DAKUHIKETTEIRIREKI2 %>,
          <%= DAKUHIKETTEIRIREKI3 %>,
          <%= DAKUHIKETTEIRIREKI4 %>,
          <%= DAKUHIKETTEIRIREKI5 %>,
          <%= DAKUHIKETTEIRIREKI6 %>,
          <%= DAKUHIKETTEIRIREKI7 %>,
          <%= DAKUHIKETTEIRIREKI8 %>,
          <%= DAKUHIKETTEIRIREKI9 %>,
          <%= DAKUHIKETTEIRIREKI10 %>,
          <%= DAKUHIKETTEIRIREKI11 %>,
          <%= DAKUHIKETTEIRIREKI12 %>,
          <%= DAKUHIKETTEIRIREKI13 %>,
          <%= DAKUHIKETTEIRIREKI14 %>,
          <%= DAKUHIKETTEIRIREKI15 %>
      ]);

      var linkList = {
          <%= KKTJOUHOUBTN_LINKBUTTONS4 %>       : <%= KOKUTIINFO + LABEL %>,
          <%= MOSTENKENRRKBTN_LINKBUTTONS4 %>    : <%= MOUSHIKOMITENKENRIREKI + LABEL %>,
          <%= KNKSATEIRIREKIBTN_LINKBUTTONS4 %>  : <%= KANKYOUSATEIRIREKI + LABEL %>,
          <%= IMUSATEIRIREKIBTN_LINKBUTTONS4 %>  : <%= IMUSATEIRIREKI + LABEL %>,
          <%= DAKUHIKTRIREKIBTN_LINKBUTTONS4 %>  : <%= DAKUHIKETTEIRIREKI1 + LABEL %>,
      };

      for(btnId in linkList){
          $(document).on('click', btnId, function(){
              var thisId = $(this).attr('id');
              gotoTarget(linkList['#' + thisId]);
          });
      }
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_NYUUKINJK) { %>
     <% if (!C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu())) { %>
          showKoumoku(<%=FSTPRYOSYUYMD_NYUUKINJYOUKYOUBASEINFO%>);
          showKoumoku(<%=DENKAWASERATE_NYUUKINJYOUKYOUBASEINFO%>);
     <% } %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getZennoumousideumu())) { %>
          showKoumoku(<%=DISPZENKIZENNOUUMU_NYUUKINJYOUKYOUBASEINFO%>);
          showKoumoku(<%=DISPZNNKAI_NYUUKINJYOUKYOUBASEINFO%>);
     <% } %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
          showKoumoku(<%=HITUYOUIKKATUP_NYUUKINJYOUKYOUBASEINFO%>);
          showKoumoku(<%=HUSOKUIKKATUP_NYUUKINJYOUKYOUBASEINFO%>);
          showKoumoku(<%=IKKATUYOUPKAISUU_NYUUKINJYOUKYOUBASEINFO%>);
          showKoumoku(<%=GENZAIIKKATUKAISUU_NYUUKINJYOUKYOUBASEINFO%>);
     <% } %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getTeikiikkatubaraiumu())) { %>
        showKoumoku(<%=DISPTEIKIIKKATUBARAIKAISUU_NYUUKINJYOUKYOUBASEINFO%>);
     <% } %>

     <%
     if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn()) &&
         !uiBean.getKyktuukasyu().eq(uiBean.getHrktuukasyu())) { %>
        showKoumoku(<%=FSTPHRKGKHRKTUUKA_NYUUKINJYOUKYOUBASEINFO%>);
        showKoumoku(<%=NYKNKWSRATETKYYMD_NYUUKINJYOUKYOUBASEINFO%>);
        showKoumoku(<%=NYKNKWSRATE2_NYUUKINJYOUKYOUBASEINFO%>);
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_SYORUITOUTYAKUJK) { %>
     <% if (uiBean.getSyoruiInfoListDataSource().getAllData().size() != 0) { %>
          showGroup(<%=SYORUIINFOLIST%>);
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_SAKUININFO) { %>
     <% if (uiBean.getKykSakuinInfoDataSource().getAllData().size() != 0) { %>
          showGroup(<%=KYKSAKUININFO%>);
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_SAKUININFO) { %>
     <% if (C_KykKbn.KEIHI_BETU.eq(uiBean.getKykkbn())) { %>
          showGroup(<%=HIHOKENSYA%>);
     <% } %>
     <% if (uiBean.getHhknSakuinInfoDataSource().getAllData().size() != 0) { %>
          showGroup(<%=HHKNSAKUININFO%>);
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_HUBITRKINFO) { %>
     <% for (int i = 0; i < uiBean.getHubiItiranDataSource().getAllData().size(); i++) { %>
          <% if (C_UmuKbn.ARI.eq(uiBean.getHubiItiranDataSource().getAllData().get(i).getTyoubunFlg())) { %>
          $(<%=TYOUBUNDISPRENRAKUJIKOU_HUBIITIRAN(i)%>).parent().visible(true);
          <% } else { %>
          $(<%=DISPRENRAKUJIKOU_HUBIITIRAN(i)%>).parent().visible(true);
          <% } %>
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
     <% if (C_UmuKbn.ARI.eq(uiBean.getKykdrtentuusanumu())) { %>
         showKoumoku(<%=TKHSYOURYAKUUMUKBN_SONOTAINFO%>);
     <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_HUBIJK ||
         uiBean.getPageNo() == PAGENO_HUBITRKINFO ||
         uiBean.getPageNo() == PAGENO_KETTEIJK ||
         uiBean.getPageNo() == PAGENO_NYUUKINJK ||
         uiBean.getPageNo() == PAGENO_SYORUITOUTYAKUJK ||
         uiBean.getPageNo() == PAGENO_TEISEIRRKLIST ||
         uiBean.getPageNo() == PAGENO_SAKUININFO ||
         uiBean.getPageNo() == PAGENO_KOUTEIJK ) { %>
         $(<%=MOSNO_BASEINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","5");
  <% } %>

    <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
          showKoumoku(<%=SYONO_BASEINFO%>);
    <% } %>

 <% if (uiBean.getPageNo() == PAGENO_KENSAKURESULT) { %>
     $(<%= ROWSPAN4_CLASS%>).attr("rowspan",'4');
     $(<%= ROWSPAN2_CLASS%>).attr("rowspan",'2');
     $(<%= COLSPAN1CLASS%>).attr("colspan",'1');
 <% } %>

function dispMessageIcon(msgId, target) {
    if($(msgId).text().substring(0, 1) == "I") {
        $(target).parent().addClass("infIcon");

    } else if($(msgId).text().substring(0, 1) == "W") {
        $(target).parent().addClass("warIcon");

    } else if($(msgId).text().substring(0, 1) == "E") {
        if($(msgId).text().substring(2, 3) == "V") {
            $(target).parent().addClass("valIcon");

        } else {
            $(target).parent().addClass("errIcon");
        }

    } else if($(msgId).text().substring(0, 1) == "T") {
        $(target).parent().addClass("tokuninIcon");

    } else if($(msgId).text().substring(0, 1) == "K") {
        $(target).parent().addClass("tokuninkanouIcon");

    } else if($(msgId).text().substring(0, 1) == "Q") {
        $(target).parent().addClass("inqIcon");
    }
}

  function varElmAddTopBottomLink(idSelecterList){
      var groupSelecter = idSelecterList.join(',');
      var targetId = $(groupSelecter).filter(':visible').last().attr('id');
      addTopBottomLink('#' + targetId);
  }

  function varElmAddTopBottomLinkForImusateiAndDakuhi(idSelecterList){
      var groupSelecter = idSelecterList.join(',');
      var targetId = $(groupSelecter).last().attr('id');
      addTopBottomLink('#' + targetId);
  }

});
//-->
</script>
