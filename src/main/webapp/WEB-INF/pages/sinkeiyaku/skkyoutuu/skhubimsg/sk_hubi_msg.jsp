<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：不備メッセージ
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skkyoutuu/skhubimsg/SkHubiMsg.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- baseInfo --%>
        <swak:group id="baseInfo">
          <swak:item id="mosno" />
          <swak:item id="hhknnmkj" />
        </swak:group>

        <%-- ●決定保留不備 --%>
        <swak:dataTable id="ketteiHoryuuHubi">
          <swak:column id="msgsyubetu" />
          <swak:column id="disphubimsgid" />
          <swak:column id="disphubimsg" />
        </swak:dataTable>

        <%-- ●成立保留不備 --%>
        <swak:dataTable id="seirituHoryuuHubi">
          <swak:column id="msgsyubetu" />
          <swak:column id="disphubimsgid" />
          <swak:column id="disphubimsg" />
        </swak:dataTable>

        <%-- ●ワーニング --%>
        <swak:dataTable id="warning">
          <swak:column id="msgsyubetu" />
          <swak:column id="disphubimsgid" />
          <swak:column id="disphubimsg" />
        </swak:dataTable>

        <%-- ●基本不備 --%>
        <swak:dataTable id="kihonHubi">
          <swak:column id="msgsyubetu" />
          <swak:column id="disphubimsgid" />
          <swak:column id="disphubimsg" />
        </swak:dataTable>

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="uniqueId" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
