package yuyu.def.siharai.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.db.entity.JT_SiDetail;

/**
 * 支払明細情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SiDetailInfosBySknoSyonoSeikyuurirekinoBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private JT_SiDetail jT_SiDetail;

    @Getter @Setter
    private String kyuuhucd;

    @Getter @Setter
    private C_HokenkinsyuruiKbn hokenkinsyuruikbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
