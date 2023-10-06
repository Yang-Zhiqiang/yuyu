package yuyu.batch.biz.bzkaikei.bzgkfbsoukinhukainfotblsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;
import yuyu.def.db.meta.QBT_GkFBSoukinData;

/**
 * 業務共通 経理･会計 外貨ＦＢ送金付加情報テーブル作成の機能DAOクラス
 */

public class BzGkFBSoukinHukaInfoTblSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<BT_GkFBSoukinData> getAtesakiAriGkFBSoukinHukaInfoDatas(String pKakutyoujobcd,
        BizDate pSyoriYmd) {

        QBT_GkFBSoukinData qBT_GkFBSoukinData = new QBT_GkFBSoukinData("qBT_GkFBSoukinData");
        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri("qBM_FBSoukinListKanri");

        String mainStry = $SELECT + qBT_GkFBSoukinData +
            $FROM(qBT_GkFBSoukinData) +
            $LEFT_OUTER_JOIN + qBT_GkFBSoukinData.BM_FBSoukinListKanri() +
            $AS + qBM_FBSoukinListKanri +
            $WHERE + qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBM_FBSoukinListKanri.tantositucd.isNotNull() +
            $ORDER_BY(qBM_FBSoukinListKanri.tantositucd.asc(),
                qBT_GkFBSoukinData.shrhousiteikbn.asc(),
                qBT_GkFBSoukinData.shrtuukasyu.asc(),
                qBT_GkFBSoukinData.bankcd.asc(),
                qBT_GkFBSoukinData.sitencd.asc(),
                qBT_GkFBSoukinData.kouzano.asc(),
                qBT_GkFBSoukinData.kzmeiginmei.asc(),
                qBT_GkFBSoukinData.keirisyono.asc());

        ExDBUpdatableResults<BT_GkFBSoukinData> exDBUpdatableResults = exDBEntityManager.createJPQL(mainStry)
            .bind(qBT_GkFBSoukinData, qBM_FBSoukinListKanri).getUpdatableResults();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBUpdatableResults;

    }

    public ExDBUpdatableResults<BT_GkFBSoukinData> getAtesakiHumeiGkFBSoukinHukaInfoDatas(String pKakutyoujobcd,
        BizDate pSyoriYmd) {

        QBT_GkFBSoukinData qBT_GkFBSoukinData = new QBT_GkFBSoukinData("qBT_GkFBSoukinData");
        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri();

        String mainStry = $SELECT + qBT_GkFBSoukinData +
            $FROM(qBT_GkFBSoukinData) +
            $LEFT_OUTER_JOIN + qBT_GkFBSoukinData.BM_FBSoukinListKanri() +
            $AS + qBM_FBSoukinListKanri +
            $WHERE + qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBM_FBSoukinListKanri.tantositucd.isNull() +
            $ORDER_BY(qBM_FBSoukinListKanri.tantositucd.asc(),
                qBT_GkFBSoukinData.shrhousiteikbn.asc(),
                qBT_GkFBSoukinData.shrtuukasyu.asc(),
                qBT_GkFBSoukinData.bankcd.asc(),
                qBT_GkFBSoukinData.sitencd.asc(),
                qBT_GkFBSoukinData.kouzano.asc(),
                qBT_GkFBSoukinData.kzmeiginmei.asc(),
                qBT_GkFBSoukinData.keirisyono.asc());

        ExDBUpdatableResults<BT_GkFBSoukinData> exDBUpdatableResults = exDBEntityManager.createJPQL(mainStry)
            .bind(qBT_GkFBSoukinData, qBM_FBSoukinListKanri).getUpdatableResults();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBUpdatableResults;

    }
}
