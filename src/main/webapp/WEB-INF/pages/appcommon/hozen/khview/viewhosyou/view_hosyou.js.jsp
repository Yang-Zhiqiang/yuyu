<%--
    view_hosyou.js.jsp - 保障内容表示 JavaScript(JSP)
--%>
<%@page import="jp.co.slcs.swak.date.BizDate"%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewhosyou.ViewHosyouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewhosyou.ViewHosyouUiBeanParam" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_Htnpkkn" %>
<%@page import="yuyu.def.classification.C_TokkoudosghtnpKbn" %>
<%@page import="yuyu.def.classification.C_PmnjtkKbn" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_KhnkyhkgbairituKbn" %>
<%@page import="yuyu.def.classification.C_SyukyhkinkataKbn" %>
<%@page import="yuyu.def.classification.C_6daiLdKbn" %>
<%@page import="yuyu.def.classification.C_Tkjyskgnkkn" %>
<%@page import="yuyu.def.classification.C_KataKbn" %>
<%@page import="yuyu.def.classification.C_KyhgndkataKbn" %>
<%@page import="yuyu.def.classification.C_HknKknKbn" %>
<%@page import="yuyu.def.classification.C_KihonssyuruiKbn"%>
<%@page import="yuyu.def.classification.C_Tuukasyu"%>
<%@page import="yuyu.def.classification.C_KihonssyuruiKbn"%>
<%@page import="yuyu.def.classification.C_YendthnkJyoutaiKbn"%>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil"%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.common.biz.bzcommon.BizDateUtil"%>
<%@page import="jp.co.slcs.swak.number.BizCurrency"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewhosyou/view_hosyou.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>
<%
   ViewHosyouUiBeanParam viewHosyouUiBean = (ViewHosyouUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

function varElmAddTopBottomLink(idSelecterList){
    var groupSelecter = idSelecterList.join(',');
    var targetId = $(groupSelecter).filter(':visible').last().attr('id');
    addTopBottomLink('#' + targetId);
}

function setKihonsLayout(selector){
   var spanCount;
   var value = "";
   spanCount = selector.find("span").size();

   for (i = 0; i < spanCount; i++) {
        if (i != spanCount -1 && i != spanCount -3) {
            value = value + selector.find("span").eq(i).text();
            selector.find("span").eq(i).text("");
        }
   }
   selector.find("span").eq(spanCount-2).text(value);
   selector.find("span").eq(spanCount-2).addClass("paddingLeft");
}

$(function(){

var layoutFlg = false;

<%
    if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyukatakbn())){
%>
      showKoumoku(<%=VHSYUSYUKATAKBN_HOSYOUINFO%>);
<%}%>

<%
    if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyukyhgndkatakbn())){
%>
      showKoumoku(<%=VHSYUSYUKYHGNDKATAKBN_HOSYOUINFO%>);
<%}%>

<%
    if(viewHosyouUiBean.getVhsyusyufktsknnkaisiymd() != null){
%>
      showKoumoku(<%=VHSYUSYUFKTSKNNKAISIYMD_HOSYOUINFO%>);
<%}%>

<%
    if(viewHosyouUiBean.getVhsyugansknnkaisiymd() != null){
%>
      showKoumoku(<%=VHSYUGANSKNNKAISIYMD_HOSYOUINFO%>);
<%}%>

<%
    if(viewHosyouUiBean.getVhsyuhkgogansknnkaisiymd() != null){
%>
      showKoumoku(<%=VHSYUHKGOGANSKNNKAISIYMD_HOSYOUINFO%>);
<%}%>

<%
if(C_YendthnkJyoutaiKbn.YENDTHNKZUMI.eq(viewHosyouUiBean.getVhsyuyendthnkjyoutaikbn())){ %>
  showKoumoku(<%=VHSYUYENDTHNKYMD_HOSYOUINFO%>);
<%}%>

<%
    if(C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyuitijibrumu()) && C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyunkhknumu())){
%>
    $(<%=VHSYUSYUHKNKKN_HOSYOUINFO + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
<%}%>

<%
 if(C_KihonssyuruiKbn.KIJYUNKIN.eq(viewHosyouUiBean.getVhsyusyukihonssyuruikbn())) { %>
   $(<%=VHSYUSYUKIHONSSYURUIKBN_HOSYOUINFO + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW1006) %>');
<%}%>

 <%
 if (!viewHosyouUiBean.getVhsyusyup().isZeroOrOptional()) { %>
   showKoumoku(<%=VHSYUSYUP_HOSYOUINFO %>);
 <% } %>
 <%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyumvatekiumu())) { %>
   showKoumoku(<%=VHSYUKYKSJKKKTYOUSEIRIRITU_HOSYOUINFO %>);
   showKoumoku(<%=VHSYUSKISJKKKTYOUSEIRIRITU_HOSYOUINFO %>);
 <% } %>

 <%
    if(C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyuitijibrumu())){ %>
       <%
          if(C_YendthnkJyoutaiKbn.BLNK.eq(viewHosyouUiBean.getVhsyuyendthnkjyoutaikbn())){ %>
             <%
                if(C_KihonssyuruiKbn.KIJYUNKIN.eq(viewHosyouUiBean.getVhsyusyukihonssyuruikbn())){ %>
                   showKoumoku(<%=VHSYUSYUKYKKJNKNGK_HOSYOUINFO%>);
                   $(<%=VHSYUSYUKYKKJNKNGK_HOSYOUINFO + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW1016)%>');
             <%
                } else { %>
                   showKoumoku(<%=VHSYUSYUKYKKJNKNGK_HOSYOUINFO %>);
             <% } %>
       <% } %>
 <%
    } else { %>
        <%
           if (viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) { %>
              showKoumoku(<%=VHSYUSYUKYKKJNKNGK_HOSYOUINFO %>);
        <%
           } else if (viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) { %>
              showKoumoku(<%=VHSYUSYUKYKKJNKNGK_HOSYOUINFO %>);
              $(<%=VHSYUSYUKYKKJNKNGK_HOSYOUINFO + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW1017)%>');
        <% } %>
 <% } %>

<%
 if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyukhnkyhkgbairitukbn())) { %>
   showKoumoku(<%=VHSYUSYUKIHONKYHGK_HOSYOUINFO %>);
   <%
   if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyunextkosumu())) { %>
     $(<%=VHSYUSYUKIHONKYHGK_HOSYOUINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
   <% } %>
<% } %>

<%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyunextkosumu())) { %>
   showKoumoku(<%=VHSYUSYUNEXTKOSGOP_HOSYOUINFO %>);
   <%
   if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyukhnkyhkgbairitukbn())) { %>
     $(<%=VHSYUSYUNEXTKOSGOP_HOSYOUINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
   <% } %>
 <% } %>

<%
 if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyusyukyhkinkatakbn())) { %>
   showKoumoku(<%=VHSYUSYUSYUKYHKINKATAKBN_HOSYOUINFO %>);
   <%
    if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyurokudaildkbn())) { %>
      $(<%=VHSYUSYUSYUKYHKINKATAKBN_HOSYOUINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
  <% } %>
<% } %>

<%
 if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyurokudaildkbn())) { %>
   showKoumoku(<%=VHSYUSYUROKUDAILDKBN_HOSYOUINFO %>);
   <%
   if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyusyukyhkinkatakbn())) { %>
        $(<%=VHSYUSYUROKUDAILDKBN_HOSYOUINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
   <% } %>
<% } %>

<%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyugannyukyhumu())) { %>
  showKoumoku(<%=VHSYUSYUGANNYUKYHNTGK_HOSYOUINFO %>);
<% } %>

<%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyusndkyhkinshrskgnumu())) { %>
   showKoumoku(<%=VHSYUSYUSHRSKGNSTARTYMD_HOSYOUINFO %>);
   <%
   if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyutsnshrgndhjumu())) { %>
     $(<%=VHSYUSYUSHRSKGNGOS_HOSYOUINFO %>).text("");
   <%
   } else { %>
     $(<%=VHSYUSYUSHRSKGNGOS_HOSYOUINFO %>).parent().find("span").eq(6).text("");
     $(<%=VHSYUSYUSHRSKGNENDYMD_HOSYOUINFO + SUFFIX%>).addClass('innerCenterViewHosyou2');
   <% } %>
<% } %>

<%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyunkhknumu())) { %>
   showKoumoku(<%=VHSYUSYUNKSHRSTARTYMD_HOSYOUINFO %>);
   showKoumoku(<%=VHSYUSYUNNKINSYUKBN_HOSYOUINFO %>);
   showKoumoku(<%=VHSYUSYUNENKINKKN_HOSYOUINFO %>);

<% } %>

   <%
   if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyugenzaikngkhyjfukaumu()) &&
       C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyuitijibrumu())) { %>

      showKoumoku(<%=VHSYUGENZAITMTTKNGK_HOSYOUINFO %>);

         <%
         if ((viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
              viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
              C_YendthnkJyoutaiKbn.BLNK.eq(viewHosyouUiBean.getVhsyuyendthnkjyoutaikbn())) { %>
            showKoumoku(<%=VHSYUTEIRITUTMTTKNGK_HOSYOUINFO %>);
            showKoumoku(<%=VHSYUTEIRITUTMTTRATE_HOSYOUINFO %>);
            showKoumoku(<%=VHSYUSISUURENDOUTMTTKNGK_HOSYOUINFO %>);
            showKoumoku(<%=VHSYUSISUURENDOURATE_HOSYOUINFO %>);
         <% } %>
   <% } %>

<%
 if ((viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
      viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
      C_YendthnkJyoutaiKbn.BLNK.eq(viewHosyouUiBean.getVhsyuyendthnkjyoutaikbn())) { %>
   showKoumoku(<%=VHSYUSISUUNM_HOSYOUINFO %>);
<% } %>

<%
 if (viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
     C_YendthnkJyoutaiKbn.BLNK.eq(viewHosyouUiBean.getVhsyuyendthnkjyoutaikbn())) { %>
   showKoumoku(<%=VHSYUSETTEIBAIRITU_HOSYOUINFO %>);
   $(<%= VHSYUSETTEIBAIRITU_HOSYOUINFO %>).text($(<%= VHSYUSETTEIBAIRITU_HOSYOUINFO %>).text() + " 倍")
<% } %>

<%
 if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyuitijibrumu()) ||
     (viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
     C_YendthnkJyoutaiKbn.BLNK.eq(viewHosyouUiBean.getVhsyuyendthnkjyoutaikbn()))) { %>
   showKoumoku(<%=VHSYUYOTEIRIRITU_HOSYOUINFO %>);
<% } %>

<%
 if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyusyutkjyskgnkkn())) { %>
   showKoumoku(<%=VHSYUSYUTKJYSKGNKKN_HOSYOUINFO %>);
   showKoumoku(<%=VHSYUSYUTKJYSKGNHKNDSYMD1_HOSYOUINFO %>);

   <%
    if (viewHosyouUiBean.getVhsyusyutkjyskgnhkndsymd2() != null) {%>
      showKoumoku(<%=VHSYUSYUTKJYSKGNHKNDSYMD2_HOSYOUINFO %>);
   <% } %>

   <%
   if (viewHosyouUiBean.getVhsyusyutkjyskgnhkndsymd3() != null) {%>
      showKoumoku(<%=VHSYUSYUTKJYSKGNHKNDSYMD3_HOSYOUINFO %>);
   <% } %>

   <%
    if (viewHosyouUiBean.getVhsyusyutkjyskgnhkndsymd4() != null) {%>
      showKoumoku(<%=VHSYUSYUTKJYSKGNHKNDSYMD4_HOSYOUINFO %>);
   <% } %>

   <%
    if (viewHosyouUiBean.getVhsyusyutkjyskgnhkndsymd5() != null) {%>
      showKoumoku(<%=VHSYUSYUTKJYSKGNHKNDSYMD5_HOSYOUINFO %>);
   <% } %>
<% } %>

<%
 if (viewHosyouUiBean.getVhsyusyutkjyp() != null &&
     viewHosyouUiBean.getVhsyusyutkjyp().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyusyutkjyp().getType())) != 0) { %>
   showKoumoku(<%=VHSYUSYUTKJYHYOUTEN_HOSYOUINFO %>);
<% } %>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyusyuhtnpbuicd1()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyusyuhtnpkkn1())) { %>
    showKoumoku(<%=VHSYUSYUHTNPBUICD1_HOSYOUINFO %>);
    showKoumoku(<%=VHSYUSYUHTNPKKN1_HOSYOUINFO %>);
<% } %>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyusyuhtnpbuicd2()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyusyuhtnpkkn2())) { %>
    showKoumoku(<%=VHSYUSYUHTNPBUICD2_HOSYOUINFO %>);
    showKoumoku(<%=VHSYUSYUHTNPKKN2_HOSYOUINFO %>);
<% } %>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyusyuhtnpbuicd3()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyusyuhtnpkkn3())) { %>
    showKoumoku(<%=VHSYUSYUHTNPBUICD3_HOSYOUINFO %>);
    showKoumoku(<%=VHSYUSYUHTNPKKN3_HOSYOUINFO %>);
<% } %>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyusyuhtnpbuicd4()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyusyuhtnpkkn4())) { %>
    showKoumoku(<%=VHSYUSYUHTNPBUICD4_HOSYOUINFO %>);
    showKoumoku(<%=VHSYUSYUHTNPKKN4_HOSYOUINFO %>);
<% } %>

<%
 if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyusyutokkdsghtnpkbn())) { %>
   showKoumoku(<%=VHSYUSYUTOKKDSGHTNPKBN_HOSYOUINFO %>);
<% } %>

<%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyuhghkumu())) { %>
   showKoumoku(<%=VHSYUSYUTUTAKNGK_HOSYOUINFO %>);
<% } %>

<%
 if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyusyukouryokuhasseiymd(), viewHosyouUiBean.getVhsyusyukykymd()) != BizDateUtil.COMPARE_EQUAL) { %>
   showKoumoku(<%=VHSYUSYUKOURYOKUHASSEIYMD_HOSYOUINFO %>);
<% } %>

<%
 if (viewHosyouUiBean.getVhsyusyuhrkkkn() !=null && viewHosyouUiBean.getVhsyusyuhrkkkn() == 0) { %>
   $(<%=VHSYUSYUHRKKKN_HOSYOUINFO%>).text("");
   $(<%=VHSYUSYUHRKKKNSMNKBN_HOSYOUINFO%>).text("");
<% }else { %>
   $(<%=VHSYUSYUHRKKKN_HOSYOUINFO %>).parent().find("span").eq(2).text("");
<%}%>

<%
if(viewHosyouUiBean.getVhsyusyohinhanteikbn() != SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){%>
    showKoumoku(<%=VHSYUSYUKIHONSSYURUIKBN_HOSYOUINFO%>);
    <%
    if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyusyutsnshrgndhjumu())) {
        if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyusyukihonssyuruikbn())) {%>
            $(<%=VHSYUDISPSYUTSNSHRGNDGK_HOSYOUINFO%>).parent().find("span").eq(3).text("");
        <%
        } else { %>
            $(<%=VHSYUDISPSYUTSNSHRGNDGK_HOSYOUINFO%>).parent().find("span").eq(1).text("");
        <% } %>
        $(<%=VHSYUDISPSYUTSNSHRGNDGK_HOSYOUINFO%>).text("");
    <%
    } else { %>
        $(<%=VHSYUSYUKIHONSSYURUIKBN_HOSYOUINFO%>).parent().find("span").eq(0).text("");
        $(<%=VHSYUSYUKIHONSSYURUIKBN_HOSYOUINFO%>).parent().find("span").eq(1).text("");
        $(<%=VHSYUSYUKIHONSSYURUIKBN_HOSYOUINFO%>).parent().find("span").eq(2).text("");
        $(<%=VHSYUSYUKIHONS_HOSYOUINFO%>).text("");
    <% } %>
    <%
 }  else{%>
     $(<%=VHSYUSYUP_HOSYOUINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     $(<%=VHSYUSYUP_HOSYOUINFO%>).addClass('paddingLeft');
 <% } %>

<%
 if (viewHosyouUiBean.getVhsyusyup().isZeroOrOptional()) { %>
   $(<%=VHSYUSYUKIHONSSYURUIKBN_HOSYOUINFO%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
   setKihonsLayout($(<%=VHSYUSYUKIHONSSYURUIKBN_HOSYOUINFO%>).parent());
 <% } %>

<%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudai1hknkknsbsyokuseiumu())) { %>
   showKoumoku(<%=VHSYUDAI1HKNKKN_HOSYOUINFO%>);
<% } %>


<%
 if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyugenzaikngkhyjfukaumu())) {%>
   <%
   if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusbhkuktumu())) {
     if (viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) { %>
       showKoumoku(<%=VHSYUGENZAISBHKNKNGAKU_HOSYOUINFO%>);
     <% }
     else {
          if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudai1hknkknsbsyokuseiumu())) { %>
           showKoumoku(<%=VHSYUGENZAISBHKNKNGAKU_HOSYOUINFO%>);
       <% } %>
    <% } %>
   <%
   } else if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusbkyuuhukinuktumu())) {%>
     showKoumoku(<%=VHSYUGENZAISBHKNKNGAKU_HOSYOUINFO%>);
     $(<%=VHSYUGENZAISBHKNKNGAKU_HOSYOUINFO + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW1005)%>');
   <%}%>
  <%}%>

<%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusgsbhsyumu()) &&
     C_HknKknKbn.DAI1HKNKKN.eq(viewHosyouUiBean.getVhsyuhknKknKbn())) { %>
   showKoumoku(<%=VHSYUSAIGAISBHKNKNGAKU_HOSYOUINFO%>);
<% } %>
<%
 if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyusyuhghkumu())) { %>
   showList(<%=TBKTINFO %>);
   if ($(<%=TBKTINFO %>)[0].rows.length > 1) {
       showGroup(<%=TBKTINFOMESSAGE%>);
   }
<% } %>

<%
 if(viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
    viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
    (viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
    C_YendthnkJyoutaiKbn.YENDTHNKZUMI.eq(viewHosyouUiBean.getVhsyuyendthnkjyoutaikbn()))){ %>
  showKoumoku(<%=VHSYUTUMITATERIRITU_HOSYOUINFO%>);
<%}%>

<%
if(viewHosyouUiBean.getVhsyusyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
   C_YendthnkJyoutaiKbn.BLNK.eq(viewHosyouUiBean.getVhsyuyendthnkjyoutaikbn())){ %>
  showKoumoku(<%=VHSYUKYKTUMITATERIRITU_HOSYOUINFO%>);
  showKoumoku(<%=VHSYU10NENTUMITATERIRITU_HOSYOUINFO%>);
<%}%>

<%
 if (viewHosyouUiBean.getVhsyutmttknitenymd() != null &&
     BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyutmttknitenymd(), BizDate.getSysDate()) != BizDateUtil.COMPARE_GREATER) {%>
       showKoumoku(<%=VHSYUTMTTKNITENYMD_HOSYOUINFO%>);
<%}%>

<%
 if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyunstkhukaumukbn()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd1()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd2()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd3()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd4()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd5()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd6()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd7()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd8()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd9()) &&
     BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd10())){ %>

    $(<%=TKINFO + LABEL%>).text("");
<% } %>

<%
   if(C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyunstkhukaumukbn())){%>
     showGroup(<%=TKINFO%>);
     showKoumoku(<%=VHSYUDISPTKSYOUHNNM_TKINFO%>);
     showKoumoku(<%=VHSYUNKSHRTKYKNKSYUKBN_TKINFO%>);
     showKoumoku(<%=VHSYUNKSHRTKYKNKSYUKKN_TKINFO%>);
     layoutFlg = false;
<%} else {%>
     layoutFlg = true;
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd1())) { %>

   if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO1 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO1 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn1())) {%>
          showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN1_TKINFO1 %>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn1())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN1_TKINFO1%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd1() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD1_TKINFO1%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd1() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD1_TKINFO1%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd1() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD1_TKINFO1%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu1())) { %>
        $(<%=VHSYUDISPTKHKNKKN1_TKINFO1 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn1())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK1_TKINFO1 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu1())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK1_TKINFO1%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu1())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP1_TKINFO1 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn1())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP1_TKINFO1%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn1())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN1_TKINFO1 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn1())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN1_TKINFO1%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn1())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN1_TKINFO1 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn1())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN1_TKINFO1%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu1())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK1_TKINFO1 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu1())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD1_TKINFO1 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu1())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS1_TKINFO1 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS1_TKINFO1 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD1_TKINFO1 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu1())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN1_TKINFO1 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN1_TKINFO1 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn1())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN1_TKINFO1 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD11_TKINFO1 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd21() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD21_TKINFO1 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd31() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD31_TKINFO1 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd41() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD41_TKINFO1 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd51() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD51_TKINFO1 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp1() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp1().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp1().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN1_TKINFO1 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd11()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn11())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD11_TKINFO1 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN11_TKINFO1 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd21()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn21())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD21_TKINFO1 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN21_TKINFO1 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd31()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn31())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD31_TKINFO1 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN31_TKINFO1 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd41()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn41())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD41_TKINFO1 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN41_TKINFO1 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn1())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN1_TKINFO1 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu1())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK1_TKINFO1 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd1(), viewHosyouUiBean.getVhsyudisptkkykymd1()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD1_TKINFO1 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn1() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN1_TKINFO1%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN1_TKINFO1%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN1_TKINFO1 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu1())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn1())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK1_TKINFO1%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK1_TKINFO1%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK1_TKINFO1%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN1_TKINFO1%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN1_TKINFO1%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN1_TKINFO1%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS1_TKINFO1%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd2())) { %>

    if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO2 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO2 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn2())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN2_TKINFO2%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn2())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN2_TKINFO2%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd2() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD2_TKINFO2%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd2() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD2_TKINFO2%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd2() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD2_TKINFO2%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu2())) { %>
        $(<%=VHSYUDISPTKHKNKKN2_TKINFO2 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn2())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK2_TKINFO2 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu2())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK2_TKINFO2%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu2())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP2_TKINFO2 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn2())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP2_TKINFO2%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn2())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN2_TKINFO2 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn2())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN2_TKINFO2%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn2())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN2_TKINFO2 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn2())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN2_TKINFO2%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu2())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK2_TKINFO2 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu2())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD2_TKINFO2 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu2())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS2_TKINFO2 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS2_TKINFO2 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD2_TKINFO2 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu2())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN2_TKINFO2 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN2_TKINFO2 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn2())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN2_TKINFO2 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD12_TKINFO2 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd22() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD22_TKINFO2 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd32() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD32_TKINFO2 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd42() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD42_TKINFO2 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd52() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD52_TKINFO2 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp2() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp2().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp2().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN2_TKINFO2 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd12()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn12())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD12_TKINFO2 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN12_TKINFO2 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd22()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn22())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD22_TKINFO2 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN22_TKINFO2 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd32()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn32())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD32_TKINFO2 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN32_TKINFO2 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd42()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn42())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD42_TKINFO2 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN42_TKINFO2 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn2())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN2_TKINFO2 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu2())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK2_TKINFO2 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd2(), viewHosyouUiBean.getVhsyudisptkkykymd2()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD2_TKINFO2 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn2() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN2_TKINFO2%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN2_TKINFO2%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN2_TKINFO2 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu2())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn2())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK2_TKINFO2%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK2_TKINFO2%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK2_TKINFO2%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN2_TKINFO2%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN2_TKINFO2%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN2_TKINFO2%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS2_TKINFO2%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd3())) { %>

     if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO3 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO3 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn3())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN3_TKINFO3%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn3())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN3_TKINFO3%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd3() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD3_TKINFO3%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd3() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD3_TKINFO3%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd3() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD3_TKINFO3%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu3())) { %>
        $(<%=VHSYUDISPTKHKNKKN3_TKINFO3 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn3())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK3_TKINFO3 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu3())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK3_TKINFO3%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu3())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP3_TKINFO3 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn3())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP3_TKINFO3%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn3())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN3_TKINFO3 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn3())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN3_TKINFO3%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn3())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN3_TKINFO3 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn3())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN3_TKINFO3%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu3())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK3_TKINFO3 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu3())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD3_TKINFO3 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu3())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS3_TKINFO3 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS3_TKINFO3 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD3_TKINFO3 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu3())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN3_TKINFO3 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN3_TKINFO3 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn3())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN3_TKINFO3 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD13_TKINFO3 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd23() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD23_TKINFO3 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd33() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD33_TKINFO3 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd43() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD43_TKINFO3 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd53() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD53_TKINFO3 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp3() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp3().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp3().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN3_TKINFO3 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd13()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn13())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD13_TKINFO3 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN13_TKINFO3 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd23()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn23())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD23_TKINFO3 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN23_TKINFO3 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd33()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn33())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD33_TKINFO3 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN33_TKINFO3 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd43()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn43())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD43_TKINFO3 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN43_TKINFO3 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn3())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN3_TKINFO3 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu3())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK3_TKINFO3 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd3(), viewHosyouUiBean.getVhsyudisptkkykymd3()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD3_TKINFO3 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn3() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN3_TKINFO3%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN3_TKINFO3%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN3_TKINFO3 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu3())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn3())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK3_TKINFO3%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK3_TKINFO3%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK3_TKINFO3%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN3_TKINFO3%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN3_TKINFO3%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN3_TKINFO3%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS3_TKINFO3%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd4())) { %>

      if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO4 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO4 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn4())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN4_TKINFO4%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn4())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN4_TKINFO4%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd4() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD4_TKINFO4%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd4() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD4_TKINFO4%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd4() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD4_TKINFO4%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu4())) { %>
        $(<%=VHSYUDISPTKHKNKKN4_TKINFO4 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn4())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK4_TKINFO4 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu4())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK4_TKINFO4%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu4())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP4_TKINFO4 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn4())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP4_TKINFO4%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn4())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN4_TKINFO4 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn4())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN4_TKINFO4%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn4())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN4_TKINFO4 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn4())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN4_TKINFO4%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu4())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK4_TKINFO4 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu4())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD4_TKINFO4 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu4())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS4_TKINFO4 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS4_TKINFO4 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD4_TKINFO4 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu4())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN4_TKINFO4 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN4_TKINFO4 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn4())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN4_TKINFO4 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD14_TKINFO4 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd24() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD24_TKINFO4 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd34() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD34_TKINFO4 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd44() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD44_TKINFO4 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd54() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD54_TKINFO4 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp4() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp4().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp4().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN4_TKINFO4 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd14()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn14())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD14_TKINFO4 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN14_TKINFO4 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd24()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn24())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD24_TKINFO4 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN24_TKINFO4 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd34()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn34())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD34_TKINFO4 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN34_TKINFO4 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd44()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn44())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD44_TKINFO4 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN44_TKINFO4 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn4())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN4_TKINFO4 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu4())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK4_TKINFO4 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd4(), viewHosyouUiBean.getVhsyudisptkkykymd4()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD4_TKINFO4 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn4() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN4_TKINFO4%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN4_TKINFO4%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN4_TKINFO4 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu4())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn4())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK4_TKINFO4%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK4_TKINFO4%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK4_TKINFO4%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN4_TKINFO4%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN4_TKINFO4%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN4_TKINFO4%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS4_TKINFO4%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd5())) { %>

      if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO5 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO5 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn5())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN5_TKINFO5%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn5())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN5_TKINFO5%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd5() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD5_TKINFO5%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd5() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD5_TKINFO5%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd5() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD5_TKINFO5%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu5())) { %>
        $(<%=VHSYUDISPTKHKNKKN5_TKINFO5 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn5())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK5_TKINFO5 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu5())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK5_TKINFO5%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu5())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP5_TKINFO5 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn5())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP5_TKINFO5%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn5())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN5_TKINFO5 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn5())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN5_TKINFO5%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn5())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN5_TKINFO5 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn5())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN5_TKINFO5%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu5())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK5_TKINFO5 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu5())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD5_TKINFO5 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu5())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS5_TKINFO5 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS5_TKINFO5 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD5_TKINFO5 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu5())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN5_TKINFO5 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN5_TKINFO5 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn5())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN5_TKINFO5 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD15_TKINFO5 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd25() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD25_TKINFO5 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd35() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD35_TKINFO5 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd45() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD45_TKINFO5 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd55() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD55_TKINFO5 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp5() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp5().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp5().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN5_TKINFO5 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd15()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn15())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD15_TKINFO5 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN15_TKINFO5 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd25()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn25())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD25_TKINFO5 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN25_TKINFO5 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd35()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn35())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD35_TKINFO5 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN35_TKINFO5 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd45()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn45())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD45_TKINFO5 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN45_TKINFO5 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn5())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN5_TKINFO5 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu5())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK5_TKINFO5 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd5(), viewHosyouUiBean.getVhsyudisptkkykymd5()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD5_TKINFO5 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn5() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN5_TKINFO5%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN5_TKINFO5%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN5_TKINFO5 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu5())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn5())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK5_TKINFO5%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK5_TKINFO5%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK5_TKINFO5%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN5_TKINFO5%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN5_TKINFO5%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN5_TKINFO5%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS5_TKINFO5%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd6())) { %>

      if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO6 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO6 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn6())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN6_TKINFO6%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn6())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN6_TKINFO6%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd6() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD6_TKINFO6%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd6() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD6_TKINFO6%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd6() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD6_TKINFO6%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu6())) { %>
        $(<%=VHSYUDISPTKHKNKKN6_TKINFO6 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn6())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK6_TKINFO6 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu6())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK6_TKINFO6%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu6())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP6_TKINFO6 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn6())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP6_TKINFO6%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn6())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN6_TKINFO6 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn6())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN6_TKINFO6%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn6())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN6_TKINFO6 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn6())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN6_TKINFO6%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu6())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK6_TKINFO6 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu6())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD6_TKINFO6 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu6())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS6_TKINFO6 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS6_TKINFO6 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD6_TKINFO6 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu6())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN6_TKINFO6 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN6_TKINFO6 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn6())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN6_TKINFO6 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD16_TKINFO6 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd26() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD26_TKINFO6 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd36() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD36_TKINFO6 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd46() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD46_TKINFO6 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd56() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD56_TKINFO6 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp6() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp6().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp6().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN6_TKINFO6 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd16()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn16())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD16_TKINFO6 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN16_TKINFO6 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd26()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn26())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD26_TKINFO6 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN26_TKINFO6 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd36()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn36())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD36_TKINFO6 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN36_TKINFO6 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd46()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn46())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD46_TKINFO6 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN46_TKINFO6 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn6())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN6_TKINFO6 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu6())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK6_TKINFO6 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd6(), viewHosyouUiBean.getVhsyudisptkkykymd6()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD6_TKINFO6 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn6() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN6_TKINFO6%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN6_TKINFO6%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN6_TKINFO6 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu6())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn6())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK6_TKINFO6%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK6_TKINFO6%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK6_TKINFO6%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN6_TKINFO6%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN6_TKINFO6%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN6_TKINFO6%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS6_TKINFO6%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd7())) { %>

      if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO7 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO7 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn7())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN7_TKINFO7%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn7())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN7_TKINFO7%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd7() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD7_TKINFO7%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd7() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD7_TKINFO7%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd7() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD7_TKINFO7%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu7())) { %>
        $(<%=VHSYUDISPTKHKNKKN7_TKINFO7 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn7())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK7_TKINFO7 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu7())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK7_TKINFO7%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu7())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP7_TKINFO7 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn7())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP7_TKINFO7%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn7())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN7_TKINFO7 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn7())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN7_TKINFO7%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn7())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN7_TKINFO7 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn7())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN7_TKINFO7%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu7())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK7_TKINFO7 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu7())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD7_TKINFO7 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu7())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS7_TKINFO7 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS7_TKINFO7 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD7_TKINFO7 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu7())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN7_TKINFO7 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN7_TKINFO7 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn7())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN7_TKINFO7 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD17_TKINFO7 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd27() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD27_TKINFO7 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd37() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD37_TKINFO7 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd47() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD47_TKINFO7 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd57() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD57_TKINFO7 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp7() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp7().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp7().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN7_TKINFO7 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd17()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn17())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD17_TKINFO7 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN17_TKINFO7 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd27()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn27())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD27_TKINFO7 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN27_TKINFO7 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd37()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn37())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD37_TKINFO7 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN37_TKINFO7 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd47()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn47())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD47_TKINFO7 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN47_TKINFO7 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn7())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN7_TKINFO7 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu7())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK7_TKINFO7 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd7(), viewHosyouUiBean.getVhsyudisptkkykymd7()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD7_TKINFO7 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn7() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN7_TKINFO7%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN7_TKINFO7%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN7_TKINFO7 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu7())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn7())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK7_TKINFO7%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK7_TKINFO7%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK7_TKINFO7%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN7_TKINFO7%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN7_TKINFO7%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN7_TKINFO7%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS7_TKINFO7%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd8())) { %>

      if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO8 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO8 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn8())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN8_TKINFO8%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn8())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN8_TKINFO8%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd8() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD8_TKINFO8%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd8() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD8_TKINFO8%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd8() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD8_TKINFO8%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu8())) { %>
        $(<%=VHSYUDISPTKHKNKKN8_TKINFO8 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn8())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK8_TKINFO8 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu8())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK8_TKINFO8%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu8())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP8_TKINFO8 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn8())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP8_TKINFO8%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn8())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN8_TKINFO8 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn8())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN8_TKINFO8%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn8())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN8_TKINFO8 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn8())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN8_TKINFO8%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu8())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK8_TKINFO8 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu8())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD8_TKINFO8 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu8())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS8_TKINFO8 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS8_TKINFO8 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD8_TKINFO8 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu8())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN8_TKINFO8 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN8_TKINFO8 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn8())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN8_TKINFO8 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD18_TKINFO8 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd28() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD28_TKINFO8 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd38() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD38_TKINFO8 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd48() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD48_TKINFO8 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd58() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD58_TKINFO8 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp8() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp8().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp8().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN8_TKINFO8 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd18()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn18())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD18_TKINFO8 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN18_TKINFO8 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd28()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn28())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD28_TKINFO8 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN28_TKINFO8 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd38()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn38())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD38_TKINFO8 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN38_TKINFO8 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd48()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn48())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD48_TKINFO8 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN48_TKINFO8 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn8())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN8_TKINFO8 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu8())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK8_TKINFO8 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd8(), viewHosyouUiBean.getVhsyudisptkkykymd8()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD8_TKINFO8 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn8() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN8_TKINFO8%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN8_TKINFO8%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN8_TKINFO8 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu8())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn8())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK8_TKINFO8%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK8_TKINFO8%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK8_TKINFO8%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN8_TKINFO8%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN8_TKINFO8%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN8_TKINFO8%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS8_TKINFO8%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd9())) { %>

      if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO9 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO9 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn9())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN9_TKINFO9%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn9())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN9_TKINFO9%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd9() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD9_TKINFO9%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd9() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD9_TKINFO9%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd9() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD9_TKINFO9%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu9())) { %>
        $(<%=VHSYUDISPTKHKNKKN9_TKINFO9 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn9())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK9_TKINFO9 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu9())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK9_TKINFO9%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu9())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP9_TKINFO9 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn9())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP9_TKINFO9%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn9())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN9_TKINFO9 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn9())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN9_TKINFO9%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn9())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN9_TKINFO9 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn9())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN9_TKINFO9%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu9())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK9_TKINFO9 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu9())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD9_TKINFO9 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu9())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS9_TKINFO9 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS9_TKINFO9 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD9_TKINFO9 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu9())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN9_TKINFO9 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN9_TKINFO9 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn9())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN9_TKINFO9 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD19_TKINFO9 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd29() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD29_TKINFO9 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd39() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD39_TKINFO9 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd49() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD49_TKINFO9 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd59() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD59_TKINFO9 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp9() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp9().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp9().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN9_TKINFO9 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd19()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn19())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD19_TKINFO9 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN19_TKINFO9 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd29()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn29())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD29_TKINFO9 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN29_TKINFO9 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd39()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn39())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD39_TKINFO9 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN39_TKINFO9 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd49()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn49())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD49_TKINFO9 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN49_TKINFO9 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn9())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN9_TKINFO9 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu9())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK9_TKINFO9 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd9(), viewHosyouUiBean.getVhsyudisptkkykymd9()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD9_TKINFO9 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn9() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN9_TKINFO9%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN9_TKINFO9%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN9_TKINFO9 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu9())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn9())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK9_TKINFO9%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK9_TKINFO9%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK9_TKINFO9%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN9_TKINFO9%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN9_TKINFO9%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN9_TKINFO9%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS9_TKINFO9%>).text("");
   <% } %>
<%}%>

<%
 if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptksyouhncd10())) { %>

      if (layoutFlg == true) {
       showGroup(<%=TKINFO%>);
       $(<%= TKINFO10 + DIV%>).css("margin-top", "0px");
       layoutFlg = false;
   }

   showGroup(<%=TKINFO10 %>);

   <%
      if(!C_KataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptokyakukatakbn10())) {%>
        showKoumoku(<%=VHSYUDISPTOKYAKUKATAKBN10_TKINFO10%>);
   <%}%>

   <%
      if(!C_KyhgndkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkyhgdkatakbn10())) {%>
        showKoumoku(<%=VHSYUDISPTKKYHGDKATAKBN10_TKINFO10%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkskkaisiymd10() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKSKKAISIYMD10_TKINFO10%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkgaskkaisiymd10() != null) {%>
        showKoumoku(<%=VHSYUDISPTKGASKKAISIYMD10_TKINFO10%>);
   <%}%>

   <%
      if(viewHosyouUiBean.getVhsyudisptkhkgskksiymd10() != null) {%>
        showKoumoku(<%=VHSYUDISPTKHKGSKKSIYMD10_TKINFO10%>);
   <%}%>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu10())) { %>
        $(<%=VHSYUDISPTKHKNKKN10_TKINFO10 + LABEL%>).text('<%=MessageUtil.getMessage(MessageId.IIW0008) %>');
   <% } %>

   <%
      if (!C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn10())) { %>
        showKoumoku(<%=VHSYUDISPTKKIHONKYHGK10_TKINFO10 %>);
     <%
        if (!C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu10())) { %>
          $(<%=VHSYUDISPTKKIHONKYHGK10_TKINFO10%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
     <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknextkosumu10())) { %>
        showKoumoku(<%=VHSYUDISPTKNEXTKOSGOP10_TKINFO10 %>);
        <%
           if (C_KhnkyhkgbairituKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkgbairitukbn10())) { %>
             $(<%=VHSYUDISPTKNEXTKOSGOP10_TKINFO10%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (!C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn10())) { %>
        showKoumoku(<%=VHSYUDISPTKSYKYHKATAKBN10_TKINFO10 %>);
      <%
      if (C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn10())) { %>
        $(<%=VHSYUDISPTKSYKYHKATAKBN10_TKINFO10%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
      <% } %>
   <% } %>

   <%
      if (!C_6daiLdKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptk6daildkbn10())) { %>
        showKoumoku(<%=VHSYUDISPTK6DAILDKBN10_TKINFO10 %>);
        <%
        if (C_SyukyhkinkataKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptksykyhkatakbn10())) { %>
          $(<%=VHSYUDISPTK6DAILDKBN10_TKINFO10%>).parent().removeClass('c2').addClass('c1').attr("colSpan","3");
        <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkgannyukyhumu10())) { %>
        showKoumoku(<%=VHSYUDISPTKGANYUKYHNTGK10_TKINFO10 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptksndkyhkinshrskgnumu10())) { %>
        showKoumoku(<%=VHSYUDISPTKSHRSKGSTRYMD10_TKINFO10 %>);
      <%
         if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu10())) { %>
           $(<%=VHSYUDISPTKSHRSKGNGOS10_TKINFO10 %>).text("");
      <%
        } else { %>
          $(<%=VHSYUDISPTKSHRSKGNGOS10_TKINFO10 %>).parent().find("span").eq(6).text("");
          $(<%=VHSYUDISPTKSHRSKGNEDYMD10_TKINFO10 + SUFFIX%>).addClass('innerCenterViewHosyou2');
      <% } %>
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptknkhknumu10())) { %>
        showKoumoku(<%=VHSYUDISPTKNENKINSYUKBN10_TKINFO10 %>);
        showKoumoku(<%=VHSYUDISPTKNENKINKKN10_TKINFO10 %>);
   <% } %>

   <%
      if (!C_Tkjyskgnkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptktkjyskgnkkn10())) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYSKGNKKN10_TKINFO10 %>);
        showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD110_TKINFO10 %>);

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd210() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD210_TKINFO10 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd310() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD310_TKINFO10 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd410() != null) {%>
            showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD410_TKINFO10 %>);
      <% } %>

      <%
         if (viewHosyouUiBean.getVhsyudisptktkjkhkdsymd510() != null) {%>
           showKoumoku(<%=VHSYUDISPTKTKJKHKDSYMD510_TKINFO10 %>);
      <% } %>
   <%}%>

   <%
      if (viewHosyouUiBean.getVhsyudisptktkjyp10() != null &&
          viewHosyouUiBean.getVhsyudisptktkjyp10().compareTo(BizCurrency.valueOf(0, viewHosyouUiBean.getVhsyudisptktkjyp10().getType()))!= 0) { %>
        showKoumoku(<%=VHSYUDISPTKTKJYHYOUTEN10_TKINFO10 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd110()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn110())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD110_TKINFO10 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN110_TKINFO10 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd210()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn210())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD210_TKINFO10 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN210_TKINFO10 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd310()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn310())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD310_TKINFO10 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN310_TKINFO10 %>);
   <% } %>

   <%
      if (!BizUtil.isBlank(viewHosyouUiBean.getVhsyudisptkhtnpbuicd410()) || !C_Htnpkkn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkhtnpkkn410())) { %>
        showKoumoku(<%=VHSYUDISPTKHTNPBUICD410_TKINFO10 %>);
        showKoumoku(<%=VHSYUDISPTKHTNPKKN410_TKINFO10 %>);
   <% } %>

   <%
      if (C_TokkoudosghtnpKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptktkkdsghtpkbn10())) { %>
        showKoumoku(<%=VHSYUDISPTKTKKDSGHTPKBN10_TKINFO10 %>);
   <% } %>

   <%
      if (C_UmuKbn.ARI.eq(viewHosyouUiBean.getVhsyudisptkhghkumu10())) { %>
        showKoumoku(<%=VHSYUDISPTKTUTAKNGK10_TKINFO10 %>);
   <% } %>

   <%
      if (BizDateUtil.compareYmd(viewHosyouUiBean.getVhsyudisptkkrkhasseiymd10(), viewHosyouUiBean.getVhsyudisptkkykymd10()) != BizDateUtil.COMPARE_EQUAL) { %>
        showKoumoku(<%=VHSYUDISPTKKRKHASSEIYMD10_TKINFO10 %>);
   <% } %>

   <%
      if (viewHosyouUiBean.getVhsyudisptkhrkkkn10() == 0) { %>
        $(<%=VHSYUDISPTKHRKKKN10_TKINFO10%>).text("");
        $(<%=VHSYUDISPTKHRKKKNSMNKBN10_TKINFO10%>).text("");
   <% }else { %>
        $(<%=VHSYUDISPTKHRKKKN10_TKINFO10 %>).parent().find("span").eq(2).text("");
   <%}%>

   <%
       if (C_UmuKbn.NONE.eq(viewHosyouUiBean.getVhsyudisptktsnshrgndhjumu10())) {
         if (!C_KihonssyuruiKbn.BLNK.eq(viewHosyouUiBean.getVhsyudisptkkihsyuruikbn9())) { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK10_TKINFO10%>).parent().find("span").eq(3).text("");
           <%
         } else { %>
           $(<%=VHSYUDISPTKTSNSHRGNDGK10_TKINFO10%>).parent().find("span").eq(1).text("");
         <% } %>
         $(<%=VHSYUDISPTKTSNSHRGNDGK10_TKINFO10%>).text("");
   <%
      } else { %>
         $(<%=VHSYUDISPTKKIHSYURUIKBN10_TKINFO10%>).parent().find("span").eq(0).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN10_TKINFO10%>).parent().find("span").eq(1).text("");
         $(<%=VHSYUDISPTKKIHSYURUIKBN10_TKINFO10%>).parent().find("span").eq(2).text("");
         $(<%=VHSYUDISPTKKIHONS10_TKINFO10%>).text("");
   <% } %>
<%}%>

<%
 if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) { %>
   varElmAddTopBottomLink([
          <%= HOSYOUINFO %>,
          <%= TBKTINFO %>,
          <%= TKINFO%>,
          <%= TKINFO1 %>,
          <%= TKINFO2 %>,
          <%= TKINFO3 %>,
          <%= TKINFO4 %>,
          <%= TKINFO5 %>,
          <%= TKINFO6 %>,
          <%= TKINFO7 %>,
          <%= TKINFO8 %>,
          <%= TKINFO9 %>,
          <%= TKINFO10 %>
        ]);
<%}%>


});

</script>
