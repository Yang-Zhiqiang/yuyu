<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：（死亡）請求受付
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/siharai/siskuke/siseikyuuuketukesb/SiSeikyuuUketukeSb.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
          <swak:item id="tojiruBtnByPopup" />
        </swak:buttonGroup>

        <%-- hkngksisanButtons --%>
        <swak:buttonGroup id="hkngksisanButtons">
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
          <swak:item id="saisateikbn" />
          <swak:item id="kouteikanriid" />
        </swak:group>

        <%-- ●書類受付日 --%>
        <swak:group id="syoruiukeymdInfo">
          <swak:item id="syoruiukeymd" />
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
          <swak:item id="dispbanknmkj" />
          <swak:item id="IJC1050" />
          <swak:item id="dispsitennmkj" />
          <swak:item id="IJC1051" />
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

        <%-- ●コメント --%>
        <swak:group id="comment">
          <swak:item id="syanaicomment" />
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
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="syoukaibtnhihyouji" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
