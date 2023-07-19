<%--
    view_skjyouhou.js.jsp - 請求者情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewskjyouhou.ViewSkjyouhouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewskjyouhou.ViewSkjyouhouUiBeanParam" %>
<%@page import="yuyu.def.classification.C_SeikyuusyaKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewskjyouhou/view_skjyouhou.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSkjyouhouUiBeanParam viewSkjyouhouUiBean = (ViewSkjyouhouUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

<%
 if (viewSkjyouhouUiBean.isViewSkjyouhouInputDispFlg()) { %>
   $(<%= VIEWSKJYOUHOUINFO + LABEL%>).text($(<%= VIEWSKJYOUHOUINFO + LABEL%>).text() + '　　<%= MessageUtil.getMessage(MessageId.IJC1024) %>');
  <%
   if (C_SeikyuusyaKbn.UKTHONNIN.eq(viewSkjyouhouUiBean.getSeikyuusyakbn())
       || C_SeikyuusyaKbn.STDR.eq(viewSkjyouhouUiBean.getSeikyuusyakbn())
       || C_SeikyuusyaKbn.KYKDAIRININ.eq(viewSkjyouhouUiBean.getSeikyuusyakbn())) { // %>
      setViewSkjyouhou();
  <% } %>

   $(<%=SEIKYUUSYAKBN_VIEWSKJYOUHOUINFO%>).change( function() {
       var value = $(<%=SEIKYUUSYAKBN_VIEWSKJYOUHOUINFO%>).val();
       if ( value == "<%=C_SeikyuusyaKbn.UKTHONNIN.getValue()%>"
           || value == "<%=C_SeikyuusyaKbn.STDR.getValue()%>"
           || value == "<%=C_SeikyuusyaKbn.KYKDAIRININ.getValue()%>" ) {
        setViewSkjyouhou();
       } else {
         $("input[id^='seikyuusyaseiymd']").readonly(false);
         $("input[id^='seikyuusyaseiymd']").removeClass('backgroundReadOnlyGray');
         removeReadOnlyGray(<%=SEIKYUUSYANMKN_VIEWSKJYOUHOUINFO%>);
         removeReadOnlyGray(<%=SEIKYUUSYANMKJ_VIEWSKJYOUHOUINFO%>);
       }
    });
<%
} else { %>
     var viewSkjyouhou = 0;
    <%
      if (viewSkjyouhouUiBean.isViewSkjyouhouSeigyo()) { %>
        $(<%=VIEWSKJYOUHOUINFO + LABEL%>).addClass('toggletitle');

       <%
        if (viewSkjyouhouUiBean.isViewSkjyouhouDispFlg()) {%>
           $(<%= VIEWSKJYOUHOUINFO%>).show();
           viewSkjyouhou = 0;
       <%
       } else { %>
           $(<%= VIEWSKJYOUHOUINFO%>).hide();
           viewSkjyouhou = 1;
       <% } %>

       $(<%= VIEWSKJYOUHOUINFO + LABEL%>).click(function(){
        if (viewSkjyouhou == 0) {
           $(<%= VIEWSKJYOUHOUINFO%>).hide();
           viewSkjyouhou = 1;
        } else {
           $(<%= VIEWSKJYOUHOUINFO%>).show();
           viewSkjyouhou = 0;
        }
     });
    <% } %>
<% } %>

function setViewSkjyouhou () {
   $("select[id^='seikyuusyaseiymd']").find("option:last").attr("selected",true);
   $("input[id^='seikyuusyaseiymd']").val("");
   $("input[id^='seikyuusyaseiymd']").readonly(true);
   $("input[id^='seikyuusyaseiymd']").addClass('backgroundReadOnlyGray');
   $("input[id^='seikyuusyaseiymd']").removeClass("readonly");
   $(<%=SEIKYUUSYANMKN_VIEWSKJYOUHOUINFO%>).val("");
   setReadOnlyGray(<%=SEIKYUUSYANMKN_VIEWSKJYOUHOUINFO%>);
   $(<%=SEIKYUUSYANMKJ_VIEWSKJYOUHOUINFO%>).val("");
   setReadOnlyGray(<%=SEIKYUUSYANMKJ_VIEWSKJYOUHOUINFO%>);
}

});

</script>
