package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KhTtdkRireki;

import com.google.common.base.Predicate;

/**
 * 契約保全手続履歴テーブル用 Predicate<br/>
 * 変更識別キー（一致）<br/>
 */
public class FilterKhTtdkRirekiByHenkousikibetukey implements Predicate<IT_KhTtdkRireki> {

    String henkousikibetukey;

    public FilterKhTtdkRirekiByHenkousikibetukey(String pHenkousikibetukey) {
        super();
        henkousikibetukey = pHenkousikibetukey;
    }

    @Override
    public boolean apply(IT_KhTtdkRireki khTtdkRireki) {
        if (henkousikibetukey.equals(khTtdkRireki.getHenkousikibetukey())) {
            return true;
        }
        return false;
    }
}