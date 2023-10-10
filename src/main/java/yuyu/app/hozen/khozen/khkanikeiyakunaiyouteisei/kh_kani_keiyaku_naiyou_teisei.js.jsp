<%--
    kh_kani_keiyaku_naiyou_teisei.js.jsp - 契約保全簡易契約内容訂正 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei.KhKaniKeiyakuNaiyouTeiseiConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei.KhKaniKeiyakuNaiyouTeiseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.def.classification.C_KykNaiyouTeiseiSyoriKbn"%>
<%@page import="yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei.KhKaniKeiyakuNaiyouTeiseiUiBean" %>
<% KhKaniKeiyakuNaiyouTeiseiUiBean uiBean = SWAKInjector.getInstance(KhKaniKeiyakuNaiyouTeiseiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

   <% if (uiBean.getPageNo() == PAGENO_REFERENCE ||
          uiBean.getPageNo() == PAGENO_CONFIRM ||
          uiBean.getPageNo() == PAGENO_RESULT) {%>

       <% if (!C_KykNaiyouTeiseiSyoriKbn.MKHGKTTTYENDTHNKTRKS.eq(uiBean.getKyknaiyouteiseisyorikbn())) { %>
              $(<%= YENDTHNKYMD_KEIYAKUNAIYOUTEISEIINFO + LABEL%>).parent().visible(false);
              $(<%= YENDTHNKYMD_KEIYAKUNAIYOUTEISEIINFO %>).parent().visible(false);
       <% } %>

       <% if (C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_TORIKESI.eq(uiBean.getDispkyknytssyorikbn()) ||
           C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(uiBean.getDispkyknytssyorikbn())) { %>
             showKoumoku(<%=TMTTKNKOURYOKUKAISIYMD_KEIYAKUNAIYOUTEISEIINFO%>);

             <% if (C_KykNaiyouTeiseiSyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(uiBean.getDispkyknytssyorikbn())) { %>
                 $(<%=TMTTKNKOURYOKUKAISIYMD_KEIYAKUNAIYOUTEISEIINFO + LABEL%>).text('<%=TMTTKNHANEI_ITEN_TORIKESI%>');
             <% } %>
       <% } %>
   <%}%>
});
//-->
</script>
