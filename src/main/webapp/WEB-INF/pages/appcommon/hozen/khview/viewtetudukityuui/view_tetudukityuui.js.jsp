<%--
    view_tetudukityuui.js.jsp - 手続注意情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_KktyuitaKbn" %>
<%@page import="yuyu.def.classification.C_StknsetKbn" %>
<%@page import="yuyu.def.classification.C_FatcakekKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewTetudukityuuiUiBeanParam viewTetudukityuuiUiBean = (ViewTetudukityuuiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();

%>
<script type="text/javascript">

function varElmAddTopBottomLink(idSelecterList){
    var groupSelecter = idSelecterList.join(',');
    var targetId = $(groupSelecter).filter(':visible').last().attr('id');
    addTopBottomLink('#' + targetId);
}

$(function(){
  var layoutFlg = false;
  <%
    if (!C_KktyuitaKbn.BLNK.eq(viewTetudukityuuiUiBean.getVtdktkktyuitakbn()) ||
        (viewTetudukityuuiUiBean.getTtdktyuuikbnInfoDataSource().getDatas() != null && viewTetudukityuuiUiBean.getTtdktyuuikbnInfoDataSource().getDatas().size() >0) ||
        C_StknsetKbn.ARI.eq(viewTetudukityuuiUiBean.getVtdktstknsetkbn()) ||
        !C_FatcakekKbn.BLNK.eq(viewTetudukityuuiUiBean.getVtdktdispfatcakekkbn1())) {
  %>
      <%
        if(!C_KktyuitaKbn.BLNK.eq(viewTetudukityuuiUiBean.getVtdktkktyuitakbn())){
      %>
         showGroup(<%=TETUDUKITYUUIINFO%>);
          showKoumoku(<%=VTDKTKKTYUITAKBN_TETUDUKITYUUIINFO%>);
          showKoumoku(<%=VTDKTTTDKTYUUINAIYOU1_TETUDUKITYUUIINFO%>);
          layoutFlg = false;
      <%} else {%>
          layoutFlg = true;
      <%}%>

      <%
        if(viewTetudukityuuiUiBean.getTtdktyuuikbnInfoDataSource().getDatas() != null && viewTetudukityuuiUiBean.getTtdktyuuikbnInfoDataSource().getDatas().size() >0) {
      %>
          if (layoutFlg == true) {
            showGroup(<%=TETUDUKITYUUIINFO%>);
            $(<%= TTDKTYUUIKBNINFO + DIV%>).css("margin-top", "0px");
          }
          layoutFlg = false;
          showList(<%=TTDKTYUUIKBNINFO%>);
      <%}%>

      <%
        if (C_StknsetKbn.ARI.eq(viewTetudukityuuiUiBean.getVtdktstknsetkbn())) {
      %>
          if (layoutFlg == true) {
            showGroup(<%=TETUDUKITYUUIINFO%>);
            $(<%= STKNSETINFO + DIV%>).css("margin-top", "0px");
          }
          showGroup(<%=STKNSETINFO%>);
      <%}%>

    <%
      if (!C_FatcakekKbn.BLNK.eq(viewTetudukityuuiUiBean.getVtdktdispfatcakekkbn1())) {
    %>
      showGroup(<%=DISPFATCAINFO1%>);

       <%
         if (!C_FatcakekKbn.BLNK.eq(viewTetudukityuuiUiBean.getVtdktdispfatcakekkbn2())) {
       %>
         showGroup(<%=DISPFATCAINFO2%>);
       <%}%>

       <%
         if (!C_FatcakekKbn.BLNK.eq(viewTetudukityuuiUiBean.getVtdktdispfatcakekkbn3())) {
       %>
         showGroup(<%=DISPFATCAINFO3%>);
       <%}%>

       <%
         if (!C_FatcakekKbn.BLNK.eq(viewTetudukityuuiUiBean.getVtdktdispfatcakekkbn4())) {
       %>
         showGroup(<%=DISPFATCAINFO4%>);
       <%}%>

       <%
         if (!C_FatcakekKbn.BLNK.eq(viewTetudukityuuiUiBean.getVtdktdispfatcakekkbn5())) {
       %>
         showGroup(<%=DISPFATCAINFO5%>);
       <%}%>

    <%}%>

    <%
      if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {
    %>
      varElmAddTopBottomLink([
        <%= TETUDUKITYUUIINFO %>,
        <%= TTDKTYUUIKBNINFO %>,
        <%= STKNSETINFO %>,
        <%= DISPFATCAINFO1 %>,
        <%= DISPFATCAINFO2 %>,
        <%= DISPFATCAINFO3 %>,
        <%= DISPFATCAINFO4 %>,
        <%= DISPFATCAINFO5 %>
      ]);

    <%}%>

  <%}%>


});


</script>
