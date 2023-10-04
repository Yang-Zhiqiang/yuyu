package yuyu.batch.hozen.khinterf.khdairitengetujikykinfofsks.dba;

import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;

import com.google.common.base.Predicate;

/**
 * 契約保全手続履歴テーブル用Predicateクラス１
 */
public class FilterKhTtdkRireki1 implements Predicate<IT_KhTtdkRireki> {

    String gyoumuKousinKinou;

    public FilterKhTtdkRireki1(String pGyoumuKousinKinou) {
        super();
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    @Override
    public boolean apply(IT_KhTtdkRireki pKhTtdkRireki) {
        if (gyoumuKousinKinou.equals(pKhTtdkRireki.getGyoumuKousinKinou()) &&
            (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(pKhTtdkRireki.getSyorikbn()) ||
                C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(pKhTtdkRireki.getSyorikbn()))) {
            return true;
        }
        return false;
    }
}
