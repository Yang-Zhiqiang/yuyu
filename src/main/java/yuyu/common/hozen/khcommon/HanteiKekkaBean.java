package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 判定結果Beanクラス
 */
public class HanteiKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_UmuKbn updateKbn;

    @Getter @Setter
    private C_UmuKbn kzkKbn;

    @Getter @Setter
    private C_UmuKbn hhkdrKbn;

    @Getter @Setter
    private C_UmuKbn saiKbn;

    @Getter @Setter
    private C_UmuKbn sinFstCreditKbn;

    @Getter @Setter
    private C_UmuKbn sinKeiroKbn;

    @Getter @Setter
    private C_UmuKbn saiCreditKbn;

    @Getter @Setter
    private C_UmuKbn skhTirasiDouhuuuUmuKbn;

    @Getter @Setter
    private C_UmuKbn allUpdKbn;

    @Getter @Setter
    private List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList;

    @Getter @Setter
    private C_UmuKbn sinBoreroKbn;

    @Getter @Setter
    private C_UmuKbn saiBoreroKbn;

    public HanteiKekkaBean() {
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
