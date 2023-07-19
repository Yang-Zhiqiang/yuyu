<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：家族登録／契約者代理特約変更
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khkzktrkkykdrhnk/KhKzktrkKykdrHnk.do">

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

        <%-- ●契約者 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="vkykskyknmkn" />
          <swak:item id="vkykskyknmkj" />
          <swak:item id="vkykskyknmkjkhukakbn" />
          <swak:item id="vkykskykseiymd" />
          <swak:item id="vkykskyksei" />
          <swak:item id="vkykskkkyktdk" />
        </swak:group>

        <%-- hjndaiyInfo --%>
        <swak:group id="hjndaiyInfo">
          <swak:item id="vkykshjndaiykkbn" />
          <swak:item id="IAW0004" />
          <swak:item id="vkykshjndaiyknm" />
          <swak:item id="IAW0005" />
          <swak:item id="vkykshjndainmkn" />
          <swak:item id="vkykshjndainmkj" />
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

        <%-- ●被保険者 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="vhhkshhknnmkn" />
          <swak:item id="vhhkshhknnmkj" />
          <swak:item id="vhhkshhknnmkjkhukakbn" />
          <swak:item id="vhhkshhknseiymd" />
          <swak:item id="vhhkshhknsei" />
        </swak:group>

        <%-- ●被保険者代理人 --%>
        <swak:group id="siteiseikyuuInfo">
          <swak:item id="vstsksiteidruktkbn" />
          <swak:item id="vstskstdrsknmkn" />
          <swak:item id="vstskstdrsknmkj" />
          <swak:item id="vstskstdrsknmkjhukakbn" />
          <swak:item id="vstskstdrskseiymd" />
        </swak:group>

        <%-- ●申出人 --%>
        <swak:group id="mousideninInfo">
          <swak:item id="mousideninkbn" />
        </swak:group>

        <%-- ●訂正区分 --%>
        <swak:group id="teiseikbnInfo">
          <swak:item id="teiseikbn" />
        </swak:group>

        <%-- dummyInfo --%>
        <swak:group id="dummyInfo">
          <swak:item id="dummykmk1" />
          <swak:item id="IIC0027" />
          <swak:item id="IIC0028" />
          <swak:item id="dummykmk2" />
        </swak:group>

        <%-- ●登録家族（１人目） --%>
        <swak:group id="trkkzkInfo1">
          <swak:item id="dummykmk3" />
          <swak:item id="trkkzkttdkkbn1" />
          <swak:item id="trkkzknmkn1" />
          <swak:item id="newtrkkzknmkn1" />
          <swak:item id="trkkzknmkj1" />
          <swak:item id="trkkzknmkjkhukakbn1" />
          <swak:item id="newtrkkzknmkj1" />
          <swak:item id="newtrkkzknmkjkhuka1" />
          <swak:item id="newtrkkzknmkjkhukakbn1" />
          <swak:item id="trkkzkseiymd1" />
          <swak:item id="newtrkkzkseiymd1" />
          <swak:item id="trkkzksei1" />
          <swak:item id="newtrkkzksei1" />
          <swak:item id="trkkzktsindousiteikbn1" />
          <swak:item id="newtrkkzktsindousiteikbn1" />
          <swak:item id="trkkzkyno1" />
          <swak:item id="newtrkkzkyno1" />
          <swak:item id="trkkzkadr1kj1" />
          <swak:item id="trkkzkadr2kj1" />
          <swak:item id="trkkzkadr3kj1" />
          <swak:item id="newtrkkzkadr1kj1" />
          <swak:item id="newtrkkzkadr2kj1" />
          <swak:item id="newtrkkzkadr3kj1" />
          <swak:item id="trkkzktelno1" />
          <swak:item id="newtrkkzktelno1" />
          <swak:item id="trkkzktdk1" />
          <swak:item id="IIC1006" />
          <swak:item id="newtrkkzktdk1" />
          <swak:item id="IIC1006" />
        </swak:group>

        <%-- ●登録家族（２人目） --%>
        <swak:group id="trkkzkInfo2">
          <swak:item id="dummykmk4" />
          <swak:item id="trkkzkttdkkbn2" />
          <swak:item id="trkkzknmkn2" />
          <swak:item id="newtrkkzknmkn2" />
          <swak:item id="trkkzknmkj2" />
          <swak:item id="trkkzknmkjkhukakbn2" />
          <swak:item id="newtrkkzknmkj2" />
          <swak:item id="newtrkkzknmkjkhuka2" />
          <swak:item id="newtrkkzknmkjkhukakbn2" />
          <swak:item id="trkkzkseiymd2" />
          <swak:item id="newtrkkzkseiymd2" />
          <swak:item id="trkkzksei2" />
          <swak:item id="newtrkkzksei2" />
          <swak:item id="trkkzktsindousiteikbn2" />
          <swak:item id="newtrkkzktsindousiteikbn2" />
          <swak:item id="trkkzkyno2" />
          <swak:item id="newtrkkzkyno2" />
          <swak:item id="trkkzkadr1kj2" />
          <swak:item id="trkkzkadr2kj2" />
          <swak:item id="trkkzkadr3kj2" />
          <swak:item id="newtrkkzkadr1kj2" />
          <swak:item id="newtrkkzkadr2kj2" />
          <swak:item id="newtrkkzkadr3kj2" />
          <swak:item id="trkkzktelno2" />
          <swak:item id="newtrkkzktelno2" />
          <swak:item id="trkkzktdk2" />
          <swak:item id="IIC1006" />
          <swak:item id="newtrkkzktdk2" />
          <swak:item id="IIC1006" />
        </swak:group>

        <%-- ●契約者代理特約 --%>
        <swak:group id="kyksyadairitkInfo">
          <swak:item id="dummykmk5" />
          <swak:item id="kykdrtkykttdkkbn" />
          <swak:item id="kykdrkbn" />
          <swak:item id="newkykdrkbn" />
          <swak:item id="kykdairinmkn" />
          <swak:item id="newkykdrnmkn" />
          <swak:item id="kykdairinmkj" />
          <swak:item id="kykdrnmkjkhukakbn" />
          <swak:item id="newkykdrnmkj" />
          <swak:item id="newkykdrnmkjkhuka" />
          <swak:item id="newkykdrnmkjkhukakbn" />
          <swak:item id="kykdrseiymd" />
          <swak:item id="newkykdrseiymd" />
          <swak:item id="kykdryno" />
          <swak:item id="newkykdryno" />
          <swak:item id="kykdradr1kj" />
          <swak:item id="kykdradr2kj" />
          <swak:item id="kykdradr3kj" />
          <swak:item id="newkykdradr1kj" />
          <swak:item id="newkykdradr2kj" />
          <swak:item id="newkykdradr3kj" />
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
