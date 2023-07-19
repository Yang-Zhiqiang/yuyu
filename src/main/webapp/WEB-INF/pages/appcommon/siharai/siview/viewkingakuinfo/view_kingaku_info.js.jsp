<%--
    view_kingaku_info.js.jsp - 金額情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewkingakuinfo.ViewKingakuInfoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.siharai.siview.viewkingakuinfo.ViewKingakuInfoUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewkingakuinfo/view_kingaku_info.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewKingakuInfoUiBeanParam viewKingakuInfoUiBean = (ViewKingakuInfoUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

<%
    if(!viewKingakuInfoUiBean.isViewKingakuInfoHokenryouStgkDispFlg()) { %>
        $(<%=HOKENRYOUSTGK_VIEWKINGAKUINFO%>).parent().parent().visible(false);
<% } %>

<%
    if(!viewKingakuInfoUiBean.isViewKingakuInfoTutaKngkDispFlg()) { %>
        $(<%=TUTAKNGK_VIEWKINGAKUINFO%>).parent().parent().visible(false);
<% } %>

<%
    if(!viewKingakuInfoUiBean.isViewKingakuInfoKaiyakuHrDispFlg()) { %>
        $(<%=KAIYAKUHR_VIEWKINGAKUINFO%>).parent().parent().visible(false);
<% } %>

<%
    if(!viewKingakuInfoUiBean.isViewKingakuInfoKihonHokenKngkDispFlg()) { %>
        $(<%=KIHONHOKENKNGK_VIEWKINGAKUINFO%>).parent().parent().visible(false);
<% } %>

<%
    if(!viewKingakuInfoUiBean.isViewKingakuInfoSaigaiSDispFlg()) { %>
        $(<%=SAIGAIS_VIEWKINGAKUINFO%>).parent().parent().visible(false);
<% } %>


<%
   if (viewKingakuInfoUiBean.isViewKingakuInfoSeigyo()) { %>
      $(<%=VIEWKINGAKUINFO + LABEL%>).addClass('toggletitle');
      var viewkingakuinfoDispKbn = 0;
      <%
         if (viewKingakuInfoUiBean.isViewKingakuInfoDispFlg()) { %>
            $(<%= VIEWKINGAKUINFO%>).show();
      <%
         } else { %>
            $(<%= VIEWKINGAKUINFO%>).hide();
            viewkingakuinfoDispKbn = 1;
      <% } %>
      $(<%= VIEWKINGAKUINFO + LABEL%>).click(function(){
          if (viewkingakuinfoDispKbn == 0) {
             $(<%= VIEWKINGAKUINFO%>).hide();
             viewkingakuinfoDispKbn = 1;
          } else {
             $(<%= VIEWKINGAKUINFO%>).show();
             viewkingakuinfoDispKbn = 0;
          }
       });
<% } %>

});

</script>
