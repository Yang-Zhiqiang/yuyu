<%--
    bz_hojyobo_ruikeigaku_nyuuryoku.js.jsp - 補助簿累計額入力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku.BzHojyoboRuikeigakuNyuuryokuConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku.BzHojyoboRuikeigakuNyuuryokuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku.BzHojyoboRuikeigakuNyuuryokuUiBean"%>
<% BzHojyoboRuikeigakuNyuuryokuUiBean uiBean = SWAKInjector.getInstance(BzHojyoboRuikeigakuNyuuryokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
    <%
      if (uiBean.getPageNo() == PAGENO_SELECTDATA) { %>
          $(<%=HOJYOBORUIKEIGAKUINFOLIST%>).find("span").each(function(){
            if ($(this).text() == '<%= BLANK %>') {
                $(this).html('<%=HYPHEN%>');
            }
           });

          $(<%=TEISEI_LINK + LABEL%>).text('<%=BLANK%>');
          <%
            if (!uiBean.getUpdateKanouFlg()) { %>
              $(<%=TOPBUTTONS + DIV%>).visible(false);
              $("a").filter(function (index) { return $(this).html() == '<%=TEISEILINK%>'; }).parent().html("<%= BLANK %>");
           <% } %>
    <% } %>
    <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
        <%
          if (SINKI_TOUROKU.equals(uiBean.getInputGamenMod())) { %>
            $(<%=DISPKANJYOUKAMOKU_INPUTDATAINFO%>).parent().parent().visible(false);
        <%
         } else { %>
            $(<%=INPUTKANJYOUKAMOKU_INPUTDATAINFO%>).parent().parent().parent().visible(false);
        <% } %>

        <%
          if (!uiBean.getSakujyoBtnDispFlg()) { %>
            $(<%=BOTTOMBUTTONS + DIV%>).visible(false);
        <% } %>
    <% } %>

});
//-->
</script>
