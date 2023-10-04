package yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks.dba;

import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;

import com.google.common.base.Predicate;

/**
 * 控除証明内容テーブル用Predicateクラス１
 */
public class FilterKoujyoSymNaiyou1 implements Predicate<IT_KoujyoSymNaiyou> {

    String koujyosyoumeinnd;

    public FilterKoujyoSymNaiyou1(String pKoujyosyoumeinnd) {
        super();
        koujyosyoumeinnd = pKoujyosyoumeinnd;
    }

    @Override
    public boolean apply(IT_KoujyoSymNaiyou pKoujyoSymNaiyou) {
        if (koujyosyoumeinnd.equals(pKoujyoSymNaiyou.getKoujyosyoumeinnd()) &&
            C_Kjsmhakkouzumiflg.BLNK.eq(pKoujyoSymNaiyou.getKjsmhakkouzumiflg()) &&
            !C_Delflag.SAKUJYO.eq(pKoujyoSymNaiyou.getSakujyoflg())) {
            return true;
        }
        return false;
    }
}
