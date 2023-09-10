package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 申込取消金額取得（決算）Beanです。<br />
 */
public class MosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBean implements Serializable {

    public MosTorikesiKgKsansBySyoriYmdKnjyymdRstuukasyuBean(
        String pTrhkkgkSumType, BigDecimal pTrhkkgkSumValue, Long pHrkmdeldataskbtkeyCount) {

        trhkkgkSum = new BizCurrencySum(pTrhkkgkSumType, pTrhkkgkSumValue).toBizCurrency();
        hrkmdeldataskbtkeyCount = pHrkmdeldataskbtkeyCount;
    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency trhkkgkSum;

    @Getter @Setter
    private Long hrkmdeldataskbtkeyCount;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
