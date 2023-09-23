
package yuyu.common.hozen.khcommon.dba4keisankoujyogaku;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 主契約商品履歴情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SyuKykSyouhnRirekisBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
