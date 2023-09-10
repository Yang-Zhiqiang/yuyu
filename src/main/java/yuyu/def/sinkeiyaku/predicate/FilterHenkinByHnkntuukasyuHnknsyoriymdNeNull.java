package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金通貨種類（一致）、返金処理日 IS NOT NUL <br/>
 */
public class FilterHenkinByHnkntuukasyuHnknsyoriymdNeNull implements Predicate<HT_Henkin>{

    C_Tuukasyu hnkntuukasyu;

    public FilterHenkinByHnkntuukasyuHnknsyoriymdNeNull(C_Tuukasyu pHnkntuukasyu){
        super();
        hnkntuukasyu = pHnkntuukasyu;
    }

    @Override
    public boolean apply(HT_Henkin pHT_Henkin) {

        if(hnkntuukasyu.eq(pHT_Henkin.getHnkntuukasyu()) && pHT_Henkin.getHnknsyoriymd() != null){

            return true;

        }
        return false;
    }
}
