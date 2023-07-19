<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：備金確定日変更
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sikessan/sibknkktymdhenkou/SiBknKktymdHenkou.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- 基本情報 --%>
        <swak:group id="kihonInfo">
          <swak:item id="syono" />
          <swak:item id="skno" />
        </swak:group>

        <%-- ●契約者情報 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="kyknmkn" />
          <swak:item id="kyknmkj" />
          <swak:item id="kykseiymd" />
          <swak:item id="kyksei" />
        </swak:group>

        <%-- ●被保険者情報 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
          <swak:item id="hhknseiymd" />
          <swak:item id="hhknsei" />
        </swak:group>

        <%-- ●備金情報（変更前） --%>
        <swak:group id="bikouInfoBefore">
          <swak:item id="siboukaritrkymd" />
        </swak:group>

        <%-- ●備金情報（変更後） --%>
        <swak:group id="bikouInfoAfter">
          <swak:item id="bknkktymd" />
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
