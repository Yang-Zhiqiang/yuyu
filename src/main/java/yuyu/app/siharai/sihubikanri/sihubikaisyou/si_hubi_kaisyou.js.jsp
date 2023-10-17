<%--
    si_hubi_kaisyou.js.jsp - 保険金給付金不備解消 JavaScript(JSP)
--%>
<%@page language='java' contentType='text/javascript; charset=UTF-8' pageEncoding='UTF-8' %>
<%@page import='static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*' %>
<%@page import='static yuyu.app.siharai.sihubikanri.sihubikaisyou.SiHubiKaisyouConstants.*' %>
<%@page import='static yuyu.app.siharai.sihubikanri.sihubikaisyou.SiHubiKaisyouSelector.*'  %>
<%@page import='jp.co.slcs.swak.core.inject.SWAKInjector' %>
<%@page import='yuyu.app.siharai.sihubikanri.sihubikaisyou.SiHubiKaisyouUiBean' %>
<% SiHubiKaisyouUiBean uiBean = SWAKInjector.getInstance(SiHubiKaisyouUiBean.class); %>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM
      || uiBean.getPageNo() == PAGENO_RESULT) { %>
      <jsp:include page='/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp'/>
      <%
      if (uiBean.isKidougmKbnWorkListSeigyo()) { %>
          <jsp:include page='/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp'/>
      <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      <jsp:include page='/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp'/>
<% } %>

<script type='text/javascript'>
$(function(){

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

    <%
     if (uiBean.isAllPrintFlg()) { %>
        if ($(<%=ALLHYOUJIBTN_BUTTONALLHYOUJI%>).is(':disabled') === false) {
           $(<%=ALLHYOUJIBTN_BUTTONALLHYOUJI%>).trigger("click");
        }

    <% } %>

    $(<%= ALLCHECKBTN_BUTTONALLCONTROL %>).click(function() {
      $("input[class='check']").each(function(){
       this.checked = true;
      });
    });

    $(<%= ALLUNCHECKBTN_BUTTONALLCONTROL %>).click(function() {
      $("input[class='check']").each(function(){
       this.checked = false;
      });
    });
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
      $(<%= MIKAISYOUHUBILIST1 + DIV %>).css("margin-top", "-1px");
<% }%>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM
      || uiBean.getPageNo() == PAGENO_RESULT) { %>
      <%
      if (!uiBean.isKidougmKbnWorkListSeigyo()) { %>
          $(<%=KOUTEIINFO + DIV%>).visible(false);
      <% } %>

      $(<%= COMMONCHECKBOX_LABEL %>).attr('rowspan','2');
      $(<%= TRKYMD_LABEL %>).attr('rowspan','2');
      $(<%= HUBINAIYOUMSG_LABEL %>).attr('rowspan','2');
      $(<%= GENPONHNKYKUMUCHKBOX_LABEL %>).attr('rowspan','2');
      $(<%= HASINYMD_LABEL %>).attr('rowspan','2');
      $(<%= HASSINSAKIKBN_LABEL %>).attr('rowspan','2');
      $(<%= KAISYOUYMD_LABEL %>).attr('rowspan','2');
      $(<%= NYUURYOKUTANTOUNM_LABEL %>).attr('colspan','1');
      $(<%= SYOUNINTANTOUNM_LABEL %>).attr('colspan','1');
      $(<%= COMMONCHECKBOX_DATA %>).attr('rowspan','2');
      $(<%= TRKYMD_DATA %>).attr('rowspan','2');
      $(<%= GENPONHNKYKUMUCHKBOX_DATA %>).attr('rowspan','2');
      $(<%= HUBINAIYOUMSG_DATA %>).attr('rowspan','2');
      $(<%= HASINYMD_DATA %>).attr('rowspan','2');
      $(<%= HASSINSAKIKBN_DATA %>).attr('rowspan','2');
      $(<%= KAISYOUYMD_DATA %>).attr('rowspan','2');
      $(<%= NYUURYOKUTANTOUNM_DATA %>).attr('colspan','1');
      $(<%= SYOUNINTANTOUNM_DATA %>).attr('colspan','1');

      $(<%= MICOMMONCHECKBOX_LABEL %>).attr('rowspan','2');
      $(<%= MITRKYMD_LABEL %>).attr('rowspan','2');
      $(<%= DISPHUBINAIYOUMSG_LABEL %>).attr('rowspan','2');
      $(<%= DISPGENPONHNKYKUMU_LABEL %>).attr('rowspan','2');
      $(<%= DISPHASSINYMD_LABEL %>).attr('rowspan','2');
      $(<%= DISPHASSINSAKIKBN_LABEL %>).attr('rowspan','2');
      $(<%= DISPKAISYOUYMD_LABEL %>).attr('rowspan','2');
      $(<%= DISPNYURYOKUTANTOUNM_LABEL %>).attr('colspan','1');
      $(<%= DISPSYOUNINTANTOUNM_LABEL %>).attr('colspan','1');
      $(<%= MICOMMONCHECKBOX_DATA %>).attr('rowspan','2');
      $(<%= MITRKYMD_DATA %>).attr('rowspan','2');
      $(<%= DISPHUBINAIYOUMSG_DATA %>).attr('rowspan','2');
      $(<%= DISPGENPONHNKYKUMU_DATA %>).attr('rowspan','2');
      $(<%= DISPHASSINYMD_DATA %>).attr('rowspan','2');
      $(<%= DISPHASSINSAKIKBN_DATA %>).attr('rowspan','2');
      $(<%= DISPKAISYOUYMD_DATA %>).attr('rowspan','2');
      $(<%= DISPNYURYOKUTANTOUNM_DATA %>).attr('colspan','1');
      $(<%= DISPSYOUNINTANTOUNM_DATA %>).attr('colspan','1');
<% } %>

<% if (uiBean.getKaisyouzumihubiListDataSource().getAllData().size() > 0) {%>
   <% if ((uiBean.getPageNo() == PAGENO_INPUTCONTENTS) || (uiBean.getPageNo() == PAGENO_CONFIRM) ||  (uiBean.getPageNo() == PAGENO_RESULT)) {%>
       showList(<%=KAISYOUZUMIHUBILIST%>);
   <% } %>
<% } %>

});
</script>
