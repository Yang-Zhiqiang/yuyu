<%--
    ds_kokyaku_seibi.js.jsp - 顧客整備 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*"%>
<%@page
	import="static yuyu.app.direct.dskokyakukanri.dskokyakuseibi.DsKokyakuSeibiConstants.*"%>
<%@page
	import="static yuyu.app.direct.dskokyakukanri.dskokyakuseibi.DsKokyakuSeibiSelector.*"%>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector"%>
<%@page
	import="yuyu.app.direct.dskokyakukanri.dskokyakuseibi.DsKokyakuSeibiUiBean"%>
<%@page import="yuyu.def.classification.C_DsKokyakuJtKbn"%>
<%@page import="yuyu.def.classification.C_DsTeisiRiyuuKbn"%>
<%@page import="yuyu.def.classification.C_DsKinouModeIdKbn"%>
<%@page import="yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn"%>
<% DsKokyakuSeibiUiBean uiBean = SWAKInjector.getInstance(DsKokyakuSeibiUiBean.class); %>
<script type="text/javascript"><!--
$(function(){

    <%if (uiBean.getPageNo() == PAGENO_INPUTKEYSELECT) { %>
        <% if (uiBean.getSearchResultInfoDataSource().getAllData().size() > 0) {%>
            showList(<%=SEARCHRESULTINFO%>);
            $("<%= SEIBIRIYUUKBN_LABEL %>").each(function(){
              $(this).visible(false);
            });
            $("<%= SEIBIRIYUUKBN_DATA %>").each(function(){
              $(this).visible(false);
            });
            $("<%= SYORIYMD_LABEL %>").each(function(){
              $(this).visible(false);
            });
            $("<%= SYORIYMD_DATA %>").each(function(){
              $(this).visible(false);
            });
            $("<%= SYORIZUMIFLG_LABEL %>").each(function(){
              $(this).visible(false);
            });
            $("<%= SYORIZUMIFLG_DATA %>").each(function(){
              $(this).visible(false);
            });
            $("<%= DSKOKNO_LABEL %>").attr("rowspan","2");
            $("<%= DSKOKNO_DATA %>").attr("rowspan","2");
            $("<%= SYONO_LABEL %>").attr("rowspan","2");
            $("<%= SYONO_DATA %>").attr("rowspan","2");
            $("<%= DSKOKYAKUNMKJ_LABEL %>").attr("colspan","3");
            $("<%= DSKOKYAKUNMKJ_DATA %>").attr("colspan","3");
            $("<%= DSKOKYAKUSEIYMD_LABEL %>").attr("colspan","1");
            $("<%= DSKOKYAKUSEIYMD_DATA %>").attr("colspan","1");
            $("<%= DSKOKYAKUJTKBN_LABEL %>").attr("rowspan","2");
            $("<%= DSKOKYAKUJTKBN_DATA %>").attr("rowspan","2");
            $("<%= PASSWORDJTKBN_LABEL %>").attr("rowspan","2");
            $("<%= PASSWORDJTKBN_DATA %>").attr("rowspan","2");
            $("<%= DSKOKYAKUNMKN_LABEL %>").attr("colspan","3");
            $("<%= DSKOKYAKUNMKN_DATA %>").attr("colspan","3");
            $("<%= DSKOKYAKUYNO_LABEL %>").attr("colspan","1");
            $("<%= DSKOKYAKUYNO_DATA %>").attr("colspan","1");
            $("<%= DSKOKNO_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
            );
            $("<%= SYONO_LABEL %>").each(
              function(){
                $(this).css("width", "15%");
              }
            );
            $("<%= DSKOKYAKUNMKJ_LABEL %>").each(
              function(){
                $(this).css("width", "35%");
              }
            );
            $("<%= DSKOKYAKUSEIYMD_LABEL %>").each(
              function(){
                $(this).css("width", "11%");
              }
            );
            $("<%= DSKOKYAKUJTKBN_LABEL %>").each(
              function(){
                $(this).css("width", "12%");
              }
            );
            $("<%= PASSWORDJTKBN_LABEL %>").each(
              function(){
                $(this).css("width", "12%");
              }
            );
        <% } %>
    <%} else if (uiBean.getPageNo() == PAGENO_SEIBITSSEARCH) { %>
        <% if (uiBean.getSearchResultInfoDataSource().getAllData().size() > 0) {%>
            showList(<%=SEARCHRESULTINFO%>);
            $("<%= DSKOKNO_LABEL %>").attr("rowspan","2");
            $("<%= DSKOKNO_DATA %>").attr("rowspan","2");
            $("<%= SYONO_LABEL %>").attr("rowspan","2");
            $("<%= SYONO_DATA %>").attr("rowspan","2");
            $("<%= DSKOKYAKUJTKBN_LABEL %>").attr("rowspan","2");
            $("<%= DSKOKYAKUJTKBN_DATA %>").attr("rowspan","2");
            $("<%= PASSWORDJTKBN_LABEL %>").attr("rowspan","2");
            $("<%= PASSWORDJTKBN_DATA %>").attr("rowspan","2");
            $("<%= SEIBIRIYUUKBN_LABEL %>").attr("rowspan","2");
            $("<%= SEIBIRIYUUKBN_DATA %>").attr("rowspan","2");
            $("<%= SYORIYMD_LABEL %>").attr("rowspan","2");
            $("<%= SYORIYMD_DATA %>").attr("rowspan","2");
            $("<%= SYORIZUMIFLG_LABEL %>").attr("rowspan","2");
            $("<%= SYORIZUMIFLG_DATA %>").attr("rowspan","2");
            $("<%= DSKOKYAKUNMKN_LABEL %>").attr("colspan","1");
            $("<%= DSKOKYAKUNMKN_DATA %>").attr("colspan","1");
            $("<%= DSKOKYAKUYNO_LABEL %>").attr("colspan","1");
            $("<%= DSKOKYAKUYNO_DATA %>").attr("colspan","1");

            $("<%= DSKOKNO_LABEL %>").each(
              function(){
                $(this).css("width", "12%");
              }
            );
            $("<%= SYONO_LABEL %>").each(
              function(){
                $(this).css("width", "12%");
              }
            );
            $("<%= DSKOKYAKUNMKJ_LABEL %>").each(
              function(){
                $(this).css("width", "24%");
              }
            );
            $("<%= DSKOKYAKUSEIYMD_LABEL %>").each(
              function(){
                $(this).css("width", "12%");
              }
            );
            $("<%= DSKOKYAKUJTKBN_LABEL %>").each(
              function(){
                $(this).css("width", "7%");
              }
            );
            $("<%= PASSWORDJTKBN_LABEL %>").each(
              function(){
                $(this).css("width", "8%");
              }
            );
            $("<%= SEIBIRIYUUKBN_LABEL %>").each(
              function(){
                $(this).css("width", "7%");
              }
            );
            $("<%= SYORIYMD_LABEL %>").each(
              function(){
                $(this).css("width", "9%");
              }
            );
            $("<%= SYORIZUMIFLG_LABEL %>").each(
              function(){
                $(this).css("width", "9%");
              }
            );
        <% } %>
    <%} else if (uiBean.getPageNo() == PAGENO_TKTITRHKYUKOUZASEARCH) { %>
        <% if (uiBean.getSrchRsltKzInfoDataSource().getAllData().size() > 0) {%>
            showList(<%=SRCHRSLTKZINFO%>);
            $("<%= DISPKOUAZANO_LABEL %>").attr("rowspan","2");
            $("<%= DISPKOUAZANO_DATA %>").attr("rowspan","2");
            $("<%= DISPKZMEIGINMKN_LABEL %>").attr("colspan","1");
            $("<%= DISPKZMEIGINMKN_DATA %>").attr("colspan","1");
            $("<%= DSKOKNO_LABEL %>").attr("rowspan","2");
            $("<%= DSKOKNO_DATA %>").attr("rowspan","2");
            $("<%= SYONO_LABEL %>").attr("rowspan","2");
            $("<%= SYONO_DATA %>").attr("rowspan","2");
        <% } %>
    <%} else if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS) { %>
        <%if (C_DsKinouModeIdKbn.TEISEI.equals(uiBean.getKinouMode())) { %>
            showGroup(<%=DRCTSERVICEINFO1%>);
            showKoumoku(<%= INPUTDSKANYUUKEIROKBN_DSKOKYAKUJTINFO%>);
            showKoumoku(<%=INPUTDSMAILADDRESS_DSMAILADDRESSINFO%>);
            showKoumoku(<%=INPUTDSMAILSOUSINJTKBN_DSMAILADDRESSINFO%>);
            showKoumoku(<%= INPUTDSMAILSOUSINTISRYKBN_DSMAILADDRESSINFO%>);
            showKoumoku(<%= INPUTSEISAHUYOUHYJ_MONTHJISEISAINFO%>);
            $("<%= KYKNMKJ_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= INPUTDSKOKYAKUNMKJ_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= DSKOKNO_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= KRPASSWORDUMUKBN_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= HONPASSWORDUMUKBN_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= SYOKAILOGINYMD_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= INPUTSEISAHUYOUHYJ_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= LASTJYUUHENYMD_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%=DSMAILADDRESSRENBAN_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
        <% } else { %>

            showGroup(<%=DRCTSERVICEINFO%>);
            showKoumoku(<%= DSKANYUUKEIROKBN_DSKOKYAKUJTINFO%>);
            showKoumoku(<%=DSMAILADDRESS_DSMAILADDRESSINFO%>);
            showKoumoku(<%=DSMAILSOUSINJYOUTAIKBN_DSMAILADDRESSINFO%>);
            showKoumoku(<%= DSMAILSOUSINTISRYKBN_DSMAILADDRESSINFO%>);
            showKoumoku(<%= SEISAHUYOUHYJ_MONTHJISEISAINFO%>);

            $("<%= KYKNMKJ_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= DSKOKYAKUNMKJ_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= DSKOKNO_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= KRPASSWORDUMUKBN_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= HONPASSWORDUMUKBN_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= SYOKAILOGINYMD_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= SEISAHUYOUHYJ_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%= LASTJYUUHENYMD_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
            $("<%=DSMAILADDRESSRENBAN_LABEL%>").each(
              function(){
                $(this).css("width", "16%");
              }
            );
        <% } %>

        <%
        if (C_DsKinouModeIdKbn.TEISEI.equals(uiBean.getKinouMode())) { %>
          <%
            if (C_DsKokyakuJtKbn.YUUKOU.eq(uiBean.getDskokyakujtkbn()) ||
                (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn()) &&
                  (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(uiBean.getDsteisiriyuukbn()) ||
                  C_DsTeisiRiyuuKbn.SONOTA.eq(uiBean.getDsteisiriyuukbn())))) { %>
               showKoumoku(<%= INPUTDSTEISIRIYUUKBN_DSKOKYAKUJTINFO%>);
            <%
            } else { %>
               showKoumoku(<%= DSTEISIRIYUUKBN_DSKOKYAKUJTINFO%>);
            <% } %>
        <%
        } else if (C_DsKinouModeIdKbn.ACCOUNTJYOUTAIHENKOU.equals(uiBean.getKinouMode())) {%>
            <%
            if (C_DsKokyakuJtKbn.YUUKOU.eq(uiBean.getDskokyakujtkbn())) { %>
               showKoumoku(<%= INPUTDSTEISIRIYUUKBN_DSKOKYAKUJTINFO%>);
            <%
            } else { %>
               showKoumoku(<%= DSTEISIRIYUUKBN_DSKOKYAKUJTINFO%>);
            <% } %>
        <%
        } else { %>
               showKoumoku(<%= DSTEISIRIYUUKBN_DSKOKYAKUJTINFO%>);
        <% } %>

        <%
          if (C_DsKinouModeIdKbn.TEISEI.equals(uiBean.getKinouMode())) { %>
            <%
              if (C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU.eq(uiBean.getDsteisiriyuukbn())) { %>
                showKoumoku(<%= INPUTDSKRHNNKAKCDTTYHKBN_KRPASSWORDINFO%>);
            <%
              } else { %>
                showKoumoku(<%= DSKRHNNKAKCDTTYHKBN_KRPASSWORDINFO%>);
            <% } %>
         <%
           } else { %>
             showKoumoku(<%= DSKRHNNKAKCDTTYHKBN_KRPASSWORDINFO%>);
          <% } %>

        <%if (C_DsKinouModeIdKbn.ACCOUNTJYOUTAIHENKOU.equals(uiBean.getKinouMode())
           || C_DsKinouModeIdKbn.TEISEI.equals(uiBean.getKinouMode())) { %>

            showGroup(<%=FOOTERBUTTONS4%>);

            <%if (uiBean.getYuukoukykhyuFlg()) { %>
                $(<%= ACCOUNTLOCKKAIJYOBTN_FOOTERBUTTONS4%>).visible(true);
            <% } %>

            <%if (C_DsKokyakuJtKbn.YUUKOU.eq(uiBean.getDskokyakujtkbn())) { %>
                $(<%= SERVICETEISIBTN_FOOTERBUTTONS4%>).visible(true);
            <% } %>

            <%if (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn())
               && (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(uiBean.getDsteisiriyuukbn())
                 || C_DsTeisiRiyuuKbn.SONOTA.eq(uiBean.getDsteisiriyuukbn()))
               && uiBean.getYuukoukykhyuFlg() == true) { %>
                $(<%= SERVICESAIKAIBTN_FOOTERBUTTONS4%>).visible(true);
            <% } %>

           <%
             if (C_DsKinouModeIdKbn.TEISEI.equals(uiBean.getKinouMode())) { %>
               <%
                 if (C_DsKokyakuJtKbn.YUUKOU.eq(uiBean.getDskokyakujtkbn()) ||
                     C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn())) { %>
                      $(<%= DSKAIYAKUBTN_FOOTERBUTTONS4%>).visible(true);
               <% } %>
            <% } %>
        <% } %>

        <%if (C_DsKinouModeIdKbn.TEISEI.equals(uiBean.getKinouMode())) { %>

            $(<%= KAKUNINBTN_FOOTERBUTTONS3%>).visible(true);

        <% } %>

    <%} else if (uiBean.getPageNo() == PAGENO_CONFIRM || uiBean.getPageNo() == PAGENO_RESULT) { %>

        $("<%= KYKNMKJ_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );
        $("<%= KAKUNINDSKOKYAKUNMKJ_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );
        $("<%= DSKOKNO_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );
        $("<%= KAKUNINKRPASSWORDUMUKBN_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );
        $("<%= KAKUNINHONPASSWORDUMUKBN_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );
        $("<%= SYOKAILOGINYMD_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );
        $("<%= KAKUNINSEISAHUYOUHYJ_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );
        $("<%= LASTJYUUHENYMD_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );
        $("<%= DSMAILADDRESSRENBAN_LABEL%>").each(
          function(){
            $(this).css("width", "16%");
          }
        );

    <%} else if (uiBean.getPageNo() == PAGENO_KYKBTINPUTCONTENTS) { %>
        <%if (!C_DsKinouModeIdKbn.SYOUKAI.eq(uiBean.getKinouMode()) &&
            (C_DsKokyakuJtKbn.YUUKOU.eq(uiBean.getDskokyakujtkbn()) ||
                C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn())) &&
            C_DsTrhkserviceRiyoujkKbn.RIYOU_KA.eq(uiBean.getDstrhkserviceriyoujkkbn())) { %>

            showKoumoku(<%= INPUTDSTRHKSVCTISRYKBN_TRHKSERVICETOUROKUJK%>);

            showGroup(<%=FOOTERBUTTONS8%>);

        <%
        } else { %>

            showKoumoku(<%= DSTRHKSERVICETEISIRIYUUKBN_TRHKSERVICETOUROKUJK%>);
        <% } %>
    <% } %>
});
//-->
</script>
