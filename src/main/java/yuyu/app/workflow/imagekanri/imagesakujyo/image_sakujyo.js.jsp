<%--
    image_sakujyo.js.jsp - イメージ削除 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.imagekanri.imagesakujyo.ImageSakujyoConstants.*" %>
<%@page import="static yuyu.app.workflow.imagekanri.imagesakujyo.ImageSakujyoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.imagekanri.imagesakujyo.ImageSakujyoUiBean" %>
<% ImageSakujyoUiBean uiBean = SWAKInjector.getInstance(ImageSakujyoUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
var subSystemId  = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();
var allJimuTetuzuki = [];


<% if (uiBean.getPageNo() == PAGENO_SELECTDATA) { %>

if ($(<%= ANKENLIST %>)[0].rows.length <= 1) {
  $(<%= ANKENLIST + DIV %>).visible(false);
}

$(<%= HYOUJILINK + LABEL  %>).text("<%= BLANK %>");

$(<%= SAKUJYOLINK + LABEL  %>).text("<%= BLANK %>");

$(<%= DISPGYOUMUKEY + LABEL %>).text('<%= uiBean.getGyoumukeylbl() %>');

var allJimutetuzuki = [];
$(<%= JIMUTETUZUKICD_SEARCHINFO %> + " option").each(
  function() {
    allJimuTetuzuki.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);

var allSyoruinm = [];
$(<%= TORIKOMISYORUICD_SEARCHINFO %> + " option").each(
  function() {
    allSyoruinm.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);

var svSubSystemId = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();
$(<%= SUBSYSTEMID_SEARCHINFO %>).change(
  function() {
    var subSystemId = $(this).val();
    var jimuTetuzukiCd  = $(<%= JIMUTETUZUKICD_SEARCHINFO %>).val();
    var syoruinm  = $(<%= TORIKOMISYORUICD_SEARCHINFO %>).val();
    var mosNo = $(<%= MOSNO_SEARCHINFO %>).val();
    var syoNo = $(<%= SYONO_SEARCHINFO %>).val();
    var nkSysyNo = $(<%= NKSYSYNO_SEARCHINFO %>).val();

    if (svSubSystemId != subSystemId) {
        $(<%= SYONO_SEARCHINFO %>).val('<%= BLANK %>');
        $(<%= NKSYSYNO_SEARCHINFO %>).val('<%= BLANK %>');
        $(<%= MOSNO_SEARCHINFO %>).val('<%= BLANK %>');
        $(<%= TORIKOMISYORUICD_SEARCHINFO %>).val("0");
    }

    if (subSystemId == "") {
        setJimuTetuzukiSelectBlank();
        setSyoruinmSelectBlank();
        dispGyoumuKey(false,subSystemId);
    } else {
        createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd,syoNo,nkSysyNo);
        createSyoruinmSelect(allSyoruinm,syoruinm,svSubSystemId,subSystemId);
        lblGyoumuKey(subSystemId);
        dispGyoumuKey(true,subSystemId);
    }
  }
).change();



$("#ankenList .link").mousedown(
function(){

var pageno = $(".noLinkPagerItem").text();
var pageno = pageno.replace(/</g,"").replace(/>/g,"");
var yousono = ((pageno - 1) * 10) + $("#ankenList .link").index(this);

$("#selectindex").val(yousono);
$(".popupLink").click();

});


<% } %>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
    var subSystemId = '<%= uiBean.getSubSystemId() %>';
    lblGyoumuKey(subSystemId);

if(subSystemId == "nenkin") {
    $(<%= DISPGYOUMUKEY + LABEL  %>).text("<%= LBL_GYOUMUKEY_NENKINSIHARAI %>");
} else if(subSystemId == "sinkeiyaku"){
    $(<%= DISPGYOUMUKEY + LABEL  %>).text("<%= LBL_GYOUMUKEY_SINKEIYAKU %>");
} else if(subSystemId == "hozen"){
    $(<%= DISPGYOUMUKEY + LABEL  %>).text("<%= LBL_GYOUMUKEY_KEIYAKUHOZEN %>");
} else{
    $(<%= DISPGYOUMUKEY + LABEL  %>).text("<%= LBL_GYOUMUKEY_HOKENKYUHUSIHARAI %>");
}

$(<%= HYOUJILINK + LABEL  %>).text("<%= BLANK %>");

$(<%= SAKUJYOLINK + LABEL  %>).text("<%= BLANK %>");


$("#ankenList2 .link").mousedown(
function(){

$(".popupLink").click();

});

<% } %>


<% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    var subSystemId = '<%= uiBean.getSubSystemId() %>';
    lblGyoumuKey(subSystemId);

if(subSystemId == "nenkin") {
    $(<%= DISPGYOUMUKEY + LABEL  %>).text("<%= LBL_GYOUMUKEY_NENKINSIHARAI %>");
} else if(subSystemId == "sinkeiyaku"){
    $(<%= DISPGYOUMUKEY + LABEL  %>).text("<%= LBL_GYOUMUKEY_SINKEIYAKU %>");
} else if(subSystemId == "hozen"){
    $(<%= DISPGYOUMUKEY + LABEL  %>).text("<%= LBL_GYOUMUKEY_KEIYAKUHOZEN %>");
} else{
    $(<%= DISPGYOUMUKEY + LABEL  %>).text("<%= LBL_GYOUMUKEY_HOKENKYUHUSIHARAI %>");
}

$(<%= HYOUJILINK + LABEL  %>).text("<%= BLANK %>");

$(<%= SAKUJYOLINK + LABEL  %>).text("<%= BLANK %>");

<% } %>

});



function createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd,syoNo,nkSysyNo){
    setJimuTetuzukiSelectBlank();
    var exists = false;
    for (var i in allJimuTetuzuki) {
        with (allJimuTetuzuki[i]) {
            if ((id.length == 0) || (subSystemId.length == 0) || id.startsWith(subSystemId + ".")) {
                $(<%= JIMUTETUZUKICD_SEARCHINFO %>).append($("<option />").val(id).text(name));
                if ((id == jimuTetuzukiCd)  && (id.length != 0)) {
                    exists = true;
                }
            }
        }
    }
    with ($(<%= JIMUTETUZUKICD_SEARCHINFO %>)) {
        if (exists) {
            val(jimuTetuzukiCd);
            $(<%= SYONO_SEARCHINFO %>).val(syoNo);
            $(<%= NKSYSYNO_SEARCHINFO %>).val(nkSysyNo);
        }
        change();
    }
}

function createSyoruinmSelect(allSyoruinm,syoruinm,svSubSystemId,subSystemId){
    setSyoruinmSelectBlank();
    var exists = false;
    for (var j in allSyoruinm) {
        with (allSyoruinm[j]) {
            if ((id.length == 0) || (subSystemId.length == 0) || id.startsWith(subSystemId + ".")) {
                $(<%= TORIKOMISYORUICD_SEARCHINFO %>).append($("<option />").val(id).text(name));
                if (id == syoruinm && (id.length != 0)) {
                    exists = true;
                }
            }
        }
    }
    with ($(<%= TORIKOMISYORUICD_SEARCHINFO %>)) {
        if (exists && svSubSystemId == subSystemId) {
            val(syoruinm);
        }
        change();
    }
}

function setJimuTetuzukiSelectBlank(){
  $(<%= JIMUTETUZUKICD_SEARCHINFO %> + " option").remove();
}

function setSyoruinmSelectBlank(){
  $(<%= TORIKOMISYORUICD_SEARCHINFO %> + " option").remove();
}

function lblGyoumuKey(subSystemId) {
    if (subSystemId == '<%= E_SubSystem.NENKINSIHARAI.getName() %>') {
          $(<%= NKSYSYNO_SEARCHINFO + LABEL %>).text('<%= LBL_GYOUMUKEY_NENKINSIHARAI %>');
        } else if(subSystemId == '<%= E_SubSystem.SINKEIYAKU.getName() %>') {
          $(<%= MOSNO_SEARCHINFO + LABEL %>).text('<%= LBL_GYOUMUKEY_SINKEIYAKU %>');
          $(<%= SYONO_SEARCHINFO + LABEL %>).text('<%= LBL_GYOUMUKEY_KEIYAKUHOZEN %>');
        } else if(subSystemId == '<%= E_SubSystem.KEIYAKUHOZEN.getName() %>') {
          $(<%= SYONO_SEARCHINFO + LABEL %>).text('<%= LBL_GYOUMUKEY_KEIYAKUHOZEN %>');
        } else if(subSystemId == '<%= E_SubSystem.HOKENKYUHUSIHARAI.getName() %>') {
          $(<%= SYONO_SEARCHINFO + LABEL %>).text('<%= LBL_GYOUMUKEY_HOKENKYUHUSIHARAI %>');
    }
}

function dispGyoumuKey(p_visible,subSystemId){

  $("<%= MOSNO_LABEL%>").each(function(){
    $(this).visible(false);
  });
  $("<%= SYONO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= NKSYSYNO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= MOSNO_DATA%>").each(function(){
      $(this).visible(false);
  });
  $("<%= SYONO_DATA %>").each(function(){
      $(this).visible(false);
  });
  $("<%= NKSYSYNO_DATA %>").each(function(){
      $(this).visible(false);
  });
  if (p_visible == true) {
    if ((subSystemId == '<%= E_SubSystem.SINKEIYAKU.getName() %>')) {
      $("<%= MOSNO_LABEL %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
      $("<%= MOSNO_DATA %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
      $("<%= SYONO_LABEL %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
      $("<%= SYONO_DATA %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
    } else if ((subSystemId == '<%= E_SubSystem.KEIYAKUHOZEN.getName() %>') ||
        (subSystemId == '<%= E_SubSystem.HOKENKYUHUSIHARAI.getName() %>')) {
      $("<%= SYONO_LABEL %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
      $("<%= SYONO_DATA %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
    }
    else {
      $("<%= NKSYSYNO_LABEL %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
      $("<%= NKSYSYNO_DATA %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
    }
  }
}
//-->
</script>
