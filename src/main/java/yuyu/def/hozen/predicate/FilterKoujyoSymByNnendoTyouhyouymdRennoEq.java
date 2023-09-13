package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KoujyoSym;

import com.google.common.base.Predicate;

/**
 * 控除証明書テーブル用 Predicate<br/>
 * 年度、帳票作成日（一致）<br/>
 */
public class FilterKoujyoSymByNnendoTyouhyouymdRennoEq implements Predicate<IT_KoujyoSym> {

    String nendo;
    BizDate tyouhyouymd;

    public FilterKoujyoSymByNnendoTyouhyouymdRennoEq(String pNendo, BizDate pTyouhyouymd) {

        super();

        nendo = pNendo;
        tyouhyouymd = pTyouhyouymd;
    }

    @Override
    public boolean apply(IT_KoujyoSym pKoujyoSym) {

        if (nendo.equals(pKoujyoSym.getNendo()) && tyouhyouymd.equals(pKoujyoSym.getTyouhyouymd()) && Integer.valueOf(1).equals(pKoujyoSym.getRenno()) ) {

            return true;
        }
        return false;
    }
}
