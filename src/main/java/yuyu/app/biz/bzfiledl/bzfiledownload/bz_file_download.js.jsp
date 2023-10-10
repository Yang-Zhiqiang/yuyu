<%--
    bz_file_download.js.jsp - ファイルダウンロード JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzfiledl.bzfiledownload.BzFileDownloadConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzfiledl.bzfiledownload.BzFileDownloadSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzfiledl.bzfiledownload.BzFileDownloadUiBean"%>
<% BzFileDownloadUiBean uiBean = SWAKInjector.getInstance(BzFileDownloadUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
    <% if (uiBean.getPageNo() == PAGENO_DOWNLOAD) { %>
    $(<%= FILESYURUI_BASEINFO %>).val('<%= uiBean.getFilesyurui() %>');
  <% } %>

    <% if (uiBean.getPageNo() == PAGENO_DOWNLOAD) { %>
      <%
        if (uiBean.isDlflag()){ %>
        fileDownLoad("downloadFile", "_blank");
      <%} %>
    <%
    }
    %>
});
//-->
</script>
