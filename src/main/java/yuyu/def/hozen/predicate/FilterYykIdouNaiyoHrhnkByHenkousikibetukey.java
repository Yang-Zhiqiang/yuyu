package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;

import com.google.common.base.Predicate;

/**
 * 予約異動受付内容（払方変更）テーブル用 Predicate<br/>
 * 変更識別キー（一致）<br/>
 */
public class FilterYykIdouNaiyoHrhnkByHenkousikibetukey implements Predicate<IT_YykIdouNaiyoHrhnk> {

    String henkousikibetukey;

    public FilterYykIdouNaiyoHrhnkByHenkousikibetukey(String pHenkousikibetukey) {
        super();
        henkousikibetukey = pHenkousikibetukey;
    }

    @Override
    public boolean apply(IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk) {
        if (henkousikibetukey.equals(yykIdouNaiyoHrhnk.getHenkousikibetukey())) {
            return true;
        }
        return false;
    }
}