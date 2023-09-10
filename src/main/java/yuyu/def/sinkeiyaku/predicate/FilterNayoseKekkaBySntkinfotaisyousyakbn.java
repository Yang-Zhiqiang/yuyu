package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_NayoseKekka;

import com.google.common.base.Predicate;

/**
 * 名寄せ結果テーブル 用 Predicate<br/>
 * 選択情報対象者区分（一致）<br/>
 */
public class FilterNayoseKekkaBySntkinfotaisyousyakbn implements Predicate<HT_NayoseKekka> {

    public FilterNayoseKekkaBySntkinfotaisyousyakbn() {
        super();
    }

    @Override
    public boolean apply(HT_NayoseKekka pNayoseKekka) {
        if (C_SntkInfoTaisyousyaKbn.KEIYAKUSYA.eq(pNayoseKekka.getSntkinfotaisyousyakbn())) {
            return true;
        }
        return false;
    }

}
