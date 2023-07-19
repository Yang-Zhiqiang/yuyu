<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約保全手続注意設定
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khtetudukityuui/KhTetudukiTyuui.do">

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

        <%-- ●被保険者 --%>
        <swak:group id="hihokensyaInfo">
          <swak:item id="vhhkshhknnmkn" />
          <swak:item id="vhhkshhknnmkj" />
          <swak:item id="vhhkshhknnmkjkhukakbn" />
          <swak:item id="vhhkshhknseiymd" />
          <swak:item id="vhhkshhknsei" />
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

        <%-- ●手続注意 --%>
        <swak:group id="ttdkTyuui">
          <swak:item id="kktyuitakbn" />
          <swak:item id="ttdktyuuinaiyou1" />
          <swak:item id="ttdktyuuinaiyou2" />
          <swak:item id="ttdktyuuinaiyou3" />
        </swak:group>

        <%-- ttdkTyuui1 --%>
        <swak:dataTable id="ttdkTyuui1">
          <swak:column id="ttdktyuuikbn" />
          <swak:column id="ttdktyuuikbnhsknaiyou" />
          <swak:column id="ttdktyuuikbnsetymd" />
          <swak:column id="setsosikinm" />
          <swak:column id="ttdktyuuisakujyo" />
        </swak:dataTable>

        <%-- stknset --%>
        <swak:group id="stknset">
          <swak:item id="stknsetkbn" />
        </swak:group>

        <%-- ●契約者代理状態 --%>
        <swak:group id="kykdrjtInfo">
          <swak:item id="kykdrknhatudoujyoutai" />
          <swak:item id="kykdrdouiyouhi" />
        </swak:group>

        <%-- ●ＦＡＴＣＡ対象者 --%>
        <swak:group id="fatcaTaisyousya1">
          <swak:item id="dispsyoriymd1" />
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
          <swak:item id="dispkouryokuendymd1" />
          <swak:item id="dispfatcasakujyo1" />
        </swak:group>

        <%-- fatcaTaisyousya2 --%>
        <swak:group id="fatcaTaisyousya2">
          <swak:item id="dispsyoriymd2" />
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
          <swak:item id="dispkouryokuendymd2" />
          <swak:item id="dispfatcasakujyo2" />
        </swak:group>

        <%-- fatcaTaisyousya3 --%>
        <swak:group id="fatcaTaisyousya3">
          <swak:item id="dispsyoriymd3" />
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
          <swak:item id="dispkouryokuendymd3" />
          <swak:item id="dispfatcasakujyo3" />
        </swak:group>

        <%-- fatcaTaisyousya4 --%>
        <swak:group id="fatcaTaisyousya4">
          <swak:item id="dispsyoriymd4" />
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
          <swak:item id="dispkouryokuendymd4" />
          <swak:item id="dispfatcasakujyo4" />
        </swak:group>

        <%-- fatcaTaisyousya5 --%>
        <swak:group id="fatcaTaisyousya5">
          <swak:item id="dispsyoriymd5" />
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
          <swak:item id="dispkouryokuendymd5" />
          <swak:item id="dispfatcasakujyo5" />
        </swak:group>

        <%-- fatcaKensuu --%>
        <swak:group id="fatcaKensuu">
          <swak:item id="recordkensuu" />
        </swak:group>

        <%-- addbtnButtons --%>
        <swak:buttonGroup id="addbtnButtons">
          <swak:item id="addbtn" />
        </swak:buttonGroup>

        <%-- ●ＡＥＯＩ対象者 --%>
        <swak:group id="aeoiTaisyousya1">
          <swak:item id="dispaeoisyoriymd1" />
          <swak:item id="dispaeoisyorisosikicd1" />
          <swak:item id="dispaeoikekkakbn1" />
          <swak:item id="dispaeoisyorikbn1" />
          <swak:item id="dispaeoitaisyousyakbn1" />
          <swak:item id="dispaeoihoujinsyuruikbn1" />
          <swak:item id="dispaeoikouryokusttymd1" />
          <swak:item id="dispaeoikouryokuendymd1" />
          <swak:item id="dispaeoisakujyo1" />
        </swak:group>

        <%-- aeoiTaisyousya2 --%>
        <swak:group id="aeoiTaisyousya2">
          <swak:item id="dispaeoisyoriymd2" />
          <swak:item id="dispaeoisyorisosikicd2" />
          <swak:item id="dispaeoikekkakbn2" />
          <swak:item id="dispaeoisyorikbn2" />
          <swak:item id="dispaeoitaisyousyakbn2" />
          <swak:item id="dispaeoihoujinsyuruikbn2" />
          <swak:item id="dispaeoikouryokusttymd2" />
          <swak:item id="dispaeoikouryokuendymd2" />
          <swak:item id="dispaeoisakujyo2" />
        </swak:group>

        <%-- aeoiTaisyousya3 --%>
        <swak:group id="aeoiTaisyousya3">
          <swak:item id="dispaeoisyoriymd3" />
          <swak:item id="dispaeoisyorisosikicd3" />
          <swak:item id="dispaeoikekkakbn3" />
          <swak:item id="dispaeoisyorikbn3" />
          <swak:item id="dispaeoitaisyousyakbn3" />
          <swak:item id="dispaeoihoujinsyuruikbn3" />
          <swak:item id="dispaeoikouryokusttymd3" />
          <swak:item id="dispaeoikouryokuendymd3" />
          <swak:item id="dispaeoisakujyo3" />
        </swak:group>

        <%-- aeoiTaisyousya4 --%>
        <swak:group id="aeoiTaisyousya4">
          <swak:item id="dispaeoisyoriymd4" />
          <swak:item id="dispaeoisyorisosikicd4" />
          <swak:item id="dispaeoikekkakbn4" />
          <swak:item id="dispaeoisyorikbn4" />
          <swak:item id="dispaeoitaisyousyakbn4" />
          <swak:item id="dispaeoihoujinsyuruikbn4" />
          <swak:item id="dispaeoikouryokusttymd4" />
          <swak:item id="dispaeoikouryokuendymd4" />
          <swak:item id="dispaeoisakujyo4" />
        </swak:group>

        <%-- aeoiTaisyousya5 --%>
        <swak:group id="aeoiTaisyousya5">
          <swak:item id="dispaeoisyoriymd5" />
          <swak:item id="dispaeoisyorisosikicd5" />
          <swak:item id="dispaeoikekkakbn5" />
          <swak:item id="dispaeoisyorikbn5" />
          <swak:item id="dispaeoitaisyousyakbn5" />
          <swak:item id="dispaeoihoujinsyuruikbn5" />
          <swak:item id="dispaeoikouryokusttymd5" />
          <swak:item id="dispaeoikouryokuendymd5" />
          <swak:item id="dispaeoisakujyo5" />
        </swak:group>

        <%-- aeoiKensuu --%>
        <swak:group id="aeoiKensuu">
          <swak:item id="aeoirecordkensuu" />
        </swak:group>

        <%-- aeoiaddbtnButtons --%>
        <swak:buttonGroup id="aeoiaddbtnButtons">
          <swak:item id="addbtnbyaeoi" />
        </swak:buttonGroup>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="syoukaibtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtnbysyoukai" />
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
