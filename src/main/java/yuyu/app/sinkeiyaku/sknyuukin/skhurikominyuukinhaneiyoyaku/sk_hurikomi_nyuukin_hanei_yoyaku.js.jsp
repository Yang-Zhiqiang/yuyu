<%--
    sk_hurikomi_nyuukin_hanei_yoyaku.js.jsp - 振込入金反映予約 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku.SkHurikomiNyuukinHaneiYoyakuConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku.SkHurikomiNyuukinHaneiYoyakuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<%@page import="jp.co.slcs.swak.number.BizCurrency"%>
<%@page import="yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku.SkHurikomiNyuukinHaneiYoyakuUiBean" %>
<% SkHurikomiNyuukinHaneiYoyakuUiBean uiBean = SWAKInjector.getInstance(SkHurikomiNyuukinHaneiYoyakuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
<%
   if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
   $(<%= UPLOADFILE_UPLOADFILEINFO%>).addClass('uploadfileCss');
<% } %>

<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||
       uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
         $(<%= ROWSPAN_CLASS_2%>).attr('rowspan', '2');
         $(<%= COLSPAN_CLASS_1%>).attr("colspan","3");
<% } %>
<%
   if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

       $(".rsgaku_data").each(
        function(){
          $(this).removeClass('alignRight');
       });

       var hrkTuukasyuZen;
       var hrkTuukasyuGo;

      <% for (int i = 0; i < uiBean.getHrkmnyknInfoDataSource().getAllData().size(); i++) { %>

             if ($(<%=  HRKTUUKASYU_HRKMNYKNINFO(i) %>).val() == <%= C_Tuukasyu.BLNK.getValue() %>) {
                  $(<%= RSGAKU_HRKMNYKNINFO(i)%>).next().next().text('');
             }

             $(<%=  HRKTUUKASYU_HRKMNYKNINFO(i) %>).focus(function() {
               hrkTuukasyuZen = $(<%=  HRKTUUKASYU_HRKMNYKNINFO(i) %>).val();
             });

             $(<%= HRKTUUKASYU_HRKMNYKNINFO(i) %>).blur(function () {
                hrkTuukasyuGo = $(<%= HRKTUUKASYU_HRKMNYKNINFO(i) %>).val();

                if (hrkTuukasyuZen != hrkTuukasyuGo) {
                    var tuukasyu = $(this).val();
                    if (tuukasyu == <%= C_Tuukasyu.BLNK.getValue() %>) {
                        $(<%= RSGAKU_HRKMNYKNINFO(i)%>).next().next().text('');
                        $(<%= RSGAKU_HRKMNYKNINFO(i)%>).val('<%= BizCurrency.optional()%>');
                    }
                    else {
                      callAjaxCurrencyChange(tuukasyu, <%= i%>, <%= RSGAKU_HRKMNYKNINFO(i)%>);
                   }
                }
            });
      <% } %>

       function callAjaxCurrencyChange(tuukasyu, rowNo, selector) {
         var form = $('form').attr('action');
         form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";

         $.ajax({
           type: "POST",
           url: form,
           data: {
             <%= AJAX_POST_PARAM_TUUKASYU %>: tuukasyu,
             <%= AJAX_POST_PARAM_ROWNO %>: rowNo,
             <%= AJAX_POST_PARAM_SWAK_CID %>: $('input[name=swak-cid]').val()
           },
           dataType: "json"
         }).success(function(data) {
           $(selector).val(data[0]);
           $(selector).next().text(data[1]);
           $(selector).next().next().text(data[2]);
           $(selector).next().next().next().val(data[3]);
         });
       }

    <% } %>
<%
   if (uiBean.getPageNo() == PAGENO_CONFIRM ||
       uiBean.getPageNo() == PAGENO_RESULT) { %>
       $(<%=RSGAKU_LABEL%>).html('<%=RSGAKU_DENGK_TATILE%>');

       $(<%=HRKMNYKNINFO%>).find(<%=SHR_SYOUSAI_S_LIST_CELL %>).each(function(){
         $(this).find("span").eq(1).before('<br/>');
       });

       showList(<%=IKKTNYKNINFO%>);
       showList(<%=GKKWSSEKINFO%>);

        $(<%=HRKMNYKNINFO%>).find("tr").each(function(i) {
          var $dengk = $(document.getElementById('hrkmnyknInfo['+ i + '].dengk'));

          if ($dengk.text() == '') {
            $dengk.before('<br/>');
          }
        });
<% } %>
});
//-->
</script>
