<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：控除証明書再発行
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khkoujyosyoumeisaihakkou/KhKoujyosyoumeiSaihakkou.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

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

        <%-- ●仮受金情報 --%>
        <swak:dataTable id="kariukekinInfo">
          <swak:column id="vkukkrkno" />
          <swak:column id="vkukkrkkeijyoymd" />
          <swak:column id="vkukkrkriyuukbn" />
          <swak:column id="vkukhrkkaisuu" />
          <swak:column id="vkuknykkeiro" />
          <swak:column id="vkuknyknaiyoukbn" />
          <swak:column id="vkukjyuutouym" />
          <swak:column id="vkukjyutoukaisuu" />
          <swak:column id="vkukryosyuymd" />
          <swak:column id="vkukkrkgk" />
        </swak:dataTable>

        <%-- ●控除証明年度 --%>
        <swak:group id="koujyoSyoumeiNendoInfo">
          <swak:item id="koujyosyoumeinnd" />
        </swak:group>

        <%-- ●再発行表示区分 --%>
        <swak:group id="saihkhyjkbnInfo">
          <swak:item id="saihkhyjkbn" />
        </swak:group>

        <%-- ●出力区分 --%>
        <swak:group id="tyhyoutkbnInfo">
          <swak:item id="koujyosyoumeisyooutkbn" />
          <swak:item id="IIF1013" />
        </swak:group>

        <%-- ●控除証明内容 --%>
        <swak:group id="koujyoSyoumeiNaiyouInfo">
          <swak:item id="disptekiyouseidokbn" />
          <swak:item id="dispnenkanhrkkaisuu" />
          <swak:item id="dispsyoumeistartym" />
          <swak:item id="dispsyoumeiendym" />
        </swak:group>

        <%-- ＜実績＞ --%>
        <swak:group id="jissekiInfo">
          <swak:item id="dispnewippanjissekip" />
          <swak:item id="dispnewippanjissekihtkin" />
          <swak:item id="dispnewippanjissekisymgk" />
          <swak:item id="dispnewiryoujissekip" />
          <swak:item id="dispnewiryoujissekihtkin" />
          <swak:item id="dispnewiryoujissekisymgk" />
          <swak:item id="dispnewnkjissekip" />
          <swak:item id="dispnewnkjissekihtkin" />
          <swak:item id="dispnewnkjissekisymgk" />
        </swak:group>

        <%-- ＜年間＞　※本年（証明年度）１２月末時点のご申告予定額 --%>
        <swak:group id="nenkanInfo">
          <swak:item id="dispnewippannenkanp" />
          <swak:item id="dispnewippannenkanhtkin" />
          <swak:item id="dispnewippannenkansymgk" />
          <swak:item id="dispnewiryounenkanp" />
          <swak:item id="dispnewiryounenkanhtkin" />
          <swak:item id="dispnewiryounenkansymgk" />
          <swak:item id="dispnewnknenkanp" />
          <swak:item id="dispnewnknenkanhtkin" />
          <swak:item id="dispnewnknenkansymgk" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="nyuuryokubtn" />
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
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
