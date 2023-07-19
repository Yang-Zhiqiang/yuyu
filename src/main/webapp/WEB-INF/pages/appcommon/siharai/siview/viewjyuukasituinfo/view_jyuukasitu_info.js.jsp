<%--
    view_jyuukasitu_info.js.jsp - 重過失情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewjyuukasituinfo/view_jyuukasitu_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewJyuukasituInfoUiBeanParam viewJyuukasituInfoUiBean = (ViewJyuukasituInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

<%
   if (viewJyuukasituInfoUiBean.isViewJyuukasituInfoFlg()) { %>
   showGroup(<%=VIEWJYUUKASITUINFO%>);
   viewJyuukasituInfo();
   <%
   if (!viewJyuukasituInfoUiBean.isViewJyuukasituInfoInputDispFlg()) { %>
      $(<%=JUUKASITUCHECKCOMMENT1_VIEWJYUUKASITUINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=JUUKASITUCHECKCOMMENT2_VIEWJYUUKASITUINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=JUUKASITUCHECKCOMMENT3_VIEWJYUUKASITUINFO%>).parent().addClass('dispviewfirstCell');
      $(<%=JUUKASITUCHECKCOMMENT4_VIEWJYUUKASITUINFO%>).parent().addClass('dispviewfirstCell');
   <% } %>
<% } %>

function viewJyuukasituInfo() {

 var viewJyuukasituInfoDispKbn = 0;
 <%
    if (viewJyuukasituInfoUiBean.isViewJyuukasituInfoSeigyo()) { %>
       $(<%=VIEWJYUUKASITUINFO + LABEL%>).addClass('toggletitle');

       <%
          if (viewJyuukasituInfoUiBean.isViewJyuukasituInfoDispFlg()) { %>
             $(<%= VIEWJYUUKASITUINFO%>).show();
       <%
          } else { %>
             $(<%= VIEWJYUUKASITUINFO%>).hide();
             viewJyuukasituInfoDispKbn = 1;
       <% } %>

       $(<%= VIEWJYUUKASITUINFO + LABEL%>).click(function(){
         if (viewJyuukasituInfoDispKbn == 0) {
             $(<%= VIEWJYUUKASITUINFO%>).hide();
             viewJyuukasituInfoDispKbn = 1;
         } else {
             $(<%= VIEWJYUUKASITUINFO%>).show();
             viewJyuukasituInfoDispKbn = 0;
         }
     });
 <% } %>
}

});

</script>
