package yuyu.batch.hozen.khinterf.khsiharaikekkatorikomi.dba;

import yuyu.def.db.entity.IT_Azukarikin;

import com.google.common.base.Predicate;

/**
 * 預り金テーブル用Predicateクラス
 *
 */
public class FilterAzukarikin1 implements Predicate<IT_Azukarikin> {

    public FilterAzukarikin1() {
        super();
    }

    @Override
    public boolean apply(IT_Azukarikin pAzukarikin) {
        if (pAzukarikin.getShrymd() == null) {
            return true;
        }
        return false;
    }
}
