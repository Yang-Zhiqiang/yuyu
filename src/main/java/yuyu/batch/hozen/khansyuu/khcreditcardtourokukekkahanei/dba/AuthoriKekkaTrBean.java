package yuyu.batch.hozen.khansyuu.khcreditcardtourokukekkahanei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_CardBrandKbn;

/**
 * オーソリ結果ＴＲ（クレカ非保持）Beanクラス<br />
 */
@AllArgsConstructor
public class AuthoriKekkaTrBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String creditkessaiyouno;

    @Getter @Setter
    private BizDate syoriymd;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_CardBrandKbn cardbrandkbn;

    @Getter @Setter
    private String creditkaiinnosimo4keta;

    @Getter @Setter
    private C_AuthorijkKbn authorijkkbn;

    @Getter @Setter
    private String datajyusinymd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}