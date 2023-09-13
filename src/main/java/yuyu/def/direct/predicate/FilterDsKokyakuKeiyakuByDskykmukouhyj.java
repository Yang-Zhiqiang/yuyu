package yuyu.def.direct.predicate;

import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;

import com.google.common.base.Predicate;

/**
 * ＤＳ顧客契約テーブル用 Predicate<br/>
 * ＤＳ契約無効表示（一致）<br/>
 */
public class FilterDsKokyakuKeiyakuByDskykmukouhyj implements Predicate<MT_DsKokyakuKeiyaku>  {

    C_MukouHyj dskykMukouHyj;

    public FilterDsKokyakuKeiyakuByDskykmukouhyj(C_MukouHyj pDskykmukouhyj) {

        super();

        dskykMukouHyj = pDskykmukouhyj;
    }

    @Override
    public boolean apply(MT_DsKokyakuKeiyaku pDsKokyakuKeiyaku) {

        if (dskykMukouHyj.eq(pDsKokyakuKeiyaku.getDskykmukouhyj())) {

            return true;
        }

        return false;
    }
}
