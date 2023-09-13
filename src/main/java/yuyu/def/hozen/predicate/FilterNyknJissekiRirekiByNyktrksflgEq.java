package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 入金取消フラグ（一致）
 */
public class FilterNyknJissekiRirekiByNyktrksflgEq implements Predicate<IT_NyknJissekiRireki> {

    C_Nyktrksflg nyktrksflg;

    public FilterNyknJissekiRirekiByNyktrksflgEq(C_Nyktrksflg pNyktrksflg) {
        super();
        nyktrksflg = pNyktrksflg;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki nyknJissekiRireki) {
        if(nyktrksflg.eq(nyknJissekiRireki.getNyktrksflg())){
            return true;
        }
        return false;
    }
}
