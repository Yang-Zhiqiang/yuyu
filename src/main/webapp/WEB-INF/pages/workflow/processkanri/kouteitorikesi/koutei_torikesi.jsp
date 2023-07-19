<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：工程取消
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/kouteitorikesi/KouteiTorikesi.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="subSystemId" />
          <swak:item id="jimutetuzukicd" />
          <swak:item id="syono" />
          <swak:item id="nksysyno" />
          <swak:item id="dispkouteikaisiymd" />
          <swak:item id="disptantounm" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- kouteiList --%>
        <swak:dataTable id="kouteiList">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispGyoumuKey" />
          <swak:column id="dispkouteikaisiymd" />
          <swak:column id="disptantounm" />
          <swak:column id="nyuuryokuLink" />
        </swak:dataTable>

        <%-- torikesiComment --%>
        <swak:group id="torikesiComment">
          <swak:item id="workflowTorikesiComment" />
        </swak:group>

        <%-- buttonInputContents --%>
        <swak:buttonGroup id="buttonInputContents">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- buttonInputContents2 --%>
        <swak:buttonGroup id="buttonInputContents2">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
