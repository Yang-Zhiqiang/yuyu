<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：検証用レートＤＢ照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/biz/bzkyoutuusyoukai/bzkensyouyouratedbsyoukai/BzKensyouyouRatedbsyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ratekeyNyuuryokuGroup --%>
        <swak:group id="ratekeyNyuuryokuGroup">
          <swak:item id="ratesyoukaikbn" />
          <swak:item id="disppalhokensyuruikigou" />
          <swak:item id="suurikykymd" />
          <swak:item id="IBF1003" />
          <swak:item id="disphksyuruikigousedaikbn" />
          <swak:item id="IBF1004" />
          <swak:item id="dispyoteiriritu" />
          <swak:item id="IBF1005" />
          <swak:item id="hhknnen" />
          <swak:item id="suurihhknsei" />
          <swak:item id="palsaimankikykhyoujikbn" />
          <swak:item id="hknkkn" />
          <swak:item id="hrkkkn" />
          <swak:item id="dispharaikomikaisuukbn" />
          <swak:item id="disppalpmenkbn" />
          <swak:item id="disppalannaihuyouriyuukbn" />
          <swak:item id="IBF1012" />
          <swak:item id="dispratetuukasyukbn" />
          <swak:item id="IBF1012" />
          <swak:item id="dai1hknkkn" />
          <swak:item id="IBF1012" />
          <swak:item id="disppalryouritukbn" />
          <swak:item id="IBF1013" />
          <swak:item id="dispdnendo" />
          <swak:item id="IBF1006" />
          <swak:item id="dispdratenaiteikakuteikbn" />
          <swak:item id="IBF1006" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="syoukaibtnbyinputkey" />
          <swak:item id="modorubtnbyresultrate" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
