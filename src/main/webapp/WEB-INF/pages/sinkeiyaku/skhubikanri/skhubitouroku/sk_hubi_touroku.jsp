<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：新契約不備登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skhubikanri/skhubitouroku/SkHubiTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
          <swak:item id="tojirubtnbyinputcontents" />
        </swak:buttonGroup>

        <%-- mosjkSyoukaiButtons --%>
        <swak:buttonGroup id="mosjkSyoukaiButtons">
          <swak:item id="mosjksyoukaibtn" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiInfo">
          <swak:item id="vktifdispjimutetuzukinm" />
          <swak:item id="vktifdisptasknm" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="baseInfo">
          <swak:item id="mosno" />
        </swak:group>

        <%-- selectDataList --%>
        <swak:dataTable id="selectDataList">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="nyuuryokuLink" />
        </swak:dataTable>

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

        <%-- ●画面制御項目 --%>
        <swak:group id="seigyoGroup">
          <swak:item id="dummykmk1" />
          <swak:item id="dummykmk2" />
          <swak:item id="dummykmk3" />
          <swak:item id="dummykmk4" />
          <swak:item id="dummykmk5" />
          <swak:item id="uniqueid2" />
          <swak:item id="hubitourokumode" />
        </swak:group>

        <%-- ●取扱注意情報 --%>
        <swak:dataTable id="toriatukaiTyuuiInfo">
          <swak:column id="dispskeittdktyuitrttrkymd" />
          <swak:column id="dispskeittdktyuitrtnaiyo" />
          <swak:column id="dispskeittdktyuitrttantou" />
        </swak:dataTable>

        <%-- ●発信済み不備一覧 --%>
        <swak:dataTable id="hubiList1">
          <swak:column id="disptrkymd" />
          <swak:column id="hubisyoruicd" />
          <swak:column id="disphassinymd" />
          <swak:column id="disphasinkyokakbn" />
          <swak:column id="dispnyuryokutantounm" />
          <swak:column id="dummykmk1" />
          <swak:column id="dispskhubikoumoku" />
          <swak:column id="dispskhubinaiyou" />
          <swak:column id="dispkaisyouymd" />
          <swak:column id="disphassinsakikbn" />
          <swak:column id="dispskseibisijinaiyou" />
          <swak:column id="tyoubundisprenrakujikou" />
        </swak:dataTable>

        <%-- ●未発信不備一覧 --%>
        <swak:dataTable id="hubiList2">
          <swak:column id="dispinputtrkymd" />
          <swak:column id="hubisyoruicd" />
          <swak:column id="dummykmk1" />
          <swak:column id="dispinputhasinkyokakbn" />
          <swak:column id="dispinputnyuryokutantounm" />
          <swak:column id="dispinputtyoubunflg" />
          <swak:column id="dispinputskhubikoumoku" />
          <swak:column id="dispinputhubinaiyoucd" />
          <swak:column id="dummykmk2" />
          <swak:column id="dispinputhassinsakikbn" />
          <swak:column id="sakujyoLink" />
          <swak:column id="sakujyoflg" />
          <swak:column id="dispinputskseibisijinaiyou" />
          <swak:column id="tyoubundisprenrakujikou" />
        </swak:dataTable>

        <%-- tuikaButtons --%>
        <swak:buttonGroup id="tuikaButtons">
          <swak:item id="addbtn" />
        </swak:buttonGroup>

        <%-- ●不備通知先 --%>
        <swak:group id="hubituutisaki">
          <swak:item id="utdskknnm1kj" />
          <swak:item id="utdskknnm2kj" />
          <swak:item id="tuutisakitantounmkj" />
        </swak:group>

        <%-- ●コメント --%>
        <swak:group id="comment">
          <swak:item id="commentareagamen" />
        </swak:group>

        <%-- ●不備帳票出力 --%>
        <swak:group id="hubiTyouhyouSyuturyoku">
          <swak:item id="hbtyhyoutkbn" />
        </swak:group>

        <%-- hiddenDateGroup --%>
        <swak:group id="hiddenDateGroup">
          <swak:item id="syoriYmd" />
          <swak:item id="nyuuryokutantounm" />
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
          <swak:item id="kakuninBtn" />
          <swak:item id="karisakuseibtn" />
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
          <swak:item id="tourokubtnbypopup" />
          <swak:item id="karisakuseibtnbypopup" />
          <swak:item id="tojiruBtnByPopup" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
