<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ＤＳメール送信履歴照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/direct/dssyoukai/dsmailsousinrirekisyoukai/DsMailSousinRirekiSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchjyoukenInfo --%>
        <swak:group id="searchjyoukenInfo">
          <swak:item id="srchdskokno" />
          <swak:item id="srchsyono" />
          <swak:item id="dsgaitoukokyakukensaku" />
          <swak:item id="srchdssousinno" />
          <swak:item id="dssousinmailsyubetukbn" />
          <swak:item id="sousinymdfrom" />
          <swak:item id="IAW0003" />
          <swak:item id="sousinymdto" />
        </swak:group>

        <%-- headerButtons1 --%>
        <swak:buttonGroup id="headerButtons1">
          <swak:item id="searchbtnbyinputkeyselect" />
          <swak:item id="clearbtnbyinputkeyselect" />
        </swak:buttonGroup>

        <%-- ●検索結果 --%>
        <swak:dataTable id="searchResultInfo">
          <swak:column id="dsdatasakuseiymd" />
          <swak:column id="dskokno" />
          <swak:column id="syono" />
          <swak:column id="dssousinmailsyubetukbn" />
          <swak:column id="haisinjidsmailaddress" />
          <swak:column id="haisinerrorcount" />
          <swak:column id="dssousinno" />
        </swak:dataTable>
        <swak:pager id="searchResultInfoDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
