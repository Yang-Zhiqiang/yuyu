<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：帳票個別出力
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/biz/bztyouhyou/bztyouhyoukobetu/BzTyouhyouKobetu.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- 検索条件 --%>
        <swak:group id="kensakuJyouken">
          <swak:item id="srchsubsystemid" />
          <swak:item id="srchsyoruicd" />
          <swak:item id="tyouhyouymdfrom" />
          <swak:item id="IAW0002" />
          <swak:item id="tyouhyouymdto" />
          <swak:item id="knskkmkid1" />
          <swak:item id="knskkmkid2" />
          <swak:item id="knskkmkid3" />
          <swak:item id="knskkmkid4" />
          <swak:item id="knskkmkid5" />
        </swak:group>

        <%-- 検索結果一覧 --%>
        <swak:dataTable id="kensakuKekkaItiranList">
          <swak:column id="tyouhyouSyuturyokuLink" />
          <swak:column id="knskkmknm1" />
          <swak:column id="knskkmknm2" />
          <swak:column id="knskkmknm3" />
          <swak:column id="knskkmknm4" />
          <swak:column id="knskkmknm5" />
          <swak:column id="disptyouhyousakuseiymd" />
          <swak:column id="dispoutkaisuu" />
          <swak:column id="dispfstoutymd" />
          <swak:column id="displstoutymd" />
        </swak:dataTable>
        <swak:pager id="kensakuKekkaItiranListDataSource" />

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="searchBtn" />
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
