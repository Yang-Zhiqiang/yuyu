package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 領収通貨種類（一致）
 */
public class FilterNyuukinByRstuukasyu implements Predicate<HT_Nyuukin>{

    C_Tuukasyu tuukasyu;

    public FilterNyuukinByRstuukasyu(C_Tuukasyu pRstuukasyu){
        super();

        tuukasyu = pRstuukasyu;
    }

    @Override
    public boolean apply(HT_Nyuukin nyuukin) {
        if (tuukasyu.eq(nyuukin.getRstuukasyu())) {
            return true;
        }
        return false;
    }
}
