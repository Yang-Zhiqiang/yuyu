<%--
    kh_mkhgk_ttt_yendt_hnk_uktk.js.jsp - 目標額到達時円建変更受付 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk.KhMkhgkTttYendtHnkUktkConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk.KhMkhgkTttYendtHnkUktkSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk.KhMkhgkTttYendtHnkUktkUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.common.sinkeiyaku.skcommon.SyouhinUtil" %>
<% KhMkhgkTttYendtHnkUktkUiBean uiBean = SWAKInjector.getInstance(KhMkhgkTttYendtHnkUktkUiBean.class); %>

<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
    commonViewInBean.setCommonViewUiBeanParam(uiBean);
    commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<% if (uiBean.getPageNo() == PAGENO_REFERENCE ||
       uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT ) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkihon/view_kihon.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewbetukyk/view_betukyk.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtetudukityuui/view_tetudukityuui.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewkeiyakusya/view_keiyakusya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewtuusinsaki/view_tuusinsaki.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhihokensya/view_hihokensya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewhosyou/view_hosyou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/hozen/khview/viewsonotatk/view_sonota_tk.js.jsp"/>
<%}%>

<script type="text/javascript"><!--
$(function(){

<% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
  $(<%=SEARCHCONDITIONS + DIV%>).css("margin-top", "-1px");
<% }%>

  <%
  if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyohinHanteiKbn()) { %>

      showKoumoku(<%=MKHGKTTTKAIYAKUHR_MKHGKTTTNAIYOU%>);
      showKoumoku(<%=YENDTHNKSBHOKENKNGK_MKHGKTTTNAIYOU%>);
      showKoumoku(<%=YENDTHNKKAIYAKUHRGK_MKHGKTTTNAIYOU%>);
      showKoumoku(<%=YENDTHNKHRGK_MKHGKTTTNAIYOU%>);

  <%
  } else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyohinHanteiKbn()) { %>

      showKoumoku(<%=YENDTHNKKJNKNGK_MKHGKTTTNAIYOU%>);

  <%
   } else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn()) {%>

      showKoumoku(<%=YENDTHNKKJNKNGK_MKHGKTTTNAIYOU%>);

  <%}%>
});
//-->
</script>
