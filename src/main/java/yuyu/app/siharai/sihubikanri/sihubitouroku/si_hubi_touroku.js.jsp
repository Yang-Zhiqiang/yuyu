<%--
    si_hubi_touroku.js.jsp - 保険金給付金不備登録 JavaScript(JSP)
--%>
<%@page import='yuyu.common.biz.bzcommon.BizUtil'%>
<%@page language='java' contentType='text/javascript; charset=UTF-8' pageEncoding='UTF-8' %>
<%@page import='static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*' %>
<%@page import='static yuyu.app.siharai.sihubikanri.sihubitouroku.SiHubiTourokuConstants.*' %>
<%@page import='static yuyu.app.siharai.sihubikanri.sihubitouroku.SiHubiTourokuSelector.*'  %>
<%@page import='jp.co.slcs.swak.core.inject.SWAKInjector' %>
<%@page import='yuyu.app.siharai.sihubikanri.sihubitouroku.SiHubiTourokuUiBean' %>
<%@page import='yuyu.common.biz.bzview.CommonViewInBean' %>
<%@page import='yuyu.def.classification.C_Delflag' %>
<% SiHubiTourokuUiBean uiBean = SWAKInjector.getInstance(SiHubiTourokuUiBean.class); %>

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
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM
      || uiBean.getPageNo() == PAGENO_RESULT) { %>
      <%
      if (uiBean.isKidougmKbnWorkListSeigyo()) { %>
          $(<%=KOUTEIINFO + DIV%>).visible(true);
      <% } %>

      <%
      if (uiBean.isNngHasinzumiHubiItiranUmuSeigyo()) { %>
          showList(<%=HASINZUMIHUBILIST%>);
          $(<%= TRKYMD_LABEL %>).attr('rowspan','2');
          $(<%= GENPONHNKYKUMUCHKBOX_LABEL %>).attr('rowspan','2');
          $(<%= HASINYMD_LABEL %>).attr('rowspan','2');
          $(<%= HASSINSAKIKBN_LABEL %>).attr('rowspan','2');
          $(<%= KAISYOUYMD_LABEL %>).attr('rowspan','2');
          $(<%= HUBISYORUINM_LABEL %>).attr('colspan','1');
          $(<%= HUBINAIYOUMSG_LABEL %>).attr('colspan','1');
          $(<%= NYUURYOKUTANTOUNM_LABEL %>).attr('colspan','1');
          $(<%= SYOUNINTANTOUNM_LABEL %>).attr('colspan','1');
          $(<%= TRKYMD_DATA %>).attr('rowspan','2');
          $(<%= GENPONHNKYKUMUCHKBOX_DATA %>).attr('rowspan','2');
          $(<%= HASINYMD_DATA %>).attr('rowspan','2');
          $(<%= HASSINSAKIKBN_DATA %>).attr('rowspan','2');
          $(<%= KAISYOUYMD_DATA %>).attr('rowspan','2');
          $(<%= HUBISYORUINM_DATA %>).attr('colspan','1');
          $(<%= HUBINAIYOUMSG_DATA %>).attr('colspan','1');
          $(<%= NYUURYOKUTANTOUNM_DATA %>).attr('colspan','1');
          $(<%= SYOUNINTANTOUNM_DATA %>).attr('colspan','1');
      <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      function listRowsDisplayControl(listGroup){
        $(listGroup).find('tr').each(function(){
          if($(this).find('.visibleFlg').length != 0){
              if($(this).find('.visibleFlg').val() == <%= C_Delflag.BLNK %>){
                  $(this).visible(true);
              }else{
                  $(this).visible(false);
              }
          }
        });
      }

     listRowsDisplayControl(<%= MIHASINHUBILIST %>);

     inputToOutput(<%= DISPHUBISYORUINM_DATA_TEXT %>);
     inputToOutput(<%= DISPNYURYOKUTANTOUNM_DATA_TEXT %>);
     inputToOutput(<%= DISPSYOUNINTANTOUNM_DATA_TEXT %>);
     inputToOutput(<%= DISPTRKYMD_DATA_SELECT %>);
     inputToOutput(<%= DISPTRKYMD_DATA_TEXT %>);

    $(document).on('click', <%= ADDBTN_TUIKABUTTONS %>,function(){
      var newRowsObj = getMultiLineListRows($(<%= MIHASINHUBILIST %>).find('tr:visible').last().nextAll('tr:hidden').first());
      newRowsObj.visible(true);
      newRowsObj.find('.visibleFlg').val(<%= C_Delflag.BLNK %>);

      if(getListVisibleRowCount(<%= MIHASINHUBILIST %>) == <%= MAX_ROW_COUNT %>){
        $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
      }
    });

    <% for (int i = 0; i < uiBean.getMihasinhubiListDataSource().getAllData().size(); i++){ %>
      $(document).on('click', <%= SAKUJYOLINK_MIHASINHUBILIST(i) %>,function(){
          var rowCount = getListVisibleRowCount(<%= MIHASINHUBILIST %>);
          if(rowCount > 1){
              var delRowsObj = getMultiLineListRows($(this).parents('tr'));
              delRowsObj.find(':input').trigger('formInit');

              listRowShift($(this).parents('tr'));

              var lastRowsObj = getMultiLineListRows($(<%= MIHASINHUBILIST %>).find('tr:visible').last());
              lastRowsObj.find(':input').trigger('formInit');
              lastRowsObj.visible(false);
              lastRowsObj.find('.visibleFlg').val(<%= C_Delflag.SAKUJYO %>);
          }
          if(rowCount == 1){
              var delRowsObj = getMultiLineListRows($(this).parents('tr'));
              delRowsObj.find(':input').trigger('formInit');
          }

          $(<%= ADDBTN_TUIKABUTTONS %>).visible(true);
        });

        $('#mihasinhubiList\\[<%= i %>\\]\\.dispsyoruicdPopupButton').popupResponse(function() {
          $('#mihasinhubiList\\[<%= i %>\\]\\.disphubinaiyoumsg').val($('#mihasinhubiList\\[<%= i %>\\]\\.disphubinaiyoumsg').text().replace(/\<BR\>/g, '\r\n').replace(/\<br\>/g, '\r\n'));
          inputToOutput(<%= DISPHUBISYORUINM_DATA_TEXT %>);
        });
    <% } %>

    $(document).on('formInit', '.inputForm1', function(){
           $(this).val('');
           inputToOutput(<%= DISPHUBISYORUINM_DATA_TEXT %>);
        });

    $(document).on('formInit', '.inputForm2', function(){
           $(this).prop({'checked' : false});
        });

    $(document).on('formInit', '.inputForm4', function(){
           $(this).val('2');
        });

    $(document).on('formInit', '.inputForm5', function(){
           $(this).val('');
        });

    $(document).on('formInit', '.inputForm6', function(){
           $(this).val('');
        });

    $(document).on('formInit', '.inputForm8', function(){
           $(this).val('');
        });

    $(document).on('formInit', <%= DISPTRKYMD_DATA_SELECT %>, function(){
      $(this).val($(<%= SYORIYMD_DATA_SELECT %>).val());
      inputToOutput(<%= DISPTRKYMD_DATA_SELECT %>);
    });
    $(document).on('formInit', <%= DISPTRKYMD_DATA_TEXT %>, function(){
      $(this).val($(<%= SYORIYMD_DATA_TEXT_WAREKI_SYMBOL %>).val());
      inputToOutput(<%= DISPTRKYMD_DATA_TEXT %>);
    });

    $(document).on('formInit', <%= DISPNYURYOKUTANTOUNM_DATA_TEXT %>, function(){
      $(this).val($(<%= NYUURYOKUTANTOUNM_DATA_TEXT %>).val());
      inputToOutput(<%= DISPNYURYOKUTANTOUNM_DATA_TEXT %>);
    });

    showList(<%= MIHASINHUBILIST %>);

    showGroup(<%= TUIKABUTTONS %>);
    if (getListVisibleRowCount(<%= MIHASINHUBILIST %>) == <%= MAX_ROW_COUNT %>) {
      $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
    }

    $(<%= DISPTRKYMD_LABEL %>).attr('rowspan','2');
    $(<%= DISPGENPONHNKYKUMU_LABEL %>).attr('rowspan','2');
    $(<%= DISPHASSINYMD_LABEL %>).attr('rowspan','2');
    $(<%= DISPHASSINSAKIKBN_LABEL %>).attr('rowspan','2');
    $(<%= SAKUJYOLINK_LABEL %>).attr('rowspan','2');
    $(<%= DISPHUBISYORUINM_LABEL %>).attr('colspan','1');
    $(<%= DISPHUBINAIYOUMSG_LABEL %>).attr('colspan','1');
    $(<%= DISPNYURYOKUTANTOUNM_LABEL %>).attr('colspan','1');
    $(<%= DISPSYOUNINTANTOUNM_LABEL %>).attr('colspan','1');
    $(<%= DISPTRKYMD_DATA %>).attr('rowspan','2');
    $(<%= DISPGENPONHNKYKUMU_DATA %>).attr('rowspan','2');
    $(<%= DISPHASSINYMD_DATA %>).attr('rowspan','2');
    $(<%= DISPHASSINSAKIKBN_DATA %>).attr('rowspan','2');
    $(<%= SAKUJYOLINK_DATA %>).attr('rowspan','2');
    $(<%= DISPHUBISYORUINM_DATA %>).attr('colspan','1');
    $(<%= DISPHUBINAIYOUMSG_DATA %>).attr('colspan','1');
    $(<%= DISPNYURYOKUTANTOUNM_DATA %>).attr('colspan','1');
    $(<%= DISPSYOUNINTANTOUNM_DATA %>).attr('colspan','1');
  <% } %>

<%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (uiBean.getMihasinhubiListDataSource().getAllData().size() > 0) { %>
         showList(<%= MIHASINHUBILIST %>);
         $(<%= DISPTRKYMD_LABEL %>).attr('rowspan','2');
         $(<%= DISPGENPONHNKYKUMU_LABEL %>).attr('rowspan','2');
         $(<%= DISPHASSINYMD_LABEL %>).attr('rowspan','2');
         $(<%= DISPHASSINSAKIKBN_LABEL %>).attr('rowspan','2');
         $(<%= DISPKAISYOUYMD_LABEL %>).attr('rowspan','2');
         $(<%= DISPHUBISYORUINM_LABEL %>).attr('colspan','1');
         $(<%= DISPHUBINAIYOUMSG_LABEL %>).attr('colspan','1');
         $(<%= DISPNYURYOKUTANTOUNM_LABEL %>).attr('colspan','1');
         $(<%= DISPSYOUNINTANTOUNM_LABEL %>).attr('colspan','1');
         $(<%= DISPTRKYMD_DATA %>).attr('rowspan','2');
         $(<%= DISPGENPONHNKYKUMU_DATA %>).attr('rowspan','2');
         $(<%= DISPHASSINYMD_DATA %>).attr('rowspan','2');
         $(<%= DISPHASSINSAKIKBN_DATA %>).attr('rowspan','2');
         $(<%= DISPKAISYOUYMD_DATA %>).attr('rowspan','2');
         $(<%= DISPHUBISYORUINM_DATA %>).attr('colspan','1');
         $(<%= DISPHUBINAIYOUMSG_DATA %>).attr('colspan','1');
         $(<%= DISPNYURYOKUTANTOUNM_DATA %>).attr('colspan','1');
         $(<%= DISPSYOUNINTANTOUNM_DATA %>).attr('colspan','1');
    <% } %>
  <% } %>
  <% if (uiBean.getPageNo() == PAGENO_RESULT && !BizUtil.isBlank(uiBean.getTyouhyouJoinKey())) {
    %>
      openReport('print', '_blank');
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS && !BizUtil.isBlank(uiBean.getKarisakuseiTyouhyouJoinKey())) {
     %>
      openReport('karisakuseiPrint', '_blank');
  <% } %>

});

</script>
