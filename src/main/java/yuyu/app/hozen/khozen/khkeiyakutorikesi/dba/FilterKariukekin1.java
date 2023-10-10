package yuyu.app.hozen.khozen.khkeiyakutorikesi.dba;

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.db.entity.IT_Kariukekin;

import com.google.common.base.Predicate;

/**
 * 仮受金テーブル用Predicateクラス１<br/>
 */
public class FilterKariukekin1 implements Predicate<IT_Kariukekin> {

    public FilterKariukekin1() {
        super();
    }

    @Override
    public boolean apply(IT_Kariukekin pKariukekin) {
        if (C_Krkseisanzumiflg.BLNK.eq(pKariukekin.getKrkseisanzumiflg())) {
            return true;
        }
        return false;
    }

}
