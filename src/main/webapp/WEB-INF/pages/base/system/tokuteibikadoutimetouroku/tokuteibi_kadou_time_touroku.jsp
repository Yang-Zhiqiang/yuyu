<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：特定日稼働時間登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/tokuteibikadoutimetouroku/TokuteibiKadouTimeTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="tokuteibiKadouTime.kadouTimeSiteiYmd" />
        </swak:group>

        <%-- kadouTimeGroupList --%>
        <swak:dataTable id="kadouTimeGroupList">
          <swak:column id="commonCheckBox" />
          <swak:column id="kadouTimeGroupCd" />
          <swak:column id="kadouTimeGroupNm" />
          <swak:column id="kadouTimeGroupDescription" />
        </swak:dataTable>

        <%-- buttonInputKey --%>
        <swak:buttonGroup id="buttonInputKey">
          <swak:item id="tourokuBtn" />
        </swak:buttonGroup>

        <%-- tokuteibiKadouTimeSelectList --%>
        <swak:dataTable id="tokuteibiKadouTimeSelectList">
          <swak:column id="kadouTimeGroupCd" />
          <swak:column id="kadouTimeGroupNm" />
          <swak:column id="kadouTimeSiteiYmd" />
          <swak:column id="kadouTimeDisp" />
          <swak:column id="henkouLink" />
          <swak:column id="sakujyoLink" />
        </swak:dataTable>
        <swak:pager id="tokuteibiKadouTimeSelectListDataSource" />

        <%-- tokuteibiKadouTimeInfo --%>
        <swak:group id="tokuteibiKadouTimeInfo">
          <swak:item id="tokuteibiKadouTime.kadouTimeSiteiKbn" />
          <swak:item id="tokuteibiKadouTime.kadouTimeFrom1" />
          <swak:item id="tokuteibiKadouTime.kadouTimeTo1" />
          <swak:item id="tokuteibiKadouTime.kadouTimeFrom2" />
          <swak:item id="tokuteibiKadouTime.kadouTimeTo2" />
          <swak:item id="tokuteibiKadouTime.kadouTimeFrom3" />
          <swak:item id="tokuteibiKadouTime.kadouTimeTo3" />
          <swak:item id="tokuteibiKadouTime.kadouTimeFrom4" />
          <swak:item id="tokuteibiKadouTime.kadouTimeTo4" />
          <swak:item id="tokuteibiKadouTime.kadouTimeFrom5" />
          <swak:item id="tokuteibiKadouTime.kadouTimeTo5" />
        </swak:group>

        <%-- buttonInputContents --%>
        <swak:buttonGroup id="buttonInputContents">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuninBtn" />
          <swak:item id="kakuteiBtn" />
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
