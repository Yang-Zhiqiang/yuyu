<%--
    sk_dairiten_kobetu_jyouhou_touroku.js.jsp - 代理店個別情報登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku.SkDairitenKobetuJyouhouTourokuConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku.SkDairitenKobetuJyouhouTourokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku.SkDairitenKobetuJyouhouTourokuUiBean" %>
<% SkDairitenKobetuJyouhouTourokuUiBean uiBean = SWAKInjector.getInstance(SkDairitenKobetuJyouhouTourokuUiBean.class); %>
<script type="text/javascript">
$(function(){

<%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM
      || uiBean.getPageNo() == PAGENO_RESULT) { %>
      var syoriModoHyouji = '';
      <%
         if (E_SyoriKbn.NEW.equals(uiBean.getGamenSyoriKbn())) { %>
             syoriModoHyouji = '<%= PANKUZU_NEW %>';
      <%
         } else if (E_SyoriKbn.UPD.equals(uiBean.getGamenSyoriKbn())) { %>
             syoriModoHyouji = '<%= PANKUZU_UPD %>';
      <%
         } else { %>
             syoriModoHyouji = '<%= PANKUZU_DEL %>';
      <% } %>

      $(<%= IBA0001 %>).text(syoriModoHyouji);
<% } %>

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  $(<%= UTDSKKNNM2KJ_DAIRITENKOBETUINFO1 + LABEL%>).css("margin-right", "17px");
<% } %>

});

</script>
