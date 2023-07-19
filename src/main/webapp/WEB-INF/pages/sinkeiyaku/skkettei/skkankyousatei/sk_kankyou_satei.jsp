<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：環境査定
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
          <swak:item id="tojirubtnbytsyknyjk" />
        </swak:buttonGroup>

        <%-- buttonMosJkSyoukai --%>
        <swak:buttonGroup id="buttonMosJkSyoukai">
          <swak:item id="mosjksyoukaibtn" />
        </swak:buttonGroup>

        <%-- buttonHubisyousai --%>
        <swak:group id="buttonHubisyousai">
          <swak:item id="hubisyousaibtn" />
        </swak:group>

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

        <%-- sintyokuJyoukyou1 --%>
        <swak:group id="sintyokuJyoukyou1">
          <swak:item id="mostenken1jiyhkbn" />
          <swak:item id="mostenken2jiyhkbn" />
          <swak:item id="knkysatei1jiyhkbn" />
          <swak:item id="knkysatei2jiyhkbn" />
          <swak:item id="imusateikaniyhkbn" />
          <swak:item id="lincgthtkekkbn" />
          <swak:item id="knksateisjnaiyou" />
        </swak:group>

        <%-- ●前回指示内容 --%>
        <swak:group id="zenkaiSijiNaiyou">
          <swak:item id="zenkaiknksateicomnt" />
        </swak:group>

        <%-- ●環境査定履歴 --%>
        <swak:dataTable id="kankyouSateiRireki">
          <swak:column id="dispknksyoriymd" />
          <swak:column id="dispknkstktsyorinmkbn" />
          <swak:column id="dispknkkekkakbn" />
          <swak:column id="dispknkktnm" />
          <swak:column id="dispknkcomment" />
        </swak:dataTable>

        <%-- ●選択情報 --%>
        <swak:dataTable id="sentakuJouhou">
          <swak:column id="dispsntkinfotsysy" />
          <swak:column id="dispsntkinfono" />
          <swak:column id="dispsntkinfosyubetu" />
          <swak:column id="dispsntkinfosyskbn" />
        </swak:dataTable>

        <%-- ●新契約取扱注意情報 --%>
        <swak:dataTable id="toriatukaiTyuuiJouhou">
          <swak:column id="dispskeittdktyuitrttrkymd" />
          <swak:column id="dispskeittdktyuitrtnaiyo" />
          <swak:column id="dispskeittdktyuitrttantou" />
        </swak:dataTable>

        <%-- ●確認事項 --%>
        <swak:group id="kakuninJikou">
          <swak:item id="linckak" />
          <swak:item id="linckakkbn" />
          <swak:item id="lincjkbtn" />
        </swak:group>

        <%-- ●環境査定 --%>
        <swak:group id="kankyouSatei">
          <swak:item id="knksateisateikekka" />
          <swak:item id="knktnsketsyacd" />
          <swak:item id="knksateicommentgamen" />
          <swak:item id="hubihassintns" />
          <swak:item id="hubihassintnskbn" />
        </swak:group>

        <%-- ●決定 --%>
        <swak:group id="ketteiJouhou">
          <swak:item id="ketkekkacd" />
          <swak:item id="ketriyuuitiranBtn" />
          <swak:item id="ketriyuucd1gamen" />
          <swak:item id="ketteiriyuunaiyou1" />
          <swak:item id="ketriyuucd2gamen" />
          <swak:item id="ketteiriyuunaiyou2" />
          <swak:item id="ketriyuucd3gamen" />
          <swak:item id="ketteiriyuunaiyou3" />
          <swak:item id="ketriyuucd4gamen" />
          <swak:item id="ketteiriyuunaiyou4" />
          <swak:item id="mrriyuucdkbn" />
          <swak:item id="torikesisyousairiyuucd" />
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

        <%-- ●申込書入力情報 --%>
        <swak:group id="mosTenkenJouhou">
          <swak:item id="khnchkcmnt" />
        </swak:group>

        <%-- ●申込点検履歴 --%>
        <swak:dataTable id="mosTenkenRireki">
          <swak:column id="dispmostenkensyoriymd" />
          <swak:column id="dispmostnknstktsyorinmkbn" />
          <swak:column id="dispmostenkenkekkakbn" />
          <swak:column id="dispmostenkenktnm" />
          <swak:column id="dispmostenkencomment" />
        </swak:dataTable>

        <%-- ●申込点検依頼 --%>
        <swak:group id="mosTenkenIrai">
          <swak:item id="mostenkenkekkakbn" />
          <swak:item id="mostenkeniraicomment" />
        </swak:group>

        <%-- ●他社加入状況 --%>
        <swak:dataTable id="tasyaKanyuuJoukyou">
          <swak:column id="tasyaout" />
          <swak:column id="tasyano" />
          <swak:column id="tasyaankenjyoutai" />
          <swak:column id="tasyakyksyubetu" />
          <swak:column id="tasyakaisyacd" />
          <swak:column id="tasyakaisyanm" />
          <swak:column id="tasyakykkbn" />
          <swak:column id="tasyakyknmkn" />
          <swak:column id="tasyakyknmkj" />
          <swak:column id="tasyahhknnmkn" />
          <swak:column id="tasyahhknnmkj" />
          <swak:column id="tasyasyuutyuu" />
          <swak:column id="tasyakykymd" />
          <swak:column id="tasyatrkymd" />
          <swak:column id="tasyasibusmantyen" />
          <swak:column id="tasyasaigaismanyen" />
          <swak:column id="tasyasaigaisenyen" />
          <swak:column id="tasyasippeisenyen" />
          <swak:column id="tasyaseijinbyousenyen" />
          <swak:column id="tasyasonotasenyen" />
          <swak:column id="tasyakanyuusyano" />
          <swak:column id="tasyahknkykkanrino" />
        </swak:dataTable>

        <%-- ●当他社通算 --%>
        <swak:group id="touTasyaTsusan">
          <swak:item id="IHF1039" />
          <swak:item id="IHF1040" />
          <swak:item id="IHF1041" />
          <swak:item id="tasyatsn" />
          <swak:item id="IHF1042" />
          <swak:item id="tousyatsn" />
          <swak:item id="IHF1043" />
          <swak:item id="tousyatsnfundnotinc" />
          <swak:item id="IHF1044" />
          <swak:item id="toutasyatsn" />
          <swak:item id="IHF1045" />
          <swak:item id="toutasyatsnfundnotinc" />
          <swak:item id="IHF1046" />
          <swak:item id="toutasyatsnkessaitgk" />
        </swak:group>

        <%-- ●その他情報 --%>
        <swak:group id="sonotaJouhou">
          <swak:item id="nensyuukbn" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="sateibtn" />
        </swak:buttonGroup>

        <%-- jyoubuButtons1 --%>
        <swak:buttonGroup id="jyoubuButtons1">
          <swak:item id="kakuninbtnbyjyoubu" />
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

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="haneibtn" />
        </swak:buttonGroup>

        <%-- footerButtons6 --%>
        <swak:buttonGroup id="footerButtons6">
          <swak:item id="tojiruBtnByPopup" />
        </swak:buttonGroup>

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="uniqueId" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
