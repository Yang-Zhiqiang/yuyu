<%--
    view_progress_history.js.jsp - 進捗履歴情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistorySelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/biz/koutei/viewprogresshistory/view_progress_history.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewProgressHistoryUiBeanParam viewProgressHistoryUiBean = (ViewProgressHistoryUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
  showList(<%= PROGRESSHISTORYINFO %>);
});

</script>
