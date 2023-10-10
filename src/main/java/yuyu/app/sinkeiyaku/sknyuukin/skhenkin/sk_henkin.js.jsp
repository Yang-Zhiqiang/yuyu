<%--
    sk_henkin.js.jsp - 返金入力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.skhenkin.SkHenkinConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.skhenkin.SkHenkinSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sknyuukin.skhenkin.SkHenkinUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_SkkinouModeIdKbn" %>
<%@page import="yuyu.def.classification.C_KidougmKbn" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<% SkHenkinUiBean uiBean = SWAKInjector.getInstance(SkHenkinUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>
<% commonViewInBean.setCommonViewUiBeanParam(uiBean); %>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
   <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>
<script type="text/javascript">
$(function(){


   <%
   if (uiBean.getPageNo() == PAGENO_INPUTKEY) {%>
     <%
     if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
        $(<%= TOUROKUBTN_FOOTERBUTTONS %>).visible(true);
     <%}%>
     <%
     if (C_SkkinouModeIdKbn.HENKINKIBOU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
        $(<%= HENKINKIBOUBTN_FOOTERBUTTONS %>).visible(true);
     <%}%>
   <%}%>

  <%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
     <%
     if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
        showKoumoku(<%= HNKNGK_HENKININFO %>);
        showKoumoku(<%= HNKNHOUKBN_HENKININFO %>);
        showGroup(<%= BANKINFO %>);
     <%}%>

     <%
     if (C_SkkinouModeIdKbn.HENKINKIBOU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
        showKoumoku(<%= HNKNKIBOUGK_HENKININFO %>);
        $(<%=BANKINFO + DIV %>).visible(false);
     <%}%>

     <%
     if (C_Tuukasyu.JPY.eq(uiBean.getTuukaSyu())) {%>
        $(<%= YOKINKBN_BANKINFO %>).disable(false);
      <%
      } else  { %>
        $(<%= YOKINKBN_BANKINFO %>).disable(true);
     <%}%>
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
     <%
     if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
        showKoumoku(<%= HNKNGK_HENKININFO %>);
        showKoumoku(<%= HNKNHOUKBN_HENKININFO %>);
        showGroup(<%= BANKINFO %>);
     <%}%>

     <%
     if (C_SkkinouModeIdKbn.HENKINKIBOU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
        showKoumoku(<%= HNKNKIBOUGK_HENKININFO %>);
        $(<%=BANKINFO + DIV %>).visible(false);
     <%}%>
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_RESULT) { %>
     <%
     String[] hubiMsgs = uiBean.getHubimsgData();
     String msgId = "";
     if (hubiMsgs != null && hubiMsgs.length != 0 && hubiMsgs[0].length() != 0) {
         String[] hubiMsg = hubiMsgs[0].split(" ");
         msgId = hubiMsg[1];
     }
     %>
     changeErrMsg('<%= msgId %>');

     <%
     if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
        showKoumoku(<%= HNKNGK_HENKININFO %>);
        showKoumoku(<%= HNKNHOUKBN_HENKININFO %>);
        showGroup(<%= BANKINFO %>);
     <%}%>

     <%
     if (C_SkkinouModeIdKbn.HENKINKIBOU.getValue().equals(uiBean.getKinouMode().getKinouMode())) {%>
        showKoumoku(<%= HNKNKIBOUGK_HENKININFO %>);
        $(<%=BANKINFO + DIV %>).visible(false);
     <%}%>
  <% } %>

});
</script>
