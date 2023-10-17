package yuyu.app.hozen.khansyuu.khharaikatahenkou.dba;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_Kariukekin;

import com.google.common.base.Predicate;

/**
 * 仮受金テーブル用Predicateクラス１
 */
public class FilterKariukekin1 implements Predicate<IT_Kariukekin>{

    BizDate ryosyuymd;
    C_NyknaiyouKbn nyknaiyoukbn;
    C_Krkseisanzumiflg krkseisanzumiflg;

    public FilterKariukekin1(BizDate pRyosyuymd, C_NyknaiyouKbn pNyknaiyoukbn, C_Krkseisanzumiflg pKrkseisanzumiflg) {
        super();
        ryosyuymd = pRyosyuymd;
        nyknaiyoukbn = pNyknaiyoukbn;
        krkseisanzumiflg = pKrkseisanzumiflg;
    }

    @Override
    public boolean apply(IT_Kariukekin pKariukekin) {
        if (BizDateUtil.compareYmd(ryosyuymd, pKariukekin.getRyosyuymd()) == BizDateUtil.COMPARE_EQUAL &&
            nyknaiyoukbn.eq(pKariukekin.getNyknaiyoukbn()) &&
            !krkseisanzumiflg.eq(pKariukekin.getKrkseisanzumiflg())) {
            return true;
        }

        return false;
    }

}
