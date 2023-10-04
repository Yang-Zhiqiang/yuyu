package yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 申込取消金額取得Beanクラス<br />
 */
public class MosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency trhkkgkSum;

    @Getter @Setter
    private Long hrkmdeldataskbtkeyCount;

    public MosTorikesiKgsBySyoriYmdKnjyymdRstuukasyuBean(
        String pTrhkkgkSumType,
        BigDecimal pTrhkkgkSumValue,
        Long pHrkmdeldataskbtkeyCount) {

        trhkkgkSum = new BizCurrencySum(pTrhkkgkSumType, pTrhkkgkSumValue).toBizCurrency();
        hrkmdeldataskbtkeyCount = pHrkmdeldataskbtkeyCount;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
