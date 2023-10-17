<%--
    q_r_seal_sakusei.js.jsp - QRシール用紙作成 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.workflow.imagekanri.qrsealsakusei.QRSealSakuseiConstants.*" %>
<%@page import="static yuyu.app.workflow.imagekanri.qrsealsakusei.QRSealSakuseiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.workflow.imagekanri.qrsealsakusei.QRSealSakuseiUiBean" %>
<%@page import="yuyu.def.classification.C_OutkeisikiKbn" %>
<% QRSealSakuseiUiBean uiBean = SWAKInjector.getInstance(QRSealSakuseiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    addRequiredMark("<%= SKEIJIMUKBN_LABEL%>");
    addRequiredMark("<%= HKNSYURUINM_LABEL%>");
    addRequiredMark("<%= OUTKNS_LABEL%>");

    var keisikiKbn = <%= uiBean.getOutkeisikikbn() %>;
    dispNyrykGroup(keisikiKbn);

    $("<%= SAKUJYOLINK_LABEL%>").each(
      function() {
        $(this).text('<%= BLANK %>');
      }
    );

<% if (uiBean.getOutkeisikikbn().equals(C_OutkeisikiKbn.MOSNOSYORUI)) { %>
    if ($(<%= INPUTCONTENTSINFO3 %>)[0]
      && $(<%= INPUTCONTENTSINFO3 %>)[0].rows.length >= 30 * <%= uiBean.getSyrCdSelectNum() %>) {
      $(<%= ADDBUTTON + DIV %>).visible(false);
    }

    if ($(<%= INPUTCONTENTSINFO3 %>)[0].rows.length >= 2 * <%= uiBean.getSyrCdSelectNum() %>) {
      var basePosition = $(<%= INPUTCONTENTSINFO3 %>)[0].getBoundingClientRect();
      var facY = 29;
      var positionY = facY * ($(<%= INPUTCONTENTSINFO3 %>)[0].rows.length - <%= uiBean.getSyrCdSelectNum() %> - 1);

      window.scrollTo("0", basePosition.top + positionY);
    }

<% } %>

    bondSell();

<% } %>

<% if (uiBean.getPageNo() == PAGENO_CONFIRM) { %>
    var keisikiKbn = <%= uiBean.getOutkeisikikbn() %>;
    dispNyrykGroup(keisikiKbn);
    dispSakujyoLink();
    existBondSell();
<% } %>

<% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    openReport("print", "_blank");
    var keisikiKbn = <%= uiBean.getOutkeisikikbn() %>;
    dispNyrykGroup(keisikiKbn);
    dispSakujyoLink();
    existBondSell()

<% } %>

});





var REQUIRED_MARK = "※";

function dispNyrykGroup(keisikiKbn) {
  if (keisikiKbn == '<%= E_OutKeisiki.KENSUU.getName() %>') {
      $(<%= INPUTCONTENTSINFO2 + DIV %>).remove();
      $(<%= INPUTCONTENTSINFO3 + DIV %>).remove();
      $(<%= INPUTCONTENTSINFO4 + DIV %>).remove();
      $(<%= ADDBUTTON + DIV %>).remove();

  } else if (keisikiKbn == '<%= E_OutKeisiki.MOSNO.getName() %>') {
      $(<%= INPUTCONTENTSINFO1 + DIV %>).remove();
      $(<%= INPUTCONTENTSINFO3 + DIV %>).remove();
      $(<%= INPUTCONTENTSINFO4 + DIV %>).remove();
      $(<%= ADDBUTTON + DIV %>).remove();

  } else if (keisikiKbn == '<%= E_OutKeisiki.MOSNOSYORUI.getName() %>') {
      $(<%= INPUTCONTENTSINFO1 + DIV %>).remove();
      $(<%= INPUTCONTENTSINFO2 + DIV %>).remove();

  }
}

function addRequiredMark(labelNm) {
    $(labelNm + "<%= REQUIRED_LABEL%>").each(
      function() {
        $(this).append(
          "<span class='requiredMark'>" + REQUIRED_MARK
          + "</span>");
      });
}


function dispSakujyoLink() {
  $("<%= SAKUJYOLINK_LABEL%>").each(
    function() {
      $(this).text('<%= BLANK %>');
    }
  );
  $("<%= SAKUJYOLINK_DATA%>").each(
    function() {
      $(this).text('<%= BLANK %>');
    }
  );
}


function bondSell() {
    var counter = 0;
    var selectNum = <%= uiBean.getSyrCdSelectNum() %>

    $("<%= MOSNO_DATA%>").each(
    function() {
        if (counter == 0) {
          $(this).attr('rowspan', selectNum);
          $(this).attr('valign', top);
          counter++;
        } else {
          $(this).visible(false);
          counter++
        }
        if (selectNum == counter) {
          counter = 0;
        }
    });


    $("<%= SAKUJYOLINK_DATA%>").each(
    function() {
        if (counter == 0) {
          $(this).attr('rowspan', selectNum);
          counter++;
        } else {
          $(this).visible(false);
          counter++
        }
        if (selectNum == counter) {
          counter = 0;
        }
    });
}

function existBondSell() {
    var counter = 0;
    var num = 0;
    var groupNum = <%= uiBean.getCountNum() %>;

    $("<%= MOSNO_DATA%>").each(
    function() {
        if (counter == 0) {
          $(this).attr('rowspan', groupNum[num]);
          $(this).attr('valign', top);
          counter++;
          if (groupNum[num] == 1) {
            counter = 0;
            num++;
          }
        } else {
          $(this).visible(false);
          counter++
          if (groupNum[num] == counter) {
            counter = 0;
            num++;
          }
        }
    });

    num=0;

    $("<%= SAKUJYOLINK_DATA%>").each(
    function() {
        if (counter == 0) {
          $(this).attr('rowspan', groupNum[num]);
          counter++;
          if (groupNum[num] == 1) {
            counter = 0;
            num++;
          }
        } else {
          $(this).visible(false);
          counter++
          if (groupNum[num] == counter) {
            counter = 0;
            num++;
          }
        }
    });

}

//-->
</script>
