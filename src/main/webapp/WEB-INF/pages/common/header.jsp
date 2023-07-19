<%@page import="jp.co.slcs.swak.bizinfr.configuration.BizInfrConfig"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="static com.google.common.base.CaseFormat.*"%>
<%@page import="com.google.common.base.Strings"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="yuyu.def.base.configuration.YuyuBaseConfig"%>
<%@page import="yuyu.def.db.entity.AS_Kinou"%>
<%@page import="java.util.List"%>
<%@page import="yuyu.def.biz.configuration.YuyuBizConfig"%>
<%
  String   appName        = YuyuBaseConfig.getInstance().getApplicationName();
  String   appRootPackage = BizInfrConfig.instance.getAppRootPackage().replaceAll("\\.", "/");
  AS_Kinou kinou          = SWAKInjector.getInstance(AS_Kinou.class);
  List<String> insatukaKinouIdList = YuyuBizConfig.getInstance().getInsatukaKinouIdList();
  String   resourcePath;
  String   jsJspPath;
  String   kinouId = kinou.getKinouId();
  boolean  keyControlFlg = true;

  if (Strings.isNullOrEmpty(kinou.getJikkouPath())) {
      resourcePath = null;
      jsJspPath    = null;
  } else {
      String[] paths   = kinou.getJikkouPath().split("/");
      int      last    = paths.length - 1;
      String   resName = UPPER_CAMEL.to(LOWER_UNDERSCORE, paths[last].replaceFirst("\\.do(\\?.+)*$", ""));
      resourcePath     =
          String.format(
              "/%s/%s/%s/%s",
              paths[last - 3],
              paths[last - 2],
              paths[last - 1],
              resName
          );
      pageContext.setAttribute("resourcePath", resourcePath);

      jsJspPath = "/" + appRootPackage + resourcePath + ".js.jsp";
      if (getClass().getResource("/META-INF/resources" + jsJspPath) != null) {
          pageContext.setAttribute("jsJspPath", jsJspPath);
      } else if (getClass().getResource(jsJspPath) != null) {
          pageContext.setAttribute("jsJspPath", "/WEB-INF/classes" + jsJspPath);
      } else {
          jsJspPath = null;
      }
  }
  pageContext.setAttribute("subSystemId", kinou.getSubSystemId());

  if (insatukaKinouIdList.contains(kinouId)) {
      keyControlFlg = false;
  }

%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma"        content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires"       content="0">

    <title><%= kinou.getKinouNm() %> - <%= appName %></title>
    <swak:resource name="link"   src="/css/jquery-ui-1.10.2.custom.min.css" />
    <swak:resource name="link"   src="/css/swak-web.css"                    />
    <swak:resource name="link"   src="/css/common.css"                      />
    <swak:resource name="link"   src="/css/appcommon.css"                   />
    <swak:resource name="link"   src="/css/common-${ subSystemId }.css"     />
<% if (resourcePath != null) { %>
    <swak:resource name="link"   src="${ resourcePath }.css"                />
<% } %>
    <swak:resource name="script" src="/js/jquery-1.9.1.min.js"              />
    <swak:resource name="script" src="/js/jquery-ui-1.10.2.custom.min.js"   />
    <swak:resource name="script" src="/js/jquery.ui.datepicker-ja.js"       />
    <swak:resource name="script" src="/js/key-control.js"                   />
<% if (keyControlFlg) { %>
    <swak:resource name="script" src="/js/key-control-sub.js"               />
    <script type="text/javascript">
    $(document).on('contextmenu', function(event) {
        return false;
    });
    </script>
<% } %>
    <swak:resource name="script" src="/js/swak-web.js"                      />
    <swak:resource name="script" src="/js/swak-env.js"                      />
    <swak:resource name="script" src="/js/common.js"                        />
    <swak:resource name="script" src="/js/appcommon.js"                     />
    <swak:resource name="script" src="/js/common-${ subSystemId }.js"       />
    <script type="text/javascript">
    <!--
    new Image().src="<%= request.getContextPath() %>/img/loading.gif";
    //-->
    </script>
<% if (resourcePath != null) { %>
    <% if (jsJspPath != null) { %>
      <jsp:include page="${ jsJspPath }" />
    <% } else { %>
      <swak:resource name="script" src="${ resourcePath }.js"               />
    <% } %>
<% } %>
