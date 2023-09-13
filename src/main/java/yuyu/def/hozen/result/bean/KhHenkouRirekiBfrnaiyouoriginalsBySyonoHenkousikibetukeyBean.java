package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 変更前後初期死亡時円換算最低保証額Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String bfrnaiyouoriginal;

    @Getter @Setter
    private String newnaiyouoriginal;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
