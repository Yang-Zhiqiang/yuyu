package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KykDairiten;

import com.google.common.base.Predicate;

/**
 * 契約代理店テーブル用 Predicate<br/>
 * 連番（一致）<br/>
 */
public class FilterKykDairitenByDrtenrenno implements Predicate<IT_KykDairiten> {

    Integer drtenrenno;

    public FilterKykDairitenByDrtenrenno(Integer pDrtenrenno) {
        super();
        drtenrenno = pDrtenrenno;
    }

    @Override
    public boolean apply(IT_KykDairiten kykDairiten) {
        if (kykDairiten.getDrtenrenno().equals(drtenrenno)) {
            return true;
        }
        return false;
    }
}