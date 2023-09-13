package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_HokenSyouken;

/**
 * 再発行証券情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_HokenSyouken iT_HokenSyouken;

    @Getter @Setter
    private Integer keikanensuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
