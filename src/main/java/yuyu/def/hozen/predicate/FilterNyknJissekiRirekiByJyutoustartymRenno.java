package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 充当開始年月（一致）、連番（一致）
 */
public class FilterNyknJissekiRirekiByJyutoustartymRenno implements Predicate<IT_NyknJissekiRireki> {

    BizDateYM jyutoustartym;
    Integer renno;

    public FilterNyknJissekiRirekiByJyutoustartymRenno(BizDateYM pJyutoustartym,Integer pRenno) {
        super();
        jyutoustartym = pJyutoustartym;
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki pNyknJissekiRireki) {
        if(jyutoustartym.compareTo(pNyknJissekiRireki.getJyutoustartym()) == 0 && renno.equals(pNyknJissekiRireki.getRenno())){
            return true;
        }
        return false;
    }
}
