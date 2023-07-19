<%--
    view_tratkihuryou_husyoujiken.js.jsp - 取扱不良・不詳事件等 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken.ViewTratkihuryouHusyoujikenSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_NoinitUmuKbn" %>
<%@page import="yuyu.def.classification.C_NoinitYouhiKbn" %>
<%@page import="yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken.ViewTratkihuryouHusyoujikenUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewtratkihuryouhusyoujiken/view_tratkihuryou_husyoujiken.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewTratkihuryouHusyoujikenUiBeanParam viewTratkihuryouHusyoujikenUiBean = (ViewTratkihuryouHusyoujikenUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewTratkihuryouHusyoujikenUiBean.isViewTratkihuryouHusyoujikenInputDispFlg()) { %>

   $(<%=TRATKIHURYOUCOMMENT_VIEWTRATKIHURYOUHUSYOUJIKENINFO%>).addClass("tratkihuryoucomment_text12");

    viewTratkihuryouHusyoujiken();

     <%
     if (C_NoinitUmuKbn.NONE.eq(viewTratkihuryouHusyoujikenUiBean.getTratkihuryouumukbn())) { //%>
        setViewTratkihuryouHusyoujiken();
     <% }%>

     $("input[id^='tratkihuryouumukbn']").change(function() {
         var value = $("input[id^='tratkihuryouumukbn']:checked").val();
          if ( value == "<%=C_NoinitUmuKbn.NONE.getValue()%>" ) {
           setViewTratkihuryouHusyoujiken();
          } else {
           $(<%= GYOUSINKAISOUYOUHIKBN_VIEWTRATKIHURYOUHUSYOUJIKENINFO + SPAN%>).find("input[class^='radio']").removeAttr("disabled");
           $(<%= AIREQDAITYOUKISAIKBN_VIEWTRATKIHURYOUHUSYOUJIKENINFO + SPAN%>).find("input[class^='radio']").removeAttr("disabled");
          }
      });

  <%
  } else { %>
    <%
    if (viewTratkihuryouHusyoujikenUiBean.isViewTratkihuryouHusyoujikenFlg()) { %>
      viewTratkihuryouHusyoujiken();
    <%
    } else { %>
       $(<%=VIEWTRATKIHURYOUHUSYOUJIKENINFO + DIV%>).visible(false);
    <% } %>
  <% } %>

function viewTratkihuryouHusyoujiken() {
  var viewTratkihuryouHusyoujikenDispKbn = 0;
  <%
  if (viewTratkihuryouHusyoujikenUiBean.isViewTratkihuryouHusyoujikenSeigyo()) { %>
      $(<%=VIEWTRATKIHURYOUHUSYOUJIKENINFO + LABEL%>).addClass('toggletitle');

      <%
      if (viewTratkihuryouHusyoujikenUiBean.isViewTratkihuryouHusyoujikenDispFlg()) { %>
          $(<%= VIEWTRATKIHURYOUHUSYOUJIKENINFO%>).show();
      <%
      } else { %>
          $(<%= VIEWTRATKIHURYOUHUSYOUJIKENINFO%>).hide();
          viewTratkihuryouHusyoujikenDispKbn = 1;
      <% } %>

      $(<%= VIEWTRATKIHURYOUHUSYOUJIKENINFO + LABEL%>).click(function(){
          if (viewTratkihuryouHusyoujikenDispKbn == 0) {
              $(<%= VIEWTRATKIHURYOUHUSYOUJIKENINFO%>).hide();
              viewTratkihuryouHusyoujikenDispKbn = 1;
          } else {
              $(<%= VIEWTRATKIHURYOUHUSYOUJIKENINFO%>).show();
              viewTratkihuryouHusyoujikenDispKbn = 0;
          }
      });
  <% } %>
}

function setViewTratkihuryouHusyoujiken () {

   $(<%= GYOUSINKAISOUYOUHIKBN_VIEWTRATKIHURYOUHUSYOUJIKENINFO + SPAN%>).find("input[class^='radio']").attr("disabled", "true");
   $("#ui:0Z1gyousinkaisouyouhikbn").val("");
   $("input[id^='gyousinkaisouyouhikbn']").removeAttr("checked");

   $(<%= AIREQDAITYOUKISAIKBN_VIEWTRATKIHURYOUHUSYOUJIKENINFO + SPAN%>).find("input[class^='radio']").attr("disabled", "true");
   $("#ui:0a1aireqdaityoukisaikbn").val("");
   $("input[id^='aireqdaityoukisaikbn']").removeAttr("checked");

}


});

</script>
