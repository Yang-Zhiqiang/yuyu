<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：年金支払工程ワークリスト
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/nenkinworklist/NenkinWorkList.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- jimutetuzukiLabel --%>
        <swak:group id="jimutetuzukiLabel">
          <swak:item id="dispjimutetuzukinm" />
        </swak:group>

        <%-- searchKeyInput --%>
        <swak:group id="searchKeyInput">
          <swak:item id="jimutetuzukicd" />
          <swak:item id="jimuyoucd" />
          <swak:item id="jmycdMisetteiKbn" />
          <swak:item id="jimustartYmdFrom" />
          <swak:item id="jimustartYmdTo" />
          <swak:item id="nksysyno" />
        </swak:group>

        <%-- searchConditionBtn --%>
        <swak:buttonGroup id="searchConditionBtn">
          <swak:item id="clearbtn" />
          <swak:item id="joukenHozonBtn" />
          <swak:item id="saisetteiBtn" />
        </swak:buttonGroup>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- resultInfoTskSntkBase --%>
        <swak:dataTable id="resultInfoTskSntkBase">
          <swak:column id="jimutetuzukicd" />
        </swak:dataTable>

        <%-- resultInfoTskSntk --%>
        <swak:dataTable id="resultInfoTskSntk">
          <swak:column id="jimutetuzukicd" />
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="workflowTskNm" />
          <swak:column id="kjnTskKensuu" />
          <swak:column id="kojinNyuuryokuLink" />
          <swak:column id="kojinItiranLink" />
          <swak:column id="kyyTskKensuu" />
          <swak:column id="kyouyouNyuuryokuLink" />
          <swak:column id="kyouyouItiranLink" />
        </swak:dataTable>

        <%-- resultInfoItiran --%>
        <swak:dataTable id="resultInfoItiran">
          <swak:column id="dispjimustartymdtime" />
          <swak:column id="nksysyno" />
          <swak:column id="nenkinuktnmkanji" />
          <swak:column id="dispzenkaisyoritask" />
          <swak:column id="dispzenkaisyoritantounm" />
          <swak:column id="nyuuryokuLink" />
        </swak:dataTable>
        <swak:pager id="resultInfoItiranDataSource" />

        <%-- lastButtons --%>
        <swak:buttonGroup id="lastButtons">
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
