<%--
    wariate_kaijyo.js.jsp - 担当者割当解除 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.wariatekaijyo.WariateKaijyoConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.wariatekaijyo.WariateKaijyoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.processkanri.wariatekaijyo.WariateKaijyoUiBean" %>
<% WariateKaijyoUiBean uiBean = SWAKInjector.getInstance(WariateKaijyoUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

var tantoFlg = "<%= uiBean.isTantoFlg()  %>"
var tantId = "<%= uiBean.getTantid()  %>"

var allJimuTetuzuki = [];
var allWorkFlowTsk = [];
var subSystemId  = $(<%= SUBSYSTEMID_SEARCHINFO %>).val();

<% if (uiBean.getPageNo() == PAGENO_SELECTDATA) { %>

if ($(<%= TASKSERINFO %>)[0].rows.length <= 1) {
  $(<%= TASKSERINFO + DIV %>).visible(false);
}

$(<%= WARIATEKAIJYOLINK + LABEL  %>).text("<%= BLANK %>");


$(<%= DISPGYOUMUKEY + LABEL %>).text('<%= uiBean.getGyoumukeylbl() %>');


$(<%= JIMUTETUZUKICD_SEARCHINFO %> + " option").each(
  function() {
    allJimuTetuzuki.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);

$(<%= WORKFLOWTSKNM_SEARCHINFO %> + " option").each(
  function() {
    allWorkFlowTsk.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);

$(<%= SUBSYSTEMID_SEARCHINFO %>).change(
  function() {
    var subSystemId = $(this).val();
    var jimuTetuzukiCd  = $(<%= JIMUTETUZUKICD_SEARCHINFO %>).val();

    if(subSystemId == "" || subSystemId == null){
        setJimuTetuzukiSelectBlank();
        setWorkFlowTskSelectBlank();
        setTantSelectBlank();
        setTantSelectDisable(true);
        tantoFlg = "true";
        tantId = "";
    } else{
        createJimuTetuzukiSelect(allJimuTetuzuki,subSystemId,jimuTetuzukiCd);
    }
  }
).change();

  jimutetuzukiHenkou(allWorkFlowTsk, tantId);

  var jimutetuzukicdZen;

  $(<%= JIMUTETUZUKICD_SEARCHINFO %>).focus(function() {
    jimutetuzukicdZen = $(<%= JIMUTETUZUKICD_SEARCHINFO %>).val();
  });

  $(<%= JIMUTETUZUKICD_SEARCHINFO %>).blur(function () {
    var jimutetuzukicdGo = $(<%= JIMUTETUZUKICD_SEARCHINFO %>).val();

    if (jimutetuzukicdZen != jimutetuzukicdGo || jimutetuzukicdGo == "" || jimutetuzukicdGo == null) {
      jimutetuzukiHenkou(allWorkFlowTsk, tantId);
    }
  });

  var animateSpeed = 200;

<% } %>

});



function jimutetuzukiHenkou(allWorkFlowTsk, tantId) {
    var jimuTetuzukiCd = $(<%= JIMUTETUZUKICD_SEARCHINFO %>).val();
    var workFlowTskNm  = $(<%= WORKFLOWTSKNM_SEARCHINFO %>).val();
    tantoFlg = "<%= uiBean.isTantoFlg()  %>"
    if(jimuTetuzukiCd == "" || jimuTetuzukiCd == null){
      setWorkFlowTskSelectBlank();
      setTantSelectBlank();
      setTantSelectDisable(true);
      tantoFlg = "true";
      tantId = "";
    } else if(jimuTetuzukiCd != "<%= uiBean.getJimutetuzukicd()  %>"){
      createWorkFlowTskSelect(allWorkFlowTsk,jimuTetuzukiCd,workFlowTskNm);
      setTantSelectBlank();
      setTantSelectDisable(false);
      tantId = "";
      if(tantoFlg){
      callAjaxCreateTantSelect(jimuTetuzukiCd,tantId);
      }
    } else{
      createWorkFlowTskSelect(allWorkFlowTsk,jimuTetuzukiCd,workFlowTskNm);
      setTantSelectBlank();
      setTantSelectDisable(false);
      if(tantoFlg){
      callAjaxCreateTantSelect(jimuTetuzukiCd,tantId);
      }
    }
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
        change();
    }
    $(<%= JIMUTETUZUKICD_SEARCHINFO %>).blur();
}


function createWorkFlowTskSelect(allWorkFlowTsk,jimuTetuzukiCd,workFlowTskNm){
    setWorkFlowTskSelectBlank();
    var exists = false;
    for (var i in allWorkFlowTsk) {
      with (allWorkFlowTsk[i]) {
        if ((id.length == 0) || (jimuTetuzukiCd.length == 0) || id.startsWith(jimuTetuzukiCd + ".")) {
          $(<%= WORKFLOWTSKNM_SEARCHINFO %>).append($("<option />").val(id).text(name));
          if (id == workFlowTskNm) {
            exists = true;
          }
        }
      }
    }
    with ($(<%= WORKFLOWTSKNM_SEARCHINFO %>)) {
      if (exists) {
        val(workFlowTskNm);
      }
      change();
    }
}

function createTantoSelect(obj,jimuTetuzukiCd,tantId){

    setTantSelectBlank();
    var exists = false;
    for (var i in obj) {
      with (obj[i]) {
          $(<%= TANTID_SEARCHINFO %>).append($("<option />").val(value).text(label));
          if (value == tantId) {
            exists = true;
          }
      }
    }
    with ($(<%= TANTID_SEARCHINFO %>)) {
      if (exists) {
        val(tantId);
      }
      change();
    }
}

function setJimuTetuzukiSelectBlank(){
  $(<%= JIMUTETUZUKICD_SEARCHINFO %> + " option").remove();
}

function setWorkFlowTskSelectBlank(){
  $(<%= WORKFLOWTSKNM_SEARCHINFO %> + " option").remove();
}

function setTantSelectBlank(){
  $(<%= TANTID_SEARCHINFO %> + " option").remove();

}

function setTantSelectDisable(disableFlg){
  $(<%= TANTID_SEARCHINFO %>).disable(disableFlg);
}

function callAjaxCreateTantSelect(jimuTetuzukiCd,tantId){

    var form = $('form').attr('action');
    form = form + "?<%= AJAX_POST_EVENTHANDLER %>";

    $.ajax({
        type: "POST",
        url: form,
        data: {
            jimutetuzukicd: jimuTetuzukiCd
        },
        dataType: "json"
    }).done(function(data){
        createTantoSelect(data,jimuTetuzukiCd,tantId);
    });
}

//-->
</script>
