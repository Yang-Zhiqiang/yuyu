package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.db.entity.HT_DakuhiKettei;

import com.google.common.base.Predicate;

/**
 * 諾否決定テーブル用 Predicate<br/>
 * 決定結果コード（不一致）
 */
public class FilterDakuhiKetteiByKetkekkacd implements Predicate<HT_DakuhiKettei>{

    C_Ketkekkacd ketkekkacd;

    public FilterDakuhiKetteiByKetkekkacd(C_Ketkekkacd pKetkekkacd){
        super();
        ketkekkacd = pKetkekkacd;
    }

    @Override
    public boolean apply(HT_DakuhiKettei pDakuhiKettei) {
        if (pDakuhiKettei.getKetkekkacd() != null && !ketkekkacd.eq(pDakuhiKettei.getKetkekkacd())){
            return true;
        }
        return false;
    }
}