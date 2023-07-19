<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ユーザーグループ登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/usergrouptouroku/UserGroupTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- userGroupInfo --%>
        <swak:group id="userGroupInfo">
          <swak:item id="userGroup.userGroupCd" />
          <swak:item id="userGroup.userGroupNm" />
          <swak:item id="userGroup.userGroupSetumei" />
        </swak:group>

        <%-- buttonInputKey --%>
        <swak:buttonGroup id="buttonInputKey">
          <swak:item id="tourokuBtn" />
          <swak:item id="henkouBtn" />
          <swak:item id="sakujyoBtn" />
        </swak:buttonGroup>

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
