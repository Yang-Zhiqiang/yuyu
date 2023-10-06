package yuyu.batch.biz.bzkaikei.bzonlinegkhurikominykndatasks;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.BT_OnlineGknyknmeisai;
import yuyu.def.db.meta.QBT_OnlineGknyknmeisai;

/**
 * オンライン外貨振込入金データ作成（BzOnlineGkhurikomiNyknDataSks）のDAOクラスです。<br />
 */
public class BzOnlineGkhurikomiNyknDataSksDao {

    @Inject
    ExDBEntityManager em;

    public ExDBResults<BT_OnlineGknyknmeisai> getOnlineGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(String pKakutyoujobcd, String pHrkmsakuseiymd) {

        QBT_OnlineGknyknmeisai qBT_OnlineGknyknmeisai = new QBT_OnlineGknyknmeisai();

        String strSql =$SELECT + qBT_OnlineGknyknmeisai +
            $FROM + qBT_OnlineGknyknmeisai.BT_OnlineGknyknmeisai() +
            $WHERE + qBT_OnlineGknyknmeisai.hrkmsakuseiymd.eq(pHrkmsakuseiymd);

        ExDBResults<BT_OnlineGknyknmeisai> exDBResults = em.createJPQL(strSql).bind(qBT_OnlineGknyknmeisai).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));
        return exDBResults;
    }
}
