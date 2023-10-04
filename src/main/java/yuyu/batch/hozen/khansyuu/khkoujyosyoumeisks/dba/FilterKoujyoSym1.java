package yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks.dba;

import yuyu.def.db.entity.IT_KoujyoSym;

import com.google.common.base.Predicate;

/**
 * 控除証明書テーブル用Predicateクラス１
 */
public class FilterKoujyoSym1 implements Predicate<IT_KoujyoSym> {

    String syoumeinnd;

    public FilterKoujyoSym1(String pSyoumeinnd) {
        super();
        syoumeinnd = pSyoumeinnd;
    }

    @Override
    public boolean apply(IT_KoujyoSym pKoujyoSym) {
        if (syoumeinnd.equals(pKoujyoSym.getNendo())) {
            return true;
        }
        return false;
    }
}
