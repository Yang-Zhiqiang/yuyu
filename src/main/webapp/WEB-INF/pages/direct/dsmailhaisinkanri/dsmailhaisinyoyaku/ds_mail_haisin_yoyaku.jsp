<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ＤＳメール配信予約
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/direct/dsmailhaisinkanri/dsmailhaisinyoyaku/DsMailHaisinYoyaku.do">

        <%-- headerButton --%>
        <swak:buttonGroup id="headerButton">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●送信メール検索 --%>
        <swak:group id="dssousinMailKensaku">
          <swak:item id="srchdssousinmailsyubetukbn" />
          <swak:item id="srchdshaisinyoteiymdfrom" />
          <swak:item id="IAW0003" />
          <swak:item id="srchdshaisinyoteiymdto" />
          <swak:item id="srchdshaisinyoyakustatuskbn" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="searchBtn" />
          <swak:item id="yoyakutourokubtn" />
        </swak:buttonGroup>

        <%-- searchResultInfo --%>
        <swak:dataTable id="searchResultInfo">
          <swak:column id="dsmailhaisinyoteiymd" />
          <swak:column id="dssousinmailsyubetukbn" />
          <swak:column id="dshaisinyoyakustatuskbn" />
          <swak:column id="syouninlink" />
          <swak:column id="sakujyoLink" />
          <swak:column id="gyoumuKousinTime" />
          <swak:column id="kostime" />
          <swak:column id="dsmailhaisintourokuymd" />
          <swak:column id="dsmailhaisinsyouninymd" />
        </swak:dataTable>
        <swak:pager id="searchResultInfoDataSource" />

        <%-- ●送信メール内容 --%>
        <swak:group id="sousinMailNaiyou">
          <swak:item id="dsmailhaisinyoteiymd" />
          <swak:item id="dssousinmailsyubetukbn" />
          <swak:item id="dsspiralsequencehsnset" />
          <swak:item id="IMF1010" />
          <swak:item id="dsspiralsequencehsnsetkbn" />
        </swak:group>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
