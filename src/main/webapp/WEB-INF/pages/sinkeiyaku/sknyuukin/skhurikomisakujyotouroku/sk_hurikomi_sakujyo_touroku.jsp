<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：振込入金削除データ登録
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/sinkeiyaku/sknyuukin/skhurikomisakujyotouroku/SkHurikomiSakujyoTouroku.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- baseInfo --%>
        <swak:group id="baseInfo">
          <swak:item id="sakujyotrkymd" />
        </swak:group>

        <%-- kihonInfo --%>
        <swak:group id="kihonInfo">
          <swak:item id="mosnochknasi" />
          <swak:item id="oyadrtencd" />
          <swak:item id="rstuukasyu" />
          <swak:item id="hrkmirninnm" />
          <swak:item id="rsgaku" />
        </swak:group>

        <%-- listHaneiButtons --%>
        <swak:buttonGroup id="listHaneiButtons">
          <swak:item id="kakuteiBtn" />
        </swak:buttonGroup>

        <%-- sakujyoInfoList --%>
        <swak:dataTable id="sakujyoInfoList">
          <swak:column id="disptrkymd" />
          <swak:column id="dispmosno" />
          <swak:column id="disphrkmirninnm" />
          <swak:column id="dispoyadrtencd" />
          <swak:column id="disprstuukasyu" />
          <swak:column id="disprskingaku" />
          <swak:column id="dispsakujyoLink" />
          <swak:column id="sakujyoLink" />
        </swak:dataTable>
        <swak:pager id="sakujyoInfoListDataSource" />

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
