<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：代理店検索
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/biz/bzkensaku/bzsrchdairiten/BzSrchDairiten.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchConditions --%>
        <swak:group id="searchConditions">
          <swak:item id="srchdrtencd" />
          <swak:item id="srchdrtennm" />
          <swak:item id="IBF1010" />
          <swak:item id="srchkanjidairitennm1" />
          <swak:item id="srchkanjidairitennm2" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- searchResults --%>
        <swak:dataTable id="searchResults">
          <swak:column id="dispdrtencd" />
          <swak:column id="dispdrtennmkn" />
          <swak:column id="dispdrtennmkj" />
        </swak:dataTable>
        <swak:pager id="searchResultsDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
