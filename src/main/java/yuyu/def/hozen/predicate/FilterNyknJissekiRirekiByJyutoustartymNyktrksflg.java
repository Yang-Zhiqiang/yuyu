package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 充当開始年月（一致）
 */
public class FilterNyknJissekiRirekiByJyutoustartymNyktrksflg implements Predicate<IT_NyknJissekiRireki> {

    BizDateYM jyutoustartym;

    public FilterNyknJissekiRirekiByJyutoustartymNyktrksflg(BizDateYM pJyutoustartym) {
        super();
        jyutoustartym = pJyutoustartym;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki nyknJissekiRireki) {
        if(jyutoustartym.equals(nyknJissekiRireki.getJyutoustartym())
            && nyknJissekiRireki.getNyktrksflg() != null
            && !C_Nyktrksflg.TORIKESI.equals(nyknJissekiRireki.getNyktrksflg()) ){
            return true;
        }
        return false;
    }
}