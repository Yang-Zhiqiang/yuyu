package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約商品テーブル用 Predicate<br/>
 * 主契約特約区分（一致）<br/>
 */
public class FilterKykSyouhnBySyutkkbn implements Predicate<IT_KykSyouhn> {

    C_SyutkKbn syutkkbn;

    public FilterKykSyouhnBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        super();
        syutkkbn = pSyutkkbn;
    }

    @Override
    public boolean apply(IT_KykSyouhn kykSyouhn) {
        if (syutkkbn.eq(kykSyouhn.getSyutkkbn())) {
            return true;
        }
        return false;
    }
}