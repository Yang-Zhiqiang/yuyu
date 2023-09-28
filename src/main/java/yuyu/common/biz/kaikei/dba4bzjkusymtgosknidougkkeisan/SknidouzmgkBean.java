package yuyu.common.biz.kaikei.dba4bzjkusymtgosknidougkkeisan;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 経理・会計 資金移動済金額Beanクラス
 */
@AllArgsConstructor
public class SknidouzmgkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private BizCurrency siteituukagk;

    public SknidouzmgkBean(
        String pSiteituukagkType,
        BigDecimal pSiteituukagkValue) {

        siteituukagk = new BizCurrencySum(pSiteituukagkType, pSiteituukagkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
