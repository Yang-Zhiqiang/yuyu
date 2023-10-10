<%--
    ds_mail_haisin_yoyaku.js.jsp - ＤＳメール配信予約 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.DsMailHaisinYoyakuConstants.*"%>
<%@page
	import="static yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.DsMailHaisinYoyakuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku.DsMailHaisinYoyakuUiBean"%>
<% DsMailHaisinYoyakuUiBean uiBean = SWAKInjector.getInstance(DsMailHaisinYoyakuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <% if (E_SyoriKbn.KENSAKU.equals(uiBean.getSyoriKbn())) { %>

        showList(<%=SEARCHRESULTINFO%>);

        $(<%= COLSPAN_CLASS_2%>).attr("colspan","2");

        $(<%= COLSPAN_CLASS_2%>).text("<%= STATUS_HENKOU%>");

        $(<%= SYOUNINLINK + LABEL  %>).text("<%= BLANK %>");

        $(<%= SAKUJYOLINK + LABEL  %>).text("<%= BLANK %>");
    <% } %>

    <% if (uiBean.getPageNo() == PAGENO_INIT) { %>

      if ($(<%= SEARCHRESULTINFO %>)[0].rows.length <= 1) {
        $(<%= SEARCHRESULTINFO + DIV %>).visible(false);

      }else{
        $("a").filter(function (index) { return $(this).html() == "<%= SYOUNIN_LINK_HTML %>"; }).parent().html("<%= SYOUNIN_LINK %>");

        $("a").filter(function (index) { return $(this).html() == "<%= SAKUJYO_LINK_HTML %>"; }).parent().html("<%= SAKUJYO_LINK %>");
      }

    <% } %>

    <%if ( uiBean.getPageNo() == PAGENO_TOUROKU) {%>
        $(<%= DSSPIRALSEQUENCEHSNSET_SOUSINMAILNAIYOU %>).attr('checked',false);
    <% } %>

    <%if ( uiBean.getPageNo() == PAGENO_SYOUNIN) {%>
        $(<%= DSSPIRALSEQUENCEHSNSET_SOUSINMAILNAIYOU %>).attr('checked',false);
    <% } %>

    <%if ( uiBean.getPageNo() == PAGENO_SAKUJYO) {%>
        $(<%= DSSPIRALSEQUENCEHSNSET_SOUSINMAILNAIYOU %>).attr('checked',false);
    <% } %>

});
//-->
</script>
