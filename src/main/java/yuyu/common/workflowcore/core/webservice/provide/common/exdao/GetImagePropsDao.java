package yuyu.common.workflowcore.core.webservice.provide.common.exdao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.core.webservice.common.WSCommonIOKey;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.IWSGetKouteiRirekiSummaryIOKey.AccountWariateUmu;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.meta.QWM_TorikomiSyorui;
import yuyu.def.db.meta.QWT_GyoumuKey;
import yuyu.def.db.meta.QWT_KouteiSummary;
import yuyu.def.db.meta.QWT_Page;
import yuyu.def.db.meta.QWT_TorikomiKanri;
import yuyu.def.db.meta.QWT_TorikomiRelation;

/**
 * イメージプロパティ取得API用の DAO クラスです。<br />
 */
public class GetImagePropsDao extends AbstractDao<WT_TorikomiKanri> {

    public GetImagePropsDao() {
        super(WT_TorikomiKanri.class);
    }

    public List<WT_TorikomiKanri> getTorikomiKanriByKouteiInfo(String[] pGyoumukeys, String[] pFlowids, String pKouteikaisibifrom,
        String pKouteikaisibito, String pKouteikanryoubifrom, String pKouteikanryoubito, String pLastSyoritimefrom,
        String pLastSyoritimeto, String[] pSyoristatus, String pAccountid, String pAccountwariateumu,
        String pNodename, Map<String, WSExtParam> pExtParam, String pTorikomiSyoruiCd,String pSyoruiToutyakuTimeFrom, String pSyoruiToutyakuTimeTo) {

        QWT_TorikomiRelation torikomiRelation = new QWT_TorikomiRelation("torikomiRelation");
        QWT_TorikomiKanri torikomiKanri = new QWT_TorikomiKanri("torikomiKanri");
        QWT_KouteiSummary kouteiSummary = new QWT_KouteiSummary("kouteiSummary");
        QWT_GyoumuKey gyoumukey = new QWT_GyoumuKey("gyoumuKey");
        QWT_Page page = new QWT_Page("page");

        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + torikomiKanri);
        mainQuery.append($FROM (gyoumukey,torikomiKanri));

        mainQuery.append($INNER_JOIN_FETCH + torikomiKanri.WT_TorikomiRelation() + $AS + torikomiRelation);
        mainQuery.append($INNER_JOIN_FETCH + torikomiRelation.WT_KouteiSummary() + $AS + kouteiSummary);
        mainQuery.append($WHERE + torikomiRelation.gyoumuKey.eq(gyoumukey.gyoumuKey));


        mainQuery.append(getWhereQuery(kouteiSummary, torikomiKanri, null,
            pGyoumukeys, pFlowids, pKouteikaisibifrom, pKouteikaisibito, pKouteikanryoubifrom, pKouteikanryoubito,
            pLastSyoritimefrom, pLastSyoritimeto, pSyoristatus, pAccountid, pAccountwariateumu,
            pNodename, pExtParam, pTorikomiSyoruiCd, null,null));

        if (StringUtils.isNotEmpty(pSyoruiToutyakuTimeFrom) || StringUtils.isNotEmpty(pSyoruiToutyakuTimeTo)) {
            mainQuery.append(
                $AND +
                $EXISTS(
                    $SELECT  + page.iwfImageId +
                    $FROM (page) +
                    $WHERE  +
                    torikomiKanri.iwfImageId.eq(page.iwfImageId) +
                    $AND + page.syoruittykymdtime.ge(pSyoruiToutyakuTimeFrom) +
                    $AND + page.syoruittykymdtime.le(pSyoruiToutyakuTimeTo)));
        }


        List<WT_TorikomiKanri> torikomiKanriList = em.createJPQL(mainQuery.toString()).bind(torikomiRelation, torikomiKanri, kouteiSummary, gyoumukey, page).getResultList();
        return new LinkedList<>(new LinkedHashSet<>(torikomiKanriList));
    }

    public Long getCount(String[] pGyoumukeys, String[] pFlowids, String pKouteikaisibifrom,
        String pKouteikaisibito, String pKouteikanryoubifrom, String pKouteikanryoubito, String pLastSyoritimefrom,
        String pLastSyoritimeto, String[] pSyoristatus, String pAccountid, String pAccountwariateumu,
        String pNodename, Map<String, WSExtParam> pExtParam, String pTorikomiSyoruiCd, String pSyoruiToutyakuTimeFrom, String pSyoruiToutyakuTimeTo) {

        QWT_Page page = new QWT_Page("page");
        QWT_TorikomiRelation torikomiRelation = new QWT_TorikomiRelation("torikomiRelation");
        QWT_TorikomiKanri torikomiKanri = new QWT_TorikomiKanri("torikomiKanri");
        QWT_KouteiSummary kouteiSummary = new QWT_KouteiSummary("kouteiSummary");
        QWT_GyoumuKey gyoumukey = new QWT_GyoumuKey("gyoumukey");

        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + $COUNT(torikomiKanri.iwfImageId));
        mainQuery.append($FROM (gyoumukey,torikomiKanri,torikomiRelation,kouteiSummary,page));
        mainQuery.append($WHERE + torikomiKanri.iwfImageId.eq(torikomiRelation.iwfImageId));
        mainQuery.append($AND + torikomiKanri.iwfImageId.eq(page.iwfImageId));
        mainQuery.append($AND + torikomiRelation.gyoumuKey.eq(kouteiSummary.gyoumuKey));
        mainQuery.append($AND + torikomiRelation.gyoumuKey.eq(gyoumukey.gyoumuKey));
        mainQuery.append($AND + page.pageno.eq(1));


        mainQuery.append(getWhereQuery(kouteiSummary, torikomiKanri, page,
            pGyoumukeys, pFlowids, pKouteikaisibifrom, pKouteikaisibito, pKouteikanryoubifrom, pKouteikanryoubito,
            pLastSyoritimefrom, pLastSyoritimeto, pSyoristatus, pAccountid, pAccountwariateumu,
            pNodename, pExtParam, pTorikomiSyoruiCd, pSyoruiToutyakuTimeFrom, pSyoruiToutyakuTimeTo));

        return em.createJPQL(mainQuery.toString()).bind(page, torikomiRelation, torikomiKanri, kouteiSummary, gyoumukey).getSingleResult();
    }

    private String getWhereQuery(QWT_KouteiSummary kouteiSummary, QWT_TorikomiKanri torikomiKanri, QWT_Page page,
        String[] pGyoumukeys, String[] pFlowids, String pKouteikaisibifrom, String pKouteikaisibito, String pKouteikanryoubifrom, String pKouteikanryoubito,
        String pLastSyoritimefrom, String pLastSyoritimeto, String[] pSyoristatus, String pAccountid,
        String pAccountwariateumu, String pNodename, Map<String, WSExtParam> pExtParam, String pTorikomiSyoruiCd, String pSyoruiToutyakuTimeFrom, String pSyoruiToutyakuTimeTo) {

        StringBuilder sbSql = new StringBuilder();


        if (null != pGyoumukeys && !ArrayUtils.isEmpty(pGyoumukeys)) {
            sbSql.append($AND + kouteiSummary.gyoumuKey.in(pGyoumukeys));
        }


        if (null != pFlowids && !ArrayUtils.isEmpty(pFlowids)) {
            sbSql.append($AND + kouteiSummary.flowId.in(pFlowids));
        }


        if (!StringUtils.isEmpty(pTorikomiSyoruiCd)) {
            sbSql.append($AND + torikomiKanri.torikomiSyoruiCd.in(pTorikomiSyoruiCd));
        }


        if (StringUtils.isNotEmpty(pKouteikaisibifrom) || StringUtils.isNotEmpty(pKouteikaisibito)) {
            sbSql.append($AND + kouteiSummary.iwfKouteiKaisiYmd.ge(StringUtils.isEmpty(pKouteikaisibifrom) ? "00000000" : pKouteikaisibifrom));
            sbSql.append($AND + kouteiSummary.iwfKouteiKaisiYmd.le(StringUtils.isEmpty(pKouteikaisibito) ? "99999999" : pKouteikaisibito));
        }


        if (StringUtils.isNotEmpty(pKouteikanryoubifrom) || StringUtils.isNotEmpty(pKouteikanryoubito)) {
            sbSql.append($AND + kouteiSummary.kouteiKanryouYmd.ge(StringUtils.isEmpty(pKouteikanryoubifrom) ? "00000000" : pKouteikanryoubifrom));
            sbSql.append($AND + kouteiSummary.kouteiKanryouYmd.le(StringUtils.isEmpty(pKouteikanryoubito) ? "99999999" : pKouteikanryoubito));
        }


        if (StringUtils.isNotEmpty(pLastSyoritimefrom) || StringUtils.isNotEmpty(pLastSyoritimeto)) {
            sbSql.append($AND + kouteiSummary.lastSyoriTime.ge(StringUtils.isEmpty(pLastSyoritimefrom) ? "00000000" : pLastSyoritimefrom));
            sbSql.append($AND + kouteiSummary.lastSyoriTime.le(StringUtils.isEmpty(pLastSyoritimeto) ? "99999999" : pLastSyoritimeto));
        }


        if (null != pSyoristatus && !ArrayUtils.isEmpty(pSyoristatus)) {
            sbSql.append($AND + kouteiSummary.syoriStatus.in(pSyoristatus));
        }



        if (StringUtils.isNotEmpty(pAccountid)) {
            sbSql.append($AND + kouteiSummary.genzaiAccountId.eq(pAccountid));
        } else if (AccountWariateUmu.sS_ARI.equals(pAccountwariateumu)) {
            sbSql.append($AND + kouteiSummary.genzaiAccountId.isNotNull());
        } else if (AccountWariateUmu.sS_NASI.equals(pAccountwariateumu)) {
            sbSql.append($AND + kouteiSummary.genzaiAccountId.isNull());
        }


        if (StringUtils.isNotEmpty(pNodename)) {
            sbSql.append($AND + kouteiSummary.nodeNm.eq(pNodename));
        }


        if (StringUtils.isNotEmpty(pSyoruiToutyakuTimeFrom) || StringUtils.isNotEmpty(pSyoruiToutyakuTimeTo)) {
            sbSql.append($AND + page.syoruittykymdtime.ge(pSyoruiToutyakuTimeFrom));
            sbSql.append($AND + page.syoruittykymdtime.le(pSyoruiToutyakuTimeTo));
        }


        sbSql.append(getExtParamQuery(kouteiSummary.extParam1, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM1)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam2, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM2)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam3, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM3)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam4, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM4)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam5, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM5)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam6, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM6)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam7, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM7)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam8, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM8)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam9, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM9)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam10, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM10)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam11, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM11)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam12, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM12)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam13, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM13)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam14, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM14)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam15, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM15)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam16, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM16)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam17, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM17)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam18, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM18)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam19, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM19)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam20, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM20)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam21, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM21)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam22, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM22)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam23, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM23)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam24, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM24)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam25, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM25)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam26, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM26)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam27, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM27)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam28, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM28)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam29, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM29)));
        sbSql.append(getExtParamQuery(kouteiSummary.extParam30, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM30)));

        return sbSql.toString();
    }

    public List<WT_TorikomiKanri> getTorikomiKanriByImageInfo(String pGyoumukey, String pFlowid,
        String pTorikomiSyoruiCd, String pSyzkdaibunruiid, String pSyzksyoubunruiid, String pSyoristatus, Map<String, WSExtParam> pExtParam,
        String pSyoruiToutyakuTimeFrom,String pSyoruiToutyakuTimeTo) {

        QWT_TorikomiRelation torikomiRelation = new QWT_TorikomiRelation("torikomiRelation");
        QWT_TorikomiKanri torikomiKanri = new QWT_TorikomiKanri("torikomiKanri");
        QWT_KouteiSummary kouteiSummary = new QWT_KouteiSummary("kouteiSummary");
        QWM_TorikomiSyorui torikomiSyorui = new QWM_TorikomiSyorui("torikomiSyorui");
        QWT_Page page = new QWT_Page("page");

        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + torikomiKanri);
        mainQuery.append($FROM (torikomiSyorui,torikomiKanri));

        mainQuery.append($INNER_JOIN_FETCH + torikomiKanri.WT_TorikomiRelation() + $AS + torikomiRelation);
        mainQuery.append($INNER_JOIN_FETCH + torikomiRelation.WT_KouteiSummary() + $AS + kouteiSummary);
        mainQuery.append($WHERE + torikomiSyorui.torikomiSyoruiCd.eq(torikomiKanri.torikomiSyoruiCd));


        mainQuery.append(getWhereQueryByImageInfo(kouteiSummary, torikomiKanri,torikomiSyorui,
            pGyoumukey, pFlowid, pTorikomiSyoruiCd,pSyzkdaibunruiid, pSyzksyoubunruiid, pSyoristatus, pExtParam));

        if (StringUtils.isNotEmpty(pSyoruiToutyakuTimeFrom) || StringUtils.isNotEmpty(pSyoruiToutyakuTimeTo)) {
            mainQuery.append(
                $AND +
                $EXISTS(
                    $SELECT  + page.iwfImageId +
                    $FROM (page) +
                    $WHERE  +
                    torikomiKanri.iwfImageId.eq(page.iwfImageId) +
                    $AND + page.syoruittykymdtime.ge(pSyoruiToutyakuTimeFrom) +
                    $AND + page.syoruittykymdtime.le(pSyoruiToutyakuTimeTo)));
        }

        List<WT_TorikomiKanri> torikomiKanriList = em.createJPQL(mainQuery.toString()).bind(torikomiRelation, torikomiKanri, kouteiSummary, torikomiSyorui, page).getResultList();
        return new LinkedList<>(new LinkedHashSet<>(torikomiKanriList));
    }

    private String getWhereQueryByImageInfo(
        QWT_KouteiSummary kouteiSummary, QWT_TorikomiKanri torikomiKanri, QWM_TorikomiSyorui torikomiSyorui,
        String pGyoumukey, String pFlowid,String pTorikomiSyoruiCd, String pSyzkdaibunruiid, String pSyzksyoubunruiid, String pSyoristatus, Map<String, WSExtParam> pExtParam) {

        StringBuilder sbSql = new StringBuilder();


        if (!StringUtils.isEmpty(pGyoumukey)) {
            sbSql.append($AND + kouteiSummary.gyoumuKey.in(pGyoumukey));
        }


        if (!StringUtils.isEmpty(pFlowid)) {
            sbSql.append($AND + kouteiSummary.flowId.in(pFlowid));
        }


        if (!StringUtils.isEmpty(pTorikomiSyoruiCd)) {
            sbSql.append($AND + torikomiSyorui.torikomiSyoruiCd.in(pTorikomiSyoruiCd));
        }


        if (!StringUtils.isEmpty(pSyoristatus)) {
            sbSql.append($AND + kouteiSummary.syoriStatus.in(pSyoristatus));
        }


        if (StringUtils.isNotEmpty(pSyzkdaibunruiid)) {
            sbSql.append($AND + torikomiSyorui.syzkDaiBunruiId.eq(pSyzkdaibunruiid));
        }


        if (StringUtils.isNotEmpty(pSyzkdaibunruiid)) {
            sbSql.append($AND + torikomiSyorui.syzkSyouBunruiId.eq(pSyzksyoubunruiid));
        }

        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam1, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM1)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam2, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM2)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam3, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM3)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam4, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM4)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam5, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM5)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam6, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM6)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam7, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM7)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam8, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM8)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam9, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM9)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam10, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM10)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam11, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM11)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam12, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM12)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam13, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM13)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam14, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM14)));
        sbSql.append(getExtParamQueryTorikomiKanri(torikomiKanri.extParam15, pExtParam.get(WSCommonIOKey.IN.sS_EXTPARAM15)));

        return sbSql.toString();
    }

    @SuppressWarnings("deprecation")
    private String getExtParamQuery( ExDBFieldString<WT_KouteiSummary, String> pField, WSExtParam pExtParam) {

        StringBuilder sbSql = new StringBuilder();

        if (null == pExtParam) {
            return sbSql.toString();
        }


        if (null != pExtParam.getValues()){

            if (1 == pExtParam.getValues().length){
                if (StringUtils.isNotEmpty(pExtParam.getValues()[0])){

                    sbSql.append($AND + pField.eq(pExtParam.getValues()[0]));
                }
            }

            else if (1 < pExtParam.getValues().length){

                sbSql.append($AND + pField.in(pExtParam.getValues()));
            }
        }

        else {

            if (StringUtils.isNotEmpty(pExtParam.getValueFrom())){
                sbSql.append($AND + pField.ge(pExtParam.getValueFrom()));
            }

            if (StringUtils.isNotEmpty(pExtParam.getValueTo())){
                sbSql.append($AND + pField.le(pExtParam.getValueTo()));
            }
        }
        return sbSql.toString();
    }

    @SuppressWarnings("deprecation")
    private String getExtParamQueryTorikomiKanri( ExDBFieldString<WT_TorikomiKanri, String> pField, WSExtParam pExtParam) {

        StringBuilder sbSql = new StringBuilder();

        if (null == pExtParam) {
            return sbSql.toString();
        }


        if (null != pExtParam.getValues()){

            if (1 == pExtParam.getValues().length){
                if (StringUtils.isNotEmpty(pExtParam.getValues()[0])){

                    sbSql.append($AND + pField.eq(pExtParam.getValues()[0]));
                }
            }

            else if (1 < pExtParam.getValues().length){

                sbSql.append($AND + pField.in(pExtParam.getValues()));
            }
        }

        else {

            if (StringUtils.isNotEmpty(pExtParam.getValueFrom())){
                sbSql.append($AND + pField.ge(pExtParam.getValueFrom()));
            }

            if (StringUtils.isNotEmpty(pExtParam.getValueTo())){
                sbSql.append($AND + pField.le(pExtParam.getValueTo()));
            }
        }
        return sbSql.toString();
    }
}