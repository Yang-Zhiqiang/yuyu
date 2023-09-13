package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KoujyoSymKanri;

import com.google.common.base.Predicate;

/**
 * 控除証明書管理テーブル用 Predicate<br/>
 * 年度（一致）<br/>
 */
public class FilterKoujyoSymKanriByNendo implements Predicate<IT_KoujyoSymKanri> {

    String nendo;

    public FilterKoujyoSymKanriByNendo(String pNendo) {
        super();
        nendo = pNendo;
    }

    @Override
    public boolean apply(IT_KoujyoSymKanri koujyoSymKanri) {

        if (nendo.equals(koujyoSymKanri.getNendo())) {
            return true;
        }
        return false;
    }
}