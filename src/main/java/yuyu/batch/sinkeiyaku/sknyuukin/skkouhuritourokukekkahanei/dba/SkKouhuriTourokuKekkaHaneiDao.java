package yuyu.batch.sinkeiyaku.sknyuukin.skkouhuritourokukekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.meta.QHT_SkKouhuriUkTrkMihanei;

/**
 * 新契約 入金 口振受付登録結果反映の機能DAOクラスです
 */
public class SkKouhuriTourokuKekkaHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SkKouhuriUkTrkMihanei> getSkKouhuriUkTrkMihaneiByKinyuukkntratkiymdKakutyoujobcd(
        String pKakutyouJobCd, BizDate pKinyuukkntratkiYmd) {

        QHT_SkKouhuriUkTrkMihanei qHT_SkKouhuriUkTrkMihanei = new QHT_SkKouhuriUkTrkMihanei("qHT_SkKouhuriUkTrkMihanei");

        String sql = $SELECT + qHT_SkKouhuriUkTrkMihanei +
            $FROM(qHT_SkKouhuriUkTrkMihanei) +
            $WHERE + qHT_SkKouhuriUkTrkMihanei.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $AND + qHT_SkKouhuriUkTrkMihanei.kinyuukkntratkiymd.gt(pKinyuukkntratkiYmd) +
            $ORDER_BY(qHT_SkKouhuriUkTrkMihanei.kouhuriokyakusamano.asc(),
                qHT_SkKouhuriUkTrkMihanei.syoriYmd.asc(),
                qHT_SkKouhuriUkTrkMihanei.kinyuukkntratkiymd.asc(),
                qHT_SkKouhuriUkTrkMihanei.kinyuukkntratkitime.asc());

        ExDBResults<HT_SkKouhuriUkTrkMihanei> exDBResults = exDBEntityManager
            .createJPQL(sql).bind(qHT_SkKouhuriUkTrkMihanei).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

}
