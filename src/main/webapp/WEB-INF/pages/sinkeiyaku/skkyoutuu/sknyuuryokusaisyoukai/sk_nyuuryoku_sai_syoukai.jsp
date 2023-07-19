<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：入力差異照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skkyoutuu/sknyuuryokusaisyoukai/SkNyuuryokuSaiSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- mosNoInfo --%>
        <swak:group id="mosNoInfo">
          <swak:item id="mosno" />
          <swak:item id="aitemosno" />
        </swak:group>

        <%-- nyuuryokuSouiList --%>
        <swak:dataTable id="nyuuryokuSouiList">
          <swak:column id="dispnrksouikm" />
          <swak:column id="dispitijinrk" />
          <swak:column id="dispnijinrk" />
          <swak:column id="commonCheckBox" />
        </swak:dataTable>

        <%-- insatuYouComment --%>
        <swak:group id="insatuYouComment">
          <swak:item id="commentgamen" />
        </swak:group>

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="uniqueId" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
