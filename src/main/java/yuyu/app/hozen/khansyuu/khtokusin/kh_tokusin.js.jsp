<%--
    kh_tokusin.js.jsp - 特伸処理 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khtokusin.KhTokusinConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khtokusin.KhTokusinSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khansyuu.khtokusin.KhTokusinUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_TokusinKbn" %>
<%@page import="yuyu.app.hozen.khansyuu.khtokusin.KhTokusinConstants.E_SyoriKbn" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<% KhTokusinUiBean uiBean = SWAKInjector.getInstance(KhTokusinUiBean.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
  commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){
<%
   if (uiBean.getPageNo() == PAGENO_INPUTKEY) {%>
   showGroup(<%=TOKUSINSYORINYUURYOKUINFO%>);
  $(<%= TOKUSINSYORINYUURYOKUINFO + DIV%>).css("margin-top", "-1px");
<% } %>
<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <%
       if (C_UmuKbn.ARI.eq(uiBean.getOldTokusinInfoUmu())) { %>
         showGroup(<%=OLDTOKUSININFO%>);
         <%
             if (C_TokusinKbn.HISAIGAI.eq(uiBean.getBfrtokusinkbn())) { %>
               showKoumoku(<%=BFRHSGYMD_OLDTOKUSININFO%>);
         <% }%>
    <% }%>
    showGroup(<%=TOKUSINSYORINYUURYOKUINFO%>);
    <%
        if (C_TokusinKbn.HISAIGAI.eq(uiBean.getTokusinkbn())) { %>
          showKoumoku(<%=HSGYMD_TOKUSINSYORINYUURYOKUINFO%>);
          showKoumoku(<%=TOKUSINENDYM_TOKUSINSYORINYUURYOKUINFO%>);
          $(<%= HSGYMD_TOKUSINSYORINYUURYOKUINFO + LABEL %>).required(true);
    <%
       } else if (C_TokusinKbn.OTHER.eq(uiBean.getTokusinkbn())) {%>
          showKoumoku(<%=TOKUSINENDYMD_TOKUSINSYORINYUURYOKUINFO%>);
          $(<%= TOKUSINENDYMD_TOKUSINSYORINYUURYOKUINFO + LABEL %>).required(true);
    <% }%>
<% }%>

<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <%
       if (E_SyoriKbn.TORIKESI.equals(uiBean.getGmsyorikbn()) ||
          (E_SyoriKbn.NYUURYOKU.equals(uiBean.getGmsyorikbn()) && C_UmuKbn.ARI.eq(uiBean.getOldTokusinInfoUmu()))) { %>
           showGroup(<%=OLDTOKUSININFO%>);
           <%
             if (C_TokusinKbn.HISAIGAI.eq(uiBean.getBfrtokusinkbn())) { %>
               showKoumoku(<%=BFRHSGYMD_OLDTOKUSININFO%>);
          <% }%>
    <% }%>

    <%
       if (E_SyoriKbn.NYUURYOKU.equals(uiBean.getGmsyorikbn())) { %>
          showGroup(<%=TOKUSINSYORINYUURYOKUINFO%>);
          <%
            if (C_TokusinKbn.HISAIGAI.eq(uiBean.getTokusinkbn())) { %>
              showKoumoku(<%=HSGYMD_TOKUSINSYORINYUURYOKUINFO%>);
          <% }%>
          showKoumoku(<%=TOKUSINENDYMD_TOKUSINSYORINYUURYOKUINFO%>);
    <% }%>
<% }%>

<%
   if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <%
    if (!BizUtil.isBlank(uiBean.getTyouhyouKey())) { %>
        openReport("print", "_blank");
    <% } %>
<% }%>
});
//-->
</script>
