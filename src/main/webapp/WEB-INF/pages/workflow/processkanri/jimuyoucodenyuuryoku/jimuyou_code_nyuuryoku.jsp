<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：事務用コード入力
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/jimuyoucodenyuuryoku/JimuyouCodeNyuuryoku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="subSystemId" />
          <swak:item id="jimutetuzukicd" />
        </swak:group>

        <%-- ketteiButtons --%>
        <swak:buttonGroup id="ketteiButtons">
          <swak:item id="ketteiBtn" />
        </swak:buttonGroup>

        <%-- jimuyouCodeList --%>
        <swak:dataTable id="jimuyouCodeList">
          <swak:column id="mosno" />
          <swak:column id="syono" />
          <swak:column id="nksysyno" />
          <swak:column id="jimuyoucd" />
        </swak:dataTable>

        <%-- jimuyouCodeList2 --%>
        <swak:dataTable id="jimuyouCodeList2">
          <swak:column id="dispGyoumuKey" />
          <swak:column id="dispjimuyoucd" />
          <swak:column id="disphnkmaejimuyoucd" />
        </swak:dataTable>

        <%-- buttonInputContents --%>
        <swak:buttonGroup id="buttonInputContents">
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- buttonInputContents2 --%>
        <swak:buttonGroup id="buttonInputContents2">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- buttonInputContents3 --%>
        <swak:buttonGroup id="buttonInputContents3">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
