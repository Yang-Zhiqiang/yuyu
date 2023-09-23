package yuyu.common.hozen.ascommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 案内収納共通 領収金額計算用Bean
 */
public class KeisanRsgakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter @Setter
    private BizDate rsymd;

    @Getter @Setter
    private BizDateYM jyutoustartym;

    @Getter @Setter
    private Integer jyuutounensuu;

    @Getter @Setter
    private Integer jyuutoutukisuu;

    @Getter @Setter
    private C_Tuukasyu rstuukasyu;

    @Getter @Setter
    private List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
