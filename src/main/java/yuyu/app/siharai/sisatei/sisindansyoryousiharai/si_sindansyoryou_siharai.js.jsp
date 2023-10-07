<%--
    si_sindansyoryou_siharai.js.jsp - 診断書料支払 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisindansyoryousiharai.SiSindansyoryouSiharaiConstants.*" %>
<%@page import="static yuyu.app.siharai.sisatei.sisindansyoryousiharai.SiSindansyoryouSiharaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sisatei.sisindansyoryousiharai.SiSindansyoryouSiharaiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_SeikyuusyaKbn" %>
<%@page import="yuyu.def.classification.C_SouhusakiKbn" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<% SiSindansyoryouSiharaiUiBean uiBean = SWAKInjector.getInstance(SiSindansyoryouSiharaiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>
<% commonViewInBean.setCommonViewUiBeanParam(uiBean); %>

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTSINPUT || uiBean.getPageNo() == PAGENO_INPUTCONTENTSTENKEN) {%>
       <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewhihokensya/view_hihokensya.js.jsp"/>
       <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsoukinsaki/view_soukinsaki.js.jsp"/>
       <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrdtlsakuseikbn/view_shrdtl_sakusei_kbn.js.jsp"/>
<% }%>
<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) {%>
    <%
       if (!uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
           <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewhihokensya/view_hihokensya.js.jsp"/>
    <% }%>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsoukinsaki/view_soukinsaki.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrdtlsakuseikbn/view_shrdtl_sakusei_kbn.js.jsp"/>
<% }%>
<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTSINPUT || uiBean.getPageNo() == PAGENO_INPUTCONTENTSTENKEN ||
       uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) {%>
       <%
       if (uiBean.isKidougmKbnWorkListSeigyo()) { %>
           <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
       <% }%>
<% }%>
<script type="text/javascript">
$(function(){

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTSINPUT || uiBean.getPageNo() == PAGENO_INPUTCONTENTSTENKEN) { %>
    <%
       if (!uiBean.isKidougmKbnWorkListSeigyo()) { %>
           $(<%= KOUTEIINFO + DIV %>).visible(false);
    <%
       } else  { %>
           showList(<%= PROGRESSHISTORYINFO%>);
    <% }%>

    <%
       if (!uiBean.isStdrsktkyuSeigyo()) { %>
           $(<%= STDRSKNINFO + DIV %>).visible(false);
    <% }%>
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTSINPUT) { %>
    <%
       if (!C_SeikyuusyaKbn.SONOTA.eq(uiBean.getSeikyuusyakbn())) { %>
           $(<%= SEIKYUUSYANMKJ_SKJYOUHOU %>).val('');
           setReadOnlyGray(<%= SEIKYUUSYANMKJ_SKJYOUHOU %>);
    <% }%>

    $(<%= SEIKYUUSYAKBN_SKJYOUHOU %>).change(function(){
      var seikyuusyakbn = $(<%= SEIKYUUSYAKBN_SKJYOUHOU %>).val();
      if(seikyuusyakbn == '<%= C_SeikyuusyaKbn.SONOTA.getValue() %>'){
          removeReadOnlyGray(<%= SEIKYUUSYANMKJ_SKJYOUHOU %>);
      } else {
          $(<%= SEIKYUUSYANMKJ_SKJYOUHOU %>).val('');
          setReadOnlyGray(<%= SEIKYUUSYANMKJ_SKJYOUHOU %>);
      }
    })

    <%
       if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) { %>

          $(<%= TSINYNO_SOUHUSAKIINFO %>).val('');
          $(<%= TSINADR1KJ_SOUHUSAKIINFO %>).val('');
          $(<%= TSINADR2KJ_SOUHUSAKIINFO %>).val('');
          $(<%= TSINADR3KJ_SOUHUSAKIINFO %>).val('');
          setReadOnlyGray(<%= TSINYNO_SOUHUSAKIINFO %>);
          setReadOnlyGray(<%= TSINADR1KJ_SOUHUSAKIINFO %>);
          setReadOnlyGray(<%= TSINADR2KJ_SOUHUSAKIINFO %>);
          setReadOnlyGray(<%= TSINADR3KJ_SOUHUSAKIINFO %>);
          $(<%= TSINYNOPOPUPBUTTON %>).readonly(true);
          $(<%=TSINYNO_SOUHUSAKIINFO%>).removeClass("readonly");
    <% }%>

   $(<%= SOUHUSAKIKBN_SOUHUSAKIINFO %>).change(function(){
     var souhusakikbn = $(<%= SOUHUSAKIKBN_SOUHUSAKIINFO %>).val();
     if(souhusakikbn == '<%= C_SouhusakiKbn.TDADD.getValue() %>'){
         $(<%= TSINYNO_SOUHUSAKIINFO %>).val('');
         $(<%= TSINADR1KJ_SOUHUSAKIINFO %>).val('');
         $(<%= TSINADR2KJ_SOUHUSAKIINFO %>).val('');
         $(<%= TSINADR3KJ_SOUHUSAKIINFO %>).val('');
         setReadOnlyGray(<%= TSINYNO_SOUHUSAKIINFO %>);
         setReadOnlyGray(<%= TSINADR1KJ_SOUHUSAKIINFO %>);
         setReadOnlyGray(<%= TSINADR2KJ_SOUHUSAKIINFO %>);
         setReadOnlyGray(<%= TSINADR3KJ_SOUHUSAKIINFO %>);
         $(<%= TSINYNOPOPUPBUTTON %>).readonly(true);
         $(<%=TSINYNO_SOUHUSAKIINFO%>).removeClass("readonly");
     } else {
         removeReadOnlyGray(<%= TSINYNO_SOUHUSAKIINFO %>);
         removeReadOnlyGray(<%= TSINADR1KJ_SOUHUSAKIINFO %>);
         removeReadOnlyGray(<%= TSINADR2KJ_SOUHUSAKIINFO %>);
         removeReadOnlyGray(<%= TSINADR3KJ_SOUHUSAKIINFO %>);
         $(<%= TSINYNOPOPUPBUTTON %>).readonly(false);
     }
   })
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
   <%
      if (uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
          $(<%= KOUTEIINFO + DIV %>).visible(false);

   <%
      } else  { %>
       <%
          if (!uiBean.isKidougmKbnWorkListSeigyo()) { %>
              $(<%= KOUTEIINFO + DIV %>).visible(false);
       <%
          } else  { %>
              showList(<%= PROGRESSHISTORYINFO %>);
        <%}%>
    <%}%>


    <%
       if (uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
        $(<%= HIHOKENSYAINFO + DIV %>).visible(false);
        $(<%= TSININFO + DIV %>).visible(false);

     <%}%>

   <%
      if (uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
          $(<%= STDRSKNINFO + DIV %>).visible(false);
   <%
      } else  { %>

       <%
          if (!uiBean.isStdrsktkyuSeigyo()) { %>
              $(<%= STDRSKNINFO + DIV %>).visible(false);
        <%}%>
    <%}%>

    <%
       if (uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
           $(<%= SHRGKKEI_SINDANSYORYOUSHR %>).parent().parent().visible(false);
           $(<%= TYAKKINYMD_SINDANSYORYOUSHR %>).parent().parent().visible(false);
     <%}%>
<% } %>

  <%
     if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
     <%
       if (uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
        $(<%= MODORUBTNBYCONFIRM_FOOTERBUTTONS3%>).visible(false);
        $(<%= KAKUTEIBTN_FOOTERBUTTONS3%>).visible(false);

        $(<%= FUNCTIONNAMELINK %>).text('<%= uiBean.getKinouNm() %>');
        $(<%= FUNCTIONNAMELINK %>).attr('disabled', 'true');
        $(<%= FUNCTIONNAMELINK %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');

        $(<%= TOJIRUBTN_HEADERBUTTONS %>).visible(false);
      <%
         } else  { %>
          $(<%= TOJIRUBTNBYPOPUP_HEADERBUTTONS %>).visible(false);
      <%}%>
  <%}%>

<%
   if (uiBean.getPageNo() == PAGENO_RESULT && !BizUtil.isBlank(uiBean.getTyouhyoukey())) { %>
       openReport('print', '_blank');
 <%}%>

});
</script>
