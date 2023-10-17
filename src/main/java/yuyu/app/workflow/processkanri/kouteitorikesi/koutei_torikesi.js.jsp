<%--
    koutei_torikesi.js.jsp - 工程取消 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.kouteitorikesi.KouteiTorikesiConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.kouteitorikesi.KouteiTorikesiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.processkanri.kouteitorikesi.KouteiTorikesiUiBean" %>
<% KouteiTorikesiUiBean uiBean = SWAKInjector.getInstance(KouteiTorikesiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
var subSystemId  = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();
var length = 10;
var allJimuTetuzuki = [];

<% if (uiBean.getPageNo() == PAGENO_SELECTDATA) { %>

if ($(<%= KOUTEILIST %>)[0].rows.length <= 1) {
  $(<%= KOUTEILIST + DIV %>).visible(false);
}

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

var svSubSystemId = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();
$(<%= SUBSYSTEMID_SEARCHINFO %>).change(
  function() {
    var subSystemId = $(this).val();
    var syoNo = $(<%= SYONO_SEARCHINFO %>).val();
    var nkSysyNo = $(<%= NKSYSYNO_SEARCHINFO %>).val();
    var jimuTetuzukiCd  = $(<%= JIMUTETUZUKICD_SEARCHINFO %>).val();

    if (svSubSystemId != subSystemId) {
      $(<%= SYONO_SEARCHINFO %>).val('<%= BLANK %>');
      $(<%= NKSYSYNO_SEARCHINFO %>).val('<%= BLANK %>');
    }
    if (subSystemId == "") {
        setJimuTetuzukiSelectBlank();
        dispGyoumuKey(false,subSystemId);
    } else {
        createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd,syoNo,nkSysyNo);
        lblGyoumuKey(subSystemId);
        dispGyoumuKey(true, subSystemId);
    }
  }
).change();


<% } %>


<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
$(<%= WORKFLOWTORIKESICOMMENT_TORIKESICOMMENT %>).keypress(
  function() {
    var text = $(this).val().split("\n");
    if(text.length >= length) {
      window.keyCode = 0;
      return false;
    }
    switch (window.keyCode) {
      case 13:
      window.keyCode = 0;
      return false;
      break;
    }
    return true;
  }
).change();
    var subSystemId = '<%= uiBean.getSubSystemId() %>';
    dispGyoumuKey(true,subSystemId);
    lblGyoumuKey(subSystemId);
<% } %>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
    var subSystemId = '<%= uiBean.getSubSystemId() %>';
    dispGyoumuKey(true,subSystemId);
    lblGyoumuKey(subSystemId);
<% } %>

<% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    var subSystemId = '<%= uiBean.getSubSystemId() %>';
    dispGyoumuKey(true,subSystemId);
    lblGyoumuKey(subSystemId);
<% } %>


});


function createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd,syoNo,nkSysyNo){
    setJimuTetuzukiSelectBlank();
    var exists = false;
    for (var i in allJimuTetuzuki) {
        with (allJimuTetuzuki[i]) {
            if ((id.length == 0) || (subSystemId.length == 0) || id.startsWith(subSystemId + ".")) {
                $(<%= JIMUTETUZUKICD_SEARCHINFO %>).append($("<option />").val(id).text(name));
                if ((id == jimuTetuzukiCd) && (id.length != 0)) {
                    exists = true;
                }
            }
        }
    }
    with ($(<%= JIMUTETUZUKICD_SEARCHINFO %>)) {
        if (exists) {
            val(jimuTetuzukiCd);
        }
        change();
    }
}

function setJimuTetuzukiSelectBlank(){
  $(<%= JIMUTETUZUKICD_SEARCHINFO %> + " option").remove();
}

function lblGyoumuKey(subSystemId) {
    if (subSystemId == '<%= E_SubSystem.NENKINSIHARAI.getName() %>') {
          $(<%= NKSYSYNO_SEARCHINFO + LABEL %>).text('<%= GYOUMU_KEY_NENKIN %>');
        } else if(subSystemId == '<%= E_SubSystem.KEIYAKUHOZEN.getName() %>') {
          $(<%= SYONO_SEARCHINFO + LABEL %>).text('<%= GYOUMU_KEY_HOZEN %>');
        } else if(subSystemId == '<%= E_SubSystem.HOKENKYUHUSIHARAI.getName() %>') {
          $(<%= SYONO_SEARCHINFO + LABEL %>).text('<%= GYOUMU_KEY_SIHARAI %>');
    }
}

function dispGyoumuKey(p_visible,subSystemId){
  $("<%= SYONO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= NKSYSYNO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= SYONO_DATA %>").each(function(){
      $(this).visible(false);
  });
  $("<%= NKSYSYNO_DATA %>").each(function(){
      $(this).visible(false);
  });
  if (p_visible == true) {
    if ((subSystemId == '<%= E_SubSystem.KEIYAKUHOZEN.getName() %>') ||
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
    } else {
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
