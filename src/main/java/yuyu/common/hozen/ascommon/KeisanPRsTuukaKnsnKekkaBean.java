package yuyu.common.hozen.ascommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 案内収納共通 保険料領収通貨換算結果Bean
 */
public class KeisanPRsTuukaKnsnKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency rstuukaknsngop;

    @Getter @Setter
    private BizDate rstuukaknsnkwsratekjnymd;

    @Getter @Setter
    private BizNumber rstuukaknsnkwsrate;

    @Getter @Setter
    private C_Tuukasyu rstuukaknsngotuukasyu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
