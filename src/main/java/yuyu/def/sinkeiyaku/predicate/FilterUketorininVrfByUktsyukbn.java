package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_UketorininVrf;

import com.google.common.base.Predicate;

/**
 * 受取人ベリファイテーブル用 Predicate<br/>
 * 受取人種類区分（一致）
 */
public class FilterUketorininVrfByUktsyukbn implements Predicate<HT_UketorininVrf> {

    C_UktsyuKbn uktsyuKbn;

    public FilterUketorininVrfByUktsyukbn(C_UktsyuKbn pUktsyukbn) {

        super();

        uktsyuKbn = pUktsyukbn;
    }

    @Override
    public boolean apply(HT_UketorininVrf pUketorininVrf) {

        if (uktsyuKbn.eq(pUketorininVrf.getUktsyukbn())) {

            return true;
        }

        return false;
    }
}