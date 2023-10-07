<%--
    sk_hurikomi_sakujyo_touroku.js.jsp - 振込入金削除データ登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku.SkHurikomiSakujyoTourokuConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku.SkHurikomiSakujyoTourokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku.SkHurikomiSakujyoTourokuUiBean" %>
<%@page import="jp.co.slcs.swak.number.currencytype.BizCurrencyTypes" %>
<%@page import="yuyu.def.classification.C_Tuukasyu" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>

<% SkHurikomiSakujyoTourokuUiBean uiBean = SWAKInjector.getInstance(SkHurikomiSakujyoTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

    var tuukasyu = $(<%= RSTUUKASYU_KIHONINFO %>).val();
    if ( tuukasyu == <%= C_Tuukasyu.BLNK.getValue() %> ) {
        setReadOnlyGray(<%= RSGAKU_KIHONINFO %>);
    }

    var rstuukasyuZen;

    $(<%= RSTUUKASYU_KIHONINFO%>).focus(function() {
      rstuukasyuZen = $(<%= RSTUUKASYU_KIHONINFO%>).val();
    });

    $(<%= RSTUUKASYU_KIHONINFO%>).blur(function() {
      var rstuukasyuGo = $(<%= RSTUUKASYU_KIHONINFO%>).val();

      if (rstuukasyuZen != rstuukasyuGo) {
            var tuukasyu = $(<%= RSTUUKASYU_KIHONINFO %>).val();
            if ( tuukasyu == <%=  C_Tuukasyu.BLNK.getValue() %> ) {
                 setReadOnlyGray(<%= RSGAKU_KIHONINFO %>);
            }
            else{
                removeReadOnlyGray(<%=RSGAKU_KIHONINFO%>);
            }
            callAjaxCurrencyChange(tuukasyu,  <%= RSGAKU_KIHONINFO %>);
      }
    });

    <% for (int i = 0; i < uiBean.getSakujyoInfoListDataSource().getAllData().size(); i++){ %>
         $(document).on('click', <%=DISPSAKUJYOLINK_SAKUJYOINFOLIST(i) %>,function(){
           if(window.confirm('<%=MessageUtil.getMessage(MessageId.QAC0010) %>')){
             $(<%=SAKUJYOLINK_SAKUJYOINFOLIST(i) %>).click();
           }
         });
    <% } %>

    function callAjaxCurrencyChange(tuukasyu, selector) {
      var form = $('form').attr('action');
      form = form + "?<%= AJAX_POST_EVENTHANDLER_COMMON %>";

      $.ajax({
        type: "POST",
        url: form,
        data: {
          <%= AJAX_POST_PARAM_TUUKASYU %>: tuukasyu,
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
});
//-->
</script>
