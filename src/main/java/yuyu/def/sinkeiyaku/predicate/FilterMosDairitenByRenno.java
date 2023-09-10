package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_MosDairiten;

import com.google.common.base.Predicate;

/**
 * 申込代理店テーブル用 Predicate<br/>
 * 連番（一致）
 */
public class FilterMosDairitenByRenno implements Predicate<HT_MosDairiten> {

    Integer renno;

    public FilterMosDairitenByRenno(Integer pRenno){
        super();
        renno = pRenno;
    }

    @Override
    public boolean apply(HT_MosDairiten pHT_MosDairiten) {
        if (renno.equals(pHT_MosDairiten.getRenno())) {
            return true;
        }
        return false;
    }

}
