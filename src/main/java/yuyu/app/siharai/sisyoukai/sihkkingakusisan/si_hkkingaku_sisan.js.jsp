<%--
    si_hkkingaku_sisan.js.jsp - 保険金額試算 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisyoukai.sihkkingakusisan.SiHkkingakuSisanConstants.*" %>
<%@page import="static yuyu.app.siharai.sisyoukai.sihkkingakusisan.SiHkkingakuSisanSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sisyoukai.sihkkingakusisan.SiHkkingakuSisanUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<%@page import="yuyu.def.classification.C_SUketoriHouhouKbn"%>
<%@page import="jp.co.slcs.swak.web.message.MessageManager"%>
<% SiHkkingakuSisanUiBean uiBean = SWAKInjector.getInstance(SiHkkingakuSisanUiBean.class); %>
<% MessageManager messageManager = SWAKInjector.getInstance(MessageManager.class); %>

<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
  <%
    if ( uiBean.getPageNo() == PAGENO_SIHARAISISAN ) { %>
        <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewuketorininsb/view_uketorinin_sb.js.jsp"/>
  <% }%>

<script type="text/javascript"><!--
$(function(){
  <%
  if (uiBean.getPageNo() == PAGENO_SIHARAISISAN) { %>
   <% if(uiBean.isKnsnkijyunymdDispFlag()) {%>
     showKoumoku(<%= KNSNKIJYUNYMD_SISANINFO %>);
     showKoumoku(<%= KAWASERATE_SISANINFO %>);
   <% } %>
   <% if(uiBean.isSisanKekkaFlag()) {%>
    if (<%=messageManager.getConversationMessages().size() + messageManager.getMessages().size()%> != $(".messagesItem").size()) {
         $(<%= SISANSYOSAKUSEIBTN_FOOTERBUTTONS3%>).disable(true);
     } else {
         <% if(uiBean.isJisatuMensekiDispFlag()) {%>
             $(<%= SISANSYOSAKUSEIBTN_FOOTERBUTTONS3%>).disable(true);
             showKoumoku(<%= PTUMITATEKIN_SISANKEKKAINFO %>);
             showKoumoku(<%= JPYPTUMITATEKIN_SISANKEKKAINFO %>);
         <%
         } else { %>
             showKoumoku(<%= DISPSIHKNKNUKTBNWARI_SISANKEKKAINFO %>);
             showKoumoku(<%= DISPHASUUKASANHYOUJI_SISANKEKKAINFO %>);
             showKoumoku(<%= HOKENKNGK_SISANKEKKAINFO %>);
             showKoumoku(<%= YENHOKENKNGK_SISANKEKKAINFO %>);
         <% } %>
         showGroup(<%=HARAIKOMUINFO%>);
         <% if(uiBean.isItijibrpDispFlag()) {%>
           showKoumoku(<%= ITIJIBRP_HARAIKOMUINFO %>);
         <% } %>
         <% if(uiBean.isNyknymdDispFlag()) {%>
           showKoumoku(<%= RYOSYUYMD_HARAIKOMUINFO %>);
         <% } %>
         <% if(uiBean.isNyknkawaserateDispFlag()) {%>
           showKoumoku(<%= VHRKIYENTKYKWSRATETUUKASYU_HARAIKOMUINFO %>);
         <% } %>
         <% if(uiBean.isZeimuKihrkmpDispFlag()) {%>
           showKoumoku(<%= VHRKIYENKANSANNYKNKINGK_HARAIKOMUINFO %>);
         <% } %>
         showGroup(<%=SISANKEKKAINFO%>);
         <% if(uiBean.isKnsnkijyunymdDispFlag()) {%>
            showKoumoku(<%= DISPKNSNKIJYUNYMD_SISANKEKKAINFO %>);
            showKoumoku(<%= DISPTUUKASYU_SISANKEKKAINFO %>);
         <% } %>
         <% if(uiBean.isSisankekkaGaikaknsnkijyunymdDispFlag()) {%>
            showKoumoku(<%= GAIKAKNSNKWSRATEKJYMD_SISANKEKKAINFO %>);
            showKoumoku(<%= DISPTUUKASYU2_SISANKEKKAINFO %>);
         <% } %>
         <% if(uiBean.isSisankekkaHaitoukinDispFlag()) {%>
            showKoumoku(<%= HAITOUKIN_SISANKEKKAINFO %>);
            showKoumoku(<%= YENKAHAITOUKIN_SISANKEKKAINFO %>);
         <% } %>
         <% if(uiBean.isSisankekkaSonotahaitoukinDispFlag()) {%>
            showKoumoku(<%= SONOTAHAITOUKIN_SISANKEKKAINFO %>);
            showKoumoku(<%= YENKASONOTAHAITOUKIN_SISANKEKKAINFO %>);
         <% } %>
         <% if(uiBean.isSisankekkaMikeikapDispFlag()) {%>
            showKoumoku(<%= MIKEIKAP_SISANKEKKAINFO %>);
            showKoumoku(<%= MIKEIKAPGAITOUKKN_SISANKEKKAINFO %>);
            showKoumoku(<%= YENKAMIKEIKAP_SISANKEKKAINFO %>);
         <% } %>
         <% if(uiBean.isSisankekkaMisyuupDispFlag()) {%>
               <% if(!uiBean.isJisatuMensekiDispFlag()) {%>
                  showKoumoku(<%= MISYUUP_SISANKEKKAINFO %>);
                  showKoumoku(<%= MISYUUPGAITOUKKN_SISANKEKKAINFO %>);
                  showKoumoku(<%= YENKAMISYUUP_SISANKEKKAINFO %>);
           <% } %>
         <% } %>
         <% if(uiBean.isSisankekkaZennouseisankgkDispFlag()) {%>
            showKoumoku(<%= ZENNOUSEISANKGK_SISANKEKKAINFO %>);
            showKoumoku(<%= YENKAZENNOUSEISANKGK_SISANKEKKAINFO %>);
         <% } %>
         <% if(uiBean.isSisankekkaAzukarikingkDispFlag()) {%>
            showKoumoku(<%= AZUKARIKINGK_SISANKEKKAINFO %>);
            showKoumoku(<%= YENKAAZUKARIKINGK_SISANKEKKAINFO %>);
         <% } %>
         <% if(uiBean.isSisankekkaKrkgkDispFlag()) {%>
            showKoumoku(<%= KRKGK_SISANKEKKAINFO %>);
            showKoumoku(<%= YENKAKRKGK_SISANKEKKAINFO %>);
         <% } %>

         <% if(uiBean.isSisankekkaGoukeigkDispFlag()) {%>
            showGroup(<%=GOUKEIGKINFO%>);
            showKoumoku(<%= DISPGOUKEIGK_GOUKEIGKINFO %>);
            showKoumoku(<%= DISPYENKAGOUKEIGK_GOUKEIGKINFO %>);
         <% } %>

         <% if(uiBean.isSisankekkaZeimuInfoDispFlag()) {%>
            showGroup(<%=ZEIMUINFO%>);
            showKoumoku(<%= DISPZEITRATKIKBN_ZEIMUINFO %>);
            <% if(uiBean.isSisankekkaSynykngkDispFlag()) {%>
               showKoumoku(<%= SYNYKNGK_ZEIMUINFO %>);
               <% if(uiBean.isSisankekkaGaikashrsynykngkDispFlag()) {%>
                  showKoumoku(<%= GAIKASHRSYNYKNGK_ZEIMUINFO %>);
               <% } %>
            <% } %>
            <% if(uiBean.isSisankekkaKztkgkDispFlag()) {%>
               showKoumoku(<%= KZTKGK_ZEIMUINFO %>);
            <% } %>
         <% } %>

         <% if(uiBean.isSisankekkaSikinidougakuDispFlag()) {%>
            showGroup(<%=SIKINIDOUGAKUINFO%>);
            showKoumoku(<%= SIKINIDOUGAKU_SIKINIDOUGAKUINFO %>);
         <% } %>

         showGroup(<%= FOOTERBUTTONS3 %>);

     }

     <% if(!"".equals(uiBean.getReportKey())) {%>
         openReport('print', '_blank');
     <% } %>

   <% } %>
  <% }%>
});
//-->
</script>
