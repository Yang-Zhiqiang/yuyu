package yuyu.batch.sinkeiyaku.sknyuukin.skkhrtrkkekkamihaneilistsks.dba;

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
 * 新契約 入金 口振受付登録結果未反映リスト作成機能DAOクラス
 */
public class SkKhrTrkKekkaMihaneilistSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SkKouhuriUkTrkMihanei> getSkKouhuriUkTrkMihaneiByKinyuukkntratkiymdKakutyoujobcd(
        String pKakutyouJobCd, BizDate pKinyuukknTratkiYmd) {

        QHT_SkKouhuriUkTrkMihanei qHT_SkKouhuriUkTrkMihanei = new QHT_SkKouhuriUkTrkMihanei("qHT_SkKouhuriUkTrkMihanei");

        String strSql = $SELECT + qHT_SkKouhuriUkTrkMihanei +
            $FROM(qHT_SkKouhuriUkTrkMihanei) +
            $WHERE + qHT_SkKouhuriUkTrkMihanei.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $AND + qHT_SkKouhuriUkTrkMihanei.kinyuukkntratkiymd.gt(pKinyuukknTratkiYmd) +
            $ORDER_BY(qHT_SkKouhuriUkTrkMihanei.kinyuukkntratkiymd.asc(),
                qHT_SkKouhuriUkTrkMihanei.syoriYmd.asc());

        ExDBResults<HT_SkKouhuriUkTrkMihanei> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qHT_SkKouhuriUkTrkMihanei).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
