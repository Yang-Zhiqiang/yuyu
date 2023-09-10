package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_SiHubiDetail;

import com.google.common.base.Predicate;

/**
 * 支払不備詳細テーブル 用 Predicate<br />
 * 発信日（非空）、解消日（空）<br />
 */
public class FilterSiHubiDetailByHasinymdNotNullKaisyouymdNull implements Predicate<JT_SiHubiDetail> {

    public FilterSiHubiDetailByHasinymdNotNullKaisyouymdNull() {

        super();
    }

    @Override
    public boolean apply(JT_SiHubiDetail pSiHubiDetail) {

        if (pSiHubiDetail.getHasinymd() != null && pSiHubiDetail.getKaisyouymd() == null) {

            return true;
        }

        return false;
    }
}
