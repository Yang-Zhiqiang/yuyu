package yuyu.batch.biz.bzkaikei.bzfbsoukintrkmkh.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QIT_KhFBSoukinData;

/**
 * 業務共通 経理･会計 ＦＢ送金データ取込（契約保全）の機能DAOクラス
 */
public class BzFBSoukinTrkmKhDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_KhFBSoukinData> getOnlineKhFBSoukinDatas(String pKakutyoujobcd, BizDate pSyoriYmd,
        C_KinouKbn pKinouKbn) {

        QIT_KhFBSoukinData qIT_KhFBSoukinData = new QIT_KhFBSoukinData("qIT_KhFBSoukinData");
        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");

        String strSql = $SELECT + qIT_KhFBSoukinData +
            $FROM(qIT_KhFBSoukinData,
                qAS_Kinou) +
                $WHERE + qIT_KhFBSoukinData.syoriYmd.eq(pSyoriYmd) +
                $AND + qAS_Kinou.kinouKbn.ne(pKinouKbn) +
                $AND + qIT_KhFBSoukinData.syoricd.eq(qAS_Kinou.syoricd);

        ExDBResults<IT_KhFBSoukinData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qIT_KhFBSoukinData, qAS_Kinou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<IT_KhFBSoukinData> getBatchKhFBSoukinDatas(String pKakutyoujobcd, BizDate pSyoriYmd,
        C_KinouKbn pKinouKbn) {

        QIT_KhFBSoukinData qIT_KhFBSoukinData = new QIT_KhFBSoukinData("qIT_KhFBSoukinData");
        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");

        String strSql = $SELECT + qIT_KhFBSoukinData +
            $FROM(qIT_KhFBSoukinData,
                qAS_Kinou) +
                $WHERE + qIT_KhFBSoukinData.syoriYmd.eq(pSyoriYmd) +
                $AND + qAS_Kinou.kinouKbn.eq(pKinouKbn) +
                $AND + qIT_KhFBSoukinData.syoricd.eq(qAS_Kinou.syoricd);

        ExDBResults<IT_KhFBSoukinData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qIT_KhFBSoukinData, qAS_Kinou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}