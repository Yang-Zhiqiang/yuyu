package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykUkt;

import com.google.common.base.Predicate;

/**
 * 契約受取人テーブル用 Predicate<br/>
 * 受取人種類区分（一致）
 */
public class FilterKykUktByUktsyukbn implements Predicate<IT_KykUkt>{

    C_UktsyuKbn uktsyukbn;

    public FilterKykUktByUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        super();
        uktsyukbn = pUktsyukbn;
    }

    @Override
    public boolean apply(IT_KykUkt kykUkt) {
        if(uktsyukbn.eq(kykUkt.getUktsyukbn())){
            return true;
        }
        return false;
    }

}
