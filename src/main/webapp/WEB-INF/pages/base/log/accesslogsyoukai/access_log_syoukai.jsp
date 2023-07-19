<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：アクセスログ照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/log/accesslogsyoukai/AccessLogSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●検索条件 --%>
        <swak:group id="searchConditions">
          <swak:item id="subSystemId" />
          <swak:item id="categoryId" />
          <swak:item id="kinouKbn" />
          <swak:item id="kinouId" />
          <swak:item id="userId" />
          <swak:item id="ipAddress" />
          <swak:item id="syoriYmdFrom" />
          <swak:item id="syoriTimeFrom" />
          <swak:item id="syoriYmdTo" />
          <swak:item id="syoriTimeTo" />
          <swak:item id="logKindCd" />
          <swak:item id="sessionId" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- ●アクセスログ情報リスト --%>
        <swak:dataTable id="accessLogInfoList">
          <swak:column id="syoriTime" />
          <swak:column id="syoriUserId" />
          <swak:column id="userNm" />
          <swak:column id="logKindCd" />
          <swak:column id="ipAddress" />
          <swak:column id="sessionId" />
          <swak:column id="transactionId" />
          <swak:column id="subSystemNm" />
          <swak:column id="kinouNm" />
          <swak:column id="syousaiLink" />
          <swak:column id="logData" />
        </swak:dataTable>
        <swak:pager id="accessLogInfoListDataSource" />

        <%-- ●アクセスログ情報 --%>
        <swak:group id="accessLogInfo">
          <swak:item id="syoriTime" />
          <swak:item id="accessLog.syoriUserId" />
          <swak:item id="user.userNm" />
          <swak:item id="accessLog.logKindCd" />
          <swak:item id="accessLog.ipAddress" />
          <swak:item id="accessLog.transactionId" />
          <swak:item id="accessLog.sessionId" />
          <swak:item id="kinou.subSystem.subSystemNm" />
          <swak:item id="kinou.kinouNm" />
          <swak:item id="accessLog.logData" />
        </swak:group>

        <%-- ●アクセス詳細ログ情報 --%>
        <swak:dataTable id="accessDetailLogInfo">
          <swak:column id="syousaiEdaNo" />
          <swak:column id="logSyousaiData" />
        </swak:dataTable>
        <swak:pager id="accessDetailLogInfoDataSource" />

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="modoruBtnBySyousai" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
