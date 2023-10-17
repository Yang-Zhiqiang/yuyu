package yuyu.batch.biz.bzkaikei.bzfbsoukintrkmsk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QHT_SkFBSoukinData;

/**
 * 業務共通 経理･会計 ＦＢ送金データ取込（新契約）の機能DAOクラス
 */
public class BzFBSoukinTrkmSkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SkFBSoukinData> getOnlineSkFBSoukinDatas(String pKakutyoujobcd, BizDate pSyoriYmd,
        C_KinouKbn pKinouKbn) {

        QHT_SkFBSoukinData qHT_SkFBSoukinData = new QHT_SkFBSoukinData("qHT_SkFBSoukinData");
        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");

        String strSql = $SELECT + qHT_SkFBSoukinData +
            $FROM(qHT_SkFBSoukinData,
                qAS_Kinou) +
                $WHERE + qHT_SkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
                $AND + qAS_Kinou.kinouKbn.ne(pKinouKbn) +
                $AND + qHT_SkFBSoukinData.syoricd.eq(qAS_Kinou.syoricd);

        ExDBResults<HT_SkFBSoukinData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qHT_SkFBSoukinData, qAS_Kinou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<HT_SkFBSoukinData> getBatchSkFBSoukinDatas(String pKakutyoujobcd, BizDate pSyoriYmd,
        C_KinouKbn pKinouKbn) {

        QHT_SkFBSoukinData qHT_SkFBSoukinData = new QHT_SkFBSoukinData("qHT_SkFBSoukinData");
        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");

        String strSql = $SELECT + qHT_SkFBSoukinData +
            $FROM(qHT_SkFBSoukinData,
                qAS_Kinou) +
                $WHERE + qHT_SkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
                $AND + qAS_Kinou.kinouKbn.eq(pKinouKbn) +
                $AND + qHT_SkFBSoukinData.syoricd.eq(qAS_Kinou.syoricd);

        ExDBResults<HT_SkFBSoukinData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qHT_SkFBSoukinData, qAS_Kinou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}