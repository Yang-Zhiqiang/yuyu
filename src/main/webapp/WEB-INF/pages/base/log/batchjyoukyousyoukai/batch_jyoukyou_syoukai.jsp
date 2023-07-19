<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：バッチ状況照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/log/batchjyoukyousyoukai/BatchJyoukyouSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
          <swak:item id="tojiruBtnByPopup" />
        </swak:buttonGroup>

        <%-- kousinButtons --%>
        <swak:buttonGroup id="kousinButtons">
          <swak:item id="jidouKousinSuruBtn" />
          <swak:item id="jidouKousinSinaiBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="subSystemId" />
          <swak:item id="syoriYmdFrom" />
          <swak:item id="syoriYmdTo" />
          <swak:item id="batchResultKbn" />
          <swak:item id="batchJyoutai" />
        </swak:group>

        <%-- searchButton --%>
        <swak:buttonGroup id="searchButton">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- batchJobinfo --%>
        <swak:group id="batchJobinfo">
          <swak:item id="subSystemNm" />
          <swak:item id="categoryNm" />
          <swak:item id="kinouNm" />
          <swak:item id="batchJob.batchKidouKbn" />
          <swak:item id="batchJob.batchSyoriYmd" />
          <swak:item id="batchJob.batchStartTime" />
          <swak:item id="batchJob.batchEndTime" />
          <swak:item id="batchJob.batchResultKbn" />
          <swak:item id="batchJob.batchJyoutaiKbn" />
          <swak:item id="userNm" />
        </swak:group>

        <%-- batchJobList --%>
        <swak:dataTable id="batchJobList">
          <swak:column id="subSystemNm" />
          <swak:column id="categoryNm" />
          <swak:column id="kinouNm" />
          <swak:column id="batchKidouKbn" />
          <swak:column id="batchStartTime" />
          <swak:column id="batchEndTime" />
          <swak:column id="batchResultKbn" />
          <swak:column id="batchJyoutaiKbn" />
          <swak:column id="syousaiLink" />
          <swak:column id="tyouhyouSyuturyokuLink" />
        </swak:dataTable>
        <swak:pager id="batchJobListDataSource" />

        <%-- batchLogList --%>
        <swak:dataTable id="batchLogList">
          <swak:column id="logOutputTime" />
          <swak:column id="logLevelKbn" />
          <swak:column id="logNaiyou" />
        </swak:dataTable>
        <swak:pager id="batchLogListDataSource" />

        <%-- fotterButtons --%>
        <swak:buttonGroup id="fotterButtons">
          <swak:item id="kousinBtn" />
          <swak:item id="modoruBtnByGaiyou" />
          <swak:item id="tyuudanBtn" />
          <swak:item id="insatuGamenBtn" />
          <swak:item id="insatuBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
