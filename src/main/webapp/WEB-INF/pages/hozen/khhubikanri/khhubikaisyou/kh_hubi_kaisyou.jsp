<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約保全不備解消
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khhubikanri/khhubikaisyou/KhHubiKaisyou.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiinfo">
          <swak:item id="vktifdispjimutetuzukinm" />
          <swak:item id="vktifdisptasknm" />
        </swak:group>

        <%-- baseInfo --%>
        <swak:group id="baseInfo">
          <swak:item id="syono" />
        </swak:group>

        <%-- ●書類情報一覧 --%>
        <swak:dataTable id="syoruiInfoList">
          <swak:column id="syoruittykymdtime" />
          <swak:column id="syoruinm" />
          <swak:column id="htysyoruiumukbn" />
          <swak:column id="hyoujilink" />
          <swak:column id="hyoujilinkflg" />
          <swak:column id="imageid" />
        </swak:dataTable>

        <%-- buttonAllhyouji --%>
        <swak:buttonGroup id="buttonAllhyouji">
          <swak:item id="allhyoujibtn" />
        </swak:buttonGroup>

        <%-- ●進捗履歴情報 --%>
        <swak:dataTable id="progresshistoryinfo">
          <swak:column id="vprghsdispsyoriymd" />
          <swak:column id="vprghsdisptasknm" />
          <swak:column id="vprghsdispsyorikekkakbn" />
          <swak:column id="vprghsdispsousasyanm" />
          <swak:column id="vprghsdispcomment" />
        </swak:dataTable>

        <%-- selectDataList --%>
        <swak:dataTable id="selectDataList">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="nyuuryokuLink" />
        </swak:dataTable>

        <%-- ●解消済み不備一覧 --%>
        <swak:dataTable id="kaisyouzumihubiList">
          <swak:column id="dispkaisyoutaisyoukbn" />
          <swak:column id="disptrkymd" />
          <swak:column id="disphubinaiyoumsg" />
          <swak:column id="dispgenponhnkykumu" />
          <swak:column id="disphassinymd" />
          <swak:column id="disphassinsakikbn" />
          <swak:column id="dispnyuryokutantounm" />
          <swak:column id="dispkaisyouymd" />
          <swak:column id="dispsyounintantounm" />
        </swak:dataTable>

        <%-- ●未解消不備一覧 --%>
        <swak:buttonGroup id="buttonAllcontrol">
          <swak:item id="allCheckBtn" />
          <swak:item id="allUnCheckBtn" />
        </swak:buttonGroup>

        <%-- ●未解消不備一覧 --%>
        <swak:dataTable id="mikaisyouhubiList">
          <swak:column id="dispkaisyoutaisyou" />
          <swak:column id="dispkaisyoutaisyoukbn" />
          <swak:column id="disptrkymd" />
          <swak:column id="disphubinaiyoumsg" />
          <swak:column id="dispgenponhnkykumu" />
          <swak:column id="disphassinymd" />
          <swak:column id="disphassinsakikbn" />
          <swak:column id="dispnyuryokutantounm" />
          <swak:column id="dispkaisyouymd" />
          <swak:column id="dispsyounintantounm" />
        </swak:dataTable>

        <%-- ●連絡欄 --%>
        <swak:group id="renrakuran">
          <swak:item id="renrakuarea" />
        </swak:group>

        <%-- ●結果入力 --%>
        <swak:group id="kekkanyuuryoku">
          <swak:item id="syorikekkakbn" />
          <swak:item id="syanaicommentkh" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="kakuteibtnbyinputkey" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtnbyitiransentaku" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="itiranheBtnByInputContents" />
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteibtnbyconfirm" />
        </swak:buttonGroup>

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="syokigamenheBtn" />
          <swak:item id="syokigamenhebtnbyworkflow" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
