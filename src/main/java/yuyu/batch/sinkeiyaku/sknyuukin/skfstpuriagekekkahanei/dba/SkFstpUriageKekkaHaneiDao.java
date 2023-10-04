package yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagekekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.meta.QHT_SkUriageData;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuKekkaTr;

/**
 * 新契約 入金 初回保険料売上請求結果反映Daoクラス
 */
public class SkFstpUriageKekkaHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZT_FstpUriageSeikyuuKekkaTr> getFstUriageKekkaTrs(String pKakutyouJobCd) {

        QZT_FstpUriageSeikyuuKekkaTr qZT_FstpUriageSeikyuuKekkaTr = new QZT_FstpUriageSeikyuuKekkaTr(
            "qZT_FstpUriageSeikyuuKekkaTr");

        String sql = $SELECT + qZT_FstpUriageSeikyuuKekkaTr +
            $FROM(qZT_FstpUriageSeikyuuKekkaTr) +
            $ORDER_BY(qZT_FstpUriageSeikyuuKekkaTr.ztrcreditkessaiyouno.asc());

        ExDBResults<ZT_FstpUriageSeikyuuKekkaTr> exDBResults = exDBEntityManager
            .createJPQL(sql, ZT_FstpUriageSeikyuuKekkaTr.class).bind(qZT_FstpUriageSeikyuuKekkaTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public HT_SkUriageData getSkUriageDataInfo(String pCreditkessaiyouno) {

        QHT_SkUriageData qHT_SkUriageData = new QHT_SkUriageData("qHT_SkUriageData");

        String sql = $SELECT + qHT_SkUriageData +
            $FROM(qHT_SkUriageData) +
            $WHERE + qHT_SkUriageData.creditkessaiyouno.eq(pCreditkessaiyouno);

        HT_SkUriageData exDBResult = exDBEntityManager.createJPQL(sql, HT_SkUriageData.class)
            .bind(qHT_SkUriageData).getSingleResult();

        return exDBResult;
    }
}
