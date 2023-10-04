package yuyu.batch.hozen.khansyuu.khuriageseikyuusel;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納 案内内容集約Beanクラス<br />
 */
public class AnnaiNaiyouMergeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDateYM jyutouym;

    @Getter @Setter
    private BizDate ryosyukwsratekjymd;

    @Getter @Setter
    private BizNumber ryosyukwsrate;

    @Getter @Setter
    private BizCurrency annaigk;

    @Getter @Setter
    private BizCurrency iktwaribikikgk;

    @Getter @Setter
    private int jyutoukaisuum;

    @Getter @Setter
    private int jyutoukaisuuy;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
