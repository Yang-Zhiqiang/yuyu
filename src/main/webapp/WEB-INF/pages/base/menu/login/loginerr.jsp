<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="jp.co.slcs.swak.date.BizDate"%>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil"%>
<%@page import="jp.co.slcs.swak.web.message.ExceptionMessages"%>
<%@page import="yuyu.def.MessageId"%>
<%@page import="yuyu.infr.auth.LoginUser"%>
<%@page import="yuyu.infr.exception.ExceptionMessageHandler.GlobalErrorTitle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  機能       ：ログインエラー画面（SSO用）
 --%>
<%@ taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<swak:html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>認証エラー</title>
    <swak:resource name="link"   src="/css/jquery-ui-1.10.2.custom.min.css" />
    <swak:resource name="link"   src="/css/swak-web.css"                    />
    <swak:resource name="link"   src="/css/common.css"                      />
    <swak:resource name="link"   src="/css/appcommon.css"                   />
    <swak:resource name="script" src="/js/jquery-1.9.1.min.js"              />
    <swak:resource name="script" src="/js/jquery-ui-1.10.2.custom.min.js"   />
    <swak:resource name="script" src="/js/jquery.ui.datepicker-ja.js"       />
    <swak:resource name="script" src="/js/key-control.js"                   />
    <swak:resource name="script" src="/js/key-control-sub.js"               />
    <script type="text/javascript">
    $(document).on('contextmenu', function(event) {
        return false;
    });
    </script>
    <swak:resource name="script" src="/js/swak-web.js"                      />
    <swak:resource name="script" src="/js/swak-env.js"                      />
    <swak:resource name="script" src="/js/common.js"                        />
    <swak:resource name="script" src="/js/appcommon.js"                     />
    <script type="text/javascript">
    <!--
    new Image().src="<%= request.getContextPath() %>/img/loading.gif";
    //-->
    </script>

    <script type="text/javascript">
    <!--
    $(function(){
      parent.$('#_dialog').dialog({
        title: $("title").text()
      });
      if(parent.$('#_dialogFrame').length){
        $(document.body).css({'cssText': 'width: 92% !important;'});
      }
    });
    //-->
    </script>

    <style type="text/css">
        div.messagesDiv {
            width: 100%;
            margin-top: 20px;
        }
        #contentsDiv {
            height:500px;
        }
    </style>
  </head>
    <body>
      <div class="contentsHeader">
        <div class="contentsHeaderRight">
        <br/>
        </div>
      </div>
      <hr class="contentsHeader" />
      <div class="messagesDiv">
        <table id="messages" class="messagesItems">
          <tr>
            <td class="messagesIcon"><img src="<%= request.getContextPath() %>/img/message/Message_Error.png" /></td>
            <td class="messagesItem">
              <span class="error_message">
                タイムアウトまたはログインに失敗しました。<br />
                再度リンクから起動してください。<br />
                再度起動して同じ画面が表示される場合は管理者に連絡してください。
              <span>
            </td>
          </tr>
        </table>
      </div><br />
      <div id ="contentsDiv">
        <%-- headerButtons --%>
        <div  id="headerButtonsDiv" class="buttonsDiv">
          <table  id="headerButtons" class="buttonsItems rightButtons">
            <tr>
              <td>
                <span id="tojiruBtnByPopupSpan" class="tojiruBtnByPopupItem">
                <input type="button" id="tojiruBtnByPopup" name="tojiruBtnByPopup" class="noSubmitCloseButton" value="閉じる" alt="閉じる"></span>
              </td>
            </tr>
          </table>
        </div>
      </div>
      <jsp:include page="/WEB-INF/pages/common/contents-footer.jsp" />
    </body>
</swak:html>
