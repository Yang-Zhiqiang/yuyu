<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：代理店情報修正
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khdairiteninfosyuusei/KhDairitenInfoSyuusei.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●基本情報 --%>
        <swak:group id="kihonInfo">
          <swak:item id="vkihnsyono" />
          <swak:item id="drteninfosyuuseitaisyou" />
          <swak:item id="vkihnyuukousyoumetukbn" />
          <swak:item id="vkihnkykjyoutai" />
          <swak:item id="vkihnsyoumetujiyuu" />
          <swak:item id="vkihnsyoumetuymd" />
          <swak:item id="vkihnlastsyosaihkymd" />
        </swak:group>

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

        <%-- ●代理店情報 --%>
        <swak:group id="dairitenInfo">
          <swak:item id="dispsyono" />
          <swak:item id="dispoyadrtencd1" />
          <swak:item id="dispoyadrtennm1" />
        </swak:group>

        <%-- ●変更前代理店情報 --%>
        <swak:group id="hekoumaedairitenInfo">
          <swak:item id="cifcd1" />
          <swak:item id="uktkid1" />
        </swak:group>

        <%-- Ａ代理店 --%>
        <swak:group id="AdairiInfo">
          <swak:item id="drtenjimcd1" />
          <swak:item id="bosyuunintourokuno1" />
          <swak:item id="dairitenkinyuukikancd1" />
          <swak:item id="dairitenkinyuukikansitencd1" />
          <swak:item id="dairitentoriatukaikouincd1" />
          <swak:item id="toriatukaidairitencd1" />
          <swak:item id="kanjitoriatukaidairitennm1" />
          <swak:item id="oyadairitencd1" />
          <swak:item id="kanjioyadrtennm1" />
          <swak:item id="bosyuucd1" />
          <swak:item id="bosyuuninnm1" />
          <swak:item id="gyskkjsakisosikicd1" />
          <swak:item id="gyskkjsakisosikinmkj1" />
          <swak:item id="bunwari1" />
        </swak:group>

        <%-- Ｂ代理店 --%>
        <swak:group id="BdairiInfo">
          <swak:item id="drtenjimcd2" />
          <swak:item id="bosyuunintourokuno2" />
          <swak:item id="dairitenkinyuukikancd2" />
          <swak:item id="dairitenkinyuukikansitencd2" />
          <swak:item id="dairitentoriatukaikouincd2" />
          <swak:item id="toriatukaidairitencd2" />
          <swak:item id="kanjitoriatukaidairitennm2" />
          <swak:item id="oyadairitencd2" />
          <swak:item id="kanjioyadrtennm2" />
          <swak:item id="bosyuucd2" />
          <swak:item id="bosyuuninnm2" />
          <swak:item id="gyskkjsakisosikicd2" />
          <swak:item id="gyskkjsakisosikinmkj2" />
          <swak:item id="bunwari2" />
        </swak:group>

        <%-- ●変更後代理店情報 --%>
        <swak:group id="hekougodairitenInfo">
          <swak:item id="cifcd2" />
          <swak:item id="uktkid2" />
          <swak:item id="IHF0047" />
        </swak:group>

        <%-- A代理店 --%>
        <swak:group id="AdairiInfo2">
          <swak:item id="drtenjimcd3" />
          <swak:item id="bosyuunintourokuno3" />
          <swak:item id="dairitenkinyuukikancd3" />
          <swak:item id="dairitenkinyuukikansitencd3" />
          <swak:item id="dairitentoriatukaikouincd3" />
          <swak:item id="toriatukaidairitencd3" />
          <swak:item id="kanjitoriatukaidairitennm3" />
          <swak:item id="oyadairitencd3" />
          <swak:item id="kanjioyadrtennm3" />
          <swak:item id="bosyuucd3" />
          <swak:item id="bosyuuninnm3" />
          <swak:item id="gyskkjsakisosikicd3" />
          <swak:item id="gyskkjsakisosikinmkj3" />
          <swak:item id="bunwari3" />
        </swak:group>

        <%-- Ｂ代理店 --%>
        <swak:group id="BdairiInfo2">
          <swak:item id="drtenjimcd4" />
          <swak:item id="bosyuunintourokuno4" />
          <swak:item id="dairitenkinyuukikancd4" />
          <swak:item id="dairitenkinyuukikansitencd4" />
          <swak:item id="dairitentoriatukaikouincd4" />
          <swak:item id="toriatukaidairitencd4" />
          <swak:item id="kanjitoriatukaidairitennm4" />
          <swak:item id="oyadairitencd4" />
          <swak:item id="kanjioyadrtennm4" />
          <swak:item id="bosyuucd4" />
          <swak:item id="bosyuuninnm4" />
          <swak:item id="gyskkjsakisosikicd4" />
          <swak:item id="gyskkjsakisosikinmkj4" />
          <swak:item id="bunwari4" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="nyuuryokubtn" />
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="henkouBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
