package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KhHubiDetail;

import com.google.common.base.Predicate;

/**
 * 契約保全不備詳細テーブル用 Predicate<br/>
 * 発信日 IS NOT NULL<br/>
 */
public class FilterKhHubiDetailByHasinymd implements Predicate<IT_KhHubiDetail> {

    @Override
    public boolean apply(IT_KhHubiDetail khHubiDetail) {
        if (khHubiDetail.getHasinymd() != null) {
            return true;
        }
        return false;
    }
}