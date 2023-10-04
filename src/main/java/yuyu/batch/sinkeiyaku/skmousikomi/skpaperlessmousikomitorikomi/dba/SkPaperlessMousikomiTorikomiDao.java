package yuyu.batch.sinkeiyaku.skmousikomi.skpaperlessmousikomitorikomi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos2Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos2Tr;


/**
 * 新契約 申込入力 ペーパーレス申込情報取込機能DAOクラス
 */
public class SkPaperlessMousikomiTorikomiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZT_HanyouPaperlessMos1Tr> getHanyouPaperlessMos1TrByKakutyoujobcd(String pKakutyoujobcd) {

        QZT_HanyouPaperlessMos1Tr qZT_HanyouPaperlessMos1Tr = new QZT_HanyouPaperlessMos1Tr("qZT_HanyouPaperlessMos1Tr");

        String strSql =$SELECT + qZT_HanyouPaperlessMos1Tr +
            $FROM(qZT_HanyouPaperlessMos1Tr) +
            $WHERE + qZT_HanyouPaperlessMos1Tr.ztrseihowebtkiyougyoutaikbn.ne("5") +
            $AND + qZT_HanyouPaperlessMos1Tr.ztrseihowebplmosnoc.ne("000000000");

        ExDBResults<ZT_HanyouPaperlessMos1Tr> exDBResults = exDBEntityManager
            .createJPQL(strSql).bind(qZT_HanyouPaperlessMos1Tr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<ZT_HanyouPaperlessMos2Tr> getHanyouPaperlessMos2TrByKakutyoujobcd(String pKakutyoujobcd) {

        QZT_HanyouPaperlessMos2Tr qZT_HanyouPaperlessMos2Tr = new QZT_HanyouPaperlessMos2Tr("qZT_HanyouPaperlessMos2Tr");

        String strSql =$SELECT + qZT_HanyouPaperlessMos2Tr +
            $FROM(qZT_HanyouPaperlessMos2Tr) +
            $WHERE + qZT_HanyouPaperlessMos2Tr.ztrseihowebtkiyougyoutaikbn.ne("5") +
            $AND + qZT_HanyouPaperlessMos2Tr.ztrseihowebplmosnoc.ne("000000000");

        ExDBResults<ZT_HanyouPaperlessMos2Tr> exDBResults = exDBEntityManager
            .createJPQL(strSql).bind(qZT_HanyouPaperlessMos2Tr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}