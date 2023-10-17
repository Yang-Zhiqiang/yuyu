<%--
    kh_cifcd_ikkatu_henkou_touroku.js.jsp - ＣＩＦコード一括変更登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.KhCifcdIkkatuHenkouTourokuConstants.*" %>
<%@page import="static yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.KhCifcdIkkatuHenkouTourokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.KhCifcdIkkatuHenkouTourokuUiBean" %>
<% KhCifcdIkkatuHenkouTourokuUiBean uiBean = SWAKInjector.getInstance(KhCifcdIkkatuHenkouTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
    $(<%= UPLOADFILE_UPLOADFILEINFO%>).addClass('uploadfileCss');
  <% } %>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    showGroup(<%=CIFCODEHENKOUINFO%>);
    if ($(<%=CIFCODEHENKOUINFO%>)[0].rows.length > 1) {
       $(<%=CIFCODEHENKOUINFOTITLE + DIV%>).visible(true);
       $(<%=CIFCODEHENKOUINFO + DIV%>).find("tr").eq(0).remove();
       if ($(<%=CIFCODEHENKOUINFO%>)[0].rows.length >= 20) {
         $(<%=CIFCODEHENKOUINFO + DIV%>).css("height","567px");
         $('.dataCell1').css("width","32px");
         $('.dataCell2').css("width","461px");
         $('.dataCell3').css("width","446px");
       }
       $(<%= CIFCODEHENKOUINFO + DIV %>).css("margin-top", "-1px");

       $(<%= CIFCODEHENKOUINFO + DIV %>).scroll(function() {

         $(<%= CIFCODEHENKOUINFOTITLE + DIV %>).scrollTop($(this).scrollTop());
       });

     }
 <% } %>

 <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
   <% if (uiBean.getSyoriKuben() == E_SyoriKubun.TOUROKU) { %>
     showGroup(<%=CIFCODEHENKOUINFO%>);
     if ($(<%=CIFCODEHENKOUINFO%>)[0].rows.length > 1) {
       $(<%=CIFCODEHENKOUINFOTITLE + DIV%>).visible(true);
       $(<%=CIFCODEHENKOUINFO + DIV%>).find("tr").eq(0).remove();
       if ($(<%=CIFCODEHENKOUINFO%>)[0].rows.length >= 20) {
         $(<%=CIFCODEHENKOUINFO + DIV%>).css("height","567px");
         $('.dataCell1').css("width","32px");
         $('.dataCell2').css("width","461px");
         $('.dataCell3').css("width","446px");
       }
       $(<%= CIFCODEHENKOUINFO + DIV %>).css("margin-top", "-1px");

       $(<%= CIFCODEHENKOUINFO + DIV %>).scroll(function() {

         $(<%= CIFCODEHENKOUINFOTITLE + DIV %>).scrollTop($(this).scrollTop());
       });
     }
   <% } %>
 <% } %>
});
//-->
</script>
