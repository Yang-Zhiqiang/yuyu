<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：手続履歴照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sisyoukai/sittzkrirekisyoukai/SiTtzkRirekiSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- headerButtons2 --%>
        <swak:buttonGroup id="headerButtons2">
          <swak:item id="syoukaibtn" />
        </swak:buttonGroup>

        <%-- searchConditions --%>
        <swak:group id="searchConditions">
          <swak:item id="srchsyono" />
          <swak:item id="srchhhknnmkn" />
          <swak:item id="srchsksyubetu" />
          <swak:item id="srchsyoruiukeymdfrom" />
          <swak:item id="IAW0002" />
          <swak:item id="srchsyoruiukeymdto" />
        </swak:group>

        <%-- searchResults --%>
        <swak:dataTable id="searchResults">
          <swak:column id="dispsyono" />
          <swak:column id="disphhknnmkn" />
          <swak:column id="disphhknnmkj" />
          <swak:column id="dispsksyubetu" />
          <swak:column id="dispsyoruiukeymd" />
        </swak:dataTable>
        <swak:pager id="searchResultsDataSource" />

        <%-- 基本情報 --%>
        <swak:group id="hktskKihonInfo">
          <swak:item id="syono" />
          <swak:item id="skno" />
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
          <swak:item id="uktnmkn" />
          <swak:item id="uktnmkj" />
          <swak:item id="seikyuusyubetu" />
          <swak:item id="syoruiukeymd" />
          <swak:item id="kouteikanriid" />
        </swak:group>

        <%-- ttzkRrkList --%>
        <swak:dataTable id="ttzkRrkList">
          <swak:column id="dispsyoriymd" />
          <swak:column id="dispsyorinm" />
          <swak:column id="syorikekka" />
          <swak:column id="disptantounm" />
          <swak:column id="dispcomment" />
          <swak:column id="syousaiLink" />
          <swak:column id="dispttdkrrkskbtkey" />
        </swak:dataTable>
        <swak:pager id="ttzkRrkListDataSource" />

        <%-- ●画面非表示項目 --%>
        <swak:group id="hiddenGroup">
          <swak:item id="dispttdkrrkskbtkey" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="searchBtn" />
          <swak:item id="modorubtnbykensaku" />
          <swak:item id="modorubtnbyttdkrrklist" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
