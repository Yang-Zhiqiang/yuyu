<%--
    si_seikyuu_uketuke_sb.js.jsp - （死亡）請求受付 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.siskuke.siseikyuuuketukesb.SiSeikyuuUketukeSbConstants.*" %>
<%@page import="static yuyu.app.siharai.siskuke.siseikyuuuketukesb.SiSeikyuuUketukeSbSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.siskuke.siseikyuuuketukesb.SiSeikyuuUketukeSbUiBean" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<% SiSeikyuuUketukeSbUiBean uiBean = SWAKInjector.getInstance(SiSeikyuuUketukeSbUiBean.class); %>
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class);
   commonViewInBean.setCommonViewUiBeanParam(uiBean);
%>
<%
if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewskkihon/view_sk_kihon.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewskjyouhou/view_skjyouhou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsaikeninfo/view_saiken_info.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsouhusaki/view_souhusaki.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsknaiyou/view_sknaiyou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsoukinsaki/view_soukinsaki.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsindansyoinfosibou/view_sindansyoinfo_sibou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrdtlsakuseikbn/view_shrdtl_sakusei_kbn.js.jsp"/>
<% } %>

<%
if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewskjyouhou/view_skjyouhou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsaikeninfo/view_saiken_info.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsinkensya/view_sinkensya.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsouhusaki/view_souhusaki.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsknaiyou/view_sknaiyou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsoukinsaki/view_soukinsaki.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsindansyoinfosibou/view_sindansyoinfo_sibou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewsateikaisouyouhisibou/view_sateikaisouyouhi_sibou.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewshrdtlsakuseikbn/view_shrdtl_sakusei_kbn.js.jsp"/>
  <jsp:include page="/WEB-INF/pages/appcommon/siharai/siview/viewmnmeigibangou/view_mn_meigi_bangou.js.jsp"/>
<% } %>
<script type="text/javascript">
$(function(){

  <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_RESULT) { %>
      <%
        if (!uiBean.isKidougmKbnWorkListSeigyo()) { %>
          $(<%=KOUTEIINFO + DIV%>).visible(false);
    <% } %>
  <% } %>
  <%
     if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
       <%
        if (uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
          $(<%=KOUTEIINFO + DIV%>).visible(false);
       <%
         } else { %>
           <%
             if (!uiBean.isKidougmKbnWorkListSeigyo()) { %>
               $(<%=KOUTEIINFO + DIV%>).visible(false);
            <% } %>
       <% } %>
  <% } %>

  <%
     if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
       <%
         if (uiBean.isSiTtzkRirekiSyoukaiHyojiSeigyo()) { %>
           $(<%=MODORUBTNBYCONFIRM_FOOTERBUTTONS3 %>).visible(false);
           $(<%=KAKUTEIBTN_FOOTERBUTTONS3%>).visible(false);
           $(<%=FUNCTION_NAME%>).text('<%= uiBean.getKinouNm() %>');
           $(<%= FUNCTION_NAME %>).attr("disabled", "true");
           $(<%= FUNCTION_NAME %>).parent().removeClass('contentsHeaderLeft').addClass('contentsHeaderLeftIe11');
           $(<%= TOJIRUBTN_HEADERBUTTONS %>).visible(false);
       <%
         } else {  %>
           $(<%= TOJIRUBTNBYPOPUP_HEADERBUTTONS %>).visible(false);
       <% } %>
  <% } %>

  <%
    if (uiBean.isViewBanknmSitennmDispFlg()) { %>
        $(<%=DISPBANKNMKJ_VIEWSOUKINSAKIINFO + LABEL%>).parent().visible(true);
        $(<%=DISPBANKNMKJ_VIEWSOUKINSAKIINFO%>).parent().visible(true);
        $(<%=DISPSITENNMKJ_VIEWSOUKINSAKIINFO + LABEL%>).parent().visible(true);
        $(<%=DISPSITENNMKJ_VIEWSOUKINSAKIINFO%>).parent().visible(true);
  <% } %>

      $(<%=DISPBANKNMKJ_VIEWSOUKINSAKIINFO%>).addClass('SoukinsakiInfoMsgLocation');
      $(<%=DISPSITENNMKJ_VIEWSOUKINSAKIINFO%>).addClass('SoukinsakiInfoMsgLocation');
      $(<%=BANKCD_VIEWSOUKINSAKIINFO + SPAN%>).addClass('SoukinsakiInfoMsgLocation');
      $(<%=SITENCD_VIEWSOUKINSAKIINFO + SPAN%>).addClass('SoukinsakiInfoMsgLocation');
      $(<%=YOKINKBN_VIEWSOUKINSAKIINFO + SPAN%>).addClass('SoukinsakiInfoMsgLocation');
      $(<%=KOUZANO_VIEWSOUKINSAKIINFO + SPAN%>).addClass('SoukinsakiInfoMsgLocation');

  <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
      <%
        if (uiBean.isKidougmKbnWorkListSeigyo()) {  %>
            <%
              if (!uiBean.isSiSateiSougouSyoukaiFlg()) {  %>
                syoukaibtnOnClick();
                <% uiBean.setSiSateiSougouSyoukaiFlg(true); %>
            <% } %>
     <% } %>
  <% } %>

 function syoukaibtnOnClick() {
    $(<%=SYOUKAIBTNHIHYOUJI_FOOTERBUTTONS5%>).trigger("click");
 }
});
</script>
