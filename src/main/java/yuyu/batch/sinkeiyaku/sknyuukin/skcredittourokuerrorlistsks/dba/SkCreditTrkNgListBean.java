package yuyu.batch.sinkeiyaku.sknyuukin.skcredittourokuerrorlistsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Dbhanei;

/**
 * クレジットカード会員登録ＮＧ情報Beanを保持するBeanクラス<br />
 */
@AllArgsConstructor
public class SkCreditTrkNgListBean implements Serializable{

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
    private String creditkessaiyouno;

    @Getter
    @Setter
    private String creditqrerrorcd;

    @Getter
    @Setter
    private String bluegateerrorcd;

    @Getter
    @Setter
    private C_Dbhanei dbhaneikbn;

    @Getter
    @Setter
    private String credittrkhaneierrriyuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
