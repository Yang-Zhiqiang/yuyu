package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.apache.commons.lang.StringUtils;

import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.id.PKWT_KouteiRireki;
import yuyu.def.db.meta.QWT_GyoumuKey;
import yuyu.def.db.meta.QWT_KouteiRireki;

/**
 * 工程履歴テーブル(WT_KouteiRireki) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_KouteiRirekiDao extends AbstractDao<WT_KouteiRireki> {

    public WT_KouteiRirekiDao() {

        super(WT_KouteiRireki.class);
    }

    public WT_KouteiRireki getKouteiRireki(String pTokenId, C_RirekiKbn pRirekiKbn, String pSyoriTime) {

        return selectPk(new PKWT_KouteiRireki(pTokenId, pRirekiKbn, pSyoriTime));
    }

    public List<WT_KouteiRireki> getAllKouteiRireki() {

        return selectAll();
    }

    public List<String> getKouteiRirekis() {

        QWT_GyoumuKey gyoumuKey = new QWT_GyoumuKey("gyoumuKey");
        QWT_KouteiRireki kouteiRireki = new QWT_KouteiRireki("kouteiRireki");

        String subQuery = $SELECT_DISTINCT + gyoumuKey.gyoumuKey
            + $FROM + gyoumuKey.WT_GyoumuKey()
            + $WHERE + gyoumuKey.gyoumuKey.eq(kouteiRireki.gyoumuKey);

        String mainQuery = $SELECT_DISTINCT + kouteiRireki
            + $FROM + kouteiRireki.WT_KouteiRireki()
            + $WHERE + $EXISTS(subQuery);

        return em.createJPQL(mainQuery).bind(gyoumuKey, kouteiRireki).getResultList();
    }

    public Long getCount(String pGyoumukey, String pFlowid, C_RirekiKbn pRirekiKbn) {

        QWT_KouteiRireki kouteiRireki = new QWT_KouteiRireki("kouteiRireki");

        StringBuffer mainQuery = new StringBuffer();

        mainQuery.append($SELECT + $COUNT(kouteiRireki.gyoumuKey));
        mainQuery.append(getWhereQuery(kouteiRireki, pGyoumukey, pFlowid, pRirekiKbn));

        return em.createJPQL(mainQuery.toString()).bind(kouteiRireki).getSingleResult();
    }

    public List<WT_KouteiRireki> getKouteiRirekis(String pGyoumukey, String pFlowid, C_RirekiKbn pRirekiKbn) {

        QWT_KouteiRireki kouteiRireki = new QWT_KouteiRireki("kouteiRireki");

        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + kouteiRireki);
        mainQuery.append(getWhereQuery(kouteiRireki, pGyoumukey, pFlowid, pRirekiKbn));

        return em.createJPQL(mainQuery.toString()).bind(kouteiRireki).getResultList();
    }

    public List<WT_KouteiRireki> getKouteiRirekis(String pUserId, List<String> pListFlowid, C_RirekiKbn pRirekiKbn,
        String pSyoriTimeFrom, String pSyoriTimeTo) {

        QWT_KouteiRireki kouteiRireki = new QWT_KouteiRireki("kouteiRireki");
        String[] flowIds = pListFlowid.toArray(new String[pListFlowid.size()]);

        StringBuffer query = new StringBuffer();
        query.append($SELECT + kouteiRireki);
        query.append($FROM + kouteiRireki.WT_KouteiRireki());
        query.append($WHERE + kouteiRireki.userId.eq(pUserId));
        query.append($AND + kouteiRireki.rirekiKbn.eq(pRirekiKbn));
        query.append($AND + kouteiRireki.flowId.in(flowIds));
        query.append($AND + kouteiRireki.syoriTime + $BETWEEN + pSyoriTimeFrom + $AND + pSyoriTimeTo);
        query.append($ORDER_BY(kouteiRireki.syoriTime.asc()));

        return em.createJPQL(query.toString()).bind(kouteiRireki).getResultList();
    }

    private String getWhereQuery(QWT_KouteiRireki pKouteiRireki, String pGyoumukey, String pFlowid, C_RirekiKbn pRirekiKbn) {

        StringBuffer sbSql = new StringBuffer();
        sbSql.append($FROM + pKouteiRireki.WT_KouteiRireki());
        sbSql.append($WHERE + pKouteiRireki.gyoumuKey.eq(pKouteiRireki.gyoumuKey));

        if (StringUtils.isNotEmpty(pGyoumukey)) {
            sbSql.append($AND + pKouteiRireki.gyoumuKey.eq(pGyoumukey));
        }
        if (StringUtils.isNotEmpty(pFlowid)) {
            sbSql.append($AND + pKouteiRireki.flowId.eq(pFlowid));
        }
        if (null != pRirekiKbn) {
            sbSql.append($AND + pKouteiRireki.rirekiKbn.eq(pRirekiKbn));
        }

        return sbSql.toString();
    }
}