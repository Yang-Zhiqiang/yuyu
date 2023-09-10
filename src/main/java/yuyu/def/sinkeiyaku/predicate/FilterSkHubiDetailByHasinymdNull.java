package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_SkHubiDetail;

import com.google.common.base.Predicate;

/**
 * 新契約不備詳細テーブル用 Predicate<br/>
 * 発信日（null）
 */
public class FilterSkHubiDetailByHasinymdNull implements Predicate<HT_SkHubiDetail> {


    public FilterSkHubiDetailByHasinymdNull() {
        super();
    }

    @Override
    public boolean apply(HT_SkHubiDetail skHubiDetail) {
        if (skHubiDetail.getHasinymd() == null) {
            return true;
        }
        return false;
    }
}
