<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：帳票出力権限登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/biz/bzmaster/bztyouhyousyuturyokukengen/BzTyouhyouSyuturyokuKengen.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="roleCd" />
          <swak:item id="roleNm" />
          <swak:item id="subSystemId" />
        </swak:group>

        <%-- tyouhyouList --%>
        <swak:dataTable id="tyouhyouList">
          <swak:column id="dispsubsystemnm" />
          <swak:column id="dispsyoruinm" />
          <swak:column id="dispikkatuoutputchkbox" />
          <swak:column id="dispkobetuoutputchkbox" />
        </swak:dataTable>

        <%-- checkButtons --%>
        <swak:buttonGroup id="checkButtons">
          <swak:item id="allCheckBtn" />
          <swak:item id="allUnCheckBtn" />
        </swak:buttonGroup>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="kousinBtn" />
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
