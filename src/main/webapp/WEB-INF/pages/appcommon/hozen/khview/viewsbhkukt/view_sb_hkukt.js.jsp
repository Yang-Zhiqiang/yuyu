<%--
    view_sbhkukt.js.jsp - 死亡保険金受取人情報表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.hozen.khview.viewsbhkukt.ViewSbHkuktSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.hozen.khview.viewsbhkukt.ViewSbHkuktUiBeanParam" %>
<%@page import="yuyu.def.classification.C_HyoujiptnKbn" %>
<%@page import="yuyu.def.classification.C_UmuKbn" %>
<%@page import="yuyu.def.classification.C_UktKbn" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/hozen/khview/viewsbhkukt/view_sb_hkukt.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSbHkuktUiBeanParam viewSbhkuktUiBean = (ViewSbHkuktUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">
function varElmAddTopBottomLink(idSelecterList){
    var groupSelecter = idSelecterList.join(',');
    var targetId = $(groupSelecter).filter(':visible').last().attr('id');
    addTopBottomLink('#' + targetId);
}

$(function(){

    <%
    if (viewSbhkuktUiBean.getVshktsbuktnin() != null && viewSbhkuktUiBean.getVshktsbuktnin() >= 1) {%>
       <%
       if (C_UmuKbn.ARI.eq(viewSbhkuktUiBean.getVshktsbkyuuhukinuktumu())){ %>
          $(<%=SBUKTNININFO + LABEL%>).text('<%="●死亡給付金受取人" %>');
       <% } %>
       showGroup(<%=SBUKTNININFO%>);
       showGroup(<%=SBHKUKTINFO1%>);
       <%
       if (!C_UktKbn.BLNK.eq(viewSbhkuktUiBean.getVshktdispsbuktkbn2())) {%>
          showGroup(<%=SBHKUKTINFO2%>);
       <%}%>
       <%
       if (!C_UktKbn.BLNK.eq(viewSbhkuktUiBean.getVshktdispsbuktkbn3())) {%>
          showGroup(<%=SBHKUKTINFO3%>);
       <%}%>
       <%
       if (!C_UktKbn.BLNK.eq(viewSbhkuktUiBean.getVshktdispsbuktkbn4())) {%>
          showGroup(<%=SBHKUKTINFO4%>);
       <%}%>
       <%
       if (C_HyoujiptnKbn.SYOUKAI.eq(commonViewInBean.getHyoujiptnKbn())) {%>
       varElmAddTopBottomLink([
          <%= SBUKTNININFO %>,
          <%= SBHKUKTINFO1 %>,
          <%= SBHKUKTINFO2 %>,
          <%= SBHKUKTINFO3 %>,
          <%= SBHKUKTINFO4 %>
           ]);
        <%}%>
     <%}%>

});

</script>
