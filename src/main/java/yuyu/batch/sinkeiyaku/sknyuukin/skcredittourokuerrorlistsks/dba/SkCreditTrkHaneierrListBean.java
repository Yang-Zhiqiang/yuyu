package yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokuerrorlistsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_CreditTrkhouKbn;

/**
 * クレジットカード登録反映エラーリスト情報Beanを保持するBeanクラス<br />
 */
@AllArgsConstructor
public class SkCreditTrkHaneierrListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private BizDate tyouhyouymd;

    @Getter
    @Setter
    private Integer datarenno;

    @Getter
    @Setter
    private String mosno;

    @Getter
    @Setter
    private C_CreditTrkhouKbn credittrkhoukbn;

    @Getter
    @Setter
    private String sosikicd;

    @Getter
    @Setter
    private String creditkessaiyouno;

    @Getter
    @Setter
    private String credittrkhaneierrriyuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
