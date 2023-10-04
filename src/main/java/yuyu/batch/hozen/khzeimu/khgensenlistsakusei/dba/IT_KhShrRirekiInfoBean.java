package yuyu.batch.hozen.khzeimu.khgensenlistsakusei.dba;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_KhShrRireki;

/**
 * 契約保全 税務 契約保全支払履歴情報Beanクラス
 */
@AllArgsConstructor
public class IT_KhShrRirekiInfoBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KhShrRireki khShrRireki;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
