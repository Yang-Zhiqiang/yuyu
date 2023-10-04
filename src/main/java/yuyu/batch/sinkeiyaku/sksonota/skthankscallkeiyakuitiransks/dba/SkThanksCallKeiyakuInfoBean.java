package yuyu.batch.sinkeiyaku.sksonota.skthankscallkeiyakuitiransks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_KykKbn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 新契約 その他 サンクスコール対象契約情報Beanクラス
 */
@AllArgsConstructor
public class SkThanksCallKeiyakuInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String mosno;

    @Getter @Setter
    private C_KykKbn kykkbn;

    @Getter @Setter
    private Integer kyknen;

    @Getter @Setter
    private Integer hhknnen;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
