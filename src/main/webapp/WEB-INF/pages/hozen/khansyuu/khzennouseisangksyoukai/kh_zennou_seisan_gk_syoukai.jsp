<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：前納精算額照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khansyuu/khzennouseisangksyoukai/KhZennouSeisanGkSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

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

        <%-- 基本情報 --%>
        <swak:group id="baseInfo">
          <swak:item id="syono" />
          <swak:item id="calckijyunymd" />
        </swak:group>

        <%-- ●前納情報 --%>
        <swak:group id="zennouInfo2">
          <swak:item id="zennoustartym" />
          <swak:item id="zennoukikan" />
          <swak:item id="zennounyuukinkgk" />
          <swak:item id="annaisaikaiym" />
          <swak:item id="IIA3002" />
          <swak:item id="zennounyuukinkgkrstk" />
          <swak:item id="ryosyukwsratekjymd" />
          <swak:item id="ryosyukwsrate" />
          <swak:item id="rstuukasyu" />
          <swak:item id="kyktuukasyu" />
        </swak:group>

        <%-- ●前納精算額 --%>
        <swak:group id="seisanGkInfo">
          <swak:item id="zennouseisankgk" />
          <swak:item id="seityuusigojkipjytym" />
          <swak:item id="yenkazennouseisankgk" />
          <swak:item id="yenkansantkykwsrateymd" />
          <swak:item id="yenkansantkykwsrate" />
          <swak:item id="kyktuukasyu2" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="syoukaibtnbyinputkey" />
          <swak:item id="modorubtnbysyoukai" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
