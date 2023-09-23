package yuyu.common.hozen.khcommon.dba4commonnyuukin;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;

import com.google.common.base.Predicate;

/**
 * 案内収納履歴テーブル用Predicateクラス２
 */
public class FilterAnsyuRireki2 implements Predicate<IT_AnsyuRireki> {

    C_NyknaiyouKbn nyknaiyouKbn;

    BizDateYM jyuutouym;

    C_Nykkeiro nykkeiro;

    Integer jyutoukaisuuy;

    Integer jyutoukaisuum;

    C_AnnaijkKbn annaijkkbn;

    BizDate ryosyuymd;

    public FilterAnsyuRireki2(C_NyknaiyouKbn pNyknaiyouKbn, BizDateYM pJyuutouym, C_Nykkeiro pNykkeiro,
        Integer pJyutoukaisuuy, Integer pJyutoukaisuum, C_AnnaijkKbn pAnnaijkkbn, BizDate pRyosyuymd) {
        super();
        nyknaiyouKbn = pNyknaiyouKbn;
        jyuutouym = pJyuutouym;
        nykkeiro = pNykkeiro;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        annaijkkbn = pAnnaijkkbn;
        ryosyuymd = pRyosyuymd;
    }

    @Override
    public boolean apply(IT_AnsyuRireki pAnsyuRireki) {
        if (nyknaiyouKbn.eq(pAnsyuRireki.getNyknaiyoukbn()) &&
            BizDateUtil.compareYm(jyuutouym, pAnsyuRireki.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL &&
            nykkeiro.eq(pAnsyuRireki.getNykkeiro()) &&
            pAnsyuRireki.getJyutoukaisuuy().equals(jyutoukaisuuy) &&
            pAnsyuRireki.getJyutoukaisuum().equals(jyutoukaisuum) &&
            annaijkkbn.eq(pAnsyuRireki.getAnnaijkkbn())) {

            if (C_Nykkeiro.KZHRK.eq(nykkeiro)) {
                if (BizDateUtil.compareYmd(ryosyuymd, pAnsyuRireki.getHurikaeymd()) == BizDateUtil.COMPARE_EQUAL) {
                    return true;
                }

                return false;
            }
            else if (C_Nykkeiro.CREDIT.eq(nykkeiro)) {
                if (BizDateUtil.compareYmd(ryosyuymd, pAnsyuRireki.getUriageymdkon()) == BizDateUtil.COMPARE_EQUAL) {
                    return true;
                }

                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
