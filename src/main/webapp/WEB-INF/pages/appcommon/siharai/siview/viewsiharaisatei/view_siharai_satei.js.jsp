<%--
    view_siharai_satei.js.jsp - 支払査定 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.def.classification.C_SinsaGendoKknKbn" %>
<%@page import="yuyu.def.classification.C_HushrGeninKbn" %>
<%@page import="yuyu.def.classification.C_SindansyoRyouShrYouhiKbn" %>
<%@page import="yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsiharaisatei/view_siharai_satei.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSiharaiSateiUiBeanParam viewSiharaiSateiUiBean = (ViewSiharaiSateiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewSiharaiSateiUiBean.isViewSiharaiSateiInputDispFlg()) { %>
    hokenkinSyuruiSeigyo();

    viewSiharaiSateiHyoujiSeigyo();

    <%
      if (viewSiharaiSateiUiBean.isKinouModeSisateiitijiSeigyo()) { %>

       <%
       if (C_SyorikekkaKbn.HUSIHARAI.eq(viewSiharaiSateiUiBean.getSyorikekkakbn())) { %>
          setViewSiharaiSateiKatusei();

          $(<%= SINDANSYORYOUSHRYOUHI_VIEWSIHARAISATEIINFO %>).removeAttr("disabled");
       <% } %>
       <%
       if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(viewSiharaiSateiUiBean.getSyorikekkakbn())) { // %>
          setViewSiharaiSateiKatusei();

          $(<%= SINDANSYORYOUSHRYOUHI_VIEWSIHARAISATEIINFO %>).attr("disabled", "true");
          $("#ui:0r1sindansyoryoushryouhi").val("");
          $(<%=SINDANSYORYOUSHRYOUHI_VIEWSIHARAISATEIINFO%>).removeAttr("checked");
       <% } %>

       <%
       if (!C_SyorikekkaKbn.HUSIHARAI.eq(viewSiharaiSateiUiBean.getSyorikekkakbn()) &&
           !C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(viewSiharaiSateiUiBean.getSyorikekkakbn())) { // %>
          setViewSiharaiSateiHikatusei();
       <% } %>

       <%
         if (C_SinsaGendoKknKbn.BD5.eq(viewSiharaiSateiUiBean.getSinsagendokknkbn())) { // %>
            setRikoukityuutuudannissuuHikatusei();
       <% } %>

       $(<%=SYORIKEKKAKBN_VIEWSIHARAISATEIINFO%>).change( function() {
           var value = $(<%=SYORIKEKKAKBN_VIEWSIHARAISATEIINFO%>).val();
           if ( value == "<%=C_SyorikekkaKbn.HUSIHARAI.getValue()%>" ) {
              setViewSiharaiSateiKatusei();

              $(<%= SINDANSYORYOUSHRYOUHI_VIEWSIHARAISATEIINFO %>).removeAttr("disabled");
           }

           if ( value == "<%=C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.getValue()%>" ) {
              setViewSiharaiSateiKatusei();

              $(<%= SINDANSYORYOUSHRYOUHI_VIEWSIHARAISATEIINFO %>).attr("disabled", "true");
              $("#ui:0r1sindansyoryoushryouhi").val("");
              $(<%=SINDANSYORYOUSHRYOUHI_VIEWSIHARAISATEIINFO%>).removeAttr("checked");
           }
           if (value != "<%=C_SyorikekkaKbn.HUSIHARAI.getValue()%>" &&
               value != "<%=C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.getValue()%>") {
              setViewSiharaiSateiHikatusei();
           }
        });
       $(<%=SINSAGENDOKKNKBN_VIEWSIHARAISATEIINFO%>).change( function() {
           var value = $(<%=SINSAGENDOKKNKBN_VIEWSIHARAISATEIINFO%>).val();
           if ( value == "<%=C_SinsaGendoKknKbn.BD5.getValue()%>" ) {
               setRikoukityuutuudannissuuHikatusei();
           } else {
               setRikoukityuutuudannissuuKatusei();
           }
        });
     <%
     } else { %>
     <%
     if (!C_SyorikekkaKbn.HUSIHARAI.eq(viewSiharaiSateiUiBean.getSatei1Syorikekkakbn()) &&
         !C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(viewSiharaiSateiUiBean.getSatei1Syorikekkakbn())) { %>
          $(<%=HUSHRGENINKBN_VIEWSIHARAISATEIINFO%>).parent().parent().visible(false);
          $(<%=SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO%>).parent().parent().visible(false);
     <% } %>
    <% } %>
  <%
  } else { %>
     hokenkinSyuruiSeigyo();

     viewSiharaiSateiHyoujiSeigyo();

     <%
     if (!C_SyorikekkaKbn.HUSIHARAI.eq(viewSiharaiSateiUiBean.getSyorikekkakbn()) &&
         !C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(viewSiharaiSateiUiBean.getSyorikekkakbn())) { %>
          $(<%=HUSHRGENINKBN_VIEWSIHARAISATEIINFO%>).parent().parent().visible(false);
          $(<%=SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO%>).parent().parent().visible(false);
     <% } %>
  <% } %>


function hokenkinSyuruiSeigyo() {
    <%
    if (!viewSiharaiSateiUiBean.isViewSiharaiSateiHokenkinSyuruiDispFlg()) { %>
        $(<%=HOKENKINSYURUI_VIEWSIHARAISATEIINFO%>).parent().parent().visible(false);
    <% } %>
}

function viewSiharaiSateiHyoujiSeigyo() {
   var viewSiharaiSateiDispKbn = 0;
   <%
   if (viewSiharaiSateiUiBean.isViewSiharaiSateiSeigyo()) { %>
       $(<%=VIEWSIHARAISATEIINFO + LABEL%>).addClass('toggletitle');

       <%
       if (viewSiharaiSateiUiBean.isViewSiharaiSateiDispFlg()) { %>
           $(<%= VIEWSIHARAISATEIINFO%>).show();
       <%
       } else { %>
           $(<%= VIEWSIHARAISATEIINFO%>).hide();
           viewSiharaiSateiDispKbn = 1;
       <% } %>

       $(<%= VIEWSIHARAISATEIINFO + LABEL%>).click(function(){
           if (viewSiharaiSateiDispKbn == 0) {
               $(<%= VIEWSIHARAISATEIINFO%>).hide();
               viewSiharaiSateiDispKbn = 1;
           } else {
               $(<%= VIEWSIHARAISATEIINFO%>).show();
               viewSiharaiSateiDispKbn = 0;
           }
       });
 <% } %>
}

function setViewSiharaiSateiHikatusei () {
    $(<%=HUSHRGENINKBN_VIEWSIHARAISATEIINFO%>).val("0");
    $(<%=HUSHRGENINKBN_VIEWSIHARAISATEIINFO%>).find("option").each(function(){
     if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
    });
    $(<%=HUSHRGENINKBN_VIEWSIHARAISATEIINFO%>).addClass("backgroundReadOnlyGray");

    $(<%=SESSYOUYHKBN_VIEWSIHARAISATEIINFO%>).val("0");
    $(<%=SESSYOUYHKBN_VIEWSIHARAISATEIINFO%>).find("option").each(function(){
     if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
    });
    $(<%=SESSYOUYHKBN_VIEWSIHARAISATEIINFO%>).addClass("backgroundReadOnlyGray");

    setReadOnlyGray(<%=SESSYOUSISYACD_VIEWSIHARAISATEIINFO%>);
    $(<%=SESSYOUSISYACD_VIEWSIHARAISATEIINFO%>).val("");

    $(<%=SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO%>).val("0");
    $(<%=SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO%>).find("option").each(function(){
     if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
     }
    });
    $(<%=SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO%>).addClass("backgroundReadOnlyGray");

    $(<%= SINDANSYORYOUSHRYOUHI_VIEWSIHARAISATEIINFO %>).attr("disabled", "true");
    $("#ui:0r1sindansyoryoushryouhi").val("");
    $(<%=SINDANSYORYOUSHRYOUHI_VIEWSIHARAISATEIINFO%>).removeAttr("checked");
}

function setRikoukityuutuudannissuuHikatusei () {
    $(<%=RIKOUKITYUUTUUDANNISSUU_VIEWSIHARAISATEIINFO%>).val("");
    setReadOnlyGray(<%=RIKOUKITYUUTUUDANNISSUU_VIEWSIHARAISATEIINFO%>);
}

function setViewSiharaiSateiKatusei () {
  $(<%=HUSHRGENINKBN_VIEWSIHARAISATEIINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
  });
  $(<%=HUSHRGENINKBN_VIEWSIHARAISATEIINFO%>).removeClass("backgroundReadOnlyGray");

  $(<%=SESSYOUYHKBN_VIEWSIHARAISATEIINFO%>).find("option").each(function(){
     $(this).removeAttr("disabled");
  });
  $(<%=SESSYOUYHKBN_VIEWSIHARAISATEIINFO%>).removeClass("backgroundReadOnlyGray");

  removeReadOnlyGray(<%=SESSYOUSISYACD_VIEWSIHARAISATEIINFO%>);

  $(<%=SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO%>).find("option").each(function(){
     $(this).removeAttr("disabled");
  });
  $(<%=SAIGAIMOUSIDEUMUKBN_VIEWSIHARAISATEIINFO%>).removeClass("backgroundReadOnlyGray");
}

function setRikoukityuutuudannissuuKatusei () {
    removeReadOnlyGray(<%=RIKOUKITYUUTUUDANNISSUU_VIEWSIHARAISATEIINFO%>);
}
});

</script>
