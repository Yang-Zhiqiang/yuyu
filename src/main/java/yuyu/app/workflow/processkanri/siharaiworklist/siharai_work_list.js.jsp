<%--
    siharai_work_list.js.jsp - 保険金給付金支払工程ワークリスト JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.siharaiworklist.SiharaiWorkListConstants.*" %>
<%@page import="static yuyu.app.workflow.processkanri.siharaiworklist.SiharaiWorkListSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.processkanri.siharaiworklist.SiharaiWorkListUiBean" %>
<% SiharaiWorkListUiBean uiBean = SWAKInjector.getInstance(SiharaiWorkListUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  $(".messagesItem").each(
  function(){
    <% if(uiBean.getPageNo() == PAGENO_INPUTKEYTSKSNTKHKNSHR){ %>
        if ($(<%= RESULTINFOTSKSNTKBASE %>)[0].rows.length <= 1) {
            $(<%= RESULTINFOTSKSNTKBASE %>).visible(false);
        }
    <% } %>

    <% if(uiBean.getPageNo() == PAGENO_INPUTKEYANKNITRNHKNSHR){ %>
        if ($(<%= RESULTINFOITIRAN %>)[0].rows.length <= 1) {
            $(<%= RESULTINFOITIRAN + DIV %>).visible(false);
            $(".recordCountDiv").visible(false);
            $(".pagerDiv").visible(false);
        }
    <% } %>
  });

    $(<%= CLEARBTN_SEARCHCONDITIONBTN %>).click(
      function(){
        $(".userSelect").each(
          function(){
            $(this).val("");
          }
        );
        $(".check").each(
          function(){
            $(this).prop('checked',false);
          }
        );
        $(".text").each(
          function(){
            $(this).val("");
          }
        );
        $(".dateYMD_SEIREKI").each(
          function(){
            $(this).val("");
          }
        );
      }
    );

    <% if(uiBean.getPageNo() == PAGENO_INPUTKEYTSKSNTKHKNSHR){ %>


      $("#resultInfoTskSntkBase .jimutetuzukicd_label").remove();

      $(<%= RESULTINFOTSKSNTKBASE %>).removeClass("listItems");

      $("#resultInfoTskSntkBase .jimutetuzukicd_data").each(

        function(i){

          var resultInfoCloneTd = $("<td></td>");
          var resultInfoCloneTable = $("<table id='resultInfoTskSntk_clone[" + i + "]' class='listItemsClone'></table>");

          var tbody = $("<tbody></tbody>");

          var tableHeader = $("<tr></tr>");

          var tableHeaderTskNm = $("<td class='workflowTskNm_label["+i+"] label'></td>");
          tableHeaderTskNm.append($("span[class='workflowTskNm_label']").html());

          var tableHeaderKojinTskNum = $("<td class='kjnTskKensuu_label["+i+"] label' colspan = '3'></td>");
          tableHeaderKojinTskNum.append($("span[class='kjnTskKensuu_label']").html());

          var tableHeaderKyoyoTskNum = $("<td class='kyyTskKensuu_label["+i+"] label' colspan = '3'></td>");
          tableHeaderKyoyoTskNum.append($("span[class='kyyTskKensuu_label']").html());

          tableHeader.append(tableHeaderTskNm,tableHeaderKojinTskNum,tableHeaderKyoyoTskNum);

          tbody.append(tableHeader);

          var tableBody=$();

          var jimtetuzukicdBase = $(this).text().trim();

          var resultInfo = $("#resultInfoTskSntk .jimutetuzukicd_data");

          var captionflg = true;

          for(var cnt = 0;cnt < resultInfo.length;cnt++){

            var jimutetuzukicd = $("#resultInfoTskSntk\\["+cnt+"\\]\\.jimutetuzukicd");

            if(jimutetuzukicd.text() == jimtetuzukicdBase){

              if(captionflg){
                resultInfoCloneTable.append(
                  "<caption> ●" +
                  $("#resultInfoTskSntk\\["+cnt+"\\]\\.dispjimutetuzukinm").html() +
                  "</caption>");
                captionflg = false;
              }

              var tableBodyContents = $("<tr></tr>");

              var tableBodyTskNm = $("<td class = 'workflowTskNm_data'></td>");
              tableBodyTskNm.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.workflowTskNm"));

              var tableBodyKjnTsk = $("<td class = 'kjnTskKensuu_data' colspan='3'></td>");
              tableBodyKjnTsk.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.kjnTskKensuu"));
              tableBodyKjnTsk.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.kjnTskKensuuUnit"));
              tableBodyKjnTsk.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.kojinNyuuryokuLinkSpan"));
              tableBodyKjnTsk.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.kojinItiranLinkSpan"));

              var tableBodyKyyTsk = $("<td class = 'kyyTskKensuu_data' colspan='3'></td>");
              tableBodyKyyTsk.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.kyyTskKensuu"));
              tableBodyKyyTsk.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.kyyTskKensuuUnit"));
              tableBodyKyyTsk.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.kyouyouNyuuryokuLinkSpan"));
              tableBodyKyyTsk.append($("#resultInfoTskSntk\\["+cnt+"\\]\\.kyouyouItiranLinkSpan"));

              tableBodyContents.append(tableBodyTskNm,tableBodyKjnTsk,tableBodyKyyTsk);
              tbody.append(tableBodyContents);
            }
          }

          resultInfoCloneTable.append(tbody);
          resultInfoCloneTd.append(resultInfoCloneTable);
          $(this).replaceWith(resultInfoCloneTd);
        }
      );

      $("a[id *= 'NyuuryokuLink']").filter(function (index) { return $(this).html() == ""; }).parent().html("<%= NYUURYOKU_LINK %>");
      $("a[id *= 'ItiranLink']").filter(function (index) { return $(this).html() == ""; }).parent().html("<%= ITIRAN_LINK %>");

      $(<%= RESULTINFOTSKSNTKBASE + DIV %>).visible(true);
      $(<%= RESULTINFOTSKSNTK + DIV %>).remove();
    <% } %>

    <% if(uiBean.getPageNo() == PAGENO_INPUTKEYANKNITRNHKNSHR){ %>
        $(<%= RESULTINFOITIRAN %>).prepend(
            "<caption> ●" +
            "<%= uiBean.getDispTaskName() %>" +
            "一覧 </caption>");

        $("a[id *= 'nyuuryokuLink']").filter(function (index) { return $(this).html() == ""; }).parent().html("<%= NYUURYOKU_LINK %>");
    <% } %>
});


//-->
</script>
