package yuyu.def.siharai.predicate;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.db.entity.JT_SiDetail;

import com.google.common.base.Predicate;

/**
 * 支払明細テーブル用 Predicate<br/>
 * 給付金額 (0以外)<br/>
 */
public class FilterSiDetailByKyhkg implements Predicate<JT_SiDetail>{

    public FilterSiDetailByKyhkg(){

        super();
    }

    @Override
    public boolean apply(JT_SiDetail pSiDetail){

        BizCurrency kyhkg = pSiDetail.getKyhkg();
        if (kyhkg == null) {

            return false;
        }

        BizCurrency tempKyhkgZero = BizCurrency.valueOf(0, kyhkg.getType());
        if (!tempKyhkgZero.equalsValue(kyhkg)) {

            return true;
        }

        return false;
    }
}
