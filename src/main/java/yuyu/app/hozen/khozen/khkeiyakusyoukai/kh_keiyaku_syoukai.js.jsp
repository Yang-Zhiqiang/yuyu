<%--
    kh_keiyaku_syoukai.js.jsp - 契約内容照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkeiyakusyoukai.KhKeiyakuSyoukaiConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkeiyakusyoukai.KhKeiyakuSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khkeiyakusyoukai.KhKeiyakuSyoukaiUiBean" %>
<%@page import="yuyu.common.hozen.khcommon.IKhozenCommonConstants"%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="yuyu.def.classification.C_SaitaiknkflagKbn"%>
<%@page import="yuyu.def.classification.C_Syorikeiyu"%>
<%@page import="yuyu.def.classification.C_FatcakekKbn"%>
<%@page import="yuyu.def.classification.C_KktyuitaKbn"%>
<%@page import="yuyu.def.classification.C_StknsetKbn"%>
<%@page import="yuyu.def.classification.C_Meigihnkjiyuu"%>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn"%>
<%@page import="yuyu.def.classification.C_DrtensikibetuKbn"%>
<%@page import="yuyu.def.classification.C_ShrhousiteiKbn"%>
<%@page import="yuyu.def.classification.C_KouzasyuruiKbn"%>
<%@page import="yuyu.def.classification.C_SyoriKbn"%>
<%@page import="yuyu.def.classification.C_UktKbn"%>
<%@page import="yuyu.def.classification.C_KyktrksKbn"%>
<%@page import="yuyu.def.classification.C_YuukousyoumetuKbn"%>
<%@page import="yuyu.def.classification.C_Tuukasyu"%>
<%@page import="yuyu.def.classification.C_Hrkkeiro"%>
<%@page import="jp.co.slcs.swak.number.BizCurrency"%>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<%@page import="jp.co.slcs.swak.number.BizNumber"%>
<%@page import="yuyu.def.classification.C_HaitoukinuketorihouKbn"%>
<%@page import="yuyu.def.classification.C_DispKbn"%>
<%@page import="yuyu.def.classification.C_KahiKbn"%>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil"%>
<%@page import="yuyu.def.classification.C_Kykjyoutai"%>
<% KhKeiyakuSyoukaiUiBean uiBean = SWAKInjector.getInstance(KhKeiyakuSyoukaiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
    <% commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.SYOUKAI);%>

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
        page="/WEB-INF/pages/appcommon/hozen/khview/viewnkukt/view_nkukt.js.jsp" />

    <jsp:include
        page="/WEB-INF/pages/appcommon/hozen/khview/viewkeizokunkukt/view_keizoku_nkukt.js.jsp" />

    <jsp:include
        page="/WEB-INF/pages/appcommon/hozen/khview/viewsbhenkanukt/view_sb_henkanukt.js.jsp" />

    <jsp:include
        page="/WEB-INF/pages/appcommon/hozen/khview/viewsbhkukt/view_sb_hkukt.js.jsp" />

    <jsp:include
        page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp" />

    <jsp:include
        page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp" />

    <jsp:include
        page="/WEB-INF/pages/appcommon/hozen/khview/viewsiteiseikyuu/view_siteiseikyuu.js.jsp" />

    <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp" />

    <jsp:include
      page="/WEB-INF/pages/appcommon/hozen/khview/viewkhtkshrsiharaikouza/view_kh_tkshr_siharai_kouza.js.jsp" />

<% } %>
<% if (uiBean.getPageNo() == PAGENO_TTDKSYOUSAI) { %>

     <% if ((C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()) &&
         !uiBean.getShrgkgoukeikakunin().isOptional()
         && uiBean.getShrgkgoukeikakunin().compareTo(
             BizCurrency.valueOf(0, uiBean.getShrgkgoukeikakunin().getType())) > 0) ||
             (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) &&
                 !uiBean.getJpyshrgkgoukeikakunin().isOptional()
                 && uiBean.getJpyshrgkgoukeikakunin().compareTo(
                     BizCurrency.valueOf(0, uiBean.getJpyshrgkgoukeikakunin().getType())) > 0) ||
                     (!uiBean.getNykntuukashrgkgoukeikakunin().isOptional()
                         && uiBean.getNykntuukashrgkgoukeikakunin().compareTo(
                             BizCurrency.valueOf(0, uiBean.getNykntuukashrgkgoukeikakunin().getType())) > 0) ||
                             (!uiBean.getHenkank().isOptional() && uiBean.getHenkank().compareTo(
                                     BizCurrency.valueOf(0, uiBean.getHenkank().getType())) > 0)) {%>
      <jsp:include
             page="/WEB-INF/pages/appcommon/hozen/khview/viewkouzainfo/view_kouza_info.js.jsp" />
     <% } %>
    <jsp:include
      page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp" />

    <jsp:include
      page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp" />

<% } %>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_TTDKSYOUSAI) { %>

     $(<%= ROWSPAN6_CLASS %>).attr("rowspan","6");
     $(<%= ROWSPAN2_CLASS %>).attr("rowspan","2");
     $(<%= ROWSPAN4_CLASS %>).attr("rowspan","4");

     <% if (C_UmuKbn.ARI.eq(uiBean.getShrSyousaiUmu())) { %>

       <% if (C_HyoujiptnKbn.KAIYAKU.eq(uiBean.getKinouHyoujiptnKbn()) ||
               C_HyoujiptnKbn.PMNYSYMET_JDSKN_SSNZM.eq(uiBean.getKinouHyoujiptnKbn()) ||
               C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
               C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
               C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
          <% if (C_UmuKbn.ARI.eq(uiBean.getShrnaiyouumu())) { %>
             showGroup(<%=SIHARAINAIYOUINFO%>);
          <% }%>

          <% if (C_HyoujiptnKbn.KAIYAKU.eq(uiBean.getKinouHyoujiptnKbn()) ||
                 C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
               showGroup(<%=SHRNAIYOUSYORUIUKEINFO%>);
               $(<%=SIHARAINAIYOUINFO + LABEL%>).parent().parent().visible(false);
          <% }%>

          <% if (C_UmuKbn.ARI.eq(uiBean.getShrnaiyouumu())) { %>
              <% if (C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu())) { %>
                  showGroup(<%=SHRGKKEIINFO%>);

                  showKoumoku(<%=YENDTHNKKAIYAKUHR_SHRGKKEIINFO%>);

                  <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=YENDTHNKMIKEIKAP_SHRGKKEIINFO%>);
                    showKoumoku(<%=YENDTHNKZENNOUSEISANKIN_SHRGKKEIINFO%>);
                    <% if (!C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                          showKoumoku(<%=YENDTHNKKRKGK_SHRGKKEIINFO%>);
                    <% }%>
                  <% }%>

                  <% if (!C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                    showKoumoku(<%=YENDTHNKHAITOUKIN_SHRGKKEIINFO%>);
                    showKoumoku(<%=YENDTHNKTKBTHAITOUKIN_SHRGKKEIINFO%>);
                  <% }%>

                  $(<%= YENDTHNKSHRGKGOUKEI_SHRGKKEIINFO + LABEL%>).parent().attr("rowspan","11");
                  $(<%= YENDTHNKSHRGKGOUKEI_SHRGKKEIINFO%>).parent().attr("rowspan","11");

                  <% if ((C_HyoujiptnKbn.KAIYAKU.eq(uiBean.getKinouHyoujiptnKbn()) || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) &&
                      C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                      showKoumoku(<%=SONOTASEISAN_SHRGKKEIINFO%>);
                  <% } %>

                  <% if ((C_HyoujiptnKbn.KAIYAKU.eq(uiBean.getKinouHyoujiptnKbn()) || C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) &&
                      C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                      showKoumoku(<%=YENDTHNKGSTSZEIGK_SHRGKKEIINFO%>);
                  <% } %>

                  <% if(!C_HyoujiptnKbn.PMNYSYMET_JDSKN_SSNZM.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                       showKoumoku(<%=DISPYENDTTIENRSKKSNBINISSUU_SHRGKKEIINFO%>);

                       $(<%= DISPYENDTTIENRSKKSNBINISSUU_SHRGKKEIINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");
                  <% } %>

                  $(<%=SYNYKNGK_ZEIMUINFO%>).parent().attr("colSpan","3");
              <% } else { %>
                  <% if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) { %>
                     showGroup(<%=SHRGKKEIGAIKAINFO%>);
                     showKoumoku(<%=KAIYAKUHR_SHRGKKEIGAIKAINFO%>);
                     <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                        showKoumoku(<%=MIKEIKAP_SHRGKKEIGAIKAINFO%>);
                        showKoumoku(<%=ZENNOUSEISANKIN_SHRGKKEIGAIKAINFO%>);
                     <% }%>
                     <% if (!C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                         showKoumoku(<%=AZUKARIKINKYKHNKKAIYAKUHR_SHRGKKEIGAIKAINFO%>);
                     <% } %>
                     showKoumoku(<%=SONOTASHRGK_SHRGKKEIGAIKAINFO%>);
                      $(<%= SHRGKGOUKEIKAKUNIN_SHRGKKEIGAIKAINFO + LABEL%>).parent().attr("rowspan","8");
                      $(<%= SHRGKGOUKEIKAKUNIN_SHRGKKEIGAIKAINFO%>).parent().attr("rowspan","8");

                      $(<%= DISPTIENRSKKISANYMDNISSUU_SHRGKKEIGAIKAINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

                      showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
                      $(<%= SYNYKNGK_ZEIMUINFO %>).removeClass('leftViewCell');
                      $(<%= KAIYAKUHR_SHRGKKEIGAIKAINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

                      <% if ((C_HyoujiptnKbn.KAIYAKU.eq(uiBean.getKinouHyoujiptnKbn()) || C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) &&
                             C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                          showKoumoku(<%=GSTSZEIGK_SHRGKKEIGAIKAINFO%>);
                      <% } %>

                     showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);
                     showGroup(<%=SNTSHRGKSSSIHARAIWASERATE%>);
                     showGroup(<%=SNTSHRGKSSYENSONOTASHRGKINFO%>);
                     <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                        showKoumoku(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                        showKoumoku(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                     <% }%>
                     <% if (!C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                         showKoumoku(<%=SNTSHRGKSSYENAZUKARIKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                         <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                             showKoumoku(<%=SNTSHRGKSSYENKAKRKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                         <% }%>
                     <% } %>
                     <% if (!C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                         showKoumoku(<%=SNTSHRGKSSYENHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                         showKoumoku(<%=SNTSHRGKSSYENTKBTHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                     <% } %>

                  <% } else { %>
                      showGroup(<%=SHRGKKEIENKAINFO%>);
                      showKoumoku(<%=JPYKAIYAKUHR_SHRGKKEIENKAINFO%>);

                     <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                         showKoumoku(<%=YENKAMIKEIKAP_SHRGKKEIENKAINFO%>);
                         showKoumoku(<%=YENKAZENNOUSEISANKGK_SHRGKKEIENKAINFO%>);
                     <% } %>

                     <% if (!C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                         showKoumoku(<%=YENKAAZUKARIKINGK_SHRGKKEIENKAINFO%>);
                         <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                           showKoumoku(<%=YENKAKRKGK_SHRGKKEIENKAINFO%>);
                         <% }%>
                     <% } %>
                     <% if (!C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                         showKoumoku(<%=YENKAHAITOUKIN_SHRGKKEIENKAINFO%>);
                         showKoumoku(<%=YENTKBTHAITOUKIN_SHRGKKEIENKAINFO%>);
                     <% } %>

                      <% if ((C_HyoujiptnKbn.KAIYAKU.eq(uiBean.getKinouHyoujiptnKbn()) ||
                              C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) &&
                             C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                          showKoumoku(<%=JPYGSTSZEIGK_SHRGKKEIENKAINFO%>);
                      <% } %>

                      $(<%= JPYSHRGKGOUKEIKAKUNIN_SHRGKKEIENKAINFO + LABEL%>).parent().attr("rowspan","10");
                      $(<%= JPYSHRGKGOUKEIKAKUNIN_SHRGKKEIENKAINFO%>).parent().attr("rowspan","10");
                      $(<%= DISPJPTIENRSKKISANYMDNISSUU_SHRGKKEIENKAINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

                      <% if (C_HyoujiptnKbn.PMNYSYMET_JDSKN_SSNZM.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                          $(<%= DISPJPTIENRSKKISANYMDNISSUU_SHRGKKEIENKAINFO + LABEL%>).parent().visible(false);
                          $(<%= DISPJPTIENRSKKISANYMDNISSUU_SHRGKKEIENKAINFO %>).parent().visible(false);
                      <% } %>

                      <% if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                          showGroup(<%=SIHARAISYOUSAIINFO%>);
                          showKoumoku(<%=SHRSYOUSAIKAIYAKUHR_SIHARAISYOUSAIINFO%>);
                          showKoumoku(<%=SHRSYOUSAIJPYKAIYAKUHR_SIHARAISYOUSAIINFO%>);
                          showGroup(<%=RATEIINFO%>);
                      <% } %>
                      <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                            showGroup(<%=YENKIYKHRSSINFO%>);
                            showGroup(<%=YENKIYKHRSSSHRKWSRATEINFO%>);
                            showGroup(<%=YENKIYKHRSSGOUKEIINFO%>);

                            <% if (!C_HyoujiptnKbn.PMNYSYMET_JDSKN_SSNZM.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                              showKoumoku(<%=YENKIYKHRSSMIKEIKAP_YENKIYKHRSSGOUKEIINFO%>);
                            <% } %>

                          <% if (!C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                            showKoumoku(<%=YENKIYKHRSSKYKHNKKAIYAKUHR_YENKIYKHRSSGOUKEIINFO%>);
                          <% } %>
                     <% } %>

                      $(<%= JPYKAIYAKUHR_SHRGKKEIENKAINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

                      $(<%=SYNYKNGK_ZEIMUINFO%>).parent().attr("colSpan","3");
                  <% } %>
              <% } %>
              <% if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
                      SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) &&
                    !C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu()) &&
                    !C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                  showGroup(<%=HOKENRYOUTMTTKSYOUSAIINFO%>);
                  $(<%= PTUMITATEKINSSPTUMITATEKIN_HOKENRYOUTMTTKSYOUSAIINFO + LABEL%>).parent().attr("rowspan","2");
                  $(<%= PTUMITATEKINSSPTUMITATEKIN_HOKENRYOUTMTTKSYOUSAIINFO%>).parent().attr("rowspan","2");
                  $(<%= SISUURENDOUTMTTKNGK_HOKENRYOUTMTTKSYOUSAIINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");
              <% } %>
          <% }%>

          <% if(!C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
             <% if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                  showGroup(<%=KAIYAKUHRSYOUSAIINFO%>);

                  $(<%= KIYKHRSYOUSAIKAIYAKUHR_KAIYAKUHRSYOUSAIINFO + LABEL%>).parent().attr("rowspan","4");
                  $(<%= KIYKHRSYOUSAIKAIYAKUHR_KAIYAKUHRSYOUSAIINFO%>).parent().attr("rowspan","4");

                  <% if (C_UmuKbn.ARI.eq(uiBean.getKaiyakukoujyoritutekiumu())) { %>
                      showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJGK_KAIYAKUHRSYOUSAIINFO%>);

                      showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJRITU_KAIYAKUHRSYOUSAIINFO%>);
                  <% } %>

                  <% if (C_UmuKbn.ARI.eq(uiBean.getMvatekiumu())) { %>
                      showKoumoku(<%=KIYKHRSYOUSAISJKKKTYOUSEIRT_KAIYAKUHRSYOUSAIINFO%>);
                  <% } %>
              <% } %>
          <% } %>

          <% if (C_UmuKbn.ARI.eq(uiBean.getShrnaiyouumu())) { %>
            showGroup(<%=ZEIMUINFO%>);

            <% if (!C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu()) && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) { %>
                showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
            <% } %>

            <% if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                showKoumoku(<%=GSTSTAISYOUSAEKI_ZEIMUINFO%>);
                showKoumoku(<%=ZEIMUGSTSZEIGK_ZEIMUINFO%>);
            <% } %>

              <% if(uiBean.getKykhnkkaisuu() > 0) { %>
                 showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
                 showKoumoku(<%=KYKHNKKAISUU_ZEIMUINFO%>);
                 $(<%=KYKHNKKAISUU_UNIT%>).addClass('leftKykhnkkaisuuUnitCell');
            <% } %>
          <% } %>
          <% if (C_UmuKbn.ARI.eq(uiBean.getZeitekiazukarikinkjumu())) { %>
            showGroup(<%=AZUKARIKININFO%>);
            showGroup(<%=AZUKARIKINYENINFO%>);
             $(<%= ROWSPAN4_CLASS %>).attr("rowspan","4");
             $(<%= COLSPAN1_CLASS %>).attr("colspan","1");
          <% } %>
       <% } else if (C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
               C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ||
               C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {%>
           showGroup(<%=SIHARAINAIYOUINFO%>);

           showGroup(<%=SHRGKKEIINFO1%>);

           <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
             showKoumoku(<%=KEITORIKRKGK_SHRGKKEIINFO1%>);
           <% } %>

           $(<%= NYKNTUUKASHRGKGOUKEIKAKUNIN_SHRGKKEIINFO1 + LABEL%>).parent().attr("rowspan","2");
           $(<%= NYKNTUUKASHRGKGOUKEIKAKUNIN_SHRGKKEIINFO1%>).parent().attr("rowspan","2");
           $(<%= KEITORIKRKGK_SHRGKKEIINFO1 %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

       <% } else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
         showGroup(<%=SIHARAINAIYOUINFO%>);

         <% if (C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu())) { %>
             showGroup(<%=SHRGKKEIINFO%>);

              showKoumoku(<%=YENDTHNKPTUMITATEKIN_SHRGKKEIINFO%>);

              showKoumoku(<%=YENDTHNKHAITOUKIN_SHRGKKEIINFO%>);
              showKoumoku(<%=YENDTHNKTKBTHAITOUKIN_SHRGKKEIINFO%>);

              showKoumoku(<%=DISPYENDTTIENRSKKSNBINISSUU_SHRGKKEIINFO%>);

              <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                showKoumoku(<%=YENDTHNKMIKEIKAP_SHRGKKEIINFO%>);
                showKoumoku(<%=YENDTHNKZENNOUSEISANKIN_SHRGKKEIINFO%>);
                showKoumoku(<%=YENDTHNKKRKGK_SHRGKKEIINFO%>);
              <% } %>

              $(<%= YENDTHNKSHRGKGOUKEI_SHRGKKEIINFO + LABEL%>).parent().attr("rowspan","11");
              $(<%= YENDTHNKSHRGKGOUKEI_SHRGKKEIINFO%>).parent().attr("rowspan","11");
              $(<%= DISPYENDTTIENRSKKSNBINISSUU_SHRGKKEIINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

         <% } else { %>
             <% if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) { %>
                 showGroup(<%=SHRGKKEIGAIKAINFO%>);
                 showKoumoku(<%=PTUMITATEKIN_SHRGKKEIGAIKAINFO%>);

                 showKoumoku(<%=AZUKARIKINKYKHNKKAIYAKUHR_SHRGKKEIGAIKAINFO%>);
                 showKoumoku(<%=SONOTASHRGK_SHRGKKEIGAIKAINFO%>);

                 <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=MIKEIKAP_SHRGKKEIGAIKAINFO%>);
                    showKoumoku(<%=ZENNOUSEISANKIN_SHRGKKEIGAIKAINFO%>);
                 <% } %>
                 $(<%= SHRGKGOUKEIKAKUNIN_SHRGKKEIGAIKAINFO + LABEL%>).parent().attr("rowspan","8");
                 $(<%= SHRGKGOUKEIKAKUNIN_SHRGKKEIGAIKAINFO%>).parent().attr("rowspan","8");

                 $(<%= DISPTIENRSKKISANYMDNISSUU_SHRGKKEIGAIKAINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

                 showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);
                 showGroup(<%=SNTSHRGKSSSIHARAIWASERATE%>);
                 showGroup(<%=SNTSHRGKSSYENSONOTASHRGKINFO%>);

                 showKoumoku(<%=SNTSHRGKSSYENAZUKARIKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                 showKoumoku(<%=SNTSHRGKSSYENHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                 showKoumoku(<%=SNTSHRGKSSYENTKBTHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                 <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENKAKRKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                 <% } %>
             <% } else { %>
                 showGroup(<%=SHRGKKEIENKAINFO%>);
                 showKoumoku(<%=JPYPTUMITATEKIN_SHRGKKEIENKAINFO%>);

                 showKoumoku(<%=YENKAAZUKARIKINGK_SHRGKKEIENKAINFO%>);
                 showKoumoku(<%=YENKAHAITOUKIN_SHRGKKEIENKAINFO%>);
                 showKoumoku(<%=YENTKBTHAITOUKIN_SHRGKKEIENKAINFO%>);

                 <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=YENKAMIKEIKAP_SHRGKKEIENKAINFO%>);
                    showKoumoku(<%=YENKAZENNOUSEISANKGK_SHRGKKEIENKAINFO%>);
                    showKoumoku(<%=YENKAKRKGK_SHRGKKEIENKAINFO%>);
                 <% } %>
                 $(<%= JPYSHRGKGOUKEIKAKUNIN_SHRGKKEIENKAINFO + LABEL%>).parent().attr("rowspan","10");
                 $(<%= JPYSHRGKGOUKEIKAKUNIN_SHRGKKEIENKAINFO%>).parent().attr("rowspan","10");

                 $(<%= DISPJPTIENRSKKISANYMDNISSUU_SHRGKKEIENKAINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

                 <% if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                   showGroup(<%=SIHARAISYOUSAIINFO%>);
                   showKoumoku(<%=SHRSYOUSAIPTUMITATEKIN_SIHARAISYOUSAIINFO%>);
                   showKoumoku(<%=SHRSYOUSAIJPYPTUMITATEKIN_SIHARAISYOUSAIINFO%>);
                   showGroup(<%=RATEIINFO%>);
                 <% } %>

                 <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                   showGroup(<%=YENPTMTTSSINFO%>);
                   showGroup(<%=YENPTMTTSSSIHARAIWASERATE%>);
                   showGroup(<%=YENPTMTTSSGOUKEIINFO%>);
                <% } %>
             <% } %>
         <% } %>

          showGroup(<%=ZEIMUINFO%>);

          <% if (!C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu()) && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) { %>
              showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
              $(<%= SYNYKNGK_ZEIMUINFO %>).removeClass('leftViewCell');
          <% } %>

            <% if(uiBean.getKykhnkkaisuu() > 0) { %>
               showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
               showKoumoku(<%=KYKHNKKAISUU_ZEIMUINFO%>);
               $(<%=KYKHNKKAISUU_UNIT%>).addClass('leftKykhnkkaisuuUnitCell');
          <% } %>
       <% } else if (C_HyoujiptnKbn.SEINENGAPPISEI.eq(uiBean.getKinouHyoujiptnKbn())) {%>
           showGroup(<%=SIHARAINAIYOUINFO%>);
           showGroup(<%=HENKANKINFO%>);
           <% if (C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu())) { %>
               showKoumoku(<%=YENHENKANK_HENKANKINFO%>);
               $(<%=YENHENKANK_HENKANKINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
               $(<%=YENHENKANK_HENKANKINFO%>).addClass('leftViewCell');
           <%
           } else { %>
              <% if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) { %>
               showKoumoku(<%=HENKANK_HENKANKINFO%>);
               $(<%=HENKANK_HENKANKINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
               $(<%=HENKANK_HENKANKINFO%>).addClass('leftViewCell');
               $(<%=HENKANK_HENKANKINFO + LABEL%>).text('<%=YEN_HENKANK_NAME%>');
              <%
              } else { %>
               showKoumoku(<%=YENHENKANK_HENKANKINFO%>);
               showKoumoku(<%=HENKANK_HENKANKINFO%>);
               showGroup(<%=RATEIINFO%>);
              <% } %>
           <% } %>
       <% } else if (C_HyoujiptnKbn.YENDTHNKHRSHR.eq(uiBean.getKinouHyoujiptnKbn())) { %>
           showGroup(<%=SIHARAINAIYOUINFO%>);

           showGroup(<%=SHRNAIYOUSYORUIUKEINFO%>);
           $(<%=SIHARAINAIYOUINFO + LABEL%>).parent().parent().visible(false);

           showGroup(<%=SHRGKKEIINFO%>);
           showKoumoku(<%=DISPYENDTTIENRSKKSNBINISSUU_SHRGKKEIINFO%>);

           showKoumoku(<%=YENDTHNKHR_SHRGKKEIINFO%>);
           $(<%= YENDTHNKSHRGKGOUKEI_SHRGKKEIINFO + LABEL%>).parent().attr("rowspan","11");
           $(<%= YENDTHNKSHRGKGOUKEI_SHRGKKEIINFO%>).parent().attr("rowspan","11");
           $(<%= DISPYENDTTIENRSKKSNBINISSUU_SHRGKKEIINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

           showGroup(<%=ZEIMUINFO%>);

           <% if(uiBean.getKykhnkkaisuu() > 0) { %>
               showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
               showKoumoku(<%=KYKHNKKAISUU_ZEIMUINFO%>);
               $(<%=KYKHNKKAISUU_UNIT%>).addClass('leftKykhnkkaisuuUnitCell');
           <% } %>
       <% } else if (C_HyoujiptnKbn.DSHR.eq(uiBean.getKinouHyoujiptnKbn())) { %>
         showGroup(<%=SHRNAIYOUSYORUIUKEINFO%>);

         showGroup(<%=SIHARAINAIYOUINFO%>);
         showKoumoku(<%=CALCKIJYUNYMD_SIHARAINAIYOUINFO%>);

         $(<%=SIHARAINAIYOUINFO + LABEL%>).parent().parent().visible(false);

         showGroup(<%=SHRGKKEIINFO3%>);
         showKoumoku(<%=TUMITATEHAITOUGANRIKIN_SHRGKKEIINFO3%>);
         showKoumoku(<%=DISPHAITTTIENRSKKSNBINISSUU_SHRGKKEIINFO3%>);

         $(<%= SHRGKKEI_SHRGKKEIINFO3 + LABEL%>).parent().attr("rowspan","3");
         $(<%= SHRGKKEI_SHRGKKEIINFO3%>).parent().attr("rowspan","3");
         $(<%= DISPHAITTTIENRSKKSNBINISSUU_SHRGKKEIINFO3 %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");

         $(<%= SHRGKKEIINFO3 + DIV%>).css("margin-top", "-1px");

       <% } else if (C_HyoujiptnKbn.DSEISANTUIBARAI.eq(uiBean.getKinouHyoujiptnKbn())) { %>
        showGroup(<%=SIHARAINAIYOUINFO%>);
        <% if (C_UmuKbn.ARI.eq(uiBean.getShrnaiyouumu())) { %>
            <% if (C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu())) { %>
                showGroup(<%=SHRGKKEIINFO%>);
                showKoumoku(<%=YENDTHNKHAITOUKIN_SHRGKKEIINFO%>);
                showKoumoku(<%=YENDTHNKTKBTHAITOUKIN_SHRGKKEIINFO%>);

                showKoumoku(<%=DISPYENDTTIENRSKKSNBINISSUU_SHRGKKEIINFO%>);

                $(<%= YENDTHNKSHRGKGOUKEI_SHRGKKEIINFO + LABEL%>).parent().attr("rowspan","11");
                $(<%= YENDTHNKSHRGKGOUKEI_SHRGKKEIINFO%>).parent().attr("rowspan","11");

                <% if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                    showKoumoku(<%=YENDTHNKGSTSZEIGK_SHRGKKEIINFO%>);
                <% } %>
            <% } else { %>
                <% if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) { %>
                    showGroup(<%=SHRGKKEIGAIKAINFO%>);
                    showKoumoku(<%=SONOTASHRGK_SHRGKKEIGAIKAINFO%>);

                    $(<%= SHRGKGOUKEIKAKUNIN_SHRGKKEIGAIKAINFO + LABEL%>).parent().attr("rowspan","8");
                    $(<%= SHRGKGOUKEIKAKUNIN_SHRGKKEIGAIKAINFO%>).parent().attr("rowspan","8");

                    <% if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                        showKoumoku(<%=GSTSZEIGK_SHRGKKEIGAIKAINFO%>);
                    <% } %>

                    showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);

                    showGroup(<%=SNTSHRGKSSSIHARAIWASERATE%>);

                    showGroup(<%=SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    $(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO%>).parent().visible(false);
                    $(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO + LABEL%>).parent().visible(false);
                    $(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>).parent().visible(false);
                    $(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO + LABEL%>).parent().visible(false);
                    showKoumoku(<%=SNTSHRGKSSYENHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENTKBTHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);

                    $(<%= SNTSHRGKSSYENSONOTASHRGK_SNTSHRGKSSYENSONOTASHRGKINFO + LABEL%>).parent().attr("rowspan","6");
                    $(<%= SNTSHRGKSSYENSONOTASHRGK_SNTSHRGKSSYENSONOTASHRGKINFO%>).parent().attr("rowspan","6");
                <% } else { %>
                    showGroup(<%=SHRGKKEIENKAINFO%>);
                    showKoumoku(<%=YENKAHAITOUKIN_SHRGKKEIENKAINFO%>);
                    showKoumoku(<%=YENTKBTHAITOUKIN_SHRGKKEIENKAINFO%>);

                    $(<%= JPYSHRGKGOUKEIKAKUNIN_SHRGKKEIENKAINFO + LABEL%>).parent().attr("rowspan","10");
                    $(<%= JPYSHRGKGOUKEIKAKUNIN_SHRGKKEIENKAINFO%>).parent().attr("rowspan","10");

                    <% if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
                        showKoumoku(<%=JPYGSTSZEIGK_SHRGKKEIENKAINFO%>);
                    <% } %>
                <% } %>
            <% } %>
        <% } %>

        showGroup(<%=ZEIMUINFO%>);

        <% if (!C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu()) && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) { %>
            showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
            $(<%= SYNYKNGK_ZEIMUINFO %>).removeClass("leftViewCell");
        <% } else {%>
            $(<%= SYNYKNGK_ZEIMUINFO %>).parent().attr("colSpan","3");
        <% } %>

        <% if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) { %>
            showKoumoku(<%=GSTSTAISYOUSAEKI_ZEIMUINFO%>);
            showKoumoku(<%=ZEIMUGSTSZEIGK_ZEIMUINFO%>);
        <% } %>

        <% if (uiBean.getKykhnkkaisuu() > 0) { %>
            showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
            showKoumoku(<%=KYKHNKKAISUU_ZEIMUINFO%>);
            $(<%=KYKHNKKAISUU_UNIT%>).addClass('leftKykhnkkaisuuUnitCell');
        <% } %>
       <% } %>
     <% } %>

     <% if (C_UmuKbn.ARI.eq(uiBean.getHasseiKazeiUmuKbn())) { %>
         <% if (C_HyoujiptnKbn.MKHGKTTTYENDTHNK.eq(uiBean.getKinouHyoujiptnKbn()) ||
             C_HyoujiptnKbn.PMNYSYMET_MSSN.eq(uiBean.getKinouHyoujiptnKbn())) { %>
             showGroup(<%=ZEIMUINFO%>);

             <% if(uiBean.getKykhnkkaisuu() != null && uiBean.getKykhnkkaisuu() > 0) { %>
                 showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
                 showKoumoku(<%=KYKHNKKAISUU_ZEIMUINFO%>);
                 $(<%=KYKHNKKAISUU_UNIT%>).addClass('leftKykhnkkaisuuUnitCell');
             <% } %>
         <% } %>
     <% } %>

      <% if (C_HyoujiptnKbn.MKHGKTTTYENDTHNK.eq(uiBean.getKinouHyoujiptnKbn())) { %>
        <% if (C_UmuKbn.ARI.eq(uiBean.getYendtinfomDispUmu())) { %>
            <% if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(uiBean.getYendtinfosyorikbn())) { %>
              showGroup(<%=YENDTINFO%>);
              showKoumoku(<%=YENDTINFOMKHGK_YENDTINFO%>);
              showKoumoku(<%=YENDTINFOKJNKNGK_YENDTINFO%>);
              showKoumoku(<%=YENDTINFOMOKUHYOUTI_YENDTINFO%>);

              <% if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyohinHanteiKbn()){ %>
                showKoumoku(<%=YENDTINFOYENDTHNKHRGK_YENDTINFO%>);
                showKoumoku(<%=YENDTINFOBFRSIBOUSYEN_YENDTINFO%>);
                showKoumoku(<%=YENDTINFONEWKAIYAKUHR_YENDTINFO%>);
              <% } %>

              $(<%= YENDTINFOSYORUIUKTKYMD_YENDTINFO %>).visible(false);
              $(<%= YENDTINFOYENDTHNKKJNKNGK_YENDTINFO %>).visible(false);
            <% } else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(uiBean.getYendtinfosyorikbn())) { %>
              showGroup(<%=YENDTINFO%>);
              $(<%= YENDTINFOMKHGKTTTYMD_YENDTINFO %>).visible(false);
              $(<%= YENDTINFOTOUTATUKNGK_YENDTINFO %>).visible(false);

              $(<%= YENDTINFOMKHGKTTTYMD_YENDTINFO + LABEL %>).text('書類受付日');
              $(<%= YENDTINFOTOUTATUKNGK_YENDTINFO + LABEL %>).text('円建変更後基準金額');
            <% } %>

            showGroup(<%=YENDTKIYKHRSYOUSAI%>);

            <% if (C_UmuKbn.ARI.eq(uiBean.getKaiyakukoujyoritutekiumu())) { %>
              showKoumoku(<%=YENDTINFOKAIYAKUKJGK_YENDTKIYKHRSYOUSAI%>);
              showKoumoku(<%=YENDTINFOKAIYAKUKOUJYORITU_YENDTKIYKHRSYOUSAI%>);
           <% } %>
        <% } %>
      <% } %>
     <% if ((C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()) &&
         !uiBean.getShrgkgoukeikakunin().isOptional()
         && uiBean.getShrgkgoukeikakunin().compareTo(
             BizCurrency.valueOf(0, uiBean.getShrgkgoukeikakunin().getType())) > 0) ||
             (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) &&
                 !uiBean.getJpyshrgkgoukeikakunin().isOptional()
                 && uiBean.getJpyshrgkgoukeikakunin().compareTo(
                     BizCurrency.valueOf(0, uiBean.getJpyshrgkgoukeikakunin().getType())) > 0)) {%>
          <% if (C_HyoujiptnKbn.KAIYAKU.eq(uiBean.getKinouHyoujiptnKbn())
              || C_HyoujiptnKbn.PMNYSYMET_JDSKN_SSNZM.eq(uiBean.getKinouHyoujiptnKbn())
              || C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())
              || C_HyoujiptnKbn.DSEISANTUIBARAI.eq(uiBean.getKinouHyoujiptnKbn())
              || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())
              || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())
              || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) { %>
              <% if (!C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu())) { %>
                  showGroup(<%=YENSHRTKUMUINFO%>);
              <% } %>
         <% } %>

          <% if (C_HyoujiptnKbn.KAIYAKU.eq(uiBean.getKinouHyoujiptnKbn())
              || C_HyoujiptnKbn.PMNYSYMET_JDSKN_SSNZM.eq(uiBean.getKinouHyoujiptnKbn())
              || C_HyoujiptnKbn.GENGAKU.eq(uiBean.getKinouHyoujiptnKbn())
              || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())
              || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>

              showGroup(<%=MNMEIGINOINFO%>);
              <% if(C_SyoriKbn.KAIYAKU_KEIYAKUSYASIBOU.eq(uiBean.getSyoriKbn())) { %>
                $(<%= UKTMNMEIGIBANGOU_MNMEIGINOINFO + LABEL%>).html('<span>相続人代表者</span><br/><span>ＭＮ名義番号</span>');
              <% } else { %>
                $(<%= UKTMNMEIGIBANGOU_MNMEIGINOINFO + LABEL%>).text("受取人ＭＮ名義番号");
              <% } %>
         <% } %>

     <% } %>

     <% if ((!uiBean.getHenkank().isOptional()
         && uiBean.getHenkank().compareTo(BizCurrency.valueOf(0, uiBean.getHenkank().getType())) > 0) &&
             !C_Tuukasyu.JPY.eq(uiBean.getShrkyktuukasyu())) { %>
             <% if (C_HyoujiptnKbn.SEINENGAPPISEI.eq(uiBean.getKinouHyoujiptnKbn())) { %>
                 showGroup(<%=YENSHRTKUMUINFO%>);
             <% } %>
     <% } %>

     <% if (!BizUtil.isBlank(uiBean.getSoukinsakinmkn())) { %>

           showGroup(<%=SOUKINSAKIINFO%>);
           showGroup(<%=SOUKINSAKIINFO2%>);
     <% } %>

     <% if (!BizUtil.isBlank(uiBean.getKyksyaszknmkn())) { %>

           showGroup(<%=KYKSYASZINFO%>);
           showGroup(<%=KYKSYASZINFO2%>);
     <% } %>

     <% if (!BizUtil.isBlank(uiBean.getSaikennmkj())) { %>

           showGroup(<%=SAIKEINFO%>);
           showGroup(<%=SAIKEINFO2%>);
     <% } %>

        <% if (C_HyoujiptnKbn.MEIGIHENKOU.eq(uiBean.getKinouHyoujiptnKbn())) { %>
           <% if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigiHnkJiyuu())
               || C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigiHnkJiyuu())) { %>
               showGroup(<%=SINKYKTSINTELINFO%>);
           <% } %>

           <% if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigiHnkJiyuu())) { %>
               showGroup(<%=ZEIMUINFO%>);
               showKoumoku(<%=YENKAIYAKUHRSTGK_ZEIMUINFO%>);

               <% if (!C_Tuukasyu.JPY.eq(uiBean.getZeimukyktuukasyu())) { %>
                   showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
                   $(<%= YENKAIYAKUHRSTGK_ZEIMUINFO %>).removeClass('leftViewCell');
               <% } %>

               showKoumoku(<%=KIHRKMPSGK_ZEIMUINFO%>);
               showKoumoku(<%=OLDKYKKIHRKMP_ZEIMUINFO%>);
               $(<%= SYNYKNGK_ZEIMUINFO%>).parent().visible(false);
               $(<%= SYNYKNGK_ZEIMUINFO + LABEL%>).parent().visible(false);

               $(<%= HTYKEIHI_ZEIMUINFO%>).parent().visible(false);
               $(<%= HTYKEIHI_ZEIMUINFO + LABEL%>).parent().visible(false);
           <% } %>
       <% } %>
       <% if (!uiBean.getDispyentuikahrkkin().isOptional()
           && uiBean.getDispyentuikahrkkin().compareTo(BizCurrency.valueOf(0, uiBean.getDispyentuikahrkkin().getType())) > 0) { %>
            showGroup(<%=TUIKAHRKKININFO%>);
            <% if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
               $(<%=DISPYENTUIKAHRKKIN_TUIKAHRKKININFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
               $(<%=DISPYENTUIKAHRKKIN_TUIKAHRKKININFO%>).addClass('leftViewCell');
            <%
            } else { %>
               showKoumoku(<%=DISPTUIKAHRKKIN_TUIKAHRKKININFO%>);
               showGroup(<%=TUIKAHRKKINWSRATEINFO%>);
            <% } %>
       <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
    $(<%=SYONOSITEI_LABEL%>).text('<%=SYOUKENBANGOUSITEI%>');
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>
    <% if (C_UmuKbn.ARI.eq(uiBean.getTtdkrrkumu())) { %>
    $(<%=TTDKRRKBTNBYKEIYAKUNAIYOU_HEADERBUTTONS1%>).visible(true);
    <% } %>

    $(<%= KYKNAIYOUBTNBYKEIYAKUNAIYOU_HEADERBUTTONS1 %>).disable(true);

    <% if (C_UmuKbn.ARI.eq(uiBean.getTumitateRirekiUmuKbn())) { %>
      $(<%=TMTTKNRRKBTNBYKEIYAKUNAIYOU_HEADERBUTTONS1%>).visible(true);
    <% } %>

    <% if (C_UmuKbn.ARI.eq(uiBean.getKyknaiyouosiraseKngnUmu())) { %>
      $(<%=KYKNYSRSSKSBTNBYKYKNY_HEADERBUTTONS1%>).visible(true);
    <% } %>

    <% if (C_UmuKbn.ARI.eq(uiBean.getSyouraiKaiyakuhenreikinKngnUmu())) { %>
      $(<%=SYRKIYKHKBTNBYKEIYAKUNAIYOU_HEADERBUTTONS6%>).visible(true);
    <% } %>
    <% if (C_UmuKbn.ARI.eq(uiBean.getKaiyakuKngnUmu())) { %>
      $(<%=KAIYAKUBTNBYKEIYAKUNAIYOU_HEADERBUTTONS6%>).visible(true);
    <% } %>

    <% if (C_YuukousyoumetuKbn.SYOUMETU.eq(uiBean.getYuukousyoumetukbn())){ %>
       showKoumoku(<%= SYOUMETUJIYUU_KIHONINFO %>);
       showKoumoku(<%= SYOUMETUYMD_KIHONINFO %>);
    <% } %>

    <% if (C_UmuKbn.ARI.eq(uiBean.getMosuktymdhkumu())){ %>
       $("#IIW0007").removeClass('defaultNonVisible');
    <% } %>

    <% if(uiBean.getMosukeymd() != null && uiBean.getMosjimosuktymd() != null ){ %>
       showKoumoku(<%= MOSUKEYMD_KIHONINFO %>);
       $(<%= MOSUKEYMD_KIHONINFO %>).parent().removeClass('c1').addClass('c2').attr("colSpan","1");
       $(<%= KKTYMD_KIHONINFO %>).parent().attr("rowspan","2");
       $(<%= KKTYMD_KIHONINFO + LABEL %>).parent().attr("rowspan","2");
    <% } %>

    <% if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn() &&
           C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai()) && !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())){ %>
          <% if (C_DispKbn.HYOUJI.eq(uiBean.getPyentuthouDispKbn())) { %>
            showKoumoku(<%= PYENTUTHOUKBN_YAKKANINFO %>);
          <% } %>
    <% } %>

    <% if(uiBean.getDrtenListKensu() == 2){ %>
       showGroup(<%=DAIRITENINFO2%>);
    <% } %>

  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU) { %>

    <% if (C_Syorikeiyu.KEYINPUT.eq(uiBean.getSyoriKeiyuKbn())) { %>
       $(<%=MODORUBTNBYKEIYAKUNAIYOU_FOOTERBUTTONS3%>).visible(true);
    <% } %>
    <% if (C_Syorikeiyu.SRCH.eq(uiBean.getSyoriKeiyuKbn())) { %>
       $(<%=SEARCHRESULTHEMODORUBTNBYKEIYAKUNAIYOU_FOOTERBUTTONS3%>).visible(true);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_TTDKRIREKI) { %>
    <% if (C_Syorikeiyu.KEYINPUT.eq(uiBean.getSyoriKeiyuKbn())) { %>
       $(<%=MODORUBTNBYTTDKRRKLIST_FOOTERBUTTONS4%>).visible(true);
    <% } %>
    <% if (C_Syorikeiyu.SRCH.eq(uiBean.getSyoriKeiyuKbn())) { %>
       $(<%=SEARCHRESULTHEMODORUBTNBYTTDKRIREKI_FOOTERBUTTONS4%>).visible(true);
    <% } %>

    $(<%= TTDKRIREKIBTNBYTTDKRIREKI_HEADERBUTTONS2 %>).disable(true);

    <% if (C_UmuKbn.ARI.eq(uiBean.getTumitateRirekiUmuKbn())) { %>
      $(<%=TMTTKNRRKBTNBYTTDKRIREKI_HEADERBUTTONS2%>).visible(true);
    <% } %>

    <% if (C_UmuKbn.ARI.eq(uiBean.getKyknaiyouosiraseKngnUmu())) { %>
      $(<%=KYKNYSRSSKSBTNBYTTDKRRK_HEADERBUTTONS2%>).visible(true);
    <% } %>

    <% if (C_UmuKbn.ARI.eq(uiBean.getSyouraiKaiyakuhenreikinKngnUmu())) { %>
      $(<%=SYRKIYKHKBTNBYTTDKRIREKI_HEADERBUTTONS7%>).visible(true);
    <% } %>

    <% if (C_UmuKbn.ARI.eq(uiBean.getKaiyakuKngnUmu())) { %>
      $(<%=KAIYAKUBTNBYTTDKRIREKI_HEADERBUTTONS7%>).visible(true);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_NYUUKINRIREKI) { %>
    <% if (C_Syorikeiyu.KEYINPUT.eq(uiBean.getSyoriKeiyuKbn())) { %>
       $(<%=MODORUBTNBYNYUUKINRIREKI_FOOTERBUTTONS6%>).visible(true);
    <% } %>
    <% if (C_Syorikeiyu.SRCH.eq(uiBean.getSyoriKeiyuKbn())) { %>
       $(<%=SEARCHRESULTHEMODORUBTNBYNYUUKINRIREKI_FOOTERBUTTONS6%>).visible(true);
    <% } %>
  <% } %>

  <% if(uiBean.getPageNo() == PAGENO_KEIYAKUNAIYOU){ %>

      var linkList = {
          <%= KIHONJOUHOUBTN_LINKBUTTONS1 %>       : <%= KIHONINFO + LABEL %>,
          <% if (!(C_KktyuitaKbn.BLNK.eq(uiBean.getVtdktkktyuitakbn())
             && uiBean.getTtdktyuuikbnInfoDataSource().getDatas().size() == 0
             && !C_StknsetKbn.ARI.eq(uiBean.getVtdktstknsetkbn())
             && C_FatcakekKbn.BLNK.eq(uiBean.getVtdktdispfatcakekkbn1()))) { %>
             <%= TTDKTYUUIJOUHOUBTN_LINKBUTTONS1 %>   : <%= TETUDUKITYUUIINFO + LABEL %>,
          <% } %>
          <%= KEIYAKUSYAJOUHOUBTN_LINKBUTTONS1 %>  : <%= KEIYAKUSYAINFO + LABEL %>,
          <%= TUSINSAKIJOUHOUBTN_LINKBUTTONS1 %>   : <%= TUUSINSAKIINFO + LABEL %>,
          <%= HIHOKENSYAJOUHOUBTN_LINKBUTTONS1 %>  : <%= HIHOKENSYAINFO + LABEL %>,
          <%= HOSYOUJOUHOUBTN_LINKBUTTONS1 %>      : <%= HOSYOUINFO + LABEL %>,
          <% if (!(uiBean.getVsntkdisptkhukainfo() == null
             || uiBean.getVsntkdisptkhukainfo().length() == 0
             || BizUtil.isBlank(uiBean.getVsntkdisptkhukainfo()))) { %>
             <%= SONOTATOKUYAKUBTN_LINKBUTTONS1 %> : <%= SONOTATKINFO + LABEL %>,
          <% } %>
          <%= HARAIKOMIJOUHOUBTN_LINKBUTTONS2 %>   : <%= HARAIKOMIINFO + LABEL %>,
          <%
          if (C_UmuKbn.ARI.eq(uiBean.getVtsumukbn())) { %>
          <%= TOKUSINJOUHOUBTN_LINKBUTTONS2 %>      : <%= TOKUSININFO + LABEL %>,
          <% } %>
          <%= KARIUKEKINJOUHOUBTN_LINKBUTTONS2 %>      : <%= KARIUKEKININFO + LABEL %>,
          <%
          if (C_UmuKbn.ARI.eq(uiBean.getVdtumukbn())) { %>
          <%= DATTAIOUHOUBTN_LINKBUTTONS2 %>      : <%= DATTAIINFO + LABEL %>,
          <% } %>
          <%
          if (C_HaitoukinuketorihouKbn.TUMIHAI.eq(uiBean.getVhthaitoukinuketorihoukbn())) { %>
          <%= HAITOUKINJOUHOUBTN_LINKBUTTONS2 %>      : <%= HAITOUKININFO + LABEL %>,
          <% } %>
          <% if (!C_UktKbn.BLNK.eq(uiBean.getVnkuknenkinuktkbn())) { %>
            <%= UKETORININBTN_LINKBUTTONS2 %>      : <%= NKUKTINFO + LABEL %>,
          <% } else if (!BizUtil.isBlank(uiBean.getKeizknkuktnmkn())) {%>
            <%= UKETORININBTN_LINKBUTTONS2 %>      : <%= KEIZOKUNKUKTINFO + LABEL %>,
          <% } else if (!BizUtil.isBlank(uiBean.getSbhenkanuktnmkn())) {%>
            <%= UKETORININBTN_LINKBUTTONS2 %>      : <%= SBHENKANUKTINFO + LABEL %>,
          <% } else if (!(uiBean.getVshktsbuktnin() ==  0)) {%>
             <% if (C_UmuKbn.ARI.eq(uiBean.getVshktsbkyuuhukinuktumu())) {%>

                <%= UKETORININBTN_LINKBUTTONS2 %>      : <%= SBUKTNININFO + LABEL %>,
             <% } else {%>

                <%= UKETORININBTN_LINKBUTTONS2 %>      : <%= SBUKTNININFO + LABEL %>,
             <% }%>
          <% } %>
          <%
          if (C_UmuKbn.ARI.eq(uiBean.getVtrkkzktrkkzkumukbn1())) {%>
            <%= TRKKZKBTN_LINKBUTTONS2 %>   : <%= TRKKZKINFO1 + LABEL %>,
          <%
          } else if (C_UmuKbn.ARI.eq(uiBean.getVtrkkzktrkkzkumukbn2())) {%>
            <%= TRKKZKBTN_LINKBUTTONS2 %>   : <%= TRKKZKINFO2 + LABEL %>,
          <% } %>
          <%
          if (!C_UktKbn.BLNK.eq(uiBean.getVkykdrkykdrkbn())) {%>
            <%= KYKDAIRININBTN_LINKBUTTONS3 %>   : <%= KYKSYADAIRINININFO + LABEL %>,
          <% } %>
          <% if (!C_UktKbn.BLNK.eq(uiBean.getVstsksiteidruktkbn())) {%>
            <%= SITEIDAIRININBTN_LINKBUTTONS3 %>   : <%= SITEISEIKYUUINFO + LABEL %>,
          <% } %>
          <%= SIHARAISAKIKOUZAJOUHOUBTN_LINKBUTTONS3 %>    : <%= VIEWKHTKSHRSIHARAIKOUZAINFO + LABEL %>,
          <%= DAIRITENJOUHOUBTN_LINKBUTTONS3 %>    : <%= DAIRITENINFO1 + LABEL %>,
          <%= SYHENKOUYJOUHOUBTN_LINKBUTTONS3 %>   : <%= SAISYUHENKOINFO + LABEL %>,
      };

      for(btnId in linkList){
          $(document).on('click', btnId, function(){
              var thisId = $(this).attr('id');
              gotoTarget(linkList['#' + thisId]);
          });
      }

    addTopBottomLink(<%= DAIRITENINFO4 %>);
    addTopBottomLink(<%= SAISYUHENKOINFO2 %>);

    <% if (BizNumber.ZERO.equals(uiBean.getDispbunwari1())) { %>
    $(<%=DISPBUNWARI1_DAIRITENINFO1%>).visible(false);
    $(<%=DISPBUNWARI1_DAIRITENINFO1_UNIT%>).visible(false);
    <% } %>

    <% if (BizNumber.ZERO.equals(uiBean.getDispbunwari2())) { %>
    $(<%=DISPBUNWARI2_DAIRITENINFO2%>).visible(false);
    $(<%=DISPBUNWARI2_DAIRITENINFO2_UNIT%>).visible(false);
    <% } %>


    <% if (!BizUtil.isBlank(uiBean.getSmbckanriid())) { %>
    showKoumoku(<%= SMBCKANRIID_DAIRITENINFO4 %>);
    <% } %>

    <% if (C_UmuKbn.ARI.eq(uiBean.getVshktsbkyuuhukinuktumu())) {%>
      $(<%= SBUKTNININFO + LABEL %>).text("●死亡給付金受取人");
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_SEARCHRESULT) { %>

      $("<%= DISPSYONO_LABEL %>").attr("rowspan","4");
      $("<%= DISPTSINTELNO_LABEL %>").attr("rowspan","2");
      $("<%= DISPKYKSEIYMD_LABEL %>").attr("rowspan","2");
      $("<%= DISPSYOUHNNM_LABEL %>").attr("rowspan","2");
      $("<%= DISPKYKNMKJ_LABEL %>").attr("colspan","1");
      $("<%= DISPHHKNNMKN_LABEL %>").attr("colspan","1");
      $("<%= DISPDAI2TSINTELNO_LABEL %>").attr("rowspan","2");
      $("<%= DISPHHNSEIYMD_LABEL %>").attr("rowspan","2");
      $("<%= DISPYUUKOUSYOUMETUKBN_LABEL %>").attr("rowspan","2");
      $("<%= DISPHHKNNMKJ_LABEL %>").attr("colspan","1");

      $("<%= DISPSYONO_DATA %>").attr("rowspan","4");
      $("<%= DISPTSINTELNO_DATA %>").attr("rowspan","2");
      $("<%= DISPKYKSEIYMD_DATA %>").attr("rowspan","2");
      $("<%= DISPSYOUHNNM_DATA %>").attr("rowspan","2");
      $("<%= DISPKYKNMKJ_DATA %>").attr("colspan","1");
      $("<%= DISPHHKNNMKN_DATA %>").attr("colspan","1");
      $("<%= DISPDAI2TSINTELNO_DATA %>").attr("rowspan","2");
      $("<%= DISPHHNSEIYMD_DATA %>").attr("rowspan","2");
      $("<%= DISPYUUKOUSYOUMETUKBN_DATA %>").attr("rowspan","2");
      $("<%= DISPHHKNNMKJ_DATA %>").attr("colspan","1");

    <% } %>

    <% if (uiBean.getPageNo() == PAGENO_TTDKSYOUSAI) { %>
      <% if (uiBean.getHenkounaiyouListDataSource().getAllData().size() > 0) { %>
      showGroup(<%=HENKOUNAIYOULIST%>);
      <% } %>
    <% } %>

    <% if (uiBean.getPageNo() == PAGENO_NYUUKINRIREKI) { %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getTtdkrrkumu())) { %>
      $(<%=TTDKRRKBTNBYNYUUKINRIREKI_HEADERBUTTONS3%>).visible(true);
      <% } %>

      $(<%= NKRRKBTNBYNYUUKINRIREKI_HEADERBUTTONS3 %>).disable(true);

      <% if (C_UmuKbn.ARI.eq(uiBean.getTumitateRirekiUmuKbn())) { %>
        $(<%=TMTTKNRRKBTNBYNYUUKINRIREKI_HEADERBUTTONS3%>).visible(true);
      <% } %>

      <% if (C_UmuKbn.ARI.eq(uiBean.getKyknaiyouosiraseKngnUmu())) { %>
        $(<%=KYKNYSRSSKSBTNBYNYKNRRK_HEADERBUTTONS3%>).visible(true);
      <% } %>

      <% if (C_UmuKbn.ARI.eq(uiBean.getSyouraiKaiyakuhenreikinKngnUmu())) { %>
        $(<%=SYRKIYKHKBTNBYNYUUKINRIREKI_HEADERBUTTONS8%>).visible(true);
      <% } %>

      <% if (C_UmuKbn.ARI.eq(uiBean.getKaiyakuKngnUmu())) { %>
        $(<%=KAIYAKUBTNBYNYUUKINRIREKI_HEADERBUTTONS8%>).visible(true);
      <% } %>

      <% if (C_UmuKbn.NONE.eq(uiBean.getItijiDispUmu())) { %>
      showKoumoku(<%=DISPJKIPJYTYM_KIHONINFO%>);
      showKoumoku(<%=NEXTANNAIYOTEIYMD_KIHONINFO%>);
      showKoumoku(<%=HRKKJT_KIHONINFO%>);
      showKoumoku(<%=YYKKNMNRYYMD_KIHONINFO%>);
      <% } %>

      <% if (C_DispKbn.HYOUJI.eq(uiBean.getKawaserateDispKbn())) { %>
        showGroup(<%= KAWASERATENAIYOUINFO %>);
        <% if (C_KahiKbn.KA.eq(uiBean.getKawaserateKahiKbn())) { %>
          showGroup(<%= KAWASERATEMESSAGEINFO1 %>);
          $(<%= KAWASERATEMESSAGEINFO1 + DIV%>).css("margin-top", "-1px");
        <%
        } else { %>
          showGroup(<%= KAWASERATEMESSAGEINFO2 %>);
          $(<%= KAWASERATEMESSAGEINFO2 + DIV%>).css("margin-top", "-1px");
        <% } %>
      <% } %>

      <% if (uiBean.getAnnaiNo1() != null) { %>
        showGroup(<%= ANNAIINFO1 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro1())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN1_ANNAIINFO1%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro1())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN1_ANNAIINFO1%>);
        <% } %>
      <% } %>
      <% if (uiBean.getAnnaiNo2() != null) { %>
        showGroup(<%= ANNAIINFO2 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro2())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN2_ANNAIINFO2%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro2())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN2_ANNAIINFO2%>);
        <% } %>
      <% } %>
      <% if (uiBean.getAnnaiNo3() != null) { %>
        showGroup(<%= ANNAIINFO3 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro3())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN3_ANNAIINFO3%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro3())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN3_ANNAIINFO3%>);
        <% } %>
      <% } %>
      <% if (uiBean.getAnnaiNo4() != null) { %>
        showGroup(<%= ANNAIINFO4 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro4())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN4_ANNAIINFO4%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro4())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN4_ANNAIINFO4%>);
        <% } %>
      <% } %>
      <% if (uiBean.getAnnaiNo5() != null) { %>
        showGroup(<%= ANNAIINFO5 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro5())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN5_ANNAIINFO5%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro5())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN5_ANNAIINFO5%>);
        <% } %>
      <% } %>
      <% if (uiBean.getAnnaiNo6() != null) { %>
        showGroup(<%= ANNAIINFO6 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro6())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN6_ANNAIINFO6%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro6())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN6_ANNAIINFO6%>);
        <% } %>
      <% } %>
      <% if (uiBean.getAnnaiNo7() != null) { %>
        showGroup(<%= ANNAIINFO7 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro7())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN7_ANNAIINFO7%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro7())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN7_ANNAIINFO7%>);
        <% } %>
      <% } %>
      <% if (uiBean.getAnnaiNo8() != null) { %>
        showGroup(<%= ANNAIINFO8 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro8())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN8_ANNAIINFO8%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro8())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN8_ANNAIINFO8%>);
        <% } %>
      <% } %>
      <% if (uiBean.getAnnaiNo9() != null) { %>
        showGroup(<%= ANNAIINFO9 %>);
        <% if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro9())) { %>
            showKoumoku(<%=DISPCREDITURAGNGJIYUUKBN9_ANNAIINFO9%>);
        <% } %>
        <%
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro9())) { %>
            showKoumoku(<%=DISPHURIHUNOKBN9_ANNAIINFO9%>);
        <% } %>
      <% } %>

      <% if (uiBean.getNyuukinRirekiInfoDataSource().getAllData().size() > 0) {%>
        showGroup(<%= NYUUKINRIREKIINFO %>);

        <% for (int i=0;i<uiBean.getNyuukinRirekiInfoDataSource().getAllData().size();i++) { %>
          <% if (BizNumber.ZERO.equals(uiBean.getNyuukinRirekiInfoDataSource().getAllData().get(i).getDispkawaserate())) { %>
              $(<%=DISPKAWASERATE_NYUUKINRIREKIINFO(i)%>).visible(false);
              $(<%=NYUUKINRIREKIINFO_DISPRSTUUKASYUSUFFIX(i)%>).visible(false);
              $(<%=DISPRSTUUKASYU_NYUUKINRIREKIINFO(i)%>).visible(false);
              $(<%=DISPKYKTUUKASYU_NYUUKINRIREKIINFO(i)%>).visible(false);
          <% } %>
        <% } %>
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_TUMITATEKINRIREKI) { %>
    <% if (C_Syorikeiyu.KEYINPUT.eq(uiBean.getSyoriKeiyuKbn())) { %>
        $(<%=MODORUBTNBYTMTTKNRIREKI_FOOTERBUTTONS7%>).visible(true);
    <% } %>
    <% if (C_Syorikeiyu.SRCH.eq(uiBean.getSyoriKeiyuKbn())) { %>
        $(<%=SRCRSLTMDRBTNBYTMTTKNRIREKI_FOOTERBUTTONS7%>).visible(true);
    <% } %>

    <% if (C_UmuKbn.ARI.eq(uiBean.getTtdkrrkumu())) { %>
        $(<%=TTDKRRKBTNBYTMTTKNRIREKI_HEADERBUTTONS5%>).visible(true);
    <% } %>

    $(<%= TMTTKNRRKBTNBYTMTTKNRIREKI_HEADERBUTTONS5 %>).disable(true);

    <% if (C_UmuKbn.ARI.eq(uiBean.getKyknaiyouosiraseKngnUmu())) { %>
      $(<%=KYKNYSRSSKSBTNTMTTKNRRK_HEADERBUTTONS5%>).visible(true);
    <% } %>

      <% if (C_UmuKbn.ARI.eq(uiBean.getSyouraiKaiyakuhenreikinKngnUmu())) { %>
        $(<%=SYRKIYKHKBTNBYTMTTKNRIREKI_HEADERBUTTONS9%>).visible(true);
      <% } %>

      <% if (C_UmuKbn.ARI.eq(uiBean.getKaiyakuKngnUmu())) { %>
        $(<%=KAIYAKUBTNBYTMTTKNRIREKI_HEADERBUTTONS9%>).visible(true);
      <% } %>

    <% if (uiBean.getHokenryouTmttInfoDataSource().getAllData().size() > 0) { %>
        showList(<%=HOKENRYOUTMTTINFO%>);
    <% } %>

    <% if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn()) { %>
        showKoumoku(<%=DISPTMTTKNZOUKARITUJYGN_SISUURENDOUTMTTINFO%>);
        showKoumoku(<%=DISPKYKJISISUURENDOURATE_SISUURENDOUTMTTINFO%>);
    <% } %>

    <% if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) { %>
        showKoumoku(<%=DISPRENDOURITU_SISUURENDOUTMTTINFO%>);
        showKoumoku(<%=DISPKYKJISISUURENDOURATE2_SISUURENDOUTMTTINFO%>);
    <% } %>

  <% } %>
});
//-->
</script>
