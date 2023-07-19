<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ユーザー検索（ロール表示用）
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/userkensakurolehyouji/UserKensakuRoleHyouji.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="userId" />
          <swak:item id="userNm" />
          <swak:item id="srchsosikicd" />
        </swak:group>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- userAndUserRoleInfo --%>
        <swak:dataTable id="userAndUserRoleInfo">
          <swak:column id="userId" />
          <swak:column id="userNm" />
          <swak:column id="roleCd" />
          <swak:column id="roleNm" />
        </swak:dataTable>
        <swak:pager id="userAndUserRoleInfoDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
