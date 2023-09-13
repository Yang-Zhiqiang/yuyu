package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 入金経路（不一致）、入金取消フラグ（一致）
 */
public class FilterNyknJissekiRirekiByNykkeiroNyktrksflg implements Predicate<IT_NyknJissekiRireki> {

    C_Nykkeiro nykkeiro;
    C_Nyktrksflg nyktrksflg;

    public FilterNyknJissekiRirekiByNykkeiroNyktrksflg(C_Nykkeiro pNykkeiro,C_Nyktrksflg pNyktrksflg) {
        super();
        nykkeiro = pNykkeiro;
        nyktrksflg = pNyktrksflg;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki nyknJissekiRireki) {
        if(nyknJissekiRireki.getNykkeiro() != null &&
            !nykkeiro.eq(nyknJissekiRireki.getNykkeiro()) && nyktrksflg.eq(nyknJissekiRireki.getNyktrksflg())){
            return true;
        }
        return false;
    }
}