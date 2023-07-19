<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：振込入金反映予約
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sknyuukin/skhurikominyuukinhaneiyoyaku/SkHurikomiNyuukinHaneiYoyaku.do" enctype="multipart/form-data">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- アップロードファイル情報 --%>
        <swak:group id="uploadfileInfo">
          <swak:item id="uploadfile" />
        </swak:group>

        <%-- ●一括入金額 --%>
        <swak:dataTable id="ikktnyknInfo">
          <swak:column id="ikktnykninfonyknoyadrtennm" />
          <swak:column id="ikktnykninfohrktuukasyu" />
          <swak:column id="ikktnykninfositeituukasyu" />
          <swak:column id="ikktnykninfokouzano" />
          <swak:column id="ikktnykninfoikktnyuukingk" />
          <swak:column id="ikktnykninfodengk" />
          <swak:column id="ikktnykninforyosyuymd" />
          <swak:column id="ikktnykninfokawaserate" />
        </swak:dataTable>

        <%-- ●明細 --%>
        <swak:dataTable id="hrkmnyknInfo">
          <swak:column id="disprenno3keta" />
          <swak:column id="mosnochknasi" />
          <swak:column id="nyknoyadrtencd" />
          <swak:column id="hrkmirninnm48" />
          <swak:column id="hrktuukasyu" />
          <swak:column id="siteituuka" />
          <swak:column id="rsgaku" />
          <swak:column id="dengk" />
          <swak:column id="ryosyuymd" />
          <swak:column id="simukebanknm15" />
          <swak:column id="simuketennm15" />
        </swak:dataTable>

        <%-- ●外貨為替差益 --%>
        <swak:dataTable id="gkkwssekInfo">
          <swak:column id="gkkwssekinfonyknoyadrtennm" />
          <swak:column id="gkkwssekinfohrktuukasyu" />
          <swak:column id="gkkwssekinfositeituukasyu" />
          <swak:column id="gkkwssekinfokouzano" />
          <swak:column id="grossnykngk" />
          <swak:column id="grossdengk" />
          <swak:column id="meisaigoukeidengk" />
          <swak:column id="kawasesasonekikngk" />
        </swak:dataTable>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="tourokuBtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
