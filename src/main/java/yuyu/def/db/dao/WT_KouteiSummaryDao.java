package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

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
import yuyu.def.db.id.PKWT_KouteiSummary;
import yuyu.def.db.meta.QWT_KouteiSummary;

/**
 * 工程サマリテーブル(WT_KouteiSummary) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_KouteiSummaryDao extends AbstractDao<WT_KouteiSummary> {

    public WT_KouteiSummaryDao() {

        super(WT_KouteiSummary.class);
    }

    public WT_KouteiSummary getKouteiSummary(String pGyoumuKey) {
        return selectPk(new PKWT_KouteiSummary(pGyoumuKey));
    }

    public List<WT_KouteiSummary> getAllKouteiSummary() {

        return selectAll();
    }

    public Long getCount(String[] pGyoumukeys, String[] pFlowids, String pKouteikaisibifrom, String pKouteikaisibito,
        String pKouteikanryoubifrom, String pKouteikanryoubito, String pLastSyoritimefrom, String pLastSyoritimeto,
        String[] pSyoristatus, String pAccountid, String pAccountwariateumu, String pNodename,
        Map<String, WSExtParam> pExtParam) {

        QWT_KouteiSummary kouteiSummary = new QWT_KouteiSummary("kouteiSummary");

        StringBuffer mainQuery = new StringBuffer();

        mainQuery.append($SELECT + $COUNT(kouteiSummary.gyoumuKey));
        mainQuery.append(getWhereQuery(kouteiSummary, pGyoumukeys, pFlowids, pKouteikaisibifrom, pKouteikaisibito,
            pKouteikanryoubifrom, pKouteikanryoubito, pLastSyoritimefrom, pLastSyoritimeto, pSyoristatus,
            pAccountid, pAccountwariateumu, pNodename, pExtParam));

        return em.createJPQL(mainQuery.toString()).bind(kouteiSummary).getSingleResult();
    }

    public List<WT_KouteiSummary> getKouteiSummarys(String[] pGyoumukeys, String[] pFlowids, String pKouteikaisibifrom,
        String pKouteikaisibito, String pKouteikanryoubifrom, String pKouteikanryoubito, String pLastSyoritimefrom,
        String pLastSyoritimeto, String[] pSyoristatus, String pAccountid, String pAccountwariateumu,
        String pNodename, Map<String, WSExtParam> pExtParam) {

        QWT_KouteiSummary kouteiSummary = new QWT_KouteiSummary("kouteiSummary");

        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + kouteiSummary);
        mainQuery.append(getWhereQuery(kouteiSummary, pGyoumukeys, pFlowids, pKouteikaisibifrom, pKouteikaisibito,
            pKouteikanryoubifrom, pKouteikanryoubito, pLastSyoritimefrom, pLastSyoritimeto, pSyoristatus,
            pAccountid, pAccountwariateumu, pNodename, pExtParam));

        return em.createJPQL(mainQuery.toString()).bind(kouteiSummary).getResultList();
    }

    private String getWhereQuery(QWT_KouteiSummary kouteiSummary, String[] pGyoumukeys, String[] pFlowids,
        String pKouteikaisibifrom, String pKouteikaisibito, String pKouteikanryoubifrom, String pKouteikanryoubito,
        String pLastSyoritimefrom, String pLastSyoritimeto, String[] pSyoristatus, String pAccountid,
        String pAccountwariateumu, String pNodename, Map<String, WSExtParam> pExtParam) {

        StringBuilder sbSql = new StringBuilder();
        sbSql.append($FROM + kouteiSummary.WT_KouteiSummary());
        sbSql.append($WHERE + kouteiSummary.gyoumuKey.eq(kouteiSummary.gyoumuKey));

        if (null != pGyoumukeys && !ArrayUtils.isEmpty(pGyoumukeys)) {

            sbSql.append($AND + kouteiSummary.gyoumuKey.in(pGyoumukeys));
        }

        if (null != pFlowids && !ArrayUtils.isEmpty(pFlowids)) {

            sbSql.append($AND + kouteiSummary.flowId.in(pFlowids));
        }

        if (StringUtils.isNotEmpty(pKouteikaisibifrom) || StringUtils.isNotEmpty(pKouteikaisibito)) {

            sbSql.append($AND + kouteiSummary.iwfKouteiKaisiYmd.ge(getYmdFrom(pKouteikaisibifrom)));
            sbSql.append($AND + kouteiSummary.iwfKouteiKaisiYmd.le(getYmdTo(pKouteikaisibito)));
        }

        if (StringUtils.isNotEmpty(pKouteikanryoubifrom) || StringUtils.isNotEmpty(pKouteikanryoubito)) {

            sbSql.append($AND + kouteiSummary.kouteiKanryouYmd.ge(getYmdFrom(pKouteikanryoubifrom)));
            sbSql.append($AND + kouteiSummary.kouteiKanryouYmd.le(getYmdTo(pKouteikanryoubito)));
        }

        if (StringUtils.isNotEmpty(pLastSyoritimefrom) || StringUtils.isNotEmpty(pLastSyoritimeto)) {

            sbSql.append($AND + kouteiSummary.lastSyoriTime.ge(pLastSyoritimefrom));
            sbSql.append($AND + kouteiSummary.lastSyoriTime.le(pLastSyoritimeto));
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

    private String getYmdFrom(String pYmdFrom) {

        return StringUtils.isEmpty(pYmdFrom) ? "00000000" : pYmdFrom;
    }

    private String getYmdTo(String pYmdTo) {

        return StringUtils.isEmpty(pYmdTo) ? "99999999" : pYmdTo;
    }
}