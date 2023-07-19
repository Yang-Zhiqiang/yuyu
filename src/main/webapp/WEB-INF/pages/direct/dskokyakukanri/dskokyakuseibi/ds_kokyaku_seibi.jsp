<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：顧客整備
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/direct/dskokyakukanri/dskokyakuseibi/DsKokyakuSeibi.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- srchdskoknoInfo --%>
        <swak:group id="srchdskoknoInfo">
          <swak:item id="srchdskokno" />
        </swak:group>

        <%-- srchsyonoInfo --%>
        <swak:group id="srchsyonoInfo">
          <swak:item id="srchsyono" />
        </swak:group>

        <%-- ●顧客情報 --%>
        <swak:group id="kokInfo">
          <swak:item id="srchdskokyakunmkj" />
          <swak:item id="srchdskokyakunmkn" />
          <swak:item id="srchdskokyakuseiymd" />
          <swak:item id="srchdskokyakuyno" />
        </swak:group>

        <%-- ●検索条件 --%>
        <swak:group id="searchjyoukenInfo">
          <swak:item id="syoriYmdFrom" />
          <swak:item id="IAW0003" />
          <swak:item id="syoriYmdTo" />
        </swak:group>

        <%-- ●検索条件 --%>
        <swak:group id="searchjyoukenKouzaInfo">
          <swak:item id="srchtktitrhkkzbankcd" />
          <swak:item id="srchtktitrhkkzsitencd" />
          <swak:item id="IBC1002" />
          <swak:item id="srchhaisiymdfrom" />
          <swak:item id="IAW0003" />
          <swak:item id="srchhaisiymdto" />
        </swak:group>

        <%-- headerButtons1 --%>
        <swak:buttonGroup id="headerButtons1">
          <swak:item id="searchbtnbyinputkeyselect" />
          <swak:item id="clearbtnbyinputkeyselect" />
        </swak:buttonGroup>

        <%-- headerButtons2 --%>
        <swak:buttonGroup id="headerButtons2">
          <swak:item id="searchbtnbyseibitssearch" />
          <swak:item id="clearbtnbyseibitssearch" />
        </swak:buttonGroup>

        <%-- headerButtons3 --%>
        <swak:buttonGroup id="headerButtons3">
          <swak:item id="searchbtnbytktitrhkkz" />
          <swak:item id="clearbtnbytktitrhkkz" />
        </swak:buttonGroup>

        <%-- ●検索結果 --%>
        <swak:dataTable id="searchResultInfo">
          <swak:column id="dskokno" />
          <swak:column id="syono" />
          <swak:column id="dskokyakunmkj" />
          <swak:column id="dskokyakuseiymd" />
          <swak:column id="dskokyakujtkbn" />
          <swak:column id="passwordjtkbn" />
          <swak:column id="seibiriyuukbn" />
          <swak:column id="syoriYmd" />
          <swak:column id="syorizumiflg" />
          <swak:column id="dskokyakunmkn" />
          <swak:column id="dskokyakuyno" />
        </swak:dataTable>
        <swak:pager id="searchResultInfoDataSource" />

        <%-- ●検索結果 --%>
        <swak:dataTable id="srchRsltKzInfo">
          <swak:column id="dispbankcd" />
          <swak:column id="dispbanknmkj" />
          <swak:column id="sinsetuymd" />
          <swak:column id="dispkouzano" />
          <swak:column id="dispkyknmkn" />
          <swak:column id="dskokno" />
          <swak:column id="syono" />
          <swak:column id="dispsitencd" />
          <swak:column id="dispsitennmkj" />
          <swak:column id="haisiymd" />
          <swak:column id="dispkzmeiginmkn" />
        </swak:dataTable>
        <swak:pager id="srchRsltKzInfoDataSource" />

        <%-- ●保全情報 --%>
        <swak:group id="hozenInfo">
          <swak:item id="kyknmkj" />
          <swak:item id="kyknmkn" />
          <swak:item id="kykseiymd" />
          <swak:item id="tsinyno" />
          <swak:item id="kyksei" />
          <swak:item id="tsinadr1kj" />
          <swak:item id="tsinadr2kj" />
          <swak:item id="tsinadr3kj" />
          <swak:item id="tsintelno" />
          <swak:item id="dai2tsintelno" />
        </swak:group>

        <%-- ●ＤＳ顧客情報 --%>
        <swak:group id="drctserviceInfo">
          <swak:item id="dskokyakunmkj" />
          <swak:item id="dskokyakunmkn" />
          <swak:item id="dskokyakuseiymd" />
          <swak:item id="dskokyakuyno" />
        </swak:group>

        <%-- ●ＤＳ顧客情報 --%>
        <swak:group id="drctserviceInfo1">
          <swak:item id="inputdskokyakunmkj" />
          <swak:item id="inputdskokyakunmkn" />
          <swak:item id="inputdskokyakuseiymd" />
          <swak:item id="inputdskokyakuyno" />
        </swak:group>

        <%-- ●ＤＳ顧客情報 --%>
        <swak:group id="drctserviceInfo2">
          <swak:item id="kakunindskokyakunmkj" />
          <swak:item id="kakunindskokyakunmkn" />
          <swak:item id="kakunindskokyakuseiymd" />
          <swak:item id="kakunindskokyakuyno" />
        </swak:group>

        <%-- ●ＤＳ顧客状態 --%>
        <swak:group id="dskokyakujtInfo">
          <swak:item id="dskokno" />
          <swak:item id="dskokyakujtkbn" />
          <swak:item id="kakunindskokyakujtkbn" />
          <swak:item id="dskokyakusakuseiymd" />
          <swak:item id="dsteisiriyuukbn" />
          <swak:item id="inputdsteisiriyuukbn" />
          <swak:item id="kakunindsteisiriyuukbn" />
          <swak:item id="dskokyakumukouymd" />
          <swak:item id="kakunindskokyakumukouymd" />
          <swak:item id="dskanyuukeirokbn" />
          <swak:item id="inputdskanyuukeirokbn" />
          <swak:item id="kakunindskanyuukeirokbn" />
        </swak:group>

        <%-- ●仮パスワード --%>
        <swak:group id="krpasswordInfo">
          <swak:item id="krpasswordumukbn" />
          <swak:item id="kakuninkrpasswordumukbn" />
          <swak:item id="dskrhnnkakcdsetkbn" />
          <swak:item id="kakunindskrhnnkakcdsetkbn" />
          <swak:item id="dskrhnnkakcdsetymd" />
          <swak:item id="kakunindskrhnnkakcdsetymd" />
          <swak:item id="dskrhnnkakcdyuukouymd" />
          <swak:item id="kakunindskrhnnkakcdykymd" />
          <swak:item id="dskrhnnkakcdttshjyhsymd" />
          <swak:item id="kakunindskrhnnkakcdttjyymd" />
          <swak:item id="dskrhnnkakcdttyhkbn" />
          <swak:item id="inputdskrhnnkakcdttyhkbn" />
          <swak:item id="kakunindskrhnnkakcdttyhkbn" />
        </swak:group>

        <%-- ●本パスワード --%>
        <swak:group id="honpasswordInfo">
          <swak:item id="honpasswordumukbn" />
          <swak:item id="kakuninhonpasswordumukbn" />
          <swak:item id="dshnnkakcdsetymd" />
          <swak:item id="kakunindshnnkakcdsetymd" />
        </swak:group>

        <%-- ●ログイン情報 --%>
        <swak:group id="loginInfo">
          <swak:item id="syokailoginymd" />
          <swak:item id="dispsyokailogintime" />
          <swak:item id="syokailoginbaitaikbn" />
          <swak:item id="saisinloginymd" />
          <swak:item id="dispsaisinlogintime" />
          <swak:item id="saisinloginbaitaikbn" />
          <swak:item id="dshnnkakcderrorkaisuu" />
          <swak:item id="kakunindshnnkakcderrkaisuu" />
          <swak:item id="dskokyakunmerrorkaisuu" />
          <swak:item id="kakunindskoknmerrkaisuu" />
          <swak:item id="dskokyakuseiymderrorkaisuu" />
          <swak:item id="kakunindskokseiymderrkaisuu" />
          <swak:item id="dskokyakutelnoerrorkaisuu" />
          <swak:item id="kakunindskoktelnoerrkaisuu" />
        </swak:group>

        <%-- ●ＤＳメールアドレス情報 --%>
        <swak:group id="dsmailaddressInfo">
          <swak:item id="dsmailaddressrenban" />
          <swak:item id="dsmailaddress" />
          <swak:item id="inputdsmailaddress" />
          <swak:item id="kakunindsmailaddress" />
          <swak:item id="dsmailsousinjyoutaikbn" />
          <swak:item id="inputdsmailsousinjtkbn" />
          <swak:item id="kakunindsmailsousinjtkbn" />
          <swak:item id="dsmailsousintisrykbn" />
          <swak:item id="inputdsmailsousintisrykbn" />
          <swak:item id="kakunindsmailsousintisrykbn" />
          <swak:item id="dispdskousinymdtime" />
          <swak:item id="kakunindskousinymdtime" />
        </swak:group>

        <%-- ●月次精査 --%>
        <swak:group id="monthjiseisaInfo">
          <swak:item id="seisahuyouhyj" />
          <swak:item id="inputseisahuyouhyj" />
          <swak:item id="kakuninseisahuyouhyj" />
        </swak:group>

        <%-- ●最終更新 --%>
        <swak:group id="lastkosInfo">
          <swak:item id="lastjyuuhenymd" />
          <swak:item id="lastkykmeighnkymd" />
        </swak:group>

        <%-- ●ＤＳ顧客契約 --%>
        <swak:dataTable id="dskokkykInfo">
          <swak:column id="syono" />
          <swak:column id="syusyouhnnm" />
          <swak:column id="dskykkanyuuymd" />
          <swak:column id="dskykhenkouymd" />
          <swak:column id="dskykmukouhyj" />
          <swak:column id="dskykmukouymd" />
        </swak:dataTable>
        <swak:pager id="dskokkykInfoDataSource" />

        <%-- ●基本情報 --%>
        <swak:group id="kihonInfo">
          <swak:item id="kykbtdispsyono" />
          <swak:item id="kykbtdispdskokno" />
          <swak:item id="kykbtdispsyouhnnm" />
        </swak:group>

        <%-- ●保全情報 --%>
        <swak:group id="kykbtHozenInfo">
          <swak:item id="kykbtdispkyknmkj" />
          <swak:item id="kykbtdispkyknmkn" />
          <swak:item id="kykbtdispkykseiymd" />
        </swak:group>

        <%-- ●取引サービス登録状況 --%>
        <swak:group id="trhkServiceTourokuJk">
          <swak:item id="dstrhkserviceriyoujkkbn" />
          <swak:item id="kakunindstrhkserviceryjkkbn" />
          <swak:item id="dstrhkserviceteisiriyuukbn" />
          <swak:item id="inputdstrhksvctisrykbn" />
          <swak:item id="kakunindstrhksvctisrykbn" />
          <swak:item id="dstrhkservicekanyukeirokbn" />
        </swak:group>

        <%-- ●特定取引用口座情報 --%>
        <swak:group id="tokuteiTrhkKouzaInfo">
          <swak:item id="kzsyuruikbn" />
          <swak:item id="bankcd" />
          <swak:item id="banknmkj" />
          <swak:item id="sitencd" />
          <swak:item id="sitennmkj" />
          <swak:item id="yokinkbn" />
          <swak:item id="kouzano" />
          <swak:item id="kzdoukbn" />
          <swak:item id="kzmeiginmkn" />
        </swak:group>

        <%-- ●特定取引用暗証番号情報 --%>
        <swak:group id="tokuteiTrhkAnsyonoInfo">
          <swak:item id="disptokuteitrhkansyono" />
          <swak:item id="tktrhkansyonoerrorkaisuu" />
          <swak:item id="tokuteitrhkansyonosetymd" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="kokseibibtn" />
          <swak:item id="seibitssearchbtn" />
          <swak:item id="searchtktitrhkkzbtn" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="accountlockkaijyobtn" />
          <swak:item id="serviceteisibtn" />
          <swak:item id="servicesaikaibtn" />
          <swak:item id="dskaiyakubtn" />
        </swak:buttonGroup>

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons6 --%>
        <swak:buttonGroup id="footerButtons6">
          <swak:item id="syokigamenhebtnbyresult" />
        </swak:buttonGroup>

        <%-- footerButtons7 --%>
        <swak:buttonGroup id="footerButtons7">
          <swak:item id="modorubtnbykykbtic" />
        </swak:buttonGroup>

        <%-- footerButtons8 --%>
        <swak:buttonGroup id="footerButtons8">
          <swak:item id="trhkserviceteisibtn" />
        </swak:buttonGroup>

        <%-- footerButtons9 --%>
        <swak:buttonGroup id="footerButtons9">
          <swak:item id="modorubtnbykykconfirm" />
          <swak:item id="kakuteibtnbykykconfirm" />
        </swak:buttonGroup>

        <%-- footerButtons10 --%>
        <swak:buttonGroup id="footerButtons10">
          <swak:item id="syokigamenhebtnbykykbtrslt" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
