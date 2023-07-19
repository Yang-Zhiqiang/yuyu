<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：名義変更／契約者等生年月日訂正
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khmeigihenkou/KhMeigiHenkou.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiInfo">
          <swak:item id="vktifdispjimutetuzukinm" />
          <swak:item id="vktifdisptasknm" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="kihonInfo">
          <swak:item id="vkihnsyono" />
          <swak:item id="vkihnyuukousyoumetukbn" />
          <swak:item id="vkihnkykjyoutai" />
          <swak:item id="vkihnsyoumetujiyuu" />
          <swak:item id="vkihnsyoumetuymd" />
          <swak:item id="vkihnlastsyosaihkymd" />
        </swak:group>

        <%-- ●別契約（既契約） --%>
        <swak:dataTable id="kikeiyakuInfo">
          <swak:column id="vbtkkdispbtkyksyono" />
          <swak:column id="vbtkkdispbtkykyuuksumtkbn" />
          <swak:column id="vbtkkdispbtkykkykjyoutai" />
          <swak:column id="vbtkkdispbtkykkykymd" />
          <swak:column id="vbtkkdispbtkyksumetujiyuu" />
          <swak:column id="vbtkkdispbtkyksyoumetuymd" />
          <swak:column id="vbtkkdispbtkyksyouhnnm" />
        </swak:dataTable>

        <%-- ●別契約（年金支払契約） --%>
        <swak:dataTable id="nenkinsiharaiInfo">
          <swak:column id="vbtkkdispbtkyknksysyno" />
          <swak:column id="vbtkkdispbtkyknkshrsymd" />
          <swak:column id="vbtkkdispbtkyknksymtjiyuu" />
          <swak:column id="vbtkkdispbtkyknksymtymd" />
        </swak:dataTable>

        <%-- ●別契約（ＰＡＬ既契約） --%>
        <swak:dataTable id="palkikeiyakuInfo">
          <swak:column id="vbtkkdisppalbtkyksyono" />
          <swak:column id="vbtkkdisppalbtkykkykymd" />
          <swak:column id="vbtkkdisppalbtkyksymtcd" />
          <swak:column id="vbtkkdisppalbtkyksymtymd" />
        </swak:dataTable>

        <%-- ●別契約（ＰＡＬ年金支払契約） --%>
        <swak:dataTable id="palnenkinsiharaiInfo">
          <swak:column id="vbtkkdisppalbtkyknksysyno" />
          <swak:column id="vbtkkdisppalbtkyknkshrymd" />
          <swak:column id="vbtkkdisppalbtkyknksymtcd" />
          <swak:column id="vbtkkdisppalbtkyknksymtymd" />
        </swak:dataTable>

        <%-- ●別契約（ＰＡＬ保険金据置契約） --%>
        <swak:dataTable id="palsueokiInfo">
          <swak:column id="vbtkkdisppalbtkyksosysyno" />
          <swak:column id="vbtkkdisppalbtkyksosymd" />
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

        <%-- ●手続注意 --%>
        <swak:group id="tetudukityuuiInfo">
          <swak:item id="vtdktkktyuitakbn" />
          <swak:item id="vtdktttdktyuuinaiyou1" />
          <swak:item id="vtdktttdktyuuinaiyou2" />
          <swak:item id="vtdktttdktyuuinaiyou3" />
        </swak:group>

        <%-- 手続注意区分内容 --%>
        <swak:dataTable id="ttdktyuuikbnInfo">
          <swak:column id="vtdktttdktyuuikbn" />
          <swak:column id="vtdktttdktyikbnhsknaiyou" />
          <swak:column id="vtdktttdktyuuikbnsetymd" />
          <swak:column id="vtdktsetsosikinm" />
        </swak:dataTable>

        <%-- 質権設定 --%>
        <swak:group id="stknsetInfo">
          <swak:item id="vtdktstknsetkbn" />
        </swak:group>

        <%-- ●ＦＡＴＣＡ対象者 --%>
        <swak:group id="dispFatcaInfo1">
          <swak:item id="vtdktdispsyoriymd1" />
          <swak:item id="vtdktdispfatcasnsikbn1" />
          <swak:item id="vtdktdispbikkjnssinfokbn1" />
          <swak:item id="vtdktdispfatcakekkbn1" />
          <swak:item id="vtdktdispfatcahankeiikbn1" />
          <swak:item id="vtdktdispbikknzsyno1" />
          <swak:item id="vtdktdispsyomeiymd1" />
          <swak:item id="vtdktdispfatcatgkbn1" />
          <swak:item id="vtdktdispnmkn1" />
          <swak:item id="vtdktdispnmkj1" />
          <swak:item id="vtdktdispseiymd1" />
          <swak:item id="vtdktdispsei1" />
          <swak:item id="vtdktdispkouryokuendymd1" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域２ --%>
        <swak:group id="dispFatcaInfo2">
          <swak:item id="vtdktdispsyoriymd2" />
          <swak:item id="vtdktdispfatcasnsikbn2" />
          <swak:item id="vtdktdispbikkjnssinfokbn2" />
          <swak:item id="vtdktdispfatcakekkbn2" />
          <swak:item id="vtdktdispfatcahankeiikbn2" />
          <swak:item id="vtdktdispbikknzsyno2" />
          <swak:item id="vtdktdispsyomeiymd2" />
          <swak:item id="vtdktdispfatcatgkbn2" />
          <swak:item id="vtdktdispnmkn2" />
          <swak:item id="vtdktdispnmkj2" />
          <swak:item id="vtdktdispseiymd2" />
          <swak:item id="vtdktdispsei2" />
          <swak:item id="vtdktdispkouryokuendymd2" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域３ --%>
        <swak:group id="dispFatcaInfo3">
          <swak:item id="vtdktdispsyoriymd3" />
          <swak:item id="vtdktdispfatcasnsikbn3" />
          <swak:item id="vtdktdispbikkjnssinfokbn3" />
          <swak:item id="vtdktdispfatcakekkbn3" />
          <swak:item id="vtdktdispfatcahankeiikbn3" />
          <swak:item id="vtdktdispbikknzsyno3" />
          <swak:item id="vtdktdispsyomeiymd3" />
          <swak:item id="vtdktdispfatcatgkbn3" />
          <swak:item id="vtdktdispnmkn3" />
          <swak:item id="vtdktdispnmkj3" />
          <swak:item id="vtdktdispseiymd3" />
          <swak:item id="vtdktdispsei3" />
          <swak:item id="vtdktdispkouryokuendymd3" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域４ --%>
        <swak:group id="dispFatcaInfo4">
          <swak:item id="vtdktdispsyoriymd4" />
          <swak:item id="vtdktdispfatcasnsikbn4" />
          <swak:item id="vtdktdispbikkjnssinfokbn4" />
          <swak:item id="vtdktdispfatcakekkbn4" />
          <swak:item id="vtdktdispfatcahankeiikbn4" />
          <swak:item id="vtdktdispbikknzsyno4" />
          <swak:item id="vtdktdispsyomeiymd4" />
          <swak:item id="vtdktdispfatcatgkbn4" />
          <swak:item id="vtdktdispnmkn4" />
          <swak:item id="vtdktdispnmkj4" />
          <swak:item id="vtdktdispseiymd4" />
          <swak:item id="vtdktdispsei4" />
          <swak:item id="vtdktdispkouryokuendymd4" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域５ --%>
        <swak:group id="dispFatcaInfo5">
          <swak:item id="vtdktdispsyoriymd5" />
          <swak:item id="vtdktdispfatcasnsikbn5" />
          <swak:item id="vtdktdispbikkjnssinfokbn5" />
          <swak:item id="vtdktdispfatcakekkbn5" />
          <swak:item id="vtdktdispfatcahankeiikbn5" />
          <swak:item id="vtdktdispbikknzsyno5" />
          <swak:item id="vtdktdispsyomeiymd5" />
          <swak:item id="vtdktdispfatcatgkbn5" />
          <swak:item id="vtdktdispnmkn5" />
          <swak:item id="vtdktdispnmkj5" />
          <swak:item id="vtdktdispseiymd5" />
          <swak:item id="vtdktdispsei5" />
          <swak:item id="vtdktdispkouryokuendymd5" />
        </swak:group>

        <%-- ●ＡＥＯＩ対象者 --%>
        <swak:group id="aeoitaisyousyaInfo1">
          <swak:item id="dispaeoisyoriymd1" />
          <swak:item id="dispaeoisyorisosikicd1" />
          <swak:item id="dispaeoikekkakbn1" />
          <swak:item id="dispaeoisyorikbn1" />
          <swak:item id="dispaeoitaisyousyakbn1" />
          <swak:item id="dispaeoihoujinsyuruikbn1" />
          <swak:item id="dispaeoikouryokusttymd1" />
          <swak:item id="dispaeoikouryokuendymd1" />
        </swak:group>

        <%-- ●ＡＥＯＩ対象者２ --%>
        <swak:group id="aeoitaisyousyaInfo2">
          <swak:item id="dispaeoisyoriymd2" />
          <swak:item id="dispaeoisyorisosikicd2" />
          <swak:item id="dispaeoikekkakbn2" />
          <swak:item id="dispaeoisyorikbn2" />
          <swak:item id="dispaeoitaisyousyakbn2" />
          <swak:item id="dispaeoihoujinsyuruikbn2" />
          <swak:item id="dispaeoikouryokusttymd2" />
          <swak:item id="dispaeoikouryokuendymd2" />
        </swak:group>

        <%-- ●ＡＥＯＩ対象者３ --%>
        <swak:group id="aeoitaisyousyaInfo3">
          <swak:item id="dispaeoisyoriymd3" />
          <swak:item id="dispaeoisyorisosikicd3" />
          <swak:item id="dispaeoikekkakbn3" />
          <swak:item id="dispaeoisyorikbn3" />
          <swak:item id="dispaeoitaisyousyakbn3" />
          <swak:item id="dispaeoihoujinsyuruikbn3" />
          <swak:item id="dispaeoikouryokusttymd3" />
          <swak:item id="dispaeoikouryokuendymd3" />
        </swak:group>

        <%-- ●ＡＥＯＩ対象者４ --%>
        <swak:group id="aeoitaisyousyaInfo4">
          <swak:item id="dispaeoisyoriymd4" />
          <swak:item id="dispaeoisyorisosikicd4" />
          <swak:item id="dispaeoikekkakbn4" />
          <swak:item id="dispaeoisyorikbn4" />
          <swak:item id="dispaeoitaisyousyakbn4" />
          <swak:item id="dispaeoihoujinsyuruikbn4" />
          <swak:item id="dispaeoikouryokusttymd4" />
          <swak:item id="dispaeoikouryokuendymd4" />
        </swak:group>

        <%-- ●ＡＥＯＩ対象者５ --%>
        <swak:group id="aeoitaisyousyaInfo5">
          <swak:item id="dispaeoisyoriymd5" />
          <swak:item id="dispaeoisyorisosikicd5" />
          <swak:item id="dispaeoikekkakbn5" />
          <swak:item id="dispaeoisyorikbn5" />
          <swak:item id="dispaeoitaisyousyakbn5" />
          <swak:item id="dispaeoihoujinsyuruikbn5" />
          <swak:item id="dispaeoikouryokusttymd5" />
          <swak:item id="dispaeoikouryokuendymd5" />
        </swak:group>

        <%-- ●登録家族（１人目） --%>
        <swak:group id="trkkzkInfo1">
          <swak:item id="vtrkkzktrkkzknmkn1" />
          <swak:item id="vtrkkzktrkkzknmkj1" />
          <swak:item id="vtrkkzktrkkzknmkjkhukakbn1" />
          <swak:item id="vtrkkzktrkkzkseiymd1" />
          <swak:item id="vtrkkzktrkkzksei1" />
          <swak:item id="vtrkkzktrkkzktdk1" />
          <swak:item id="IIC1006" />
          <swak:item id="vtrkkzktrkkzkyno1" />
          <swak:item id="vtrkkzktrkkzkadr1kj1" />
          <swak:item id="vtrkkzktrkkzkadr2kj1" />
          <swak:item id="vtrkkzktrkkzkadr3kj1" />
          <swak:item id="vtrkkzktrkkzktelno1" />
          <swak:item id="vtrkkzktrkkzkumukbn1" />
        </swak:group>

        <%-- ●登録家族（２人目） --%>
        <swak:group id="trkkzkInfo2">
          <swak:item id="vtrkkzktrkkzknmkn2" />
          <swak:item id="vtrkkzktrkkzknmkj2" />
          <swak:item id="vtrkkzktrkkzknmkjkhukakbn2" />
          <swak:item id="vtrkkzktrkkzkseiymd2" />
          <swak:item id="vtrkkzktrkkzksei2" />
          <swak:item id="vtrkkzktrkkzktdk2" />
          <swak:item id="IIC1006" />
          <swak:item id="vtrkkzktrkkzkyno2" />
          <swak:item id="vtrkkzktrkkzkadr1kj2" />
          <swak:item id="vtrkkzktrkkzkadr2kj2" />
          <swak:item id="vtrkkzktrkkzkadr3kj2" />
          <swak:item id="vtrkkzktrkkzktelno2" />
          <swak:item id="vtrkkzktrkkzkumukbn2" />
        </swak:group>

        <%-- ●契約者代理人 --%>
        <swak:group id="kyksyadairininInfo">
          <swak:item id="vkykdrkykdrkbn" />
          <swak:item id="vkykdrkykdrnmkn" />
          <swak:item id="vkykdrkykdrnmkj" />
          <swak:item id="vkykdrkykdrnmkjkhukakbn" />
          <swak:item id="vkykdrkykdrseiymd" />
          <swak:item id="vkykdrkykdryno" />
          <swak:item id="vkykdrkykdradr1kj" />
          <swak:item id="vkykdrkykdradr2kj" />
          <swak:item id="vkykdrkykdradr3kj" />
        </swak:group>

        <%-- ●変更事由 --%>
        <swak:group id="henkoujiyuuInfo">
          <swak:item id="meigihnkjiyuu" />
        </swak:group>

        <%-- henkoujiyuuInfo2 --%>
        <swak:group id="henkoujiyuuInfo2">
          <swak:item id="dummykmk1" />
          <swak:item id="IIC0027" />
          <swak:item id="IIC0028" />
          <swak:item id="dummykmk2" />
        </swak:group>

        <%-- ●契約者 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="vkykskyknmkn" />
          <swak:item id="newkyknmkn" />
          <swak:item id="vkykskyknmkj" />
          <swak:item id="vkykskyknmkjkhukakbn" />
          <swak:item id="newkyknmkj" />
          <swak:item id="newkyknmkjkhuka" />
          <swak:item id="newkyknmkjkhukakbn" />
          <swak:item id="vkykskykseiymd" />
          <swak:item id="newkykseiymd" />
          <swak:item id="vkykskyksei" />
          <swak:item id="newkyksei" />
          <swak:item id="vkykskkkyktdk" />
          <swak:item id="IIC0006" />
          <swak:item id="newkkkyktdk" />
          <swak:item id="IIC0006" />
        </swak:group>

        <%-- houjinDaihyousyaInfo --%>
        <swak:group id="houjinDaihyousyaInfo">
          <swak:item id="vkykshjndaiykkbn" />
          <swak:item id="vkykshjndaiyknm" />
          <swak:item id="newhjndaiykkbn" />
          <swak:item id="newhjndaiyknm" />
          <swak:item id="vkykshjndainmkn" />
          <swak:item id="newhjndainmkn" />
          <swak:item id="vkykshjndainmkj" />
          <swak:item id="newhjndainmkj" />
        </swak:group>

        <%-- ●被保険者 --%>
        <swak:group id="hhknInfo1">
          <swak:item id="vhhkshhknnmkn" />
          <swak:item id="newhhknnmkn" />
          <swak:item id="vhhkshhknnmkj" />
          <swak:item id="vhhkshhknnmkjkhukakbn" />
          <swak:item id="newhhknnmkj" />
          <swak:item id="newhhknnmkjkhuka" />
          <swak:item id="newhhknnmkjkhukakbn" />
        </swak:group>

        <%-- hhknInfo2 --%>
        <swak:group id="hhknInfo2">
          <swak:item id="vhhkshhknseiymd" />
          <swak:item id="vhhkshhknsei" />
        </swak:group>

        <%-- ●年金受取人 --%>
        <swak:group id="nkuktInfo">
          <swak:item id="vnkuknenkinuktkbn" />
          <swak:item id="newnenkinuktkbn" />
        </swak:group>

        <%-- ●継続年金受取人 --%>
        <swak:group id="kzuktkaijyoInfo1">
          <swak:item id="kzuktkaijyokbn" />
        </swak:group>

        <%-- kzuktkaijyoInfo2 --%>
        <swak:group id="kzuktkaijyoInfo2">
          <swak:item id="keizknkuktnmkn" />
          <swak:item id="newkzuktnmkn" />
          <swak:item id="keizknkuktnmkj" />
          <swak:item id="newkzuktnmkj" />
          <swak:item id="keizknenkiuktseiymd" />
          <swak:item id="newkzuktseiymd" />
          <swak:item id="keizknenkinukttdk" />
          <swak:item id="IIC0007" />
          <swak:item id="newkzukttdk" />
          <swak:item id="IIC0007" />
        </swak:group>

        <%-- ●死亡返還金受取人 --%>
        <swak:group id="sbhenkanuktInfo">
          <swak:item id="sbhenkanuktnmkn" />
          <swak:item id="newsbhenkanuktnmkn" />
          <swak:item id="sbhenkanuktnmkj" />
          <swak:item id="newsbhenkanuktnmkj" />
          <swak:item id="sibouhenkankinuktseiymd" />
          <swak:item id="newsbhenkanuktseiymd" />
          <swak:item id="sibouhenkankinukttdk" />
          <swak:item id="IIC0006" />
          <swak:item id="newsbhenkanukttdk" />
          <swak:item id="IIC0006" />
        </swak:group>

        <%-- ●死亡保険金受取人 --%>
        <swak:group id="sbhkkukttyouInfo1">
          <swak:item id="vshktsbuktnin" />
          <swak:item id="sbuktnin" />
          <swak:item id="IIC1004" />
        </swak:group>

        <%-- 死亡受取人解除区分 --%>
        <swak:group id="sbHkuktInfo11">
          <swak:item id="sbuktkaijyokbn1" />
        </swak:group>

        <%-- ●死亡保険金受取人２ --%>
        <swak:group id="sbhkkukttyouInfo2">
          <swak:item id="vshktdispsbuktkbn1" />
          <swak:item id="sbuktkbn1" />
          <swak:item id="vshktdispsbuktnmkn1" />
          <swak:item id="sbuktnmkn1" />
          <swak:item id="vshktdispsbuktnmkj1" />
          <swak:item id="vshktdispsbuktnmkjhukakbn1" />
          <swak:item id="sbuktnmkj1" />
          <swak:item id="sbuktnmkjkhuka1" />
          <swak:item id="sbuktnmkjhukakbn1" />
          <swak:item id="vshktdispsbuktseiymd1" />
          <swak:item id="sbuktseiymd1" />
          <swak:item id="vshktdispsbuktbnwari1" />
          <swak:item id="newsbuktbnwari1" />
          <swak:item id="IIC0015" />
        </swak:group>

        <%-- 死亡受取人解除区分 --%>
        <swak:group id="sbHkuktInfo21">
          <swak:item id="sbuktkaijyokbn2" />
        </swak:group>

        <%-- ●死亡保険金受取人３ --%>
        <swak:group id="sbhkkukttyouInfo3">
          <swak:item id="vshktdispsbuktnmkn2" />
          <swak:item id="sbuktnmkn2" />
          <swak:item id="vshktdispsbuktnmkj2" />
          <swak:item id="vshktdispsbuktnmkjhukakbn2" />
          <swak:item id="sbuktnmkj2" />
          <swak:item id="sbuktnmkjkhuka2" />
          <swak:item id="sbuktnmkjhukakbn2" />
          <swak:item id="vshktdispsbuktseiymd2" />
          <swak:item id="sbuktseiymd2" />
          <swak:item id="vshktdispsbuktbnwari2" />
          <swak:item id="newsbuktbnwari2" />
          <swak:item id="IIC0015" />
        </swak:group>

        <%-- 死亡受取人解除区分 --%>
        <swak:group id="sbHkuktInfo31">
          <swak:item id="sbuktkaijyokbn3" />
        </swak:group>

        <%-- ●死亡保険金受取人４ --%>
        <swak:group id="sbhkkukttyouInfo4">
          <swak:item id="vshktdispsbuktnmkn3" />
          <swak:item id="sbuktnmkn3" />
          <swak:item id="vshktdispsbuktnmkj3" />
          <swak:item id="vshktdispsbuktnmkjhukakbn3" />
          <swak:item id="sbuktnmkj3" />
          <swak:item id="sbuktnmkjkhuka3" />
          <swak:item id="sbuktnmkjhukakbn3" />
          <swak:item id="vshktdispsbuktseiymd3" />
          <swak:item id="sbuktseiymd3" />
          <swak:item id="vshktdispsbuktbnwari3" />
          <swak:item id="newsbuktbnwari3" />
          <swak:item id="IIC0015" />
        </swak:group>

        <%-- 死亡受取人解除区分 --%>
        <swak:group id="sbHkuktInfo41">
          <swak:item id="sbuktkaijyokbn4" />
        </swak:group>

        <%-- ●死亡保険金受取人５ --%>
        <swak:group id="sbhkkukttyouInfo5">
          <swak:item id="vshktdispsbuktnmkn4" />
          <swak:item id="sbuktnmkn4" />
          <swak:item id="vshktdispsbuktnmkj4" />
          <swak:item id="vshktdispsbuktnmkjhukakbn4" />
          <swak:item id="sbuktnmkj4" />
          <swak:item id="sbuktnmkjkhuka4" />
          <swak:item id="sbuktnmkjhukakbn4" />
          <swak:item id="vshktdispsbuktseiymd4" />
          <swak:item id="sbuktseiymd4" />
          <swak:item id="vshktdispsbuktbnwari4" />
          <swak:item id="newsbuktbnwari4" />
          <swak:item id="IIC0015" />
        </swak:group>

        <%-- ●被保険者代理人 --%>
        <swak:group id="stdrskkaijyoInfo1">
          <swak:item id="stdrskkaijyokbn" />
        </swak:group>

        <%-- ●指定代理請求人２ --%>
        <swak:group id="stdrskkaijyoInfo2">
          <swak:item id="vstsksiteidruktkbn" />
          <swak:item id="newstdruktkbn" />
          <swak:item id="vstskstdrsknmkn" />
          <swak:item id="newstdrsknmkn" />
          <swak:item id="vstskstdrsknmkj" />
          <swak:item id="vstskstdrsknmkjhukakbn" />
          <swak:item id="newstdrsknmkj" />
          <swak:item id="newstdrsknmkjhuka" />
          <swak:item id="newstdrsknmkjhukakbn" />
          <swak:item id="vstskstdrskseiymd" />
          <swak:item id="newstdrskseiymd" />
        </swak:group>

        <%-- ●通信先 --%>
        <swak:group id="tuusinsakiInfo">
          <swak:item id="vtssktsinyno" />
          <swak:item id="vtssktsinadr1kj" />
          <swak:item id="vtssktsinadr2kj" />
          <swak:item id="vtssktsinadr3kj" />
          <swak:item id="vtssktsintelno" />
          <swak:item id="vtsskdai2tsintelno" />
        </swak:group>

        <%-- ●払込情報 --%>
        <swak:group id="haraikomiInfo">
          <swak:item id="vhrkifstphrkkeirokbn" />
          <swak:item id="vhrkihrkkaisuu" />
          <swak:item id="vhrkihrkkeiro" />
          <swak:item id="vhrkitikiktbrijk" />
          <swak:item id="vhrkijkipjytym" />
          <swak:item id="IIW0002" />
          <swak:item id="vhrkihrkp" />
          <swak:item id="vhrkiitijibrp" />
          <swak:item id="vhrkikihrkp" />
          <swak:item id="vhrkinextkosgohrkp" />
          <swak:item id="IIC0005" />
          <swak:item id="vhrkiyenkansannyknkingk" />
          <swak:item id="vhrkiyentkykwsrateymd" />
          <swak:item id="vhrkiyentkykwsrate" />
          <swak:item id="vhrkiyentkykwsratetuukasyu" />
        </swak:group>

        <%-- 銀行情報 --%>
        <swak:group id="ginkouInfo">
          <swak:item id="vhrkihrkinfobankcd" />
          <swak:item id="vhrkihrkinfobanknmkj" />
          <swak:item id="vhrkihrkinfositencd" />
          <swak:item id="vhrkihrkinfositennmkj" />
          <swak:item id="vhrkihrkinfotuutyoukigou" />
          <swak:item id="vhrkihrkinfoyokinkbn" />
          <swak:item id="vhrkihrkinfokouzano" />
          <swak:item id="vhrkihrkinfosinkeizkkbn" />
          <swak:item id="vhrkihrkinfokzmeiginmkn" />
          <swak:item id="vhrkikzdoukbn" />
        </swak:group>

        <%-- クレジットカード情報 --%>
        <swak:group id="focreditcardInfo">
          <swak:item id="vhrkidispcreditkessaiyouno" />
          <swak:item id="vhrkicredityuukoukakkekka" />
          <swak:item id="vhrkicredityuukoukakym" />
        </swak:group>

        <%-- ＜前納情報＞ --%>
        <swak:group id="zennouInfo">
          <swak:item id="vhrkizennoustartym" />
          <swak:item id="vhrkizennoukkn" />
          <swak:item id="IIA3002" />
          <swak:item id="vhrkizennounyuukingk" />
          <swak:item id="vhrkizennounyuukinymd" />
        </swak:group>

        <%-- ●進捗履歴情報 --%>
        <swak:dataTable id="progresshistoryinfo">
          <swak:column id="vprghsdispsyoriymd" />
          <swak:column id="vprghsdisptasknm" />
          <swak:column id="vprghsdispsyorikekkakbn" />
          <swak:column id="vprghsdispsousasyanm" />
          <swak:column id="vprghsdispcomment" />
        </swak:dataTable>

        <%-- ●必要書類 --%>
        <swak:group id="hituyouSyoruiInfo">
          <swak:item id="vhtysdisphtysyorui" />
        </swak:group>

        <%-- ●請求書送付先 --%>
        <swak:group id="shsnmInfo">
          <swak:item id="shsnmkj" />
        </swak:group>

        <%-- shskadrInfo --%>
        <swak:group id="shskadrInfo">
          <swak:item id="shskyno" />
          <swak:item id="shsadr1kj" />
          <swak:item id="shsadr2kj" />
          <swak:item id="shsadr3kj" />
        </swak:group>

        <%-- referenceButtons --%>
        <swak:buttonGroup id="referenceButtons">
          <swak:item id="syoukainomibtn" />
          <swak:item id="skssakuseibtn" />
        </swak:buttonGroup>

        <%-- ●新契約者通信先 --%>
        <swak:group id="sinkeiyakuTuusinsakiInfo">
          <swak:item id="adrhenkouumu" />
          <swak:item id="tsinyno" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
          <swak:item id="tsintelno" />
          <swak:item id="dai2tsintelno" />
        </swak:group>

        <%-- ●異動調書用項目 --%>
        <swak:group id="idoutyousyoyuuKoumoku">
          <swak:item id="oldkyksibouymd" />
          <swak:item id="syoruiukeymd" />
        </swak:group>

        <%-- ●本人確認 --%>
        <swak:group id="honninKakuninInfo">
          <swak:item id="honninkakninkekkakbn" />
        </swak:group>

        <%-- ●帳票作成要否 --%>
        <swak:group id="tyhysakuseiyhkbnInfo">
          <swak:item id="tyhysakuseiyhkbn" />
          <swak:item id="IIC0017" />
        </swak:group>

        <%-- ●発送区分 --%>
        <swak:group id="hassoukbnGroup">
          <swak:item id="hassoukbn" />
        </swak:group>

        <%-- ●結果入力 --%>
        <swak:group id="kekkainputGroup">
          <swak:item id="syorikekkakbn" />
          <swak:item id="sasimodosisakikbn" />
          <swak:item id="syanaicommentkh" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="syoukaibtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteibtnbyconfirm" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="syokigamenhebtnbyresult" />
        </swak:buttonGroup>

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="modorubtnbysksconfirm" />
          <swak:item id="kakuteibtnbysksconfirm" />
        </swak:buttonGroup>

        <%-- footerButtons6 --%>
        <swak:buttonGroup id="footerButtons6">
          <swak:item id="syokigamenhebtnbysksresult" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
