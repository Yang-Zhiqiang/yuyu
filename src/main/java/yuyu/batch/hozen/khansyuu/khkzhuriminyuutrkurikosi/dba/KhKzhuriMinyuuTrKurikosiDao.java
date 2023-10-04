package yuyu.batch.hozen.khansyuu.khkzhuriminyuutrkurikosi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_TRKzhuriKurikosiMinyuu;

/**
 * 契約保全 案内収納 口座振替未入ＴＲ繰越処理の機能DAOクラスです
 */
public class KhKzhuriMinyuuTrKurikosiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<TRKzhuriKurikosiMinyuuBean> getTRKzhuriKurikosiMinyuuBeans(String pKakutyoujobCd) {

        QIT_TRKzhuriKurikosiMinyuu qIT_TRKzhuriKurikosiMinyuu = new QIT_TRKzhuriKurikosiMinyuu("qIT_TRKzhuriKurikosiMinyuu");

        String strSql = $SELECT + $NEW(TRKzhuriKurikosiMinyuuBean.class,
            qIT_TRKzhuriKurikosiMinyuu.kbnkey,
            qIT_TRKzhuriKurikosiMinyuu.syono,
            qIT_TRKzhuriKurikosiMinyuu.syoriYmd,
            qIT_TRKzhuriKurikosiMinyuu.minyuutrrenno,
            qIT_TRKzhuriKurikosiMinyuu.nykkeiro,
            qIT_TRKzhuriKurikosiMinyuu.nyknaiyoukbn,
            qIT_TRKzhuriKurikosiMinyuu.jyuutouym,
            qIT_TRKzhuriKurikosiMinyuu.jyutoukaisuuy,
            qIT_TRKzhuriKurikosiMinyuu.jyutoukaisuum,
            qIT_TRKzhuriKurikosiMinyuu.rsgaku.getTypeFieldName(),
            qIT_TRKzhuriKurikosiMinyuu.rsgaku.getValueFieldName(),
            qIT_TRKzhuriKurikosiMinyuu.ryosyuymd,
            qIT_TRKzhuriKurikosiMinyuu.hurihunokbn,
            qIT_TRKzhuriKurikosiMinyuu.bankcd,
            qIT_TRKzhuriKurikosiMinyuu.sitencd,
            qIT_TRKzhuriKurikosiMinyuu.yokinkbn,
            qIT_TRKzhuriKurikosiMinyuu.kouzano,
            qIT_TRKzhuriKurikosiMinyuu.dantaikobetukbn,
            qIT_TRKzhuriKurikosiMinyuu.hrkkaisuu,
            qIT_TRKzhuriKurikosiMinyuu.kzhurikaetkbtannaihyj,
            qIT_TRKzhuriKurikosiMinyuu.tikiktbrisyuruikbn,
            qIT_TRKzhuriKurikosiMinyuu.creditkessaiyouno,
            qIT_TRKzhuriKurikosiMinyuu.credituriagengjiyuu,
            qIT_TRKzhuriKurikosiMinyuu.gyoumuKousinKinou,
            qIT_TRKzhuriKurikosiMinyuu.gyoumuKousinsyaId,
            qIT_TRKzhuriKurikosiMinyuu.gyoumuKousinTime) +
            $FROM(qIT_TRKzhuriKurikosiMinyuu);

        ExDBResults<TRKzhuriKurikosiMinyuuBean> exDBResults =
            exDBEntityManager.createJPQL(strSql, TRKzhuriKurikosiMinyuuBean.class).bind(qIT_TRKzhuriKurikosiMinyuu).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobCd));

        return exDBResults;
    }

    public Integer deleteTRKzhuriKurikosiMinyuu() {

        QIT_TRKzhuriKurikosiMinyuu qIT_TRKzhuriKurikosiMinyuu = new QIT_TRKzhuriKurikosiMinyuu("qIT_TRKzhuriKurikosiMinyuu");

        String strSql = $DELETE_FROM(qIT_TRKzhuriKurikosiMinyuu);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_TRKzhuriKurikosiMinyuu).executeUpdate();
    }
}
