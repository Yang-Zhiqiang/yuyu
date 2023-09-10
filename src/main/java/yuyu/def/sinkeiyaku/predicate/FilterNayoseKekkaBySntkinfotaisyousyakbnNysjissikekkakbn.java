package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_NayoseKekka;

import com.google.common.base.Predicate;

/**
 * 名寄せ結果テーブル用 Predicate<br />
 * 選択情報対象者区分固定値（<選択情報対象者区分>契約者）名寄せ実施結果区分固定値（<名寄せ実施結果区分>同一人あり）<br />
 */
public class FilterNayoseKekkaBySntkinfotaisyousyakbnNysjissikekkakbn implements Predicate<HT_NayoseKekka> {

    public FilterNayoseKekkaBySntkinfotaisyousyakbnNysjissikekkakbn() {

        super();
    }

    @Override
    public boolean apply(HT_NayoseKekka pNayoseKekka) {

        if (C_SntkInfoTaisyousyaKbn.KEIYAKUSYA.eq(pNayoseKekka.getSntkinfotaisyousyakbn()) &&
            C_NayoseJissiKekkaKbn.DOUITUARI.eq(pNayoseKekka.getNysjissikekkakbn())) {

            return true;
        }

        return false;
    }
}
