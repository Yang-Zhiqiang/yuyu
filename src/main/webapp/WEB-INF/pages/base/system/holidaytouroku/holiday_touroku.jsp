<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：休日登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/holidaytouroku/HolidayTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:dataTable id="keyInfo">
          <swak:column id="holidayGroupCd" />
          <swak:column id="holidayGroupNm" />
          <swak:column id="holidayGroupDescription" />
        </swak:dataTable>

        <%-- holidayGroupInfo --%>
        <swak:group id="holidayGroupInfo">
          <swak:item id="holidayGroup.holidayGroupCd" />
          <swak:item id="holidayGroup.holidayGroupNm" />
          <swak:item id="holidayGroup.holidayGroupDescription" />
        </swak:group>

        <%-- holidayPattern --%>
        <swak:group id="holidayPattern">
          <swak:item id="holidayYoyaku.holidayPatternNm" />
          <swak:item id="holidayYoyaku.holidayPattern" />
        </swak:group>

        <%-- buttonSelect --%>
        <swak:buttonGroup id="buttonSelect">
          <swak:item id="tourokuBtn" />
        </swak:buttonGroup>

        <%-- holidayPatternInfo --%>
        <swak:dataTable id="holidayPatternInfo">
          <swak:column id="holidayPatternNm" />
          <swak:column id="holidayPattern" />
          <swak:column id="tekiyouYmdFrom" />
          <swak:column id="tekiyouYmdTo" />
          <swak:column id="legalHolidayKbn" />
          <swak:column id="yoyakuKbn" />
          <swak:column id="henkouLink" />
          <swak:column id="sakujyoLink" />
        </swak:dataTable>
        <swak:pager id="holidayPatternInfoDataSource" />

        <%-- holidayPatternInfoInput --%>
        <swak:group id="holidayPatternInfoInput">
          <swak:item id="holidayYoyaku.tekiyouYmdFrom" />
          <swak:item id="holidayYoyaku.tekiyouYmdTo" />
          <swak:item id="holidayGroupCd" />
          <swak:item id="holidayYmd" />
          <swak:item id="holidayMd" />
          <swak:item id="holidayM" />
          <swak:item id="holidayNth" />
          <swak:item id="holidaySiteiYoubi" />
          <swak:item id="holidayYoubi" />
          <swak:item id="holidayYoyaku.legalHolidayKbn" />
          <swak:item id="holidayYoyaku.holidayPatternDescription" />
        </swak:group>

        <%-- buttonInputContents --%>
        <swak:buttonGroup id="buttonInputContents">
          <swak:item id="modoruBtnBySelectKey" />
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
