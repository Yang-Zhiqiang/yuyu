<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：新契約不備解消
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/skhubikanri/skhubikaisyou/SkHubiKaisyou.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- buttonMosJkSyoukai --%>
        <swak:buttonGroup id="buttonMosJkSyoukai">
          <swak:item id="mosjksyoukaibtn" />
        </swak:buttonGroup>

        <%-- ●工程情報 --%>
        <swak:group id="kouteiInfo">
          <swak:item id="vktifdispjimutetuzukinm" />
          <swak:item id="vktifdisptasknm" />
        </swak:group>

        <%-- ●基本情報 --%>
        <swak:group id="baseInfo">
          <swak:item id="mosno" />
          <swak:item id="currenttsknm" />
        </swak:group>

        <%-- itiranInfo --%>
        <swak:dataTable id="itiranInfo">
          <swak:column id="jimutetuzukinm" />
          <swak:column id="jimustartymd" />
          <swak:column id="nyuuryokuLink" />
        </swak:dataTable>

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

        <%-- ●取扱注意情報 --%>
        <swak:dataTable id="toriatukaiTyuuiInfo">
          <swak:column id="dispskeittdktyuitrttrkymd" />
          <swak:column id="dispskeittdktyuitrtnaiyo" />
          <swak:column id="dispskeittdktyuitrttantou" />
        </swak:dataTable>

        <%-- ●不備一覧 --%>
        <swak:dataTable id="hubiList">
          <swak:column id="dispkaisyoutaisyou" />
          <swak:column id="dispkaisyoutaisyoukbn" />
          <swak:column id="disptrkymd" />
          <swak:column id="dispskhubikoumoku" />
          <swak:column id="disphassinymd" />
          <swak:column id="dispkaisyouymd" />
          <swak:column id="disphassinsakikbn" />
          <swak:column id="dispnyuryokutantounm" />
          <swak:column id="dispskhubinaiyou" />
          <swak:column id="dispskseibisijinaiyou" />
          <swak:column id="dispskrenrakujikou" />
        </swak:dataTable>

        <%-- ●コメント --%>
        <swak:group id="comment">
          <swak:item id="commentarea" />
        </swak:group>

        <%-- ●申込点検転送 --%>
        <swak:group id="mosTenkenTensou">
          <swak:item id="mostenkenkekkakbn" />
          <swak:item id="mostenkentnsketsyacd" />
          <swak:item id="mostentnsketsyanm" />
          <swak:item id="mostenkencommentgamen" />
        </swak:group>

        <%-- ●環境査定転送 --%>
        <swak:group id="kankyouSateiTensou">
          <swak:item id="knksateisateikekka" />
          <swak:item id="knktnsketsyacd" />
          <swak:item id="knktnsketsyanm" />
          <swak:item id="knksateicommentgamen" />
        </swak:group>

        <%-- ●医務査定転送 --%>
        <swak:group id="imuSateiTensou">
          <swak:item id="imusateisateikekka" />
          <swak:item id="imutnsketsyacd" />
          <swak:item id="imutnsketsyanm" />
          <swak:item id="imusateicommentgamen" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="kakuteibtnbyinputkey" />
          <swak:item id="modorubtnbyitiransentaku" />
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteibtnbyconfirm" />
          <swak:item id="syokigamenheBtn" />
          <swak:item id="syokigamenhebtnbyworkflow" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
