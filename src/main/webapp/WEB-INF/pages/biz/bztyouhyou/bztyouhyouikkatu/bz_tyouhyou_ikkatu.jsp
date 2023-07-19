<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：帳票一括出力
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/biz/bztyouhyou/bztyouhyouikkatu/BzTyouhyouIkkatu.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="subSystemId" />
          <swak:item id="tyouhyousakuseiymd" />
          <swak:item id="syoruinm" />
          <swak:item id="misyuturyokukensuu" />
          <swak:item id="sakuseisoukensuu" />
        </swak:group>

        <%-- searchResultList --%>
        <swak:dataTable id="searchResultList">
          <swak:column id="dispsyoruinm" />
          <swak:column id="dispmisyuturyokukensuu" />
          <swak:column id="dispsakuseisoukensuu" />
        </swak:dataTable>

        <%-- searchKeyList --%>
        <swak:dataTable id="searchKeyList">
          <swak:column id="knskkmknm1" />
          <swak:column id="knskkmknm2" />
          <swak:column id="knskkmknm3" />
          <swak:column id="knskkmknm4" />
          <swak:column id="knskkmknm5" />
        </swak:dataTable>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtnbykensaku" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="syokigamenheBtn" />
          <swak:item id="searchresulthemdrbtnbykekka" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
