package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_NayoseKekka;

import com.google.common.base.Predicate;

/**
 * 名寄せ結果テーブル用 Predicate<br/>
 * 選択情報対象者区分（一致）
 * 枝番号（一致）
 */
public class FilterNayoseKekkaBySntkinfotaisyousyakbnEdano implements Predicate<HT_NayoseKekka> {

    Integer edano;
    C_SntkInfoTaisyousyaKbn sntkinfotaisyousyakbn;

    public FilterNayoseKekkaBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,Integer pEdano) {
        super();
        sntkinfotaisyousyakbn = pSntkinfotaisyousyakbn;
        edano = pEdano;
    }

    @Override
    public boolean apply(HT_NayoseKekka nayoseKekka) {
        if (sntkinfotaisyousyakbn.eq(nayoseKekka.getSntkinfotaisyousyakbn()) &&
                edano.equals(nayoseKekka.getEdano()) ) {
            return true;
        }
        return false;
    }
}
