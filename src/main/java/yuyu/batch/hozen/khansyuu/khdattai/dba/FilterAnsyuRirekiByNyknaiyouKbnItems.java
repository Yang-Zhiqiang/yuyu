package yuyu.batch.hozen.khansyuu.khdattai.dba;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;

import com.google.common.base.Predicate;

/**
 * 案内収納履歴テーブル用Predicateクラス
 */
public class FilterAnsyuRirekiByNyknaiyouKbnItems implements Predicate<IT_AnsyuRireki> {

    C_NyknaiyouKbn nyknaiyouKbn;
    BizDateYM dattaiYm;
    C_Nykkeiro nykkeiro;
    Integer jyutoukaisuuy;
    Integer jyutoukaisuum;
    BizDate hurikaeymd;

    public FilterAnsyuRirekiByNyknaiyouKbnItems(C_NyknaiyouKbn pNyknaiyouKbn,
        BizDateYM pDattaiYm, C_Nykkeiro pNykkeiro, Integer pJyutoukaisuuy, Integer pJyutoukaisuum, BizDate pHurikaeymd) {
        super();
        nyknaiyouKbn = pNyknaiyouKbn;
        dattaiYm = pDattaiYm;
        nykkeiro = pNykkeiro;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        hurikaeymd = pHurikaeymd;
    }

    @Override
    public boolean apply(IT_AnsyuRireki pAnsyuRireki) {

        boolean hanteiKekka = pAnsyuRireki.getNyknaiyoukbn().eq(nyknaiyouKbn) &&
            BizDateUtil.compareYm(pAnsyuRireki.getJyuutouym(), dattaiYm) == BizDateUtil.COMPARE_EQUAL &&
            pAnsyuRireki.getNykkeiro().eq(nykkeiro) &&
            pAnsyuRireki.getJyutoukaisuuy().equals(jyutoukaisuuy) &&
            pAnsyuRireki.getJyutoukaisuum().equals(jyutoukaisuum);

        if (C_Nykkeiro.KZHRK.eq(nykkeiro)) {

            hanteiKekka = hanteiKekka && BizDateUtil.compareYmd(pAnsyuRireki.getHurikaeymd(), hurikaeymd)
                == BizDateUtil.COMPARE_EQUAL;
        }
        else if(C_Nykkeiro.CREDIT.eq(nykkeiro)) {

            hanteiKekka = hanteiKekka && BizDateUtil.compareYmd(pAnsyuRireki.getUriageymdkon(), hurikaeymd) ==
                BizDateUtil.COMPARE_EQUAL;
        }

        return hanteiKekka;
    }
}