<%--
    si_make_syorui.js.jsp - 保険金給付金書類作成 JavaScript(JSP)
--%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sisonota.simakesyorui.SiMakeSyoruiConstants.*" %>
<%@page import="static yuyu.app.siharai.sisonota.simakesyorui.SiMakeSyoruiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sisonota.simakesyorui.SiMakeSyoruiUiBean" %>
<% SiMakeSyoruiUiBean uiBean = SWAKInjector.getInstance(SiMakeSyoruiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

   $(<%= SYORUISAKUSEILINK + LABEL  %>).text("<%= BLNK %>");

   <% if (uiBean.getPageNo() == PAGENO_SELECTDATA) { %>
        if ($(<%= ANKENSEARCHRESULTLIST %>)[0].rows.length <= 1) {
           $(<%= ANKENSEARCHRESULTLIST + DIV %>).visible(false);
         }
   <% } %>

   <% if (uiBean.getPageNo() == PAGENO_RESULT && !BizUtil.isBlank(uiBean.getReportKey())) {
         %>
        openReport('print', '_blank');
   <% } %>

});
//-->
</script>
