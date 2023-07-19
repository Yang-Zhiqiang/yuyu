<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ユーザーグループ検索
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/usergroupkensaku/UserGroupKensaku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="userGroupCd" />
          <swak:item id="userGroupNm" />
        </swak:group>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- userGroupInfo --%>
        <swak:dataTable id="userGroupInfo">
          <swak:column id="userGroupCd" />
          <swak:column id="userGroupNm" />
        </swak:dataTable>
        <swak:pager id="userGroupInfoDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
