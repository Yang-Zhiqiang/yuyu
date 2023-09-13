package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_SyouhnTokujou;

import com.google.common.base.Predicate;

/**
 * 商品特条テーブル用 Predicate<br/>
 * 主契約特約区分（一致）
 */
public class FilterSyouhnTokujouBySyutkkbn implements Predicate<IT_SyouhnTokujou>{

    C_SyutkKbn syutkKbn;

    public FilterSyouhnTokujouBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        super();
        syutkKbn = pSyutkkbn;
    }

    @Override
    public boolean apply(IT_SyouhnTokujou syouhnTokujou) {
        if(syutkKbn.eq(syouhnTokujou.getSyutkkbn())){
            return true;
        }
        return false;
    }

}