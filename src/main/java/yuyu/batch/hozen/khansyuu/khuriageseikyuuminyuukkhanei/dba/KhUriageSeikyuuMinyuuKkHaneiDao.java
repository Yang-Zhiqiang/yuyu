package yuyu.batch.hozen.khansyuu.khuriageseikyuuminyuukkhanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.meta.QIT_TRCreditKurikosiMinyuu;

import com.google.common.collect.Collections2;

/**
 * 契約保全 案内収納 売上請求未入結果反映機能DAOクラスです。
 */
public class KhUriageSeikyuuMinyuuKkHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<TRCreditKurikosiMinyuuBean> getTRCreditMinyuus(String pKakutyoujobcd, BizDate pSyoribiYm) {

        QIT_TRCreditKurikosiMinyuu qiT_TRCreditKurikosiMinyuu = new QIT_TRCreditKurikosiMinyuu
            ("qiT_TRCreditKurikosiMinyuu");

        String sql = $SELECT + $NEW(TRCreditKurikosiMinyuuBean.class,
            qiT_TRCreditKurikosiMinyuu.syono,
            qiT_TRCreditKurikosiMinyuu.nyknaiyoukbn,
            qiT_TRCreditKurikosiMinyuu.jyuutouym,
            qiT_TRCreditKurikosiMinyuu.nykkeiro,
            qiT_TRCreditKurikosiMinyuu.jyutoukaisuuy,
            qiT_TRCreditKurikosiMinyuu.jyutoukaisuum,
            qiT_TRCreditKurikosiMinyuu.rsgaku.getTypeFieldName(),
            qiT_TRCreditKurikosiMinyuu.rsgaku.getValueFieldName(),
            qiT_TRCreditKurikosiMinyuu.ryosyuymd,
            qiT_TRCreditKurikosiMinyuu.credituriagengjiyuu,
            qiT_TRCreditKurikosiMinyuu.kbnkey) +
            $FROM(qiT_TRCreditKurikosiMinyuu) +
            $WHERE + qiT_TRCreditKurikosiMinyuu.syoriYmd.eq(pSyoribiYm);

        ExDBResults<TRCreditKurikosiMinyuuBean> exDBResults = exDBEntityManager.createJPQL(sql,
            TRCreditKurikosiMinyuuBean.class).bind(qiT_TRCreditKurikosiMinyuu).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public List<IT_AnsyuRireki> getAnsyuRirekis(IT_AnsyuKihon pAnsyuKihon, C_NyknaiyouKbn pNyknaiyouKbn, BizDateYM pJyuutouYm,
        C_Nykkeiro pNykkeiro, Integer pJyutoukaiSuuy, Integer pJyutoukaiSuum, BizCurrency pRsgaku, BizDate pRyosyuYmd,
        C_AnnaijkKbn pAnnai) {

        List<IT_AnsyuRireki> ansyuRirekiLst = pAnsyuKihon.getAnsyuRirekis();

        return new ArrayList<IT_AnsyuRireki>(Collections2.filter(ansyuRirekiLst, new FilterAnsyuRireki1(
            pNyknaiyouKbn, pJyuutouYm, pNykkeiro, pJyutoukaiSuuy, pJyutoukaiSuum, pRsgaku, pRyosyuYmd, pAnnai)));

    }
}
