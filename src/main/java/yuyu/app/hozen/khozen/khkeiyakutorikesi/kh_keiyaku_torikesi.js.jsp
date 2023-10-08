<%--
    kh_keiyaku_torikesi.js.jsp - 契約取消 JavaScript(JSP)
--%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkeiyakutorikesi.KhKeiyakuTorikesiConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkeiyakutorikesi.KhKeiyakuTorikesiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khkeiyakutorikesi.KhKeiyakuTorikesiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<%@page import="jp.co.slcs.swak.number.BizCurrency" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.def.classification.C_KyktrksKbn" %>
<%@page import="yuyu.def.classification.C_FiSiyouKbn" %>
<%@page import="yuyu.def.classification.C_SoukinsakisiteiKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<%@page import="yuyu.def.classification.C_Hrkkeiro" %>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil" %>
<% KhKeiyakuTorikesiUiBean uiBean = SWAKInjector.getInstance(KhKeiyakuTorikesiUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);%>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<%
  if (uiBean.getPageNo() != PAGENO_INPUTKEY) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp" />
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhaitoukin/view_haitoukin.js.jsp" />
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp" />
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp" />
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkhtkshrsiharaikouza/view_kh_tkshr_siharai_kouza.js.jsp" />

    <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
        <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
        <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
  <% } %>
<% }%>
<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
        <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
    <% } %>
<% }%>

<%
  if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {%>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
  <% } %>
<% }%>
<script type="text/javascript">
$(function(){
<%
   if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
      showGroup(<%=KYKTRKSSYORIINPUTINFO%>);
      showKoumoku(<%=KYKTRKSKBN_KYKTRKSSYORIINPUTINFO%>);
     $(<%= KYKTRKSSYORIINPUTINFO + DIV %>).css("margin-top", "-1px");
<% } %>

<%
  if (uiBean.getPageNo() != PAGENO_INPUTKEY) { %>
      <%
      if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
        $(<%= KOUTEIINFO + DIV%>).visible(false);
    <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    showGroup(<%=KYKTRKSSYORIINPUTINFO%>);
    showKoumoku(<%=KYKTRKSKBN_KYKTRKSSYORIINPUTINFO%>);
    <%
      if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
        <%
          if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn())) { %>
            showKoumoku(<%=SIBOUYMD_KYKTRKSSYORIINPUTINFO%>);

            <%
              if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                showKoumoku(<%=SYORUIUKEYMD_KYKTRKSSYORIINPUTINFO%>);
                showKoumoku(<%=HUBIKANRYOUYMD_KYKTRKSSYORIINPUTINFO%>);
            <% }%>
        <% }%>

        <%
          if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
            showKoumoku(<%=KAIJYOKESSAIYMD_KYKTRKSSYORIINPUTINFO%>);
            showKoumoku(<%=KAIJYOTUUTIYMD_KYKTRKSSYORIINPUTINFO%>);
            showKoumoku(<%=SYORUIUKEYMD_KYKTRKSSYORIINPUTINFO%>);
        <% }%>
    <%
      } else { %>
        <%
          if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
            <%
              if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ||
                  C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
                  C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn())) { %>
                showKoumoku(<%=SIBOUYMD_KYKTRKSSYORIINPUTINFO%>);

                inputToOutput("#sibouymdSpan > *");
                <%
                  if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                    showKoumoku(<%=SYORUIUKEYMD_KYKTRKSSYORIINPUTINFO%>);
                    showKoumoku(<%=HUBIKANRYOUYMD_KYKTRKSSYORIINPUTINFO%>);
                    inputToOutput("#syoruiukeymdSpan > *");
                    inputToOutput("#hubikanryouymdSpan > *");
                     $("#IIC1005").text("");
               <% }%>
             <% } %>
             <%
               if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                showKoumoku(<%=KAIJYOKESSAIYMD_KYKTRKSSYORIINPUTINFO%>);
                showKoumoku(<%=KAIJYOTUUTIYMD_KYKTRKSSYORIINPUTINFO%>);
                showKoumoku(<%=SYORUIUKEYMD_KYKTRKSSYORIINPUTINFO%>);

               inputToOutput("#kaijyokessaiymdSpan > *");
               inputToOutput("#kaijyotuutiymdSpan > *");
               inputToOutput("#syoruiukeymdSpan > *");
            <% }%>
        <% } %>
    <% } %>
<% }%>

<%
  if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
    showGroup(<%=KYKTRKSSYORIINPUTINFO%>);
    showKoumoku(<%=KYKTRKSKBN_KYKTRKSSYORIINPUTINFO%>);
    <%
      if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
          !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
        <%
          if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn())) { %>
            showKoumoku(<%=SIBOUYMD_KYKTRKSSYORIINPUTINFO%>);

            <%
              if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                showKoumoku(<%=SYORUIUKEYMD_KYKTRKSSYORIINPUTINFO%>);
                showKoumoku(<%=HUBIKANRYOUYMD_KYKTRKSSYORIINPUTINFO%>);
            <% }%>
        <% }%>

        <%
          if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
            showKoumoku(<%=KAIJYOKESSAIYMD_KYKTRKSSYORIINPUTINFO%>);
            showKoumoku(<%=KAIJYOTUUTIYMD_KYKTRKSSYORIINPUTINFO%>);
            showKoumoku(<%=SYORUIUKEYMD_KYKTRKSSYORIINPUTINFO%>);
        <% }%>
    <% }%>
    <%
      if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
          !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
        <%
          if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
              showGroup(<%=SIHARAINAIYOUINFOYEN%>);
               <%
               if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                   <%
                     if(C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                       showGroup(<%=KIYKHRSYOUSAIINFO%>);
                       showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUHR_KIYKHRSYOUSAIINFO%>);
                       showKoumoku(<%=KIYKHRSYOUSAIPTUMITATEKIN_KIYKHRSYOUSAIINFO%>);
                       <%
                       if(C_UmuKbn.ARI.eq(uiBean.getMvatekiumu())) { %>
                          showKoumoku(<%=KIYKHRSYOUSAISJKKKTYOUSEIRT_KIYKHRSYOUSAIINFO%>);
                       <% } %>
                       <%
                       if (C_UmuKbn.ARI.eq(uiBean.getKaiyakukoujyoritutekiumu())) { %>
                         showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJGK_KIYKHRSYOUSAIINFO%>);
                         showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJRITU_KIYKHRSYOUSAIINFO%>);
                    <% }%>
                   <% } %>
               <% } %>

              <%
              if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                $(<%=JPYSHRGKGOUKEISYOUKAI_SIHARAINAIYOUINFOYEN + LABEL%>).text("支払額合計");
                $(<%=JPYSHRGKGOUKEISYOUKAI_SIHARAINAIYOUINFOYEN%>).parent().find("span").eq(0).text("");

                <%
                if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                  showKoumoku(<%=YENDTHNKKAIYAKUHR_SIHARAINAIYOUINFOYEN%>);

                  <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                    showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                    showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                  <% } %>

                  <%
                  if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                    showKoumoku(<%=SONOTASEISAN_SIHARAINAIYOUINFOYEN%>);
                  <% } %>

                <%
                } else if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) { %>
                  showKoumoku(<%=YENDTHNKKAIYAKUHR_SIHARAINAIYOUINFOYEN%>);
                  showKoumoku(<%=YENKAHAITOUKIN_SIHARAINAIYOUINFOYEN%>);
                  showKoumoku(<%=YENTKBTHAITOUKIN_SIHARAINAIYOUINFOYEN%>);

                  <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                    showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                    showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                  <% } %>
                <%
                } else { %>
                  showKoumoku(<%=YENDTHNKPTUMITATEKIN_SIHARAINAIYOUINFOYEN%>);
                  showKoumoku(<%=YENKAHAITOUKIN_SIHARAINAIYOUINFOYEN%>);
                  showKoumoku(<%=YENTKBTHAITOUKIN_SIHARAINAIYOUINFOYEN%>);

                  <%
                  if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                     showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                     showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                     showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                  <% } %>
                <% } %>
              <%
              } else { %>
               $(<%=SIHARAINAIYOUINFOYEN + LABEL%>).text("");
                showGroup(<%=SIHARAINAIYOUINFOGK%>);
                $(<%=JPYSHRGKGOUKEISYOUKAI_SIHARAINAIYOUINFOYEN%>).parent().find("span").eq(2).text("");
                showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);
                showGroup(<%=SNTSHRGKSSSIHARAIWASERATE%>);
                showGroup(<%=SNTSHRGKSSYENSONOTASHRGKINFO%>);
                showKoumoku(<%=AZUKARIKINKYKHNKKAIYAKUHR_SIHARAINAIYOUINFOGK%>);
                showKoumoku(<%=SONOTASHRGK_SIHARAINAIYOUINFOGK%>);

                showKoumoku(<%=YENAZUKARIKINKYKHNKMIKEIKAP_SIHARAINAIYOUINFOYEN%>);

                <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=MIKEIKAP_SIHARAINAIYOUINFOGK%>);
                    showKoumoku(<%=ZENNOUSEISANKGK_SIHARAINAIYOUINFOGK%>);
                <% } %>

                <%
                if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                  showKoumoku(<%=SNTSHRGKSSYENHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                  showKoumoku(<%=SNTSHRGKSSYENTKBTHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                  showKoumoku(<%=YENKAHAITOUKIN_SIHARAINAIYOUINFOYEN%>);
                  showKoumoku(<%=YENTKBTHAITOUKIN_SIHARAINAIYOUINFOYEN%>);

                <%}%>

                <%
                if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                  showKoumoku(<%=KAIYAKUHR_SIHARAINAIYOUINFOGK%>);
                  showKoumoku(<%=KAIYAKUHRYEN_SIHARAINAIYOUINFOYEN%>);
                  <%
                  if(C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                     showGroup(<%=SIHARAISYOUSAIINFO%>);
                     showKoumoku(<%=SHRSYOUSAIKAIYAKUHR_SIHARAISYOUSAIINFO%>);
                     showKoumoku(<%=SHRSYOUSAIJPYKAIYAKUHR_SIHARAISYOUSAIINFO%>);
                     showGroup(<%=SHRKWSRATEINFO%>);
                  <% } %>
                  <%
                  if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                     showGroup(<%=YENKIYKHRSSINFO%>);
                     showGroup(<%=YENKIYKHRSSSHRKWSRATEINFO%>);
                     showGroup(<%=YENKIYKHRSSGOUKEIINFO%>);

                     showKoumoku(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                     showKoumoku(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                     showKoumoku(<%=SNTSHRGKSSYENKAKRKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);

                     showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                     showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                     showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                  <% } %>
                  <%
                  if (uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                      uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) { %>
                     showGroup(<%=PTUMITATEKINSYOUSAIINFO%>);
                  <% }%>
                <%
                } else { %>
                  showKoumoku(<%=PTUMITATEKIN_SIHARAINAIYOUINFOGK%>);
                  showKoumoku(<%=JPYPTUMITATEKIN_SIHARAINAIYOUINFOYEN%>);
                  <%
                  if(C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                     showGroup(<%=SIHARAISYOUSAIINFO%>);
                     showKoumoku(<%=SHRSYOUSAIPTUMITATEKIN_SIHARAISYOUSAIINFO%>);
                     showKoumoku(<%=SHRSYOUSAIJPYPTUMITATEKIN_SIHARAISYOUSAIINFO%>);
                     showGroup(<%=SHRKWSRATEINFO%>);
                  <% } %>
                  <%
                  if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showGroup(<%=YENPTMTTSSINFO%>);
                    showGroup(<%=YENPTMTTSSSIHARAIWASERATE%>);
                    showGroup(<%=YENPTMTTSSGOUKEIINFO%>);

                    showKoumoku(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENKAKRKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);

                    showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                    showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                    showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                  <% } %>
                <% }%>
            <% } %>

            $(<%=COLSPAN1_CLASS%>).attr('colspan', '1');
            $(<%=ROWSPAN2_CLASS%>).attr('rowspan', '2');
            $(<%=ROWSPAN4_CLASS%>).attr('rowspan', '4');
            $(<%=ROWSPAN7_CLASS%>).attr('rowspan', '7');
            $(<%=ROWSPAN6_CLASS%>).attr('rowspan', '6');
            $(<%=ROWSPAN12_CLASS%>).attr('rowspan', '12');

            $(<%=DISPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOGK%>).parent().removeClass('alignRight');
            $(<%=DISPJPTIENRSKKISANYMDNISSUU_SIHARAINAIYOUINFOYEN%>).parent().removeClass('alignRight');

        <% } %>
        <%
          if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) { %>
            showGroup(<%=SIHARAIINFO%>);
            showKoumoku(<%=KIHRKMP_SIHARAIINFO%>);
            <%
               if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                showKoumoku(<%=KRKGK_SIHARAIINFO%>);
            <% } %>
            $(<%=ROWSPAN2_CLASS%>).attr('rowspan', '2');
            $(<%=COLSPAN1_CLASS%>).attr('colspan', '1');
       <% }%>
    <% }%>
    <%
      if (uiBean.getKawaserateMinasiKbn() != KAWASERATE_MINASI && !C_FiSiyouKbn.TJTSI.eq(uiBean.getFiSiyouKbn()) &&
          !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>

      <%
        if ((!uiBean.getShrgkgoukeisyoukai().isOptional()  && uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) ||
            (!uiBean.getJpyshrgkgoukeisyoukai().isOptional() && uiBean.getJpyshrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0,uiBean.getJpyshrgkgoukeisyoukai().getType())) > 0)||
                (!uiBean.getYendthnkshrgkgoukeisyoukai().isOptional()  && uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
                    BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0)  ||
                  (!uiBean.getNykntuukashrgkgoukeisyoukai().isOptional() && uiBean.getNykntuukashrgkgoukeisyoukai().compareTo(
                      BizCurrency.valueOf(0, uiBean.getNykntuukashrgkgoukeisyoukai().getType())) > 0 )) { %>
          <%
            if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
              <%
                if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                  showGroup(<%=ENSINKBNINFO%>);
                  inputToOutput(<%=SINSAGENDOKKNKBN_ENSINKBNINFO%>);
                  inputToOutput(<%=RIKOUKITYUUTUUDANNISSUU_ENSINKBNINFO%>);
              <% }%>
              <%
                if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ) { %>
                  showGroup(<%=ENSINKBNINFO%>);
              <% }%>
          <% }%>
          <%
            if (C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
              <%
                if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                  showGroup(<%=SOUKINSAKISITEIINFO%>);
                  inputToOutput(<%=SOUKINSAKISITEIKBN_SOUKINSAKISITEIINFO%>);
                  <%
                    if (C_SoukinsakisiteiKbn.SONOTA.eq(uiBean.getSoukinsakisiteikbn())) { %>
                      showGroup(<%=SOUHUSAKIINFO1%>);
                      showGroup(<%=SOUHUSAKIINFO2%>);
                      inputToOutput(<%=SOUKINSAKINMKN_SOUHUSAKIINFO1%>);
                      inputToOutput(<%=SOUKINSAKINMKJ_SOUHUSAKIINFO1%>);
                      inputToOutput(<%=SOUKINSAKIYNO_SOUHUSAKIINFO2%>);
                      inputToOutput(<%=SOUKINSAKIADR1KJ_SOUHUSAKIINFO2%>);
                      inputToOutput(<%=SOUKINSAKIADR2KJ_SOUHUSAKIINFO2%>);
                      inputToOutput(<%=SOUKINSAKIADR3KJ_SOUHUSAKIINFO2%>);
                  <% }%>
                  <%
                    if (C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(uiBean.getSoukinsakisiteikbn())) { %>
                      showGroup(<%=KYKSYASZKINFO1%>);
                      showGroup(<%=KYKSYASZKINFO2%>);
                      inputToOutput(<%=KYKSYASZKNMKN_KYKSYASZKINFO1%>);
                      inputToOutput(<%=KYKSYASZKNMKJ_KYKSYASZKINFO1%>);
                      inputToOutput(<%=KYKSYASZKYNO_KYKSYASZKINFO2%>);
                      inputToOutput(<%=KYKSYASZKADR1KJ_KYKSYASZKINFO2%>);
                      inputToOutput(<%=KYKSYASZKADR2KJ_KYKSYASZKINFO2%>);
                      inputToOutput(<%=KYKSYASZKADR3KJ_KYKSYASZKINFO2%>);
                  <% }%>
              <% }%>

              <%
                if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ) { %>
                  showGroup(<%=SOUKINSAKISITEIINFO%>);
                  showGroup(<%=SOUHUSAKIINFO1%>);
                  showGroup(<%=SOUHUSAKIINFO2%>);
                  showGroup(<%=KYKSYASZKINFO1%>);
                  showGroup(<%=KYKSYASZKINFO2%>);
                  <%
                    if (C_SoukinsakisiteiKbn.SONOTA.eq(uiBean.getSoukinsakisiteikbn())) { //%>
                      setKyksyaszkInfoGroupDisable();
                  <% }%>
                  <%
                    if (C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(uiBean.getSoukinsakisiteikbn())) { //%>
                      setSouhusakiInfoGroupDisable();
                  <% }%>
                  <%
                    if (!C_SoukinsakisiteiKbn.SONOTA.eq(uiBean.getSoukinsakisiteikbn()) &&
                        !C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(uiBean.getSoukinsakisiteikbn())) { //%>
                      setSouhusakiInfoGroupDisable();
                      setKyksyaszkInfoGroupDisable();
                  <% }%>

                  $(<%=SOUKINSAKISITEIKBN_SOUKINSAKISITEIINFO%>).change( function() {

                  var value = $(<%=SOUKINSAKISITEIKBN_SOUKINSAKISITEIINFO%>).val();
                  if ( value == "<%=C_SoukinsakisiteiKbn.SONOTA.getValue()%>") {
                      setSouhusakiInfoGroupEnable();
                      setKyksyaszkInfoGroupDisable();
                      setUktmnmeigibangouEnable();
                   }
                   else if ( value == "<%=C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.getValue()%>") {
                      setSouhusakiInfoGroupDisable();
                      setKyksyaszkInfoGroupEnable();
                      setUktmnmeigibangouEnable();
                   }
                   else {
                      setSouhusakiInfoGroupDisable();
                      setKyksyaszkInfoGroupDisable();
                      setUktmnmeigibangouDisable();
                   }
                  });

              <% }%>
          <% }%>

          <%
            if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>

              <%
                if ((C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
                     C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                     C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) &&
                    !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                  <%
                    if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                        C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
                        C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ) { %>
                      showGroup(<%=YENSHRTKUMUINFO%>);

                      $("input[id^='yenshrtkumu']").change(function() {
                        var value = $("input[id^='yenshrtkumu']:checked").val();
                        if ( value == "<%=C_UmuKbn.NONE.getValue()%>" ) {
                           setYokinKbnAndKzdouKbn();
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
                      });
                    <% }%>
                  <%
                    if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                       !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                      showGroup(<%=YENSHRTKUMUINFO%>);
                      inputToOutput("#yenshrtkumuSpan > *");
                  <% }%>
              <% }%>

              <%
                if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ) { %>
                      showGroup(<%=INPUTSHRHOUSITEIKBNINFO%>);
                      showGroup(<%=KOUZAINFO%>);

                  <%
                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                        <%
                          if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) { %>
                              showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                        <% }%>
                        <%
                          if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
                              showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                        <% }%>
                  <% }%>
                      $(<%=BANKCD_KOUZAINFO + SPAN%>).addClass("inputSpan");
                      $(<%=SITENCD_KOUZAINFO + SPAN%>).addClass("inputSpan");
                      $(<%=YOKINKBN_KOUZAINFO + SPAN%>).addClass("inputSpan");
                      $(<%=KOUZANO_KOUZAINFO + SPAN%>).addClass("inputSpan");
                      $(<%=KZDOUKBN_KOUZAINFO + SPAN%>).addClass("inputSpan");

                  <%
                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                        showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
                        showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
                      <%
                        if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()) && !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {%>
                          setYokinKbnAndKzdouKbn();
                      <% }%>
                  <% }%>
                  <%
                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) { %>
                      showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);
                      showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
                      showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
                      <%
                        if (!C_Tuukasyu.JPY.eq(uiBean.getRstuukasyu())) { %>
                          setYokinKbnAndKzdouKbn();
                      <% }%>
                  <% }%>
                  <%
                    if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                      showGroup(<%=MNMEIGIBANGOUINFO%>);
                      <%
                        if (C_SoukinsakisiteiKbn.BLNK.eq(uiBean.getSoukinsakisiteikbn()) ||
                            C_SoukinsakisiteiKbn.KYK.eq(uiBean.getSoukinsakisiteikbn())) { %>
                           setUktmnmeigibangouDisable();
                      <% }%>

                  <% }%>
              <% }%>

              <%
                if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                  showGroup(<%=INPUTSHRHOUSITEIKBNINFO%>);
                  inputToOutput(<%=INPUTSHRHOUSITEIKBN_INPUTSHRHOUSITEIKBNINFO%>);
                  showGroup(<%=KOUZAINFO%>);

                  <%
                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                       <%
                         if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) { %>
                           showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                           inputToOutput(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                       <% }%>
                       <%
                          if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
                           showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                           inputToOutput(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                      <% }%>
                  <% }%>

                  inputToOutput(<%=BANKCD_KOUZAINFO%>);
                  inputToOutput(<%=SITENCD_KOUZAINFO%>);
                  inputToOutput(<%=KOUZANO_KOUZAINFO%>);
                  inputToOutput(<%=KZMEIGINMKN_KOUZAINFO%>);
                  <%
                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                      <%
                        if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) || C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                          showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
                          showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
                          inputToOutput(<%=YOKINKBN_KOUZAINFO%>);
                          inputToOutput(<%=KZDOUKBN_KOUZAINFO%>);
                          $("#IBC1003").text("");
                          $("#IIC1003").text("");
                      <% }%>
                  <% }%>

                  <%
                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) { %>

                      showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);

                      <%
                        if (C_Tuukasyu.JPY.eq(uiBean.getRstuukasyu())) { %>
                          showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
                          showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
                          inputToOutput(<%=YOKINKBN_KOUZAINFO%>);
                          inputToOutput(<%=KZDOUKBN_KOUZAINFO%>);
                          $("#IBC1003").text("");
                          $("#IIC1003").text("");
                      <% }%>
                  <% }%>

                  $("#IBC1001").text("");
                  $("#IBC1002").text("");
                  $("#IBC1004").text("");

                  <%
                    if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                      showGroup(<%=MNMEIGIBANGOUINFO%>);
                      inputToOutput(<%=KYKMNMEIGIBANGOU_MNMEIGIBANGOUINFO%>);
                      inputToOutput(<%=UKTMNMEIGIBANGOU_MNMEIGIBANGOUINFO%>);
                  <% }%>
              <% }%>
          <% }%>
      <% }%>
      $(<%=KAKUNINBTN_FOOTERBUTTONS3%>).visible(true);

      <%
         if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
             !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()))) { %>
            showGroup(<%=HONNINKAKUNININFO%>);
            <%
              if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                  !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                  inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNINKAKUNININFO%>);
            <% }%>
      <% }%>

      showGroup(<%=COMMENTINFO%>);
      <%
        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
          showKoumoku(<%=SASIMODOSISAKIKBN_COMMENTINFO%>);
      <% }%>
    <% }%>
<% }%>
<%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    showGroup(<%=KYKTRKSSYORIINPUTINFO%>);
    showKoumoku(<%=KYKTRKSKBN_KYKTRKSSYORIINPUTINFO%>);
    <%
      if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
          !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
        <%
          if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn())) { %>
            showKoumoku(<%=SIBOUYMD_KYKTRKSSYORIINPUTINFO%>);

            <%
              if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                showKoumoku(<%=SYORUIUKEYMD_KYKTRKSSYORIINPUTINFO%>);
                showKoumoku(<%=HUBIKANRYOUYMD_KYKTRKSSYORIINPUTINFO%>);
            <% }%>
        <% }%>

        <%
          if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
            showKoumoku(<%=KAIJYOKESSAIYMD_KYKTRKSSYORIINPUTINFO%>);
            showKoumoku(<%=KAIJYOTUUTIYMD_KYKTRKSSYORIINPUTINFO%>);
            showKoumoku(<%=SYORUIUKEYMD_KYKTRKSSYORIINPUTINFO%>);
        <% }%>
    <% }%>

    <%
      if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
          !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
        <%
          if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
             showGroup(<%=SIHARAINAIYOUINFO%>);
             showGroup(<%=ZEIMUINFO%>);
             <%
             if (uiBean.getKykHnkKaisuu() > 0) { %>
               showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
             <% } %>
             <%
               if(C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                 showGroup(<%=KIYKHRSYOUSAIINFO%>);
                 showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUHR_KIYKHRSYOUSAIINFO%>);
                 showKoumoku(<%=KIYKHRSYOUSAIPTUMITATEKIN_KIYKHRSYOUSAIINFO%>);
                 <%
                 if (C_UmuKbn.ARI.eq(uiBean.getMvatekiumu())) { %>
                     showKoumoku(<%=KIYKHRSYOUSAISJKKKTYOUSEIRT_KIYKHRSYOUSAIINFO%>);
                 <% } %>
                 <%
                 if (C_UmuKbn.ARI.eq(uiBean.getKaiyakukoujyoritutekiumu())) { %>
                   showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJGK_KIYKHRSYOUSAIINFO%>);
                   showKoumoku(<%=KIYKHRSYOUSAIKAIYAKUKJRITU_KIYKHRSYOUSAIINFO%>);
                 <% }%>
             <% } %>
             <%
             if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) { %>
                 showGroup(<%=SIHARAINAIYOUINFOYEN%>);
                 <%
                 if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) { %>
                   showKoumoku(<%=YENKAHAITOUKIN_SIHARAINAIYOUINFOYEN%>);
                   showKoumoku(<%=YENTKBTHAITOUKIN_SIHARAINAIYOUINFOYEN%>);
                 <% } %>
                <%
                if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                    showKoumoku(<%=YENDTHNKKAIYAKUHR_SIHARAINAIYOUINFOYEN%>);

                    <%
                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                       <%
                       if (C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                          showKoumoku(<%=SONOTASEISAN_SIHARAINAIYOUINFOYEN%>);
                       <% } %>
                    <% } %>
                    $(<%=JPYSHRGKGOUKEIKAKUNIN_SIHARAINAIYOUINFOYEN + LABEL%>).text("支払額合計");
                    $(<%=JPYSHRGKGOUKEIKAKUNIN_SIHARAINAIYOUINFOYEN%>).parent().find("span").eq(0).text("");

                    <%
                    if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                       showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                       showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                       showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                    <% } %>
                <%
                } else { %>
                   showKoumoku(<%=YENAZUKARIKINKYKHNKMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                   $(<%=JPYSHRGKGOUKEIKAKUNIN_SIHARAINAIYOUINFOYEN%>).parent().find("span").eq(2).text("");
                   showKoumoku(<%=KAIYAKUHRYEN_SIHARAINAIYOUINFOYEN%>);

                   <%
                   if(C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                       showGroup(<%=SIHARAISYOUSAIINFO%>);
                       showKoumoku(<%=SHRSYOUSAIKAIYAKUHR_SIHARAISYOUSAIINFO%>);
                       showKoumoku(<%=SHRSYOUSAIJPYKAIYAKUHR_SIHARAISYOUSAIINFO%>);
                       showGroup(<%=SHRKWSRATEINFO%>);
                   <% } %>
                   <%
                   if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                       showGroup(<%=YENKIYKHRSSINFO%>);
                       showGroup(<%=YENKIYKHRSSSHRKWSRATEINFO%>);
                       showGroup(<%=YENKIYKHRSSGOUKEIINFO%>);

                       showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                       showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                       showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                   <% } %>

                  <%
                  if (uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                      uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) { %>
                     showGroup(<%=PTUMITATEKINSYOUSAIINFO%>);
                   <% } %>
                  <%
                  if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) { %>
                    showKoumoku(<%=YENKAHAITOUKIN_SIHARAINAIYOUINFOYEN%>);
                    showKoumoku(<%=YENTKBTHAITOUKIN_SIHARAINAIYOUINFOYEN%>);
                  <% } %>

                <% } %>

                 $(<%=SYNYKNGK_ZEIMUINFO%>).addClass('innerLeftZeimuInfo');
                 $(<%=SYNYKNGK_ZEIMUINFO%>).addClass('zeimuInfoLeftCell');

             <%
             } else { %>
               showGroup(<%=SIHARAINAIYOUINFOGK%>);

               showKoumoku(<%=KAIYAKUHR_SIHARAINAIYOUINFOGK%>);
               showKoumoku(<%=AZUKARIKINKYKHNKKAIYAKUHR_SIHARAINAIYOUINFOGK%>);
               showKoumoku(<%=SONOTASHRGK_SIHARAINAIYOUINFOGK%>);

               showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);
               showGroup(<%=SNTSHRGKSSSIHARAIWASERATE%>);
               showGroup(<%=SNTSHRGKSSYENSONOTASHRGKINFO%>);

               <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=MIKEIKAP_SIHARAINAIYOUINFOGK%>);
                    showKoumoku(<%=ZENNOUSEISANKGK_SIHARAINAIYOUINFOGK%>);
                    showKoumoku(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENKAKRKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                <% } %>

               <%
               if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) { %>
                 showKoumoku(<%=SNTSHRGKSSYENHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                 showKoumoku(<%=SNTSHRGKSSYENTKBTHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
               <% } %>

               <%
               if (uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                   uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) { %>
                 showGroup(<%=PTUMITATEKINSYOUSAIINFO%>);
               <% } %>
               showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
            <% } %>

        <% } %>

        <%
          if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
              C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ) { %>
            showGroup(<%=SIHARAINAIYOUINFO%>);
            showGroup(<%=SIHARAIINFO%>);
            showKoumoku(<%=KIHRKMP_SIHARAIINFO%>);
            <%
               if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                showKoumoku(<%=KRKGK_SIHARAIINFO%>);
            <% } %>
            $(<%=ROWSPAN2_CLASS%>).attr('rowspan', '2');
            $(<%=COLSPAN1_CLASS%>).attr('colspan', '1');
        <% } %>

        <%
          if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>

            showGroup(<%=SIHARAINAIYOUINFO%>);
            showGroup(<%=ZEIMUINFO%>);
            <%
             if (uiBean.getKykHnkKaisuu() > 0) { %>
               showKoumoku(<%=YENSHRKYKHTYKEIHI_ZEIMUINFO%>);
            <% } %>

            <%
             if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) { %>
                showGroup(<%=SIHARAINAIYOUINFOYEN%>);
                showKoumoku(<%=YENKAHAITOUKIN_SIHARAINAIYOUINFOYEN%>);
                showKoumoku(<%=YENTKBTHAITOUKIN_SIHARAINAIYOUINFOYEN%>);

                <%
                   if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                     showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                     showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                     showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                <% } %>

               <%
               if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                   $(<%=JPYSHRGKGOUKEIKAKUNIN_SIHARAINAIYOUINFOYEN + LABEL%>).text("支払額合計");
                   $(<%=JPYSHRGKGOUKEIKAKUNIN_SIHARAINAIYOUINFOYEN%>).parent().find("span").eq(0).text("");
                   showKoumoku(<%=YENDTHNKPTUMITATEKIN_SIHARAINAIYOUINFOYEN%>);

               <%
               } else { %>
                  showKoumoku(<%=YENAZUKARIKINKYKHNKMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                  $(<%=JPYSHRGKGOUKEIKAKUNIN_SIHARAINAIYOUINFOYEN%>).parent().find("span").eq(2).text("");
                  showKoumoku(<%=JPYPTUMITATEKIN_SIHARAINAIYOUINFOYEN%>);

                  <%
                  if(C_UmuKbn.ARI.eq(uiBean.getItijibrumu())) { %>
                      showGroup(<%=SIHARAISYOUSAIINFO%>);
                      showKoumoku(<%=SHRSYOUSAIPTUMITATEKIN_SIHARAISYOUSAIINFO%>);
                      showKoumoku(<%=SHRSYOUSAIJPYPTUMITATEKIN_SIHARAISYOUSAIINFO%>);
                      showGroup(<%=SHRKWSRATEINFO%>);
                  <% } %>
                  <%
                  if(C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                      showGroup(<%=YENPTMTTSSINFO%>);
                      showGroup(<%=YENPTMTTSSSIHARAIWASERATE%>);
                      showGroup(<%=YENPTMTTSSGOUKEIINFO%>);
                      showKoumoku(<%=YENKAMIKEIKAP_SIHARAINAIYOUINFOYEN%>);
                      showKoumoku(<%=YENKAZENNOUSEISANKGK_SIHARAINAIYOUINFOYEN%>);
                      showKoumoku(<%=YENKAKRKGK_SIHARAINAIYOUINFOYEN%>);
                      showKoumoku(<%=YENPTMTTSSMIKEIKAP_YENPTMTTSSGOUKEIINFO%>);
                      showKoumoku(<%=YENPTMTTSSZENNOUSEISANKIN_YENPTMTTSSGOUKEIINFO%>);
                  <% } %>
               <% } %>

               $(<%=SYNYKNGK_ZEIMUINFO%>).addClass('innerLeftZeimuInfo');
               $(<%=SYNYKNGK_ZEIMUINFO%>).addClass('zeimuInfoLeftCell');
            <%
            } else { %>
                showGroup(<%=SIHARAINAIYOUINFOGK%>);
                showKoumoku(<%=PTUMITATEKIN_SIHARAINAIYOUINFOGK%>);
                showKoumoku(<%=ZEIMUKWSRATEKJNYMD_ZEIMUINFO%>);
                showKoumoku(<%=AZUKARIKINKYKHNKKAIYAKUHR_SIHARAINAIYOUINFOGK%>);
                showKoumoku(<%=SONOTASHRGK_SIHARAINAIYOUINFOGK%>);
                showGroup(<%=SNTSHRGKSSSONOTASHRGKINFO%>);
                showGroup(<%=SNTSHRGKSSSIHARAIWASERATE%>);
                showGroup(<%=SNTSHRGKSSYENSONOTASHRGKINFO%>);
                showKoumoku(<%=SNTSHRGKSSYENHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                showKoumoku(<%=SNTSHRGKSSYENTKBTHAITOUKIN_SNTSHRGKSSYENSONOTASHRGKINFO%>);

                <%
                  if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
                    showKoumoku(<%=MIKEIKAP_SIHARAINAIYOUINFOGK%>);
                    showKoumoku(<%=ZENNOUSEISANKGK_SIHARAINAIYOUINFOGK%>);
                    showKoumoku(<%=SNTSHRGKSSYENKAMIKEIKAP_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENZENNOUSISNKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                    showKoumoku(<%=SNTSHRGKSSYENKAKRKGK_SNTSHRGKSSYENSONOTASHRGKINFO%>);
                <% } %>
            <% }%>
        <% } %>
        $(<%=COLSPAN1_CLASS%>).attr('colspan', '1');
        $(<%=ROWSPAN2_CLASS%>).attr('rowspan', '2');
        $(<%=ROWSPAN4_CLASS%>).attr('rowspan', '4');
        $(<%=ROWSPAN7_CLASS%>).attr('rowspan', '7');
        $(<%=ROWSPAN6_CLASS%>).attr('rowspan', '6');
        $(<%=ROWSPAN12_CLASS%>).attr('rowspan', '12');
    <% }%>

    <%
      if ((!uiBean.getShrgkgoukeisyoukai().isOptional()  && uiBean.getShrgkgoukeisyoukai().compareTo(
          BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) ||
          (!uiBean.getJpyshrgkgoukeisyoukai().isOptional() && uiBean.getJpyshrgkgoukeisyoukai().compareTo(
              BizCurrency.valueOf(0,uiBean.getJpyshrgkgoukeisyoukai().getType())) > 0)||
              (!uiBean.getYendthnkshrgkgoukeisyoukai().isOptional()  && uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
                  BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0)  ||
                (!uiBean.getNykntuukashrgkgoukeisyoukai().isOptional() && uiBean.getNykntuukashrgkgoukeisyoukai().compareTo(
                    BizCurrency.valueOf(0, uiBean.getNykntuukashrgkgoukeisyoukai().getType())) > 0 )) { %>
          <%
            if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
              <%
                if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                  showGroup(<%=ENSINKBNINFO%>);
              <% }%>
          <% }%>

          <%
            if (C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
              <%
                if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                  showGroup(<%=SOUKINSAKISITEIINFO%>);
                  <%
                    if (C_SoukinsakisiteiKbn.SONOTA.eq(uiBean.getSoukinsakisiteikbn())) { %>
                      showGroup(<%=SOUHUSAKIINFO1%>);
                      showGroup(<%=SOUHUSAKIINFO2%>);
                  <% }%>
                  <%
                    if (C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(uiBean.getSoukinsakisiteikbn())) { %>
                      showGroup(<%=KYKSYASZKINFO1%>);
                      showGroup(<%=KYKSYASZKINFO2%>);
                  <% }%>
              <% }%>
          <% }%>

          <%
            if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>

              <%
                if ((C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
                     C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                     C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) &&
                    !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                  <%
                    if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
                        !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                      showGroup(<%=YENSHRTKUMUINFO%>);
                  <% }%>
              <% }%>

              <%
                if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
                  showGroup(<%=INPUTSHRHOUSITEIKBNINFO%>);
                  showGroup(<%=KOUZAINFO%>);

                  $(<%=BANKCD_KOUZAINFO%>).addClass('keiyakuTorikesiFirstCell');
                  $(<%=SITENCD_KOUZAINFO%>).addClass('keiyakuTorikesiFirstCell');

                  <%
                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                         C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) { %>
                       <%
                         if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) { %>
                           showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                       <% }%>
                       <%
                         if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) { %>
                           showKoumoku(<%=SOUKINSAKIKBN_KOUZAINFO%>);
                       <% }%>

                  <% }%>

                  <%
                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                      <%
                        if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) || C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) { %>
                          showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
                          showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
                      <% }%>
                  <% }%>

                  <%
                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) { %>
                      <%
                        if (C_Tuukasyu.JPY.eq(uiBean.getRstuukasyu())) { %>
                          showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
                          showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
                      <% }%>
                  <% }%>

                  <%
                    if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                        C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) { %>
                          showKoumoku(<%=KZSYURUIKBN_KOUZAINFO%>);
                  <% }%>

                  <%
                    if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
                      showGroup(<%=MNMEIGIBANGOUINFO%>);
                  <% }%>
              <% }%>
          <% }%>
    <% }%>

    <%
      if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
          !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) { %>
        showGroup(<%=HONNINKAKUNININFO%>);
    <% }%>

    showGroup(<%=COMMENTINFO%>);
    <%
      if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
        showKoumoku(<%=SASIMODOSISAKIKBN_COMMENTINFO%>);
    <% }%>
<% }%>

 <%
   if (uiBean.getPageNo() == PAGENO_RESULT) { %>
     <%
       if (!BizUtil.isBlank(uiBean.getTyouhyouKey())) { %>
         openReport('print', '_blank');
     <%} %>
  <%} %>

function setYokinKbnAndKzdouKbn() {
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
}

function setSouhusakiInfoGroupDisable () {

    $(<%=SOUKINSAKINMKN_SOUHUSAKIINFO1%>).val("");
    setReadOnlyGray(<%=SOUKINSAKINMKN_SOUHUSAKIINFO1%>);

    $(<%=SOUKINSAKINMKJ_SOUHUSAKIINFO1%>).val("");
    setReadOnlyGray(<%=SOUKINSAKINMKJ_SOUHUSAKIINFO1%>);

    $(<%=SOUKINSAKIYNO_SOUHUSAKIINFO2%>).val("");
    setReadOnlyGray(<%=SOUKINSAKIYNO_SOUHUSAKIINFO2%>);

    $(<%=SOUKINSAKIADR1KJ_SOUHUSAKIINFO2%>).val("");
    setReadOnlyGray(<%=SOUKINSAKIADR1KJ_SOUHUSAKIINFO2%>);

    $(<%=SOUKINSAKIADR2KJ_SOUHUSAKIINFO2%>).val("");
    setReadOnlyGray(<%=SOUKINSAKIADR2KJ_SOUHUSAKIINFO2%>);

    $(<%=SOUKINSAKIADR3KJ_SOUHUSAKIINFO2%>).val("");
    setReadOnlyGray(<%=SOUKINSAKIADR3KJ_SOUHUSAKIINFO2%>);

    $(<%=SOUKINSAKIYNO_POPUP_BUTTON%>).readonly(true);
    $(<%=SOUKINSAKIYNO_SOUHUSAKIINFO2%>).removeClass("readonly");
}

function setSouhusakiInfoGroupEnable () {

    removeReadOnlyGray(<%=SOUKINSAKINMKN_SOUHUSAKIINFO1%>);

    removeReadOnlyGray(<%=SOUKINSAKINMKJ_SOUHUSAKIINFO1%>);

    removeReadOnlyGray(<%=SOUKINSAKIYNO_SOUHUSAKIINFO2%>);

    removeReadOnlyGray(<%=SOUKINSAKIADR1KJ_SOUHUSAKIINFO2%>);

    removeReadOnlyGray(<%=SOUKINSAKIADR2KJ_SOUHUSAKIINFO2%>);

    removeReadOnlyGray(<%=SOUKINSAKIADR3KJ_SOUHUSAKIINFO2%>);

    $(<%=SOUKINSAKIYNO_POPUP_BUTTON%>).readonly(false);
}

function setKyksyaszkInfoGroupDisable () {

    $(<%=KYKSYASZKNMKN_KYKSYASZKINFO1%>).val("");
    setReadOnlyGray(<%=KYKSYASZKNMKN_KYKSYASZKINFO1%>);

    $(<%=KYKSYASZKNMKJ_KYKSYASZKINFO1%>).val("");
    setReadOnlyGray(<%=KYKSYASZKNMKJ_KYKSYASZKINFO1%>);

    $(<%=KYKSYASZKYNO_KYKSYASZKINFO2%>).val("");
    setReadOnlyGray(<%=KYKSYASZKYNO_KYKSYASZKINFO2%>);

    $(<%=KYKSYASZKADR1KJ_KYKSYASZKINFO2%>).val("");
    setReadOnlyGray(<%=KYKSYASZKADR1KJ_KYKSYASZKINFO2%>);

    $(<%=KYKSYASZKADR2KJ_KYKSYASZKINFO2%>).val("");
    setReadOnlyGray(<%=KYKSYASZKADR2KJ_KYKSYASZKINFO2%>);

    $(<%=KYKSYASZKADR3KJ_KYKSYASZKINFO2%>).val("");
    setReadOnlyGray(<%=KYKSYASZKADR3KJ_KYKSYASZKINFO2%>);

    $(<%=KYKSYASZKYNO_POPUP_BUTTON%>).readonly(true);
    $(<%=KYKSYASZKYNO_KYKSYASZKINFO2%>).removeClass("readonly");
}

function setKyksyaszkInfoGroupEnable () {

    removeReadOnlyGray(<%=KYKSYASZKNMKN_KYKSYASZKINFO1%>);

    removeReadOnlyGray(<%=KYKSYASZKNMKJ_KYKSYASZKINFO1%>);

    removeReadOnlyGray(<%=KYKSYASZKYNO_KYKSYASZKINFO2%>);

    removeReadOnlyGray(<%=KYKSYASZKADR1KJ_KYKSYASZKINFO2%>);

    removeReadOnlyGray(<%=KYKSYASZKADR2KJ_KYKSYASZKINFO2%>);

    removeReadOnlyGray(<%=KYKSYASZKADR3KJ_KYKSYASZKINFO2%>);

    $(<%=KYKSYASZKYNO_POPUP_BUTTON%>).readonly(false);
}

function setUktmnmeigibangouDisable () {

  <%
    if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>

      $(<%=UKTMNMEIGIBANGOU_MNMEIGIBANGOUINFO%>).val("");
      setReadOnlyGray(<%=UKTMNMEIGIBANGOU_MNMEIGIBANGOUINFO%>);

   <% }%>
}

function setUktmnmeigibangouEnable () {
  <%
  if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) { %>
    removeReadOnlyGray(<%=UKTMNMEIGIBANGOU_MNMEIGIBANGOUINFO%>);
  <% }%>
}
});
</script>
