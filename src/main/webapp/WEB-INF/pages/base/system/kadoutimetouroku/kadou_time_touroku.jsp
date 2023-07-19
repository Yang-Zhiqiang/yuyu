<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：稼働時間登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/kadoutimetouroku/KadouTimeTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:dataTable id="keyInfo">
          <swak:column id="kadouTimeGroupCd" />
          <swak:column id="kadouTimeGroupNm" />
          <swak:column id="kadouTimeGroupDescription" />
        </swak:dataTable>

        <%-- kadouTimeGroupInfo --%>
        <swak:group id="kadouTimeGroupInfo">
          <swak:item id="kadouTimeGroup.kadouTimeGroupCd" />
          <swak:item id="kadouTimeGroup.kadouTimeGroupNm" />
          <swak:item id="holidayGroup.holidayGroupNm" />
          <swak:item id="kadouTimeGroup.kadouTimeGroupDescription" />
        </swak:group>

        <%-- ●営業日 --%>
        <swak:dataTable id="eigyoubiKadouTimeInfo">
          <swak:column id="eigyouKadouTimeYoubiKbn" />
          <swak:column id="kadouTimeSiteiKbn" />
          <swak:column id="eigyouKadouTime" />
          <swak:column id="henkouEigyoubiLink" />
        </swak:dataTable>

        <%-- ●非営業日 --%>
        <swak:dataTable id="hiEigyoubiKadouTimeInfo">
          <swak:column id="hiEigyouKadouTimeYoubiKbn" />
          <swak:column id="kadouTimeSiteiKbn" />
          <swak:column id="hiEigyouKadouTime" />
          <swak:column id="henkouHieigyoubiLink" />
        </swak:dataTable>

        <%-- kadouTimeInfo --%>
        <swak:group id="kadouTimeInfo">
          <swak:item id="kadouTime.kadouTimeYoubiKbn" />
          <swak:item id="kadouTime.eigyoubiKbn" />
          <swak:item id="hyoujunKadouTimeInfo" />
        </swak:group>

        <%-- kadouTimeInfoInput --%>
        <swak:group id="kadouTimeInfoInput">
          <swak:item id="kadouTime.kadouTimeSiteiKbn" />
          <swak:item id="kadouTime.kadouTimeFrom1" />
          <swak:item id="kadouTime.kadouTimeTo1" />
          <swak:item id="kadouTime.kadouTimeFrom2" />
          <swak:item id="kadouTime.kadouTimeTo2" />
          <swak:item id="kadouTime.kadouTimeFrom3" />
          <swak:item id="kadouTime.kadouTimeTo3" />
          <swak:item id="kadouTime.kadouTimeFrom4" />
          <swak:item id="kadouTime.kadouTimeTo4" />
          <swak:item id="kadouTime.kadouTimeFrom5" />
          <swak:item id="kadouTime.kadouTimeTo5" />
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
