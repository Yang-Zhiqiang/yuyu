<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：工程ロック強制解除
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/lockkyouseikaijyo/LockKyouseiKaijyo.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchConditions --%>
        <swak:group id="searchConditions">
          <swak:item id="subSystemId" />
          <swak:item id="jimutetuzukicd" />
          <swak:item id="mosno" />
          <swak:item id="syono" />
          <swak:item id="nksysyno" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- lockedTaskInfoList --%>
        <swak:dataTable id="lockedTaskInfoList">
          <swak:column id="dispGyoumuKey" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="disptasknm" />
          <swak:column id="disptantounm" />
          <swak:column id="lockKaijyoLink" />
        </swak:dataTable>
        <swak:pager id="lockedTaskInfoListDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
