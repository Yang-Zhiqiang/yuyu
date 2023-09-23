package yuyu.common.hozen.khcommon.dba4kykhenkoujiznnjyttrksksn;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import jp.co.slcs.swak.date.BizDateYM;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用Predicate１クラス
 */
public class FilterNyknJissekiRireki1 implements Predicate<IT_NyknJissekiRireki> {

    private BizDateYM jyutoustartym;

    public FilterNyknJissekiRireki1(BizDateYM pJyutoustartYm) {
        super();
        this.jyutoustartym = pJyutoustartYm;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki pNyknJissekiRireki) {
        if ((BizDateUtil.compareYm(pNyknJissekiRireki.getJyutoustartym(), jyutoustartym) == BizDateUtil.COMPARE_EQUAL||
            BizDateUtil.compareYm(pNyknJissekiRireki.getJyutoustartym(), jyutoustartym) == BizDateUtil.COMPARE_GREATER)
            && !C_Nyktrksflg.TORIKESI.eq(pNyknJissekiRireki.getNyktrksflg()) ) {
            return true;
        }
        return false;
    }
}
