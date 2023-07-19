<%--
    view_sateikaisouyouhi_sibou.js.jsp - 査定回送要否確認（死亡） JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsateikaisouyouhisibou.ViewSateikaisouyouhiSibouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsateikaisouyouhisibou.ViewSateikaisouyouhiSibouUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsateikaisouyouhisibou/view_sateikaisouyouhi_sibou.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSateikaisouyouhiSibouUiBeanParam viewSateikaisouyouhiSibouUiBean = (ViewSateikaisouyouhiSibouUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

var viewSateikaisouyouhiSibouDispKbn = 0;
<%
if (viewSateikaisouyouhiSibouUiBean.isViewSateikaisouyouhiSibouSeigyo()) { %>
    $(<%=VIEWSATEIKAISOUYOUHISIBOUINFO + LABEL%>).addClass('toggletitle');

    <%
    if (viewSateikaisouyouhiSibouUiBean.isViewSateikaisouyouhiSibouDispFlg()) { %>
        $(<%= VIEWSATEIKAISOUYOUHISIBOUINFO%>).show();
    <%
    } else { %>
        $(<%= VIEWSATEIKAISOUYOUHISIBOUINFO%>).hide();
        viewSateikaisouyouhiSibouDispKbn = 1;
    <% } %>

    $(<%= VIEWSATEIKAISOUYOUHISIBOUINFO + LABEL%>).click(function(){
        if (viewSateikaisouyouhiSibouDispKbn == 0) {
            $(<%= VIEWSATEIKAISOUYOUHISIBOUINFO%>).hide();
            viewSateikaisouyouhiSibouDispKbn = 1;
        } else {
            $(<%= VIEWSATEIKAISOUYOUHISIBOUINFO%>).show();
            viewSateikaisouyouhiSibouDispKbn = 0;
        }
    });
<% } %>

});

</script>
