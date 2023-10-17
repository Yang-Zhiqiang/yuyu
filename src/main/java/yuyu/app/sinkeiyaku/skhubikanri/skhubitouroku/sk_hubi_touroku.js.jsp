<%--
    sk_hubi_touroku.js.jsp - 新契約不備登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.SkHubiTourokuConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.SkHubiTourokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.SkHubiTourokuUiBean" %>
<%@page import="yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.HubiList2DataSourceBean" %>
<%@page import="yuyu.def.classification.C_Delflag" %>
<%@page import="yuyu.def.classification.C_KidougmKbn" %>
<%@page import="yuyu.def.classification.C_HassinsakiKbn" %>
<%@page import="yuyu.def.classification.C_HasinkyokaKbn" %>
<%@page import="yuyu.def.classification.C_SyoruiCdKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="java.util.List" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_SkkinouModeIdKbn"%>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.def.classification.C_MosUketukeKbn" %>
<%@page import="yuyu.def.classification.C_DrtenRnrkhouKbn" %>
<% SkHubiTourokuUiBean uiBean = SWAKInjector.getInstance(SkHubiTourokuUiBean.class);
   CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
   commonViewInBean.setCommonViewUiBeanParam(uiBean); %>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>
<script type="text/javascript">
$(function(){

    var hubikoumokucd = [];
    var hubinaiyoucd = [];
    var tyoubunFlgKekka = [];
    var renrakuJikou = [];

   <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
     <% if (uiBean.getHubiList1DataSource().getAllData().size() > 0) { %>
       showList(<%= HUBILIST1 %>);
     <% } %>
     showGroup(<%= MOSJKSYOUKAIBUTTONS %>);
     $(<%= CLASS_ROWSPAN_5 %>).attr('rowspan', '5');
     $(<%= CLASS_COLSPAN_1 %>).attr('colspan', '1');
     $(<%= CLASS_ROWSPAN_2 %>).attr('rowspan', '2');
     $(<%= CLASS_ROWSPAN_4 %>).attr('rowspan', '3');
     $(<%= CLASS_COLSPAN_5 %>).attr('colspan', '5');
     $(<%= CLASS_LASTLISTTITLE %>).text('');
     showList(<%= TORIATUKAITYUUIINFO %>);

   <% } %>

   <%
   if (uiBean.getPageNo() == PAGENO_TENKEN_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_TENKEN_CONFIRM) { %>
    <% if (uiBean.getHubiList1DataSource().getAllData().size() > 0) { %>
       showList(<%= HUBILIST1 %>);
    <% } %>
     $(<%= CLASS_ROWSPAN_5 %>).attr('rowspan', '5');
     $(<%= CLASS_COLSPAN_1 %>).attr('colspan', '1');
     $(<%= CLASS_ROWSPAN_2 %>).attr('rowspan', '2');
     $(<%= CLASS_ROWSPAN_4 %>).attr('rowspan', '3');
     $(<%= CLASS_COLSPAN_5 %>).attr('colspan', '5');
     $(<%= CLASS_LASTLISTTITLE %>).text('');

     $(<%= FUNCTION_NAME %>).attr("disabled", "true");
     $(<%= FUNCTION_NAME %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');
   <% } %>

   <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT || uiBean.getPageNo() == PAGENO_TENKEN_CONFIRM) { %>
     $(<%= CLASS_TYOUBUNFLGKM %>).attr('rowspan', '3');
     $(<%= CLASS_SAKUJYOKM %>).visible(false);
     showList(<%= HUBILIST2 %>);
   <% } %>
   <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_TENKEN_INPUTCONTENTS) { %>

    if (hubikoumokucd == '' && $('#dummykmk1').val() != '') {
      hubikoumokucd = $('#dummykmk1').val().split(",");
    }
    if (hubinaiyoucd == '' && $('#dummykmk2').val() != '') {
      hubinaiyoucd = $('#dummykmk2').val().split(",");
    }
    if (tyoubunFlgKekka == '' && $('#dummykmk4').val() != '') {
      tyoubunFlgKekka = $('#dummykmk4').val().split(",");
    }
    if (renrakuJikou == '' && $('#dummykmk5').val() != '') {
      renrakuJikou = $('#dummykmk5').val().split(",");
    }
     $(<%= CLASS_SAKUJYOKM %>).visible(true);

     function listRowsDisplayControl(listGroup){
       $(listGroup).find('tr').each(function(){
         if($(this).find('.visibleFlg').length != 0){
           var multiLineObj = getMultiLineListRows($(this));
           if(multiLineObj.find('.visibleFlg').val() == <%= C_Delflag.BLNK %>){
             multiLineObj.visible(true);
           }else{
             multiLineObj.visible(false);
           }
          }
        });
      }

    inputToOutput(<%= DISPINPUTTRKYMD_DATA_SELECT %>);
    inputToOutput(<%= DISPINPUTTRKYMD_DATA_TEXT_WAREKI_SYMBOL %>);
    inputToOutput(<%= DISPINPUTTRKYMD_DATA_TEXT_SEIREKI %>);

    inputToOutput(<%= DISPINPUTNYURYOKUTANTOUNM_DATA_TEXT %>);

    listRowsDisplayControl(<%= HUBILIST2 %>);
    showList(<%= HUBILIST2 %>);
    var rowCount = getListVisibleRowCount(<%= HUBILIST2 %>);
    if(rowCount < <%= MAX_ROW_COUNT - uiBean.getHubiList1DataSource().getAllData().size() %> ){
      showGroup(<%= TUIKABUTTONS %>);
    }else{
      showGroup(<%= TUIKABUTTONS %>);
      $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
    }

    $(document).on('click', <%= ADDBTN_TUIKABUTTONS %>,function(){
      var rowCount = getListVisibleRowCount(<%= HUBILIST2 %>);
      if(rowCount >= <%= MAX_ROW_COUNT - uiBean.getHubiList1DataSource().getAllData().size() - 1 %> ){
        $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
      }

      var newRowsObj = getMultiLineListRows($(<%= HUBILIST2 %>).find('tr:visible').last().nextAll('tr:hidden').first());
      newRowsObj.visible(true);
      newRowsObj.find('.visibleFlg').val(<%= C_Delflag.BLNK %>);
    });

    <% for(int i = 0; i < uiBean.getHubiList2DataSource().getAllData().size(); i++){ %>
       <%
         if (!C_Delflag.SAKUJYO.eq(uiBean.getHubiList2DataSource().getAllData().get(i).getSakujyoflg())) {
             String syoruiCd      = uiBean.getHubiList2DataSource().getAllData().get(i).getHubisyoruicd().getValue();
             String hubikoumokuCd = uiBean.getHubiList2DataSource().getAllData().get(i).getDispinputskhubikoumoku();
             String hubinaiyouCd  = uiBean.getHubiList2DataSource().getAllData().get(i).getDispinputhubinaiyoucd();
             boolean tyoubunFlg   = uiBean.getHubiList2DataSource().getAllData().get(i).getDispinputtyoubunflg();
       %>

         onLoadPullDownList($(<%= DISPINPUTSKHUBIKOUMOKU_HUBILIST2(i)%>),
                            $(<%= DISPINPUTHUBINAIYOUCD_HUBILIST2(i)%>),
                            '<%=syoruiCd %>',
                            '<%=hubikoumokuCd %>',
                            '<%=hubinaiyouCd %>');

         <%if (tyoubunFlg) { %>
            $(<%= TYOUBUNDISPRENRAKUJIKOU_HUBILIST2(i)%>).attr('rows', '15');
         <%} else {%>
            $(<%= TYOUBUNDISPRENRAKUJIKOU_HUBILIST2(i)%>).attr('rows', '5');
         <%}%>
       <% }%>
    <% } %>

    $(<%= CLASS_SAKUJYOKM %>).each(function(index){
       $(this).click(function(){

          var rowCount = getListVisibleRowCount(<%= HUBILIST2 %>);

          if(rowCount > <%= MIN_ROW_COUNT %>){
              var delRowsObj = getMultiLineListRows($(this).parents('tr'));
              delRowsObj.find(':input').trigger('formInit');
              listRowShiftHubiTouroku($(this).parents('tr'));

              var lastRowsObj = getMultiLineListRows($(<%= HUBILIST2 %>).find('tr:visible').last());
              lastRowsObj.find(':input').trigger('formInit');
              lastRowsObj.visible(false);
              lastRowsObj.find('.visibleFlg').val(<%= C_Delflag.SAKUJYO %>);

          }
          if(rowCount == <%= MIN_ROW_COUNT %>){
              var delRowsObj = getMultiLineListRows($(this).parents('tr'));
              delRowsObj.find(':input').trigger('formInit');
          }

          rowCount = getListVisibleRowCount(<%= HUBILIST2 %>);
          if(rowCount < <%= MAX_ROW_COUNT - uiBean.getHubiList1DataSource().getAllData().size() %> ){
            $(<%= ADDBTN_TUIKABUTTONS %>).visible(true);
          }

       });
    });


    $(document).on('formInit', '.inputForm1', function(){
       $(this).val('<%= C_HasinkyokaKbn.HORYUU.getValue() %>');
    });
    $(document).on('formInit', '.inputForm2', function(){
       $(this).val('<%= C_HassinsakiKbn.DRTEN.getValue() %>');
    });
    $(document).on('formInit', '.inputForm8', function(){
       $(this).val('');
       $(this).attr('rows', '5');
    });
    $(document).on('formInit', '.inputForm3', function(){
       $(this).val('');
       $(this).attr('rows', '5');
       $(this).removeClass('errorItem');
    });
    $(document).on('formInit', '.inputForm4', function(){
       $(this).val('<%= C_SyoruiCdKbn.BLNK.getValue() %>');
    });
    $(document).on('formInit', '.inputForm5', function(){
       $(this).empty();
    });
    $(document).on('formInit', '.inputForm6', function(){
       $(this).empty();
    });
    $(document).on('formInit', '.inputForm7', function(){
       $(this).prop({'checked' : false});
    });

    $(document).on('formInit', <%= DISPINPUTTRKYMD_DATA_SELECT %>, function(){
      $(this).val($(<%= SYORIYMD_DATA_SELECT %>).val());
      inputToOutput(<%= DISPINPUTTRKYMD_DATA_SELECT %>);
    });
    $(document).on('formInit', <%= DISPINPUTTRKYMD_DATA_TEXT_WAREKI_SYMBOL %>, function(){
      $(this).val($(<%= SYORIYMD_DATA_TEXT_WAREKI_SYMBOL %>).val());
      inputToOutput(<%= DISPINPUTTRKYMD_DATA_TEXT_WAREKI_SYMBOL %>);
    });
    $(document).on('formInit', <%= DISPINPUTTRKYMD_DATA_TEXT_SEIREKI %>, function(){
      $(this).val($(<%= SYORIYMD_DATA_TEXT_SEIREKI %>).val());
      inputToOutput(<%= DISPINPUTTRKYMD_DATA_TEXT_SEIREKI %>);
    });

    $(document).on('formInit', <%= DISPINPUTNYURYOKUTANTOUNM_DATA_TEXT %>, function(){
      $(this).val($(<%= NYUURYOKUTANTOUNM_DATA_TEXT %>).val());
      inputToOutput(<%= DISPINPUTNYURYOKUTANTOUNM_DATA_TEXT %>);
    });

    $('.inputForm7').each(function(index){
       $(this).click(function(){

         var $tyoubundisprenrakujikou = $(document.getElementById('hubiList2['+ index + '].tyoubundisprenrakujikou'));

         if (true == $(this).prop('checked')) {
            $tyoubundisprenrakujikou.attr('rows', '15');
         }
         else{
            $tyoubundisprenrakujikou.attr('rows', '5');
         }
       });

     });

     $('.inputForm4').each(function(index){
       var $hubisyoruicd = $(document.getElementById('hubiList2['+ index + '].hubisyoruicd'));
       var $dispinputskhubikoumoku = $(document.getElementById('hubiList2['+ index + '].dispinputskhubikoumoku'));

       var hubisyoruicdZen;

       $hubisyoruicd.focus(function() {
         hubisyoruicdZen = $hubisyoruicd.val();
       });

       $hubisyoruicd.blur(function() {
         var hubisyoruicdGo = $hubisyoruicd.val();

         if (hubisyoruicdZen != hubisyoruicdGo) {
           $dispinputskhubikoumoku.val("");

           var syoruicd = $(this).val();
           callAjaxHubiKbn(syoruicd, index);
         }
       });
     });

     $('.inputForm6').each(function(index){
       var $dispinputskhubikoumoku = $(document.getElementById('hubiList2['+ index + '].dispinputskhubikoumoku'));
       var $dispinputhubinaiyoucd  = $(document.getElementById('hubiList2['+ index + '].dispinputhubinaiyoucd'));

       var dispinputskhubikoumokuZen;

       $dispinputskhubikoumoku.focus(function() {
         dispinputskhubikoumokuZen = $dispinputskhubikoumoku.val();
       });

       $dispinputskhubikoumoku.blur(function() {
         var dispinputskhubikoumokuGo = $dispinputskhubikoumoku.val();

         if (dispinputskhubikoumokuZen != dispinputskhubikoumokuGo) {
           $dispinputhubinaiyoucd.val("");

           var skHubiKoumokuCd = $(this).val();
           callAjaxHubiReason(skHubiKoumokuCd, index, 0);
         }
       });
     });
     $('.inputForm5').each(function(index){
       var $skHubiKoumokuCd = $(document.getElementById('hubiList2['+ index + '].dispinputskhubikoumoku'));

       if ($skHubiKoumokuCd.val() != null) {
         callAjaxHubiReason($skHubiKoumokuCd.val(), index, 1);
       }
       var $dispinputskseibisijinaiyou = $(document.getElementById('hubiList2['+ index + '].dispinputskseibisijinaiyou'));

       var $dispinputhubinaiyoucd = $(document.getElementById('hubiList2['+ index + '].dispinputhubinaiyoucd'));

       var skHubiKoumokuCd;

       skHubiKoumokuCd = $skHubiKoumokuCd.val();

       $skHubiKoumokuCd.focusout(function() {
         skHubiKoumokuCd = $skHubiKoumokuCd.val();
       });

       var indexMeisai = index;

       $dispinputhubinaiyoucd.change(function() {
         var skHubiNaiyouCd = $(this).val();

         if (skHubiNaiyouCd == '') {

           var $dispinputtyoubunflg        = $(document.getElementById('hubiList2['+ indexMeisai + '].dispinputtyoubunflg'));
           var $tyoubundisprenrakujikou    = $(document.getElementById('hubiList2['+ indexMeisai + '].tyoubundisprenrakujikou'));

           $dispinputtyoubunflg.prop({'checked' : false});
           $tyoubundisprenrakujikou.attr('rows', '5');
           $tyoubundisprenrakujikou.val('');
         }

         var hubiNaiyouCnt = hubikoumokucd.length;

         skHubiKoumokuCd =$(document.getElementById('hubiList2['+ indexMeisai + '].dispinputskhubikoumoku')).val();

         for (var index = 0; index < hubiNaiyouCnt; index++) {
           if (hubikoumokucd[index] == skHubiKoumokuCd && hubinaiyoucd[index] == skHubiNaiyouCd) {
             var $dispinputtyoubunflg        = $(document.getElementById('hubiList2['+ indexMeisai + '].dispinputtyoubunflg'));
             var $tyoubundisprenrakujikou    = $(document.getElementById('hubiList2['+ indexMeisai + '].tyoubundisprenrakujikou'));

             var tyoubunFlg = tyoubunFlgKekka[index];

             if (tyoubunFlg == '<%=C_UmuKbn.ARI.getValue() %>') {
               $dispinputtyoubunflg.prop({'checked' : true});
               $tyoubundisprenrakujikou.attr('rows', '15');
             } else {
               $dispinputtyoubunflg.prop({'checked' : false});
               $tyoubundisprenrakujikou.attr('rows', '5');
             }

             $tyoubundisprenrakujikou.val(renrakuJikou[index]);
           }
         }
       });
     });

     $(<%= KAKUNINBTN_FOOTERBUTTONS3 %>).keydown(function() {
        $(<%= KAKUNINBTN_FOOTERBUTTONS3 %>).focus();
     });

     <%
     if (uiBean.getPageNo() == PAGENO_TENKEN_INPUTCONTENTS) { %>
        <%
         if (C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(uiBean.getHubitourokumode())) { %>
               $(<%=HUBILIST2%>).find("tr").each(function(i){
                var $dispinputhasinkyokakbn = $(document.getElementById('hubiList2['+ i + '].dispinputhasinkyokakbn'));

                $dispinputhasinkyokakbn.find("option").each(function(){
                 if ($(this).val() == 1) {
                      $(this).attr("disabled", "true");
                }
               });
              $dispinputhasinkyokakbn.addClass("backgroundReadOnlyGray");
              });
              $(<%=KARISAKUSEIBTNBYPOPUP_FOOTERBUTTONS5%>).visible(false);
              $(<%=HUBITYOUHYOUSYUTURYOKU + DIV%>).visible(false);
        <% } %>
      <% } %>
   <% } %>


   <%
   if (uiBean.getPageNo() == PAGENO_TENKEN_INPUTCONTENTS) { %>
      <%
      if (uiBean.isTourokuBtnFlg()) { %>
         $(<%=TOJIRUBTNBYINPUTCONTENTS_HEADERBUTTONS%>).trigger("click");
      <% } %>

      <%
      if (C_MosUketukeKbn.PAPERLESSNIT.eq(uiBean.getMosuketukekbn()) &&
          C_DrtenRnrkhouKbn.NIT.eq(uiBean.getDrtenRnrkhouKbn())) { %>
           var messagesIcon = true;
            $(".messagesIcon").each(function(){
             if ($(this).html().split("Message_Error").length > 1) {
               messagesIcon = false;
             }
            });
            if (messagesIcon == true) {
               <%
              if (!uiBean.isKeizokuEditKahi()) { %>
                  if(!window.confirm('<%=MessageUtil.getMessage(MessageId.QHF1004) %>')){
                     $("form:first").attr("action", "<%= request.getContextPath() %>/sinkeiyaku/skhubikanri/skhubitouroku/SkHubiTouroku.do?_eventHandler=dialogOkByTenkenOnClick");
                     $("form:first").submit();
                     return;
                  }
              <% } %>
            }
      <% } %>
   <% } %>

   <%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      <%
      if (C_MosUketukeKbn.PAPERLESSNIT.eq(uiBean.getMosuketukekbn()) &&
          C_DrtenRnrkhouKbn.NIT.eq(uiBean.getDrtenRnrkhouKbn())) { %>
            var messagesIcon = true;
            $(".messagesIcon").each(function(){
             if ($(this).html().split("Message_Error").length > 1) {
               messagesIcon = false;
             }
            });
            if (messagesIcon == true) {
              <%
              if (!uiBean.isKeizokuEditKahi()) { %>
                   if(!window.confirm('<%=MessageUtil.getMessage(MessageId.QHF1004) %>')){
                     $("form:first").attr("action", "<%= request.getContextPath() %>/sinkeiyaku/skhubikanri/skhubitouroku/SkHubiTouroku.do?_eventHandler=dialogOkOnClick");
                     $("form:first").submit();
                     return;
                   }
              <% } %>
            }
      <% } %>
   <% } %>

   <%
     if (uiBean.getPageNo() == PAGENO_TENKEN_CONFIRM) { %>
      <%
       if (C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(uiBean.getHubitourokumode())) { %>
            $(<%=HUBITYOUHYOUSYUTURYOKU + DIV%>).visible(false);
      <% } %>
   <% } %>

   <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {%>
           $(<%= SYOKIGAMENHEBTN_FOOTERBUTTONS5 %>).visible(true);
           $(<%= SYOKIGAMENHEBTNBYWORKFLOW_FOOTERBUTTONS5 %>).visible(false);
    <% } else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {%>
           $(<%= SYOKIGAMENHEBTN_FOOTERBUTTONS5 %>).visible(false);
           $(<%= SYOKIGAMENHEBTNBYWORKFLOW_FOOTERBUTTONS5 %>).visible(true);
    <% } %>
    <% if (uiBean.getTyouhyouKey() != null && uiBean.getTyouhyouKey().length() > 0) { %>
          openReport("print", "_blank");
    <% } %>
  <% } %>
  <%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
      uiBean.getPageNo() == PAGENO_TENKEN_INPUTCONTENTS) { %>
    <% if (uiBean.getKarisakuseiTyouhyouKey() != null && uiBean.getKarisakuseiTyouhyouKey().length() > 0) { %>
          openReport("karisakuseiPrint", "_blank");
    <% } %>
  <% } %>
  function callAjaxHubiKbn(syoruiCd, index) {

      var form = $('form').attr('action');
      form = form + "?<%= AJAX_POST_EVENTHANDLER_HUBIKBN %>";

      $.ajax({
          type: "POST",
          url: form,
          data: {
              syoruiCd: syoruiCd
          },
          dataType: "json"
      }).done(function(data){
          var $dispinputskhubikoumoku     = $(document.getElementById('hubiList2['+ index + '].dispinputskhubikoumoku'));
          var $dispinputhubinaiyoucd      = $(document.getElementById('hubiList2['+ index + '].dispinputhubinaiyoucd'));
          var $dispinputskseibisijinaiyou = $(document.getElementById('hubiList2['+ index + '].dispinputskseibisijinaiyou'));
          var $dispinputtyoubunflg        = $(document.getElementById('hubiList2['+ index + '].dispinputtyoubunflg'));
          var $tyoubundisprenrakujikou    = $(document.getElementById('hubiList2['+ index + '].tyoubundisprenrakujikou'));

          var userSelectStr = '<option value =""></option>';

          var naiyoucdUserSelectStr = '<option value =""></option>';

          for (var i = 0; i < data.length; i++) {
            var key   = data[i].split("@@")[0];
            var value = data[i].split("@@")[1];

            userSelectStr = userSelectStr + '<option value = "' + key + '">' + value + '</option>';

          }
        $dispinputskhubikoumoku.html(userSelectStr);
        $dispinputhubinaiyoucd.html(naiyoucdUserSelectStr);
        $dispinputtyoubunflg.prop({'checked' : false});
        $tyoubundisprenrakujikou.attr('rows', '5');
        $tyoubundisprenrakujikou.val('');

      });
  }

  function callAjaxHubiReason(skHubiKoumokuCd, index, flag){
      var form = $('form').attr('action');
      form = form + "?<%= AJAX_POST_EVENTHANDLER_HUBIREASON %>";

      $.ajax({
          type: "POST",
          url: form,
          data: {
              skHubiKoumokuCd: skHubiKoumokuCd
          },
          dataType: "json"
      }).done(function(data){

          var $dispinputhubinaiyoucd      = $(document.getElementById('hubiList2['+ index +'].dispinputhubinaiyoucd'));
          var $dispinputskseibisijinaiyou = $(document.getElementById('hubiList2['+ index + '].dispinputskseibisijinaiyou'));
          var $dispinputtyoubunflg        = $(document.getElementById('hubiList2['+ index + '].dispinputtyoubunflg'));
          var $tyoubundisprenrakujikou    = $(document.getElementById('hubiList2['+ index + '].tyoubundisprenrakujikou'));
          var userSelectStr = '<option value =""></option>';

          for (var i = 1; i <= data[0]; i++) {
            var key   = data[i].split("@@")[0];
            var value = data[i].split("@@")[1];

            userSelectStr = userSelectStr + '<option value = "' + key + '">' + value + '</option>';

          }

          if (data.length != 0) {
            var hubikoumokucdStr = "";
            var hubikoumokucdStart= data[0];
            hubikoumokucdStart++;

            for (var p = 0; p < hubikoumokucd.length; p++) {
              hubikoumokucdStr = hubikoumokucdStr + "|" + hubikoumokucd[p];
            }
            if (hubikoumokucdStr.indexOf(data[hubikoumokucdStart].split("&&")[0]) == -1) {
            for (var j = data[0]; j < data.length; j++) {
                if (j != data[0]) {
                  hubikoumokucd.push(data[j].split("&&")[0]);
                  hubinaiyoucd.push(data[j].split("&&")[1]);
                  tyoubunFlgKekka.push(data[j].split("&&")[2]);
                  if (data[j].split("&&")[3].indexOf("\n") != -1 ) {
                    var renrakuJikous = "";

                    for (var i= 0; i < data[j].split("&&")[3].split("\n").length; i++ ) {

                      if (i < data[j].split("&&")[3].split("\n").length - 1) {
                        renrakuJikous = renrakuJikous + data[j].split("&&")[3].split("\n")[i] + "\n";
                      }
                      else {
                        renrakuJikous = renrakuJikous + data[j].split("&&")[3].split("\n")[i];
                      }
                    }

                    renrakuJikou.push(renrakuJikous);
                  } else {
                    renrakuJikou.push(data[j].split("&&")[3]);
                  }
                }
              }
            }
          }
        $('#dummykmk1').val(hubikoumokucd);
        $('#dummykmk2').val(hubinaiyoucd);
        $('#dummykmk4').val(tyoubunFlgKekka);
        $('#dummykmk5').val(renrakuJikou);

        if (flag == 0) {
          $dispinputhubinaiyoucd.html(userSelectStr);
          $dispinputtyoubunflg.prop({'checked' : false});
          $tyoubundisprenrakujikou.attr('rows', '5');
          $tyoubundisprenrakujikou.val('');
        }

      });
  }

  function onLoadPullDownList($hubikoumokuList, $hubinaiyouList, syoruiCd, hubikoumokuCd, hubinaiyouCd) {

      if (syoruiCd != null && syoruiCd != '0' && syoruiCd != '') {
        var form = $('form').attr('action');
        form = form + "?<%= AJAX_POST_EVENTHANDLER_HUBIKBN %>";

        $.ajax({
            type: "POST",
            url: form,
            data: {
                syoruiCd: syoruiCd
            },
            dataType: "json"
        }).done(function(data){
            var $dispinputskhubikoumoku = $hubikoumokuList;

            var userSelectStr = '<option value =""></option>';

            for (var i = 0; i < data.length; i++) {
              var key   = data[i].split("@@")[0];
              var value = data[i].split("@@")[1];
              userSelectStr = userSelectStr + '<option value = "' + key + '"' + '>' + value + '</option>';
            }

          $dispinputskhubikoumoku.html(userSelectStr);
          $dispinputskhubikoumoku.val(hubikoumokuCd);

        });
      }

      if (hubikoumokuCd != null && hubikoumokuCd != 'null' && hubikoumokuCd != '') {
        var form = $('form').attr('action');
        form = form + "?<%= AJAX_POST_EVENTHANDLER_HUBIREASON %>";

        $.ajax({
            type: "POST",
            url: form,
            data: {
                skHubiKoumokuCd: hubikoumokuCd
            },
            dataType: "json"
        }).done(function(data){
            var $dispinputhubinaiyoucd = $hubinaiyouList;
            var userSelectStr = '<option value =""></option>';

            for (var i = 1; i <= data[0]; i++) {
              var key   = data[i].split("@@")[0];
              var value = data[i].split("@@")[1];
              userSelectStr = userSelectStr + '<option value = "' + key + '"' + '>' + value + '</option>';
            }
          $dispinputhubinaiyoucd.html(userSelectStr);
          $dispinputhubinaiyoucd.val(hubinaiyouCd);
        });
      }
  }

  function listRowShiftHubiTouroku(delRowObj){
   var delRowId = $(delRowObj).find(':input[id]').first().attr('id');
   var tmp = delRowId.split(/\[|\]/);
   var delRowNum = Number(tmp[1]);
   var moveRows = $(delRowObj).nextAll('tr:visible').filter(function(){
       var thisId = $(this).find(':input[id]').first().attr('id');
       var tmp = thisId.split(/\[|\]/);
       var thisNum = Number(tmp[1]);
       if(delRowNum < thisNum){
           return true;
       }else{
           return false;
       }
   });

   var syoruiCd = '';
   var hubikoumokuCd = '';
   var hubinaiyouCd = '';
   var hubikoumokuArray = new Array();
   var hubinaiyouArray = new Array();

   $(moveRows).find(':input[id]').each(function(){
       var thisListId = $(this).attr('id');
       tmp = thisListId.split(/\[|\]/);
       var ddid = tmp[0];
       var prevNum = tmp[1] - 1;
       var groupId = thisListId.slice(thisListId.indexOf("]") + 1);
       var prevInputId = "#" + ddid + "[" + prevNum + "]" + groupId;
       prevInputId = prevInputId.replace(/:/g, "\\:");
       prevInputId = prevInputId.replace(/\./g, "\\.");
       prevInputId = prevInputId.replace(/\[/g, "\\[");
       prevInputId = prevInputId.replace(/\]/g, "\\]");

       if (groupId == '.hubisyoruicd') {
         syoruiCd = $(this).val();
       }
       if (groupId == '.dispinputskhubikoumoku') {
         hubikoumokuCd = $(this).val();
         $(this).find('option').each(function(){
           hubikoumokuArray.push($(this).text());
         });
       }
       else if (groupId == '.dispinputhubinaiyoucd') {
         hubinaiyouCd = $(this).val();
         $(this).find('option').each(function(){
           hubinaiyouArray.push($(this).text());
         });
       }

       var tagName = this.tagName.toUpperCase();
       switch (tagName){
         case "INPUT":
           var type = $(this).attr("type");
           if(type == "checkbox" || type == "radio"){
               $(prevInputId).prop('checked', $(this).prop('checked')).trigger('valueSync');
           }else if(type != "button"){
               $(prevInputId).val($(this).val()).trigger('valueSync');
           }
           break;
         case "SELECT":
         case "TEXTAREA":
           if (groupId == '.dispinputskhubikoumoku') {
             var userSelectStr = '<option value =""></option>';

             for (var i = 1; i < hubikoumokuArray.length; i++) {

               var key   = hubikoumokuArray[i].split('：')[0];
               var value = hubikoumokuArray[i];

               userSelectStr = userSelectStr + '<option value = "' + key + '"' + '>' + value + '</option>';

             }
              $(prevInputId).html(userSelectStr);
              $(prevInputId).val(hubikoumokuCd);
           }
           else if (groupId == '.dispinputhubinaiyoucd') {
             var userSelectStr = '<option value =""></option>';
             for (var i = 1; i < hubinaiyouArray.length; i++) {
               var key   = hubinaiyouArray[i].split('：')[0];
               var value = hubinaiyouArray[i];
               userSelectStr = userSelectStr + '<option value = "' + key + '"' + '>' + value + '</option>';
             }
             $(prevInputId).html(userSelectStr);
             $(prevInputId).val(hubinaiyouCd);
           }
           $(prevInputId).val($(this).val()).trigger('valueSync');
           break;
       };

       if($(this).hasClass('errorItem')){
           $(this).removeClass('errorItem');
           $(prevInputId).addClass('errorItem');
       }
   });
  }
});

</script>
