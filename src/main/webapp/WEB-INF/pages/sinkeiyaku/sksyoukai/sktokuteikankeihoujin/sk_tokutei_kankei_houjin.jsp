<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：特定関係法人照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sksyoukai/sktokuteikankeihoujin/SkTokuteiKankeiHoujin.do">

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="mosno" />
        </swak:group>

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchConditions --%>
        <swak:group id="searchConditions">
          <swak:item id="srchtkhjnkinyuucd" />
          <swak:item id="srchtkhjnkjdrtennm" />
          <swak:item id="srchtkhjnnmkj" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- searchConditions2 --%>
        <swak:group id="searchConditions2">
          <swak:item id="disptkhjnkinyuucd" />
          <swak:item id="disptkhjnkjdrtennm" />
          <swak:item id="disptkhjnnmkj" />
        </swak:group>

        <%-- searchResults --%>
        <swak:dataTable id="searchResults">
          <swak:column id="disptkhjnkinyuucd" />
          <swak:column id="disptkhjnkjdrtennm" />
          <swak:column id="disptkhjnnmkj" />
        </swak:dataTable>
        <swak:pager id="searchResultsDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
