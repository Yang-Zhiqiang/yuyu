<%--
    view_zeimu_info.js.jsp - 税務情報 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewzeimuinfo.ViewZeimuInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewzeimuinfo.ViewZeimuInfoUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewzeimuinfo/view_zeimu_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewZeimuInfoUiBeanParam viewZeimuInfoUiBean = (ViewZeimuInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

   var viewZeimuInfoDispKbn = 0;
   <%
   if (viewZeimuInfoUiBean.isViewZeimuInfoSeigyo()) { %>
       $(<%=VIEWZEIMUINFO + LABEL%>).addClass('toggletitle');

       <%
       if (viewZeimuInfoUiBean.isViewZeimuInfoDispFlg()) { %>
           $(<%= VIEWZEIMUINFO%>).show();
       <%
       } else { %>
           $(<%= VIEWZEIMUINFO%>).hide();
           viewZeimuInfoDispKbn = 1;
       <% } %>

       $(<%= VIEWZEIMUINFO + LABEL%>).click(function(){
           if (viewZeimuInfoDispKbn == 0) {
               $(<%= VIEWZEIMUINFO%>).hide();
               viewZeimuInfoDispKbn = 1;
             } else {
               $(<%= VIEWZEIMUINFO%>).show();
               viewZeimuInfoDispKbn = 0;
           }
       });

   <% } %>
   <%
   if (viewZeimuInfoUiBean.getKykhnkkaisuu() == 0) { %>
       $(<%=KYKHNKKAISUU_VIEWZEIMUINFO%>).parent().parent().visible(false);
       $(<%=SHRKYKHTYKEIHI_VIEWZEIMUINFO%>).parent().parent().visible(false);
   <% } %>

});

</script>
