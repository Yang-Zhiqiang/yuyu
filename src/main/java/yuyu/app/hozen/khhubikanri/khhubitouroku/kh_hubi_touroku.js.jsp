<%--
    kh_hubi_touroku.js.jsp - 契約保全不備登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khhubikanri.khhubitouroku.KhHubiTourokuConstants.*" %>
<%@page import="static yuyu.app.hozen.khhubikanri.khhubitouroku.KhHubiTourokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khhubikanri.khhubitouroku.KhHubiTourokuUiBean" %>
<%@page import="yuyu.def.classification.C_Delflag" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_HassinsakiKbn" %>
<%@page import="yuyu.def.classification.C_SyoruiCdKbn" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<% KhHubiTourokuUiBean uiBean = SWAKInjector.getInstance(KhHubiTourokuUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT) { %>
<jsp:include
  page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
<jsp:include
  page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
<% } %>

<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    function listRowsDisplayControl(listGroup){
      $(listGroup).find('tr').each(function(){
        if($(this).find('.visibleFlg').length != 0){
            if($(this).find('.visibleFlg').val() == <%= C_Delflag.BLNK %>){
              $(this).visible(true);
            } else {
              $(this).visible(false);
            }
        }
      });
    }
    listRowsDisplayControl(<%= HUBILIST2 %>);
    inputToOutput(<%= DISPTRKYMD_DATA_SELECT %>);
    inputToOutput(<%= DISPTRKYMD_TEXT_WAREKI_SYMBOL %>);
    inputToOutput(<%= DISPSYORUINM_DATA_TEXT %>);
    inputToOutput(<%= DISPNYURYOKUTANTOUNM_DATA_TEXT %>);
    inputToOutput(<%= DISPSYOUNINTANTOUNM_DATA_TEXT %>);

    showList(<%= HUBILIST2 %>);

     showGroup(<%= TUIKABUTTONS %>);
     if (getListVisibleRowCount(<%= HUBILIST2 %>) == <%= MAX_ROW_COUNT %>) {
       $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
     }

    $(document).on('click', <%= ADDBTN_TUIKABUTTONS %>,function(){
      var newRowsObj = getMultiLineListRows($(<%= HUBILIST2 %>).find('tr:visible').last().nextAll('tr:hidden').first());
      newRowsObj.visible(true);
      newRowsObj.find('.visibleFlg').val(<%= C_Delflag.BLNK %>);

      if(getListVisibleRowCount(<%= HUBILIST2 %>) == <%= MAX_ROW_COUNT %>){
        $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
      }
    });

    <% for(int i = 0; i < uiBean.getHubiList2DataSource().getAllData().size(); i++){ %>
      $(document).on('click', <%= SAKUJYOLINK_HUBILIST2(i) %>,function(){

          var rowCount = getListVisibleRowCount(<%= HUBILIST2 %>);

          if(rowCount > <%= MIN_ROW_COUNT %>){
              var delRowsObj = getMultiLineListRows($(this).parents('tr'));
              delRowsObj.find(':input').trigger('formInit');
              listRowShift($(this).parents('tr'));

              var lastRowsObj = getMultiLineListRows($(<%= HUBILIST2 %>).find('tr:visible').last());
              lastRowsObj.find(':input').trigger('formInit');
              lastRowsObj.visible(false);
              lastRowsObj.find('.visibleFlg').val(<%= C_Delflag.SAKUJYO %>);

          }
          if(rowCount == <%= MIN_ROW_COUNT %>){
              var delRowsObj = getMultiLineListRows($(this).parents('tr'));
              delRowsObj.find(':input').trigger('formInit');
          }

          $(<%= ADDBTN_TUIKABUTTONS %>).visible(true);
        });

        $('#hubiList2\\[<%= i %>\\]\\.dispsyoruicdPopupButton').popupResponse(function() {
            $('#hubiList2\\[<%= i %>\\]\\.disphubinaiyoumsg').val($('#hubiList2\\[<%= i %>\\]\\.disphubinaiyoumsg').text().replace(/\<BR\>/g, '\r\n').replace(/\<br\>/g, '\r\n'));
            inputToOutput(<%= DISPSYORUINM_DATA_TEXT %>);
        });
    <% } %>

    $(document).on('formInit', <%= DISPTRKYMD_DATA_SELECT %>, function(){
      $(this).val($(<%= SYORIYMD_DATA_SELECT %>).val());
      inputToOutput(<%= DISPTRKYMD_DATA_SELECT %>);
    });
    $(document).on('formInit', <%= DISPTRKYMD_TEXT_WAREKI_SYMBOL %>, function(){
      $(this).val($(<%= SYORIYMD_DATA_TEXT_WAREKI_SYMBOL %>).val());
      inputToOutput(<%= DISPTRKYMD_TEXT_WAREKI_SYMBOL %>);
    });

    $(document).on('formInit', <%= DISPSYORUICD_DATA_TEXT %>, function(){
       $(this).val('<%= C_SyoruiCdKbn.BLNK.getValue() %>');
    });
    $(document).on('formInit', <%= DISPSYORUINM_DATA_TEXT %>, function(){
       $(this).val('');
       inputToOutput(<%= DISPSYORUINM_DATA_TEXT %>);
    });
    $(document).on('formInit', <%= DISPHUBINAIYOUMSG_DATA_TEXT %>, function(){
       $(this).val('');
    });
    $(document).on('formInit', '.inputForm4', function(){
       $(this).val('<%= C_HassinsakiKbn.KOK.getValue() %>');
    });
    $(document).on('formInit', '.inputForm2', function(){
       $(this).prop({'checked' : false});
    });
    $(document).on('formInit', <%= DISPNYURYOKUTANTOUNM_DATA_TEXT %>, function(){
      $(this).val('');
      inputToOutput(<%= DISPNYURYOKUTANTOUNM_DATA_TEXT %>);
    });
    $(document).on('formInit', <%= DISPSYOUNINTANTOUNM_DATA_TEXT %>, function(){
      $(this).val('');
      inputToOutput(<%= DISPSYOUNINTANTOUNM_DATA_TEXT %>);
    });
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
       showGroup(<%= COMMENT %>);
       $(<%= SYORIKEKKAKBN_COMMENT%>).attr("disabled", "true");
    <% } else if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode()) ||
        C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
       showGroup(<%= COMMENT %>);
       $(<%= COMMENT + LABEL%>).text('●結果入力');
       showKoumoku(<%= SYORIKEKKAKBN_COMMENT%>);
       showKoumoku(<%= TENNOUSAKISOUSASYACD_COMMENT%>);
       $(<%= HUBIANSWERKJTINFO + LABEL%>).text($(<%= HUBIANSWERKJTINFO + LABEL%>).text()
       + '　　　　<%= MessageUtil.getMessage(MessageId.IBA1006) %>');
    <% } %>

    <% for(int i = 0; i < uiBean.getHashinzumiHubiListDataSource().getAllData().size(); i++){ %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getHashinzumiHubiListDataSource().getAllData().get(i).getDispgenponhnkykumu())) { %>
        $('#hashinzumiHubiList\\[<%= i %>\\]\\.dispgenponhnkykumu').text('●');
      <% } else  { %>
        $('#hashinzumiHubiList\\[<%= i %>\\]\\.dispgenponhnkykumu').text('');
      <% } %>
    <% } %>

    <% for(int i = 0; i < uiBean.getHubiList2DataSource().getAllData().size(); i++){ %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getHubiList2DataSource().getAllData().get(i).getDispgenponhnkykumu())) { %>
        $('#hubiList2\\[<%= i %>\\]\\.dispgenponhnkykumu').text('●');
      <% } else  { %>
        $('#hubiList2\\[<%= i %>\\]\\.dispgenponhnkykumu').text('');
      <% } %>
    <% } %>

    $(<%= TRKYMD_LABEL %>).each(
      function(){
        $(this).css("width", "8%");
      }
    );
    $(<%= HUBISYORUINM_LABEL %>).each(
      function(){
        $(this).css("width", "44%");
      }
    );
    $(<%= DISPGENPONHNKYKUMU_LABEL %>).each(
      function(){
        $(this).css("width", "3%");
      }
    );
    $(<%= HASINYMD_LABEL %>).each(
      function(){
        $(this).css("width", "8%");
      }
    );
    $(<%= HASSINSAKIKBN_LABEL %>).each(
      function(){
        $(this).css("width", "12%");
      }
    );
    $(<%= NYUURYOKUTANTOUNM_LABEL %>).each(
      function(){
        $(this).css("width", "16%");
      }
    );
    $(<%= KAISYOUYMD_LABEL %>).each(
      function(){
        $(this).css("width", "8%");
      }
    );

    $(<%= DISPTRKYMD_LABEL %>).each(
      function(){
        $(this).css("width", "8%");
      }
    );
    $(<%= DISPSYORUICD_LABEL %>).each(
      function(){
        $(this).css("width", "44%");
      }
    );
    $(<%= DISPGENPONHNKYKUMUCHKBOX_LABEL %>).each(
      function(){
        $(this).css("width", "3%");
      }
    );
    $(<%= DISPGENPONHNKYKUMU2_LABEL %>).each(
      function(){
        $(this).css("width", "3%");
      }
    );
    $(<%= DISPHASSINYMD_LABEL %>).each(
      function(){
        $(this).css("width", "8%");
      }
    );
    $(<%= DISPHASSINSAKIKBN_LABEL %>).each(
      function(){
        $(this).css("width", "12%");
      }
    );
    $(<%= DISPNYURYOKUTANTOUNM_LABEL %>).each(
      function(){
        $(this).css("width", "16%");
      }
    );
    $(<%= SAKUJYOLINK_LABEL %>).each(
      function(){
        $(this).css("width", "8%");
      }
    );
    $(<%= DISPKAISYOUYMD_LABEL %>).each(
      function(){
        $(this).css("width", "8%");
      }
    );
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <%
       if (C_KhkinouModeIdKbn.DEFAULT.eq(uiBean.getKhkinouModeIdKbn())
           || C_KhkinouModeIdKbn.INPUTKEY.eq(uiBean.getKhkinouModeIdKbn())) {%>
       $(<%= SYOKIGAMENHEBTNBYWORKFLOW_FOOTERBUTTONS5%>).visible(false);
    <%
       } else {%>
       $(<%= SYOKIGAMENHEBTN_FOOTERBUTTONS5%>).visible(false);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <% if (uiBean.getHashinzumiHubiListDataSource().getAllData().size() > 0) { %>
      showList(<%= HASHINZUMIHUBILIST %>);

      $(<%= TRKYMD_LABEL %>).attr("rowspan","2");
      $(<%= DISPGENPONHNKYKUMU_LABEL %>).attr("rowspan","2");
      $(<%= HASINYMD_LABEL %>).attr("rowspan","2");
      $(<%= HASSINSAKIKBN_LABEL %>).attr("rowspan","2");
      $(<%= KAISYOUYMD_LABEL %>).attr("rowspan","2");
      $(<%= HUBISYORUINM_LABEL %>).attr("colspan","1");
      $(<%= HUBINAIYOUMSG_LABEL %>).attr("colspan","1");
      $(<%= NYUURYOKUTANTOUNM_LABEL %>).attr("colspan","1");
      $(<%= SYOUNINTANTOUNM_LABEL %>).attr("colspan","1");

      $(<%= TRKYMD_DATA %>).attr("rowspan","2");
      $(<%= DISPGENPONHNKYKUMU_DATA %>).attr("rowspan","2");
      $(<%= HASINYMD_DATA %>).attr("rowspan","2");
      $(<%= HASSINSAKIKBN_DATA %>).attr("rowspan","2");
      $(<%= KAISYOUYMD_DATA %>).attr("rowspan","2");
      $(<%= HUBISYORUINM_DATA %>).attr("colspan","1");
      $(<%= HUBINAIYOUMSG_DATA %>).attr("colspan","1");
      $(<%= NYUURYOKUTANTOUNM_DATA %>).attr("colspan","1");
      $(<%= SYOUNINTANTOUNM_DATA %>).attr("colspan","1");
    <% } %>

    $(<%= DISPTRKYMD_LABEL %>).attr("rowspan","2");
    $(<%= DISPGENPONHNKYKUMUCHKBOX_LABEL %>).attr("rowspan","2");
    $(<%= DISPHASSINYMD_LABEL %>).attr("rowspan","2");
    $(<%= DISPHASSINSAKIKBN_LABEL %>).attr("rowspan","2");
    $(<%= SAKUJYOLINK_LABEL %>).attr("rowspan","2");
    $(<%= DISPSYORUICD_LABEL %>).attr("colspan","1");
    $(<%= DISPHUBINAIYOUMSG_LABEL %>).attr("colspan","1");
    $(<%= DISPNYURYOKUTANTOUNM_LABEL %>).attr("colspan","1");
    $(<%= DISPSYOUNINTANTOUNM_LABEL %>).attr("colspan","1");

    $(<%= DISPTRKYMD_DATA %>).attr("rowspan","2");
    $(<%= DISPGENPONHNKYKUMUCHKBOX_DATA %>).attr("rowspan","2");
    $(<%= DISPHASSINYMD_DATA %>).attr("rowspan","2");
    $(<%= DISPHASSINSAKIKBN_DATA %>).attr("rowspan","2");
    $(<%= SAKUJYOLINK_DATA %>).attr("rowspan","2");
    $(<%= DISPSYORUICD_DATA %>).attr("colspan","1");
    $(<%= DISPHUBINAIYOUMSG_DATA %>).attr("colspan","1");
    $(<%= DISPNYURYOKUTANTOUNM_DATA %>).attr("colspan","1");
    $(<%= DISPSYOUNINTANTOUNM_DATA %>).attr("colspan","1");
  <% } else if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (uiBean.getHashinzumiHubiListDataSource().getAllData().size() > 0) { %>
      showList(<%= HASHINZUMIHUBILIST %>);

      $(<%= TRKYMD_LABEL %>).attr("rowspan","2");
      $(<%= DISPGENPONHNKYKUMU_LABEL %>).attr("rowspan","2");
      $(<%= HASINYMD_LABEL %>).attr("rowspan","2");
      $(<%= HASSINSAKIKBN_LABEL %>).attr("rowspan","2");
      $(<%= KAISYOUYMD_LABEL %>).attr("rowspan","2");
      $(<%= HUBISYORUINM_LABEL %>).attr("colspan","1");
      $(<%= HUBINAIYOUMSG_LABEL %>).attr("colspan","1");
      $(<%= NYUURYOKUTANTOUNM_LABEL %>).attr("colspan","1");
      $(<%= SYOUNINTANTOUNM_LABEL %>).attr("colspan","1");

      $(<%= TRKYMD_DATA %>).attr("rowspan","2");
      $(<%= DISPGENPONHNKYKUMU_DATA %>).attr("rowspan","2");
      $(<%= HASINYMD_DATA %>).attr("rowspan","2");
      $(<%= HASSINSAKIKBN_DATA %>).attr("rowspan","2");
      $(<%= KAISYOUYMD_DATA %>).attr("rowspan","2");
      $(<%= HUBISYORUINM_DATA %>).attr("colspan","1");
      $(<%= HUBINAIYOUMSG_DATA %>).attr("colspan","1");
      $(<%= NYUURYOKUTANTOUNM_DATA %>).attr("colspan","1");
      $(<%= SYOUNINTANTOUNM_DATA %>).attr("colspan","1");
    <% } %>

    <% if (uiBean.getHubiList2DataSource().getAllData().size() > 0) { %>

      showList(<%= HUBILIST2 %>);

      $(<%= DISPTRKYMD_LABEL %>).attr("rowspan","2");
      $(<%= DISPGENPONHNKYKUMU2_LABEL %>).attr("rowspan","2");
      $(<%= DISPHASSINYMD_LABEL %>).attr("rowspan","2");
      $(<%= DISPHASSINSAKIKBN_LABEL %>).attr("rowspan","2");
      $(<%= DISPKAISYOUYMD_LABEL %>).attr("rowspan","2");
      $(<%= DISPSYORUICD_LABEL %>).attr("colspan","1");
      $(<%= DISPHUBINAIYOUMSG_LABEL %>).attr("colspan","1");
      $(<%= DISPNYURYOKUTANTOUNM_LABEL %>).attr("colspan","1");
      $(<%= DISPSYOUNINTANTOUNM_LABEL %>).attr("colspan","1");

      $(<%= DISPTRKYMD_DATA %>).attr("rowspan","2");
      $(<%= DISPGENPONHNKYKUMU2_DATA %>).attr("rowspan","2");
      $(<%= DISPHASSINYMD_DATA %>).attr("rowspan","2");
      $(<%= DISPHASSINSAKIKBN_DATA %>).attr("rowspan","2");
      $(<%= DISPKAISYOUYMD_DATA %>).attr("rowspan","2");
      $(<%= DISPSYORUICD_DATA %>).attr("colspan","1");
      $(<%= DISPHUBINAIYOUMSG_DATA %>).attr("colspan","1");
      $(<%= DISPNYURYOKUTANTOUNM_DATA %>).attr("colspan","1");
      $(<%= DISPSYOUNINTANTOUNM_DATA %>).attr("colspan","1");
    <% } %>
  <% } %>

  <% if (!BizUtil.isBlank(uiBean.getTyouhyoukey())) { %>
      <%
      if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { //%>
         openReport("printKarisakusei", "_blank");
       <% } %>
       <%
       if (uiBean.getPageNo() == PAGENO_RESULT) { //%>
         openReport("print", "_blank");
       <% } %>
  <% } %>

<%
    if (C_UmuKbn.ARI == uiBean.getItirankeiyuumukbn()) {
%>
        $(<%=MODORUBTNBYINPUTCONTENTS_FOOTERBUTTONS3%>).visible(false);
        $(<%=ITIRANHEBTNBYINPUTCONTENTS_FOOTERBUTTONS3%>).visible(true);
<%
    } else {
%>
        $(<%=MODORUBTNBYINPUTCONTENTS_FOOTERBUTTONS3%>).visible(true);
        $(<%=ITIRANHEBTNBYINPUTCONTENTS_FOOTERBUTTONS3%>).visible(false);
<%
    }
%>
});
//-->
</script>
