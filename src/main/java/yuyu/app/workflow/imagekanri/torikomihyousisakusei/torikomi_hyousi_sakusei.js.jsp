<%--
    torikomi_hyousi_sakusei.js.jsp - 取込用表紙作成 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.imagekanri.torikomihyousisakusei.TorikomiHyousiSakuseiConstants.*" %>
<%@page import="static yuyu.app.workflow.imagekanri.torikomihyousisakusei.TorikomiHyousiSakuseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.imagekanri.torikomihyousisakusei.TorikomiHyousiSakuseiUiBean" %>
<% TorikomiHyousiSakuseiUiBean uiBean = SWAKInjector.getInstance(TorikomiHyousiSakuseiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
var subSystemId  = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();
var length = 10;
var allJimuTetuzuki = [];

$(<%= SAKUSEILINK + LABEL  %>).text("<%= BLANK %>");

<% if (uiBean.getPageNo() == PAGENO_SELECTDATA) { %>

if ($(<%= ANKENLIST %>)[0].rows.length <= 1) {
  $(<%= ANKENLIST + DIV %>).visible(false);
}

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
    var mosno = $(<%= MOSNO_SEARCHINFO %>).val();
    var jimuTetuzukiCd  = $(<%= JIMUTETUZUKICD_SEARCHINFO %>).val();

    if (svSubSystemId != subSystemId) {
      $(<%= SYONO_SEARCHINFO %>).val('<%= BLANK %>');
      $(<%= NKSYSYNO_SEARCHINFO %>).val('<%= BLANK %>');
      $(<%= MOSNO_SEARCHINFO %>).val('<%= BLANK %>');
    }
    if (subSystemId == "") {
        setJimuTetuzukiSelectBlank();
        dispGyoumuKey(false,subSystemId);
    } else {
        createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd);
        lblGyoumuKey(subSystemId);
        dispGyoumuKey(true,subSystemId);
    }

  }
).change();

<% } %>


<% if (uiBean.getPageNo() == PAGENO_INPUTCONDITION) { %>
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
    openReport("print", "_blank");
    var subSystemId = '<%= uiBean.getSubSystemId() %>';
    dispGyoumuKey(true,subSystemId);
    lblGyoumuKey(subSystemId);
<% } %>


});


function createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd){
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
        } else {
          $(<%= MOSNO_SEARCHINFO + LABEL %>).text('<%= GYOUMU_KEY_SINKEIYAKU %>');
    }
}

function dispGyoumuKey(p_visible,subSystemId){
  $("<%= SYONO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= NKSYSYNO_LABEL %>").each(function(){
      $(this).visible(false);
  });
  $("<%= MOSNO_LABEL %>").each(function(){
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
