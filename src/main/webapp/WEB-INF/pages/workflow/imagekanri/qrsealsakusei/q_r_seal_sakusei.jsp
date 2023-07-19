<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：QRシール用紙作成
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/imagekanri/qrsealsakusei/QRSealSakusei.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- inputConditionInfo --%>
        <swak:group id="inputConditionInfo">
          <swak:item id="dispsubsystemnm" />
          <swak:item id="dispjimutetuzukinm" />
          <swak:item id="outkeisikikbn" />
          <swak:item id="syuturyokukaisigyoukbn" />
        </swak:group>

        <%-- inputButton --%>
        <swak:buttonGroup id="inputButton">
          <swak:item id="ketteiBtn" />
        </swak:buttonGroup>

        <%-- inputContentsInfo1 --%>
        <swak:group id="inputContentsInfo1">
          <swak:item id="skeijimukbn" />
          <swak:item id="disphknsyuruinoqrseal" />
          <swak:item id="outkensuu" />
        </swak:group>

        <%-- inputContentsInfo2 --%>
        <swak:dataTable id="inputContentsInfo2">
          <swak:column id="mosno1" />
          <swak:column id="mosno2" />
          <swak:column id="mosno3" />
        </swak:dataTable>

        <%-- inputContentsInfo3 --%>
        <swak:dataTable id="inputContentsInfo3">
          <swak:column id="mosno" />
          <swak:column id="torikomiSyoruiCd" />
          <swak:column id="sakujyoLink" />
        </swak:dataTable>

        <%-- inputContentsInfo4 --%>
        <swak:dataTable id="inputContentsInfo4">
          <swak:column id="mosno" />
          <swak:column id="torikomiSyoruiCd" />
          <swak:column id="sakujyoLink" />
        </swak:dataTable>

        <%-- addButton --%>
        <swak:buttonGroup id="addButton">
          <swak:item id="addbtn" />
        </swak:buttonGroup>

        <%-- buttonInputContents --%>
        <swak:buttonGroup id="buttonInputContents">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuninBtn" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="torikomiyouhyousisakuseiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
