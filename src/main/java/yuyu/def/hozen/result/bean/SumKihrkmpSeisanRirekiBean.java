
package yuyu.def.hozen.result.bean;

import java.io.Serializable;
import java.util.Map;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_MisyuumikeikaKbn;

/**
 * 既払込Ｐ精算履歴合計Beanクラスです。<br />
 */
public class SumKihrkmpSeisanRirekiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumSeisanpgoukei;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumYenkansansspgoukei;

    @Getter @Setter
    private C_MisyuumikeikaKbn misyuumikeikakbn;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumYenkansanhenkankin;

    @Getter @Setter
    private Map<CurrencyType, BizCurrency> sumYenkansantuityoukin;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
