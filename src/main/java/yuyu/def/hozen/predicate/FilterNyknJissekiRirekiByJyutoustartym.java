package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 充当開始年月（一致）
 */
public class FilterNyknJissekiRirekiByJyutoustartym implements Predicate<IT_NyknJissekiRireki> {

    BizDateYM jyutoustartym;

    public FilterNyknJissekiRirekiByJyutoustartym(BizDateYM pJyutoustartym) {
        super();
        jyutoustartym = pJyutoustartym;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki nyknJissekiRireki) {
        if(jyutoustartym.equals(nyknJissekiRireki.getJyutoustartym())){
            return true;
        }
        return false;
    }
}