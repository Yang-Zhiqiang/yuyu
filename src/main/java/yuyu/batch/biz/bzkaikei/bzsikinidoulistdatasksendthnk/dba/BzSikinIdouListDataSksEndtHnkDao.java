package yuyu.batch.biz.bzkaikei.bzsikinidoulistdatasksendthnk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;
import yuyu.def.db.meta.QBT_YendthnkSikinIdouData;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成（円建変更）DAOクラスです。<br />
 */
public class BzSikinIdouListDataSksEndtHnkDao {

    @Inject
    private ExDBEntityManager em;

    public ExDBResults<BT_YendthnkSikinIdouData> getYendthnkSikinIdouDataByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QBT_YendthnkSikinIdouData qBT_YendthnkSikinIdouData = new QBT_YendthnkSikinIdouData();

        String strSql = $SELECT + qBT_YendthnkSikinIdouData +
            $FROM(qBT_YendthnkSikinIdouData) +
            $WHERE + qBT_YendthnkSikinIdouData.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qBT_YendthnkSikinIdouData.keiriyendthnkkbn.asc(),
                qBT_YendthnkSikinIdouData.syouhncd.asc(),
                qBT_YendthnkSikinIdouData.syouhnsdno.asc());

        ExDBResults<BT_YendthnkSikinIdouData> exDBResults = em.createJPQL(strSql).bind(qBT_YendthnkSikinIdouData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));
        return exDBResults;
    }

    public List<BT_YendthnkSikinIdouData> getYendthnkSikinIdouDataBySyonoSyoriYmd(String pSyono, BizDate pSyoriYmd) {

        QBT_YendthnkSikinIdouData qBT_YendthnkSikinIdouData = new QBT_YendthnkSikinIdouData();

        String queryStr = $SELECT + qBT_YendthnkSikinIdouData +
            $FROM(qBT_YendthnkSikinIdouData) +
            $WHERE + qBT_YendthnkSikinIdouData.syono.eq(pSyono) +
            $AND + qBT_YendthnkSikinIdouData.keiriyendthnkkbn.eq(C_KeiriyendthnkKbn.HENKOU) +
            $AND + qBT_YendthnkSikinIdouData.syoriYmd.lt(pSyoriYmd) +
            $ORDER_BY(qBT_YendthnkSikinIdouData.syoriYmd.desc());

        return em.createJPQL(queryStr).bind(qBT_YendthnkSikinIdouData).getResultList();
    }
}
