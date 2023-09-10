package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.db.entity.HT_NayoseKekka;

import com.google.common.base.Predicate;

/**
 * 名寄せ結果テーブル用 Predicate<br />
 * シグナル設定有無区分固定値（<ブランク付有無区分>あり）<br />
 */
public class FilterNayoseKekkaBySignalsetteiumukbn implements Predicate<HT_NayoseKekka> {

    public FilterNayoseKekkaBySignalsetteiumukbn() {

        super();
    }

    @Override
    public boolean apply(HT_NayoseKekka pNayoseKekka) {

        if (pNayoseKekka.getSignalsetteiumukbn().eq(C_BlnktkumuKbn.ARI)) {

            return true;
        }

        return false;
    }
}
