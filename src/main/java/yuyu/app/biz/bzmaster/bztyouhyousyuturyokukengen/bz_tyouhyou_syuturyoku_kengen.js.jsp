<%--
    bz_tyouhyou_syuturyoku_kengen.js.jsp - 帳票出力権限登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen.BzTyouhyouSyuturyokuKengenConstants.*"%>
<%@page
	import="static yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen.BzTyouhyouSyuturyokuKengenSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page import="jp.co.slcs.swak.util.message.MessageUtil"%>
<%@page import="yuyu.def.MessageId"%>
<%@page
	import="yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen.BzTyouhyouSyuturyokuKengenUiBean"%>
<% BzTyouhyouSyuturyokuKengenUiBean uiBean = SWAKInjector.getInstance(BzTyouhyouSyuturyokuKengenUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

    $(<%= ALLCHECKBTN_CHECKBUTTONS %>).click(function() {
      $("input[class='check']").each(function(){
       this.checked = true;
      });
    });

    $(<%= ALLUNCHECKBTN_CHECKBUTTONS %>).click(function() {
      $("input[class='check']").each(function(){
       this.checked = false;
      });
    });

    function listRowsDisplayControl(listGroup){

        var listLength = $(listGroup)[0].rows.length;

        var line = 0;
        var selectFlg = false;

       $(listGroup).find('tr').each(function(){
            var visibleFlg = false;
            var count = 0;
            line++;

            if (line != 1) {
                $(this).find('td').each(function(){
                    count++;
                    if (count == 3 || count == 4) {
                       if ($(this).text().trim() == '<%=MessageUtil.getMessage(MessageId.IBC0005) %>') {
                            visibleFlg = true;
                            selectFlg = true;
                        }
                     }
                });
                if (line != listLength) {
                    if (visibleFlg == false) {
                        $(this).visible(false);
                    }
                }
                else {
                    if (selectFlg == false) {
                        $(this).find('td').each(function(){
                            $(this).text("");
                        });
                    }
                    else if (selectFlg == true && visibleFlg == false) {
                        $(this).visible(false);
                    }
                }
            }
        });
    }

    <% if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>
            listRowsDisplayControl(<%= TYOUHYOULIST %>);
    <% }  %>
});
//-->
</script>
