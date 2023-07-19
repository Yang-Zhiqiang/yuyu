<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約保全索引名番号修正
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khnayose/khsakuinnmnosyuusei/KhSakuinnmnoSyuusei.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- inputGroup --%>
        <swak:group id="inputGroup">
          <swak:item id="syono" />
          <swak:item id="syuuseitaisyoukbn" />
          <swak:item id="taisyoudouituhyouji" />
        </swak:group>

        <%-- ●対象者情報 --%>
        <swak:group id="taisyousyainfoGroup">
          <swak:item id="taisyounmkn" />
          <swak:item id="taisyounmkj" />
          <swak:item id="taisyouseiymd" />
          <swak:item id="taisyousakuinnmno" />
        </swak:group>

        <%-- syuuseigosakuinnmnoGroup --%>
        <swak:group id="syuuseigosakuinnmnoGroup">
          <swak:item id="syuuseigosakuinnmno" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
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
