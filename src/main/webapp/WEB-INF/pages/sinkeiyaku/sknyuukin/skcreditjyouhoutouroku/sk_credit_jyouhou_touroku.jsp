<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：クレジットカード情報登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sknyuukin/skcreditjyouhoutouroku/SkCreditJyouhouTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- buttonHubisyousai --%>
        <swak:group id="buttonHubisyousai">
          <swak:item id="hubisyousaibtn" />
        </swak:group>

        <%-- kihonInfo --%>
        <swak:group id="kihonInfo">
          <swak:item id="mosno" />
          <swak:item id="creditinfotrkugmsyorikbn" />
          <swak:item id="authorikakymd" />
          <swak:item id="cardbrandkbn" />
          <swak:item id="dispcreditkessaiyouno" />
          <swak:item id="credittrkjkkbn" />
          <swak:item id="creditkessaiyouno1" />
          <swak:item id="IHF1020" />
          <swak:item id="creditkessaiyouno2" />
          <swak:item id="IHF1021" />
          <swak:item id="creditkessaiyouno3" />
          <swak:item id="IHF1022" />
          <swak:item id="creditkessaiyouno4" />
          <swak:item id="IHF1023" />
          <swak:item id="creditkessaiyouno5" />
          <swak:item id="IHF1024" />
          <swak:item id="creditkessaiyouno6" />
          <swak:item id="IHF1025" />
        </swak:group>

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="uniqueId" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="tourokuBtn" />
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruinputbtnbyconfirm" />
          <swak:item id="modorukeybtnbyconfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
