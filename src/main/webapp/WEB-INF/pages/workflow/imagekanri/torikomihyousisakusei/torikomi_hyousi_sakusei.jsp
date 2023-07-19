<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：取込用表紙作成
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/imagekanri/torikomihyousisakusei/TorikomiHyousiSakusei.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="subSystemId" />
          <swak:item id="jimutetuzukicd" />
          <swak:item id="mosno" />
          <swak:item id="syono" />
          <swak:item id="nksysyno" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- ankenList --%>
        <swak:dataTable id="ankenList">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispkouteikanristatus" />
          <swak:column id="dispkouteikaisiymd" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="dispkouteikanymd" />
          <swak:column id="sakuseiLink" />
        </swak:dataTable>
        <swak:pager id="ankenListDataSource" />

        <%-- ankenList2 --%>
        <swak:dataTable id="ankenList2">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispkouteikanristatus" />
          <swak:column id="dispkouteikaisiymd" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="dispkouteikanymd" />
          <swak:column id="sakuseiLink" />
        </swak:dataTable>

        <%-- syoruiInfo --%>
        <swak:group id="syoruiInfo">
          <swak:item id="torikomiSyoruiCd" />
        </swak:group>

        <%-- buttonInputContents --%>
        <swak:buttonGroup id="buttonInputContents">
          <swak:item id="modoruBtnByInputCondition" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuninBtn" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
          <swak:item id="jyoukensiteigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
