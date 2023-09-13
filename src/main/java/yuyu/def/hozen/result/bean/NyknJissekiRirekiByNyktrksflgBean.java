package yuyu.def.hozen.result.bean;

import java.io.Serializable;
import java.util.Map;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 入金実績履歴Beanクラスです。<br />
 */
public class NyknJissekiRirekiByNyktrksflgBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumRsgaku;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumYenkansannyknkingk;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
