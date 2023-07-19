<%--
    view_uketorinin_sb.js.jsp - 死亡保険金受取人情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page import="static yuyu.common.siharai.siview.viewuketorininsb.ViewUketorininSBSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.common.siharai.siview.viewuketorininsb.ViewUketorininSBUiBeanParam"%>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean"%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.def.classification.C_UktKbn"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewuketorininsb/view_uketorinin_sb.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewUketorininSBUiBeanParam viewUketorininSBUiBeanParam = (ViewUketorininSBUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
 <%
    if (viewUketorininSBUiBeanParam.isViewUketorininsbSeigyo()) {
  %>

    <%
    if (viewUketorininSBUiBeanParam.isSbuktninHyojiHantei()) {
  %>
    showGroup(<%=UKETORININSBINFO%>);
    $(<%=UKETORININSBINFO1 + LABEL%>).text("");
  <%}%>

  <%
  if (!C_UktKbn.BLNK.eq(viewUketorininSBUiBeanParam.getDispsbuktkbn1())) { %>
     showGroup(<%=UKETORININSBINFO1%>);

     <%
    if(!BizUtil.isBlank(viewUketorininSBUiBeanParam.getDispsbuktnmkn1())){
    %>
    showKoumoku(<%=DISPSBUKTNMKN1_UKETORININSBINFO1%>)
    <%}%>

    <%
    if(!BizUtil.isBlank(viewUketorininSBUiBeanParam.getDispsbuktnmkj1())){
    %>
    showKoumoku(<%=DISPSBUKTNMKJ1_UKETORININSBINFO1%>)
    <%}%>

    <%
    if(viewUketorininSBUiBeanParam.getDispsbuktseiymd1() != null){
    %>
    showKoumoku(<%=DISPSBUKTSEIYMD1_UKETORININSBINFO1%>)
    <%}%>

     <%
     if(!viewUketorininSBUiBeanParam.getDispsbuktbnwari1().isZeroOrOptional() && viewUketorininSBUiBeanParam.getDispsbuktbnwari1() != null){
     %>
         showKoumoku(<%=DISPSBUKTBNWARI1_UKETORININSBINFO1%>)
    <%}%>

 <%}%>

 <%
  if (!C_UktKbn.BLNK.eq(viewUketorininSBUiBeanParam.getDispsbuktkbn2())) { %>
    showGroup(<%=UKETORININSBINFO2%>);
    <%
    if(!BizUtil.isBlank(viewUketorininSBUiBeanParam.getDispsbuktnmkn2())){
    %>
    showKoumoku(<%=DISPSBUKTNMKN2_UKETORININSBINFO2%>)
    <%}%>

    <%
    if(!BizUtil.isBlank(viewUketorininSBUiBeanParam.getDispsbuktnmkj2())){
    %>
    showKoumoku(<%=DISPSBUKTNMKJ2_UKETORININSBINFO2%>)
    <%}%>

    <%
    if(viewUketorininSBUiBeanParam.getDispsbuktseiymd2() != null){
    %>
    showKoumoku(<%=DISPSBUKTSEIYMD2_UKETORININSBINFO2%>)
    <%}%>

     <%
     if(!viewUketorininSBUiBeanParam.getDispsbuktbnwari2().isZeroOrOptional() && viewUketorininSBUiBeanParam.getDispsbuktbnwari2() != null){
     %>
         showKoumoku(<%=DISPSBUKTBNWARI2_UKETORININSBINFO2%>)
    <%}%>
<%}%>

 <%
  if (!C_UktKbn.BLNK.eq(viewUketorininSBUiBeanParam.getDispsbuktkbn3())) { %>
     showGroup(<%=UKETORININSBINFO3%>);
     <%
    if(!BizUtil.isBlank(viewUketorininSBUiBeanParam.getDispsbuktnmkn3())){
    %>
    showKoumoku(<%=DISPSBUKTNMKN3_UKETORININSBINFO3%>)
    <%}%>

    <%
    if(!BizUtil.isBlank(viewUketorininSBUiBeanParam.getDispsbuktnmkj3())){
    %>
    showKoumoku(<%=DISPSBUKTNMKJ3_UKETORININSBINFO3%>)
    <%}%>

    <%
    if(viewUketorininSBUiBeanParam.getDispsbuktseiymd3() != null){
    %>
    showKoumoku(<%=DISPSBUKTSEIYMD3_UKETORININSBINFO3%>)
    <%}%>

     <%
     if(!viewUketorininSBUiBeanParam.getDispsbuktbnwari3().isZeroOrOptional() && viewUketorininSBUiBeanParam.getDispsbuktbnwari3() != null){
     %>
         showKoumoku(<%=DISPSBUKTBNWARI3_UKETORININSBINFO3%>)
    <%}%>
<%}%>

 <%
  if (!C_UktKbn.BLNK.eq(viewUketorininSBUiBeanParam.getDispsbuktkbn4())) { %>
    showGroup(<%=UKETORININSBINFO4%>);
     <%
    if(!BizUtil.isBlank(viewUketorininSBUiBeanParam.getDispsbuktnmkn4())){
    %>
    showKoumoku(<%=DISPSBUKTNMKN4_UKETORININSBINFO4%>)
    <%}%>

    <%
    if(!BizUtil.isBlank(viewUketorininSBUiBeanParam.getDispsbuktnmkj4())){
    %>
    showKoumoku(<%=DISPSBUKTNMKJ4_UKETORININSBINFO4%>)
    <%}%>

    <%
    if(viewUketorininSBUiBeanParam.getDispsbuktseiymd4() != null){
    %>
    showKoumoku(<%=DISPSBUKTSEIYMD4_UKETORININSBINFO4%>)
    <%}%>

     <%
     if(!viewUketorininSBUiBeanParam.getDispsbuktbnwari4().isZeroOrOptional() && viewUketorininSBUiBeanParam.getDispsbuktbnwari4() != null){
     %>
         showKoumoku(<%=DISPSBUKTBNWARI4_UKETORININSBINFO4%>)
    <%}%>
  <%}%>
<%}%>

});
</script>
