package yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokukekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.IT_SkCreditCardTourokuKekka;
import yuyu.def.db.meta.QHW_CreditTrkHaneierrList;
import yuyu.def.db.meta.QHW_CreditTrkNgList;
import yuyu.def.db.meta.QIT_SkCreditCardTourokuKekka;

/**
 * 新契約 入金 クレジットカード登録結果反映機能DAOクラス
 */
public class SkCreditTourokuKekkaHaneiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_SkCreditCardTourokuKekka> getSkCreditCardTourokuKekkasByKakutyoujobcd (String pKakutyouJobCd) {

        QIT_SkCreditCardTourokuKekka qIT_SkCreditCardTourokuKekka = new QIT_SkCreditCardTourokuKekka("qIT_SkCreditCardTourokuKekka");

        String strSql = $SELECT + qIT_SkCreditCardTourokuKekka +
            $FROM(qIT_SkCreditCardTourokuKekka) +
            $WHERE + qIT_SkCreditCardTourokuKekka.datasyorijyoukyou.eq("2") +
            $OR + qIT_SkCreditCardTourokuKekka.datasyorijyoukyou.eq("3") +
            $ORDER_BY(qIT_SkCreditCardTourokuKekka.creditkessaiyouno.asc(),
                qIT_SkCreditCardTourokuKekka.datajyusinymd.asc());

        ExDBResults<IT_SkCreditCardTourokuKekka> exDBResults = exDBEntityManager.createJPQL(strSql
            ).bind(qIT_SkCreditCardTourokuKekka).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public Integer getCreditTrkHaneierrListMaxDatarennoByTyouhyouymd(BizDate pTyouhyouYmd) {

        QHW_CreditTrkHaneierrList qHW_CreditTrkHaneierrList = new QHW_CreditTrkHaneierrList("qHW_CreditTrkHaneierrList");

        String strSql = $SELECT + $MAX(qHW_CreditTrkHaneierrList.datarenno) +
            $FROM(qHW_CreditTrkHaneierrList) +
            $WHERE+ qHW_CreditTrkHaneierrList.tyouhyouymd.eq(pTyouhyouYmd);

        return exDBEntityManager.createJPQL(strSql)
            .bind(qHW_CreditTrkHaneierrList).getSingleResult();
    }

    public Integer getCreditTrkNgListMaxDatarennoByTyouhyouymd(BizDate pTyouhyouYmd) {

        QHW_CreditTrkNgList qHW_CreditTrkNgList = new QHW_CreditTrkNgList("qHW_CreditTrkNgList");

        String strSql = $SELECT + $MAX(qHW_CreditTrkNgList.datarenno) +
            $FROM(qHW_CreditTrkNgList) +
            $WHERE+ qHW_CreditTrkNgList.tyouhyouymd.eq(pTyouhyouYmd);

        return exDBEntityManager.createJPQL(strSql)
            .bind(qHW_CreditTrkNgList).getSingleResult();
    }

}
