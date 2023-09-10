package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 全額返金区分（不一致）
 */
public class FilterNyuukinByZenhnknkbnNe implements Predicate<HT_Nyuukin> {

    C_ZenhnknKbn zenhnknKbn;

    public FilterNyuukinByZenhnknkbnNe(C_ZenhnknKbn pZenhnknkbn) {
        super();
        zenhnknKbn = pZenhnknkbn;
    }

    @Override
    public boolean apply(HT_Nyuukin nyuukin) {
        if (nyuukin.getZenhnknkbn() != null
            && !zenhnknKbn.eq(nyuukin.getZenhnknkbn())) {
            return true;
        }
        return false;
    }

}
