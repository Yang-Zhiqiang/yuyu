<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：入金／返金状況確認
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sknyuukin/sknyuukinhenkinkakunin/SkNyuukinHenkinKakunin.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- baseInfo --%>
        <swak:group id="baseInfo">
          <swak:item id="nyuukinhenkinsyorikbn" />
          <swak:item id="syoriYmd" />
        </swak:group>

        <%-- ●合計 --%>
        <swak:dataTable id="goukeiInfo">
          <swak:column id="dispgkdtendt" />
          <swak:column id="disprstuukasyu" />
          <swak:column id="dispkensuu" />
          <swak:column id="disprskingaku" />
          <swak:column id="disprsdengkyen" />
        </swak:dataTable>

        <%-- ●明細 --%>
        <swak:dataTable id="nyuukinMeisai">
          <swak:column id="mosno" />
          <swak:column id="kyknmkn" />
          <swak:column id="gkdtendt" />
          <swak:column id="nyknsyubetu" />
          <swak:column id="ryosyuymd" />
          <swak:column id="rsgaku" />
          <swak:column id="denyenkagk" />
          <swak:column id="fstpryosyuymd" />
          <swak:column id="denkawaserate" />
          <swak:column id="seiritukbn" />
        </swak:dataTable>

        <%-- ●明細 --%>
        <swak:dataTable id="henkinMeisai">
          <swak:column id="mosno" />
          <swak:column id="kyknmkn" />
          <swak:column id="gkdtendt" />
          <swak:column id="hnknhoukbn" />
          <swak:column id="hnkngk" />
          <swak:column id="denyenkagk" />
          <swak:column id="fstpryosyuymd" />
          <swak:column id="denkawaserate" />
          <swak:column id="seiritukbn" />
        </swak:dataTable>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="syoukaibtnbyinputkey" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtnbysyoukai" />
          <swak:item id="syoukaibtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnBySyousai" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
