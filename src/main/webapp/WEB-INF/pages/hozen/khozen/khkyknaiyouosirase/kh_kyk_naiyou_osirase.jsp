<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ご契約内容のお知らせ
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khkyknaiyouosirase/KhKykNaiyouOsirase.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- 契約内容のお知らせ指定情報 --%>
        <swak:group id="kyknaiyouOsiraseSiteiInfo">
          <swak:item id="syono" />
        </swak:group>

        <%-- syoukaiButtons1 --%>
        <swak:buttonGroup id="syoukaiButtons1">
          <swak:item id="reportsksbtn" />
        </swak:buttonGroup>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
