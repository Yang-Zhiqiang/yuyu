<%--
    si_bunkatu_siharai_keisan.js.jsp - 分割支払計算 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page
  import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
  import="static yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan.SiBunkatuSiharaiKeisanConstants.*"%>
<%@page
  import="static yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan.SiBunkatuSiharaiKeisanSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
  import="yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan.SiBunkatuSiharaiKeisanUiBean"%>
<% SiBunkatuSiharaiKeisanUiBean uiBean = SWAKInjector.getInstance(SiBunkatuSiharaiKeisanUiBean.class); %>
<%@page import="yuyu.def.classification.C_BunkatuHouhouKbn"%>
<%@page import="yuyu.def.classification.C_SiharaiTuukaKbn"%>
<%@page import="yuyu.def.classification.C_Tuukasyu"%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<script type="text/javascript"><!--
$(function(){

<% if (uiBean.getPageNo() == PAGENO_RESULT && !BizUtil.isBlank(uiBean.getResultTyouhyouKey())) {
      %>
       openReport('print', '_blank');
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

      uktrseigyo = function(selector){

        var sbuktrnin = $(<%=SBUKTNINMOJI_UKTRSETTEI%>).val();
        if (sbuktrnin == "") {
          sbuktrnin = 0;
        }
        value = selector.filter(':checked').val();
        <% for (int i = 0; i < uiBean.getUktrInfoDataSource().getAllData().size(); i++){ %>

          if (sbuktrnin >= <%=i + 1%>) {
            if(value == "<%= C_BunkatuHouhouKbn.KINTOUWARI.getValue() %>"){
              $(<%= UKTRWRAIBUNSI_UKTRINFO(i) %>).val("");
              setReadOnlyGray(<%=UKTRWRAIBUNSI_UKTRINFO(i)%>);
              $(<%= UKTRWRAIBUNBO_UKTRINFO(i) %>).val("");
              setReadOnlyGray(<%=UKTRWRAIBUNBO_UKTRINFO(i)%>);
            }
            else{
              removeReadOnlyGray(<%=UKTRWRAIBUNSI_UKTRINFO(i)%>);
              removeReadOnlyGray(<%=UKTRWRAIBUNBO_UKTRINFO(i)%>);
            }
          } else {
              $(<%= UKTRWRAIBUNSI_UKTRINFO(i) %>).val("");
              setReadOnlyGray(<%=UKTRWRAIBUNSI_UKTRINFO(i)%>);
              $(<%= UKTRWRAIBUNBO_UKTRINFO(i) %>).val("");
              setReadOnlyGray(<%=UKTRWRAIBUNBO_UKTRINFO(i)%>);
          }

       <% } %>
      };

      $(<%=RADIO_CHECKED%>).each(function(){
        uktrseigyo($(this));
      });

      $(<%=RADIO%>).click(function(){
        uktrseigyo($(this));
      });

      sbuuktrninSelect(<%= uiBean.getSbuktninint()%>);

      $(<%=SBUKTNINMOJI_UKTRSETTEI%>).change(function(){
        sbuuktrninSelect($(<%=SBUKTNINMOJI_UKTRSETTEI%>).val());
      });

<% } %>

 function sbuuktrninSelect(uktrinin) {

    var bunkatuhouhou = $(<%=RADIO%>).filter(':checked').val();

    <% for (int i = 0; i < uiBean.getUktrInfoDataSource().getAllData().size(); i++){ %>

      if (uktrinin >= <%=i + 1%>) {
        if ($(<%=SHRTAISYOU_UKTRINFO(i)%>).prop('disabled')) {
          $(<%=SHRTAISYOU_UKTRINFO(i)%>).prop('disabled', false);
          removeReadOnlyGray(<%=UKTRWRAIBUNSI_UKTRINFO(i)%>);
          removeReadOnlyGray(<%=UKTRWRAIBUNBO_UKTRINFO(i)%>);
          removeReadOnlyGray(<%=BNKTSBUKTNMKJ_UKTRINFO(i)%>);
        }
        if (bunkatuhouhou == "<%=C_BunkatuHouhouKbn.KINTOUWARI.getValue() %>") {
          $(<%= UKTRWRAIBUNSI_UKTRINFO(i) %>).val("");
          setReadOnlyGray(<%=UKTRWRAIBUNSI_UKTRINFO(i)%>);
          $(<%= UKTRWRAIBUNBO_UKTRINFO(i) %>).val("");
          setReadOnlyGray(<%=UKTRWRAIBUNBO_UKTRINFO(i)%>);
        }

       } else {
        if (!$(<%=SHRTAISYOU_UKTRINFO(i)%>).prop('disabled')) {
          $(<%=SHRTAISYOU_UKTRINFO(i)%>).prop('checked', false);
          $(<%=SHRTAISYOU_UKTRINFO(i)%>).prop('disabled', true);
          $(<%= UKTRWRAIBUNSI_UKTRINFO(i) %>).val("");
          setReadOnlyGray(<%=UKTRWRAIBUNSI_UKTRINFO(i)%>);
          $(<%= UKTRWRAIBUNBO_UKTRINFO(i) %>).val("");
          setReadOnlyGray(<%=BNKTSBUKTNMKJ_UKTRINFO(i)%>);
          $(<%= BNKTSBUKTNMKJ_UKTRINFO(i) %>).val("");
          setReadOnlyGray(<%=UKTRWRAIBUNBO_UKTRINFO(i)%>);
        }

       }
    <% } %>

 }

<%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
      $(<%=BNKTMAEGAIKAGOUKEI_LABEL%>).attr("rowspan","11");
      $(<%=BNKTMAEGAIKAGOUKEI_DATA%>).attr("rowspan","11");

      $(<%=BNKTMAEYENGOUKEI_LABEL%>).attr("rowspan","11");
      $(<%=BNKTMAEYENGOUKEI_DATA%>).attr("rowspan","11");

      $(<%=BNKTGOGAIKAGOUKEI_LABEL%>).attr("rowspan","11");
      $(<%=BNKTGOGAIKAGOUKEI_DATA%>).attr("rowspan","11");
      $(<%=BNKTGOYENGOUKEI_LABEL%>).attr("rowspan","11");
      $(<%=BNKTGOYENGOUKEI_DATA%>).attr("rowspan","11");

     <% for (int i = 1; i < uiBean.getSbuktninint() + 1; i++){ %>

         showGroup(<%= "'#bunkatuKeisanKekka" + i + "'"%>);

         <% if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) { %>
              showGroup(<%= "'#yenbunkatuKeisanKekka" + i + "'"%>);
         <% } else { %>
              showGroup(<%= "'#gkbunkatuKeisanKekka" + i + "'"%>);

             if (kingakuHiHyoujiChk("<%=uiBean.getYenkaBunkatuKekka().get(i).get(YEN_GOUKEI_BUNKATUKEY).toString()%>")) {
                showGroup(<%= "'#yenbunkatuKeisanKekka" + i + "'"%>);
              }
         <% } %>



         $(<%="'#gkbunkatuKeisanKekka" + i + " .gaikaknrgoukei" + i + "_label'" %>).attr("rowspan","11");
         $(<%="'#gkbunkatuKeisanKekka" + i + " .gaikaknrgoukei" + i + "_data'" %>).attr("rowspan","11");
         $(<%="'#yenbunkatuKeisanKekka" + i + " .yenkaknrgoukei" + i + "_label'" %>).attr("rowspan","11");
         $(<%="'#yenbunkatuKeisanKekka" + i + " .yenkaknrgoukei" + i + "_data'" %>).attr("rowspan","11");

         $(<%="'#bunkatuKeisanKekka" + i + "'" + LABEL%>).addClass('toggletitle');

         <% if (!uiBean.getUktrInfoDataSource().getDatas().get(i-1).getShrtaisyou()) { %>
           $(<%= "'#bunkatuKeisanKekka" + i + "'"%>).hide();
           $(<%= "'#gkbunkatuKeisanKekka" + i + "'"%>).hide();
           $(<%= "'#yenbunkatuKeisanKekka" + i + "'"%>).hide();
         <% } %>
     <% } %>

     var bnktkeissankekkaDispKbn1  = 1;
     var bnktkeissankekkaDispKbn2  = 1;
     var bnktkeissankekkaDispKbn3  = 1;
     var bnktkeissankekkaDispKbn4  = 1;
     var bnktkeissankekkaDispKbn5  = 1;
     var bnktkeissankekkaDispKbn6  = 1;
     var bnktkeissankekkaDispKbn7  = 1;
     var bnktkeissankekkaDispKbn8  = 1;
     var bnktkeissankekkaDispKbn9  = 1;
     var bnktkeissankekkaDispKbn10 = 1;
     var bnktkeissankekkaDispKbn11 = 1;
     var bnktkeissankekkaDispKbn12 = 1;
     var bnktkeissankekkaDispKbn13 = 1;
     var bnktkeissankekkaDispKbn14 = 1;
     var bnktkeissankekkaDispKbn15 = 1;

     var uketrjuni = <%= uiBean.getShrtaisyouuktrjuni()%>

     if (uketrjuni == 1) {
         bnktkeissankekkaDispKbn1 = 0;
     } else if (uketrjuni == 2) {
         bnktkeissankekkaDispKbn2 = 0;
     } else if (uketrjuni == 3) {
         bnktkeissankekkaDispKbn3 = 0;
     } else if (uketrjuni == 4) {
         bnktkeissankekkaDispKbn4 = 0;
     } else if (uketrjuni == 5) {
         bnktkeissankekkaDispKbn5 = 0;
     } else if (uketrjuni == 6) {
         bnktkeissankekkaDispKbn6 = 0;
     } else if (uketrjuni == 7) {
         bnktkeissankekkaDispKbn7 = 0;
     } else if (uketrjuni == 8) {
         bnktkeissankekkaDispKbn8 = 0;
     } else if (uketrjuni == 9) {
         bnktkeissankekkaDispKbn9 = 0;
     } else if (uketrjuni == 10) {
         bnktkeissankekkaDispKbn10 = 0;
     } else if (uketrjuni == 11) {
         bnktkeissankekkaDispKbn11 = 0;
     } else if (uketrjuni == 12) {
         bnktkeissankekkaDispKbn12 = 0;
     } else if (uketrjuni == 13) {
         bnktkeissankekkaDispKbn13 = 0;
     } else if (uketrjuni == 14) {
         bnktkeissankekkaDispKbn14 = 0;
     } else if (uketrjuni == 15) {
         bnktkeissankekkaDispKbn15 = 0;
     }

     $(<%= BUNKATUKEISANKEKKA1 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn1 == 0) {
         $(<%= BUNKATUKEISANKEKKA1%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA1%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA1%>).hide();
         bnktkeissankekkaDispKbn1 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA1%>).show();
         $(<%= GKBUNKATUKEISANKEKKA1%>).show();
         $(<%= YENBUNKATUKEISANKEKKA1%>).show();
         bnktkeissankekkaDispKbn1 = 0;
         }
       });

     $(<%= BUNKATUKEISANKEKKA2 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn2 == 0) {
         $(<%= BUNKATUKEISANKEKKA2%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA2%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA2%>).hide();
         bnktkeissankekkaDispKbn2 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA2%>).show();
         $(<%= GKBUNKATUKEISANKEKKA2%>).show();
         $(<%= YENBUNKATUKEISANKEKKA2%>).show();
         bnktkeissankekkaDispKbn2 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA3 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn3 == 0) {
         $(<%= BUNKATUKEISANKEKKA3%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA3%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA3%>).hide();
         bnktkeissankekkaDispKbn3 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA3%>).show();
         $(<%= GKBUNKATUKEISANKEKKA3%>).show();
         $(<%= YENBUNKATUKEISANKEKKA3%>).show();
         bnktkeissankekkaDispKbn3 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA4 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn4 == 0) {
         $(<%= BUNKATUKEISANKEKKA4%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA4%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA4%>).hide();
         bnktkeissankekkaDispKbn4 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA4%>).show();
         $(<%= GKBUNKATUKEISANKEKKA4%>).show();
         $(<%= YENBUNKATUKEISANKEKKA4%>).show();
         bnktkeissankekkaDispKbn4 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA5 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn5 == 0) {
         $(<%= BUNKATUKEISANKEKKA5%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA5%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA5%>).hide();
         bnktkeissankekkaDispKbn5 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA5%>).show();
         $(<%= GKBUNKATUKEISANKEKKA5%>).show();
         $(<%= YENBUNKATUKEISANKEKKA5%>).show();
         bnktkeissankekkaDispKbn5 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA6 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn6 == 0) {
         $(<%= BUNKATUKEISANKEKKA6%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA6%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA6%>).hide();
         bnktkeissankekkaDispKbn6 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA6%>).show();
         $(<%= GKBUNKATUKEISANKEKKA6%>).show();
         $(<%= YENBUNKATUKEISANKEKKA6%>).show();
         bnktkeissankekkaDispKbn6 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA7 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn7 == 0) {
         $(<%= BUNKATUKEISANKEKKA7%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA7%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA7%>).hide();
         bnktkeissankekkaDispKbn7 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA7%>).show();
         $(<%= GKBUNKATUKEISANKEKKA7%>).show();
         $(<%= YENBUNKATUKEISANKEKKA7%>).show();
         bnktkeissankekkaDispKbn7 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA8 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn8 == 0) {
         $(<%= BUNKATUKEISANKEKKA8%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA8%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA8%>).hide();
         bnktkeissankekkaDispKbn8 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA8%>).show();
         $(<%= GKBUNKATUKEISANKEKKA8%>).show();
         $(<%= YENBUNKATUKEISANKEKKA8%>).show();
         bnktkeissankekkaDispKbn8 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA9 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn9 == 0) {
         $(<%= BUNKATUKEISANKEKKA9%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA9%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA9%>).hide();
         bnktkeissankekkaDispKbn9 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA9%>).show();
         $(<%= GKBUNKATUKEISANKEKKA9%>).show();
         $(<%= YENBUNKATUKEISANKEKKA9%>).show();
         bnktkeissankekkaDispKbn9 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA10 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn10 == 0) {
         $(<%= BUNKATUKEISANKEKKA10%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA10%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA10%>).hide();
         bnktkeissankekkaDispKbn10 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA10%>).show();
         $(<%= GKBUNKATUKEISANKEKKA10%>).show();
         $(<%= YENBUNKATUKEISANKEKKA10%>).show();
         bnktkeissankekkaDispKbn10 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA11 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn11 == 0) {
         $(<%= BUNKATUKEISANKEKKA11%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA11%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA11%>).hide();
         bnktkeissankekkaDispKbn11 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA11%>).show();
         $(<%= GKBUNKATUKEISANKEKKA11%>).show();
         $(<%= YENBUNKATUKEISANKEKKA11%>).show();
         bnktkeissankekkaDispKbn11 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA12 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn12 == 0) {
         $(<%= BUNKATUKEISANKEKKA12%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA12%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA12%>).hide();
         bnktkeissankekkaDispKbn12 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA12%>).show();
         $(<%= GKBUNKATUKEISANKEKKA12%>).show();
         $(<%= YENBUNKATUKEISANKEKKA12%>).show();
         bnktkeissankekkaDispKbn12 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA13 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn13 == 0) {
         $(<%= BUNKATUKEISANKEKKA13%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA13%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA13%>).hide();
         bnktkeissankekkaDispKbn13 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA13%>).show();
         $(<%= GKBUNKATUKEISANKEKKA13%>).show();
         $(<%= YENBUNKATUKEISANKEKKA13%>).show();
         bnktkeissankekkaDispKbn13 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA14 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn14 == 0) {
         $(<%= BUNKATUKEISANKEKKA14%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA14%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA14%>).hide();
         bnktkeissankekkaDispKbn14 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA14%>).show();
         $(<%= GKBUNKATUKEISANKEKKA14%>).show();
         $(<%= YENBUNKATUKEISANKEKKA14%>).show();
         bnktkeissankekkaDispKbn14 = 0;
         }
       });

       $(<%= BUNKATUKEISANKEKKA15 + LABEL%>).click(function(){
       if (bnktkeissankekkaDispKbn15 == 0) {
         $(<%= BUNKATUKEISANKEKKA15%>).hide();
         $(<%= GKBUNKATUKEISANKEKKA15%>).hide();
         $(<%= YENBUNKATUKEISANKEKKA15%>).hide();
         bnktkeissankekkaDispKbn15 = 1;
         } else {
         $(<%= BUNKATUKEISANKEKKA15%>).show();
         $(<%= GKBUNKATUKEISANKEKKA15%>).show();
         $(<%= YENBUNKATUKEISANKEKKA15%>).show();
         bnktkeissankekkaDispKbn15 = 0;
         }
       });


     <% if (C_Tuukasyu.JPY.eq(uiBean.getSiKykSyouhn().getKyktuukasyu())) { %>
           $(<%=SHRKWSRATEKJNYMD_SHRINFOMATION%>).parent().parent().visible(false);
           $(<%=GAIKAKNSNKWSRATEKJYMD_SHRINFOMATION%>).parent().parent().visible(false);
     <% } else { %>
          if (!kingakuHiHyoujiChk("<%=uiBean.getBnktmaeyengoukei().toString()%>")) {
            $(<%=GAIKAKNSNKWSRATEKJYMD_SHRINFOMATION%>).parent().parent().visible(false);
          }
     <% } %>
     if (kingakuHiHyoujiChk("<%=uiBean.getBnktmaegaikagoukei().toString()%>")) {
       showGroup(<%=GAIKAKANRIBNKATUMAE%>);
     }

     if (kingakuHiHyoujiChk("<%=uiBean.getBnktmaeyengoukei().toString()%>")) {
       showGroup(<%=YENKANRIBNKATUMAE%>);
     }

     <% if (C_SiharaiTuukaKbn.YENSIHARAI.eq(uiBean.getSiharaituukakbn())) { %>
         showGroup(<%=YENKANRIBNKATUGO%>);
         $('#yentienrisokukisanymdPrefix').addClass('viewFirstCell');
         $('#yentienrsknissuuSuffix').addClass('viewFirstCell');
     <% } else { %>
         showGroup(<%=GAIKAKANRIBNKATUGO%>);
         $('#tienrisokukisanymdPrefix').addClass('viewFirstCell');
         $('#tienrsknissuuSuffix').addClass('viewFirstCell');
     <% } %>



 function kingakuHiHyoujiChk(kingaku) {

  if (kingaku == "0" || kingaku == "") {
    return false;
  }

  return true;
 }
<% } %>

});
//-->
</script>
