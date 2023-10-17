package yuyu.batch.biz.bzinterf.bznyuukinmeisaityuusyutu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.ZT_NyknmeisaiTr;
import yuyu.def.db.meta.QZT_NyknmeisaiTr;

/**
 * 入出金明細テーブル抽出（BzNyuukinMeisaiTyuusyutu）のDAOクラスです。<br />
 */
public class BzNyuukinMeisaiTyuusyutuDao {

    @Inject
    ExDBEntityManager em;

    public ExDBResults<ZT_NyknmeisaiTr> getNyknmeisaiTrsByKakutyoujobcd(String pKakutyoujobcd) {

        QZT_NyknmeisaiTr qZT_NyknmeisaiTr = new QZT_NyknmeisaiTr("qZT_NyknmeisaiTr");

        String strSql = $SELECT + qZT_NyknmeisaiTr + $FROM(qZT_NyknmeisaiTr);

        ExDBResults<ZT_NyknmeisaiTr> exDBResults = em.createJPQL(strSql).bind(qZT_NyknmeisaiTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));
        return exDBResults;
    }
}
