<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：郵便番号検索
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/biz/bzkensaku/bzsrchyno/BzSrchYno.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="srchyno" />
          <swak:item id="todouhukenKbn" />
          <swak:item id="srchknadr" />
          <swak:item id="srchkjadr" />
        </swak:group>

        <%-- searchbuttons --%>
        <swak:buttonGroup id="searchbuttons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- searchResult --%>
        <swak:dataTable id="searchResult">
          <swak:column id="dispyno" />
          <swak:column id="dispkjadr" />
          <swak:column id="dispknadr" />
          <swak:column id="disptodouhukennmkj" />
          <swak:column id="dispsikutyousonnmkj" />
          <swak:column id="disptyouikinmkj" />
          <swak:column id="todoufukenSikutyousonNm" />
          <swak:column id="todoufukenSikutyousonNmKn" />
        </swak:dataTable>
        <swak:pager id="searchResultDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
