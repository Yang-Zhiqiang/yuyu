<%--
    sk_nyuukin_henkin_kakunin.js.jsp - 入金／返金状況確認 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.SkNyuukinHenkinKakuninConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.SkNyuukinHenkinKakuninSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.SkNyuukinHenkinKakuninUiBean" %>
<%@page import="yuyu.def.classification.C_NyuukinHenkinSyoriKbn" %>
<% SkNyuukinHenkinKakuninUiBean uiBean = SWAKInjector.getInstance(SkNyuukinHenkinKakuninUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <%
    if (uiBean.getPageNo() == PAGENO_MEISAI) { %>
      <%
        if (C_NyuukinHenkinSyoriKbn.NYUUKIN.eq(uiBean.getNyuukinhenkinsyorikbn())) { %>
          showList(<%=NYUUKINMEISAI%>);
      <%
        } else if (C_NyuukinHenkinSyoriKbn.HENKIN.eq(uiBean.getNyuukinhenkinsyorikbn())) { %>
           showList(<%=HENKINMEISAI%>);
      <% } %>
  <% } %>

});
//-->
</script>
