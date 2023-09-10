package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金通貨種類（一致）
 */
public class FilterHenkinByHnkntuukasyu implements Predicate<HT_Henkin>{

    C_Tuukasyu hnkntuukasyu;

    public FilterHenkinByHnkntuukasyu(C_Tuukasyu pHnkntuukasyu){
        super();
        hnkntuukasyu = pHnkntuukasyu;
    }

    @Override
    public boolean apply(HT_Henkin pHT_Henkin) {

        if(hnkntuukasyu.eq(pHT_Henkin.getHnkntuukasyu())){

            return true;

        }
        return false;
    }
}
