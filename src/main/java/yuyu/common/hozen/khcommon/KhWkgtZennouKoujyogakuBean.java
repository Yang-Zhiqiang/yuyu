package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_KoujyosyoumeipKbn;

/**
 * 契約保全 契約保全共通 控除枠毎控除証明情報Beanクラス
 */
public class KhWkgtZennouKoujyogakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_KoujyosyoumeipKbn koujyosyoumeipKbn;

    @Getter @Setter
    private BizCurrency khWkgtZennouKoujyogaku;

    public KhWkgtZennouKoujyogakuBean() {
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
