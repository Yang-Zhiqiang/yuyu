package yuyu.common.hozen.khcommon.dba4keisanzennouseisangk;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約保全 契約保全共通 契約商品テーブルエンティティ用Predicateクラス1
 */
public class FilterKykSyouhn1 implements Predicate<IT_KykSyouhn> {

    C_SyutkKbn syutkKbn;

    public FilterKykSyouhn1(C_SyutkKbn pSyutkKbn) {
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
