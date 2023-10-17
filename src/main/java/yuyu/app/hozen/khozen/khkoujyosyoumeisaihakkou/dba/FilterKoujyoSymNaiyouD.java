package yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou.dba;

import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;

import com.google.common.base.Predicate;

/**
 * 控除証明内容Ｄテーブル用Predicateクラス
 */
public class FilterKoujyoSymNaiyouD implements Predicate<IT_KoujyoSymNaiyouD> {

    String koujyosyoumeinnd;

    public FilterKoujyoSymNaiyouD(String pKoujyosyoumeinnd) {
        super();
        koujyosyoumeinnd = pKoujyosyoumeinnd;
    }

    @Override
    public boolean apply(IT_KoujyoSymNaiyouD pKoujyoSymNaiyouD) {

        if (koujyosyoumeinnd.equals(pKoujyoSymNaiyouD.getKoujyosyoumeinnd())
            && C_Kjsmhakkouzumiflg.BLNK.eq(pKoujyoSymNaiyouD.getKjsmhakkouzumiflg())
            && !C_Delflag.SAKUJYO.eq(pKoujyoSymNaiyouD.getSakujyoflg())) {

            return true;
        }

        return false;
    }
}
