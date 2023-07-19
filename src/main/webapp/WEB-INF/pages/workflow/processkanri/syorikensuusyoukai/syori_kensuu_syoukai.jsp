<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：処理件数照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/syorikensuusyoukai/SyoriKensuuSyoukai.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- searchKeyInput --%>
        <swak:group id="searchKeyInput">
          <swak:item id="subSystemId" />
          <swak:item id="syoriYmd" />
          <swak:item id="syoriYmdTo" />
          <swak:item id="userId" />
          <swak:item id="userNm" />
          <swak:item id="dispsubsystemnm" />
          <swak:item id="dispsyoriymd" />
          <swak:item id="dispsyoriymdto" />
          <swak:item id="dispjimutetuzukinm" />
          <swak:item id="disptantcd" />
          <swak:item id="disptantounm" />
          <swak:item id="disptasknm" />
        </swak:group>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- taskuserInfo --%>
        <swak:dataTable id="taskuserInfo">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="zenjituzanKensuu" />
          <swak:column id="zanKensuu" />
          <swak:column id="kanryoKensuu" />
          <swak:column id="syousaiLink" />
        </swak:dataTable>

        <%-- taskuserInfo2 --%>
        <swak:dataTable id="taskuserInfo2">
          <swak:column id="disptasknm" />
          <swak:column id="zenjituzanKensuu" />
          <swak:column id="zanKensuu" />
          <swak:column id="kanryoKensuu" />
          <swak:column id="syousaiLinkTask" />
        </swak:dataTable>

        <%-- lastButtons2 --%>
        <swak:buttonGroup id="lastButtons2">
          <swak:item id="modoruBtnByConfirm" />
        </swak:buttonGroup>

        <%-- taskuserInfo3 --%>
        <swak:dataTable id="taskuserInfo3">
          <swak:column id="disptantounm" />
          <swak:column id="zenjituzanKensuu" />
          <swak:column id="zanKensuu" />
          <swak:column id="kanryoKensuu" />
        </swak:dataTable>

        <%-- lastButtons3 --%>
        <swak:buttonGroup id="lastButtons3">
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
