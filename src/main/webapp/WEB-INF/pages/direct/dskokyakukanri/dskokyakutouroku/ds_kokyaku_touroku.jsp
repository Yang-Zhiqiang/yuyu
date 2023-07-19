<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：顧客登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/direct/dskokyakukanri/dskokyakutouroku/DsKokyakuTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●基本情報 --%>
        <swak:group id="baseInfo">
          <swak:item id="syono" />
          <swak:item id="tougoumaedskokno" />
        </swak:group>

        <%-- ●保全情報 --%>
        <swak:group id="hozenInfo">
          <swak:item id="kyknmkj" />
          <swak:item id="kyknmkn" />
          <swak:item id="kykseiymd" />
          <swak:item id="tsinyno" />
        </swak:group>

        <%-- ●ＤＳ顧客情報 --%>
        <swak:group id="dskokInfo">
          <swak:item id="dskokyakunmkj" />
          <swak:item id="dskokyakunmkn" />
          <swak:item id="dskokyakuseiymd" />
          <swak:item id="dskokyakuyno" />
        </swak:group>

        <%-- ●処理選択 --%>
        <swak:group id="syorisenntaku">
          <swak:item id="dssyorikbn" />
        </swak:group>

        <%-- ●ＤＳ顧客状態 --%>
        <swak:group id="dskokyakujyoutai">
          <swak:item id="dskanyuukeirokbn" />
        </swak:group>

        <%-- ●顧客統合先 --%>
        <swak:group id="kokyakutougousaki">
          <swak:item id="tougousakidskokno" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="nyuuryokubtn" />
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
