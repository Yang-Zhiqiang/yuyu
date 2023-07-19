<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：支払履歴照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sisyoukai/sishrrirekisyoukai/SiShrRirekiSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●証券番号指定 --%>
        <swak:group id="hktskKihonInfo">
          <swak:item id="syono" />
          <swak:item id="skno" />
        </swak:group>

        <%-- syoukaiButton --%>
        <swak:buttonGroup id="syoukaiButton">
          <swak:item id="syoukaibtn" />
        </swak:buttonGroup>

        <%-- ●検索条件指定 --%>
        <swak:group id="searchConditions">
          <swak:item id="hhknnmkn" />
          <swak:item id="hhknnmkj" />
        </swak:group>

        <%-- searchButton --%>
        <swak:buttonGroup id="searchButton">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- searchResults --%>
        <swak:dataTable id="searchResults">
          <swak:column id="syono" />
          <swak:column id="hhknnmkn" />
          <swak:column id="hhknnmkj" />
          <swak:column id="seikyuusyanmkn" />
          <swak:column id="seikyuusyanmkj" />
        </swak:dataTable>
        <swak:pager id="searchResultsDataSource" />

        <%-- ●支払履歴 --%>
        <swak:dataTable id="siharaiRireki">
          <swak:column id="shrymd" />
          <swak:column id="shrkekkakbn" />
          <swak:column id="hushrgeninkbn" />
          <swak:column id="seikyuusyubetu" />
          <swak:column id="seikyuusyanmkj" />
          <swak:column id="seikyuusyakbn" />
          <swak:column id="shrgkkei" />
          <swak:column id="syousaiLink" />
        </swak:dataTable>
        <swak:pager id="siharaiRirekiDataSource" />

        <%-- ●進捗履歴情報 --%>
        <swak:dataTable id="progresshistoryinfo">
          <swak:column id="vprghsdispsyoriymd" />
          <swak:column id="vprghsdisptasknm" />
          <swak:column id="vprghsdispsyorikekkakbn" />
          <swak:column id="vprghsdispsousasyanm" />
          <swak:column id="vprghsdispcomment" />
        </swak:dataTable>

        <%-- ●書類情報 --%>
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

        <%-- ●請求者情報 --%>
        <swak:group id="viewSkjyouhouInfo">
          <swak:item id="seikyuusyakbn" />
          <swak:item id="sihonninkakninkbn" />
          <swak:item id="seikyuusyaseiymd" />
          <swak:item id="seikyuusyasei" />
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

        <%-- ●親権者後見人情報 --%>
        <swak:group id="viewSinkensyaInfo">
          <swak:item id="skskknnmkn" />
          <swak:item id="skskknnmkj" />
          <swak:item id="skskknsyubetu" />
        </swak:group>

        <%-- ●送付先住所情報 --%>
        <swak:group id="viewSouhusakiInfo">
          <swak:item id="souhusakikbn" />
          <swak:item id="tsinyno" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
          <swak:item id="tsintelno" />
        </swak:group>

        <%-- ●支払方法 --%>
        <swak:group id="viewSoukinsakishrInfo">
          <swak:item id="inputshrhousiteikbn" />
        </swak:group>

        <%-- ●送金先口座情報 --%>
        <swak:group id="viewSoukinsakiInfo">
          <swak:item id="bankcd" />
          <swak:item id="IBC1001" />
          <swak:item id="banknmkj" />
          <swak:item id="sitencd" />
          <swak:item id="IBC1002" />
          <swak:item id="sitennmkj" />
          <swak:item id="yokinkbn" />
          <swak:item id="IBC1003" />
          <swak:item id="kouzano" />
          <swak:item id="IBC1004" />
          <swak:item id="kzdoukbn" />
          <swak:item id="kzmeiginmkn" />
        </swak:group>

        <%-- ●査定回送要否確認 --%>
        <swak:group id="viewSateikaisouyouhiSibouInfo">
          <swak:item id="sateikaksaigaikanousei" />
          <swak:item id="sateikaksaigaikanouseikbn" />
          <swak:item id="sateikakkaigaisb" />
          <swak:item id="sateikakkaigaisbkbn" />
          <swak:item id="sateikakhusyousi" />
          <swak:item id="sateikakhusyousikbn" />
          <swak:item id="sateikakmeigihnk" />
          <swak:item id="sateikakmeigihnkkbn" />
        </swak:group>

        <%-- ●請求内容 --%>
        <swak:group id="viewSknaiyouInfo">
          <swak:item id="suketorihouhoukbn" />
          <swak:item id="siharaituukakbn" />
        </swak:group>

        <%-- ●診断書情報 --%>
        <swak:group id="viewSindansyoinfoSibouInfo">
          <swak:item id="geninkbn" />
          <swak:item id="sibouymd" />
          <swak:item id="siboubasyokbn" />
          <swak:item id="siboubasyo" />
        </swak:group>

        <%-- viewSindansyoinfoSibouInfo1 --%>
        <swak:dataTable id="viewSindansyoinfoSibouInfo1">
          <swak:column id="searchlink" />
          <swak:column id="byoumeikj" />
          <swak:column id="sakujyoLink" />
          <swak:column id="sakujyoflg" />
          <swak:column id="byoumeicd" />
          <swak:column id="byoumeikn" />
          <swak:column id="byoumeitourokuno" />
        </swak:dataTable>

        <%-- ●診断書料支払 --%>
        <swak:group id="viewSindansyoryouShrnfo">
          <swak:item id="sindansyomaisuu" />
          <swak:item id="sindansyoshrgk" />
          <swak:item id="tyakkinymd" />
        </swak:group>

        <%-- ●支払明細書作成区分 --%>
        <swak:group id="viewShrdtlSakuseiKbnInfo">
          <swak:item id="shrdtlsyooutkbn" />
          <swak:item id="hassoukbn" />
        </swak:group>

        <%-- ●ＭＮ名義番号 --%>
        <swak:group id="viewMnMeigiBangou">
          <swak:item id="uktmnmeigibangou" />
          <swak:item id="kykmnmeigibangou" />
        </swak:group>

        <%-- ●死因情報 --%>
        <swak:group id="viewSiinInfo">
          <swak:item id="siinkbn" />
        </swak:group>

        <%-- ●支払詳細 --%>
        <swak:dataTable id="hktshrMeisaisInfo">
          <swak:column id="syouhnnmgm" />
          <swak:column id="kyhkg" />
          <swak:column id="bikoumsg1" />
          <swak:column id="bikoumsg2" />
          <swak:column id="bikoumsg3" />
          <swak:column id="bikoumsg4" />
        </swak:dataTable>

        <%-- ●支払情報 --%>
        <swak:group id="viewSiharaiInfo">
          <swak:item id="shrtuukasyu" />
          <swak:item id="shrkwsratekjnymd" />
          <swak:item id="shrkwsrate" />
          <swak:item id="gaikaknsnkwsratekjymd" />
          <swak:item id="gaikaknsnkwsrate" />
          <swak:item id="dispsyoruiukeymd" />
          <swak:item id="disphubikanryouymd" />
        </swak:group>

        <%-- viewSiharaiInfo1 --%>
        <swak:group id="viewSiharaiInfo1">
          <swak:item id="shrymd" />
          <swak:item id="dispsinsagendokknkbn" />
          <swak:item id="disprkktydnnissuu" />
        </swak:group>

        <%-- ●支払合計 --%>
        <swak:group id="hktshrGoukeiInfo">
          <swak:item id="shrgk" />
          <swak:item id="hokenkngkgoukei" />
          <swak:item id="haitoukin" />
          <swak:item id="sonotahaitoukin" />
          <swak:item id="mikeikapgaitoukkn" />
          <swak:item id="mikeikap" />
          <swak:item id="misyuupgaitoukkn" />
          <swak:item id="misyuup" />
          <swak:item id="zennouseisankgk" />
          <swak:item id="azukarikingk" />
          <swak:item id="krkgk" />
          <swak:item id="tienrisokukisanymd" />
          <swak:item id="tienrsknissuu" />
          <swak:item id="shrtienrsk" />
        </swak:group>

        <%-- ●円換算支払合計 --%>
        <swak:group id="yenGoukeiInfo">
          <swak:item id="yenshrgk" />
          <swak:item id="yenhkgkgoukei" />
          <swak:item id="yenkahaitoukin" />
          <swak:item id="yenkasonotahaitoukin" />
          <swak:item id="yenkamikeikapgaitoukkn" />
          <swak:item id="yenkamikeikap" />
          <swak:item id="yenkamisyuupgaitoukkn" />
          <swak:item id="yenkamisyuup" />
          <swak:item id="yenkazennouseisankgk" />
          <swak:item id="yenkaazukarikingk" />
          <swak:item id="yenkakrkgk" />
          <swak:item id="yentienrisokukisanymd" />
          <swak:item id="yentienrsknissuu" />
          <swak:item id="yenshrtienrsk" />
        </swak:group>

        <%-- ●税務情報 --%>
        <swak:group id="viewZeimuInfo">
          <swak:item id="zeitratkikbn" />
          <swak:item id="goukeihituyoukeihi" />
          <swak:item id="kykhnkkaisuu" />
          <swak:item id="shrkykhtykeihi" />
        </swak:group>

        <%-- ●一般判定 --%>
        <swak:group id="viewIppanhanteiInfo">
          <swak:item id="IJW1057" />
          <swak:item id="IJW1058" />
          <swak:item id="IJW1061" />
          <swak:item id="IJW1060" />
          <swak:item id="IBC1008" />
          <swak:item id="IJC1001" />
          <swak:item id="ippanhanteitensuu1" />
          <swak:item id="ippanhanteicomment1" />
          <swak:item id="IBC1009" />
          <swak:item id="IJC1002" />
          <swak:item id="ippanhanteitensuu2" />
          <swak:item id="ippanhanteicomment2" />
          <swak:item id="IBC1010" />
          <swak:item id="IJC1003" />
          <swak:item id="ippanhanteitensuu3" />
          <swak:item id="ippanhanteicomment3" />
          <swak:item id="IBC1011" />
          <swak:item id="IJC1004" />
          <swak:item id="ippanhanteitensuu4" />
          <swak:item id="ippanhanteicomment4" />
          <swak:item id="IBC1012" />
          <swak:item id="IJC1005" />
          <swak:item id="ippanhanteitensuu5" />
          <swak:item id="ippanhanteicomment5" />
          <swak:item id="IBC1013" />
          <swak:item id="IJC1006" />
          <swak:item id="ippanhanteitensuu6" />
          <swak:item id="ippanhanteicomment6" />
          <swak:item id="IAW0001" />
          <swak:item id="IJC1007" />
          <swak:item id="ippanhanteitensuugoukei" />
          <swak:item id="ippanhanteigoukeicomment" />
        </swak:group>

        <%-- ●告反チェック --%>
        <swak:group id="viewKokuhanCheckInfo">
          <swak:item id="IJW1057" />
          <swak:item id="IJW1058" />
          <swak:item id="IJW1059" />
          <swak:item id="IJW1060" />
          <swak:item id="IBC1008" />
          <swak:item id="IJC1016" />
          <swak:item id="kokuhancheck1" />
          <swak:item id="kokuhanchecomment1" />
          <swak:item id="IBC1009" />
          <swak:item id="IJC1017" />
          <swak:item id="kokuhancheck2" />
          <swak:item id="kokuhanchecomment2" />
          <swak:item id="IBC1010" />
          <swak:item id="IJC1018" />
          <swak:item id="kokuhancheck3" />
          <swak:item id="kokuhanchecomment3" />
          <swak:item id="IBC1011" />
          <swak:item id="IJC1019" />
          <swak:item id="kokuhancheck4" />
          <swak:item id="kokuhanchecomment4" />
          <swak:item id="IBC1012" />
          <swak:item id="IJC1020" />
          <swak:item id="kokuhancheck5" />
          <swak:item id="kokuhanchecomment5" />
          <swak:item id="IBC1013" />
          <swak:item id="IJC1021" />
          <swak:item id="kokuhancheck6" />
          <swak:item id="kokuhanchecomment6" />
          <swak:item id="IBC1014" />
          <swak:item id="IJC1022" />
          <swak:item id="kokuhancheck7" />
          <swak:item id="kokuhanchecomment7" />
          <swak:item id="IBC1015" />
          <swak:item id="IJC1023" />
          <swak:item id="kokuhancheck8" />
          <swak:item id="kokuhanchecomment8" />
        </swak:group>

        <%-- ●重過失チェック --%>
        <swak:group id="viewJyuukasituInfo">
          <swak:item id="IJW1057" />
          <swak:item id="IJW1058" />
          <swak:item id="IJW1059" />
          <swak:item id="IJW1060" />
          <swak:item id="IBC1008" />
          <swak:item id="IJC1030" />
          <swak:item id="juukasitucheck1" />
          <swak:item id="juukasitucheckcomment1" />
          <swak:item id="IBC1009" />
          <swak:item id="IJC1031" />
          <swak:item id="juukasitucheck2" />
          <swak:item id="juukasitucheckcomment2" />
          <swak:item id="IBC1010" />
          <swak:item id="IJC1032" />
          <swak:item id="juukasitucheck3" />
          <swak:item id="juukasitucheckcomment3" />
          <swak:item id="IBC1011" />
          <swak:item id="IJC1033" />
          <swak:item id="juukasitucheck4" />
          <swak:item id="juukasitucheckcomment4" />
        </swak:group>

        <%-- ●解除期限日入力 --%>
        <swak:group id="viewKaijokigenymdInputInfo">
          <swak:item id="kaijokigenymd" />
        </swak:group>

        <%-- ●名義変更査定 --%>
        <swak:group id="viewMeigihenkouSateiInfo">
          <swak:item id="meihenyuukoumukoukbn" />
          <swak:item id="meihenuktkbn" />
          <swak:item id="meihenuktnm" />
        </swak:group>

        <%-- ●取扱不良・不祥事件等 --%>
        <swak:group id="viewTratkihuryouHusyoujikenInfo">
          <swak:item id="tratkihuryouumukbn" />
          <swak:item id="gyousinkaisouyouhikbn" />
          <swak:item id="aireqdaityoukisaikbn" />
          <swak:item id="tratkihuryoucomment" />
        </swak:group>

        <%-- ●その他チェック項目 --%>
        <swak:group id="viewSonotaCheckSibou">
          <swak:item id="bengosikenkaiumukbn" />
          <swak:item id="kujyouumukbn" />
          <swak:item id="jimumissumukbn" />
          <swak:item id="kyhgksitukaisouyouhikbn" />
        </swak:group>

        <%-- ●別口チェック項目 --%>
        <swak:group id="viewBetukutiCheckSibouInfo">
          <swak:item id="betusibouumukbn" />
          <swak:item id="betusiboucomment" />
          <swak:item id="betusoukiumukbn" />
          <swak:item id="betusoukicomment" />
        </swak:group>

        <%-- ●支払査定 --%>
        <swak:group id="viewSiharaiSateiInfo">
          <swak:item id="syorikekkakbn" />
          <swak:item id="hushrgeninkbn" />
          <swak:item id="sessyouyhkbn" />
          <swak:item id="sessyousisyacd" />
          <swak:item id="sisyanm" />
          <swak:item id="saigaimousideumukbn" />
          <swak:item id="sindansyoryoushryouhikbn" />
        </swak:group>

        <%-- ●解決入力 --%>
        <swak:group id="viewSateiKekkaInfo">
          <swak:item id="kaiketuymd" />
        </swak:group>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtnbykensaku" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modorubtnbysyoukai" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="modoruBtnBySyousai" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
