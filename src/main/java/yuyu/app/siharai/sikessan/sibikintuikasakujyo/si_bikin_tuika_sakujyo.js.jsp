<%--
    si_bikin_tuika_sakujyo.js.jsp - 保険金給付金備金追加削除 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sikessan.sibikintuikasakujyo.SiBikinTuikaSakujyoConstants.*" %>
<%@page import="static yuyu.app.siharai.sikessan.sibikintuikasakujyo.SiBikinTuikaSakujyoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.def.classification.C_BknsyoriKbn" %>
<%@page import="yuyu.app.siharai.sikessan.sibikintuikasakujyo.SiBikinTuikaSakujyoUiBean" %>
<% SiBikinTuikaSakujyoUiBean uiBean = SWAKInjector.getInstance(SiBikinTuikaSakujyoUiBean.class); %>
<script type="text/javascript">
$(function(){

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
     <%
        if (C_BknsyoriKbn.TORIKESI.eq(uiBean.getBknsyorikbn())) { %>
          showKoumoku(<%=BKNRIGIKBN_BIKOUINFO%>);
     <% } %>
<% } %>
<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ) { %>
     <%
        if (C_BknsyoriKbn.SAKUJYO.eq(uiBean.getBknsyorikbn()) || C_BknsyoriKbn.TORIKESI.eq(uiBean.getBknsyorikbn())) { %>
          $(<%=BKNGK_BIKOUINFO%>).parent().addClass("bkngkRightCell");
          $(<%=BKNGK_BIKOUINFO%>).addClass("bkngkFirstCellInput");
          $(<%=BKNGK_BIKOUINFO + LABEL%>).next().text("");
          inputToOutput(<%=BKNGK_BIKOUINFO%>);
          $(<%=BKNKKTYMD_BIKOUINFO + LABEL%>).next().text("");
          inputToOutput(<%=BKNKKTYMD_DATA_SELECT%>);
          $(<%=CALCKIJYUNYMD_BIKOUINFO + LABEL%>).next().text("");
          inputToOutput(<%=CALCKIJYUNYMD_DATA_SELECT%>);
          inputToOutput(<%=SHRUMU_BIKOUINFO%>);
          inputToOutput(<%=SOUKIUMUKBN_BIKOUINFO%>);
          inputToOutput(<%=SHRSYORIYMD_DATA_SELECT%>);
          inputToOutput(<%=TYAKKINYMD_DATA_SELECT%>);
          inputToOutput(<%=SHRTUUKASYU_BIKOUINFO%>);
          inputToOutput(<%=SYORUIUKEYMD_DATA_SELECT%>);
          $(<%= SHRSYORIYMD_MESSAGE %>).css('display', 'none');
          $(<%= TYAKKINYMD_MESSAGE %>).css('display', 'none');
          $(<%= SHRTUUKASYU_MESSAGE %>).css('display', 'none');
     <% } %>
<% } %>
<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
   $(<%=BKNGK_BIKOUINFO%>).parent().addClass("bkngkRightCell");
   $(<%=BKNGK_BIKOUINFO%>).addClass("bkngkFirstCell");
<% } %>
});
</script>
