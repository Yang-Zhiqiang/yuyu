package yuyu.batch.biz.bzkaikei.bzfbsoukinhukainfotblsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;
import yuyu.def.db.meta.QBT_FBSoukinData;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

/**
 * 業務共通 経理･会計 ＦＢ送金付加情報テーブル作成の機能DAOクラス
 */

public class BzFBSoukinHukaInfoTblSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<BT_FBSoukinData> getAtesakiAriFBSoukinHukaInfoDatas(String pKakutyoujobcd,
        BizDate pSyoriYmd, C_FbSoukinBatchKbn pFbSoukinBatchKbn) {

        QBT_FBSoukinData qBT_FBSoukinData = new QBT_FBSoukinData("qBT_FBSoukinData");
        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri("qBM_FBSoukinListKanri");

        String mainStry = $SELECT + qBT_FBSoukinData +
            $FROM (qBT_FBSoukinData) +
            $LEFT_OUTER_JOIN + qBT_FBSoukinData.BM_FBSoukinListKanri() +
            $AS + qBM_FBSoukinListKanri +
            $WHERE + qBT_FBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_FBSoukinData.fbsoukinbatchkbn.eq(pFbSoukinBatchKbn) +
            $AND + qBM_FBSoukinListKanri.tantositucd.isNotNull() +
            $ORDER_BY (qBM_FBSoukinListKanri.tantositucd.asc(),
                qBT_FBSoukinData.shrhousiteikbn.asc(),
                qBT_FBSoukinData.bankcd.asc(),
                qBT_FBSoukinData.sitencd.asc(),
                qBT_FBSoukinData.yokinkbn.asc(),
                qBT_FBSoukinData.kouzano.asc(),
                qBT_FBSoukinData.kzmeiginmkn.asc(),
                qBT_FBSoukinData.keirisyono.asc());

        ExDBUpdatableResults<BT_FBSoukinData> exDBUpdatableResults = exDBEntityManager.createJPQL(mainStry)
            .bind(qBT_FBSoukinData, qBM_FBSoukinListKanri).getUpdatableResults();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBUpdatableResults;

    }

    public ExDBUpdatableResults<BT_FBSoukinData> getAtesakiHumeiFBSoukinHukaInfoDatas(String pKakutyoujobcd,
        BizDate pSyoriYmd, C_FbSoukinBatchKbn pFbSoukinBatchKbn) {

        QBT_FBSoukinData qBT_FBSoukinData = new QBT_FBSoukinData();
        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri();

        String mainStry = $SELECT + qBT_FBSoukinData +
            $FROM (qBT_FBSoukinData) +
            $LEFT_OUTER_JOIN + qBT_FBSoukinData.BM_FBSoukinListKanri() +
            $AS + qBM_FBSoukinListKanri +
            $WHERE + qBT_FBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_FBSoukinData.fbsoukinbatchkbn.eq(pFbSoukinBatchKbn) +
            $AND + qBM_FBSoukinListKanri.tantositucd.isNull() +
            $ORDER_BY (qBT_FBSoukinData.shrhousiteikbn.asc(),
                qBT_FBSoukinData.bankcd.asc(),
                qBT_FBSoukinData.sitencd.asc(),
                qBT_FBSoukinData.yokinkbn.asc(),
                qBT_FBSoukinData.kouzano.asc(),
                qBT_FBSoukinData.kzmeiginmkn.asc(),
                qBT_FBSoukinData.keirisyono.asc());

        ExDBUpdatableResults<BT_FBSoukinData> exDBUpdatableResults = exDBEntityManager.createJPQL(mainStry)
            .bind(qBT_FBSoukinData, qBM_FBSoukinListKanri).getUpdatableResults();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBUpdatableResults;

    }
}
