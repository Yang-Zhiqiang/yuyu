package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykUkt;

import com.google.common.base.Predicate;

/**
 * 契約受取人テーブル用 Predicate<br/>
 * 受取人種類区分、受取人種類別連番（一致）
 */
public class FilterKykUktByUktsyukbnUktsyurenno implements Predicate<IT_KykUkt> {

    C_UktsyuKbn uktsyukbn;
    Integer uktsyurenno;

    public FilterKykUktByUktsyukbnUktsyurenno(C_UktsyuKbn pUktsyukbn, Integer pUktsyurenno) {
        super();
        uktsyukbn = pUktsyukbn;
        uktsyurenno = pUktsyurenno;
    }

    @Override
    public boolean apply(IT_KykUkt kykUkt) {
        if (uktsyukbn.eq(kykUkt.getUktsyukbn()) && uktsyurenno.equals(kykUkt.getUktsyurenno())) {
            return true;
        }
        return false;
    }

}
