<%--
    sk_keiyaku_kakunin_kekka.js.jsp - 契約確認結果入力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka.SkKeiyakuKakuninKekkaConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka.SkKeiyakuKakuninKekkaSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka.SkKeiyakuKakuninKekkaUiBean" %>
<% SkKeiyakuKakuninKekkaUiBean uiBean = SWAKInjector.getInstance(SkKeiyakuKakuninKekkaUiBean.class); %>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
<jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>
<script type="text/javascript"><!--
$(function(){
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
