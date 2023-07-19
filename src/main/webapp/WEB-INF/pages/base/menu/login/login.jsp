<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- saved from url=(0055)http://localhost:8080/s-np1-source/base/menu/login/login.do -->
<!-- Generated by F12 developer tools. This might not be an accurate representation of the original source file -->
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン - SWAK2.1 ベースパッケージ</title>
<link rel="stylesheet" type="text/css" href="/s-np1-source/css/jquery-ui-1.10.2.custom.min.css">
<link rel="stylesheet" type="text/css" href="/s-np1-source/css/common.css">
<link rel="stylesheet" type="text/css" href="/s-np1-source/css/appcommon.css">
<link rel="stylesheet" type="text/css" href="/s-np1-source/css/common-base.css">
<link rel="stylesheet" type="text/css" href="/s-np1-source/base/menu/login/login.css">
<script type="text/javascript" charset="UTF-8" src="/s-np1-source/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="/s-np1-source/js/jquery-ui-1.10.2.custom.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="/s-np1-source/js/jquery.ui.datepicker-ja.js"></script>
<script type="text/javascript" charset="UTF-8" src="/s-np1-source/js/swak-web.js"></script>
<script type="text/javascript" charset="UTF-8" src="/s-np1-source/js/common.js"></script>
<script type="text/javascript" charset="UTF-8" src="/s-np1-source/js/appcommon.js"></script>
<script type="text/javascript" charset="UTF-8" src="/s-np1-source/js/common-base.js"></script>

<script type="text/javascript">
    function addHeaderRequest() {
      var httpRequest = new XMLHttpRequest();

      var loginInitUrl = document.URL;
      var realLoginInitUrl = loginInitUrl.substr(0, loginInitUrl.indexOf("login.do")+8);
      var contextRoot = loginInitUrl.substr(0, loginInitUrl.indexOf("/base"));

      var url = realLoginInitUrl + "?_eventHandler=loginBtnOnClick";
      httpRequest.open("POST", url, true);

      if(document.getElementById("userId").value != ''){
          httpRequest.setRequestHeader("USERID", document.getElementById("userId").value);
      }
      if(document.getElementById("idKind").value != ''){
          httpRequest.setRequestHeader("ID_KIND", document.getElementById("idKind").value);
      }
      if(document.getElementById("personCd").value != ''){
          httpRequest.setRequestHeader("PERSON_CODE", document.getElementById("personCd").value);
      }
      if(document.getElementById("issueNum").value != ''){
          httpRequest.setRequestHeader("ISSUE_NUMBER", document.getElementById("issueNum").value);
      }
      if(document.getElementById("pcCd").value != ''){
          httpRequest.setRequestHeader("PC_CODE", document.getElementById("pcCd").value);
      }
      if(document.getElementById("ipAddress").value != ''){
          httpRequest.setRequestHeader("IPADDR", document.getElementById("ipAddress").value);
      }
      if(document.getElementById("machineKind").value != ''){
          httpRequest.setRequestHeader("MACHINE", document.getElementById("machineKind").value);
      }
      if(document.getElementById("nodeNum").value != ''){
          httpRequest.setRequestHeader("NODE_NUMBER", document.getElementById("nodeNum").value);
      }
      if(document.getElementById("tmSosikiCd").value != ''){
          httpRequest.setRequestHeader("MAC_ORG_CODE", document.getElementById("tmSosikiCd").value);
      }

      httpRequest.onreadystatechange = function() {
        if (httpRequest.readyState == 4 && httpRequest.status == 200) {
          var cType = httpRequest.getResponseHeader("Content-Type");
          if (cType.toLowerCase().indexOf("text/plain") == -1) {
            window.location.href = contextRoot + "/base/menu/menu/Menu.do";
          }
        }
      }
      httpRequest.send();
    }

</script>

</head>
<body>
  <div class="fullscreen">
  <img id="pic" src="../../../img/Login.png"><br><br>
  <div id="loginInputDiv" class="groupDiv">
  <table id="loginInput" class="groupItems">
    <tbody>
      <tr trtes0="">
        <td style="float: right;" class="userId_label">
          <span style="float: right;" id="userId_label" class="userId_label" value="ユーザーＩＤ">ユーザーＩＤ :</span>
          <span style="display: none;" class="requiredMark">※</span>
        </td>
        <td class="userId_data">
          <span id="userIdSpan" class="textItem">
            <input id="userId" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value = "54010101">
          </span>
        </td>
      </tr>
      <tr trtes0="">
        <td style="float: right;">
          <span style="float: right;" id="userId_label" class="userId_label" value="ID区分">ID区分 :</span>
        </td>
        <td class="userId_data">
          <span class="textItem">
            <input id="idKind" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value = "54">
          </span>
        </td>
      </tr>
      <tr trtes0="">
        <td style="float: right;">
          <span style="float: right;" id="userId_label" value="個人コード">個人コード :</span>
        </td>
        <td class="userId_data">
          <span id="userIdSpan" class="textItem">
            <input id="personCd" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value = "010101">
          </span>
        </td>
      </tr>
      <tr trtes0="">
        <td style="float: right;">
          <span style="float: right;" id="userId_label" value="発行通番">発行通番 :</span>
        </td>
        <td class="userId_data">
          <span id="userIdSpan" class="textItem">
            <input id="issueNum" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value = "00">
          </span>
        </td>
      </tr>
      <tr trtes0="">
        <td style="float: right;">
          <span style="float: right;" id="userId_label" class="userId_label" value="端末使用区分">端末使用区分 :</span>
        </td>
        <td class="userId_data">
          <span id="userIdSpan" class="textItem">
            <input id="pcCd" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value = "1">
          </span>
        </td>
      </tr>
      <tr trtes0="">
        <td style="float: right;" class="userId_label">
          <span style="float: right;" id="userId_label" class="userId_label" value="IPアドレス">IPアドレス :</span>
          <span style="display: none;" class="requiredMark">※</span>
        </td>
        <td class="userId_data">
          <span id="userIdSpan" class="textItem">
            <input id="ipAddress" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value ="">
          </span>
        </td>
      </tr>
      <tr trtes0="">
        <td style="float: right;" class="userId_label">
          <span style="float: right;" id="userId_label" class="userId_label" value="端末種別">端末種別 :</span>
        </td>
        <td class="userId_data">
          <span id="userIdSpan" class="textItem">
            <input id="machineKind" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value="26" >
          </span>
        </td>
      </tr>
      <tr trtes0="">
        <td style="float: right;" class="userId_label">
          <span style="float: right;" id="userId_label" class="userId_label" value="ノード管理番号">ノード管理番号 :</span>
        </td>
        <td class="userId_data">
          <span id="userIdSpan" class="textItem">
            <input id="nodeNum" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value="">
          </span>
        </td>
      </tr>
      <tr trtes0="">
        <td style="float: right;" class="userId_label">
          <span style="float: right;" id="userId_label" class="userId_label" value="端末設置組織コード">端末設置組織コード :</span>
        </td>
        <td class="userId_data">
          <span id="userIdSpan" class="textItem">
            <input id="tmSosikiCd" class="text imemode-off text7" name="ui:000userId" maxLength="30" type="text" value="5900000">
          </span>
        </td>
      </tr>
    </tbody>
  </table>
  </div>
  <div id="buttonLoginDiv" class="buttonsDiv">
  <table id="buttonLogin" class="buttonsItems">
    <tbody>
      <tr trtes0="">
        <td>
          <span id="loginBtnSpan" class="buttonItem">
            <input id="loginBtn" class="button" name="loginBtn" alt="ログイン" value="ログイン" type="button" onclick="addHeaderRequest()">
          </span>
        </td>
      </tr>
    </tbody>
  </table>
  </div>
  </div>
</body>
</html>