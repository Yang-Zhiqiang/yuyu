
package yuyu.def.siharai.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiHubiDetail;

/**
 * 不備情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SiHubisSiHubiDetailsBySyonoBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;


    @Getter @Setter
    private JT_SiHubi jT_SiHubi;

    @Getter @Setter
    private JT_SiHubiDetail jT_SiHubiDetail;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
