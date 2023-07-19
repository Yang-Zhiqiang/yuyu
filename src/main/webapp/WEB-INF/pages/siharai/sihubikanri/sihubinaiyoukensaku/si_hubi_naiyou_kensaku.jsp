<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：保険金給付金不備内容検索
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sihubikanri/sihubinaiyoukensaku/SiHubiNaiyouKensaku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchConditions --%>
        <swak:group id="searchConditions">
          <swak:item id="dispjimutetuzukinm" />
          <swak:item id="dispsyoruinmsntk" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- hubinaiyouList --%>
        <swak:dataTable id="hubinaiyouList">
          <swak:column id="disphubinaiyou" />
          <swak:column id="disphubinaiyoumsg" />
          <swak:column id="syoruiCd" />
          <swak:column id="syoruinm" />
          <swak:column id="hubinaiyoucd" />
          <swak:column id="sentakulink" />
        </swak:dataTable>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
