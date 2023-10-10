<%--
    kh_tetuduki_tyuui.js.jsp - 契約保全手続注意設定 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page
  import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
  import="static yuyu.app.hozen.khozen.khtetudukityuui.KhTetudukiTyuuiConstants.*"%>
<%@page
  import="static yuyu.app.hozen.khozen.khtetudukityuui.KhTetudukiTyuuiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
  import="yuyu.app.hozen.khozen.khtetudukityuui.KhTetudukiTyuuiUiBean"%>
<%@page
  import="yuyu.app.hozen.khozen.khtetudukityuui.TtdkTyuui1DataSourceBean"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="yuyu.def.classification.C_KktyuitaKbn"%>
<%@page import="yuyu.def.classification.C_TtdktyuuiKbn"%>
<%@page import="java.util.List"%>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<% KhTetudukiTyuuiUiBean uiBean = SWAKInjector.getInstance(KhTetudukiTyuuiUiBean.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<% if (uiBean.getPageNo() == PAGENO_REFERENCE || uiBean.getPageNo() == PAGENO_CONFIRM
       || uiBean.getPageNo() == PAGENO_RESULT) { %>
<jsp:include
  page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp" />
<jsp:include
  page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp" />
<jsp:include
  page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp" />
<jsp:include
  page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp" />
 <jsp:include
  page="/WEB-INF/pages/appcommon/hozen/khview/viewtrkkazoku/view_trk_kazoku.js.jsp"/>
 <jsp:include
  page="/WEB-INF/pages/appcommon/hozen/khview/viewkyksyadairi/view_kyksyadairi.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){

    <% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>

        <% if (C_UmuKbn.ARI.eq(uiBean.getStknUmu())) { %>
            showGroup(<%= STKNSET %>);
        <% } %>

        showKoumoku(<%=KKTYUITAKBN_TTDKTYUUI %>);
        showKoumoku(<%=TTDKTYUUINAIYOU1_TTDKTYUUI %>);
        showKoumoku(<%=TTDKTYUUINAIYOU2_TTDKTYUUI %>);
        showKoumoku(<%=TTDKTYUUINAIYOU3_TTDKTYUUI %>);

        var fatcaSize = <%= uiBean.getRecordkensuu()%>;
        if (fatcaSize == 1) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
        }else if (fatcaSize == 2) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
            showGroup(<%= FATCATAISYOUSYA2 %>);
        }else if (fatcaSize == 3) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
            showGroup(<%= FATCATAISYOUSYA2 %>);
            showGroup(<%= FATCATAISYOUSYA3 %>);
        }else if (fatcaSize == 4) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
            showGroup(<%= FATCATAISYOUSYA2 %>);
            showGroup(<%= FATCATAISYOUSYA3 %>);
            showGroup(<%= FATCATAISYOUSYA4 %>);
        }else if (fatcaSize == 5) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
            showGroup(<%= FATCATAISYOUSYA2 %>);
            showGroup(<%= FATCATAISYOUSYA3 %>);
            showGroup(<%= FATCATAISYOUSYA4 %>);
            showGroup(<%= FATCATAISYOUSYA5 %>);
            $(<%=ADDBTNBUTTONS%>).visible(false);
        }

        var aeoiSize = <%= uiBean.getAeoirecordkensuu()%>;
        if (aeoiSize == 1) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
        }else if (aeoiSize == 2) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
            showGroup(<%= AEOITAISYOUSYA2 %>);
        }else if (aeoiSize == 3) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
            showGroup(<%= AEOITAISYOUSYA2 %>);
            showGroup(<%= AEOITAISYOUSYA3 %>);
        }else if (aeoiSize == 4) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
            showGroup(<%= AEOITAISYOUSYA2 %>);
            showGroup(<%= AEOITAISYOUSYA3 %>);
            showGroup(<%= AEOITAISYOUSYA4 %>);
        }else if (aeoiSize == 5) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
            showGroup(<%= AEOITAISYOUSYA2 %>);
            showGroup(<%= AEOITAISYOUSYA3 %>);
            showGroup(<%= AEOITAISYOUSYA4 %>);
            showGroup(<%= AEOITAISYOUSYA5 %>);
            $(<%=AEOIADDBTNBUTTONS%>).visible(false);
        }
        showList(<%=TTDKTYUUI1 %>);

       <%
          if (C_UmuKbn.ARI.eq(uiBean.getKykdrtkykumu())) { %>
             showGroup(<%= KYKDRJTINFO %>);
       <% } %>

    <% } %>

    <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
        var layoutFlg = false;
        <% if (C_KktyuitaKbn.DNGNMEMONASI.eq(uiBean.getKktyuitakbn())
            || C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getKktyuitakbn())) { %>

            showKoumoku(<%=KKTYUITAKBN_TTDKTYUUI %>);
            showKoumoku(<%=TTDKTYUUINAIYOU1_TTDKTYUUI %>);
            showKoumoku(<%=TTDKTYUUINAIYOU2_TTDKTYUUI %>);
            showKoumoku(<%=TTDKTYUUINAIYOU3_TTDKTYUUI %>);
            layoutFlg = false;
        <%} else {%>
          layoutFlg = true;
        <%}%>

        <% List<TtdkTyuui1DataSourceBean> ttdkTyuui1DataLst = uiBean.getTtdkTyuui1DataSource().getDatas(); %>
        <% if (ttdkTyuui1DataLst.size() > 0 && !C_TtdktyuuiKbn.BLNK.eq(ttdkTyuui1DataLst.get(0).getTtdktyuuikbn())) { %>
         if (layoutFlg == true) {
            $(<%= TTDKTYUUI1 + DIV%>).css("margin-top", "0px");
            layoutFlg = false;
         }
         showList(<%=TTDKTYUUI1 %>);
        <% } %>

        <% if (C_UmuKbn.ARI.eq(uiBean.getStknUmu())) { %>
         if (layoutFlg == true) {
            $(<%= STKNSET + DIV%>).css("margin-top", "0px");
         }
         showGroup(<%= STKNSET %>);
        <% } %>

        var fatcaSize = <%= uiBean.getRecordkensuu()%>;
        if (fatcaSize == 1) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
        }else if (fatcaSize == 2) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
            showGroup(<%= FATCATAISYOUSYA2 %>);
        }else if (fatcaSize == 3) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
            showGroup(<%= FATCATAISYOUSYA2 %>);
            showGroup(<%= FATCATAISYOUSYA3 %>);
        }else if (fatcaSize == 4) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
            showGroup(<%= FATCATAISYOUSYA2 %>);
            showGroup(<%= FATCATAISYOUSYA3 %>);
            showGroup(<%= FATCATAISYOUSYA4 %>);
        }else if (fatcaSize == 5) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
            showGroup(<%= FATCATAISYOUSYA2 %>);
            showGroup(<%= FATCATAISYOUSYA3 %>);
            showGroup(<%= FATCATAISYOUSYA4 %>);
            showGroup(<%= FATCATAISYOUSYA5 %>);
        }

        var aeoiSize = <%= uiBean.getAeoirecordkensuu()%>;
        if (aeoiSize == 1) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
        }else if (aeoiSize == 2) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
            showGroup(<%= AEOITAISYOUSYA2 %>);
        }else if (aeoiSize == 3) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
            showGroup(<%= AEOITAISYOUSYA2 %>);
            showGroup(<%= AEOITAISYOUSYA3 %>);
        }else if (aeoiSize == 4) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
            showGroup(<%= AEOITAISYOUSYA2 %>);
            showGroup(<%= AEOITAISYOUSYA3 %>);
            showGroup(<%= AEOITAISYOUSYA4 %>);
        }else if (aeoiSize == 5) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
            showGroup(<%= AEOITAISYOUSYA2 %>);
            showGroup(<%= AEOITAISYOUSYA3 %>);
            showGroup(<%= AEOITAISYOUSYA4 %>);
            showGroup(<%= AEOITAISYOUSYA5 %>);
        }

       <%
          if (C_UmuKbn.ARI.eq(uiBean.getKykdrtkykumu())) { %>
             showGroup(<%= KYKDRJTINFO %>);
       <% } %>

    <% } %>

    <%
    if (uiBean.getPageNo() == PAGENO_RESULT) { %>
      <%
      if (C_UmuKbn.ARI.eq(uiBean.getTyouhyoumukbn())) { %>
          openReport("print", "_blank");
      <% } %>
    <% } %>

    var fatcaSize = <%= uiBean.getRecordkensuu()%>;
    $(<%= ADDBTN_ADDBTNBUTTONS %>).click(function() {

        fatcaSize++;

        if (fatcaSize == 1) {
            showGroup(<%= FATCATAISYOUSYA1 %>);
        }else if (fatcaSize == 2) {
            showGroup(<%= FATCATAISYOUSYA2 %>);
        }else if (fatcaSize == 3) {
            showGroup(<%= FATCATAISYOUSYA3 %>);
        }else if (fatcaSize == 4) {
            showGroup(<%= FATCATAISYOUSYA4 %>);
        }else if (fatcaSize == 5) {
            showGroup(<%= FATCATAISYOUSYA5 %>);
            $(<%=ADDBTNBUTTONS%>).visible(false);
        }

        $(<%=RECORDKENSUU_FATCAKENSUU%>).attr("value", fatcaSize);
    });

    var aeoiSize = <%= uiBean.getAeoirecordkensuu()%>;
    $(<%= ADDBTNBYAEOI_AEOIADDBTNBUTTONS %>).click(function() {

        aeoiSize++;

        if (aeoiSize == 1) {
            showGroup(<%= AEOITAISYOUSYA1 %>);
        }else if (aeoiSize == 2) {
            showGroup(<%= AEOITAISYOUSYA2 %>);
        }else if (aeoiSize == 3) {
            showGroup(<%= AEOITAISYOUSYA3 %>);
        }else if (aeoiSize == 4) {
            showGroup(<%= AEOITAISYOUSYA4 %>);
        }else if (aeoiSize == 5) {
            showGroup(<%= AEOITAISYOUSYA5 %>);
            $(<%=AEOIADDBTNBUTTONS%>).visible(false);
        }

        $(<%=AEOIRECORDKENSUU_AEOIKENSUU%>).attr("value", aeoiSize);
    });
});
//-->
</script>
