package yuyu.def.direct.predicate;

import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;

import com.google.common.base.Predicate;
/**
 * ＤＳ顧客契約テーブル用 Predicate<br/>
 * 証券番号<br/>
 */
public class FilterDsKokyakuKeiyakuBySyonoDskykmukouhyj implements Predicate<MT_DsKokyakuKeiyaku> {
    String syono;

    public FilterDsKokyakuKeiyakuBySyonoDskykmukouhyj(String pSyono) {

        super();

        syono = pSyono;
    }

    @Override
    public boolean apply(MT_DsKokyakuKeiyaku pMT_DsKokyakuKeiyaku) {

        if (syono.equals(pMT_DsKokyakuKeiyaku.getSyono()) &&
                C_MukouHyj.BLANK.eq(pMT_DsKokyakuKeiyaku.getDskykmukouhyj())) {

            return true;
        }

        return false;
    }
}
