<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約保全不備登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khhubikanri/khhubitouroku/KhHubiTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiInfo">
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

        <%-- ●発信済み不備一覧 --%>
        <swak:dataTable id="hashinzumiHubiList">
          <swak:column id="trkymd" />
          <swak:column id="hubisyoruinm" />
          <swak:column id="dispgenponhnkykumu" />
          <swak:column id="hasinymd" />
          <swak:column id="hassinsakikbn" />
          <swak:column id="nyuuryokutantounm" />
          <swak:column id="kaisyouymd" />
          <swak:column id="hubinaiyoumsg" />
          <swak:column id="syounintantounm" />
        </swak:dataTable>

        <%-- ●未発信不備一覧 --%>
        <swak:dataTable id="hubiList2">
          <swak:column id="disptrkymd" />
          <swak:column id="dispsyoruicd" />
          <swak:column id="disphubisyoruinm" />
          <swak:column id="dispgenponhnkykumuchkbox" />
          <swak:column id="dispgenponhnkykumu" />
          <swak:column id="disphassinymd" />
          <swak:column id="disphassinsakikbn" />
          <swak:column id="dispnyuryokutantounm" />
          <swak:column id="dispkaisyouymd" />
          <swak:column id="sakujyoLink" />
          <swak:column id="sakujyoflg" />
          <swak:column id="disphubinaiyoumsg" />
          <swak:column id="dispsyounintantounm" />
          <swak:column id="disphubisyoruicd" />
          <swak:column id="disphubinaiyoucd" />
          <swak:column id="jimutetuzukicd" />
          <swak:column id="sakujyoflg2" />
        </swak:dataTable>

        <%-- tuikaButtons --%>
        <swak:buttonGroup id="tuikaButtons">
          <swak:item id="addbtn" />
        </swak:buttonGroup>

        <%-- ●連絡先名 --%>
        <swak:group id="renrakusakiNm">
          <swak:item id="renrakusakinmkj" />
        </swak:group>

        <%-- ●連絡先情報 --%>
        <swak:group id="renrakusakiInfo">
          <swak:item id="renrakuyno" />
          <swak:item id="renrakusakiadr1kj" />
          <swak:item id="renrakusakiadr2kj" />
          <swak:item id="renrakusakiadr3kj" />
          <swak:item id="renrakusakitelno" />
        </swak:group>

        <%-- ●連絡欄 --%>
        <swak:group id="renrakuran">
          <swak:item id="renrakuarea" />
        </swak:group>

        <%-- ●不備回答期日 --%>
        <swak:group id="hubianswerkjtInfo">
          <swak:item id="hubianswerkjt" />
        </swak:group>

        <%-- karisakuseiButtons --%>
        <swak:buttonGroup id="karisakuseiButtons">
          <swak:item id="karisakuseibtn" />
        </swak:buttonGroup>

        <%-- ●コメント --%>
        <swak:group id="comment">
          <swak:item id="syorikekkakbn" />
          <swak:item id="tennousakisousasyacd" />
          <swak:item id="syanaicommentkh" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="tourokuBtn" />
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
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="syokigamenheBtn" />
          <swak:item id="syokigamenhebtnbyworkflow" />
        </swak:buttonGroup>

        <%-- hiddenDateGroup --%>
        <swak:group id="hiddenDateGroup">
          <swak:item id="syoriYmd" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
