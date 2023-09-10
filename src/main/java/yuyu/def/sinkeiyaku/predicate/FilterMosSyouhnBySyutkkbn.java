package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_MosSyouhn;

import com.google.common.base.Predicate;

/**
 * 申込商品テーブル用 Predicate<br/>
 * 主契約特約区分（一致）
 */
public class FilterMosSyouhnBySyutkkbn implements Predicate<HT_MosSyouhn>{

    C_SyutkKbn syutkKbn;

    public FilterMosSyouhnBySyutkkbn(C_SyutkKbn pSyutkkbn){
        super();
        syutkKbn = pSyutkkbn;
    }

    @Override
    public boolean apply(HT_MosSyouhn pMosSyouhn) {
        if(syutkKbn.eq(pMosSyouhn.getSyutkkbn())){
            return true;
        }
        return false;
    }

}
