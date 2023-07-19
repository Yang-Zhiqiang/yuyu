<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ユーザー登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/usertouroku/UserTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfoInput --%>
        <swak:group id="keyInfoInput">
          <swak:item id="user.userId" />
          <swak:item id="user.userNm" />
        </swak:group>

        <%-- keyInfoConfirm --%>
        <swak:group id="keyInfoConfirm">
          <swak:item id="user.userId" />
          <swak:item id="user.userNm" />
        </swak:group>

        <%-- keyInfoSosikicdConfirm --%>
        <swak:group id="keyInfoSosikicdConfirm">
          <swak:item id="srchsosikicd" />
        </swak:group>

        <%-- buttonInputKey --%>
        <swak:buttonGroup id="buttonInputKey">
          <swak:item id="henkouBtn" />
        </swak:buttonGroup>

        <%-- buttonSearch --%>
        <swak:buttonGroup id="buttonSearch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- checkButtons --%>
        <swak:buttonGroup id="checkButtons">
          <swak:item id="allCheckBtn" />
          <swak:item id="allUnCheckBtn" />
        </swak:buttonGroup>

        <%-- ● ロール情報 --%>
        <swak:dataTable id="roleInfo">
          <swak:column id="commonCheckBox" />
          <swak:column id="roleCd" />
          <swak:column id="roleNm" />
          <swak:column id="roleSetumei" />
        </swak:dataTable>

        <%-- buttonInputContents --%>
        <swak:buttonGroup id="buttonInputContents">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuninBtn" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
