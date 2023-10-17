<%--
    kinou_teigi_touroku.js.jsp - 機能定義登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.kinouteigitouroku.KinouTeigiTourokuConstants.*"%>
<%@page
	import="static yuyu.app.base.system.kinouteigitouroku.KinouTeigiTourokuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.system.kinouteigitouroku.KinouTeigiTourokuUiBean"%>
<%@page
	import="yuyu.app.base.system.kinouteigitouroku.KinouTeigiTourokuConstants"%>
<%@page import="yuyu.def.classification.C_KousinNaiyouHaneiKbn"%>
<%@page import="yuyu.def.classification.C_YuukouKbn"%>
<%@page import="yuyu.def.classification.C_KinouKbn"%>
<%@page import="yuyu.def.classification.C_YouhiKbn"%>

<% KinouTeigiTourokuUiBean uiBean = SWAKInjector.getInstance(KinouTeigiTourokuUiBean.class); %>

<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_SELECTDATA) {%>

        <%
        if (!uiBean.getSubSystemEnableFlg()) {
        %>
            $(<%= KEYINFO %>).parent().visible(false);
            $(<%= BUTTONSELECT %>).parent().visible(false);
        <%
        }
        %>
    <%
    }
    %>

    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>

        var value = $(<%= YUUKOUKBN%> + ":checked").val();
        if(value == "<%= C_YuukouKbn.BYDATE.getValue() %>"){
            $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO        %>).disable(false);
            $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + SPAN %>).children().disable(false);

        }
        else {
            $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO        %>).disable(true);
            $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + SPAN %>).children().disable(true);
        }

        <%
        if (C_KinouKbn.BATCH.eq(uiBean.getKinou().getKinouKbn())) {
        %>
            $(<%= KADOUTIMEGROUPCD_SYSTEMSETTEIINFO %>).parent().parent().parent().visible(false);
        <%
        }
        %>

        <%
         if (C_YouhiKbn.HUYOU.eq(uiBean.getKinou().getKidouKengenHanteiYouhiKbn())) {
         %>
             $(<%= KENGENSETTEILIST + DIV %>).visible(false);
             $(<%= BUTTONCHECK + DIV%>).visible(false);

         <%
         }
         %>


        <%
        if (!uiBean.getKinouModeSiborikomiDataumuFlg()) {
        %>
            $(<%= SELECT_SIBORIKOMI%>).visible(false);
        <%
        }
        %>


        $(<%= KENGENSETTEILIST %>).find(":checkbox").each(function(index){

            var selectSiborikomiWithIndex = "select[id^='kengenSetteiList\\[" + index + "\\].siborikomiId']";

            if ($(this).attr('checked') == undefined) {
                $(selectSiborikomiWithIndex).disable(true);

            }
            else {
                $(selectSiborikomiWithIndex).disable(false);
            }
        })

        $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + PREFIX %>).visible(false);
        $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + SUFFIX %>).visible(false);

    <%
    }
    %>

    <% if (uiBean.getPageNo() == PAGENO_CONFIRM ||
        uiBean.getPageNo() == PAGENO_RESULT ) {%>

        <%
        if (!(C_YuukouKbn.BYDATE.eq(uiBean.getKinouMode().getYuukouKbn()))) {
        %>
             $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + PREFIX %>).visible(false);
             $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + SUFFIX %>).visible(false);
        <%
        }
        %>

        <%
        if (C_KousinNaiyouHaneiKbn.KINOU_MODE.eq(uiBean.getKousinNaiyouHaneiKbn())) {
        %>
            $(<%= KINOUMODEINFOLIST + DIV %>).visible(false);

        <%
        }
        %>

        <%
        if (C_KinouKbn.BATCH.eq(uiBean.getKinou().getKinouKbn())) {
        %>
            $(<%= KADOUTIMEGROUPCD_SYSTEMSETTEIINFO %>).parent().parent().visible(false);
        <%
        }
        %>


        <%
        if (C_YouhiKbn.HUYOU.eq(uiBean.getKinou().getKidouKengenHanteiYouhiKbn())) {
        %>
            $(<%= KENGENSETTEILIST + LABEL %>).parent().parent().parent().parent().visible(false);
            $(<%= KENGENSETTEILIST         %>).visible(false);
        <%
        }
        %>
    <%
    }
    %>
});


$(function() {

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>
        $(<%= YUUKOUKBN %>).click(function(){

            var value = $(<%= YUUKOUKBN %> + ":checked").val();

            if(value == "<%= C_YuukouKbn.BYDATE.getValue() %>"){
                $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO        %>).disable(false);
                $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + SPAN %>).children().disable(false);

            }
            else {
                $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO        %>).val("");
                $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + SPAN %>).children("select").val("H");
                $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + SPAN %>).children("input" ).val("");

                $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO        %>).disable(true);
                $(<%= YUUKOUKAISIYMD_SYSTEMSETTEIINFO + SPAN %>).children().disable(true);
            }
        })
    <%
    }
    %>
});

$(function() {

   <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>
        $(<%= KENGENSETTEILIST %>).find(":checkbox").click(function(){
            if ($(this).is(':checked')) {
                $(this).parent().parent().parent().find("select").disable(false);
            }
            else {
                $(this).parent().parent().parent().find("select").disable(true);
            }
        })
    <%
    }
    %>
});

$(function() {

    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>
            $("[id^='allCheckBtn']").click(function(){
                $(".check").prop({'checked' : true});
                $(".userSelect").disable(false);
            })
    <%
    }
    %>
});

$(function() {

    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>
            $("[id^='allUnCheckBtn']").click(function(){
                $(".check").prop({'checked' : false});
                $(".siborikomiId_data").children().children().disable(true);
            })
    <%
    }
    %>
});
//-->
</script>
