package yuyu.batch.hozen.khansyuu.khcreditminyuutrsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_TRCreditKurikosiMinyuu;

/**
 * 契約保全 案内収納 クレカ未入ＴＲ作成Daoクラス
 */
public class KhCreditMinyuuTrSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<TRCreditKurikosiMinyuuBean> getTRCreditKurikosiMinyuuBeans(String pKakutyouJobCd) {

        QIT_TRCreditKurikosiMinyuu qIT_TRCreditKurikosiMinyuu = new QIT_TRCreditKurikosiMinyuu(
            "qIT_TRCreditKurikosiMinyuu");

        String sql = $SELECT + $NEW(TRCreditKurikosiMinyuuBean.class,
            qIT_TRCreditKurikosiMinyuu.syono,
            qIT_TRCreditKurikosiMinyuu.syoriYmd,
            qIT_TRCreditKurikosiMinyuu.minyuutrrenno,
            qIT_TRCreditKurikosiMinyuu.nykkeiro,
            qIT_TRCreditKurikosiMinyuu.nyknaiyoukbn,
            qIT_TRCreditKurikosiMinyuu.jyuutouym,
            qIT_TRCreditKurikosiMinyuu.jyutoukaisuuy,
            qIT_TRCreditKurikosiMinyuu.jyutoukaisuum,
            qIT_TRCreditKurikosiMinyuu.rsgaku.getTypeFieldName(),
            qIT_TRCreditKurikosiMinyuu.rsgaku.getValueFieldName(),
            qIT_TRCreditKurikosiMinyuu.ryosyuymd,
            qIT_TRCreditKurikosiMinyuu.hurihunokbn,
            qIT_TRCreditKurikosiMinyuu.bankcd,
            qIT_TRCreditKurikosiMinyuu.sitencd,
            qIT_TRCreditKurikosiMinyuu.yokinkbn,
            qIT_TRCreditKurikosiMinyuu.kouzano,
            qIT_TRCreditKurikosiMinyuu.dantaikobetukbn,
            qIT_TRCreditKurikosiMinyuu.hrkkaisuu,
            qIT_TRCreditKurikosiMinyuu.kzhurikaetkbtannaihyj,
            qIT_TRCreditKurikosiMinyuu.tikiktbrisyuruikbn,
            qIT_TRCreditKurikosiMinyuu.creditkessaiyouno,
            qIT_TRCreditKurikosiMinyuu.credituriagengjiyuu) +
            $FROM(qIT_TRCreditKurikosiMinyuu) +
            $ORDER_BY(qIT_TRCreditKurikosiMinyuu.syono.asc(),
                qIT_TRCreditKurikosiMinyuu.syoriYmd.asc(),
                qIT_TRCreditKurikosiMinyuu.minyuutrrenno.asc());

        ExDBResults<TRCreditKurikosiMinyuuBean> exDBResults = exDBEntityManager.createJPQL(sql, TRCreditKurikosiMinyuuBean.class)
            .bind(qIT_TRCreditKurikosiMinyuu).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
