<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：工程開始登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/kouteikaisitouroku/KouteiKaisiTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- torokuInfo1 --%>
        <swak:dataTable id="torokuInfo1">
          <swak:column id="dispno" />
          <swak:column id="workflowDocumentId" />
        </swak:dataTable>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- torokuInfo2 --%>
        <swak:dataTable id="torokuInfo2">
          <swak:column id="dispno" />
          <swak:column id="workflowDispDocumentId" />
          <swak:column id="dispsyoruinmryaku" />
        </swak:dataTable>

        <%-- lastButtons --%>
        <swak:buttonGroup id="lastButtons">
          <swak:item id="modorubtn" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
