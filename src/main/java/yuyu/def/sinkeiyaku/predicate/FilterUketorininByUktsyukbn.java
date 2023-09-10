package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_Uketorinin;

import com.google.common.base.Predicate;

/**
 * 受取人テーブル用 Predicate<br/>
 * 受取人種類区分（一致）
 */
public class FilterUketorininByUktsyukbn implements Predicate<HT_Uketorinin>{

    C_UktsyuKbn uktsyukbn;

    public FilterUketorininByUktsyukbn(C_UktsyuKbn pUktsyukbn){
        super();
        uktsyukbn = pUktsyukbn;
    }

    @Override
    public boolean apply(HT_Uketorinin pUketorinin) {

        if(uktsyukbn.eq(pUketorinin.getUktsyukbn())) {
            return true;
        }
        return false;
    }

}
