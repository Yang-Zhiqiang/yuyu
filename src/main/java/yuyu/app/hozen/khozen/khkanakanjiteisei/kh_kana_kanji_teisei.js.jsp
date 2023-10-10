<%--
    kh_kana_kanji_teisei.js.jsp - 仮名漢字訂正 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkanakanjiteisei.KhKanaKanjiTeiseiConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkanakanjiteisei.KhKanaKanjiTeiseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khkanakanjiteisei.KhKanaKanjiTeiseiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_UktKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="jp.co.slcs.swak.util.string.StringUtil" %>
<%@page import="yuyu.def.classification.C_UktkaijyoKbn" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@page import="yuyu.def.classification.C_Hrkkeiro" %>

<% KhKanaKanjiTeiseiUiBean uiBean = SWAKInjector.getInstance(KhKanaKanjiTeiseiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
<% } %>

<script type="text/javascript"><!--
$(function(){
<% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
      <% if (!C_UktKbn.BLNK.eq(uiBean.getVnkuknenkinuktkbn())) { %>
          showGroup(<%=NKUKTINFO%>);
      <% } %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getVshktsbhkuktumu()) ||
             C_UmuKbn.ARI.eq(uiBean.getVshktsbkyuuhukinuktumu())) { %>
          showGroup(<%=SBHKUKTINFO%>);
          <% if (!C_UktKbn.BLNK.eq(uiBean.getVshktdispsbuktkbn1())) { %>
              showGroup(<%=SBHKUKTINFO1%>);
          <% } %>
          <% if (!C_UktKbn.BLNK.eq(uiBean.getVshktdispsbuktkbn2())) { %>
              showGroup(<%=SBHKUKTINFO2%>);
          <% } %>
          <% if (!C_UktKbn.BLNK.eq(uiBean.getVshktdispsbuktkbn3())) { %>
              showGroup(<%=SBHKUKTINFO3%>);
          <% } %>
          <% if (!C_UktKbn.BLNK.eq(uiBean.getVshktdispsbuktkbn4())) { %>
              showGroup(<%=SBHKUKTINFO4%>);
          <% } %>
          <% if (C_UmuKbn.ARI.eq(uiBean.getVshktsbkyuuhukinuktumu())) { %>
              $(<%=SBHKUKTINFO + LABEL%>).text('<%="●死亡給付金受取人"%>');
          <% } %>
      <% } %>
      <% if (!C_UktKbn.BLNK.eq(uiBean.getVstsksiteidruktkbn())) { %>
          showGroup(<%=SITEISEIKYUUINFO1%>);
          showGroup(<%=SITEISEIKYUUINFO2%>);
          showGroup(<%=SITEISEIKYUUSYOSAIINFO%>);
      <% } %>
      <% if (C_UktKbn.NASI.eq(uiBean.getVstsksiteidruktkbn())) { %>
          $(<%=STDRSKKAIJYOKBN_SITEISEIKYUUINFO1%>).visible(false);
          $(<%=STDRSKKAIJYOKBN_SITEISEIKYUUINFO1 + DIV%>).css("margin-top", "0px");
      <% } else { %>
          $(<%=STDRSKKAIJYOKBN_SITEISEIKYUUINFO1%>).visible(true);
      <% } %>
      $(<%=DUMMYKMK1_HENKOUJIYUUINFO2 + LABEL%>).parent().attr("rowspan","2");
      $(<%=DUMMYKMK2_HENKOUJIYUUINFO2%>).parent().parent().append(
          '<td class="c1_mh"><span>漢字欄最後に<font color=\"#FF0000\">※</font>ありは、漢字化不可</span></td>');
      $(<%=DUMMYKMK2_HENKOUJIYUUINFO2%>).parent().parent().append(
          '<td class="c1_mh"><span>漢字化不可の場合は漢字欄後ろに<input type=\"checkbox\" checked> を入力する</span></td>');
      <% if (C_Hrkkeiro.KOUHURI.eq(uiBean.getKykKihon().getHrkkeiro()) && C_UmuKbn.ARI.eq(uiBean.getKzUmuKbn())) { %>
          showGroup(<%=KZMEIGIINFO%>);
      <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (StringUtil.isNullOrBlank(uiBean.getNewkyknmkn())) { %>
        $(<%=NEWKYKNMKN_KEIYAKUSYAINFO%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getNewkyknmkj())) { %>
        $(<%=NEWKYKNMKJ_KEIYAKUSYAINFO%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getNewhhknnmkn())) { %>
        $(<%=NEWHHKNNMKN_HIHOKENSYAINFO%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getNewhhknnmkj())) { %>
        $(<%=NEWHHKNNMKJ_HIHOKENSYAINFO%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getSbuktnmkn1())) { %>
        $(<%=SBUKTNMKN1_SBHKUKTINFO1%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getSbuktnmkj1())) { %>
        $(<%=SBUKTNMKJ1_SBHKUKTINFO1%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getSbuktnmkn2())) { %>
        $(<%=SBUKTNMKN2_SBHKUKTINFO2%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getSbuktnmkj2())) { %>
        $(<%=SBUKTNMKJ2_SBHKUKTINFO2%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getSbuktnmkn3())) { %>
        $(<%=SBUKTNMKN3_SBHKUKTINFO3%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getSbuktnmkj3())) { %>
        $(<%=SBUKTNMKJ3_SBHKUKTINFO3%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getSbuktnmkn4())) { %>
        $(<%=SBUKTNMKN4_SBHKUKTINFO4%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getSbuktnmkj4())) { %>
        $(<%=SBUKTNMKJ4_SBHKUKTINFO4%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getNewstdrsknmkn())) { %>
        $(<%=NEWSTDRSKNMKN_SITEISEIKYUUINFO2%>).text('<%=HOSI%>');
    <% } %>
    <% if (StringUtil.isNullOrBlank(uiBean.getNewstdrsknmkj())) { %>
        $(<%=NEWSTDRSKNMKJ_SITEISEIKYUUINFO2%>).text('<%=HOSI%>');
    <% } %>
    <% if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) { %>
        $(<%=NEWSTDRSKNMKN_SITEISEIKYUUINFO2%>).text('');
        $(<%=NEWSTDRSKNMKJ_SITEISEIKYUUINFO2%>).text('');
        $(<%=NEWSTDRUKTKBN_SITEISEIKYUUINFO2%>).text('');
        $(<%=NEWSTDRSKNMKJHUKAKBN_SITEISEIKYUUINFO2%>).text('');
    <% } %>
     <% if (BizUtil.isBlank(uiBean.getNewkzmeiginmkn())) { %>
         $(<%=NEWKZMEIGINMKN_KZMEIGIINFO%>).text('<%=HOSI%>');
     <% } %>

<% } %>
});
//-->
</script>
