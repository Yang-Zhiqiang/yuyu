package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.base.Predicate;

/**
 * 入金実績履歴テーブルエンティティ用 Predicate<br/>
 * 入金実績履歴テーブル．充当終了年月　!＝　NULL　かつ
 * I．払込期月 ≦　入金実績履歴テーブル．充当終了年月　かつ
 * I．次回Ｐ充当年月 ＞　入金実績履歴テーブル．充当終了年月　かつ
 * 入金実績履歴テーブル．入金取消フラグ　!＝　NULL　かつ
 * I．入金取消フラグ　≠　入金実績履歴テーブル．入金取消フラグ<br/>
 */
public class FilterNyknJissekiRirekiByHrkkymJkipjytymNyktrksflg implements Predicate<IT_NyknJissekiRireki> {

    BizDateYM hrkkym;
    BizDateYM jkipjytym;
    C_Nyktrksflg nyktrksflg;

    public FilterNyknJissekiRirekiByHrkkymJkipjytymNyktrksflg(BizDateYM pHrkkym,BizDateYM pJkipjytym,C_Nyktrksflg pNyktrksflg) {
        super();
        hrkkym = pHrkkym;
        jkipjytym = pJkipjytym;
        nyktrksflg = pNyktrksflg;
    }

    @Override
    public boolean apply(IT_NyknJissekiRireki pNyknJissekiRireki) {
        if (pNyknJissekiRireki.getJyutouendym() != null &&
            hrkkym.compareTo(pNyknJissekiRireki.getJyutouendym()) <= 0 &&
            jkipjytym.compareTo(pNyknJissekiRireki.getJyutouendym()) > 0 &&
            pNyknJissekiRireki.getNyktrksflg() != null &&
            !nyktrksflg.eq(pNyknJissekiRireki.getNyktrksflg())) {
            return true;
        }
        return false;
    }
}