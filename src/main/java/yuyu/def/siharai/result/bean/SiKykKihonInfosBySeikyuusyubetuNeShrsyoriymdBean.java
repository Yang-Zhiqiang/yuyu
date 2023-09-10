
package yuyu.def.siharai.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 請求基本情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private JT_SkKihon jT_SkKihon;


    @Getter @Setter
    private JT_SiRireki jT_SiRireki;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
