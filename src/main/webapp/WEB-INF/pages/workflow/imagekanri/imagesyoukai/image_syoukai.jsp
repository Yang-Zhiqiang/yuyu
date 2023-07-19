<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：イメージ照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/imagekanri/imagesyoukai/ImageSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchInfo --%>
        <swak:group id="searchInfo">
          <swak:item id="subSystemId" />
          <swak:item id="jimutetuzukicd" />
          <swak:item id="mosno" />
          <swak:item id="syono" />
          <swak:item id="nksysyno" />
          <swak:item id="torikomiSyoruiCd" />
          <swak:item id="kouteikanristatus" />
          <swak:item id="syoruittykymdfrom" />
          <swak:item id="syoruittykymdto" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- ankenList --%>
        <swak:dataTable id="ankenList">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispGyoumuKey" />
          <swak:column id="dispsyoruinm" />
          <swak:column id="dispkouteikanristatus" />
          <swak:column id="syoruittykymdtime" />
          <swak:column id="hyoujilink" />
        </swak:dataTable>
        <swak:pager id="ankenListDataSource" />

        <%-- hiddeninfo --%>
        <swak:group id="hiddeninfo">
          <swak:item id="selectindex" />
          <swak:item id="tyouhyouSyuturyokuLink" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
