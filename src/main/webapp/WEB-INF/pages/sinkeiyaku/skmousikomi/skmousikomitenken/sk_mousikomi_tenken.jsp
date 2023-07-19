<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：申込点検
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skmousikomi/skmousikomitenken/SkMousikomiTenken.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- buttonMosJkSyoukai --%>
        <swak:buttonGroup id="buttonMosJkSyoukai">
          <swak:item id="mosjksyoukaibtn" />
        </swak:buttonGroup>

        <%-- buttonHubisyousai --%>
        <swak:group id="buttonHubisyousai">
          <swak:item id="hubisyousaibtn" />
        </swak:group>

        <%-- ●決定保留不備 --%>
        <swak:dataTable id="ketteiHoryuuHubi">
          <swak:column id="msgsyubetu" />
          <swak:column id="disphubimsgid" />
          <swak:column id="disphubimsg" />
        </swak:dataTable>

        <%-- ●成立保留不備 --%>
        <swak:dataTable id="seirituHoryuuHubi">
          <swak:column id="msgsyubetu" />
          <swak:column id="disphubimsgid" />
          <swak:column id="disphubimsg" />
        </swak:dataTable>

        <%-- ●ワーニング --%>
        <swak:dataTable id="warning">
          <swak:column id="msgsyubetu" />
          <swak:column id="disphubimsgid" />
          <swak:column id="disphubimsg" />
        </swak:dataTable>

        <%-- ●基本不備 --%>
        <swak:dataTable id="kihonHubi">
          <swak:column id="msgsyubetu" />
          <swak:column id="disphubimsgid" />
          <swak:column id="disphubimsg" />
        </swak:dataTable>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiInfo">
          <swak:item id="vktifdispjimutetuzukinm" />
          <swak:item id="vktifdisptasknm" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="baseInfo">
          <swak:item id="mosno" />
          <swak:item id="hhknnmkj" />
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

        <%-- ●進捗状況 --%>
        <swak:group id="sintyokuJyoukyou">
          <swak:item id="mosnrkumu" />
          <swak:item id="kkthjykbn" />
          <swak:item id="nyknnrkumu" />
          <swak:item id="mostenkenjoukbn" />
          <swak:item id="hubiumu" />
          <swak:item id="kykkakjkkbn" />
          <swak:item id="lincjkkbn" />
          <swak:item id="linckknnjkkbn" />
          <swak:item id="knkysateijyoukbn" />
          <swak:item id="imusateijyoukbn" />
          <swak:item id="ketteikbn" />
          <swak:item id="jimusrhkbn" />
          <swak:item id="seiritukbn" />
        </swak:group>

        <%-- sintyokuJyoukyou2 --%>
        <swak:group id="sintyokuJyoukyou2">
          <swak:item id="mostenken1jiyhkbn" />
          <swak:item id="mostenken2jiyhkbn" />
          <swak:item id="knkysatei1jiyhkbn" />
          <swak:item id="knkysatei2jiyhkbn" />
          <swak:item id="imusateikaniyhkbn" />
          <swak:item id="lincgthtkekkbn" />
          <swak:item id="mostenkensjnaiyou" />
        </swak:group>

        <%-- ●申込書入力情報 --%>
        <swak:group id="moousikomiTenkenJouhou">
          <swak:item id="khnchkcmnt" />
        </swak:group>

        <%-- ●前回指示内容 --%>
        <swak:group id="zenkaiSijiNaiyou">
          <swak:item id="zenkaiknksateicomnt" />
        </swak:group>

        <%-- ●申込点検履歴 --%>
        <swak:dataTable id="mousikomiTenkenRireki">
          <swak:column id="dispmostenkensyoriymd" />
          <swak:column id="dispmostnknstktsyorinmkbn" />
          <swak:column id="dispmostenkenkekkakbn" />
          <swak:column id="dispmostenkenktnm" />
          <swak:column id="dispmostenkencomment" />
        </swak:dataTable>

        <%-- ●新契約取扱注意情報 --%>
        <swak:dataTable id="skToriatukaiTyuuiJouhou">
          <swak:column id="dispskeittdktyuitrttrkymd" />
          <swak:column id="dispskeittdktyuitrtnaiyo" />
          <swak:column id="dispskeittdktyuitrttantou" />
        </swak:dataTable>

        <%-- ●確認事項 --%>
        <swak:group id="kakuninJikou">
          <swak:item id="tkhjnkbn" />
          <swak:item id="searchBtn" />
          <swak:item id="fatcakakkekkakbn" />
          <swak:item id="aeoikekkakbn" />
          <swak:item id="uktkak" />
          <swak:item id="uktkakkbn" />
          <swak:item id="tkhsyouryaku" />
          <swak:item id="tkhsyouryakuumukbn" />
          <swak:item id="koureitaioukbn" />
        </swak:group>

        <%-- ●構成員契約入力 --%>
        <swak:group id="kouseiinkykInput">
          <swak:item id="kouseiinkykkbn" />
          <swak:item id="kouseiinkyktkjkumukbn" />
        </swak:group>

        <%-- ●交換契約入力 --%>
        <swak:group id="koukankykInput">
          <swak:item id="koukankykkbn" />
          <swak:item id="koukankykkinmusakinm" />
          <swak:item id="koukankyksyokumunaiyou" />
          <swak:item id="koukankyktkjkumukbn" />
        </swak:group>

        <%-- ●特殊項目コード --%>
        <swak:group id="tokusyuKoumokuCd">
          <swak:item id="tsryhshrkykumukbn" />
          <swak:item id="syosisyatodokeumukbn" />
          <swak:item id="kakukisyouryakukbumukbn" />
          <swak:item id="seiymdmosseitouumukbn" />
        </swak:group>

        <%-- ●申込点検 --%>
        <swak:group id="mousikomiTenken">
          <swak:item id="mostenkenkekkakbn" />
          <swak:item id="mostenkentnsketsyacd" />
          <swak:item id="mostenkencommentgamen" />
        </swak:group>

        <%-- ●環境査定履歴 --%>
        <swak:dataTable id="kankyouSateiRireki">
          <swak:column id="dispknksyoriymd" />
          <swak:column id="dispknkstktsyorinmkbn" />
          <swak:column id="dispknkkekkakbn" />
          <swak:column id="dispknkktnm" />
          <swak:column id="dispknkcomment" />
        </swak:dataTable>

        <%-- ●環境査定依頼 --%>
        <swak:group id="kankyouSateiIrai">
          <swak:item id="knksateikekkakbn" />
          <swak:item id="knksateiiraicomment" />
        </swak:group>

        <%-- ●医務査定履歴 --%>
        <swak:dataTable id="imuSateiRireki">
          <swak:column id="dispimusyoriymd" />
          <swak:column id="dispimustktsyorinmkbn" />
          <swak:column id="dispimukekkakbn" />
          <swak:column id="dispimuktnm" />
          <swak:column id="dispimucomment" />
        </swak:dataTable>

        <%-- ●医務査定依頼 --%>
        <swak:group id="imuSateiIrai">
          <swak:item id="imusateikekkakbn" />
          <swak:item id="imusateiiraicomment" />
        </swak:group>

        <%-- ●不備コメント --%>
        <swak:group id="hubiComment">
          <swak:item id="hbcmntkkt" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="tenkenBtn" />
        </swak:buttonGroup>

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="hbtrbtnpopup" />
          <swak:item id="hbknbtnpopup" />
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

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="uniqueId" />
          <swak:item id="uniqueid2" />
          <swak:item id="hubitourokumode" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
