<%--
    koutei_jyoukyou_syoukai.js.jsp - 工程状況照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.kouteijyoukyousyoukai.KouteiJyoukyouSyoukaiConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.kouteijyoukyousyoukai.KouteiJyoukyouSyoukaiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.processkanri.kouteijyoukyousyoukai.KouteiJyoukyouSyoukaiUiBean" %>
<% KouteiJyoukyouSyoukaiUiBean uiBean = SWAKInjector.getInstance(KouteiJyoukyouSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

var allJimuTetuzuki = [];
var allWorkFlowTsk = [];
var subSystemId  = $(<%= SUBSYSTEMID_SEARCHKEYINPUT %>).val();

<% if (uiBean.getPageNo()== PAGENO_INPUTKEY){ %>


$(function(){
    dspGyoumuKey(subSystemId);
});


$(<%= JIMUTETUZUKICD_SEARCHKEYINPUT %> + " option").each(
  function() {
    allJimuTetuzuki.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);


$(<%= TSKID_SEARCHKEYINPUT  %> + " option").each(
  function() {
    allWorkFlowTsk.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);


if ($(<%= TASKUSERINFO %>)[0].rows.length <= 1) {
  $(<%= TASKUSERINFO + DIV %>).visible(false);
}



$(<%= DISPGYOUMUKEY + LABEL %>).text('<%= uiBean.getGyoumukeylbl() %>');

$("#syousaiLink_label").text("<%= BLANK %>");


$(<%= SUBSYSTEMID_SEARCHKEYINPUT  %>).change(
  function() {
    subSystemId = $(this).val();
    var jimuTetuzukiCd  = $(<%= JIMUTETUZUKICD_SEARCHKEYINPUT %>).val();

    if(subSystemId == ""){
        jimuTetuzukiBlankOnly();
        workFlowTskBlankOnly();
        $(<%= JIMUTETUZUKICD_SEARCHKEYINPUT%>).val("");
        $(<%= TSKID_SEARCHKEYINPUT%>).val("");

    } else{
        jimuTetuzukiMake(allJimuTetuzuki,subSystemId,jimuTetuzukiCd);
    }
    dspGyoumuKey(subSystemId);
    if(subSystemId != "<%= uiBean.getSubSystemId() %>"){
        $(<%= MOSNO_SEARCHKEYINPUT %>).val("<%= BLANK %>");
        $(<%= SYONO_SEARCHKEYINPUT %>).val("<%= BLANK %>");
        $(<%= NKSYSYNO_SEARCHKEYINPUT %>).val("<%= BLANK %>");
    }
  }
).change();


$(<%= JIMUTETUZUKICD_SEARCHKEYINPUT %>).change(
  function() {
    var jimuTetuzukiCd = $(this).val();
    var workFlowTskNm  = $(<%= TSKID_SEARCHKEYINPUT %>).val();
    if(jimuTetuzukiCd == ""){
        workFlowTskBlankOnly();
        $(<%= TSKID_SEARCHKEYINPUT%>).val("");
    } else{

        workFlowTskMake(allWorkFlowTsk,jimuTetuzukiCd,workFlowTskNm);
   }
  }
).change();

var animateSpeed = 200;

<% } %>



<% if (uiBean.getPageNo()== PAGENO_RESULT) { %>

if ($(<%= RESULTINFO %>)[0].rows.length <= 1) {
  $(<%= RESULTINFO + DIV %>).visible(false);
}


$(function(){
    if( "<%= uiBean.getSubSystemId() %>" == '<%= NENKIN %>'){
        $(<%= DISPGYOUMUKEY_KEYINFOINPUT + LABEL %>).text('<%= GYOUMU_KEY_NENKIN %>');
    } else if ("<%= uiBean.getSubSystemId() %>" == '<%= SINKEIYAKU %>') {
        $(<%= DISPGYOUMUKEY_KEYINFOINPUT + LABEL %>).text('<%= GYOUMU_KEY_SINKEIYAKU %>');
    } else{
        $(<%= DISPGYOUMUKEY_KEYINFOINPUT + LABEL %>).text('<%= GYOUMU_KEY_HOZEN_SIHARAI %>');
    }
});


var animateSpeed = 200;

<% } %>

});



function jimuTetuzukiMake(allJimuTetuzuki,subSystemId,jimuTetuzukiCd){
    jimuTetuzukiBlank();
    var exists = false;
    for (var i in allJimuTetuzuki) {
        with (allJimuTetuzuki[i]) {
            if ((id.length == 0) || (subSystemId.length == 0) || id.startsWith(subSystemId + ".")) {
            $(<%= JIMUTETUZUKICD_SEARCHKEYINPUT %>).append($("<option />").val(id).text(name));
                if (id == jimuTetuzukiCd) {
                    exists = true;
                }
            }
        }
    }
    with ($(<%= JIMUTETUZUKICD_SEARCHKEYINPUT %>)) {
        if (exists) {
            val(jimuTetuzukiCd);
        }
        change();
    }
}




function workFlowTskMake(allWorkFlowTsk,jimuTetuzukiCd,workFlowTskNm){
    workFlowTskBlank();
    var exists = false;
    for (var i in allWorkFlowTsk) {
      with (allWorkFlowTsk[i]) {
        if (jimuTetuzukiCd != null) {
            if ((id.length == 0) || (jimuTetuzukiCd.length == 0) || id.startsWith(jimuTetuzukiCd + ".")) {
                $(<%= TSKID_SEARCHKEYINPUT %>).append($("<option />").val(id).text(name));
                if (id == workFlowTskNm) {
                    exists = true;
                }
            }
        }
      }
    }
    with ($(<%= TSKID_SEARCHKEYINPUT %>)) {
      if (exists) {
        val(workFlowTskNm);
      }
      change();
    }
}


function jimuTetuzukiBlank(){
  $(<%= JIMUTETUZUKICD_SEARCHKEYINPUT %> + " option").remove();
}

function jimuTetuzukiBlankOnly(){
  jimuTetuzukiBlank();
  $(<%= TSKID_SEARCHKEYINPUT %>).append($("<option />").val("<%= BLANK %>").text("<%= BLANK %>"));
}



function workFlowTskBlank(){
  $(<%= TSKID_SEARCHKEYINPUT %> + " option").remove();
}

function workFlowTskBlankOnly(){
  workFlowTskBlank();
  $(<%= TSKID_SEARCHKEYINPUT %>).append($("<option />").val("<%= BLANK %>").text("<%= BLANK %>"));
}


function dspGyoumuKey(subSystemId){
    if( subSystemId == "" || subSystemId == null ){
        $(<%= MOSNO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
        $(<%= SYONO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
        $(<%= NKSYSYNO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
    }else if(subSystemId == '<%= NENKIN %>'){
        $(<%= MOSNO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
        $(<%= SYONO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
        $(<%= NKSYSYNO_SEARCHKEYINPUT %>).parent().parent().parent().show();
    }else if(subSystemId == '<%= SINKEIYAKU %>'){
        $(<%= MOSNO_SEARCHKEYINPUT %>).parent().parent().parent().show();
        $(<%= SYONO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
        $(<%= NKSYSYNO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
    }else {
        $(<%= MOSNO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
        $(<%= SYONO_SEARCHKEYINPUT %>).parent().parent().parent().show();
        $(<%= NKSYSYNO_SEARCHKEYINPUT %>).parent().parent().parent().css('display', 'none');
    }
}


//-->
</script>