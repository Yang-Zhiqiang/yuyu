package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブル用 Predicate<br/>
 * 充当開始年月 ＜ Ｉ．月単位直後応当月
 * 充当終了年月 != null
 * 充当終了年月≧ Ｉ．月単位直後応当月
 * 入金取消フラグ != null
 * 入金取消フラグ ≠ ＜入金取消フラグ＞取消
 */
public class FilterNyknJissekiRirekiByTukitanityokugooutoymNyktrksflg implements Predicate<IT_NyknJissekiRireki> {

    BizDateYM tukitanityokugooutoym;

    public FilterNyknJissekiRirekiByTukitanityokugooutoymNyktrksflg(BizDateYM pTukitanityokugooutoym) {
        super();
        tukitanityokugooutoym = pTukitanityokugooutoym;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki pNyknJissekiRireki) {
        if(pNyknJissekiRireki.getNyktrksflg() != null &&
            tukitanityokugooutoym.compareTo(pNyknJissekiRireki.getJyutoustartym()) > 0 &&
            pNyknJissekiRireki.getJyutouendym() != null &&
            tukitanityokugooutoym.compareTo(pNyknJissekiRireki.getJyutouendym()) <= 0 &&
            !C_Nyktrksflg.TORIKESI.eq(pNyknJissekiRireki.getNyktrksflg())){
            return true;
        }
        return false;
    }
}
