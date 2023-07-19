<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：診断書料支払
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sisatei/sisindansyoryousiharai/SiSindansyoryouSiharai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
          <swak:item id="tojiruBtnByPopup" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiinfo">
          <swak:item id="vktifdispjimutetuzukinm" />
          <swak:item id="vktifdisptasknm" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="hktskKihonInfo">
          <swak:item id="syono" />
        </swak:group>

        <%-- ●進捗履歴情報 --%>
        <swak:dataTable id="progresshistoryinfo">
          <swak:column id="vprghsdispsyoriymd" />
          <swak:column id="vprghsdisptasknm" />
          <swak:column id="vprghsdispsyorikekkakbn" />
          <swak:column id="vprghsdispsousasyanm" />
          <swak:column id="vprghsdispcomment" />
        </swak:dataTable>

        <%-- ●被保険者情報 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
          <swak:item id="hhknseiymd" />
          <swak:item id="mskmjskjhknnen" />
          <swak:item id="hhknsei" />
        </swak:group>

        <%-- ●被保険者代理人情報 --%>
        <swak:group id="stdrsknInfo">
          <swak:item id="siteidruktnmkn" />
          <swak:item id="siteidruktnmkj" />
        </swak:group>

        <%-- ●通信先住所情報 --%>
        <swak:group id="tsinInfo">
          <swak:item id="tdkdtsinyno" />
          <swak:item id="tdkdtsinadr1kj" />
          <swak:item id="tdkdtsinadr2kj" />
          <swak:item id="tdkdtsinadr3kj" />
          <swak:item id="tdkdtsintelno1" />
        </swak:group>

        <%-- ●請求者情報 --%>
        <swak:group id="skjyouhou">
          <swak:item id="seikyuusyakbn" />
          <swak:item id="seikyuusyanmkj" />
        </swak:group>

        <%-- ●送付先住所情報 --%>
        <swak:group id="souhusakiInfo">
          <swak:item id="souhusakikbn" />
          <swak:item id="tsinyno" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
        </swak:group>

        <%-- ●支払方法 --%>
        <swak:group id="viewSoukinsakishrInfo">
          <swak:item id="inputshrhousiteikbn" />
        </swak:group>

        <%-- ●送金先口座情報 --%>
        <swak:group id="viewSoukinsakiInfo">
          <swak:item id="bankcd" />
          <swak:item id="IBC1001" />
          <swak:item id="banknmkj" />
          <swak:item id="sitencd" />
          <swak:item id="IBC1002" />
          <swak:item id="sitennmkj" />
          <swak:item id="yokinkbn" />
          <swak:item id="IBC1003" />
          <swak:item id="kouzano" />
          <swak:item id="IBC1004" />
          <swak:item id="kzdoukbn" />
          <swak:item id="kzmeiginmkn" />
        </swak:group>

        <%-- ●診断書料支払 --%>
        <swak:group id="sindansyoryoushr">
          <swak:item id="sindansyomaisuu" />
          <swak:item id="shrgkkei" />
          <swak:item id="tyakkinymd" />
        </swak:group>

        <%-- ●支払明細書作成区分 --%>
        <swak:group id="viewShrdtlSakuseiKbnInfo">
          <swak:item id="shrdtlsyooutkbn" />
          <swak:item id="hassoukbn" />
        </swak:group>

        <%-- ●結果入力 --%>
        <swak:group id="kekkaInput">
          <swak:item id="syorikekkakbn" />
          <swak:item id="tennousakisousasyacd" />
          <swak:item id="syanaicomment" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="ketteiBtn" />
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
