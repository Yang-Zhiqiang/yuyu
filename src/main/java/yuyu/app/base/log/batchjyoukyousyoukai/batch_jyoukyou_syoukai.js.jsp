<%--
    batch_jyoukyou_syoukai.js.jsp - バッチ状況照会 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiConstants.*"%>
<%@page
	import="static yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.log.batchjyoukyousyoukai.BatchJyoukyouSyoukaiUiBean"%>
<% BatchJyoukyouSyoukaiUiBean uiBean = SWAKInjector.getInstance(BatchJyoukyouSyoukaiUiBean.class); %>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="yuyu.def.classification.C_BatchJyoutaiKbn"%>
<%@page import="yuyu.def.classification.C_BatchResultKbn"%>
<script type="text/javascript"><!--

$(function(){

    <% if (uiBean.getPageNo() == PAGENO_SUMMARY) {%>

        <%if (uiBean.getOutputFlg() != null &&
            uiBean.getOutputFlg().equals(E_OutputKbn.OUTPUT)) {
            uiBean.setOutputFlg(E_OutputKbn.NOOUTPUT);%>
            openReport("print", "_blank");
        <%}%>

        var batchJobListLength = $(<%=BATCHJOBLIST%>)[0].rows.length;

        if (batchJobListLength <= 1) {
            $(<%=BATCHJOBLIST + DIV%>).visible(false);
            $(<%=KOUSINBTN_FOTTERBUTTONS + SPAN%>).visible(false);
        }

        <%if (uiBean.getSubsystemYuukouHanteiFlg() != null &&
            uiBean.getSubsystemYuukouHanteiFlg().equals(E_SubsystemYuukouHanteiKbn.YUUKOU)) {%>
            addClass4SubSystemAri();
        <%} else {%>
            addClass4SubSystemNone();

            $(<%= KEYINFO_FIRST%>).remove();

            var count = 0;
            while (count < batchJobListLength) {
                $(<%=BATCHJOBLIST%>)[0].rows[count].deleteCell(0);
                count++;
            }
        <%}%>

        controlJidouKousin();

        $("a,button,:button").click(
          function() {
            stopTimer();
          }
        );
    <% }
    %>

    <% if (uiBean.getPageNo() == PAGENO_DETAIL) {%>
        var batchLogListLength = $(<%=BATCHLOGLIST%>)[0].rows.length;

        if (batchLogListLength <= 1) {
            $(<%=BATCHLOGLIST + DIV%>).visible(false);
        }

        <%if (uiBean.getSubsystemYuukouHanteiFlg() == null ||
            !uiBean.getSubsystemYuukouHanteiFlg().equals(E_SubsystemYuukouHanteiKbn.YUUKOU)) {%>
            $(<%= BATCHJOBINFO_FIRST %>).remove();
        <%}%>

        <%if (uiBean.getViewControlFlg() != null &&
            uiBean.getViewControlFlg().equals(E_ViewKbn.INVISIBLE)) {%>
            $(<%= TYUUDANBTN_FOTTERBUTTONS + SPAN %>).visible(false);
        <%
        }
        %>
    <%
    }
    %>

    <% if (uiBean.getPageNo() == PAGENO_PRINT) {%>

        var batchLogListLength = $(<%= BATCHLOGLIST %>)[0].rows.length;

        if (batchLogListLength <= 1) {
            $(<%= BATCHLOGLIST + DIV %>).visible(false);
        }

        <%
        if (uiBean.getSubsystemYuukouHanteiFlg() == null ||
            !uiBean.getSubsystemYuukouHanteiFlg().equals(E_SubsystemYuukouHanteiKbn.YUUKOU)) {
        %>
            $(<%= BATCHJOBINFO_FIRST %>).remove();
        <%
        }
        %>
    <%
    }
    %>

    $(<%= INSATUBTN_FOTTERBUTTONS %>).click(function(){

        window.print();
        return false;
     });

});

function addClass4SubSystemAri() {

    $(<%= SUBSYSTEMNM_LABEL %>).addClass(<%= SUBSYSTEMNM_SUBARI %>);
    $(<%= KINOUNM_LABEL %>).addClass(<%= KINOUNM_SUBARI %>);
    $(<%= SUBSYSTEMNM_LABEL %>).removeClass(<%= SUBSYSTEMNM_SUBNASI %>);
    $(<%= KINOUNM_LABEL %>).removeClass(<%= KINOUNM_SUBNASI %>);
}

function addClass4SubSystemNone() {

    $(<%= SUBSYSTEMNM_LABEL %>).addClass(<%= SUBSYSTEMNM_SUBNASI %>);
    $(<%= KINOUNM_LABEL %>).addClass(<%= KINOUNM_SUBNASI %>);
    $(<%= SUBSYSTEMNM_LABEL %>).removeClass(<%= SUBSYSTEMNM_SUBARI %>);
    $(<%= KINOUNM_LABEL %>).removeClass(<%= KINOUNM_SUBARI %>);
}

function controlJidouKousin() {


    <%
    if (uiBean.getJidouKousinUmuFlg() != null &&
        C_UmuKbn.ARI.eq(uiBean.getJidouKousinUmuFlg())) {
    %>

        $(<%= JIDOUKOUSINSURUBTN_KOUSINBUTTONS %>).disable(true);
        $(<%= JIDOUKOUSINSINAIBTN_KOUSINBUTTONS %>).disable(false);

        startTimer();

    <%
    } else {
    %>
        $(<%= JIDOUKOUSINSURUBTN_KOUSINBUTTONS %>).disable(false);
        $(<%= JIDOUKOUSINSINAIBTN_KOUSINBUTTONS %>).disable(true);
    <%
    }
    %>
}

var timer;
function startTimer() {
    timer = setInterval(function(){
       $(<%=KOUSINBTN_FOTTERBUTTONS%>).trigger('click');
    },30000);
}

function stopTimer() {
  clearInterval(timer);
}
//-->
</script>