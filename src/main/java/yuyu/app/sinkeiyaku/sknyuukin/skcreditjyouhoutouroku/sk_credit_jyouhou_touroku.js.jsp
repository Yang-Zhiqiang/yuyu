<%--
    sk_credit_jyouhou_touroku.js.jsp - クレジットカード情報登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku.SkCreditJyouhouTourokuConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku.SkCreditJyouhouTourokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.def.classification.C_CreditInfoTourokuGamenSyoriKbn" %>
<%@page import="yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku.SkCreditJyouhouTourokuUiBean" %>
<% SkCreditJyouhouTourokuUiBean uiBean = SWAKInjector.getInstance(SkCreditJyouhouTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
      uiBean.getPageNo() == PAGENO_CONFIRM ||
      uiBean.getPageNo() == PAGENO_RESULT) { %>

    <%
    if (C_CreditInfoTourokuGamenSyoriKbn.AUTHORIKAKYMDNYUURYOKU.eq(uiBean.getCreditinfotrkugmsyorikbn())) { %>
        showKoumoku(<%=AUTHORIKAKYMD_KIHONINFO%>);
        showKoumoku(<%=CARDBRANDKBN_KIHONINFO%>);
    <%
    } else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUHANEISYORIQR.eq(uiBean.getCreditinfotrkugmsyorikbn())) { %>
        showKoumoku(<%=CREDITKESSAIYOUNO1_KIHONINFO%>);
        showKoumoku(<%=CREDITKESSAIYOUNO2_KIHONINFO%>);
        showKoumoku(<%=CREDITKESSAIYOUNO3_KIHONINFO%>);
        showKoumoku(<%=CREDITKESSAIYOUNO4_KIHONINFO%>);
        showKoumoku(<%=CREDITKESSAIYOUNO5_KIHONINFO%>);
        showKoumoku(<%=CREDITKESSAIYOUNO6_KIHONINFO%>);
    <% } %>
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_CONFIRM ||
      uiBean.getPageNo() == PAGENO_RESULT) { %>
      $(".alignMessageCell1").removeClass('alignMessageCell1').addClass('alignMessageCell2');
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
    <%
    if (C_CreditInfoTourokuGamenSyoriKbn.AUTHORIKAKYMDNYUURYOKU.eq(uiBean.getCreditinfotrkugmsyorikbn()) ||
        C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUHANEISYORIQR.eq(uiBean.getCreditinfotrkugmsyorikbn())) { %>
        $(<%= MODORUKEYBTNBYCONFIRM_FOOTERBUTTONS %>).visible(false);
    <% } %>
    <%
    if (C_CreditInfoTourokuGamenSyoriKbn.CREDITKESSAIYOUNOSYUTOKU.eq(uiBean.getCreditinfotrkugmsyorikbn()) ||
        C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUKANBI.eq(uiBean.getCreditinfotrkugmsyorikbn())) { %>
        $(<%= MODORUINPUTBTNBYCONFIRM_FOOTERBUTTONS %>).visible(false);
    <% } %>
  <% } %>

  <%
  if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <%
    if (C_CreditInfoTourokuGamenSyoriKbn.CREDITKESSAIYOUNOSYUTOKU.eq(uiBean.getCreditinfotrkugmsyorikbn())) { %>
        showKoumoku(<%=DISPCREDITKESSAIYOUNO_KIHONINFO%>);
    <%
    } else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUKANBI.eq(uiBean.getCreditinfotrkugmsyorikbn())) { %>
        showKoumoku(<%=CREDITTRKJKKBN_KIHONINFO%>);
    <% } %>

    <%
    String[] hubiMsgs = uiBean.getHubimsgData();%>
    <%
    String msgId = "";%>
    <%
    if (hubiMsgs != null && hubiMsgs.length != 0 && hubiMsgs[0].length() != 0) {
        String[] hubiMsg = hubiMsgs[0].split(" ");
        msgId = hubiMsg[1];
    }%>

    changeErrMsg('<%= msgId %>');
  <% } %>

});
//-->
</script>
