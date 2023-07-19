<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約保全オンライン処理件数照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khonlinekensuusyoukai/KhOnlineKensuuSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- syoriYmdInfo --%>
        <swak:group id="syoriYmdInfo">
          <swak:item id="syoriYmd" />
        </swak:group>

        <%-- syoriKensuuList --%>
        <swak:dataTable id="syoriKensuuList">
          <swak:column id="dispkinounm" />
          <swak:column id="dispkensuu" />
        </swak:dataTable>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="syoukaibtn" />
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
