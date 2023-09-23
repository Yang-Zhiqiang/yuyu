package yuyu.common.hozen.khcommon.dba4commonnyuukin;

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.db.entity.IT_Kariukekin;

import com.google.common.base.Predicate;

/**
 * 仮受金テーブル用Predicateクラス１
 */
public class FilterKariukekin1 implements Predicate<IT_Kariukekin> {

    C_Krkseisanzumiflg krkseisanzumiFlg;

    public FilterKariukekin1(C_Krkseisanzumiflg pkrkseisanzumiFlg) {
        super();
        krkseisanzumiFlg = pkrkseisanzumiFlg;
    }

    @Override
    public boolean apply(IT_Kariukekin pKariukekin) {
        if (krkseisanzumiFlg.eq(pKariukekin.getKrkseisanzumiflg())) {
            return true;
        }
        return false;
    }
}
