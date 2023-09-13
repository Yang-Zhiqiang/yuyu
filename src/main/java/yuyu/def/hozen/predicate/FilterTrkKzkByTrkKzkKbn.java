package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.db.entity.IT_TrkKzk;

import com.google.common.base.Predicate;

/**
 * 登録家族テーブル用 Predicate<br/>
 * 登録家族区分（一致）
 */
public class FilterTrkKzkByTrkKzkKbn implements Predicate<IT_TrkKzk> {

    C_TrkKzkKbn trkKzkKbn;

    public FilterTrkKzkByTrkKzkKbn(C_TrkKzkKbn pTrkkzkkbn) {
        super();
        trkKzkKbn = pTrkkzkkbn;
    }

    @Override
    public boolean apply(IT_TrkKzk pTrkKzk) {

        if(trkKzkKbn.eq(pTrkKzk.getTrkkzkkbn())){

            return true;
        }
        return false;
    }
}