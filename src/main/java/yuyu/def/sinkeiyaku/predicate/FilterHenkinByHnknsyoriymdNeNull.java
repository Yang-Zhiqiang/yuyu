package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル 用 Predicate<br/>
 * 返金処理日 IS NOT NULL<br/>
 */
public class FilterHenkinByHnknsyoriymdNeNull implements Predicate<HT_Henkin>{

    public FilterHenkinByHnknsyoriymdNeNull() {
        super();
    }

    @Override
    public boolean apply(HT_Henkin pHT_Henkin) {
        if (pHT_Henkin.getHnknsyoriymd() != null) {
            return true;
        }
        return false;
    }
}