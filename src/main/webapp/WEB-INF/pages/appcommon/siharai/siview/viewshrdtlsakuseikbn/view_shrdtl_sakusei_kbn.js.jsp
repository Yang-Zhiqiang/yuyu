<%--
    view_shrdtl_sakusei_kbn.js.jsp - 支払明細書作成区分 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnUiBeanParam" %>
<%@page import="yuyu.def.classification.C_KanryotuutioutKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewshrdtlsakuseikbn/view_shrdtl_sakusei_kbn.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewShrdtlSakuseiKbnUiBeanParam viewshrdtlsakuseikbnUiBean = (ViewShrdtlSakuseiKbnUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){
  <%
     if (viewshrdtlsakuseikbnUiBean.isViewShrdtlSakuseiKbnFlg()) { %>
        showGroup(<%=VIEWSHRDTLSAKUSEIKBNINFO%>);

        <%
           if (viewshrdtlsakuseikbnUiBean.isViewShrdtlSakuseiKbnInputDispFlg()) { %>
              <%
                 if (C_KanryotuutioutKbn.PDF.eq(viewshrdtlsakuseikbnUiBean.getShrdtlsyooutkbn())) { // %>
                    setViewShrdtlSakuseiKbn();
              <% } %>

               $(<%=SHRDTLSYOOUTKBN_VIEWSHRDTLSAKUSEIKBNINFO%>).change( function() {
                   var value = $(<%=SHRDTLSYOOUTKBN_VIEWSHRDTLSAKUSEIKBNINFO%>).val();
                   if ( value == "<%=C_KanryotuutioutKbn.PDF.getValue()%>" ) {
                      setViewShrdtlSakuseiKbn();
                   } else {
                       $(<%=HASSOUKBN_VIEWSHRDTLSAKUSEIKBNINFO%>).find("option").each(function(){
                        $(this).removeAttr("disabled");
                       });
                       $(<%=HASSOUKBN_VIEWSHRDTLSAKUSEIKBNINFO%>).removeClass("backgroundReadOnlyGray");
                   }
                });
         <%
            } else { %>
          var viewShrdtlSakuseiKbnDispKbn = 0;
          <%
          if (viewshrdtlsakuseikbnUiBean.isViewShrdtlSakuseiKbnSeigyo()) { %>
              $(<%=VIEWSHRDTLSAKUSEIKBNINFO + LABEL%>).addClass('toggletitle');

              <%
              if (viewshrdtlsakuseikbnUiBean.isViewShrdtlSakuseiKbnDispFlg()) { %>
                  $(<%= VIEWSHRDTLSAKUSEIKBNINFO%>).show();
              <%
              } else { %>
                  $(<%= VIEWSHRDTLSAKUSEIKBNINFO%>).hide();
                  viewShrdtlSakuseiKbnDispKbn = 1;
              <% } %>

              $(<%= VIEWSHRDTLSAKUSEIKBNINFO + LABEL%>).click(function(){
                  if (viewShrdtlSakuseiKbnDispKbn == 0) {
                      $(<%= VIEWSHRDTLSAKUSEIKBNINFO%>).hide();
                      viewShrdtlSakuseiKbnDispKbn = 1;
                  } else {
                      $(<%= VIEWSHRDTLSAKUSEIKBNINFO%>).show();
                      viewShrdtlSakuseiKbnDispKbn = 0;
                  }
              });
          <% } %>
     <% } %>
  <% } %>

function setViewShrdtlSakuseiKbn () {
    $(<%=HASSOUKBN_VIEWSHRDTLSAKUSEIKBNINFO%>).val("0");
    $(<%=HASSOUKBN_VIEWSHRDTLSAKUSEIKBNINFO%>).find("option").each(function(){
      if ($(this).val() != 0) {
        $(this).attr("disabled", "true");
      }
    });
    $(<%=HASSOUKBN_VIEWSHRDTLSAKUSEIKBNINFO%>).addClass("backgroundReadOnlyGray");
}

});

</script>
