<%--
    kh_kz_seibi.js.jsp - 口座整備処理 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khkzseibi.KhKzSeibiConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khkzseibi.KhKzSeibiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khansyuu.khkzseibi.KhKzSeibiUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<% KhKzSeibiUiBean uiBean = SWAKInjector.getInstance(KhKzSeibiUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewdattai/view_dattai.js.jsp"/>
<% } %>
<script type="text/javascript">
$(function(){
<%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
     $(<%=NEWBANKCD_NEWKOUZAINFO%>).addClass('bfrFirstCell');
     $(<%=NEWSITENCD_NEWKOUZAINFO%>).addClass('bfrFirstCell');
<% } %>
});
</script>
