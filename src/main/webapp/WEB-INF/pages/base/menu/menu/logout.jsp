<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session = "false" %>
<%@ taglib uri="http://swak.slcs.co.jp/struts-tags" prefix="swak" %>
<%@ page import="yuyu.def.base.configuration.YuyuBaseConfig" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ログアウト - <%= YuyuBaseConfig.getInstance().getApplicationName() %></title>
    <swak:resource name="link" src="/css/common.css" />
  </head>

  <body>
    <table class="fullscreen">
      <tr>
        <td align="center">
          <swak:img page="/img/Login.png" /><br />
          <swak:messages /><br />
          ログアウトしました。<br />
          <br />
          <br />
          <swak:link page="/">ログイン画面へ</swak:link>
        </td>
      </tr>
    </table>
  </body>

</swak:html>
