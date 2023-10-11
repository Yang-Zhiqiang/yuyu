<%--
    sk_mousikomisyo.js.jsp - 申込書入力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.date.BizDate" %>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SaiDataTouroku" %>
<%@page import="yuyu.common.biz.bzcommon.BizDateUtil" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@page import="yuyu.def.classification.C_UktKbn" %>
<%@page import="yuyu.def.classification.C_KykKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_Nstkumu" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<%@page import="yuyu.def.classification.C_TargetTkHukaKanouKbn" %>
<%@page import="yuyu.def.classification.C_Sknenkinsyu" %>
<%@page import="yuyu.def.classification.C_TargetTkMokuhyoutiKbn" %>
<%@page import="yuyu.def.classification.C_HknsyuruiNo" %>
<%@page import="yuyu.def.classification.C_TumitatekinHaibunWariKbn" %>
<%@page import="yuyu.def.classification.C_FstphrkkeiroKbn" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil"%>
<%@page import="yuyu.def.MessageId"%>
<%@page import="yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoUiBean" %>
<%@page import="yuyu.def.classification.C_HrkkknsmnKbn" %>
<%@page import="yuyu.def.classification.C_HknkknsmnKbn" %>
<%@page import="yuyu.def.classification.C_BlnktkumuKbn" %>
<%@page import="yuyu.def.classification.C_Hrkkeiro" %>
<%@page import="yuyu.def.classification.C_IkkatubaraiKaisuuKbn" %>
<%@page import="yuyu.def.classification.C_Hrkkaisuu" %>
<%@page import="yuyu.def.classification.C_YokinKbn" %>
<%@page import="yuyu.def.classification.C_KzkykdouKbn" %>
<%@page import="yuyu.def.classification.C_SkeijimuKbn" %>
<%@page import="yuyu.def.classification.C_KzhuritourokuhouKbn" %>
<%@page import="yuyu.def.classification.C_KouzasyuruiKbn" %>
<%@page import="yuyu.def.classification.C_Tkhukaumu" %>
<%@page import="yuyu.def.classification.C_KoureiKzkSetumeiHouKbn" %>
<%@page import="yuyu.def.classification.C_KoureiMndnHukusuukaiKbn" %>
<%@page import="yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn" %>
<%@page import="yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig" %>
<%@page import="yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn" %>
<%@page import="yuyu.def.classification.C_PtratkituukasiteiKbn" %>
<%@page import="yuyu.def.classification.C_Sdpd" %>
<%@page import="yuyu.def.classification.C_NensyuuKbn" %>

<% SkMousikomisyoUiBean uiBean = SWAKInjector.getInstance(SkMousikomisyoUiBean.class); %>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
<jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){
  var gaikatatkiumu = '<%= C_UmuKbn.NONE.getValue() %>';
  var ptratkituukasiteikbn = '<%= C_PtratkituukasiteiKbn.BLNK.getValue() %>';
  var hknsyuruiNoHandan = '<%= C_HknsyuruiNo.BLNK.getValue() %>';

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
         uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>
            $(<%= LINKBUTTONS1 + DIV %>).removeClass("buttonsDiv").addClass("contentsButtonLeft");
            $(<%= LINKBUTTONS2 + DIV %>).removeClass("buttonsDiv").addClass("contentsButtonLeft");
  <% } %>
  <%
  if (uiBean.getPageNo() == PAGENO_CONFIRM ||
      uiBean.getPageNo() == PAGENO_RESULT) { //%>
      $(".alignMessageCell2").removeClass('alignMessageCell2').addClass('alignMessageCell3');

      $("#IHF1030").addClass('alignMessageCell4');
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
       if($(<%= STDRSKTKYHKKBN_SITEIDAIRISEIKYUNININFO%>).hasClass("errorItem")){
           $("#IHF1027").css("margin-left", "158px");
       }
       if($(<%= STDRUKTKBN_SITEIDAIRISEIKYUNININFO%>).hasClass("errorItem")){
           $("#IHF1028").css("margin-left", "92px");
       }
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_RESULT) {
      String[] hubiMsgs = uiBean.getHubimsgData();
      String[] hubiMsg2s = uiBean.getHubimsgData2();
      String msgId = "";
      String msgId2 = "";
      if (hubiMsgs != null && hubiMsgs.length != 0 && hubiMsgs[0].length() != 0 ) {
          String[] hubiMsg = hubiMsgs[0].split(" ");
          msgId = hubiMsg[1];
      }
      if (hubiMsg2s != null && hubiMsg2s.length != 0 && hubiMsg2s[0].length() != 0 ) {
          String[] hubiMsg2 = hubiMsg2s[0].split(" ");
          msgId2 = hubiMsg2[1];
       }
      %>

    mousikomisyoChangeErrMsg("<%= msgId %>","<%= msgId2 %>");
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS &&
         E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn()) &&
         uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAIARI) { %>
       showGroup(<%= BUTTONNYUURYOKUSAISYOUKAI %>);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
    <% if (uiBean.getKakuninmessage() != null && uiBean.getKakuninmessage().size() > 0) { %>
       var kakuninmessage = '<%= uiBean.getKakuninmessage()%>';
       var messagesLst = new Array();
       messagesLst = kakuninmessage.replace("[","").replace("]","").split(",");

       var index = 0;
       $('#messages tr').each(function(){
         var message = $(this).children('td').text();
         for (var i = 0; i < messagesLst.length; i++ ) {
           if (message == messagesLst[i]) {
           index = index + 1;
           }
         }
       });
      if (index == 0) {
          <% if (E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) { //%>
           for (var i = 0; i < messagesLst.length; i++ ) {
               $('#messages').append('<tr><td class="messagesIcon"><img src="'+ '<%= request.getContextPath() %>/img/message/Message_Warning.png" /></td><td class="messagesItem"><span class="error_message">' +
               messagesLst[i] + '</span></td></tr>');
           }
         <% } else { //%>
           for (i = 0; i < messagesLst.length; i++ ) {
             if (i == 0 ) {
               $('#messages').append('<tr><td class="messagesIcon"><img src="'+ '<%= request.getContextPath() %>/img/message/Message_Inquiry.png" /></td><td class="messagesItem"><span class="error_message">' +
               messagesLst[i] + '</span></td></tr>');
           }
           else {
              $('#messages').append('<tr><td class="messagesIcon"><img src="'+ '<%= request.getContextPath() %>/img/message/Message_Warning.png" /></td><td class="messagesItem"><span class="error_message">' +
              messagesLst[i] + '</span></td></tr>');
           }
       }
     <% } %>
       }
   <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
         uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>
       var linkList = {
         <%= KEIYAKUSYAJOUHOUBTN_LINKBUTTONS1 %>      : <%= KEIYAKUSYAINFO + LABEL %>,
         <%= TUSINSAKIJOUHOUBTN_LINKBUTTONS1 %>       : <%= TUUSINSAKIINFO + LABEL %>,
         <%= HIHOKENSYAJOUHOUBTN_LINKBUTTONS1 %>      : <%= HIHOKENSYAINFO + LABEL %>,
         <%= UKETORININBTN_LINKBUTTONS1 %>            : <%= NENKINUKETORINININFO + LABEL %>,
         <%= KZKTOUROKUBTN_LINKBUTTONS1 %>            : <%= KZKOUROKUSERVICEYOUROKUINFO + LABEL %>,
         <%= KYKDAIRININBTN_LINKBUTTONS1 %>           : <%= KYKDAIRISEIKYUNININFO + LABEL %>,
         <%= SITEIDAIRININBTN_LINKBUTTONS2 %>         : <%= SITEIDAIRISEIKYUNININFO + LABEL %>,
         <%= HOSYOUINFOBTN_LINKBUTTONS1 %>            : <%= SYUKEIYAKUHOSYOUINFO + LABEL %>,
         <%= KOUHURIKOUZAINFOBTN_LINKBUTTONS2 %>      : <%= KOUHURIKOUZAINFO + LABEL %>,
         <%= DAIRITENJOUHOUBTN_LINKBUTTONS2 %>        : <%= DAIRITENINFO + LABEL %>
       };

       for (btnId in linkList) {
         $(document).on("click", btnId, function() {
           var thisId = $(this).attr("id");

           if (thisId == <%= UKETORININBTN_LINKBUTTONS1 %>.substring(1)) {
             var targetLst = [<%= NENKINUKETORINININFO %>, <%= SIBOUUKETORINININFO %>];
             var targetSelecter = targetLst.join(",");
             var targetId = $(targetSelecter).filter(":visible").first().attr("id");
             gotoTarget("#" + targetId + "_label");
           } else {
             gotoTarget(linkList["#" + thisId]);
           }
         });
       }
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {
         if (uiBean.getSyoruiInfoListDataSource().size() > 0) { %>
           showGroup(<%= SYORUIINFOLIST %>);
           showGroup(<%= BUTTONALLHYOUJI %>);
  <%     }
     } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
       var henkoumaeKykKbn = null;
       var henkouatoKykKbn = null;
       $(<%= KYKKBN_KEIYAKUSYAINFO %>).focus(function() {
         henkoumaeKykKbn = $(this).val();
       });

       $(<%= KYKKBN_KEIYAKUSYAINFO %>).blur(function() {
         henkouatoKykKbn = $(this).val();

         if ((henkoumaeKykKbn == <%= C_KykKbn.BLNK.getValue() %> ||
              henkoumaeKykKbn == <%= C_KykKbn.KEIHI_BETU.getValue() %>) &&
             henkouatoKykKbn == <%= C_KykKbn.KEIHI_DOUITU.getValue() %>) {
           $(<%= TSINDOUSITEI_HIHOKENSYAINFO %>).prop("checked", true);
         }

         if (henkoumaeKykKbn == <%= C_KykKbn.KEIHI_DOUITU.getValue() %> &&
             (henkouatoKykKbn == <%= C_KykKbn.KEIHI_BETU.getValue() %> ||
                 henkouatoKykKbn == <%= C_KykKbn.BLNK.getValue() %>)) {
           $(<%= TSINDOUSITEI_HIHOKENSYAINFO %>).prop("checked", false);
         }
       });
  <% } %>

  <% if ((BizDateUtil.compareYmd(BizDate.getSysDate(),
      YuyuSinkeiyakuConfig.getInstance().getZenchanelYakkandensiTratkiKaisiYmd()) == BizDateUtil.COMPARE_LESSER &&
      (C_SkeijimuKbn.SMBC.eq(uiBean.getSkeijimuKbn()) || (C_SkeijimuKbn.TIGINSINKIN.eq(uiBean.getSkeijimuKbn())))) ||
      BizDateUtil.compareYmd(BizDate.getSysDate(),
          YuyuSinkeiyakuConfig.getInstance().getZenchanelYakkandensiTratkiKaisiYmd()) != BizDateUtil.COMPARE_LESSER) { %>
          showKoumoku(<%= YAKKANJYURYOUHOUKBN_KEIYAKUSYAINFO %>);
  <% } %>

  var inputcontentsFlg = false;
  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {  %>
       inputcontentsFlg = true;
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
         uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>

       hknsyuruiGmCtrl(<%= uiBean.getHknsyuruino() %>, 'onload');

       var hknsyuruinomosinputZen;

       $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).focus(function() {
         hknsyuruinomosinputZen = $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val();
       });

       $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).blur(function() {

          var hknsyuruinomosinputGo = $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val();

          if (hknsyuruinomosinputZen != hknsyuruinomosinputGo) {
              var hknsyuruino = $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val();
              var defultHknsyuruino = <%= uiBean.getInitHknsyuruino().getValue() %>;
              if (hknsyuruino != defultHknsyuruino) {
                  alert('<%=MessageUtil.getMessage(MessageId.WHA1007) %>');
              }
              hknsyuruiGmCtrl($(this).val(), 'blur');
          }
       });

       function hknsyuruiGmCtrl(hknsyuruiNo, jyoutaiKbn) {
         var hknsyuruiCnt = <%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().size() %>;

         var hknsyuruiNoLst = [];
         var hknsyuruiNoSdLst = [];
         var syokugyoukktumuLst = [];
         var gaikatatkiumuLst = [];
         var nkhknumuLst = [];
         var hengakuumuLst = [];
         var nstkumuLst = [];
         var targettkhukakanoukbnLst = [];
         var sbuktumuLst = [];
         var teikisiharaikinumuLst = [];
         var kykdrtentuusanumuLst = [];
         var syuusinhknumuLst = [];
         var syksbyensitihsyutktekiumuLst = [];
         var jyudkaigomehrtktekiumuLst = [];
         var targettkmkhtselectmapLst = [];
         var dai1HknkknSelectMapLst = [];
         var nenkinsyuSelectMapLst  = [];
         var sueokikknSelectMapLst = [];
         var kyktuukasyuSelectMapLst = [];
         var hrktuukasyuSelectMapLst = [];
         var kyktuukasyu2SelectMapLst = [];
         var hrktuukasyu2SelectMapLst = [];
         var hrkkaisuuSelectMapLst = [];
         var ikkatubaraikaisuuSelectMapLst = [];
         var zenkizennouSelectMapLst = [];
         var aeoitaisyouumuLst = [];
         var hokenkngkyakujyouumuLst = [];
         var tmttknhaibunwarisiteiumuLst = [];
         var nkuktumuLst = [];
         var selectedRecordIndex = 0;

         var hknsyuruiAriFlg = false;
         var sonotaTkAriFlg = false;
         var skeiJimuKbn = String("0" + <%= uiBean.getSkeijimuKbn().getValue() %>);
         var hknsyuruiNoSd;
         var mkhgkwarimosinputselect = [];
         var dai1hknkknselect = [];
         var sueokikknSelect = [];
         var nenkinsyuSelect = [];
         var dai1hknkknItemCountLst = [];
         var zeiseitekikakuumuLst = [];
         var heijyunbaraiumuLst = [];
         var itijibrumuLst = [];
         var zennouumuLst = [];
         var kouzahurikaebaraitekiumuLst = [];
         var kyktuukasyuLst = [];
         var hrktuukasyuLst = [];
         var kyktuukasyu2Lst = [];
         var hrktuukasyu2Lst = [];
         var hrkkaisuuLst = [];
         var ikkatubaraikaisuuLst = [];
         var syuhrkkknsmnkbnLst = [];
         var syuhknkknsmnkbnLst = [];
         var zenkizennouLst = [];
         var syouhncd;
         var syouhncdLst = [];
         var itibuzennoutekiumuLst = [];
         var teikiikkatubaraiumuLst = [];
         var mos2hyoujiumuKbnLst = [];
         var ptratkituukasiteikbnLst = [];

         <% for (int index = 0;index < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().size(); index++) { %>
              hknsyuruiNoLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHknsyuruino() %>);
              hknsyuruiNoSdLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHknsyuruinosd() %>);
              syokugyoukktumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getSyokugyoukktumu() %>);
              gaikatatkiumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getGaikatatkiumu() %>);
              nkhknumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getNkhknumu() %>);
              hengakuumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHengakuumu() %>);
              nstkumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getNstkumu() %>);
              targettkhukakanoukbnLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getTargettkhukakanoukbn() %>);
              sbuktumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getSbuktumu() %>);
              teikisiharaikinumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getTeikisiharaikinumu() %>);
              kykdrtentuusanumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getKykdrtentuusanumu() %>);
              syuusinhknumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getSyuusinhknumu() %>);
              syksbyensitihsyutktekiumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getSyksbyensitihsyutktekiumu() %>);
              jyudkaigomehrtktekiumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getJyudkaigomehrtktekiumu() %>);
              aeoitaisyouumuLst.push('<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getAeoitaisyouumu() %>');
              hokenkngkyakujyouumuLst.push('<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHokenkngkyakujyouumu() %>');
              tmttknhaibunwarisiteiumuLst.push('<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getTmttknhaibunwarisiteiumu() %>');
              nkuktumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getNkuktumu() %>);
              zeiseitekikakuumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getZeiseitekikakuumu() %>);
              heijyunbaraiumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHeijyunbaraiumu() %>);
              itijibrumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getItijibrumu() %>);
              zennouumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getZennouumu() %>);
              kouzahurikaebaraitekiumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getKouzahurikaebaraitekiumu() %>);
              syuhrkkknsmnkbnLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrkkknsmnkbn() %>);
              syuhknkknsmnkbnLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHknkknsmnKbn() %>);
              syouhncdLst.push('<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getInputctrlsyouhncd() %>');
              itibuzennoutekiumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getItibuzennoutekiumu() %>);
              teikiikkatubaraiumuLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getTeikiikkatubaraiumu() %>);
              mos2hyoujiumuKbnLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getMos2hyoujiumuKbn() %>);
              ptratkituukasiteikbnLst.push(<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getPtratkituukasiteikbn() %>);

              var targettkmkhtselectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getTargettkmkhtSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getTargettkmkhtSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getTargettkmkhtSelect().get(itemIndex).getValue() %>';
                  targettkmkhtselectMap[value] = label;
              <% } %>
              targettkmkhtselectmapLst.push(targettkmkhtselectMap);

              var dai1HknkknSelectMap = [];
              var dai1hknkknItemCount = 0;
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getDai1HknkknSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getDai1HknkknSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getDai1HknkknSelect().get(itemIndex).getValue() %>';
                  dai1HknkknSelectMap[value] = label;
                  dai1hknkknItemCount = dai1hknkknItemCount + 1;
              <% } %>
              dai1HknkknSelectMapLst.push(dai1HknkknSelectMap);
              dai1hknkknItemCountLst.push(dai1hknkknItemCount);

              var sueokikknSelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getSueokikknSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getSueokikknSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getSueokikknSelect().get(itemIndex).getValue() %>';
                  sueokikknSelectMap[value] = label;
              <% } %>
              sueokikknSelectMapLst.push(sueokikknSelectMap);

              var nenkinsyuSelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getNenkinsyuSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getNenkinsyuSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getNenkinsyuSelect().get(itemIndex).getValue() %>';
                  nenkinsyuSelectMap[value] = label;
              <% } %>
              nenkinsyuSelectMapLst.push(nenkinsyuSelectMap);

              var kyktuukasyuSelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getKyktuukasyuSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getKyktuukasyuSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getKyktuukasyuSelect().get(itemIndex).getValue() %>';
                  kyktuukasyuSelectMap[value] = label;
              <% } %>
              kyktuukasyuSelectMapLst.push(kyktuukasyuSelectMap);

              var hrktuukasyuSelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrktuukaSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrktuukaSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrktuukaSelect().get(itemIndex).getValue() %>';
                  hrktuukasyuSelectMap[value] = label;
              <% } %>
              hrktuukasyuSelectMapLst.push(hrktuukasyuSelectMap);

              var kyktuukasyu2SelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getKyktuukasyu2Select().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getKyktuukasyu2Select().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getKyktuukasyu2Select().get(itemIndex).getValue() %>';
                  kyktuukasyu2SelectMap[value] = label;
              <% } %>
              kyktuukasyu2SelectMapLst.push(kyktuukasyu2SelectMap);

              var hrktuukasyu2SelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrktuukaSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrktuukaSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrktuukaSelect().get(itemIndex).getValue() %>';
                  hrktuukasyu2SelectMap[value] = label;
              <% } %>
              hrktuukasyu2SelectMapLst.push(hrktuukasyu2SelectMap);

              var hrkkaisuuSelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrkkaisuuSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrkkaisuuSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getHrkkaisuuSelect().get(itemIndex).getValue() %>';
                  hrkkaisuuSelectMap[value] = label;
              <% } %>
              hrkkaisuuSelectMapLst.push(hrkkaisuuSelectMap);

              var ikkatubaraikaisuuSelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getIkkatubaraikaisuuSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getIkkatubaraikaisuuSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getIkkatubaraikaisuuSelect().get(itemIndex).getValue() %>';
                  ikkatubaraikaisuuSelectMap[value] = label;
              <% } %>
              ikkatubaraikaisuuSelectMapLst.push(ikkatubaraikaisuuSelectMap);

              var zenkizennouSelectMap = [];
              <% for (int itemIndex = 0; itemIndex < uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getZenkizennouSelect().size(); itemIndex++) { %>
                  var label = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getZenkizennouSelect().get(itemIndex).getLabel() %>';
                  var value = '<%= uiBean.getSyouhnzokuseiCtrlGetOutBeanLst().get(index).getZenkizennouSelect().get(itemIndex).getValue() %>';
                  zenkizennouSelectMap[value] = label;
              <% } %>
              zenkizennouSelectMapLst.push(zenkizennouSelectMap);
         <% } %>

         for (var index = 0; index < hknsyuruiCnt; index++) {
           if (hknsyuruiNoLst[index] == hknsyuruiNo) {
             selectedRecordIndex = index;
             hknsyuruiAriFlg = true;
             hknsyuruiNoSd = hknsyuruiNoSdLst[index];
             mkhgkwarimosinputselect = targettkmkhtselectmapLst[index];
             dai1hknkknselect = dai1HknkknSelectMapLst[index];
             sueokikknSelect = sueokikknSelectMapLst[index];
             nenkinsyuSelect = nenkinsyuSelectMapLst[index];
             kyktuukasyuLst = kyktuukasyuSelectMapLst[index];
             hrktuukasyuLst = hrktuukasyuSelectMapLst[index];
             kyktuukasyu2Lst = kyktuukasyu2SelectMapLst[index];
             hrktuukasyu2Lst = hrktuukasyu2SelectMapLst[index];
             hrkkaisuuLst = hrkkaisuuSelectMapLst[index];
             ikkatubaraikaisuuLst = ikkatubaraikaisuuSelectMapLst[index];
             zenkizennouLst = zenkizennouSelectMapLst[index];
             syouhncd = syouhncdLst[index];
             gaikatatkiumu = gaikatatkiumuLst[index];
             ptratkituukasiteikbn = ptratkituukasiteikbnLst[index];
             hknsyuruiNoHandan = hknsyuruiNoLst[index];

             <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                createUserSelect(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>, kyktuukasyuLst, '<%= C_Tuukasyu.BLNK.getValue() %>', '<%= uiBean.getKyktuukasyumosinput() %>', jyoutaiKbn);
                createUserSelect(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>, hrktuukasyuLst, '<%= C_Tuukasyu.BLNK.getValue() %>', '<%= uiBean.getHrktuukasyumosinput() %>', jyoutaiKbn);

                createUserSelect(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU%>, kyktuukasyu2Lst, '<%= C_Tuukasyu.BLNK.getValue() %>', '<%= uiBean.getKyktuukasyu2mosinput() %>', jyoutaiKbn);
                createUserSelect(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU%>, hrktuukasyu2Lst, '<%= C_Tuukasyu.BLNK.getValue() %>', '<%= uiBean.getHrktuukasyu2mosinput() %>', jyoutaiKbn);

               createUserSelect(<%= IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>, ikkatubaraikaisuuLst, '<%= C_IkkatubaraiKaisuuKbn.BLNK.getValue() %>', '<%= uiBean.getIkkatubaraikaisuumosinput() %>', jyoutaiKbn);

               createUserSelect(<%= ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>, zenkizennouLst, '<%= C_BlnktkumuKbn.NONE.getValue() %>', '<%= uiBean.getZenkizennouumumosinput() %>', jyoutaiKbn);

               if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.GAIKARIRITUHENDOUNK.getValue() %>') {
                 createUserSelect(<%= HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>, hrkkaisuuLst, '<%= C_Hrkkaisuu.TUKI.getValue() %>', '<%= uiBean.getHrkkaisuumosinput() %>', jyoutaiKbn);
               }
               else {
                 createUserSelect(<%= HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>, hrkkaisuuLst, '<%= C_Hrkkaisuu.BLNK.getValue() %>', '<%= uiBean.getHrkkaisuumosinput() %>', jyoutaiKbn);
               }
            <% } %>

             if (aeoitaisyouumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               showKoumoku(<%= AEOISNSIKBN_KEIYAKUSYAINFO %>);
             } else {
               mosNrkHideKoumoku(<%= AEOISNSIKBN_KEIYAKUSYAINFO %>);
             }

             if (syokugyoukktumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               showKoumoku(<%= KKTYMD_HIHOKENSYAINFO %>);
             } else {
               mosNrkHideKoumoku(<%= KKTYMD_HIHOKENSYAINFO %>);
             }

             if (itijibrumuLst[index] != <%= C_UmuKbn.ARI.getValue() %> && nkhknumuLst[index] != <%= C_UmuKbn.ARI.getValue() %>) {
                showKoumoku(<%= HHKNNENSYUUKBN_HIHOKENSYAINFO %>);
             } else {
                mosNrkHideKoumoku(<%= HHKNNENSYUUKBN_HIHOKENSYAINFO %>);
                $(<%=HHKNNENSYUUKBN_HIHOKENSYAINFO%>).val('<%=C_NensyuuKbn.BLNK.getValue()%>');
             }

             if (nkuktumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               showGroup(<%= NENKINUKETORINININFO %>);
               if (zeiseitekikakuumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                    $(<%= NKUKTHYOUJIMONGON_NENKINUKETORINININFO%>).text('<%=MessageUtil.getMessage(MessageId.IHF1007) %>');
                    $(<%= NKUKTHYOUJIMONGON_NENKINUKETORINININFO%>).attr('style','');
                  <% } %>
               } else {
                   <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                    $(<%= NKUKTHYOUJIMONGON_NENKINUKETORINININFO%>).text('<%=MessageUtil.getMessage(MessageId.IHF1006) %>');
                    $(<%= NKUKTHYOUJIMONGON_NENKINUKETORINININFO%>).attr('style','');
                   <% } %>
               }
               <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                   $("#IHF1027").text('<%=MessageUtil.getMessage(MessageId.IHF1027) %>');
               <% } %>

             } else {
               mosNrkHideGroup(<%= NENKINUKETORINININFO %>);
               $("#IHF1027").text("");
             }

             if (hokenkngkyakujyouumuLst[index] == '<%= C_UmuKbn.NONE.getValue() %>') {
                setReadOnlyGray(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>);
                $(<%=SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).addClass("backgroundReadOnlyGray");
                setReadOnlyGray(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU %>);
                $(<%=KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).addClass("backgroundReadOnlyGray");
             } else {
                removeReadOnlyGray(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>);
                $(<%=SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                removeReadOnlyGray(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU %>);
                $(<%=KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).removeClass("backgroundReadOnlyGray");
             }

              if (mos2hyoujiumuKbnLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                 showGroup(<%= SYUKEIYAKUHOSYOUINFOBEI %>);
                 showGroup(<%= SYUKEIYAKUHOSYOUINFOGOU %>);

                 $(<%= SYUKEIYAKUHOSYOUINFOBEI + DIV%>).css("margin-top", "20px");
                 $(<%= SYUKEIYAKUHOSYOUINFOBEI + DIV%>).find(".groupTitle").visible(true);
              }
              else {
                showGroup(<%= SYUKEIYAKUHOSYOUINFOBEI %>);
                $(<%= SYUKEIYAKUHOSYOUINFOBEI + DIV%>).css("margin-top", "-1px");
                $(<%= SYUKEIYAKUHOSYOUINFOBEI + DIV%>).find(".groupTitle").visible(false);

                mosNrkHideGroup(<%= SYUKEIYAKUHOSYOUINFOGOU %>);

                if ('blur' == jyoutaiKbn) {
                   mosNrkHideKoumoku(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>);
                   mosNrkHideKoumoku(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>);
                   mosNrkHideKoumoku(<%= KJNNKPZEITEKITKHUKAKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
                }

                if (teikiikkatubaraiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                    showKoumoku(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>);
                }

                if (zennouumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                   showKoumoku(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>);
                }

                if (zeiseitekikakuumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                    showKoumoku(<%= KJNNKPZEITEKITKHUKAKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
                }

                if (gaikatatkiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                   showKoumoku(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
                   showKoumoku(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
                   $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI + LABEL %>).parent().parent().show();
                  <%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                     var kyktuukasyu = $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
                     if (kyktuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
                         $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                         $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                         if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.SITEITUUKA.getValue() %>') {
                            $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                            $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                            $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                            $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                         }
                     } else {
                         if ('blur' == jyoutaiKbn) {
                           $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                           $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                           $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                           $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                           $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                           $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                           $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                           $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                         }
                         <% if (uiBean.getSyukihons() == null || uiBean.getSyukihons().isZeroOrOptional()) { %>
                             if ($(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                                callAjaxCurrencyChange1(kyktuukasyu, <%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>
                                                   , "<%= AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS %>");
                             }
                         <% } else { %>
                             if ('blur' == jyoutaiKbn) {
                                callAjaxCurrencyChange1(kyktuukasyu, <%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>
                                                   , "<%= AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS %>");
                             }
                         <% } %>
                         if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.SITEITUUKA.getValue() %>') {
                            <% if (uiBean.getMossyukykp() == null || uiBean.getMossyukykp().isZeroOrOptional()) { %>
                             if ($(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                                callAjaxCurrencyChange1(kyktuukasyu, <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>
                                                   , "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                             }
                            <% } else { %>
                                if ('blur' == jyoutaiKbn) {
                                   callAjaxCurrencyChange1(kyktuukasyu, <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>
                                                      , "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                                }
                            <% } %>
                            <% if (uiBean.getMoszennoupsyokaiari() == null || uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) { %>
                             if ($(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                                callAjaxCurrencyChange1(kyktuukasyu, <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>
                                                   , "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                             }
                            <% } else { %>
                                if ('blur' == jyoutaiKbn) {
                                   callAjaxCurrencyChange1(kyktuukasyu, <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>
                                                      , "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                                }
                            <% } %>
                         }
                     }
                     var hrktuukasyu = $(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
                     if (hrktuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
                       $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                       $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                       $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                       $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                       if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.HRKTUUKA.getValue() %>') {
                           $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                           $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                           $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                           $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                       }
                     } else {
                       if ('blur' == jyoutaiKbn) {
                         $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                         $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                         $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                         $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                         $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                         $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                         $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                         $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                       }
                       <% if (uiBean.getHrktuukasyukykp() == null || uiBean.getHrktuukasyukykp().isZeroOrOptional()) { %>
                            if ($(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                              callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
                              <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
                            }
                       <% } else { %>
                            if ('blur' == jyoutaiKbn) {
                              callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
                              <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
                            }
                       <% } %>
                       <% if (uiBean.getMosikkatup() == null || uiBean.getMosikkatup().isZeroOrOptional()) { %>
                            if ($(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                              callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_BEI %>",
                              <%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSIKKATUP %>");
                            }
                       <% } %>
                       if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.HRKTUUKA.getValue() %>') {
                            <% if (uiBean.getMossyukykp() == null || uiBean.getMossyukykp().isZeroOrOptional()) { %>
                                 if ($(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                                   callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI %>",
                                   <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                                 }
                            <% } else { %>
                                 if ('blur' == jyoutaiKbn) {
                                   callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI %>",
                                   <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                                 }
                            <% } %>
                            <% if (uiBean.getMoszennoupsyokaiari() == null || uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) { %>
                                 if ($(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                                   callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI %>",
                                   <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                                 }
                            <% } else { %>
                                 if ('blur' == jyoutaiKbn) {
                                   callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI %>",
                                   <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                                 }
                            <% } %>
                       }
                     }
                <% } %>
                }
                else {
                   mosNrkHideKoumoku(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
                   mosNrkHideKoumoku(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);

                   $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI + LABEL %>).parent().parent().hide();

                   $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('円');
                   $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().next().val('YEN');
                   $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('円');
                   $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().next().val('YEN');
                }
              }
              if (mos2hyoujiumuKbnLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                showKoumoku(<%=AITEMOSNO_BASEINFO%>);

                if ('blur' == jyoutaiKbn) {
                   mosNrkHideKoumoku(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>);
                   mosNrkHideKoumoku(<%=MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>);
                   mosNrkHideKoumoku(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>);
                   mosNrkHideKoumoku(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>);
                   mosNrkHideKoumoku(<%= KJNNKPZEITEKITKHUKAKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
                   mosNrkHideKoumoku(<%= KJNNKPZEITEKITKHUKAKBN2_SYUKEIYAKUHOSYOUINFOGOU %>);
                }

                if (teikiikkatubaraiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                    showKoumoku(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>);
                    showKoumoku(<%=MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>);
                }

                if (zennouumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                     showKoumoku(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>);
                     showKoumoku(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>);
                }

                if (zeiseitekikakuumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                    showKoumoku(<%= KJNNKPZEITEKITKHUKAKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
                    showKoumoku(<%= KJNNKPZEITEKITKHUKAKBN2_SYUKEIYAKUHOSYOUINFOGOU %>);
                }

                if (gaikatatkiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                 showKoumoku(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
                 showKoumoku(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
                 showKoumoku(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>);
                 showKoumoku(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>);

                <%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                 var kyktuukasyu = $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
                 if (kyktuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
                   $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                   $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                   if (ptratkituukasiteikbnLst[index] == <%= C_PtratkituukasiteiKbn.SITEITUUKA.getValue() %>) {
                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                   }
                 } else {
                   if ('blur' == jyoutaiKbn) {
                     $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                     $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                   }
                   <% if (uiBean.getSyukihons() == null || uiBean.getSyukihons().isZeroOrOptional()) { %>
                       if ($(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                         callAjaxCurrencyChange1(kyktuukasyu, <%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>
                                                , "<%= AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS %>");
                       }
                   <% } else { %>
                       if ('blur' == jyoutaiKbn) {
                         callAjaxCurrencyChange1(kyktuukasyu, <%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>
                                                , "<%= AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS %>");
                       }
                   <% } %>
                   if (ptratkituukasiteikbnLst[index] == <%= C_PtratkituukasiteiKbn.SITEITUUKA.getValue() %>) {
                        <% if (uiBean.getMossyukykp() == null || uiBean.getMossyukykp().isZeroOrOptional()) { %>
                            if ($(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                              callAjaxCurrencyChange1(kyktuukasyu, <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>
                                                     , "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                            }
                        <% } else { %>
                            if ('blur' == jyoutaiKbn) {
                              callAjaxCurrencyChange1(kyktuukasyu, <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>
                                                     , "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                            }
                        <% } %>
                        <% if (uiBean.getMoszennoupsyokaiari() == null || uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) { %>
                            if ($(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                              callAjaxCurrencyChange1(kyktuukasyu, <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>
                                                     , "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                            }
                        <% } else { %>
                            if ('blur' == jyoutaiKbn) {
                              callAjaxCurrencyChange1(kyktuukasyu, <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>
                                                     , "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                            }
                        <% } %>
                   }
                 }

                 var hrktuukasyu = $(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();

                 if (hrktuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
                   $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                   $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                   $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                   $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                   if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.HRKTUUKA.getValue() %>') {
                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                   }
                 } else {
                   if ('blur' == jyoutaiKbn) {
                     $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                     $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
                   }
                   <% if (uiBean.getHrktuukasyukykp() == null || uiBean.getHrktuukasyukykp().isZeroOrOptional()) { %>
                       if ($(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                         callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
                         <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
                        }
                   <% } else { %>
                           if ('blur' == jyoutaiKbn) {
                           callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
                           <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
                           }
                   <% } %>

                   <% if (uiBean.getMosikkatup() == null || uiBean.getMosikkatup().isZeroOrOptional()) { %>
                       if ($(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                         callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_BEI %>",
                         <%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSIKKATUP %>");
                        }
                   <% } %>
                   if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.HRKTUUKA.getValue() %>') {
                       <% if (uiBean.getMossyukykp() == null || uiBean.getMossyukykp().isZeroOrOptional()) { %>
                        if ($(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                          callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI %>",
                          <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                        }
                       <% } else { %>
                           if ('blur' == jyoutaiKbn) {
                            callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI %>",
                            <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                           }
                       <% } %>

                       <% if (uiBean.getMoszennoupsyokaiari() == null || uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) { %>
                            if ($(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                              callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI %>",
                              <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                            }
                       <% } else { %>
                           if ('blur' == jyoutaiKbn) {
                            callAjaxCurrencyChange(hrktuukasyu , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI %>",
                            <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                           }
                       <% } %>
                   }
                 }

                 var kyktuukasyu2 = $(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).val();

                 if (kyktuukasyu2 == <%=C_Tuukasyu.BLNK.getValue() %>) {
                   $(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('');
                   $(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).val('');
                 } else {
                 <% if (uiBean.getKihons2() == null || uiBean.getKihons2().isZeroOrOptional()) { %>
                     if ($(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU %>).val() == "") {
                         callAjaxCurrencyChange2(kyktuukasyu2, <%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU %>
                                                , "<%= AJAX_POST_TUUKAHENKANKMNM_KIHONS2 %>");
                     }
                 <% } %>
                 }

                 var hrktuukasyu2 = $(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).val();

                 if (hrktuukasyu2 == <%=C_Tuukasyu.BLNK.getValue() %>) {
                   $(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('');
                   $(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>).val('');
                   $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('');
                   $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>).val('');
                   $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('');
                   $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>).val('');
                 } else {
                 <% if (uiBean.getHrktuukasyukykp2() == null || uiBean.getHrktuukasyukykp2().isZeroOrOptional()) { %>
                      if ($(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU %>).val() == "") {
                        callAjaxCurrencyChange(hrktuukasyu2 , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_GOU %>",
                        <%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKPM2 %>");
                      }
                 <% } %>
                 <% if (uiBean.getMosikkatup2() == null || uiBean.getMosikkatup2().isZeroOrOptional()) { %>
                      if ($(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>).val() == "") {
                        callAjaxCurrencyChange(hrktuukasyu2 , "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_GOU %>",
                        <%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_MOSIKKATUP2 %>");
                       }
                 <% } %>
                 <% if (uiBean.getMoszennoupsyokaiari2() == null || uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) { %>
                      if ($(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>).val() == "") {
                        callAjaxCurrencyChange(hrktuukasyu2 , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_GOU %>",
                        <%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI2 %>");
                       }
                 <% } %>
                 }
                <% } %>
               } else {
                <%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                 if ($(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val() != <%= C_Tuukasyu.BLNK.getValue() %>) {
                   <% if (uiBean.getSyukihons() == null || uiBean.getSyukihons().isZeroOrOptional()) { %>
                        if ($(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                          callAjaxCurrencyChange1("<%= C_Tuukasyu.BLNK.getValue() %>", <%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>
                                          , "<%= AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS %>");
                        }
                   <% } else { %>
                       if ('blur' == jyoutaiKbn) {
                       callAjaxCurrencyChange1("<%= C_Tuukasyu.BLNK.getValue() %>", <%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>
                                          , "<%= AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS %>");
                       }
                   <% } %>
                 }
                 if ($(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val() != <%= C_Tuukasyu.BLNK.getValue() %>) {
                   <% if (uiBean.getHrktuukasyukykp() == null || uiBean.getHrktuukasyukykp().isZeroOrOptional()) { %>
                        if ($(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                         callAjaxCurrencyChange("<%= C_Tuukasyu.BLNK.getValue() %>" , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
                         <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
                        }
                   <% } else { %>
                       if ('blur' == jyoutaiKbn) {
                         callAjaxCurrencyChange("<%= C_Tuukasyu.BLNK.getValue() %>" , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
                         <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
                       }
                   <% } %>

                   <% if (uiBean.getMosikkatup() == null || uiBean.getMosikkatup().isZeroOrOptional()) { %>
                       if ($(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).val() == "") {
                         callAjaxCurrencyChange("<%= C_Tuukasyu.BLNK.getValue() %>" , "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_BEI %>",
                         <%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSIKKATUP %>");
                       }
                   <% } %>
                 }

                 if ($(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).val() != <%= C_Tuukasyu.BLNK.getValue() %>) {
                   <% if (uiBean.getKihons2() == null || uiBean.getKihons2().isZeroOrOptional()) { %>
                        if ($(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU %>).val() == "") {
                           callAjaxCurrencyChange2("<%= C_Tuukasyu.BLNK.getValue() %>", <%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU %>
                                          , "<%= AJAX_POST_TUUKAHENKANKMNM_KIHONS2 %>");
                        }
                   <% } %>
                 }
                 if ($(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).val() != <%= C_Tuukasyu.BLNK.getValue() %>) {
                   <% if (uiBean.getHrktuukasyukykp2() == null || uiBean.getHrktuukasyukykp2().isZeroOrOptional()) { %>
                        if ($(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU %>).val() == "") {
                          callAjaxCurrencyChange("<%= C_Tuukasyu.BLNK.getValue() %>" , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_GOU %>",
                          <%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKPM2 %>");
                        }
                   <% } %>
                   <% if (uiBean.getMosikkatup2() == null || uiBean.getMosikkatup2().isZeroOrOptional()) { %>
                        if ($(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>).val() == "") {
                          callAjaxCurrencyChange("<%= C_Tuukasyu.BLNK.getValue() %>" , "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_GOU %>",
                          <%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_MOSIKKATUP2 %>");
                        }
                   <% } %>
                   <% if (uiBean.getMoszennoupsyokaiari2() == null || uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) { %>
                        if ($(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>).val() == "") {
                          callAjaxCurrencyChange("<%= C_Tuukasyu.BLNK.getValue() %>" , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_GOU %>",
                          <%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI2 %>");
                        }
                   <% } %>
                }
                 $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('円');
                 $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().next().val('YEN');
                 $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('円');
                 $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().next().val('YEN');
                 $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('円');
                 $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().next().val('YEN');
                 $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('円');
                 $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().next().val('YEN');
                 $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('円');
                 $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().next().val('YEN');

                 mosNrkHideKoumoku(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>);
                 mosNrkHideKoumoku(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>);
                 $(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('円');
                 $(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().next().val('YEN');
                 $(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('円');
                 $(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().next().val('YEN');
                 $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('円');
                 $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().next().val('YEN');
                 $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('円');
                 $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().next().val('YEN');
                <% } %>
                mosNrkHideKoumoku(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
                mosNrkHideKoumoku(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
               }

               <%if (uiBean.getPageNo() == PAGENO_RESULT) { %>
                     <% if (((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) && uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAINASI) ||
                              E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) &&
                              C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) { %>
                                 showKoumoku(<%= DISPCREDITKESSAIYOUNO2_SYUKEIYAKUHOSYOUINFOGOU %>);
                     <% } %>
               <% } %>

             } else {
                 mosNrkHideKoumoku(<%=AITEMOSNO_BASEINFO%>);
             }

             if ('onload' == jyoutaiKbn) {
                <% if (C_Sdpd.BLNK.eq(uiBean.getSdpdkbn())) { %>
                     if (hokenkngkyakujyouumuLst[index] != '<%= C_UmuKbn.ARI.getValue() %>') {
                        $(<%= SDPDKBN_SYUKEIYAKUHOSYOUINFO %>).val('<%=C_Sdpd.PD.getValue()%>');
                     }
                <% } %>
             } else {
                if (hokenkngkyakujyouumuLst[index] == '<%= C_UmuKbn.ARI.getValue() %>') {
                   $(<%= SDPDKBN_SYUKEIYAKUHOSYOUINFO %>).val('<%=C_Sdpd.BLNK.getValue()%>');
                } else {
                   $(<%= SDPDKBN_SYUKEIYAKUHOSYOUINFO %>).val('<%=C_Sdpd.PD.getValue()%>');
                }
             }

             if (tmttknhaibunwarisiteiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               showKoumoku(<%= TEIRITUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
               showKoumoku(<%= SISUUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
               <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                   if ($(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val() == <%= C_HknsyuruiNo.GAIKAINDEXNK_SISUU.getValue() %> ||
                       $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val() == <%= C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.getValue() %>) {
                       $(<%= SISUUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>).text('<%= C_TumitatekinHaibunWariKbn.WARIAI100.getContent() %>');
                       $(<%= TEIRITUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>).text('<%= C_TumitatekinHaibunWariKbn.WARIAI000.getContent() %>');
                   } else if ($(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val() == <%= C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.getValue() %> ||
                              $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val() == <%= C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.getValue() %>) {
                       $(<%= SISUUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>).text('<%= C_TumitatekinHaibunWariKbn.WARIAI000.getContent() %>');
                       $(<%= TEIRITUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>).text('<%= C_TumitatekinHaibunWariKbn.WARIAI100.getContent() %>');
                   } else {
                       $(<%= SISUUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>).text('');
                       $(<%= TEIRITUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>).text('');
                   }
               <% } %>
               showKoumoku(<%= SISUUNM_SYUKEIYAKUHOSYOUINFOBEI %>);
               changeSisuuNm();
               } else {
               mosNrkHideKoumoku(<%= TEIRITUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
               mosNrkHideKoumoku(<%= SISUUHAIBUNWARIKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
               mosNrkHideKoumoku(<%= SISUUNM_SYUKEIYAKUHOSYOUINFOBEI %>);
             }

             if (hokenkngkyakujyouumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                  $("#IHF1037").visible(true);
             } else {
                  $("#IHF1037").visible(false);
             }

             if (nkhknumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               showKoumoku(<%= NENKINSYUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
               $(<%= NENKINSYUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().show();
               <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                   uiBean.getPageNo() == PAGENO_CONFIRM ||
                   uiBean.getPageNo() == PAGENO_RESULT) { %>
                      $(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO + LABEL%>).text('<%= DISPHRKKKNTRL %>');
                      $(<%= SYUHKNKKN_SYUKEIYAKUHOSYOUINFO + LABEL%>).text('<%= DISPHKNKKNtRL %>');
               <% } %>
             } else {
               mosNrkHideKoumoku(<%= NENKINSYUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
               $(<%= NENKINSYUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
               <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                   uiBean.getPageNo() == PAGENO_CONFIRM ||
                   uiBean.getPageNo() == PAGENO_RESULT) { %>
                      $(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO + LABEL%>).text('<%= HRKKKN %>');
                      $(<%= SYUHKNKKN_SYUKEIYAKUHOSYOUINFO + LABEL%>).text('<%= HKNKKN %>');
               <% } %>
             }
             if (nkhknumuLst[index] == <%= C_UmuKbn.ARI.getValue() %> &&
                 hengakuumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               showKoumoku(<%= NKGNSHOSYOURITUKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
             } else {
               mosNrkHideKoumoku(<%= NKGNSHOSYOURITUKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
             }
             if (syksbyensitihsyutktekiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               sonotaTkAriFlg = true;
               showKoumoku(<%= SYKSBYENSITIHSYUTKHKKBN_SONOTATOKUYAKUINFO2 %>);
             } else {
               mosNrkHideKoumoku(<%= SYKSBYENSITIHSYUTKHKKBN_SONOTATOKUYAKUINFO2 %>);
             }
             if (jyudkaigomehrtktekiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               sonotaTkAriFlg = true;
               showKoumoku(<%= JYUDKAIGOMEHRTKHKKBN_SONOTATOKUYAKUINFO2 %>);
             } else {
               mosNrkHideKoumoku(<%= JYUDKAIGOMEHRTKHKKBN_SONOTATOKUYAKUINFO2 %>);
             }

             if (nstkumuLst[index] == <%= C_Nstkumu.ST_ARI.getValue() %>) {
               sonotaTkAriFlg = true;
               showKoumoku(<%= NSTKHKKBN_SONOTATOKUYAKUINFO2 %>);
               showKoumoku(<%= NSTKSBNKKN_SONOTATOKUYAKUINFO2 %>);
             } else {
               mosNrkHideKoumoku(<%= NSTKHKKBN_SONOTATOKUYAKUINFO2 %>);
               mosNrkHideKoumoku(<%= NSTKSBNKKN_SONOTATOKUYAKUINFO2 %>);
             }
             if (targettkhukakanoukbnLst[index] != <%= C_TargetTkHukaKanouKbn.NONE.getValue() %>) {
               sonotaTkAriFlg = true;
               showKoumoku(<%= MKHGKWARIMOSINPUT_SONOTATOKUYAKUINFO2 %>);
             } else {
               mosNrkHideKoumoku(<%= MKHGKWARIMOSINPUT_SONOTATOKUYAKUINFO2 %>);
             }

             if (sbuktumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               showGroup(<%= SIBOUUKETORINININFO %>);
               showGroup(<%= SIBOUUKETORINININFO1 %>);
               showGroup(<%= SIBOUUKETORINININFO2 %>);
               showGroup(<%= SIBOUUKETORINININFO3 %>);
               showGroup(<%= SIBOUUKETORINININFO4 %>);
             } else {
               mosNrkHideGroup(<%= SIBOUUKETORINININFO %>);
               mosNrkHideGroup(<%= SIBOUUKETORINININFO1 %>);
               mosNrkHideGroup(<%= SIBOUUKETORINININFO2 %>);
               mosNrkHideGroup(<%= SIBOUUKETORINININFO3 %>);
               mosNrkHideGroup(<%= SIBOUUKETORINININFO4 %>);
             }
             if (teikisiharaikinumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               sonotaTkAriFlg = true;
               showGroup(<%= UKETORIKOUZAINFO %>);
               $(<%= SONOTATOKUYAKUINFO2 + DIV %>).removeClass("nonMargin");

               <%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

                 var value = $(<%=TEIKISIHARAITKYKHKKBN_UKETORIKOUZAINFO%>).val();
                 if (value == '<%=C_Tkhukaumu.BLNK.getValue()%>' || value == '<%=C_Tkhukaumu.NONE.getValue()%>') {
                       $(<%= SHKSTKZINFKZINFOINPUTHRY_UKETORIKOUZAINFO %>).removeAttr("checked");
                       $(<%= SHKSTKZINFKZINFOINPUTHRY_UKETORIKOUZAINFO %>).attr("disabled", "true");
                       setShkstkzinfkzinfoHikatusei();
                 } else {
                       $(<%= SHKSTKZINFKZINFOINPUTHRY_UKETORIKOUZAINFO %>).removeAttr("disabled");
                       <% if (uiBean.getShkstkzinfkzinfoinputhry()) { //%>
                            setShkstkzinfkzinfoHikatusei();
                       <% } else { //%>
                            setShkstkzinfkzinfoKatusei();

                            <% if(C_KouzasyuruiKbn.GAIKAKOUZA.eq(uiBean.getKzsyuruikbn())) { %>

                                  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).val('<%=C_KzkykdouKbn.SITEI.getValue()%>');
                                  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
                                       if ($(this).val() != 2) {
                                           $(this).attr("disabled", "true");
                                       }
                                  });
                                  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).addClass("backgroundReadOnlyGray");

                                  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).val('<%=C_YokinKbn.BLNK.getValue()%>');
                                  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
                                       if ($(this).val() != 0) {
                                           $(this).attr("disabled", "true");
                                       }
                                  });
                                  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
                             <% } else { %>
                                  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
                                       $(this).removeAttr("disabled");
                                  });
                                  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");

                                  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
                                       $(this).removeAttr("disabled");
                                  });
                                  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");
                             <% } %>
                       <% } %>
                 }
               <% } %>
             } else {
               $(<%= SONOTATOKUYAKUINFO2 + DIV %>).addClass("nonMargin");
               mosNrkHideGroup(<%= UKETORIKOUZAINFO %>);
             }
             if (kykdrtentuusanumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
               showKoumoku(<%= TKHSYOURYAKU_SONOTAINFO %>);
               showKoumoku(<%= TKHSYOURYAKUUMUKBN_SONOTAINFO %>);
               showGroup(<%= SONOTAINFO %>);
             } else {
               mosNrkHideKoumoku(<%= TKHSYOURYAKU_SONOTAINFO %>);
               mosNrkHideKoumoku(<%= TKHSYOURYAKUUMUKBN_SONOTAINFO %>);
               mosNrkHideGroup(<%= SONOTAINFO %>);
             }

             <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                    uiBean.getPageNo() == PAGENO_CONFIRM ||
                    uiBean.getPageNo() == PAGENO_RESULT) { %>
                  if (sonotaTkAriFlg) {
                    showGroup(<%= SONOTATOKUYAKUIINFO %>);
                    showGroup(<%= SONOTATOKUYAKUINFO2 %>);
                  }
                  else {
                    mosNrkHideGroup(<%= SONOTATOKUYAKUIINFO %>);
                    mosNrkHideGroup(<%= SONOTATOKUYAKUINFO2 %>);
                  }
             <% } %>
             <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                   uiBean.getPageNo() == PAGENO_CONFIRM ||
                   uiBean.getPageNo() == PAGENO_RESULT) { %>
                   if (heijyunbaraiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                       showKoumoku(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO %>);
                       showKoumoku(<%= SYUHKNKKN_SYUKEIYAKUHOSYOUINFO %>);
                       <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                         if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.getValue() %>'
                           || hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                              $(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO %>).val("");
                              $(<%= SYUHKNKKN_SYUKEIYAKUHOSYOUINFO %>).val("99");
                              setReadOnlyGray(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO %>);
                              setReadOnlyGray(<%= SYUHKNKKN_SYUKEIYAKUHOSYOUINFO %>);
                              $(<%=SYUHRKKKN_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");
                              $(<%=SYUHKNKKN_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");
                         } else {
                             removeReadOnlyGray(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO %>);
                             $(<%=SYUHRKKKN_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
                             if ($(<%=SYUHKNKKN_SYUKEIYAKUHOSYOUINFO%>).prop("readonly")) {
                                removeReadOnlyGray(<%= SYUHKNKKN_SYUKEIYAKUHOSYOUINFO %>);
                                $(<%=SYUHKNKKN_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
                                $(<%= SYUHKNKKN_SYUKEIYAKUHOSYOUINFO %>).val("");
                             }
                         }
                       <% } %>

                       $(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().show();
                       showKoumoku(<%= HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                       showKoumoku(<%= HRKKEIRO_SYUKEIYAKUHOSYOUINFO %>);
                       $(<%= HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().show();
                       showKoumoku(<%= FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO %>);

                       <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                          var zenkizennouumumosinpu = "";
                          if ('onload' == jyoutaiKbn) {
                             zenkizennouumumosinpu = <%=uiBean.getZenkizennouumumosinput()%>;
                          } else {
                             zenkizennouumumosinpu = $(<%=ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val();
                          }
                          if (zenkizennouumumosinpu == '<%= C_BlnktkumuKbn.ARI.getValue() %>') {
                             if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.getValue() %>' ||
                                 hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).find("option").each(function(){
                                 $(this).removeAttr("disabled");
                                 });
                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                                 removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                                 $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                             } else {
                                 <% if(!C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) { %>
                                    removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                                    $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                                 <% } %>
                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).find("option").each(function(){
                                 $(this).removeAttr("disabled");
                                 });
                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                             }
                             setHrkkeiroAndIkkatubaraikaisuu (teikiikkatubaraiumuLst[index]);
                          } else {
                             $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                                $(this).removeAttr("disabled");
                             });
                             $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
                             $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                             $(this).removeAttr("disabled");
                             });
                             $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");

                             if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.getValue() %>' ||
                                 hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).val('<%=C_Tuukasyu.JPY.getValue()%>');
                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).find("option").each(function(){
                                  if ($(this).val() != '<%=C_Tuukasyu.JPY.getValue()%>') {
                                     $(this).attr("disabled", "true");
                                  }
                                 });
                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).addClass("backgroundReadOnlyGray");

                                 callAjaxCurrencyChange('<%=C_Tuukasyu.JPY.getValue()%>', "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
                                    <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
                                 callAjaxCurrencyChange('<%=C_Tuukasyu.JPY.getValue()%>', "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_BEI %>",
                                    <%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSIKKATUP %>");
                                 if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.HRKTUUKA.getValue() %>') {
                                   callAjaxCurrencyChange('<%=C_Tuukasyu.JPY.getValue()%>' , "<%= AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI %>",
                                      <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                                   callAjaxCurrencyChange('<%=C_Tuukasyu.JPY.getValue()%>' , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI %>",
                                      <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                                 }
                                 setReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                                 $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val("");

                                 $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_Hrkkeiro.KOUHURI.getValue()%>');
                                 $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                                  if ($(this).val() != '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {
                                     $(this).attr("disabled", "true");
                                  } else {
                                     $(this).removeAttr("disabled");
                                  }
                                 });
                                 $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");

                                 setKouhurikouzaInfoKatusei();
                                 $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                                      $(this).removeAttr("disabled");
                                 });
                                 $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");
                                 $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("disabled");
                                 if ('blur' == jyoutaiKbn) {
                                    $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
                                 }
                             } else {
                                 var hrkkeiro = '<%= C_Hrkkeiro.BLNK.getValue() %>';
                                 if ('onload' == jyoutaiKbn) {
                                   hrkkeiro = <%=uiBean.getHrkkeiro()%>;
                                 }
                                 if (hrkkeiro == '<%= C_Hrkkeiro.BLNK.getValue() %>' || 'blur' == jyoutaiKbn) {
                                   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_Hrkkeiro.BLNK.getValue()%>');
                                   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                                   $(this).removeAttr("disabled");
                                   });
                                   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
                                   $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
                                   $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).attr("disabled", "true");
                                   setKouhurikouzaInfoHikatusei();

                                   $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).val('<%=C_KzhuritourokuhouKbn.BLNK.getValue()%>');
                                   $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                                      if ($(this).val() != 0) {
                                          $(this).attr("disabled", "true");
                                      }
                                   });
                                   $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
                                 }

                                 <% if(!C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) { %>
                                    removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                                    $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                                 <% } %>

                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).find("option").each(function(){
                                 $(this).removeAttr("disabled");
                                 });
                                 $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                             }
                          }

                          <% if(!C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) { %>
                                $(<%=FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_FstphrkkeiroKbn.HURIKOMI.getValue()%>');
                                setFstphrkkeirokbnHikatusei();
                          <% } %>
                          <% if(C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) { %>
                             $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_IkkatubaraiKaisuuKbn.BLNK.getValue()%>');
                             $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                                 if ($(this).val() != 0) {
                                     $(this).attr("disabled", "true");
                                 }
                             });
                             $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");
                             $(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>).val("");
                             setReadOnlyGray(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>);
                             $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val("");
                             setReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                             $(<%=MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>).val("");
                             setReadOnlyGray(<%=MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>);
                             $(<%=MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>).val("");
                             setReadOnlyGray(<%=MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>);
                           <% } %>
                       <% } %>

                       if (zennouumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                        showKoumoku(<%= ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                        showKoumoku(<%= ZNNKAI_SYUKEIYAKUHOSYOUINFO %>);
                        $(<%= ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().show();
                        <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                         if (!(itibuzennoutekiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %> && '<%=uiBean.getZenkizennouumumosinput() %>' != <%=C_BlnktkumuKbn.ARI.getValue()%>)) {
                           $(<%=ZNNKAI_SYUKEIYAKUHOSYOUINFO%>).val("");
                           setReadOnlyGray(<%=ZNNKAI_SYUKEIYAKUHOSYOUINFO%>);
                         }
                          $(<%= ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>).blur(function() {
                             var value = $(<%=ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val();
                             if (itibuzennoutekiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %> && value != <%=C_BlnktkumuKbn.ARI.getValue()%>) {
                                 removeReadOnlyGray(<%=ZNNKAI_SYUKEIYAKUHOSYOUINFO%>);
                              }
                               else {
                                $(<%=ZNNKAI_SYUKEIYAKUHOSYOUINFO%>).val("");
                                setReadOnlyGray(<%=ZNNKAI_SYUKEIYAKUHOSYOUINFO%>);
                              }
                          });
                        <% } else { %>
                          <% if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
                             if (!(itibuzennoutekiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %> && '<%=uiBean.getZenkizennouumumosinput() %>' != <%=C_BlnktkumuKbn.ARI.getValue()%>)) {
                                $(<%=ZNNKAI_SYUKEIYAKUHOSYOUINFO%>).text("");
                                $(<%=ZNNKAI_UNIT%>).text("");
                             }
                          <% } %>
                          <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
                           <% if (uiBean.getZnnkai() != null && uiBean.getZnnkai() == 0) { %>
                                $(<%=ZNNKAI_SYUKEIYAKUHOSYOUINFO%>).text("");
                                $(<%=ZNNKAI_UNIT%>).text("");
                           <% } %>
                          <% } %>
                        <% } %>
                       } else {
                        mosNrkHideKoumoku(<%= ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                        mosNrkHideKoumoku(<%= ZNNKAI_SYUKEIYAKUHOSYOUINFO %>);
                        $(<%= ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
                       }

                       if (teikiikkatubaraiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                           showKoumoku(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>);
                           $(<%= IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().show();
                       }
                       else {
                           mosNrkHideKoumoku(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>);
                           $(<%= IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
                       }

                     $(<%=ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).change(function() {

                        var value = $(<%=ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val();
                        if (value == "<%=C_BlnktkumuKbn.ARI.getValue()%>" ) {
                           setHrkkeiroAndIkkatubaraikaisuu (teikiikkatubaraiumuLst[index]);
                           if (kouzahurikaebaraitekiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                               $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
                               $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).attr("disabled", "true");
                               setKouhurikouzaInfoHikatusei();

                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).val('<%=C_KzhuritourokuhouKbn.BLNK.getValue()%>');
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                                  if ($(this).val() != 0) {
                                      $(this).attr("disabled", "true");
                                  }
                               });
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
                           } else {
                               setKouhurikouzaInfoKatusei();
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                                    $(this).removeAttr("disabled");
                               });
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");
                               $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).removeAttr("disabled");
                           }
                           if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.getValue() %>' ||
                               hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).find("option").each(function(){
                               $(this).removeAttr("disabled");
                               });
                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).val('<%=C_Tuukasyu.BLNK.getValue()%>');

                               removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                               $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");

                               var hrktuukasyu = $(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
                               if (hrktuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
                                   $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).next().next().text('');
                                   $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val('');
                                   $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).next().next().text('');
                                   $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).val('');
                                   if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.HRKTUUKA.getValue() %>') {
                                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).next().next().text('');
                                     $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val('');
                                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).next().next().text('');
                                     $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).val('');
                                   }
                               }
                           } else {
                               <% if(!C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) { %>
                                  removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                                  $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                               <% } %>

                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).find("option").each(function(){
                               $(this).removeAttr("disabled");
                               });
                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                           }
                           if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).val('<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>');
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).find("option").each(function(){
                                if ($(this).val() != '<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>') {
                                   $(this).attr("disabled", "true");
                                } else {
                                   $(this).removeAttr("disabled");
                                }
                               });
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).addClass("backgroundReadOnlyGray");
                           } else {
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).find("option").each(function(){
                               $(this).removeAttr("disabled");
                               });
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).removeClass("backgroundReadOnlyGray");
                           }
                         }
                         else {
                           setHrkkeiroAndIkkatubaraikaisuuEnable (teikiikkatubaraiumuLst[index]);
                           if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.getValue() %>' ||
                               hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).val('<%=C_Tuukasyu.JPY.getValue()%>');
                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).find("option").each(function(){
                                if ($(this).val() != '<%=C_Tuukasyu.JPY.getValue()%>') {
                                   $(this).attr("disabled", "true");
                                }
                               });
                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).addClass("backgroundReadOnlyGray");

                               callAjaxCurrencyChange('<%=C_Tuukasyu.JPY.getValue()%>', "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
                                  <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
                               callAjaxCurrencyChange('<%=C_Tuukasyu.JPY.getValue()%>', "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_BEI %>",
                                  <%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSIKKATUP %>");
                               if (ptratkituukasiteikbnLst[index] == '<%= C_PtratkituukasiteiKbn.HRKTUUKA.getValue() %>') {
                                 callAjaxCurrencyChange('<%=C_Tuukasyu.JPY.getValue()%>' , "<%= AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI %>",
                                    <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                                 callAjaxCurrencyChange('<%=C_Tuukasyu.JPY.getValue()%>' , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI %>",
                                    <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
                               }
                               setReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                               $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val("");

                               $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_Hrkkeiro.KOUHURI.getValue()%>');
                               $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                                if ($(this).val() != '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {
                                   $(this).attr("disabled", "true");
                                } else {
                                   $(this).removeAttr("disabled");
                                }
                               });
                               $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");

                               setKouhurikouzaInfoKatusei();
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                                    $(this).removeAttr("disabled");
                               });
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");
                               $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("disabled");
                               $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
                           } else {
                               <% if(!C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) { %>
                                  removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
                                  $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                               <% } %>

                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).find("option").each(function(){
                               $(this).removeAttr("disabled");
                               });
                               $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");

                               $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_Hrkkeiro.BLNK.getValue()%>');
                               $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                               $(this).removeAttr("disabled");
                               });
                               $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
                               $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
                               $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).attr("disabled", "true");
                               setKouhurikouzaInfoHikatusei();

                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).val('<%=C_KzhuritourokuhouKbn.BLNK.getValue()%>');
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                                  if ($(this).val() != 0) {
                                      $(this).attr("disabled", "true");
                                  }
                               });
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
                           }

                           if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).find("option").each(function(){
                               $(this).removeAttr("disabled");
                               });
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).removeClass("backgroundReadOnlyGray");
                           } else {
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).val('<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>');
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).find("option").each(function(){
                                if ($(this).val() != '<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>') {
                                   $(this).attr("disabled", "true");
                                } else {
                                   $(this).removeAttr("disabled");
                                }
                               });
                               $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).addClass("backgroundReadOnlyGray");
                           }
                         }
                         $(<%= FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO %>).val('<%= C_FstphrkkeiroKbn.HURIKOMI.getValue() %>');
                         setFstphrkkeirokbnHikatusei();
                         removeReadOnlyGray(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>);
                         removeReadOnlyGray(<%=MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>);
                         removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>);
                         setHrktuukasyukykp();
                     });

                     if (syuhrkkknsmnkbnLst[index] == <%= C_HrkkknsmnKbn.SAIMANKI.getValue() %>) {
                          $(<%= SYUHRKKKNSMNKBN_SYUKEIYAKUHOSYOUINFO%>).text('歳');
                     }
                     if (syuhrkkknsmnkbnLst[index] == <%= C_HrkkknsmnKbn.NENMANKI.getValue() %>) {
                          $(<%= SYUHRKKKNSMNKBN_SYUKEIYAKUHOSYOUINFO%>).text('年');
                     }
                     if (syuhknkknsmnkbnLst[index] == <%= C_HknkknsmnKbn.SAIMANKI.getValue() %>) {
                          $(<%= SYUHKNKKNSMNKBN_SYUKEIYAKUHOSYOUINFO%>).text('歳');
                     }
                     if (syuhknkknsmnkbnLst[index] == <%= C_HknkknsmnKbn.NENMANKI.getValue() %>) {
                          $(<%= SYUHKNKKNSMNKBN_SYUKEIYAKUHOSYOUINFO%>).text('年');
                     }
                   }
                   else {
                       mosNrkHideKoumoku(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO %>);
                       mosNrkHideKoumoku(<%= SYUHKNKKN_SYUKEIYAKUHOSYOUINFO %>);
                       mosNrkHideKoumoku(<%= HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                       mosNrkHideKoumoku(<%= HRKKEIRO_SYUKEIYAKUHOSYOUINFO %>);
                       mosNrkHideKoumoku(<%= ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                       mosNrkHideKoumoku(<%= ZNNKAI_SYUKEIYAKUHOSYOUINFO %>);
                       mosNrkHideKoumoku(<%= IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                       mosNrkHideKoumoku(<%= FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO %>);
                       $(<%= SYUHRKKKN_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
                       $(<%= HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
                       $(<%= ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
                       $(<%= IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
                       if (gaikatatkiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                         $(<%=HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>).removeClass("backgroundReadOnlyGray");
                       }
                   }
             <% } %>

             <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                   uiBean.getPageNo() == PAGENO_CONFIRM ||
                   uiBean.getPageNo() == PAGENO_RESULT) { %>
                   if (nkhknumuLst[index] == <%= C_UmuKbn.ARI.getValue()%> &&
                       itijibrumuLst[index] == <%= C_UmuKbn.ARI.getValue()%>) {
                           showKoumoku(<%= SUEOKIKKNMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
                    }
                    else {
                        mosNrkHideKoumoku(<%= SUEOKIKKNMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
                    }
            <% } %>

            <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                   uiBean.getPageNo() == PAGENO_CONFIRM ||
                   uiBean.getPageNo() == PAGENO_RESULT) { %>
                   if (hknsyuruiNoLst[index] == <%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>) {
                      showGroup(<%= PTUUTIINFO %>);
                   } else {
                       $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).val('<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>');
                       mosNrkHideGroup(<%= PTUUTIINFO %>);
                   }

                   var zenkizennouumumosinpu = "";
                   if ('onload' == jyoutaiKbn) {
                      zenkizennouumumosinpu = <%=uiBean.getZenkizennouumumosinput()%>;
                   } else {
                      zenkizennouumumosinpu = $(<%=ZENKIZENNOUUMUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val();
                   }
                   if (zenkizennouumumosinpu == "<%=C_BlnktkumuKbn.NONE.getValue()%>" ) {
                      if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).find("option").each(function(){
                          $(this).removeAttr("disabled");
                          });
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).removeClass("backgroundReadOnlyGray");
                      } else {
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).val('<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>');
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).find("option").each(function(){
                           if ($(this).val() != '<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>') {
                              $(this).attr("disabled", "true");
                           } else {
                              $(this).removeAttr("disabled");
                           }
                          });
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).addClass("backgroundReadOnlyGray");
                      }
                   } else {
                      if (hknsyuruiNoLst[index] == '<%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>') {
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).val('<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>');
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).find("option").each(function(){
                           if ($(this).val() != '<%=C_YnkHrkmgkAnniTuutiKbn.BLNK.getValue()%>') {
                              $(this).attr("disabled", "true");
                           } else {
                              $(this).removeAttr("disabled");
                           }
                          });
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).addClass("backgroundReadOnlyGray");
                      } else {
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).find("option").each(function(){
                          $(this).removeAttr("disabled");
                          });
                          $(<%=YNKHRKMGKANNITUUTIKBN_PTUUTIINFO%>).removeClass("backgroundReadOnlyGray");
                      }
                   }
            <% } %>

            <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                   uiBean.getPageNo() == PAGENO_CONFIRM ||
                   uiBean.getPageNo() == PAGENO_RESULT) { %>
                   if (ptratkituukasiteikbnLst[index] == <%= C_PtratkituukasiteiKbn.SITEITUUKA.getValue() %>) {
                      showKoumoku(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>);
                   } else {
                       $(<%=MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val("");
                       mosNrkHideKoumoku(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>);
                   }
            <% } %>

             <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                   uiBean.getPageNo() == PAGENO_CONFIRM ||
                   uiBean.getPageNo() == PAGENO_RESULT) { %>
                   if (kouzahurikaebaraitekiumuLst[index] == <%= C_UmuKbn.ARI.getValue() %>) {
                      showGroup(<%= KOUHURIKOUZAINFO %>);
                      $(<%= KOUHURIKOUZAINFOBTN_LINKBUTTONS2%>).visible(true);

                      <% if (BizDateUtil.compareYmd(BizDate.getSysDate(),
                             YuyuSinkeiyakuConfig.getInstance().getNetkouhuriServiceKaisiYmd()) != BizDateUtil.COMPARE_LESSER &&
                             (E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn()) ||
                             E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
                             E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn()))) { %>

                               showKoumoku(<%= KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO %>);
                      <% } %>

                      <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
                        var value = $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val();
                        if (value != '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {
                           $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
                           $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).attr("disabled", "true");
                        }
                        else {
                           $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).removeAttr("disabled");
                        }

                        var kouzainfoinputhoryuu = "";
                        if ('onload' == jyoutaiKbn) {
                           kouzainfoinputhoryuu = '<%=uiBean.getKouzainfoinputhoryuu()%>';
                        } else {
                           kouzainfoinputhoryuu = $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).prop("checked");
                        }
                        if (kouzainfoinputhoryuu == 'true' || value != '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {
                           setKouhurikouzaInfoHikatusei();
                           if (value != '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {

                              $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).val('<%=C_KzhuritourokuhouKbn.BLNK.getValue()%>');
                              $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                                   if ($(this).val() != 0) {
                                       $(this).attr("disabled", "true");
                                   }
                              });
                              $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
                           }
                        }
                        else {
                            setKouhurikouzaInfoKatusei();
                            if (value == '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                                    $(this).removeAttr("disabled");
                               });
                               $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");
                            }
                        }
                      <% } else { %>
                            $(<%= KOUHURIKOUZAINFOBANKCD_KOUHURIKOUZAINFO %>).addClass("teikikinUkeInfoDisp");
                            $(<%= KOUHURIKOUZAINFOSITENCD_KOUHURIKOUZAINFO %>).addClass("teikikinUkeInfoDisp");
                      <% } %>
                   }
                   else {
                       mosNrkHideGroup(<%= KOUHURIKOUZAINFO %>);
                       $(<%= KOUHURIKOUZAINFOBTN_LINKBUTTONS2%>).visible(false);
                   }
             <% } %>

             <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
                   uiBean.getPageNo() == PAGENO_CONFIRM ||
                   uiBean.getPageNo() == PAGENO_RESULT) { %>

                   if (hknsyuruiNoLst[index] == <%= C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.getValue() %> ||
                       hknsyuruiNoLst[index] == <%= C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.getValue() %> ||
                       hknsyuruiNoLst[index] == <%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>) {
                      showGroup(<%= KOUREISYAINFO %>);
                   } else {
                       $(<%=KOUREIKZKSETUMEIHOUKBN_KOUREISYAINFO%>).val('<%=C_KoureiKzkSetumeiHouKbn.BLNK.getValue()%>');
                       $(<%=KOUREIMNDNHUKUSUUKAIKBN_KOUREISYAINFO%>).val('<%=C_KoureiMndnHukusuukaiKbn.BLNK.getValue()%>');
                       $(<%=KOUREITRATKISYAIGIDSKKBN_KOUREISYAINFO%>).val('<%=C_KoureiTratkisyaIgiDskKbn.BLNK.getValue()%>');
                       mosNrkHideGroup(<%= KOUREISYAINFO %>);
                   }
             <% } %>
             break;
           }
         }

         if (!hknsyuruiAriFlg) {
           showKoumoku(<%= KKTYMD_HIHOKENSYAINFO %>);
           showKoumoku(<%= SISUUNM_SYUKEIYAKUHOSYOUINFOBEI %>);
           showKoumoku(<%= SUEOKIKKNMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>);
           showGroup(<%= NENKINUKETORINININFO %>);
           showKoumoku(<%= NKGNSHOSYOURITUKBN_SYUKEIYAKUHOSYOUINFOBEI %>);
           showGroup(<%= SONOTATOKUYAKUIINFO %>);
           showKoumoku(<%= NSTKHKKBN_SONOTATOKUYAKUINFO2 %>);
           showKoumoku(<%= NSTKSBNKKN_SONOTATOKUYAKUINFO2 %>);
           showKoumoku(<%= MKHGKWARIMOSINPUT_SONOTATOKUYAKUINFO2 %>);
           showGroup(<%= SIBOUUKETORINININFO %>);
           showGroup(<%= SIBOUUKETORINININFO1 %>);
           showGroup(<%= SIBOUUKETORINININFO2 %>);
           showGroup(<%= SIBOUUKETORINININFO3 %>);
           showGroup(<%= SIBOUUKETORINININFO4 %>);
           showGroup(<%= UKETORIKOUZAINFO %>);
           showGroup(<%= SONOTAINFO %>);
         }

         mosNrkAddLink();

         <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
              var form = $('form').attr('action');
              form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";

              $.ajax({
                type: "POST",
                url: form,
                data: {
                  <%= AJAX_POST_PARAM_SYORIKBN %>: "<%= AJAX_POST_SYORIKBN_AISYOUMEISET %>",
                  <%= AJAX_POST_PARAM_HKNSYURUINO %>: $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val(),
                  <%= AJAX_POST_PARAM_HKNSYURUINOSD %>: hknsyuruiNoSd,
                  <%= AJAX_POST_PARAM_SKEIJIMUKBN %>: skeiJimuKbn,
                  <%= AJAX_POST_PARAM_SYOUHNCD %>: syouhncd
                },
                dataType: "json"
              }).success(function(data) {
                $(<%= AISYOUMEI_BASEINFO2 %>).text(data[0]);
              });
              if (dai1hknkknItemCountLst[selectedRecordIndex] == 0) {
                mosNrkHideKoumoku(<%= SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                $(<%= SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
              } else {
                showKoumoku(<%=SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                $(<%= SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().show();
                createUserSelect(<%= SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO%>, dai1hknkknselect, 0, '<%= uiBean.getSyudai1hknkknmosinput() %>', jyoutaiKbn);
              }

              createUserSelect(<%= MKHGKWARIMOSINPUT_SONOTATOKUYAKUINFO2%>, mkhgkwarimosinputselect, '<%= C_TargetTkMokuhyoutiKbn.BLNK.getValue() %>', '<%= uiBean.getMkhgkwarimosinput() %>', jyoutaiKbn);
              createUserSelect(<%= SUEOKIKKNMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI%>, sueokikknSelect, 0, '<%= uiBean.getSueokikknmosinput() %>', jyoutaiKbn);
              createUserSelect(<%= NENKINSYUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>, nenkinsyuSelect, '<%= C_Sknenkinsyu.BLNK.getValue() %>', '<%= uiBean.getNenkinsyumosinput() %>', jyoutaiKbn);
             if(jyoutaiKbn == 'blur') {
               $(<%=NENKINUKTKBN_NENKINUKETORINININFO%>).val(<%= C_UktKbn.BLNK.getValue() %>);

               if (hknsyuruiNoHandan != <%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.getValue() %> &&
                   hknsyuruiNoHandan != <%= C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.getValue() %>) {
                   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                       $(this).removeAttr("disabled");
                   });
                   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");

                   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_Hrkkeiro.BLNK.getValue()%>');
               }
               $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                  $(this).removeAttr("disabled");
               });
               $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");

               $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_IkkatubaraiKaisuuKbn.BLNK.getValue()%>');
             }

             var value = $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val();
             if (value != '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {
                 $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
                 $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).attr("disabled", "true");
             }

             var kouzainfoinputhoryuu = "";
             if ('onload' == jyoutaiKbn) {
                kouzainfoinputhoryuu = '<%=uiBean.getKouzainfoinputhoryuu()%>';
             } else {
                kouzainfoinputhoryuu = $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).prop("checked");
             }
             if (kouzainfoinputhoryuu == 'true' || value != '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {
                setKouhurikouzaInfoHikatusei();

                if (value != '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {

                      $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).val('<%=C_KzhuritourokuhouKbn.BLNK.getValue()%>');
                      $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                           if ($(this).val() != 0) {
                               $(this).attr("disabled", "true");
                           }
                      });
                      $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
                 }
             }

             setHrktuukasyukykp();

         <% } %>

         <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
               if(dai1hknkknItemCountLst[index] != 0) {
                 showKoumoku(<%=SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                 $(<%= SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().show();
               }
               else {
                 //mosNrkHideKoumoku(<%=SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO %>);
                 $(<%= SYUDAI1HKNKKNMOSINPUT_SYUKEIYAKUHOSYOUINFO + LABEL %>).parent().parent().hide();
               }
         <% } %>
       }

       function createUserSelect(selector, selectLst, initValue, value, jyoutaiKbn) {
           var selectNaiyou = '';
           var count = 0;

            for (var key in selectLst) {
               selectNaiyou = selectNaiyou + '<option value = "' + key + '"' + '>' + selectLst[key] + '</option>';
               count = count + 1;
            }

            if (count == 0) {
               selectNaiyou = '<option value = "' + initValue + '"></option>';
            }

           $(selector).html(selectNaiyou);
           if(jyoutaiKbn == 'blur') {
             $(selector).val(initValue);
           }
           else {
             $(selector).val(value);
           }

       }

  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
         $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).parent().addClass('aligRightGk');
         $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).parent().addClass('aligRightGk');
         $(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).parent().addClass('aligRightGk');
         $(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>).parent().addClass('aligRightGk');
  <%
         Boolean sibouUketorininInfoVisibled = false;
         if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getSbuktumu())) {
             sibouUketorininInfoVisibled = true;
         }

         Boolean sibouUketorininInfo1Visibled = false;
         if (!C_UktKbn.BLNK.eq(uiBean.getSbuktkbn1())) {
             sibouUketorininInfo1Visibled = true;
         } else {
             sibouUketorininInfo1Visibled = false;
         }

         if (sibouUketorininInfo1Visibled) { %>
           showGroup(<%= SIBOUUKETORINININFO1 %>);
      <% } else { %>
           mosNrkHideGroup(<%= SIBOUUKETORINININFO1 %>);
      <% }

         Boolean sibouUketorininInfo2Visibled = false;
         if (!C_UktKbn.BLNK.eq(uiBean.getSbuktkbn2())) {
             sibouUketorininInfo2Visibled = true;
         } else {
             sibouUketorininInfo2Visibled = false;
         }

         if (sibouUketorininInfo2Visibled) { %>
           showGroup(<%= SIBOUUKETORINININFO2 %>);
      <% } else { %>
           mosNrkHideGroup(<%= SIBOUUKETORINININFO2 %>);
      <% }

         Boolean sibouUketorininInfo3Visibled = false;
         if (!C_UktKbn.BLNK.eq(uiBean.getSbuktkbn3())) {
             sibouUketorininInfo3Visibled = true;
         } else {
             sibouUketorininInfo3Visibled = false;
         }

         if (sibouUketorininInfo3Visibled) { %>
           showGroup(<%= SIBOUUKETORINININFO3 %>);
      <% } else { %>
           mosNrkHideGroup(<%= SIBOUUKETORINININFO3 %>);
      <% }

         Boolean sibouUketorininInfo4Visibled = false;
         if (!C_UktKbn.BLNK.eq(uiBean.getSbuktkbn4())) {
             sibouUketorininInfo4Visibled = true;
         } else {
             sibouUketorininInfo4Visibled = false;
         }

         if (sibouUketorininInfo4Visibled) { %>
           showGroup(<%= SIBOUUKETORINININFO4 %>);
      <% } else { %>
           mosNrkHideGroup(<%= SIBOUUKETORINININFO4 %>);
      <% }

         if (sibouUketorininInfoVisibled &&
             (!sibouUketorininInfo1Visibled &&
              !sibouUketorininInfo2Visibled &&
              !sibouUketorininInfo3Visibled &&
              !sibouUketorininInfo4Visibled)) { %>
           showGroup(<%= SIBOUUKETORINININFO1 %>);
      <% }
     } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
         uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>
         <% if (E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn()) ||
                E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
                E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) { %>
                  showGroup(<%= KZKOUROKUSERVICEYOUROKUINFO2 %>);
                  showGroup(<%= KYKDAIRISEIKYUNININFO %>);
                  $(<%= KYKDAIRININBTN_LINKBUTTONS1%>).visible(true);
         <% } else { %>
                  mosNrkHideGroup(<%= KZKOUROKUSERVICEYOUROKUINFO2 %>);
                  mosNrkHideGroup(<%= KYKDAIRISEIKYUNININFO %>);
                  $(<%= KYKDAIRININBTN_LINKBUTTONS1%>).visible(false);
         <% } %>
  <% } %>

  <%
     Boolean dairitenInfo2Visibled = false;
     if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {
         dairitenInfo2Visibled = true;
     } else if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) {
         if (uiBean.getDrtInfo2HyoujiFlg()) {
             dairitenInfo2Visibled = true;
         }
     } %>

  <% if (dairitenInfo2Visibled) { %>
       showGroup(<%= DAIRITENINFOB %>);
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

      $(<%= TSINYOU_POPUPBUTTON %>).click(function() {
          $(<%= TSINADR1KJ_TUUSINSAKIINFO %>).parents("tr").prev().find("span[class='EHA0333']").remove();
          $(<%= TSINADR1KJ_TUUSINSAKIINFO %>).parents("tr").prev().find("input").removeClass("errorItem");
      });

      $(<%= HHKNYNO_POPUPBUTTON %>).click(function() {
          $(<%= HHKNADR1KJ_HIHOKENSYAINFO %>).parents("tr").prev().find("span[class='EHA0333']").remove();
          $(<%= HHKNADR1KJ_HIHOKENSYAINFO %>).parents("tr").prev().find("input").removeClass("errorItem");
      });
      $(<%= TRKKZKYNO1_POPUPBUTTON %>).click(function() {
          $(<%= TRKKZKADR1KJ1_KZKOUROKUSERVICEYOUROKUINFO1 %>).parents("tr").prev().find("span[class='EHA0333']").remove();
          $(<%= TRKKZKADR1KJ1_KZKOUROKUSERVICEYOUROKUINFO1 %>).parents("tr").prev().find("input").removeClass("errorItem");
      });

      $(<%= TRKKZKYNO2_POPUPBUTTON %>).click(function() {
          $(<%= TRKKZKADR1KJ2_KZKOUROKUSERVICEYOUROKUINFO2 %>).parents("tr").prev().find("span[class='EHA0333']").remove();
          $(<%= TRKKZKADR1KJ2_KZKOUROKUSERVICEYOUROKUINFO2 %>).parents("tr").prev().find("input").removeClass("errorItem");
      });
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
       $(<%= HANEIBTNBYTSINSAKIJYOUHOU_TUUSINSAKIINFO %>).click(function() {
         var postalCd = $(<%= TSINYNO_TUUSINSAKIINFO %>).val();
         callAjaxAddressSrch(postalCd, <%= TSINADR1KJ_TUUSINSAKIINFO %>, <%= TSINADR2KJ_TUUSINSAKIINFO %>, <%= TSINADR3KJ_TUUSINSAKIINFO %>);
       });

       $(<%= HANEIBTNBYHIHOKENSYAJYOUHOU_HIHOKENSYAINFO %>).click(function() {
         var postalCd = $(<%= HHKNYNO_HIHOKENSYAINFO %>).val();
         callAjaxAddressSrch(postalCd, <%= HHKNADR1KJ_HIHOKENSYAINFO %>, <%= HHKNADR2KJ_HIHOKENSYAINFO %>, <%= HHKNADR3KJ_HIHOKENSYAINFO %>);
       });

       $(<%= HANEIBTNBYTRKKZKADR1_KZKOUROKUSERVICEYOUROKUINFO1 %>).click(function() {
         var postalCd = $(<%= TRKKZKYNO1_KZKOUROKUSERVICEYOUROKUINFO1 %>).val();
         callAjaxAddressSrch(postalCd, <%= TRKKZKADR1KJ1_KZKOUROKUSERVICEYOUROKUINFO1 %>, <%= TRKKZKADR2KJ1_KZKOUROKUSERVICEYOUROKUINFO1 %>, <%= TRKKZKADR3KJ1_KZKOUROKUSERVICEYOUROKUINFO1 %>);
       });

       $(<%= HANEIBTNBYTRKKZKADR2_KZKOUROKUSERVICEYOUROKUINFO2 %>).click(function() {
         var postalCd = $(<%= TRKKZKYNO2_KZKOUROKUSERVICEYOUROKUINFO2 %>).val();
         callAjaxAddressSrch(postalCd, <%= TRKKZKADR1KJ2_KZKOUROKUSERVICEYOUROKUINFO2 %>, <%= TRKKZKADR2KJ2_KZKOUROKUSERVICEYOUROKUINFO2 %>, <%= TRKKZKADR3KJ2_KZKOUROKUSERVICEYOUROKUINFO2 %>);
       });

       function callAjaxAddressSrch(postalCd, Adr1, Adr2, Adr3) {
         var form = $('form').attr('action');
         form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";

         $.ajax({
           type: "POST",
           url: form,
           data: {
             <%= AJAX_POST_PARAM_SYORIKBN %>: "<%= AJAX_POST_SYORIKBN_ADDRESSSRCH %>",
             <%= AJAX_POST_PARAM_POSTALCD %>: postalCd
           },
           dataType: "json"
         }).success(function(data) {
           $(Adr1).parents("tr").prev().find("span[class='EHA0333']").remove();
           $(Adr1).parents("tr").prev().find("input").removeClass("errorItem");

           $(Adr1).val(data[0]);
           $(Adr2).val(data[1]);
           $(Adr3).val("");
         }).error(function() {
           $(Adr1).parents("tr").prev().find("span[class='EHA0333']").remove();

             $(Adr1).parents("tr").prev().find("span:last")
             .after("<span class=" + '<%= MessageId.EHA0333 %>' + " name=" + '<%= MessageId.EHA0333 %>' + ">" + '<%= MessageUtil.getMessage(MessageId.EHA0333) %>' + "</span>");
             $(Adr1).parents("tr").prev().find("input").addClass("errorItem");
             $(Adr1).val("");
             $(Adr2).val("");
             $(Adr3).val("");
         });
       }

       callAjaxSyokugyoumeiSet(<%= HHKNSYKGYCD_HIHOKENSYAINFO %>);

       $(<%= HHKNSYKGYCD_HIHOKENSYAINFO %>).change(function() {

         callAjaxSyokugyoumeiSet(<%= HHKNSYKGYCD_HIHOKENSYAINFO %>);
       }
       );

       function callAjaxSyokugyoumeiSet(selector) {
         var hhknSykgyCd = $(selector).val();

         var form = $('form').attr('action');
         form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";

         $.ajax({
           type: "POST",
           url: form,
           data: {
             <%= AJAX_POST_PARAM_SYORIKBN %>: "<%= AJAX_POST_SYORIKBN_SYOKUGYOUMEISET %>",
             <%= AJAX_POST_PARAM_SYOKUGYOUCD %>: hhknSykgyCd
           },
           dataType: "json"
         }).success(function(data) {
           $(<%= HHKNSYKGYNM_HIHOKENSYAINFO %>).text(data[0]);
         });
       }

       var kyktuukasyuZen;

       $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).focus(function() {
         kyktuukasyuZen = $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
       });

       $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).blur(function () {
         kyktuukasyuGo = $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
         if (kyktuukasyuZen != kyktuukasyuGo) {
           changeSisuuNm();
           var tuukasyu = $(this).val();

           if (tuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
             $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
             $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
             if (ptratkituukasiteikbn == 1) {
               $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
               $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
               $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).next().next().text('');
               $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val('');
             }
           }
           else {
             callAjaxCurrencyChange1(tuukasyu, <%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>
                                    , "<%= AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS %>");
             if (ptratkituukasiteikbn == 1) {
                 callAjaxCurrencyChange1(tuukasyu, <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>
                                   , "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
                 callAjaxCurrencyChange1(tuukasyu, <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>
                                   , "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
             }
           }
         }
       });

       var hrktuukasyuZen;

       $(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).focus(function() {
         hrktuukasyuZen = $(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
       });

       $(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).blur(function() {
         var hrktuukasyuGo = $(<%= HRKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
         if (hrktuukasyuZen != hrktuukasyuGo) {
           var tuukasyu = $(this).val();
           if (tuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
             $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).next().next().text('');
             $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val('');
             $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).next().next().text('');
             $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).val('');
             if (ptratkituukasiteikbn == 2) {
               $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).next().next().text('');
               $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).val('');
               $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).next().next().text('');
               $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).val('');
             }
           }
           else {
            callAjaxCurrencyChange(tuukasyu, "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI %>",
               <%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKP %>");
            callAjaxCurrencyChange(tuukasyu, "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_BEI %>",
               <%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSIKKATUP %>");
            if (ptratkituukasiteikbn == 2) {
              callAjaxCurrencyChange(tuukasyu , "<%= AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI %>",
                 <%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSSYUKYKP %>");
              callAjaxCurrencyChange(tuukasyu , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI %>",
                 <%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI %>");
            }
           }
         }
       });

       var kyktuukasyu2Zen;

       $(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).focus(function() {
         kyktuukasyu2Zen = $(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).val();
       });

       $(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).blur(function () {
         kyktuukasyu2Go = $(<%= KYKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).val();

         if (kyktuukasyu2Zen != kyktuukasyu2Go) {
           changeSisuuNm();
           var tuukasyu = $(this).val();

           if (tuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
             $(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).next().next().text('');
             $(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU%>).val('');
           }
           else {
             callAjaxCurrencyChange2(tuukasyu, <%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU %>
                                    , "<%= AJAX_POST_TUUKAHENKANKMNM_KIHONS2 %>");
           }
         }
       });

       var hrktuukasyu2Zen;

       $(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).focus(function() {
         hrktuukasyu2Zen = $(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).val();
       });

       $(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).blur(function() {
         var hrktuukasyu2Go = $(<%= HRKTUUKASYU2MOSINPUT_SYUKEIYAKUHOSYOUINFOGOU %>).val();

         if (hrktuukasyu2Zen != hrktuukasyu2Go) {
           var tuukasyu = $(this).val();
           if (tuukasyu == <%=C_Tuukasyu.BLNK.getValue() %>) {
             $(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU %>).next().next().text('');
             $(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU %>).val('');
             $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>).next().next().text('');
             $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>).val('');
             $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>).next().next().text('');
             $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>).val('');
           }
           else {
             callAjaxCurrencyChange(tuukasyu , "<%= AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_GOU %>",
                <%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_HRKTUUKASYUKYKPM2 %>");
             callAjaxCurrencyChange(tuukasyu , "<%= AJAX_POST_SYORIKBN_MOSIKKATUP_GOU %>",
                <%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_MOSIKKATUP2 %>");
             callAjaxCurrencyChange(tuukasyu , "<%= AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_GOU %>",
                <%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>, "<%= AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI2 %>");
           }
         }

       });

       function callAjaxCurrencyChange1(tuukasyu, selector, tuukahenkankm) {
         var form = $('form').attr('action');
         form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";

         $.ajax({
           type: "POST",
           url: form,
           data: {
             <%= AJAX_POST_PARAM_SYORIKBN %>: "<%= AJAX_POST_SYORIKBN_CURRENCYCHANGE %>",
             <%= AJAX_POST_PARAM_TUUKASYU %>: tuukasyu,
             <%= AJAX_POST_PARAM_TUUKAHENKANKM %>: tuukahenkankm,
             <%= AJAX_POST_PARAM_SWAK_CID %>: $('input[name=swak-cid]').val()
           },
           dataType: "json"
         }).success(function(data) {
           $(selector).val(data[0]);
           $(selector).next().text(data[1]);
           $(selector).next().next().text(data[2]);
           $(selector).next().next().next().val(data[3]);
         });
       }

       function callAjaxCurrencyChange2(tuukasyu, selector, tuukahenkankm) {
         var form = $('form').attr('action');
         form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";

         $.ajax({
           type: "POST",
           url: form,
           data: {
             <%= AJAX_POST_PARAM_SYORIKBN %>: "<%= AJAX_POST_SYORIKBN_CURRENCYCHANGE_GOU %>",
             <%= AJAX_POST_PARAM_TUUKASYU %>: tuukasyu,
             <%= AJAX_POST_PARAM_TUUKAHENKANKM %>: tuukahenkankm,
             <%= AJAX_POST_PARAM_SWAK_CID %>: $('input[name=swak-cid]').val()
           },
           dataType: "json"
         }).success(function(data) {
           $(selector).val(data[0]);
           $(selector).next().text(data[1]);
           $(selector).next().next().text(data[2]);
           $(selector).next().next().next().val(data[3]);
         });
       }

       function callAjaxCurrencyChange(tuukasyu,syorikbn,selector, tuukahenkankm) {
         var form = $('form').attr('action');
         form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";
         $.ajax({
           type: "POST",
           url: form,
           data: {
             <%= AJAX_POST_PARAM_SYORIKBN %>: syorikbn,
             <%= AJAX_POST_PARAM_TUUKASYU %>: tuukasyu,
             <%= AJAX_POST_PARAM_TUUKAHENKANKM %>: tuukahenkankm,
             <%= AJAX_POST_PARAM_SWAK_CID %>: $('input[name=swak-cid]').val()
           },
           dataType: "json"
         }).success(function(data) {
           $(selector).val(data[0]);
           $(selector).next().text(data[1]);
           $(selector).next().next().text(data[2]);
           $(selector).next().next().next().val(data[3]);
         });

       }
  <% } %>

       function changeSisuuNm(){
       <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS){ %>
         var tuuka ="";
         var sisuuMap =[];
         $(<%= SISUUNM_SYUKEIYAKUHOSYOUINFOBEI %>).text("");
         <% for (String key: uiBean.getSisuunmSyutokuMap().keySet()){ %>
              var label = '<%= uiBean.getSisuunmSyutokuMap().get(key) %>';
              var value = '<%=key%>';
              sisuuMap[value] = label;
         <% } %>
         var hokensyu = $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).val();
         tuukasyu = $(<%= KYKTUUKASYUMOSINPUT_SYUKEIYAKUHOSYOUINFOBEI %>).val();
         var mapKey = hokensyu + tuukasyu;
         $(<%= SISUUNM_SYUKEIYAKUHOSYOUINFOBEI %>).text(sisuuMap[mapKey]);
       <% } %>

       }

  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if ((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) && uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAINASI) ||
           E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn()) ||
           E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
           E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn())) { %>
         $(<%= NYUURYOKUTEISEIBTNBYRESULT_FOOTERBUTTONS4 %>).visible(true);
    <% } else if (E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) { %>
         $(<%= HENKOUTSSKBTNBYRESULT_FOOTERBUTTONS4 %>).visible(true);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (!(E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn()) ||
             (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
              SaiDataTouroku.NRKSAIARI == uiBean.getNrksaiumu()))
           && C_KykKbn.KEIHI_BETU.eq(uiBean.getKykkbn())) { %>
         $(<%= KYKNEN_KEIYAKUSYAINFO2 %>).visible(true);
    <% } else { %>
         $(<%= KYKNEN_UNIT %>).visible(false);
    <% } %>

    <% if (!(E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn()) ||
             (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
              SaiDataTouroku.NRKSAIARI == uiBean.getNrksaiumu()))) { %>
         $(<%= HHKNNEN_HIHOKENSYAINFO %>).visible(true);
    <% } else { %>
         $(<%= HHKNNEN_UNIT %>).visible(false);
    <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
       $(<%= KYKNMKJKHUKAKBN_KEIYAKUSYAINFO2 %>).addClass("fontRed");
       $(<%= HHKNNMKJKHUKAKBN_HIHOKENSYAINFO %>).addClass("fontRed");
       $(<%= SBUKTNMKJHUKAKBN1_SIBOUUKETORINININFO1 %>).addClass("fontRed");
       $(<%= SBUKTNMKJHUKAKBN2_SIBOUUKETORINININFO2 %>).addClass("fontRed");
       $(<%= SBUKTNMKJHUKAKBN3_SIBOUUKETORINININFO3 %>).addClass("fontRed");
       $(<%= SBUKTNMKJHUKAKBN4_SIBOUUKETORINININFO4 %>).addClass("fontRed");
       $(<%= TRKKZKNMKJKHUKAKBN1_KZKOUROKUSERVICEYOUROKUINFO1 %>).addClass("fontRed");
       $(<%= TRKKZKNMKJKHUKAKBN2_KZKOUROKUSERVICEYOUROKUINFO2 %>).addClass("fontRed");
       $(<%= STDRSKNMKJHUKAKBN_SITEIDAIRISEIKYUNININFO %>).addClass("fontRed");
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
       $(<%= HHKNSYKGYCD_HIHOKENSYAINFO %>).parent().addClass("hhknsykgycdDisp");
  <% } else if (uiBean.getPageNo() == PAGENO_CONFIRM ||
                uiBean.getPageNo() == PAGENO_RESULT) { %>
       $(<%= HHKNSYKGYCD_HIHOKENSYAINFO %>).addClass("hhknsykgycdDisp");
  <% } %>
  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
       $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).parent().parent().removeClass("alignRight");
       $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).parent().parent().removeClass("alignRight");
       $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).parent().parent().removeClass("alignRight");
       $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>).parent().parent().removeClass("alignRight");
       $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>).parent().parent().removeClass("alignRight");
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>
       $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>).parent().addClass("kingakuDisp");
       $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).parent().addClass("kingakuDisp");
       $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).addClass("leftDispCell");
       $(<%= MOSSYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).addClass("leftDispCell");
       $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).addClass("leftDispCell");
       $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>).addClass("leftDispCell");
       $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>).addClass("leftDispCell");
  <% } %>

  <%if (uiBean.getPageNo() == PAGENO_RESULT) { %>
       <% if (((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) && uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAINASI) ||
                E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) &&
                C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) { %>
                  showKoumoku(<%= DISPCREDITKESSAIYOUNO_SYUKEIYAKUHOSYOUINFOBEI %>);
       <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>
       <% if (uiBean.getSyukihons() == null ||
              uiBean.getSyukihons().isZeroOrOptional()) { %>
            $(<%= SYUKIHONS_SYUKEIYAKUHOSYOUINFOBEI %>).text("");
       <% } %>

       <% if (uiBean.getHrktuukasyukykp() == null ||
              uiBean.getHrktuukasyukykp().isZeroOrOptional()) { %>
            $(<%= HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI %>).text("");
       <% } %>

       <% if (uiBean.getMosikkatup() == null ||
              uiBean.getMosikkatup().isZeroOrOptional()) { %>
            $(<%= MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI %>).text("");
       <% } %>

       <% if (uiBean.getMoszennoupsyokaiari() == null ||
              uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) { %>
            $(<%= MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI %>).text("");
       <% } %>
       <% if (uiBean.getKihons2() == null ||
              uiBean.getKihons2().isZeroOrOptional()) { %>
            $(<%= KIHONS2_SYUKEIYAKUHOSYOUINFOGOU %>).text("");
       <% } %>

       <% if (uiBean.getHrktuukasyukykp2() == null ||
              uiBean.getHrktuukasyukykp2().isZeroOrOptional()) { %>
            $(<%= HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU %>).text("");
       <% } %>

       <% if (uiBean.getMosikkatup2() == null ||
              uiBean.getMosikkatup2().isZeroOrOptional()) { %>
            $(<%= MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU %>).text("");
       <% } %>

       <% if (uiBean.getMoszennoupsyokaiari2() == null ||
              uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) { %>
            $(<%= MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU %>).text("");
       <% } %>
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>
       $(<%= BANKCD_UKETORIKOUZAINFO %>).addClass("teikikinUkeInfoDisp");
       $(<%= SITENCD_UKETORIKOUZAINFO %>).addClass("teikikinUkeInfoDisp");
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

      $(<%= DRTENKINYUUSITENCD1X3KETA_DAIRITENINFOA %>).visible(false);
      $(<%= DRTENKINYUUSITENCD2X3KETA_DAIRITENINFOB %>).visible(false);

  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
       zeroPadding(<%= DAIRITENKINYUUKIKANSITENCD1_DAIRITENINFOA %>);
       zeroPadding(<%= DAIRITENKINYUUKIKANSITENCD2_DAIRITENINFOB %>);

       setSitencd3Keta(<%= DAIRITENKINYUUKIKANSITENCD1_DAIRITENINFOA %>, <%= DRTENKINYUUSITENCD1X3KETA_DAIRITENINFOA %>);
       setSitencd3Keta(<%= DAIRITENKINYUUKIKANSITENCD2_DAIRITENINFOB %>, <%= DRTENKINYUUSITENCD2X3KETA_DAIRITENINFOB %>);

       $(<%= DAIRITENKINYUUKIKANSITENCD1_DAIRITENINFOA %>).bind("input propertychange", function() {
         if (!$(this).is(":focus")) {
           zeroPadding(<%= DAIRITENKINYUUKIKANSITENCD1_DAIRITENINFOA %>);
         } else {
           $(this).focusout(function() {
             zeroPadding(<%= DAIRITENKINYUUKIKANSITENCD1_DAIRITENINFOA %>);
           });
         }

         setSitencd3Keta(<%= DAIRITENKINYUUKIKANSITENCD1_DAIRITENINFOA %>, <%= DRTENKINYUUSITENCD1X3KETA_DAIRITENINFOA %>);
       });

       $(<%= DAIRITENKINYUUKIKANSITENCD2_DAIRITENINFOB %>).bind("input propertychange", function() {
         if (!$(this).is(":focus")) {
           zeroPadding(<%= DAIRITENKINYUUKIKANSITENCD2_DAIRITENINFOB %>);
         } else {
           $(this).focusout(function() {
             zeroPadding(<%= DAIRITENKINYUUKIKANSITENCD2_DAIRITENINFOB %>);
           });
         }

         setSitencd3Keta(<%= DAIRITENKINYUUKIKANSITENCD2_DAIRITENINFOB %>, <%= DRTENKINYUUSITENCD2X3KETA_DAIRITENINFOB %>);
       });

       $(<%=DAIRITENKINYUUKIKANCD1_POPUPBUTTON%>).popupResponse(function() {

         zeroPadding(<%= DAIRITENKINYUUKIKANSITENCD1_DAIRITENINFOA %>);
         setSitencd3Keta(<%= DAIRITENKINYUUKIKANSITENCD1_DAIRITENINFOA %>, <%= DRTENKINYUUSITENCD1X3KETA_DAIRITENINFOA %>);
       });

       $(<%=DAIRITENKINYUUKIKANCD2_POPUPBUTTON%>).popupResponse(function() {

         zeroPadding(<%= DAIRITENKINYUUKIKANSITENCD2_DAIRITENINFOB %>);
         setSitencd3Keta(<%= DAIRITENKINYUUKIKANSITENCD2_DAIRITENINFOB %>, <%= DRTENKINYUUSITENCD2X3KETA_DAIRITENINFOB %>);
       });

       function zeroPadding(selector) {
         var str = $(selector).val();
         if (str.length >=1 && str.length < 4) {
           for (var index = str.length; index < 4; index++) {
             str = "0" + str;
           }

           $(selector).val(str);
         }
       }

       function setSitencd3Keta(motoSelector, sakiSelector) {
         var sitenCd = $(motoSelector).val();
         if (sitenCd.length == 4) {
           $(sakiSelector).val(sitenCd.substring(1));
         } else {
           $(sakiSelector).val("");
         }
       }
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
       noneToBlnk(<%= TKHSYOURYAKUUMUKBN_SONOTAINFO %>);

       function noneToBlnk(selector) {
         var str = $(selector).text();
         if (str == "なし") {
           str = "";
           $(selector).text(str);
         }
       }
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
         uiBean.getPageNo() == PAGENO_CONFIRM ||
         uiBean.getPageNo() == PAGENO_RESULT) { %>
       function mosNrkHideGroup(selector){
         var groupId = selector + "Div";
         $(groupId).visible(false);
         clearGroupValue(groupId);
       }

       function mosNrkHideKoumoku(selector) {
         var labelId;
         if (selector.indexOf(".") == -1) {
           labelId = selector + "_label";
         } else {
           labelId = "#" + selector.substring(selector.indexOf(".") + 1) + "_label";
         }
         $(labelId).parent().visible(false);

         var koumokuId;

         koumokuId = "." +  selector.substring(1) + "_data";

         $(koumokuId).visible(false);

         clearValue(koumokuId);
       }

       function clearGroupValue(groupId) {
         if (inputcontentsFlg) {

           var selectMojiretu = $(groupId).children().find("select");

           for (var index = 0; selectMojiretu != null && index < selectMojiretu.size(); index++) {

             var selectId = selectMojiretu[index].id;

             if (selectId.indexOf(":gengou") != -1) {
               selectId = "." + selectId.substring(0, selectId.indexOf(":gengou")) + "_data";
               var maxIndex = $(selectId).children().find("select option:last").prop("index");
               if (selectId.indexOf("seiymd") != -1) {
                 $(selectId).children().find("select").prop("selectedIndex", maxIndex - 1);
               } else {
                 $(selectId).children().find("select").prop("selectedIndex", maxIndex);
               }
             } else {
               $("#" + selectId).prop("selectedIndex", 0);
             }
           }

           $(groupId).children().find("input[type='text']").val("");
           $(groupId).children().find("input[type='checkbox']").prop("checked", false);
         }
       }

       function clearValue(koumokuId) {
         if (inputcontentsFlg) {

           if (koumokuId.indexOf("ymd") != -1) {
             var maxIndex = $(koumokuId).children().find("select option:last").prop("index");

             if (koumokuId.indexOf("seiymd") != -1) {
               $(koumokuId).children().find("select").prop("selectedIndex", maxIndex - 1);
             } else {
               $(koumokuId).children().find("select").prop("selectedIndex", maxIndex);
             }
           } else {
             $(koumokuId).children().find("select").prop("selectedIndex", 0);
           }

           $(koumokuId).children().find("input[type='text']").val("");
           $(koumokuId).children().find("input[type='checkbox']").prop("checked", false);
         }
       }

       function mosNrkAddLink(){
         $(".topBottomLink").remove();

         addBottomLink(<%= BASEINFO2 %>);
         addTopBottomLink(<%= KEIYAKUSYAINFO2 %>);
         addTopBottomLink(<%= TUUSINSAKIINFO %>);
         addTopBottomLink(<%= HIHOKENSYAINFO %>);
         varElmAddTopBottomLink([<%= NENKINUKETORINININFO %>]);
         varElmAddTopBottomLink([<%= SIBOUUKETORINININFO1 %>,
                                 <%= SIBOUUKETORINININFO2 %>,
                                 <%= SIBOUUKETORINININFO3 %>,
                                 <%= SIBOUUKETORINININFO4 %>]);
         varElmAddTopBottomLink([<%= KZKOUROKUSERVICEYOUROKUINFO1 %>,
                                 <%= KZKOUROKUSERVICEYOUROKUINFO2 %>]);
         varElmAddTopBottomLink([<%= KYKDAIRISEIKYUNININFO %>]);
         addTopBottomLink(<%= SITEIDAIRISEIKYUNININFO %>);
         varElmAddTopBottomLink([<%= SYUKEIYAKUHOSYOUINFO %>,
                                 <%= SYUKEIYAKUHOSYOUINFOBEI %>,
                                 <%= SYUKEIYAKUHOSYOUINFOGOU %>]);
         varElmAddTopBottomLink([<%= KOUHURIKOUZAINFO %>]);
         addTopBottomLink(<%= HONNINKAKNININFO %>);
         varElmAddTopBottomLink([<%= KOUREISYAINFO %>]);
         varElmAddTopBottomLink([<%= DAIRITENINFOA %>,
                                 <%= DAIRITENINFOB %>]);
         addTopBottomLink(<%= TOKUSYUKOUMOKUINFO %>);
         varElmAddTopBottomLink([<%= SONOTAINFO %>]);
         addTopBottomLink(<%= MOSTENKENINFO %>);
         varElmAddTopBottomLink([<%= UKETORIKOUZAINFO %>,
                                 <%= SONOTATOKUYAKUINFO2 %>]);
         addTopBottomLink(<%= DRCTSERVICEINFO %>);
         varElmAddTopBottomLink([<%= PTUUTIINFO %>]);
       }

       function varElmAddTopBottomLink(idSelectorList) {
         var groupSelector = idSelectorList.join(",");
         var targetId = $(groupSelector).filter(":visible").last().attr("id");
         addTopBottomLink("#" + targetId);
       }

       mosNrkAddLink();
  <% } %>

   <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      $(<%= HKNSYURUINOMOSINPUT_BASEINFO2 %>).blur(function() {

          <% if(C_HrkkknsmnKbn.SAIMANKI.eq(uiBean.getSyuhrkkknsmnkbn())) { %>
              $(<%= SYUHRKKKNSMNKBN_SYUKEIYAKUHOSYOUINFO%>).text('歳');
          <% } %>

          <% if(C_HrkkknsmnKbn.NENMANKI.eq(uiBean.getSyuhrkkknsmnkbn())) { %>
              $(<%= SYUHRKKKNSMNKBN_SYUKEIYAKUHOSYOUINFO%>).text('年');
          <% } %>

          <% if(C_HknkknsmnKbn.SAIMANKI.eq(uiBean.getSyuhknkknsmnkbn())) { %>
              $(<%= SYUHKNKKNSMNKBN_SYUKEIYAKUHOSYOUINFO%>).text('歳');
          <% } %>

          <% if(C_HknkknsmnKbn.NENMANKI.eq(uiBean.getSyuhknkknsmnkbn())) { %>
              $(<%= SYUHKNKKNSMNKBN_SYUKEIYAKUHOSYOUINFO%>).text('年');
          <% } %>
       });
   <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      $("input[id^='kouzainfoinputhoryuu']").change(function() {
         var value = $("input[id^='kouzainfoinputhoryuu']:checked").val();
         if (value == 'true') {
           setKouhurikouzaInfoHikatusei();
         }
         else {
            setKouhurikouzaInfoKatusei();
         }
        });
     $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).change(function() {

       var value = $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val();
       if (value == '<%=C_Hrkkeiro.KOUHURI.getValue()%>') {
           $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).removeAttr("disabled");
           setKouhurikouzaInfoKatusei();

           $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
                $(this).removeAttr("disabled");
           });
           $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");
       }
       else {
           $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
           $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).attr("disabled", "true");
           setKouhurikouzaInfoHikatusei();

           $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).val('<%=C_KzhuritourokuhouKbn.BLNK.getValue()%>');
           $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
              if ($(this).val() != 0) {
                  $(this).attr("disabled", "true");
              }
           });
           $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
       }

       if (value == "<%=C_Hrkkeiro.CREDIT.getValue()%>" ) {
           if ('<%=uiBean.getSkeijimuKbn() %>' == <%=C_SkeijimuKbn.SHOP.getValue()%>) {

               $(<%= FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO %>).val('<%= C_FstphrkkeiroKbn.CREDIT.getValue() %>');
               setFstphrkkeirokbnKatusei();
           }
           else {

               $(<%= FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO %>).val('<%= C_FstphrkkeiroKbn.HURIKOMI.getValue() %>');
               setFstphrkkeirokbnKatusei();
           }

           $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_IkkatubaraiKaisuuKbn.BLNK.getValue()%>');
           $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
                if ($(this).val() != 0) {
                    $(this).attr("disabled", "true");
                                 }
                });
           $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");
           $(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>).val("");
           setReadOnlyGray(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>);
           $(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>).val("");
           setReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
           $(<%=MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>).val("");
           setReadOnlyGray(<%=MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>);
           $(<%=MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>).val("");
           setReadOnlyGray(<%=MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>);
       }
       else {

           $(<%= FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO %>).val('<%= C_FstphrkkeiroKbn.HURIKOMI.getValue() %>');
           setFstphrkkeirokbnHikatusei();

           $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
              $(this).removeAttr("disabled");
           });
           $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
           removeReadOnlyGray(<%=MOSIKKATUP_SYUKEIYAKUHOSYOUINFOBEI%>);
           removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI_SYUKEIYAKUHOSYOUINFOBEI%>);
           removeReadOnlyGray(<%=MOSIKKATUP2_SYUKEIYAKUHOSYOUINFOGOU%>);
           removeReadOnlyGray(<%=MOSZENNOUPSYOKAIARI2_SYUKEIYAKUHOSYOUINFOGOU%>);
       }
       setHrktuukasyukykp();
     });

      $(<%= IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO %>).change(function() {
          setHrktuukasyukykp();
       });

     $(<%=TEIKISIHARAITKYKHKKBN_UKETORIKOUZAINFO%>).change(function() {
       var value = $(<%=TEIKISIHARAITKYKHKKBN_UKETORIKOUZAINFO%>).val();
       if (value == "<%=C_Tkhukaumu.HUKA.getValue()%>" ) {
          $(<%= SHKSTKZINFKZINFOINPUTHRY_UKETORIKOUZAINFO %>).removeAttr("disabled");
          setShkstkzinfkzinfoKatusei();
       }
        else {
          $(<%= SHKSTKZINFKZINFOINPUTHRY_UKETORIKOUZAINFO %>).removeAttr("checked");
          $(<%= SHKSTKZINFKZINFOINPUTHRY_UKETORIKOUZAINFO %>).attr("disabled", "true");
          setShkstkzinfkzinfoHikatusei();
       }
      });

      $("input[id^='shkstkzinfkzinfoinputhry']").change(function() {
         var value = $("input[id^='shkstkzinfkzinfoinputhry']:checked").val();
         if (value == 'true') {
             setShkstkzinfkzinfoHikatusei();
         }
          else {
             setShkstkzinfkzinfoKatusei();
         }
      });

      $(<%=KZSYURUIKBN_UKETORIKOUZAINFO%>).change(function() {
        var value = $(<%=KZSYURUIKBN_UKETORIKOUZAINFO%>).val();
        if (value == "<%=C_KouzasyuruiKbn.GAIKAKOUZA.getValue()%>" ) {
            $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).val('<%=C_KzkykdouKbn.SITEI.getValue()%>');
            $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
               if ($(this).val() != 2) {
                   $(this).attr("disabled", "true");
               }
            });
            $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).addClass("backgroundReadOnlyGray");

            $(<%=YOKINKBN_UKETORIKOUZAINFO%>).val('<%=C_YokinKbn.BLNK.getValue()%>');
            $(<%=YOKINKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
               if ($(this).val() != 0) {
                   $(this).attr("disabled", "true");
            }
            });
            $(<%=YOKINKBN_UKETORIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
         }
          else {
            $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
                $(this).removeAttr("disabled");
            });
            $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");

            $(<%=YOKINKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
               $(this).removeAttr("disabled");
            });
            $(<%=YOKINKBN_UKETORIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");
         }
      });
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>

    <%if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) { %>
       <%
          if (uiBean.getHubimsgData() != null && uiBean.getHubimsgData().length > 0) { %>
             $(<%= HUBISYOUSAIBTN_BUTTONHUBISYOUSAI %>).val("不備詳細（米）");
     <% } %>

      <%
         if (uiBean.getHubimsgData2()!= null && uiBean.getHubimsgData2().length > 0) { %>
           <%
             if (uiBean.getHubimsgData() == null ||  uiBean.getHubimsgData().length == 0) { %>
              $(<%= HUBISYOUSAIBTN_BUTTONHUBISYOUSAI %>).visible(false);
          <% } %>
      <% } else { %>
          $(<%= HUBISYOUSAIBTN2_BUTTONHUBISYOUSAI %>).visible(false);
      <% } %>
    <% } else { %>
       $(<%= HUBISYOUSAIBTN2_BUTTONHUBISYOUSAI %>).visible(false);
    <% } %>
  <% } %>


 function setKouhurikouzaInfoHikatusei() {

  setReadOnlyGray(<%=KOUHURIKOUZAINFOBANKCD_KOUHURIKOUZAINFO%>);
  $(<%=KOUHURIKOUZAINFOBANKCD_KOUHURIKOUZAINFO%>).val("");

  setReadOnlyGray(<%=KOUHURIKOUZAINFOSITENCD_KOUHURIKOUZAINFO%>);
  $(<%=KOUHURIKOUZAINFOSITENCD_KOUHURIKOUZAINFO%>).val("");

  $(<%=KOUHURIKOUZAINFOYOKINKBN_KOUHURIKOUZAINFO%>).val('<%=C_YokinKbn.BLNK.getValue()%>');
  $(<%=KOUHURIKOUZAINFOYOKINKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
    if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
   });
   $(<%=KOUHURIKOUZAINFOYOKINKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");

  setReadOnlyGray(<%=KOUHURIKOUZAINFOKOUZANO_KOUHURIKOUZAINFO%>);
  $(<%=KOUHURIKOUZAINFOKOUZANO_KOUHURIKOUZAINFO%>).val("");

  $(<%=KOUHURIKOUZAINFOKZDOUKBN_KOUHURIKOUZAINFO%>).val('<%=C_KzkykdouKbn.DOUITU.getValue()%>');
  $(<%=KOUHURIKOUZAINFOKZDOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
    if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
   });
   $(<%=KOUHURIKOUZAINFOKZDOUKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");

  setReadOnlyGray(<%=KOUHURIKOUZAINFOKZMEIGINMKN_KOUHURIKOUZAINFO%>);
  $(<%=KOUHURIKOUZAINFOKZMEIGINMKN_KOUHURIKOUZAINFO%>).val("");

  $(<%=KOUZAKAKUNINIRAIKBN_KOUHURIKOUZAINFO%>).val("0");
  $(<%=KOUZAKAKUNINIRAIKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
    if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
   });
   $(<%=KOUZAKAKUNINIRAIKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");
 }


 function setKouhurikouzaInfoKatusei() {
  removeReadOnlyGray(<%=KOUHURIKOUZAINFOBANKCD_KOUHURIKOUZAINFO%>);

  removeReadOnlyGray(<%=KOUHURIKOUZAINFOSITENCD_KOUHURIKOUZAINFO%>);

  $(<%=KOUHURIKOUZAINFOYOKINKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
  });
  $(<%=KOUHURIKOUZAINFOYOKINKBN_KOUHURIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");

  removeReadOnlyGray(<%=KOUHURIKOUZAINFOKOUZANO_KOUHURIKOUZAINFO%>);

  $(<%=KOUHURIKOUZAINFOKZDOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
  });
  $(<%=KOUHURIKOUZAINFOKZDOUKBN_KOUHURIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");

  removeReadOnlyGray(<%=KOUHURIKOUZAINFOKZMEIGINMKN_KOUHURIKOUZAINFO%>);

    $(<%=KOUZAKAKUNINIRAIKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
  });
  $(<%=KOUZAKAKUNINIRAIKBN_KOUHURIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");
 }

function setHrkkeiroAndIkkatubaraikaisuu (teikiikkatubaraiumu) {

   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_Hrkkeiro.HURIKAE.getValue()%>');
   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
    if ($(this).val() != '<%=C_Hrkkeiro.HURIKAE.getValue()%>') {
       $(this).attr("disabled", "true");
    } else {
       $(this).removeAttr("disabled");
    }
   });
   $(<%=HRKKEIRO_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");

   $(<%=KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO%>).removeAttr("checked");
   $(<%= KOUZAINFOINPUTHORYUU_KOUHURIKOUZAINFO %>).attr("disabled", "true");
   setKouhurikouzaInfoHikatusei();

   $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).val('<%=C_KzhuritourokuhouKbn.BLNK.getValue()%>');
   $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).find("option").each(function(){
      if ($(this).val() != 0) {
          $(this).attr("disabled", "true");
      }
   });
   $(<%=KZHURITOUROKUHOUKBN_KOUHURIKOUZAINFO%>).addClass("backgroundReadOnlyGray");

   if (teikiikkatubaraiumu == <%= C_UmuKbn.ARI.getValue() %>) {
      $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_IkkatubaraiKaisuuKbn.IKKATU12.getValue()%>');
      $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
        if ($(this).val() != '<%=C_IkkatubaraiKaisuuKbn.IKKATU12.getValue()%>') {
           $(this).attr("disabled", "true");
        }
      });
      $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");

      $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
           $(this).removeAttr("disabled");
      });
      $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
    } else {
       $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
          $(this).removeAttr("disabled");
       });
       $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");

       $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_Hrkkaisuu.NEN.getValue()%>');
       $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
         if ($(this).val() != '<%= C_Hrkkaisuu.NEN.getValue() %>'){
            $(this).attr("disabled", "true");
         }
       });
       $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");
    }
}

function setHrkkeiroAndIkkatubaraikaisuuEnable (teikiikkatubaraiumu) {
   if (teikiikkatubaraiumu == <%= C_UmuKbn.ARI.getValue() %>) {
      $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_IkkatubaraiKaisuuKbn.BLNK.getValue()%>');
      $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
      });
      $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");

      $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
           $(this).removeAttr("disabled");
      });
      $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
   } else {
      $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val('<%=C_Hrkkaisuu.BLNK.getValue()%>');
      $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
      });
      $(<%=HRKKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
   }
}

function setHrktuukasyukykp () {
    if (ptratkituukasiteikbn == 1) {
        setReadOnlyGray(<%=HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>);
        $(<%=HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val("");
        <% if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) { %>
              setReadOnlyGray(<%=HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>);
            $(<%=HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>).val("");
        <% } %>
    } else {
        var value = $(<%=IKKATUBARAIKAISUUMOSINPUT_SYUKEIYAKUHOSYOUINFO%>).val();
        if (value != '<%=C_IkkatubaraiKaisuuKbn.BLNK.getValue()%>') {
            setReadOnlyGray(<%=HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>);
            $(<%=HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>).val("");
            <% if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) { %>
                  setReadOnlyGray(<%=HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>);
                $(<%=HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>).val("");
            <% } %>
        } else {
            removeReadOnlyGray(<%=HRKTUUKASYUKYKP_SYUKEIYAKUHOSYOUINFOBEI%>);
            <% if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) { %>
                  removeReadOnlyGray(<%=HRKTUUKASYUKYKP2_SYUKEIYAKUHOSYOUINFOGOU%>);
            <% } %>
        }
    }
}

 function setFstphrkkeirokbnKatusei() {
  $(<%=FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
  });
  $(<%=FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO%>).removeClass("backgroundReadOnlyGray");
 }

 function setFstphrkkeirokbnHikatusei() {
  $(<%=FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO%>).find("option").each(function(){
    if ($(this).val() != 1) {
        $(this).attr("disabled", "true");
     }
   });
   $(<%=FSTPHRKKEIROKBN_SYUKEIYAKUHOSYOUINFO%>).addClass("backgroundReadOnlyGray");
 }

 function setShkstkzinfkzinfoHikatusei() {

  $(<%=KZSYURUIKBN_UKETORIKOUZAINFO%>).val('<%=C_KouzasyuruiKbn.BLNK.getValue()%>');
  $(<%=KZSYURUIKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
    if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
   });
  $(<%=KZSYURUIKBN_UKETORIKOUZAINFO%>).addClass("backgroundReadOnlyGray");

  setReadOnlyGray(<%=BANKCD_UKETORIKOUZAINFO%>);
  $(<%=BANKCD_UKETORIKOUZAINFO%>).val("");

  setReadOnlyGray(<%=SITENCD_UKETORIKOUZAINFO%>);
  $(<%=SITENCD_UKETORIKOUZAINFO%>).val("");

  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).val('<%=C_YokinKbn.BLNK.getValue()%>');
  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
    if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
   });
  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).addClass("backgroundReadOnlyGray");

  setReadOnlyGray(<%=KOUZANO_UKETORIKOUZAINFO%>);
  $(<%=KOUZANO_UKETORIKOUZAINFO%>).val("");

  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).val('<%=C_KzkykdouKbn.DOUITU.getValue()%>');
  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
    if ($(this).val() != 1) {
        $(this).attr("disabled", "true");
     }
   });
  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).addClass("backgroundReadOnlyGray");

  setReadOnlyGray(<%=KZMEIGINMKN_UKETORIKOUZAINFO%>);
  $(<%=KZMEIGINMKN_UKETORIKOUZAINFO%>).val("");

 }

 function setShkstkzinfkzinfoKatusei() {

  $(<%=KZSYURUIKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
  });
  $(<%=KZSYURUIKBN_UKETORIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");

  removeReadOnlyGray(<%=BANKCD_UKETORIKOUZAINFO%>);

  removeReadOnlyGray(<%=SITENCD_UKETORIKOUZAINFO%>);

  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
  });
  $(<%=YOKINKBN_UKETORIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");

  removeReadOnlyGray(<%=KOUZANO_UKETORIKOUZAINFO%>);

  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
  });
  $(<%=KZKYKDOUKBN_UKETORIKOUZAINFO%>).removeClass("backgroundReadOnlyGray");

  removeReadOnlyGray(<%=KZMEIGINMKN_UKETORIKOUZAINFO%>);

 }

function mousikomisyoChangeErrMsg(messageId,messageId1) {

  $('#hubisyousaibtn').before('<span id="errerMessageSpan" class="fontRed"></span>');
  var errMsg = '';
  var iconClass = '';
  if (messageId !="" && messageId1 !="") {
      messageId = String(messageId);
      firstStr = messageId.substr(0, 1);
      messageId1 = String(messageId1);
      firstStr1 = messageId1.substr(0, 1);

      if (firstStr == 'E' || firstStr == 'T' || firstStr1 == 'E' || firstStr1 == 'T') {
         errMsg = '不備情報があります！！&nbsp;&nbsp;詳細を確認してください。';
         iconClass = 'errIcon';
      }
      else if (firstStr == 'W' || firstStr1 == 'W') {
         errMsg = 'ワーニング情報があります。&nbsp;&nbsp;詳細を確認してください。';
         iconClass = 'warIcon';
      }
      else if (firstStr == 'K' || firstStr1 == 'K') {
         errMsg = '不備が特認されています。&nbsp;&nbsp;詳細を確認してください。';
         iconClass = 'tokuninkanouIcon';
      }
  } else {
    if (messageId !="" ) {
      messageId = String(messageId);
      firstStr = messageId.substr(0, 1);
      switch(firstStr) {
         case 'E':
         case 'T':
           errMsg = '不備情報があります！！&nbsp;&nbsp;詳細を確認してください。';
           iconClass = 'errIcon';
           break;
         case 'W':
           errMsg = 'ワーニング情報があります。&nbsp;&nbsp;詳細を確認してください。';
           iconClass = 'warIcon';
           break;
         case 'K':
           errMsg = '不備が特認されています。&nbsp;&nbsp;詳細を確認してください。';
           iconClass = 'tokuninkanouIcon';
           break;
       }
     }
     if (messageId1 !="" ) {
      messageId1 = String(messageId1);
      firstStr = messageId1.substr(0, 1);
      switch(firstStr) {
         case 'E':
         case 'T':
           errMsg = '不備情報があります！！&nbsp;&nbsp;詳細を確認してください。';
           iconClass = 'errIcon';
           break;
         case 'W':
           errMsg = 'ワーニング情報があります。&nbsp;&nbsp;詳細を確認してください。';
           iconClass = 'warIcon';
           break;
         case 'K':
           errMsg = '不備が特認されています。&nbsp;&nbsp;詳細を確認してください。';
           iconClass = 'tokuninkanouIcon';
           break;
       }
    }
  }

  if (errMsg != '') {
      $('#errerMessageSpan').html(errMsg);

      var hubisyousaiLabelObj = $('#hubisyousaibtn_label');
      hubisyousaiLabelObj.text('');
      hubisyousaiLabelObj.addClass(iconClass);
      hubisyousaiLabelObj.css('display', 'block');

      showGroup('#buttonHubisyousai');
    }
}
});
//-->
</script>