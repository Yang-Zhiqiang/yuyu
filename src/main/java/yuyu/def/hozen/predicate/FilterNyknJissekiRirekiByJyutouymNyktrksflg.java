package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 計算基準年月（一致）、入金取消フラグ（一致）
 */
public class FilterNyknJissekiRirekiByJyutouymNyktrksflg implements Predicate<IT_NyknJissekiRireki> {

    BizDateYM keisannkizyunnbi;
    C_Nyktrksflg nyktrksflg;

    public FilterNyknJissekiRirekiByJyutouymNyktrksflg(BizDateYM pKeisannkizyunnbi,
        C_Nyktrksflg pNyktrksflg) {
        super();
        keisannkizyunnbi = pKeisannkizyunnbi;
        nyktrksflg = pNyktrksflg;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki nyknJissekiRireki) {
        if(keisannkizyunnbi.compareTo(nyknJissekiRireki.getJyutoustartym()) > 0
            && nyknJissekiRireki.getJyutouendym() != null
            && keisannkizyunnbi.compareTo(nyknJissekiRireki.getJyutouendym()) <= 0
            && nyknJissekiRireki.getNyktrksflg() != null
            && !nyktrksflg.equals(nyknJissekiRireki.getNyktrksflg()) ){
            return true;
        }
        return false;
    }
}