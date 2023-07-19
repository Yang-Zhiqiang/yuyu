<%--
    view_syorui_info_itiran.js.jsp - 書類情報一覧表示 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSyoruiInfoItiranUiBeanParam viewSyoruiInfoItiranUiBeanParam = (ViewSyoruiInfoItiranUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

showList(<%=SYORUIINFOLIST%>);

if ($(<%=SYORUIINFOLIST%>)[0].rows.length > 1) {
    showGroup(<%=BUTTONALLHYOUJI%>);
}

var zenHyoujiFlg = false;

$(<%=SYORUIINFOLIST%>).find('tr').each(function(index){
  if($(<%=SYORUIINFOLIST%>)[0].rows.length == (index + 1)) {
     return false;
  }

  var $hyoujiLinkFlg = $(document.getElementById('syoruiInfoList['+ index +'].hyoujilinkflg'));

  if ($hyoujiLinkFlg.text() == '0') {
    var $hyoujiLink = $(document.getElementById('syoruiInfoList['+ index +'].hyoujilink'));
    var $hyoujiLinkSpan = $(document.getElementById('syoruiInfoList['+ index +'].hyoujilinkSpan'));

    $hyoujiLink.remove();
    $hyoujiLinkSpan.text('<%=MessageUtil.getMessage(MessageId.IBW0002) %>');
  }
  if ($hyoujiLinkFlg.text() == '1') {
    zenHyoujiFlg = true;
  }
});

if(zenHyoujiFlg == false) {

   $(<%= ALLHYOUJIBTN_BUTTONALLHYOUJI %>).disable(true);
}

$("a[id *= 'hyoujilink']").click(function(){
  var imageId = $(this).parent().next().next().text();
  var eventName = "hyoujilinkOnClick" + "&ui:000imageid=" + imageId;
  openWindow(eventName,"_blank");

});

$(<%= ALLHYOUJIBTN_BUTTONALLHYOUJI %>).click(function(){
  openWindow("allhyoujibtnOnClick","_blank");

});


});

</script>
