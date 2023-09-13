package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_YykIdouUktk;

import com.google.common.base.Predicate;
/**
 * 予約異動受付テーブル用 Predicate<br/>
 * 予約異動処理区分（一致）
 */
public class FilterYykIdouUktkByYykidousyorikbn implements Predicate<IT_YykIdouUktk> {

    C_YykidousyoriKbn yykidousyoriKbn;

    public FilterYykIdouUktkByYykidousyorikbn(C_YykidousyoriKbn pYykidousyorikbn) {
        super();
        yykidousyoriKbn = pYykidousyorikbn;
    }

    @Override
    public boolean apply(IT_YykIdouUktk yykIdouUktk) {
        if(yykidousyoriKbn.eq(yykIdouUktk.getYykidousyorikbn())){
            return true;
        }
        return false;
    }
}
