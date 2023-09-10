package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 全額返金区分がブランク
 */
public class FilterNyuukinByZenhnknkbnBlank implements Predicate<HT_Nyuukin> {

    public FilterNyuukinByZenhnknkbnBlank() {

        super();

    }

    @Override
    public boolean apply(HT_Nyuukin pNyuukin) {

        if (C_ZenhnknKbn.BLNK.eq(pNyuukin.getZenhnknkbn())) {

            return true;
        }

        return false;
    }
}