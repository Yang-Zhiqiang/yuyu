package yuyu.batch.hozen.khinterf.khkzkpyokujyuutouyoteicsvsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 インターフェイス 継続Ｐ翌月充当予定Beanクラス
 */
@AllArgsConstructor
public class KhKzkPYokuJyuutouYoteiWkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizDateYM kykym;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private Integer hknkkn;

    @Getter @Setter
    private BizCurrency hokenryou;

    public KhKzkPYokuJyuutouYoteiWkBean(C_Tuukasyu pKyktuukasyu,
        BizDateYM pKykym,
        BizDateYM pJyuutouym,
        Integer pHknkkn,
        String pHokenryouType,
        BigDecimal pHokenryouValue) {

        kyktuukasyu = pKyktuukasyu;
        kykym = pKykym;
        jyuutouym = pJyuutouym;
        hknkkn = pHknkkn;
        hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
