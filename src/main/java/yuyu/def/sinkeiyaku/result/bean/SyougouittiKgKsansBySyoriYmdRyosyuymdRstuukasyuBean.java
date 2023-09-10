package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;


/**
 * 照合一致金額取得（決算）Beanです。<br />
 */
public class SyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBean implements Serializable {

    public SyougouittiKgKsansBySyoriYmdRyosyuymdRstuukasyuBean(String pRsgakuSumType, BigDecimal pRsgakuSumValue,
        String pRsgakuenSumType, BigDecimal pRsgakuenSumValue,
        String pHrkmtsrySumType, BigDecimal pHrkmtsrySumValue, Long psyoriYmdCount) {

        rsgakuSum = new BizCurrencySum(pRsgakuSumType, pRsgakuSumValue).toBizCurrency();
        rsgakuenSum = new BizCurrencySum(pRsgakuenSumType, pRsgakuenSumValue).toBizCurrency();
        hrkmtsrySum = new BizCurrencySum(pHrkmtsrySumType, pHrkmtsrySumValue).toBizCurrency();
        syoriYmdCount = psyoriYmdCount;

    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency rsgakuSum;

    @Getter @Setter
    private BizCurrency rsgakuenSum;

    @Getter @Setter
    private BizCurrency hrkmtsrySum;

    @Getter @Setter
    private Long syoriYmdCount;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
