package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 有効期間経過金額取得（決算）Beanです。<br />
 */
public class YuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBean implements Serializable {

    public YuukoukknKsansBySyoriYmdKnjyymdRstuukasyuBean(
        String pTrhkkgkSumType, BigDecimal pTrhkkgkSumValue, Long pNyksyoriymdCount) {

        trhkkgkSum = new BizCurrencySum(pTrhkkgkSumType, pTrhkkgkSumValue).toBizCurrency();
        nyksyoriymdCount = pNyksyoriymdCount;
    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency trhkkgkSum;

    @Getter @Setter
    private Long nyksyoriymdCount;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
