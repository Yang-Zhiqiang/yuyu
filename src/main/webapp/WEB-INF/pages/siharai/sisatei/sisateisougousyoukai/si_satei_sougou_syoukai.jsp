<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：査定総合照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sisatei/sisateisougousyoukai/SiSateiSougouSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- headerButtons2 --%>
        <swak:buttonGroup id="headerButtons2">
          <swak:item id="kouteijkbtn" />
          <swak:item id="siharairirekisyoukaibtn" />
          <swak:item id="imagesyoukaibtn" />
          <swak:item id="mosjksyoukaibtn" />
          <swak:item id="kyknaiyousyoukaibtn" />
        </swak:buttonGroup>

        <%-- headerButtons3 --%>
        <swak:buttonGroup id="headerButtons3">
          <swak:item id="skinfo1btnbysk1" />
          <swak:item id="skinfo2btnbysk1" />
          <swak:item id="kykinfobtnbysk1" />
          <swak:item id="nayoseinfobtnbysk1" />
          <swak:item id="ttdktyuuiinfobtnbysk1" />
        </swak:buttonGroup>

        <%-- headerButtons4 --%>
        <swak:buttonGroup id="headerButtons4">
          <swak:item id="skinfo1btnbysk2" />
          <swak:item id="skinfo2btnbysk2" />
          <swak:item id="kykinfobtnbysk2" />
          <swak:item id="nayoseinfobtnbysk2" />
          <swak:item id="ttdktyuuiinfobtnbysk2" />
        </swak:buttonGroup>

        <%-- headerButtons5 --%>
        <swak:buttonGroup id="headerButtons5">
          <swak:item id="skinfo1btnbykyk" />
          <swak:item id="skinfo2btnbykyk" />
          <swak:item id="kykinfobtnbykyk" />
          <swak:item id="nayoseinfobtnbykyk" />
          <swak:item id="ttdktyuuiinfobtnbykyk" />
        </swak:buttonGroup>

        <%-- headerButtons6 --%>
        <swak:buttonGroup id="headerButtons6">
          <swak:item id="skinfo1btnbynayose" />
          <swak:item id="skinfo2btnbynayose" />
          <swak:item id="kykinfobtnbynayose" />
          <swak:item id="nayoseinfobtnbynayose" />
          <swak:item id="ttdktyuuiinfobtnbynayose" />
        </swak:buttonGroup>

        <%-- headerButtons7 --%>
        <swak:buttonGroup id="headerButtons7">
          <swak:item id="skinfo1btnbyttdk" />
          <swak:item id="skinfo2btnbyttdk" />
          <swak:item id="kykinfobtnbyttdk" />
          <swak:item id="nayoseinfobtnbyttdk" />
          <swak:item id="ttdktyuuiinfobtnbyttdk" />
        </swak:buttonGroup>

        <%-- hktskKihonInfo --%>
        <swak:group id="hktskKihonInfo">
          <swak:item id="syono" />
          <swak:item id="skno" />
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

        <%-- ●画面非表示項目 --%>
        <swak:group id="hiddenGroup">
          <swak:item id="imageid" />
          <swak:item id="kouteikanriid" />
        </swak:group>

        <%-- ●同時請求情報 --%>
        <swak:dataTable id="skKihonKanriInfo">
          <swak:column id="dispsyono" />
          <swak:column id="dispsyoriymd" />
          <swak:column id="dispnextsyorinm" />
          <swak:column id="disphubikbn" />
          <swak:column id="disptyousajkkbn" />
        </swak:dataTable>

        <%-- ●請求者情報 --%>
        <swak:group id="skJyouhou">
          <swak:item id="seikyuusyakbn" />
          <swak:item id="seikyuusyanmkn" />
          <swak:item id="seikyuusyanmkj" />
        </swak:group>

        <%-- ●債権者情報 --%>
        <swak:group id="viewSaikenInfo">
          <swak:item id="saikennmkj" />
        </swak:group>

        <%-- viewSaikenInfo1 --%>
        <swak:group id="viewSaikenInfo1">
          <swak:item id="saikennyno" />
          <swak:item id="saikenadr1kj" />
          <swak:item id="saikenadr2kj" />
          <swak:item id="saikenadr3kj" />
        </swak:group>

        <%-- ●送付先情報 --%>
        <swak:group id="souhusakiInfo">
          <swak:item id="tsinyno" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
          <swak:item id="tsintelno" />
        </swak:group>

        <%-- ●送金先口座情報 --%>
        <swak:group id="soukinsaki">
          <swak:item id="inputshrhousiteikbn" />
          <swak:item id="bankcd" />
          <swak:item id="banknmkj" />
          <swak:item id="sitencd" />
          <swak:item id="sitennmkj" />
          <swak:item id="yokinkbn" />
          <swak:item id="kouzano" />
          <swak:item id="kzmeiginmkn" />
        </swak:group>

        <%-- ●進捗履歴情報 --%>
        <swak:dataTable id="progresshistoryinfo">
          <swak:column id="vprghsdispsyoriymd" />
          <swak:column id="vprghsdisptasknm" />
          <swak:column id="vprghsdispsyorikekkakbn" />
          <swak:column id="vprghsdispsousasyanm" />
          <swak:column id="vprghsdispcomment" />
        </swak:dataTable>

        <%-- ●不備一覧 --%>
        <swak:dataTable id="hubiList">
          <swak:column id="trkymd" />
          <swak:column id="syoruinm" />
          <swak:column id="genponhnkykumu" />
          <swak:column id="hasinymd" />
          <swak:column id="hassinsakikbn" />
          <swak:column id="dispnyuryokutantounm" />
          <swak:column id="kaisyouymd" />
          <swak:column id="hubisyoruimsg" />
          <swak:column id="hubisyouninktntnm" />
        </swak:dataTable>

        <%-- ●申出人情報 --%>
        <swak:group id="mousideninInfo">
          <swak:item id="mousideninkbn" />
          <swak:item id="mousideninnmkj" />
          <swak:item id="uketorininsibouumukbn" />
          <swak:item id="kyksyasibouumukbn" />
        </swak:group>

        <%-- mousideninInfo2 --%>
        <swak:group id="mousideninInfo2">
          <swak:item id="souhusakikbn" />
          <swak:item id="disptsinyno" />
          <swak:item id="disptsinadr1kj" />
          <swak:item id="disptsinadr2kj" />
          <swak:item id="disptsinadr3kj" />
          <swak:item id="disptsintelno" />
        </swak:group>

        <%-- ●申出内容 --%>
        <swak:group id="mousideNaiyou">
          <swak:item id="seikyuusyubetu" />
          <swak:item id="geninkbn" />
          <swak:item id="sibouymd" />
          <swak:item id="syoubyounmkjgamen" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="kihonInfo">
          <swak:item id="yuukousyoumetukbn" />
          <swak:item id="kykjyoutai" />
          <swak:item id="syoumetujiyuu" />
          <swak:item id="syoumetuymd" />
          <swak:item id="mosymd" />
          <swak:item id="kktymd" />
          <swak:item id="mosukeymd" />
        </swak:group>

        <%-- ●契約者情報 --%>
        <swak:group id="keiyakusyaInfo">
          <swak:item id="vkykskyknmkn" />
          <swak:item id="vkykskyknmkj" />
          <swak:item id="vkykskykseiymd" />
          <swak:item id="dispmskmjskjkyknen" />
          <swak:item id="vkykskyksei" />
          <swak:item id="vtssktsinyno" />
          <swak:item id="vtssktsintelno" />
          <swak:item id="vtssktsinadr1kj" />
          <swak:item id="vtssktsinadr2kj" />
          <swak:item id="vtssktsinadr3kj" />
        </swak:group>

        <%-- ●被保険者情報 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="vhhkshhknnmkn" />
          <swak:item id="vhhkshhknnmkj" />
          <swak:item id="vhhkshhknseiymd" />
          <swak:item id="dispmskmjskjhhknnen" />
          <swak:item id="vhhkshhknsei" />
        </swak:group>

        <%-- ●保障内容 --%>
        <swak:group id="hosyouInfo">
          <swak:item id="vhsyusyusyouhnnm" />
          <swak:item id="vhsyusyukyktuukasyu" />
          <swak:item id="vhsyusyuhknkkn" />
          <swak:item id="vhsyusyuhknkknsmnkbn" />
          <swak:item id="vhsyusyuhrkkkn" />
          <swak:item id="vhsyusyuhrkkknsmnkbn" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudai1hknkkn" />
          <swak:item id="vhsyusyukykymd" />
          <swak:item id="vhsyusyusknnkaisiymd" />
          <swak:item id="vhsyusyufktsknnkaisiymd" />
          <swak:item id="vhsyusyukihons" />
          <swak:item id="vhsyusyup" />
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
        </swak:group>

        <%-- 　＜特約＞ --%>
        <swak:group id="tkInfo1">
          <swak:item id="vhsyudisptksyouhnnm1" />
          <swak:item id="vhsyudisptkhknkkn1" />
          <swak:item id="vhsyudisptkhknkknsmnkbn1" />
          <swak:item id="vhsyudisptkhrkkkn1" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn1" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd1" />
          <swak:item id="vhsyudisptksknnkaisiymd1" />
          <swak:item id="vhsyudisptkhkskkaisiymd1" />
          <swak:item id="vhsyudisptkkihons1" />
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
        </swak:group>

        <%-- 　＜特約＞２ --%>
        <swak:group id="tkInfo2">
          <swak:item id="vhsyudisptksyouhnnm2" />
          <swak:item id="vhsyudisptkhknkkn2" />
          <swak:item id="vhsyudisptkhknkknsmnkbn2" />
          <swak:item id="vhsyudisptkhrkkkn2" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn2" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd2" />
          <swak:item id="vhsyudisptksknnkaisiymd2" />
          <swak:item id="vhsyudisptkhkskkaisiymd2" />
          <swak:item id="vhsyudisptkkihons2" />
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
        </swak:group>

        <%-- 　＜特約＞３ --%>
        <swak:group id="tkInfo3">
          <swak:item id="vhsyudisptksyouhnnm3" />
          <swak:item id="vhsyudisptkhknkkn3" />
          <swak:item id="vhsyudisptkhknkknsmnkbn3" />
          <swak:item id="vhsyudisptkhrkkkn3" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn3" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd3" />
          <swak:item id="vhsyudisptksknnkaisiymd3" />
          <swak:item id="vhsyudisptkhkskkaisiymd3" />
          <swak:item id="vhsyudisptkkihons3" />
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
        </swak:group>

        <%-- 　＜特約＞４ --%>
        <swak:group id="tkInfo4">
          <swak:item id="vhsyudisptksyouhnnm4" />
          <swak:item id="vhsyudisptkhknkkn4" />
          <swak:item id="vhsyudisptkhknkknsmnkbn4" />
          <swak:item id="vhsyudisptkhrkkkn4" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn4" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd4" />
          <swak:item id="vhsyudisptksknnkaisiymd4" />
          <swak:item id="vhsyudisptkhkskkaisiymd4" />
          <swak:item id="vhsyudisptkkihons4" />
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
        </swak:group>

        <%-- 　＜特約＞５ --%>
        <swak:group id="tkInfo5">
          <swak:item id="vhsyudisptksyouhnnm5" />
          <swak:item id="vhsyudisptkhknkkn5" />
          <swak:item id="vhsyudisptkhknkknsmnkbn5" />
          <swak:item id="vhsyudisptkhrkkkn5" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn5" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd5" />
          <swak:item id="vhsyudisptksknnkaisiymd5" />
          <swak:item id="vhsyudisptkhkskkaisiymd5" />
          <swak:item id="vhsyudisptkkihons5" />
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
        </swak:group>

        <%-- 　＜特約＞６ --%>
        <swak:group id="tkInfo6">
          <swak:item id="vhsyudisptksyouhnnm6" />
          <swak:item id="vhsyudisptkhknkkn6" />
          <swak:item id="vhsyudisptkhknkknsmnkbn6" />
          <swak:item id="vhsyudisptkhrkkkn6" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn6" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd6" />
          <swak:item id="vhsyudisptksknnkaisiymd6" />
          <swak:item id="vhsyudisptkhkskkaisiymd6" />
          <swak:item id="vhsyudisptkkihons6" />
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
        </swak:group>

        <%-- 　＜特約＞７ --%>
        <swak:group id="tkInfo7">
          <swak:item id="vhsyudisptksyouhnnm7" />
          <swak:item id="vhsyudisptkhknkkn7" />
          <swak:item id="vhsyudisptkhknkknsmnkbn7" />
          <swak:item id="vhsyudisptkhrkkkn7" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn7" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd7" />
          <swak:item id="vhsyudisptksknnkaisiymd7" />
          <swak:item id="vhsyudisptkhkskkaisiymd7" />
          <swak:item id="vhsyudisptkkihons7" />
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
        </swak:group>

        <%-- 　＜特約＞８ --%>
        <swak:group id="tkInfo8">
          <swak:item id="vhsyudisptksyouhnnm8" />
          <swak:item id="vhsyudisptkhknkkn8" />
          <swak:item id="vhsyudisptkhknkknsmnkbn8" />
          <swak:item id="vhsyudisptkhrkkkn8" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn8" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd8" />
          <swak:item id="vhsyudisptksknnkaisiymd8" />
          <swak:item id="vhsyudisptkhkskkaisiymd8" />
          <swak:item id="vhsyudisptkkihons8" />
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
        </swak:group>

        <%-- 　＜特約＞９ --%>
        <swak:group id="tkInfo9">
          <swak:item id="vhsyudisptksyouhnnm9" />
          <swak:item id="vhsyudisptkhknkkn9" />
          <swak:item id="vhsyudisptkhknkknsmnkbn9" />
          <swak:item id="vhsyudisptkhrkkkn9" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn9" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd9" />
          <swak:item id="vhsyudisptksknnkaisiymd9" />
          <swak:item id="vhsyudisptkhkskkaisiymd9" />
          <swak:item id="vhsyudisptkkihons9" />
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
        </swak:group>

        <%-- 　＜特約＞１０ --%>
        <swak:group id="tkInfo10">
          <swak:item id="vhsyudisptksyouhnnm10" />
          <swak:item id="vhsyudisptkhknkkn10" />
          <swak:item id="vhsyudisptkhknkknsmnkbn10" />
          <swak:item id="vhsyudisptkhrkkkn10" />
          <swak:item id="vhsyudisptkhrkkknsmnkbn10" />
          <swak:item id="IJW1088" />
          <swak:item id="vhsyudisptkkykymd10" />
          <swak:item id="vhsyudisptksknnkaisiymd10" />
          <swak:item id="vhsyudisptkhkskkaisiymd10" />
          <swak:item id="vhsyudisptkkihons10" />
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
        </swak:group>

        <%-- ●その他特約・特則 --%>
        <swak:group id="sonotaTkInfo">
          <swak:item id="vsntkdisptkhukainfo" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="sbHkuktInfo">
          <swak:item id="vshktsbuktnin" />
        </swak:group>

        <%-- ●死亡受取人情報 --%>
        <swak:group id="sbHkuktInfo1">
          <swak:item id="vshktdispsbuktkbn1" />
          <swak:item id="vshktdispsbuktnmkn1" />
          <swak:item id="vshktdispsbuktnmkj1" />
          <swak:item id="vshktdispsbuktseiymd1" />
          <swak:item id="dispmskmjskjuktnen1" />
          <swak:item id="vshktdispsbuktbnwari1" />
        </swak:group>

        <%-- ●死亡受取人情報２ --%>
        <swak:group id="sbHkuktInfo2">
          <swak:item id="vshktdispsbuktnmkn2" />
          <swak:item id="vshktdispsbuktnmkj2" />
          <swak:item id="vshktdispsbuktseiymd2" />
          <swak:item id="dispmskmjskjuktnen2" />
          <swak:item id="vshktdispsbuktbnwari2" />
        </swak:group>

        <%-- ●死亡受取人情報３ --%>
        <swak:group id="sbHkuktInfo3">
          <swak:item id="vshktdispsbuktnmkn3" />
          <swak:item id="vshktdispsbuktnmkj3" />
          <swak:item id="vshktdispsbuktseiymd3" />
          <swak:item id="dispmskmjskjuktnen3" />
          <swak:item id="vshktdispsbuktbnwari3" />
        </swak:group>

        <%-- ●死亡受取人情報４ --%>
        <swak:group id="sbHkuktInfo4">
          <swak:item id="vshktdispsbuktnmkn4" />
          <swak:item id="vshktdispsbuktnmkj4" />
          <swak:item id="vshktdispsbuktseiymd4" />
          <swak:item id="dispmskmjskjuktnen4" />
          <swak:item id="vshktdispsbuktbnwari4" />
        </swak:group>

        <%-- ●被保険者代理人 --%>
        <swak:group id="siteiseikyuuInfo">
          <swak:item id="vstsksiteidruktkbn" />
          <swak:item id="vstskstdrsknmkn" />
          <swak:item id="vstskstdrsknmkj" />
        </swak:group>

        <%-- ●代理店 --%>
        <swak:group id="dairitenInfo1">
          <swak:item id="dispdrtencd1" />
          <swak:item id="dispdrtennm1" />
          <swak:item id="dispbosyuucd1" />
          <swak:item id="dispbosyuunm1" />
          <swak:item id="dispbunwari1" />
        </swak:group>

        <%-- dairitenInfo2 --%>
        <swak:group id="dairitenInfo2">
          <swak:item id="dispdrtencd2" />
          <swak:item id="dispdrtennm2" />
          <swak:item id="dispbosyuucd2" />
          <swak:item id="dispbosyuunm2" />
          <swak:item id="dispbunwari2" />
        </swak:group>

        <%-- dairitenInfo3 --%>
        <swak:group id="dairitenInfo3">
          <swak:item id="bosyuuym" />
          <swak:item id="dairitenseisekiym" />
        </swak:group>

        <%-- dairitenInfo4 --%>
        <swak:group id="dairitenInfo4">
          <swak:item id="cifcd" />
          <swak:item id="boskykjyoutai" />
          <swak:item id="smbckanriid" />
        </swak:group>

        <%-- ●別契約情報 --%>
        <swak:dataTable id="betukykInfo">
          <swak:column id="btkyksyono" />
          <swak:column id="syscdkbn" />
          <swak:column id="betukutikeiyakukbn" />
          <swak:column id="kankeisyakbnname" />
          <swak:column id="syoumetuymd" />
          <swak:column id="syoumetujiyuuname" />
          <swak:column id="syouhnnm" />
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

        <%-- ●審査注意情報 --%>
        <swak:group id="sinsatyuuiInfo">
          <swak:item id="sinsatyuuisetnm" />
          <swak:item id="sosikinm" />
          <swak:item id="sinsatyuui" />
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

        <%-- ●ＭＲ・反社情報 --%>
        <swak:group id="mrhansyaInfo">
          <swak:item id="kykmrumu" />
          <swak:item id="kykhnsyumu" />
          <swak:item id="hhknmrumu" />
          <swak:item id="hhknhnsyumu" />
        </swak:group>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
