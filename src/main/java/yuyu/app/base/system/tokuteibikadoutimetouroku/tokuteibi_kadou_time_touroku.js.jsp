<%--
    tokuteibi_kadou_time_touroku.js.jsp - 特定日稼働時間登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.tokuteibikadoutimetouroku.TokuteibiKadouTimeTourokuConstants.*"%>
<%@page
	import="static yuyu.app.base.system.tokuteibikadoutimetouroku.TokuteibiKadouTimeTourokuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.system.tokuteibikadoutimetouroku.TokuteibiKadouTimeTourokuUiBean"%>
<%@page import="yuyu.def.classification.C_KadouTimeSiteiKbn"%>
<%@page
	import="static yuyu.app.base.system.tokuteibikadoutimetouroku.TokuteibiKadouTimeTourokuSelector.*"%>
<% TokuteibiKadouTimeTourokuUiBean uiBean = SWAKInjector.getInstance(TokuteibiKadouTimeTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

$(function(){

    <% if (uiBean.getPageNo() == PAGENO_SELECTDATA) {%>
        <%if (uiBean.getTokuteibiKadouTimeDataumuFlg() == false) {%>
            $(<%= TOKUTEIBIKADOUTIMESELECTLIST %>).visible(false);
        <%
        }
        %>
    <%
    }
    %>
    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>
        disableKadouTime();
    <%
    }
    %>
});

$(function(){

    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>
        $(<%= KADOUTIMESITEIKBN_TOKUTEIBIKADOUTIMEINFO %>).change(function(){
          disableKadouTime();
        })
    <%
    }
    %>
});

function disableKadouTime() {

    if ($(<%= KADOUTIMESITEIKBN_TOKUTEIBIKADOUTIMEINFO %>).val() == "<%= C_KadouTimeSiteiKbn.SITEI.getValue() %>"){
         $(".kadouTimeFrom1_data").children().children().each(function(){
             $(this).disable(false);
         });
     }
     else {
         $(".kadouTimeFrom1_data").children().children().each(function(){
             $(this).disable(true);
             $(this).val(<%= BLANK%>);
         });
     }
}
});
//-->
</script>
