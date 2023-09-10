package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_SkHubi;

import com.google.common.base.Predicate;

/**
 * 新契約不備テーブル用 Predicate<br/>
 * 不備識別キー（一致）
 */
public class FilterSkHubiByHubisikibetukey implements Predicate<HT_SkHubi> {

    String hubisikibetukey;

    public FilterSkHubiByHubisikibetukey(String pHubisikibetukey) {
        super();
        hubisikibetukey = pHubisikibetukey;
    }

    @Override
    public boolean apply(HT_SkHubi pHT_SkHubi) {

        if (hubisikibetukey.equals(pHT_SkHubi.getHubisikibetukey())) {
            return true;
        }

        return false;
    }
}
