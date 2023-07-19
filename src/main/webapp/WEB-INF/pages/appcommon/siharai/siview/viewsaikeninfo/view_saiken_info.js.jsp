<%--
    view_saiken_info.js.jsp - 債権者情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsaikeninfo/view_saiken_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>
<%
   ViewSaikenInfoUiBeanParam viewSaikenInfoUiBean = (ViewSaikenInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

<%
if (viewSaikenInfoUiBean.isViewSaikenInfoFlg()) { %>
   showGroup(<%=VIEWSAIKENINFO%>);
   showGroup(<%=VIEWSAIKENINFO1%>);
   viewSaikenInfo();

<% } %>

function viewSaikenInfo() {
    var viewSaikenInfoDispKbn = 0;
   <%
      if (!viewSaikenInfoUiBean.isViewSaikenInfoInputDispFlg()) { %>
         <%
            if (viewSaikenInfoUiBean.isViewSaikenInfoSeigyo()) { %>
               $(<%=VIEWSAIKENINFO + LABEL%>).addClass('toggletitle');

               <%
                  if (viewSaikenInfoUiBean.isViewSaikenInfoDispFlg()) { %>
                     $(<%= VIEWSAIKENINFO%>).show();
                     $(<%= VIEWSAIKENINFO1%>).show();
               <%
                  } else { %>
                     $(<%= VIEWSAIKENINFO%>).hide();
                     $(<%= VIEWSAIKENINFO1%>).hide();
                     viewSaikenInfoDispKbn = 1;
                <% } %>

                $(<%= VIEWSAIKENINFO + LABEL%>).click(function(){
                if (viewSaikenInfoDispKbn == 0) {
                   $(<%= VIEWSAIKENINFO%>).hide();
                   $(<%= VIEWSAIKENINFO1%>).hide();
                   viewSaikenInfoDispKbn = 1;
                } else {
                   $(<%= VIEWSAIKENINFO%>).show();
                   $(<%= VIEWSAIKENINFO1%>).show();
                   viewSaikenInfoDispKbn = 0;
                }
               });
         <% } %>
   <% } %>
}

});

</script>
