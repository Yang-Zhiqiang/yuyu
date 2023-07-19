<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：契約保全内容確認
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khnaiyoukakunin/KhNaiyouKakunin.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- baseInfo --%>
        <swak:group id="baseInfo">
          <swak:item id="jimuttdknm" />
          <swak:item id="kinoussnm" />
          <swak:item id="syono" />
          <swak:item id="jimustartymd" />
        </swak:group>

        <%-- jyouhouList --%>
        <swak:dataTable id="jyouhouList">
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="dispkinoussnm" />
          <swak:column id="dispjimustartymd" />
          <swak:column id="nyuuryokuLink" />
        </swak:dataTable>

        <%-- ●書類情報一覧 --%>
        <swak:dataTable id="syoruiInfoList">
          <swak:column id="syoruittykymdtime" />
          <swak:column id="syoruinm" />
          <swak:column id="htysyoruiumukbn" />
          <swak:column id="hyoujilink" />
          <swak:column id="hyoujilinkflg" />
        </swak:dataTable>

        <%-- buttonAllhyouji --%>
        <swak:buttonGroup id="buttonAllhyouji">
          <swak:item id="allhyoujibtn" />
        </swak:buttonGroup>

        <%-- ●確認履歴 --%>
        <swak:dataTable id="kakuninKekkaInfo">
          <swak:column id="dispnaiyoukakymd" />
          <swak:column id="dispsousasyanm" />
          <swak:column id="disptasknm" />
          <swak:column id="dispkakuninkekkakbn" />
          <swak:column id="dispcomment" />
        </swak:dataTable>

        <%-- ●内容確認入力 --%>
        <swak:group id="naiyouKakuninNyuuryoku">
          <swak:item id="kakuninkekkakbn" />
          <swak:item id="commentgamen" />
        </swak:group>

        <%-- footerButtons1 --%>
        <swak:buttonGroup id="footerButtons1">
          <swak:item id="kakuteibtnbyinputkey" />
        </swak:buttonGroup>

        <%-- footerButtons2 --%>
        <swak:buttonGroup id="footerButtons2">
          <swak:item id="modorubtnbyitiransentaku" />
        </swak:buttonGroup>

        <%-- footerButtons3 --%>
        <swak:buttonGroup id="footerButtons3">
          <swak:item id="modoruBtnByInputContents" />
          <swak:item id="kakuninBtn" />
        </swak:buttonGroup>

        <%-- footerButtons4 --%>
        <swak:buttonGroup id="footerButtons4">
          <swak:item id="modoruBtnByConfirm" />
          <swak:item id="kakuteibtnbyconfirm" />
          <swak:item id="kakuteibtnbyworkflow" />
        </swak:buttonGroup>

        <%-- footerButtons5 --%>
        <swak:buttonGroup id="footerButtons5">
          <swak:item id="syokigamenheBtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
