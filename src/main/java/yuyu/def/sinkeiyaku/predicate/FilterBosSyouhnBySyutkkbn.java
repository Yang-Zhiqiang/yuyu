package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_BosSyouhn;

import com.google.common.base.Predicate;

/**
 * 募集商品テーブル用 Predicate<br/>
 * 主契約特約区分（一致）<br />
 */
public class FilterBosSyouhnBySyutkkbn implements Predicate<HT_BosSyouhn>{

    C_SyutkKbn syutkkbn;

    public FilterBosSyouhnBySyutkkbn(C_SyutkKbn pSyutkKbn){

        super();

        syutkkbn = pSyutkKbn;
    }

    @Override
    public boolean apply(HT_BosSyouhn pHT_BosSyouhn) {

        if(syutkkbn.eq(pHT_BosSyouhn.getSyutkkbn())){

            return true;
        }

        return false;
    }
}
