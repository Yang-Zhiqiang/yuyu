<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：申込書入力
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skmousikomi/skmousikomisyo/SkMousikomisyo.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- buttonNyuuryokuSaiSyoukai --%>
        <swak:buttonGroup id="buttonNyuuryokuSaiSyoukai">
          <swak:item id="nyuuryokusaisyoukaibtn" />
        </swak:buttonGroup>

        <%-- buttonHubisyousai --%>
        <swak:group id="buttonHubisyousai">
          <swak:item id="hubisyousaibtn" />
          <swak:item id="hubisyousaibtn2" />
        </swak:group>

        <%-- linkButtons1 --%>
        <swak:buttonGroup id="linkButtons1">
          <swak:item id="keiyakusyajouhoubtn" />
          <swak:item id="tusinsakijouhoubtn" />
          <swak:item id="hihokensyajouhoubtn" />
          <swak:item id="uketorininbtn" />
          <swak:item id="hosyouinfobtn" />
          <swak:item id="kzktourokubtn" />
          <swak:item id="kykdairininbtn" />
        </swak:buttonGroup>

        <%-- linkButtons2 --%>
        <swak:buttonGroup id="linkButtons2">
          <swak:item id="siteidairininbtn" />
          <swak:item id="kouhurikouzainfobtn" />
          <swak:item id="dairitenjouhoubtn" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiinfo">
          <swak:item id="vktifdispjimutetuzukinm" />
          <swak:item id="vktifdisptasknm" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="baseInfo">
          <swak:item id="mosno" />
          <swak:item id="aitemosno" />
          <swak:item id="doujikaiyakusyono" />
          <swak:item id="mosymd" />
          <swak:item id="jimuyoucd" />
          <swak:item id="kykymd" />
          <swak:item id="bosyuuym" />
          <swak:item id="sknnkaisiymd" />
          <swak:item id="seisekiym" />
        </swak:group>

        <%-- baseInfo2 --%>
        <swak:group id="baseInfo2">
          <swak:item id="mosuketukekbn" />
          <swak:item id="hknsyuruinomosinput" />
          <swak:item id="aisyoumeikbn" />
          <swak:item id="aisyoumei" />
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

        <%-- ●契約者情報 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="kykkbn" />
          <swak:item id="yakkanjyuryouhoukbn" />
          <swak:item id="fatcasnsikbn" />
          <swak:item id="bikkjnssinfokbn" />
          <swak:item id="bikknzsyno" />
          <swak:item id="aeoisnsikbn" />
        </swak:group>

        <%-- ※被保険者と別人の場合のみ入力。 --%>
        <swak:group id="keiyakusyaInfo2">
          <swak:item id="kyknmkn" />
          <swak:item id="kyknmkj" />
          <swak:item id="kyknmkjkhuka" />
          <swak:item id="kyknmkjkhukakbn" />
          <swak:item id="kykseiymd" />
          <swak:item id="kyksei" />
          <swak:item id="kyknen" />
          <swak:item id="kyktdk" />
        </swak:group>

        <%-- ●通信先情報 --%>
        <swak:group id="tuusinsakiInfo">
          <swak:item id="tsinyno" />
          <swak:item id="haneibtnbytsinsakijyouhou" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
          <swak:item id="tsintelno" />
          <swak:item id="dai2tsintelno" />
        </swak:group>

        <%-- ●被保険者情報 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
          <swak:item id="hhknnmkjkhuka" />
          <swak:item id="hhknnmkjkhukakbn" />
          <swak:item id="hhknseiymd" />
          <swak:item id="hhknsei" />
          <swak:item id="hhknnen" />
          <swak:item id="tsindousitei" />
          <swak:item id="tsindousiteikbn" />
          <swak:item id="hhknyno" />
          <swak:item id="haneibtnbyhihokensyajyouhou" />
          <swak:item id="IHF0044" />
          <swak:item id="hhknadr1kj" />
          <swak:item id="hhknadr2kj" />
          <swak:item id="hhknadr3kj" />
          <swak:item id="hhkntelno" />
          <swak:item id="kktymd" />
          <swak:item id="hhknsykgycd" />
          <swak:item id="hhknsykgynm" />
          <swak:item id="hhknnensyuukbn" />
        </swak:group>

        <%-- ●年金受取人情報 --%>
        <swak:group id="nenkinUketorininInfo">
          <swak:item id="nenkinuktkbn" />
          <swak:item id="nkukthyoujimongon" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="sibouUketorininInfo">
          <swak:item id="sbuktnin" />
        </swak:group>

        <%-- sibouUketorininInfo1 --%>
        <swak:group id="sibouUketorininInfo1">
          <swak:item id="sbuktkbn1" />
          <swak:item id="sbuktnmkn1" />
          <swak:item id="sbuktnmkj1" />
          <swak:item id="sbuktnmkjkhuka1" />
          <swak:item id="sbuktnmkjhukakbn1" />
          <swak:item id="sbuktseiymd1" />
          <swak:item id="sbukttdk1" />
          <swak:item id="sbuktbnwari1" />
        </swak:group>

        <%-- sibouUketorininInfo2 --%>
        <swak:group id="sibouUketorininInfo2">
          <swak:item id="sbuktkbn2" />
          <swak:item id="sbuktnmkn2" />
          <swak:item id="sbuktnmkj2" />
          <swak:item id="sbuktnmkjkhuka2" />
          <swak:item id="sbuktnmkjhukakbn2" />
          <swak:item id="sbuktseiymd2" />
          <swak:item id="sbukttdk2" />
          <swak:item id="sbuktbnwari2" />
        </swak:group>

        <%-- sibouUketorininInfo3 --%>
        <swak:group id="sibouUketorininInfo3">
          <swak:item id="sbuktkbn3" />
          <swak:item id="sbuktnmkn3" />
          <swak:item id="sbuktnmkj3" />
          <swak:item id="sbuktnmkjkhuka3" />
          <swak:item id="sbuktnmkjhukakbn3" />
          <swak:item id="sbuktseiymd3" />
          <swak:item id="sbukttdk3" />
          <swak:item id="sbuktbnwari3" />
        </swak:group>

        <%-- sibouUketorininInfo4 --%>
        <swak:group id="sibouUketorininInfo4">
          <swak:item id="sbuktkbn4" />
          <swak:item id="sbuktnmkn4" />
          <swak:item id="sbuktnmkj4" />
          <swak:item id="sbuktnmkjkhuka4" />
          <swak:item id="sbuktnmkjhukakbn4" />
          <swak:item id="sbuktseiymd4" />
          <swak:item id="sbukttdk4" />
          <swak:item id="sbuktbnwari4" />
        </swak:group>

        <%-- ●主契約保障情報 --%>
        <swak:group id="syukeiyakuHosyouInfo">
          <swak:item id="syuhrkkkn" />
          <swak:item id="syuhrkkknsmnkbn" />
          <swak:item id="syuhknkkn" />
          <swak:item id="syuhknkknsmnkbn" />
          <swak:item id="syudai1hknkknmosinput" />
          <swak:item id="sdpdkbn" />
          <swak:item id="IHF1037" />
          <swak:item id="nenkinsyumosinput" />
          <swak:item id="zenkizennouumumosinput" />
          <swak:item id="znnkai" />
          <swak:item id="hrkkaisuumosinput" />
          <swak:item id="hrkkeiro" />
          <swak:item id="fstphrkkeirokbn" />
          <swak:item id="ikkatubaraikaisuumosinput" />
        </swak:group>

        <%-- ●主契約保障情報（米ドル） --%>
        <swak:group id="syukeiyakuHosyouInfoBei">
          <swak:item id="kyktuukasyumosinput" />
          <swak:item id="hrktuukasyumosinput" />
          <swak:item id="syukihons" />
          <swak:item id="hrktuukasyukykp" />
          <swak:item id="mosikkatup" />
          <swak:item id="mossyukykp" />
          <swak:item id="moszennoupsyokaiari" />
          <swak:item id="sisuuhaibunwarikbn" />
          <swak:item id="sisuunm" />
          <swak:item id="teirituhaibunwarikbn" />
          <swak:item id="sueokikknmosinput" />
          <swak:item id="nkgnshosyouritukbn" />
          <swak:item id="kjnnkpzeitekitkhukakbn" />
          <swak:item id="dispcreditkessaiyouno" />
        </swak:group>

        <%-- ●主契約保障情報（豪ドル） --%>
        <swak:group id="syukeiyakuHosyouInfoGou">
          <swak:item id="kyktuukasyu2mosinput" />
          <swak:item id="hrktuukasyu2mosinput" />
          <swak:item id="kihons2" />
          <swak:item id="hrktuukasyukykp2" />
          <swak:item id="mosikkatup2" />
          <swak:item id="moszennoupsyokaiari2" />
          <swak:item id="kjnnkpzeitekitkhukakbn2" />
          <swak:item id="dispcreditkessaiyouno2" />
        </swak:group>

        <%-- ●その他特約情報 --%>
        <swak:group id="sonotaTokuyakuiInfo">
          <swak:item id="IAW0001" />
        </swak:group>

        <%-- uketorikouzaInfo --%>
        <swak:group id="uketorikouzaInfo">
          <swak:item id="teikisiharaitkykhkkbn" />
          <swak:item id="shkstkzinfkzinfoinputhry" />
          <swak:item id="shkstkzinfkzinfoinputhrykbn" />
          <swak:item id="IHF1009" />
          <swak:item id="kzsyuruikbn" />
          <swak:item id="bankcd" />
          <swak:item id="banknmkj" />
          <swak:item id="IBC1001" />
          <swak:item id="sitencd" />
          <swak:item id="sitennmkj" />
          <swak:item id="IBC1002" />
          <swak:item id="yokinkbn" />
          <swak:item id="IBC1003" />
          <swak:item id="kouzano" />
          <swak:item id="IBC1004" />
          <swak:item id="kzkykdoukbn" />
          <swak:item id="IHF1031" />
          <swak:item id="kzmeiginmkn" />
          <swak:item id="IHF1011" />
        </swak:group>

        <%-- sonotaTokuyakuInfo2 --%>
        <swak:group id="sonotaTokuyakuInfo2">
          <swak:item id="mkhgkwarimosinput" />
          <swak:item id="syksbyensitihsyutkhkkbn" />
          <swak:item id="jyudkaigomehrtkhkkbn" />
          <swak:item id="nstkhkkbn" />
          <swak:item id="nstksbnkkn" />
        </swak:group>

        <%-- ●ご家族登録サービス情報 --%>
        <swak:group id="kzkourokuserviceYourokuInfo">
          <swak:item id="kzktourokuservicetourokukbn" />
        </swak:group>

        <%-- 登録家族１人目 --%>
        <swak:group id="kzkourokuserviceYourokuInfo1">
          <swak:item id="trkkzknmkn1" />
          <swak:item id="trkkzknmkj1" />
          <swak:item id="trkkzknmkjkhuka1" />
          <swak:item id="trkkzknmkjkhukakbn1" />
          <swak:item id="trkkzkseiymd1" />
          <swak:item id="trkkzksei1" />
          <swak:item id="trkkzktdk1" />
          <swak:item id="IHF1026" />
          <swak:item id="trkkzktsindousitei1" />
          <swak:item id="trkkzktsindousiteikbn1" />
          <swak:item id="trkkzkyno1" />
          <swak:item id="haneibtnbytrkkzkadr1" />
          <swak:item id="trkkzkadr1kj1" />
          <swak:item id="trkkzkadr2kj1" />
          <swak:item id="trkkzkadr3kj1" />
          <swak:item id="trkkzktelno1" />
        </swak:group>

        <%-- 登録家族２人目 --%>
        <swak:group id="kzkourokuserviceYourokuInfo2">
          <swak:item id="trkkzknmkn2" />
          <swak:item id="trkkzknmkj2" />
          <swak:item id="trkkzknmkjkhuka2" />
          <swak:item id="trkkzknmkjkhukakbn2" />
          <swak:item id="trkkzkseiymd2" />
          <swak:item id="trkkzksei2" />
          <swak:item id="trkkzktdk2" />
          <swak:item id="IHF1026" />
          <swak:item id="trkkzktsindousitei2" />
          <swak:item id="trkkzktsindousiteikbn2" />
          <swak:item id="trkkzkyno2" />
          <swak:item id="haneibtnbytrkkzkadr2" />
          <swak:item id="trkkzkadr1kj2" />
          <swak:item id="trkkzkadr2kj2" />
          <swak:item id="trkkzkadr3kj2" />
          <swak:item id="trkkzktelno2" />
        </swak:group>

        <%-- ●保険契約者代理特約情報 --%>
        <swak:group id="kykDairiSeikyuninInfo">
          <swak:item id="kykdrtkykhukakbn" />
          <swak:item id="kykdrkbn" />
        </swak:group>

        <%-- ●被保険者代理特約情報 --%>
        <swak:group id="siteiDairiSeikyuninInfo">
          <swak:item id="stdrsktkyhkkbn" />
          <swak:item id="IHF1027" />
          <swak:item id="stdruktkbn" />
          <swak:item id="IHF1028" />
          <swak:item id="siteidruktnmkn" />
          <swak:item id="siteidruktnmkj" />
          <swak:item id="stdrsknmkjkhuka" />
          <swak:item id="stdrsknmkjhukakbn" />
          <swak:item id="stdrskseiymd" />
          <swak:item id="stdrsktdk" />
        </swak:group>

        <%-- ●ダイレクトサービス --%>
        <swak:group id="drctserviceInfo">
          <swak:item id="drctservicemoskbn" />
        </swak:group>

        <%-- ●保険料通知情報 --%>
        <swak:group id="ptuutiinfo">
          <swak:item id="ynkhrkmgkannituutikbn" />
        </swak:group>

        <%-- ●口振口座情報 --%>
        <swak:group id="kouhurikouzaInfo">
          <swak:item id="kzhuritourokuhoukbn" />
          <swak:item id="IHF1030" />
          <swak:item id="kouzainfoinputhoryuu" />
          <swak:item id="kouzainfoinputhoryuukbn" />
          <swak:item id="IHF1009" />
          <swak:item id="kouhurikouzainfobankcd" />
          <swak:item id="kouhurikouzainfobanknmkj" />
          <swak:item id="IBC1001" />
          <swak:item id="kouhurikouzainfositencd" />
          <swak:item id="kouhurikouzainfositennmkj" />
          <swak:item id="IBC1002" />
          <swak:item id="kouhurikouzainfoyokinkbn" />
          <swak:item id="IBC1003" />
          <swak:item id="kouhurikouzainfokouzano" />
          <swak:item id="IBC1004" />
          <swak:item id="kouhurikouzainfokzdoukbn" />
          <swak:item id="IHF1010" />
          <swak:item id="kouhurikouzainfokzmeiginmkn" />
          <swak:item id="IHF1011" />
          <swak:item id="kouzakakuniniraikbn" />
          <swak:item id="IHF1012" />
        </swak:group>

        <%-- ●本人確認情報 --%>
        <swak:group id="honninKakninInfo">
          <swak:item id="kykhonninkakninsyoruikbn" />
          <swak:item id="skskknhonninkakninsyoruikbn" />
        </swak:group>

        <%-- ●高齢者情報 --%>
        <swak:group id="koureisyaInfo">
          <swak:item id="koureikzksetumeihoukbn" />
          <swak:item id="koureimndnhukusuukaikbn" />
          <swak:item id="koureitratkisyaigidskkbn" />
        </swak:group>

        <%-- ●代理店情報 --%>
        <swak:group id="dairitenInfo">
          <swak:item id="IAW0001" />
        </swak:group>

        <%-- Ａ代理店 --%>
        <swak:group id="dairitenInfoA">
          <swak:item id="drtenjimcd1" />
          <swak:item id="dairitenkinyuukikancd1" />
          <swak:item id="dairitenkinyuukikansitencd1" />
          <swak:item id="drtenkinyuusitencd1x3keta" />
          <swak:item id="dairitentoriatukaikouincd1" />
          <swak:item id="inputbosyuucd1" />
          <swak:item id="bosyuunintourokuno1" />
          <swak:item id="toriatukaidairitencd1" />
          <swak:item id="toriatukaidairitennm1" />
          <swak:item id="oyadairitencd1" />
          <swak:item id="oyadairitennm1" />
          <swak:item id="bosyuucd1" />
          <swak:item id="bosyuuninnm1" />
          <swak:item id="gyskkjsakisosikicd1" />
          <swak:item id="gyskkjsakisosikinmkj1" />
          <swak:item id="IHF1001" />
          <swak:item id="dairitenbuntanwariai1" />
          <swak:item id="IHF1001" />
          <swak:item id="cifcd" />
          <swak:item id="uktkid" />
          <swak:item id="IHF0047" />
        </swak:group>

        <%-- Ｂ代理店 --%>
        <swak:group id="dairitenInfoB">
          <swak:item id="drtenjimcd2" />
          <swak:item id="dairitenkinyuukikancd2" />
          <swak:item id="dairitenkinyuukikansitencd2" />
          <swak:item id="drtenkinyuusitencd2x3keta" />
          <swak:item id="dairitentoriatukaikouincd2" />
          <swak:item id="inputbosyuucd2" />
          <swak:item id="bosyuunintourokuno2" />
          <swak:item id="toriatukaidairitencd2" />
          <swak:item id="toriatukaidairitennm2" />
          <swak:item id="oyadairitencd2" />
          <swak:item id="oyadairitennm2" />
          <swak:item id="bosyuucd2" />
          <swak:item id="bosyuuninnm2" />
          <swak:item id="gyskkjsakisosikicd2" />
          <swak:item id="gyskkjsakisosikinmkj2" />
          <swak:item id="IHF1001" />
          <swak:item id="dairitenbuntanwariai2" />
        </swak:group>

        <%-- ●特殊項目コード --%>
        <swak:group id="tokusyukoumokuInfo">
          <swak:item id="tsryhshrkykumukbn" />
          <swak:item id="syosisyatodokeumukbn" />
          <swak:item id="kakukisyouryakukbumukbn" />
          <swak:item id="seiymdmosseitouumukbn" />
        </swak:group>

        <%-- ●その他 --%>
        <swak:group id="sonotaInfo">
          <swak:item id="tkhsyouryaku" />
          <swak:item id="tkhsyouryakuumukbn" />
        </swak:group>

        <%-- ●申込点検情報 --%>
        <swak:group id="mosTenkenInfo">
          <swak:item id="khnchkcmnt" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="sinkiitijibtn" />
          <swak:item id="sinkinijibtn" />
          <swak:item id="sinkisanjibtn" />
          <swak:item id="henkouteiseibtn" />
          <swak:item id="henkoutsskbtnbyinputkey" />
          <swak:item id="nyuuryokutsbtnbyinputkey" />
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
          <swak:item id="nyuuryokuteiseibtnbyresult" />
          <swak:item id="henkoutsskbtnbyresult" />
        </swak:buttonGroup>

        <%-- seigyoGroup --%>
        <swak:group id="seigyoGroup">
          <swak:item id="uniqueId" />
          <swak:item id="uniqueid2" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
