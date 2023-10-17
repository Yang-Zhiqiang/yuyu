<%--
    sk_kankyou_satei.js.jsp - 環境査定 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkettei.skkankyousatei.SkKankyouSateiConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkettei.skkankyousatei.SkKankyouSateiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skkettei.skkankyousatei.SkKankyouSateiUiBean" %>
<%@page import="yuyu.def.classification.C_JimusrhKbn" %>
<%@page import="yuyu.def.classification.C_SkkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_ImusateijyouKbn" %>
<%@page import="yuyu.def.classification.C_Ketriyuucd" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.def.classification.C_LincjkKbn" %>
<%@page import="yuyu.def.classification.C_KykSyubetuKbn" %>
<%@page import="yuyu.def.classification.C_AnkenJyoutaiKbn" %>
<% SkKankyouSateiUiBean uiBean = SWAKInjector.getInstance(SkKankyouSateiUiBean.class); %>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
<jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
    <% if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
        showGroup(<%= JYOUBUBUTTONS1 %>);
    <% } else { %>
        showGroup(<%= FOOTERBUTTONS1 %>);
    <% } %>
  <% } %>

  <%
     if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
         uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>

        <%
           if (C_JimusrhKbn.HORYU.eq(uiBean.getJimusrhkbn())) { %>
               $(<%= JIMUSRHKBN_SINTYOKUJYOUKYOU %>).css("color", "#ff0000");
        <% } %>

        <%
           if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
               C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
               C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
                 showList(<%= SENTAKUJOUHOU %>);
        <% } %>

        showList(<%= TORIATUKAITYUUIJOUHOU %>);

        <%
           if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
               C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
                   showGroup(<%= KAKUNINJIKOU %>);
        <% } %>

        <%
           if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
               C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
               showKoumoku(<%= KETRIYUUITIRANBTN_KETTEIJOUHOU %>);
               $(<%= KETRIYUUITIRANBTN_KETTEIJOUHOU %>).val('<%= ITIRAN %>');

               showKoumoku(<%= KETRIYUUCD1GAMEN_KETTEIJOUHOU %>);
               showKoumoku(<%= KETRIYUUCD2GAMEN_KETTEIJOUHOU %>);
               showKoumoku(<%= KETRIYUUCD3GAMEN_KETTEIJOUHOU %>);
               showKoumoku(<%= KETRIYUUCD4GAMEN_KETTEIJOUHOU %>);

               showKoumoku(<%= MRRIYUUCDKBN_KETTEIJOUHOU %>);
        <% } %>

        <%
           if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>
              showKoumoku(<%= TORIKESISYOUSAIRIYUUCD_KETTEIJOUHOU %>);
        <% } %>

        <%
           if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM) { %>
             <%
               if (C_LincjkKbn.KAITOARI_TASYAARI.eq(uiBean.getLincjkkbn())){ %>
                  $(<%=LINCJKBTN_KAKUNINJIKOU%>).visible(true);
             <%
             } else { %>
                 $(<%=LINCJKBTN_KAKUNINJIKOU%>).visible(false);
             <% } %>
        <% } %>
  <% } %>

  <%
     if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
         <% if (uiBean.getImusateiIraiyhFlg() == 1) { %>
                   $(<%= IMUSATEIKEKKAKBN_IMUSATEIIRAI %>).visible(true);
                   $(<%= IMUSATEIIRAICOMMENT_IMUSATEIIRAI %>).visible(true);
         <% } %>

         <% if (uiBean.getMosTenkenIraiyhFlg() == 1) { %>
                  $(<%= MOSTENKENKEKKAKBN_MOSTENKENIRAI %>).visible(true);
                  $(<%= MOSTENKENIRAICOMMENT_MOSTENKENIRAI %>).visible(true);
         <% } %>

         var ketteiRiyuuCd1 = $(<%= KETRIYUUCD1GAMEN_KETTEIJOUHOU %>).val();
         callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd1, <%= AJAX_POST_PARAM_KETRIYUUCD1 %>);

         $(<%=KETRIYUUCD1GAMEN_KETTEIJOUHOU%>).change( function() {
           var ketteiRiyuuCd1 = $(<%= KETRIYUUCD1GAMEN_KETTEIJOUHOU %>).val();
           callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd1, <%= AJAX_POST_PARAM_KETRIYUUCD1 %>);
         });

         var ketteiRiyuuCd2 = $(<%= KETRIYUUCD2GAMEN_KETTEIJOUHOU %>).val();
         callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd2, <%= AJAX_POST_PARAM_KETRIYUUCD2 %>);

         $(<%=KETRIYUUCD2GAMEN_KETTEIJOUHOU%>).change( function() {
           var ketteiRiyuuCd2 = $(<%= KETRIYUUCD2GAMEN_KETTEIJOUHOU %>).val();
           callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd2, <%= AJAX_POST_PARAM_KETRIYUUCD2 %>);
         });

         var ketteiRiyuuCd3 = $(<%= KETRIYUUCD3GAMEN_KETTEIJOUHOU %>).val();
         callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd3, <%= AJAX_POST_PARAM_KETRIYUUCD3 %>);

         $(<%=KETRIYUUCD3GAMEN_KETTEIJOUHOU%>).change( function() {
           var ketteiRiyuuCd3 = $(<%= KETRIYUUCD3GAMEN_KETTEIJOUHOU %>).val();
           callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd3, <%= AJAX_POST_PARAM_KETRIYUUCD3 %>);
         });

         var ketteiRiyuuCd4 = $(<%= KETRIYUUCD4GAMEN_KETTEIJOUHOU %>).val();
         callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd4, <%= AJAX_POST_PARAM_KETRIYUUCD4 %>);

         $(<%=KETRIYUUCD4GAMEN_KETTEIJOUHOU%>).change( function() {
           var ketteiRiyuuCd4 = $(<%= KETRIYUUCD4GAMEN_KETTEIJOUHOU %>).val();
           callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd4, <%= AJAX_POST_PARAM_KETRIYUUCD4 %>);
         });

         $(<%= KAKUNINBTN_FOOTERBUTTONS2%>).click( function () {
           var checkedAll = $('input:radio[name="ui:050ketkekkacd"]:checked').val();
           var knksateisateikekka = $('#knksateisateikekka').val();
           if (checkedAll == null && <%=C_SyorikekkaKbn.KANRYOU%> == knksateisateikekka) {
             <%
                if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                    C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                    C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

                  if(window.confirm('<%=MessageUtil.getMessage(MessageId.QHF1001) %>')){

                    $("input[name='ui:050ketkekkacd']").eq(0).attr("checked", "checked");
                    $("form:first").attr("action", "<%= request.getContextPath() %>/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do?_eventHandler=kakuninBtnOnClick");
                    $("form:first").submit();
                  }
             <% } %>

             <%
                if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) { %>

                  if(window.confirm('<%=MessageUtil.getMessage(MessageId.QHF1002) %>')){
                       $("input[name='ui:050ketkekkacd']").eq(1).attr("checked", "checked");
                       $("form:first").attr("action", "<%= request.getContextPath() %>/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do?_eventHandler=kakuninBtnOnClick");
                       $("form:first").submit();
                  }
             <% } %>

           } else {
                 $("form:first").attr("action", "<%= request.getContextPath() %>/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do?_eventHandler=kakuninBtnOnClick");
                 $("form:first").submit();
           }
         });
  <% } %>

  <%
     if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
       $(<%= IMUSATEIKEKKAKBN_IMUSATEIIRAI %>).visible(true);
       $(<%= IMUSATEIIRAICOMMENT_IMUSATEIIRAI %>).visible(true);

       $(<%= MOSTENKENKEKKAKBN_MOSTENKENIRAI %>).visible(true);
       $(<%= MOSTENKENIRAICOMMENT_MOSTENKENIRAI %>).visible(true);

showKoumoku(<%= LINCKAKKBN_KAKUNINJIKOU %>);
  <% } %>

<%
  if (uiBean.getPageNo() == PAGENO_TASYAKANYUUJOUKYOU) { %>
     <%
       if (uiBean.getTyouhyoukeyLst() != null && uiBean.getTyouhyoukeyLst().size() > 0){ %>
            openReport("print", "_blank");
     <% } %>

     $(<%=FUNCTION_NAME%>).text('<%=FUNCTION_NAME_TASYA_KANYUU_JOUKYOU%>');
     $(<%= FUNCTION_NAME %>).attr("disabled", "true");
     $(<%= FUNCTION_NAME %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');

     <%
       if (uiBean.isHaneibtnOnClickFlg()){ %>
       $(<%=TOJIRUBTNBYTSYKNYJK_HEADERBUTTONS%>).trigger("click");
     <% } %>

     showList(<%= TASYAKANYUUJOUKYOU %>);

     showGroup(<%= TOUTASYATSUSAN %>);

     showGroup(<%= SONOTAJOUHOU %>);

     inputToOutput(<%=TOUTASYATSNKESSAITGK_TOUTASYATSUSAN%>);

     $(<%=TASYAKANYUUJOUKYOU%>).find(<%=LIST_CELL %>).each(function(){
       $(this).find("span").eq(1).before('<br/>');
     });

     <%
       if (PAGENO_INPUTCONTENTS == uiBean.getTasyaKanyuuJoukyouPath()){ %>
         $(<%= TASYAOUT_DISP %>).visible(true);
         showGroup(<%= FOOTERBUTTONS5 %>);

         $(<%= TSAKJT_INPUT_FORM %>).change(function(){
             var toutasyatsnkessaitgk = 0;

             $(<%=TASYAKANYUUJOUKYOU%>).find("tr").each(function(index){
                 var $tasyaankenjyoutai = $(document.getElementById('tasyaKanyuuJoukyou['+ index + '].tasyaankenjyoutai'));
                 var $tasyakyksyubetu = $(document.getElementById('tasyaKanyuuJoukyou['+ index + '].tasyakyksyubetu'));
                 var $tasyasibusmantyen = $(document.getElementById('tasyaKanyuuJoukyou['+ index + '].tasyasibusmantyen'));
                 if ($tasyakyksyubetu.val() == '<%=C_KykSyubetuKbn.HOUJIN.getValue()%>' ||
                     $tasyakyksyubetu.val() == '<%=C_KykSyubetuKbn.BETUHOUJIN.getValue()%>' ||
                     $tasyakyksyubetu.val() == '<%=C_KykSyubetuKbn.TAISYOUGAI.getValue()%>' ||
                     $tasyaankenjyoutai.val() == '<%=C_AnkenJyoutaiKbn.SYOUMETU.getValue()%>' ||
                     $tasyaankenjyoutai.val() == '<%=C_AnkenJyoutaiKbn.BETUJIN.getValue()%>') {

                     var newtasyasibusmantyen = $tasyasibusmantyen.text().replace(/,/g,"");

                     toutasyatsnkessaitgk = parseInt(toutasyatsnkessaitgk) + parseInt(newtasyasibusmantyen);
                 }
             });

             var tasyatsn = $(<%=TASYATSN_TOUTASYATSUSAN%>).text().replace(/,/g,"");
             var tousyatsn = $(<%=TOUSYATSN_TOUTASYATSUSAN%>).text().replace(/,/g,"");
             var toutasyatsnkessaitgk1 = parseInt(tasyatsn) + parseInt(tousyatsn) - parseInt(toutasyatsnkessaitgk);

             $(<%=TOUTASYATSNKESSAITGK_TOUTASYATSUSAN%>).val(toutasyatsnkessaitgk1.toFixed(0).toString().replace(/(\d)(?=(?:\d{3})+$)/g,"$1,"));

            inputToOutput(<%=TOUTASYATSNKESSAITGK_TOUTASYATSUSAN%>);

         });

         $(<%= TSKYKSB_INPUT_FORM %>).change(function(){
             var toutasyatsnkessaitgk = 0;

             $(<%=TASYAKANYUUJOUKYOU%>).find("tr").each(function(index){
                 var $tasyaankenjyoutai = $(document.getElementById('tasyaKanyuuJoukyou['+ index + '].tasyaankenjyoutai'));
                 var $tasyakyksyubetu = $(document.getElementById('tasyaKanyuuJoukyou['+ index + '].tasyakyksyubetu'));
                 var $tasyasibusmantyen = $(document.getElementById('tasyaKanyuuJoukyou['+ index + '].tasyasibusmantyen'));
                 if ($tasyakyksyubetu.val() == '<%=C_KykSyubetuKbn.HOUJIN.getValue()%>' ||
                     $tasyakyksyubetu.val() == '<%=C_KykSyubetuKbn.BETUHOUJIN.getValue()%>' ||
                     $tasyakyksyubetu.val() == '<%=C_KykSyubetuKbn.TAISYOUGAI.getValue()%>' ||
                     $tasyaankenjyoutai.val() == '<%=C_AnkenJyoutaiKbn.SYOUMETU.getValue()%>' ||
                     $tasyaankenjyoutai.val() == '<%=C_AnkenJyoutaiKbn.BETUJIN.getValue()%>') {

                     var newtasyasibusmantyen = $tasyasibusmantyen.text().replace(/,/g,"");

                     toutasyatsnkessaitgk = parseInt(toutasyatsnkessaitgk) + parseInt(newtasyasibusmantyen);
                 }
             });
             var tasyatsn = $(<%=TASYATSN_TOUTASYATSUSAN%>).text().replace(/,/g,"");
             var tousyatsn = $(<%=TOUSYATSN_TOUTASYATSUSAN%>).text().replace(/,/g,"");
             var toutasyatsnkessaitgk1 = parseInt(tasyatsn) + parseInt(tousyatsn) - parseInt(toutasyatsnkessaitgk);

             $(<%=TOUTASYATSNKESSAITGK_TOUTASYATSUSAN%>).val(toutasyatsnkessaitgk1.toFixed(0).toString().replace(/(\d)(?=(?:\d{3})+$)/g,"$1,"));
             inputToOutput(<%=TOUTASYATSNKESSAITGK_TOUTASYATSUSAN%>);
         });
     <%
     } else { %>
        $(<%= TASYAOUT_DISP %>).visible(false);
        showGroup(<%= FOOTERBUTTONS6 %>);

        $(<%=TASYAKANYUUJOUKYOU%>).find("tr").each(function(i){
        var $tasyaankenjyoutai = $(document.getElementById('tasyaKanyuuJoukyou['+ i + '].tasyaankenjyoutai'));
        $tasyaankenjyoutai.find("option").each(function(){
           $(this).attr("disabled", "true");
         });
         $tasyaankenjyoutai.addClass("backgroundReadOnlyGray");

        var $tasyakyksyubetu = $(document.getElementById('tasyaKanyuuJoukyou['+ i + '].tasyakyksyubetu'));
        $tasyakyksyubetu.find("option").each(function(){
           $(this).attr("disabled", "true");
         });
         $tasyakyksyubetu.addClass("backgroundReadOnlyGray");
        });
     <% } %>
<% } %>

  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
      <%
        String[] hubiMsgs = uiBean.getHubimsgData();
        String msgId = "";
        if (hubiMsgs != null && hubiMsgs.length != 0 && hubiMsgs[0].length() != 0) {
            String[] hubiMsg = hubiMsgs[0].split(" ");
            msgId = hubiMsg[1];
        }
        %>
        changeErrMsg('<%= msgId %>');
  <% } %>

  function callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd, ketteiRiyuuCdFlag){

      var form = $('form').attr('action');
      form = form + "?<%= AJAX_POST_EVENTHANDLER_KETTEIRIYUUNAIYOU %>";

      $.ajax({
          type: "POST",
          url: form,
          data: {
              ketteiRiyuuCd: ketteiRiyuuCd
          },
          dataType: "json"
      }).done(function(data){
          ketteiRiyuuNaiyouSettei(data, ketteiRiyuuCdFlag);
      });
  }

  function ketteiRiyuuNaiyouSettei(obj, ketteiRiyuuCdFlag){
    if (ketteiRiyuuCdFlag == <%= AJAX_POST_PARAM_KETRIYUUCD1 %>) {
      $(<%= KETTEIRIYUUNAIYOU1_KETTEIJOUHOU %>).text(obj[0]);
    }

    if (ketteiRiyuuCdFlag == <%= AJAX_POST_PARAM_KETRIYUUCD2 %>) {
      $(<%= KETTEIRIYUUNAIYOU2_KETTEIJOUHOU %>).text(obj[0]);
    }

    if (ketteiRiyuuCdFlag == <%= AJAX_POST_PARAM_KETRIYUUCD3 %>) {
      $(<%= KETTEIRIYUUNAIYOU3_KETTEIJOUHOU %>).text(obj[0]);
    }

    if (ketteiRiyuuCdFlag == <%= AJAX_POST_PARAM_KETRIYUUCD4 %>) {
      $(<%= KETTEIRIYUUNAIYOU4_KETTEIJOUHOU %>).text(obj[0]);
    }
  }

});
//-->
</script>
