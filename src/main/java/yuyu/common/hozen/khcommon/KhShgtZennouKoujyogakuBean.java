package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;

/**
 * 契約保全 契約保全共通 商品毎控除証明情報Beanクラス
 */
public class KhShgtZennouKoujyogakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private String syouhnsdno;

    @Getter @Setter
    private C_SyutkKbn syutkkbn;

    @Getter @Setter
    private  C_KoujyosyoumeipKbn koujyosyoumeipkbn;

    @Getter @Setter
    private BizCurrency khShgtZennouKoujyogaku;

    public KhShgtZennouKoujyogakuBean() {
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
