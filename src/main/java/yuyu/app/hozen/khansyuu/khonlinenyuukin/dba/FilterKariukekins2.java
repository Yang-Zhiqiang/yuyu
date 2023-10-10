package yuyu.app.hozen.khansyuu.khonlinenyuukin.dba;

import yuyu.def.db.entity.IT_Kariukekin;

import com.google.common.base.Predicate;

/**
 * 仮受金テーブル用Predicateクラス２<br />
 * 仮受番号（一致）<br />
 */
public class FilterKariukekins2 implements Predicate<IT_Kariukekin> {
    Integer kariukeNo;

    public FilterKariukekins2(Integer pKariukeNo) {
        super();
        kariukeNo = pKariukeNo;
    }

    @Override
    public boolean apply(IT_Kariukekin pKariukekin) {
        if (kariukeNo.equals(pKariukekin.getKrkno())) {
            return true;
        }

        return false;
    }
}