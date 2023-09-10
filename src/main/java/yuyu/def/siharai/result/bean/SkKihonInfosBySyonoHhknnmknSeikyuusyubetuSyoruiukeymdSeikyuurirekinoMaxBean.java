
package yuyu.def.siharai.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 請求基本情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    public SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean() {
    }

    @Getter @Setter
    private JT_SkKihon skKihon;

    @Getter @Setter
    private JT_Sk sk;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
