<%--
    access_log_syoukai.js.jsp - アクセスログ照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.log.accesslogsyoukai.AccessLogSyoukaiConstants.*"%>
<%@page
	import="static yuyu.app.base.log.accesslogsyoukai.AccessLogSyoukaiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.log.accesslogsyoukai.AccessLogSyoukaiUiBean"%>
<%@page import="yuyu.def.classification.C_KinouKbn"%>
<% AccessLogSyoukaiUiBean uiBean = SWAKInjector.getInstance(AccessLogSyoukaiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

<% if (uiBean.getPageNo() == PAGENO_SEARCH) { %>

var allCategories = [];
$(<%= CATEGORYID_SEARCHCONDITIONS %> + " option").each(
  function() {
    allCategories.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);

var allKinous = [];
$(<%= KINOUID_SEARCHCONDITIONS %> + " option").each(
  function() {
    allKinous.push({
      id   : $(this).val(),
      name : $(this).text()
    });
  }
);

$(function(){
  chkKinouKbn();
});

$(<%= CATEGORYID_SEARCHCONDITIONS %>).change(
   function() {
     chkKinouKbn();
  }
);

$(<%= KINOUKBN_SEARCHCONDITIONS %>).change(
  function() {
    chkKinouKbn();
  }
);

$(<%= SUBSYSTEMID_SEARCHCONDITIONS %>).change(
  function() {
    var subSystemId = $(this).val();
    var categoryId  = $(<%= CATEGORYID_SEARCHCONDITIONS %>).val();

    $(<%= CATEGORYID_SEARCHCONDITIONS %> + " option").remove();
    var exists = false;
    for (var i in allCategories) {
      with (allCategories[i]) {
        if ((id.length == 0) || (subSystemId.length == 0) || id.startsWith(subSystemId + ".")) {
          $(<%= CATEGORYID_SEARCHCONDITIONS %>).append($("<option />").val(id).text(name));
          if (id == categoryId) {
            exists = true;
          }
        }
      }
    }
    with ($(<%= CATEGORYID_SEARCHCONDITIONS %>)) {
      if (exists) {
        val(categoryId);
      }
      change();
    }
  }
).change();

var animateSpeed = 200;

if ($(<%= ACCESSLOGINFOLIST %>)[0].rows.length <= 2) {
  $(<%= ACCESSLOGINFOLIST + DIV %>).visible(false);
  $(<%= SEARCHCONDITIONS        %>).visible(true);
  $(<%= SEARCHBTN_SEARCHBUTTONS %>).visible(true);
} else {
  $(<%= SEARCHCONDITIONS         %>).visible(false);
  $(<%= SEARCHBTN_SEARCHBUTTONS  %>).visible(false);
  $(<%= SEARCHCONDITIONS + LABEL %>).closest("table.groupTitle")
  .addClass("searchConditionsMinimizable searchConditionsMinimized")
  .click(
    function() {
      $(this).toggleClass("searchConditionsMinimized");
      $(<%= SEARCHBTN_SEARCHBUTTONS %>).toggle();
      $(<%= SEARCHCONDITIONS        %>).toggle();
    }
  )
  .hover(
    function() {
      $(this).addClass("active");
    },
    function() {
      $(this).removeClass("active");
    }
  );
}

if ($('#messages').is(':visible') && $("img").attr('src').match(/Message_Error/)) {
  $(<%= SEARCHCONDITIONS        %>).visible(true);
  $(<%= SEARCHBTN_SEARCHBUTTONS %>).visible(true);
}

$(".logData_data").each(
  function() {
    var td = $(this);
    if (td.text().trim().length == 0) {
      td.visible(false);
    } else {
      var tr   = td.closest("tr");
      var span = td.children();
      tr.removeClass("hidden");
      span.wrap("<div class='logData_data'></div>");
      var div  = span.closest("div");
      var maxHeight = div.height();
      div.addClass("minimized");
      var minHeight = div.height();
      var toggleLogData = function() {
        var toHeight = div.hasClass("minimized") ? maxHeight : minHeight;
        div.animate({ height: toHeight }, animateSpeed);
        div.toggleClass("minimized");
        if (! $(this).hasClass("active")) {
          setTimeout(
            function() {
              tr.addClass("hidden");
            },
            animateSpeed
          );
        }
      };
      tr.addClass("hidden")
      .click(
        toggleLogData
      );

      tr.prev("tr")
      .hover(
        function() {
          $(this).addClass("active");
          if (tr.hasClass("hidden")) {
            tr.removeClass("hidden");
          }
        },
        function() {
          $(this).removeClass("active");
          if (div.hasClass("minimized")) {
            tr.addClass("hidden");
          }
        }
      )
      .click(
        toggleLogData
      );
    }
  }
);

function chkKinouKbn(){
  var subSystemId = $(<%= SUBSYSTEMID_SEARCHCONDITIONS %>).val();
  var categoryId  = $(<%= CATEGORYID_SEARCHCONDITIONS  %>).val();
  var kinouId     = $(<%= KINOUID_SEARCHCONDITIONS     %>).val();
  var kinouKbn    = $(<%= KINOUKBN_SEARCHCONDITIONS %>).val();

  $(<%= KINOUID_SEARCHCONDITIONS %> + " option").remove();
  var exists = false;
  for (var i in allKinous) {
    with (allKinous[i]) {
      if ((id.length == 0) ||
         ((subSystemId.length == 0) && (categoryId.length == 0) && (kinouKbn == <%= C_KinouKbn.BLNK%>|| id.endsWith(kinouKbn)))
         || ((subSystemId.length == 0) && (id.startsWith(categoryId + ".")) && (kinouKbn == <%= C_KinouKbn.BLNK%> || id.endsWith(kinouKbn)))
         || ((id.startsWith(subSystemId+ ".")) && (id.startsWith(categoryId + ".")) && (kinouKbn == <%= C_KinouKbn.BLNK%> || id.endsWith(kinouKbn)))
         || ((id.startsWith(subSystemId+ ".")) && (categoryId.length == 0) && (kinouKbn == <%= C_KinouKbn.BLNK%> || id.endsWith(kinouKbn)))
         || ((id.startsWith(categoryId + ".")) && (subSystemId.length == 0) && (kinouKbn == <%= C_KinouKbn.BLNK%> || id.endsWith(kinouKbn)))
         )
      {
          $(<%= KINOUID_SEARCHCONDITIONS %>).append($("<option />").val(id).text(name));
          if (id == kinouId) {
            exists = true;
          }
      }
    }
  }
  if (exists) {
    $(<%= KINOUID_SEARCHCONDITIONS %>).val(kinouId);
  }
}

<% } %>

});
//-->
</script>
