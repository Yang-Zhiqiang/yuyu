package yuyu.batch.biz.bzinterf.bzgknyuukinmeisaityuusyutu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;
import yuyu.def.db.meta.QZT_GknyknmeisaiTr;

/**
 * 外貨入出金明細テーブル抽出（BzGknyuukinMeisaiTyuusyutu）のDAOクラスです。<br />
 */
public class BzGknyuukinMeisaiTyuusyutuDao {

    @Inject
    ExDBEntityManager em;

    public ExDBResults<ZT_GknyknmeisaiTr> getGknyknmeisaiTrsByKakutyoujobcd(String pKakutyoujobcd) {

        QZT_GknyknmeisaiTr qZT_GknyknmeisaiTr = new QZT_GknyknmeisaiTr("qZT_GknyknmeisaiTr");

        String strSql = $SELECT + qZT_GknyknmeisaiTr + $FROM(qZT_GknyknmeisaiTr);

        ExDBResults<ZT_GknyknmeisaiTr> exDBResults = em.createJPQL(strSql).bind(qZT_GknyknmeisaiTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));
        return exDBResults;
    }
}
