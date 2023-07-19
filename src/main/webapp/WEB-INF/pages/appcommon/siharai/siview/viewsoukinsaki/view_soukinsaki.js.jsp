<%--
    view_soukinsaki.js.jsp - 送金先口座情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiUiBeanParam" %>
<%@page import="yuyu.def.classification.C_InputShrhousiteiKbn" %>
<%@page import="yuyu.def.classification.C_SiharaiTuukaKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsoukinsaki/view_soukinsaki.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSoukinsakiUiBeanParam viewSoukinsakiUiBean = (ViewSoukinsakiUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">
$(function(){
<%
 if (viewSoukinsakiUiBean.isViewSoukinsakiInputDispFlg()) { %>

   <%
     if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(viewSoukinsakiUiBean.getInputshrhousiteikbn()) || C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(viewSoukinsakiUiBean.getInputshrhousiteikbn())) { // %>
        setViewSoukinsaki1();
   <% } else { %>
       <%
          if (C_SiharaiTuukaKbn.GAIKASIHARAI.eq(viewSoukinsakiUiBean.getSiharaituukakbn())) { // %>
            setViewSoukinsaki2();
        <% } %>
   <% } %>
   $(<%=INPUTSHRHOUSITEIKBN_VIEWSOUKINSAKISHRINFO%>).change( function() {
      var value = $(<%=INPUTSHRHOUSITEIKBN_VIEWSOUKINSAKISHRINFO%>).val();
      if ( value == "<%=C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.getValue()%>" ||  value == "<%=C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.getValue()%>") {
          setViewSoukinsaki1();
      } else {
        var siharaituukakbn = $(<%=SIHARAITUUKAKBN_VIEWSKNAIYOUINFO%>).val();
        if ( siharaituukakbn == "<%=C_SiharaiTuukaKbn.GAIKASIHARAI.getValue()%>") {
          setViewSoukinsaki2();
        } else {
          setViewSoukinsaki3();
        }
        removeReadOnlyGray(<%=BANKCD_VIEWSOUKINSAKIINFO%>);

        removeReadOnlyGray(<%=SITENCD_VIEWSOUKINSAKIINFO%>);

        removeReadOnlyGray(<%=KOUZANO_VIEWSOUKINSAKIINFO%>);

        removeReadOnlyGray(<%=KZMEIGINMKN_VIEWSOUKINSAKIINFO%>);

        $(<%=BANKCD_POPUP_BUTTON%>).readonly(false);
      }
   });

   $(<%=SIHARAITUUKAKBN_VIEWSKNAIYOUINFO%>).change( function() {
     var value = $(<%=INPUTSHRHOUSITEIKBN_VIEWSOUKINSAKISHRINFO%>).val();
     if ( value != "<%=C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.getValue()%>" &&  value != "<%=C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.getValue()%>") {
         var siharaituukakbn = $(<%=SIHARAITUUKAKBN_VIEWSKNAIYOUINFO%>).val();
         if ( siharaituukakbn == "<%=C_SiharaiTuukaKbn.GAIKASIHARAI.getValue()%>") {
           setViewSoukinsaki2();
         } else {
           setViewSoukinsaki3();
        }
     }
   });
<%
} else { %>
    var shrhousitei = 0;
    <%
      if (viewSoukinsakiUiBean.isInputshrhousiteiSeigyo()) { %>
        $(<%=VIEWSOUKINSAKISHRINFO + LABEL%>).addClass('toggletitle');

       <%
        if (viewSoukinsakiUiBean.isInputshrhousiteiDispFlg()) {%>
           $(<%= VIEWSOUKINSAKISHRINFO%>).show();
           shrhousitei = 0;
       <%
       } else { %>
           $(<%= VIEWSOUKINSAKISHRINFO%>).hide();
           shrhousitei = 1;
       <% } %>

       $(<%= VIEWSOUKINSAKISHRINFO + LABEL%>).click(function(){
        if (shrhousitei == 0) {
           $(<%= VIEWSOUKINSAKISHRINFO%>).hide();
           shrhousitei = 1;
        } else {
           $(<%= VIEWSOUKINSAKISHRINFO%>).show();
           shrhousitei = 0;
        }
     });
  <% } %>

  <%
   if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(viewSoukinsakiUiBean.getInputshrhousiteikbn()) || C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(viewSoukinsakiUiBean.getInputshrhousiteikbn())) { %>
     $(<%=VIEWSOUKINSAKIINFO + DIV%>).visible(false);
  <%
  } else { %>

     <%
       if (C_SiharaiTuukaKbn.GAIKASIHARAI.eq(viewSoukinsakiUiBean.getSiharaituukakbn())) { %>
          $(<%=YOKINKBN_VIEWSOUKINSAKIINFO%>).parent().parent().visible(false);
          $(<%=KZDOUKBN_VIEWSOUKINSAKIINFO%>).parent().parent().visible(false);
     <% } %>

     $(<%=BANKCD_VIEWSOUKINSAKIINFO%>).addClass('viewSoukinsakiFirstCell');
     $(<%=SITENCD_VIEWSOUKINSAKIINFO%>).addClass('viewSoukinsakiFirstCell');
     var viewSoukinsaki = 0;
    <%
      if (viewSoukinsakiUiBean.isViewSoukinsakiSeigyo()) { %>
        $(<%=VIEWSOUKINSAKIINFO + LABEL%>).addClass('toggletitle');

       <%
        if (viewSoukinsakiUiBean.isViewSoukinsakiDispFlg()) {%>
           $(<%=VIEWSOUKINSAKIINFO%>).show();
           viewSoukinsaki = 0;
       <%
       } else { %>
           $(<%=VIEWSOUKINSAKIINFO%>).hide();
           viewSoukinsaki = 1;
       <% } %>

       $(<%=VIEWSOUKINSAKIINFO + LABEL%>).click(function(){
        if (viewSoukinsaki == 0) {
           $(<%=VIEWSOUKINSAKIINFO%>).hide();
           viewSoukinsaki = 1;
        } else {
           $(<%=VIEWSOUKINSAKIINFO%>).show();
           viewSoukinsaki = 0;
        }
     });
   <% } %>
  <% } %>
<% } %>

function setViewSoukinsaki1 () {
    $(<%=BANKCD_VIEWSOUKINSAKIINFO%>).val("");
    setReadOnlyGray(<%=BANKCD_VIEWSOUKINSAKIINFO%>);

    $(<%=SITENCD_VIEWSOUKINSAKIINFO%>).val("");
    setReadOnlyGray(<%=SITENCD_VIEWSOUKINSAKIINFO%>);

    $(<%=KOUZANO_VIEWSOUKINSAKIINFO%>).val("");
    setReadOnlyGray(<%=KOUZANO_VIEWSOUKINSAKIINFO%>);

    $(<%=KZMEIGINMKN_VIEWSOUKINSAKIINFO%>).val("");
    setReadOnlyGray(<%=KZMEIGINMKN_VIEWSOUKINSAKIINFO%>);

    $(<%=BANKCD_POPUP_BUTTON%>).readonly(true);

    $(<%=BANKCD_VIEWSOUKINSAKIINFO%>).removeClass("readonly");

    setViewSoukinsaki2();
}
function setViewSoukinsaki2 () {
    $(<%=YOKINKBN_VIEWSOUKINSAKIINFO%>).val("0");
    $(<%=YOKINKBN_VIEWSOUKINSAKIINFO%>).find("option").each(function(){
     if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
      }
    });
    $(<%=YOKINKBN_VIEWSOUKINSAKIINFO%>).addClass("backgroundReadOnlyGray");

    $(<%=KZDOUKBN_VIEWSOUKINSAKIINFO%>).val("0");
    $(<%=KZDOUKBN_VIEWSOUKINSAKIINFO%>).find("option").each(function(){
     if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
      }
    });
    $(<%=KZDOUKBN_VIEWSOUKINSAKIINFO%>).addClass("backgroundReadOnlyGray");
}
function setViewSoukinsaki3 () {
    $(<%=YOKINKBN_VIEWSOUKINSAKIINFO%>).find("option").each(function(){
        $(this).removeAttr("disabled");
    });
    $(<%=YOKINKBN_VIEWSOUKINSAKIINFO%>).removeClass("backgroundReadOnlyGray");

    $(<%=KZDOUKBN_VIEWSOUKINSAKIINFO%>).find("option").each(function(){
      $(this).removeAttr("disabled");
    });
    $(<%=KZDOUKBN_VIEWSOUKINSAKIINFO%>).removeClass("backgroundReadOnlyGray");
}

 });
</script>
