package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_ImusateiRireki;

import com.google.common.base.Predicate;

/**
 * 医務査定履歴テーブル用 Predicate<br/>
 * 医務査定結果区分（一致）
 */
public class FilterImusateiRirekiByImusateikekkakbn implements Predicate<HT_ImusateiRireki> {

    C_SyorikekkaKbn imusateikekkakbn;

    public FilterImusateiRirekiByImusateikekkakbn(C_SyorikekkaKbn pImusateikekkakbn) {
        super();
        imusateikekkakbn = pImusateikekkakbn;
    }

    @Override
    public boolean apply(HT_ImusateiRireki pHT_ImusateiRireki) {
        if (pHT_ImusateiRireki.getImusateikekkakbn().eq(imusateikekkakbn)) {
            return true;
        }
        return false;
    }

}
