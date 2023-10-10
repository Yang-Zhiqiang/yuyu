<%--
    kh_hubi_naiyou_kensaku.js.jsp - 契約保全不備内容検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page
  import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page import="jp.co.slcs.swak.web.ui.UserDefsList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page
  import="static yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku.KhHubiNaiyouKensakuConstants.*"%>
<%@page
  import="static yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku.KhHubiNaiyouKensakuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
  import="yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku.KhHubiNaiyouKensakuUiBean"%>
<%
    KhHubiNaiyouKensakuUiBean uiBean = SWAKInjector.getInstance(KhHubiNaiyouKensakuUiBean.class);
%>
<script type="text/javascript">
<!--
$(function(){
  $(<%= JIMUTTDKNM_INPUTGROUP %>).on('change', function(){
    changeJimuttdkNm(<%= JIMUTTDKNM_INPUTGROUP%>, <%= DISPSYORUINMSNTK_INPUTGROUP%>);
  });

  if (opener == null) {
    $(<%= JIMUTTDKNM_INPUTGROUP %>).disable(true);
  }

  changeJimuttdkNm(<%= JIMUTTDKNM_INPUTGROUP%>, <%= DISPSYORUINMSNTK_INPUTGROUP%>);

  showList(<%= FUBINAIYOULIST %>);

  function changeJimuttdkNm(jimuCd, syoruiCd){

     var jimuCdVal = $(jimuCd).val();

     $(<%= DISPSYORUINMSNTK_INPUTGROUP %> + " option").remove()

     $(syoruiCd).append("<option/>");

     if (jimuCdVal == '') {
         $(syoruiCd).val('');
         $(<%= DISPSYORUINMSNTK_INPUTGROUP %>).disable(true);
     } else {
         $(<%= DISPSYORUINMSNTK_INPUTGROUP %>).disable(false);

         <%Map<String, String> extinfo = new HashMap<String, String>();%>
         <% for (int i = 0; i < uiBean.getKhHubiNaiyouList().size(); i++) { %>
               <% if (!extinfo.containsKey(uiBean.getKhHubiNaiyouList().get(i).getJimutetuzukicd())) {%>
                      <%extinfo = new HashMap<String, String>();%>
               <% } %>
               <% if (!extinfo.containsValue(uiBean.getKhHubiNaiyouList().get(i).getSyoruiCd().getValue())) {%>
                  if (jimuCdVal == '<%= uiBean.getKhHubiNaiyouList().get(i).getJimutetuzukicd() %>') {
                    $(syoruiCd).append("<option value = '<%= uiBean.getKhHubiNaiyouList().get(i).getSyoruiCd()%>'><%= uiBean.getKhHubiNaiyouList().get(i).getSyoruiCd().getContent()%></option> ");
                    <%extinfo.put(uiBean.getKhHubiNaiyouList().get(i).getJimutetuzukicd(), uiBean.getKhHubiNaiyouList().get(i).getSyoruiCd().getValue());%>
                  }
               <% } %>
         <% } %>

         $(syoruiCd).find("option[value = '<%= uiBean.getDispsyoruinmsntk()%>']").attr("selected", true);
     }
  }

  $('.popupReturnLink').each(function() {
      var item = $(this).parent().find("span").eq(3);
      item.text(item.html());
  });

});
//-->
</script>
