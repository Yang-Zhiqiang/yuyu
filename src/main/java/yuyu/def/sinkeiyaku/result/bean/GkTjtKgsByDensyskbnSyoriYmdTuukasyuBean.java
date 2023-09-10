package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 外貨当日金額取得Beanです。<br />
 */
public class GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean implements Serializable {

    public GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean(
        String pTrhkkgkSumType, BigDecimal pTrhkkgkSumValue, String pDengkSumType, BigDecimal pDengkSumValue, Long pSyoriYmdCount) {

        trhkkgkSum = new BizCurrencySum(pTrhkkgkSumType, pTrhkkgkSumValue).toBizCurrency();
        dengkSum = new BizCurrencySum(pDengkSumType, pDengkSumValue).toBizCurrency();
        syoriYmdCount = pSyoriYmdCount;

    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency trhkkgkSum;

    @Getter @Setter
    private BizCurrency dengkSum;

    @Getter @Setter
    private Long syoriYmdCount;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
