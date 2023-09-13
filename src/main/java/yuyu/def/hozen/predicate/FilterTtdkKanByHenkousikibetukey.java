package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_TtdkKan;

import com.google.common.base.Predicate;

/**
 * 手続完了テーブル用 Predicate<br/>
 * 変更識別キー（一致）<br/>
 */
public class FilterTtdkKanByHenkousikibetukey implements Predicate<IT_TtdkKan> {

    String henkousikibetukey;

    public FilterTtdkKanByHenkousikibetukey(String pHenkousikibetukey) {
        super();
        henkousikibetukey = pHenkousikibetukey;
    }

    @Override
    public boolean apply(IT_TtdkKan ttdkKan) {
        if (henkousikibetukey.equals(ttdkKan.getHenkousikibetukey())) {
            return true;
        }
        return false;
    }
}