<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：操作履歴照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/direct/dssyoukai/dssousarirekisyoukai/DsSousaRirekiSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●検索条件 --%>
        <swak:group id="kensakuzyouken">
          <swak:item id="ttdkymdfrom" />
          <swak:item id="IAW0003" />
          <swak:item id="ttdkymdto" />
          <swak:item id="ttdkstarttimefrom" />
          <swak:item id="IAW0003" />
          <swak:item id="ttdkstarttimeto" />
          <swak:item id="syono" />
          <swak:item id="syonomisetteikensaku" />
          <swak:item id="sousarirekijkkbn" />
          <swak:item id="sousarirekikekkakbn" />
        </swak:group>

        <%-- headerButtons1 --%>
        <swak:buttonGroup id="headerButtons1">
          <swak:item id="searchbtnbyinputkeyselect" />
          <swak:item id="clearbtnbyinputkeyselect" />
        </swak:buttonGroup>

        <%-- ●検索結果 --%>
        <swak:dataTable id="kensakukekka">
          <swak:column id="ttdkstartymd" />
          <swak:column id="ttdkstarttime" />
          <swak:column id="ttdkendymd" />
          <swak:column id="ttdkendtime" />
          <swak:column id="dispsyono" />
          <swak:column id="ttdkkinoukbn" />
          <swak:column id="dispsousarirekijkkbn" />
          <swak:column id="dispsousarirekikekkakbn" />
          <swak:column id="syousaiLink" />
        </swak:dataTable>
        <swak:pager id="kensakukekkaDataSource" />

        <%-- ●操作履歴詳細情報 --%>
        <swak:dataTable id="sousarirekisyousaiInfo">
          <swak:column id="syorinaiyoukbn" />
          <swak:column id="syoriendymd" />
          <swak:column id="syoriendtime" />
          <swak:column id="syorisyousai" />
        </swak:dataTable>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
