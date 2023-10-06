package yuyu.batch.biz.bzinterf.bzonlinegknyknmeisaityuusyutu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiTr;
import yuyu.def.db.meta.QZT_OnlineGknyknmeisaiTr;

/**
 * オンライン外貨入出金明細テーブル抽出（BzOnlineGknyknMeisaiTyuusyutu）のDAOクラスです。<br />
 */
public class BzOnlineGknyknMeisaiTyuusyutuDao {

    @Inject
    ExDBEntityManager em;

    public ExDBResults<ZT_OnlineGknyknmeisaiTr> getOnlineGknyknmeisaiTrsByKakutyoujobcd(String pKakutyoujobcd) {

        QZT_OnlineGknyknmeisaiTr qZT_OnlineGknyknmeisaiTr = new QZT_OnlineGknyknmeisaiTr("qZT_OnlineGknyknmeisaiTr");

        String strSql = $SELECT + qZT_OnlineGknyknmeisaiTr + $FROM(qZT_OnlineGknyknmeisaiTr);

        ExDBResults<ZT_OnlineGknyknmeisaiTr> exDBResults = em.createJPQL(strSql).bind(qZT_OnlineGknyknmeisaiTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));
        return exDBResults;
    }
}
