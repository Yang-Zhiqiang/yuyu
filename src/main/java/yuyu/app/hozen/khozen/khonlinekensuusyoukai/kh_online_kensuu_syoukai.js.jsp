<%--
    kh_online_kensuu_syoukai.js.jsp - 契約保全オンライン処理件数照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khonlinekensuusyoukai.KhOnlineKensuuSyoukaiConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khonlinekensuusyoukai.KhOnlineKensuuSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="java.util.List" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil" %>
<%@page import="yuyu.app.hozen.khozen.khonlinekensuusyoukai.SyoriKensuuListDataSourceBean" %>
<%@page import="yuyu.app.hozen.khozen.khonlinekensuusyoukai.KhOnlineKensuuSyoukaiUiBean" %>
<% KhOnlineKensuuSyoukaiUiBean uiBean = SWAKInjector.getInstance(KhOnlineKensuuSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <% if (uiBean.getPageNo() == PAGENO_REFERENCE) { %>
        <% List<SyoriKensuuListDataSourceBean> syoriKensuuListDataSourceBean = uiBean.getSyoriKensuuListDataSource().getAllData();
           for (int iCnt = 0; iCnt < syoriKensuuListDataSourceBean.size(); iCnt++ ) { %>
           var dispkensuu = '<%=BizUtil.comma(syoriKensuuListDataSourceBean.get(iCnt).getDispkensuu().toString()) %>';
                $(<%= DISPKENSUU_SYORIKENSUULIST(iCnt) %>).text(dispkensuu);
                $(<%= DISPKENSUU_SYORIKENSUULIST(iCnt) %>).after('&nbsp;&nbsp;');
        <%}%>
<% } %>
});
//-->
</script>
