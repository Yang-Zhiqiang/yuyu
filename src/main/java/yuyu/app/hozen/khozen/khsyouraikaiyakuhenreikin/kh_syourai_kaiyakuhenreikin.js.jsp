<%--
    kh_syourai_kaiyakuhenreikin.js.jsp - 将来解約返戻金照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin.KhSyouraiKaiyakuhenreikinConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin.KhSyouraiKaiyakuhenreikinSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.date.BizDate" %>
<%@page import="java.util.List" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil" %>
<%@page import="yuyu.def.classification.C_Syorizumiflg" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<%@page import="yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin.KhSyouraiKaiyakuhenreikinUiBean" %>
<% KhSyouraiKaiyakuhenreikinUiBean uiBean = SWAKInjector.getInstance(KhSyouraiKaiyakuhenreikinUiBean.class); %>
<script type="text/javascript"><!--
$(function(){


    <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
      <% if (!BizUtil.isBlank(uiBean.getSyono())) {%>
          showKoumoku(<%=SYONO_SYOUKAICONDITIONS%>);
      <% } %>

      <% if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn() ||
          SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn()) &&
      !C_Tuukasyu.JPY.eq(uiBean.getSiteituuka())) { %>
          showKoumoku(<%=SISUURENDOURATE_SYOUKAICONDITIONS%>);
      <% } %>

      <% if (uiBean.getYendthnkymd() != null) { %>
          showKoumoku(<%=YENDTHNKYMD_SYOUKAICONDITIONS%>);
      <% } %>

      <% if (C_UmuKbn.NONE.eq(uiBean.getSyuusinhknumu())) { %>
          showKoumoku(<%=HKNKKN_SYOUKAICONDITIONS%>);
      <% } %>

      <% if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN != uiBean.getSyohinHanteiKbn()) { %>
          showKoumoku(<%=KIHONS_SYOUKAICONDITIONS%>);
      <% } %>

      <% if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) { %>
          showKoumoku(<%=HRKKKN_SYOUKAICONDITIONS%>);
      <% } %>

      <% if (uiBean.getTmttknitenymd() != null) { %>
          showKoumoku(<%=TMTTKNITENYMD_SYOUKAICONDITIONS%>);
      <% } %>

      <% if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()) { %>
          showKoumoku(<%=HOKENRYOU_SYOUKAICONDITIONS%>);
      <% } %>

      <% if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) { %>
          showKoumoku(<%=SITEITUUKA_SYOUKAICONDITIONS%>);
      <% } %>
    <% } %>

    <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
        openReport("print", "_blank");
    <% } %>

    var srchhknsyruiZen;

    $(<%= SRCHHKNSYRUI_SYOUKAICONDITIONS2%>).focus(function() {
      srchhknsyruiZen = $(<%= SRCHHKNSYRUI_SYOUKAICONDITIONS2 %>).val();
    });

    $(<%= SRCHHKNSYRUI_SYOUKAICONDITIONS2%>).blur(function() {
      srchhknsyruiGo = $(<%= SRCHHKNSYRUI_SYOUKAICONDITIONS2 %>).val();

      if (srchhknsyruiZen != srchhknsyruiGo) {
        var syouhnCd = $(this).val();
        var newSiteituuka = $(<%= SRCHSITEITUUKA_SYOUKAICONDITIONS2 %>).val();
        callAjaxSyouhnChange(syouhnCd, newSiteituuka, <%= SRCHKIHONS_SYOUKAICONDITIONS2 %>);
      }
    });

    var srchsiteituukaZen;

    $(<%= SRCHSITEITUUKA_SYOUKAICONDITIONS2%>).focus(function() {
      srchsiteituukaZen = $(<%= SRCHSITEITUUKA_SYOUKAICONDITIONS2 %>).val();
    });

    $(<%= SRCHSITEITUUKA_SYOUKAICONDITIONS2%>).blur(function() {
      srchsiteituukaGo = $(<%= SRCHSITEITUUKA_SYOUKAICONDITIONS2 %>).val();

      if (srchsiteituukaZen != srchsiteituukaGo) {
        var srchsiteituuka = $(this).val();
        var newSrchhknsyrui = $(<%= SRCHHKNSYRUI_SYOUKAICONDITIONS2 %>).val();
        callAjaxSyouhnChange(newSrchhknsyrui,srchsiteituuka, <%= SRCHKIHONS_SYOUKAICONDITIONS2 %>);
      }
    });
       function callAjaxSyouhnChange(syouhnCd, siteituuka, selector) {
         var form = $('form').attr('action');
         form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";

         $.ajax({
           type: "POST",
           url: form,
           data: {
             <%= AJAX_POST_PARAM_SYOUHNCD %>: syouhnCd,
             <%= AJAX_POST_PARAM_SITEITUUKA %>: siteituuka,
             "swak-cid": $('input[name=swak-cid]').val()
           },
           dataType: "json"
         }).success(function(data) {
           $(selector).val(data[0]);
           $(selector).next().text(data[1]);
           $(selector).next().next().text(data[2]);
           $(selector).next().next().next().val(data[3]);
         });
       }
});
//-->
</script>

