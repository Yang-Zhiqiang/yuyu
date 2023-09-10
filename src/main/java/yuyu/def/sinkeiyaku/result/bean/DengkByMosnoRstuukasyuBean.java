package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 伝票金額Beanクラスです。<br />
 */
public class DengkByMosnoRstuukasyuBean implements Serializable {

    public DengkByMosnoRstuukasyuBean(
        String denyenkagkSumType, BigDecimal denyenkagkSumValue, String dengaikagkSumType, BigDecimal dengaikagkSumValue) {

        denyenkagk = new BizCurrencySum(denyenkagkSumType, denyenkagkSumValue).toBizCurrency();
        dengaikagk = new BizCurrencySum(dengaikagkSumType, dengaikagkSumValue).toBizCurrency();

    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency denyenkagk;

    @Getter @Setter
    private BizCurrency dengaikagk;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
