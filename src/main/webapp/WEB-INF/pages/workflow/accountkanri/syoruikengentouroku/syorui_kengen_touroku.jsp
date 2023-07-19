<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：書類権限登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/accountkanri/syoruikengentouroku/SyoruiKengenTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- SearchKeyInput --%>
        <swak:group id="SearchKeyInput">
          <swak:item id="roleCd" />
          <swak:item id="subSystemId" />
          <swak:item id="disproleSetumei" />
        </swak:group>

        <%-- syoruiInfo --%>
        <swak:dataTable id="syoruiInfo">
          <swak:column id="dispsubsystemnm" />
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispsyoruinm" />
          <swak:column id="commonCheckBox" />
        </swak:dataTable>

        <%-- buttonSelect --%>
        <swak:buttonGroup id="buttonSelect">
          <swak:item id="allCheckBtn" />
          <swak:item id="allUnCheckBtn" />
        </swak:buttonGroup>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="ketteiBtn" />
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
