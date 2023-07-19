<%--
    view_nenkin_info.js.jsp - 年金情報 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewnenkininfo.ViewNenkinInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewnenkininfo.ViewNenkinInfoUiBeanParam" %>
<%@page import="yuyu.def.classification.C_SUketoriHouhouKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewnenkininfo/view_nenkin_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewNenkinInfoUiBeanParam viewNenkinInfoUiBean = (ViewNenkinInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(viewNenkinInfoUiBean.getSuketorihouhoukbn())
      || C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(viewNenkinInfoUiBean.getSuketorihouhoukbn())) { %>
    showGroup(<%=VIEWNENKININFO%>);

    var viewNenkinInfoDispKbn = 0;
    <%
    if (viewNenkinInfoUiBean.isViewNenkinInfoSeigyo()) { %>
        <%
        if (viewNenkinInfoUiBean.isViewNenkinInfoDispFlg()) { %>
            $(<%= VIEWNENKININFO%>).show();
        <%
        } else { %>
            $(<%= VIEWNENKININFO%>).hide();
            viewNenkinInfoDispKbn = 1;
        <% } %>

        $(<%= VIEWNENKININFO + LABEL%>).click(function(){
            if (viewNenkinInfoDispKbn == 0) {
                $(<%= VIEWNENKININFO%>).hide();
                viewNenkinInfoDispKbn = 1;
              } else {
                $(<%= VIEWNENKININFO%>).show();
                viewNenkinInfoDispKbn = 0;
            }
        });

    <% } %>
  <% } %>

});

</script>
