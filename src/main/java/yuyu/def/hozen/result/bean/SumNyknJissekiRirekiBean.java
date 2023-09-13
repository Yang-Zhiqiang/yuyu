package yuyu.def.hozen.result.bean;

import java.io.Serializable;
import java.util.Map;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 入金実績履歴合計Beanクラスです。<br />
 */
public class SumNyknJissekiRirekiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumHrkp;


    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumYenkansannyknkingk;


    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumRsgaku;


    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
