<%--
    bz_tyouhyou_ikkatu.js.jsp - 帳票一括出力 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bztyouhyou.bztyouhyouikkatu.BzTyouhyouIkkatuConstants.*"%>
<%@page
	import="static yuyu.app.biz.bztyouhyou.bztyouhyouikkatu.BzTyouhyouIkkatuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.biz.bztyouhyou.bztyouhyouikkatu.BzTyouhyouIkkatuUiBean"%>
<%@page
	import="yuyu.app.biz.bztyouhyou.bztyouhyouikkatu.SearchKeyListDataSourceBean"%>
<%@page import="java.util.List"%>
<% BzTyouhyouIkkatuUiBean uiBean = SWAKInjector.getInstance(BzTyouhyouIkkatuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) {%>

    $(<%=KNSKKMKNM1_LABEL%>).text('<%=uiBean.getKensakuNm1()%>');
    $(<%=KNSKKMKNM2_LABEL%>).text('<%=uiBean.getKensakuNm2()%>');
    $(<%=KNSKKMKNM3_LABEL%>).text('<%=uiBean.getKensakuNm3()%>');
    $(<%=KNSKKMKNM4_LABEL%>).text('<%=uiBean.getKensakuNm4()%>');
    $(<%=KNSKKMKNM5_LABEL%>).text('<%=uiBean.getKensakuNm5()%>');

<% }%>

  <% if (uiBean.getPageNo() == PAGENO_KENSAKURESULT) {%>
    $(<%=SEARCHRESULTLIST%>).find('tr').each(function(index){
      if($(<%=SEARCHRESULTLIST%>)[0].rows.length == (index + 1)) {
         return false;
      }

      var $dispmisyuturyokukensuu = $(document.getElementById('searchResultList['+ index +'].dispmisyuturyokukensuu'));

      if ($dispmisyuturyokukensuu.text() == '0') {
        var $dispsyoruinm = $(document.getElementById('searchResultList['+ index +'].dispsyoruinm'));
        var $dispsyoruinmSpan = $(document.getElementById('searchResultList['+ index +'].dispsyoruinmSpan'));
        var syoruiNm = $dispsyoruinm.text();

        $dispsyoruinm.remove();
        $dispsyoruinmSpan.text(syoruiNm);
      }
    });
  <% }%>

  <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
  <%    boolean isKnskKeyExist = false; %>
  <%    List<SearchKeyListDataSourceBean> searchKeyList = uiBean.getSearchKeyList(); %>
  <%    for (SearchKeyListDataSourceBean bean : searchKeyList) { %>
  <%        if (bean.getKnskkmknm1() != null || bean.getKnskkmknm2() != null || bean.getKnskkmknm3() != null || bean.getKnskkmknm4() != null || bean.getKnskkmknm5() != null) { %>
  <%            isKnskKeyExist = true; %>
  <%        } %>
  <%    } %>
  <%    if (!isKnskKeyExist) { %>
            $(searchKeyListDiv).visible(false);
            $(searchKeyListDiv).wrap("<div />");
  <%    } %>
  <% }%>

  <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    openReport("print", "_blank");
  <% } %>

});
//-->
</script>
