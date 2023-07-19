<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：証券再発行
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khsyoukensaihakkou/KhSyoukenSaihakkou.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiinfo">
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

        <%-- ●保障内容 --%>
        <swak:group id="hosyouInfo">
          <swak:item id="vhsyusyusyouhnnm" />
          <swak:item id="vhsyuaisyoumeikbn" />
          <swak:item id="vhsyusyukyktuukasyu" />
          <swak:item id="vhsyusyukykjisiteituukasyu" />
          <swak:item id="vhsyusyukatakbn" />
          <swak:item id="vhsyusyukyhgndkatakbn" />
          <swak:item id="vhsyusyuhhknnen" />
          <swak:item id="vhsyusyukykymd" />
          <swak:item id="vhsyusyusknnkaisiymd" />
          <swak:item id="vhsyugansknnkaisiymd" />
          <swak:item id="vhsyusyufktsknnkaisiymd" />
          <swak:item id="vhsyuhkgogansknnkaisiymd" />
          <swak:item id="vhsyuyendthnkymd" />
          <swak:item id="vhsyutmttknitenymd" />
          <swak:item id="vhsyusyuhknkkn" />
          <swak:item id="vhsyusyuhknkknsmnkbn" />
          <swak:item id="vhsyusyuhrkkkn" />
          <swak:item id="vhsyusyuhrkkknsmnkbn" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudai1hknkkn" />
          <swak:item id="vhsyusdpdkbn" />
          <swak:item id="vhsyusyukihonssyuruikbn" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyusyukihons" />
          <swak:item id="vhsyudispsyutsnshrgndgk" />
          <swak:item id="vhsyusyup" />
          <swak:item id="vhsyusyukykkjnkngk" />
          <swak:item id="vhsyugenzaisbhknkngaku" />
          <swak:item id="vhsyusaigaisbhknkngaku" />
          <swak:item id="vhsyusyukihonkyhgk" />
          <swak:item id="vhsyusyunextkosgop" />
          <swak:item id="vhsyusyusyukyhkinkatakbn" />
          <swak:item id="vhsyusyurokudaildkbn" />
          <swak:item id="vhsyusyugannyukyhntgk" />
          <swak:item id="vhsyusyushrskgnstartymd" />
          <swak:item id="vhsyusyushrskgnendymd" />
          <swak:item id="vhsyusyushrskgngos" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyusyunkshrstartymd" />
          <swak:item id="vhsyusyunnkinsyukbn" />
          <swak:item id="vhsyusyunenkinkkn" />
          <swak:item id="vhsyugenzaitmttkngk" />
          <swak:item id="vhsyuteiritutmttkngk" />
          <swak:item id="vhsyuteiritutmttrate" />
          <swak:item id="vhsyusisuurendoutmttkngk" />
          <swak:item id="vhsyusisuurendourate" />
          <swak:item id="vhsyusisuunm" />
          <swak:item id="vhsyusetteibairitu" />
          <swak:item id="vhsyuyoteiriritu" />
          <swak:item id="vhsyutumitateriritu" />
          <swak:item id="vhsyukyktumitateriritu" />
          <swak:item id="IIW1003" />
          <swak:item id="vhsyu10nentumitateriritu" />
          <swak:item id="IIW1015" />
          <swak:item id="vhsyukyksjkkktyouseiriritu" />
          <swak:item id="IIW1003" />
          <swak:item id="vhsyuskisjkkktyouseiriritu" />
          <swak:item id="IIW1004" />
          <swak:item id="vhsyusyutkjyskgnkkn" />
          <swak:item id="vhsyusyutkjyskgnhkndsymd1" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyusyutkjyskgnhkndeymd1" />
          <swak:item id="vhsyusyutkjyskgns1" />
          <swak:item id="vhsyusyutkjyskgnhkndsymd2" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyusyutkjyskgnhkndeymd2" />
          <swak:item id="vhsyusyutkjyskgns2" />
          <swak:item id="vhsyusyutkjyskgnhkndsymd3" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyusyutkjyskgnhkndeymd3" />
          <swak:item id="vhsyusyutkjyskgns3" />
          <swak:item id="vhsyusyutkjyskgnhkndsymd4" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyusyutkjyskgnhkndeymd4" />
          <swak:item id="vhsyusyutkjyskgns4" />
          <swak:item id="vhsyusyutkjyskgnhkndsymd5" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyusyutkjyskgnhkndeymd5" />
          <swak:item id="vhsyusyutkjyskgns5" />
          <swak:item id="vhsyusyutkjyhyouten" />
          <swak:item id="vhsyusyutkjyp" />
          <swak:item id="vhsyusyuhtnpbuicd1" />
          <swak:item id="vhsyusyuhtnpbuinm1" />
          <swak:item id="vhsyusyuhtnpkkn1" />
          <swak:item id="vhsyusyuhtnpbuicd2" />
          <swak:item id="vhsyusyuhtnpbuinm2" />
          <swak:item id="vhsyusyuhtnpkkn2" />
          <swak:item id="vhsyusyuhtnpbuicd3" />
          <swak:item id="vhsyusyuhtnpbuinm3" />
          <swak:item id="vhsyusyuhtnpkkn3" />
          <swak:item id="vhsyusyuhtnpbuicd4" />
          <swak:item id="vhsyusyuhtnpbuinm4" />
          <swak:item id="vhsyusyuhtnpkkn4" />
          <swak:item id="vhsyusyutokkdsghtnpkbn" />
          <swak:item id="vhsyusyututakngk" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyusyukouryokuhasseiymd" />
        </swak:group>

        <%-- 　＜特別勘定情報＞ --%>
        <swak:dataTable id="tbktInfo">
          <swak:column id="vhsyudispfundunitkbnval" />
          <swak:column id="vhsyudispfundunitkbn" />
          <swak:column id="vhsyudispunitsuu" />
          <swak:column id="vhsyudispfundindex" />
          <swak:column id="vhsyudisptutakngk" />
          <swak:column id="vhsyudispwariai" />
        </swak:dataTable>

        <%-- tbktInfomessage --%>
        <swak:group id="tbktInfomessage">
          <swak:item id="IIC1002" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo">
          <swak:item id="vhsyudisptksyouhnnm" />
          <swak:item id="vhsyunkshrtkyknksyukbn" />
          <swak:item id="vhsyunkshrtkyknksyukkn" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo1">
          <swak:item id="vhsyudisptksyouhnnm1" />
          <swak:item id="vhsyudisptkktuukasyu1" />
          <swak:item id="vhsyudisptokyakukatakbn1" />
          <swak:item id="vhsyudisptkkyhgdkatakbn1" />
          <swak:item id="vhsyudisptkhhknnen1" />
          <swak:item id="vhsyudisptkkykymd1" />
          <swak:item id="vhsyudisptksknnkaisiymd1" />
          <swak:item id="vhsyudisptkgaskkaisiymd1" />
          <swak:item id="vhsyudisptkhkskkaisiymd1" />
          <swak:item id="vhsyudisptkhkgskksiymd1" />
          <swak:item id="vhsyudisptkhknkkn1" />
          <swak:item id="vhsyudisptkhknkknsmnkbn1" />
          <swak:item id="vhsyudisptkhrkkkn1" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn1" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn1" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons1" />
          <swak:item id="vhsyudisptktsnshrgndgk1" />
          <swak:item id="vhsyudisptkp1" />
          <swak:item id="vhsyudisptkkihonkyhgk1" />
          <swak:item id="vhsyudisptknextkosgop1" />
          <swak:item id="vhsyudisptksykyhkatakbn1" />
          <swak:item id="vhsyudisptk6daildkbn1" />
          <swak:item id="vhsyudisptkganyukyhntgk1" />
          <swak:item id="vhsyudisptkshrskgstrymd1" />
          <swak:item id="vhsyudisptkshrskgnedymd1" />
          <swak:item id="vhsyudisptkshrskgngos1" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn1" />
          <swak:item id="vhsyudisptknenkinkkn1" />
          <swak:item id="vhsyudisptktkjyskgnkkn1" />
          <swak:item id="vhsyudisptktkjkhkdsymd11" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd11" />
          <swak:item id="vhsyudisptktkjyskgns11" />
          <swak:item id="vhsyudisptktkjkhkdsymd21" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd21" />
          <swak:item id="vhsyudisptktkjyskgns21" />
          <swak:item id="vhsyudisptktkjkhkdsymd31" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd31" />
          <swak:item id="vhsyudisptktkjyskgns31" />
          <swak:item id="vhsyudisptktkjkhkdsymd41" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd41" />
          <swak:item id="vhsyudisptktkjyskgns41" />
          <swak:item id="vhsyudisptktkjkhkdsymd51" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd51" />
          <swak:item id="vhsyudisptktkjyskgns51" />
          <swak:item id="vhsyudisptktkjyhyouten1" />
          <swak:item id="vhsyudisptktkjyp1" />
          <swak:item id="vhsyudisptkhtnpbuicd11" />
          <swak:item id="vhsyudisptkhtnpbuinm11" />
          <swak:item id="vhsyudisptkhtnpkkn11" />
          <swak:item id="vhsyudisptkhtnpbuicd21" />
          <swak:item id="vhsyudisptkhtnpbuinm21" />
          <swak:item id="vhsyudisptkhtnpkkn21" />
          <swak:item id="vhsyudisptkhtnpbuicd31" />
          <swak:item id="vhsyudisptkhtnpbuinm31" />
          <swak:item id="vhsyudisptkhtnpkkn31" />
          <swak:item id="vhsyudisptkhtnpbuicd41" />
          <swak:item id="vhsyudisptkhtnpbuinm41" />
          <swak:item id="vhsyudisptkhtnpkkn41" />
          <swak:item id="vhsyudisptktkkdsghtpkbn1" />
          <swak:item id="vhsyudisptktutakngk1" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd1" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo2">
          <swak:item id="vhsyudisptksyouhnnm2" />
          <swak:item id="vhsyudisptkktuukasyu2" />
          <swak:item id="vhsyudisptokyakukatakbn2" />
          <swak:item id="vhsyudisptkkyhgdkatakbn2" />
          <swak:item id="vhsyudisptkhhknnen2" />
          <swak:item id="vhsyudisptkkykymd2" />
          <swak:item id="vhsyudisptksknnkaisiymd2" />
          <swak:item id="vhsyudisptkgaskkaisiymd2" />
          <swak:item id="vhsyudisptkhkskkaisiymd2" />
          <swak:item id="vhsyudisptkhkgskksiymd2" />
          <swak:item id="vhsyudisptkhknkkn2" />
          <swak:item id="vhsyudisptkhknkknsmnkbn2" />
          <swak:item id="vhsyudisptkhrkkkn2" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn2" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn2" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons2" />
          <swak:item id="vhsyudisptktsnshrgndgk2" />
          <swak:item id="vhsyudisptkp2" />
          <swak:item id="vhsyudisptkkihonkyhgk2" />
          <swak:item id="vhsyudisptknextkosgop2" />
          <swak:item id="vhsyudisptksykyhkatakbn2" />
          <swak:item id="vhsyudisptk6daildkbn2" />
          <swak:item id="vhsyudisptkganyukyhntgk2" />
          <swak:item id="vhsyudisptkshrskgstrymd2" />
          <swak:item id="vhsyudisptkshrskgnedymd2" />
          <swak:item id="vhsyudisptkshrskgngos2" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn2" />
          <swak:item id="vhsyudisptknenkinkkn2" />
          <swak:item id="vhsyudisptktkjyskgnkkn2" />
          <swak:item id="vhsyudisptktkjkhkdsymd12" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd12" />
          <swak:item id="vhsyudisptktkjyskgns12" />
          <swak:item id="vhsyudisptktkjkhkdsymd22" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd22" />
          <swak:item id="vhsyudisptktkjyskgns22" />
          <swak:item id="vhsyudisptktkjkhkdsymd32" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd32" />
          <swak:item id="vhsyudisptktkjyskgns32" />
          <swak:item id="vhsyudisptktkjkhkdsymd42" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd42" />
          <swak:item id="vhsyudisptktkjyskgns42" />
          <swak:item id="vhsyudisptktkjkhkdsymd52" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd52" />
          <swak:item id="vhsyudisptktkjyskgns52" />
          <swak:item id="vhsyudisptktkjyhyouten2" />
          <swak:item id="vhsyudisptktkjyp2" />
          <swak:item id="vhsyudisptkhtnpbuicd12" />
          <swak:item id="vhsyudisptkhtnpbuinm12" />
          <swak:item id="vhsyudisptkhtnpkkn12" />
          <swak:item id="vhsyudisptkhtnpbuicd22" />
          <swak:item id="vhsyudisptkhtnpbuinm22" />
          <swak:item id="vhsyudisptkhtnpkkn22" />
          <swak:item id="vhsyudisptkhtnpbuicd32" />
          <swak:item id="vhsyudisptkhtnpbuinm32" />
          <swak:item id="vhsyudisptkhtnpkkn32" />
          <swak:item id="vhsyudisptkhtnpbuicd42" />
          <swak:item id="vhsyudisptkhtnpbuinm42" />
          <swak:item id="vhsyudisptkhtnpkkn42" />
          <swak:item id="vhsyudisptktkkdsghtpkbn2" />
          <swak:item id="vhsyudisptktutakngk2" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd2" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo3">
          <swak:item id="vhsyudisptksyouhnnm3" />
          <swak:item id="vhsyudisptkktuukasyu3" />
          <swak:item id="vhsyudisptokyakukatakbn3" />
          <swak:item id="vhsyudisptkkyhgdkatakbn3" />
          <swak:item id="vhsyudisptkhhknnen3" />
          <swak:item id="vhsyudisptkkykymd3" />
          <swak:item id="vhsyudisptksknnkaisiymd3" />
          <swak:item id="vhsyudisptkgaskkaisiymd3" />
          <swak:item id="vhsyudisptkhkskkaisiymd3" />
          <swak:item id="vhsyudisptkhkgskksiymd3" />
          <swak:item id="vhsyudisptkhknkkn3" />
          <swak:item id="vhsyudisptkhknkknsmnkbn3" />
          <swak:item id="vhsyudisptkhrkkkn3" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn3" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn3" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons3" />
          <swak:item id="vhsyudisptktsnshrgndgk3" />
          <swak:item id="vhsyudisptkp3" />
          <swak:item id="vhsyudisptkkihonkyhgk3" />
          <swak:item id="vhsyudisptknextkosgop3" />
          <swak:item id="vhsyudisptksykyhkatakbn3" />
          <swak:item id="vhsyudisptk6daildkbn3" />
          <swak:item id="vhsyudisptkganyukyhntgk3" />
          <swak:item id="vhsyudisptkshrskgstrymd3" />
          <swak:item id="vhsyudisptkshrskgnedymd3" />
          <swak:item id="vhsyudisptkshrskgngos3" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn3" />
          <swak:item id="vhsyudisptknenkinkkn3" />
          <swak:item id="vhsyudisptktkjyskgnkkn3" />
          <swak:item id="vhsyudisptktkjkhkdsymd13" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd13" />
          <swak:item id="vhsyudisptktkjyskgns13" />
          <swak:item id="vhsyudisptktkjkhkdsymd23" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd23" />
          <swak:item id="vhsyudisptktkjyskgns23" />
          <swak:item id="vhsyudisptktkjkhkdsymd33" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd33" />
          <swak:item id="vhsyudisptktkjyskgns33" />
          <swak:item id="vhsyudisptktkjkhkdsymd43" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd43" />
          <swak:item id="vhsyudisptktkjyskgns43" />
          <swak:item id="vhsyudisptktkjkhkdsymd53" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd53" />
          <swak:item id="vhsyudisptktkjyskgns53" />
          <swak:item id="vhsyudisptktkjyhyouten3" />
          <swak:item id="vhsyudisptktkjyp3" />
          <swak:item id="vhsyudisptkhtnpbuicd13" />
          <swak:item id="vhsyudisptkhtnpbuinm13" />
          <swak:item id="vhsyudisptkhtnpkkn13" />
          <swak:item id="vhsyudisptkhtnpbuicd23" />
          <swak:item id="vhsyudisptkhtnpbuinm23" />
          <swak:item id="vhsyudisptkhtnpkkn23" />
          <swak:item id="vhsyudisptkhtnpbuicd33" />
          <swak:item id="vhsyudisptkhtnpbuinm33" />
          <swak:item id="vhsyudisptkhtnpkkn33" />
          <swak:item id="vhsyudisptkhtnpbuicd43" />
          <swak:item id="vhsyudisptkhtnpbuinm43" />
          <swak:item id="vhsyudisptkhtnpkkn43" />
          <swak:item id="vhsyudisptktkkdsghtpkbn3" />
          <swak:item id="vhsyudisptktutakngk3" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd3" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo4">
          <swak:item id="vhsyudisptksyouhnnm4" />
          <swak:item id="vhsyudisptkktuukasyu4" />
          <swak:item id="vhsyudisptokyakukatakbn4" />
          <swak:item id="vhsyudisptkkyhgdkatakbn4" />
          <swak:item id="vhsyudisptkhhknnen4" />
          <swak:item id="vhsyudisptkkykymd4" />
          <swak:item id="vhsyudisptksknnkaisiymd4" />
          <swak:item id="vhsyudisptkgaskkaisiymd4" />
          <swak:item id="vhsyudisptkhkskkaisiymd4" />
          <swak:item id="vhsyudisptkhkgskksiymd4" />
          <swak:item id="vhsyudisptkhknkkn4" />
          <swak:item id="vhsyudisptkhknkknsmnkbn4" />
          <swak:item id="vhsyudisptkhrkkkn4" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn4" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn4" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons4" />
          <swak:item id="vhsyudisptktsnshrgndgk4" />
          <swak:item id="vhsyudisptkp4" />
          <swak:item id="vhsyudisptkkihonkyhgk4" />
          <swak:item id="vhsyudisptknextkosgop4" />
          <swak:item id="vhsyudisptksykyhkatakbn4" />
          <swak:item id="vhsyudisptk6daildkbn4" />
          <swak:item id="vhsyudisptkganyukyhntgk4" />
          <swak:item id="vhsyudisptkshrskgstrymd4" />
          <swak:item id="vhsyudisptkshrskgnedymd4" />
          <swak:item id="vhsyudisptkshrskgngos4" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn4" />
          <swak:item id="vhsyudisptknenkinkkn4" />
          <swak:item id="vhsyudisptktkjyskgnkkn4" />
          <swak:item id="vhsyudisptktkjkhkdsymd14" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd14" />
          <swak:item id="vhsyudisptktkjyskgns14" />
          <swak:item id="vhsyudisptktkjkhkdsymd24" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd24" />
          <swak:item id="vhsyudisptktkjyskgns24" />
          <swak:item id="vhsyudisptktkjkhkdsymd34" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd34" />
          <swak:item id="vhsyudisptktkjyskgns34" />
          <swak:item id="vhsyudisptktkjkhkdsymd44" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd44" />
          <swak:item id="vhsyudisptktkjyskgns44" />
          <swak:item id="vhsyudisptktkjkhkdsymd54" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd54" />
          <swak:item id="vhsyudisptktkjyskgns54" />
          <swak:item id="vhsyudisptktkjyhyouten4" />
          <swak:item id="vhsyudisptktkjyp4" />
          <swak:item id="vhsyudisptkhtnpbuicd14" />
          <swak:item id="vhsyudisptkhtnpbuinm14" />
          <swak:item id="vhsyudisptkhtnpkkn14" />
          <swak:item id="vhsyudisptkhtnpbuicd24" />
          <swak:item id="vhsyudisptkhtnpbuinm24" />
          <swak:item id="vhsyudisptkhtnpkkn24" />
          <swak:item id="vhsyudisptkhtnpbuicd34" />
          <swak:item id="vhsyudisptkhtnpbuinm34" />
          <swak:item id="vhsyudisptkhtnpkkn34" />
          <swak:item id="vhsyudisptkhtnpbuicd44" />
          <swak:item id="vhsyudisptkhtnpbuinm44" />
          <swak:item id="vhsyudisptkhtnpkkn44" />
          <swak:item id="vhsyudisptktkkdsghtpkbn4" />
          <swak:item id="vhsyudisptktutakngk4" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd4" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo5">
          <swak:item id="vhsyudisptksyouhnnm5" />
          <swak:item id="vhsyudisptkktuukasyu5" />
          <swak:item id="vhsyudisptokyakukatakbn5" />
          <swak:item id="vhsyudisptkkyhgdkatakbn5" />
          <swak:item id="vhsyudisptkhhknnen5" />
          <swak:item id="vhsyudisptkkykymd5" />
          <swak:item id="vhsyudisptksknnkaisiymd5" />
          <swak:item id="vhsyudisptkgaskkaisiymd5" />
          <swak:item id="vhsyudisptkhkskkaisiymd5" />
          <swak:item id="vhsyudisptkhkgskksiymd5" />
          <swak:item id="vhsyudisptkhknkkn5" />
          <swak:item id="vhsyudisptkhknkknsmnkbn5" />
          <swak:item id="vhsyudisptkhrkkkn5" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn5" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn5" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons5" />
          <swak:item id="vhsyudisptktsnshrgndgk5" />
          <swak:item id="vhsyudisptkp5" />
          <swak:item id="vhsyudisptkkihonkyhgk5" />
          <swak:item id="vhsyudisptknextkosgop5" />
          <swak:item id="vhsyudisptksykyhkatakbn5" />
          <swak:item id="vhsyudisptk6daildkbn5" />
          <swak:item id="vhsyudisptkganyukyhntgk5" />
          <swak:item id="vhsyudisptkshrskgstrymd5" />
          <swak:item id="vhsyudisptkshrskgnedymd5" />
          <swak:item id="vhsyudisptkshrskgngos5" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn5" />
          <swak:item id="vhsyudisptknenkinkkn5" />
          <swak:item id="vhsyudisptktkjyskgnkkn5" />
          <swak:item id="vhsyudisptktkjkhkdsymd15" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd15" />
          <swak:item id="vhsyudisptktkjyskgns15" />
          <swak:item id="vhsyudisptktkjkhkdsymd25" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd25" />
          <swak:item id="vhsyudisptktkjyskgns25" />
          <swak:item id="vhsyudisptktkjkhkdsymd35" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd35" />
          <swak:item id="vhsyudisptktkjyskgns35" />
          <swak:item id="vhsyudisptktkjkhkdsymd45" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd45" />
          <swak:item id="vhsyudisptktkjyskgns45" />
          <swak:item id="vhsyudisptktkjkhkdsymd55" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd55" />
          <swak:item id="vhsyudisptktkjyskgns55" />
          <swak:item id="vhsyudisptktkjyhyouten5" />
          <swak:item id="vhsyudisptktkjyp5" />
          <swak:item id="vhsyudisptkhtnpbuicd15" />
          <swak:item id="vhsyudisptkhtnpbuinm15" />
          <swak:item id="vhsyudisptkhtnpkkn15" />
          <swak:item id="vhsyudisptkhtnpbuicd25" />
          <swak:item id="vhsyudisptkhtnpbuinm25" />
          <swak:item id="vhsyudisptkhtnpkkn25" />
          <swak:item id="vhsyudisptkhtnpbuicd35" />
          <swak:item id="vhsyudisptkhtnpbuinm35" />
          <swak:item id="vhsyudisptkhtnpkkn35" />
          <swak:item id="vhsyudisptkhtnpbuicd45" />
          <swak:item id="vhsyudisptkhtnpbuinm45" />
          <swak:item id="vhsyudisptkhtnpkkn45" />
          <swak:item id="vhsyudisptktkkdsghtpkbn5" />
          <swak:item id="vhsyudisptktutakngk5" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd5" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo6">
          <swak:item id="vhsyudisptksyouhnnm6" />
          <swak:item id="vhsyudisptkktuukasyu6" />
          <swak:item id="vhsyudisptokyakukatakbn6" />
          <swak:item id="vhsyudisptkkyhgdkatakbn6" />
          <swak:item id="vhsyudisptkhhknnen6" />
          <swak:item id="vhsyudisptkkykymd6" />
          <swak:item id="vhsyudisptksknnkaisiymd6" />
          <swak:item id="vhsyudisptkgaskkaisiymd6" />
          <swak:item id="vhsyudisptkhkskkaisiymd6" />
          <swak:item id="vhsyudisptkhkgskksiymd6" />
          <swak:item id="vhsyudisptkhknkkn6" />
          <swak:item id="vhsyudisptkhknkknsmnkbn6" />
          <swak:item id="vhsyudisptkhrkkkn6" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn6" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn6" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons6" />
          <swak:item id="vhsyudisptktsnshrgndgk6" />
          <swak:item id="vhsyudisptkp6" />
          <swak:item id="vhsyudisptkkihonkyhgk6" />
          <swak:item id="vhsyudisptknextkosgop6" />
          <swak:item id="vhsyudisptksykyhkatakbn6" />
          <swak:item id="vhsyudisptk6daildkbn6" />
          <swak:item id="vhsyudisptkganyukyhntgk6" />
          <swak:item id="vhsyudisptkshrskgstrymd6" />
          <swak:item id="vhsyudisptkshrskgnedymd6" />
          <swak:item id="vhsyudisptkshrskgngos6" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn6" />
          <swak:item id="vhsyudisptknenkinkkn6" />
          <swak:item id="vhsyudisptktkjyskgnkkn6" />
          <swak:item id="vhsyudisptktkjkhkdsymd16" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd16" />
          <swak:item id="vhsyudisptktkjyskgns16" />
          <swak:item id="vhsyudisptktkjkhkdsymd26" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd26" />
          <swak:item id="vhsyudisptktkjyskgns26" />
          <swak:item id="vhsyudisptktkjkhkdsymd36" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd36" />
          <swak:item id="vhsyudisptktkjyskgns36" />
          <swak:item id="vhsyudisptktkjkhkdsymd46" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd46" />
          <swak:item id="vhsyudisptktkjyskgns46" />
          <swak:item id="vhsyudisptktkjkhkdsymd56" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd56" />
          <swak:item id="vhsyudisptktkjyskgns56" />
          <swak:item id="vhsyudisptktkjyhyouten6" />
          <swak:item id="vhsyudisptktkjyp6" />
          <swak:item id="vhsyudisptkhtnpbuicd16" />
          <swak:item id="vhsyudisptkhtnpbuinm16" />
          <swak:item id="vhsyudisptkhtnpkkn16" />
          <swak:item id="vhsyudisptkhtnpbuicd26" />
          <swak:item id="vhsyudisptkhtnpbuinm26" />
          <swak:item id="vhsyudisptkhtnpkkn26" />
          <swak:item id="vhsyudisptkhtnpbuicd36" />
          <swak:item id="vhsyudisptkhtnpbuinm36" />
          <swak:item id="vhsyudisptkhtnpkkn36" />
          <swak:item id="vhsyudisptkhtnpbuicd46" />
          <swak:item id="vhsyudisptkhtnpbuinm46" />
          <swak:item id="vhsyudisptkhtnpkkn46" />
          <swak:item id="vhsyudisptktkkdsghtpkbn6" />
          <swak:item id="vhsyudisptktutakngk6" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd6" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo7">
          <swak:item id="vhsyudisptksyouhnnm7" />
          <swak:item id="vhsyudisptkktuukasyu7" />
          <swak:item id="vhsyudisptokyakukatakbn7" />
          <swak:item id="vhsyudisptkkyhgdkatakbn7" />
          <swak:item id="vhsyudisptkhhknnen7" />
          <swak:item id="vhsyudisptkkykymd7" />
          <swak:item id="vhsyudisptksknnkaisiymd7" />
          <swak:item id="vhsyudisptkgaskkaisiymd7" />
          <swak:item id="vhsyudisptkhkskkaisiymd7" />
          <swak:item id="vhsyudisptkhkgskksiymd7" />
          <swak:item id="vhsyudisptkhknkkn7" />
          <swak:item id="vhsyudisptkhknkknsmnkbn7" />
          <swak:item id="vhsyudisptkhrkkkn7" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn7" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn7" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons7" />
          <swak:item id="vhsyudisptktsnshrgndgk7" />
          <swak:item id="vhsyudisptkp7" />
          <swak:item id="vhsyudisptkkihonkyhgk7" />
          <swak:item id="vhsyudisptknextkosgop7" />
          <swak:item id="vhsyudisptksykyhkatakbn7" />
          <swak:item id="vhsyudisptk6daildkbn7" />
          <swak:item id="vhsyudisptkganyukyhntgk7" />
          <swak:item id="vhsyudisptkshrskgstrymd7" />
          <swak:item id="vhsyudisptkshrskgnedymd7" />
          <swak:item id="vhsyudisptkshrskgngos7" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn7" />
          <swak:item id="vhsyudisptknenkinkkn7" />
          <swak:item id="vhsyudisptktkjyskgnkkn7" />
          <swak:item id="vhsyudisptktkjkhkdsymd17" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd17" />
          <swak:item id="vhsyudisptktkjyskgns17" />
          <swak:item id="vhsyudisptktkjkhkdsymd27" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd27" />
          <swak:item id="vhsyudisptktkjyskgns27" />
          <swak:item id="vhsyudisptktkjkhkdsymd37" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd37" />
          <swak:item id="vhsyudisptktkjyskgns37" />
          <swak:item id="vhsyudisptktkjkhkdsymd47" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd47" />
          <swak:item id="vhsyudisptktkjyskgns47" />
          <swak:item id="vhsyudisptktkjkhkdsymd57" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd57" />
          <swak:item id="vhsyudisptktkjyskgns57" />
          <swak:item id="vhsyudisptktkjyhyouten7" />
          <swak:item id="vhsyudisptktkjyp7" />
          <swak:item id="vhsyudisptkhtnpbuicd17" />
          <swak:item id="vhsyudisptkhtnpbuinm17" />
          <swak:item id="vhsyudisptkhtnpkkn17" />
          <swak:item id="vhsyudisptkhtnpbuicd27" />
          <swak:item id="vhsyudisptkhtnpbuinm27" />
          <swak:item id="vhsyudisptkhtnpkkn27" />
          <swak:item id="vhsyudisptkhtnpbuicd37" />
          <swak:item id="vhsyudisptkhtnpbuinm37" />
          <swak:item id="vhsyudisptkhtnpkkn37" />
          <swak:item id="vhsyudisptkhtnpbuicd47" />
          <swak:item id="vhsyudisptkhtnpbuinm47" />
          <swak:item id="vhsyudisptkhtnpkkn47" />
          <swak:item id="vhsyudisptktkkdsghtpkbn7" />
          <swak:item id="vhsyudisptktutakngk7" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd7" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo8">
          <swak:item id="vhsyudisptksyouhnnm8" />
          <swak:item id="vhsyudisptkktuukasyu8" />
          <swak:item id="vhsyudisptokyakukatakbn8" />
          <swak:item id="vhsyudisptkkyhgdkatakbn8" />
          <swak:item id="vhsyudisptkhhknnen8" />
          <swak:item id="vhsyudisptkkykymd8" />
          <swak:item id="vhsyudisptksknnkaisiymd8" />
          <swak:item id="vhsyudisptkgaskkaisiymd8" />
          <swak:item id="vhsyudisptkhkskkaisiymd8" />
          <swak:item id="vhsyudisptkhkgskksiymd8" />
          <swak:item id="vhsyudisptkhknkkn8" />
          <swak:item id="vhsyudisptkhknkknsmnkbn8" />
          <swak:item id="vhsyudisptkhrkkkn8" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn8" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn8" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons8" />
          <swak:item id="vhsyudisptktsnshrgndgk8" />
          <swak:item id="vhsyudisptkp8" />
          <swak:item id="vhsyudisptkkihonkyhgk8" />
          <swak:item id="vhsyudisptknextkosgop8" />
          <swak:item id="vhsyudisptksykyhkatakbn8" />
          <swak:item id="vhsyudisptk6daildkbn8" />
          <swak:item id="vhsyudisptkganyukyhntgk8" />
          <swak:item id="vhsyudisptkshrskgstrymd8" />
          <swak:item id="vhsyudisptkshrskgnedymd8" />
          <swak:item id="vhsyudisptkshrskgngos8" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn8" />
          <swak:item id="vhsyudisptknenkinkkn8" />
          <swak:item id="vhsyudisptktkjyskgnkkn8" />
          <swak:item id="vhsyudisptktkjkhkdsymd18" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd18" />
          <swak:item id="vhsyudisptktkjyskgns18" />
          <swak:item id="vhsyudisptktkjkhkdsymd28" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd28" />
          <swak:item id="vhsyudisptktkjyskgns28" />
          <swak:item id="vhsyudisptktkjkhkdsymd38" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd38" />
          <swak:item id="vhsyudisptktkjyskgns38" />
          <swak:item id="vhsyudisptktkjkhkdsymd48" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd48" />
          <swak:item id="vhsyudisptktkjyskgns48" />
          <swak:item id="vhsyudisptktkjkhkdsymd58" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd58" />
          <swak:item id="vhsyudisptktkjyskgns58" />
          <swak:item id="vhsyudisptktkjyhyouten8" />
          <swak:item id="vhsyudisptktkjyp8" />
          <swak:item id="vhsyudisptkhtnpbuicd18" />
          <swak:item id="vhsyudisptkhtnpbuinm18" />
          <swak:item id="vhsyudisptkhtnpkkn18" />
          <swak:item id="vhsyudisptkhtnpbuicd28" />
          <swak:item id="vhsyudisptkhtnpbuinm28" />
          <swak:item id="vhsyudisptkhtnpkkn28" />
          <swak:item id="vhsyudisptkhtnpbuicd38" />
          <swak:item id="vhsyudisptkhtnpbuinm38" />
          <swak:item id="vhsyudisptkhtnpkkn38" />
          <swak:item id="vhsyudisptkhtnpbuicd48" />
          <swak:item id="vhsyudisptkhtnpbuinm48" />
          <swak:item id="vhsyudisptkhtnpkkn48" />
          <swak:item id="vhsyudisptktkkdsghtpkbn8" />
          <swak:item id="vhsyudisptktutakngk8" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd8" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo9">
          <swak:item id="vhsyudisptksyouhnnm9" />
          <swak:item id="vhsyudisptkktuukasyu9" />
          <swak:item id="vhsyudisptokyakukatakbn9" />
          <swak:item id="vhsyudisptkkyhgdkatakbn9" />
          <swak:item id="vhsyudisptkhhknnen9" />
          <swak:item id="vhsyudisptkkykymd9" />
          <swak:item id="vhsyudisptksknnkaisiymd9" />
          <swak:item id="vhsyudisptkgaskkaisiymd9" />
          <swak:item id="vhsyudisptkhkskkaisiymd9" />
          <swak:item id="vhsyudisptkhkgskksiymd9" />
          <swak:item id="vhsyudisptkhknkkn9" />
          <swak:item id="vhsyudisptkhknkknsmnkbn9" />
          <swak:item id="vhsyudisptkhrkkkn9" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn9" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn9" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons9" />
          <swak:item id="vhsyudisptktsnshrgndgk9" />
          <swak:item id="vhsyudisptkp9" />
          <swak:item id="vhsyudisptkkihonkyhgk9" />
          <swak:item id="vhsyudisptknextkosgop9" />
          <swak:item id="vhsyudisptksykyhkatakbn9" />
          <swak:item id="vhsyudisptk6daildkbn9" />
          <swak:item id="vhsyudisptkganyukyhntgk9" />
          <swak:item id="vhsyudisptkshrskgstrymd9" />
          <swak:item id="vhsyudisptkshrskgnedymd9" />
          <swak:item id="vhsyudisptkshrskgngos9" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn9" />
          <swak:item id="vhsyudisptknenkinkkn9" />
          <swak:item id="vhsyudisptktkjyskgnkkn9" />
          <swak:item id="vhsyudisptktkjkhkdsymd19" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd19" />
          <swak:item id="vhsyudisptktkjyskgns19" />
          <swak:item id="vhsyudisptktkjkhkdsymd29" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd29" />
          <swak:item id="vhsyudisptktkjyskgns29" />
          <swak:item id="vhsyudisptktkjkhkdsymd39" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd39" />
          <swak:item id="vhsyudisptktkjyskgns39" />
          <swak:item id="vhsyudisptktkjkhkdsymd49" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd49" />
          <swak:item id="vhsyudisptktkjyskgns49" />
          <swak:item id="vhsyudisptktkjkhkdsymd59" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd59" />
          <swak:item id="vhsyudisptktkjyskgns59" />
          <swak:item id="vhsyudisptktkjyhyouten9" />
          <swak:item id="vhsyudisptktkjyp9" />
          <swak:item id="vhsyudisptkhtnpbuicd19" />
          <swak:item id="vhsyudisptkhtnpbuinm19" />
          <swak:item id="vhsyudisptkhtnpkkn19" />
          <swak:item id="vhsyudisptkhtnpbuicd29" />
          <swak:item id="vhsyudisptkhtnpbuinm29" />
          <swak:item id="vhsyudisptkhtnpkkn29" />
          <swak:item id="vhsyudisptkhtnpbuicd39" />
          <swak:item id="vhsyudisptkhtnpbuinm39" />
          <swak:item id="vhsyudisptkhtnpkkn39" />
          <swak:item id="vhsyudisptkhtnpbuicd49" />
          <swak:item id="vhsyudisptkhtnpbuinm49" />
          <swak:item id="vhsyudisptkhtnpkkn49" />
          <swak:item id="vhsyudisptktkkdsghtpkbn9" />
          <swak:item id="vhsyudisptktutakngk9" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd9" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo10">
          <swak:item id="vhsyudisptksyouhnnm10" />
          <swak:item id="vhsyudisptkktuukasyu10" />
          <swak:item id="vhsyudisptokyakukatakbn10" />
          <swak:item id="vhsyudisptkkyhgdkatakbn10" />
          <swak:item id="vhsyudisptkhhknnen10" />
          <swak:item id="vhsyudisptkkykymd10" />
          <swak:item id="vhsyudisptksknnkaisiymd10" />
          <swak:item id="vhsyudisptkgaskkaisiymd10" />
          <swak:item id="vhsyudisptkhkskkaisiymd10" />
          <swak:item id="vhsyudisptkhkgskksiymd10" />
          <swak:item id="vhsyudisptkhknkkn10" />
          <swak:item id="vhsyudisptkhknkknsmnkbn10" />
          <swak:item id="vhsyudisptkhrkkkn10" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn10" />
          <swak:item id="IIW0002" />
          <swak:item id="vhsyudisptkkihsyuruikbn10" />
          <swak:item id="IIC0018" />
          <swak:item id="vhsyudisptkkihons10" />
          <swak:item id="vhsyudisptktsnshrgndgk10" />
          <swak:item id="vhsyudisptkp10" />
          <swak:item id="vhsyudisptkkihonkyhgk10" />
          <swak:item id="vhsyudisptknextkosgop10" />
          <swak:item id="vhsyudisptksykyhkatakbn10" />
          <swak:item id="vhsyudisptk6daildkbn10" />
          <swak:item id="vhsyudisptkganyukyhntgk10" />
          <swak:item id="vhsyudisptkshrskgstrymd10" />
          <swak:item id="vhsyudisptkshrskgnedymd10" />
          <swak:item id="vhsyudisptkshrskgngos10" />
          <swak:item id="IIC0009" />
          <swak:item id="vhsyudisptknenkinsyukbn10" />
          <swak:item id="vhsyudisptknenkinkkn10" />
          <swak:item id="vhsyudisptktkjyskgnkkn10" />
          <swak:item id="vhsyudisptktkjkhkdsymd110" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd110" />
          <swak:item id="vhsyudisptktkjyskgns110" />
          <swak:item id="vhsyudisptktkjkhkdsymd210" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd210" />
          <swak:item id="vhsyudisptktkjyskgns210" />
          <swak:item id="vhsyudisptktkjkhkdsymd310" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd310" />
          <swak:item id="vhsyudisptktkjyskgns310" />
          <swak:item id="vhsyudisptktkjkhkdsymd410" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd410" />
          <swak:item id="vhsyudisptktkjyskgns410" />
          <swak:item id="vhsyudisptktkjkhkdsymd510" />
          <swak:item id="IAW0003" />
          <swak:item id="vhsyudisptktkjkhkdeymd510" />
          <swak:item id="vhsyudisptktkjyskgns510" />
          <swak:item id="vhsyudisptktkjyhyouten10" />
          <swak:item id="vhsyudisptktkjyp10" />
          <swak:item id="vhsyudisptkhtnpbuicd110" />
          <swak:item id="vhsyudisptkhtnpbuinm110" />
          <swak:item id="vhsyudisptkhtnpkkn110" />
          <swak:item id="vhsyudisptkhtnpbuicd210" />
          <swak:item id="vhsyudisptkhtnpbuinm210" />
          <swak:item id="vhsyudisptkhtnpkkn210" />
          <swak:item id="vhsyudisptkhtnpbuicd310" />
          <swak:item id="vhsyudisptkhtnpbuinm310" />
          <swak:item id="vhsyudisptkhtnpkkn310" />
          <swak:item id="vhsyudisptkhtnpbuicd410" />
          <swak:item id="vhsyudisptkhtnpbuinm410" />
          <swak:item id="vhsyudisptkhtnpkkn410" />
          <swak:item id="vhsyudisptktkkdsghtpkbn10" />
          <swak:item id="vhsyudisptktutakngk10" />
          <swak:item id="IIC1001" />
          <swak:item id="vhsyudisptkkrkhasseiymd10" />
        </swak:group>

        <%-- ●その他特約・特則 --%>
        <swak:group id="sonotaTkInfo">
          <swak:item id="vsntkdisptkhukainfo" />
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

        <%-- buttonsyoukai --%>
        <swak:buttonGroup id="buttonsyoukai">
          <swak:item id="modorubtnbysyoukai" />
          <swak:item id="skssakuseibtn" />
        </swak:buttonGroup>

        <%-- ●証券再発行 --%>
        <swak:group id="syosaihkiInfo">
          <swak:item id="syoukensaihkkbn" />
        </swak:group>

        <%-- ●印紙税支払 --%>
        <swak:group id="insizeishrInfo">
          <swak:item id="insizeishryouhikbn" />
          <swak:item id="IIF1007" />
        </swak:group>

        <%-- ●本人確認 --%>
        <swak:group id="honninkakniInfo">
          <swak:item id="honninkakninkekkakbn" />
        </swak:group>

        <%-- ●発送区分 --%>
        <swak:group id="hassoukbniInfo">
          <swak:item id="hassoukbn" />
        </swak:group>

        <%-- ●結果入力 --%>
        <swak:group id="kekkaInfo">
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
