<%--
    ds_kokyaku_touroku.js.jsp - 顧客登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.direct.dskokyakukanri.dskokyakutouroku.DsKokyakuTourokuConstants.*"%>
<%@page
	import="static yuyu.app.direct.dskokyakukanri.dskokyakutouroku.DsKokyakuTourokuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.direct.dskokyakukanri.dskokyakutouroku.DsKokyakuTourokuUiBean"%>
<%@page import="yuyu.def.classification.C_DsSyoriKbn"%>
<% DsKokyakuTourokuUiBean uiBean = SWAKInjector.getInstance(DsKokyakuTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <%
  if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
    var sentakuDsSyoriKbn = $("input[id^='dssyorikbn']:checked").val();

    if (<%= C_DsSyoriKbn.KOKYAKU_TOUROKU.getValue() %> == sentakuDsSyoriKbn) {
      showGroup(<%= DSKOKYAKUJYOUTAI %>);

    } else if (<%= C_DsSyoriKbn.KOKYAKU_TOUGOU.getValue() %> == sentakuDsSyoriKbn) {
      showGroup(<%= KOKYAKUTOUGOUSAKI %>);
    }

    $("input[id^='dssyorikbn']").change(
      function() {
        var sentakuDsSyoriKbn = $("input[id^='dssyorikbn']:checked").val();

        if (<%= C_DsSyoriKbn.KOKYAKU_TOUROKU.getValue() %> == sentakuDsSyoriKbn) {
          showGroup(<%= DSKOKYAKUJYOUTAI %>);
        }
        else{
          $(<%= DSKOKYAKUJYOUTAI + DIV %>).visible(false);
          $(<%= DSKANYUUKEIROKBN_DSKOKYAKUJYOUTAI %>).find("option[value = '0']").attr("selected", true);
        }

        if (<%= C_DsSyoriKbn.KOKYAKU_TOUGOU.getValue() %> == sentakuDsSyoriKbn) {
          showGroup(<%= KOKYAKUTOUGOUSAKI %>);
        }
        else{
          $(<%= KOKYAKUTOUGOUSAKI + DIV %>).visible(false);
          $(<%= TOUGOUSAKIDSKOKNO_KOKYAKUTOUGOUSAKI %>).val("");
        }
      }
    );
  <% }%>

  <%
  if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
    <% if(C_DsSyoriKbn.KOKYAKU_TOUROKU.eq(uiBean.getDssyorikbn())) {%>
         showGroup(<%= DSKOKYAKUJYOUTAI %>);
    <% }
     else if(C_DsSyoriKbn.KOKYAKU_TOUGOU.eq(uiBean.getDssyorikbn())) {%>
         showGroup(<%= KOKYAKUTOUGOUSAKI %>);
    <% } %>
  <% }%>
});
//-->
</script>
