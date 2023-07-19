<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：担当者別処理タスク照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/tantousyabetusyoritasksyoukai/TantousyabetuSyoriTaskSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchKeyInput --%>
        <swak:group id="searchKeyInput">
          <swak:item id="subSystemId" />
          <swak:item id="userId" />
          <swak:item id="userNm" />
          <swak:item id="syoriYmdFrom" />
          <swak:item id="syoriYmdTo" />
        </swak:group>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- taskserInfo --%>
        <swak:dataTable id="taskserInfo">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispGyoumuKey" />
          <swak:column id="dispsyoritime" />
          <swak:column id="disptasknm" />
          <swak:column id="disphknsyuruiworklist" />
          <swak:column id="disptratkiagnm1" />
          <swak:column id="dispkyknmkn" />
          <swak:column id="dispkyknmkj" />
        </swak:dataTable>
        <swak:pager id="taskserInfoDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
