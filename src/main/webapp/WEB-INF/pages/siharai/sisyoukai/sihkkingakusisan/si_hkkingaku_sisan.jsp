<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：保険金額試算
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sisyoukai/sihkkingakusisan/SiHkkingakuSisan.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchCondition --%>
        <swak:group id="searchCondition">
          <swak:item id="syono" />
        </swak:group>

        <%-- ●契約者情報 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="kyknmkn" />
          <swak:item id="kyknmkj" />
          <swak:item id="kykseiymd" />
          <swak:item id="kyksei" />
        </swak:group>

        <%-- ●通信先住所情報 --%>
        <swak:group id="tusinsakiInfo">
          <swak:item id="tsinyno" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
        </swak:group>

        <%-- ●被保険者情報 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
          <swak:item id="hhknseiymd" />
          <swak:item id="hhknsei" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo">
          <swak:item id="sbuktnin" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo1">
          <swak:item id="dispsbuktkbn1" />
          <swak:item id="dispsbuktnmkn1" />
          <swak:item id="dispsbuktnmkj1" />
          <swak:item id="dispsbuktseiymd1" />
          <swak:item id="dispmskmjskjuktnen1" />
          <swak:item id="dispsbuktbnwari1" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo2">
          <swak:item id="dispsbuktkbn2" />
          <swak:item id="dispsbuktnmkn2" />
          <swak:item id="dispsbuktnmkj2" />
          <swak:item id="dispsbuktseiymd2" />
          <swak:item id="dispmskmjskjuktnen2" />
          <swak:item id="dispsbuktbnwari2" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo3">
          <swak:item id="dispsbuktkbn3" />
          <swak:item id="dispsbuktnmkn3" />
          <swak:item id="dispsbuktnmkj3" />
          <swak:item id="dispsbuktseiymd3" />
          <swak:item id="dispmskmjskjuktnen3" />
          <swak:item id="dispsbuktbnwari3" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="uketorininsbInfo4">
          <swak:item id="dispsbuktkbn4" />
          <swak:item id="dispsbuktnmkn4" />
          <swak:item id="dispsbuktnmkj4" />
          <swak:item id="dispsbuktseiymd4" />
          <swak:item id="dispmskmjskjuktnen4" />
          <swak:item id="dispsbuktbnwari4" />
        </swak:group>

        <%-- ●試算情報 --%>
        <swak:group id="sisanInfo">
          <swak:item id="seikyuusyubetu" />
          <swak:item id="geninkbn" />
          <swak:item id="suketorihouhoukbn" />
          <swak:item id="calckijyunymd" />
          <swak:item id="IJC1045" />
          <swak:item id="knsnkijyunymd" />
          <swak:item id="IJC1026" />
          <swak:item id="kawaserate" />
          <swak:item id="IJC1027" />
          <swak:item id="sihknknuktbnwari" />
          <swak:item id="hasuukasanhyouji" />
          <swak:item id="zeitratkikbn" />
        </swak:group>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="hkngksisanbtn" />
        </swak:buttonGroup>

        <%-- ●払込情報 --%>
        <swak:group id="haraikomuInfo">
          <swak:item id="itijibrp" />
          <swak:item id="kihrkmp" />
          <swak:item id="ryosyuymd" />
          <swak:item id="vhrkiyentkykwsratetuukasyu" />
          <swak:item id="yenkansantkykwsrate" />
          <swak:item id="IJC1049" />
          <swak:item id="vhrkiyenkansannyknkingk" />
        </swak:group>

        <%-- ●試算結果 --%>
        <swak:group id="sisanKekkaInfo">
          <swak:item id="hokenkinsyurui" />
          <swak:item id="dispsuketorihouhoukbn" />
          <swak:item id="dispcalckijyunymd" />
          <swak:item id="dispknsnkijyunymd" />
          <swak:item id="disptuukasyu" />
          <swak:item id="dispkawaserate" />
          <swak:item id="gaikaknsnkwsratekjymd" />
          <swak:item id="disptuukasyu2" />
          <swak:item id="gaikaknsnkwsrate" />
          <swak:item id="dispsihknknuktbnwari" />
          <swak:item id="disphasuukasanhyouji" />
          <swak:item id="hokenkngk" />
          <swak:item id="yenhokenkngk" />
          <swak:item id="ptumitatekin" />
          <swak:item id="jpyptumitatekin" />
          <swak:item id="haitoukin" />
          <swak:item id="yenkahaitoukin" />
          <swak:item id="sonotahaitoukin" />
          <swak:item id="yenkasonotahaitoukin" />
          <swak:item id="mikeikapgaitoukkn" />
          <swak:item id="mikeikap" />
          <swak:item id="yenkamikeikap" />
          <swak:item id="misyuupgaitoukkn" />
          <swak:item id="misyuup" />
          <swak:item id="yenkamisyuup" />
          <swak:item id="zennouseisankgk" />
          <swak:item id="yenkazennouseisankgk" />
          <swak:item id="azukarikingk" />
          <swak:item id="yenkaazukarikingk" />
          <swak:item id="krkgk" />
          <swak:item id="yenkakrkgk" />
        </swak:group>

        <%-- goukeigkInfo --%>
        <swak:group id="goukeigkInfo">
          <swak:item id="dispgoukeigk" />
          <swak:item id="dispyenkagoukeigk" />
        </swak:group>

        <%-- ●税務情報 --%>
        <swak:group id="zeimuInfo">
          <swak:item id="dispzeitratkikbn" />
          <swak:item id="synykngk" />
          <swak:item id="gaikashrsynykngk" />
          <swak:item id="kztkgk" />
        </swak:group>

        <%-- ●時効消滅後資金移動額　※支払遅延利息発生時は、支払通貨に関わらず、支払遅延利息の契約通貨額を足しこむ。 --%>
        <swak:group id="sikinidougakuInfo">
          <swak:item id="sikinidougaku" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="ketteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="syokigamenheBtn" />
          <swak:item id="sisansyosakuseibtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
