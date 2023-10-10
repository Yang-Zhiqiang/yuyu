<%--
    kh_tmttkin_iten.js.jsp - 積立金移転 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khtmttkiniten.KhTmttkinItenConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khtmttkiniten.KhTmttkinItenSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khtmttkiniten.KhTmttkinItenUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.infr.kinoumode.KinouMode" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>

<% KhTmttkinItenUiBean uiBean = SWAKInjector.getInstance(KhTmttkinItenUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);%>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<%
  if (uiBean.getPageNo() != PAGENO_INPUTKEY) { %>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp" />
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp" />
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>

    <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
          <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
          <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
    <% } %>
<% } %>


<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      <%
      if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
          C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
          <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
   <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_REFERENCE ||
      uiBean.getPageNo() == PAGENO_CONFIRM ||
      uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%
      if (!(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
          C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn()))) {%>
          <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
  <% } %>
<% } %>

<%
  if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
      uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
      <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp"/>
<% } %>

<script type="text/javascript"><!--
$(function(){
<%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS){
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
            showGroup(<%= KOUTEIINFO %>);
        <% } %>

        <%
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
            showGroup(<%= KHTMTTKINITENNAIYOUINFO %>);
            showGroup(<%= KHTMTTKINITENNYUURYOKUINFO %>);
        <% } %>
        <%
        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) { %>
            showGroup(<%= KHTMTTKINITENNAIYOUINFO %>);
            showGroup(<%= KHTMTTKINITENNYUURYOKUINFO %>);
           inputToOutput(<%= TMTTKNITENKBN_KHTMTTKINITENNAIYOUINFO %>);
           inputToOutput("#syoruiukeymdSpan > *");
     <% } %>
<% } %>

<%
    if (uiBean.getPageNo() == PAGENO_REFERENCE) {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
            showGroup(<%= KOUTEIINFO %>);
        <% } %>

        <%
            if(!(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn()))) { %>
                showGroup(<%= KHTMTTKINITENNAIYOUINFO %>);
                showGroup(<%= KHTMTTKINITENNYUURYOKUINFO %>);
        <% } %>

        <%
            if(C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
               C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
             $(<%= SKSSAKUSEIBTN_REFERENCEBUTTONS %>).visible(true);
        <% } %>

        <%
            if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>
              showGroup(<%= HONNININFO %>);

              showGroup(<%= HASSOUKBNGROUP %>);

              showGroup(<%= KEKKAINPUTGROUP %>);
        <% } %>

        <%
            if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
               !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) { %>
                showGroup(<%= HONNININFO %>);
                inputToOutput(<%= HONNINKAKNINKEKKAKBN_HONNININFO %>);

                 showGroup(<%= HASSOUKBNGROUP %>);
                 inputToOutput(<%= HASSOUKBN_HASSOUKBNGROUP %>);
        <% } %>

        <%
            if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
                showGroup(<%=KEKKAINPUTGROUP%>);
                showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
        <% } %>

        <%
            if (!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>
                showGroup(<%= FOOTERBUTTONS3 %>);
        <% } %>
<% } %>

<%
    if (uiBean.getPageNo() == PAGENO_CONFIRM ||
        uiBean.getPageNo() == PAGENO_RESULT) {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>
            showGroup(<%=KOUTEIINFO%>);
        <% } %>

        <%
            if(!(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn()))) { %>
                showGroup(<%= KHTMTTKINITENNAIYOUINFO %>);
                showGroup(<%= KHTMTTKINITENNYUURYOKUINFO %>);

                showGroup(<%= HONNININFO %>);
                showGroup(<%= HASSOUKBNGROUP %>);
      <% } %>

      <%
          if(C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
             C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {%>
              showGroup(<%=KEKKAINPUTGROUP%>);
      <% } %>

      <%
          if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {%>
            showGroup(<%=KEKKAINPUTGROUP%>);
            showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP%>);
      <% } %>
<% } %>

<%
    if (uiBean.getPageNo() == PAGENO_SKSCONFIRM ||
        uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
        showGroup(<%= KHTMTTKINITENNAIYOUINFO %>);
        showGroup(<%= KHTMTTKINITENNYUURYOKUINFO %>);
<% } %>

<%
    if (uiBean.getPageNo() == PAGENO_SKSRESULT) {  %>
        <%
            if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoUmuKbn())) { %>
                openReport("print", "_blank");
           <% } %>
 <% } %>
});
//-->
</script>
