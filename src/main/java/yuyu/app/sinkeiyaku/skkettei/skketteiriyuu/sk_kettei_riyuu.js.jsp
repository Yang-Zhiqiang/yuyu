<%--
    sk_kettei_riyuu.js.jsp - 決定理由一覧 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkettei.skketteiriyuu.SkKetteiRiyuuConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkettei.skketteiriyuu.SkKetteiRiyuuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skkettei.skketteiriyuu.SkKetteiRiyuuUiBean" %>
<% SkKetteiRiyuuUiBean uiBean = SWAKInjector.getInstance(SkKetteiRiyuuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  showList(<%=KETTEIRIYUULIST%>);
});
//-->
</script>
