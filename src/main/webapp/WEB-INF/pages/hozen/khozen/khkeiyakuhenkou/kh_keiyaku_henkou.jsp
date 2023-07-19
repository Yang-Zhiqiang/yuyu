<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約変更
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khkeiyakuhenkou/KhKeiyakuHenkou.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●基本情報 --%>
        <swak:group id="kihonInfo">
          <swak:item id="syono" />
          <swak:item id="lastsyosaihkymd" />
          <swak:item id="yuukousyoumetukbn" />
          <swak:item id="kykjyoutai" />
          <swak:item id="syoumetujiyuu" />
          <swak:item id="syoumetuymd" />
          <swak:item id="mosymd" />
          <swak:item id="kktymd" />
          <swak:item id="mosukeymd" />
          <swak:item id="IIW0007" />
          <swak:item id="seirituymd" />
          <swak:item id="seisekiym" />
        </swak:group>

        <%-- 　＜別契約＞ --%>
        <swak:dataTable id="betukeiyakuList">
          <swak:column id="dispsetkykkbn" />
          <swak:column id="dispbtkyksyono" />
          <swak:column id="dispbtkykyuukousyoumetukbn" />
          <swak:column id="dispbtkykkykjyoutai" />
          <swak:column id="dispbtkykkykymd" />
          <swak:column id="dispbtkyksyoumetujiyuu" />
          <swak:column id="dispbtkyksyoumetuymd" />
          <swak:column id="dispbtkyksyouhnnm" />
        </swak:dataTable>

        <%-- ●書類情報一覧 --%>
        <swak:dataTable id="syoruiInfoList">
          <swak:column id="syoruittykymdtime" />
          <swak:column id="syoruinm" />
          <swak:column id="htysyoruiumukbn" />
          <swak:column id="hyoujilink" />
          <swak:column id="hyoujilinkflg" />
        </swak:dataTable>

        <%-- buttonAllhyouji --%>
        <swak:buttonGroup id="buttonAllhyouji">
          <swak:item id="allhyoujibtn" />
        </swak:buttonGroup>

        <%-- ●手続注意 --%>
        <swak:group id="tetudukityuuiInfo">
          <swak:item id="kktyuitakbn" />
          <swak:item id="ttdktyuuinaiyou1" />
          <swak:item id="ttdktyuuinaiyou2" />
          <swak:item id="ttdktyuuinaiyou3" />
        </swak:group>

        <%-- 手続注意区分内容 --%>
        <swak:dataTable id="ttdktyuuikbnInfo">
          <swak:column id="ttdktyuuikbn" />
          <swak:column id="ttdktyuuikbnhsknaiyou" />
          <swak:column id="ttdktyuuikbnsetymd" />
        </swak:dataTable>

        <%-- 質権設定 --%>
        <swak:group id="stknsetInfo">
          <swak:item id="stknsetkbn" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域１ --%>
        <swak:group id="dispFatcaInfo1">
          <swak:item id="dispfatcasnsikbn1" />
          <swak:item id="dispbikkjnssinfokbn1" />
          <swak:item id="dispfatcakekkbn1" />
          <swak:item id="dispfatcahankeiikbn1" />
          <swak:item id="dispbikknzsyno1" />
          <swak:item id="dispsyomeiymd1" />
          <swak:item id="dispfatcatgkbn1" />
          <swak:item id="dispnmkn1" />
          <swak:item id="dispnmkj1" />
          <swak:item id="dispseiymd1" />
          <swak:item id="dispsei1" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域２ --%>
        <swak:group id="dispFatcaInfo2">
          <swak:item id="dispfatcasnsikbn2" />
          <swak:item id="dispbikkjnssinfokbn2" />
          <swak:item id="dispfatcakekkbn2" />
          <swak:item id="dispfatcahankeiikbn2" />
          <swak:item id="dispbikknzsyno2" />
          <swak:item id="dispsyomeiymd2" />
          <swak:item id="dispfatcatgkbn2" />
          <swak:item id="dispnmkn2" />
          <swak:item id="dispnmkj2" />
          <swak:item id="dispseiymd2" />
          <swak:item id="dispsei2" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域３ --%>
        <swak:group id="dispFatcaInfo3">
          <swak:item id="dispfatcasnsikbn3" />
          <swak:item id="dispbikkjnssinfokbn3" />
          <swak:item id="dispfatcakekkbn3" />
          <swak:item id="dispfatcahankeiikbn3" />
          <swak:item id="dispbikknzsyno3" />
          <swak:item id="dispsyomeiymd3" />
          <swak:item id="dispfatcatgkbn3" />
          <swak:item id="dispnmkn3" />
          <swak:item id="dispnmkj3" />
          <swak:item id="dispseiymd3" />
          <swak:item id="dispsei3" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域４ --%>
        <swak:group id="dispFatcaInfo4">
          <swak:item id="dispfatcasnsikbn4" />
          <swak:item id="dispbikkjnssinfokbn4" />
          <swak:item id="dispfatcakekkbn4" />
          <swak:item id="dispfatcahankeiikbn4" />
          <swak:item id="dispbikknzsyno4" />
          <swak:item id="dispsyomeiymd4" />
          <swak:item id="dispfatcatgkbn4" />
          <swak:item id="dispnmkn4" />
          <swak:item id="dispnmkj4" />
          <swak:item id="dispseiymd4" />
          <swak:item id="dispsei4" />
        </swak:group>

        <%-- ＦＡＴＣＡ情報領域５ --%>
        <swak:group id="dispFatcaInfo5">
          <swak:item id="dispfatcasnsikbn5" />
          <swak:item id="dispbikkjnssinfokbn5" />
          <swak:item id="dispfatcakekkbn5" />
          <swak:item id="dispfatcahankeiikbn5" />
          <swak:item id="dispbikknzsyno5" />
          <swak:item id="dispsyomeiymd5" />
          <swak:item id="dispfatcatgkbn5" />
          <swak:item id="dispnmkn5" />
          <swak:item id="dispnmkj5" />
          <swak:item id="dispseiymd5" />
          <swak:item id="dispsei5" />
        </swak:group>

        <%-- ●契約者 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="kyknmkn" />
          <swak:item id="kyknmkj" />
          <swak:item id="kyknmkjkhukakbn" />
          <swak:item id="kykseiymd" />
          <swak:item id="kyksei" />
          <swak:item id="kkkyktdk" />
        </swak:group>

        <%-- hjndaiyInfo --%>
        <swak:group id="hjndaiyInfo">
          <swak:item id="hjndaiykkbn" />
          <swak:item id="IAW0004" />
          <swak:item id="hjndaiyknm" />
          <swak:item id="IAW0005" />
          <swak:item id="hjndainmkn" />
          <swak:item id="hjndainmkj" />
        </swak:group>

        <%-- ●通信先 --%>
        <swak:group id="tuusinsakiInfo">
          <swak:item id="tsinyno" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
          <swak:item id="tsinadr4kj" />
          <swak:item id="tsintelno" />
          <swak:item id="nittyuutelno" />
        </swak:group>

        <%-- ●被保険者 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
          <swak:item id="hhknnmkjkhukakbn" />
          <swak:item id="hhknseiymd" />
          <swak:item id="hhknsei" />
        </swak:group>

        <%-- ●保障内容 --%>
        <swak:group id="hosyouInfo">
          <swak:item id="syusyouhnnm" />
          <swak:item id="syukatakbn" />
          <swak:item id="syukyhgndkatakbn" />
          <swak:item id="syuhhknnen" />
          <swak:item id="syukykymd" />
          <swak:item id="syusknnkaisiymd" />
          <swak:item id="syugansknnkaisiymd" />
          <swak:item id="syufktsknnkaisiymd" />
          <swak:item id="syuhkgansknnkaisiymd" />
          <swak:item id="syuhknkkn" />
          <swak:item id="syuhknkknsmnkbn" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="syuhrkkkn" />
          <swak:item id="syuhrkkknsmnkbn" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="syukihonssyuruikbn" />
          <swak:item id="IIC0018" />
          <swak:item id="syukihons" />
          <swak:item id="dispsyutsnshrgndgk" />
          <swak:item id="syup" />
          <swak:item id="syukihonkyhgk" />
          <swak:item id="syunextkosgop" />
          <swak:item id="syusyukyhkinkatakbn" />
          <swak:item id="syurokudaildkbn" />
          <swak:item id="syugannyukyhntgk" />
          <swak:item id="syushrskgnstartymd" />
          <swak:item id="syushrskgnendymd" />
          <swak:item id="syushrskgngos" />
          <swak:item id="IIC0009" />
          <swak:item id="syukrnbkkn" />
          <swak:item id="syunkshrstartymd" />
          <swak:item id="syunnkinsyu" />
          <swak:item id="syunenkinkkn" />
          <swak:item id="IIC0025" />
          <swak:item id="syunknengk" />
          <swak:item id="syubnshrkaisuu" />
          <swak:item id="syutkjyskgnkkn" />
          <swak:item id="syutkjyskgnhknnndsymd1" />
          <swak:item id="IAW0003" />
          <swak:item id="syutkjyskgnhknnndeymd1" />
          <swak:item id="syutkjyskgns1" />
          <swak:item id="syutkjyskgnhknnndsymd2" />
          <swak:item id="IAW0003" />
          <swak:item id="syutkjyskgnhknnndeymd2" />
          <swak:item id="syutkjyskgns2" />
          <swak:item id="syutkjyskgnhknnndsymd3" />
          <swak:item id="IAW0003" />
          <swak:item id="syutkjyskgnhknnndeymd3" />
          <swak:item id="syutkjyskgns3" />
          <swak:item id="syutkjyskgnhknnndsymd4" />
          <swak:item id="IAW0003" />
          <swak:item id="syutkjyskgnhknnndeymd4" />
          <swak:item id="syutkjyskgns4" />
          <swak:item id="syutkjyskgnhknnndsymd5" />
          <swak:item id="IAW0003" />
          <swak:item id="syutkjyskgnhknnndeymd5" />
          <swak:item id="syutkjyskgns5" />
          <swak:item id="syutkjyhyouten" />
          <swak:item id="syutkjyp" />
          <swak:item id="syuhtnpbuicd1" />
          <swak:item id="syuhtnpbuinm1" />
          <swak:item id="syuhtnpkkn1" />
          <swak:item id="syuhtnpbuicd2" />
          <swak:item id="syuhtnpbuinm2" />
          <swak:item id="syuhtnpkkn2" />
          <swak:item id="syuhtnpbuicd3" />
          <swak:item id="syuhtnpbuinm3" />
          <swak:item id="syuhtnpkkn3" />
          <swak:item id="syuhtnpbuicd4" />
          <swak:item id="syuhtnpbuinm4" />
          <swak:item id="syuhtnpkkn4" />
          <swak:item id="syutokkoudosghtnpkbn" />
          <swak:item id="syukouryokuhasseiymd" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo1">
          <swak:item id="disptksyouhnnm1" />
          <swak:item id="disptokuyakukatakbn1" />
          <swak:item id="disptkkyhgndkatakbn1" />
          <swak:item id="disptkhhknnen1" />
          <swak:item id="disptkkykymd1" />
          <swak:item id="disptksknnkaisiymd1" />
          <swak:item id="disptkgansknnkaisiymd1" />
          <swak:item id="disptkhksknnkaisiymd1" />
          <swak:item id="disptkhkgansknnkaisiymd1" />
          <swak:item id="disptkhknkkn1" />
          <swak:item id="disptkhknkknsmnkbn1" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn1" />
          <swak:item id="disptkhrkkknsmnkbn1" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn1" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons1" />
          <swak:item id="disptktsnshrgndgk1" />
          <swak:item id="disptkp1" />
          <swak:item id="disptknextkosgop1" />
          <swak:item id="disptkgannyukyhntgk1" />
          <swak:item id="disptkshrskgnstartymd1" />
          <swak:item id="disptkshrskgnendymd1" />
          <swak:item id="disptkshrskgngos1" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn1" />
          <swak:item id="disptknkshrstartymd1" />
          <swak:item id="disptknenkinsyu1" />
          <swak:item id="disptknenkinkkn1" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk1" />
          <swak:item id="disptkbnshrkaisuu1" />
          <swak:item id="disptktkjyskgnkkn1" />
          <swak:item id="disptktkjyskgnhknnndsymd11" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd11" />
          <swak:item id="disptktkjyskgns11" />
          <swak:item id="disptktkjyskgnhknnndsymd21" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd21" />
          <swak:item id="disptktkjyskgns21" />
          <swak:item id="disptktkjyskgnhknnndsymd31" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd31" />
          <swak:item id="disptktkjyskgns31" />
          <swak:item id="disptktkjyskgnhknnndsymd41" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd41" />
          <swak:item id="disptktkjyskgns41" />
          <swak:item id="disptktkjyskgnhknnndsymd51" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd51" />
          <swak:item id="disptktkjyskgns51" />
          <swak:item id="disptktkjyhyouten1" />
          <swak:item id="disptktkjyp1" />
          <swak:item id="disptkhtnpbuicd11" />
          <swak:item id="disptkhtnpbuinm11" />
          <swak:item id="disptkhtnpkkn11" />
          <swak:item id="disptkhtnpbuicd21" />
          <swak:item id="disptkhtnpbuinm21" />
          <swak:item id="disptkhtnpkkn21" />
          <swak:item id="disptkhtnpbuicd31" />
          <swak:item id="disptkhtnpbuinm31" />
          <swak:item id="disptkhtnpkkn31" />
          <swak:item id="disptkhtnpbuicd41" />
          <swak:item id="disptkhtnpbuinm41" />
          <swak:item id="disptkhtnpkkn41" />
          <swak:item id="disptktokkoudosghtnpkbn1" />
          <swak:item id="disptkkouryokuhasseiymd1" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo2">
          <swak:item id="disptksyouhnnm2" />
          <swak:item id="disptokuyakukatakbn2" />
          <swak:item id="disptkkyhgndkatakbn2" />
          <swak:item id="disptkhhknnen2" />
          <swak:item id="disptkkykymd2" />
          <swak:item id="disptksknnkaisiymd2" />
          <swak:item id="disptkgansknnkaisiymd2" />
          <swak:item id="disptkhksknnkaisiymd2" />
          <swak:item id="disptkhkgansknnkaisiymd2" />
          <swak:item id="disptkhknkkn2" />
          <swak:item id="disptkhknkknsmnkbn2" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn2" />
          <swak:item id="disptkhrkkknsmnkbn2" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn2" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons2" />
          <swak:item id="disptktsnshrgndgk2" />
          <swak:item id="disptkp2" />
          <swak:item id="disptknextkosgop2" />
          <swak:item id="disptkgannyukyhntgk2" />
          <swak:item id="disptkshrskgnstartymd2" />
          <swak:item id="disptkshrskgnendymd2" />
          <swak:item id="disptkshrskgngos2" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn2" />
          <swak:item id="disptknkshrstartymd2" />
          <swak:item id="disptknenkinsyu2" />
          <swak:item id="disptknenkinkkn2" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk2" />
          <swak:item id="disptkbnshrkaisuu2" />
          <swak:item id="disptktkjyskgnkkn2" />
          <swak:item id="disptktkjyskgnhknnndsymd12" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd12" />
          <swak:item id="disptktkjyskgns12" />
          <swak:item id="disptktkjyskgnhknnndsymd22" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd22" />
          <swak:item id="disptktkjyskgns22" />
          <swak:item id="disptktkjyskgnhknnndsymd32" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd32" />
          <swak:item id="disptktkjyskgns32" />
          <swak:item id="disptktkjyskgnhknnndsymd42" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd42" />
          <swak:item id="disptktkjyskgns42" />
          <swak:item id="disptktkjyskgnhknnndsymd52" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd52" />
          <swak:item id="disptktkjyskgns52" />
          <swak:item id="disptktkjyhyouten2" />
          <swak:item id="disptktkjyp2" />
          <swak:item id="disptkhtnpbuicd12" />
          <swak:item id="disptkhtnpbuinm12" />
          <swak:item id="disptkhtnpkkn12" />
          <swak:item id="disptkhtnpbuicd22" />
          <swak:item id="disptkhtnpbuinm22" />
          <swak:item id="disptkhtnpkkn22" />
          <swak:item id="disptkhtnpbuicd32" />
          <swak:item id="disptkhtnpbuinm32" />
          <swak:item id="disptkhtnpkkn32" />
          <swak:item id="disptkhtnpbuicd42" />
          <swak:item id="disptkhtnpbuinm42" />
          <swak:item id="disptkhtnpkkn42" />
          <swak:item id="disptktokkoudosghtnpkbn2" />
          <swak:item id="disptkkouryokuhasseiymd2" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo3">
          <swak:item id="disptksyouhnnm3" />
          <swak:item id="disptokuyakukatakbn3" />
          <swak:item id="disptkkyhgndkatakbn3" />
          <swak:item id="disptkhhknnen3" />
          <swak:item id="disptkkykymd3" />
          <swak:item id="disptksknnkaisiymd3" />
          <swak:item id="disptkgansknnkaisiymd3" />
          <swak:item id="disptkhksknnkaisiymd3" />
          <swak:item id="disptkhkgansknnkaisiymd3" />
          <swak:item id="disptkhknkkn3" />
          <swak:item id="disptkhknkknsmnkbn3" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn3" />
          <swak:item id="disptkhrkkknsmnkbn3" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn3" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons3" />
          <swak:item id="disptktsnshrgndgk3" />
          <swak:item id="disptkp3" />
          <swak:item id="disptknextkosgop3" />
          <swak:item id="disptkgannyukyhntgk3" />
          <swak:item id="disptkshrskgnstartymd3" />
          <swak:item id="disptkshrskgnendymd3" />
          <swak:item id="disptkshrskgngos3" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn3" />
          <swak:item id="disptknkshrstartymd3" />
          <swak:item id="disptknenkinsyu3" />
          <swak:item id="disptknenkinkkn3" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk3" />
          <swak:item id="disptkbnshrkaisuu3" />
          <swak:item id="disptktkjyskgnkkn3" />
          <swak:item id="disptktkjyskgnhknnndsymd13" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd13" />
          <swak:item id="disptktkjyskgns13" />
          <swak:item id="disptktkjyskgnhknnndsymd23" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd23" />
          <swak:item id="disptktkjyskgns23" />
          <swak:item id="disptktkjyskgnhknnndsymd33" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd33" />
          <swak:item id="disptktkjyskgns33" />
          <swak:item id="disptktkjyskgnhknnndsymd43" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd43" />
          <swak:item id="disptktkjyskgns43" />
          <swak:item id="disptktkjyskgnhknnndsymd53" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd53" />
          <swak:item id="disptktkjyskgns53" />
          <swak:item id="disptktkjyhyouten3" />
          <swak:item id="disptktkjyp3" />
          <swak:item id="disptkhtnpbuicd13" />
          <swak:item id="disptkhtnpbuinm13" />
          <swak:item id="disptkhtnpkkn13" />
          <swak:item id="disptkhtnpbuicd23" />
          <swak:item id="disptkhtnpbuinm23" />
          <swak:item id="disptkhtnpkkn23" />
          <swak:item id="disptkhtnpbuicd33" />
          <swak:item id="disptkhtnpbuinm33" />
          <swak:item id="disptkhtnpkkn33" />
          <swak:item id="disptkhtnpbuicd43" />
          <swak:item id="disptkhtnpbuinm43" />
          <swak:item id="disptkhtnpkkn43" />
          <swak:item id="disptktokkoudosghtnpkbn3" />
          <swak:item id="disptkkouryokuhasseiymd3" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo4">
          <swak:item id="disptksyouhnnm4" />
          <swak:item id="disptokuyakukatakbn4" />
          <swak:item id="disptkkyhgndkatakbn4" />
          <swak:item id="disptkhhknnen4" />
          <swak:item id="disptkkykymd4" />
          <swak:item id="disptksknnkaisiymd4" />
          <swak:item id="disptkgansknnkaisiymd4" />
          <swak:item id="disptkhksknnkaisiymd4" />
          <swak:item id="disptkhkgansknnkaisiymd4" />
          <swak:item id="disptkhknkkn4" />
          <swak:item id="disptkhknkknsmnkbn4" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn4" />
          <swak:item id="disptkhrkkknsmnkbn4" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn4" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons4" />
          <swak:item id="disptktsnshrgndgk4" />
          <swak:item id="disptkp4" />
          <swak:item id="disptknextkosgop4" />
          <swak:item id="disptkgannyukyhntgk4" />
          <swak:item id="disptkshrskgnstartymd4" />
          <swak:item id="disptkshrskgnendymd4" />
          <swak:item id="disptkshrskgngos4" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn4" />
          <swak:item id="disptknkshrstartymd4" />
          <swak:item id="disptknenkinsyu4" />
          <swak:item id="disptknenkinkkn4" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk4" />
          <swak:item id="disptkbnshrkaisuu4" />
          <swak:item id="disptktkjyskgnkkn4" />
          <swak:item id="disptktkjyskgnhknnndsymd14" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd14" />
          <swak:item id="disptktkjyskgns14" />
          <swak:item id="disptktkjyskgnhknnndsymd24" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd24" />
          <swak:item id="disptktkjyskgns24" />
          <swak:item id="disptktkjyskgnhknnndsymd34" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd34" />
          <swak:item id="disptktkjyskgns34" />
          <swak:item id="disptktkjyskgnhknnndsymd44" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd44" />
          <swak:item id="disptktkjyskgns44" />
          <swak:item id="disptktkjyskgnhknnndsymd54" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd54" />
          <swak:item id="disptktkjyskgns54" />
          <swak:item id="disptktkjyhyouten4" />
          <swak:item id="disptktkjyp4" />
          <swak:item id="disptkhtnpbuicd14" />
          <swak:item id="disptkhtnpbuinm14" />
          <swak:item id="disptkhtnpkkn14" />
          <swak:item id="disptkhtnpbuicd24" />
          <swak:item id="disptkhtnpbuinm24" />
          <swak:item id="disptkhtnpkkn24" />
          <swak:item id="disptkhtnpbuicd34" />
          <swak:item id="disptkhtnpbuinm34" />
          <swak:item id="disptkhtnpkkn34" />
          <swak:item id="disptkhtnpbuicd44" />
          <swak:item id="disptkhtnpbuinm44" />
          <swak:item id="disptkhtnpkkn44" />
          <swak:item id="disptktokkoudosghtnpkbn4" />
          <swak:item id="disptkkouryokuhasseiymd4" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo5">
          <swak:item id="disptksyouhnnm5" />
          <swak:item id="disptokuyakukatakbn5" />
          <swak:item id="disptkkyhgndkatakbn5" />
          <swak:item id="disptkhhknnen5" />
          <swak:item id="disptkkykymd5" />
          <swak:item id="disptksknnkaisiymd5" />
          <swak:item id="disptkgansknnkaisiymd5" />
          <swak:item id="disptkhksknnkaisiymd5" />
          <swak:item id="disptkhkgansknnkaisiymd5" />
          <swak:item id="disptkhknkkn5" />
          <swak:item id="disptkhknkknsmnkbn5" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn5" />
          <swak:item id="disptkhrkkknsmnkbn5" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn5" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons5" />
          <swak:item id="disptktsnshrgndgk5" />
          <swak:item id="disptkp5" />
          <swak:item id="disptknextkosgop5" />
          <swak:item id="disptkgannyukyhntgk5" />
          <swak:item id="disptkshrskgnstartymd5" />
          <swak:item id="disptkshrskgnendymd5" />
          <swak:item id="disptkshrskgngos5" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn5" />
          <swak:item id="disptknkshrstartymd5" />
          <swak:item id="disptknenkinsyu5" />
          <swak:item id="disptknenkinkkn5" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk5" />
          <swak:item id="disptkbnshrkaisuu5" />
          <swak:item id="disptktkjyskgnkkn5" />
          <swak:item id="disptktkjyskgnhknnndsymd15" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd15" />
          <swak:item id="disptktkjyskgns15" />
          <swak:item id="disptktkjyskgnhknnndsymd25" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd25" />
          <swak:item id="disptktkjyskgns25" />
          <swak:item id="disptktkjyskgnhknnndsymd35" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd35" />
          <swak:item id="disptktkjyskgns35" />
          <swak:item id="disptktkjyskgnhknnndsymd45" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd45" />
          <swak:item id="disptktkjyskgns45" />
          <swak:item id="disptktkjyskgnhknnndsymd55" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd55" />
          <swak:item id="disptktkjyskgns55" />
          <swak:item id="disptktkjyhyouten5" />
          <swak:item id="disptktkjyp5" />
          <swak:item id="disptkhtnpbuicd15" />
          <swak:item id="disptkhtnpbuinm15" />
          <swak:item id="disptkhtnpkkn15" />
          <swak:item id="disptkhtnpbuicd25" />
          <swak:item id="disptkhtnpbuinm25" />
          <swak:item id="disptkhtnpkkn25" />
          <swak:item id="disptkhtnpbuicd35" />
          <swak:item id="disptkhtnpbuinm35" />
          <swak:item id="disptkhtnpkkn35" />
          <swak:item id="disptkhtnpbuicd45" />
          <swak:item id="disptkhtnpbuinm45" />
          <swak:item id="disptkhtnpkkn45" />
          <swak:item id="disptktokkoudosghtnpkbn5" />
          <swak:item id="disptkkouryokuhasseiymd5" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo6">
          <swak:item id="disptksyouhnnm6" />
          <swak:item id="disptokuyakukatakbn6" />
          <swak:item id="disptkkyhgndkatakbn6" />
          <swak:item id="disptkhhknnen6" />
          <swak:item id="disptkkykymd6" />
          <swak:item id="disptksknnkaisiymd6" />
          <swak:item id="disptkgansknnkaisiymd6" />
          <swak:item id="disptkhksknnkaisiymd6" />
          <swak:item id="disptkhkgansknnkaisiymd6" />
          <swak:item id="disptkhknkkn6" />
          <swak:item id="disptkhknkknsmnkbn6" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn6" />
          <swak:item id="disptkhrkkknsmnkbn6" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn6" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons6" />
          <swak:item id="disptktsnshrgndgk6" />
          <swak:item id="disptkp6" />
          <swak:item id="disptknextkosgop6" />
          <swak:item id="disptkgannyukyhntgk6" />
          <swak:item id="disptkshrskgnstartymd6" />
          <swak:item id="disptkshrskgnendymd6" />
          <swak:item id="disptkshrskgngos6" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn6" />
          <swak:item id="disptknkshrstartymd6" />
          <swak:item id="disptknenkinsyu6" />
          <swak:item id="disptknenkinkkn6" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk6" />
          <swak:item id="disptkbnshrkaisuu6" />
          <swak:item id="disptktkjyskgnkkn6" />
          <swak:item id="disptktkjyskgnhknnndsymd16" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd16" />
          <swak:item id="disptktkjyskgns16" />
          <swak:item id="disptktkjyskgnhknnndsymd26" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd26" />
          <swak:item id="disptktkjyskgns26" />
          <swak:item id="disptktkjyskgnhknnndsymd36" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd36" />
          <swak:item id="disptktkjyskgns36" />
          <swak:item id="disptktkjyskgnhknnndsymd46" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd46" />
          <swak:item id="disptktkjyskgns46" />
          <swak:item id="disptktkjyskgnhknnndsymd56" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd56" />
          <swak:item id="disptktkjyskgns56" />
          <swak:item id="disptktkjyhyouten6" />
          <swak:item id="disptktkjyp6" />
          <swak:item id="disptkhtnpbuicd16" />
          <swak:item id="disptkhtnpbuinm16" />
          <swak:item id="disptkhtnpkkn16" />
          <swak:item id="disptkhtnpbuicd26" />
          <swak:item id="disptkhtnpbuinm26" />
          <swak:item id="disptkhtnpkkn26" />
          <swak:item id="disptkhtnpbuicd36" />
          <swak:item id="disptkhtnpbuinm36" />
          <swak:item id="disptkhtnpkkn36" />
          <swak:item id="disptkhtnpbuicd46" />
          <swak:item id="disptkhtnpbuinm46" />
          <swak:item id="disptkhtnpkkn46" />
          <swak:item id="disptktokkoudosghtnpkbn6" />
          <swak:item id="disptkkouryokuhasseiymd6" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo7">
          <swak:item id="disptksyouhnnm7" />
          <swak:item id="disptokuyakukatakbn7" />
          <swak:item id="disptkkyhgndkatakbn7" />
          <swak:item id="disptkhhknnen7" />
          <swak:item id="disptkkykymd7" />
          <swak:item id="disptksknnkaisiymd7" />
          <swak:item id="disptkgansknnkaisiymd7" />
          <swak:item id="disptkhksknnkaisiymd7" />
          <swak:item id="disptkhkgansknnkaisiymd7" />
          <swak:item id="disptkhknkkn7" />
          <swak:item id="disptkhknkknsmnkbn7" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn7" />
          <swak:item id="disptkhrkkknsmnkbn7" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn7" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons7" />
          <swak:item id="disptktsnshrgndgk7" />
          <swak:item id="disptkp7" />
          <swak:item id="disptknextkosgop7" />
          <swak:item id="disptkgannyukyhntgk7" />
          <swak:item id="disptkshrskgnstartymd7" />
          <swak:item id="disptkshrskgnendymd7" />
          <swak:item id="disptkshrskgngos7" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn7" />
          <swak:item id="disptknkshrstartymd7" />
          <swak:item id="disptknenkinsyu7" />
          <swak:item id="disptknenkinkkn7" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk7" />
          <swak:item id="disptkbnshrkaisuu7" />
          <swak:item id="disptktkjyskgnkkn7" />
          <swak:item id="disptktkjyskgnhknnndsymd17" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd17" />
          <swak:item id="disptktkjyskgns17" />
          <swak:item id="disptktkjyskgnhknnndsymd27" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd27" />
          <swak:item id="disptktkjyskgns27" />
          <swak:item id="disptktkjyskgnhknnndsymd37" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd37" />
          <swak:item id="disptktkjyskgns37" />
          <swak:item id="disptktkjyskgnhknnndsymd47" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd47" />
          <swak:item id="disptktkjyskgns47" />
          <swak:item id="disptktkjyskgnhknnndsymd57" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd57" />
          <swak:item id="disptktkjyskgns57" />
          <swak:item id="disptktkjyhyouten7" />
          <swak:item id="disptktkjyp7" />
          <swak:item id="disptkhtnpbuicd17" />
          <swak:item id="disptkhtnpbuinm17" />
          <swak:item id="disptkhtnpkkn17" />
          <swak:item id="disptkhtnpbuicd27" />
          <swak:item id="disptkhtnpbuinm27" />
          <swak:item id="disptkhtnpkkn27" />
          <swak:item id="disptkhtnpbuicd37" />
          <swak:item id="disptkhtnpbuinm37" />
          <swak:item id="disptkhtnpkkn37" />
          <swak:item id="disptkhtnpbuicd47" />
          <swak:item id="disptkhtnpbuinm47" />
          <swak:item id="disptkhtnpkkn47" />
          <swak:item id="disptktokkoudosghtnpkbn7" />
          <swak:item id="disptkkouryokuhasseiymd7" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo8">
          <swak:item id="disptksyouhnnm8" />
          <swak:item id="disptokuyakukatakbn8" />
          <swak:item id="disptkkyhgndkatakbn8" />
          <swak:item id="disptkhhknnen8" />
          <swak:item id="disptkkykymd8" />
          <swak:item id="disptksknnkaisiymd8" />
          <swak:item id="disptkgansknnkaisiymd8" />
          <swak:item id="disptkhksknnkaisiymd8" />
          <swak:item id="disptkhkgansknnkaisiymd8" />
          <swak:item id="disptkhknkkn8" />
          <swak:item id="disptkhknkknsmnkbn8" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn8" />
          <swak:item id="disptkhrkkknsmnkbn8" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn8" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons8" />
          <swak:item id="disptktsnshrgndgk8" />
          <swak:item id="disptkp8" />
          <swak:item id="disptknextkosgop8" />
          <swak:item id="disptkgannyukyhntgk8" />
          <swak:item id="disptkshrskgnstartymd8" />
          <swak:item id="disptkshrskgnendymd8" />
          <swak:item id="disptkshrskgngos8" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn8" />
          <swak:item id="disptknkshrstartymd8" />
          <swak:item id="disptknenkinsyu8" />
          <swak:item id="disptknenkinkkn8" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk8" />
          <swak:item id="disptkbnshrkaisuu8" />
          <swak:item id="disptktkjyskgnkkn8" />
          <swak:item id="disptktkjyskgnhknnndsymd18" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd18" />
          <swak:item id="disptktkjyskgns18" />
          <swak:item id="disptktkjyskgnhknnndsymd28" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd28" />
          <swak:item id="disptktkjyskgns28" />
          <swak:item id="disptktkjyskgnhknnndsymd38" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd38" />
          <swak:item id="disptktkjyskgns38" />
          <swak:item id="disptktkjyskgnhknnndsymd48" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd48" />
          <swak:item id="disptktkjyskgns48" />
          <swak:item id="disptktkjyskgnhknnndsymd58" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd58" />
          <swak:item id="disptktkjyskgns58" />
          <swak:item id="disptktkjyhyouten8" />
          <swak:item id="disptktkjyp8" />
          <swak:item id="disptkhtnpbuicd18" />
          <swak:item id="disptkhtnpbuinm18" />
          <swak:item id="disptkhtnpkkn18" />
          <swak:item id="disptkhtnpbuicd28" />
          <swak:item id="disptkhtnpbuinm28" />
          <swak:item id="disptkhtnpkkn28" />
          <swak:item id="disptkhtnpbuicd38" />
          <swak:item id="disptkhtnpbuinm38" />
          <swak:item id="disptkhtnpkkn38" />
          <swak:item id="disptkhtnpbuicd48" />
          <swak:item id="disptkhtnpbuinm48" />
          <swak:item id="disptkhtnpkkn48" />
          <swak:item id="disptktokkoudosghtnpkbn8" />
          <swak:item id="disptkkouryokuhasseiymd8" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo9">
          <swak:item id="disptksyouhnnm9" />
          <swak:item id="disptokuyakukatakbn9" />
          <swak:item id="disptkkyhgndkatakbn9" />
          <swak:item id="disptkhhknnen9" />
          <swak:item id="disptkkykymd9" />
          <swak:item id="disptksknnkaisiymd9" />
          <swak:item id="disptkgansknnkaisiymd9" />
          <swak:item id="disptkhksknnkaisiymd9" />
          <swak:item id="disptkhkgansknnkaisiymd9" />
          <swak:item id="disptkhknkkn9" />
          <swak:item id="disptkhknkknsmnkbn9" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn9" />
          <swak:item id="disptkhrkkknsmnkbn9" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn9" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons9" />
          <swak:item id="disptktsnshrgndgk9" />
          <swak:item id="disptkp9" />
          <swak:item id="disptknextkosgop9" />
          <swak:item id="disptkgannyukyhntgk9" />
          <swak:item id="disptkshrskgnstartymd9" />
          <swak:item id="disptkshrskgnendymd9" />
          <swak:item id="disptkshrskgngos9" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn9" />
          <swak:item id="disptknkshrstartymd9" />
          <swak:item id="disptknenkinsyu9" />
          <swak:item id="disptknenkinkkn9" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk9" />
          <swak:item id="disptkbnshrkaisuu9" />
          <swak:item id="disptktkjyskgnkkn9" />
          <swak:item id="disptktkjyskgnhknnndsymd19" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd19" />
          <swak:item id="disptktkjyskgns19" />
          <swak:item id="disptktkjyskgnhknnndsymd29" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd29" />
          <swak:item id="disptktkjyskgns29" />
          <swak:item id="disptktkjyskgnhknnndsymd39" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd39" />
          <swak:item id="disptktkjyskgns39" />
          <swak:item id="disptktkjyskgnhknnndsymd49" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd49" />
          <swak:item id="disptktkjyskgns49" />
          <swak:item id="disptktkjyskgnhknnndsymd59" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd59" />
          <swak:item id="disptktkjyskgns59" />
          <swak:item id="disptktkjyhyouten9" />
          <swak:item id="disptktkjyp9" />
          <swak:item id="disptkhtnpbuicd19" />
          <swak:item id="disptkhtnpbuinm19" />
          <swak:item id="disptkhtnpkkn19" />
          <swak:item id="disptkhtnpbuicd29" />
          <swak:item id="disptkhtnpbuinm29" />
          <swak:item id="disptkhtnpkkn29" />
          <swak:item id="disptkhtnpbuicd39" />
          <swak:item id="disptkhtnpbuinm39" />
          <swak:item id="disptkhtnpkkn39" />
          <swak:item id="disptkhtnpbuicd49" />
          <swak:item id="disptkhtnpbuinm49" />
          <swak:item id="disptkhtnpkkn49" />
          <swak:item id="disptktokkoudosghtnpkbn9" />
          <swak:item id="disptkkouryokuhasseiymd9" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo10">
          <swak:item id="disptksyouhnnm10" />
          <swak:item id="disptokuyakukatakbn10" />
          <swak:item id="disptkkyhgndkatakbn10" />
          <swak:item id="disptkhhknnen10" />
          <swak:item id="disptkkykymd10" />
          <swak:item id="disptksknnkaisiymd10" />
          <swak:item id="disptkgansknnkaisiymd10" />
          <swak:item id="disptkhksknnkaisiymd10" />
          <swak:item id="disptkhkgansknnkaisiymd10" />
          <swak:item id="disptkhknkkn10" />
          <swak:item id="disptkhknkknsmnkbn10" />
          <swak:item id="IIC0025" />
          <swak:item id="IIC0026" />
          <swak:item id="disptkhrkkkn10" />
          <swak:item id="disptkhrkkknsmnkbn10" />
          <swak:item id="IIC0025" />
          <swak:item id="IIW0002" />
          <swak:item id="disptkkihonssyuruikbn10" />
          <swak:item id="IIC0018" />
          <swak:item id="disptkkihons10" />
          <swak:item id="disptktsnshrgndgk10" />
          <swak:item id="disptkp10" />
          <swak:item id="disptknextkosgop10" />
          <swak:item id="disptkgannyukyhntgk10" />
          <swak:item id="disptkshrskgnstartymd10" />
          <swak:item id="disptkshrskgnendymd10" />
          <swak:item id="disptkshrskgngos10" />
          <swak:item id="IIC0009" />
          <swak:item id="disptkkrnbkkn10" />
          <swak:item id="disptknkshrstartymd10" />
          <swak:item id="disptknenkinsyu10" />
          <swak:item id="disptknenkinkkn10" />
          <swak:item id="IIC0025" />
          <swak:item id="disptknknengk10" />
          <swak:item id="disptkbnshrkaisuu10" />
          <swak:item id="disptktkjyskgnkkn10" />
          <swak:item id="disptktkjyskgnhknnndsymd110" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd110" />
          <swak:item id="disptktkjyskgns110" />
          <swak:item id="disptktkjyskgnhknnndsymd210" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd210" />
          <swak:item id="disptktkjyskgns210" />
          <swak:item id="disptktkjyskgnhknnndsymd310" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd310" />
          <swak:item id="disptktkjyskgns310" />
          <swak:item id="disptktkjyskgnhknnndsymd410" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd410" />
          <swak:item id="disptktkjyskgns410" />
          <swak:item id="disptktkjyskgnhknnndsymd510" />
          <swak:item id="IAW0003" />
          <swak:item id="disptktkjyskgnhknnndeymd510" />
          <swak:item id="disptktkjyskgns510" />
          <swak:item id="disptktkjyhyouten10" />
          <swak:item id="disptktkjyp10" />
          <swak:item id="disptkhtnpbuicd110" />
          <swak:item id="disptkhtnpbuinm110" />
          <swak:item id="disptkhtnpkkn110" />
          <swak:item id="disptkhtnpbuicd210" />
          <swak:item id="disptkhtnpbuinm210" />
          <swak:item id="disptkhtnpkkn210" />
          <swak:item id="disptkhtnpbuicd310" />
          <swak:item id="disptkhtnpbuinm310" />
          <swak:item id="disptkhtnpkkn310" />
          <swak:item id="disptkhtnpbuicd410" />
          <swak:item id="disptkhtnpbuinm410" />
          <swak:item id="disptkhtnpkkn410" />
          <swak:item id="disptktokkoudosghtnpkbn10" />
          <swak:item id="disptkkouryokuhasseiymd10" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="pmnjtInfo">
          <swak:item id="pmnjtkkbn" />
          <swak:item id="pmnjtkkykymd" />
          <swak:item id="pmnjtksknnkaisiymd" />
          <swak:item id="pmnjtkgansknnkaisiymd" />
          <swak:item id="pmhktsknnkaisiymd" />
          <swak:item id="pmnjhktgansknnkaisiymd" />
          <swak:item id="pmnjtkhtnpbuicd1" />
          <swak:item id="pmnjtkhtnpbuinm1" />
          <swak:item id="pmnjtkhtnpkkn1" />
          <swak:item id="pmnjtkhtnpbuicd2" />
          <swak:item id="pmnjtkhtnpbuinm2" />
          <swak:item id="pmnjtkhtnpkkn2" />
          <swak:item id="pmnjtkhtnpbuicd3" />
          <swak:item id="pmnjtkhtnpbuinm3" />
          <swak:item id="pmnjtkhtnpkkn3" />
          <swak:item id="pmnjtkhtnpbuicd4" />
          <swak:item id="pmnjtkhtnpbuinm4" />
          <swak:item id="pmnjtkhtnpkkn4" />
          <swak:item id="pmnjtokkoudosghtnpkbn" />
        </swak:group>

        <%-- ●その他特約・特則 --%>
        <swak:group id="sonotaTkInfo">
          <swak:item id="disptkhukainfo" />
        </swak:group>

        <%-- ●払込情報 --%>
        <swak:group id="haraikomiInfo">
          <swak:item id="fstphrkkeirokbn" />
          <swak:item id="hrkkaisuu" />
          <swak:item id="hrkkeiro" />
          <swak:item id="viewharaikomiinfodummy" />
          <swak:item id="jkipjytym" />
          <swak:item id="IIW0002" />
          <swak:item id="tokusinendymd" />
          <swak:item id="hrkp" />
          <swak:item id="kihrkp" />
          <swak:item id="nextkosgohrkp" />
          <swak:item id="IIC0005" />
        </swak:group>

        <%-- 銀行情報 --%>
        <swak:group id="ginkouInfo">
          <swak:item id="hrkinfobankcd" />
          <swak:item id="hrkinfobanknmkj" />
          <swak:item id="hrkinfositencd" />
          <swak:item id="hrkinfositennmkj" />
          <swak:item id="hrkinfoyokinkbn" />
          <swak:item id="hrkinfokouzano" />
          <swak:item id="hrkinfosinkeizkkbn" />
          <swak:item id="hrkinfokzmeiginmkn" />
          <swak:item id="hrkinfosyuudaikocd" />
        </swak:group>

        <%-- クレジットカード情報 --%>
        <swak:group id="focreditcardInfo">
          <swak:item id="hrkinfocreditcardno1" />
          <swak:item id="IAW0001" />
          <swak:item id="hrkinfocreditcardno2" />
          <swak:item id="IAW0001" />
          <swak:item id="hrkinfocreditcardno3" />
          <swak:item id="IAW0001" />
          <swak:item id="hrkinfocreditcardno4" />
          <swak:item id="hrkinfoykkigenmm" />
          <swak:item id="IIC0024" />
          <swak:item id="hrkinfoykkigenyy" />
          <swak:item id="authorijkkbn" />
          <swak:item id="authorikanryoymd" />
          <swak:item id="yuukoukakujkkbn" />
          <swak:item id="yukoukachkymd" />
        </swak:group>

        <%-- ●確認履歴 --%>
        <swak:dataTable id="kakuninKekkaInfo">
          <swak:column id="dispnaiyoukakymd" />
          <swak:column id="dispsousasyanm" />
          <swak:column id="disptasknm" />
          <swak:column id="dispkakuninkekkakbn" />
          <swak:column id="dispcomment" />
        </swak:dataTable>

        <%-- ●契約変更入力 --%>
        <swak:group id="keiyakuHenkouNyuuryokuInfo">
          <swak:item id="kykhenkoymd" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuSyuInfo --%>
        <swak:group id="keiyakuHenkouNyuuryokuSyuInfo">
          <swak:item id="dispsyusyouhnnm" />
          <swak:item id="syuhnkkbn" />
          <swak:item id="dispsyukihonssyuruikbn" />
          <swak:item id="newsyukihons" />
          <swak:item id="IIC0029" />
          <swak:item id="syutsnshrgndgk" />
          <swak:item id="dispsyukihonkyhgk" />
          <swak:item id="newsyup" />
          <swak:item id="newsyunextkosgop" />
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo1">
          <swak:item id="tokuyakusyouhnnm1" />
          <swak:item id="tkhnkkbn1" />
          <swak:item id="tokuyakukihonssyuruikbn1" />
          <swak:item id="newtkkihons1" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk1" />
          <swak:item id="newdisptkp1" />
          <swak:item id="dispnewtknextkosgop1" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo2 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo2">
          <swak:item id="tokuyakusyouhnnm2" />
          <swak:item id="tkhnkkbn2" />
          <swak:item id="tokuyakukihonssyuruikbn2" />
          <swak:item id="newtkkihons2" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk2" />
          <swak:item id="newdisptkp2" />
          <swak:item id="dispnewtknextkosgop2" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo3 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo3">
          <swak:item id="tokuyakusyouhnnm3" />
          <swak:item id="tkhnkkbn3" />
          <swak:item id="tokuyakukihonssyuruikbn3" />
          <swak:item id="newtkkihons3" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk3" />
          <swak:item id="newdisptkp3" />
          <swak:item id="dispnewtknextkosgop3" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo4 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo4">
          <swak:item id="tokuyakusyouhnnm4" />
          <swak:item id="tkhnkkbn4" />
          <swak:item id="tokuyakukihonssyuruikbn4" />
          <swak:item id="newtkkihons4" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk4" />
          <swak:item id="newdisptkp4" />
          <swak:item id="dispnewtknextkosgop4" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo5 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo5">
          <swak:item id="tokuyakusyouhnnm5" />
          <swak:item id="tkhnkkbn5" />
          <swak:item id="tokuyakukihonssyuruikbn5" />
          <swak:item id="newtkkihons5" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk5" />
          <swak:item id="newdisptkp5" />
          <swak:item id="dispnewtknextkosgop5" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo6 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo6">
          <swak:item id="tokuyakusyouhnnm6" />
          <swak:item id="tkhnkkbn6" />
          <swak:item id="tokuyakukihonssyuruikbn6" />
          <swak:item id="newtkkihons6" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk6" />
          <swak:item id="newdisptkp6" />
          <swak:item id="dispnewtknextkosgop6" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo7 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo7">
          <swak:item id="tokuyakusyouhnnm7" />
          <swak:item id="tkhnkkbn7" />
          <swak:item id="tokuyakukihonssyuruikbn7" />
          <swak:item id="newtkkihons7" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk7" />
          <swak:item id="newdisptkp7" />
          <swak:item id="dispnewtknextkosgop7" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo8 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo8">
          <swak:item id="tokuyakusyouhnnm8" />
          <swak:item id="tkhnkkbn8" />
          <swak:item id="tokuyakukihonssyuruikbn8" />
          <swak:item id="newtkkihons8" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk8" />
          <swak:item id="newdisptkp8" />
          <swak:item id="dispnewtknextkosgop8" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo9 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo9">
          <swak:item id="tokuyakusyouhnnm9" />
          <swak:item id="tkhnkkbn9" />
          <swak:item id="tokuyakukihonssyuruikbn9" />
          <swak:item id="newtkkihons9" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk9" />
          <swak:item id="newdisptkp9" />
          <swak:item id="dispnewtknextkosgop9" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuTkInfo10 --%>
        <swak:group id="keiyakuHenkouNyuuryokuTkInfo10">
          <swak:item id="tokuyakusyouhnnm10" />
          <swak:item id="tkhnkkbn10" />
          <swak:item id="tokuyakukihonssyuruikbn10" />
          <swak:item id="newtkkihons10" />
          <swak:item id="IIC0029" />
          <swak:item id="tktsnshrgndgk10" />
          <swak:item id="newdisptkp10" />
          <swak:item id="dispnewtknextkosgop10" />
        </swak:group>

        <%-- keiyakuHenkouNyuuryokuPmnjtInfo --%>
        <swak:group id="keiyakuHenkouNyuuryokuPmnjtInfo">
          <swak:item id="disptkpmnjtkkbn" />
          <swak:item id="pmnjtkhnkkbn" />
        </swak:group>

        <%-- ●新払込保険料 --%>
        <swak:group id="sinSiharaikomiHokenryou">
          <swak:item id="newhrkp" />
          <swak:item id="newnextkosgohrkp" />
        </swak:group>

        <%-- ●支払内容 --%>
        <swak:group id="siharaiNaiyouInfo">
          <swak:item id="shrymd" />
        </swak:group>

        <%-- siharaiInfo --%>
        <swak:group id="siharaiInfo">
          <swak:item id="viewharaikomiinfodummy1" />
          <swak:item id="shrgkkei" />
          <swak:item id="shrgkgoukeikakunin" />
          <swak:item id="shrgkgoukeisyoukai" />
          <swak:item id="ptumitatekin" />
          <swak:item id="henkank" />
          <swak:item id="kaiyakuhr" />
          <swak:item id="mikeikap" />
          <swak:item id="sonotaseisangk" />
          <swak:item id="gensengk" />
          <swak:item id="viewsiharaidummy" />
          <swak:item id="syoruiukeymd" />
          <swak:item id="dispkykhenkoymd" />
          <swak:item id="IIC0019" />
          <swak:item id="shrtienrsk" />
          <swak:item id="dispkihrkp" />
        </swak:group>

        <%-- ＜支払詳細＞ --%>
        <swak:group id="siharaiSyousaiInfo">
          <swak:item id="kaiykhmk" />
          <swak:item id="tumitatekin" />
          <swak:item id="sjkkktyouseigk" />
        </swak:group>

        <%-- dispgensengkInfo --%>
        <swak:group id="dispgensengkInfo">
          <swak:item id="dispgensengk" />
          <swak:item id="kztgk" />
          <swak:item id="disphtykeihi" />
        </swak:group>

        <%-- htykeihiInfo --%>
        <swak:group id="htykeihiInfo">
          <swak:item id="htykeihi" />
        </swak:group>

        <%-- ●必要書類 --%>
        <swak:group id="hituyouSyoruiInfo">
          <swak:item id="disphtysyorui" />
        </swak:group>

        <%-- ●本人確認 --%>
        <swak:group id="honninKakuninInfobyjb">
          <swak:item id="honninkakninkekkakbnbyjb" />
        </swak:group>

        <%-- ●コメント --%>
        <swak:group id="commentInfobyjb">
          <swak:item id="syanaimsgkkanribyjb" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="syoukainomibtn" />
          <swak:item id="sainyuuryokubtn" />
          <swak:item id="kakuninbtnbyjyoubu" />
          <swak:item id="skssakuseibtn" />
        </swak:buttonGroup>

        <%-- ●送金先口座情報 --%>
        <swak:group id="kouzaInfo">
          <swak:item id="soukinsakikbn" />
          <swak:item id="shrhousiteikbn" />
          <swak:item id="bankcd" />
          <swak:item id="banknmkj" />
          <swak:item id="sitencd" />
          <swak:item id="sitennmkj" />
          <swak:item id="yokinkbn" />
          <swak:item id="kouzano10keta" />
          <swak:item id="kzdoukbn" />
          <swak:item id="kzmeiginmkn" />
        </swak:group>

        <%-- ●本人確認 --%>
        <swak:group id="honninKakuninInfobykb">
          <swak:item id="honninkakninkekkakbnbykb" />
        </swak:group>

        <%-- ●コメント --%>
        <swak:group id="commentInfobykb">
          <swak:item id="syanaimsgkkanribykb" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="nyuuryokubtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="syoukaibtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="kakuninbtnbykabu" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteibtnbyconfirm" />
        </swak:buttonGroup>

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="syokigamenhebtnbyresult" />
        </swak:buttonGroup>

        <%-- footerButtons6 --%>
        <swak:buttonGroup id="footerButtons6">
          <swak:item id="modorubtnbysksconfirm" />
          <swak:item id="kakuteibtnbysksconfirm" />
        </swak:buttonGroup>

        <%-- footerButtons7 --%>
        <swak:buttonGroup id="footerButtons7">
          <swak:item id="syokigamenhebtnbysksresult" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
