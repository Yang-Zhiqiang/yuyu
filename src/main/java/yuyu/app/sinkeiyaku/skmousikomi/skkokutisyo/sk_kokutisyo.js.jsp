<%--
    sk_kokutisyo.js.jsp - 告知書入力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo.SkKokutisyoConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo.SkKokutisyoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_KidougmKbn" %>
<%@page import="yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo.SkKokutisyoUiBean" %>
<% SkKokutisyoUiBean uiBean = SWAKInjector.getInstance(SkKokutisyoUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
   commonViewInBean.setCommonViewUiBeanParam(uiBean);
   commonViewInBean.setHyoujiptnKbn(C_HyoujiptnKbn.TUUJYOU);
%>

<% if ((uiBean.getPageNo() == PAGENO_INPUTCONTENTS) ||
     (uiBean.getPageNo() == PAGENO_CONFIRM) ||
     (uiBean.getPageNo() == PAGENO_RESULT) ) { %>
       <jsp:include page="/WEB-INF/pages/appcommon/biz/koutei/viewkouteiinfo/view_koutei_info.js.jsp"/>
<% }%>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
       <jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% }%>

<script type="text/javascript"><!--
$(function(){
    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {
           if ((uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD) && C_UmuKbn.ARI.eq(uiBean.getNyuryokuSaiUmu()) ) {
    %>
               $(<%= BUTTONNYUURYOKUSAISYOUKAI + DIV %>).visible(true);
       <%  }
    }
    %>

    <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
        <%
        String[] hubiMsgs = uiBean.getHubimsgData();
        String msgId = "";
        if (hubiMsgs != null && hubiMsgs.length != 0 && hubiMsgs[0].length() != 0) {
            String[] hubiMsg = hubiMsgs[0].split(" ");
            msgId = hubiMsg[1];
        }
        %>
        changeErrMsg('<%= msgId %>');
    <% } %>
});
//-->
</script>
