package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HijynbrsikinidouyouKbn;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 経理・会計 平準払資金移動項目Beanクラス
 */
public class HijynbrSikinIdoukmBean {

    @Getter
    @Setter
    private C_HijynbrsikinidouyouKbn hijynbrsikinidouyouKbn;

    @Getter
    @Setter
    private BizCurrency hijynbrsikinidougk;

    public HijynbrSikinIdoukmBean() {
        super();
    }

}
