package yuyu.common.hozen.khcommon.dba4kykhenkoujiznnjyttrksksn;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用Predicate２クラス
 */
public class FilterNyknJissekiRireki2 implements Predicate<IT_NyknJissekiRireki> {

    private BizDateYM jyutoustartym;

    public FilterNyknJissekiRireki2(BizDateYM pJyutoustartYm) {
        super();
        this.jyutoustartym = pJyutoustartYm;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki pNyknJissekiRireki) {
        if (BizDateUtil.compareYm(pNyknJissekiRireki.getJyutoustartym(), jyutoustartym) == BizDateUtil.COMPARE_EQUAL) {
            return true;
        }
        return false;
    }

}
