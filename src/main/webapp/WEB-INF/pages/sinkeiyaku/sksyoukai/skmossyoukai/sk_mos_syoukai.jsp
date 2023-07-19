<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：申込状況照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sksyoukai/skmossyoukai/SkMosSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- buttonKykNaiyouSyoukai --%>
        <swak:buttonGroup id="buttonKykNaiyouSyoukai">
          <swak:item id="kyknaiyousyoukaibtn" />
        </swak:buttonGroup>

        <%-- pageButtons1 --%>
        <swak:buttonGroup id="pageButtons1">
          <swak:item id="kyknaiyoubtnbykeiyakunaiyou" />
          <swak:item id="hubijkbtnbykeiyakunaiyou" />
          <swak:item id="hbtrjhbtnbykeiyakunaiyou" />
          <swak:item id="ktjkbtnbykeiyakunaiyou" />
          <swak:item id="nkjkbtnbykeiyakunaiyou" />
          <swak:item id="kouteijkbtnbykeiyakunaiyou" />
          <swak:item id="srttjkbtnbykeiyakunaiyou" />
          <swak:item id="tsrrkbtnbykeiyakunaiyou" />
        </swak:buttonGroup>

        <%-- pageButtons11 --%>
        <swak:buttonGroup id="pageButtons11">
          <swak:item id="skininfobtnbykeiyakunaiyou" />
        </swak:buttonGroup>

        <%-- pageButtons2 --%>
        <swak:buttonGroup id="pageButtons2">
          <swak:item id="kyknaiyoubtnbyhubijk" />
          <swak:item id="hubijyoukyoubtnbyhubijk" />
          <swak:item id="hubitourokuinfobtnbyhubijk" />
          <swak:item id="ketteijyoukyoubtnbyhubijk" />
          <swak:item id="nyuukinjyoukyoubtnbyhubijk" />
          <swak:item id="kouteijkbtnbyhubijk" />
          <swak:item id="srttjkbtnbyhubijk" />
          <swak:item id="tsrrkbtnbyhubijk" />
        </swak:buttonGroup>

        <%-- pageButtons12 --%>
        <swak:buttonGroup id="pageButtons12">
          <swak:item id="skininfobtnbyhubijk" />
        </swak:buttonGroup>

        <%-- pageButtons3 --%>
        <swak:buttonGroup id="pageButtons3">
          <swak:item id="kyknaiyoubtnbyhubitrkinfo" />
          <swak:item id="hubijkbtnbyhubitrkinfo" />
          <swak:item id="hbtrjhbtnbyhubitrkinfo" />
          <swak:item id="ktjkbtnbyhubitrkinfo" />
          <swak:item id="nkjkbtnbyhubitrkinfo" />
          <swak:item id="kouteijkbtnbyhubitrkinfo" />
          <swak:item id="srttjkbtnbyhubitrkinfo" />
          <swak:item id="tsrrkbtnbyhubitrkinfo" />
        </swak:buttonGroup>

        <%-- pageButtons13 --%>
        <swak:buttonGroup id="pageButtons13">
          <swak:item id="skininfobtnbyhubitrkinfo" />
        </swak:buttonGroup>

        <%-- pageButtons4 --%>
        <swak:buttonGroup id="pageButtons4">
          <swak:item id="kyknaiyoubtnbyketteijk" />
          <swak:item id="hubijyoukyoubtnbyketteijk" />
          <swak:item id="hbtrjhbtnbyketteijk" />
          <swak:item id="ketteijyoukyoubtnbyketteijk" />
          <swak:item id="nkjkbtnbyketteijk" />
          <swak:item id="kouteijkbtnbyketteijk" />
          <swak:item id="srttjkbtnbyketteijk" />
          <swak:item id="tsrrkbtnbyketteijk" />
        </swak:buttonGroup>

        <%-- pageButtons14 --%>
        <swak:buttonGroup id="pageButtons14">
          <swak:item id="skininfobtnbyketteijk" />
        </swak:buttonGroup>

        <%-- pageButtons5 --%>
        <swak:buttonGroup id="pageButtons5">
          <swak:item id="kyknaiyoubtnbynyuukinjk" />
          <swak:item id="hubijyoukyoubtnbynyuukinjk" />
          <swak:item id="hbtrjhbtnbynyuukinjk" />
          <swak:item id="ktjkbtnbynyuukinjk" />
          <swak:item id="nkjkbtnbynyuukinjk" />
          <swak:item id="kouteijkbtnbynyuukinjk" />
          <swak:item id="srttjkbtnbynyuukinjk" />
          <swak:item id="tsrrkbtnbynyuukinjk" />
        </swak:buttonGroup>

        <%-- pageButtons15 --%>
        <swak:buttonGroup id="pageButtons15">
          <swak:item id="skininfobtnbynyuukinjk" />
        </swak:buttonGroup>

        <%-- pageButtons6 --%>
        <swak:buttonGroup id="pageButtons6">
          <swak:item id="kyknybtnbysyoruitoutyakujk" />
          <swak:item id="hubijkbtnbysyoruitoutyakujk" />
          <swak:item id="hbtrjhbtnbysyoruitoutyakujk" />
          <swak:item id="ktjkbtnbysyoruitoutyakujk" />
          <swak:item id="nkjkbtnbysyoruitoutyakujk" />
          <swak:item id="kouteijkbtnbysrttjk" />
          <swak:item id="srttjkbtnbysyoruitoutyakujk" />
          <swak:item id="tsrrkbtnbysyoruitoutyakujk" />
        </swak:buttonGroup>

        <%-- pageButtons16 --%>
        <swak:buttonGroup id="pageButtons16">
          <swak:item id="skininfobtnbysyoruittykjk" />
        </swak:buttonGroup>

        <%-- pageButtons7 --%>
        <swak:buttonGroup id="pageButtons7">
          <swak:item id="kyknaiyoubtnbyteiseirrklist" />
          <swak:item id="hubijkbtnbyteiseirrklist" />
          <swak:item id="hbtrjhbtnbyteiseirrklist" />
          <swak:item id="ktjkbtnbyteiseirrklist" />
          <swak:item id="nkjkbtnbyteiseirrklist" />
          <swak:item id="kouteijkbtnbyteiseirrklist" />
          <swak:item id="srttjkbtnbyteiseirrklist" />
          <swak:item id="tsrrkbtnbyteiseirrklist" />
        </swak:buttonGroup>

        <%-- pageButtons17 --%>
        <swak:buttonGroup id="pageButtons17">
          <swak:item id="skininfobtnbyteiseirrklist" />
        </swak:buttonGroup>

        <%-- pageButtons8 --%>
        <swak:buttonGroup id="pageButtons8">
          <swak:item id="kyknaiyoubtnbyskininfo" />
          <swak:item id="hubijkbtnbyskininfo" />
          <swak:item id="hbtrjhbtnbyskininfo" />
          <swak:item id="ktjkbtnbyskininfo" />
          <swak:item id="nkjkbtnbyskininfo" />
          <swak:item id="kouteijkbtnbyskininfo" />
          <swak:item id="srttjkbtnbyskininfo" />
          <swak:item id="tsrrkbtnbyskininfo" />
        </swak:buttonGroup>

        <%-- pageButtons18 --%>
        <swak:buttonGroup id="pageButtons18">
          <swak:item id="skininfobtnbyskininfo" />
        </swak:buttonGroup>

        <%-- pageButtons9 --%>
        <swak:buttonGroup id="pageButtons9">
          <swak:item id="kyknybtnbykouteijk" />
          <swak:item id="hubijkbtnbykouteijk" />
          <swak:item id="hbtrjhbtnbykouteijk" />
          <swak:item id="ktjkbtnbykouteijk" />
          <swak:item id="nkjkbtnbykouteijk" />
          <swak:item id="kouteijkbtnbykouteijk" />
          <swak:item id="srttjkbtnbykouteijk" />
          <swak:item id="tsrrkbtnbykouteijk" />
        </swak:buttonGroup>

        <%-- pageButtons19 --%>
        <swak:buttonGroup id="pageButtons19">
          <swak:item id="skininfobtnbykouteijk" />
        </swak:buttonGroup>

        <%-- linkButtons1 --%>
        <swak:buttonGroup id="linkButtons1">
          <swak:item id="styjkbtn" />
          <swak:item id="kihonjouhoubtn" />
          <swak:item id="keiyakusyajouhoubtn" />
          <swak:item id="tusinsakijouhoubtn" />
          <swak:item id="hihokensyajouhoubtn" />
          <swak:item id="uketorininbtn" />
          <swak:item id="hosyouinfobtn" />
        </swak:buttonGroup>

        <%-- linkButtons2 --%>
        <swak:buttonGroup id="linkButtons2">
          <swak:item id="kzktourokubtn" />
          <swak:item id="kykdairininbtn" />
          <swak:item id="siteidairininbtn" />
          <swak:item id="kzjouhoubtn" />
          <swak:item id="creditbtn" />
          <swak:item id="dairitenjouhoubtn" />
        </swak:buttonGroup>

        <%-- linkButtons4 --%>
        <swak:buttonGroup id="linkButtons4">
          <swak:item id="kktjouhoubtn" />
          <swak:item id="mostenkenrrkbtn" />
          <swak:item id="knksateirirekibtn" />
          <swak:item id="imusateirirekibtn" />
          <swak:item id="dakuhiktrirekibtn" />
        </swak:buttonGroup>

        <%-- ●進捗状況 --%>
        <swak:group id="sintyokuJoukyou">
          <swak:item id="sateijtkbn" />
          <swak:item id="sateizumiymd" />
          <swak:item id="jimuyoucd" />
          <swak:item id="lastrsymd" />
          <swak:item id="zenhnknkbn" />
          <swak:item id="mosnrkumu" />
          <swak:item id="kkthjykbn" />
          <swak:item id="nyknnrkumu" />
          <swak:item id="ryosyuymd" />
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
          <swak:item id="srsyoriymd" />
          <swak:item id="syohakkouymd" />
        </swak:group>

        <%-- sintyokuJoukyou2 --%>
        <swak:group id="sintyokuJoukyou2">
          <swak:item id="mostenken1jiyhkbn" />
          <swak:item id="mostenken2jiyhkbn" />
          <swak:item id="knkysatei1jiyhkbn" />
          <swak:item id="knkysatei2jiyhkbn" />
          <swak:item id="imusateikaniyhkbn" />
          <swak:item id="lincgthtkekkbn" />
        </swak:group>

        <%-- ※ベリファイ入力状況 --%>
        <swak:group id="sintyokuJoukyou3">
          <swak:item id="mosnrkvrfjkkbn" />
          <swak:item id="kktnrkvrfjkkbn" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="baseInfo">
          <swak:item id="mosno" />
          <swak:item id="syono" />
          <swak:item id="aitemosno" />
          <swak:item id="doujikaiyakusyono" />
          <swak:item id="mosymd" />
          <swak:item id="ssyukeymd" />
          <swak:item id="kykymd" />
          <swak:item id="skykymdkbn" />
          <swak:item id="bosyuuym" />
          <swak:item id="sknnkaisiymd" />
          <swak:item id="seisekiym" />
        </swak:group>

        <%-- baseInfo1 --%>
        <swak:group id="baseInfo1">
          <swak:item id="mosuketukekbn" />
          <swak:item id="hknsyuruinm" />
          <swak:item id="aisyoumei" />
          <swak:item id="snshuhusyurui" />
        </swak:group>

        <%-- ●キー指定 --%>
        <swak:group id="syoukaiJyoukenSitei">
          <swak:item id="srchmosno" />
          <swak:item id="srchsyono" />
          <swak:item id="srchkanriid" />
        </swak:group>

        <%-- buttonSyoukai --%>
        <swak:buttonGroup id="buttonSyoukai">
          <swak:item id="syoukaibtn" />
        </swak:buttonGroup>

        <%-- ●検索条件指定 --%>
        <swak:group id="kensakuJyoukenSitei">
          <swak:item id="srchmosfromymd" />
          <swak:item id="IAW0003" />
          <swak:item id="srchmostoymd" />
          <swak:item id="drtencd" />
          <swak:item id="drtncdkensakukbn" />
          <swak:item id="srchkinyuucd" />
          <swak:item id="srchkyknmkn" />
          <swak:item id="srchkykseiymd" />
          <swak:item id="srchnyknumu" />
          <swak:item id="srchketteikbn" />
          <swak:item id="srchseiritukbn" />
          <swak:item id="srchkthhbari" />
          <swak:item id="srchsrhhbari" />
          <swak:item id="srchmkshbari" />
          <swak:item id="hknsyuruino" />
        </swak:group>

        <%-- buttonSearch --%>
        <swak:buttonGroup id="buttonSearch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- kensakuKekka --%>
        <swak:dataTable id="kensakuKekka">
          <swak:column id="dispmosno" />
          <swak:column id="dispkyknmkn" />
          <swak:column id="dispkykseiymd" />
          <swak:column id="disphknsyuruino" />
          <swak:column id="dispkkthjykbn" />
          <swak:column id="dispnyknnrkumu" />
          <swak:column id="disphubiumu" />
          <swak:column id="dispketteikbn" />
          <swak:column id="dispseiritukbn" />
          <swak:column id="dispkyknmkj" />
          <swak:column id="disphhknnmkn" />
          <swak:column id="disphhknseiymd" />
          <swak:column id="disphhknnmkj" />
        </swak:dataTable>
        <swak:pager id="kensakuKekkaDataSource" />

        <%-- ●契約者情報 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="kykkbn" />
          <swak:item id="yakkanjyuryouhoukbn" />
          <swak:item id="yakkanbunsyono" />
          <swak:item id="fatcasnsikbn" />
          <swak:item id="bikkjnssinfokbn" />
          <swak:item id="fatcakakkekkakbn" />
          <swak:item id="aeoisnsikbn" />
          <swak:item id="aeoikekkakbn" />
          <swak:item id="kyknmkn" />
          <swak:item id="kyknmkj" />
          <swak:item id="kyknmkjkhukakbn" />
          <swak:item id="kykseiymd" />
          <swak:item id="kyksei" />
          <swak:item id="kyknen" />
          <swak:item id="kyktdk" />
        </swak:group>

        <%-- ●通信先情報 --%>
        <swak:group id="tuusinsakiInfo">
          <swak:item id="tsinyno" />
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
          <swak:item id="hhknnmkjkhukakbn" />
          <swak:item id="hhknseiymd" />
          <swak:item id="hhknsei" />
          <swak:item id="hhknnen" />
          <swak:item id="tsindousiteikbn" />
          <swak:item id="hhknyno" />
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
        <swak:group id="nkHokenkinUketorininInfo">
          <swak:item id="nenkinuktkbn" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="sbHokenkinUketorininInfo">
          <swak:item id="sbuktnin" />
        </swak:group>

        <%-- sbHokenkinUketorininInfo1 --%>
        <swak:group id="sbHokenkinUketorininInfo1">
          <swak:item id="dispsbuktkbn1" />
          <swak:item id="dispsbuktnmkn1" />
          <swak:item id="dispsbuktnmkj1" />
          <swak:item id="dispsbuktnmkjhukakbn1" />
          <swak:item id="dispsbuktseiymd1" />
          <swak:item id="dispsbukttdk1" />
          <swak:item id="dispsbuktbnwari1" />
        </swak:group>

        <%-- sbHokenkinUketorininInfo2 --%>
        <swak:group id="sbHokenkinUketorininInfo2">
          <swak:item id="dispsbuktkbn2" />
          <swak:item id="dispsbuktnmkn2" />
          <swak:item id="dispsbuktnmkj2" />
          <swak:item id="dispsbuktnmkjhukakbn2" />
          <swak:item id="dispsbuktseiymd2" />
          <swak:item id="dispsbukttdk2" />
          <swak:item id="dispsbuktbnwari2" />
        </swak:group>

        <%-- sbHokenkinUketorininInfo3 --%>
        <swak:group id="sbHokenkinUketorininInfo3">
          <swak:item id="dispsbuktkbn3" />
          <swak:item id="dispsbuktnmkn3" />
          <swak:item id="dispsbuktnmkj3" />
          <swak:item id="dispsbuktnmkjhukakbn3" />
          <swak:item id="dispsbuktseiymd3" />
          <swak:item id="dispsbukttdk3" />
          <swak:item id="dispsbuktbnwari3" />
        </swak:group>

        <%-- sbHokenkinUketorininInfo4 --%>
        <swak:group id="sbHokenkinUketorininInfo4">
          <swak:item id="dispsbuktkbn4" />
          <swak:item id="dispsbuktnmkn4" />
          <swak:item id="dispsbuktnmkj4" />
          <swak:item id="dispsbuktnmkjhukakbn4" />
          <swak:item id="dispsbuktseiymd4" />
          <swak:item id="dispsbukttdk4" />
          <swak:item id="dispsbuktbnwari4" />
        </swak:group>

        <%-- ●主契約保障情報 --%>
        <swak:group id="syuHosyouInfo">
          <swak:item id="syuhrkkkn" />
          <swak:item id="syuhrkkknsmnkbn" />
          <swak:item id="syuhknkkn" />
          <swak:item id="syuhknkknsmnkbn" />
          <swak:item id="nkshrstartnen" />
          <swak:item id="sueokikkn" />
          <swak:item id="syudai1hknkkn" />
          <swak:item id="sdpdkbn" />
          <swak:item id="haitoukbn" />
          <swak:item id="sknenkinsyu" />
          <swak:item id="zenkizennouumu" />
          <swak:item id="znnkai" />
          <swak:item id="hrkkaisuu" />
          <swak:item id="hrkkeiro" />
          <swak:item id="fstphrkkeirokbn" />
          <swak:item id="ikkatubaraikaisuu" />
          <swak:item id="kyktuukasyu" />
          <swak:item id="hrktuukasyu" />
          <swak:item id="syup" />
          <swak:item id="mossyup" />
          <swak:item id="hrktuukasyukykp" />
          <swak:item id="syukihons" />
          <swak:item id="syumoskihons" />
          <swak:item id="nyknkwsratekijyunymd" />
          <swak:item id="tyuuimongon1" />
          <swak:item id="nyknkwsrate" />
          <swak:item id="tyuuimongon2" />
          <swak:item id="sisuuhaibunwarikbn" />
          <swak:item id="sisuunm" />
          <swak:item id="teirituhaibunwarikbn" />
          <swak:item id="nkgnshosyouritukbn" />
          <swak:item id="pwaribikitekiyoukbn" />
          <swak:item id="inquiryyoteiriritu" />
          <swak:item id="tyuuimongon3" />
          <swak:item id="inquirytumitateriritu" />
          <swak:item id="inquiryloadinghnkgtmttrrt" />
          <swak:item id="tyuuimongon4" />
          <swak:item id="inquirytmttknzoukaritujygn" />
          <swak:item id="tyuuimongon5" />
          <swak:item id="inquirysetteibairitu" />
          <swak:item id="tyuuimongon6" />
          <swak:item id="inquiryrendouritu" />
          <swak:item id="tyuuimongon7" />
        </swak:group>

        <%-- syuHosyouInfo2 --%>
        <swak:group id="syuHosyouInfo2">
          <swak:item id="dispfstphrkgk" />
          <swak:item id="mosfstpkei" />
          <swak:item id="ikkatup" />
          <swak:item id="mosikkatup" />
          <swak:item id="zennoup" />
          <swak:item id="zennouphrkgk" />
          <swak:item id="moszennoupsyokaiari" />
          <swak:item id="pharaikomisougaku" />
        </swak:group>

        <%-- ●その他特約情報 --%>
        <swak:group id="sonotaTokuyakuInfo">
          <swak:item id="IAW0001" />
        </swak:group>

        <%-- sonotaTokuyakuInfo3 --%>
        <swak:group id="sonotaTokuyakuInfo3">
          <swak:item id="teikisiharaitkykhkkbn" />
          <swak:item id="teikisiharaikin" />
          <swak:item id="kzsyuruikbn" />
          <swak:item id="bankcd" />
          <swak:item id="banknmkj" />
          <swak:item id="sitencd" />
          <swak:item id="sitennmkj" />
          <swak:item id="yokinkbn" />
          <swak:item id="kouzano" />
          <swak:item id="kzkykdoukbn" />
          <swak:item id="kzmeiginmkn" />
        </swak:group>

        <%-- sonotaTokuyakuInfo4 --%>
        <swak:group id="sonotaTokuyakuInfo4">
          <swak:item id="syksbyensitihsyutkhkkbn" />
          <swak:item id="jyudkaigomehrtkhkkbn" />
          <swak:item id="nstkhkkbn" />
          <swak:item id="nstksbnkkn" />
          <swak:item id="targettkhkkbn" />
          <swak:item id="targettkmkhtkbn" />
          <swak:item id="mkhyouyensysnikougk" />
          <swak:item id="targettkykkijyungk" />
          <swak:item id="kjnnkpzeitekitkhukakbn" />
        </swak:group>

        <%-- sonotaTokuyakuInfo2 --%>
        <swak:group id="sonotaTokuyakuInfo2">
          <swak:item id="yennykntkhkkbn" />
          <swak:item id="gaikanykntkhkkbn" />
        </swak:group>

        <%-- ●ご家族登録サービス情報 --%>
        <swak:group id="kzkTourokuServiceInfo">
          <swak:item id="kzktourokuservicetourokukbn" />
        </swak:group>

        <%-- 登録家族１人目 --%>
        <swak:group id="kzkTourokuServiceInfo1">
          <swak:item id="trkkzknmkn1" />
          <swak:item id="trkkzknmkj1" />
          <swak:item id="trkkzknmkjkhukakbn1" />
          <swak:item id="trkkzkseiymd1" />
          <swak:item id="trkkzksei1" />
          <swak:item id="trkkzktdk1" />
          <swak:item id="IHF1026" />
          <swak:item id="trkkzktsindousiteikbn1" />
          <swak:item id="trkkzkyno1" />
          <swak:item id="trkkzkadr1kj1" />
          <swak:item id="trkkzkadr2kj1" />
          <swak:item id="trkkzkadr3kj1" />
          <swak:item id="trkkzktelno1" />
        </swak:group>

        <%-- 登録家族２人目 --%>
        <swak:group id="kzkTourokuServiceInfo2">
          <swak:item id="trkkzknmkn2" />
          <swak:item id="trkkzknmkj2" />
          <swak:item id="trkkzknmkjkhukakbn2" />
          <swak:item id="trkkzkseiymd2" />
          <swak:item id="trkkzksei2" />
          <swak:item id="trkkzktdk2" />
          <swak:item id="IHF1026" />
          <swak:item id="trkkzktsindousiteikbn2" />
          <swak:item id="trkkzkyno2" />
          <swak:item id="trkkzkadr1kj2" />
          <swak:item id="trkkzkadr2kj2" />
          <swak:item id="trkkzkadr3kj2" />
          <swak:item id="trkkzktelno2" />
        </swak:group>

        <%-- ●保険契約者代理特約情報 --%>
        <swak:group id="kykdrtkykInfo">
          <swak:item id="kykdrtkykhukakbn" />
          <swak:item id="kykdrkbn" />
        </swak:group>

        <%-- ●被保険者代理特約情報 --%>
        <swak:group id="stdrsktkuInfo">
          <swak:item id="stdrsktkyhkkbn" />
          <swak:item id="stdruktkbn" />
          <swak:item id="siteidruktnmkn" />
          <swak:item id="siteidruktnmkj" />
          <swak:item id="stdrsknmkjhukakbn" />
          <swak:item id="siteidrseiymd" />
          <swak:item id="siteidrukttdk" />
        </swak:group>

        <%-- ●口振口座情報 --%>
        <swak:group id="koufurikouzaInfo">
          <swak:item id="kzhuritourokuhoukbn" />
          <swak:item id="IHF1029" />
          <swak:item id="kouhurikouzainfobankcd" />
          <swak:item id="kouhurikouzainfobanknmkj" />
          <swak:item id="kouhurikouzainfositencd" />
          <swak:item id="kouhurikouzainfositennmkj" />
          <swak:item id="kouhurikouzainfoyokinkbn" />
          <swak:item id="kouhurikouzainfokouzano" />
          <swak:item id="kouhurikouzainfokzdoukbn" />
          <swak:item id="kouhurikouzainfokzmeiginmkn" />
          <swak:item id="kouzakakuniniraikbn" />
        </swak:group>

        <%-- ●クレジットカード情報 --%>
        <swak:group id="creditcardInfo">
          <swak:item id="authorikakymd" />
          <swak:item id="cardbrandkbn" />
          <swak:item id="credittrkjk" />
          <swak:item id="dispcreditkessaiyouno" />
          <swak:item id="credittrkhoukbn" />
        </swak:group>

        <%-- ●本人確認情報 --%>
        <swak:group id="honninkakuninInfo">
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
          <swak:item id="dispjimusyocd1" />
          <swak:item id="dispkinyuucd1" />
          <swak:item id="dispkinyuusitencd1" />
          <swak:item id="disptratkikouinncd1" />
          <swak:item id="dispinputbosyuucd1" />
          <swak:item id="dispbosyuutrkno1" />
          <swak:item id="disptratkiagcd1" />
          <swak:item id="disptratkiagnm1" />
          <swak:item id="dispoyadrtencd1" />
          <swak:item id="dispoyadrtennm1" />
          <swak:item id="dispbosyuucd1" />
          <swak:item id="dispbosyuunm1" />
          <swak:item id="dispgyskkjsakisosikicd1" />
          <swak:item id="dispgyskkjsakisosikinmkj1" />
          <swak:item id="dispbunwari1" />
          <swak:item id="cifcd" />
          <swak:item id="uktkid" />
        </swak:group>

        <%-- Ｂ代理店 --%>
        <swak:group id="dairitenInfoB">
          <swak:item id="dispjimusyocd2" />
          <swak:item id="dispkinyuucd2" />
          <swak:item id="dispkinyuusitencd2" />
          <swak:item id="disptratkikouinncd2" />
          <swak:item id="dispinputbosyuucd2" />
          <swak:item id="dispbosyuutrkno2" />
          <swak:item id="disptratkiagcd2" />
          <swak:item id="disptratkiagnm2" />
          <swak:item id="dispoyadrtencd2" />
          <swak:item id="dispoyadrtennm2" />
          <swak:item id="dispbosyuucd2" />
          <swak:item id="dispbosyuunm2" />
          <swak:item id="dispgyskkjsakisosikicd2" />
          <swak:item id="dispgyskkjsakisosikinmkj2" />
          <swak:item id="dispbunwari2" />
        </swak:group>

        <%-- ●構成員契約 --%>
        <swak:group id="kouseiinkykinfo">
          <swak:item id="kouseiinkykkbn" />
          <swak:item id="kouseiinkyktkjkumukbn" />
        </swak:group>

        <%-- ●交換契約 --%>
        <swak:group id="koukankykinfo">
          <swak:item id="koukankykkbn" />
          <swak:item id="koukankykkinmusakinm" />
          <swak:item id="koukankyksyokumunaiyou" />
          <swak:item id="koukankyktkjkumukbn" />
        </swak:group>

        <%-- ●特殊項目コード --%>
        <swak:group id="tokubetukoumokucd">
          <swak:item id="tsryhshrkykumukbn" />
          <swak:item id="syosisyatodokeumukbn" />
          <swak:item id="kakukisyouryakukbumukbn" />
          <swak:item id="seiymdmosseitouumukbn" />
        </swak:group>

        <%-- ●ダイレクトサービス --%>
        <swak:group id="drctserviceinfo">
          <swak:item id="drctservicemoskbn" />
          <swak:item id="dskokno" />
          <swak:item id="dsmailaddress" />
        </swak:group>

        <%-- ＜ＤＳ解約特定取引用口座＞ --%>
        <swak:group id="dskaiyakusoukinyoukouza">
          <swak:item id="dsbankcd" />
          <swak:item id="dsbanknmkj" />
          <swak:item id="dssitencd" />
          <swak:item id="dssitennmkj" />
          <swak:item id="dsyokinkbn" />
          <swak:item id="dskouzano" />
          <swak:item id="dskzmeiginmkn" />
        </swak:group>

        <%-- ●保険料通知情報 --%>
        <swak:group id="ptuutiinfo">
          <swak:item id="ynkhrkmgkannituutikbn" />
        </swak:group>

        <%-- ●その他 --%>
        <swak:group id="sonotainfo">
          <swak:item id="tkhjnkbn" />
          <swak:item id="tkhsyouryakuumukbn" />
        </swak:group>

        <%-- ●不備状況 --%>
        <swak:group id="hubiJyoukyou">
          <swak:item id="kthhbkbn" />
          <swak:item id="srhhbkbn" />
          <swak:item id="khnhbkbn" />
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

        <%-- ●連絡情報 --%>
        <swak:group id="renrakuInfo">
          <swak:item id="skeittdkkinkyuyouhikbn" />
          <swak:item id="IHF0053" />
          <swak:item id="skeittdktyuuiyouhikbn" />
          <swak:item id="IHF0053" />
        </swak:group>

        <%-- ●新契約取扱注意情報 --%>
        <swak:dataTable id="skToriatukaiTyuuiInfo">
          <swak:column id="dispskeittdktyuitrttrkymd" />
          <swak:column id="dispskeittdktyuitrtnaiyo" />
          <swak:column id="dispskeittdktyuitrttantou" />
        </swak:dataTable>

        <%-- ●その他注意情報 --%>
        <swak:dataTable id="sonotaTyuuiInfo">
          <swak:column id="dispskeittdktyuisttrkymd" />
          <swak:column id="dispskeittdktyuistnaiyo" />
          <swak:column id="dispskeittdktyuisttantou" />
        </swak:dataTable>

        <%-- ●不備一覧 --%>
        <swak:dataTable id="hubiItiran">
          <swak:column id="disptrkymd" />
          <swak:column id="dispskhubikoumoku" />
          <swak:column id="disphassinymd" />
          <swak:column id="dispkaisyouymd" />
          <swak:column id="disphasinkyokakbn" />
          <swak:column id="disphassinsakikbn" />
          <swak:column id="dispnyuryokutantounm" />
          <swak:column id="dispskhubinaiyou" />
          <swak:column id="dispskseibisijinaiyou" />
          <swak:column id="tyoubundisprenrakujikou" />
          <swak:column id="disprenrakujikou" />
        </swak:dataTable>

        <%-- ●不備通知先 --%>
        <swak:group id="hubitutisaki">
          <swak:item id="utdskknnm1kj" />
          <swak:item id="utdskknnm2kj" />
          <swak:item id="tuutisakitantounmkj" />
        </swak:group>

        <%-- ●コメント --%>
        <swak:group id="comment">
          <swak:item id="commentareagamen" />
        </swak:group>

        <%-- ●告知情報 --%>
        <swak:group id="kokutiInfo">
          <swak:item id="kktkktymd" />
          <swak:item id="sintyou" />
          <swak:item id="taijyuu" />
          <swak:item id="kituenkbn" />
          <swak:item id="kituenhon" />
          <swak:item id="kijikbn" />
          <swak:item id="kzkkijikbn" />
        </swak:group>

        <%-- ●申込書入力情報 --%>
        <swak:group id="mousikomisyoinputInfo">
          <swak:item id="khnchkcmnt" />
        </swak:group>

        <%-- ●申込点検履歴 --%>
        <swak:group id="moushikomitenkenRireki">
          <swak:item id="mostenkensjnaiyou" />
        </swak:group>

        <%-- moushikomitenkenRireki1 --%>
        <swak:group id="moushikomitenkenRireki1">
          <swak:item id="dispmostenkensyoriymd1" />
          <swak:item id="dispmostnknstktsyorinmkbn1" />
          <swak:item id="dispmostenkenkekkakbn1" />
          <swak:item id="dispmostns1" />
          <swak:item id="dispmostenkenktnm1" />
          <swak:item id="dispmostenkencomment1" />
        </swak:group>

        <%-- moushikomitenkenRireki2 --%>
        <swak:group id="moushikomitenkenRireki2">
          <swak:item id="dispmostenkensyoriymd2" />
          <swak:item id="dispmostnknstktsyorinmkbn2" />
          <swak:item id="dispmostenkenkekkakbn2" />
          <swak:item id="dispmostns2" />
          <swak:item id="dispmostenkenktnm2" />
          <swak:item id="dispmostenkencomment2" />
        </swak:group>

        <%-- moushikomitenkenRireki3 --%>
        <swak:group id="moushikomitenkenRireki3">
          <swak:item id="dispmostenkensyoriymd3" />
          <swak:item id="dispmostnknstktsyorinmkbn3" />
          <swak:item id="dispmostenkenkekkakbn3" />
          <swak:item id="dispmostns3" />
          <swak:item id="dispmostenkenktnm3" />
          <swak:item id="dispmostenkencomment3" />
        </swak:group>

        <%-- moushikomitenkenRireki4 --%>
        <swak:group id="moushikomitenkenRireki4">
          <swak:item id="dispmostenkensyoriymd4" />
          <swak:item id="dispmostnknstktsyorinmkbn4" />
          <swak:item id="dispmostenkenkekkakbn4" />
          <swak:item id="dispmostns4" />
          <swak:item id="dispmostenkenktnm4" />
          <swak:item id="dispmostenkencomment4" />
        </swak:group>

        <%-- moushikomitenkenRireki5 --%>
        <swak:group id="moushikomitenkenRireki5">
          <swak:item id="dispmostenkensyoriymd5" />
          <swak:item id="dispmostnknstktsyorinmkbn5" />
          <swak:item id="dispmostenkenkekkakbn5" />
          <swak:item id="dispmostns5" />
          <swak:item id="dispmostenkenktnm5" />
          <swak:item id="dispmostenkencomment5" />
        </swak:group>

        <%-- moushikomitenkenRireki6 --%>
        <swak:group id="moushikomitenkenRireki6">
          <swak:item id="dispmostenkensyoriymd6" />
          <swak:item id="dispmostnknstktsyorinmkbn6" />
          <swak:item id="dispmostenkenkekkakbn6" />
          <swak:item id="dispmostns6" />
          <swak:item id="dispmostenkenktnm6" />
          <swak:item id="dispmostenkencomment6" />
        </swak:group>

        <%-- moushikomitenkenRireki7 --%>
        <swak:group id="moushikomitenkenRireki7">
          <swak:item id="dispmostenkensyoriymd7" />
          <swak:item id="dispmostnknstktsyorinmkbn7" />
          <swak:item id="dispmostenkenkekkakbn7" />
          <swak:item id="dispmostns7" />
          <swak:item id="dispmostenkenktnm7" />
          <swak:item id="dispmostenkencomment7" />
        </swak:group>

        <%-- moushikomitenkenRireki8 --%>
        <swak:group id="moushikomitenkenRireki8">
          <swak:item id="dispmostenkensyoriymd8" />
          <swak:item id="dispmostnknstktsyorinmkbn8" />
          <swak:item id="dispmostenkenkekkakbn8" />
          <swak:item id="dispmostns8" />
          <swak:item id="dispmostenkenktnm8" />
          <swak:item id="dispmostenkencomment8" />
        </swak:group>

        <%-- moushikomitenkenRireki9 --%>
        <swak:group id="moushikomitenkenRireki9">
          <swak:item id="dispmostenkensyoriymd9" />
          <swak:item id="dispmostnknstktsyorinmkbn9" />
          <swak:item id="dispmostenkenkekkakbn9" />
          <swak:item id="dispmostns9" />
          <swak:item id="dispmostenkenktnm9" />
          <swak:item id="dispmostenkencomment9" />
        </swak:group>

        <%-- moushikomitenkenRireki10 --%>
        <swak:group id="moushikomitenkenRireki10">
          <swak:item id="dispmostenkensyoriymd10" />
          <swak:item id="dispmostnknstktsyorinmkbn10" />
          <swak:item id="dispmostenkenkekkakbn10" />
          <swak:item id="dispmostns10" />
          <swak:item id="dispmostenkenktnm10" />
          <swak:item id="dispmostenkencomment10" />
        </swak:group>

        <%-- moushikomitenkenRireki11 --%>
        <swak:group id="moushikomitenkenRireki11">
          <swak:item id="dispmostenkensyoriymd11" />
          <swak:item id="dispmostnknstktsyorinmkbn11" />
          <swak:item id="dispmostenkenkekkakbn11" />
          <swak:item id="dispmostns11" />
          <swak:item id="dispmostenkenktnm11" />
          <swak:item id="dispmostenkencomment11" />
        </swak:group>

        <%-- moushikomitenkenRireki12 --%>
        <swak:group id="moushikomitenkenRireki12">
          <swak:item id="dispmostenkensyoriymd12" />
          <swak:item id="dispmostnknstktsyorinmkbn12" />
          <swak:item id="dispmostenkenkekkakbn12" />
          <swak:item id="dispmostns12" />
          <swak:item id="dispmostenkenktnm12" />
          <swak:item id="dispmostenkencomment12" />
        </swak:group>

        <%-- moushikomitenkenRireki13 --%>
        <swak:group id="moushikomitenkenRireki13">
          <swak:item id="dispmostenkensyoriymd13" />
          <swak:item id="dispmostnknstktsyorinmkbn13" />
          <swak:item id="dispmostenkenkekkakbn13" />
          <swak:item id="dispmostns13" />
          <swak:item id="dispmostenkenktnm13" />
          <swak:item id="dispmostenkencomment13" />
        </swak:group>

        <%-- moushikomitenkenRireki14 --%>
        <swak:group id="moushikomitenkenRireki14">
          <swak:item id="dispmostenkensyoriymd14" />
          <swak:item id="dispmostnknstktsyorinmkbn14" />
          <swak:item id="dispmostenkenkekkakbn14" />
          <swak:item id="dispmostns14" />
          <swak:item id="dispmostenkenktnm14" />
          <swak:item id="dispmostenkencomment14" />
        </swak:group>

        <%-- moushikomitenkenRireki15 --%>
        <swak:group id="moushikomitenkenRireki15">
          <swak:item id="dispmostenkensyoriymd15" />
          <swak:item id="dispmostnknstktsyorinmkbn15" />
          <swak:item id="dispmostenkenkekkakbn15" />
          <swak:item id="dispmostns15" />
          <swak:item id="dispmostenkenktnm15" />
          <swak:item id="dispmostenkencomment15" />
        </swak:group>

        <%-- ●環境査定履歴 --%>
        <swak:group id="kankyouSateiRireki">
          <swak:item id="knksateisjnaiyou" />
        </swak:group>

        <%-- kankyouSateiRireki1 --%>
        <swak:group id="kankyouSateiRireki1">
          <swak:item id="dispknksyoriymd1" />
          <swak:item id="dispknkstktsyorinmkbn1" />
          <swak:item id="dispknkkekkakbn1" />
          <swak:item id="dispknktns1" />
          <swak:item id="dispknkktnm1" />
          <swak:item id="dispknkcomment1" />
          <swak:item id="dispknkktkkcd1" />
          <swak:item id="dispknktrkssyousairiyuu1" />
          <swak:item id="dispknkketriyuucd11" />
          <swak:item id="dispknkketriyuunaiyou11" />
          <swak:item id="dispknkketriyuucd21" />
          <swak:item id="dispknkketriyuunaiyou21" />
          <swak:item id="dispknkketriyuucd31" />
          <swak:item id="dispknkketriyuunaiyou31" />
          <swak:item id="dispknkketriyuucd41" />
          <swak:item id="dispknkketriyuunaiyou41" />
          <swak:item id="dispknkmrriyuucdnaiyou1" />
        </swak:group>

        <%-- kankyouSateiRireki2 --%>
        <swak:group id="kankyouSateiRireki2">
          <swak:item id="dispknksyoriymd2" />
          <swak:item id="dispknkstktsyorinmkbn2" />
          <swak:item id="dispknkkekkakbn2" />
          <swak:item id="dispknktns2" />
          <swak:item id="dispknkktnm2" />
          <swak:item id="dispknkcomment2" />
          <swak:item id="dispknkktkkcd2" />
          <swak:item id="dispknktrkssyousairiyuu2" />
          <swak:item id="dispknkketriyuucd12" />
          <swak:item id="dispknkketriyuunaiyou12" />
          <swak:item id="dispknkketriyuucd22" />
          <swak:item id="dispknkketriyuunaiyou22" />
          <swak:item id="dispknkketriyuucd32" />
          <swak:item id="dispknkketriyuunaiyou32" />
          <swak:item id="dispknkketriyuucd42" />
          <swak:item id="dispknkketriyuunaiyou42" />
          <swak:item id="dispknkmrriyuucdnaiyou2" />
        </swak:group>

        <%-- kankyouSateiRireki3 --%>
        <swak:group id="kankyouSateiRireki3">
          <swak:item id="dispknksyoriymd3" />
          <swak:item id="dispknkstktsyorinmkbn3" />
          <swak:item id="dispknkkekkakbn3" />
          <swak:item id="dispknktns3" />
          <swak:item id="dispknkktnm3" />
          <swak:item id="dispknkcomment3" />
          <swak:item id="dispknkktkkcd3" />
          <swak:item id="dispknktrkssyousairiyuu3" />
          <swak:item id="dispknkketriyuucd13" />
          <swak:item id="dispknkketriyuunaiyou13" />
          <swak:item id="dispknkketriyuucd23" />
          <swak:item id="dispknkketriyuunaiyou23" />
          <swak:item id="dispknkketriyuucd33" />
          <swak:item id="dispknkketriyuunaiyou33" />
          <swak:item id="dispknkketriyuucd43" />
          <swak:item id="dispknkketriyuunaiyou43" />
          <swak:item id="dispknkmrriyuucdnaiyou3" />
        </swak:group>

        <%-- kankyouSateiRireki4 --%>
        <swak:group id="kankyouSateiRireki4">
          <swak:item id="dispknksyoriymd4" />
          <swak:item id="dispknkstktsyorinmkbn4" />
          <swak:item id="dispknkkekkakbn4" />
          <swak:item id="dispknktns4" />
          <swak:item id="dispknkktnm4" />
          <swak:item id="dispknkcomment4" />
          <swak:item id="dispknkktkkcd4" />
          <swak:item id="dispknktrkssyousairiyuu4" />
          <swak:item id="dispknkketriyuucd14" />
          <swak:item id="dispknkketriyuunaiyou14" />
          <swak:item id="dispknkketriyuucd24" />
          <swak:item id="dispknkketriyuunaiyou24" />
          <swak:item id="dispknkketriyuucd34" />
          <swak:item id="dispknkketriyuunaiyou34" />
          <swak:item id="dispknkketriyuucd44" />
          <swak:item id="dispknkketriyuunaiyou44" />
          <swak:item id="dispknkmrriyuucdnaiyou4" />
        </swak:group>

        <%-- kankyouSateiRireki5 --%>
        <swak:group id="kankyouSateiRireki5">
          <swak:item id="dispknksyoriymd5" />
          <swak:item id="dispknkstktsyorinmkbn5" />
          <swak:item id="dispknkkekkakbn5" />
          <swak:item id="dispknktns5" />
          <swak:item id="dispknkktnm5" />
          <swak:item id="dispknkcomment5" />
          <swak:item id="dispknkktkkcd5" />
          <swak:item id="dispknktrkssyousairiyuu5" />
          <swak:item id="dispknkketriyuucd15" />
          <swak:item id="dispknkketriyuunaiyou15" />
          <swak:item id="dispknkketriyuucd25" />
          <swak:item id="dispknkketriyuunaiyou25" />
          <swak:item id="dispknkketriyuucd35" />
          <swak:item id="dispknkketriyuunaiyou35" />
          <swak:item id="dispknkketriyuucd45" />
          <swak:item id="dispknkketriyuunaiyou45" />
          <swak:item id="dispknkmrriyuucdnaiyou5" />
        </swak:group>

        <%-- kankyouSateiRireki6 --%>
        <swak:group id="kankyouSateiRireki6">
          <swak:item id="dispknksyoriymd6" />
          <swak:item id="dispknkstktsyorinmkbn6" />
          <swak:item id="dispknkkekkakbn6" />
          <swak:item id="dispknktns6" />
          <swak:item id="dispknkktnm6" />
          <swak:item id="dispknkcomment6" />
          <swak:item id="dispknkktkkcd6" />
          <swak:item id="dispknktrkssyousairiyuu6" />
          <swak:item id="dispknkketriyuucd16" />
          <swak:item id="dispknkketriyuunaiyou16" />
          <swak:item id="dispknkketriyuucd26" />
          <swak:item id="dispknkketriyuunaiyou26" />
          <swak:item id="dispknkketriyuucd36" />
          <swak:item id="dispknkketriyuunaiyou36" />
          <swak:item id="dispknkketriyuucd46" />
          <swak:item id="dispknkketriyuunaiyou46" />
          <swak:item id="dispknkmrriyuucdnaiyou6" />
        </swak:group>

        <%-- kankyouSateiRireki7 --%>
        <swak:group id="kankyouSateiRireki7">
          <swak:item id="dispknksyoriymd7" />
          <swak:item id="dispknkstktsyorinmkbn7" />
          <swak:item id="dispknkkekkakbn7" />
          <swak:item id="dispknktns7" />
          <swak:item id="dispknkktnm7" />
          <swak:item id="dispknkcomment7" />
          <swak:item id="dispknkktkkcd7" />
          <swak:item id="dispknktrkssyousairiyuu7" />
          <swak:item id="dispknkketriyuucd17" />
          <swak:item id="dispknkketriyuunaiyou17" />
          <swak:item id="dispknkketriyuucd27" />
          <swak:item id="dispknkketriyuunaiyou27" />
          <swak:item id="dispknkketriyuucd37" />
          <swak:item id="dispknkketriyuunaiyou37" />
          <swak:item id="dispknkketriyuucd47" />
          <swak:item id="dispknkketriyuunaiyou47" />
          <swak:item id="dispknkmrriyuucdnaiyou7" />
        </swak:group>

        <%-- kankyouSateiRireki8 --%>
        <swak:group id="kankyouSateiRireki8">
          <swak:item id="dispknksyoriymd8" />
          <swak:item id="dispknkstktsyorinmkbn8" />
          <swak:item id="dispknkkekkakbn8" />
          <swak:item id="dispknktns8" />
          <swak:item id="dispknkktnm8" />
          <swak:item id="dispknkcomment8" />
          <swak:item id="dispknkktkkcd8" />
          <swak:item id="dispknktrkssyousairiyuu8" />
          <swak:item id="dispknkketriyuucd18" />
          <swak:item id="dispknkketriyuunaiyou18" />
          <swak:item id="dispknkketriyuucd28" />
          <swak:item id="dispknkketriyuunaiyou28" />
          <swak:item id="dispknkketriyuucd38" />
          <swak:item id="dispknkketriyuunaiyou38" />
          <swak:item id="dispknkketriyuucd48" />
          <swak:item id="dispknkketriyuunaiyou48" />
          <swak:item id="dispknkmrriyuucdnaiyou8" />
        </swak:group>

        <%-- kankyouSateiRireki9 --%>
        <swak:group id="kankyouSateiRireki9">
          <swak:item id="dispknksyoriymd9" />
          <swak:item id="dispknkstktsyorinmkbn9" />
          <swak:item id="dispknkkekkakbn9" />
          <swak:item id="dispknktns9" />
          <swak:item id="dispknkktnm9" />
          <swak:item id="dispknkcomment9" />
          <swak:item id="dispknkktkkcd9" />
          <swak:item id="dispknktrkssyousairiyuu9" />
          <swak:item id="dispknkketriyuucd19" />
          <swak:item id="dispknkketriyuunaiyou19" />
          <swak:item id="dispknkketriyuucd29" />
          <swak:item id="dispknkketriyuunaiyou29" />
          <swak:item id="dispknkketriyuucd39" />
          <swak:item id="dispknkketriyuunaiyou39" />
          <swak:item id="dispknkketriyuucd49" />
          <swak:item id="dispknkketriyuunaiyou49" />
          <swak:item id="dispknkmrriyuucdnaiyou9" />
        </swak:group>

        <%-- kankyouSateiRireki10 --%>
        <swak:group id="kankyouSateiRireki10">
          <swak:item id="dispknksyoriymd10" />
          <swak:item id="dispknkstktsyorinmkbn10" />
          <swak:item id="dispknkkekkakbn10" />
          <swak:item id="dispknktns10" />
          <swak:item id="dispknkktnm10" />
          <swak:item id="dispknkcomment10" />
          <swak:item id="dispknkktkkcd10" />
          <swak:item id="dispknktrkssyousairiyuu10" />
          <swak:item id="dispknkketriyuucd110" />
          <swak:item id="dispknkketriyuunaiyou110" />
          <swak:item id="dispknkketriyuucd210" />
          <swak:item id="dispknkketriyuunaiyou210" />
          <swak:item id="dispknkketriyuucd310" />
          <swak:item id="dispknkketriyuunaiyou310" />
          <swak:item id="dispknkketriyuucd410" />
          <swak:item id="dispknkketriyuunaiyou410" />
          <swak:item id="dispknkmrriyuucdnaiyou10" />
        </swak:group>

        <%-- kankyouSateiRireki11 --%>
        <swak:group id="kankyouSateiRireki11">
          <swak:item id="dispknksyoriymd11" />
          <swak:item id="dispknkstktsyorinmkbn11" />
          <swak:item id="dispknkkekkakbn11" />
          <swak:item id="dispknktns11" />
          <swak:item id="dispknkktnm11" />
          <swak:item id="dispknkcomment11" />
          <swak:item id="dispknkktkkcd11" />
          <swak:item id="dispknktrkssyousairiyuu11" />
          <swak:item id="dispknkketriyuucd111" />
          <swak:item id="dispknkketriyuunaiyou111" />
          <swak:item id="dispknkketriyuucd211" />
          <swak:item id="dispknkketriyuunaiyou211" />
          <swak:item id="dispknkketriyuucd311" />
          <swak:item id="dispknkketriyuunaiyou311" />
          <swak:item id="dispknkketriyuucd411" />
          <swak:item id="dispknkketriyuunaiyou411" />
          <swak:item id="dispknkmrriyuucdnaiyou11" />
        </swak:group>

        <%-- kankyouSateiRireki12 --%>
        <swak:group id="kankyouSateiRireki12">
          <swak:item id="dispknksyoriymd12" />
          <swak:item id="dispknkstktsyorinmkbn12" />
          <swak:item id="dispknkkekkakbn12" />
          <swak:item id="dispknktns12" />
          <swak:item id="dispknkktnm12" />
          <swak:item id="dispknkcomment12" />
          <swak:item id="dispknkktkkcd12" />
          <swak:item id="dispknktrkssyousairiyuu12" />
          <swak:item id="dispknkketriyuucd112" />
          <swak:item id="dispknkketriyuunaiyou112" />
          <swak:item id="dispknkketriyuucd212" />
          <swak:item id="dispknkketriyuunaiyou212" />
          <swak:item id="dispknkketriyuucd312" />
          <swak:item id="dispknkketriyuunaiyou312" />
          <swak:item id="dispknkketriyuucd412" />
          <swak:item id="dispknkketriyuunaiyou412" />
          <swak:item id="dispknkmrriyuucdnaiyou12" />
        </swak:group>

        <%-- kankyouSateiRireki13 --%>
        <swak:group id="kankyouSateiRireki13">
          <swak:item id="dispknksyoriymd13" />
          <swak:item id="dispknkstktsyorinmkbn13" />
          <swak:item id="dispknkkekkakbn13" />
          <swak:item id="dispknktns13" />
          <swak:item id="dispknkktnm13" />
          <swak:item id="dispknkcomment13" />
          <swak:item id="dispknkktkkcd13" />
          <swak:item id="dispknktrkssyousairiyuu13" />
          <swak:item id="dispknkketriyuucd113" />
          <swak:item id="dispknkketriyuunaiyou113" />
          <swak:item id="dispknkketriyuucd213" />
          <swak:item id="dispknkketriyuunaiyou213" />
          <swak:item id="dispknkketriyuucd313" />
          <swak:item id="dispknkketriyuunaiyou313" />
          <swak:item id="dispknkketriyuucd413" />
          <swak:item id="dispknkketriyuunaiyou413" />
          <swak:item id="dispknkmrriyuucdnaiyou13" />
        </swak:group>

        <%-- kankyouSateiRireki14 --%>
        <swak:group id="kankyouSateiRireki14">
          <swak:item id="dispknksyoriymd14" />
          <swak:item id="dispknkstktsyorinmkbn14" />
          <swak:item id="dispknkkekkakbn14" />
          <swak:item id="dispknktns14" />
          <swak:item id="dispknkktnm14" />
          <swak:item id="dispknkcomment14" />
          <swak:item id="dispknkktkkcd14" />
          <swak:item id="dispknktrkssyousairiyuu14" />
          <swak:item id="dispknkketriyuucd114" />
          <swak:item id="dispknkketriyuunaiyou114" />
          <swak:item id="dispknkketriyuucd214" />
          <swak:item id="dispknkketriyuunaiyou214" />
          <swak:item id="dispknkketriyuucd314" />
          <swak:item id="dispknkketriyuunaiyou314" />
          <swak:item id="dispknkketriyuucd414" />
          <swak:item id="dispknkketriyuunaiyou414" />
          <swak:item id="dispknkmrriyuucdnaiyou14" />
        </swak:group>

        <%-- kankyouSateiRireki15 --%>
        <swak:group id="kankyouSateiRireki15">
          <swak:item id="dispknksyoriymd15" />
          <swak:item id="dispknkstktsyorinmkbn15" />
          <swak:item id="dispknkkekkakbn15" />
          <swak:item id="dispknktns15" />
          <swak:item id="dispknkktnm15" />
          <swak:item id="dispknkcomment15" />
          <swak:item id="dispknkktkkcd15" />
          <swak:item id="dispknktrkssyousairiyuu15" />
          <swak:item id="dispknkketriyuucd115" />
          <swak:item id="dispknkketriyuunaiyou115" />
          <swak:item id="dispknkketriyuucd215" />
          <swak:item id="dispknkketriyuunaiyou215" />
          <swak:item id="dispknkketriyuucd315" />
          <swak:item id="dispknkketriyuunaiyou315" />
          <swak:item id="dispknkketriyuucd415" />
          <swak:item id="dispknkketriyuunaiyou415" />
          <swak:item id="dispknkmrriyuucdnaiyou15" />
        </swak:group>

        <%-- ●医務査定履歴 --%>
        <swak:group id="imuSateiRireki">
          <swak:item id="imusateisijinaiyou" />
        </swak:group>

        <%-- imuSateiRireki1 --%>
        <swak:group id="imuSateiRireki1">
          <swak:item id="dispimusyoriymd1" />
          <swak:item id="dispimustktsyorinmkbn1" />
          <swak:item id="dispimukekkakbn1" />
          <swak:item id="dispimutns1" />
          <swak:item id="dispimuktnm1" />
          <swak:item id="dispimucomment1" />
          <swak:item id="dispimuketkekkacd1" />
          <swak:item id="dispimusntksakuseiyh1" />
          <swak:item id="dispimuketriyuucd11" />
          <swak:item id="dispimuketriyuunaiyou11" />
          <swak:item id="dispimusyoubyoucd11" />
          <swak:item id="dispimusyoubyounm11" />
          <swak:item id="dispimuketriyuucd21" />
          <swak:item id="dispimuketriyuunaiyou21" />
          <swak:item id="dispimusyoubyoujyoutai11" />
          <swak:item id="dispimukantiym11" />
          <swak:item id="dispimuketriyuucd31" />
          <swak:item id="dispimuketriyuunaiyou31" />
          <swak:item id="dispimusyoubyoucd21" />
          <swak:item id="dispimusyoubyounm21" />
          <swak:item id="dispimuketriyuucd41" />
          <swak:item id="dispimuketriyuunaiyou41" />
          <swak:item id="dispimusyoubyoujyoutai21" />
          <swak:item id="dispimukantiym21" />
        </swak:group>

        <%-- imuSateiRireki2 --%>
        <swak:group id="imuSateiRireki2">
          <swak:item id="dispimusyoriymd2" />
          <swak:item id="dispimustktsyorinmkbn2" />
          <swak:item id="dispimukekkakbn2" />
          <swak:item id="dispimutns2" />
          <swak:item id="dispimuktnm2" />
          <swak:item id="dispimucomment2" />
          <swak:item id="dispimuketkekkacd2" />
          <swak:item id="dispimusntksakuseiyh2" />
          <swak:item id="dispimuketriyuucd12" />
          <swak:item id="dispimuketriyuunaiyou12" />
          <swak:item id="dispimusyoubyoucd12" />
          <swak:item id="dispimusyoubyounm12" />
          <swak:item id="dispimuketriyuucd22" />
          <swak:item id="dispimuketriyuunaiyou22" />
          <swak:item id="dispimusyoubyoujyoutai12" />
          <swak:item id="dispimukantiym12" />
          <swak:item id="dispimuketriyuucd32" />
          <swak:item id="dispimuketriyuunaiyou32" />
          <swak:item id="dispimusyoubyoucd22" />
          <swak:item id="dispimusyoubyounm22" />
          <swak:item id="dispimuketriyuucd42" />
          <swak:item id="dispimuketriyuunaiyou42" />
          <swak:item id="dispimusyoubyoujyoutai22" />
          <swak:item id="dispimukantiym22" />
        </swak:group>

        <%-- imuSateiRireki3 --%>
        <swak:group id="imuSateiRireki3">
          <swak:item id="dispimusyoriymd3" />
          <swak:item id="dispimustktsyorinmkbn3" />
          <swak:item id="dispimukekkakbn3" />
          <swak:item id="dispimutns3" />
          <swak:item id="dispimuktnm3" />
          <swak:item id="dispimucomment3" />
          <swak:item id="dispimuketkekkacd3" />
          <swak:item id="dispimusntksakuseiyh3" />
          <swak:item id="dispimuketriyuucd13" />
          <swak:item id="dispimuketriyuunaiyou13" />
          <swak:item id="dispimusyoubyoucd13" />
          <swak:item id="dispimusyoubyounm13" />
          <swak:item id="dispimuketriyuucd23" />
          <swak:item id="dispimuketriyuunaiyou23" />
          <swak:item id="dispimusyoubyoujyoutai13" />
          <swak:item id="dispimukantiym13" />
          <swak:item id="dispimuketriyuucd33" />
          <swak:item id="dispimuketriyuunaiyou33" />
          <swak:item id="dispimusyoubyoucd23" />
          <swak:item id="dispimusyoubyounm23" />
          <swak:item id="dispimuketriyuucd43" />
          <swak:item id="dispimuketriyuunaiyou43" />
          <swak:item id="dispimusyoubyoujyoutai23" />
          <swak:item id="dispimukantiym23" />
        </swak:group>

        <%-- imuSateiRireki4 --%>
        <swak:group id="imuSateiRireki4">
          <swak:item id="dispimusyoriymd4" />
          <swak:item id="dispimustktsyorinmkbn4" />
          <swak:item id="dispimukekkakbn4" />
          <swak:item id="dispimutns4" />
          <swak:item id="dispimuktnm4" />
          <swak:item id="dispimucomment4" />
          <swak:item id="dispimuketkekkacd4" />
          <swak:item id="dispimusntksakuseiyh4" />
          <swak:item id="dispimuketriyuucd14" />
          <swak:item id="dispimuketriyuunaiyou14" />
          <swak:item id="dispimusyoubyoucd14" />
          <swak:item id="dispimusyoubyounm14" />
          <swak:item id="dispimuketriyuucd24" />
          <swak:item id="dispimuketriyuunaiyou24" />
          <swak:item id="dispimusyoubyoujyoutai14" />
          <swak:item id="dispimukantiym14" />
          <swak:item id="dispimuketriyuucd34" />
          <swak:item id="dispimuketriyuunaiyou34" />
          <swak:item id="dispimusyoubyoucd24" />
          <swak:item id="dispimusyoubyounm24" />
          <swak:item id="dispimuketriyuucd44" />
          <swak:item id="dispimuketriyuunaiyou44" />
          <swak:item id="dispimusyoubyoujyoutai24" />
          <swak:item id="dispimukantiym24" />
        </swak:group>

        <%-- imuSateiRireki5 --%>
        <swak:group id="imuSateiRireki5">
          <swak:item id="dispimusyoriymd5" />
          <swak:item id="dispimustktsyorinmkbn5" />
          <swak:item id="dispimukekkakbn5" />
          <swak:item id="dispimutns5" />
          <swak:item id="dispimuktnm5" />
          <swak:item id="dispimucomment5" />
          <swak:item id="dispimuketkekkacd5" />
          <swak:item id="dispimusntksakuseiyh5" />
          <swak:item id="dispimuketriyuucd15" />
          <swak:item id="dispimuketriyuunaiyou15" />
          <swak:item id="dispimusyoubyoucd15" />
          <swak:item id="dispimusyoubyounm15" />
          <swak:item id="dispimuketriyuucd25" />
          <swak:item id="dispimuketriyuunaiyou25" />
          <swak:item id="dispimusyoubyoujyoutai15" />
          <swak:item id="dispimukantiym15" />
          <swak:item id="dispimuketriyuucd35" />
          <swak:item id="dispimuketriyuunaiyou35" />
          <swak:item id="dispimusyoubyoucd25" />
          <swak:item id="dispimusyoubyounm25" />
          <swak:item id="dispimuketriyuucd45" />
          <swak:item id="dispimuketriyuunaiyou45" />
          <swak:item id="dispimusyoubyoujyoutai25" />
          <swak:item id="dispimukantiym25" />
        </swak:group>

        <%-- imuSateiRireki6 --%>
        <swak:group id="imuSateiRireki6">
          <swak:item id="dispimusyoriymd6" />
          <swak:item id="dispimustktsyorinmkbn6" />
          <swak:item id="dispimukekkakbn6" />
          <swak:item id="dispimutns6" />
          <swak:item id="dispimuktnm6" />
          <swak:item id="dispimucomment6" />
          <swak:item id="dispimuketkekkacd6" />
          <swak:item id="dispimusntksakuseiyh6" />
          <swak:item id="dispimuketriyuucd16" />
          <swak:item id="dispimuketriyuunaiyou16" />
          <swak:item id="dispimusyoubyoucd16" />
          <swak:item id="dispimusyoubyounm16" />
          <swak:item id="dispimuketriyuucd26" />
          <swak:item id="dispimuketriyuunaiyou26" />
          <swak:item id="dispimusyoubyoujyoutai16" />
          <swak:item id="dispimukantiym16" />
          <swak:item id="dispimuketriyuucd36" />
          <swak:item id="dispimuketriyuunaiyou36" />
          <swak:item id="dispimusyoubyoucd26" />
          <swak:item id="dispimusyoubyounm26" />
          <swak:item id="dispimuketriyuucd46" />
          <swak:item id="dispimuketriyuunaiyou46" />
          <swak:item id="dispimusyoubyoujyoutai26" />
          <swak:item id="dispimukantiym26" />
        </swak:group>

        <%-- imuSateiRireki7 --%>
        <swak:group id="imuSateiRireki7">
          <swak:item id="dispimusyoriymd7" />
          <swak:item id="dispimustktsyorinmkbn7" />
          <swak:item id="dispimukekkakbn7" />
          <swak:item id="dispimutns7" />
          <swak:item id="dispimuktnm7" />
          <swak:item id="dispimucomment7" />
          <swak:item id="dispimuketkekkacd7" />
          <swak:item id="dispimusntksakuseiyh7" />
          <swak:item id="dispimuketriyuucd17" />
          <swak:item id="dispimuketriyuunaiyou17" />
          <swak:item id="dispimusyoubyoucd17" />
          <swak:item id="dispimusyoubyounm17" />
          <swak:item id="dispimuketriyuucd27" />
          <swak:item id="dispimuketriyuunaiyou27" />
          <swak:item id="dispimusyoubyoujyoutai17" />
          <swak:item id="dispimukantiym17" />
          <swak:item id="dispimuketriyuucd37" />
          <swak:item id="dispimuketriyuunaiyou37" />
          <swak:item id="dispimusyoubyoucd27" />
          <swak:item id="dispimusyoubyounm27" />
          <swak:item id="dispimuketriyuucd47" />
          <swak:item id="dispimuketriyuunaiyou47" />
          <swak:item id="dispimusyoubyoujyoutai27" />
          <swak:item id="dispimukantiym27" />
        </swak:group>

        <%-- imuSateiRireki8 --%>
        <swak:group id="imuSateiRireki8">
          <swak:item id="dispimusyoriymd8" />
          <swak:item id="dispimustktsyorinmkbn8" />
          <swak:item id="dispimukekkakbn8" />
          <swak:item id="dispimutns8" />
          <swak:item id="dispimuktnm8" />
          <swak:item id="dispimucomment8" />
          <swak:item id="dispimuketkekkacd8" />
          <swak:item id="dispimusntksakuseiyh8" />
          <swak:item id="dispimuketriyuucd18" />
          <swak:item id="dispimuketriyuunaiyou18" />
          <swak:item id="dispimusyoubyoucd18" />
          <swak:item id="dispimusyoubyounm18" />
          <swak:item id="dispimuketriyuucd28" />
          <swak:item id="dispimuketriyuunaiyou28" />
          <swak:item id="dispimusyoubyoujyoutai18" />
          <swak:item id="dispimukantiym18" />
          <swak:item id="dispimuketriyuucd38" />
          <swak:item id="dispimuketriyuunaiyou38" />
          <swak:item id="dispimusyoubyoucd28" />
          <swak:item id="dispimusyoubyounm28" />
          <swak:item id="dispimuketriyuucd48" />
          <swak:item id="dispimuketriyuunaiyou48" />
          <swak:item id="dispimusyoubyoujyoutai28" />
          <swak:item id="dispimukantiym28" />
        </swak:group>

        <%-- imuSateiRireki9 --%>
        <swak:group id="imuSateiRireki9">
          <swak:item id="dispimusyoriymd9" />
          <swak:item id="dispimustktsyorinmkbn9" />
          <swak:item id="dispimukekkakbn9" />
          <swak:item id="dispimutns9" />
          <swak:item id="dispimuktnm9" />
          <swak:item id="dispimucomment9" />
          <swak:item id="dispimuketkekkacd9" />
          <swak:item id="dispimusntksakuseiyh9" />
          <swak:item id="dispimuketriyuucd19" />
          <swak:item id="dispimuketriyuunaiyou19" />
          <swak:item id="dispimusyoubyoucd19" />
          <swak:item id="dispimusyoubyounm19" />
          <swak:item id="dispimuketriyuucd29" />
          <swak:item id="dispimuketriyuunaiyou29" />
          <swak:item id="dispimusyoubyoujyoutai19" />
          <swak:item id="dispimukantiym19" />
          <swak:item id="dispimuketriyuucd39" />
          <swak:item id="dispimuketriyuunaiyou39" />
          <swak:item id="dispimusyoubyoucd29" />
          <swak:item id="dispimusyoubyounm29" />
          <swak:item id="dispimuketriyuucd49" />
          <swak:item id="dispimuketriyuunaiyou49" />
          <swak:item id="dispimusyoubyoujyoutai29" />
          <swak:item id="dispimukantiym29" />
        </swak:group>

        <%-- imuSateiRireki10 --%>
        <swak:group id="imuSateiRireki10">
          <swak:item id="dispimusyoriymd10" />
          <swak:item id="dispimustktsyorinmkbn10" />
          <swak:item id="dispimukekkakbn10" />
          <swak:item id="dispimutns10" />
          <swak:item id="dispimuktnm10" />
          <swak:item id="dispimucomment10" />
          <swak:item id="dispimuketkekkacd10" />
          <swak:item id="dispimusntksakuseiyh10" />
          <swak:item id="dispimuketriyuucd110" />
          <swak:item id="dispimuketriyuunaiyou110" />
          <swak:item id="dispimusyoubyoucd110" />
          <swak:item id="dispimusyoubyounm110" />
          <swak:item id="dispimuketriyuucd210" />
          <swak:item id="dispimuketriyuunaiyou210" />
          <swak:item id="dispimusyoubyoujyoutai110" />
          <swak:item id="dispimukantiym110" />
          <swak:item id="dispimuketriyuucd310" />
          <swak:item id="dispimuketriyuunaiyou310" />
          <swak:item id="dispimusyoubyoucd210" />
          <swak:item id="dispimusyoubyounm210" />
          <swak:item id="dispimuketriyuucd410" />
          <swak:item id="dispimuketriyuunaiyou410" />
          <swak:item id="dispimusyoubyoujyoutai210" />
          <swak:item id="dispimukantiym210" />
        </swak:group>

        <%-- imuSateiRireki11 --%>
        <swak:group id="imuSateiRireki11">
          <swak:item id="dispimusyoriymd11" />
          <swak:item id="dispimustktsyorinmkbn11" />
          <swak:item id="dispimukekkakbn11" />
          <swak:item id="dispimutns11" />
          <swak:item id="dispimuktnm11" />
          <swak:item id="dispimucomment11" />
          <swak:item id="dispimuketkekkacd11" />
          <swak:item id="dispimusntksakuseiyh11" />
          <swak:item id="dispimuketriyuucd111" />
          <swak:item id="dispimuketriyuunaiyou111" />
          <swak:item id="dispimusyoubyoucd111" />
          <swak:item id="dispimusyoubyounm111" />
          <swak:item id="dispimuketriyuucd211" />
          <swak:item id="dispimuketriyuunaiyou211" />
          <swak:item id="dispimusyoubyoujyoutai111" />
          <swak:item id="dispimukantiym111" />
          <swak:item id="dispimuketriyuucd311" />
          <swak:item id="dispimuketriyuunaiyou311" />
          <swak:item id="dispimusyoubyoucd211" />
          <swak:item id="dispimusyoubyounm211" />
          <swak:item id="dispimuketriyuucd411" />
          <swak:item id="dispimuketriyuunaiyou411" />
          <swak:item id="dispimusyoubyoujyoutai211" />
          <swak:item id="dispimukantiym211" />
        </swak:group>

        <%-- imuSateiRireki12 --%>
        <swak:group id="imuSateiRireki12">
          <swak:item id="dispimusyoriymd12" />
          <swak:item id="dispimustktsyorinmkbn12" />
          <swak:item id="dispimukekkakbn12" />
          <swak:item id="dispimutns12" />
          <swak:item id="dispimuktnm12" />
          <swak:item id="dispimucomment12" />
          <swak:item id="dispimuketkekkacd12" />
          <swak:item id="dispimusntksakuseiyh12" />
          <swak:item id="dispimuketriyuucd112" />
          <swak:item id="dispimuketriyuunaiyou112" />
          <swak:item id="dispimusyoubyoucd112" />
          <swak:item id="dispimusyoubyounm112" />
          <swak:item id="dispimuketriyuucd212" />
          <swak:item id="dispimuketriyuunaiyou212" />
          <swak:item id="dispimusyoubyoujyoutai112" />
          <swak:item id="dispimukantiym112" />
          <swak:item id="dispimuketriyuucd312" />
          <swak:item id="dispimuketriyuunaiyou312" />
          <swak:item id="dispimusyoubyoucd212" />
          <swak:item id="dispimusyoubyounm212" />
          <swak:item id="dispimuketriyuucd412" />
          <swak:item id="dispimuketriyuunaiyou412" />
          <swak:item id="dispimusyoubyoujyoutai212" />
          <swak:item id="dispimukantiym212" />
        </swak:group>

        <%-- imuSateiRireki13 --%>
        <swak:group id="imuSateiRireki13">
          <swak:item id="dispimusyoriymd13" />
          <swak:item id="dispimustktsyorinmkbn13" />
          <swak:item id="dispimukekkakbn13" />
          <swak:item id="dispimutns13" />
          <swak:item id="dispimuktnm13" />
          <swak:item id="dispimucomment13" />
          <swak:item id="dispimuketkekkacd13" />
          <swak:item id="dispimusntksakuseiyh13" />
          <swak:item id="dispimuketriyuucd113" />
          <swak:item id="dispimuketriyuunaiyou113" />
          <swak:item id="dispimusyoubyoucd113" />
          <swak:item id="dispimusyoubyounm113" />
          <swak:item id="dispimuketriyuucd213" />
          <swak:item id="dispimuketriyuunaiyou213" />
          <swak:item id="dispimusyoubyoujyoutai113" />
          <swak:item id="dispimukantiym113" />
          <swak:item id="dispimuketriyuucd313" />
          <swak:item id="dispimuketriyuunaiyou313" />
          <swak:item id="dispimusyoubyoucd213" />
          <swak:item id="dispimusyoubyounm213" />
          <swak:item id="dispimuketriyuucd413" />
          <swak:item id="dispimuketriyuunaiyou413" />
          <swak:item id="dispimusyoubyoujyoutai213" />
          <swak:item id="dispimukantiym213" />
        </swak:group>

        <%-- imuSateiRireki14 --%>
        <swak:group id="imuSateiRireki14">
          <swak:item id="dispimusyoriymd14" />
          <swak:item id="dispimustktsyorinmkbn14" />
          <swak:item id="dispimukekkakbn14" />
          <swak:item id="dispimutns14" />
          <swak:item id="dispimuktnm14" />
          <swak:item id="dispimucomment14" />
          <swak:item id="dispimuketkekkacd14" />
          <swak:item id="dispimusntksakuseiyh14" />
          <swak:item id="dispimuketriyuucd114" />
          <swak:item id="dispimuketriyuunaiyou114" />
          <swak:item id="dispimusyoubyoucd114" />
          <swak:item id="dispimusyoubyounm114" />
          <swak:item id="dispimuketriyuucd214" />
          <swak:item id="dispimuketriyuunaiyou214" />
          <swak:item id="dispimusyoubyoujyoutai114" />
          <swak:item id="dispimukantiym114" />
          <swak:item id="dispimuketriyuucd314" />
          <swak:item id="dispimuketriyuunaiyou314" />
          <swak:item id="dispimusyoubyoucd214" />
          <swak:item id="dispimusyoubyounm214" />
          <swak:item id="dispimuketriyuucd414" />
          <swak:item id="dispimuketriyuunaiyou414" />
          <swak:item id="dispimusyoubyoujyoutai214" />
          <swak:item id="dispimukantiym214" />
        </swak:group>

        <%-- imuSateiRireki15 --%>
        <swak:group id="imuSateiRireki15">
          <swak:item id="dispimusyoriymd15" />
          <swak:item id="dispimustktsyorinmkbn15" />
          <swak:item id="dispimukekkakbn15" />
          <swak:item id="dispimutns15" />
          <swak:item id="dispimuktnm15" />
          <swak:item id="dispimucomment15" />
          <swak:item id="dispimuketkekkacd15" />
          <swak:item id="dispimusntksakuseiyh15" />
          <swak:item id="dispimuketriyuucd115" />
          <swak:item id="dispimuketriyuunaiyou115" />
          <swak:item id="dispimusyoubyoucd115" />
          <swak:item id="dispimusyoubyounm115" />
          <swak:item id="dispimuketriyuucd215" />
          <swak:item id="dispimuketriyuunaiyou215" />
          <swak:item id="dispimusyoubyoujyoutai115" />
          <swak:item id="dispimukantiym115" />
          <swak:item id="dispimuketriyuucd315" />
          <swak:item id="dispimuketriyuunaiyou315" />
          <swak:item id="dispimusyoubyoucd215" />
          <swak:item id="dispimusyoubyounm215" />
          <swak:item id="dispimuketriyuucd415" />
          <swak:item id="dispimuketriyuunaiyou415" />
          <swak:item id="dispimusyoubyoujyoutai215" />
          <swak:item id="dispimukantiym215" />
        </swak:group>

        <%-- ●諾否決定履歴 --%>
        <swak:group id="dakuhiKetteiRireki1">
          <swak:item id="disprenno1" />
          <swak:item id="dispketymd1" />
          <swak:item id="dispketkekkacd1" />
          <swak:item id="dispsntksakuseiyh1" />
          <swak:item id="disptorikesisyousairiyuu1" />
          <swak:item id="dispketriyuucd11" />
          <swak:item id="dispketteiriyuunaiyou11" />
          <swak:item id="dispsyoubyoucd11" />
          <swak:item id="dispsyoubyounm11" />
          <swak:item id="dispketriyuucd21" />
          <swak:item id="dispketteiriyuunaiyou21" />
          <swak:item id="dispsyoubyoujyoutai11" />
          <swak:item id="dispkantiym11" />
          <swak:item id="dispketriyuucd31" />
          <swak:item id="dispketteiriyuunaiyou31" />
          <swak:item id="dispsyoubyoucd21" />
          <swak:item id="dispsyoubyounm21" />
          <swak:item id="dispketriyuucd41" />
          <swak:item id="dispketteiriyuunaiyou41" />
          <swak:item id="dispsyoubyoujyoutai21" />
          <swak:item id="dispkantiym21" />
          <swak:item id="dispmrriyuucdnaiyou1" />
        </swak:group>

        <%-- dakuhiKetteiRireki2 --%>
        <swak:group id="dakuhiKetteiRireki2">
          <swak:item id="disprenno2" />
          <swak:item id="dispketymd2" />
          <swak:item id="dispketkekkacd2" />
          <swak:item id="dispsntksakuseiyh2" />
          <swak:item id="disptorikesisyousairiyuu2" />
          <swak:item id="dispketriyuucd12" />
          <swak:item id="dispketteiriyuunaiyou12" />
          <swak:item id="dispsyoubyoucd12" />
          <swak:item id="dispsyoubyounm12" />
          <swak:item id="dispketriyuucd22" />
          <swak:item id="dispketteiriyuunaiyou22" />
          <swak:item id="dispsyoubyoujyoutai12" />
          <swak:item id="dispkantiym12" />
          <swak:item id="dispketriyuucd32" />
          <swak:item id="dispketteiriyuunaiyou32" />
          <swak:item id="dispsyoubyoucd22" />
          <swak:item id="dispsyoubyounm22" />
          <swak:item id="dispketriyuucd42" />
          <swak:item id="dispketteiriyuunaiyou42" />
          <swak:item id="dispsyoubyoujyoutai22" />
          <swak:item id="dispkantiym22" />
          <swak:item id="dispmrriyuucdnaiyou2" />
        </swak:group>

        <%-- dakuhiKetteiRireki3 --%>
        <swak:group id="dakuhiKetteiRireki3">
          <swak:item id="disprenno3" />
          <swak:item id="dispketymd3" />
          <swak:item id="dispketkekkacd3" />
          <swak:item id="dispsntksakuseiyh3" />
          <swak:item id="disptorikesisyousairiyuu3" />
          <swak:item id="dispketriyuucd13" />
          <swak:item id="dispketteiriyuunaiyou13" />
          <swak:item id="dispsyoubyoucd13" />
          <swak:item id="dispsyoubyounm13" />
          <swak:item id="dispketriyuucd23" />
          <swak:item id="dispketteiriyuunaiyou23" />
          <swak:item id="dispsyoubyoujyoutai13" />
          <swak:item id="dispkantiym13" />
          <swak:item id="dispketriyuucd33" />
          <swak:item id="dispketteiriyuunaiyou33" />
          <swak:item id="dispsyoubyoucd23" />
          <swak:item id="dispsyoubyounm23" />
          <swak:item id="dispketriyuucd43" />
          <swak:item id="dispketteiriyuunaiyou43" />
          <swak:item id="dispsyoubyoujyoutai23" />
          <swak:item id="dispkantiym23" />
          <swak:item id="dispmrriyuucdnaiyou3" />
        </swak:group>

        <%-- dakuhiKetteiRireki4 --%>
        <swak:group id="dakuhiKetteiRireki4">
          <swak:item id="disprenno4" />
          <swak:item id="dispketymd4" />
          <swak:item id="dispketkekkacd4" />
          <swak:item id="dispsntksakuseiyh4" />
          <swak:item id="disptorikesisyousairiyuu4" />
          <swak:item id="dispketriyuucd14" />
          <swak:item id="dispketteiriyuunaiyou14" />
          <swak:item id="dispsyoubyoucd14" />
          <swak:item id="dispsyoubyounm14" />
          <swak:item id="dispketriyuucd24" />
          <swak:item id="dispketteiriyuunaiyou24" />
          <swak:item id="dispsyoubyoujyoutai14" />
          <swak:item id="dispkantiym14" />
          <swak:item id="dispketriyuucd34" />
          <swak:item id="dispketteiriyuunaiyou34" />
          <swak:item id="dispsyoubyoucd24" />
          <swak:item id="dispsyoubyounm24" />
          <swak:item id="dispketriyuucd44" />
          <swak:item id="dispketteiriyuunaiyou44" />
          <swak:item id="dispsyoubyoujyoutai24" />
          <swak:item id="dispkantiym24" />
          <swak:item id="dispmrriyuucdnaiyou4" />
        </swak:group>

        <%-- dakuhiKetteiRireki5 --%>
        <swak:group id="dakuhiKetteiRireki5">
          <swak:item id="disprenno5" />
          <swak:item id="dispketymd5" />
          <swak:item id="dispketkekkacd5" />
          <swak:item id="dispsntksakuseiyh5" />
          <swak:item id="disptorikesisyousairiyuu5" />
          <swak:item id="dispketriyuucd15" />
          <swak:item id="dispketteiriyuunaiyou15" />
          <swak:item id="dispsyoubyoucd15" />
          <swak:item id="dispsyoubyounm15" />
          <swak:item id="dispketriyuucd25" />
          <swak:item id="dispketteiriyuunaiyou25" />
          <swak:item id="dispsyoubyoujyoutai15" />
          <swak:item id="dispkantiym15" />
          <swak:item id="dispketriyuucd35" />
          <swak:item id="dispketteiriyuunaiyou35" />
          <swak:item id="dispsyoubyoucd25" />
          <swak:item id="dispsyoubyounm25" />
          <swak:item id="dispketriyuucd45" />
          <swak:item id="dispketteiriyuunaiyou45" />
          <swak:item id="dispsyoubyoujyoutai25" />
          <swak:item id="dispkantiym25" />
          <swak:item id="dispmrriyuucdnaiyou5" />
        </swak:group>

        <%-- dakuhiKetteiRireki6 --%>
        <swak:group id="dakuhiKetteiRireki6">
          <swak:item id="disprenno6" />
          <swak:item id="dispketymd6" />
          <swak:item id="dispketkekkacd6" />
          <swak:item id="dispsntksakuseiyh6" />
          <swak:item id="disptorikesisyousairiyuu6" />
          <swak:item id="dispketriyuucd16" />
          <swak:item id="dispketteiriyuunaiyou16" />
          <swak:item id="dispsyoubyoucd16" />
          <swak:item id="dispsyoubyounm16" />
          <swak:item id="dispketriyuucd26" />
          <swak:item id="dispketteiriyuunaiyou26" />
          <swak:item id="dispsyoubyoujyoutai16" />
          <swak:item id="dispkantiym16" />
          <swak:item id="dispketriyuucd36" />
          <swak:item id="dispketteiriyuunaiyou36" />
          <swak:item id="dispsyoubyoucd26" />
          <swak:item id="dispsyoubyounm26" />
          <swak:item id="dispketriyuucd46" />
          <swak:item id="dispketteiriyuunaiyou46" />
          <swak:item id="dispsyoubyoujyoutai26" />
          <swak:item id="dispkantiym26" />
          <swak:item id="dispmrriyuucdnaiyou6" />
        </swak:group>

        <%-- dakuhiKetteiRireki7 --%>
        <swak:group id="dakuhiKetteiRireki7">
          <swak:item id="disprenno7" />
          <swak:item id="dispketymd7" />
          <swak:item id="dispketkekkacd7" />
          <swak:item id="dispsntksakuseiyh7" />
          <swak:item id="disptorikesisyousairiyuu7" />
          <swak:item id="dispketriyuucd17" />
          <swak:item id="dispketteiriyuunaiyou17" />
          <swak:item id="dispsyoubyoucd17" />
          <swak:item id="dispsyoubyounm17" />
          <swak:item id="dispketriyuucd27" />
          <swak:item id="dispketteiriyuunaiyou27" />
          <swak:item id="dispsyoubyoujyoutai17" />
          <swak:item id="dispkantiym17" />
          <swak:item id="dispketriyuucd37" />
          <swak:item id="dispketteiriyuunaiyou37" />
          <swak:item id="dispsyoubyoucd27" />
          <swak:item id="dispsyoubyounm27" />
          <swak:item id="dispketriyuucd47" />
          <swak:item id="dispketteiriyuunaiyou47" />
          <swak:item id="dispsyoubyoujyoutai27" />
          <swak:item id="dispkantiym27" />
          <swak:item id="dispmrriyuucdnaiyou7" />
        </swak:group>

        <%-- dakuhiKetteiRireki8 --%>
        <swak:group id="dakuhiKetteiRireki8">
          <swak:item id="disprenno8" />
          <swak:item id="dispketymd8" />
          <swak:item id="dispketkekkacd8" />
          <swak:item id="dispsntksakuseiyh8" />
          <swak:item id="disptorikesisyousairiyuu8" />
          <swak:item id="dispketriyuucd18" />
          <swak:item id="dispketteiriyuunaiyou18" />
          <swak:item id="dispsyoubyoucd18" />
          <swak:item id="dispsyoubyounm18" />
          <swak:item id="dispketriyuucd28" />
          <swak:item id="dispketteiriyuunaiyou28" />
          <swak:item id="dispsyoubyoujyoutai18" />
          <swak:item id="dispkantiym18" />
          <swak:item id="dispketriyuucd38" />
          <swak:item id="dispketteiriyuunaiyou38" />
          <swak:item id="dispsyoubyoucd28" />
          <swak:item id="dispsyoubyounm28" />
          <swak:item id="dispketriyuucd48" />
          <swak:item id="dispketteiriyuunaiyou48" />
          <swak:item id="dispsyoubyoujyoutai28" />
          <swak:item id="dispkantiym28" />
          <swak:item id="dispmrriyuucdnaiyou8" />
        </swak:group>

        <%-- dakuhiKetteiRireki9 --%>
        <swak:group id="dakuhiKetteiRireki9">
          <swak:item id="disprenno9" />
          <swak:item id="dispketymd9" />
          <swak:item id="dispketkekkacd9" />
          <swak:item id="dispsntksakuseiyh9" />
          <swak:item id="disptorikesisyousairiyuu9" />
          <swak:item id="dispketriyuucd19" />
          <swak:item id="dispketteiriyuunaiyou19" />
          <swak:item id="dispsyoubyoucd19" />
          <swak:item id="dispsyoubyounm19" />
          <swak:item id="dispketriyuucd29" />
          <swak:item id="dispketteiriyuunaiyou29" />
          <swak:item id="dispsyoubyoujyoutai19" />
          <swak:item id="dispkantiym19" />
          <swak:item id="dispketriyuucd39" />
          <swak:item id="dispketteiriyuunaiyou39" />
          <swak:item id="dispsyoubyoucd29" />
          <swak:item id="dispsyoubyounm29" />
          <swak:item id="dispketriyuucd49" />
          <swak:item id="dispketteiriyuunaiyou49" />
          <swak:item id="dispsyoubyoujyoutai29" />
          <swak:item id="dispkantiym29" />
          <swak:item id="dispmrriyuucdnaiyou9" />
        </swak:group>

        <%-- dakuhiKetteiRireki10 --%>
        <swak:group id="dakuhiKetteiRireki10">
          <swak:item id="disprenno10" />
          <swak:item id="dispketymd10" />
          <swak:item id="dispketkekkacd10" />
          <swak:item id="dispsntksakuseiyh10" />
          <swak:item id="disptorikesisyousairiyuu10" />
          <swak:item id="dispketriyuucd110" />
          <swak:item id="dispketteiriyuunaiyou110" />
          <swak:item id="dispsyoubyoucd110" />
          <swak:item id="dispsyoubyounm110" />
          <swak:item id="dispketriyuucd210" />
          <swak:item id="dispketteiriyuunaiyou210" />
          <swak:item id="dispsyoubyoujyoutai110" />
          <swak:item id="dispkantiym110" />
          <swak:item id="dispketriyuucd310" />
          <swak:item id="dispketteiriyuunaiyou310" />
          <swak:item id="dispsyoubyoucd210" />
          <swak:item id="dispsyoubyounm210" />
          <swak:item id="dispketriyuucd410" />
          <swak:item id="dispketteiriyuunaiyou410" />
          <swak:item id="dispsyoubyoujyoutai210" />
          <swak:item id="dispkantiym210" />
          <swak:item id="dispmrriyuucdnaiyou10" />
        </swak:group>

        <%-- dakuhiKetteiRireki11 --%>
        <swak:group id="dakuhiKetteiRireki11">
          <swak:item id="disprenno11" />
          <swak:item id="dispketymd11" />
          <swak:item id="dispketkekkacd11" />
          <swak:item id="dispsntksakuseiyh11" />
          <swak:item id="disptorikesisyousairiyuu11" />
          <swak:item id="dispketriyuucd111" />
          <swak:item id="dispketteiriyuunaiyou111" />
          <swak:item id="dispsyoubyoucd111" />
          <swak:item id="dispsyoubyounm111" />
          <swak:item id="dispketriyuucd211" />
          <swak:item id="dispketteiriyuunaiyou211" />
          <swak:item id="dispsyoubyoujyoutai111" />
          <swak:item id="dispkantiym111" />
          <swak:item id="dispketriyuucd311" />
          <swak:item id="dispketteiriyuunaiyou311" />
          <swak:item id="dispsyoubyoucd211" />
          <swak:item id="dispsyoubyounm211" />
          <swak:item id="dispketriyuucd411" />
          <swak:item id="dispketteiriyuunaiyou411" />
          <swak:item id="dispsyoubyoujyoutai211" />
          <swak:item id="dispkantiym211" />
          <swak:item id="dispmrriyuucdnaiyou11" />
        </swak:group>

        <%-- dakuhiKetteiRireki12 --%>
        <swak:group id="dakuhiKetteiRireki12">
          <swak:item id="disprenno12" />
          <swak:item id="dispketymd12" />
          <swak:item id="dispketkekkacd12" />
          <swak:item id="dispsntksakuseiyh12" />
          <swak:item id="disptorikesisyousairiyuu12" />
          <swak:item id="dispketriyuucd112" />
          <swak:item id="dispketteiriyuunaiyou112" />
          <swak:item id="dispsyoubyoucd112" />
          <swak:item id="dispsyoubyounm112" />
          <swak:item id="dispketriyuucd212" />
          <swak:item id="dispketteiriyuunaiyou212" />
          <swak:item id="dispsyoubyoujyoutai112" />
          <swak:item id="dispkantiym112" />
          <swak:item id="dispketriyuucd312" />
          <swak:item id="dispketteiriyuunaiyou312" />
          <swak:item id="dispsyoubyoucd212" />
          <swak:item id="dispsyoubyounm212" />
          <swak:item id="dispketriyuucd412" />
          <swak:item id="dispketteiriyuunaiyou412" />
          <swak:item id="dispsyoubyoujyoutai212" />
          <swak:item id="dispkantiym212" />
          <swak:item id="dispmrriyuucdnaiyou12" />
        </swak:group>

        <%-- dakuhiKetteiRireki13 --%>
        <swak:group id="dakuhiKetteiRireki13">
          <swak:item id="disprenno13" />
          <swak:item id="dispketymd13" />
          <swak:item id="dispketkekkacd13" />
          <swak:item id="dispsntksakuseiyh13" />
          <swak:item id="disptorikesisyousairiyuu13" />
          <swak:item id="dispketriyuucd113" />
          <swak:item id="dispketteiriyuunaiyou113" />
          <swak:item id="dispsyoubyoucd113" />
          <swak:item id="dispsyoubyounm113" />
          <swak:item id="dispketriyuucd213" />
          <swak:item id="dispketteiriyuunaiyou213" />
          <swak:item id="dispsyoubyoujyoutai113" />
          <swak:item id="dispkantiym113" />
          <swak:item id="dispketriyuucd313" />
          <swak:item id="dispketteiriyuunaiyou313" />
          <swak:item id="dispsyoubyoucd213" />
          <swak:item id="dispsyoubyounm213" />
          <swak:item id="dispketriyuucd413" />
          <swak:item id="dispketteiriyuunaiyou413" />
          <swak:item id="dispsyoubyoujyoutai213" />
          <swak:item id="dispkantiym213" />
          <swak:item id="dispmrriyuucdnaiyou13" />
        </swak:group>

        <%-- dakuhiKetteiRireki14 --%>
        <swak:group id="dakuhiKetteiRireki14">
          <swak:item id="disprenno14" />
          <swak:item id="dispketymd14" />
          <swak:item id="dispketkekkacd14" />
          <swak:item id="dispsntksakuseiyh14" />
          <swak:item id="disptorikesisyousairiyuu14" />
          <swak:item id="dispketriyuucd114" />
          <swak:item id="dispketteiriyuunaiyou114" />
          <swak:item id="dispsyoubyoucd114" />
          <swak:item id="dispsyoubyounm114" />
          <swak:item id="dispketriyuucd214" />
          <swak:item id="dispketteiriyuunaiyou214" />
          <swak:item id="dispsyoubyoujyoutai114" />
          <swak:item id="dispkantiym114" />
          <swak:item id="dispketriyuucd314" />
          <swak:item id="dispketteiriyuunaiyou314" />
          <swak:item id="dispsyoubyoucd214" />
          <swak:item id="dispsyoubyounm214" />
          <swak:item id="dispketriyuucd414" />
          <swak:item id="dispketteiriyuunaiyou414" />
          <swak:item id="dispsyoubyoujyoutai214" />
          <swak:item id="dispkantiym214" />
          <swak:item id="dispmrriyuucdnaiyou14" />
        </swak:group>

        <%-- dakuhiKetteiRireki15 --%>
        <swak:group id="dakuhiKetteiRireki15">
          <swak:item id="disprenno15" />
          <swak:item id="dispketymd15" />
          <swak:item id="dispketkekkacd15" />
          <swak:item id="dispsntksakuseiyh15" />
          <swak:item id="disptorikesisyousairiyuu15" />
          <swak:item id="dispketriyuucd115" />
          <swak:item id="dispketteiriyuunaiyou115" />
          <swak:item id="dispsyoubyoucd115" />
          <swak:item id="dispsyoubyounm115" />
          <swak:item id="dispketriyuucd215" />
          <swak:item id="dispketteiriyuunaiyou215" />
          <swak:item id="dispsyoubyoujyoutai115" />
          <swak:item id="dispkantiym115" />
          <swak:item id="dispketriyuucd315" />
          <swak:item id="dispketteiriyuunaiyou315" />
          <swak:item id="dispsyoubyoucd215" />
          <swak:item id="dispsyoubyounm215" />
          <swak:item id="dispketriyuucd415" />
          <swak:item id="dispketteiriyuunaiyou415" />
          <swak:item id="dispsyoubyoujyoutai215" />
          <swak:item id="dispkantiym215" />
          <swak:item id="dispmrriyuucdnaiyou15" />
        </swak:group>

        <%-- nyuukinJyoukyouBaseInfo --%>
        <swak:group id="nyuukinJyoukyouBaseInfo">
          <swak:item id="nyuukinjoutaikbn" />
          <swak:item id="fstphrkgk" />
          <swak:item id="rsgakukei" />
          <swak:item id="fstphrkgkhrktuuka" />
          <swak:item id="nyknkwsratetkyymd" />
          <swak:item id="nyknkwsrate2" />
          <swak:item id="fstpryosyuymd" />
          <swak:item id="denkawaserate" />
          <swak:item id="dispzenkizennouumu" />
          <swak:item id="dispznnkai" />
          <swak:item id="disphrkkaisuu" />
          <swak:item id="disphrkkeiro" />
          <swak:item id="dispfstphrkkeirokbn" />
          <swak:item id="dispteikiikkatubaraikaisuu" />
          <swak:item id="hituyouikkatup" />
          <swak:item id="husokuikkatup" />
          <swak:item id="ikkatuyoupkaisuu" />
          <swak:item id="genzaiikkatukaisuu" />
        </swak:group>

        <%-- ●入金情報 --%>
        <swak:dataTable id="nyuukinInfo">
          <swak:column id="disprskingaku" />
          <swak:column id="IAW0006" />
          <swak:column id="disprsdengkyen" />
          <swak:column id="dispryosyuymd" />
          <swak:column id="dispnyknsyubetu" />
          <swak:column id="dispsoukincd" />
          <swak:column id="disptyakkinymd" />
        </swak:dataTable>

        <%-- ●Ｐ過金情報 --%>
        <swak:dataTable id="pkakinInfo">
          <swak:column id="disppkakingk" />
          <swak:column id="IAW0006" />
          <swak:column id="disppkakindengkyen" />
          <swak:column id="disppkakinsyoriymd" />
          <swak:column id="disppkakinhnknriyuu" />
        </swak:dataTable>

        <%-- ●返金情報 --%>
        <swak:dataTable id="henkinInfo">
          <swak:column id="disphnkngk" />
          <swak:column id="IAW0006" />
          <swak:column id="disphnkndengkyen" />
          <swak:column id="disphnknymd" />
          <swak:column id="disphnknriyuu" />
          <swak:column id="disphnknhoukbn" />
          <swak:column id="dispbankcd" />
          <swak:column id="dispbanknmkj" />
          <swak:column id="IAW0006" />
          <swak:column id="dispsitencd" />
          <swak:column id="dispsitennmkj" />
          <swak:column id="dispyokinkbn" />
          <swak:column id="IAW0006" />
          <swak:column id="dispkouzano" />
          <swak:column id="dispkzmeiginmkn" />
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

        <%-- ●訂正履歴情報一覧 --%>
        <swak:dataTable id="teiseiRirekiInfoItiran">
          <swak:column id="dispsyoritime" />
          <swak:column id="dispkinoussnm" />
          <swak:column id="disptskmnm" />
          <swak:column id="disptsmaenaiyou" />
          <swak:column id="disptsgonaiyou" />
          <swak:column id="disptantounm" />
        </swak:dataTable>

        <%-- ●契約者 --%>
        <swak:group id="keiyakusya">
          <swak:item id="vkykskyknmkn" />
          <swak:item id="vkykskykseiymd" />
        </swak:group>

        <%-- kykSakuinInfo --%>
        <swak:dataTable id="kykSakuinInfo">
          <swak:column id="dispkyksakuinsyono" />
          <swak:column id="dispkyksakuinmosno" />
          <swak:column id="dispkyksakuintaisyou" />
          <swak:column id="dispkyksakuinkykymd" />
          <swak:column id="dispkyksakuinsyoumetuymd" />
          <swak:column id="dispkyksakuinhuseiritu" />
          <swak:column id="dispkyksakuin" />
        </swak:dataTable>

        <%-- ●被保険者 --%>
        <swak:group id="hihokensya">
          <swak:item id="vhhkshhknnmkn" />
          <swak:item id="vhhkshhknseiymd" />
        </swak:group>

        <%-- hhknSakuinInfo --%>
        <swak:dataTable id="hhknSakuinInfo">
          <swak:column id="disphhknsakuinsyono" />
          <swak:column id="disphhknsakuinmosno" />
          <swak:column id="disphhknsakuintaisyou" />
          <swak:column id="disphhknsakuinkykymd" />
          <swak:column id="disphhknsakuinsyoumetuymd" />
          <swak:column id="disphhknsakuinhuseiritu" />
          <swak:column id="disphhknsakuin" />
        </swak:dataTable>

        <%-- kouteiJyoukyouBaseInfo --%>
        <swak:dataTable id="kouteiJyoukyouBaseInfo">
          <swak:column id="syoriTime" />
          <swak:column id="vprghsdisptasknm" />
          <swak:column id="vprghsdispsyorikekkakbn" />
          <swak:column id="vprghsdispsousasyanm" />
          <swak:column id="vprghsdispcomment" />
        </swak:dataTable>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="modorubtnbykensaku" />
          <swak:item id="modorubtnbykeiyakunaiyou" />
          <swak:item id="modorubtnbyhubijk" />
          <swak:item id="modorubtnbyhubitrkinfo" />
          <swak:item id="modorubtnbyketteijk" />
          <swak:item id="modorubtnbynyuukinjk" />
          <swak:item id="modorubtnbysyoruitoutyakujk" />
          <swak:item id="modorubtnbyteiseirrklist" />
          <swak:item id="modorubtnbysakuininfo" />
          <swak:item id="modorubtnbykouteijk" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
