package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_SentakuJyouhou;

import com.google.common.base.Predicate;

/**
 * 選択情報テーブル用 Predicate<br/>
 * 選択情報対象者区分（一致）<br />
 * 枝番号（一致）<br />
 */
public class FilterSentakuJyouhouBySntkinfotaisyousyakbnEdano implements Predicate<HT_SentakuJyouhou> {

    C_SntkInfoTaisyousyaKbn sntkinfotaisyousyakbn;
    Integer edano;

    public FilterSentakuJyouhouBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn, Integer pEdano) {

        super();

        sntkinfotaisyousyakbn = pSntkinfotaisyousyakbn;
        edano = pEdano;
    }

    @Override
    public boolean apply(HT_SentakuJyouhou pSentakuJyouhou) {

        if (sntkinfotaisyousyakbn.eq(pSentakuJyouhou.getSntkinfotaisyousyakbn()) &&
                edano.equals(pSentakuJyouhou.getEdano())) {

            return true;
        }

        return false;
    }
}
