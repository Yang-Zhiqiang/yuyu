<%--
    view_souhusaki.js.jsp - 送付先情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiUiBeanParam" %>
<%@page import="yuyu.def.classification.C_SouhusakiKbn"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsouhusaki/view_souhusaki.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSouhusakiUiBeanParam viewSouhusakiUiBean = (ViewSouhusakiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
<%
 if (viewSouhusakiUiBean.isViewSouhusakiInputDispFlg()) { %>

    <%
     if (C_SouhusakiKbn.TDADD.eq(viewSouhusakiUiBean.getSouhusakikbn())) { // %>
         setViewSouhusaki();
    <% } %>

   $(<%=SOUHUSAKIKBN_VIEWSOUHUSAKIINFO%>).change( function() {
      var value = $(<%=SOUHUSAKIKBN_VIEWSOUHUSAKIINFO%>).val();
      if (value == "<%=C_SouhusakiKbn.TDADD.getValue()%>") {
         setViewSouhusaki();
       } else {
        removeReadOnlyGray(<%=TSINYNO_SOUHUSAKIINFO%>);
        removeReadOnlyGray(<%=TSINADR1KJ_VIEWSOUHUSAKIINFO%>);
        removeReadOnlyGray(<%=TSINADR2KJ_VIEWSOUHUSAKIINFO%>);
        removeReadOnlyGray(<%=TSINADR3KJ_VIEWSOUHUSAKIINFO%>);
        removeReadOnlyGray(<%=TSINTELNO_VIEWSOUHUSAKIINFO%>);
        $(<%=TSINYNO_POPUP_BUTTON%>).readonly(false);
       }
    });
<%
 } else { %>
  var viewSouhusaki = 0;
  <%
   if (viewSouhusakiUiBean.isViewSouhusakiSeigyo()) { %>
     $(<%=VIEWSOUHUSAKIINFO + LABEL%>).addClass('toggletitle');

    <%
     if (viewSouhusakiUiBean.isViewSouhusakiDispFlg()) {%>
       $(<%= VIEWSOUHUSAKIINFO%>).show();
       viewSouhusaki = 0;
    <%
     } else { %>
       $(<%= VIEWSOUHUSAKIINFO%>).hide();
       viewSouhusaki = 1;
    <% } %>

    $(<%= VIEWSOUHUSAKIINFO + LABEL%>).click(function(){
     if (viewSouhusaki == 0) {
       $(<%= VIEWSOUHUSAKIINFO%>).hide();
       viewSouhusaki = 1;
     } else {
       $(<%= VIEWSOUHUSAKIINFO%>).show();
       viewSouhusaki = 0;
     }
    });
  <% } %>
<% } %>

function setViewSouhusaki() {
   $(<%=TSINYNO_SOUHUSAKIINFO%>).val("");
   setReadOnlyGray(<%=TSINYNO_SOUHUSAKIINFO%>);
   $(<%=TSINADR1KJ_VIEWSOUHUSAKIINFO%>).val("");
   setReadOnlyGray(<%=TSINADR1KJ_VIEWSOUHUSAKIINFO%>);
   $(<%=TSINADR2KJ_VIEWSOUHUSAKIINFO%>).val("");
   setReadOnlyGray(<%=TSINADR2KJ_VIEWSOUHUSAKIINFO%>);
   $(<%=TSINADR3KJ_VIEWSOUHUSAKIINFO%>).val("");
   setReadOnlyGray(<%=TSINADR3KJ_VIEWSOUHUSAKIINFO%>);
   $(<%=TSINTELNO_VIEWSOUHUSAKIINFO%>).val("");
   setReadOnlyGray(<%=TSINTELNO_VIEWSOUHUSAKIINFO%>);
   $(<%=TSINYNO_POPUP_BUTTON%>).readonly(true);
   $(<%=TSINYNO_SOUHUSAKIINFO%>).removeClass("readonly");
}


});

</script>
