<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：テーブル照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/systemsyoukai/tablesyoukai/TableSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
          <swak:item id="tojiruBtnByPopup" />
        </swak:buttonGroup>

        <%-- searchConditions --%>
        <swak:group id="searchConditions">
          <swak:item id="subSystemId" />
          <swak:item id="baseTableId" />
          <swak:item id="baseTableNm" />
          <swak:item id="baseSearchPtnNm" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- tableSearchResultList --%>
        <swak:dataTable id="tableSearchResultList">
          <swak:column id="baseSelectLink" />
          <swak:column id="subSystemNm" />
          <swak:column id="baseTableId" />
          <swak:column id="baseTableNm" />
          <swak:column id="baseSearchPtnNm" />
          <swak:column id="baseSearchDdNm" />
        </swak:dataTable>

        <%-- inputSearchCondition --%>
        <swak:dataTable id="inputSearchCondition">
          <swak:column id="baseSearchDdNm" />
          <swak:column id="baseSearchConditionKbn" />
          <swak:column id="baseSearchCondition" />
        </swak:dataTable>

        <%-- token --%>
        <swak:group id="token">
          <swak:item id="baseToken" />
        </swak:group>

        <%-- buttons --%>
        <swak:buttonGroup id="buttons">
          <swak:item id="modoruBtnBySyousai" />
          <swak:item id="baseSyoukaiBtn" />
        </swak:buttonGroup>

        <%-- fieldsList --%>
        <swak:dataTable id="fieldsList">
          <swak:column id="baseColNo" />
          <swak:column id="baseFieldNm" />
        </swak:dataTable>

        <%-- resultsList --%>
        <swak:dataTable id="resultsList">
          <swak:column id="baseRowNo" />
          <swak:column id="baseColNo" />
          <swak:column id="baseFieldValue" />
        </swak:dataTable>

        <%-- onClickEvents --%>
        <swak:group id="onClickEvents">
          <swak:item id="baseClickRowNo" />
          <swak:item id="kakuteiBtn" />
        </swak:group>

        <%-- resultDetailList --%>
        <swak:dataTable id="resultDetailList">
          <swak:column id="baseFieldNm" />
          <swak:column id="baseFieldValue" />
        </swak:dataTable>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
