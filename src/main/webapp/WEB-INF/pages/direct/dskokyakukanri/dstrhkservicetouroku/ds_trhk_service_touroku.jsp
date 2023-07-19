<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：取引サービス登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/direct/dskokyakukanri/dstrhkservicetouroku/DsTrhkServiceTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- IBA0001 --%>

        <swak:message id = "IBA0001" />


        <%-- ●基本情報 --%>
        <swak:group id="kihonInfo">
          <swak:item id="syono" />
          <swak:item id="mosno" />
          <swak:item id="dskokno" />
        </swak:group>

        <%-- inputButtons --%>
        <swak:buttonGroup id="inputButtons">
          <swak:item id="itijinyuuryokubtn" />
          <swak:item id="nijinyuuryokubtn" />
          <swak:item id="syoukaibtn" />
          <swak:item id="torikesiBtn" />
        </swak:buttonGroup>

        <%-- searchjyoukenInfo --%>
        <swak:group id="searchjyoukenInfo">
          <swak:item id="srchdsjimustartymdfrom" />
          <swak:item id="IAW0003" />
          <swak:item id="srchdsjimustartymdto" />
          <swak:item id="srchtourokustatus" />
        </swak:group>

        <%-- searchButtons --%>
        <swak:buttonGroup id="searchButtons">
          <swak:item id="searchbtnbyinputkeyselect" />
        </swak:buttonGroup>

        <%-- ●取引サービス登録一覧 --%>
        <swak:dataTable id="trhkServiceInfo">
          <swak:column id="dsjimukaisiymd" />
          <swak:column id="syono" />
          <swak:column id="mosno" />
          <swak:column id="dispkakkyknmkj" />
          <swak:column id="tourokustatus" />
          <swak:column id="dispsyoritntnmkj" />
          <swak:column id="dsnyuuryokulink" />
        </swak:dataTable>
        <swak:pager id="trhkServiceInfoDataSource" />

        <%-- ●契約者情報 --%>
        <swak:group id="kyksyaInfo">
          <swak:item id="kyknmkj" />
          <swak:item id="kyknmkn" />
          <swak:item id="kykseiymd" />
        </swak:group>

        <%-- ●取引サービス加入経路 --%>
        <swak:group id="trhkServiceKanyuKeiroInfo">
          <swak:item id="dstrhkservicekanyukeirokbn" />
        </swak:group>

        <%-- ●取引サービス登録状況 --%>
        <swak:group id="trhkServiceTourokuJkInfo">
          <swak:item id="tourokustatus" />
          <swak:item id="trksriyuukbn" />
        </swak:group>

        <%-- ●特定取引用口座 --%>
        <swak:group id="tokuteiTrhkKouzaInfo">
          <swak:item id="inputtaisyoutokuteitrhkkz" />
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
          <swak:item id="IIC1003" />
          <swak:item id="kzmeiginmkn" />
        </swak:group>

        <%-- ●特定取引用暗証番号 --%>
        <swak:group id="tokuteiTrhkAnsyonoInfo">
          <swak:item id="inputtaisyoutoktrhkansyono" />
          <swak:item id="disptokuteitrhkansyono" />
          <swak:item id="tokuteitrhkansyonoinput" />
          <swak:item id="tokuteitrhkansyonokakunin" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenhebtnbyresult" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
