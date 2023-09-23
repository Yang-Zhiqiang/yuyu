package yuyu.common.hozen.khcommon.dba4editkoujyonaiyoutbl;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;

import com.google.common.base.Predicate;

/**
 * 契約商品履歴テーブル用 Predicateクラス１<br/>
 * 有効消滅区分、主契約特約区分（一致）<br/>
 */
public class FilterKykSyouhnRireki1 implements Predicate<IT_KykSyouhnRireki>{

    C_YuukousyoumetuKbn  yuukousyoumetukbn;
    C_SyutkKbn syutkkbn;

    public FilterKykSyouhnRireki1(C_YuukousyoumetuKbn pYuukousyoumetukbn,C_SyutkKbn pSyutkkbn) {
        super();
        yuukousyoumetukbn = pYuukousyoumetukbn;
        syutkkbn = pSyutkkbn;

    }

    @Override
    public boolean apply(IT_KykSyouhnRireki kykSyouhnRireki) {
        if (yuukousyoumetukbn != null) {
            if (yuukousyoumetukbn.eq(kykSyouhnRireki.getYuukousyoumetukbn()) && syutkkbn.eq(kykSyouhnRireki.getSyutkkbn())) {
                return true;
            }
        }
        else {
            if (syutkkbn.eq(kykSyouhnRireki.getSyutkkbn())) {
                return true;
            }
        }
        return false;
    }
}
