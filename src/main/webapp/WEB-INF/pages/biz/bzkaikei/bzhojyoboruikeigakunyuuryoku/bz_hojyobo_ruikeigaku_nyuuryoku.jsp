<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：補助簿累計額入力
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/biz/bzkaikei/bzhojyoboruikeigakunyuuryoku/BzHojyoboRuikeigakuNyuuryoku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- topButtons --%>
        <swak:buttonGroup id="topButtons">
          <swak:item id="sinkitourokubtn" />
        </swak:buttonGroup>

        <%-- 補助簿累計額リスト --%>
        <swak:dataTable id="hojyoboRuikeigakuInfoList">
          <swak:column id="syukanjokamokucd" />
          <swak:column id="kanjyoukmknm" />
          <swak:column id="karikataruigk" />
          <swak:column id="kasikataruigk" />
          <swak:column id="karikatateiseigk" />
          <swak:column id="kasikatateiseigk" />
          <swak:column id="teiseilink" />
        </swak:dataTable>

        <%-- inputDataInfo --%>
        <swak:group id="inputDataInfo">
          <swak:item id="dispkanjyoukamoku" />
          <swak:item id="inputkanjyoukamoku" />
          <swak:item id="dispkarikataruigk" />
          <swak:item id="dispkasikataruigk" />
          <swak:item id="inputkarikatateiseigk" />
          <swak:item id="inputkasikatateiseigk" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

        <%-- bottomButtons --%>
        <swak:buttonGroup id="bottomButtons">
          <swak:item id="teiseigksakujyobtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
