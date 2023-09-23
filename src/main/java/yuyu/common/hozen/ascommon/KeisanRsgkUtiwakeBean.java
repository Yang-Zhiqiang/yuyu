package yuyu.common.hozen.ascommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 案内収納共通 領収金額計算結果内訳Bean
 */
public class KeisanRsgkUtiwakeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDateYM jyutoustartym;

    @Getter @Setter
    private Integer jyuutounensuu;

    @Getter @Setter
    private Integer jyuutoutukisuu;

    @Getter @Setter
    private BizCurrency rsgaku;

    @Getter @Setter
    private BizDate ryosyukwsratekjymd;

    @Getter @Setter
    private BizNumber ryosyukwsrate;

    @Getter @Setter
    private C_UmuKbn iktnyuukinnumu;

    @Getter @Setter
    private BizCurrency iktwaribikikgk;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
