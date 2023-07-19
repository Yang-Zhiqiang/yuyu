<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：機能定義登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/kinouteigitouroku/KinouTeigiTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="subSystemId" />
        </swak:group>

        <%-- buttonSelect --%>
        <swak:buttonGroup id="buttonSelect">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- kinouModeInfoInputContents --%>
        <swak:group id="kinouModeInfoInputContents">
          <swak:item id="subSystem.subSystemNm" />
          <swak:item id="category.categoryNm" />
          <swak:item id="kinou.kinouNm" />
          <swak:item id="kinouMode.kinouModeNm" />
        </swak:group>

        <%-- ● システム設定 --%>
        <swak:group id="systemSetteiInfo">
          <swak:item id="kinouMode.yuukouKbn" />
          <swak:item id="kinouMode.yuukouKaisiYmd" />
          <swak:item id="kinouMode.kadouTimeGroupCd" />
        </swak:group>

        <%-- ● 権限設定 --%>
        <swak:dataTable id="kengenSetteiList">
          <swak:column id="commonCheckBox" />
          <swak:column id="roleNm" />
          <swak:column id="roleSetumei" />
          <swak:column id="siborikomiId" />
        </swak:dataTable>

        <%-- buttonCheck --%>
        <swak:buttonGroup id="buttonCheck">
          <swak:item id="allCheckBtn" />
          <swak:item id="allUnCheckBtn" />
        </swak:buttonGroup>

        <%-- ● 反映区分 --%>
        <swak:group id="haneiKbnInfo">
          <swak:item id="kousinNaiyouHaneiKbn" />
        </swak:group>

        <%-- ● 機能一覧 --%>
        <swak:dataTable id="kinouModeInfoList">
          <swak:column id="subSystemNm" />
          <swak:column id="categoryNm" />
          <swak:column id="kinouNm" />
          <swak:column id="kinouModeNm" />
          <swak:column id="henkouLink" />
        </swak:dataTable>

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
