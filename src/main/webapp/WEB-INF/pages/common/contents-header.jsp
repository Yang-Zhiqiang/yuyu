<%@page import="com.google.common.base.Strings"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="jp.co.slcs.swak.date.BizDate"%>
<%@page import="jp.co.slcs.swak.date.SeirekiWarekiKbn"%>
<%@page import="jp.co.slcs.swak.auth.Credentials"%>
<%@page import="jp.co.slcs.swak.web.struts.Constants"%>
<%@page import="jp.co.slcs.swak.web.struts.configuration.SWAKStrutsConfig"%>
<%@page import="jp.co.slcs.swak.date.BizDateConfig"%>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil"%>
<%@page import="yuyu.def.MessageId"%>
<%@page import="yuyu.def.base.configuration.YuyuBaseConfig"%>
<%@page import="yuyu.infr.auth.LoginUser"%>
<%@page import="yuyu.def.db.entity.AS_Kinou"%>
<%@page import="yuyu.common.base.BaseUserInfo"%>
<%
  SWAKStrutsConfig conf        = SWAKInjector.getInstance(SWAKStrutsConfig.class);
  YuyuBaseConfig   baseConf    = SWAKInjector.getInstance(YuyuBaseConfig.class);
  AS_Kinou         kinou       = SWAKInjector.getInstance(AS_Kinou        .class);
  LoginUser        loginUser   = SWAKInjector.getInstance(LoginUser       .class);
  BizDate          now         = BizDate.getSysDate();
  SeirekiWarekiKbn swKbn       = BizDateConfig.getInstance().getSeirekiWarekiKbn();
  String           format;
  String           dateTimeNotShowSubSystemGroup = baseConf.getDateTimeNotShowSubSystemGroup();

  if      (swKbn.equals(SeirekiWarekiKbn.WAREKI_INPUT) ||
           swKbn.equals(SeirekiWarekiKbn.WAREKI_SYMBOL)) { format = "G yy/MM/dd";  }
  else if (swKbn.equals(SeirekiWarekiKbn.WAREKI_KANJI))  { format = "GG yy/MM/dd"; }
  else                                                   { format = "yyyy/MM/dd";  }
  %>

<%
  boolean isNormalMode = true;
  if (kinou.getSubSystemId().equals("consumer") || kinou.getSubSystemId().equals("directhanbai"))
  {
      isNormalMode = false;
  }

%>
<div class="contentsHeader">
  <div class="contentsHeaderLeft"><a class="functionName" id="functionName"><%= kinou.getKinouNm() %></a></div>
<%

  boolean isShowLoginDateTime = true;
  if(dateTimeNotShowSubSystemGroup !=null && dateTimeNotShowSubSystemGroup.length()>0){
      if(dateTimeNotShowSubSystemGroup.indexOf(kinou.getSubSystemId()) != -1){
          isShowLoginDateTime = false;
      }
  }


  if (isShowLoginDateTime) {

      BaseUserInfo userInfo = SWAKInjector.getInstance(BaseUserInfo.class);

      String zenkaiLoginTime = userInfo.getZenkaiLoginTime();

      String operaterMsg = MessageUtil.getMessage(MessageId.IAW0007);

      String datetimeMsg = "";

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d H:mm");

      if("menu".equals(kinou.getCategoryId())){
          if(zenkaiLoginTime == null || zenkaiLoginTime.equals("")){
              zenkaiLoginTime = "";
          }else{
              Date loginDateTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(zenkaiLoginTime);
              zenkaiLoginTime = sdf.format(loginDateTime);
          }

          datetimeMsg = MessageUtil.getMessage(MessageId.IAW0008);
      }else{
          zenkaiLoginTime = BizDate.getSysDateTimeMilli();
          Date loginDateTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(zenkaiLoginTime);
          zenkaiLoginTime = sdf.format(loginDateTime);

          datetimeMsg = MessageUtil.getMessage(MessageId.IAW0009);
      }

%>
  <div class="contentsHeaderRight">
    <table>
      <tr><td class="alignRight contentsHeaderRightLabel"><%= operaterMsg %></td><td><%= loginUser.getUserNm() %></td></tr>
      <tr><td class="alignRight contentsHeaderRightLabel"><%= datetimeMsg %></td><td><%= zenkaiLoginTime %></td></tr>
    </table>
  </div>
<%
  }
%>
</div>
<hr class="contentsHeader" />
<%
  if (isNormalMode) {
%>
<swak:messages />
<%
}
%>
