package yuyu.batch.hozen.khansyuu.khuriageseikyuuminyuukkhanei.dba;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;

import com.google.common.base.Predicate;

/**
 * 案内収納履歴テーブル用Predicateクラス１
 *
 */
public class FilterAnsyuRireki1 implements Predicate<IT_AnsyuRireki> {

    C_NyknaiyouKbn nyknaiyoukbn;
    BizDateYM jyuutouym;
    C_Nykkeiro nykkeiro;
    Integer jyutoukaisuuy;
    Integer jyutoukaisuum;
    BizCurrency rsgaku;
    BizDate ryosyuymd;
    C_AnnaijkKbn annaijkkbn;

    public FilterAnsyuRireki1(C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM pJyuutouym,
        C_Nykkeiro pNykkeiro,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        BizCurrency pRsgaku,
        BizDate pRyosyuymd,
        C_AnnaijkKbn pAnnaijkKbn) {
        super();
        nyknaiyoukbn = pNyknaiyoukbn;
        jyuutouym = pJyuutouym;
        nykkeiro = pNykkeiro;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        rsgaku = pRsgaku;
        ryosyuymd = pRyosyuymd;
        annaijkkbn = pAnnaijkKbn;
    }

    @Override
    public boolean apply(IT_AnsyuRireki pAnsyuRireki) {
        if (nyknaiyoukbn.eq(pAnsyuRireki.getNyknaiyoukbn())
            && BizDateUtil.compareYm(jyuutouym, pAnsyuRireki.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL
            && nykkeiro.eq(pAnsyuRireki.getNykkeiro())
            && jyutoukaisuuy.compareTo(pAnsyuRireki.getJyutoukaisuuy()) == 0
            && jyutoukaisuum.compareTo(pAnsyuRireki.getJyutoukaisuum()) == 0
            && rsgaku.equalsValue(pAnsyuRireki.getRsgaku())
            && annaijkkbn.eq(pAnsyuRireki.getAnnaijkkbn())
            && BizDateUtil.compareYmd(ryosyuymd,
                pAnsyuRireki.getUriageymdkon()) == BizDateUtil.COMPARE_EQUAL) {
            return true;
        }
        return false;
    }

}
