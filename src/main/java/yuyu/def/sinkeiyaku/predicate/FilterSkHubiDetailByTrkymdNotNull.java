package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_SkHubiDetail;

import com.google.common.base.Predicate;

/**
 * 新契約不備詳細テーブル用 Predicate<br/>
 * 登録日（IS NOT NULL）
 */
public class FilterSkHubiDetailByTrkymdNotNull implements Predicate<HT_SkHubiDetail> {


    public FilterSkHubiDetailByTrkymdNotNull() {
        super();
    }

    @Override
    public boolean apply(HT_SkHubiDetail skHubiDetail) {
        if (skHubiDetail.getTrkymd() != null) {
            return true;
        }
        return false;
    }
}
