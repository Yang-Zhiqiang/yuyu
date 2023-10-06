package yuyu.batch.biz.bzkaikei.bzgkfbsoukinlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;
import yuyu.def.db.meta.QBT_GkFBSoukinData;

/**
 * 業務共通 経理・会計 外貨FB送金リスト作成機能DAOクラス
 */
public class BzGkFBSoukinListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<BT_GkFBSoukinData> getAtesakiAriGkFBSoukinListSksDatas(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QBT_GkFBSoukinData qBT_GkFBSoukinData = new QBT_GkFBSoukinData("qBT_GkFBSoukinData");

        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri("qBM_FBSoukinListKanri");

        String strSql = $SELECT + qBT_GkFBSoukinData +
            $FROM(qBT_GkFBSoukinData) +
            $LEFT_OUTER_JOIN + qBT_GkFBSoukinData.BM_FBSoukinListKanri() +
            $AS + qBM_FBSoukinListKanri +
            $WHERE + qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBM_FBSoukinListKanri.fbmeisaisyoruicd.isNotNull() +
            $ORDER_BY(qBM_FBSoukinListKanri.gkfbmeisaisyoruicd + $ASC,
                qBM_FBSoukinListKanri.tantositucd + $ASC,
                qBT_GkFBSoukinData.shrhousiteikbn + $ASC,
                qBT_GkFBSoukinData.denymd + $ASC,
                qBT_GkFBSoukinData.gkgyoumucd + $ASC,
                qBT_GkFBSoukinData.kyktuukasyu + $ASC,
                qBT_GkFBSoukinData.bankcd + $ASC,
                qBT_GkFBSoukinData.sitencd + $ASC,
                qBT_GkFBSoukinData.kouzano + $ASC,
                qBT_GkFBSoukinData.kzmeiginmei + $ASC,
                qBT_GkFBSoukinData.keirisyono + $ASC);

        ExDBResults<BT_GkFBSoukinData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qBT_GkFBSoukinData, qBM_FBSoukinListKanri).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<BT_GkFBSoukinData> getAtesakiHumeiGkFBSoukinListSksDatas(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QBT_GkFBSoukinData qBT_GkFBSoukinData = new QBT_GkFBSoukinData("qBT_GkFBSoukinData");

        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri("qBM_FBSoukinListKanri");

        String strSql = $SELECT + qBT_GkFBSoukinData +
            $FROM(qBT_GkFBSoukinData) +
            $LEFT_OUTER_JOIN + qBT_GkFBSoukinData.BM_FBSoukinListKanri() +
            $AS + qBM_FBSoukinListKanri +
            $WHERE + qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBM_FBSoukinListKanri.fbmeisaisyoruicd.isNull();

        ExDBResults<BT_GkFBSoukinData> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qBT_GkFBSoukinData, qBM_FBSoukinListKanri).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}