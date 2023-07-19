<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：分割支払計算
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/sisyoukai/sibunkatusiharaikeisan/SiBunkatuSiharaiKeisan.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- baseInfo --%>
        <swak:group id="baseInfo">
          <swak:item id="syono" />
        </swak:group>

        <%-- ●外貨管理部分（分割前） --%>
        <swak:group id="gaikakanriBnkatuMae">
          <swak:item id="bnktmaegaikagoukei" />
          <swak:item id="bnktmaehokenkngkgoukei" />
          <swak:item id="mikeikapgaitoukkn" />
          <swak:item id="bnktmaemikeikap" />
          <swak:item id="misyuupgaitoukkn" />
          <swak:item id="bnktmaemisyuup" />
          <swak:item id="bnktmaeznnusisnkgk" />
          <swak:item id="bnkatmaezitkazkrknstituka" />
        </swak:group>

        <%-- ●円貨管理部分（分割前） --%>
        <swak:group id="yenkanriBnkatuMae">
          <swak:item id="bnktmaeyengoukei" />
          <swak:item id="bnktmaeyenhknkngkguki" />
          <swak:item id="bnktmaeyenhaitoukin" />
          <swak:item id="bnktmaeyensonotahaitoukin" />
          <swak:item id="yenkamikeikapgaitoukkn" />
          <swak:item id="bnktmaeyenmikeikap" />
          <swak:item id="yenkamisyuupgaitoukkn" />
          <swak:item id="bnktmaeyenmisyuup" />
          <swak:item id="bnktmaeyenznnusisnkgk" />
          <swak:item id="bnktmaezitkazkrknyen" />
          <swak:item id="bnktmaeyenkrkgk" />
        </swak:group>

        <%-- ●受取人設定 --%>
        <swak:group id="uktrSettei">
          <swak:item id="sbuktninmoji" />
          <swak:item id="bunkatuhouhoukbn" />
          <swak:item id="shrtaisyouuktrjuni" />
        </swak:group>

        <%-- ●受取人情報 --%>
        <swak:dataTable id="uktrInfo">
          <swak:column id="shrtaisyou" />
          <swak:column id="uktrjuni" />
          <swak:column id="uktrwraibunsi" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo" />
          <swak:column id="bnktsbuktnmkj" />
        </swak:dataTable>

        <%-- ●分割計算結果１ --%>
        <swak:dataTable id="bunkatuKeisanKekka1">
          <swak:column id="shrtaisyou1" />
          <swak:column id="uktrjuni1" />
          <swak:column id="uktrwraibunsi1" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo1" />
          <swak:column id="bnktsbuktnmkj1" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka1 --%>
        <swak:group id="gkbunkatuKeisanKekka1">
          <swak:item id="gaikaknrgoukei1" />
          <swak:item id="hokenkngkgoukei1" />
          <swak:item id="mikeikap1" />
          <swak:item id="misyuup1" />
          <swak:item id="znnusisnkgk1" />
          <swak:item id="zitkazkrknstituka1" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka1 --%>
        <swak:group id="yenbunkatuKeisanKekka1">
          <swak:item id="yenkaknrgoukei1" />
          <swak:item id="yenhknkngkguki1" />
          <swak:item id="yenhaitoukin1" />
          <swak:item id="yensonotahaitoukin1" />
          <swak:item id="yenmikeikap1" />
          <swak:item id="yenmisyuup1" />
          <swak:item id="yenznnusisnkgk1" />
          <swak:item id="zitkazkrknyen1" />
          <swak:item id="yenkrkgk1" />
        </swak:group>

        <%-- ●分割計算結果２ --%>
        <swak:dataTable id="bunkatuKeisanKekka2">
          <swak:column id="shrtaisyou2" />
          <swak:column id="uktrjuni2" />
          <swak:column id="uktrwraibunsi2" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo2" />
          <swak:column id="bnktsbuktnmkj2" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka2 --%>
        <swak:group id="gkbunkatuKeisanKekka2">
          <swak:item id="gaikaknrgoukei2" />
          <swak:item id="hokenkngkgoukei2" />
          <swak:item id="mikeikap2" />
          <swak:item id="misyuup2" />
          <swak:item id="znnusisnkgk2" />
          <swak:item id="zitkazkrknstituka2" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka2 --%>
        <swak:group id="yenbunkatuKeisanKekka2">
          <swak:item id="yenkaknrgoukei2" />
          <swak:item id="yenhknkngkguki2" />
          <swak:item id="yenhaitoukin2" />
          <swak:item id="yensonotahaitoukin2" />
          <swak:item id="yenmikeikap2" />
          <swak:item id="yenmisyuup2" />
          <swak:item id="yenznnusisnkgk2" />
          <swak:item id="zitkazkrknyen2" />
          <swak:item id="yenkrkgk2" />
        </swak:group>

        <%-- ●分割計算結果３ --%>
        <swak:dataTable id="bunkatuKeisanKekka3">
          <swak:column id="shrtaisyou3" />
          <swak:column id="uktrjuni3" />
          <swak:column id="uktrwraibunsi3" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo3" />
          <swak:column id="bnktsbuktnmkj3" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka3 --%>
        <swak:group id="gkbunkatuKeisanKekka3">
          <swak:item id="gaikaknrgoukei3" />
          <swak:item id="hokenkngkgoukei3" />
          <swak:item id="mikeikap3" />
          <swak:item id="misyuup3" />
          <swak:item id="znnusisnkgk3" />
          <swak:item id="zitkazkrknstituka3" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka3 --%>
        <swak:group id="yenbunkatuKeisanKekka3">
          <swak:item id="yenkaknrgoukei3" />
          <swak:item id="yenhknkngkguki3" />
          <swak:item id="yenhaitoukin3" />
          <swak:item id="yensonotahaitoukin3" />
          <swak:item id="yenmikeikap3" />
          <swak:item id="yenmisyuup3" />
          <swak:item id="yenznnusisnkgk3" />
          <swak:item id="zitkazkrknyen3" />
          <swak:item id="yenkrkgk3" />
        </swak:group>

        <%-- ●分割計算結果４ --%>
        <swak:dataTable id="bunkatuKeisanKekka4">
          <swak:column id="shrtaisyou4" />
          <swak:column id="uktrjuni4" />
          <swak:column id="uktrwraibunsi4" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo4" />
          <swak:column id="bnktsbuktnmkj4" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka4 --%>
        <swak:group id="gkbunkatuKeisanKekka4">
          <swak:item id="gaikaknrgoukei4" />
          <swak:item id="hokenkngkgoukei4" />
          <swak:item id="mikeikap4" />
          <swak:item id="misyuup4" />
          <swak:item id="znnusisnkgk4" />
          <swak:item id="zitkazkrknstituka4" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka4 --%>
        <swak:group id="yenbunkatuKeisanKekka4">
          <swak:item id="yenkaknrgoukei4" />
          <swak:item id="yenhknkngkguki4" />
          <swak:item id="yenhaitoukin4" />
          <swak:item id="yensonotahaitoukin4" />
          <swak:item id="yenmikeikap4" />
          <swak:item id="yenmisyuup4" />
          <swak:item id="yenznnusisnkgk4" />
          <swak:item id="zitkazkrknyen4" />
          <swak:item id="yenkrkgk4" />
        </swak:group>

        <%-- ●分割計算結果５ --%>
        <swak:dataTable id="bunkatuKeisanKekka5">
          <swak:column id="shrtaisyou5" />
          <swak:column id="uktrjuni5" />
          <swak:column id="uktrwraibunsi5" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo5" />
          <swak:column id="bnktsbuktnmkj5" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka5 --%>
        <swak:group id="gkbunkatuKeisanKekka5">
          <swak:item id="gaikaknrgoukei5" />
          <swak:item id="hokenkngkgoukei5" />
          <swak:item id="mikeikap5" />
          <swak:item id="misyuup5" />
          <swak:item id="znnusisnkgk5" />
          <swak:item id="zitkazkrknstituka5" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka5 --%>
        <swak:group id="yenbunkatuKeisanKekka5">
          <swak:item id="yenkaknrgoukei5" />
          <swak:item id="yenhknkngkguki5" />
          <swak:item id="yenhaitoukin5" />
          <swak:item id="yensonotahaitoukin5" />
          <swak:item id="yenmikeikap5" />
          <swak:item id="yenmisyuup5" />
          <swak:item id="yenznnusisnkgk5" />
          <swak:item id="zitkazkrknyen5" />
          <swak:item id="yenkrkgk5" />
        </swak:group>

        <%-- ●分割計算結果６ --%>
        <swak:dataTable id="bunkatuKeisanKekka6">
          <swak:column id="shrtaisyou6" />
          <swak:column id="uktrjuni6" />
          <swak:column id="uktrwraibunsi6" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo6" />
          <swak:column id="bnktsbuktnmkj6" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka6 --%>
        <swak:group id="gkbunkatuKeisanKekka6">
          <swak:item id="gaikaknrgoukei6" />
          <swak:item id="hokenkngkgoukei6" />
          <swak:item id="mikeikap6" />
          <swak:item id="misyuup6" />
          <swak:item id="znnusisnkgk6" />
          <swak:item id="zitkazkrknstituka6" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka6 --%>
        <swak:group id="yenbunkatuKeisanKekka6">
          <swak:item id="yenkaknrgoukei6" />
          <swak:item id="yenhknkngkguki6" />
          <swak:item id="yenhaitoukin6" />
          <swak:item id="yensonotahaitoukin6" />
          <swak:item id="yenmikeikap6" />
          <swak:item id="yenmisyuup6" />
          <swak:item id="yenznnusisnkgk6" />
          <swak:item id="zitkazkrknyen6" />
          <swak:item id="yenkrkgk6" />
        </swak:group>

        <%-- ●分割計算結果７ --%>
        <swak:dataTable id="bunkatuKeisanKekka7">
          <swak:column id="shrtaisyou7" />
          <swak:column id="uktrjuni7" />
          <swak:column id="uktrwraibunsi7" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo7" />
          <swak:column id="bnktsbuktnmkj7" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka7 --%>
        <swak:group id="gkbunkatuKeisanKekka7">
          <swak:item id="gaikaknrgoukei7" />
          <swak:item id="hokenkngkgoukei7" />
          <swak:item id="mikeikap7" />
          <swak:item id="misyuup7" />
          <swak:item id="znnusisnkgk7" />
          <swak:item id="zitkazkrknstituka7" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka7 --%>
        <swak:group id="yenbunkatuKeisanKekka7">
          <swak:item id="yenkaknrgoukei7" />
          <swak:item id="yenhknkngkguki7" />
          <swak:item id="yenhaitoukin7" />
          <swak:item id="yensonotahaitoukin7" />
          <swak:item id="yenmikeikap7" />
          <swak:item id="yenmisyuup7" />
          <swak:item id="yenznnusisnkgk7" />
          <swak:item id="zitkazkrknyen7" />
          <swak:item id="yenkrkgk7" />
        </swak:group>

        <%-- ●分割計算結果８ --%>
        <swak:dataTable id="bunkatuKeisanKekka8">
          <swak:column id="shrtaisyou8" />
          <swak:column id="uktrjuni8" />
          <swak:column id="uktrwraibunsi8" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo8" />
          <swak:column id="bnktsbuktnmkj8" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka8 --%>
        <swak:group id="gkbunkatuKeisanKekka8">
          <swak:item id="gaikaknrgoukei8" />
          <swak:item id="hokenkngkgoukei8" />
          <swak:item id="mikeikap8" />
          <swak:item id="misyuup8" />
          <swak:item id="znnusisnkgk8" />
          <swak:item id="zitkazkrknstituka8" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka8 --%>
        <swak:group id="yenbunkatuKeisanKekka8">
          <swak:item id="yenkaknrgoukei8" />
          <swak:item id="yenhknkngkguki8" />
          <swak:item id="yenhaitoukin8" />
          <swak:item id="yensonotahaitoukin8" />
          <swak:item id="yenmikeikap8" />
          <swak:item id="yenmisyuup8" />
          <swak:item id="yenznnusisnkgk8" />
          <swak:item id="zitkazkrknyen8" />
          <swak:item id="yenkrkgk8" />
        </swak:group>

        <%-- ●分割計算結果９ --%>
        <swak:dataTable id="bunkatuKeisanKekka9">
          <swak:column id="shrtaisyou9" />
          <swak:column id="uktrjuni9" />
          <swak:column id="uktrwraibunsi9" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo9" />
          <swak:column id="bnktsbuktnmkj9" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka9 --%>
        <swak:group id="gkbunkatuKeisanKekka9">
          <swak:item id="gaikaknrgoukei9" />
          <swak:item id="hokenkngkgoukei9" />
          <swak:item id="mikeikap9" />
          <swak:item id="misyuup9" />
          <swak:item id="znnusisnkgk9" />
          <swak:item id="zitkazkrknstituka9" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka9 --%>
        <swak:group id="yenbunkatuKeisanKekka9">
          <swak:item id="yenkaknrgoukei9" />
          <swak:item id="yenhknkngkguki9" />
          <swak:item id="yenhaitoukin9" />
          <swak:item id="yensonotahaitoukin9" />
          <swak:item id="yenmikeikap9" />
          <swak:item id="yenmisyuup9" />
          <swak:item id="yenznnusisnkgk9" />
          <swak:item id="zitkazkrknyen9" />
          <swak:item id="yenkrkgk9" />
        </swak:group>

        <%-- ●分割計算結果１０ --%>
        <swak:dataTable id="bunkatuKeisanKekka10">
          <swak:column id="shrtaisyou10" />
          <swak:column id="uktrjuni10" />
          <swak:column id="uktrwraibunsi10" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo10" />
          <swak:column id="bnktsbuktnmkj10" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka10 --%>
        <swak:group id="gkbunkatuKeisanKekka10">
          <swak:item id="gaikaknrgoukei10" />
          <swak:item id="hokenkngkgoukei10" />
          <swak:item id="mikeikap10" />
          <swak:item id="misyuup10" />
          <swak:item id="znnusisnkgk10" />
          <swak:item id="zitkazkrknstituka10" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka10 --%>
        <swak:group id="yenbunkatuKeisanKekka10">
          <swak:item id="yenkaknrgoukei10" />
          <swak:item id="yenhknkngkguki10" />
          <swak:item id="yenhaitoukin10" />
          <swak:item id="yensonotahaitoukin10" />
          <swak:item id="yenmikeikap10" />
          <swak:item id="yenmisyuup10" />
          <swak:item id="yenznnusisnkgk10" />
          <swak:item id="zitkazkrknyen10" />
          <swak:item id="yenkrkgk10" />
        </swak:group>

        <%-- ●分割計算結果１１ --%>
        <swak:dataTable id="bunkatuKeisanKekka11">
          <swak:column id="shrtaisyou11" />
          <swak:column id="uktrjuni11" />
          <swak:column id="uktrwraibunsi11" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo11" />
          <swak:column id="bnktsbuktnmkj11" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka11 --%>
        <swak:group id="gkbunkatuKeisanKekka11">
          <swak:item id="gaikaknrgoukei11" />
          <swak:item id="hokenkngkgoukei11" />
          <swak:item id="mikeikap11" />
          <swak:item id="misyuup11" />
          <swak:item id="znnusisnkgk11" />
          <swak:item id="zitkazkrknstituka11" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka11 --%>
        <swak:group id="yenbunkatuKeisanKekka11">
          <swak:item id="yenkaknrgoukei11" />
          <swak:item id="yenhknkngkguki11" />
          <swak:item id="yenhaitoukin11" />
          <swak:item id="yensonotahaitoukin11" />
          <swak:item id="yenmikeikap11" />
          <swak:item id="yenmisyuup11" />
          <swak:item id="yenznnusisnkgk11" />
          <swak:item id="zitkazkrknyen11" />
          <swak:item id="yenkrkgk11" />
        </swak:group>

        <%-- ●分割計算結果１２ --%>
        <swak:dataTable id="bunkatuKeisanKekka12">
          <swak:column id="shrtaisyou12" />
          <swak:column id="uktrjuni12" />
          <swak:column id="uktrwraibunsi12" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo12" />
          <swak:column id="bnktsbuktnmkj12" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka12 --%>
        <swak:group id="gkbunkatuKeisanKekka12">
          <swak:item id="gaikaknrgoukei12" />
          <swak:item id="hokenkngkgoukei12" />
          <swak:item id="mikeikap12" />
          <swak:item id="misyuup12" />
          <swak:item id="znnusisnkgk12" />
          <swak:item id="zitkazkrknstituka12" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka12 --%>
        <swak:group id="yenbunkatuKeisanKekka12">
          <swak:item id="yenkaknrgoukei12" />
          <swak:item id="yenhknkngkguki12" />
          <swak:item id="yenhaitoukin12" />
          <swak:item id="yensonotahaitoukin12" />
          <swak:item id="yenmikeikap12" />
          <swak:item id="yenmisyuup12" />
          <swak:item id="yenznnusisnkgk12" />
          <swak:item id="zitkazkrknyen12" />
          <swak:item id="yenkrkgk12" />
        </swak:group>

        <%-- ●分割計算結果１３ --%>
        <swak:dataTable id="bunkatuKeisanKekka13">
          <swak:column id="shrtaisyou13" />
          <swak:column id="uktrjuni13" />
          <swak:column id="uktrwraibunsi13" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo13" />
          <swak:column id="bnktsbuktnmkj13" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka13 --%>
        <swak:group id="gkbunkatuKeisanKekka13">
          <swak:item id="gaikaknrgoukei13" />
          <swak:item id="hokenkngkgoukei13" />
          <swak:item id="mikeikap13" />
          <swak:item id="misyuup13" />
          <swak:item id="znnusisnkgk13" />
          <swak:item id="zitkazkrknstituka13" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka13 --%>
        <swak:group id="yenbunkatuKeisanKekka13">
          <swak:item id="yenkaknrgoukei13" />
          <swak:item id="yenhknkngkguki13" />
          <swak:item id="yenhaitoukin13" />
          <swak:item id="yensonotahaitoukin13" />
          <swak:item id="yenmikeikap13" />
          <swak:item id="yenmisyuup13" />
          <swak:item id="yenznnusisnkgk13" />
          <swak:item id="zitkazkrknyen13" />
          <swak:item id="yenkrkgk13" />
        </swak:group>

        <%-- ●分割計算結果１４ --%>
        <swak:dataTable id="bunkatuKeisanKekka14">
          <swak:column id="shrtaisyou14" />
          <swak:column id="uktrjuni14" />
          <swak:column id="uktrwraibunsi14" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo14" />
          <swak:column id="bnktsbuktnmkj14" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka14 --%>
        <swak:group id="gkbunkatuKeisanKekka14">
          <swak:item id="gaikaknrgoukei14" />
          <swak:item id="hokenkngkgoukei14" />
          <swak:item id="mikeikap14" />
          <swak:item id="misyuup14" />
          <swak:item id="znnusisnkgk14" />
          <swak:item id="zitkazkrknstituka14" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka14 --%>
        <swak:group id="yenbunkatuKeisanKekka14">
          <swak:item id="yenkaknrgoukei14" />
          <swak:item id="yenhknkngkguki14" />
          <swak:item id="yenhaitoukin14" />
          <swak:item id="yensonotahaitoukin14" />
          <swak:item id="yenmikeikap14" />
          <swak:item id="yenmisyuup14" />
          <swak:item id="yenznnusisnkgk14" />
          <swak:item id="zitkazkrknyen14" />
          <swak:item id="yenkrkgk14" />
        </swak:group>

        <%-- ●分割計算結果１５ --%>
        <swak:dataTable id="bunkatuKeisanKekka15">
          <swak:column id="shrtaisyou15" />
          <swak:column id="uktrjuni15" />
          <swak:column id="uktrwraibunsi15" />
          <swak:column id="IBC1028" />
          <swak:column id="uktrwraibunbo15" />
          <swak:column id="bnktsbuktnmkj15" />
        </swak:dataTable>

        <%-- gkbunkatuKeisanKekka15 --%>
        <swak:group id="gkbunkatuKeisanKekka15">
          <swak:item id="gaikaknrgoukei15" />
          <swak:item id="hokenkngkgoukei15" />
          <swak:item id="mikeikap15" />
          <swak:item id="misyuup15" />
          <swak:item id="znnusisnkgk15" />
          <swak:item id="zitkazkrknstituka15" />
        </swak:group>

        <%-- yenbunkatuKeisanKekka15 --%>
        <swak:group id="yenbunkatuKeisanKekka15">
          <swak:item id="yenkaknrgoukei15" />
          <swak:item id="yenhknkngkguki15" />
          <swak:item id="yenhaitoukin15" />
          <swak:item id="yensonotahaitoukin15" />
          <swak:item id="yenmikeikap15" />
          <swak:item id="yenmisyuup15" />
          <swak:item id="yenznnusisnkgk15" />
          <swak:item id="zitkazkrknyen15" />
          <swak:item id="yenkrkgk15" />
        </swak:group>

        <%-- ●支払情報 --%>
        <swak:group id="shrInfomation">
          <swak:item id="syoruiukeymd" />
          <swak:item id="IJC1057" />
          <swak:item id="siharaituukakbn" />
          <swak:item id="shrymd" />
          <swak:item id="IJC1056" />
          <swak:item id="shrkwsratekjnymd" />
          <swak:item id="shrkwsrate" />
          <swak:item id="gaikaknsnkwsratekjymd" />
          <swak:item id="gaikaknsnkwsrate" />
        </swak:group>

        <%-- ●外貨支払金額（分割後） --%>
        <swak:group id="gaikakanriBnkatuGo">
          <swak:item id="bnktgogaikagoukei" />
          <swak:item id="bnktgogaikaknsntkgk" />
          <swak:item id="bnktgohokenkngkgoukei" />
          <swak:item id="bnktgomikeikap" />
          <swak:item id="bnktgomisyuup" />
          <swak:item id="bnktgoznnusisnkgk" />
          <swak:item id="bnktgozitkazkrknstituka" />
          <swak:item id="tienrisokukisanymd" />
          <swak:item id="tienrsknissuu" />
          <swak:item id="shrtienrsk" />
        </swak:group>

        <%-- ●円貨支払金額（分割後） --%>
        <swak:group id="yenkanriBnkatuGo">
          <swak:item id="bnktgoyengoukei" />
          <swak:item id="bnktgoyenkaknsntkgk" />
          <swak:item id="bnktgoyenhknkngkguki" />
          <swak:item id="bnktgoyenhaitoukin" />
          <swak:item id="bnktgoyensonotahaitoukin" />
          <swak:item id="bnktgoyenmikeikap" />
          <swak:item id="bnktgoyenmisyuup" />
          <swak:item id="bnktgoyenznnusisnkgk" />
          <swak:item id="bnktgozitkazkrknyen" />
          <swak:item id="bnktgoyenkrkgk" />
          <swak:item id="yentienrisokukisanymd" />
          <swak:item id="yentienrsknissuu" />
          <swak:item id="yenshrtienrsk" />
        </swak:group>

        <%-- ●支払明細書送付先住所 --%>
        <swak:group id="shskjuusyo">
          <swak:item id="tsinyno" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="ketteiBtn" />
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
          <swak:item id="naiyounyuuryokugamenheBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
