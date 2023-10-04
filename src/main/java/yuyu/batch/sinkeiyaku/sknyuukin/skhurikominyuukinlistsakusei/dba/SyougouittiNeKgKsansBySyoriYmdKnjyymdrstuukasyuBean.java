package yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 照合不一致金額取得（決算）Beanクラス<br />
 */
public class SyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency trhkkgkSum;

    @Getter @Setter
    private Long nyksyoriymdCount;

    public SyougouittiNeKgKsansBySyoriYmdKnjyymdrstuukasyuBean(
        String pTrhkkgkSumType,
        BigDecimal pTrhkkgkSumValue,
        Long pNyksyoriymdCount) {

        trhkkgkSum = new BizCurrencySum(pTrhkkgkSumType, pTrhkkgkSumValue).toBizCurrency();
        nyksyoriymdCount = pNyksyoriymdCount;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
