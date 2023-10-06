<%--
    lock_kyousei_kaijyo.js.jsp - 工程ロック強制解除 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.lockkyouseikaijyo.LockKyouseiKaijyoConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.lockkyouseikaijyo.LockKyouseiKaijyoSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.processkanri.lockkyouseikaijyo.LockKyouseiKaijyoUiBean" %>
<% LockKyouseiKaijyoUiBean uiBean = SWAKInjector.getInstance(LockKyouseiKaijyoUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

<% if (uiBean.getPageNo() == PAGENO_SELECTDATA) { %>

$(<%= LOCKKAIJYOLINK + LABEL %>).text('<%= BLANK %>');

var allJimutetuzuki = [];
$(<%= JIMUTETUZUKICD_SEARCHCONDITIONS %> + " option").each(
  function() {
    allJimutetuzuki.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);

var svSubSystemId = $(<%= SUBSYSTEMID_SEARCHCONDITIONS %>).val();
$(<%= SUBSYSTEMID_SEARCHCONDITIONS %>).change(
  function() {
    var subSystemId = $(this).val();
    var jimutetuzukiCd  = $(<%= JIMUTETUZUKICD_SEARCHCONDITIONS %>).val();
    $(<%= JIMUTETUZUKICD_SEARCHCONDITIONS %> + " option").remove();

    if (svSubSystemId != subSystemId) {
      $(<%= MOSNO_SEARCHCONDITIONS %>).val('<%= BLANK %>');
      $(<%= SYONO_SEARCHCONDITIONS %>).val('<%= BLANK %>');
      $(<%= NKSYSYNO_SEARCHCONDITIONS %>).val('<%= BLANK %>');
    }

    if (subSystemId.length != 0) {
        var exists = false;
        for (var i in allJimutetuzuki) {
          with (allJimutetuzuki[i]) {
            if ((id.length == 0) || (subSystemId.length == 0) || id.startsWith(subSystemId + '<%= SPLITTER %>')) {
              $(<%= JIMUTETUZUKICD_SEARCHCONDITIONS %>).append($("<option />").val(id).text(name));
              if ((id == jimutetuzukiCd) && (id.length != 0)) {
                exists = true;
              }
            }
          }
        }
        with ($(<%= JIMUTETUZUKICD_SEARCHCONDITIONS %>)) {
          if (exists) {
            val(jimutetuzukiCd);
          }
          change();
        }
        dispControlGyoumuKey(true);
    } else {
        dispControlGyoumuKey(false);
    }
  }
).change();
svSubSystemId = $(<%= SUBSYSTEMID_SEARCHCONDITIONS %>).val();

$(<%= DISPGYOUMUKEY + LABEL %>).text('<%= uiBean.getGyoumukeylbl() %>');

if ($(<%= LOCKEDTASKINFOLIST %>)[0].rows.length <= 1) {
  $(<%= LOCKEDTASKINFOLIST + DIV %>).visible(false);
}

function dispControlGyoumuKey(p_visible){
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
    var subSystemId = $(<%= SUBSYSTEMID_SEARCHCONDITIONS %>).val();
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

<% } %>

});
//-->
</script>
