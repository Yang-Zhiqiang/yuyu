<%--
    table_syoukai.js.jsp - テーブル照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.systemsyoukai.tablesyoukai.TableSyoukaiConstants.*"%>
<%@page
	import="static yuyu.app.base.systemsyoukai.tablesyoukai.TableSyoukaiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.def.classification.C_TblsSearchCondition"%>
<%@page
	import="yuyu.app.base.systemsyoukai.tablesyoukai.TableSyoukaiUiBean"%>
<% TableSyoukaiUiBean uiBean = SWAKInjector.getInstance(TableSyoukaiUiBean.class); %>
<script type="text/javascript"><!--

$(function(){
<% if(uiBean.getPageNo() == PAGENO_SELECTTABLE){

  if(uiBean.getTableSearchResultListDataSource() == null
      || uiBean.getTableSearchResultListDataSource().size() == 0){%>
   $(<%= TABLESEARCHRESULTLIST%>).parent().visible(false);

<%}
} %>


<% if(uiBean.getPageNo() == PAGENO_SEARCH){ %>

  disableInputSearchCondition = function(selector){

    value = selector.filter(':checked').val();

    if(value == "<%=C_TblsSearchCondition.INPUT.getValue() %>"){
      selector.parent().parent().find(".text").disable(false);
    }
    else{
      selector.parent().parent().find(".text").disable(true);
    }
  };

  $(<%= RADIO_CHECKED%>).each(function(){
    disableInputSearchCondition($(this));
  })

  $(<%= RADIO%>).click(function(){
    disableInputSearchCondition($(this));
  })

  for(var index = 0; index < <%= uiBean.getInputSearchConditionDataSource().size()%>; index++){
    $("[for='inputSearchCondition\\[" + index + "\\].baseSearchConditionKbn\\[1\\]']")
      .after($("#inputSearchCondition\\[" + index + "\\]\\.baseSearchConditionSpan"));
      $("#inputSearchCondition\\[" + index + "\\]\\.baseSearchCondition").removeClass("text12")
      $("#inputSearchCondition\\[" + index + "\\]\\.baseSearchCondition").addClass("text11")
  }

  $(<%= RESULT_LIST_DIV %>).after(
    "<div id='tableDatasDiv' class='listDiv'>" +
     "<table id='tableDatas' class='listItems'>" +
      "<thead></thead>" +
      "<tbody></tbody>" +
     "</table>" +
    "</div>"
  );

  var fieldsList = [];
  for (var col = 0; col < $(<%= FIELD_LIST%>)[0].rows.length - 1; col++) {
    fieldsList.push({
      name: $("#fieldsList\\[" + col + "\\]\\.baseFieldNm"  ).text(),
      toString: function() { return "{name=" + this.name + " }"; }
    });
  }
  $(<%= FIELD_LIST_DIV%>).remove();

  var th = "";
  for (var col = 0; col < fieldsList.length; col++) {
    th += "<td class='label ddNm'><span>" + fieldsList[col].name + "</span></td>";
  }
  $("#tableDatas thead").append("<tr><td class='label syousaiLink'>詳細</td>" + th + "</tr>");

  var valIndex = 0;
  var rowIndex = 0;
  var f = function() {
    var hasNext = true;
    var rows    = 0;
    while (hasNext) {
      rowIndex++;
      $("#tableDatas tbody").append("<tr></tr>");
      $("#tableDatas tbody tr:last-child").append("<td class=syousaiLink id=" + rowIndex + "></td>");
      $("#tableDatas tbody tr:last-child td:first-child").append("<span></span>");
      $("#tableDatas tbody tr:last-child td:first-child span:first-child").append("<a href=#.>詳細</a>")
        .click(
          function() {
            $(<%= BASECLICKROWNO_ONCLICKEVENTS%>).val($(this).parent().attr("id"));
            $(<%= KAKUTEIBTN_ONCLICKEVENTS%>).click();
          }
        );
      for (var col = 0; col < fieldsList.length; col++) {
        var td = $("#resultsList\\[" + valIndex++ + "\\]\\.baseFieldValue").parent("td");
        var tr = td.parent("tr");
        $("#tableDatas tbody tr:last-child").append(td);
        tr.remove();
      }
      hasNext = $("#resultsList\\[" + valIndex + "\\]\\.baseFieldValue").length > 0;
      if (++rows >= 20) break;
    }
    if (hasNext) {
      window.setTimeout(f, 10);
    } else {
      $(<%= RESULT_LIST_DIV%>).remove();
    }
  };
  f();

  if(fieldsList.length >= 6){
    var width = (fieldsList.length*160+30) + 'px';
    $(<%= TABLE_DATAS%>).css('width', width);


    $(<%= DDNM%>).each(function(){
      $(this).css('width', '160px');
    });
  }else{
    var width = (96/fieldsList.length);
    $(<%= DDNM%>).each(function(){
      $(this).css('width' , width+'%');
    });

  }

  $(<%= SYOUSAI_LINK%>).css('width', '30px');

  <% if(uiBean.getResultsList() == null
     || uiBean.getResultsList().size() == 0){%>
       $(<%= TABLE_DATAS%>).parent().visible(false);
  <%}%>

<%} %>


<% if(uiBean.getPageNo() == PAGENO_RESULTDETAIL){ %>
  $(<%= FIELD_NM_LABEL%>).parent().visible(false);

  $(<%= FIELD_NM_DATA%>).each(function(){
    $(this).addClass('label');
  });

  $("#functionName").parent().addClass("functionNameLink");
  $("#functionName").contents().unwrap();


<%} %>
});

//-->
</script>
