package yuyu.batch.sinkeiyaku.sknyuukin.skhurikominyuukinlistsakusei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 前日繰越金額付Beanクラス<br />
 */
public class ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long yokukurikosikensuu;

    @Getter @Setter
    private BizCurrency yokukurikosigk;

    public ZenzitukKgBySyoriYmdKessanKbnRstuukasyuNyktyhyoutListBean(
        Long pYokukurikosikensuu,
        String pYokukurikosigkType,
        BigDecimal pYokukurikosigkValue) {

        yokukurikosikensuu = pYokukurikosikensuu;
        yokukurikosigk = new BizCurrencySum(pYokukurikosigkType, pYokukurikosigkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
