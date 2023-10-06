package yuyu.batch.biz.bzkaikei.bzkariukemeisailistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 経理・会計 平準払資金移動金額データBEANクラス
 */
public class HijynbrsikinidougkDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String denrenno;

    @Getter
    @Setter
    private BizCurrency hijynbrsikinidougk;

    public HijynbrsikinidougkDataBean(String pDenrenno,
        String pHijynbrsikinidougkType,
        BigDecimal pHijynbrsikinidougkValue) {
        denrenno = pDenrenno;
        hijynbrsikinidougk = new BizCurrencySum(pHijynbrsikinidougkType, pHijynbrsikinidougkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
