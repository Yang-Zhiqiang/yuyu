<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：請求情報ファイル作成
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/simakefile/simakeseikyuuinfof/SiMakeSeikyuuInfoF.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- 出力条件 --%>
        <swak:group id="outConditions">
          <swak:item id="siharaisyorijyoutaikbn" />
          <swak:item id="sibouymdfrom" />
          <swak:item id="IAW0002" />
          <swak:item id="sibouymdto" />
          <swak:item id="siboukariymdfrom" />
          <swak:item id="IAW0002" />
          <swak:item id="siboukariymdto" />
          <swak:item id="syoruiukeymdfrom" />
          <swak:item id="IAW0002" />
          <swak:item id="syoruiukeymdto" />
          <swak:item id="shrymdfrom" />
          <swak:item id="IAW0002" />
          <swak:item id="shrymdto" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtn" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
