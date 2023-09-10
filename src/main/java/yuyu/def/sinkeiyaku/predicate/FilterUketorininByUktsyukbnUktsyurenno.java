package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_Uketorinin;

import com.google.common.base.Predicate;

/**
 * 受取人テーブル用 Predicate<br/>
 * 受取人種類区分（一致）<br/>
 * 受取人種類別連番（一致）<br/>
 */
public class FilterUketorininByUktsyukbnUktsyurenno implements Predicate<HT_Uketorinin> {

    C_UktsyuKbn uktsyukbn;
    Integer uktsyurenno;

    public FilterUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn pUktsyukbn, Integer pUktsyurenno) {

        super();

        uktsyukbn = pUktsyukbn;

        uktsyurenno = pUktsyurenno;
    }

    @Override
    public boolean apply(HT_Uketorinin pUketorinin) {

        if(uktsyukbn.eq(pUketorinin.getUktsyukbn()) && uktsyurenno.equals(pUketorinin.getUktsyurenno())) {

            return true;
        }

        return false;
    }
}
