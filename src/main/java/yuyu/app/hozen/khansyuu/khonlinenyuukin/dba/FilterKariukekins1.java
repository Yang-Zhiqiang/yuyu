package yuyu.app.hozen.khansyuu.khonlinenyuukin.dba;

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.db.entity.IT_Kariukekin;

import com.google.common.base.Predicate;

/**
 * 仮受金テーブル用Predicateクラス１<br />
 * 仮受番号と仮受精算済フラグ（一致）<br />
 */
public class FilterKariukekins1 implements Predicate<IT_Kariukekin> {
    Integer kariukeNo;

    C_Krkseisanzumiflg krkseisanzumiflg;

    public FilterKariukekins1(Integer pKariukeNo, C_Krkseisanzumiflg pKrkseisanzumiflg) {
        super();
        kariukeNo = pKariukeNo;
        krkseisanzumiflg = pKrkseisanzumiflg;
    }

    @Override
    public boolean apply(IT_Kariukekin pKariukekin) {
        if (kariukeNo.equals(pKariukekin.getKrkno()) && krkseisanzumiflg.eq(pKariukekin.getKrkseisanzumiflg())) {
            return true;
        }

        return false;
    }
}