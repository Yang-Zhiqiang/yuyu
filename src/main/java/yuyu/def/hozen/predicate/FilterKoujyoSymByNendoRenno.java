package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KoujyoSym;

import com.google.common.base.Predicate;

/**
 * 控除証明書テーブル用 Predicate<br/>
 * 年度、連番（一致）<br/>
 */
public class FilterKoujyoSymByNendoRenno implements Predicate<IT_KoujyoSym> {

    String nendo;
    Integer renno;

    public FilterKoujyoSymByNendoRenno(String pNendo,Integer pRenno) {
        super();
        nendo = pNendo;
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_KoujyoSym koujyoSym) {
        if (nendo.equals(koujyoSym.getNendo()) &&renno.equals(koujyoSym.getRenno())) {
            return true;
        }
        return false;
    }
}