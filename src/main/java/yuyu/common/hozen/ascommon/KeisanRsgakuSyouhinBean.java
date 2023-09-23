package yuyu.common.hozen.ascommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納共通 領収金額計算用商品情報Bean
 */
public class KeisanRsgakuSyouhinBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter @Setter
    private String ryouritusdno;

    @Getter @Setter
    private BizNumber yoteiRiritu;

    @Getter @Setter
    private BizCurrency hokenryou;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }


}
