<%--
    si_satei_sb.js.jsp - （死亡）査定 JavaScript(JSP)
--%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisateisb.SiSateiSbConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisateisb.SiSateiSbSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sisatei.sisateisb.SiSateiSbUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_SikinouModeIdKbn" %>
<% SiSateiSbUiBean uiBean = SWAKInjector.getInstance(SiSateiSbUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
   commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewskkihon/view_sk_kihon.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsindansyoinfosibou/view_sindansyoinfo_sibou.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsiininfo/view_siin_info.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsiharaiinfo/view_siharai_info.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrgoukei/view_shr_goukei.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewkingakuinfo/view_kingaku_info.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewzeimuinfo/view_zeimu_info.js.jsp"/>

<%
if (uiBean.getPageNo() != PAGENO_INPUTCORRECT) { %>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsknaiyou/view_sknaiyou.js.jsp"/>
<jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrsyousais/view_shr_syousai_s.js.jsp"/>
<% } %>

<%
   if (C_SikinouModeIdKbn.SATEI1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI2.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI3.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI4.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
       C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
       <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsateikaisouyouhisibou/view_sateikaisouyouhi_sibou.js.jsp"/>
       <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewmnmeigibangou/view_mn_meigi_bangou.js.jsp"/>
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCORRECT ||
      C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
      C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
      C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
      C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
      <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewskjyouhou/view_skjyouhou.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsaikeninfo/view_saiken_info.js.jsp"/>
      <%
         if (uiBean.getPageNo() != PAGENO_INPUTCORRECT) { %>
           <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsinkensya/view_sinkensya.js.jsp"/>
      <% } %>
      <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsouhusaki/view_souhusaki.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsoukinsaki/view_soukinsaki.js.jsp"/>
<% } %>

<%
   if (!C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
       !C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())  &&
       !C_SikinouModeIdKbn.SESSYOU1.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
       !C_SikinouModeIdKbn.SESSYOU2.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
      <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrdtlsakuseikbn/view_shrdtl_sakusei_kbn.js.jsp"/>
<% } %>

<%
   if (C_SikinouModeIdKbn.SATEI1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI2.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI3.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI4.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
       C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())  ||
       C_SikinouModeIdKbn.SESSYOU1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU2.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
       <%
         if (uiBean.getPageNo() != PAGENO_INPUTCORRECT) { %>
           <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsateikoumoku/view_sateikoumoku.js.jsp"/>
           <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewmeigihenkousatei/view_meigihenkou_satei.js.jsp"/>
            <%
              if (!C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
                  !C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
                  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewippanhantei/view_ippanhantei.js.jsp"/>
                  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewkokuhancheck/view_kokuhan_check.js.jsp"/>
                  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewjyuukasituinfo/view_jyuukasitu_info.js.jsp"/>
                  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewkaijokigenymdinput/view_kaijokigenymd_input.js.jsp"/>
                  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewtratkihuryouhusyoujiken/view_tratkihuryou_husyoujiken.js.jsp"/>
                  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsonotachecksibou/view_sonota_check_sibou.js.jsp"/>
                  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewbetukutichecksibou/view_betukuti_check_sibou.js.jsp"/>
            <% } %>
       <% } %>
<% } %>

<%
   if (C_SikinouModeIdKbn.SATEI2.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI3.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI4.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU2.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
       <%
         if (uiBean.getPageNo() != PAGENO_INPUTCORRECT) { %>
           <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewkakuninkoumoku/view_kakuninkoumoku.js.jsp"/>
      <% } %>
<% } %>

<%
   if (C_SikinouModeIdKbn.SATEI1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI2.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI3.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SATEI4.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU2.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.HUBIKANRITYUU.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
       <%
         if (uiBean.getPageNo() != PAGENO_INPUTCORRECT) { %>
           <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsiharaisatei/view_siharai_satei.js.jsp"/>
      <% } %>
<% } %>

<%
   if (C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU2.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

       <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsateikekka/view_satei_kekka.js.jsp"/>
<% } %>
<script type="text/javascript">
$(function(){

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SATEI1 || uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SATEI2) { %>
       <%
        if (!BizUtil.isBlank(uiBean.getTyouhyouKey())) { %>
             openReport("kakuniniraisyoSakuseiPrint", "_blank");
       <% } %>
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_RESULT_SYOUNIN_SATEIHUYOU || uiBean.getPageNo() == PAGENO_RESULT_SYOUNIN_SATEIYOU ) { // %>
       <%
        if (!BizUtil.isBlank(uiBean.getResultTyouhyouKey())) { %>
         openReport("kakuteiPrint", "_blank");
       <% } %>
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM_SATEI1 ||
       uiBean.getPageNo() == PAGENO_CONFIRM_SATEI2 ||
       uiBean.getPageNo() == PAGENO_CONFIRM_SATEI3 ||
       uiBean.getPageNo() == PAGENO_CONFIRM_SATEI4 ||
       uiBean.getPageNo() == PAGENO_CONFIRM_TETUZUKI_SATEIHUYOU ||
       uiBean.getPageNo() == PAGENO_CONFIRM_TETUZUKI_SATEIYOU ||
       uiBean.getPageNo() == PAGENO_CONFIRM_SYOUNIN_SATEIHUYOU ||
       uiBean.getPageNo() == PAGENO_CONFIRM_SYOUNIN_SATEIYOU ||
       uiBean.getPageNo() == PAGENO_CONFIRM_SESSYOU ||
       uiBean.getPageNo() == PAGENO_CONFIRM_KAIKETU ||
       uiBean.getPageNo() == PAGENO_CONFIRM_KAKUNIN_HUBI) { %>
       <%
         if (uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
           $(<%=KOUTEIINFO + DIV %>).visible(false);
           $(<%=SHRYMD_VIEWSIHARAIINFO1 %>).parent().parent().visible(false);
           $(<%=VIEWKINGAKUINFO  + DIV %>).visible(false);
           $(<%=VIEWZEIMUINFO  + DIV %>).visible(false);
           $(<%=HOKENKINSYURUI_VIEWSIHARAISATEIINFO %>).parent().parent().visible(false);
           <%
              if (C_SikinouModeIdKbn.SATEI1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SATEI2.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SATEI3.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SATEI4.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
                  C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SESSYOU1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SESSYOU2.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
                  $(<%=VIEWSATEIKOUMOKUINFO  + DIV %>).visible(false);
           <% } %>
           <%
              if (C_SikinouModeIdKbn.SATEI1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SATEI2.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SATEI3.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SATEI4.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
                  C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SESSYOU1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                  C_SikinouModeIdKbn.SESSYOU2.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
                  $(<%=VIEWSATEIKOUMOKUINFO  + DIV %>).visible(false);
           <% } %>
           $(<%=HKTSHRGOUKEIINFO  + DIV %>).visible(false);
           $(<%=YENGOUKEIINFO  + DIV %>).visible(false);

           $(<%=MODORUBTNBYCONFIRM_FOOTERBUTTONS %>).visible(false);
           $(<%=KAKUTEIBTN_FOOTERBUTTONS %>).visible(false);
           $(<%=FUNCTION_NAME%>).text('<%= uiBean.getKinouNm() %>');
           $(<%= FUNCTION_NAME %>).attr("disabled", "true");
           $(<%= FUNCTION_NAME %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');
           $(<%= TOJIRUBTN_HEADERBUTTONS %>).visible(false);
       <%
         } else {  %>
           $(<%= TOJIRUBTNBYPOPUP_HEADERBUTTONS %>).visible(false);
       <% } %>
  <% }%>

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SATEI1 ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SATEI2 ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SATEI3 ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SATEI4 ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_TETUZUKI_SATEIHUYOU ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_TETUZUKI_SATEIYOU ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SYOUNIN_SATEIHUYOU ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SYOUNIN_SATEIYOU ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_SESSYOU ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_KAIKETU ||
       uiBean.getPageNo() == PAGENO_INPUTCONTENTS_KAKUNIN_HUBI) { %>
       <%
         if (!uiBean.isSiSateiSougouSyoukaiFlg()) { // %>
           syoukaibtnOnClick();
           <% uiBean.setSiSateiSougouSyoukaiFlg(true); %>
       <% } %>
  <% }%>


 <%
    if (C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
        C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
        $(<%=SATEITENNOUSAKISOUSASYACD_VIEWSATEIKEKKAINFO + LABEL%>).parent().visible(false);
        $(<%=SATEITENNOUSAKISOUSASYACD_VIEWSATEIKEKKAINFO%>).parent().visible(false);
        <%
          if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS_KAIKETU) { %>
           $(<%=SATEISYORIKEKKAKBN_VIEWSATEIKEKKAINFO + SPAN%>).parent().removeClass("c2").addClass('c1').attr("colspan","3");
         <%
         } else { %>
          $(<%=SATEISYORIKEKKAKBN_VIEWSATEIKEKKAINFO%>).parent().removeClass("c2").addClass('c1').attr("colspan","3");
         <% } %>
 <% } %>

<%
   if (
       C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode())||
       C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU1.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.SESSYOU2.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
       C_SikinouModeIdKbn.HUBIKANRITYUU.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
        $(<%=TENNOUSAKISOUSASYACD_VIEWSIHARAISATEIINFO + LABEL%>).parent().visible(false);

        <%
          if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS_KAKUNIN_HUBI) { %>
          $(<%=TENNOUSAKISOUSASYACD_VIEWSIHARAISATEIINFO %>).parent().parent().visible(false);
          $(<%=SYORIKEKKAKBN_VIEWSIHARAISATEIINFO + SPAN%>).parent().removeClass("c2").addClass('c1').attr("colspan","3");

        <%
        } else { %>
          $(<%=TENNOUSAKISOUSASYACD_VIEWSIHARAISATEIINFO%>).parent().visible(false);
          $(<%=SYORIKEKKAKBN_VIEWSIHARAISATEIINFO%>).parent().removeClass("c2").addClass('c1').attr("colspan","3");
       <% } %>
<% } %>

 function syoukaibtnOnClick() {
    $(<%=SYOUKAIBTNHIHYOUJI_FOOTERBUTTONS2%>).trigger("click");
 }
});
</script>
