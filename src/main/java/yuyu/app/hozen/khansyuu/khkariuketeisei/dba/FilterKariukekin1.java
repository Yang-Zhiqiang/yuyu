package yuyu.app.hozen.khansyuu.khkariuketeisei.dba;

import yuyu.def.db.entity.IT_Kariukekin;

import com.google.common.base.Predicate;

/**
 * 仮受金テーブル用 Predicate<br/>
 * 仮受番号（一致）<br/>
 */
public class FilterKariukekin1 implements Predicate<IT_Kariukekin> {

    Integer krkno;

    public FilterKariukekin1 (Integer pKrkno) {
        super();
        krkno = pKrkno;
    }

    @Override
    public boolean apply (IT_Kariukekin kykSyouhn) {
        if (krkno.compareTo(kykSyouhn.getKrkno()) == 0) {
            return true;
        }
        return false;
    }
}