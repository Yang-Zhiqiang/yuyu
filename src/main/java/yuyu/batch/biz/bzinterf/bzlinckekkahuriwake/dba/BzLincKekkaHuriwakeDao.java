package yuyu.batch.biz.bzinterf.bzlinckekkahuriwake.dba;
import javax.inject.Inject;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.ZT_LincJyusinTr;
import yuyu.def.db.meta.QZT_LincJyusinTr;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 業務共通 インターフェース ＬＩＮＣ結果反映Daoクラスです。<br />
 */
public class BzLincKekkaHuriwakeDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZT_LincJyusinTr> getLincJyusinTr(String pKakutyoujobcd) {

        QZT_LincJyusinTr qZT_LincJyusinTr = new QZT_LincJyusinTr("qZT_LincJyusinTr");

        String strSql = $SELECT + qZT_LincJyusinTr +
            $FROM(qZT_LincJyusinTr) +
            $WHERE + qZT_LincJyusinTr.ztrsyorikekkacd.ne("9") +
            $ORDER_BY(qZT_LincJyusinTr.ztrsyoriymd.asc(),
                qZT_LincJyusinTr.ztrrenno10.asc());

        ExDBResults<ZT_LincJyusinTr> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qZT_LincJyusinTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
