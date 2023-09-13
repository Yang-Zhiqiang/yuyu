package yuyu.def.direct.predicate;

import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;

import com.google.common.base.Predicate;

/**
 * ＤＳ顧客契約テーブル用 Predicate<br/>
 * 証券番号（一致）<br/>
 */
public class FilterDsKokyakuKeiyakuBySyono implements Predicate<MT_DsKokyakuKeiyaku>  {
    String syono;

    public FilterDsKokyakuKeiyakuBySyono(String pSyono) {
        super();
        syono = pSyono;
    }

    @Override
    public boolean apply(MT_DsKokyakuKeiyaku pDsKokyakuKeiyaku) {
        if (syono.equals(pDsKokyakuKeiyaku.getSyono())) {
            return true;
        }
        return false;
    }
}
