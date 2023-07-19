<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：担当者割当解除
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/wariatekaijyo/WariateKaijyo.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="subSystemId" />
          <swak:item id="jimutetuzukicd" />
          <swak:item id="workflowTskNm" />
          <swak:item id="tantid" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- taskserInfo --%>
        <swak:dataTable id="taskserInfo">
          <swak:column id="dispjimustartymd" />
          <swak:column id="disptasknm" />
          <swak:column id="disptantounm" />
          <swak:column id="dispGyoumuKey" />
          <swak:column id="wariateKaijyoLink" />
        </swak:dataTable>
        <swak:pager id="taskserInfoDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
