<%--
    jimuyou_code_nyuuryoku.js.jsp - 事務用コード入力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku.JimuyouCodeNyuuryokuConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku.JimuyouCodeNyuuryokuSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku.JimuyouCodeNyuuryokuUiBean" %>
<% JimuyouCodeNyuuryokuUiBean uiBean = SWAKInjector.getInstance(JimuyouCodeNyuuryokuUiBean.class); %>
<script type="text/javascript"><!--

var gamenFlg = "false";

$(function(){
var subSystemId  = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();
var allJimuTetuzuki = [];

<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

var allJimutetuzuki = [];
$(<%= JIMUTETUZUKICD_SEARCHINFO %> + " option").each(
  function() {
    allJimuTetuzuki.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);


$(document).ready(
  function() {

    var rsltSubSystemId = '<%= uiBean.getResultSubSystemId() %>';
    dispGyoumuKey(true,rsltSubSystemId);
    subSystemSelect(allJimuTetuzuki);

  <%
  if(!"kakuninBtnOnClick".equals(request.getParameter("_eventHandler"))){
  %>
      $(".errorItem").each(
        function() {
        jimuyouCodeListNonDisp();
          });
  <%    }
  %>
  gamenFlg = "false";
});

addRequiredMark("<%= SUBSYSTEMID_LABEL %>");
addRequiredMark("<%= JIMUTETUZUKI_LABEL %>");

if ($(<%= JIMUYOUCODELIST %>)[0].rows.length <= 1) {
  $(<%= JIMUYOUCODELIST + DIV %>).visible(false);
  $(<%= KAKUNINBTN_BUTTONINPUTCONTENTS %>).visible(false);
}

var svSubSystemId = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();
$(<%= SUBSYSTEMID_SEARCHINFO %>).change(
  function() {

    subSystemSelect(allJimuTetuzuki);
    jimuyouCodeListNonDisp();

  }
);

$(<%= JIMUTETUZUKICD_SEARCHINFO %>).change(
  function() {
if(gamenFlg=="false"){
    jimuyouCodeListNonDisp();
}
  }
);


<% } %>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
    var subSystemId = '<%= uiBean.getSubSystemId() %>';
    lblGyoumuKey(subSystemId);
<% } %>

<% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    var subSystemId = '<%= uiBean.getSubSystemId() %>';
    lblGyoumuKey(subSystemId);
<% } %>

});



var REQUIRED_MARK = "※";

function addRequiredMark(labelNm) {
    $(labelNm + "<%= REQUIRED_LABEL%>").each(
      function() {
        $(this).append(
          "<span class='requiredMark'>" + REQUIRED_MARK
          + "</span>");
      });
}


function createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd){
    setJimuTetuzukiSelectBlank();
    var exists = false;
    for (var i in allJimuTetuzuki) {
        with (allJimuTetuzuki[i]) {
            if ((id.length == 0) || (subSystemId.length == 0) || id.startsWith(subSystemId + ".")) {
                $(<%= JIMUTETUZUKICD_SEARCHINFO %>).append($("<option />").val(id).text(name));
                if (id == jimuTetuzukiCd) {
                    exists = true;
                }
            }
        }
    }
    with ($(<%= JIMUTETUZUKICD_SEARCHINFO %>)) {
        if (exists) {
            val(jimuTetuzukiCd);
        }
        gamenFlg="true";
        change();
    }
}

function lblGyoumuKey(subSystemId) {
  if (subSystemId == '<%= E_SubSystem.NENKINSIHARAI.getName() %>') {
            $(<%= DiSPGYOUMUKEY + LABEL %>).text('<%= GYOUMU_KEY_NENKIN %>');
          } else if(subSystemId == '<%= E_SubSystem.KEIYAKUHOZEN.getName() %>') {
            $(<%= DiSPGYOUMUKEY + LABEL %>).text('<%= GYOUMU_KEY_HOZEN %>');
          } else if(subSystemId == '<%= E_SubSystem.SINKEIYAKU.getName() %>') {
            $(<%= DiSPGYOUMUKEY + LABEL %>).text('<%= GYOUMU_KEY_SINKEIYAKU %>');
          } else if (subSystemId == '<%= E_SubSystem.HOKENKYUHUSIHARAI.getName() %>') {
            $(<%= DiSPGYOUMUKEY + LABEL %>).text('<%= GYOUMU_KEY_SIHARAI %>');
  };
}

function setJimuTetuzukiSelectBlank(){
  $(<%= JIMUTETUZUKICD_SEARCHINFO %> + " option").remove();
}

function dispGyoumuKey(p_visible,subSystemId){
  $("<%= MOSNO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= SYONO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= NKSYSYNO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= MOSNO_DATA %>").each(function(){
      $(this).visible(false);
  });
  $("<%= SYONO_DATA %>").each(function(){
      $(this).visible(false);
  });
  $("<%= NKSYSYNO_DATA %>").each(function(){
      $(this).visible(false);
  });
  if (p_visible == true) {
    if (subSystemId == '<%= E_SubSystem.SINKEIYAKU.getName() %>') {
      $("<%= MOSNO_LABEL %>").each(
        function(){
          $(this).visible(p_visible);
          $(this).css("width", "50%");
        }
      );
      $("<%= MOSNO_DATA %>").each(
        function(){
          $(this).visible(p_visible);
        }
      );
    } else if ((subSystemId == '<%= E_SubSystem.KEIYAKUHOZEN.getName() %>') ||
        (subSystemId == '<%= E_SubSystem.HOKENKYUHUSIHARAI.getName() %>')) {
      $("<%= SYONO_LABEL %>").each(
        function(){
          $(this).visible(p_visible);
          $(this).css("width", "50%");
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
          $(this).css("width", "50%");
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

function jimuyouCodeListNonDisp(){
  $(<%= JIMUYOUCODELIST + DIV %>).visible(false);
  $(<%= KAKUNINBTN_BUTTONINPUTCONTENTS %>).visible(false);

  $(".text").each(
    function() {
      $(this).val("");
    });
}

function subSystemSelect(allJimuTetuzuki){

    var subSystemId = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();
    var jimuTetuzukiCd = $(<%= JIMUTETUZUKICD_SEARCHINFO %>).val();

    if (subSystemId == "") {
        setJimuTetuzukiSelectBlank();

    } else {
        createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd);
        $(<%= SUBSYSTEMID_SEARCHINFO %>).val(subSystemId);
    }

}

//-->
</script>
