<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：代理店個別情報登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skmaster/skdairitenkobetujyouhoutouroku/SkDairitenKobetuJyouhouTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- IBA0001 --%>

        <swak:message id = "IBA0001" />


        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="drtencd" />
          <swak:item id="bankcd" />
          <swak:item id="oyadrtennm" />
        </swak:group>

        <%-- dairitenKobetuInfo1 --%>
        <swak:group id="dairitenKobetuInfo1">
          <swak:item id="drtenRnrkhouKbn" />
          <swak:item id="utdskknnm1kj" />
          <swak:item id="utdskknnm2kj" />
        </swak:group>

        <%-- dairitenKobetuInfo2 --%>
        <swak:group id="dairitenKobetuInfo2">
          <swak:item id="nykntratkikbn" />
          <swak:item id="trksskssouhukbn" />
          <swak:item id="tkhjnkinyuucd" />
          <swak:item id="IHF1004" />
        </swak:group>

        <%-- ●ＣＩＦコード情報 --%>
        <swak:group id="cifcdInfo">
          <swak:item id="cifcdcheckyouhi" />
          <swak:item id="cifcdsiteiketasuu" />
          <swak:item id="cifcdmaezeroumeyouhi" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="tourokuBtn" />
          <swak:item id="henkouBtn" />
          <swak:item id="sakujyoBtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
