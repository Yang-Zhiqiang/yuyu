package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.db.entity.IT_Kariukekin;

import com.google.common.base.Predicate;
/**
 * 仮受金テーブル用 Predicate<br/>
 * 仮受精算済フラグ（不一致）
 */
public class FilterKariukekinByKrkseisanzumiflg implements Predicate<IT_Kariukekin> {

    C_Krkseisanzumiflg krkseisanzumiflg;

    public FilterKariukekinByKrkseisanzumiflg(C_Krkseisanzumiflg pKrkseisanzumiflg) {
        super();
        krkseisanzumiflg = pKrkseisanzumiflg;
    }

    @Override
    public boolean apply(IT_Kariukekin kariukekin) {
        if(kariukekin.getKrkseisanzumiflg() != null && !krkseisanzumiflg.eq(kariukekin.getKrkseisanzumiflg())){
            return true;
        }
        return false;
    }
}
