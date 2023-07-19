<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：強制ハンド決定入力
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skkettei/skkyouseihand/SkKyouseiHand.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- buttonHubisyousai --%>
        <swak:group id="buttonHubisyousai">
          <swak:item id="hubisyousaibtn" />
        </swak:group>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="mosno" />
          <swak:item id="hhknnmkj" />
        </swak:group>

        <%-- ●申込点検依頼 --%>
        <swak:group id="mosTenkenIrai">
          <swak:item id="mostenkenkekkakbn" />
          <swak:item id="mostenkentnsketsyacd" />
          <swak:item id="mostenkencommentgamen" />
        </swak:group>

        <%-- ●環境査定依頼 --%>
        <swak:group id="knkSateiIrai">
          <swak:item id="knksateikekkakbn" />
          <swak:item id="knktnsketsyacd" />
          <swak:item id="knksateiiraicomment" />
        </swak:group>

        <%-- ●医務査定依頼 --%>
        <swak:group id="imuSateiIrai">
          <swak:item id="imusateikekkakbn" />
          <swak:item id="imutnsketsyacd" />
          <swak:item id="imusateiiraicomment" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="tourokuBtn" />
          <swak:item id="modorubtn" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="uniqueId" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
