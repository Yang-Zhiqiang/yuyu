<%--
    bz_tyouhyou_kobetu.js.jsp - 帳票個別出力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bztyouhyou.bztyouhyoukobetu.BzTyouhyouKobetuConstants.*"%>
<%@page
	import="static yuyu.app.biz.bztyouhyou.bztyouhyoukobetu.BzTyouhyouKobetuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bztyouhyou.bztyouhyoukobetu.BzTyouhyouKobetuUiBean"%>
<%@page import="yuyu.common.biz.bzcommon.BizUtil"%>
<%@page import="yuyu.def.biz.result.bean.SyoruiZokuseiMasterInfoBean"%>
<% BzTyouhyouKobetuUiBean uiBean = SWAKInjector.getInstance(BzTyouhyouKobetuUiBean.class); %>
<script type="text/javascript">
$(function(){

<% if (uiBean.getPageNo() == PAGENO_INPUTKEY) { %>
var allSrchsyoruicd = [];
$(<%= SRCHSYORUICD_KENSAKUJYOUKEN %> + " option").each(
  function() {
    allSrchsyoruicd.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);

var svSubSystemId = $(<%= SRCHSUBSYSTEMID_KENSAKUJYOUKEN %>).val();
$(<%= SRCHSUBSYSTEMID_KENSAKUJYOUKEN %>).change(
  function() {
     var subSystemId = $(this).val();
      $(<%= SRCHSYORUICD_KENSAKUJYOUKEN %> + " option").remove();
      $(<%=SRCHSYORUICD_KENSAKUJYOUKEN %>).val("");
      $("select[id^='tyouhyouymdfrom']").find("option:last").attr("selected",true);
      $("input[id^='tyouhyouymdfrom']").val("");
      $("select[id^='tyouhyouymdto']").find("option:last").attr("selected",true);
      $("input[id^='tyouhyouymdto']").val("");
      $(<%=KNSKKMKID1_KENSAKUJYOUKEN%>).val("");
      $(<%=KNSKKMKID2_KENSAKUJYOUKEN%>).val("");
      $(<%=KNSKKMKID3_KENSAKUJYOUKEN%>).val("");
      $(<%=KNSKKMKID4_KENSAKUJYOUKEN%>).val("");
      $(<%=KNSKKMKID5_KENSAKUJYOUKEN%>).val("");
      for (var i in allSrchsyoruicd) {
        with (allSrchsyoruicd[i]) {
          if ((id.length == 0) || id.startsWith(subSystemId + '.')) {
            $(<%= SRCHSYORUICD_KENSAKUJYOUKEN %>).append($("<option />").val(id).text(name));
          }
        }
      }
   dispControlGyoumuKey();
  }
);

dispControlGyoumuKey();

$(<%= SRCHSYORUICD_KENSAKUJYOUKEN%>).change(function() {
   dispControlGyoumuKey();
   $("select[id^='tyouhyouymdfrom']").find("option:last").attr("selected",true);
   $("input[id^='tyouhyouymdfrom']").val("");
   $("select[id^='tyouhyouymdto']").find("option:last").attr("selected",true);
   $("input[id^='tyouhyouymdto']").val("");
   $(<%=KNSKKMKID1_KENSAKUJYOUKEN%>).val("");
   $(<%=KNSKKMKID2_KENSAKUJYOUKEN%>).val("");
   $(<%=KNSKKMKID3_KENSAKUJYOUKEN%>).val("");
   $(<%=KNSKKMKID4_KENSAKUJYOUKEN%>).val("");
   $(<%=KNSKKMKID5_KENSAKUJYOUKEN%>).val("");
});
  var valSyoruicd = $(<%=SRCHSYORUICD_KENSAKUJYOUKEN %>).val();
  $(<%= SRCHSYORUICD_KENSAKUJYOUKEN %> + " option").remove();
  for (var i in allSrchsyoruicd) {
      with (allSrchsyoruicd[i]) {
        if ((id.length == 0) || id.startsWith(svSubSystemId + '.')) {
          $(<%= SRCHSYORUICD_KENSAKUJYOUKEN %>).append($("<option />").val(id).text(name));
        }
      }
  }
  $(<%=SRCHSYORUICD_KENSAKUJYOUKEN %>).val(valSyoruicd);
<% }%>

<% if (uiBean.getPageNo() == PAGENO_SEARCHRESULT) { %>
  $(<%=KNSKKMKNM1_LABEL%>).text('<%=uiBean.getDispkensakukii1()%>');
  $(<%=KNSKKMKNM2_LABEL%>).text('<%=uiBean.getDispkensakukii2()%>');
  $(<%=KNSKKMKNM3_LABEL%>).text('<%=uiBean.getDispkensakukii3()%>');
  $(<%=KNSKKMKNM4_LABEL%>).text('<%=uiBean.getDispkensakukii4()%>');
  $(<%=KNSKKMKNM5_LABEL%>).text('<%=uiBean.getDispkensakukii5()%>');

  var  value = '<%= uiBean.getDispsyoruicd() %>';

  var object = '<%= uiBean.getKensakunmMap()%>';
  var codeObject = new Object();
  var syoruicdObject = object.split(",");
  var cnt;
  for (cnt=0;cnt < syoruicdObject.length;cnt++) {
    var keyObject = syoruicdObject[cnt].split("=");
    codeObject[keyObject[0].replace('{',"").trim()] = keyObject[1].replace('}',"");
  }
  var kensakunm1 = codeObject[value.split(".")[1]].split("#");
   $(<%=KNSKKMKID1_KENSAKUJYOUKEN%>).val("");
   $(<%=KNSKKMKID2_KENSAKUJYOUKEN%>).val("");
   $(<%=KNSKKMKID3_KENSAKUJYOUKEN%>).val("");
   $(<%=KNSKKMKID4_KENSAKUJYOUKEN%>).val("");
   $(<%=KNSKKMKID5_KENSAKUJYOUKEN%>).val("");
  if (kensakunm1[0].length != 0) {
    <% if (!BizUtil.isBlank(uiBean.getKnskkmkid1())) { %>
        showKoumoku(<%=KNSKKMKID1_KENSAKUJYOUKEN%>);
    <%}%>

    $(<%=KNSKKMKID1_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[0]);
   }
  if (kensakunm1[1] != undefined ) {
     <% if (!BizUtil.isBlank(uiBean.getKnskkmkid2())) { %>
         showKoumoku(<%=KNSKKMKID2_KENSAKUJYOUKEN%>);
     <%}%>
    $(<%=KNSKKMKID2_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[1]);
  }
  if (kensakunm1[2] != undefined) {
    <% if (!BizUtil.isBlank(uiBean.getKnskkmkid3())) { %>
        showKoumoku(<%=KNSKKMKID3_KENSAKUJYOUKEN%>);
    <%}%>
    $(<%=KNSKKMKID3_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[2]);
  }
  if (kensakunm1[3] != undefined) {
     <% if (!BizUtil.isBlank(uiBean.getKnskkmkid4())) { %>
         showKoumoku(<%=KNSKKMKID4_KENSAKUJYOUKEN%>);
     <%}%>

    $(<%=KNSKKMKID4_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[3]);
  }
  if (kensakunm1[4] != undefined) {
    <% if (!BizUtil.isBlank(uiBean.getKnskkmkid5())) { %>
        showKoumoku(<%=KNSKKMKID5_KENSAKUJYOUKEN%>);
    <%}%>
    $(<%=KNSKKMKID5_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[4]);
  }
<% }%>

<% if (uiBean.getPageNo() == PAGENO_SEARCHRESULT) { %>
    <% if (uiBean.isPrintOutFlg()) { %>
        <%uiBean.setPrintOutFlg(false);%>
        openReport('print');
    <%}%>
<%}%>

function dispControlGyoumuKey () {
  var  value = $(<%=SRCHSYORUICD_KENSAKUJYOUKEN%>).val();
  var object = '<%= uiBean.getKensakunmMap()%>';
  var codeObject = new Object();
  var syoruicdObject = object.split(",");
  var cnt;
  for (cnt=0;cnt < syoruicdObject.length;cnt++) {
    var keyObject = syoruicdObject[cnt].split("=");
    codeObject[keyObject[0].replace('{',"").trim()] = keyObject[1].replace('}',"");
  }
  var kensakunm1 = codeObject[value.split(".")[1]].split("#");
  if (kensakunm1[0].length != 0) {
    $(<%=KNSKKMKID1_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(true);
    showKoumoku(<%=KNSKKMKID1_KENSAKUJYOUKEN%>);
    $(<%=KNSKKMKID1_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[0]);
  } else {
    $(<%=KNSKKMKID1_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(false);
  }
  if (kensakunm1[1] != undefined) {
    $(<%=KNSKKMKID2_KENSAKUJYOUKEN+ LABEL%>).parent().parent().visible(true);
    $(<%=KNSKKMKID2_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(true);
    showKoumoku(<%=KNSKKMKID2_KENSAKUJYOUKEN%>);
    $(<%=KNSKKMKID2_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[1]);
   } else {
    $(<%=KNSKKMKID2_KENSAKUJYOUKEN+ LABEL%>).parent().parent().visible(false);
  }
  if (kensakunm1[2] != undefined) {
    $(<%=KNSKKMKID3_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(true);
    showKoumoku(<%=KNSKKMKID3_KENSAKUJYOUKEN%>);
    $(<%=KNSKKMKID3_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[2]);
  } else {
    $(<%=KNSKKMKID3_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(false);
  }
  if (kensakunm1[3] != undefined) {
    $(<%=KNSKKMKID4_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(true);
    showKoumoku(<%=KNSKKMKID4_KENSAKUJYOUKEN%>);
    $(<%=KNSKKMKID4_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[3]);
  } else {
    $(<%=KNSKKMKID4_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(false);
  }
  if (kensakunm1[4] != undefined) {
    $(<%=KNSKKMKID5_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(true);
    showKoumoku(<%=KNSKKMKID5_KENSAKUJYOUKEN%>);
    $(<%=KNSKKMKID5_KENSAKUJYOUKEN + LABEL%>).text(kensakunm1[4]);
  } else {
    $(<%=KNSKKMKID5_KENSAKUJYOUKEN + LABEL%>).parent().parent().visible(false);
  }

}

});
</script>
