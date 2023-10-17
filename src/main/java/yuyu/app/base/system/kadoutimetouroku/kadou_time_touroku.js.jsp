<%--
    kadou_time_touroku.js.jsp - 稼働時間登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.kadoutimetouroku.KadouTimeTourokuConstants.*"%>
<%@page
	import="static yuyu.app.base.system.kadoutimetouroku.KadouTimeTourokuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.system.kadoutimetouroku.KadouTimeTourokuUiBean"%>
<%@page import="yuyu.def.classification.C_KadouTimeSiteiKbn"%>
<%@page import="yuyu.def.classification.C_KadouTimeYoubiKbn"%>
<% KadouTimeTourokuUiBean uiBean = SWAKInjector.getInstance(KadouTimeTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

    $(function(){

        <%if ( uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>
            disableKadouTime();
            nonDisHyoujunKadouTime();

        <%
        }
        %>

        <%if (uiBean.getPageNo() == PAGENO_CONFIRM) {%>
            nonDisHyoujunKadouTime();
        <%
        }
        %>

        <%if (uiBean.getPageNo() == PAGENO_RESULT) {%>
            nonDisHyoujunKadouTime();
        <%
        }
        %>

    });

    $(function(){

        <%if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>
            $(<%= KADOUTIMESITEIKBN_KADOUTIMEINFOINPUT %>).change(function(){
            disableKadouTime();
            })
        <%
        }
        %>
    });

    function disableKadouTime() {

        if ($(<%= KADOUTIMESITEIKBN_KADOUTIMEINFOINPUT %>).val() == "<%= C_KadouTimeSiteiKbn.SITEI.getValue() %>"){
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

    function nonDisHyoujunKadouTime() {
        <% if (C_KadouTimeYoubiKbn.HYOUJYUN.equals(uiBean.getKadouTime().getKadouTimeYoubiKbn())) { %>
            $(".hyoujunKadouTimeInfo_label").parent().visible(false);
        <% } %>
    }

});
//-->
</script>
