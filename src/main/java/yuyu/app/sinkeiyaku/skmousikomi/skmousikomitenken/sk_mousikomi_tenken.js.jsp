<%--
    sk_mousikomi_tenken.js.jsp - 申込点検 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken.SkMousikomiTenkenConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken.SkMousikomiTenkenSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken.SkMousikomiTenkenUiBean" %>
<%@page import="yuyu.def.classification.C_KouseiinkykKbn"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="yuyu.def.classification.C_BlnktkumuKbn"%>
<%@page import="yuyu.def.classification.C_KoukankykKbn"%>
<% SkMousikomiTenkenUiBean uiBean = SWAKInjector.getInstance(SkMousikomiTenkenUiBean.class); %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
<jsp:include
  page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp" />
<% } %>

<script type="text/javascript"><!--
$(function(){

    <%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

        changeKouseiinkykkbn(<%=KOUSEIINKYKKBN_KOUSEIINKYKINPUT%>);

        $(<%= KOUSEIINKYKKBN_KOUSEIINKYKINPUT %>).on('change', function(){
            changeKouseiinkykkbn(<%= KOUSEIINKYKKBN_KOUSEIINKYKINPUT%>);
        });

        changeKoukankykkbn(<%=KOUKANKYKKBN_KOUKANKYKINPUT%>);

        $(<%= KOUKANKYKKBN_KOUKANKYKINPUT %>).on('change', function(){
            changeKoukankykkbn(<%= KOUKANKYKKBN_KOUKANKYKINPUT%>);
        });

    <%
    } else if (uiBean.getPageNo() == PAGENO_RESULT) { %>
       <%
       String[] hubiMsgs = uiBean.getHubimsgData();%>
       <%
       String msgId = "";%>
       <%
       if (hubiMsgs != null && hubiMsgs.length != 0 && hubiMsgs[0].length() != 0) {
           String[] hubiMsg = hubiMsgs[0].split(" ");
           msgId = hubiMsg[1];
       }%>

       changeErrMsg('<%= msgId %>');

    <% } %>

    <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
        || uiBean.getPageNo() == PAGENO_CONFIRM
        || uiBean.getPageNo() == PAGENO_RESULT) { %>

        showList(<%=SKTORIATUKAITYUUIJOUHOU %>);

        <%
        if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
           <%
           if (C_UmuKbn.ARI.eq(uiBean.getKykdrtentsnsTumu())) { %>
                showKoumoku(<%= TKHSYOURYAKU_KAKUNINJIKOU %>);
         <% } %>

        <%
        } else{ %>
           <%
           if (C_UmuKbn.ARI.eq(uiBean.getKykdrtentsnsTumu())) { %>
                showKoumoku(<%= TKHSYOURYAKUUMUKBN_KAKUNINJIKOU %>);
        <% } %>
     <% } %>

     <%
        if (C_UmuKbn.ARI.eq(uiBean.getAeoiTaisyouUmu())) { %>
            showKoumoku(<%= AEOIKEKKAKBN_KAKUNINJIKOU %>);
     <% } %>

     <%if (IMUSATEIIRAIFLG_ARI.equals(uiBean.getImusateiiraiFlg())) { %>
         $(<%=IMUSATEIKEKKAKBN_IMUSATEIIRAI%>).visible(true);
         $(<%=IMUSATEIIRAICOMMENT_IMUSATEIIRAI%>).visible(true);
     <% } %>

     <%if (GAMENHOUJIFLG_ARI.equals(uiBean.getKoureisyaTaiouFlg())) { %>
           showKoumoku(<%= KOUREITAIOUKBN_KAKUNINJIKOU %>);
     <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
     <% if (uiBean.getKetteiHoryuuHubiDataSource().getAllData().size() != 0) { %>
       showGroup(<%=KETTEIHORYUUHUBI%>);
       <% for(int i = 0; i < uiBean.getKetteiHoryuuHubiDataSource().getAllData().size(); i++ ){ %>
       dispMessageIcon(<%= DISPHUBIMSGID_KETTEIHORYUUHUBI(i) %>, <%= MSGSYUBETU_KETTEIHORYUUHUBI(i) %>);
       <% } %>
     <% } %>

     <% if (uiBean.getSeirituHoryuuHubiDataSource().getAllData().size() != 0) { %>
       showGroup(<%=SEIRITUHORYUUHUBI%>);
       <% for(int i = 0; i < uiBean.getSeirituHoryuuHubiDataSource().getAllData().size(); i++ ){ %>
       dispMessageIcon(<%= DISPHUBIMSGID_SEIRITUHORYUUHUBI(i) %>, <%= MSGSYUBETU_SEIRITUHORYUUHUBI(i) %>);
       <% } %>
     <% } %>

     <% if (uiBean.getWarningDataSource().getAllData().size() != 0) { %>
       showGroup(<%=WARNING%>);
       <% for(int i = 0; i < uiBean.getWarningDataSource().getAllData().size(); i++ ){ %>
       dispMessageIcon(<%= DISPHUBIMSGID_WARNING(i) %>, <%= MSGSYUBETU_WARNING(i) %>);
       <% } %>
     <% } %>

     <% if (uiBean.getKihonHubiDataSource().getAllData().size() != 0) { %>
       showGroup(<%=KIHONHUBI%>);
       <% for(int i = 0; i < uiBean.getKihonHubiDataSource().getAllData().size(); i++ ){ %>
       dispMessageIcon(<%= DISPHUBIMSGID_KIHONHUBI(i) %>, <%= MSGSYUBETU_KIHONHUBI(i) %>);
       <% } %>
     <% } %>
      $(".msgsyubetu_data").text("");
 <% } %>

      $("<%=DISPMOSTENKENSYORIYMD_LABEL %>").each(
              function(){
                $(this).css("width", "8%");
              }
          );

       $("<%=DISPMOSTNKNSTKTSYORINMKBN_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
          );

       $("<%=DISPMOSTENKENKEKKAKBN_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
        );

       $("<%=DISPMOSTENKENKTNM_LABEL %>").each(
              function(){
                $(this).css("width", "19%");
              }
          );

       $("<%=DISPMOSTENKENCOMMENT_LABEL %>").each(
              function(){
                $(this).css("width", "43%");
              }
       );

        $("<%=DISPSKEITTDKTYUITRTTRKYMD_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
          );

       $("<%=DISPSKEITTDKTYUITRTNAIYO_LABEL %>").each(
              function(){
                $(this).css("width", "65%");
              }
          );

       $("<%=DISPSKEITTDKTYUITRTTANTOU_LABEL %>").each(
              function(){
                $(this).css("width", "20%");
              }
        );

        $("<%=DISPKNKSYORIYMD_LABEL %>").each(
              function(){
                $(this).css("width", "8%");
              }
          );

       $("<%=DISPKNKSTKTSYORINMKBN_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
          );

       $("<%=DISPKNKKEKKAKBN_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
        );

       $("<%=DISPKNKKTNM_LABEL %>").each(
              function(){
                $(this).css("width", "19%");
              }
          );

       $("<%=DISPKNKCOMMENT_LABEL %>").each(
              function(){
                $(this).css("width", "43%");
              }
       );

        $("<%=DISPIMUSYORIYMD_LABEL %>").each(
              function(){
                $(this).css("width", "8%");
              }
          );

       $("<%=DISPIMUSTKTSYORINMKBN_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
          );

       $("<%=DISPIMUKEKKAKBN_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
        );

       $("<%=DISPIMUKTNM_LABEL %>").each(
              function(){
                $(this).css("width", "19%");
              }
          );

       $("<%=DISPIMUCOMMENT_LABEL %>").each(
              function(){
                $(this).css("width", "43%");
              }
       );

  <% } %>

<%
   if (uiBean.getPageNo() == PAGENO_RESULT) { %>
     <%
     if (uiBean.getTyouhyouKey() != null && uiBean.getTyouhyouKey().length() > 0) { %>
          openReport("print", "_blank");
   <% } %>
<% } %>

function changeKouseiinkykkbn(kouseiinkykkbn){
  var value = $(kouseiinkykkbn).val();
  if ( value == "<%=C_KouseiinkykKbn.BLNK.getValue()%>"
      || value == "<%=C_KouseiinkykKbn.GAITOUNASI.getValue()%>") {

      $(<%=KOUSEIINKYKTKJKUMUKBN_KOUSEIINKYKINPUT + SPAN%>).find("input[class^='radio']").attr("disabled", "disabled");
      $("#ui:040kouseiinkyktkjkumukbn").val("");
      $("input[id^='kouseiinkyktkjkumukbn']").removeAttr("checked");

  } else {
      $(<%=KOUSEIINKYKTKJKUMUKBN_KOUSEIINKYKINPUT + SPAN%>).find("input[class^='radio']").removeAttr("disabled");
  }

}

function changeKoukankykkbn(koukankykkbn){
  var value = $(koukankykkbn).val();
  if ( value == "<%=C_KoukankykKbn.BLNK.getValue()%>"
      || value == "<%=C_KoukankykKbn.GAITOUNASI.getValue()%>") {

      $(<%=KOUKANKYKTKJKUMUKBN_KOUKANKYKINPUT + SPAN%>).find("input[class^='radio']").attr("disabled", "disabled");
      $("#ui:080koukankyktkjkumukbn").val("");
      $("input[id^='koukankyktkjkumukbn']").removeAttr("checked");

      setReadOnlyGray(<%=KOUKANKYKKINMUSAKINM_KOUKANKYKINPUT%>);

      $(<%=KOUKANKYKKINMUSAKINM_KOUKANKYKINPUT%>).val('');
      setReadOnlyGray(<%=KOUKANKYKSYOKUMUNAIYOU_KOUKANKYKINPUT%>);

      $(<%=KOUKANKYKSYOKUMUNAIYOU_KOUKANKYKINPUT%>).val('');
  } else {
      $(<%=KOUKANKYKTKJKUMUKBN_KOUKANKYKINPUT + SPAN%>).find("input[class^='radio']").removeAttr("disabled");
      removeReadOnlyGray(<%=KOUKANKYKKINMUSAKINM_KOUKANKYKINPUT%>);

      removeReadOnlyGray(<%=KOUKANKYKSYOKUMUNAIYOU_KOUKANKYKINPUT%>);
  }
}

function dispMessageIcon(msgId, target) {
    if($(msgId).text().substring(0, 1) == "I") {
        $(target).parent().addClass("infIcon");

    } else if($(msgId).text().substring(0, 1) == "W") {
        $(target).parent().addClass("warIcon");

    } else if($(msgId).text().substring(0, 1) == "E") {
        if($(msgId).text().substring(2, 3) == "V") {
            $(target).parent().addClass("valIcon");

        } else {
            $(target).parent().addClass("errIcon");
        }

    } else if($(msgId).text().substring(0, 1) == "T") {
        $(target).parent().addClass("tokuninIcon");

    } else if($(msgId).text().substring(0, 1) == "K") {
        $(target).parent().addClass("tokuninkanouIcon");

    } else if($(msgId).text().substring(0, 1) == "Q") {
        $(target).parent().addClass("inqIcon");
    }
}

});
//-->
</script>
