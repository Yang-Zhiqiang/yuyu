package yuyu.batch.sinkeiyaku.sknyuukin.skcreditkaiinqrkekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.QHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.QHW_CreditTrkHaneierrList;

/**
 * 新契約 入金 クレジットカード会員ＱＲ登録結果反映機能DAOクラス
 */
public class SkCreditKaiinQRKekkaHaneiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SkCreditCardQrTrkMihanei> getSkCreditCardQrTrkMihaneiByBgUktkymdtimeKakutyoujobcd(
        String pKakutyouJobCd, String pBluegateDate) {

        QHT_SkCreditCardQrTrkMihanei qHT_SkCreditCardQrTrkMihanei = new QHT_SkCreditCardQrTrkMihanei("qHT_SkCreditCardQrTrkMihanei");

        String strSql = $SELECT + qHT_SkCreditCardQrTrkMihanei +
            $FROM(qHT_SkCreditCardQrTrkMihanei) +
            $WHERE + qHT_SkCreditCardQrTrkMihanei.syorizumiflg.eq(C_Syorizumiflg.MISYORI) +
            $AND + qHT_SkCreditCardQrTrkMihanei.bluegatejyusinymdtime.ge(pBluegateDate) +
            $ORDER_BY(qHT_SkCreditCardQrTrkMihanei.creditkessaiyouno.asc(),
                qHT_SkCreditCardQrTrkMihanei.systemjyusinymd.asc(),
                qHT_SkCreditCardQrTrkMihanei.systemjyusintime.asc());

        ExDBResults<HT_SkCreditCardQrTrkMihanei> exDBResults = exDBEntityManager.createJPQL(strSql)
            .bind(qHT_SkCreditCardQrTrkMihanei).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Integer getCreditTrkHaneierrListMaxDatarennoByTyouhyouymd(BizDate pTyouhyouYmd) {

        QHW_CreditTrkHaneierrList qHW_CreditTrkHaneierrList = new QHW_CreditTrkHaneierrList("qHW_CreditTrkHaneierrList");

        String strSql = $SELECT + $MAX(qHW_CreditTrkHaneierrList.datarenno) +
            $FROM(qHW_CreditTrkHaneierrList) +
            $WHERE + qHW_CreditTrkHaneierrList.tyouhyouymd.eq(pTyouhyouYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qHW_CreditTrkHaneierrList).getSingleResult();
    }
}
