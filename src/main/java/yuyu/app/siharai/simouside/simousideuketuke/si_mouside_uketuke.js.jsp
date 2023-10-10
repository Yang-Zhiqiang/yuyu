<%--
    si_mouside_uketuke.js.jsp - 申出受付 JavaScript(JSP)
--%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.simouside.simousideuketuke.SiMousideUketukeConstants.*" %>
<%@page import="static yuyu.app.siharai.simouside.simousideuketuke.SiMousideUketukeSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.def.classification.C_NayoseYouhi" %>
<%@page import="yuyu.def.classification.C_YuukousyoumetuKbn" %>
<%@page import="yuyu.def.classification.C_SouhusakiKbn" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.app.siharai.simouside.simousideuketuke.SiMousideUketukeUiBean" %>
<% SiMousideUketukeUiBean uiBean = SWAKInjector.getInstance(SiMousideUketukeUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
     <%
       if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
        <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
        <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewhihokensya/view_hihokensya.js.jsp"/>
        <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewuketorininsb/view_uketorinin_sb.js.jsp"/>
    <% } %>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewbetukyk/view_betukyk.js.jsp"/>
<% } %>
<script type="text/javascript">
$(function(){
 <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
      var pankuzuText = '';
    <%
      if (uiBean.getGamensyorikbn().equals(SYO_TTDKANNAISKI)) { %>
        pankuzuText = '<%=PANKUZU_TTDKANNAISKI%>';
    <%
      } else if (uiBean.getGamensyorikbn().equals(SYO_HKNKMOSUKE)) { %>
        pankuzuText = '<%=PANKUZU_HKNKMOSUKE%>';
    <%} %>
    $(<%= IBA0001 %>).text(pankuzuText);
 <%} %>

 <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
      showList(<%= BETUKEIYAKULIST%>);
      <%
        if (uiBean.getGamensyorikbn().equals(SYO_HKNKMOSUKE)) { %>
          showGroup(<%= MOUSIDENAIYOU%>);
          showKoumoku(<%= BYOUMEITOUROKUNO_MOUSIDENAIYOU%>);
          $(<%=BYOUMEITOUROKUNO_MOUSIDENAIYOU %>).visible(false);
          showGroup(<%= COMMENTINFO%>);
      <%} %>
 <%} %>
 <%
    if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
      <%
        if (uiBean.isSiTtzkRirekiSyoukaiHyoujiFlg()) { %>
          showGroup(<%= MOUSIDENAIYOU%>);
          showKoumoku(<%= BYOUMEITOUROKUNO_MOUSIDENAIYOU%>);
           $(<%=BYOUMEITOUROKUNO_MOUSIDENAIYOU %>).visible(false);
          showGroup(<%= COMMENTINFO%>);
      <%} %>
 <%} %>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

    <%
     if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) { %>
         setReadOnlySouhusaki();
    <% } %>

   $(<%=SOUHUSAKIKBN_MOUSIDENININFO2%>).change( function() {
      var value = $(<%=SOUHUSAKIKBN_MOUSIDENININFO2%>).val();
      if (value == "<%=C_SouhusakiKbn.TDADD.getValue()%>") {
         setReadOnlySouhusaki();
       } else {
        removeReadOnlyGray(<%=TSINYNO_MOUSIDENININFO2%>);
        removeReadOnlyGray(<%=TSINADR1KJ_MOUSIDENININFO2%>);
        removeReadOnlyGray(<%=TSINADR2KJ_MOUSIDENININFO2%>);
        removeReadOnlyGray(<%=TSINADR3KJ_MOUSIDENININFO2%>);
        removeReadOnlyGray(<%=TSINTELNO_MOUSIDENININFO2%>);
        $(<%=TSINYNO_POPUP_BUTTON%>).readonly(false);
       }
    });

    <%
      if (BizUtil.isBlank(uiBean.getMskmjskjkyknen())) { %>
        $(<%=KYKSEIYMD_KEIYAKUSYAINFO%>).parent().removeClass('alignRight');
     <%} %>

    <%
      if (BizUtil.isBlank(uiBean.getMskmjskjkyknen())) { %>
        $(<%=HHKNSEIYMD_HIHOKENSYAINFO%>).parent().removeClass('alignRight');
     <%} %>

    $(<%= BETUKEIYAKULIST + LABEL%>).text($(<%= BETUKEIYAKULIST + LABEL%>).text() + '　　<%= MessageUtil.getMessage(MessageId.IJF0053) %>');

    <%
      if (uiBean.getGamensyorikbn().equals(SYO_HKNKMOSUKE)) { %>
        <%
          if (uiBean.isKeiyakushahihokenshadouituFlg()) { %>
              $(<%= KYKSYASIBOUUMU_MOUSIDENININFO %>).readonly(true);
              $("#ui:030kyksyasibouumu").val("true");
              $(<%= KYKSYASIBOUUMU_MOUSIDENININFO %>).attr("checked", "checked");
         <%} %>

          if ($(<%=BYOUMEIKJ_MOUSIDENAIYOU%>).val() == '') {
            $(<%=CLEARBTNBYBYOUMEI_MOUSIDENAIYOU %>).visible(false);
          } else {
            $(<%=CLEARBTNBYBYOUMEI_MOUSIDENAIYOU %>).visible(true);
          }

         $(<%=BYOUMEIKJ_MOUSIDENAIYOU %>).attr('unselectable', 'on');
         $(<%=BYOUMEIKJ_MOUSIDENAIYOU %>).readonly(true);

         $(<%=CLEARBTNBYBYOUMEI_MOUSIDENAIYOU %>).click(function() {
            $(<%=BYOUMEIKJ_MOUSIDENAIYOU %>).val('');
            $(<%=BYOUMEICD_MOUSIDENAIYOU %>).val('');
            $(<%=BYOUMEIKN_MOUSIDENAIYOU %>).val('');
            $(<%=BYOUMEITOUROKUNO_MOUSIDENAIYOU %>).val('');
            $(<%=CLEARBTNBYBYOUMEI_MOUSIDENAIYOU %>).visible(false);
         });
        $(<%=BYOUMEITOUROKUNO_POPUP_BUTTON%>).popupResponse(function(){
          if ($(<%=BYOUMEIKJ_MOUSIDENAIYOU%>).val() == '') {
            $(<%=CLEARBTNBYBYOUMEI_MOUSIDENAIYOU %>).visible(false);
          } else {
            $(<%=CLEARBTNBYBYOUMEI_MOUSIDENAIYOU %>).visible(true);
          }
         });

         showKoumoku(<%= UKETORININSIBOUUMU_MOUSIDENININFO%>);
         showKoumoku(<%= KYKSYASIBOUUMU_MOUSIDENININFO%>);
     <%} %>
  <%} %>

  <%
    if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

    <%
      if (uiBean.getGamensyorikbn().equals(SYO_HKNKMOSUKE)) { %>
         showKoumoku(<%= UKETORININSIBOUUMUKBN_MOUSIDENININFO%>);
         showKoumoku(<%= KYKSYASIBOUUMUKBN_MOUSIDENININFO%>);
      <%} %>

    $(<%=BYOUMEIKJ_MOUSIDENAIYOU%>).removeClass('inputCovLabel');
  <%} %>

  <%
    if (uiBean.getPageNo() == PAGENO_RESULT && !BizUtil.isBlank(uiBean.getReportKey())) { %>
      openReport('print', '_blank');
  <%} %>

  <%
     if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
     <%
       if (uiBean.isSiTtzkRirekiSyoukaiHyoujiFlg()) { %>
        $(<%= MODORUBTNBYCONFIRM_FOOTERBUTTONS3 %>).visible(false);
        $(<%= KAKUTEIBTN_FOOTERBUTTONS3 %>).visible(false);
        $(<%= FUNCTIONNAMELINK %>).text('<%= uiBean.getKinouNm() %>');
        $(<%= FUNCTIONNAMELINK %>).attr('disabled', 'true');
        $(<%= FUNCTIONNAMELINK %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');
        $(<%= TOJIRUBTN_HEADERBUTTONS %>).visible(false);
      <%
         } else  { %>
          $(<%= TOJIRUBTNBYPOPUP_HEADERBUTTONS %>).visible(false);
      <%}%>
  <%}%>

function setReadOnlySouhusaki() {
   $(<%=TSINYNO_MOUSIDENININFO2%>).val("");
   setReadOnlyGray(<%=TSINYNO_MOUSIDENININFO2%>);
   $(<%=TSINADR1KJ_MOUSIDENININFO2%>).val("");
   setReadOnlyGray(<%=TSINADR1KJ_MOUSIDENININFO2%>);
   $(<%=TSINADR2KJ_MOUSIDENININFO2%>).val("");
   setReadOnlyGray(<%=TSINADR2KJ_MOUSIDENININFO2%>);
   $(<%=TSINADR3KJ_MOUSIDENININFO2%>).val("");
   setReadOnlyGray(<%=TSINADR3KJ_MOUSIDENININFO2%>);
   $(<%=TSINTELNO_MOUSIDENININFO2%>).val("");
   setReadOnlyGray(<%=TSINTELNO_MOUSIDENININFO2%>);
   $(<%=TSINYNO_POPUP_BUTTON%>).readonly(true);
   $(<%=TSINYNO_MOUSIDENININFO2%>).removeClass("readonly");
}

});
</script>
