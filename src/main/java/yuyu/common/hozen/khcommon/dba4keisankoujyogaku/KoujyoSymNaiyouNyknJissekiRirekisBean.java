
package yuyu.common.hozen.khcommon.dba4keisankoujyogaku;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosyoumeipKbn;

/**
 * 控除証明内容View情報Beanクラスです。<br />
 */
public class KoujyoSymNaiyouNyknJissekiRirekisBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer renno3keta;

    @Getter @Setter
    private C_KoujyosyoumeipKbn koujyosyoumeipkbn;

    @Getter @Setter
    private BizCurrency koujyosyoumeigk;

    @Getter @Setter
    private BizDateYM syoumeistartym;

    @Getter @Setter
    private BizDateYM syoumeiendym;

    @Getter @Setter
    private C_DispKbn keisanhukahyoujikbn;

    @Getter @Setter
    private String keisanhukariyuucd;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
