package yuyu.batch.biz.bzinterf.bzsikinidoulistcsvfsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_SikinidoulistKbn;
import yuyu.def.classification.C_Tuukasyu;
import lombok.Getter;
import lombok.Setter;

/**
 * 資金移動明細額データBeanクラスです
 */
public class SikinIdouMeisaigkDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_SikinidoulistKbn sikinidoulistkbn;

    @Getter @Setter
    private C_Tuukasyu syukkinkouzatuukasyu;

    @Getter @Setter
    private String syukkinkouzano;

    @Getter @Setter
    private C_Tuukasyu nyuukinkouzatuukasyu;

    @Getter @Setter
    private String nyuukinkouzano;

    @Getter @Setter
    private BizCurrency sikinidoumeisaigk;

    public SikinIdouMeisaigkDataBean(C_SikinidoulistKbn pSikinidoulistkbn,
        C_Tuukasyu pSyukkinkouzatuukasyu,
        String pSyukkinkouzano,
        C_Tuukasyu pNyuukinkouzatuukasyu,
        String pNyuukinkouzano,
        String pSikinidoumeisaigkType,
        BigDecimal pSikinidoumeisaigkValue) {

        sikinidoulistkbn = pSikinidoulistkbn;
        syukkinkouzatuukasyu = pSyukkinkouzatuukasyu;
        syukkinkouzano = pSyukkinkouzano;
        nyuukinkouzatuukasyu = pNyuukinkouzatuukasyu;
        nyuukinkouzano = pNyuukinkouzano;
        sikinidoumeisaigk = new BizCurrencySum(pSikinidoumeisaigkType, pSikinidoumeisaigkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
