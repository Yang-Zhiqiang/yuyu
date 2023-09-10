package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_MosSyouhnVrf;

import com.google.common.base.Predicate;

/**
 * 申込商品ベリファイテーブル用 Predicate<br/>
 * 主契約特約区分（一致）
 */
public class FilterMosSyouhnVrfBySyutkkbn implements Predicate<HT_MosSyouhnVrf>{

    C_SyutkKbn syutkkbn;

    public FilterMosSyouhnVrfBySyutkkbn(C_SyutkKbn pSyutkkbn){

        super();

        syutkkbn = pSyutkkbn;
    }

    @Override
    public boolean apply(HT_MosSyouhnVrf pMosSyouhnVrf) {

        if(syutkkbn.eq(pMosSyouhnVrf.getSyutkkbn())){

            return true;
        }

        return false;
    }
}