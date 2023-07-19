<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：当日ＦＢ返金取消
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sknyuukin/sktoujitufbhenkintorikesi/SkToujituFbHenkinTorikesi.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- baseInfo --%>
        <swak:group id="baseInfo">
          <swak:item id="mosno" />
          <swak:item id="hhknnmkj" />
        </swak:group>

        <%-- ●返金情報 --%>
        <swak:dataTable id="henkinJyouhouList">
          <swak:column id="dummykmk" />
          <swak:column id="disphnkngk" />
          <swak:column id="disphnknymd" />
          <swak:column id="disphnknhoukbn" />
          <swak:column id="dispsrgohnknumu" />
          <swak:column id="dispbankcd" />
          <swak:column id="dispbanknmkj" />
          <swak:column id="IAW0006" />
          <swak:column id="dispsitencd" />
          <swak:column id="dispsitennmkj" />
          <swak:column id="dispyokinkbn" />
          <swak:column id="IAW0006" />
          <swak:column id="dispkouzano" />
          <swak:column id="dispkzmeiginmkn" />
          <swak:column id="sentakulink" />
        </swak:dataTable>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="kakuteibtnbyinputkey" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modoruBtnByInputContents" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteibtnbyconfirm" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
