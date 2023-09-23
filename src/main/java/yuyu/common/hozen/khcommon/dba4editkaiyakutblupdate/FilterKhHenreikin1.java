package yuyu.common.hozen.khcommon.dba4editkaiyakutblupdate;

import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.db.entity.IT_KhHenreikin;

import com.google.common.base.Predicate;

/**
 * 契約保全 契約保全共通 契約保全返戻金テーブル用Predicateクラス１
 */
public class FilterKhHenreikin1 implements Predicate<IT_KhHenreikin> {

    C_HrsyuruiKbn hrsyuruiKbn;

    C_Siharaijyoutaikbn siharaijyoutaikbn;

    public FilterKhHenreikin1(C_HrsyuruiKbn pHrsyuruiKbn, C_Siharaijyoutaikbn pSiharaijyoutaikbn) {
        super();
        hrsyuruiKbn = pHrsyuruiKbn;
        siharaijyoutaikbn = pSiharaijyoutaikbn;
    }

    @Override
    public boolean apply(IT_KhHenreikin pKhHenreikin) {
        if (hrsyuruiKbn.eq(pKhHenreikin.getHrsyuruikbn()) &&
            siharaijyoutaikbn.eq(pKhHenreikin.getHrsiharaijyoutaikbn())) {
            return true;
        }

        return false;
    }

}
