<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：特認処理
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skkettei/sktokunin/SkTokunin.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- buttonHubisyousai --%>
        <swak:group id="buttonHubisyousai">
          <swak:item id="hubisyousaibtn" />
        </swak:group>

        <%-- kihonInfo --%>
        <swak:group id="kihonInfo">
          <swak:item id="mosno" />
          <swak:item id="hhknnmkj" />
        </swak:group>

        <%-- tokuninInfo --%>
        <swak:group id="tokuninInfo">
          <swak:item id="spgndtknkbn" />
          <swak:item id="nenkkntknkbn" />
          <swak:item id="tsngndtknkbn" />
          <swak:item id="sentakuinfotknkbn" />
          <swak:item id="signalkaihikbn" />
          <swak:item id="kakoymdkyytknkbn" />
          <swak:item id="saiteiptknkbn" />
          <swak:item id="yoteiriritutknkbn" />
          <swak:item id="nenreiuptknkbn" />
          <swak:item id="kzmeigitknkbn" />
          <swak:item id="ikkatuyouptknkbn" />
          <swak:item id="sonotatknkbn" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="tourokuBtn" />
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="uniqueId" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
