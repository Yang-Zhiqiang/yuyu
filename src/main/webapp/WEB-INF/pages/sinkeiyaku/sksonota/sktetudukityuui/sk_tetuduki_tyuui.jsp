<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：新契約手続注意設定
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sksonota/sktetudukityuui/SkTetudukiTyuui.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="mosno" />
        </swak:group>

        <%-- ●連絡情報 --%>
        <swak:group id="renrakuInfo">
          <swak:item id="skeittdkkinkyuyouhi" />
          <swak:item id="skeittdktyuuiyouhi" />
        </swak:group>

        <%-- ●新契約取扱注意情報 --%>
        <swak:dataTable id="toriatukaiTyuuiInfo">
          <swak:column id="skeittdktyuitrtnaiyo" />
          <swak:column id="disptratkityuuidel" />
          <swak:column id="linehyoujiflag" />
        </swak:dataTable>

        <%-- toriatukaiTyuuiButtons --%>
        <swak:buttonGroup id="toriatukaiTyuuiButtons">
          <swak:item id="addbtnbytoriatukaityuuiinfo" />
        </swak:buttonGroup>

        <%-- ●その他注意情報 --%>
        <swak:dataTable id="sonotaTyuuiInfo">
          <swak:column id="skeittdktyuistnaiyo" />
          <swak:column id="dispsttratkityuuidel" />
          <swak:column id="linehyoujiflag" />
        </swak:dataTable>

        <%-- sonotaTyuuiButtons --%>
        <swak:buttonGroup id="sonotaTyuuiButtons">
          <swak:item id="addbtnbysonotatyuuiinfo" />
        </swak:buttonGroup>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="tourokuBtn" />
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
