package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 初期死亡時円換算最低保証額変更前後Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private String bfrnaiyouoriginal;

    @Getter @Setter
    private String newnaiyouoriginal;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
