package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.IT_Zennou;

import com.google.common.base.Predicate;

/**
 * 前納テーブル用 Predicate<br/>
 * 前納精算区分 ＝ <前納精算区分>未精算
 */
public class FilterZennouMsisnBySyono implements Predicate<IT_Zennou>{

    public FilterZennouMsisnBySyono(){
        super();
    }

    @Override
    public boolean apply(IT_Zennou pZennou) {

        if (C_ZennouSeisanKbn.MISEISAN.eq(pZennou.getZennouseisankbn())) {

            return true;
        }

        return false;
    }
}
