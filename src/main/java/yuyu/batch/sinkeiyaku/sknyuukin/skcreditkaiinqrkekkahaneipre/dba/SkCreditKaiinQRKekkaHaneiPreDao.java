package yuyu.batch.sinkeiyaku.sknyuukin.skcreditkaiinqrkekkahaneipre.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrTr;

public class SkCreditKaiinQRKekkaHaneiPreDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZT_SkCreditTourokukekkaQrTr> getSkCreditTourokukekkaQrTrs(String pKakutyouJobCd) {

        QZT_SkCreditTourokukekkaQrTr qZT_SkCreditTourokukekkaQrTr =
            new QZT_SkCreditTourokukekkaQrTr("qZT_SkCreditTourokukekkaQrTr");

        String strSql = $SELECT + qZT_SkCreditTourokukekkaQrTr +
            $FROM(qZT_SkCreditTourokukekkaQrTr);

        ExDBResults<ZT_SkCreditTourokukekkaQrTr> exDBResults = exDBEntityManager.createJPQL(strSql
            ).bind(qZT_SkCreditTourokukekkaQrTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
