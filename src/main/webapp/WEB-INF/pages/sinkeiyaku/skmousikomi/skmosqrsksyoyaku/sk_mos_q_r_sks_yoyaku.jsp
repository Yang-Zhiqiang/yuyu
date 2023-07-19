<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：申込書類用QR作成予約
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skmousikomi/skmosqrsksyoyaku/SkMosQRSksYoyaku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- inputyoyakuInfo --%>
        <swak:group id="inputyoyakuInfo">
          <swak:item id="skeijimukbn" />
          <swak:item id="hknsyuruinm" />
          <swak:item id="mosnosaibankbn" />
          <swak:item id="sakuseikensuu" />
        </swak:group>

        <%-- listHaneiButtons --%>
        <swak:buttonGroup id="listHaneiButtons">
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- ●予約一覧 --%>
        <swak:dataTable id="yoyakuInfoList">
          <swak:column id="disptrkymd" />
          <swak:column id="dispqryoyakutime" />
          <swak:column id="dispskeijimukbn" />
          <swak:column id="disphknsyuruino" />
          <swak:column id="dispmosnosaibankbn" />
          <swak:column id="dispsakuseikensuu" />
          <swak:column id="sakujyoLink" />
        </swak:dataTable>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
