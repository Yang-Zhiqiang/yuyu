<%--
    view_kouza_info.js.jsp - 口座情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewkouzainfo.ViewKouzaInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewkouzainfo.ViewKouzaInfoUiBeanParam" %>
<%@page import="yuyu.def.classification.C_KouzasyuruiKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewkouzainfo/view_kouza_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKouzaInfoUiBeanParam viewKouzaInfoUiBean = (ViewKouzaInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
  showGroup(<%=SIHARAIHOUHOU%>);
  showGroup(<%=KOUZAINFO%>);

  <% if(C_KouzasyuruiKbn.YENKOUZA.eq(viewKouzaInfoUiBean.getKzsyuruikbn())) {%>
    showKoumoku(<%=YOKINKBN_KOUZAINFO%>);
    showKoumoku(<%=KZDOUKBN_KOUZAINFO%>);
  <%}%>

});

</script>
