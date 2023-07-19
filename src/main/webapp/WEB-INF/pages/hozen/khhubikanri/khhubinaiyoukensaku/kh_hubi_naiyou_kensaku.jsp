<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約保全不備内容検索
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khhubikanri/khhubinaiyoukensaku/KhHubiNaiyouKensaku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- inputGroup --%>
        <swak:group id="inputGroup">
          <swak:item id="jimuttdknm" />
          <swak:item id="dispsyoruinmsntk" />
          <swak:item id="hassinsakikbn" />
          <swak:item id="kensakuyougenponhnkykumu" />
          <swak:item id="khhubinaiyou" />
          <swak:item id="IBA1007" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- fubinaiyouList --%>
        <swak:dataTable id="fubinaiyouList">
          <swak:column id="dispkhhubinaiyou" />
          <swak:column id="disphassinsakikbn" />
          <swak:column id="dispgenponhnkykumu" />
          <swak:column id="disphubinaiyoumsg" />
          <swak:column id="sentakulink" />
          <swak:column id="syoruiCd" />
          <swak:column id="syoruinm" />
          <swak:column id="hubinaiyoucd" />
          <swak:column id="dispgenponhnkykumuchkbox" />
        </swak:dataTable>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
