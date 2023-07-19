<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：イメージ取込
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/imagekanri/imagetorikomi/ImageTorikomi.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="subSystemId" />
          <swak:item id="jimutetuzukicd" />
          <swak:item id="syono" />
          <swak:item id="nksysyno" />
          <swak:item id="srchjimustartymdfrom" />
          <swak:item id="srchjimustartymdto" />
          <swak:item id="kouteikanristatus" />
          <swak:item id="jimuyoucd" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- ankenList --%>
        <swak:dataTable id="ankenList">
          <swak:column id="dispGyoumuKey" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="dispkouteikaisiymd" />
          <swak:column id="dispkouteikanristatus" />
          <swak:column id="disptasknm" />
          <swak:column id="jimuyoucd" />
          <swak:column id="disptantounm" />
          <swak:column id="syousaiLink" />
        </swak:dataTable>
        <swak:pager id="ankenListDataSource" />

        <%-- ankenList2 --%>
        <swak:dataTable id="ankenList2">
          <swak:column id="dispGyoumuKey" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="dispkouteikaisiymd" />
          <swak:column id="dispkouteikanristatus" />
          <swak:column id="disptasknm" />
          <swak:column id="jimuyoucd" />
          <swak:column id="disptantounm" />
          <swak:column id="syousaiLink" />
        </swak:dataTable>

        <%-- syoruiInfo01 --%>
        <swak:dataTable id="syoruiInfo01">
          <swak:column id="dispsyoruinm" />
          <swak:column id="syoruittykymdtime" />
          <swak:column id="userNm" />
          <swak:column id="hyoujilink" />
          <swak:column id="torikomiLink" />
        </swak:dataTable>

        <%-- syoruiInfo02 --%>
        <swak:dataTable id="syoruiInfo02">
          <swak:column id="dispsyoruinm" />
          <swak:column id="fileNm" />
        </swak:dataTable>

        <%-- buttonInputContents --%>
        <swak:buttonGroup id="buttonInputContents">
          <swak:item id="modoruBtnByInputCondition" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

        <%-- hiddeninfo --%>
        <swak:group id="hiddeninfo">
          <swak:item id="selectindex" />
          <swak:item id="tyouhyouSyuturyokuLink" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
