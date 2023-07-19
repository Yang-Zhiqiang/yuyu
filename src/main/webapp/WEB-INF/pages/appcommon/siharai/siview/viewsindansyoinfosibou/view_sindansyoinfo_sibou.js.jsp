<%--
    view_sindansyoinfo_sibou.js.jsp - 診断書情報（死亡） JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.common.siharai.siview.viewsindansyoinfosibou.ViewSindansyoinfoSibouSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.common.biz.bzview.CommonViewInBean" %>
<%@page import="yuyu.def.classification.C_Delflag" %>
<%@page import="yuyu.common.siharai.siview.viewsindansyoinfosibou.ViewSindansyoinfoSibouUiBeanParam" %>
<%@taglib prefix="swak" uri="http://swak.slcs.co.jp/struts-tags" %>
<swak:resource name="link" src="/css/appcommon/siharai/siview/viewsindansyoinfosibou/view_sindansyoinfo_sibou.css" />
<% CommonViewInBean commonViewInBean = SWAKInjector.getInstance(CommonViewInBean.class); %>

<%
   ViewSindansyoinfoSibouUiBeanParam viewSindansyoinfoSibouUiBean = (ViewSindansyoinfoSibouUiBeanParam)commonViewInBean.getCommonViewUiBeanParam();
%>
<script type="text/javascript">

$(function(){

  <%
  if (viewSindansyoinfoSibouUiBean.isViewSindansyoinfoSibouInputDispFlg()) { %>

    var dispNum = 0;

    function listRowsDisplayControl(listGroup){
      $(listGroup).find('tr').each(function(){
        if($(this).find('.visibleFlg').length != 0){
            var multiLineObj = getMultiLineListRows($(this));
            if(multiLineObj.find('.visibleFlg').val() == <%= C_Delflag.BLNK %>){
                multiLineObj.visible(true);
                dispNum++;
            }else{
                multiLineObj.visible(false);
            }
        }
      });
    }

    listRowsDisplayControl(<%= VIEWSINDANSYOINFOSIBOUINFO1 %>);

    for (var i = 0; i < 10; i++) {
      var $viewSindansyoinfoSibouInfo0 = $(document.getElementById('viewSindansyoinfoSibouInfo1[' + i + '].byoumeikj'));
      $viewSindansyoinfoSibouInfo0.addClass('inputCovLabel');
      $viewSindansyoinfoSibouInfo0.attr('unselectable', 'on');
      $viewSindansyoinfoSibouInfo0.readonly(true);
    }

    showGroup(<%= TUIKABUTTONS %>);
    if (dispNum == 10) {
      $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
    }

    if(getListVisibleRowCount(<%= VIEWSINDANSYOINFOSIBOUINFO1 %>) == 10) {
      $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
    }

    $(document).on('click', <%= ADDBTN_TUIKABUTTONS %>,function(){
      var newRowsObj = getMultiLineListRows($(<%= VIEWSINDANSYOINFOSIBOUINFO1 %>).find('tr:visible').last().nextAll('tr:hidden').first());
      newRowsObj.find(':input').trigger('formInit');
      newRowsObj.visible(true);
      newRowsObj.find('.visibleFlg').val(<%= C_Delflag.BLNK %>);

      if(getListVisibleRowCount(<%= VIEWSINDANSYOINFOSIBOUINFO1 %>) == 10){
        $(<%= ADDBTN_TUIKABUTTONS %>).visible(false);
      }
    });

    <% for (int i = 0; i < viewSindansyoinfoSibouUiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData().size(); i++){ %>
      $(document).on('click', <%= SAKUJYOLINK_VIEWSINDANSYOINFOSIBOUINFO1(i) %>,function(){
          var rowCount = getListVisibleRowCount(<%= VIEWSINDANSYOINFOSIBOUINFO1 %>);
          if(rowCount > 1){
              var delRowsObj = getMultiLineListRows($(this).parents('tr'));
              delRowsObj.find(':input').trigger('formInit');

              listRowShift($(this).parents('tr'));

              var lastRowsObj = getMultiLineListRows($(<%= VIEWSINDANSYOINFOSIBOUINFO1 %>).find('tr:visible').last());
              lastRowsObj.find(':input').trigger('formInit');
              lastRowsObj.visible(false);
              lastRowsObj.find('.visibleFlg').val(<%= C_Delflag.SAKUJYO %>);
          }
          if(rowCount == 1){
              var delRowsObj = getMultiLineListRows($(this).parents('tr'));
              delRowsObj.find(':input').trigger('formInit');
          }

          $(<%= ADDBTN_TUIKABUTTONS %>).visible(true);
        });
    <% } %>

    $(document).on('formInit', '.inputForm1', function(){
           $(this).val('');
        });

    $(document).on('formInit', '.inputForm2', function(){
           $(this).val('');
        });

    $(document).on('formInit', '.inputForm3', function(){
           $(this).val('');
        });

    $(document).on('formInit', '.inputForm4', function(){
           $(this).val('');
        });

  <%
  } else { %>
      var viewSindansyoinfoSibouDispKbn = 0;
      <%
      if (viewSindansyoinfoSibouUiBean.isViewSindansyoinfoSibouSeigyo()) { %>
          $(<%=VIEWSINDANSYOINFOSIBOUINFO + LABEL%>).addClass('toggletitle');

          <%
          if (viewSindansyoinfoSibouUiBean.isViewSindansyoinfoSibouDispFlg()) { %>
              $(<%= VIEWSINDANSYOINFOSIBOUINFO%>).show();
              $(<%= VIEWSINDANSYOINFOSIBOUINFO1%>).show();
          <%
          } else { %>
              $(<%= VIEWSINDANSYOINFOSIBOUINFO%>).hide();
              $(<%= VIEWSINDANSYOINFOSIBOUINFO1%>).hide();
              viewSindansyoinfoSibouDispKbn = 1;
          <% } %>

          $(<%= VIEWSINDANSYOINFOSIBOUINFO + LABEL%>).click(function(){
              if (viewSindansyoinfoSibouDispKbn == 0) {
                  $(<%= VIEWSINDANSYOINFOSIBOUINFO%>).hide();
                  $(<%= VIEWSINDANSYOINFOSIBOUINFO1%>).hide();
                  viewSindansyoinfoSibouDispKbn = 1;
              } else {
                  $(<%= VIEWSINDANSYOINFOSIBOUINFO%>).show();
                  $(<%= VIEWSINDANSYOINFOSIBOUINFO1%>).show();
                  viewSindansyoinfoSibouDispKbn = 0;
              }
          });
      <% } %>
      $(<%=SIBOUBASYOKBN_VIEWSINDANSYOINFOSIBOUINFO%>).addClass('viewsindansyoinfosibouFirstCell');
  <% } %>

});

</script>
