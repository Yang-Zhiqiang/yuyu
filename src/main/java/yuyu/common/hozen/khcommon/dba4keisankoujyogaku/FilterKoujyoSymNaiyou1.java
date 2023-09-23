package yuyu.common.hozen.khcommon.dba4keisankoujyogaku;

import yuyu.def.classification.C_Delflag;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;

import com.google.common.base.Predicate;

/**
 * 控除証明内容テーブル用 Predicateクラス１<br/>
 */
public class FilterKoujyoSymNaiyou1 implements Predicate<IT_KoujyoSymNaiyou> {

    String koujyosyoumeinnd;

    public FilterKoujyoSymNaiyou1(String pKoujyosyoumeinnd) {
        super();
        koujyosyoumeinnd = pKoujyosyoumeinnd;
    }

    @Override
    public boolean apply(IT_KoujyoSymNaiyou pKoujyoSymNaiyou) {
        if (koujyosyoumeinnd.equals(pKoujyoSymNaiyou.getKoujyosyoumeinnd())
            &&
            C_Delflag.BLNK.eq(pKoujyoSymNaiyou.getSakujyoflg())) {
            return true;
        }
        return false;
    }
}
