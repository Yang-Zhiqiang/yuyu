<%--
    sk_styjksyoukai.js.jsp - 進捗状況照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai.SkStyjksyoukaiConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai.SkStyjksyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai.SkStyjksyoukaiUiBean" %>
<% SkStyjksyoukaiUiBean uiBean = SWAKInjector.getInstance(SkStyjksyoukaiUiBean.class); %>
<script type="text/javascript">
$(function(){

  showList(<%=SEARCHRESULTS%>);
 if ($(<%=SEARCHRESULTS%>)[0].rows.length > 1) {
   if ($(<%=SEARCHRESULTS%>)[0].rows.length > 16) {
     $(<%=SEARCHRESULTS + DIV%>).css("height","452px");
     $(<%=SEARCHRESULTS + DIV%>).find("td[class^='displastkossyori_data']").removeAttr("secondCell18").addClass("secondCell19");
   }
   $(<%=SEARCHRESULTSTITLE + DIV%>).visible(true);
   $(<%=SEARCHRESULTSTITLE + DIV%>).css("overflow-x","hidden");
   $(<%=SEARCHRESULTS + DIV%>).find("tr").eq(0).remove();
   $(<%= SEARCHRESULTS + DIV %>).css("margin-top", "-1px");

   $(<%= SEARCHRESULTS + DIV %>).scroll(function() {

   $(<%= SEARCHRESULTSTITLE + DIV %>).scrollTop($(this).scrollTop());

   $(<%= SEARCHRESULTSTITLE + DIV %>).scrollLeft($(this).scrollLeft());

   });
 }



});
</script>
