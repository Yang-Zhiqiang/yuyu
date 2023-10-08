package yuyu.app.hozen.khozen.khgengaku.dba;

import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;

import com.google.common.base.Predicate;

/**
 * 契約保全 契約保全 契約保全手続履歴テーブル用Predicateクラス１
 */
public class FilterKhTtdkRireki1 implements Predicate<IT_KhTtdkRireki>{


    C_SyoriKbn syorikbn;

    public FilterKhTtdkRireki1(C_SyoriKbn pSyorikbn) {
        super();
        syorikbn = pSyorikbn;
    }

    @Override
    public boolean apply(IT_KhTtdkRireki pKhTtdkRireki) {
        if (syorikbn.eq(pKhTtdkRireki.getSyorikbn())) {
            return true;
        }

        return false;
    }

}
