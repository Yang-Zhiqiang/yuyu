package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuui;

import com.google.common.base.Predicate;

/**
 * 新契約手続注意テーブル用 Predicate<br/>
 * 新契約手続連絡区分（一致）
 */
public class FilterSkTtdkTyuuiBySkeittdkrenrakukbn implements Predicate<HT_SkTtdkTyuui> {

    C_SkeittdkrenrakuKbn skeittdkrenrakukbn;

    public FilterSkTtdkTyuuiBySkeittdkrenrakukbn(C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn) {
        super();
        skeittdkrenrakukbn = pSkeittdkrenrakukbn;
    }

    @Override
    public boolean apply(HT_SkTtdkTyuui pSkTtdkTyuui) {
        if(skeittdkrenrakukbn.eq(pSkTtdkTyuui.getSkeittdkrenrakukbn())){
            return true;
        }
        return false;
    }

}
