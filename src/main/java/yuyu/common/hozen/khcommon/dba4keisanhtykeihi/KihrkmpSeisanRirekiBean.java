package yuyu.common.hozen.khcommon.dba4keisanhtykeihi;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全共通 既払込Ｐ精算履歴Beanクラス
 */
public class KihrkmpSeisanRirekiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    BizCurrency hituyoukeihiitijisytktysgk;

    public KihrkmpSeisanRirekiBean(
        String pHituyoukeihiitijisytktysgkType,
        BigDecimal pHituyoukeihiitijisytktysgkValue) {

        hituyoukeihiitijisytktysgk = new BizCurrencySum(
            pHituyoukeihiitijisytktysgkType, pHituyoukeihiitijisytktysgkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
