package yuyu.common.biz.kaikei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 配当金資金移動データBeanクラス
 */
public class HtkinSikinIdouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDate kijyunymd;

    @Getter
    @Setter
    private String kakutyoujobcd;

    @Getter
    @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter
    @Setter
    private String gonenmeoutoubikbn;

    @Getter
    @Setter
    private BizCurrency yuukoutyuusyoyougaku;

    @Getter
    @Setter
    private C_Segcd seg1cd;

    @Getter
    @Setter
    private BizNumber kawaserate;

    public HtkinSikinIdouDataBean() {
        super();
    }
}
