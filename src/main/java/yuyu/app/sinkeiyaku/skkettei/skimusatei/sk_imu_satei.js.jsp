<%--
    sk_imu_satei.js.jsp - 医務査定 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkettei.skimusatei.SkImuSateiConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.skkettei.skimusatei.SkImuSateiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.skkettei.skimusatei.SkImuSateiUiBean" %>
<%@page import="yuyu.def.classification.C_KnkysateijyouKbn" %>
<%@page import="yuyu.def.classification.C_SyorikekkaKbn" %>
<%@page import="yuyu.app.sinkeiyaku.skkettei.skimusatei.SkImuSateiConstants" %>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil" %>
<%@page import="yuyu.def.MessageId" %>
<% SkImuSateiUiBean uiBean = SWAKInjector.getInstance(SkImuSateiUiBean.class); %>
<% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
<jsp:include page="/WEB-INF/pages/appcommon/biz/syoruiitiran/viewsyoruiinfoitiran/view_syorui_info_itiran.js.jsp"/>
<% } %>

<script type="text/javascript"><!--
$(function(){
    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM
        || uiBean.getPageNo() == PAGENO_RESULT) { %>

        showList(<%= TORIATUKAITYUUIJOUHOU %>);

        showList(<%= SENTAKUJOUHOU %>);

    <% } %>

    <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
        <% if(C_KnkysateijyouKbn.NONE.eq(uiBean.getKnkysateijyoukbn())) {%>
                 $(<%= KNKSATEIKEKKAKBN_KANKYOUSATEIIRAI %>).visible(true);
                 $(<%= KNKSATEIIRAICOMMENT_KANKYOUSATEIIRAI %>).visible(true);
        <% } %>

     var syoubyouJyoutaiKbn1 = $(<%=SYOUBYOUJYOUTAIKBN1_KETTEI%>).val();

     if (syoubyouJyoutaiKbn1 != <%= SYOUBYOUJYOUTAIKBN_KANTI %>) {
       $("select[id='kantiym1:gengou']").find("option:last").attr("selected",true);
       $("select[id='kantiym1:gengou']").readonly(true);

       $("input[id='kantiym1:date']").val("");
       $("input[id='kantiym1:date']").readonly(true);
     } else {
       $("select[id='kantiym1:gengou']").find("option:last").attr("selected",true);

       $("input[id='kantiym1:date']").readonly(false);
     }

     $(<%=SYOUBYOUJYOUTAIKBN1_KETTEI%>).change( function() {
       var syoubyouJyoutaiKbn1 = $(<%=SYOUBYOUJYOUTAIKBN1_KETTEI%>).val();

       if (syoubyouJyoutaiKbn1 != <%= SYOUBYOUJYOUTAIKBN_KANTI %>) {
         $("select[id='kantiym1:gengou']").find("option:last").attr("selected",true);
         $("select[id='kantiym1:gengou']").readonly(true);

         $("input[id='kantiym1:date']").val("");
         $("input[id='kantiym1:date']").readonly(true);
       } else {
         $("select[id='kantiym1:gengou']").find("option:last").attr("selected",true);

         $("input[id='kantiym1:date']").readonly(false);
       }
     });

     var syoubyouJyoutaiKbn2 = $(<%=SYOUBYOUJYOUTAIKBN2_KETTEI%>).val();

     if (syoubyouJyoutaiKbn2 != <%= SYOUBYOUJYOUTAIKBN_KANTI %>) {
       $("select[id='kantiym2:gengou']").find("option:last").attr("selected",true);
       $("select[id='kantiym2:gengou']").readonly(true);

       $("input[id='kantiym2:date']").val("");
       $("input[id='kantiym2:date']").readonly(true);
     } else {
       $("select[id='kantiym2:gengou']").find("option:last").attr("selected",true);

       $("input[id='kantiym2:date']").readonly(false);
     }

     $(<%=SYOUBYOUJYOUTAIKBN2_KETTEI%>).change( function() {
       var syoubyouJyoutaiKbn2 = $(<%=SYOUBYOUJYOUTAIKBN2_KETTEI%>).val();

       if (syoubyouJyoutaiKbn2 != <%= SYOUBYOUJYOUTAIKBN_KANTI %>) {
         $("select[id='kantiym2:gengou']").find("option:last").attr("selected",true);
         $("select[id='kantiym2:gengou']").readonly(true);

         $("input[id='kantiym2:date']").val("");
         $("input[id='kantiym2:date']").readonly(true);
       } else {
         $("select[id='kantiym2:gengou']").find("option:last").attr("selected",true);

         $("input[id='kantiym2:date']").readonly(false);
       }
     });

     $(<%=KETRIYUUITIRANBTN_KETTEI%>).visible(true);
     $(<%=KETRIYUUITIRANBTN_KETTEI%>).val('<%= ITIRAN %>');

     var ketriyuucd1Gamen = $(<%= KETRIYUUCD1GAMEN_KETTEI %>).val();
     callAjaxKetteiRiyuuNaiyou(ketriyuucd1Gamen, <%= KETTEIRIYUUCDFLAG1 %>);

     $(<%=KETRIYUUCD1GAMEN_KETTEI%>).change( function() {
       var ketriyuucd1Gamen = $(<%= KETRIYUUCD1GAMEN_KETTEI %>).val();
       callAjaxKetteiRiyuuNaiyou(ketriyuucd1Gamen, <%= KETTEIRIYUUCDFLAG1 %>);
     });

     var ketriyuucd2Gamen = $(<%= KETRIYUUCD2GAMEN_KETTEI %>).val();
     callAjaxKetteiRiyuuNaiyou(ketriyuucd2Gamen, <%= KETTEIRIYUUCDFLAG2 %>);

     $(<%=KETRIYUUCD2GAMEN_KETTEI%>).change( function() {
       var ketriyuucd2Gamen = $(<%= KETRIYUUCD2GAMEN_KETTEI %>).val();
       callAjaxKetteiRiyuuNaiyou(ketriyuucd2Gamen, <%= KETTEIRIYUUCDFLAG2 %>);
     });

     var ketriyuucd3Gamen = $(<%= KETRIYUUCD3GAMEN_KETTEI %>).val();
     callAjaxKetteiRiyuuNaiyou(ketriyuucd3Gamen, <%= KETTEIRIYUUCDFLAG3 %>);

     $(<%=KETRIYUUCD3GAMEN_KETTEI%>).change( function() {
       var ketriyuucd3Gamen = $(<%= KETRIYUUCD3GAMEN_KETTEI %>).val();
       callAjaxKetteiRiyuuNaiyou(ketriyuucd3Gamen, <%= KETTEIRIYUUCDFLAG3 %>);
     });

     var ketriyuucd4Gamen = $(<%= KETRIYUUCD4GAMEN_KETTEI %>).val();
     callAjaxKetteiRiyuuNaiyou(ketriyuucd4Gamen, <%= KETTEIRIYUUCDFLAG4 %>);

     $(<%=KETRIYUUCD4GAMEN_KETTEI%>).change( function() {
       var ketriyuucd4Gamen = $(<%= KETRIYUUCD4GAMEN_KETTEI %>).val();
       callAjaxKetteiRiyuuNaiyou(ketriyuucd4Gamen, <%= KETTEIRIYUUCDFLAG4 %>);
     });

     var syoubyouCd1 = $(<%= SYOUBYOUCD1_KETTEI %>).val();
     callAjaxSyoubyouMei(syoubyouCd1, <%= SYOUBYOUCDFLAG1 %>);

     $(<%=SYOUBYOUCD1_KETTEI%>).change( function() {
       var syoubyouCd1 = $(<%= SYOUBYOUCD1_KETTEI %>).val();
       callAjaxSyoubyouMei(syoubyouCd1, <%= SYOUBYOUCDFLAG1 %>);
     });

     var syoubyouCd2 = $(<%= SYOUBYOUCD2_KETTEI %>).val();
     callAjaxSyoubyouMei(syoubyouCd2, <%= SYOUBYOUCDFLAG2 %>);

     $(<%=SYOUBYOUCD2_KETTEI%>).change( function() {
      var syoubyouCd2 = $(<%= SYOUBYOUCD2_KETTEI %>).val();
      callAjaxSyoubyouMei(syoubyouCd2, <%= SYOUBYOUCDFLAG2 %>);
     });

     $(<%= KAKUNINBTN_FOOTERBUTTONS2%>).click( function () {
        var checkedAll = $('input:radio[name="ui:040ketkekkacd"]:checked').val();
        var imuSateikekkaKbn = $('#imusateikekkakbn').val();
        if (checkedAll == null && <%=C_SyorikekkaKbn.KANRYOU%> == imuSateikekkaKbn) {
          if(window.confirm('<%=MessageUtil.getMessage(MessageId.QHF1003) %>')){

               $("input[name='ui:040ketkekkacd']").eq(0).attr("checked", "checked");
               $("form:first").attr("action", "<%= request.getContextPath() %>/sinkeiyaku/skkettei/skimusatei/SkImuSatei.do?_eventHandler=kakuninBtnOnClick");
               $("input[id='kantiym1:date']").readonly(false);
               $("input[id='kantiym2:date']").readonly(false);
               $("form:first").submit();

          }
        } else {
               $("form:first").attr("action", "<%= request.getContextPath() %>/sinkeiyaku/skkettei/skimusatei/SkImuSatei.do?_eventHandler=kakuninBtnOnClick");
               $("input[id='kantiym1:date']").readonly(false);
               $("input[id='kantiym2:date']").readonly(false);
               $("form:first").submit();
        }
      });
 <% } %>

   <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
     $(<%= KNKSATEIKEKKAKBN_KANKYOUSATEIIRAI %>).visible(true);
     $(<%= KNKSATEIIRAICOMMENT_KANKYOUSATEIIRAI %>).visible(true);

     <% if(uiBean.getHhknnen() == 0) { %>
        $(<%= HHKNNENDATA_HIHOKENSYAJOUHOU %>).text("");
        $(<%= HHKNNENUNIT_HIHOKENSYAJOUHOU %>).text("");
     <% } %>
   <% } %>

   <% if (uiBean.getPageNo() == PAGENO_RESULT) { %>
    <%
       String[] hubiMsgs = uiBean.getHubimsgData();
       String msgId = "";
       if (hubiMsgs != null && hubiMsgs.length != 0 && hubiMsgs[0].length() != 0) {
       String[] hubiMsg = hubiMsgs[0].split(" ");
       msgId = hubiMsg[1];
     }
    %>
     changeErrMsg('<%= msgId %>');
  <% } %>

  function callAjaxSyoubyouMei(syoubyouCd, syoubyouCdFlag){

      var form = $('form').attr('action');
      form = form + "?<%= CALLAJAXSYOUBYOUMEI %>";

      $.ajax({
          type: "POST",
          url: form,
          data: {
              syoubyoucd: syoubyouCd
          },
          dataType: "json"
      }).done(function(data){
          syoubyouMeiSettei(data, syoubyouCdFlag);
      });
  }

  function syoubyouMeiSettei(obj, syoubyouCdFlag){
    if (syoubyouCdFlag == <%= SYOUBYOUCDFLAG1 %>) {
      $(<%= SYOUBYOUNM1_KETTEI %>).text(obj[0]);
    }
     if (syoubyouCdFlag == <%= SYOUBYOUCDFLAG2 %>) {
      $(<%= SYOUBYOUNM2_KETTEI %>).text(obj[0]);
    }
  }

  function callAjaxKetteiRiyuuNaiyou(ketteiRiyuuCd, ketteiRiyuuCdFlag){

      var form = $('form').attr('action');
      form = form + "?<%= CALLAJAXKETTEIRIYUUNAIYOU %>";

      $.ajax({
          type: "POST",
          url: form,
          data: {
              ketteiRiyuuCd: ketteiRiyuuCd
          },
          dataType: "json"
      }).done(function(data){
          ketteiRiyuuNaiyouSettei(data, ketteiRiyuuCdFlag);
      });
  }

  function ketteiRiyuuNaiyouSettei(obj, ketteiRiyuuCdFlag){
    if (ketteiRiyuuCdFlag == <%= KETTEIRIYUUCDFLAG1 %>) {
      $(<%= KETTEIRIYUUNAIYOU1_KETTEI %>).text(obj[0]);
    }

    if (ketteiRiyuuCdFlag == <%= KETTEIRIYUUCDFLAG2 %>) {
      $(<%= KETTEIRIYUUNAIYOU2_KETTEI %>).text(obj[0]);
    }

    if (ketteiRiyuuCdFlag == <%= KETTEIRIYUUCDFLAG3 %>) {
      $(<%= KETTEIRIYUUNAIYOU3_KETTEI %>).text(obj[0]);
    }

    if (ketteiRiyuuCdFlag == <%= KETTEIRIYUUCDFLAG4 %>) {
      $(<%= KETTEIRIYUUNAIYOU4_KETTEI %>).text(obj[0]);
    }

  }

});
//-->
</script>
