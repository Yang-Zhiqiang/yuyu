<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：（死亡）査定
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sisatei/sisateisb/SiSateiSb.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
          <swak:item id="tojiruBtnByPopup" />
        </swak:buttonGroup>

        <%-- headerButtons2 --%>
        <swak:buttonGroup id="headerButtons2">
          <swak:item id="hbtrbtn" />
          <swak:item id="hkngksisanbtn" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiinfo">
          <swak:item id="vktifdispjimutetuzukinm" />
          <swak:item id="vktifdisptasknm" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="hktskKihonInfo">
          <swak:item id="syono" />
          <swak:item id="syoukaibtn" />
          <swak:item id="skno" />
          <swak:item id="kouteikanriid" />
          <swak:item id="kouteilockkey" />
        </swak:group>

        <%-- ●書類受付日 --%>
        <swak:group id="syoruiukeymdInfo">
          <swak:item id="syoruiukeymd" />
          <swak:item id="hubikanryouymd" />
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

        <%-- ●請求内容 --%>
        <swak:group id="viewSknaiyouInfo">
          <swak:item id="suketorihouhoukbn" />
          <swak:item id="siharaituukakbn" />
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

        <%-- tuikaButtons --%>
        <swak:buttonGroup id="tuikaButtons">
          <swak:item id="addbtn" />
        </swak:buttonGroup>

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

        <%-- nyuuryokuTeiseiBtn --%>
        <swak:buttonGroup id="nyuuryokuTeiseiBtn">
          <swak:item id="nyuuryokuteiseibtn" />
        </swak:buttonGroup>

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

        <%-- ●金額情報（外貨建商品の場合は書類受付日の為替レートで計算） --%>
        <swak:group id="viewKingakuInfo">
          <swak:item id="hokenryoustgk" />
          <swak:item id="yenhokenryoustgk" />
          <swak:item id="tutakngk" />
          <swak:item id="yentutakngk" />
          <swak:item id="kaiyakuhr" />
          <swak:item id="yenkaiyakuhr" />
          <swak:item id="kihonhokenkngk" />
          <swak:item id="yenkihonhokenkngk" />
          <swak:item id="saigais" />
          <swak:item id="yensaigais" />
        </swak:group>

        <%-- ●税務情報 --%>
        <swak:group id="viewZeimuInfo">
          <swak:item id="zeitratkikbn" />
          <swak:item id="goukeihituyoukeihi" />
          <swak:item id="kykhnkkaisuu" />
          <swak:item id="shrkykhtykeihi" />
        </swak:group>

        <%-- ●査定項目 --%>
        <swak:group id="viewSateikoumokuInfo">
          <swak:item id="sateikoumoku" />
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
          <swak:item id="hokenkinsyurui" />
          <swak:item id="syorikekkakbn" />
          <swak:item id="IJC1048" />
          <swak:item id="tennousakisousasyacd" />
          <swak:item id="hushrgeninkbn" />
          <swak:item id="sessyouyhkbn" />
          <swak:item id="sessyousisyacd" />
          <swak:item id="sisyanm" />
          <swak:item id="sinsagendokknkbn" />
          <swak:item id="rikoukityuutuudannissuu" />
          <swak:item id="saigaimousideumukbn" />
          <swak:item id="sindansyoryoushryouhi" />
          <swak:item id="sindansyoryoushryouhikbn" />
          <swak:item id="syanaicomment" />
        </swak:group>

        <%-- ●手続入力 --%>
        <swak:group id="viewSateiKekkaInfo">
          <swak:item id="sateisyorikekkakbn" />
          <swak:item id="sateitennousakisousasyacd" />
          <swak:item id="kaiketuymd" />
          <swak:item id="sateisyanaicomment" />
        </swak:group>

        <%-- ●確認項目 --%>
        <swak:dataTable id="viewKakuninkoumokuInfo">
          <swak:column id="dispsyoriymd" />
          <swak:column id="disptasknm" />
          <swak:column id="dispsyorikekkakbn" />
          <swak:column id="dispsousasyanm" />
          <swak:column id="dispcomment" />
        </swak:dataTable>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modorubtnbyinputcorrect" />
          <swak:item id="saikeisanbtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
          <swak:item id="kakuniniraisyosakuseibtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="syoukaibtnhihyouji" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
