<%--
    holiday_touroku.js.jsp - 休日登録 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.base.system.holidaytouroku.HolidayTourokuConstants.*"%>
<%@page
	import="static yuyu.app.base.system.holidaytouroku.HolidayTourokuSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.base.system.holidaytouroku.HolidayTourokuUiBean"%>
<%@page import="yuyu.def.classification.C_HolidayPtn"%>
<%@page
	import="yuyu.app.base.system.holidaytouroku.GenHolidayTourokuConstants"%>
<% HolidayTourokuUiBean uiBean = SWAKInjector.getInstance(HolidayTourokuUiBean.class); %>
<script type="text/javascript"><!--
$(function(){
  <%
  if (uiBean.getHolidayYoyaku().getHolidayPattern() != null && uiBean.getPageNo() != GenHolidayTourokuConstants.PAGENO_SELECTKEY) {
      if (uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.OTHER_HOLIDAYGROUP)) { %>
          setNoneToTrDisplay(<%= HOLIDAYYMD_HOLIDAYPATTERNINFOINPUT + LABEL   %>);
          setNoneToTrDisplay(<%= HOLIDAYMD_HOLIDAYPATTERNINFOINPUT + LABEL    %>);
          setNoneToTrDisplay(<%= HOLIDAYM_HOLIDAYPATTERNINFOINPUT + LABEL     %>);
          setNoneToTrDisplay(<%= HOLIDAYYOUBI_HOLIDAYPATTERNINFOINPUT + LABEL %>);

  <%
      } else if (uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.SPECIFIC_DAY)) { %>
          setNoneToTrDisplay(<%= TEKIYOUYMDFROM_LABEL %>);
          setNoneToTrDisplay(<%= TEKIYOUYMDTO_LABEL   %>);
          setNoneToTrDisplay(<%= HOLIDAYGROUP   %>);
          setNoneToTrDisplay(<%= HOLIDAYGROUPCD_HOLIDAYPATTERNINFOINPUT %>);
          setNoneToTrDisplay(<%= HOLIDAYMD_HOLIDAYPATTERNINFOINPUT + LABEL      %>);
          setNoneToTrDisplay(<%= HOLIDAYM_HOLIDAYPATTERNINFOINPUT + LABEL       %>);
          setNoneToTrDisplay(<%= HOLIDAYYOUBI_HOLIDAYPATTERNINFOINPUT + LABEL   %>);

  <%
      } else if (uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.SPECIFIC_DAYEVERYYEAR)) { %>
          setNoneToTrDisplay(<%= HOLIDAYGROUP %>);
          setNoneToTrDisplay(<%= HOLIDAYGROUPCD_HOLIDAYPATTERNINFOINPUT %>);
          setNoneToTrDisplay(<%= HOLIDAYYMD_HOLIDAYPATTERNINFOINPUT + LABEL   %>);
          setNoneToTrDisplay(<%= HOLIDAYM_HOLIDAYPATTERNINFOINPUT + LABEL     %>);
          setNoneToTrDisplay(<%= HOLIDAYYOUBI_HOLIDAYPATTERNINFOINPUT + LABEL %>);

  <%
      } else if (uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.SPECIFIC_DAYOFWEEK)) { %>
          setNoneToTrDisplay(<%= HOLIDAYGROUP   %>);
          setNoneToTrDisplay(<%= HOLIDAYGROUPCD_HOLIDAYPATTERNINFOINPUT %>);
          setNoneToTrDisplay(<%= HOLIDAYYMD_HOLIDAYPATTERNINFOINPUT + LABEL   %>);
          setNoneToTrDisplay(<%= HOLIDAYMD_HOLIDAYPATTERNINFOINPUT + LABEL    %>);
          setNoneToTrDisplay(<%= HOLIDAYYOUBI_HOLIDAYPATTERNINFOINPUT + LABEL %>);

  <%
      } else if (uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.EVERY_WEEK)) { %>
          setNoneToTrDisplay(<%= HOLIDAYGROUP   %>);
          setNoneToTrDisplay(<%= HOLIDAYGROUPCD_HOLIDAYPATTERNINFOINPUT %>);
          setNoneToTrDisplay(<%= HOLIDAYYMD_HOLIDAYPATTERNINFOINPUT + LABEL %>);
          setNoneToTrDisplay(<%= HOLIDAYMD_HOLIDAYPATTERNINFOINPUT + LABEL  %>);
          setNoneToTrDisplay(<%= HOLIDAYM_HOLIDAYPATTERNINFOINPUT + LABEL   %>);

  <%
      } else if (
          uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.EQUINOX            ) ||
          uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.NATIONAL_HOLIDAY   ) ||
          uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.SUBSTITUTE_HOLIDAY1) ||
          uiBean.getHolidayYoyaku().getHolidayPattern().eq(C_HolidayPtn.SUBSTITUTE_HOLIDAY2)

      ) { %>
          setNoneToTrDisplay(<%= HOLIDAYGROUP   %>);
          setNoneToTrDisplay(<%= HOLIDAYGROUPCD_HOLIDAYPATTERNINFOINPUT %>);
          setNoneToTrDisplay(<%= HOLIDAYYMD_HOLIDAYPATTERNINFOINPUT + LABEL   %>);
          setNoneToTrDisplay(<%= HOLIDAYMD_HOLIDAYPATTERNINFOINPUT + LABEL    %>);
          setNoneToTrDisplay(<%= HOLIDAYM_HOLIDAYPATTERNINFOINPUT + LABEL     %>);
          setNoneToTrDisplay(<%= HOLIDAYYOUBI_HOLIDAYPATTERNINFOINPUT + LABEL %>);
  <%  }
  } %>
});

function setNoneToTrDisplay(selector) {
        $(selector).parent().parent().visible(false);
}

//-->
</script>