<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：メニュー
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/menu/menu/Menu.do">

        <%-- 通知メッセージ --%>

        <swak:include id="info-msg-area.jsp" />


        <%-- マイメニュー --%>
        <swak:dataTable id="myMenuContents">
          <swak:column id="kinouId" />
        </swak:dataTable>

        <%-- メニュー --%>
        <swak:dataTable id="menuContents">
          <swak:column id="commonCheckBox" />
          <swak:column id="subSystemId" />
          <swak:column id="subSystemNm" />
          <swak:column id="categoryId" />
          <swak:column id="categoryNm" />
          <swak:column id="kinouId" />
          <swak:column id="kinouNm" />
          <swak:column id="jikkouPath" />
        </swak:dataTable>

        <%-- フッターボタン --%>
        <swak:buttonGroup id="menuFooterButtons">
          <swak:item id="tojiruBtn" />
          <swak:item id="myMenuTourokuBtn" />
        </swak:buttonGroup>

        <%-- マイメニュー登録用ボタン --%>
        <swak:buttonGroup id="myMenuTourokuButtons">
          <swak:item id="torikesiBtn" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
