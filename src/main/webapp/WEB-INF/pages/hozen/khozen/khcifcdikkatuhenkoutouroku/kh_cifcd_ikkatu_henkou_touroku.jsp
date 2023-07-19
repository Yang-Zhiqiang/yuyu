<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ＣＩＦコード一括変更登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khcifcdikkatuhenkoutouroku/KhCifcdIkkatuHenkouTouroku.do" enctype="multipart/form-data">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- アップロードファイル情報 --%>
        <swak:group id="uploadfileInfo">
          <swak:item id="uploadfile" />
        </swak:group>

        <%-- ＣＩＦコード変更情報一覧タイトル --%>
        <swak:dataTable id="cifCodeHenkouInfoTitle">
          <swak:column id="disprenno3keta" />
          <swak:column id="syono" />
          <swak:column id="cifcd" />
        </swak:dataTable>

        <%-- ＣＩＦコード変更情報一覧 --%>
        <swak:dataTable id="cifCodeHenkouInfo">
          <swak:column id="disprenno3keta" />
          <swak:column id="syono" />
          <swak:column id="cifcd" />
        </swak:dataTable>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="tourokuBtn" />
          <swak:item id="sakujyoBtn" />
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
