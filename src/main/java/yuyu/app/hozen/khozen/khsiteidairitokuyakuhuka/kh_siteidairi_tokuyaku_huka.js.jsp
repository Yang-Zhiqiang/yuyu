<%--
    kh_siteidairi_tokuyaku_huka.js.jsp - 被保険者代理特約中途付加 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page
  import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
  import="static yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka.KhSiteidairiTokuyakuHukaConstants.*"%>
<%@page
  import="static yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka.KhSiteidairiTokuyakuHukaSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
  import="yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka.KhSiteidairiTokuyakuHukaUiBean"%>
<%@page import="yuyu.infr.kinoumode.KinouMode"%>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn"%>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn"%>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<% KhSiteidairiTokuyakuHukaUiBean uiBean = SWAKInjector.getInstance(KhSiteidairiTokuyakuHukaUiBean.class); %>
<% KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
    || uiBean.getPageNo() == PAGENO_REFERENCE
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
        || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
        || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

  <jsp:include
    page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp" />
  <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS
    || uiBean.getPageNo() == PAGENO_REFERENCE
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT
    || uiBean.getPageNo() == PAGENO_SKSCONFIRM
    || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewnkukt/view_nkukt.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewsbhkukt/view_sb_hkukt.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp" />

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp" />
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
       || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
       || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

    <jsp:include
    page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp" />
    <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE
    || uiBean.getPageNo() == PAGENO_CONFIRM
    || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
        || !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

  <jsp:include
    page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp" />
  <% } %>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_SKSCONFIRM
    || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
<jsp:include
  page="/WEB-INF/pages/appcommon/hozen/khview/viewhituyousyorui/view_hituyou_syorui.js.jsp" />
<% } %>

<script type="text/javascript"><!--
$(function(){

<%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
   <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=STDRSKTKYHNKNYINFO %>);
   <%
    } else { %>
       <% if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

          showGroup(<%=STDRSKTKYHNKNYINFO %>);
          inputToOutput(<%=KHSTDRSKTKYHNKKBN_STDRSKTKYHNKNYINFO %>);
       <% } %>
   <% } %>

   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=KOUTEIINFO %>);
   <% } %>
<%
 } else if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
   <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
      || !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

      showGroup(<%=STDRSKTKYHNKNYINFO %>);
   <% } %>

   <% if (C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

      $(<%= SKSSAKUSEIBTN_REFERENCEBUTTONS%>).visible(true);
   <% } %>

   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=SITEISEIKYUUINFO %>);
      showGroup(<%=HONNININFO %>);
      showGroup(<%=HASSOUKBNGROUP %>);
      showKoumoku(<%=STDRSKNMKJKHUKA_SITEISEIKYUUINFO %>);
      $(<%= IIC0004%>).visible(true);
      $(<%= STDRSKNMKJHUKAKBN_SITEISEIKYUUINFO%>).visible(false);

   <%
    } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
          && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

          showGroup(<%=SITEISEIKYUUINFO %>);
          inputToOutput(<%=STDRUKTKBN_SITEISEIKYUUINFO %>);
          inputToOutput(<%=STDRSKNMKN_SITEISEIKYUUINFO %>);
          inputToOutput(<%=STDRSKNMKJ_SITEISEIKYUUINFO %>);
          $(<%= STDRSKNMKJKHUKA_SITEISEIKYUUINFO%>).parent().visible(false);
          $(<%= IIC0004%>).visible(false);
          inputToOutput("#stdrskseiymdSpan > *");

          showGroup(<%=HONNININFO %>);
          inputToOutput(<%=HONNINKAKNINKEKKAKBN_HONNININFO %>);

          showGroup(<%=HASSOUKBNGROUP %>);
          inputToOutput(<%=HASSOUKBN_HASSOUKBNGROUP %>);
   <% } %>

   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=KEKKAINPUTGROUP %>);
   <%
    } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=KEKKAINPUTGROUP %>);
      showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP %>);
   <% } %>

   <% if (!C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) { %>

       showGroup(<%=FOOTERBUTTONS3 %>);
   <% } %>

   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=KOUTEIINFO %>);
   <% } %>
<%
 } else if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
      || !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) { %>

       showGroup(<%=STDRSKTKYHNKNYINFO %>);
       showGroup(<%=SITEISEIKYUUINFO %>);
       showGroup(<%=HONNININFO %>);
       showGroup(<%=HASSOUKBNGROUP %>);
    <% } %>

    <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=KEKKAINPUTGROUP %>);
    <%
     } else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=KEKKAINPUTGROUP %>);
      showKoumoku(<%=SASIMODOSISAKIKBN_KEKKAINPUTGROUP %>);
    <% } %>

   <% if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
      || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) { %>

      showGroup(<%=KOUTEIINFO %>);
   <% } %>
<%
 } else if (uiBean.getPageNo() == PAGENO_SKSCONFIRM || uiBean.getPageNo() == PAGENO_SKSRESULT) { %>

       showGroup(<%=STDRSKTKYHNKNYINFO %>);
<% } %>

<% if (uiBean.getPageNo() == PAGENO_SKSRESULT) { %>
    openReport("print", "_blank");
<% } %>

});
//-->
</script>
