<%--
    si_shr_rireki_syoukai.js.jsp - 支払履歴照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisyoukai.sishrrirekisyoukai.SiShrRirekiSyoukaiConstants.*" %>
<%@page import="static yuyu.app.siharai.sisyoukai.sishrrirekisyoukai.SiShrRirekiSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sisyoukai.sishrrirekisyoukai.SiShrRirekiSyoukaiUiBean" %>
<%@page import="yuyu.def.classification.C_SeikyuuSyubetu" %>
<%@page import="yuyu.def.classification.C_SUketoriHouhouKbn" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.def.classification.C_SateiYouhiKbn" %>
<% SiShrRirekiSyoukaiUiBean uiBean = SWAKInjector.getInstance(SiShrRirekiSyoukaiUiBean.class); %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>

<%
if (uiBean.getPageNo() == PAGENO_SHRRIREKISYOUSAI) { %>

    <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewskjyouhou/view_skjyouhou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsouhusaki/view_souhusaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsoukinsaki/view_soukinsaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrdtlsakuseikbn/view_shrdtl_sakusei_kbn.js.jsp"/>

  <%
  if (!C_SeikyuuSyubetu.SDSSHR.eq(uiBean.getSeikyuuSyubetu())) {%>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsaikeninfo/view_saiken_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsinkensya/view_sinkensya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsateikaisouyouhisibou/view_sateikaisouyouhi_sibou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsknaiyou/view_sknaiyou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsindansyoinfosibou/view_sindansyoinfo_sibou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewmnmeigibangou/view_mn_meigi_bangou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsiininfo/view_siin_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrsyousais/view_shr_syousai_s.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsiharaiinfo/view_siharai_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrgoukei/view_shr_goukei.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewzeimuinfo/view_zeimu_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewippanhantei/view_ippanhantei.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewkokuhancheck/view_kokuhan_check.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewjyuukasituinfo/view_jyuukasitu_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewkaijokigenymdinput/view_kaijokigenymd_input.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewmeigihenkousatei/view_meigihenkou_satei.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewtratkihuryouhusyoujiken/view_tratkihuryou_husyoujiken.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsonotachecksibou/view_sonota_check_sibou.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewbetukutichecksibou/view_betukuti_check_sibou.js.jsp"/>
  <% } %>
<% } %>

<script type="text/javascript"><!--
$(function(){

    <%
    if (uiBean.getPageNo() == PAGENO_SHRRIREKI) { %>
        showList(<%=SIHARAIRIREKI %>);

        $(<%= SEARCHCONDITIONS + DIV %>).css("margin-top", "-1px");
    <% } %>

    <%
    if (uiBean.getPageNo() == PAGENO_SHRRIREKISYOUSAI) { %>

        <%
        if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuuSyubetu())) {%>

            <%
            if (C_SateiYouhiKbn.YOU.eq(uiBean.getSateiyhkbn())) {%>

                $(<%= VIEWSIHARAISATEIINFO + DIV%>).visible(true);

                <%
                if (!C_SyorikekkaKbn.HUSIHARAI.eq(uiBean.getSyorikekkakbn()) &&
                    !C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(uiBean.getSyorikekkakbn())) {%>

                    $(<%= HUSHRGENINKBN_VIEWSIHARAISATEIINFO %>).parent().parent().visible(false);
                    $(<%= SESSYOUYHKBN_VIEWSIHARAISATEIINFO %>).parent().parent().visible(false);
                    $(<%= SESSYOUSISYACD_VIEWSIHARAISATEIINFO %>).parent().parent().visible(false);
                    $(<%= SISYANM_VIEWSIHARAISATEIINFO %>).parent().parent().visible(false);
                    $(<%= SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO + LABEL%>).parent().visible(false);
                    $(<%= SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO%>).parent().visible(false);
                    $(<%= SINDANSYORYOUSHRYOUHIKBN_VIEWSIHARAISATEIINFO + LABEL%>).parent().visible(false);
                    $(<%= SINDANSYORYOUSHRYOUHIKBN_VIEWSIHARAISATEIINFO%>).parent().visible(false);
                <% } %>

                <%
                if (uiBean.getKaiketuymd() != null) {%>
                    $(<%= VIEWSATEIKEKKAINFO + DIV%>).visible(true);
                <% } %>
            <% } %>
        <% } %>

        <%
        if (C_SeikyuuSyubetu.SDSSHR.eq(uiBean.getSeikyuuSyubetu())) {%>

            $(<%= SIHONNINKAKNINKBN_VIEWSKJYOUHOUINFO %>).parent().parent().visible(false);
            $(<%= SEIKYUUSYASEIYMD_VIEWSKJYOUHOUINFO %>).parent().parent().visible(false);
            $(<%= SEIKYUUSYASEI_VIEWSKJYOUHOUINFO %>).parent().parent().visible(false);
            $(<%= SEIKYUUSYANMKN_VIEWSKJYOUHOUINFO %>).parent().parent().visible(false);

            $(<%= TSINTELNO_VIEWSOUHUSAKIINFO + LABEL%>).parent().visible(false);
            $(<%= TSINTELNO_VIEWSOUHUSAKIINFO%>).parent().visible(false);

            $(<%= VIEWSINDANSYORYOUSHRNFO + DIV%>).visible(true);

            $(<%= VIEWSINKENSYAINFO + DIV%>).visible(false);
            $(<%= VIEWSATEIKAISOUYOUHISIBOUINFO + DIV%>).visible(false);
            $(<%= VIEWSKNAIYOUINFO + DIV%>).visible(false);
            $(<%= VIEWSINDANSYOINFOSIBOUINFO + DIV%>).visible(false);
            $(<%= VIEWSINDANSYOINFOSIBOUINFO1 + DIV%>).visible(false);
            $(<%= VIEWMNMEIGIBANGOU + DIV%>).visible(false);
            $(<%= VIEWSIHARAIINFO + DIV%>).visible(false);
            $(<%= VIEWZEIMUINFO + DIV%>).visible(false);
            $(<%= VIEWTRATKIHURYOUHUSYOUJIKENINFO + DIV%>).visible(false);
            $(<%= VIEWBETUKUTICHECKSIBOUINFO + DIV%>).visible(false);
        <% } %>
    <% } %>

});
//-->
</script>