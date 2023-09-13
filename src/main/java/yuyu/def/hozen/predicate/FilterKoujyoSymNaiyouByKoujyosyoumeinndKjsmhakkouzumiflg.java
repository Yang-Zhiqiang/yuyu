package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;

import com.google.common.base.Predicate;

/**
 * 控除証明内容テーブル用 Predicate<br/>
 * 控除証明年度、控除証明書発行済フラグ（一致）<br/>
 */
public class FilterKoujyoSymNaiyouByKoujyosyoumeinndKjsmhakkouzumiflg implements Predicate<IT_KoujyoSymNaiyou> {

    String Koujyosyoumeinnd;
    C_Kjsmhakkouzumiflg Kjsmhakkouzumiflg;

    public FilterKoujyoSymNaiyouByKoujyosyoumeinndKjsmhakkouzumiflg(String pKoujyosyoumeinnd, C_Kjsmhakkouzumiflg pKjsmhakkouzumiflg) {
        super();
        Koujyosyoumeinnd = pKoujyosyoumeinnd;
        Kjsmhakkouzumiflg = pKjsmhakkouzumiflg;
    }

    @Override
    public boolean apply(IT_KoujyoSymNaiyou koujyoSymNaiyou) {

        if (Koujyosyoumeinnd.equals(koujyoSymNaiyou.getKoujyosyoumeinnd()) && Kjsmhakkouzumiflg.eq(koujyoSymNaiyou.getKjsmhakkouzumiflg())) {
            return true;
        }
        return false;
    }
}