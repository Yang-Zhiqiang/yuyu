package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_Kariukekin;

import com.google.common.base.Predicate;
/**
 * 仮受金テーブル用 Predicate<br/>
 * 仮受精算済フラグ（不一致）、入金内容区分（一致）
 */
public class FilterKariukekinByKrkseisanzumiflgNyknaiyoukbn implements Predicate<IT_Kariukekin> {

    C_Krkseisanzumiflg krkseisanzumiflg;
    C_NyknaiyouKbn nyknaiyouKbn;

    public FilterKariukekinByKrkseisanzumiflgNyknaiyoukbn(C_Krkseisanzumiflg pKrkseisanzumiflg,
        C_NyknaiyouKbn pNyknaiyoukbn) {
        super();
        krkseisanzumiflg = pKrkseisanzumiflg;
        nyknaiyouKbn = pNyknaiyoukbn;
    }

    @Override
    public boolean apply(IT_Kariukekin ｋariukekin) {
        if(ｋariukekin.getKrkseisanzumiflg() != null
            && !krkseisanzumiflg.eq(ｋariukekin.getKrkseisanzumiflg()) && nyknaiyouKbn.eq(ｋariukekin.getNyknaiyoukbn())){
            return true;
        }
        return false;
    }
}
