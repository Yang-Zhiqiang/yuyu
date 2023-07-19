<%--
    view_haitoukin.js.jsp - 配当金情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewhaitoukin.ViewHaitoukinSelector.*" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewhaitoukin.ViewHaitoukinUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_HaitoukinuketorihouKbn" %>
<%@page import="yuyu.def.classification.C_HaitoukinsksKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewhaitoukin/view_haitoukin.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewHaitoukinUiBeanParam viewHaitoukinUiBeanParam = (ViewHaitoukinUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
  <%
    if (C_HaitoukinuketorihouKbn.TUMIHAI.eq(viewHaitoukinUiBeanParam.getVhthaitoukinuketorihoukbn())) { %>
     showGroup(<%=HAITOUKININFO%>);
     <%
       if (viewHaitoukinUiBeanParam.getVhttumitatedtumitateymd()!=null) { %>
         showKoumoku(<%=VHTHAITOUNENDO_HAITOUKININFO%>);
         showKoumoku(<%=VHTNAITEIKAKUTEIKBN_HAITOUKININFO%>);
         showKoumoku(<%=VHTTUMITATENENDO_HAITOUKININFO%>);
         showKoumoku(<%=VHTTUMITATEDTUMITATEYMD_HAITOUKININFO%>);
         showKoumoku(<%=VHTTUMITATEDSHRKRKYMD_HAITOUKININFO%>);
     <%}%>
     <%
       if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) { %>
         addTopBottomLink(<%=HAITOUKININFO%>);
     <%}%>
  <% } %>
});

</script>
