<%--
    ds_trhk_service_touroku.js.jsp - 取引サービス登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.DsTrhkServiceTourokuConstants.*"%>
<%@page
	import="static yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.DsTrhkServiceTourokuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.DsTrhkServiceTourokuUiBean"%>
<%@page import="yuyu.def.classification.C_UmuKbn"%>
<%@page import="yuyu.def.classification.C_DsKinouModeIdKbn"%>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil"%>
<%@page import="yuyu.def.MessageId"%>
<% DsTrhkServiceTourokuUiBean uiBean = SWAKInjector.getInstance(DsTrhkServiceTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
    <%
    if (uiBean.getPageNo() == PAGENO_INPUTKEYSELECT) { %>
        <% if (uiBean.getTrhkServiceInfoDataSource().getAllData().size() > 0) {%>
            showList(<%=TRHKSERVICEINFO%>);
        <% }
    }%>

    <%
    if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) {%>

        showGroup(<%=TRHKSERVICEKANYUKEIROINFO%>);

     <%
       if (C_UmuKbn.ARI.eq(uiBean.getDstrhkserviceknykeironrumu())) {
          if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) ||
              C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) { %>
              $(<%= DSTRHKSERVICEKANYUKEIROKBN_TRHKSERVICEKANYUKEIROINFO + LABEL %>).required(true);
          <% }
          else {  %>
               inputToOutput(<%=DSTRHKSERVICEKANYUKEIROKBN_TRHKSERVICEKANYUKEIROINFO%>);
        <%    }
       }
       else {
       %>
            inputToOutput(<%=DSTRHKSERVICEKANYUKEIROKBN_TRHKSERVICEKANYUKEIROINFO%>);
     <%  }

       if (C_DsKinouModeIdKbn.TORIKESI.eq(uiBean.getKinouMode())) { %>
           showKoumoku(<%=TRKSRIYUUKBN_TRHKSERVICETOUROKUJKINFO%>);
           $(<%= TRKSRIYUUKBN_TRHKSERVICETOUROKUJKINFO + LABEL %>).required(true);
           showKoumoku(<%=DISPTOKUTEITRHKANSYONO_TOKUTEITRHKANSYONOINFO%>);

      <%
       }
       if (C_DsKinouModeIdKbn.SYOUKAI.eq(uiBean.getKinouMode())) { %>
          showKoumoku(<%=TRKSRIYUUKBN_TRHKSERVICETOUROKUJKINFO%>);
          inputToOutput(<%=TRKSRIYUUKBN_TRHKSERVICETOUROKUJKINFO%>);
       <% }

       if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) ||
           C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) { %>
           showKoumoku(<%=INPUTTAISYOUTOKUTEITRHKKZ_TOKUTEITRHKKOUZAINFO%>);
           $(<%= INPUTTAISYOUTOKUTEITRHKKZ_TOKUTEITRHKKOUZAINFO + LABEL %>).required(true);
           $(<%=IBC1001%>).visible(true);
           $(<%=IBC1002%>).visible(true);
           $(<%=IBC1003%>).visible(true);
           $(<%=IBC1004%>).visible(true);

           showKoumoku(<%=INPUTTAISYOUTOKTRHKANSYONO_TOKUTEITRHKANSYONOINFO%>);
           $(<%= INPUTTAISYOUTOKTRHKANSYONO_TOKUTEITRHKANSYONOINFO + LABEL %>).required(true);
           showKoumoku(<%=TOKUTEITRHKANSYONOINPUT_TOKUTEITRHKANSYONOINFO%>);
           showKoumoku(<%=TOKUTEITRHKANSYONOKAKUNIN_TOKUTEITRHKANSYONOINFO%>);

       <% }
       else { %>
            inputToOutput(<%=BANKCD_TOKUTEITRHKKOUZAINFO%>);
            inputToOutput(<%=SITENCD_TOKUTEITRHKKOUZAINFO%>);
            inputToOutput(<%=YOKINKBN_TOKUTEITRHKKOUZAINFO%>);
            inputToOutput(<%=KOUZANO_TOKUTEITRHKKOUZAINFO%>);
            inputToOutput(<%=KZDOUKBN_TOKUTEITRHKKOUZAINFO%>);
            inputToOutput(<%=KZMEIGINMKN_TOKUTEITRHKKOUZAINFO%>);

            showKoumoku(<%=DISPTOKUTEITRHKANSYONO_TOKUTEITRHKANSYONOINFO%>);

      <%  }

       if (!C_DsKinouModeIdKbn.SYOUKAI.eq(uiBean.getKinouMode())) { %>

           $(<%=KAKUNINBTN_FOOTERBUTTONS%>).visible(true);
       <% }
     }

    if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) {
       if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode()) ||
           C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) { %>
           showKoumoku(<%=INPUTTAISYOUTOKUTEITRHKKZ_TOKUTEITRHKKOUZAINFO%>);
           showKoumoku(<%=INPUTTAISYOUTOKTRHKANSYONO_TOKUTEITRHKANSYONOINFO%>);
       <% }

       if (C_DsKinouModeIdKbn.TORIKESI.eq(uiBean.getKinouMode())) { %>
           showKoumoku(<%=TRKSRIYUUKBN_TRHKSERVICETOUROKUJKINFO%>);
           inputToOutput(<%=TRKSRIYUUKBN_TRHKSERVICETOUROKUJKINFO%>);
      <% } %>

       showKoumoku(<%=DISPTOKUTEITRHKANSYONO_TOKUTEITRHKANSYONOINFO%>);

        showGroup(<%=TRHKSERVICEKANYUKEIROINFO%>);

    <% } %>

    <%
     if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM) { %>

        var msgText = '';

        <% if (C_DsKinouModeIdKbn.ITIJINYUURYOKU.eq(uiBean.getKinouMode())) { %>
            msgText = '<%=MessageUtil.getMessage(MessageId.IMW1006) %>';
        <% } else if (C_DsKinouModeIdKbn.NIJINYUURYOKU.eq(uiBean.getKinouMode())) { %>
            msgText = '<%=MessageUtil.getMessage(MessageId.IMW1007) %>';
        <% } %>

       $(<%= IBA0001 %>).text(msgText);

     <% } %>

});
//-->
</script>
