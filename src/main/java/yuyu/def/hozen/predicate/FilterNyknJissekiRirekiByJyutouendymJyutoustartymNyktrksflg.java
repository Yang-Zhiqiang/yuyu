package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブルエンティティ用 Predicate<br/>
 * 充当終了年月、充当開始年月、入金取消フラグ（一致）<br/>
 */
public class FilterNyknJissekiRirekiByJyutouendymJyutoustartymNyktrksflg implements Predicate<IT_NyknJissekiRireki> {

    BizDateYM jyutouendym;
    BizDateYM jyutoustartym;
    C_Nyktrksflg nyktrksflg;

    public FilterNyknJissekiRirekiByJyutouendymJyutoustartymNyktrksflg(BizDateYM pJyutouendym,BizDateYM pJyutoustartym,C_Nyktrksflg pNyktrksflg) {
        super();
        jyutouendym = pJyutouendym;
        jyutoustartym = pJyutoustartym;
        nyktrksflg = pNyktrksflg;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki pNyknJissekiRireki) {
        if (pNyknJissekiRireki.getJyutouendym() != null &&
            jyutouendym.compareTo(pNyknJissekiRireki.getJyutouendym()) <= 0 &&
            jyutoustartym.compareTo(pNyknJissekiRireki.getJyutoustartym()) > 0 &&
            pNyknJissekiRireki.getNyktrksflg() != null &&
            !nyktrksflg.eq(pNyknJissekiRireki.getNyktrksflg())) {
            return true;
        }
        return false;
    }
}