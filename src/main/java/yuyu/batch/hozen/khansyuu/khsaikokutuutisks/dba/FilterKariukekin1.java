package yuyu.batch.hozen.khansyuu.khsaikokutuutisks.dba;

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_Kariukekin;
import com.google.common.base.Predicate;

/**
 * 仮受金テーブル用Predicateクラス
 */
public class FilterKariukekin1 implements Predicate<IT_Kariukekin> {

    public FilterKariukekin1() {
        super();
    }


    @Override
    public boolean apply(IT_Kariukekin pKariukekin) {
        if (C_Krkseisanzumiflg.BLNK.eq(pKariukekin.getKrkseisanzumiflg()) &&
            (C_NyknaiyouKbn.KEIZOKUP.eq(pKariukekin.getNyknaiyoukbn()) ||
                C_NyknaiyouKbn.HARAIHENYOUP.eq(pKariukekin.getNyknaiyoukbn()) ||
                C_NyknaiyouKbn.OTHER.eq(pKariukekin.getNyknaiyoukbn()) ||
                C_NyknaiyouKbn.HOZENHENKOUYOUP.eq(pKariukekin.getNyknaiyoukbn()))) {
            return true;
        }
        return false;
    }
}