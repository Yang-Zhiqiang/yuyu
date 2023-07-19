<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：稼働時間グループ登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/base/system/kadoutimegrouptouroku/KadouTimeGroupTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- keyInfo --%>
        <swak:group id="keyInfo">
          <swak:item id="kadouTimeGroupCd" />
        </swak:group>

        <%-- keyInfoInputContents --%>
        <swak:group id="keyInfoInputContents">
          <swak:item id="kadouTimeGroup.kadouTimeGroupCd" />
        </swak:group>

        <%-- buttonInputKey --%>
        <swak:buttonGroup id="buttonInputKey">
          <swak:item id="tourokuBtn" />
        </swak:buttonGroup>

        <%-- kadouTimeGroupInfoList --%>
        <swak:dataTable id="kadouTimeGroupInfoList">
          <swak:column id="kadouTimeGroupCd" />
          <swak:column id="kadouTimeGroupNm" />
          <swak:column id="kadouTimeGroupDescription" />
          <swak:column id="henkouLink" />
          <swak:column id="sakujyoLink" />
        </swak:dataTable>

        <%-- kadouTimeGroupInfo --%>
        <swak:group id="kadouTimeGroupInfo">
          <swak:item id="kadouTimeGroup.kadouTimeGroupNm" />
          <swak:item id="kadouTimeGroup.holidayGroupCd" />
          <swak:item id="kadouTimeGroup.kadouTimeGroupDescription" />
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
