package yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks.dba;

import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;

import com.google.common.base.Predicate;

/**
 * 控除証明内容Dテーブル用Predicateクラス１
 */
public class FilterKoujyoSymNaiyouD1 implements Predicate<IT_KoujyoSymNaiyouD> {

    String syoumeinnd;

    public FilterKoujyoSymNaiyouD1(String pSyoumeinnd) {
        super();
        syoumeinnd = pSyoumeinnd;
    }

    @Override
    public boolean apply(IT_KoujyoSymNaiyouD pKoujyoSymNaiyouD) {
        if (syoumeinnd.equals(pKoujyoSymNaiyouD.getKoujyosyoumeinnd()) &&
            C_Kjsmhakkouzumiflg.BLNK.eq(pKoujyoSymNaiyouD.getKjsmhakkouzumiflg()) &&
            !C_Delflag.SAKUJYO.eq(pKoujyoSymNaiyouD.getSakujyoflg())) {
            return true;
        }
        return false;
    }
}
