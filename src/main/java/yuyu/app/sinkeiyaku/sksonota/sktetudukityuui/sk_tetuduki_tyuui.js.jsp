<%--
    sk_tetuduki_tyuui.js.jsp - 新契約手続注意設定 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksonota.sktetudukityuui.SkTetudukiTyuuiConstants.*" %>
<%@page import="static yuyu.app.sinkeiyaku.sksonota.sktetudukityuui.SkTetudukiTyuuiSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.sinkeiyaku.sksonota.sktetudukityuui.SkTetudukiTyuuiUiBean" %>
<%@page import="yuyu.def.classification.C_YesNoKbn" %>
<% SkTetudukiTyuuiUiBean uiBean = SWAKInjector.getInstance(SkTetudukiTyuuiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>

  function listRowsDisplayControl(listGroup){
    $(listGroup).find('tr').each(function(){
        if($(this).find('.visibleFlg').length != 0){
             var multiLineObj = getMultiLineListRows($(this));
             if(multiLineObj.find('.visibleFlg').val() == '<%= C_YesNoKbn.YES %>'){
                multiLineObj.visible(true);
             }else{
                multiLineObj.visible(false);
             }
         }
     });
  }

  listRowsDisplayControl(<%= TORIATUKAITYUUIINFO %>);

  listRowsDisplayControl(<%= SONOTATYUUIINFO  %>);

  $(document).on('click', <%= ADDBTNBYTORIATUKAITYUUIINFO_TORIATUKAITYUUIBUTTONS %>,function(){
     var rowCount = getListVisibleRowCount(<%= TORIATUKAITYUUIINFO %>);
    if(rowCount < <%= MAX_ROW_COUNT %> ){
     var newRowsObj = getMultiLineListRows($(<%= TORIATUKAITYUUIINFO %>).find('tr:visible').last().nextAll('tr:hidden').first());
     newRowsObj.visible(true);
     newRowsObj.find('.visibleFlg').val(<%= C_YesNoKbn.YES %>);
     }

     if(rowCount == <%= MAX_ROW_COUNT %> - 1 ){
        $(<%= ADDBTNBYTORIATUKAITYUUIINFO_TORIATUKAITYUUIBUTTONS %>).visible(false);
     }
  });

  $(document).on('click', <%= ADDBTNBYSONOTATYUUIINFO_SONOTATYUUIBUTTONS %>,function(){
     var rowCount = getListVisibleRowCount(<%= SONOTATYUUIINFO  %>);
    if(rowCount < <%= MAX_ROW_COUNT %> ){
     var newRowsObj = getMultiLineListRows($(<%= SONOTATYUUIINFO  %>).find('tr:visible').last().nextAll('tr:hidden').first());
     newRowsObj.visible(true);
     newRowsObj.find('.visibleFlg').val(<%= C_YesNoKbn.YES %>);
     }

    if(rowCount == <%= MAX_ROW_COUNT %> - 1 ){
        $(<%= ADDBTNBYSONOTATYUUIINFO_SONOTATYUUIBUTTONS %>).visible(false);
     }
  });

  var torCount = getListVisibleRowCount(<%= TORIATUKAITYUUIINFO %>);
  var sonCount = getListVisibleRowCount(<%= SONOTATYUUIINFO %>);

  if(torCount == <%= MAX_ROW_COUNT %> ){
      $(<%= ADDBTNBYTORIATUKAITYUUIINFO_TORIATUKAITYUUIBUTTONS %>).visible(false);
  }
  if(sonCount == <%= MAX_ROW_COUNT %> ){
      $(<%= ADDBTNBYSONOTATYUUIINFO_SONOTATYUUIBUTTONS %>).visible(false);
  }
  <%}%>

  <% if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

    showList(<%=TORIATUKAITYUUIINFO%>);

    showList(<%=SONOTATYUUIINFO%>);

  <%}%>

});
//-->
</script>
