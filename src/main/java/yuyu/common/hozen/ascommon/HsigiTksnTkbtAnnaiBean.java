package yuyu.common.hozen.ascommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納共通 被災害特伸特別案内Beanクラス
 */
public class HsigiTksnTkbtAnnaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Integer jyuutoutukisuu;

    @Getter @Setter
    private Integer jyuutounensuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
