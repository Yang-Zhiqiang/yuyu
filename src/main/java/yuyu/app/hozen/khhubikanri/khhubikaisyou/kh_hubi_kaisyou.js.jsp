<%--
    kh_hubi_kaisyou.js.jsp - 契約保全不備解消 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khhubikanri.khhubikaisyou.KhHubiKaisyouConstants.*" %>
<%@page import="static yuyu.app.hozen.khhubikanri.khhubikaisyou.KhHubiKaisyouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khhubikanri.khhubikaisyou.KhHubiKaisyouUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_KidougmKbn"%>
<%@page import="yuyu.def.classification.C_KhkinouModeIdKbn"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="java.util.List" %>
<%@page import="yuyu.def.classification.C_KaisyoutaisyouKbn" %>
<%@page import="yuyu.app.hozen.khhubikanri.khhubikaisyou.MikaisyouhubiListDataSourceBean" %>
<% KhHubiKaisyouUiBean uiBean = SWAKInjector.getInstance(KhHubiKaisyouUiBean.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewprogresshistory/view_progress_history.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
<% } %>

<script type="text/javascript"><!--
$(function(){
   <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
        $(<%= KAISYOUDISPKAISYOUTAISYOUKBN_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPTRKYMD_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHUBINAIYOUMSG_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPGENPONHNKYKUMU_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHASSINYMD_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHASSINSAKIKBN_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPKAISYOUYMD_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPSYOUNINTANTOUNM_LABEL %>).attr("colspan","1");

        $(<%= MIKAISYOUDISPKAISYOUTAISYOU_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPTRKYMD_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHUBINAIYOUMSG_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPGENPONHNKYKUMU_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHASSINYMD_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHASSINSAKIKBN_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPKAISYOUYMD_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPSYOUNINTANTOUNM_LABEL %>).attr("colspan","1");

        $(<%= KAISYOUDISPKAISYOUTAISYOUKBN_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPTRKYMD_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHUBINAIYOUMSG_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPGENPONHNKYKUMU_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHASSINYMD_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHASSINSAKIKBN_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPKAISYOUYMD_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPSYOUNINTANTOUNM_DATA %>).attr("colspan","1");

        $(<%= MIKAISYOUDISPKAISYOUTAISYOU_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPTRKYMD_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHUBINAIYOUMSG_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPGENPONHNKYKUMU_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHASSINYMD_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHASSINSAKIKBN_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPKAISYOUYMD_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPSYOUNINTANTOUNM_DATA %>).attr("colspan","1");

   <% } else if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

        $(<%= KAISYOUDISPKAISYOUTAISYOUKBN_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPTRKYMD_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHUBINAIYOUMSG_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPGENPONHNKYKUMU_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHASSINYMD_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHASSINSAKIKBN_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPKAISYOUYMD_LABEL %>).attr("rowspan","2");
        $(<%= KAISYOUDISPSYOUNINTANTOUNM_LABEL %>).attr("colspan","1");

        $(<%= MIKAISYOUDISPKAISYOUTAISYOUKBN_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPTRKYMD_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHUBINAIYOUMSG_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPGENPONHNKYKUMU_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHASSINYMD_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHASSINSAKIKBN_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPKAISYOUYMD_LABEL %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPSYOUNINTANTOUNM_LABEL %>).attr("colspan","1");

        $(<%= KAISYOUDISPKAISYOUTAISYOUKBN_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPTRKYMD_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHUBINAIYOUMSG_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPGENPONHNKYKUMU_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHASSINYMD_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPHASSINSAKIKBN_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPKAISYOUYMD_DATA %>).attr("rowspan","2");
        $(<%= KAISYOUDISPSYOUNINTANTOUNM_DATA %>).attr("colspan","1");

        $(<%= MIKAISYOUDISPKAISYOUTAISYOUKBN_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPTRKYMD_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHUBINAIYOUMSG_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPGENPONHNKYKUMU_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHASSINYMD_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPHASSINSAKIKBN_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPKAISYOUYMD_DATA %>).attr("rowspan","2");
        $(<%= MIKAISYOUDISPSYOUNINTANTOUNM_DATA %>).attr("colspan","1");

   <% } %>

  <% if ((uiBean.getPageNo() == PAGENO_CONFIRM) ||  (uiBean.getPageNo() == PAGENO_RESULT)) { %>
    <% List<MikaisyouhubiListDataSourceBean> mikaisyouhubiListDataSourceBeanLst = uiBean.getMikaisyouhubiListDataSource().getAllData();
       for (int iCnt = 0; iCnt < mikaisyouhubiListDataSourceBeanLst.size(); iCnt++ ) { %>
         <% MikaisyouhubiListDataSourceBean mikaisyouhubiListDataSourceBean = mikaisyouhubiListDataSourceBeanLst.get(iCnt);
         if (C_KaisyoutaisyouKbn.TAISYOU.eq(mikaisyouhubiListDataSourceBean.getDispkaisyoutaisyoukbn())) {%>
              $(<%= DISPKAISYOUYMD_MIKAISYOUHUBILIST(iCnt) %>).css({color:"red"});
       <%}%>
     <%}%>
 <% } %>


 <% if ((uiBean.getPageNo() == PAGENO_INPUTCONTENTS) || (uiBean.getPageNo() == PAGENO_CONFIRM) ||  (uiBean.getPageNo() == PAGENO_RESULT)) { %>
     <% for(int i = 0; i < uiBean.getKaisyouzumihubiListDataSource().getAllData().size(); i++){ %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getKaisyouzumihubiListDataSource().getAllData().get(i).getDispgenponhnkykumu())) { %>
        $('#kaisyouzumihubiList\\[<%= i %>\\]\\.dispgenponhnkykumu').text('●');
      <% } else  { %>
        $('#kaisyouzumihubiList\\[<%= i %>\\]\\.dispgenponhnkykumu').text('');
      <% } %>
    <% } %>

    <% for(int i = 0; i < uiBean.getMikaisyouhubiListDataSource().getAllData().size(); i++){ %>
      <% if (C_UmuKbn.ARI.eq(uiBean.getMikaisyouhubiListDataSource().getAllData().get(i).getDispgenponhnkykumu())) { %>
        $('#mikaisyouhubiList\\[<%= i %>\\]\\.dispgenponhnkykumu').text('●');
      <% } else  { %>
        $('#mikaisyouhubiList\\[<%= i %>\\]\\.dispgenponhnkykumu').text('');
      <% } %>
    <% } %>
  <% } %>

 <%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    $(<%= ALLCHECKBTN_CHECKBUTTONSK %>).click(function() {
      $("input[class='check']").each(function(){
       this.checked = true;
      });
    });

    $(<%= ALLUNCHECKBTN_CHECKBUTTONSK %>).click(function() {
      $("input[class='check']").each(function(){
       this.checked = false;
      });
    });
<% } %>

<%
   if (C_KhkinouModeIdKbn.DEFAULT.eq(uiBean.getKhkinouModeIdKbn()) || C_KhkinouModeIdKbn.INPUTKEY.eq(uiBean.getKhkinouModeIdKbn())) {%>
   $(<%= SYOKIGAMENHEWORKFLOW_BUTTON%>).visible(false);
<%
   } else {%>
   $(<%= SYOKIGAMENHEINPUTKEY_BUTTON%>).visible(false);
<% } %>

<% if (uiBean.getKaisyouzumihubiListDataSource().getAllData().size() > 0) {%>
   <% if ((uiBean.getPageNo() == PAGENO_INPUTCONTENTS) || (uiBean.getPageNo() == PAGENO_CONFIRM) ||  (uiBean.getPageNo() == PAGENO_RESULT)) {%>
       showList(<%=KAISYOUZUMIHUBILIST%>);
   <% } %>
<% } %>

<%
    if (E_SyoriKeiyu.ITIRAN == uiBean.getSyoriKeiyuKbn()) {
%>
        $(<%=MODORUBTNBYINPUTCONTENTS_FOOTERBUTTONS3%>).visible(false);
        $(<%=ITIRANHEBTNBYINPUTCONTENTS_FOOTERBUTTONS3%>).visible(true);
<%
    } else {
%>
        $(<%=MODORUBTNBYINPUTCONTENTS_FOOTERBUTTONS3%>).visible(true);
        $(<%=ITIRANHEBTNBYINPUTCONTENTS_FOOTERBUTTONS3%>).visible(false);
<%
    }
%>
});
//-->
</script>
