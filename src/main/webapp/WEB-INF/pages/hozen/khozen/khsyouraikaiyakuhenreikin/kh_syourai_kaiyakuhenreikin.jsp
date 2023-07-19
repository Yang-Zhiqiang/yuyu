<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：将来解約返戻金照会
--%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <jsp:include page="/WEB-INF/pages/common/header.jsp" />
  </head>

  <body>
    <jsp:include page="/WEB-INF/pages/common/contents-header.jsp" />

    <swak:form action="/hozen/khozen/khsyouraikaiyakuhenreikin/KhSyouraiKaiyakuhenreikin.do">

        <%-- headerButtons --%>
        <swak:buttonGroup id="headerButtons">
          <swak:item id="tojiruBtn" />
        </swak:buttonGroup>

        <%-- ●証券番号を指定して照会 --%>
        <swak:group id="syoukaiConditions1">
          <swak:item id="srchsyono" />
        </swak:group>

        <%-- syoukaiButtons1 --%>
        <swak:buttonGroup id="syoukaiButtons1">
          <swak:item id="syonodesyoukaibtn" />
        </swak:buttonGroup>

        <%-- ●試算条件を指定して照会 --%>
        <swak:group id="syoukaiConditions2">
          <swak:item id="srchsknnkaisiymd" />
          <swak:item id="srchkykymd" />
          <swak:item id="srchkanyuujinen" />
          <swak:item id="srchsei" />
          <swak:item id="srchhknsyrui" />
          <swak:item id="srchsiteituuka" />
          <swak:item id="IIF1031" />
          <swak:item id="srchhknkkn" />
          <swak:item id="IIF1011" />
          <swak:item id="srchhrkkkn" />
          <swak:item id="IIF1020" />
          <swak:item id="srchkihons" />
          <swak:item id="srchp" />
          <swak:item id="srchsisuurendourate" />
          <swak:item id="srchyendthnkymd" />
          <swak:item id="srchtmttknitenymd" />
        </swak:group>

        <%-- syoukaiButtons2 --%>
        <swak:buttonGroup id="syoukaiButtons2">
          <swak:item id="inputnaiyoudesyoukaibtn" />
        </swak:buttonGroup>

        <%-- syoukaiConditions --%>
        <swak:group id="syoukaiConditions">
          <swak:item id="syono" />
          <swak:item id="sknnkaisiymd" />
          <swak:item id="kykymd" />
          <swak:item id="hhknnen" />
          <swak:item id="hhknsei" />
          <swak:item id="syouhnnm" />
          <swak:item id="siteituuka" />
          <swak:item id="hknkkn" />
          <swak:item id="hrkkkn" />
          <swak:item id="kihons" />
          <swak:item id="hokenryou" />
          <swak:item id="sisuurendourate" />
          <swak:item id="yendthnkymd" />
          <swak:item id="tmttknitenymd" />
        </swak:group>

        <%-- footerButtons --%>
        <swak:buttonGroup id="footerButtons">
          <swak:item id="modorubtn" />
        </swak:buttonGroup>

    </swak:form>

    <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
  </body>

</swak:html>
