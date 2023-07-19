<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：（保険金）承認
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sisatei/sisyouninhkn/SiSyouninHkn.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- IBA0001 --%>

        <swak:message id = "IBA0001" />


        <%-- 基本情報 --%>
        <swak:group id="hktskKihonInfo">
          <swak:item id="syono" />
          <swak:item id="skno" />
          <swak:item id="firstsyoruiuketukeymd" />
          <swak:item id="lastsyoruiuketukeymd" />
        </swak:group>

        <%-- ●支払合計 --%>
        <swak:group id="hktshrGoukeiInfo">
          <swak:item id="sateikekka" />
          <swak:item id="hushrgeninkbn" />
          <swak:item id="sindansyoryoushryouhikbn" />
          <swak:item id="sindansyomaisuu" />
        </swak:group>

        <%-- ●支払合計 --%>
        <swak:group id="hktshrGoukeiInfo1">
          <swak:item id="siharaiymd" />
          <swak:item id="dispsinsagendokknkbn" />
          <swak:item id="disprkktydnnissuu" />
        </swak:group>

        <%-- hktshrGoukeiInfo2 --%>
        <swak:group id="hktshrGoukeiInfo2">
          <swak:item id="shrgkkei" />
          <swak:item id="hokenkngkgoukei" />
          <swak:item id="mikeikap" />
          <swak:item id="misyuup" />
          <swak:item id="sonotaseisangk" />
          <swak:item id="disptienrisokukisanymd" />
          <swak:item id="shrtienrsk" />
        </swak:group>

        <%-- ●承認 --%>
        <swak:group id="syounin">
          <swak:item id="dispsateikekka" />
          <swak:item id="disphushrgeninkbn" />
          <swak:item id="dispsindansyoryoushryhkbn" />
          <swak:item id="dispsindansyomaisuu" />
          <swak:item id="reportcommentgamen" />
          <swak:item id="syouninkekka" />
          <swak:item id="syanaicommentgamen" />
        </swak:group>

        <%-- ●確認項目 --%>
        <swak:group id="sakugennKakuninnInfo">
          <swak:item id="sakugenshrkakuninkanryou" />
          <swak:item id="sakugenshrkak" />
          <swak:item id="IJC0010" />
        </swak:group>

        <%-- ●進捗履歴情報 --%>
        <swak:dataTable id="kanriTtdkRrkInfo">
          <swak:column id="dispstrksyoriymd" />
          <swak:column id="dispkinoussnm" />
          <swak:column id="dispkekka" />
          <swak:column id="dispsousasyanm" />
          <swak:column id="dispcomment" />
        </swak:dataTable>

        <%-- ●同時請求契約 --%>
        <swak:dataTable id="skKihonKanriInfo">
          <swak:column id="dispsyono" />
          <swak:column id="dispsyoriymd" />
          <swak:column id="dispnextsyorinm" />
          <swak:column id="disphubikbn" />
          <swak:column id="disptyousajkkbn" />
        </swak:dataTable>

        <%-- ●別契約情報 --%>
        <swak:dataTable id="betukykInfo">
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

        <%-- ●契約者情報 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="kyknmkn" />
          <swak:item id="kyknmkj" />
          <swak:item id="kykseiymd" />
          <swak:item id="kyksei" />
        </swak:group>

        <%-- ●被保険者情報 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
          <swak:item id="hhknseiymd" />
          <swak:item id="hhknsei" />
        </swak:group>

        <%-- ●請求者情報 --%>
        <swak:group id="skjyouhou">
          <swak:item id="seikyuusyakbn" />
          <swak:item id="seikyuusyanmkn" />
          <swak:item id="seikyuusyanmkj" />
          <swak:item id="seikyuusyatdk" />
          <swak:item id="IJC0012" />
        </swak:group>

        <%-- ●受取人情報 --%>
        <swak:group id="uktKyksyaInfo">
          <swak:item id="uktkyksyatdk" />
        </swak:group>

        <%-- ●送付先情報 --%>
        <swak:group id="souhusakiInfo">
          <swak:item id="souhusakikbn" />
          <swak:item id="tsinyno" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
          <swak:item id="tsinadr4kj" />
          <swak:item id="tsintelno1" />
          <swak:item id="tsintelno2" />
        </swak:group>

        <%-- nittyuurenrakusakiInfo --%>
        <swak:group id="nittyuurenrakusakiInfo">
          <swak:item id="nittyuurenrakusaki" />
        </swak:group>

        <%-- ●送金先口座情報 --%>
        <swak:group id="soukinsaki">
          <swak:item id="soukinsakikbn" />
          <swak:item id="shrhousiteikbn" />
          <swak:item id="bankcd" />
          <swak:item id="banknmkj" />
          <swak:item id="sitencd" />
          <swak:item id="sitennmkj" />
          <swak:item id="yokinkbn" />
          <swak:item id="kouzano" />
          <swak:item id="kzmeiginmkn" />
        </swak:group>

        <%-- ●請求内容 --%>
        <swak:group id="sknaiyouInfo">
          <swak:item id="geninkbn1" />
          <swak:item id="sibouymd" />
          <swak:item id="syougaikoteiymd" />
          <swak:item id="sggeninkbn1" />
          <swak:item id="IJC0003" />
          <swak:item id="jikoymd1" />
          <swak:item id="IJC0003" />
          <swak:item id="byoumeitourokuno" />
          <swak:item id="clearbtnbybyoumei" />
          <swak:item id="IAW0001" />
          <swak:item id="syoubyounmkjgamen" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IAW0001" />
          <swak:item id="IJC0004" />
          <swak:item id="siboubasyokbn" />
          <swak:item id="siboubasyo" />
          <swak:item id="gankbn" />
          <swak:item id="sandaisippeikbn" />
          <swak:item id="syoubyounmkn" />
          <swak:item id="nanadaisippeikbn" />
          <swak:item id="kansensyoukbn" />
        </swak:group>

        <%-- ●支払詳細 --%>
        <swak:dataTable id="hktshrMeisaisInfo">
          <swak:column id="dispkyhnm" />
          <swak:column id="dispkyhkg" />
          <swak:column id="dispbikoumsg1" />
          <swak:column id="dispbikoumsg2" />
          <swak:column id="dispbikoumsg3" />
          <swak:column id="dispbikoumsg4" />
        </swak:dataTable>

        <%-- ●調査履歴 --%>
        <swak:dataTable id="hkttyousaRrkInfo">
          <swak:column id="dispno" />
          <swak:column id="disptyousasiraiymd" />
          <swak:column id="dispiraisyaid" />
          <swak:column id="disptyousakanymd" />
        </swak:dataTable>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
