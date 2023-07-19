<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：送付案内作成
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khsouhuannaisakusei/KhSouhuannaiSakusei.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="syono" />
        </swak:group>

        <%-- ●送付先名 --%>
        <swak:group id="souhusakimei">
          <swak:item id="shsnmkj" />
        </swak:group>

        <%-- ●送付先住所情報 --%>
        <swak:group id="souhusakiJyuusyoInfo">
          <swak:item id="shskyno" />
          <swak:item id="shsadr1kj" />
          <swak:item id="shsadr2kj" />
          <swak:item id="shsadr3kj" />
        </swak:group>

        <%-- ●送付案内印字内容 --%>
        <swak:group id="souhuAnnaiInjiNaiyou">
          <swak:item id="hanyoushannaityouhyounm" />
          <swak:item id="hanyoushannaiinjinaiyou" />
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
