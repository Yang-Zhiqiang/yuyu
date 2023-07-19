<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：進捗状況照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sksyoukai/skstyjksyoukai/SkStyjksyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- 検索条件 --%>
        <swak:group id="searchConditions">
          <swak:item id="srchjimustartymdfrom" />
          <swak:item id="srchjimustartymdto" />
          <swak:item id="srchmosno" />
          <swak:item id="srchnowkinoussnm" />
          <swak:item id="srchseiritukbn" />
          <swak:item id="srchketteikbn" />
          <swak:item id="srchlincjkjknumu" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- 検索結果タイトル --%>
        <swak:dataTable id="searchResultsTitle">
          <swak:column id="dispjimustartymdtime" />
          <swak:column id="dispmosno" />
          <swak:column id="dispkinoussnm" />
          <swak:column id="disptratkiagcd" />
          <swak:column id="disptratkiagnm" />
          <swak:column id="dispoyadrtencd" />
          <swak:column id="dispoyadrtennm" />
          <swak:column id="disphubiumu" />
          <swak:column id="disptrkymd" />
          <swak:column id="disphassinymd" />
          <swak:column id="dispkaisyouymd" />
          <swak:column id="dispnyknumukbn" />
          <swak:column id="disphrkkeiro" />
          <swak:column id="dispketteikbn" />
          <swak:column id="dispjimusrhkbn" />
          <swak:column id="dispseiritukbn" />
          <swak:column id="dispsyoriymd" />
          <swak:column id="displastkossyori" />
        </swak:dataTable>

        <%-- 検索結果 --%>
        <swak:dataTable id="searchResults">
          <swak:column id="dispjimustartymdtime" />
          <swak:column id="dispmosno" />
          <swak:column id="dispkinoussnm" />
          <swak:column id="disptratkiagcd" />
          <swak:column id="disptratkiagnm" />
          <swak:column id="dispoyadrtencd" />
          <swak:column id="dispoyadrtennm" />
          <swak:column id="disphubiumu" />
          <swak:column id="disptrkymd" />
          <swak:column id="disphassinymd" />
          <swak:column id="dispkaisyouymd" />
          <swak:column id="dispnyknumukbn" />
          <swak:column id="disphrkkeiro" />
          <swak:column id="dispketteikbn" />
          <swak:column id="dispjimusrhkbn" />
          <swak:column id="dispseiritukbn" />
          <swak:column id="dispsyoriymd" />
          <swak:column id="displastkossyori" />
        </swak:dataTable>
        <swak:pager id="searchResultsDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
