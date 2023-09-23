package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_KakuninjyoutaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;

/**
 * 契約保全 契約保全共通 帳票本番確認Beanクラス<br />
 */
@AllArgsConstructor
public class TyohyouHonbanKakuninBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public TyohyouHonbanKakuninBean() {
    }

    @Getter @Setter
    private C_TyouhyouBunruiKbn tyouhyoubunrui;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private String jyoukenbunrui1;

    @Getter @Setter
    private String jyoukenbunrui2;

    @Getter @Setter
    private String jyoukenbunrui3;

    @Getter @Setter
    private C_KakuninjyoutaiKbn kakuninjyoutaikbn;

    @Override
    public boolean equals(Object pObj) {

        if (pObj == null) {
            return false;
        }

        if (!(pObj instanceof TyohyouHonbanKakuninBean)) {
            return false;
        }

        if (this == pObj) {
            return true;
        }

        TyohyouHonbanKakuninBean otherBean = (TyohyouHonbanKakuninBean)pObj;

        if (tyouhyoubunrui == null && otherBean.tyouhyoubunrui != null ||
            tyouhyoubunrui != null && otherBean.tyouhyoubunrui == null) {
            return false;
        }
        if (syoruiCd == null && otherBean.syoruiCd != null ||
            syoruiCd != null && otherBean.syoruiCd == null) {
            return false;
        }
        if (jyoukenbunrui1 == null && otherBean.jyoukenbunrui1 != null ||
            jyoukenbunrui1 != null && otherBean.jyoukenbunrui1 == null) {
            return false;
        }
        if (jyoukenbunrui2 == null && otherBean.jyoukenbunrui2 != null ||
            jyoukenbunrui2 != null && otherBean.jyoukenbunrui2 == null) {
            return false;
        }
        if (jyoukenbunrui3 == null && otherBean.jyoukenbunrui3 != null ||
            jyoukenbunrui3 != null && otherBean.jyoukenbunrui3 == null) {
            return false;
        }
        if (kakuninjyoutaikbn == null && otherBean.kakuninjyoutaikbn != null ||
            kakuninjyoutaikbn != null && otherBean.kakuninjyoutaikbn == null) {
            return false;
        }

        if (tyouhyoubunrui.eq(otherBean.tyouhyoubunrui) &&
            syoruiCd.eq(otherBean.syoruiCd) &&
            jyoukenbunrui1.equals(otherBean.jyoukenbunrui1) &&
            jyoukenbunrui2.equals(otherBean.jyoukenbunrui2) &&
            jyoukenbunrui3.equals(otherBean.jyoukenbunrui3) &&
            kakuninjyoutaikbn.eq(otherBean.kakuninjyoutaikbn)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        final int addPrime = 31;
        int result = addPrime;

        result += (tyouhyoubunrui == null) ? 0 : tyouhyoubunrui.hashCode();
        result *= addPrime;
        result += (syoruiCd == null) ? 0 : syoruiCd.hashCode();
        result *= addPrime;
        result += (jyoukenbunrui1 == null) ? 0 : jyoukenbunrui1.hashCode();
        result *= addPrime;
        result += (jyoukenbunrui2 == null) ? 0 : jyoukenbunrui2.hashCode();
        result *= addPrime;
        result += (jyoukenbunrui3 == null) ? 0 : jyoukenbunrui3.hashCode();
        result *= addPrime;
        result += (kakuninjyoutaikbn == null) ? 0 : kakuninjyoutaikbn.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}