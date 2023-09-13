package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KhTtdkRireki;

import com.google.common.base.Predicate;

/**
 * 契約保全手続履歴テーブル用 Predicate<br/>
 * 変更識別キー（一致）<br/>
 */
public class FilterKhTtdkRirekiByHenkousikibetukeyGt implements Predicate<IT_KhTtdkRireki> {

    String henkousikibetukey;

    public FilterKhTtdkRirekiByHenkousikibetukeyGt(String pHenkousikibetukey) {
        super();
        henkousikibetukey = pHenkousikibetukey;
    }

    @Override
    public boolean apply(IT_KhTtdkRireki khTtdkRireki) {
        if (henkousikibetukey.compareTo(khTtdkRireki.getHenkousikibetukey()) < 0) {
            return true;
        }
        return false;
    }
}