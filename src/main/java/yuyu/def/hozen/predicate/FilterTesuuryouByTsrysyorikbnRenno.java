package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_Tesuuryou;

import com.google.common.base.Predicate;

/**
 * 手数料情報テーブル用 Predicate<br/>
 * 手数料処理区分、連番（一致）<br/>
 */
public class FilterTesuuryouByTsrysyorikbnRenno implements Predicate<IT_Tesuuryou> {

    C_TsrysyoriKbn tsrysyorikbn;
    Integer renno;

    public FilterTesuuryouByTsrysyorikbnRenno(C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno) {
        super();
        tsrysyorikbn = pTsrysyorikbn;
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_Tesuuryou tesuuryou) {
        if (tsrysyorikbn.eq(tesuuryou.getTsrysyorikbn()) && renno == tesuuryou.getRenno()) {
            return true;
        }
        return false;
    }
}