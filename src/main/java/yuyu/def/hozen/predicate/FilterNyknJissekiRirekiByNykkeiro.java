package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 入金経路（一致）
 */
public class FilterNyknJissekiRirekiByNykkeiro implements Predicate<IT_NyknJissekiRireki> {

    C_Nykkeiro nykkeiro;

    public FilterNyknJissekiRirekiByNykkeiro(C_Nykkeiro pNykkeiro) {
        super();
        nykkeiro = pNykkeiro;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki nyknJissekiRireki) {
        if(nykkeiro.eq(nyknJissekiRireki.getNykkeiro())){
            return true;
        }
        return false;
    }
}
