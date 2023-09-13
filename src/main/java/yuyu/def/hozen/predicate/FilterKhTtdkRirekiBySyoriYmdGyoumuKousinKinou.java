package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhTtdkRireki;

import com.google.common.base.Predicate;

/**
 * 契約保全手続履歴テーブル用 Predicate<br/>
 * 処理年月日、業務用更新機能ＩＤ（一致）<br/>
 */
public class FilterKhTtdkRirekiBySyoriYmdGyoumuKousinKinou implements Predicate<IT_KhTtdkRireki> {

    BizDate syoriYmd;
    String  gyoumuKousinKinou;

    public FilterKhTtdkRirekiBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmd,String pGyoumuKousinKinou) {
        super();
        syoriYmd = pSyoriYmd;
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    @Override
    public boolean apply(IT_KhTtdkRireki khTtdkRireki) {
        if (syoriYmd.equals(khTtdkRireki.getSyoriYmd()) && gyoumuKousinKinou.equals(khTtdkRireki.getGyoumuKousinKinou())){
            return true;
        }
        return false;
    }
}