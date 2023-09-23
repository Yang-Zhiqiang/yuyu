package yuyu.common.hozen.ascommon.dba4keisanzennouseisangk2;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約保全 案内収納共通 契約商品テーブルエンティティ用Predicateクラス1
 */
public class FilterKykSyouhn implements Predicate<IT_KykSyouhn> {

    C_SyutkKbn syutkKbn;

    public FilterKykSyouhn(C_SyutkKbn pSyutkKbn) {
        super();
        syutkKbn = pSyutkKbn;
    }

    @Override
    public boolean apply(IT_KykSyouhn pKykSyouhn) {
        if (syutkKbn.eq(pKykSyouhn.getSyutkkbn())) {
            return true;
        }

        return false;
    }
}
