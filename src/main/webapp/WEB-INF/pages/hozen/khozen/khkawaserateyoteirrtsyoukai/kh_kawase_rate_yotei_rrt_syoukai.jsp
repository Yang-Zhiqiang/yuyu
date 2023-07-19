<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：為替レート予定利率推移照会（平準払）
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khkawaserateyoteirrtsyoukai/KhKawaseRateYoteiRrtSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- 照会指定情報 --%>
        <swak:group id="referenceSiteiInfo">
          <swak:item id="syono" />
        </swak:group>

        <%-- referenceList --%>
        <swak:dataTable id="referenceList">
          <swak:column id="dispym" />
          <swak:column id="disphrkp" />
          <swak:column id="dispgaikaknsnkwsratekjymd" />
          <swak:column id="dispgaikaknsnkwsrate" />
          <swak:column id="dispkyktuukasyu" />
          <swak:column id="disppgaika" />
          <swak:column id="dispytirrtcalckijyunrrt" />
        </swak:dataTable>
        <swak:pager id="referenceListDataSource" />

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="syoukaibtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
