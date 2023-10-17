<%--
    si_hubi_naiyou_kensaku.js.jsp - 保険金給付金不備内容検索 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku.SiHubiNaiyouKensakuConstants.*" %>
<%@page import="static yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku.SiHubiNaiyouKensakuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku.SiHubiNaiyouKensakuUiBean" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="jp.co.slcs.swak.web.ui.UserDefsList" %>
<script type="text/javascript"><!--
<% SiHubiNaiyouKensakuUiBean uiBean = SWAKInjector.getInstance(SiHubiNaiyouKensakuUiBean.class); %>
$(function(){

  parent.$(<%= DIALOG %>).dialog({
    title: document.title
  });

  $(<%= DISPJIMUTETUZUKINM_SEARCHCONDITIONS%>).on('change', function(){
    changeSyoruiNm(<%= DISPJIMUTETUZUKINM_SEARCHCONDITIONS%>,<%= DISPSYORUINMSNTK_SEARCHCONDITIONS%>);
  });

  changeSyoruiNm(<%= DISPJIMUTETUZUKINM_SEARCHCONDITIONS%>,<%= DISPSYORUINMSNTK_SEARCHCONDITIONS%>);

  showList(<%= HUBINAIYOULIST%>);

  function changeSyoruiNm(dispjimutetuzukinm,dispsyoruinmsntk){
    var dispjimuCd = $(dispjimutetuzukinm).val();
    $(<%= DISPSYORUINMSNTK_SEARCHCONDITIONS%> + " option").remove();
    $(dispsyoruinmsntk).append("<option/>");

    if(dispjimuCd == ''){
        $(<%= DISPSYORUINMSNTK_SEARCHCONDITIONS%>).disable(true);
    }
    else{
        $(<%= DISPSYORUINMSNTK_SEARCHCONDITIONS%>).disable(false);
        <%
        Map<String,String> syoruiMap = new HashMap<String,String>();%>
        <%
        for (int idx = 0;idx < uiBean.getSiHubiNaiYouLst().size();idx++) {%>
            if(dispjimuCd == '<%= uiBean.getSiHubiNaiYouLst().get(idx).getJimutetuzukicd()%>'){
                <%
                if (!syoruiMap.containsKey(uiBean.getSiHubiNaiYouLst().get(idx).getSyoruiCd().getValue())) {%>
                    $(dispsyoruinmsntk).append("<option value = '<%= uiBean.getSiHubiNaiYouLst().get(idx).getSyoruiCd().getValue()%>'><%= uiBean.getSiHubiNaiYouLst().get(idx).getSyoruiCd().getContent()%></option>");
                    <%
                    syoruiMap.put(uiBean.getSiHubiNaiYouLst().get(idx).getSyoruiCd().getValue(),uiBean.getSiHubiNaiYouLst().get(idx).getSyoruiCd().getContent());%>
                    <%}
                    %>
                }
            <% }%>
    }

    $(dispsyoruinmsntk).find("option[value = '<%= uiBean.getDispsyoruinmsntk()%>']").attr("selected",true);
  }

    $('.popupReturnLink').each(function() {
      var item = $(this).parent().find("span").eq(3);
      item.text(item.html());

  });
});
//-->
</script>
