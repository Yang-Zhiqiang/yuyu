<%--
    si_make_seikyuu_info_f.js.jsp - 請求情報ファイル作成 JavaScript(JSP)
--%>
<%@page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="static jp.co.slcs.swak.web.struts.ui.IdSelectorConstants.*" %>
<%@page import="static yuyu.app.siharai.simakefile.simakeseikyuuinfof.SiMakeSeikyuuInfoFConstants.*" %>
<%@page import="static yuyu.app.siharai.simakefile.simakeseikyuuinfof.SiMakeSeikyuuInfoFSelector.*"  %>
<%@page import="jp.co.slcs.swak.core.inject.SWAKInjector" %>
<%@page import="yuyu.app.siharai.simakefile.simakeseikyuuinfof.SiMakeSeikyuuInfoFUiBean" %>
<%@page import="yuyu.def.classification.C_SiharaiSyoriJyoutaiKbn" %>
<% SiMakeSeikyuuInfoFUiBean uiBean = SWAKInjector.getInstance(SiMakeSeikyuuInfoFUiBean.class); %>
<script type="text/javascript">
$(function(){
<%
    if (uiBean.getPageNo() == PAGENO_INPUTCONDITIONS) { %>
        <%
        if (C_SiharaiSyoriJyoutaiKbn.MISEIKYUU.eq(uiBean.getSiharaisyorijyoutaikbn())) { %>
            removeReadOnlyGray(<%= SIBOUYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUYMDTO_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>);
            $(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>);
            $(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>);
            $(<%= SHRYMDFROM_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SHRYMDFROM_OUTCONDITIONS %>);
            $(<%= SHRYMDTO_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SHRYMDTO_OUTCONDITIONS %>);
        <% }%>

        <%
        if (C_SiharaiSyoriJyoutaiKbn.UKETUKETYUU.eq(uiBean.getSiharaisyorijyoutaikbn())) { %>
            removeReadOnlyGray(<%= SIBOUYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUYMDTO_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>);
            $(<%= SHRYMDFROM_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SHRYMDFROM_OUTCONDITIONS %>);
            $(<%= SHRYMDTO_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SHRYMDTO_OUTCONDITIONS %>);
        <% }%>

        <%
        if (C_SiharaiSyoriJyoutaiKbn.SINDANSYORYOUSIHARAI.eq(uiBean.getSiharaisyorijyoutaikbn())) { %>
            removeReadOnlyGray(<%= SHRYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SHRYMDTO_OUTCONDITIONS%>);
            $(<%= SIBOUYMDFROM_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SIBOUYMDFROM_OUTCONDITIONS %>);
            $(<%= SIBOUYMDTO_OUTCONDITIONS%>).val('');
            setReadOnlyGray(<%= SIBOUYMDTO_OUTCONDITIONS %>);
            $(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>);
            $(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>);
            $(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>).val('');
            setReadOnlyGray(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>);
            $(<%= SYORUIUKEYMDTO_OUTCONDITIONS%>).val('');
            setReadOnlyGray(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>);
        <% }%>

        <%
        if (C_SiharaiSyoriJyoutaiKbn.SIHARAIZUMI.eq(uiBean.getSiharaisyorijyoutaikbn())) { %>
            removeReadOnlyGray(<%= SIBOUYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUYMDTO_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SHRYMDFROM_OUTCONDITIONS %>);
            removeReadOnlyGray(<%= SHRYMDTO_OUTCONDITIONS %>);
        <% }%>

        $(<%= SIHARAISYORIJYOUTAIKBN_OUTCONDITIONS %>).change(function(){
            var siharaisyorijyoutaikbn = $(<%= SIHARAISYORIJYOUTAIKBN_OUTCONDITIONS %>).val();
            if(siharaisyorijyoutaikbn == '<%= C_SiharaiSyoriJyoutaiKbn.MISEIKYUU.getValue() %>'){
                removeReadOnlyGray(<%= SIBOUYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUYMDTO_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>);
                $(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>);
                $(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>);
                $(<%= SHRYMDFROM_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SHRYMDFROM_OUTCONDITIONS %>);
                $(<%= SHRYMDTO_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SHRYMDTO_OUTCONDITIONS %>);
            }

            if(siharaisyorijyoutaikbn == '<%= C_SiharaiSyoriJyoutaiKbn.UKETUKETYUU.getValue() %>'){
                removeReadOnlyGray(<%= SIBOUYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUYMDTO_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>);
                $(<%= SHRYMDFROM_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SHRYMDFROM_OUTCONDITIONS %>);
                $(<%= SHRYMDTO_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SHRYMDTO_OUTCONDITIONS %>);
            }

            if(siharaisyorijyoutaikbn == '<%= C_SiharaiSyoriJyoutaiKbn.SINDANSYORYOUSIHARAI.getValue() %>'){
                removeReadOnlyGray(<%= SHRYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SHRYMDTO_OUTCONDITIONS%>);
                $(<%= SIBOUYMDFROM_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SIBOUYMDFROM_OUTCONDITIONS %>);
                $(<%= SIBOUYMDTO_OUTCONDITIONS%>).val('');
                setReadOnlyGray(<%= SIBOUYMDTO_OUTCONDITIONS %>);
                $(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>);
                $(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>);
                $(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>).val('');
                setReadOnlyGray(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>);
                $(<%= SYORUIUKEYMDTO_OUTCONDITIONS%>).val('');
                setReadOnlyGray(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>);
            }

            if(siharaisyorijyoutaikbn == '<%= C_SiharaiSyoriJyoutaiKbn.SIHARAIZUMI.getValue() %>'){
                removeReadOnlyGray(<%= SIBOUYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUYMDTO_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUKARIYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SIBOUKARIYMDTO_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SYORUIUKEYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SYORUIUKEYMDTO_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SHRYMDFROM_OUTCONDITIONS %>);
                removeReadOnlyGray(<%= SHRYMDTO_OUTCONDITIONS %>);
            }
        })
    <% }%>
});
</script>
