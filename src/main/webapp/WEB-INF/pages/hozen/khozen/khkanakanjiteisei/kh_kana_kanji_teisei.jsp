<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：仮名漢字訂正
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khkanakanjiteisei/KhKanaKanjiTeisei.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

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
        </swak:group>

        <%-- keiyakusyasyosaiInfo --%>
        <swak:group id="keiyakusyasyosaiInfo">
          <swak:item id="vkykskykseiymd" />
          <swak:item id="vkykskyksei" />
          <swak:item id="vkykskkkyktdk" />
        </swak:group>

        <%-- ●被保険者 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="vhhkshhknnmkn" />
          <swak:item id="newhhknnmkn" />
          <swak:item id="vhhkshhknnmkj" />
          <swak:item id="vhhkshhknnmkjkhukakbn" />
          <swak:item id="newhhknnmkj" />
          <swak:item id="newhhknnmkjkhuka" />
          <swak:item id="newhhknnmkjkhukakbn" />
        </swak:group>

        <%-- hihokensyasyosaiInfo --%>
        <swak:group id="hihokensyasyosaiInfo">
          <swak:item id="vhhkshhknseiymd" />
          <swak:item id="vhhkshhknsei" />
        </swak:group>

        <%-- ●年金受取人 --%>
        <swak:group id="nkuktInfo">
          <swak:item id="vnkuknenkinuktkbn" />
          <swak:item id="newnenkinuktkbn" />
        </swak:group>

        <%-- ●死亡保険金受取人 --%>
        <swak:group id="sbHkuktInfo">
          <swak:item id="vshktsbuktnin" />
        </swak:group>

        <%-- ●死亡保険金受取人 --%>
        <swak:group id="sbHkuktInfo1">
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
          <swak:item id="vshktdispsbuktbnwari1" />
        </swak:group>

        <%-- ●死亡保険金受取人 --%>
        <swak:group id="sbHkuktInfo2">
          <swak:item id="vshktdispsbuktnmkn2" />
          <swak:item id="sbuktnmkn2" />
          <swak:item id="vshktdispsbuktnmkj2" />
          <swak:item id="vshktdispsbuktnmkjhukakbn2" />
          <swak:item id="sbuktnmkj2" />
          <swak:item id="sbuktnmkjkhuka2" />
          <swak:item id="sbuktnmkjhukakbn2" />
          <swak:item id="vshktdispsbuktseiymd2" />
          <swak:item id="vshktdispsbuktbnwari2" />
        </swak:group>

        <%-- ●死亡保険金受取人 --%>
        <swak:group id="sbHkuktInfo3">
          <swak:item id="vshktdispsbuktnmkn3" />
          <swak:item id="sbuktnmkn3" />
          <swak:item id="vshktdispsbuktnmkj3" />
          <swak:item id="vshktdispsbuktnmkjhukakbn3" />
          <swak:item id="sbuktnmkj3" />
          <swak:item id="sbuktnmkjkhuka3" />
          <swak:item id="sbuktnmkjhukakbn3" />
          <swak:item id="vshktdispsbuktseiymd3" />
          <swak:item id="vshktdispsbuktbnwari3" />
        </swak:group>

        <%-- ●死亡保険金受取人 --%>
        <swak:group id="sbHkuktInfo4">
          <swak:item id="vshktdispsbuktnmkn4" />
          <swak:item id="sbuktnmkn4" />
          <swak:item id="vshktdispsbuktnmkj4" />
          <swak:item id="vshktdispsbuktnmkjhukakbn4" />
          <swak:item id="sbuktnmkj4" />
          <swak:item id="sbuktnmkjkhuka4" />
          <swak:item id="sbuktnmkjhukakbn4" />
          <swak:item id="vshktdispsbuktseiymd4" />
          <swak:item id="vshktdispsbuktbnwari4" />
        </swak:group>

        <%-- ●被保険者代理人 --%>
        <swak:group id="siteiseikyuuInfo1">
          <swak:item id="stdrskkaijyokbn" />
        </swak:group>

        <%-- ●被保険者代理人２ --%>
        <swak:group id="siteiseikyuuInfo2">
          <swak:item id="vstsksiteidruktkbn" />
          <swak:item id="newstdruktkbn" />
          <swak:item id="vstskstdrsknmkn" />
          <swak:item id="newstdrsknmkn" />
          <swak:item id="vstskstdrsknmkj" />
          <swak:item id="vstskstdrsknmkjhukakbn" />
          <swak:item id="newstdrsknmkj" />
          <swak:item id="newstdrsknmkjhuka" />
          <swak:item id="newstdrsknmkjhukakbn" />
        </swak:group>

        <%-- siteiseikyuusyosaiInfo --%>
        <swak:group id="siteiseikyuusyosaiInfo">
          <swak:item id="vstskstdrskseiymd" />
        </swak:group>

        <%-- ●口座名義人 --%>
        <swak:group id="kzmeigiInfo">
          <swak:item id="kzkykdoukbn" />
          <swak:item id="newkzkykdoukbn" />
          <swak:item id="kzmeiginmkn" />
          <swak:item id="newkzmeiginmkn" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="syoukaibtn" />
          <swak:item id="modorubtnbysyoukai" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
