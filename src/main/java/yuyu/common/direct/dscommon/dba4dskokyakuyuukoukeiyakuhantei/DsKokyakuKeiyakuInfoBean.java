package yuyu.common.direct.dscommon.dba4dskokyakuyuukoukeiyakuhantei;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ＤＳ顧客契約情報を保持するBeanクラスです。<br />
 */
@AllArgsConstructor
public class DsKokyakuKeiyakuInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}