package yuyu.batch.biz.bzkaikei.bzfbsoukinlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;
import yuyu.def.db.meta.QBT_FBSoukinData;

/**
 * 業務共通 経理･会計 ＦＢ送金リスト作成の機能DAOクラス
 */
public class BzFBSoukinListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<BT_FBSoukinData> getAtesakiAriFBSoukinListSksDatas(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QBT_FBSoukinData qBT_FBSoukinData = new QBT_FBSoukinData();
        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri();

        String mainStry = $SELECT + qBT_FBSoukinData +
            $FROM(qBT_FBSoukinData) +
            $LEFT_OUTER_JOIN + qBT_FBSoukinData.BM_FBSoukinListKanri() +
            $AS + qBM_FBSoukinListKanri +
            $WHERE + qBT_FBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBM_FBSoukinListKanri.fbmeisaisyoruicd.isNotNull() +
            $ORDER_BY (qBM_FBSoukinListKanri.fbmeisaisyoruicd.asc(),
                qBM_FBSoukinListKanri.tantositucd.asc(),
                qBT_FBSoukinData.shrhousiteikbn.asc(),
                qBT_FBSoukinData.gyoumucd.asc(),
                qBT_FBSoukinData.bankcd.asc(),
                qBT_FBSoukinData.sitencd.asc(),
                qBT_FBSoukinData.yokinkbn.asc(),
                qBT_FBSoukinData.kouzano.asc(),
                qBT_FBSoukinData.kzmeiginmkn.asc(),
                qBT_FBSoukinData.keirisyono.asc());

        ExDBResults<BT_FBSoukinData> exDBResults = exDBEntityManager.createJPQL(mainStry)
            .bind(qBT_FBSoukinData, qBM_FBSoukinListKanri).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<BT_FBSoukinData> getAtesakiHumeiFBSoukinListSksDatas(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QBT_FBSoukinData qBT_FBSoukinData = new QBT_FBSoukinData();
        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri();

        String mainStry = $SELECT + qBT_FBSoukinData +
            $FROM  (qBT_FBSoukinData) +
            $LEFT_OUTER_JOIN + qBT_FBSoukinData.BM_FBSoukinListKanri() +
            $AS + qBM_FBSoukinListKanri +
            $WHERE + qBT_FBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBM_FBSoukinListKanri.fbmeisaisyoruicd.isNull();

        ExDBResults<BT_FBSoukinData> exDBResults = exDBEntityManager.createJPQL(mainStry)
            .bind(qBT_FBSoukinData, qBM_FBSoukinListKanri).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}