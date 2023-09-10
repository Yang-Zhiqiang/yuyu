package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_MosDairitenVrf;

import com.google.common.base.Predicate;

/**
 * 申込代理店ベリファイテーブル用 Predicate<br/>
 * 連番（一致）<br />
 */
public class FilterMosDairitenVrfByRenno implements Predicate<HT_MosDairitenVrf>{

    Integer renno ;

    public FilterMosDairitenVrfByRenno(Integer pRenno) {

        super();

        renno = pRenno;
    }

    @Override
    public boolean apply(HT_MosDairitenVrf pHT_MosDairitenVrf) {

        if (renno.equals(pHT_MosDairitenVrf.getRenno())) {

            return true;
        }

        return false;
    }
}