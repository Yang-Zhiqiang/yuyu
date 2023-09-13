package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;
/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 入金取消フラグ（不一致）
 */
public class FilterNyknJissekiRirekiByNyktrksflg implements Predicate<IT_NyknJissekiRireki> {

    C_Nyktrksflg nyktrksflg;

    public FilterNyknJissekiRirekiByNyktrksflg(C_Nyktrksflg pNyktrksflg) {
        super();
        nyktrksflg = pNyktrksflg;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki nyknJissekiRireki) {
        if(nyknJissekiRireki.getNyktrksflg() != null && !nyktrksflg.eq(nyknJissekiRireki.getNyktrksflg()) &&
            !C_Nykkeiro.ZENNOUJYUUTOU.eq(nyknJissekiRireki.getNykkeiro()) &&
            !C_Nykkeiro.HKNKIN.eq(nyknJissekiRireki.getNykkeiro())){
            return true;
        }
        return false;
    }
}
