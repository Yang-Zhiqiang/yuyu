package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KhHubiDetail;

import com.google.common.base.Predicate;

/**
 * 契約保全不備詳細テーブル用 Predicate<br/>
 * 発信日（非空）、解消日（非空）
 */
public class FilterKhHubiDetailsByHasinymdKaisyouymdNotNull implements Predicate<IT_KhHubiDetail> {

    public FilterKhHubiDetailsByHasinymdKaisyouymdNotNull() {

        super();
    }

    @Override
    public boolean apply(IT_KhHubiDetail pKhHubiDetail) {

        if (pKhHubiDetail.getHasinymd() != null && pKhHubiDetail.getKaisyouymd() != null) {

            return true;
        }

        return false;
    }
}