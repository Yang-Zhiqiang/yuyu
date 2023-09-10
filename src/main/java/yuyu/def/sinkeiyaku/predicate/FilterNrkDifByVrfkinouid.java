package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_NrkDif;

import com.google.common.base.Predicate;

/**
 * 入力差異テーブル用 Predicate<br/>
 * ベリファイ機能ID（一致）
 */
public class FilterNrkDifByVrfkinouid implements Predicate<HT_NrkDif> {

    String vrfkinouid;

    public FilterNrkDifByVrfkinouid(String pVrfkinouid) {
        super();
        vrfkinouid = pVrfkinouid;
    }

    @Override
    public boolean apply(HT_NrkDif nrkDif) {
        if (vrfkinouid.equals(nrkDif.getVrfkinouid())) {
            return true;
        }
        return false;
    }
}
