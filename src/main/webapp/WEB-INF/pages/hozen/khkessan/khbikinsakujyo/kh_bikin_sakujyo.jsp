<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約保全備金削除
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khkessan/khbikinsakujyo/KhBikinSakujyo.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- baseInfo --%>
        <swak:group id="baseInfo">
          <swak:item id="syono" />
          <swak:item id="bkncdkbn" />
          <swak:item id="bknkktymd" />
          <swak:item id="bknsyorikbn" />
          <swak:item id="kessankijyunymd" />
        </swak:group>

        <%-- ●備金情報 --%>
        <swak:group id="bikinInfo">
          <swak:item id="bknrigikbn" />
          <swak:item id="bkngk" />
          <swak:item id="calckijyunymd" />
          <swak:item id="kbnkeirisegcd" />
          <swak:item id="syouhncd" />
          <swak:item id="shrsyoriymd" />
          <swak:item id="tyakkinymd" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="ketteiBtn" />
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
