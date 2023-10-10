<%--
    kh_rinji_uriage_seikyuu_uketuke.js.jsp - 臨時売上請求受付 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke.KhRinjiUriageSeikyuuUketukeConstants.*" %>
<%@page import="static yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke.KhRinjiUriageSeikyuuUketukeSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke.KhRinjiUriageSeikyuuUketukeUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<% KhRinjiUriageSeikyuuUketukeUiBean uiBean = SWAKInjector.getInstance(KhRinjiUriageSeikyuuUketukeUiBean.class); %>
<%
  CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
  commonViewInBean.setCommonViewUiBeanParam(uiBean);
  commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>
<%
  if (uiBean.getPageNo() != PAGENO_INPUTKEY ) { %>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewharaikomiinfo/view_haraikomi_info.js.jsp"/>
    <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkariukekin/view_kariukekin.js.jsp"/>
<% } %>

<script type="text/javascript"><!--
$(function(){
});
//-->
</script>
