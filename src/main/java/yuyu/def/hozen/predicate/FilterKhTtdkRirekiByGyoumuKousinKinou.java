package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KhTtdkRireki;

import com.google.common.base.Predicate;

/**
 * 契約保全手続履歴テーブル用 Predicate<br/>
 * 業務用更新機能ＩＤ（一致）<br/>
 */
public class FilterKhTtdkRirekiByGyoumuKousinKinou implements Predicate<IT_KhTtdkRireki> {

    String gyoumuKousinKinou;

    public FilterKhTtdkRirekiByGyoumuKousinKinou(String pGyoumuKousinKinou) {
        super();
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    @Override
    public boolean apply(IT_KhTtdkRireki khTtdkRireki) {

        if (gyoumuKousinKinou.equals(khTtdkRireki.getGyoumuKousinKinou())) {
            return true;
        }
        return false;
    }
}
