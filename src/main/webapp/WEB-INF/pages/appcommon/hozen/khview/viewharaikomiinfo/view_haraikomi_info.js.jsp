<%--
    view_haraikomi_info.js.jsp - 払込情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_Hrkkeiro" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_Hrkkaisuu" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.def.classification.C_Tuukasyu"%>
<%@page import="yuyu.def.classification.C_TkiktbrisyuruiKbn"%>
<%@page import="yuyu.common.biz.bzcommon.IGkCommonKoumoku"%>
<%@page import="yuyu.def.classification.C_Kykjyoutai"%>
<%@page import="yuyu.def.classification.C_SyutkKbn"%>
<%@page import="yuyu.common.biz.bzcommon.BizDateUtil"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewHaraikomiInfoUiBeanParam viewHaraikomiInfoUiBean = (ViewHaraikomiInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

function varElmAddTopBottomLink(idSelecterList){
    var groupSelecter = idSelecterList.join(',');
    var targetId = $(groupSelecter).filter(':visible').last().attr('id');
    addTopBottomLink('#' + targetId);
}

$(function(){

<%
   if (C_Hrkkeiro.KOUHURI.eq(viewHaraikomiInfoUiBean.getVhrkihrkkeiro()) && !BizUtil.isBlank(viewHaraikomiInfoUiBean.getVhrkihrkinfokouzano())) { %>
     showGroup(<%=GINKOUINFO%>);
     <%
        if (!IGkCommonKoumoku.BANKCD_YTGINKOU.equals(viewHaraikomiInfoUiBean.getVhrkihrkinfobankcd())) { %>
          showKoumoku(<%=VHRKIHRKINFOSITENCD_GINKOUINFO%>);
          showKoumoku(<%=VHRKIHRKINFOSITENNMKJ_GINKOUINFO%>);
        <%
        } else { %>
          showKoumoku(<%=VHRKIHRKINFOTUUTYOUKIGOU_GINKOUINFO%>);
          $('#vhrkihrkinfokouzano_label').html("通帳番号");
     <% } %>
<% } %>

<%
   if (C_Hrkkeiro.CREDIT.eq(viewHaraikomiInfoUiBean.getVhrkihrkkeiro())) { %>
     showGroup(<%=FOCREDITCARDINFO%>);
<% } %>

<%
   if (C_UmuKbn.ARI.eq(viewHaraikomiInfoUiBean.getNextkosumu())) {%>
     showKoumoku(<%=VHRKINEXTKOSGOHRKP_HARAIKOMIINFO%>);
<% }%>

 <%
   if (C_Hrkkaisuu.ITIJI.eq(viewHaraikomiInfoUiBean.getVhrkihrkkaisuu())) { %>
     $(<%=VHRKIJKIPJYTYM_HARAIKOMIINFO%>).visible(false);
<%
   } else { %>
     $(<%=VHRKIJKIPJYTYM_HARAIKOMIINFO%>).parent().find("span").eq(1).text("");
<% } %>

<%
   if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {%>
        varElmAddTopBottomLink([
          <%= HARAIKOMIINFO %>,
          <%= GINKOUINFO %>,
          <%= FOCREDITCARDINFO %>
        ]);
<% }%>

<%
   if (!C_TkiktbrisyuruiKbn.BLNK.eq(viewHaraikomiInfoUiBean.getVhrkitikiktbrijk())) {%>
      showKoumoku(<%= VHRKITIKIKTBRIJK_HARAIKOMIINFO %>);
<% }%>

<%
   if (!C_Hrkkaisuu.ITIJI.eq(viewHaraikomiInfoUiBean.getVhrkihrkkaisuu())) {%>
     showKoumoku(<%= VHRKIHRKP_HARAIKOMIINFO %>);
<% }%>

<%
   if (C_Hrkkaisuu.ITIJI.eq(viewHaraikomiInfoUiBean.getVhrkihrkkaisuu()) && !(C_Tuukasyu.JPY.eq(viewHaraikomiInfoUiBean.getKyktuukasyu()))) {%>
     showKoumoku(<%= VHRKIITIJIBRP_HARAIKOMIINFO %>);
<% }%>

<%
   if (!(C_Tuukasyu.JPY.eq(viewHaraikomiInfoUiBean.getVhrkiyentkykwsratetuukasyu()))) {%>
     showKoumoku(<%= VHRKIYENKANSANNYKNKINGK_HARAIKOMIINFO %>);
     showKoumoku(<%= VHRKIYENTKYKWSRATEYMD_HARAIKOMIINFO %>);
<% }%>

<%
   if (C_Kykjyoutai.ZENNOU.eq(viewHaraikomiInfoUiBean.getVhrkikykjyoutai())) {%>
     showGroup(<%= ZENNOUINFO %>);
   <%
     if (C_UmuKbn.ARI.eq(viewHaraikomiInfoUiBean.getVhrkizenkizennouumu())) {%>
       $(<%=VHRKIZENNOUKKN_ZENNOUINFO%>).parent().find("span").eq(1).text("");
       $(<%=VHRKIZENNOUKKN_ZENNOUINFO%>).visible(false);
       $('#IIA3002').visible(true);
   <% } %>
<% }%>

});

</script>
