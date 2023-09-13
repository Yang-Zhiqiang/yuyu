package yuyu.def.hozen.result.bean;

import java.io.Serializable;
import java.util.Map;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全支払履歴明細合計金額情報Beanクラスです。<br />
 */
public class KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> syushrgk;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> shrtstmttkin;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> shrtstmttkinhngkbbn;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sjkkktyouseigk;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> kaiyakukjgk;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
