package yuyu.batch.biz.bzkaikei.bzfbsoukintrkmsi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QJT_SiFBSoukinData;

/**
 * 業務共通 経理･会計 ＦＢ送金データ取込（支払）の機能DAOクラス
 */
public class BzFBSoukinTrkmSiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<JT_SiFBSoukinData> getOnlineSiFBSoukinDatas(String pKakutyoujobcd, BizDate pSyoriYmd,
        C_KinouKbn pKinouKbn) {

        QJT_SiFBSoukinData qJT_SiFBSoukinData = new QJT_SiFBSoukinData("qJT_SiFBSoukinData");
        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");

        String strSql = $SELECT + qJT_SiFBSoukinData +
            $FROM(qJT_SiFBSoukinData,
                qAS_Kinou) +
                $WHERE + qJT_SiFBSoukinData.syoriYmd.eq(pSyoriYmd) +
                $AND + qAS_Kinou.kinouKbn.ne(pKinouKbn) +
                $AND + qJT_SiFBSoukinData.syoricd.eq(qAS_Kinou.syoricd);

        ExDBResults<JT_SiFBSoukinData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qJT_SiFBSoukinData, qAS_Kinou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<JT_SiFBSoukinData> getBatchSiFBSoukinDatas(String pKakutyoujobcd, BizDate pSyoriYmd,
        C_KinouKbn pKinouKbn) {

        QJT_SiFBSoukinData qJT_SiFBSoukinData = new QJT_SiFBSoukinData("qJT_SiFBSoukinData");
        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");

        String strSql = $SELECT + qJT_SiFBSoukinData +
            $FROM(qJT_SiFBSoukinData,
                qAS_Kinou) +
                $WHERE + qJT_SiFBSoukinData.syoriYmd.eq(pSyoriYmd) +
                $AND + qAS_Kinou.kinouKbn.eq(pKinouKbn) +
                $AND + qJT_SiFBSoukinData.syoricd.eq(qAS_Kinou.syoricd);

        ExDBResults<JT_SiFBSoukinData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qJT_SiFBSoukinData, qAS_Kinou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}