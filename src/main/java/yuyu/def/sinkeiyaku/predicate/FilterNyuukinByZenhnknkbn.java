package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 募集基本テーブル用 Predicate<br/>
 * 全額返金区分（一致）<br/>
 */
public class FilterNyuukinByZenhnknkbn implements Predicate<HT_Nyuukin> {

    C_ZenhnknKbn zenhnknKbn;

    public FilterNyuukinByZenhnknkbn(C_ZenhnknKbn pZenhnknkbn) {

        super();

        zenhnknKbn = pZenhnknkbn;
    }

    @Override
    public boolean apply(HT_Nyuukin pNyuukin) {

        if (zenhnknKbn.eq(pNyuukin.getZenhnknkbn())) {

            return true;
        }

        return false;
    }
}
