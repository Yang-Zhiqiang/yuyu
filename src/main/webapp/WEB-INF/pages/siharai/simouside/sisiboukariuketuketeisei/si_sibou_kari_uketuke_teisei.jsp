<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：死亡仮受付訂正
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/simouside/sisiboukariuketuketeisei/SiSibouKariUketukeTeisei.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- 基本情報 --%>
        <swak:group id="kihonInfo">
          <swak:item id="syono" />
        </swak:group>

        <%-- ●契約者情報 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="kyknmkn" />
          <swak:item id="kyknmkj" />
          <swak:item id="kykseiymd" />
          <swak:item id="kyksei" />
        </swak:group>

        <%-- ●被保険者情報 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
          <swak:item id="hhknseiymd" />
          <swak:item id="hhknsei" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo">
          <swak:item id="sbuktnin" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo1">
          <swak:item id="dispsbuktkbn1" />
          <swak:item id="dispsbuktnmkn1" />
          <swak:item id="dispsbuktnmkj1" />
          <swak:item id="dispsbuktseiymd1" />
          <swak:item id="dispmskmjskjuktnen1" />
          <swak:item id="dispsbuktbnwari1" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo2">
          <swak:item id="dispsbuktkbn2" />
          <swak:item id="dispsbuktnmkn2" />
          <swak:item id="dispsbuktnmkj2" />
          <swak:item id="dispsbuktseiymd2" />
          <swak:item id="dispmskmjskjuktnen2" />
          <swak:item id="dispsbuktbnwari2" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo3">
          <swak:item id="dispsbuktkbn3" />
          <swak:item id="dispsbuktnmkn3" />
          <swak:item id="dispsbuktnmkj3" />
          <swak:item id="dispsbuktseiymd3" />
          <swak:item id="dispmskmjskjuktnen3" />
          <swak:item id="dispsbuktbnwari3" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo4">
          <swak:item id="dispsbuktkbn4" />
          <swak:item id="dispsbuktnmkn4" />
          <swak:item id="dispsbuktnmkj4" />
          <swak:item id="dispsbuktseiymd4" />
          <swak:item id="dispmskmjskjuktnen4" />
          <swak:item id="dispsbuktbnwari4" />
        </swak:group>

        <%-- ●申出情報（訂正前） --%>
        <swak:group id="mousideInfoTeiseimae">
          <swak:item id="bfrsibouymd" />
          <swak:item id="bfrgeninkbn" />
          <swak:item id="bfrtntnm" />
        </swak:group>

        <%-- ●申出情報（訂正後） --%>
        <swak:group id="mousideInfoTeiseigo">
          <swak:item id="sibouymd" />
          <swak:item id="geninkbn" />
          <swak:item id="tntnm" />
        </swak:group>

        <%-- ●別契約情報 --%>
        <swak:dataTable id="betukykInfo">
          <swak:column id="btkyksyono" />
          <swak:column id="syscdkbn" />
          <swak:column id="betukutikeiyakukbn" />
          <swak:column id="kankeisyakbnname" />
          <swak:column id="syoumetuymd" />
          <swak:column id="syoumetujiyuuname" />
          <swak:column id="syouhnnm" />
        </swak:dataTable>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="ketteiBtn" />
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
