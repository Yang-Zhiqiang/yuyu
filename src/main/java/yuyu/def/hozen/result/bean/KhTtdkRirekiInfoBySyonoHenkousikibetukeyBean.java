package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhTtdkRireki;

/**
 * 契約保全手続履歴情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KhTtdkRireki iT_KhTtdkRireki;

    @Getter @Setter
    private AS_Kinou aS_Kinou;

    @Getter @Setter
    private AM_User aM_User;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
