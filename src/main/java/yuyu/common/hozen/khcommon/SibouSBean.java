package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全共通 死亡ＳBeanクラス
 */
public class SibouSBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate calcKijyunYmd;

    @Getter @Setter
    private BizCurrency sibouS = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizCurrency zennouZndk = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizCurrency sibouUktrgk = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizCurrency sibouUktrgkYendaka = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizCurrency sibouUktrgkYen = BizCurrency.valueOf(0);

    @Getter @Setter
    private BizCurrency sibouUktrgkYenyasu = BizCurrency.valueOf(0);

    public SibouSBean() {
        super();
    }
}
