<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：新契約工程ワークリスト
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- jimutetuzukiLabel --%>
        <swak:group id="jimutetuzukiLabel">
          <swak:item id="dispjimutetuzukinm" />
        </swak:group>

        <%-- searchKeyInput --%>
        <swak:group id="searchKeyInput">
          <swak:item id="skeijimukbn" />
          <swak:item id="mosuketukekbn" />
          <swak:item id="disphknsyuruiworklist" />
          <swak:item id="dairitenkinyuukikancd1" />
          <swak:item id="dairitencd1" />
          <swak:item id="dispdrtennm1" />
          <swak:item id="dairitenkinyuukikancd2" />
          <swak:item id="dairitencd2" />
          <swak:item id="dispdrtennm2" />
          <swak:item id="dairitenkinyuukikancd3" />
          <swak:item id="drtencd3" />
          <swak:item id="dispdrtennm3" />
          <swak:item id="dairitenkinyuukikancd4" />
          <swak:item id="drtencd4" />
          <swak:item id="dispdrtennm4" />
          <swak:item id="dairitenkinyuukikancd5" />
          <swak:item id="drtencd5" />
          <swak:item id="dispdrtennm5" />
          <swak:item id="jimuyoucd" />
          <swak:item id="jmycdMisetteiKbn" />
          <swak:item id="djmskmKeiyakuKbn" />
          <swak:item id="srchmosfromymd" />
          <swak:item id="srchmostoymd" />
          <swak:item id="jimustartYmdFrom" />
          <swak:item id="jimustartYmdTo" />
          <swak:item id="mosno" />
        </swak:group>

        <%-- searchConditionBtn --%>
        <swak:buttonGroup id="searchConditionBtn">
          <swak:item id="clearbtn" />
          <swak:item id="joukenHozonBtn" />
          <swak:item id="saisetteiBtn" />
        </swak:buttonGroup>

        <%-- buttonSerch --%>
        <swak:buttonGroup id="buttonSerch">
          <swak:item id="searchBtn" />
        </swak:buttonGroup>

        <%-- resultInfoTskSntkBase --%>
        <swak:dataTable id="resultInfoTskSntkBase">
          <swak:column id="jimutetuzukicd" />
        </swak:dataTable>

        <%-- resultInfoTskSntk --%>
        <swak:dataTable id="resultInfoTskSntk">
          <swak:column id="jimutetuzukicd" />
          <swak:column id="dispjimutetuzukinm" />
          <swak:column id="workflowTskNm" />
          <swak:column id="kjnTskKensuu" />
          <swak:column id="kojinNyuuryokuLink" />
          <swak:column id="kojinItiranLink" />
          <swak:column id="kyyTskKensuu" />
          <swak:column id="kyouyouNyuuryokuLink" />
          <swak:column id="kyouyouItiranLink" />
        </swak:dataTable>

        <%-- resultInfoItiran --%>
        <swak:dataTable id="resultInfoItiran">
          <swak:column id="dispjimustartymdtime" />
          <swak:column id="mosno" />
          <swak:column id="disphknsyuruiworklist" />
          <swak:column id="kyknmkj" />
          <swak:column id="dispzenkaisyoritask" />
          <swak:column id="dispzenkaisyoritantounm" />
          <swak:column id="nyuuryokuLink" />
        </swak:dataTable>
        <swak:pager id="resultInfoItiranDataSource" />

        <%-- lastButtons --%>
        <swak:buttonGroup id="lastButtons">
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
