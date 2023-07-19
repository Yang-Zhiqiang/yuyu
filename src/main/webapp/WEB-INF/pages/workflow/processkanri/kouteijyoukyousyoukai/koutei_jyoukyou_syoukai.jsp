<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：工程状況照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/kouteijyoukyousyoukai/KouteiJyoukyouSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- SearchKeyInput --%>
        <swak:group id="SearchKeyInput">
          <swak:item id="subSystemId" />
          <swak:item id="jimutetuzukicd" />
          <swak:item id="subflowincludeCheckBox" />
          <swak:item id="IDF1002" />
          <swak:item id="tskid" />
          <swak:item id="mosno" />
          <swak:item id="syono" />
          <swak:item id="nksysyno" />
          <swak:item id="srchjimustartymdfrom" />
          <swak:item id="srchjimustartymdto" />
          <swak:item id="srchKouteikanStartYmdFrom" />
          <swak:item id="srchKouteikanStartYmdTo" />
          <swak:item id="srchLastkosStartYmdFrom" />
          <swak:item id="srchLastkosStartYmdTo" />
          <swak:item id="kouteikanristatus" />
          <swak:item id="jimuyoucd" />
          <swak:item id="commonCheckBox" />
        </swak:group>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- taskuserInfo --%>
        <swak:dataTable id="taskuserInfo">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispGyoumuKey" />
          <swak:column id="hyoujiYmdFrom" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="hyoujiYmdTo" />
          <swak:column id="dispkouteikanristatus" />
          <swak:column id="disptasknm" />
          <swak:column id="dispnowsyoritantounm" />
          <swak:column id="syousaiLink" />
        </swak:dataTable>
        <swak:pager id="taskuserInfoDataSource" />

        <%-- keyInfoInput --%>
        <swak:group id="keyInfoInput">
          <swak:item id="dispGyoumuKey" />
          <swak:item id="dispjimutetuzukinm" />
          <swak:item id="dispkouteikanristatus" />
          <swak:item id="disptasknm" />
          <swak:item id="dispnowsyoritantounm" />
        </swak:group>

        <%-- resultInfo --%>
        <swak:dataTable id="resultInfo">
          <swak:column id="syoriTime" />
          <swak:column id="dispTskkinousyousaiNm" />
          <swak:column id="syorikekkakbn" />
          <swak:column id="disptantounm" />
          <swak:column id="dispRirekiMsg" />
        </swak:dataTable>
        <swak:pager id="resultInfoDataSource" />

        <%-- lastButtons --%>
        <swak:buttonGroup id="lastButtons">
          <swak:item id="modoruBtnByResult" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
